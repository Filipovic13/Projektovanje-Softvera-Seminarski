/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.communication.Communication;
import java.io.IOException;
import java.net.Socket;
import view.form.FrmLogin;

/**
 *
 * @author Sara
 */
public class Client {

    public static void main(String[] args) {

        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Povezan!");

        Communication.getInstance().setSocket(socket);
        new FrmLogin().setVisible(true);
    }
}
