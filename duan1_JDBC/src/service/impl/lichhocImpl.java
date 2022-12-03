/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.lichhocRepo;
import service.lichhocService;
import viewmodel.lichhocVD;

/**
 *
 * @author HánH
 */
public class lichhocImpl implements lichhocService{

    private lichhocRepo lhr = new lichhocRepo();
    
    @Override
    public List<lichhocVD> getAll(String ma) {
        return lhr.getAll(ma);
    }
    
    
    
}
