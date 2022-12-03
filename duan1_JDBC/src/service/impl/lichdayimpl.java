/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.lichDayRepo;
import service.lichdayService;
import viewmodel.LichDay;

/**
 *
 * @author 84839
 */
public class lichdayimpl implements lichdayService {

    private lichDayRepo ldr = new lichDayRepo();

    @Override
    public List<LichDay> getAll(String ma) {
        return ldr.getAll(ma);
    }

}
