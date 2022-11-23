/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.HocVien;
import repository.hocvienRepo;
import service.hocvienService;

/**
 *
 * @author HánH
 */
public class hocvienImpl implements hocvienService{
    private hocvienRepo hvr = new hocvienRepo();

    @Override
    public List<HocVien> getAll() {
        return hvr.getAll();
    }

    @Override
    public String getIDHocVien(String ma) {
        return hvr.getIDHocVien(ma);
    }

    @Override
    public HocVien getOne(String ma) {
        return hvr.getOne(ma);
    }

    @Override
    public String updateHV(String maHV, HocVien hv) {
        boolean update = hvr.updateNV(maHV, hv);
        if (update) {
            return "Update Thành Công";
        }else{
            return "Update Thất Bại";
        }
    }

    
}
