package com.java.project.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> nullPointerExceptionHandle() {
        System.out.println("NullPointerException 발생");
        Map<String, Object> result = new HashMap<>();
        result.put("desc", "NullPointerException");
        result.put("status", 500);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> indexOutOfBoundsExceptionHandle() {
        System.out.println("IndexOutOfBoundsException 발생");
        Map<String, Object> result = new HashMap<>();
        result.put("desc", "IndexOutOfBoundsException");
        result.put("status", 500);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> numberFormatExceptionHandle() {
        System.out.println("NumberFormatException 발생");
        Map<String, Object> result = new HashMap<>();
        result.put("desc", "NumberFormatException");
        result.put("status", 500);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> classCastExceptionHandle() {
        System.out.println("ClassCastException 발생");
        Map<String, Object> result = new HashMap<>();
        result.put("desc", "ClassCastException");
        result.put("status", 500);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
