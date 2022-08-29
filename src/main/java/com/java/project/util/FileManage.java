package com.java.project.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileManage {

    private final ServletContext servletContext;

    public boolean remove(String path, String fileName) throws Exception {
        path = servletContext.getRealPath(path);
        File file = new File(path, fileName);

        return file.delete();
    }

    public String fileSave(MultipartFile mf, String path) throws Exception {
        path = servletContext.getRealPath(path);

        File file = new File(path);

        if(!file.exists()) {
            file.mkdirs();
        }

        Calendar calendar = Calendar.getInstance();
        String fileName = UUID.randomUUID().toString();
        fileName = fileName + "_" + calendar.getTimeInMillis() + ".jpg";
        file = new File(path, fileName);
        mf.transferTo(file);

        return fileName;
    }

}
