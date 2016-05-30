/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import java.awt.Color;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.stream.Stream;

/**
 *
 * @author zouhairhajji
 */
public class MathHepler {
    
    private static Color colorWrong, colorReight;
    private static DecimalFormat df;
    
    static{
        df = new DecimalFormat();
        df.setDecimalSeparatorAlwaysShown ( true ) ; 
    }
    
    public static String ajustVirgule ( Number nbr, int nbrAfterVirgule){
        df.setMaximumFractionDigits ( nbrAfterVirgule ) ; //arrondi à 2 chiffres apres la virgules 
        df.setMinimumFractionDigits ( nbrAfterVirgule ) ; 
        return df.format(nbr);
    }
    
    
    public static int compareToWithTauxEndet(Client client, SimulationPret sim, SimulationPret sim2, boolean desc){
        
        if(sim.getTauxEndettement(client) > sim2.getTauxEndettement(client))
                return (desc) ? 1 : -1;
        
        else if (sim.getTauxEndettement(client) == sim2.getTauxEndettement(client))
            return 0;
        
        return (desc) ? -1 : 1;
    }
    
    public static int compareToWithMensualite(SimulationPret sim, SimulationPret sim2, boolean desc){
        
        if(sim.getMensualite() > sim2.getMensualite())
                return (desc) ? 1 : -1;
        
        else if (sim.getMensualite() == sim2.getMensualite())
            return 0;
        
        return (desc) ? -1 : 1;
    }
    
    public static int compareToWithDuree( SimulationPret sim, SimulationPret sim2, boolean desc){
        
        if(sim.getDureePret() > sim2.getDureePret())
                return (desc) ? 1 : -1;
        
        else if (sim.getDureePret() == sim2.getDureePret())
            return 0;
        
        return (desc) ? -1 : 1;
    }
    
    public static int compareToInteret(SimulationPret sim, SimulationPret sim2, boolean desc){
        
        if(sim.getTauxInteret() > sim2.getTauxInteret())
                return (desc) ? 1 : -1;
        
        else if (sim.getTauxInteret() == sim2.getTauxInteret())
            return 0;
        
        return (desc) ? -1 : 1;
    }

    
    public static int compareToMtTotale(SimulationPret sim, SimulationPret sim2, boolean desc){
        
        if(sim.getMensualite()*sim.getDureePret() > sim2.getMensualite()*sim.getDureePret())
                return (desc) ? 1 : -1;
        
        else if (sim.getMensualite()*sim.getDureePret() == sim2.getMensualite()*sim.getDureePret())
            return 0;
        
        return (desc) ? -1 : 1;
    }
    
    
    public static int compareToTypePret(SimulationPret sim, SimulationPret sim2, boolean desc){
        
        if( sim.getTypeEmprunt() == sim2.getTypeEmprunt() )
                return 0;
        
        return (desc) ? -1 : 1;
    }
    
    public static int compareToResSimulation(Object[] sim, Object[] sim2, boolean desc){
        if( ((double)sim[8]) > ((double)sim2[8]) )
                return (desc) ? 1 : -1;
        
        else if ( ((double)sim[8]) == ((double)sim2[8]) )
            return 0;
        
        return (desc) ? -1 : 1;
    }
    
    
    public static int compareToDateFin(SimulationPret e1, SimulationPret e2, boolean b) {
        
        if ( MathHepler.addMouthToDate(e1.getDateContraction(), e1.getDureePret()).getTime() > MathHepler.addMouthToDate(e2.getDateContraction(), e2.getDureePret()).getTime())
            return 1;
        else if ( MathHepler.addMouthToDate(e1.getDateContraction(), e1.getDureePret()).getTime() == MathHepler.addMouthToDate(e2.getDateContraction(), e2.getDureePret()).getTime())
            return 0;
        return -1;
    }
    
    public static Timestamp addMouthToDate(Timestamp date, int nbrMouth){
        Calendar cal = Calendar.getInstance();
        Timestamp dateCloned = (Timestamp) date.clone();
        cal.setTime(dateCloned);
        cal.add(Calendar.MONTH, nbrMouth);
        dateCloned.setTime(cal.getTime().getTime());
        return dateCloned;
    }
    
    public static String formatTimeStamp(Timestamp date, String format){
        return new SimpleDateFormat(format).format(date);
    }

    

    public static Color getColorWrong() {
        if(colorWrong == null)
            colorWrong = new Color(255, 234, 234);
        return colorWrong;
    }
    
    
    public static Color getColorReight() {
        if(colorReight == null)
            colorReight = new Color(242, 255, 245);
        return colorReight;
    }
    
}
