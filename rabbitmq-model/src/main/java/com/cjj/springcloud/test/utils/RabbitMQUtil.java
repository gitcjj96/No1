package com.cjj.springcloud.test.utils;

import cn.hutool.core.util.NetUtil;

import javax.swing.*;

/**
 * @Author: cjj
 * @Date: 2019/9/19 0019 上午 10:17
 * @Description：
 */
public class RabbitMQUtil {
    public static void main(String[] args) {
        checkServer();
    }
    public static void checkServer() {
        if(NetUtil.isUsableLocalPort(15672)) {
            JOptionPane.showMessageDialog(null, "RabbitMQ 服务器未启动 ");
            System.exit(1);
        }
    }

}
