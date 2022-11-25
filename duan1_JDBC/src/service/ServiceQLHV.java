/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.HocVien;

/**
 *
 * @author Tran Duc Do
 */
public interface ServiceQLHV {

    List<HocVien> GetAllDaTa();

    boolean addhv(HocVien hocVien);

    boolean updateHv(HocVien hocVien, String ma);

    boolean Delete(String ma);

    boolean addVi(String idHV);

    HocVien getOne(String maHV);

    boolean deleteKqht(String idHV);

    boolean deleteLopHV(String idHV);

    boolean deleteVi(String id);

    boolean deleteDHP(String id);

    boolean deleteDKHocLai(String id);
}
