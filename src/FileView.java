import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileView {
        String filename = "View.DAT";
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;
        Scanner scanner;

        public void OpenFile() {
            try {
                fileWriter = new FileWriter(filename, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                printWriter = new PrintWriter(bufferedWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void CloseFile() {
            try {
                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void OpenRead() {
            try {
                scanner = new Scanner(Paths.get(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void GhiFile(SinhVien sinhvien) {

            OpenFile();
            printWriter.println(sinhvien.getMaSV() + "|" + sinhvien.getHoTen() + "|" + sinhvien.getNgaySinh() + "|" + sinhvien.getGioiTinh() + "|" + sinhvien.getDiemTB() + "|" + sinhvien.getDiemRL());

            CloseFile();
        }
        public void GhiFile2(List<SinhVien> sinhViens) {
            try {
                fileWriter = new FileWriter(filename);
                bufferedWriter = new BufferedWriter(fileWriter);
                printWriter = new PrintWriter(bufferedWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (SinhVien sinhvien:sinhViens) {
                printWriter.println(sinhvien.getMaSV() + "|" + sinhvien.getHoTen() + "|" + sinhvien.getNgaySinh() + "|" + sinhvien.getGioiTinh() + "|" + sinhvien.getDiemTB() + "|" + sinhvien.getDiemRL());
            }
            CloseFile();
        }

        public SinhVien Tach(String data) {
            String[] datas = data.split("\\|");
            SinhVien sinhVien = new SinhVien(datas[0], datas[1], datas[2],
                    Integer.parseInt(datas[3]), Integer.parseInt(datas[4]));
            return sinhVien;
        }

        public List<SinhVien> ReadSV() {
            OpenRead();
            List<SinhVien> sinhViens = new ArrayList<>();
            while (scanner.hasNextLine())
            {
                String str = scanner.nextLine();
                SinhVien sinhVien = Tach(str);
                sinhViens.add(sinhVien);
            }
            scanner.close();
            return sinhViens;
        }

    }
