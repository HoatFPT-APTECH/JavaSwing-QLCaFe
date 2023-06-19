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
public class NguyenLieu {
    public int MaNguyenLieu;
    public String Ten;
    public int SLTonKho;
    public String DonVi;
    public int Deleted;

    public NguyenLieu(int MaNguyenLieu, String Ten, int SLTonKho, String DonVi, int Deleted) {
        this.MaNguyenLieu = MaNguyenLieu;
        this.Ten = Ten;
        this.SLTonKho = SLTonKho;
        this.DonVi = DonVi;
        this.Deleted = Deleted;
    }

  
    
}
