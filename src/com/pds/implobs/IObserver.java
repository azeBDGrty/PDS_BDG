/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.implobs;

/**
 *
 * @author zouhairhajji
 */
public interface IObserver {
    
    public boolean update(AbstractObservable sender, String message, Object ... data);
    
}
