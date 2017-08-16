package com.team.hk.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/8/13.
 * 文件操作类
 */
public class FileUtil {

    private static Logger logger = Logger.getLogger(FileUtil.class);

    /**
     * 删除文件夹及文件
     *
     * @param file 文件
     */
    public static void deleteFolder(File file) {

        /**
         * 1.生成File[]数组
         * 2.listFiles()方法获取当前目录里的文件夹和文件
         */

        File[] files = file.listFiles();
        /* 判断是否为空 */
        if (files != null) {
            for (File fileName : files) {
                /* 是文件就删除 */
                if (fileName.isFile()) {
                    fileName.delete();
                    logger.debug("删除文件成功: " + fileName);
                } else if (fileName.isDirectory()) {
                    /* 是文件夹就递归 */
                    deleteFolder(fileName);
                }
            }
            /* 空文件夹直接删除 */
            file.delete();
            logger.debug("删除目录成功: " + file);
        } else {
            /* 空文件夹直接删除 */
            file.delete();
            logger.debug("删除目录成功: " + file);
        }
    }

    /**
     * 获得文件
     *
     * @param path 文件路径
     * @return 文件集合
     */
    public static List<String> getFileName(String path) {
        List<String> list = new ArrayList<>();
        File fs = new File(path);
        if (!fs.exists()) {
            logger.debug("文件不存在!");
            return list;
        }

        File f[] = fs.listFiles();
        for (File i : f) {
            list.add(i.getName());
        }
        return list;
    }
}
