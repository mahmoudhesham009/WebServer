package com.mahmoudH;

import com.mahmoudH.configreations.Configration;
import com.mahmoudH.configreations.ConfigrationManager;


public class Main {
    public static void main(String[] args){
        Configration configration=ConfigrationManager.getConfigration();
        System.out.println(configration.getPort()+"  "+configration.getWebroot());
        new ConnectionListnerThread(configration).start();
    }
}
