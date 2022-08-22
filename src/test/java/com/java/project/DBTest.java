package com.java.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DBTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void test() throws Exception {
        assertNotNull(dataSource.getConnection());
    }

}
