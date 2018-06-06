package net.cdsunrise.alps.ewp.eiamanage.utils;

import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.eiamanage.exception.CustomException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 格式化时间，
     * @param date
     * @return
     */
    public static Date stringToDate(String date){
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat minute = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat second = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            if(date != null){
                date = date.trim();
                if(date.length() == 10){
                    dateTime = day.parse(date);
                }else if(date.length() == 16){
                    dateTime = minute.parse(date);
                }else if(date.length() == 19){
                    dateTime = second.parse(date);
                }else{
                    throw new CustomException(ExceptionEnums.TIME_FORMAT_ERROR);
                }
            }
        } catch (Exception e) {
            throw new CustomException(ExceptionEnums.TIME_FORMAT_ERROR);
        }
        return dateTime;
    }
}
