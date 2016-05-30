/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pds.graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;

/**
 *
 * @author Nodaro
 */
public class Printer implements Printable{
    
     Component comp;

    public Printer(Component comp){
        this.comp = comp;
    }
    
    @Override
    public int print(Graphics graphics, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        // Print the entire visible contents of a
        // java.awt.Frame.
        comp.printAll(graphics);
        
        return PAGE_EXISTS;
    }
    
}
