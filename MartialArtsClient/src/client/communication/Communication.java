/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.communication;

import common.communication.Receiver;
import common.communication.Request;
import common.communication.Response;
import common.communication.Sender;

import java.net.Socket;

/**
 *
 * @author Sara
 */
public class Communication {

    private static Communication instance;
    private Socket socket;

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Response login(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za prijavom na sistem je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response addClan(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za addClan je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response addPrisustvo(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za addPrisustvo je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteClanarina(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za deleteClanarina je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response addClanarina(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za addClanarina je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response getAllByCriteriaPrisustvoClanaPoDatumu(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za getAllByCriteriaPrisustvoClanaPoDatumu je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response addPolaganje(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za addPolaganje je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteClan(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za deleteClan je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response deletePrisustvo(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za deletePrisustvo je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response deletePolaganje(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za deletePolaganje je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response getAllClan(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za getAllClan je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response editClan(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za editClan je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response editPolaganje(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za editPolaganje je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response editClanarina(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za editClanarina je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

    public Response changeAllClanarina(Request request) throws Exception {
        new Sender(socket).send(request);
        System.out.println("Zahtev za changeAllClanarina je poslat... ");
        return (Response) new Receiver(socket).receive();
    }

}
