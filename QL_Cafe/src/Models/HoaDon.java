/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;


/**
 *
 * @author ThangIKCU
 */
public class HoaDon  {
    private int MaHoaDon, GiamGia, TongTien, TrangThai ,MaBan, MaKhachHang;
    private Date GioDen;
    
    public HoaDon(){
        this.MaHoaDon =0;
        this.GiamGia =0;
        this.TongTien =0;
        TrangThai =0;
        MaBan = 0;
        GioDen=null;
        MaKhachHang=0;
    }
     public HoaDon(int mahoadon, int giamgia, int maban, Date gioden, int tongtien, int trangthai){
        this.MaHoaDon =mahoadon;
        this.GiamGia =giamgia;
        this.TongTien =tongtien;
        TrangThai =trangthai;
        MaBan =maban;
        GioDen=gioden;
 
    } 

    public HoaDon(int MaHoaDon, int GiamGia, int TongTien, int TrangThai, int MaBan, int MaKhachHang, Date GioDen) {
        this.MaHoaDon = MaHoaDon;
        this.GiamGia = GiamGia;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.MaBan = MaBan;
        this.MaKhachHang = MaKhachHang;
        this.GioDen = GioDen;
    }
     
    public void SetMaHD(int ma){
        MaHoaDon = ma;
    }
    public int GetMaHD(){
        return MaHoaDon;
    }
    public void SetGiamGia(int giamgia){
        GiamGia = giamgia;
    }
    public int GetGiamGia(){
        return GiamGia;
    }
    public void SetMaBan(int maban){
        MaBan = maban;
    }
    public int GetMaBan(){
        return MaBan;
    }
    public void SetGioDen(Date gioden){
        GioDen = gioden;
    }
    public Date GetGioDen(){
        return GioDen;
    }
    public void SetTongTien(int tongtien){
        TongTien = tongtien;
    }
    public int GetTongTien(){
        return TongTien;
    }
    public void SetTrangThai(int trangThai){
        TrangThai = trangThai;
    }
    public int GetTrangThai(){
        return TrangThai;
    }
    
}
