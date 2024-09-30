package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: Phạm Duy Văn
 */
public class QLKhachHang {

    public static Object Max() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Object[] TB() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private ArrayList<KhachHang> dsKhachHang;
    private String fileName;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public void DocKhachHang(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String maso = data[0];
                String hoten = data[1];
                int sonhankhau = Integer.parseInt(data[2]);
                double chisocu = Double.parseDouble(data[3]);
                double chisomoi = Double.parseDouble(data[4]);
                KhachHang kh = new KhachHang(maso, hoten, sonhankhau, chisocu, chisomoi);
                dsKhachHang.add(kh);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc: " + e.getMessage());
        }
    }

    public boolean GhiHoaDon(String filename) {
        //sinh viên viết code 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (KhachHang kh : dsKhachHang) {
                bw.write(kh.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi: " + e.getMessage());
        }

        return true;
    }

    public void sapXepTheoMucTieuThu() {
        //sinh viên viết code    
        dsKhachHang.sort((kh1, kh2) -> Double.compare(kh2.getTieuThu(), kh1.getTieuThu()));
    }

    public double getTieuThuCaoNhat() {
        double max = 0;
        for (KhachHang kh : dsKhachHang) {
            double tieuThu = kh.getTieuThu();
            if (tieuThu > max) {
                max = tieuThu;
            }
        }
        return max;
    }

    public double getTieuThuThapNhat() {
        double min = 0;
        return min;
    }

    public double getTieuThuTrungBinh() {
        double tongTieuThu = 0;
        for (KhachHang kh : dsKhachHang) {
            tongTieuThu += kh.getTieuThu();
        }
        return tongTieuThu / dsKhachHang.size();        
    }

    public ArrayList<KhachHang> getDanhSachKhachHang() {
        return dsKhachHang;
    }

    public void setDanhSachKhachHang(ArrayList<KhachHang> danhSachKhachHang) {
        this.dsKhachHang = danhSachKhachHang;
    }

    // Hàm main để chạy thử
    public static void main(String[] args) {
        QLKhachHang qlkh = new QLKhachHang();

        // Đọc dữ liệu khách hàng từ file input.txt
        qlkh.DocKhachHang("input.txt");
        // Tìm số khối tiêu thụ lớn nhất
        System.out.println("Số khối nước tiêu thụ cao nhất: " + qlkh.getTieuThuCaoNhat());
        // Tìm số khối tiêu thụ trung bình
        System.out.println("Số khối nước tiêu thụ trung bình: " + qlkh.getTieuThuTrungBinh());

        // Sắp xếp danh sách theo tiêu thụ giảm dần
        qlkh.sapXepTheoMucTieuThu();

        // Ghi danh sách hóa đơn ra file output.txt
        qlkh.GhiHoaDon("output.txt");
    }
}
