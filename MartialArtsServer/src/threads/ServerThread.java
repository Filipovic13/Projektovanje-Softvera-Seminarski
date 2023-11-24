/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import constant.MyServerConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sara
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private List<HandleClientThread> clients;

    public ServerThread() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/server.properties"));
            int port = Integer.parseInt(properties.getProperty(MyServerConstants.SERVER_CONFIG_PORT));

            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {

                System.out.println("Ceka se klijent...");
                System.out.println(serverSocket);
                Socket socket = serverSocket.accept();
                System.out.println("Klijent povezan!");

                HandleClientThread clientThread = new HandleClientThread(socket);
                clientThread.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stopAllHandleClientThreads();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    private void stopAllHandleClientThreads() {
        for (HandleClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
