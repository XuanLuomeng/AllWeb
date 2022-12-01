package com.atguigu.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            File file = new File("E:\\图片");
            if (!file.exists()) {
                file.mkdirs();
            }
            factory.setRepository(file);
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("utf-8");
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            PrintWriter writer = resp.getWriter();
            for (FileItem filitem : fileItems) {
                if (filitem.isFormField()) {
                    String name = filitem.getFieldName();
                    if (name.equals("name")) {
                        if (!filitem.getString().equals("")) {
                            String value = filitem.getString("utf-8");
                            writer.print("上传者:" + value + "<br/>");
                        }
                    }
                } else {
                    String filename = filitem.getName();
                    if (filename != null && !filename.equals("")) {
                        writer.print("上传的文件名称是:" + filename + "<br/>");
                        filename = filename.substring(filename.lastIndexOf("\\") + 1);
                        filename = UUID.randomUUID().toString() + "_" + filename;
                        String webPath = "/upload/";
                        String filePath = getServletContext().getRealPath(webPath + filename);
                        File file1 = new File(filePath);
                        file1.getParentFile().mkdirs();
                        file1.createNewFile();
                        InputStream is = filitem.getInputStream();
                        FileOutputStream fos = new FileOutputStream(file1);
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = is.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                        is.close();
                        fos.close();
                        filitem.delete();
                        writer.print("上传文件成功！<br/>");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
