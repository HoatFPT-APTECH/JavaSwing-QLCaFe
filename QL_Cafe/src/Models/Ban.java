/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ThangIKCU
 */
public class Ban {
    private String  TenBan, TrangThai,Gio=null;
    private int MaBan,MaKhachHang=-1;

 
    
    public Ban(){
        this.MaBan =0;
        this.TenBan ="";
        this.TrangThai ="";
    }
    public Ban(int ma, String ten, String trangthai){
        this.MaBan =ma;
        this.TenBan =ten;
        this.TrangThai =trangthai;
    }

    public Ban( int MaBan,String TenBan, String TrangThai, String gio,int MaKhachHang) {
        this.TenBan = TenBan;
        this.TrangThai = TrangThai;
        this.MaBan = MaBan;
        this.Gio=gio;
        this.MaKhachHang=MaKhachHang;
    }
   
  

    public String getGio() {
        return Gio;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    

    public void setGio(String Gio) {
        this.Gio = Gio;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

 
    
    public void SetMaBan(int ma){
        this.MaBan = ma;
    }
    public int GetMaBan(){
        return this.MaBan;
    }
    public void SetTenBan(String ten){
        this.TenBan = ten;
    }
    public String GetTenBan(){
        return this.TenBan;
    }
    public void SetTrangThai(String trangthai){
        this.TrangThai = trangthai;
    }
    public String GetTrangThai(){
        return this.TrangThai;
    }
    @Override
    public String toString(){
        return this.TenBan;
    }
}
