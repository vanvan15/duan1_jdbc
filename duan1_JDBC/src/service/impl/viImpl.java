/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.Vi;
import repository.viRepo;
import service.viService;

/**
 *
 * @author HánH
 */
public class viImpl implements viService {

    private viRepo vr = new viRepo();

    @Override
    public Vi getOne(String id) {
        return vr.getOne(id);
    }

    @Override
    public String getIDHocVien(String ma) {
        return vr.getIDHocVien(ma);
    }

    @Override
    public String updateV(String id, Vi v) {
        boolean update = vr.updateV(id, v);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

}
