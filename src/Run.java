import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;


public class Run {
    public static Scanner sc = new Scanner(System.in);
    static List<Account> listAccount = new ArrayList<>();
    static FileController fileController = new FileController();
    static List<SinhVien>sinhVienList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        do {
            System.out.println("\n\t=======* MENU *=======	");
            System.out.println("    |    1. Đăng nhập.   |");
            System.out.println("    |    2. Thoát.       |");
            System.out.println("    ----------------------");
            switch (Choose(1, 2)) {
                case 1:
                    listAccount = fileController.ReadAccountFromFile("Account.DAT");
                    String username, password;
                    System.out.print("Nhập tên tài khoản: ");
                    username = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = sc.nextLine();

                    if (KiemTraDangNhap(username, password)) {
                        Account account = new Account();
                        for (int i = 0; i < listAccount.size(); i++)
                            if (listAccount.get(i).getUserName().compareTo(username) == 0)
                                account = listAccount.get(i);
                            int Chon;
                            do {
                                System.out.println("\n\t=======* MENU *=========	");
                                System.out.println("    |     1. Thêm thông tin.|");
                                System.out.println("    |     2. Xem thông tin. |");
                                System.out.println("    |     3. Thoát.         |");
                                System.out.println("    -------------------------");
                                System.out.println("           Nhập lựa chọn:");
                                Chon = sc.nextInt();
                                switch(Chon)
                                {
                                    case 1:
                                        ThemTT();
                                        break;
                                    case 2:
                                        XemTT();
                                        break;
                                    case 3:
                                        System.out.println("Thoát.");
                                        break;
                                    default:
                                        System.out.println("Lựa chọn không hợp lệ.");
                                }
                            } while(Chon!=3);
                    }
                case 2:
                    System.out.println("Đã thoát! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.\n");
            }
        } while(true);

    }
    private static void ThemTT() throws IOException{
        SinhVien sinhVien = new SinhVien();
        sc.nextLine();
        System.out.println("Nhập mã sinh viên: ");
        String MaSV = sc.nextLine();
        sinhVien.setMaSV(MaSV);
        for(SinhVien m : sinhVienList) {
            if(m.getMaSV().equals(MaSV)) {
                System.out.println("Mã sinh viên đã tồn tại.");
                return;
            }
        }

        System.out.println("Nhập họ tên: ");
        String HoTen = sc.nextLine();
        sinhVien.setHoTen(HoTen);

        System.out.println("Nhập ngày sinh: ");
        String NgaySinh = sc.nextLine();
        sinhVien.setNgaySinh(NgaySinh);

        System.out.println("Nhập giới tính: ");
        String GioiTinh = sc.nextLine();
        sinhVien.setGioiTinh(GioiTinh);

        System.out.println("Nhập điểm trung bình: ");
        int DiemTB = sc.nextInt();
        sinhVien.setDiemTB(DiemTB);

        System.out.println("Nhập điểm rèn luyện: ");
        int DiemRL = sc.nextInt();
        sinhVien.setDiemRL(DiemRL);

    }
    private static void XemTT() {
        int check;
        do {
            System.out.println("\n\t==============================* MENU *================================	");
            System.out.println("   |       1. Sắp xếp các sinh viên theo điểm trung bình từ cao đến thấp. |");
            System.out.println("   |       2. Sắp xếp các sinh viên theo điểm rèn luyện từ thấp đến cao.  |");
            System.out.println("   |       3. Tìm sinh viên theo mã sinh viên.                            |");
            System.out.println("   |       4. Hiển thị toàn bộ sinh viên vừa nhập.                        |");
            System.out.println("   |       5. Thoát.                                                      |");
            System.out.println("   ------------------------------------------------------------------------");

            System.out.println("           Nhập lựa chọn:");
            check = sc.nextInt();
            switch(check)
            {
                case 1:
                    SxDTB();
                    break;
                case 2:
                    SxDRL();
                    break;
                case 3:
                    TimSV();
                    break;
                case 4:
                    HienThi();
                    break;
                case 5:
                    System.out.println("Thoát.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while(check!=5);
    }
    private static void SxDTB() {
        List<SinhVien> sinhViens = sinhVienList;
        Collections.sort(sinhViens, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien s1, SinhVien s2) {
                if (s1.getDiemTB() > s2.getDiemTB()) {
                    return 1;
                }
                return -1;
            }
        });
        System.out.format("%-10s %-10s %-10s %-10s %-10s %-10s", "Mã sinh viên", "Họ tên", "Ngày sinh", "Giới tính", "Điểm trung bình", "Điểm rèn luyện");
        for (int i = 0; i < sinhVienList.size(); i++) {
            System.out.format("%-10s %-10s %-10s %-10s %-10d %-10d", sinhVienList.get(i).getMaSV(), sinhVienList.get(i).getHoTen(), sinhVienList.get(i).getNgaySinh(), sinhVienList.get(i).getGioiTinh(), sinhVienList.get(i).getDiemTB(), sinhVienList.get(i).getDiemRL());

        }
    }

        private static void SxDRL() {
            List<SinhVien> sinhViens = sinhVienList;
            Collections.sort(sinhViens, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien s1, SinhVien s2) {
                    if (s1.getDiemRL() < s2.getDiemRL()) {
                        return 1;
                    }
                    return -1;
                }
            });
            System.out.format("%-10s %-10s %-10s %-10s %-10s %-10s ", "Mã sinh viên", "Họ tên", "Ngày sinh", "Giới tính", "Điểm trung bình", "Điểm rèn luyện");
            for (int i = 0; i < sinhVienList.size(); i++) {
                System.out.format("%-10s %-10s %-10s %-10s %-10d %-10d", sinhVienList.get(i).getMaSV(), sinhVienList.get(i).getHoTen(), sinhVienList.get(i).getNgaySinh(), sinhVienList.get(i).getGioiTinh(), sinhVienList.get(i).getDiemTB(), sinhVienList.get(i).getDiemRL());
            }

    }
    private static void TimSV() {

    }
    private static void HienThi() {
        System.out.format("%-10s %-10s %-10s %-10s %-10s %-10s ", "Mã sinh viên", "Họ tên", "Ngày sinh", "Giới tính", "Điểm trung bình", "Điểm rèn luyện");
        for (int i = 0; i < sinhVienList.size(); i++) {
            System.out.format("%-10s %-10s %-10s %-10s %-10d %-10d", sinhVienList.get(i).getMaSV(), sinhVienList.get(i).getHoTen(), sinhVienList.get(i).getNgaySinh(), sinhVienList.get(i).getGioiTinh(), sinhVienList.get(i).getDiemTB(), sinhVienList.get(i).getDiemRL());

        }
    }

    public static int Choose(int a, int b) {
        int choose;
        do {
            try {
                do {
                    System.out.print("\nNhập lựa chọn: ");
                    choose = Integer.parseInt(sc.nextLine());
                    if (choose < a || choose > b)
                        System.out.println("Lựa chọn không chính xác!");
                } while (choose < a || choose > b);
                return choose;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        } while (true);
    }

    public static boolean KiemTraDangNhap(String username, String password) {
        listAccount = fileController.ReadAccountFromFile("Account.DAT");
        for (int i = 0; i < listAccount.size(); i++)
            if (listAccount.get(i).getUserName().compareTo(username) == 0
                    && listAccount.get(i).getPassword().compareTo(password) == 0){

                System.out.println("Đăng nhập thành công!");
                return true;
            }
        System.out.println("Đăng nhập không thành công!");
        return false;
    }
}
