package view;

import model.dao.LopHoc_MonHocDAO;
import model.dao.SinhVienDAO;
import model.dao.SinhVien_HocLop_MonDAO;
import model.enteties.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class LopView extends JFrame implements ActionListener, ListSelectionListener {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton xemButton;
    private JTable table1;
    private JButton xoaSinhVienButton;
    private JButton themSinhVienButton;
    private JPanel rootPanel;
    private JButton themSinhVienVaoLopNayButton;

    private Object[][] students = new Object[][]{};
    private String[] header = new String[]{"STT", "MSSV", "Họ tên", "Giới tính", "CMND"};

    List<Lop> lopsData;
    List<MonHoc> monHocsData;


    public LopView() {
        add(rootPanel);
        setTitle("Xem lớp");
        setSize(900, 500);
        table1.setModel(new DefaultTableModel((Object[][]) students, header));

        themSinhVienVaoLopNayButton.setEnabled(false);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void addXemButtonListener(ActionListener listener) {
        xemButton.addActionListener(listener);
    }

    public void addThemSinhVienLopMonListener(ActionListener listener) {
        themSinhVienVaoLopNayButton.addActionListener(listener);
    }

    public void addThemSinhVienButtonListener(ActionListener listener) {
        themSinhVienButton.addActionListener(listener);
    }

    public void updateDataLop(List<Lop> lopList) {
        lopsData = lopList;
    }

    public void addXoaSinhVienButtonListener(ActionListener listener) {
        xoaSinhVienButton.addActionListener(listener);
    }

    public void cleanTable() {
        Object blankData[][] = new Object[][]{};

        table1.setModel(new DefaultTableModel(blankData, header));
    }

    public SinhVien layThongTinSinhVienQuaTable() {
        int pos = table1.getSelectedRow();
        if (pos == -1)
            return null;
        SinhVien sv = new SinhVien();
        try {
            sv = SinhVienDAO.layThongTinSinhVien(students[pos][1].toString());
        } catch (Exception e) {
            return null;
        }
        return sv;
    }

    public void showListLop(List<Lop> lopList) {
        lopsData = lopList;
        Vector lopCombobox = new Vector();
        lopCombobox.add("--Chọn lớp--");
        for (Lop lop : lopList) {
            lopCombobox.add(lop.getMalop());
        }
        DefaultComboBoxModel lopsModel = new DefaultComboBoxModel(lopCombobox);
        comboBox1.setModel(lopsModel);
        comboBox1.setSelectedIndex(0);
        comboBox1.setEnabled(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 6, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Lop");
        rootPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        rootPanel.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("MonHoc");
        rootPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        rootPanel.add(comboBox2, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        xemButton = new JButton();
        xemButton.setText("Xem");
        rootPanel.add(xemButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        xoaSinhVienButton = new JButton();
        xoaSinhVienButton.setText("XoaSinhVien");
        rootPanel.add(xoaSinhVienButton, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        themSinhVienButton = new JButton();
        themSinhVienButton.setText("ThemSinhVien");
        rootPanel.add(themSinhVienButton, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        rootPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1 = new JTable();
        scrollPane1.setViewportView(table1);
        themSinhVienVaoLopNayButton = new JButton();
        themSinhVienVaoLopNayButton.setText("ThemSinhVienVaoLopNay");
        rootPanel.add(themSinhVienVaoLopNayButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public String layMSSVQuaDialog() {
        setAlwaysOnTop(false);
        ThemMaSoSinhVienDialog view = new ThemMaSoSinhVienDialog();
        view.setSize(400, 200);
        view.show();
        setAlwaysOnTop(true);
        if (!view.isOK) {
            return null;
        }
        String mssv = view.getMssvQuaDialog();
        return mssv;
    }

    public SinhVien laySinhVienInfoQuaDialog() {
        setAlwaysOnTop(false);
        ThemSinhVienDialog view = new ThemSinhVienDialog();
        view.setSize(500, 300);
        view.show();
        setAlwaysOnTop(true);
        if (!view.isOK) {
            return null;
        }
        SinhVien sinhVien = view.getSinhVienInforDialog();

        return sinhVien;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showMonHoc(List<MonHoc> monHocList) {
        monHocsData = monHocList;
        Vector monCombobox = new Vector();
        monCombobox.add("--Chọn môn học--");
        for (MonHoc monHoc : monHocList) {
            monCombobox.add(monHoc.getTenMon());
        }
        DefaultComboBoxModel lopsModel = new DefaultComboBoxModel(monCombobox);
        comboBox2.setModel(lopsModel);
        comboBox2.setSelectedIndex(0);
        comboBox2.setEnabled(true);
    }

    public void xemLop() {
        if (comboBox2.getSelectedIndex() != 0 && comboBox1.getSelectedIndex() != 0) {
            themSinhVienVaoLopNayButton.setEnabled(true);
        } else themSinhVienVaoLopNayButton.setEnabled(false);
        Object blankObject[][] = new Object[][]{};
        if (comboBox1.getSelectedIndex() != 0) {
            if (comboBox2.getSelectedIndex() != 0) {
                LopHoc_MonHoc lopHoc_monHoc = new LopHoc_MonHoc();
                int posLop, posMon;
                posLop = comboBox1.getSelectedIndex();
                posMon = comboBox2.getSelectedIndex();
                Lop lop = lopsData.get(posLop - 1);
                MonHoc monHoc = monHocsData.get(posMon - 1);
                lopHoc_monHoc = LopHoc_MonHocDAO.layThongTinLopHoc_MonHoc(lop.getMalop() + "-" + monHoc.getMaMon());
                if (lopHoc_monHoc == null) {
                    table1.setModel(new DefaultTableModel((Object[][]) blankObject, header));
                    return;
                }
                Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = lopHoc_monHoc.getSinhVien_hocLop_mons();
                int size = sinhVien_hocLop_mons.size();
                students = new Object[size][5];
                int i = 0, j = 1;
                for (SinhVien_HocLop_Mon sinhVien_hocLop_mon : sinhVien_hocLop_mons) {
                    SinhVien sv = sinhVien_hocLop_mon.getSinhVien();
                    students[i][1] = sv.getMssv();
                    students[i][2] = sv.getHoVaTen();
                    students[i][3] = sv.getGioiTinh();
                    students[i][4] = sv.getCmnd();
                    students[i][0] = j;
                    i++;
                    j++;
                }
                table1.setModel(new DefaultTableModel(students, header));
            } else {
                Lop lop = lopsData.get(comboBox1.getSelectedIndex() - 1);
                if (lop == null) {
                    table1.setModel(new DefaultTableModel((Object[][]) blankObject, header));
                    return;
                }
                Set<SinhVien> sinhViens = lopsData.get(comboBox1.getSelectedIndex() - 1).getSinhVienSet();

                int size = sinhViens.size();
                students = new Object[size][5];
                table1.setModel(new DefaultTableModel((Object[][]) students, header));
                int i = 0, j = 1;
                for (SinhVien sv : sinhViens) {
                    students[i][1] = sv.getMssv();
                    students[i][2] = sv.getHoVaTen();
                    students[i][3] = sv.getGioiTinh();
                    students[i][4] = sv.getCmnd();
                    students[i][0] = j;
                    i++;
                    j++;
                }
                table1.setModel(new DefaultTableModel(students, header));
            }
        } else
            table1.setModel(new DefaultTableModel((Object[][]) blankObject, header));

    }

    public LopHoc_MonHoc layLopHocMonHOc() {
        if (comboBox2.getSelectedIndex() == 0 || comboBox1.getSelectedIndex() == 0)
            return null;
        LopHoc_MonHoc lopHoc_monHoc = new LopHoc_MonHoc();
        MonHoc monHoc = monHocsData.get(comboBox2.getSelectedIndex() - 1);
        Lop lop = lopsData.get(comboBox1.getSelectedIndex() - 1);
        lopHoc_monHoc = LopHoc_MonHocDAO.layThongTinLopHoc_MonHoc(lop.getMalop() + "-" + monHoc.getMaMon());
        return lopHoc_monHoc;
    }

    public MonHoc layThongTinMonHoc() {
        if (comboBox2.getSelectedIndex() == 0)
            return null;
        return monHocsData.get(comboBox2.getSelectedIndex() - 1);
    }
}
