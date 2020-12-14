package com.webwork.recruitsystem.Config;

import com.webwork.recruitsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class TimePlan {

    @Autowired
    UserService userService;
    //每天的0点跑这个定时任务
    @Scheduled(cron = "0 0 0 * * ?")
    public void ChangeUserType(){
        System.out.println("检查用户level");
        userService.changeAllUserLevel();
    }
}
