/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mainexec;

import com.pds.entities.MathHepler;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author zouhairhajji
 */
public class Testes {
    
    public static Timestamp addDate(Timestamp date, int nbrMouth){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, nbrMouth);
        date.setTime(cal.getTime().getTime());
        return date;
    }
    
    public static void main(String[] args) {
        //System.out.println(MathHepler.formatTimeStamp(addDate(new Timestamp(new Date("10/09/1994").getTime()), 11), "dd-MM-yyyy"));
        
        
    }
}
