/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.HocVien;

/**
 *
 * @author HánH
 */
public interface hocvienService {

    List<HocVien> getAll();

    String getIDHocVien(String ma);
    
    HocVien getOne(String ma);
    
    String updateHV(String maHV, HocVien hv);
}
