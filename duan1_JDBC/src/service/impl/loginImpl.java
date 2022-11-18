/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.ChucVu;
import model.HocVien;
import model.NhanVien;
import repository.loginRepo;
import service.loginService;

/**
 *
 * @author Dell
 */
public class loginImpl implements loginService {

    loginRepo login = new loginRepo();

    @Override
    public String getOne(String maNV) {
        return login.getOne(maNV);
    }

    @Override
    public List<NhanVien> getALlNV() {
        return login.getALLNV();
    }

    @Override
    public List<HocVien> getALLHV() {
        return login.getALLHV();
    }

    @Override
    public String getIDNV(String maNV) {
        return login.getIDNV(maNV);
    }

    @Override
    public String getIDHV(String maHV) {
        return login.getIDNV(maHV);
    }

}
