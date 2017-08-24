package com.util;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Alexhu on 2017/7/24.
 */
public class FileUtilsTool {
    private static final int BUFFER_SIZE = 1 *1024;
    private static final int ZIP_THEREHOLD = 5 * 1024 * 1024;

    // 文件下载
    public void downloadFiles(HttpServletResponse response, String fileFullPathInServer) {
        InputStream inputStream = null;

        try {
            File sourceFile = new File(fileFullPathInServer);
            long sourceFileLength = sourceFile.length();

            boolean canDownload = true;

            if (canDownload) {
                // 获取需下载的文件的文件名部分
                String[] spiltedPath = fileFullPathInServer.split("/");
                String downloadFileName = spiltedPath[spiltedPath.length - 1];

                // 下载文件
                inputStream = new FileInputStream(fileFullPathInServer);
                response.reset();
                response.setContentType("APPLICATION/OCTET-STREAM;charset=utf-8");
                response.setHeader("Content-Disposition", "attachement; filename=\""
                    + new String((downloadFileName).getBytes(), "ISO8859_1") + "\"");
                byte[] b = new byte[BUFFER_SIZE];
                int len;
                while ((len = inputStream.read(b, 0, BUFFER_SIZE)) != -1) {
                    response.getOutputStream().write(b, 0, len);
                }

                response.getOutputStream().flush();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != response.getOutputStream()) {
                    response.getOutputStream().close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
