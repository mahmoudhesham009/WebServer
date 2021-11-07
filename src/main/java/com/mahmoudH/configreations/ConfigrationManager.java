package com.mahmoudH.configreations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mahmoudH.Exception.HTTPConfigrationException;
import com.mahmoudH.Exception.NullConfiguratioException;
import com.mahmoudH.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigrationManager {
    private static Configration myConfigrations;

    public static Configration getConfigration(){
        StringBuffer stringBuffer=new StringBuffer();
        FileReader fileReader= null;

        try {
            fileReader = new FileReader("src/main/resources/configration.json");
        } catch (FileNotFoundException e) {
            throw new HTTPConfigrationException(e);
        }


        try{
            int i=fileReader.read();
            while(i!=-1){
                stringBuffer.append((char)i);
                i=fileReader.read();
            }
        } catch (IOException e) {
            throw new HTTPConfigrationException(e);
        }


        try {
            myConfigrations= Json.parse(stringBuffer.toString(),Configration.class);
        } catch (JsonProcessingException e) {
            throw new HTTPConfigrationException("cant parse json to configuration file",e);
        }

        if(myConfigrations==null){
            throw new NullConfiguratioException("null congfiguration object");
        }

        return myConfigrations;
    }
}
