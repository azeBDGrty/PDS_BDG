/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.executor;

import com.pds.entities.Anonyme;
import com.pds.inoutdata.InPutData;
import com.pds.inoutdata.OutPutData;
import com.pds.mvc_main.Controller_MDIForm;
import com.pds.mvc_main.Forme;
import com.pds.server.Server;
import com.pds.serverhandler.AnonymeHandle;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author zouhairhajji
 */
public class mainExec {

    public static void main(String[] args) throws IOException, Exception {
        
        String choix = args[0];

        try {
            if ("server".equalsIgnoreCase(choix.trim().toLowerCase()) || "serveur".equalsIgnoreCase(choix.trim().toLowerCase())) {
                Server server = new Server();
                server.startThread();

            } else if ("client".equalsIgnoreCase(choix.trim().toLowerCase())) {

                Socket socket = new Socket(args[1], Integer.parseInt(args[2]));

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

            } else {
                System.out.println("vous devez choisir soit (Client) soit (Server | Server )");
            }
        } catch (Exception e) {
        }

    }
}
