package com.ip2region;

import org.apache.commons.lang.StringUtils;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author a-cper-cpu
 * @date 2022-01-30-19:21
 */
public class ip2regionTest {
    public static void main(String[] args) {
        String addressByIp = getAddressByIp("172.27.24.161");
        System.out.println(addressByIp);
    }

    //获取ip所在地址
    public static String getAddressByIp(String ip) {
        try {
            //db
            URL url = ip2regionTest.class.getClassLoader().getResource("ip2region.db");
            String dbPath = url.getFile();
            File file = new File(url.getFile());
            if (file.exists() == false) {
                System.out.println("Error: Invalid ip2region.db file");
            }

            //查询算法
            int algorithm = DbSearcher.BTREE_ALGORITHM; //B-tree
            //int algorithm = DbSearcher.BINARY_ALGORITHM; //Binary
            //int algorithm = DbSearcher.MEMORY_ALGORITYM; //Memory
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);
            //define the method
            Method method = null;
            switch (algorithm) {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }
            DataBlock dataBlock = null;
            if (Util.isIpAddress(ip) == false) {
                System.out.println("Error: Invalid ip address");
            }
            dataBlock = (DataBlock) method.invoke(searcher, ip);
            //address格式：中国|0|广东省|深圳市|电信
            String address = dataBlock.getRegion();
            //下两行 防止截取报错 在本方法catch
            String[] splitIpString = address.split("\\|");
            String succ = splitIpString[4];
            return address;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    public static String getRealIp3(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }


}