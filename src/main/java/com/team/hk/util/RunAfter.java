package com.team.hk.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by lidongliang on 2017/6/27.
 * spring boot run() 后执行
 */
@Component
public class RunAfter implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        LocalDate today = LocalDate.now();
//        System.out.println("Today's Local date : " + today);
    }
}
