/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLLopGV;

/**
 *
 * @author HánH
 */
public interface qlLopGVservice {

    List<QLLopGV> getAll(String ma);

    List<QLLopGV> getOne(String maL, String MaGV);

}
