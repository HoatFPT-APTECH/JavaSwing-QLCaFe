package Mysql;

import Models.Ban;
import Models.ChiTietHD;
import Models.DsOrder;
import Models.HoaDon;
import Models.KhachHang;
import Models.Loai;
import Models.NguyenLieu;
import Models.NhapXuatNL;
import Models.TaiKhoan;
import Models.ThucDon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;


public class ConnectSQL {

    private Connection cn;

    public ConnectSQL() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlcafe?useUnicode=true&characterEncoding=utf8", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kết nối thất bại !" + ex.getMessage());
        }
    }

    public ArrayList<Loai> GetLoai() {
        ArrayList<Loai> arrloai = null;
        String sql = "Select * From nhommon";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new ArrayList<Loai>();
            while (rs.next()) {
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai;
    }

    public ArrayList<Ban> GetBan(int maban) {
        ArrayList<Ban> arrBan = null;
        String sql;
        if (maban == 0) {
            sql = "Select * From ban";
        } else {
            sql = "Select * From ban Where MaBan = '" + maban + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while (rs.next()) {
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan;
    }

    public int UpdateBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '" + b.GetTenBan() + "', TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }

    public String GetMaLoai(String TenLoai) {
        String maloai = null;
        String sql = "Select MaLoai From nhommon Where TenLoai = '" + TenLoai + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maloai = rs.getString(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được mã loại !");
        }
        return maloai;
    }

    public ArrayList<ThucDon> GetThucDonByMa(String ma) {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;

        sql = "Select * From thucdon Where MaMon = '" + ma + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public ArrayList<DsOrder> GetDsOrder(int ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '" + ma + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public ChiTietHD GetDsChiTiet(String ma, int maban) {
        ChiTietHD arrDs = null;
        String sql;

        sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '" + ma + "' AND MaBan = '" + maban + "' AND hd.TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrDs = new ChiTietHD();
                arrDs.SetSoLuong(rs.getInt(1));
                arrDs.SetGia(rs.getInt(2));
                arrDs.SetMaChiTietHD(rs.getInt(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public int UpdateChiTiet(ChiTietHD ct) {
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '" + ct.GetSoLuong() + "', Gia = '" + ct.GetGia() + "' WHERE MaChiTietHD = '" + ct.GetMaChiTietHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;
    }

    public int HuyHD(HoaDon hd) {
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public int ThanhToan(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '" + hd.GetTongTien() + "', TrangThai = 1 WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public int UpDateTrangThaiBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;
    }

    public ArrayList<ThucDon> GetThucDon(String ma) {
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        if (ma == null) {
            sql = "Select * From thucdon";
        } else {
            sql = "Select * From thucdon Where MaLoai = '" + ma + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public int InsertHoaDon(HoaDon hd, String gio) {
        int insert = 0;
        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('" + hd.GetMaBan() + "', '" + gio + "', '" + hd.GetTrangThai() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public int DeleteMon(String mamon, int mahd, int maban) {
        int check = 0;
        try {
            String sql;
            sql = "Delete From chitiethd Where MaMon = '" + mamon + "' AND MaHoaDon = '" + mahd + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if (CheckDsMon(mahd, maban) == 0) {
                check = 2;
            }
        } catch (SQLException ex) {

        }
        return check;
    }

    public int CheckDsMon(int mahd, int maban) {
        String sql;
        int dem = 0;
        sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '" + maban + "' AND ct.MaHoaDon = '" + mahd + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dem++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;
    }

    public HoaDon GetHDbyMaBan(int ma) {
        String sql;
        HoaDon arrhd = null;
        sql = "Select * From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }

    public int GetMaHD(int ma) {
        String sql;
        int mahd = 0;
        sql = "Select MaHoaDon From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mahd = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;
    }

    public int UpdateHD(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE hoadon SET GiamGia = '" + hd.GetGiamGia() + "' WHERE MaHoaDon = '" + hd.GetMaHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Giảm giá không thành công !");
        }
        return update;
    }

    public int InsertChiTietHD(ChiTietHD cthd) {
        int insert = 0;
        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('" + cthd.GetMaHD() + "', '" + cthd.GetMaMon() + "', '" + cthd.GetSoLuong() + "', '" + cthd.GetGia() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !" + ex.toString());
        }
        return insert;
    }

    public boolean CheckLogin(TaiKhoan tk) {
        boolean check = false;
        String sql;
        sql = "Select * From taikhoan Where username = '" + tk.GetUsername() + "' AND password='" + tk.GetPassword() + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check;
    }

    public int LVTK(TaiKhoan tk) {
        int lvtk = 0;
        String sql;
        sql = "Select lv From taikhoan Where username = '" + tk.GetUsername() + "' AND password='" + tk.GetPassword() + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lvtk = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk;
    }

    public int InsertBan(Ban b) {
        int insert = 0;
        String sql = "Insert into ban (TenBan, TrangThai) values ('" + b.GetTenBan() + "', '" + b.GetTrangThai() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public boolean DeleteBan(ArrayList<Integer> listMaBan) {
        boolean check = false;
        try {
            String sql;
            for (int ma : listMaBan) {
                sql = "Delete From ban Where MaBan = '" + ma + "'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {

        }
        return check;
    }

    public Vector GetNhomMon() {
        Vector arrloai = null;
        String sql = "Select * From nhommon";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector();
            Loai all = new Loai(null, "Tất cả các món", "");
            arrloai.add(all);
            while (rs.next()) {
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai;
    }

    public int InsertThucDon(ThucDon td) {
        int insert = 0;
        String sql = "Insert into thucdon (TenMon, MaLoai, DonGia, DVT) values ('" + td.GetTenMon() + "', '" + td.GetMaLoai() + "', '" + td.GetDonGia() + "', '" + td.GetDVT() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public boolean DeleteThucDon(ArrayList<String> listMamon) {
        boolean check = false;
        try {
            String sql;
            for (String ma : listMamon) {
                sql = "Delete From thucdon Where MaMon = '" + ma + "'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {

        }
        return check;
    }

    public int UpdateThucDon(ThucDon td) {
        int update = 0;
        String sql = "UPDATE thucdon SET TenMon = '" + td.GetTenMon() + "', MaLoai = '" + td.GetMaLoai() + "', DonGia = '" + td.GetDonGia() + "', DVT = '" + td.GetDVT() + "' WHERE MaMon = '" + td.GetMaMon() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update món không thành công !");
        }
        return update;
    }

    public int InsertLoai(Loai b) {
        int insert = 0;
        String sql = "Insert into nhommon (TenLoai, MauSac) values ('" + b.GetTenLoai() + "', '" + b.GetMauSac() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public boolean DeleteNhom(ArrayList<String> lismanhom) {
        boolean check = false;
        try {
            String sql;
            for (String ma : lismanhom) {
                sql = "Delete From nhommon Where MaLoai = '" + ma + "'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {

        }
        return check;
    }

    public Loai GetLoaiByMa(String manhom) {
        Loai loai = null;
        String sql = "Select * From nhommon Where MaLoai = '" + manhom + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                loai = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return loai;
    }

    public int UpdateLoai(Loai b) {
        int update = 0;
        String sql = "UPDATE nhommon SET TenLoai = '" + b.GetTenLoai() + "', MauSac = '" + b.GetMauSac() + "' WHERE MaLoai = '" + b.GetMaLoai() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update Loại không thành công !");
        }
        return update;
    }

    public ArrayList<ThucDon> SearchMon(String ten) {
        ArrayList<ThucDon> arrtd = null;
        String sql;
        sql = "SELECT * FROM thucdon WHERE TenMon LIKE '" + ten + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public ArrayList<Loai> SearchLoai(String ten) {
        ArrayList<Loai> arrtd = null;
        String sql;
        sql = "SELECT * FROM nhommon WHERE TenLoai LIKE '" + ten + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Loai>();
            while (rs.next()) {
                Loai td = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public ArrayList<Ban> SearchBan(String ten) {
        ArrayList<Ban> arrtd = null;
        String sql;
        sql = "SELECT * FROM ban WHERE TenBan LIKE '" + ten + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Ban>();
            while (rs.next()) {
                Ban td = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public ArrayList<TaiKhoan> GetTaiKhoan() {
        ArrayList<TaiKhoan> arrtd = null;
        String sql;
        sql = "SELECT * FROM taikhoan WHERE lv != 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<TaiKhoan>();
            while (rs.next()) {
                TaiKhoan td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                arrtd.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public boolean DeleteTaiKhoan(ArrayList<Integer> listMaBan) {
        boolean check = false;
        try {
            String sql;
            for (int ma : listMaBan) {
                sql = "Delete From taikhoan Where id = '" + ma + "'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {

        }
        return check;
    }

    public int InserTK(TaiKhoan b) {
        int insert = 0;
        String sql = "Insert into taikhoan (username, password, lv) values ('" + b.GetUsername() + "', '" + b.GetPassword() + "', '" + b.GetLv() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);

        } catch (SQLException ex) {
        }
        return insert;
    }

    public TaiKhoan GetTaiKhoan(int id) {
        TaiKhoan td = null;
        String sql;
        sql = "SELECT * FROM taikhoan WHERE id = '" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }

    public TaiKhoan GetTaiKhoan(String name, String pass) {
        TaiKhoan td = null;
        String sql;
        sql = "SELECT * FROM taikhoan Where username = '" + name + "' AND password='" + pass + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }

    public int UpdateTK(TaiKhoan b) {
        int update = 0;
        String sql = "UPDATE taikhoan SET username = '" + b.GetUsername() + "', password = '" + b.GetPassword() + "', lv = '" + b.GetLv() + "' WHERE id = '" + b.GetID() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }

    public ArrayList<HoaDon> GetDSHD() {
        ArrayList<HoaDon> arrDs = null;
        String sql;
        sql = "Select * From hoadon Where TrangThai = 1 ORDER by GioDen DESC;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while (rs.next()) {
                HoaDon order = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<ThucDon> GetDsMonBan() {
        ArrayList<ThucDon> arrDs = null;
        String sql;
        sql = "Select TenMon, MaMon, DVT From thucdon WHERE MaMon in (Select MaMon From chitiethd) AND hoadon.TrangThai = 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon order = new ThucDon();
                order.SetTenMon(rs.getString(1));
                order.SetMaMon(rs.getString(2));
                order.SetDVT(rs.getString(3));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<ThucDon> GetChiTietMonByMa() {
        ArrayList<ThucDon> arrDs = null;
        String sql;
        sql = "SELECT TenMon, MaMon, DVT FROM thucdon where MaMon in (Select MaMon From chitiethd)";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<ThucDon>();
            while (rs.next()) {
                ThucDon order = new ThucDon();
                order.SetTenMon(rs.getString(1));
                order.SetMaMon(rs.getString(2));
                order.SetDVT(rs.getString(3));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetGiaSoLuong(String ma) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '" + ma + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {

                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetHdByDate(String d1, String d2, String m) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if (d1.equals(d2)) {
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen >= '" + d1 + "' AND ct.MaMon ='" + m + "'";
        } else {
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen BETWEEN '" + d1 + "' AND '" + d2 + "' AND ct.MaMon ='" + m + "'";
        }
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

    public ArrayList<DsOrder> GetCtHDByDate(int ma, String d1, String d2) {
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if (d1.equals(d2)) {
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '" + ma + "' AND hd.GioDen >= '" + d1 + "'";
        } else {
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '" + ma + "' AND hd.GioDen BETWEEN '" + d1 + "' AND '" + d2 + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !" + ex.toString());
        }
        return arrDs;
    }
    // sql Quản lý KHo

    public ArrayList<NguyenLieu> GetDSNguyenLieu(String ten) {
        ArrayList<NguyenLieu> data = new ArrayList<>();
        String sql;
        if (ten == null || ten.isEmpty()) {
            sql = "SELECT * FROM `nguyenlieu` WHERE Deleted=0";
        } else {
            sql = "SELECT * FROM `nguyenlieu` WHERE Ten LIKE '%" + ten + "%' AND Deleted=0;";
        }

        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                NguyenLieu nl = new NguyenLieu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
                data.add(nl);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách nguyên liệu  !" + ex.toString());
        }
        return data;
    }

    public NguyenLieu GetDetailNguyenLieu(int id) {
        NguyenLieu data = null;
        String sql = " SELECT * FROM `nguyenlieu` WHERE MaNguyenLieu=" + id;
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                data = new NguyenLieu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Không lấy được chi tiết nguyên liệu  !" + ex.toString());
        }
        return data;
    }

    public boolean UpdateNguyenLieu(NguyenLieu model) {
        String sql = "UPDATE nguyenlieu SET Ten=?, SLTonKho=?, DonVi=? WHERE MaNguyenLieu=?;";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, model.Ten);
            pst.setInt(2, model.SLTonKho);
            pst.setString(3, model.DonVi);
            pst.setInt(4, model.MaNguyenLieu);
            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Không cập nhật được nguyên liệu  !" + ex.toString());
        }

        return false;
    }

    public boolean DeleteNguyenLieu(int id) {
        String sql = "UPDATE nguyenlieu SET Deleted=1 WHERE MaNguyenLieu=?";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setInt(1, id);
            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Không cập nhật được nguyên liệu  !" + ex.toString());
        }

        return false;
    }

    public boolean AddNguyenLieu(NguyenLieu model) {
        String sql = "INSERT INTO nguyenlieu(MaNguyenLieu,Ten,SLTonKho,DonVi,Deleted) values (null,?, ?,?,0);";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, model.Ten);
            pst.setInt(2, model.SLTonKho);
            pst.setString(3, model.DonVi);
            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Không thêm  được nguyên liệu  !" + ex.toString());
        }

        return false;
    }
    // Lịch sử nhập xuất

    public ArrayList<NhapXuatNL> GetDSNhapXuatNL(String start, String end) {
        ArrayList<NhapXuatNL> data = new ArrayList<>();
        String sql = "SELECT * FROM `nhapxuatnl`  ORDER by NgayGio DESC;";
        if (start != null && end != null) {
            sql = "SELECT * FROM `nhapxuatnl` WHERE NgayGio BETWEEN '" + start + "' AND '" + end + "'  ORDER by NgayGio DESC;;";

        }

        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                NhapXuatNL nl = new NhapXuatNL(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                data.add(nl);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lịch sử nhập xuất nguyên liệu  !" + ex.toString());
        }
        return data;
    }

    public boolean AddNhapXuatNL(NhapXuatNL model) {
        String sql = "INSERT INTO nhapxuatnl( MaNhapXuatNL,MaNguyenLieu,MaTaiKhoan,Loai,SoLuong,NgayGio) VALUES (null,?,?,?,?, CURRENT_TIME);";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setInt(1, model.MaNguyenLieu);
            pst.setInt(2, model.MaTaiKhoan);
            pst.setInt(3, model.loai);
            pst.setInt(4, model.SoLuong);
            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thêm được lịch sử nhập xuất nguyên liệu  !" + ex.toString());
        }
        return false;

    }
    // tbl KhachHang
    public ArrayList<KhachHang> GetDSKhachHang( int loai){
         ArrayList<KhachHang> data= new ArrayList<>();
         String sql;
        if (loai == -1) {
            sql = "SELECT * FROM `khachhang`  WHERE Deleted=0";
        } else {
            sql = "SELECT * FROM `khachhang`  WHERE LoaiKH="+loai+" Deleted=0";
        }

        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

              KhachHang nl = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                data.add(nl);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách KhachHang  !" + ex.toString());
        }
        return data;
       
    }
    public boolean AddKhachHang(KhachHang model){
         String sql = "INSERT INTO khachhang( MaKhachHang,Ten,sdt,DiaChi,LoaiKH,Deleted) VALUES (null,? ,?,?, ?,0);";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
          pst.setString(1, model.Ten);
          pst.setString(2, model.sdt);
          pst.setString(3, model.DiaChi);
          pst.setInt(4, model.LoaiKH);
            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thêm được khách hàng  !" + ex.toString());
        }
        return false;
    }
    public KhachHang GetDetailKhachHang(int Ma){
        KhachHang data= new KhachHang();
        String sql="SELECT * FROM `khachhang` WHERE MaKhachHang=?;";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setInt(1, Ma);
          ResultSet rs= pst.executeQuery();
          if(rs.next())
            data= new KhachHang(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được chi tiết khách hàng  !" + ex.toString());
        }
        
        return data;
    }
    
    public boolean UpdateKhachHang(KhachHang model){
        String sql = "UPDATE khachhang SET Ten=?, sdt=?,DiaChi=?,LoaiKH=? WHERE MaKhachHang=?;";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);
          pst.setString(1, model.Ten);
          pst.setString(2, model.sdt);
          pst.setString(3, model.DiaChi);
          pst.setInt(4, model.LoaiKH);
          pst.setInt(5, model.MaKhachHang);
            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không sửa được khách hàng  !" + ex.toString());
        }
        return false; 
    }
    public boolean DeletedKhachHang(int ma){
         String sql = "UPDATE khachhang SET Deleted=1 WHERE MaKhachHang="+ma+";";
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql);

            int kq = pst.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xoá  được khách hàng  !" + ex.toString());
        }
        return false; 
    }

}
