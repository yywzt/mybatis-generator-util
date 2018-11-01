package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/1 15:51
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class createTableText {

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.url}")
    private String url;

    @Test
    public void getTableNames(){
        Connection con = null;
        try {
            //加载驱动程序
            Class.forName(driverName);
            //1.getConnection()方法，连接MySQL数据库！！
            con  = DriverManager.getConnection(url,username,password);
            DatabaseMetaData meta = con.getMetaData();
            ResultSet rs = meta.getTables(null, null, null,
                    new String[] { "TABLE" });
            while (rs.next()) {
                System.out.println("<table schema=\"%\" tableName=\"" + rs.getString(3) + "\" enableCountByExample=\"false\" enableDeleteByExample=\"false\"\n" +
                        "               enableSelectByExample=\"false\" enableUpdateByExample=\"false\"/>");
            }
            con.close();
        } catch (Exception e) {
            try {
                con.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
