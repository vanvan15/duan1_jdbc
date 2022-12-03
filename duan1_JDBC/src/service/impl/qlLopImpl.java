/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.qlLopRepo;
import service.qlLopGVservice;
import viewmodel.QLLopGV;

/**
 *
 * @author HánH
 */
public class qlLopImpl implements qlLopGVservice {

    private qlLopRepo lr = new qlLopRepo();

    @Override
    public List<QLLopGV> getAll(String ma) {
        return lr.getAll(ma);
    }

    @Override
    public List<QLLopGV> getOne(String maL, String MaGV) {
        return lr.getOne(maL, MaGV);
    }
}
