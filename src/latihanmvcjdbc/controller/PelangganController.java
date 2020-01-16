/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmvcjdbc.controller;

import javax.swing.JOptionPane;
import latihanmvcjdbc.model.PelangganModel;
import latihanmvcjdbc.view.PelangganView;

/**
 *
 * @author 
 * Nama  : Naufal Asha
 * Nim   : 10118063
 * Kelas : IF-2
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view){
        
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(
                view,
                "Nama Tidak Boleh Kosong"
            );
            
        } else if (nama.length()>255){
            JOptionPane.showMessageDialog(
                view,
                "Nama Tidak Boleh Lebih dari 255 Karakter"
            );
            
        } else if (telepon.length()>12){
            JOptionPane.showMessageDialog(
                view, 
                "Nomor Telepon Tidak Boleh Lebih dari 12 Digit"
            );
            
        } else if (!email.contains("@")||!email.contains(".")){
            JOptionPane.showMessageDialog(
                view, 
                "Email Tidak Valid"
            );
            
        } else {
            
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(
                        view, 
                        "Pelanggan Berhasil Ditambahkan"
                );
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(
                        view, 
                        new Object[]{
                            "Terjadi Error di database dengan pesan",
                            throwable .getMessage()
                        }
                );
            }  
        }
    }
    
    public void updatePelanggan(PelangganView view){
        
        if(view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(
                        view, 
                        "Silahkan pilih data yang akan diubah"
                );
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(
                view,
                "Nama Tidak Boleh Kosong"
            );
            
        } else if (nama.length()>255){
            JOptionPane.showMessageDialog(
                view,
                "Nama Tidak Boleh Lebih dari 255 Karakter"
            );
            
        } else if (telepon.length()>12){
            JOptionPane.showMessageDialog(
                view, 
                "Nomor Telepon Tidak Boleh Lebih dari 12 Digit"
            );
            
        } else if (!email.contains("@")||!email.contains(".")){
            JOptionPane.showMessageDialog(
                view, 
                "Email Tidak Valid"
            );
            
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(
                        view, 
                        "Pelanggan Berhasil Diubah"
                );
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(
                        view, 
                        new Object[]{
                            "Terjadi Error di database dengan pesan",
                            throwable .getMessage()
                        }
                );
            }  
        }
        
    }
    
    public void deletePelanggan(PelangganView view){
        
        if(view.getTablePelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(
                        view, 
                        "Silahkan pilih baris data yang akan dihapus"
                );
            return;
        }
        
        if(JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")==JOptionPane.OK_OPTION){
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(
                        view, 
                        "Pelanggan Berhasil Dihapus"
                );
                model.resetPelanggan();
            }catch (Throwable throwable) {
                JOptionPane.showMessageDialog(
                        view, 
                        new Object[]{
                            "Terjadi Error di database dengan pesan",
                            throwable .getMessage()
                        }
                );
            }
            
        }
        
    }
    
}
