package com.team.hk.util.zip;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by lidongliang on 2017/8/16.
 * base64转换图片
 */
public class Base64ToImg {

    /**
     * @param img       base64图片
     * @param tableName 图片名字
     * @return 图片
     */
    public static boolean generateImage(String img, String tableName) {

        String path = "E:\\tableImg\\" + tableName + ".jpg";

        if (img == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(img);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
