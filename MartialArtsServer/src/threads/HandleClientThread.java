/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import common.communication.Operations;
import common.communication.Receiver;
import common.communication.Request;
import common.communication.Response;
import common.communication.ResponseType;
import common.communication.Sender;
import controller.Controller;
import domain.Clan;
import domain.Clanarina;
import domain.IzmenaClanarina;
import domain.Korisnik;
import domain.Polaganje;
import domain.Prisustvo;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Sara
 */
public class HandleClientThread extends Thread {
    
    private Socket socket;
    
    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        while (!socket.isClosed()) {
            Request request;
            try {
                
                request = (Request) new Receiver(socket).receive();
                Response response = handleRequest(request);
                
                new Sender(socket).send(response);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public Socket getSocket() {
        return socket;
    }
    
    private Response handleRequest(Request request) {
        
        switch (request.getOperation()) {
            
            case Operations.LOGIN:
                return login(request);

            // CALN
            case Operations.UNOS_NOVOG_CLANA:
                return addClan(request);
            case Operations.VRATI_CLANOVE:
                return getAllClan();
            case Operations.OBRISI_CLANA:
                return deleteClan(request);
            case Operations.IZMENI_CLANA:
                return editClan(request);

            //PRISUSTVA
            case Operations.UNOS_PRISUSTVA:
                return addPrisustvo(request);
            case Operations.PRETRAGA_PRISUSTVA:
                return getByPrisustvaDatum(request);
            case Operations.OBRISI_PRISUSTVO:
                return deletePrisustvo(request);

            //ZADUZNEJA      
            case Operations.UNOS_ZADUZENJA:
                return addClanarina(request);
            case Operations.IZMENA_ZADUZENJA:
                return editClanarina(request);
            case Operations.OBRISI_ZADUZENJE:
                return deleteClanarina(request);
            case Operations.CHANGE_ALL_ZADUZENJE:
                return changeAllClanarina(request);

            //POLAGANJA    
            case Operations.UNOS_POLAGANJA:
                return addPolaganje(request);
            case Operations.IZMENI_POLAGANJE:
                return editPolaganje(request);
            case Operations.OBRISI_POLAGANJE:
                return deletePolaganje(request);
            
            default:
                return null;
            
        }
    }
    
    private Response login(Request request) {
        Response response = new Response();
        
        Korisnik kReq = (Korisnik) request.getArgument();
        try {
            Korisnik k = Controller.getInstance().login(kReq);
            if (k != null) {
                response.setResponseType(ResponseType.SUCCESS);
            } else {
                response.setResponseType(ResponseType.ERROR);
                response.setException(new Exception("Ne postoji korinsik sa unetim podacima!"));
            }
            response.setResult(k);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }
    
    private Response addClan(Request request) {
        Response response = new Response();
        Clan clan = (Clan) request.getArgument();
        try {
            Controller.getInstance().addClan(clan);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response getAllClan() {
        Response response = new Response();
        try {
            List<Clan> clanovi = Controller.getInstance().getAllClan();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(clanovi);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response deleteClan(Request request) {
        Response response = new Response();
        
        Clan clanBrisanje = (Clan) request.getArgument();
        try {
            Controller.getInstance().deleteClan(clanBrisanje);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response editClan(Request request) {
        Response response = new Response();
        
        Clan clanIzmena = (Clan) request.getArgument();
        try {
            Controller.getInstance().editClan(clanIzmena);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response addPrisustvo(Request request) {
        Response response = new Response();
        
        Prisustvo prisustvo = (Prisustvo) request.getArgument();
        try {
            Controller.getInstance().addPrisustvo(prisustvo);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response getByPrisustvaDatum(Request request) {
        Response response = new Response();
        
        Prisustvo p = (Prisustvo) request.getArgument();
        try {
            List<Prisustvo> prisustva = Controller.getInstance().getAllByCriteriaPrisustvoClanaPoDatumu(p);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(prisustva);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
        
    }
    
    private Response deletePrisustvo(Request request) {
        Response response = new Response();
        
        Prisustvo prisustvoBrisanje = (Prisustvo) request.getArgument();
        try {
            Controller.getInstance().deletePrisustvo(prisustvoBrisanje);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response addClanarina(Request request) {
        
        Response response = new Response();
        
        Clanarina novaClanarina = (Clanarina) request.getArgument();
        try {
            Controller.getInstance().addClanarina(novaClanarina);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response editClanarina(Request request) {
        Response response = new Response();
        
        Clanarina clanarina = (Clanarina) request.getArgument();
        try {
            Controller.getInstance().editClanarina(clanarina);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response deleteClanarina(Request request) {
        Response response = new Response();
        
        Clanarina clanarinaBrisanje = (Clanarina) request.getArgument();
        try {
            Controller.getInstance().deleteClanarina(clanarinaBrisanje);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
        
    }
    
    private Response changeAllClanarina(Request request) {
        Response response = new Response();
        
        IzmenaClanarina izmene = (IzmenaClanarina) request.getArgument();
        try {
            Controller.getInstance().changeAllClanarina(izmene);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response addPolaganje(Request request) {
        Response response = new Response();
        
        Polaganje novoPolaganje = (Polaganje) request.getArgument();
        try {
            Controller.getInstance().addPolaganje(novoPolaganje);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
        
    }
    
    private Response editPolaganje(Request request) {
        Response response = new Response();
        
        Polaganje polaganjeIzmena = (Polaganje) request.getArgument();
        try {
            Controller.getInstance().editPolaganje(polaganjeIzmena);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
    private Response deletePolaganje(Request request) {
        Response response = new Response();
        
        Polaganje polaganjeBrisanje = (Polaganje) request.getArgument();
        try {
            Controller.getInstance().deletePolaganje(polaganjeBrisanje);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(e);
        }
        return response;
    }
    
}
