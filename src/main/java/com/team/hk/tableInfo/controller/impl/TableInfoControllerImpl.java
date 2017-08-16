package com.team.hk.tableInfo.controller.impl;

import com.team.hk.common.ConstantUtil;
import com.team.hk.common.MessageInfo;
import com.team.hk.tableInfo.controller.TableInfoController;
import com.team.hk.tableInfo.entity.QRCode;
import com.team.hk.tableInfo.entity.TableInfo;
import com.team.hk.tableInfo.service.TableInfoService;
import com.team.hk.util.Base64ToImg;
import com.team.hk.util.FileUtil;
import com.team.hk.util.ZipCompressor;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/9.
 * 桌子信息实现类
 */
@Controller
@RequestMapping("/api/table")
public class TableInfoControllerImpl implements TableInfoController {

    private static Logger logger = Logger.getLogger(TableInfoControllerImpl.class);

    @Autowired
    private TableInfoService tableInfoService;

    /**
     * 获得桌子信息（通过分页）
     *
     * @param tableInfo 桌子entity
     * @param pageNo    页数
     * @param pageSize  数量
     * @return List<MenuInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<TableInfo> getAllTableInfoByPage(@RequestBody TableInfo tableInfo, @PathVariable("pageNo") Long pageNo,
                                                 @PathVariable("pageSize") Long pageSize) {

        logger.debug("====>桌子信息: " + tableInfo.toString());
        List list = new ArrayList();
        Long pn = (pageNo - 1) * pageSize;
        Long ps = pageSize;
        List<TableInfo> tableInfos = tableInfoService.getAllTableInfoByPageService(tableInfo, pn, ps);
        int count = tableInfoService.getAllTableInfoCountByPageService(tableInfo, pageNo, pageSize);
        list.add(tableInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得桌子信息
     *
     * @param tableInfo 桌子entity
     * @return List<TableInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<TableInfo> getAllTableInfo(@RequestBody TableInfo tableInfo) {

        logger.debug("====>桌子信息: " + tableInfo.toString());
        return tableInfoService.getAllTableInfoService(tableInfo);
    }

    /**
     * 增加桌子信息
     *
     * @param tableInfo 门店entity
     * @return List<TableInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<TableInfo> addTableInfo(@RequestBody TableInfo tableInfo) {

        logger.debug("====>添加桌子信息: " + tableInfo.toString());
        return tableInfoService.addTableInfoService(tableInfo);
    }

    /**
     * 修改桌子信息
     *
     * @param tableInfo 门店entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateTableInfo(@RequestBody TableInfo tableInfo) {

        logger.debug("====>修改桌子信息: " + tableInfo.toString());
        return tableInfoService.updateTableInfoService(tableInfo);
    }

    /**
     * 删除一个桌子
     *
     * @param tableId 桌子ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{tableId}", method = RequestMethod.DELETE)
    @Override
    public int deleteTableInfoById(@PathVariable("tableId") Long tableId) {

        logger.debug("====>删除桌子: " + tableId);
        return tableInfoService.deleteTableInfoByIdService(tableId);
    }

    /**
     * 删除多个桌子
     *
     * @param tableId 桌子ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteTableInfoByIds(@RequestParam("tableId") List<Long> tableId) {

        logger.debug("====>删除桌子: " + tableId);
        return tableInfoService.deleteTableInfoByIdsService(tableId);
    }

    /**
     * 获得桌子二维码图片
     * 1.生成二维码图片
     * 2.下载二维码.zip包
     *
     * @param qrCode   二维码信息
     * @param storeId  门店ID
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/{storeId}/getQRCodeZip", method = RequestMethod.POST)
    public MessageInfo getQRCodeZip(@RequestBody List<QRCode> qrCode,
                                    @PathVariable("storeId") String storeId,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {

        logger.debug("桌子二维码图片信息: " + qrCode.toString());
        MessageInfo messageInfo = new MessageInfo();
        boolean flag = false;
        /* 生成二维码图片 */
        for (QRCode aQrCode : qrCode) {
            String base64Img = aQrCode.getBase64Img();
            String tableName = aQrCode.getTableName();
            flag = Base64ToImg.generateImage(storeId, base64Img, tableName);
        }
        if (flag) {
            /* .zip文件目录 */
            String zipPath = ConstantUtil.ROOT_QRC_PATH + storeId + ConstantUtil.ZIP_NAME;
            /* 二维码图片路径 */
            String path = ConstantUtil.ROOT_QRC_PATH + storeId;
            List<String> fileName = FileUtil.getFileName(path);
            /* 生成二维码图片压缩包 */
            ZipCompressor zipCompressor = new ZipCompressor(zipPath);
            zipCompressor.preCompress(path, fileName);
            messageInfo.setCode(200);
            messageInfo.setMsg("二维码图片压缩成功!");
            logger.debug("二维码图片压缩成功!" + zipPath);
            return messageInfo;
        }
        messageInfo.setCode(500);
        messageInfo.setMsg("二维码图片压缩失败!");
        return messageInfo;
    }

    /**
     * 二维码压缩包下载
     *
     * @param storeId 门店ID
     * @return 二维码压缩包
     */
//    @RequestMapping(value = "/{storeId}/getQRCodeZip", method = RequestMethod.POST)
    public ResponseEntity<byte[]> download(@PathVariable("storeId") String storeId) {
        logger.debug("二维码压缩包开始下载!");
        try {
            String fileName = "QRCodeImg.zip";
            String file = ConstantUtil.ROOT_QRC_PATH + storeId + ConstantUtil.ZIP_NAME;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(file)), headers, HttpStatus.OK);
        } catch (IOException e) {
            logger.debug("二维码压缩包下载失败!");
            e.printStackTrace();
        } finally {
            logger.debug("二维码压缩包下载成功!");
        }
        return ResponseEntity.notFound().build();
    }

    /*
    @RequestMapping(value = "/{storeId}/getQRCodeZip", method = RequestMethod.POST)
    public void testDownload(@PathVariable("storeId") String storeId, HttpServletResponse res) {
        String fileName = "QRCodeImg.zip";
        String file = ConstantUtil.ROOT_QRC_PATH + storeId + ConstantUtil.ZIP_NAME;
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(file)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
    */
}
