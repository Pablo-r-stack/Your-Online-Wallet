package com.no_country.yow.services;


import java.util.List;

public interface CRUDServices<T> {
  public T save(T data);

  public List<T> findAll();

  public T updateById(Long id);

  public T findById(Long id);


}
