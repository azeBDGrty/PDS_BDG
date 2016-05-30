/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mainexec;

import com.pds.entities.Anonyme;
import com.pds.serverhandler.AnonymeHandle;
import com.pds.inoutdata.InPutData;
import com.pds.inoutdata.OutPutData;
import com.pds.mvc_main.Controller_MDIForm;
//import com.pds.mvc_main.Controller_MDIForm;
import com.pds.mvc_main.Forme;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author zouhairhajji
 */
public class Executable {

    public static void main(String[] args) throws IOException, Exception {

        Socket socket = new Socket("localhost", 3000);

        InPutData in = new InPutData(socket);
        OutPutData out = new OutPutData(socket);
        Anonyme user = new Anonyme();

        AnonymeHandle model = new AnonymeHandle(in, out, user);
        
        Controller_MDIForm controller = new Controller_MDIForm(model);

        Forme view = new Forme(controller, true);
        model.addObserver(view);
        model.setDeskTopPane(view.getDesktopPane());
        view.setVisible(true);
        model.startListenning();
    }
}
