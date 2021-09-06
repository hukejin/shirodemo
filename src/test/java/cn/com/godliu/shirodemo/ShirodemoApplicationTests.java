package cn.com.godliu.shirodemo;

import cn.com.godliu.shirodemo.utils.EncryptionUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class ShirodemoApplicationTests {

    @Test
    void contextLoads() {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        System.out.println(sb.toString());


        System.out.println("@@@@"+EncryptionUtil.encryptionString("123456","RBs4Dx"));
    }

}
