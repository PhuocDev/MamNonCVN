package com.example.mamnoncvn.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.student.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";


    public static ByteArrayInputStream studentsToExcel(List<Student> students) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            String[] HEADERs = { "Mã học sinh", "Tên học sinh", "Ngày sinh", "Giới tính",
                                "Tên PH", "SDT", "Email", "Mã lớp", "Địa chỉ", "Chiều cao", "Cân nặng",
                                "Ngày nhập học", "Ghi chú", "Trạng thái"};
            String SHEET = "Students";
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getTenHocSinh());
                row.createCell(2).setCellValue(student.getNgaySinh().toString());
                row.createCell(3).setCellValue(student.getGioiTinh());
                row.createCell(4).setCellValue(student.getTenPhuHuynh());
                row.createCell(5).setCellValue(student.getSoDienThoai());
                row.createCell(6).setCellValue(student.getEmail());
                row.createCell(7).setCellValue(student.getCvn_class().getId());
                row.createCell(8).setCellValue(student.getDiaChi());
                row.createCell(9).setCellValue(student.getChieuCao());
                row.createCell(10).setCellValue(student.getCanNang());
                row.createCell(11).setCellValue(student.getNgayNhapHoc().toString());
                row.createCell(12).setCellValue(student.getGhiChu());
                row.createCell(13).setCellValue(student.getStatus());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
    public static ByteArrayInputStream classToExcel(List<CVN_Class> cvnClasses) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            String[] HEADERs = { "Mã lớp", "Tên lớp", "Độ tuổi", "Ngày bắt đầu",
                    "Ngày kết thúc", "Học phí", "Sỉ số", "Giáo viên 1", "Giáo viên 2", "Trạng thái"};
            String SHEET = "Classes";
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (CVN_Class cvnClass : cvnClasses) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(cvnClass.getId());
                row.createCell(1).setCellValue(cvnClass.getName());
                row.createCell(2).setCellValue(cvnClass.getAge());
                row.createCell(3).setCellValue(cvnClass.getDateStarted().toString());
                row.createCell(4).setCellValue(cvnClass.getDateEnded().toString());
                row.createCell(5).setCellValue(cvnClass.getTuition());
                row.createCell(6).setCellValue(cvnClass.getTotalStudent());
                row.createCell(7).setCellValue(cvnClass.getTenGiaoVien1());
                row.createCell(8).setCellValue(cvnClass.getTenGiaoVien2());
                row.createCell(9).setCellValue(cvnClass.isStatus());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream teacherToExcel(List<GiaoVien> giaoVienList) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            String[] HEADERs = { "Mã giáo viên", "Họ và tên", "Địa chỉ", "Số điện thoại",
                    "Email", "Trạng thái"};
            String SHEET = "Teachers";
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (GiaoVien giaoVien : giaoVienList) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(giaoVien.getId());
                row.createCell(1).setCellValue(giaoVien.getHoTen());
                row.createCell(2).setCellValue(giaoVien.getDiaChi());
                row.createCell(3).setCellValue(giaoVien.getSoDienThoai());
                row.createCell(4).setCellValue(giaoVien.getEmail());
                row.createCell(5).setCellValue(giaoVien.isStatus());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
    public static ByteArrayInputStream CTHToExcel(List<ChuongTrinhHoc> chuongTrinhHocList) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            String[] HEADERs = { "Mã chương trình học", "Tên chương trình học", "Mô tả", "Ngày bắt đầu",
                    "Ngày kết thúc","Mã lớp" ,"Ngày đăng" , "Trạng thái"};
            String SHEET = "CTH";
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 1;
            for (ChuongTrinhHoc cth : chuongTrinhHocList) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(cth.getId());
                row.createCell(1).setCellValue(cth.getTenCTH());
                row.createCell(2).setCellValue(cth.getDescription());
                row.createCell(3).setCellValue(cth.getNgayBatDau().toString());
                row.createCell(4).setCellValue(cth.getNgayKetThuc().toString());
                row.createCell(5).setCellValue(cth.getMaLop());
                row.createCell(6).setCellValue(cth.getNgayDang().toString());
                row.createCell(7).setCellValue(cth.isStatus());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}