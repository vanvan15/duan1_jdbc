/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.qlDiemRepo;
import service.qlDiemService;
import viewmodel.QLLopGV;
import viewmodel.qlDiem;

/**
 *
 * @author HánH
 */
public class qlDiemImpl implements qlDiemService {

    private qlDiemRepo qldr = new qlDiemRepo();

    @Override
    public List<QLLopGV> getDsLop(String idGV) {
        return qldr.getDsLOp(idGV);
    }

    @Override
    public List<qlDiem> getDSHV(String idGV, String idLop) {
        return qldr.getDSHV(idGV, idLop);
    }

    @Override
    public String getIDLop(String idGV) {
        return qldr.getIDLop(idGV);
    }

    @Override
    public String getidGV(String ma) {
        return qldr.getIDNV(ma);
    }

    @Override
    public String getidHV(String ma) {
        return qldr.getIDHV(ma);
    }

    @Override
    public String diemHV(qlDiem kt, String idHV) {
        boolean update = qldr.updateDiem(kt, idHV);
        if (update) {
            return "Update thanh Cong";
        } else {
            return "Update Không thanh Cong";
        }
    }

}
