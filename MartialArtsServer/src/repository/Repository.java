/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Sara
 */
public interface Repository<T> {

    void add(T param) throws Exception;

    void edit(T param) throws Exception;

    void delete(T param) throws Exception;

    List<T> getAll(T param) throws Exception;

    T getOne(T param) throws Exception;

    List<T> getAllByCriteria(T param, String whereCriteria) throws Exception;

    void changeAll(List<T> addedList, List<T> editedList, List<T> deletedList) throws Exception;

}
