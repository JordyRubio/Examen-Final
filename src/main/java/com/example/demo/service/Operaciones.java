/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import java.util.List;

/**
 *
 * @author JORDY
 * @param <T>
 */
public interface Operaciones<T> {
    T create(T t);
    T update(T t);
    void delete(int id);
    T read(int id);
    List<T> readAll();
    
}