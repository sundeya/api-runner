package com.lemon.api.api.untils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntils {
    public static SimpleDateFormat yyyy_mmdd_hhmmss=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat yyyy_mmdd=new SimpleDateFormat("yyyy-MM-dd");
    public static String formatYmdhms(Date date){
        String dataString=yyyy_mmdd_hhmmss.format(new Date());
        return  dataString;
    }
    public static String formatYmd(Date date){
        String dataString=yyyy_mmdd.format(new Date());
        return  dataString;
    }
}
