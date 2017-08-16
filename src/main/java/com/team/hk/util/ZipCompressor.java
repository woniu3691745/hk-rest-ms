package com.team.hk.util;

import com.team.hk.common.ConstantUtil;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by lidongliang on 2017/8/16.
 * 图片压缩成.zip
 */
public class ZipCompressor {

    private static Logger logger = Logger.getLogger(ZipCompressor.class);

    // 缓冲字节
    static final int BUFFER = 8192;

    // 文件类
    private File zipFile;

    public ZipCompressor(String pathName) {
        zipFile = new File(pathName);
    }

    /**
     * 压缩文件前置处理
     *
     * @param path     文件路径
     * @param fileList 文件名集合
     */
    public void preCompress(String path, List<String> fileList) {

        List<String> fileName = new ArrayList<>();
        fileList.stream().filter(x -> x.contains(".jpg")).forEach(x -> fileName.add(path + "/" + x));
        if (fileName.size() > 1) {
            this.compress(fileName);
        } else {
            this.compress(fileName.get(0));
        }
    }

    /**
     * 多个文件
     *
     * @param pathName 文件名字
     */
    public void compress(List<String> pathName) {
        ZipOutputStream out;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
                    new CRC32());
            out = new ZipOutputStream(cos);
            for (String aPathName : pathName) {
                compress(new File(aPathName), out, ConstantUtil.BASEDIR);
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 一个文件
     *
     * @param srcPathName 文件名字
     */
    public void compress(String srcPathName) {
        File file = new File(srcPathName);
        if (!file.exists())
            throw new RuntimeException(srcPathName + "不存在！");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
                    new CRC32());
            ZipOutputStream out = new ZipOutputStream(cos);
            compress(file, out, ConstantUtil.BASEDIR);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断是目录还是文件
     *
     * @param file    文件地址
     * @param out     输出
     * @param basedir 压缩包目录
     */
    private void compress(File file, ZipOutputStream out, String basedir) {
        if (file.isDirectory()) {
            System.out.println("压缩：" + basedir + file.getName());
            this.compressDirectory(file, out, basedir);
        } else {
            System.out.println("压缩：" + basedir + file.getName());
            this.compressFile(file, out, basedir);
        }
    }

    /**
     * 压缩一个目录
     *
     * @param dir     文件地址
     * @param out     输出
     * @param basedir 压缩包目录
     */
    private void compressDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        for (File file : files) {
            /* 递归 */
            compress(file, out, basedir + dir.getName() + "/");
        }
    }

    /**
     * 压缩一个.zip文件
     *
     * @param file    文件地址
     * @param out     输出
     * @param basedir 压缩包目录
     */
    private void compressFile(File file, ZipOutputStream out, String basedir) {
        if (!file.exists()) {
            return;
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            ZipEntry entry = new ZipEntry(basedir + file.getName());
            out.putNextEntry(entry);
            int count;
            byte data[] = new byte[BUFFER];
            while ((count = bis.read(data, 0, BUFFER)) != -1) {
                out.write(data, 0, count);
            }
            logger.debug("二维码压缩包生成成功: " + file);
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
