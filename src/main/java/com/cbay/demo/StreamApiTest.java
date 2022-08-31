package com.cbay.demo;

import com.cbay.demo.User.Status;
import org.apache.tools.ant.taskdefs.GenerateKey;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamApiTest {
    
    List<User> userList = Arrays.asList(
            new User('b',"小毕秀峰","a",16,30000.99,Status.ASS),
            new User('2',"小袁盛楠","b",24,70000.99,Status.DUU),
            new User('3',"小韩平伟","c",34,90990.99,Status.SFF),
            new User('4',"小樊辰辰","d",9, 10000.91,Status.DUU),
            new User('5',"小王辉辉","e",72,400000.9,Status.ASS),
            new User('6',"小卜龙昌","f",37,88888.99,Status.SFF)
    );

    @Test
    public void test01(){

        List<User>   list = userList.stream().filter(u -> u.getAge() > 20).collect(Collectors.toList());
        List<User>   list2 = userList.stream().filter(u -> u.getAge() > 6).limit(2).collect(Collectors.toList());
        List<User>   list3 = userList.stream().distinct().limit(2).collect(Collectors.toList());
        List<String> list4 = userList.stream().map(User::getName).collect(Collectors.toList());

    }

}
