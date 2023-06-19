/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author hoatd
 */
public class NhapXuatNL {
    public int MaNhapXuatNL;
    public int MaNguyenLieu;
    public int MaTaiKhoan;
     public int loai;
     public int SoLuong;
     public String NgayGio;

    public NhapXuatNL(int MaNhapXuatNL, int MaNguyenLieu, int MaTaiKhoan, int loai, int SoLuong, String NgayGio) {
        this.MaNhapXuatNL = MaNhapXuatNL;
        this.MaNguyenLieu = MaNguyenLieu;
        this.MaTaiKhoan = MaTaiKhoan;
        this.loai = loai;
        this.SoLuong = SoLuong;
        this.NgayGio = NgayGio;
    }


   

 
     
   
}
