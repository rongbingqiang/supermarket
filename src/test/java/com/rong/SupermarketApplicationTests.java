package com.rong;

import com.rong.config.WxPayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.security.PrivateKey;
import java.sql.SQLException;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private WxPayConfig wxPayConfig;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetPrivateKey(){
        String privateKeyPath = wxPayConfig.getPrivateKeyPath();
       // PrivateKey privateKey = wxPayConfig.getPrivateKey(privateKeyPath);
       // System.out.println(privateKey);
    }

    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
