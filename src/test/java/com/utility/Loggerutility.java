package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggerutility {

    //In singleton we make constructor as private
    private Loggerutility(){

    }

    public static Logger getLogger(Class<?> clazz){
        Logger logger=null;
        if(logger == null) {
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }
}
