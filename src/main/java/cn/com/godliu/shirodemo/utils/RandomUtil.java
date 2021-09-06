package cn.com.godliu.shirodemo.utils;

import java.util.Random;

public class RandomUtil {

    /**
     * 生成随机长度的字符串
     * @param length 字符串长度
     * @return
     */
    public static String randomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
