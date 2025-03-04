package view;

import model.dao.BangDiemDAO;
import model.dao.LopHoc_MonHocDAO;
import model.dao.SinhVienDAO;
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

public class BangDiemView extends JFrame implements ActionListener, ListSelectionListener {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTable table1;
    private JButton xemButton;
    private JButton thayDoiDiemSinhVienButton;
    private JPanel rootPanel;
    private JLabel ketqua;

    private Object[][] students = new Object[][]{};
    private String[] header = new String[]{"STT", "MSSV", "Họ tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Kết quả"};

    List<Lop> lopData;
    List<MonHoc> monHocData;

    public BangDiemView() {
        add(rootPanel);
        setTitle("Xem bảng điểm");
        setSize(900, 500);
        table1.setModel(new DefaultTableModel((Object[][]) students, header));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addEditBangDiemButtonListener(ActionListener listener) {
        thayDoiDiemSinhVienButton.addActionListener(listener);
    }

    public void addXemBangDiemButtonListener(ActionListener listener) {
        xemButton.addActionListener(listener);
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
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 7, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Lop");
        rootPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        rootPanel.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("MonHoc");
        rootPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        rootPanel.add(comboBox2, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        rootPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1 = new JTable();
        scrollPane1.setViewportView(table1);
        xemButton = new JButton();
        xemButton.setText("Xem");
        rootPanel.add(xemButton, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        thayDoiDiemSinhVienButton = new JButton();
        thayDoiDiemSinhVienButton.setText("ThayDoiDiemSinhVien");
        rootPanel.add(thayDoiDiemSinhVienButton, new com.intellij.uiDesigner.core.GridConstraints(2, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("%Dau:");
        rootPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ketqua = new JLabel();
        ketqua.setText("");
        rootPanel.add(ketqua, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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

    public void showLopCbb(List<Lop> lopList) {
        lopData = lopList;
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

    public void showMonCbb(List<MonHoc> monHocs) {

        monHocData = monHocs;
        Vector monCombobox = new Vector();
        monCombobox.add("--Chọn môn học--");
        for (MonHoc monHoc : monHocData) {
            monCombobox.add(monHoc.getTenMon());
        }
        DefaultComboBoxModel lopsModel = new DefaultComboBoxModel(monCombobox);
        comboBox2.setModel(lopsModel);
        comboBox2.setSelectedIndex(0);
        comboBox2.setEnabled(true);
    }

    public void xemBangDiem() {
        Object blankObject[][] = new Object[][]{};
        if (comboBox1.getSelectedIndex() != 0) {
            if (comboBox2.getSelectedIndex() != 0) {
                LopHoc_MonHoc lopHoc_monHoc = new LopHoc_MonHoc();
                int posLop, posMon;
                posLop = comboBox1.getSelectedIndex();
                posMon = comboBox2.getSelectedIndex();
                Lop lop = lopData.get(posLop - 1);
                MonHoc monHoc = monHocData.get(posMon - 1);
                lopHoc_monHoc = LopHoc_MonHocDAO.layThongTinLopHoc_MonHoc(lop.getMalop() + "-" + monHoc.getMaMon());
                if (lopHoc_monHoc == null) {
                    table1.setModel(new DefaultTableModel((Object[][]) blankObject, header));
                    return;
                }
                Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = lopHoc_monHoc.getSinhVien_hocLop_mons();
                int size = sinhVien_hocLop_mons.size();
                int soLuongDau = 0;
                students = new Object[size][8];
                int i = 0, j = 1;
                for (SinhVien_HocLop_Mon sinhVien_hocLop_mon : sinhVien_hocLop_mons) {
                    SinhVien sv = sinhVien_hocLop_mon.getSinhVien();
                    BangDiem bangDiem = sinhVien_hocLop_mon.getBangDiem();
                    students[i][1] = sv.getMssv();
                    students[i][2] = sv.getHoVaTen();
                    students[i][3] = bangDiem.getDiemGiuaKy();
                    students[i][4] = bangDiem.getDiemCuoiKy();
                    students[i][5] = bangDiem.getDiemKhac();
                    students[i][6] = bangDiem.getDiemTong();

                    if (bangDiem.getDiemTong() >= 5) {
                        students[i][7] = "Đậu";
                        soLuongDau++;
                    } else
                        students[i][7] = "Rớt";

                    students[i][0] = j;
                    i++;
                    j++;
                }
                table1.setModel(new DefaultTableModel(students, header));
                float tiLeDau = ((float) soLuongDau / size) * 100;
                ketqua.setText(Float.toString(tiLeDau));
            }

        } else
            table1.setModel(new DefaultTableModel((Object[][]) blankObject, header));

    }

    public boolean CapNhatDiemSinhVien() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1)
            return false;

        if (comboBox1.getSelectedIndex() != 0) {
            if (comboBox2.getSelectedIndex() != 0) {
                LopHoc_MonHoc lopHoc_monHoc = new LopHoc_MonHoc();
                int posLop, posMon;
                posLop = comboBox1.getSelectedIndex();
                posMon = comboBox2.getSelectedIndex();
                Lop lop = lopData.get(posLop - 1);
                MonHoc monHoc = monHocData.get(posMon - 1);
                lopHoc_monHoc = LopHoc_MonHocDAO.layThongTinLopHoc_MonHoc(lop.getMalop() + "-" + monHoc.getMaMon());
                if (lopHoc_monHoc == null) {
                    return false;
                }
                SinhVien sv = SinhVienDAO.layThongTinSinhVien(students[selectedRow][1].toString());

                BangDiem bangDiem = BangDiemDAO.layThongTinBangDiem(sv.getMssv() + "-" + lopHoc_monHoc.getMaLopHoc_MonHoc());

                String diemGiuaKy = table1.getValueAt(selectedRow, 3).toString();
                String diemCuoiKy = table1.getValueAt(selectedRow, 4).toString();
                String diemKhac = table1.getValueAt(selectedRow, 5).toString();
                String diemTong = table1.getValueAt(selectedRow, 6).toString();


                bangDiem.setDiemGiuaKy(Float.parseFloat(diemGiuaKy));
                bangDiem.setDiemCuoiKy(Float.parseFloat(diemCuoiKy));
                bangDiem.setDiemKhac(Float.parseFloat(diemKhac));
                bangDiem.setDiemTong(Float.parseFloat(diemTong));

                if (bangDiem != null) {
                    return BangDiemDAO.capNhatThongTinBangDiem(bangDiem);
                } else return false;

            } else return false;
        } else return false;

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
