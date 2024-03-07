package com.no_country.yow.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.no_country.yow.exceptions.YOWException;

public interface CRUDServices<T, G> {
  ResponseEntity<?> save(T data) throws YOWException;

  ResponseEntity<List<T>> findAll();

  ResponseEntity<?> updateById(T t, G id) throws YOWException;

  ResponseEntity<?> findById(G id) throws YOWException;

}
