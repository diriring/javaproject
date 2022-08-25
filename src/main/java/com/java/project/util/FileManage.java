package com.java.project.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
@RequiredArgsConstructor
public class FileManage {

    private final ServletContext servletContext;

}
