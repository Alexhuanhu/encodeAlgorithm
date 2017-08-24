package com.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Created by Alexhu on 2017/7/21.
 */
public class ExcelStyle {
    private HSSFCellStyle formatTitle;  // 标题
    private HSSFCellStyle formatLeft;    // 居左
    private HSSFCellStyle formatRight;  // 居右

    public ExcelStyle(HSSFWorkbook workBook) {

        // 设置字体(常规)
        HSSFFont font = workBook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)12);
        font.setColor(HSSFColor.BLACK.index);

        // 设置字体(居中)
        HSSFFont titleFont = workBook.createFont();
        titleFont.setFontName("Times New Roman");
        titleFont.setFontHeightInPoints((short)14);
        titleFont.setColor(HSSFColor.BLACK.index);
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // 创建标题单元格样式
        formatTitle = workBook.createCellStyle();
        formatTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);   // 左右居中
        formatTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);    // 上下居中
        formatTitle.setWrapText(true);  // 自动换行
        formatTitle.setFont(titleFont); // 设置字体为标题字体

        // 创建居左单元格样式
        formatLeft = workBook.createCellStyle();
        formatLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);  // 左右居左
        formatLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中
        formatLeft.setWrapText(true);   // 自动换行
        formatLeft.setFont(font);   // 设置字体为常规字体
    }

    public HSSFCellStyle getFormatTitle() {
        return formatTitle;
    }

    public void setFormatTitle(HSSFCellStyle formatTitle) {
        this.formatTitle = formatTitle;
    }

    public HSSFCellStyle getFormatLeft() {
        return formatLeft;
    }

    public void setFormatLeft(HSSFCellStyle formatLeft) {
        this.formatLeft = formatLeft;
    }

    public HSSFCellStyle getFormatRight() {
        return formatRight;
    }

    public void setFormatRight(HSSFCellStyle formatRight) {
        this.formatRight = formatRight;
    }
}
