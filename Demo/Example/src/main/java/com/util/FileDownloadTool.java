package com.util;

import com.model.Algorithm;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexhu on 2017/7/24.
 */
public class FileDownloadTool {

    public String createDownloadFileListXLS(HttpServletRequest request, HttpServletResponse response, List<Algorithm> algorithmList) {
        String xlsFileFullPathInService = "";

        FileOutputStream fos = null;

        try {

            // 生成下载时间字符
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String currentDateStr = sdf.format(currentDate);

            String basePath = request.getServletContext().getRealPath("");		// 项目根目录

            String dirPath = basePath + "/download/";	// 存放文件的目录

            // 检查存放Excel文件的目录是否存在，不存在则创建目录
            File dirFile = new File(dirPath);
            if (!dirFile.isDirectory()) {
                dirFile.mkdirs();
            }

            // 创建上传后的文件
            String newFileName = currentDateStr + ".xls";	// 上传后保存的文件名
            xlsFileFullPathInService = dirPath + newFileName;	// 生成上传后的文件的全路径

            File rptExcelFile = new File(xlsFileFullPathInService);
            rptExcelFile.createNewFile();

            // 创建Excel工作薄
            HSSFWorkbook workBook = new HSSFWorkbook();

            // 通过ExcelStyle类创建个单元样式
            ExcelStyle styles = new ExcelStyle(workBook);
            HSSFCellStyle formatTitle = styles.getFormatTitle();	// 标题单元格样式
            HSSFCellStyle formatLeft = styles.getFormatLeft();		// 居左单元格样式

            // 创建首页工作表
            HSSFSheet firstSheet = workBook.createSheet("主信息");
            firstSheet.setColumnWidth(0, 256*50);
            firstSheet.setColumnWidth(1, 256*60);

            // 首页第0行
            HSSFRow firstSheetRow = firstSheet.createRow(0);
            HSSFCell titleCell = firstSheetRow.createCell(0);
            titleCell.setCellStyle(formatTitle);
            titleCell.setCellValue(new String("IP".getBytes("UTF-8"), "UTF-8"));
            HSSFCell contectCell = firstSheetRow.createCell(1);
            contectCell.setCellStyle(formatLeft);
            contectCell.setCellValue(new String("".getBytes("UTF-8"), "UTF-8"));

            // 首页第1行
            firstSheetRow = firstSheet.createRow(1);
            titleCell = firstSheetRow.createCell(0);
            titleCell.setCellStyle(formatTitle);
            titleCell.setCellValue(new String("FOLDER1".getBytes("UTF-8"), "UTF-8"));
            contectCell = firstSheetRow.createCell(1);
            contectCell.setCellStyle(formatLeft);
            contectCell.setCellValue(new String("".getBytes("UTF-8"),"UTF-8"));

            // 首页第2行
            firstSheetRow = firstSheet.createRow(2);
            titleCell = firstSheetRow.createCell(0);
            titleCell.setCellStyle(formatTitle);
            titleCell.setCellValue(new String("FOLDER2".getBytes("UTF-8"), "UTF-8"));
            contectCell = firstSheetRow.createCell(1);
            contectCell.setCellStyle(formatLeft);
            contectCell.setCellValue(new String("bussiness".getBytes("UTF-8"), "UTF-8"));

            // 首页第3行
            firstSheetRow = firstSheet.createRow(3);
            titleCell = firstSheetRow.createCell(0);
            titleCell.setCellStyle(formatTitle);
            titleCell.setCellValue(new String("SUBJECT".getBytes("UTF-8"), "UTF-8"));
            contectCell = firstSheetRow.createCell(1);
            contectCell.setCellStyle(formatLeft);
            contectCell.setCellValue(new String("".getBytes("UTF-8"), "UTF-8"));

            // 首页第4行
            firstSheetRow = firstSheet.createRow(4);
            titleCell = firstSheetRow.createCell(0);
            titleCell.setCellStyle(formatTitle);
            titleCell.setCellValue(new String("TOTAL".getBytes("UTF-8"), "UTF-8"));
            contectCell = firstSheetRow.createCell(1);
            contectCell.setCellStyle(formatLeft);
            contectCell.setCellValue(new String("".getBytes("UTF-8"), "UTF-8"));

            String currentAlgorithm = "";
            HSSFSheet sheet = null;

            for (int rptIndex = 0, rowIndex = 1; rptIndex < algorithmList.size(); rptIndex++) {
                Algorithm algorithm = algorithmList.get(rptIndex);

                if (!currentAlgorithm.equals(algorithm.getAlg())) {
                    sheet = workBook.createSheet(algorithm.getAlg());
                    sheet.createFreezePane(0, 1, 0, 1);		// 设置冻结首行

                    HSSFRow titleRow = sheet.createRow(0);
                    titleCell = titleRow.createCell(0);
                    titleCell.setCellStyle(formatTitle);
                    titleCell.setCellValue(new String("算法名称".getBytes("UTF-8"), "UTF-8"));
                    sheet.setColumnWidth(1, 256*25);

                    titleCell = titleRow.createCell(1);
                    titleCell.setCellStyle(formatTitle);
                    titleCell.setCellValue(new String("加密结果".getBytes("UTF-8"), "UTF-8"));
                    sheet.setColumnWidth(1, 256*25);

                    rowIndex = 1;
                    currentAlgorithm = algorithm.getAlg();
                }
                else {
                    rowIndex++;
                }

                HSSFRow contentRow = sheet.createRow(rowIndex);

                HSSFCell contentCell = contentRow.createCell(0);
                contentCell.setCellStyle(formatLeft);
                contentCell.setCellValue(new String(algorithm.getAlg().getBytes("UTF-8"), "UTF-8"));

                contentCell = contentRow.createCell(1);
                contentCell.setCellStyle(formatLeft);
                contentCell.setCellValue(new String(algorithm.getRult().getBytes("UTF-8"), "UTF-8"));
            }

            fos = new FileOutputStream(xlsFileFullPathInService);
            workBook.write(fos);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (null != fos) {
                    fos.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

        return xlsFileFullPathInService;
    }

}
