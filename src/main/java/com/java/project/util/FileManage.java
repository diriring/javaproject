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
        //파일을 HDD에서 삭제
        //저장된 파일명, 저장된 경로
        path = servletContext.getRealPath(path);
        File file = new File(path, fileName);

        return file.delete();
    }

    public String fileSave(MultipartFile mf, String path) throws Exception {

        path = servletContext.getRealPath(path);
        System.out.println(path);

        File file = new File(path);

        if(!file.exists()) {
            file.mkdirs(); //중간 폴더가 없으면 중간 폴더도 생성
        }

        Calendar calendar = Calendar.getInstance();
        String fileName = UUID.randomUUID().toString();
        fileName = fileName + "_" + calendar.getTimeInMillis() + ".jpg";
        file = new File(path, fileName);
        mf.transferTo(file);

        return fileName;
    }

}
