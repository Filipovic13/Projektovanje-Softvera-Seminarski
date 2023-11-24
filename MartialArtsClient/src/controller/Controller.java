/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import client.communication.Communication;
import common.communication.Operations;
import common.communication.Request;
import common.communication.Response;
import common.communication.ResponseType;
import domain.Clan;
import domain.Clanarina;
import domain.IzmenaClanarina;
import domain.Korisnik;
import domain.Polaganje;
import domain.Prisustvo;
import java.util.List;

/**
 *
 * @author Sara
 */
public class Controller {

    private static Controller instance;
    private Korisnik currentUser;

    private Controller() {

    }

    public static Controller getInstance() {

        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void setCurrentUser(Korisnik user) {
        currentUser = user;
    }

    public Korisnik login(String username, String password) throws Exception {

        Korisnik requestUser = new Korisnik();
        requestUser.setUsername(username);
        requestUser.setPassword(password);

        Request request = new Request(Operations.LOGIN, requestUser);
        Response response = Communication.getInstance().login(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            Korisnik user = (Korisnik) response.getResult();

            return user;

        } else {
            throw response.getException();
        }
    }

    public void addClan(Clan noviClan) throws Exception {

        Request request = new Request(Operations.UNOS_NOVOG_CLANA, noviClan);
        Response response = Communication.getInstance().addClan(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void addPrisustvo(Prisustvo prisustvo) throws Exception {

        Request request = new Request(Operations.UNOS_PRISUSTVA, prisustvo);
        Response response = Communication.getInstance().addPrisustvo(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }

    }

    public void deleteClanarina(Clanarina clanarinaBrisanje) throws Exception {

        Request request = new Request(Operations.OBRISI_ZADUZENJE, clanarinaBrisanje);
        Response response = Communication.getInstance().deleteClanarina(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }

    }

    public void addClanarina(Clanarina clanarina) throws Exception {
        Request request = new Request(Operations.UNOS_ZADUZENJA, clanarina);
        Response response = Communication.getInstance().addClanarina(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }
    }

    public List<Prisustvo> getAllByCriteriaPrisustvoClanaPoDatumu(Prisustvo prisustvo) throws Exception {
        Request request = new Request(Operations.PRETRAGA_PRISUSTVA, prisustvo);
        Response response = Communication.getInstance().getAllByCriteriaPrisustvoClanaPoDatumu(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            List< Prisustvo> prisustva = (List<Prisustvo>) response.getResult();
            if (prisustva.isEmpty()) {
                throw new Exception("Nema prisutva za uneti mesec i godinu");
            }
            return prisustva;
        } else {
            throw response.getException();
        }
    }

    public void addPolaganje(Polaganje polaganje) throws Exception {
        Request request = new Request(Operations.UNOS_POLAGANJA, polaganje);
        Response response = Communication.getInstance().addPolaganje(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void deleteClan(Clan clanBrisanje) throws Exception {
        Request request = new Request(Operations.OBRISI_CLANA, clanBrisanje);
        Response response = Communication.getInstance().deleteClan(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void deletePrisustvo(Prisustvo prisustvoBrisanje) throws Exception {
        Request request = new Request(Operations.OBRISI_PRISUSTVO, prisustvoBrisanje);
        Response response = Communication.getInstance().deletePrisustvo(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }

    }

    public void deletePolaganje(Polaganje polaganjeBrisanje) throws Exception {
        Request request = new Request(Operations.OBRISI_POLAGANJE, polaganjeBrisanje);
        Response response = Communication.getInstance().deletePolaganje(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }

    }

    public List<Clan> getAllClan() throws Exception {
        Request request = new Request(Operations.VRATI_CLANOVE, null);
        Response response = Communication.getInstance().getAllClan(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            List< Clan> clanovi = (List<Clan>) response.getResult();
            if (clanovi.isEmpty()) {
                throw new Exception("Nema clanova u tabeli");
            }
            return clanovi;
        } else {
            throw response.getException();
        }
    }

    public void editClan(Clan c) throws Exception {
        Request request = new Request(Operations.IZMENI_CLANA, c);
        Response response = Communication.getInstance().editClan(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }

    }

    public void editPolaganje(Polaganje p) throws Exception {
        Request request = new Request(Operations.IZMENI_POLAGANJE, p);
        Response response = Communication.getInstance().editPolaganje(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void editClanarina(Clanarina clanarina) throws Exception {
        Request request = new Request(Operations.IZMENA_ZADUZENJA, clanarina);
        Response response = Communication.getInstance().editClanarina(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }
    }

    public void changeAllClanarina(IzmenaClanarina izmena) throws Exception {

        Request request = new Request(Operations.CHANGE_ALL_ZADUZENJE, izmena);
        Response response = Communication.getInstance().changeAllClanarina(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return;
        } else {
            throw response.getException();
        }

    }

}
