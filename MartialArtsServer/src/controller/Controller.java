/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Clan;
import domain.Clanarina;
import domain.IzmenaClanarina;
import domain.Korisnik;
import domain.Polaganje;
import domain.Prisustvo;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;
import so.clan.AddClanSO;
import so.clan.DeleteClanSO;
import so.clan.EditClanSO;
import so.clan.GetAllClanSO;
import so.clanarina.AddClanarinaSO;
import so.clanarina.ChangeAllClanarinaSO;
import so.clanarina.DeleteClanarinaSO;
import so.clanarina.EditClanarinaSO;
import so.clanarina.GetAllByCriteriaClanarinaClanaSO;
import so.korisnik.LoginSO;
import so.polaganje.AddPolaganjeSO;
import so.polaganje.DeletePolaganjeSO;
import so.polaganje.EditPolaganjeSO;
import so.polaganje.GetAllByCriteriaPolaganjeClanaSO;
import so.prisustvo.AddPrisustvoSO;
import so.prisustvo.DeletePrisustvoSO;
import so.prisustvo.GetAllByCriteriaPrisustvoClanaSO;
import so.prisustvo.GetAllByCriteriaPrisustvoClanaPoDatumuSO;

/**
 *
 * @author Sara
 */
public class Controller {

    private static Controller instance;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Korisnik login(Korisnik k) throws Exception {
        AbstractSO login = new LoginSO();
        login.execute(k);
        return ((LoginSO) login).getKorisnik();
    }

    //CLAN
    public List<Clan> getAllClan() throws Exception {
        AbstractSO getAllClan = new GetAllClanSO();
        getAllClan.execute(new Clan());
        List<Clan> listaClanova = ((GetAllClanSO) getAllClan).getListaClanova();

        for (Clan clan : listaClanova) {
            clan.setPrisustva(getAllByCriteriaPrisustvoClana(clan));
            clan.setClanarine(getAllByCriteriaClanarinaClana(clan));
            clan.setPolaganja(getAllByCriteriaPolaganjeClana(clan));
        }

        return listaClanova;
    }

    public void addClan(Clan noviClan) throws Exception {
        AbstractSO addClanSO = new AddClanSO();
        addClanSO.execute(noviClan);
    }

    public void editClan(Clan clanIzmena) throws Exception {
        AbstractSO editClanSO = new EditClanSO();
        editClanSO.execute(clanIzmena);
    }

    public void deleteClan(Clan clanBrisanje) throws Exception {
        AbstractSO deleteClan = new DeleteClanSO();
        deleteClan.execute(clanBrisanje);
    }

    //PRISUSTVA
    public void addPrisustvo(Prisustvo novoPrisustvo) throws Exception {
        AbstractSO addPrisustvo = new AddPrisustvoSO();
        addPrisustvo.execute(novoPrisustvo);
    }

    public void deletePrisustvo(Prisustvo prisustvoBrisanje) throws Exception {
        AbstractSO deletePrisustvo = new DeletePrisustvoSO();
        deletePrisustvo.execute(prisustvoBrisanje);
    }

    public List<Prisustvo> getAllByCriteriaPrisustvoClana(Clan clan) throws Exception {
        AbstractSO getAllByCriteriaPrisustvo = new GetAllByCriteriaPrisustvoClanaSO();
        getAllByCriteriaPrisustvo.execute(clan);
        return ((GetAllByCriteriaPrisustvoClanaSO) getAllByCriteriaPrisustvo).getListaPrisustva();
    }

    public List<Prisustvo> getAllByCriteriaPrisustvoClanaPoDatumu(Prisustvo prisustvo) throws Exception {
        AbstractSO getAllByCriteriaPrisustvoClanaPoDatumu = new GetAllByCriteriaPrisustvoClanaPoDatumuSO();
        getAllByCriteriaPrisustvoClanaPoDatumu.execute(prisustvo);
        return ((GetAllByCriteriaPrisustvoClanaPoDatumuSO) getAllByCriteriaPrisustvoClanaPoDatumu).getListaPrisustva();
    }

    //CLANARIA
    public void addClanarina(Clanarina novaClanarina) throws Exception {
        AbstractSO addClanarina = new AddClanarinaSO();
        addClanarina.execute(novaClanarina);
    }

    public void editClanarina(Clanarina clanarina) throws Exception {
        AbstractSO editClanarina = new EditClanarinaSO();
        editClanarina.execute(clanarina);
    }

    public void deleteClanarina(Clanarina clanarinaBrisanje) throws Exception {
        AbstractSO deleteClanarina = new DeleteClanarinaSO();
        deleteClanarina.execute(clanarinaBrisanje);
    }

    private List<Clanarina> getAllByCriteriaClanarinaClana(Clan clan) throws Exception {
        AbstractSO getAllByCriteriaClanarinaClana = new GetAllByCriteriaClanarinaClanaSO();
        getAllByCriteriaClanarinaClana.execute(clan);
        return ((GetAllByCriteriaClanarinaClanaSO) getAllByCriteriaClanarinaClana).getListaClanrina();
    }

    public void changeAllClanarina(IzmenaClanarina izmene) throws Exception {
        AbstractSO changeAllClanarina = new ChangeAllClanarinaSO();
        changeAllClanarina.execute(izmene);
    }

    //POLAGANJE
    public void addPolaganje(Polaganje novoPolaganje) throws Exception {
        AbstractSO addPolaganje = new AddPolaganjeSO();
        addPolaganje.execute(novoPolaganje);
    }

    public void editPolaganje(Polaganje polaganjeIzmena) throws Exception {
        AbstractSO editPolaganje = new EditPolaganjeSO();
        editPolaganje.execute(polaganjeIzmena);
    }

    public void deletePolaganje(Polaganje polaganjeBrisanje) throws Exception {
        AbstractSO deletePolaganje = new DeletePolaganjeSO();
        deletePolaganje.execute(polaganjeBrisanje);
    }

    private List<Polaganje> getAllByCriteriaPolaganjeClana(Clan clan) throws Exception {
        AbstractSO getAllByCriteriaPolaganjeClana = new GetAllByCriteriaPolaganjeClanaSO();
        getAllByCriteriaPolaganjeClana.execute(clan);
        return ((GetAllByCriteriaPolaganjeClanaSO) getAllByCriteriaPolaganjeClana).getListaPolaganja();
    }

}
