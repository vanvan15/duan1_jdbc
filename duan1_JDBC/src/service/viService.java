/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.DongHocPhi;
import model.LichSuNapTien;
import model.Vi;

/**
 *
 * @author HánH
 */
public interface viService {

    Vi getOne(String id);

    String getIDHocVien(String ma);

    String updateV(String id, Vi v);

    List<LichSuNapTien> getAll(String id);

    String add(LichSuNapTien lsnt, String idVi);

    String getIDVi(String id);

    List<DongHocPhi> getDSHP(String idHV);
}
