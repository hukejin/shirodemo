package cn.com.godliu.shirodemo.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class EncryptionUtil {

    public static String encryptionString(String src,String salt){
        Md5Hash md5Hash = new Md5Hash(src,salt,2);
        return md5Hash.toBase64();
    }
}
