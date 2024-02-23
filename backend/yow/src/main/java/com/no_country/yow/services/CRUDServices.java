package com.no_country.yow.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.no_country.yow.exceptions.YOWException;

public interface CRUDServices<T> {
  public ResponseEntity<?> save(T data) throws YOWException;

  public List<T> findAll();

  public ResponseEntity<?> updateById(Long id) throws YOWException;

  public ResponseEntity<?> findById(Long id) throws YOWException;


}
