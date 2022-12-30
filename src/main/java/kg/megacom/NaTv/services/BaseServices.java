package kg.megacom.NaTv.services;

import java.util.List;

public interface BaseServices <T>{
    T save(T t);
    T findById(Long id,int lang);
    List<T> findAll();
}
