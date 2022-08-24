package com.cbay.demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * 户籍详细地址里面获取省市县
 * @Author bixiufeng
 * @Date 2022/6/22 16:55
 */
public class Demo_Test1 {

    @Test
    public void BiXiuFeng01(){

        List<MortgageBase> mortgageBaseList = Arrays.asList(
                new MortgageBase("张三",19,10.0,"过故宫"),
                new MortgageBase("李四",23,20.0,"过天安门"),
                new MortgageBase("王五",32,30.0,"过虹桥"),
                new MortgageBase("马六",45,40.0,"过北海"),
                new MortgageBase("韩七",27,990.0,"过南天门"),
                new MortgageBase("毕九",66,2000.00,"过天奇"),
                new MortgageBase("毕九",16,9.00,"过小弟")
        );
        List<String> collect = mortgageBaseList.stream().map(MortgageBase::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public  void BiXiuFeng02(){
        Runnable r = ()-> System.out.println("JAVA8 Lamda 表达式");
            r.run();
    }

    @Test
    public  void BiXiuFeng03(){
        Consumer<String> consumer= (a)-> System.out.println(a);
        consumer.accept("你好啊笨蛋");
        consumer.accept("你好啊笨蛋");
        consumer.accept("你好啊笨蛋");
        consumer.accept("你好啊笨蛋");

    }

    @Test
    public  void BiXiuFeng04(){
        Comparator<String> comparator = (x,y)-> Integer.compare(x.length(),y.length());
        System.out.println(comparator.compare("222","3333"));

    }

    @Test
    public void test001(){
        happy(100,d -> System.out.println("我买了"+d+"朵花"));
    }

    public  void happy(Integer moenry,Consumer consumer){
        consumer.accept(moenry);
    }




}
