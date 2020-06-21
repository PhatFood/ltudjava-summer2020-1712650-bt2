package controller;

import model.csvReader;
import view.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GiaoVuMenuController {
    private GiaoVuMenu menuGiaoVu;
    public GiaoVuMenuController(GiaoVuMenu view)
    {
        this.menuGiaoVu = view;

        view.addXemLopButtonListenner(new XemLopListener());
        view.addDangXuatButtonListenner(new DangXuatListenner());
        view.addInsertCsvLopListener(new InsertCsvLopListener());
        view.addInsertCsvTKBListener(new InsertCsvTKBListener());
        view.addInsertCsvBangDiemListener(new InsertCsvBangDiemListener());
        view.addXemTKBListener(new XemTKBListener());
        view.addXemBangDiemListener(new XemBangDiemListener());

        view.addWindowListener(new java.awt.event.WindowAdapter (){
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent){
                System.exit(1);
            }
        });

    }

    public void showMenuGiaoVu()
    {
        menuGiaoVu.setVisible(true);
        menuGiaoVu.setLocationRelativeTo(null);
    }

    private class XemLopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LopView view = new LopView();
            LopController a = new LopController(view);
            a.showLopView();
        }
    }

    private class DangXuatListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Login view = new Login();
            LoginController a = new LoginController(view);
            a.showLoginView();
            menuGiaoVu.dispose();
        }
    }

    private class InsertCsvLopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String file = OpenFile();
            if (file==null)
                return;
            file = file.replace('\\', '/');

            boolean check = csvReader.docFileLop(file);
            if (check)
            {
                showMessage("Thêm lớp thành công");
            }
            else showMessage("Thêm lớp thất bại");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(menuGiaoVu, message);
    }

    private String OpenFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        FileNameExtensionFilter filter=new FileNameExtensionFilter("Csv file", "csv");
        fileChooser.setFileFilter(filter);
        int returnVal=fileChooser.showOpenDialog(null);
        File f=fileChooser.getSelectedFile();
        if(returnVal==JFileChooser.APPROVE_OPTION){
            if (f.getName().endsWith(".csv"))
            {
                return f.getAbsolutePath();
            }
            else JOptionPane.showMessageDialog(null,"Vui lòng chọn lại file hợp lệ");
        }
        else JOptionPane.showMessageDialog(null,"Vui lòng chọn lại file hợp lệ");
        return null;
    }

    private class InsertCsvTKBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String file = OpenFile();
            if (file==null)
                return;
            file = file.replace('\\', '/');

            boolean check = csvReader.docFileTKB(file);
            if (check)
            {
                showMessage("Thêm thời khóa biểu thành công");
            }
            else showMessage("Thêm thời khóa biểu thất bại");
        }
    }

    private class InsertCsvBangDiemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String file = OpenFile();
            if (file==null)
                return;
            file = file.replace('\\', '/');

            boolean check = csvReader.docFileDiem(file);
            if (check)
            {
                showMessage("Thêm bảng điểm thành công");
            }
            else showMessage("Thêm bảng điểm thất bại");
        }
    }

    private class XemTKBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TKBView view = new TKBView();
            TKBController a = new TKBController(view);
            a.showTKBView();
        }
    }

    private class XemBangDiemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BangDiemView view = new BangDiemView();
            BangDiemController a = new BangDiemController(view);
            a.showBangDiemView();
        }
    }
}
