package com.mahmoudH;

import com.mahmoudH.Thread.*;
import com.mahmoudH.configreations.Configuration;
import com.mahmoudH.configreations.ConfigurationManager;


public class Main {
    public static void main(String[] args){
        Configuration configuration = ConfigurationManager.getConfigration();
        System.out.println(configuration.getPort()+"  "+ configuration.getWebroot());
        new ConnectionListnerThread(configuration).start();
    }
}
