package com.team.hk.util.qrCode;

/**
 * Created by lidongliang on 2017/8/15.
 */
public class QRMain {

    public static void main(String[] args) {
        QRCodeParams qrCodeParams = new QRCodeParams();
        try {
            QRCodeUtil.generateQRImage(qrCodeParams);
        } catch (QRParamsException e) {
            e.printStackTrace();
        }
    }
}
