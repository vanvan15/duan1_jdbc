/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.QLLopGV;
import viewmodel.qlDiem;

/**
 *
 * @author HánH
 */
public interface qlDiemService {

    List<QLLopGV> getDsLop(String idGV);

    List<qlDiem> getDSHV(String idGV, String idLop);

    String getIDLop(String idGV);

    String getidGV(String ma);

    String getidHV(String ma);

    String diemHV(qlDiem kt, String idHV);
}
