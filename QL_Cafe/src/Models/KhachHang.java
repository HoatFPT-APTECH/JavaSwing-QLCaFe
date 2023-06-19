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
public class KhachHang {
    public int MaKhachHang;
    public String Ten;
    public String sdt;
    public String DiaChi;

    public KhachHang(int MaKhachHang, String Ten, String sdt, String DiaChi) {
        this.MaKhachHang = MaKhachHang;
        this.Ten = Ten;
        this.sdt = sdt;
        this.DiaChi = DiaChi;
    }
    
}
