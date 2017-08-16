package com.team.hk.util;

import com.team.hk.common.ConstantUtil;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by lidongliang on 2017/8/16.
 * base64转换图片
 */
public class Base64ToImg {

    private static Logger logger = Logger.getLogger(Base64ToImg.class);

    /**
     * @param storeId   门店ID
     * @param base64img base64图片
     * @param tableName 图片名字
     * @return 二维码图片
     */
    public static boolean generateImage(String storeId, String base64img, String tableName) {

        if (base64img == null) {
            logger.debug("没有二维码图片!");
            return false;
        }
        // 生成文件路径
        String path = ConstantUtil.ROOT_QRC_PATH + storeId + "/" + tableName + ".jpg";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            /* 生成文件夹和文件 */
            File file = new File(path);
            /* 文件是否有上级目录 */
            if (!file.getParentFile().exists()) {
                /* 生成文件夹 */
                file.getParentFile().mkdirs();
            }
            /* 生成文件 */
            file.createNewFile();

            // 解密
            byte[] b = decoder.decodeBuffer(base64img);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            /* base64生成图片 */
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            logger.debug("二维码图片成功: " + path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("二维码图片失败: " + path);
            return false;
        }
    }
}
