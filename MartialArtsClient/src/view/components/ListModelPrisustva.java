/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Prisustvo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Sara
 */
public class ListModelPrisustva extends AbstractListModel<Object> {

    private List<Prisustvo> prisustva;

    public ListModelPrisustva() {
        prisustva = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return prisustva.size();
    }

    @Override
    public Object getElementAt(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        Prisustvo p = prisustva.get(i);
        return sdf.format(p.getDatum());
    }

    public void setPrisustva(List<Prisustvo> prisustva) {
        this.prisustva = prisustva;
        fireContentsChanged(this, prisustva.size(), prisustva.size());
    }

    public Prisustvo getPrisustvo(int index) {
        return prisustva.get(index);
    }

}
