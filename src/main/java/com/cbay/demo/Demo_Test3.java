package com.cbay.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 *
 * @Author bixiufeng
 * @Date 2022/6/27 14:30
 */
public class Demo_Test3 {


    public static void main(String[] args) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }
}
