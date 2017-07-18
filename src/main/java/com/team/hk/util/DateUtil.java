package com.team.hk.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by lidongliang on 2017/7/10.
 * 日期转换
 */
public class DateUtil {
    /**
     * 用LocalDateTime获得当前时间
     */
    private static void getLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("localDateTime = " + format);
    }

    /**
     * java.util.date to java.time.date
     * 1.将java.util.Date转换为ZonedDateTime。
     * 2.使用它的toLocalDate（）方法从ZonedDateTime获取LocalDate。
     */
    public static void dateToLocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("Date = " + date);
        System.out.println("LocalDate = " + localDate);
    }

    /**
     * java.time.date to java.util.date
     * 1.使用ZonedDateTime将LocalDate转换为Instant。
     * 2.使用from（）方法从Instant对象获取Date的实例
     */
    public static void localDateToDate() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        System.out.println("LocalDate = " + localDate);
        System.out.println("Date = " + date);
    }

    /**
     * java.util.dateTime to java.time.localDateTime
     * 1.从日期获取ZonedDateTime并使用其方法toLocalDateTime（）获取LocalDateTime
     * 2.使用LocalDateTime的Instant（）工厂方法
     */
    public static void dateTimeToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + format);
    }

    /**
     * java.time.localDateTime to java.util.dateTime
     * 1.使用atZone（）方法将LocalDateTime转换为ZonedDateTime
     * 2.将ZonedDateTime转换为Instant，并从中获取Date
     */
    public static void localDateTimeTimeToDateTime() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + format);
    }

    public static void main(String[] args) {

        DateUtil dateUtil = new DateUtil();
        dateUtil.getLocalDateTime();
//        dateUtil.dateToLocalDate();
//        dateUtil.localDateToDate();
//        dateUtil.dateTimeToLocalDateTime();
//        dateUtil.localDateTimeTimeToDateTime();

    }
}
