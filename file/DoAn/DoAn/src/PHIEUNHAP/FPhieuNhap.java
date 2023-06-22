/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PHIEUNHAP;

/**
 *
 * @author hoang
 */
import ChonNCC.ChonNCCFrame;
import DANGNHAP.TAIKHOAN;
import doan.JDBCConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JPanel;

public class FPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form FPhieuNhap
     */
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    TAIKHOAN tk;
    public FPhieuNhap() {
        initComponents();
        KetNoiCSDL();
        Load_data_PN();
    }
    
    public FPhieuNhap(TAIKHOAN in_tk) {
        initComponents();
        KetNoiCSDL();
        Load_data_PN();
        tk = in_tk;
    }
    
    public void NhanDLVeMaNCC(String MaNCC){
        jMaNCC.setText(MaNCC);
    }
    public JPanel getJPN(){
        return jpnPN;
    }
    
    public void setMaNV(){
        jMaNV.setText(tk.getMaNV());
    }
    
    public void KetNoiCSDL(){ 
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");
        
        } catch (SQLException ex) {
            Logger.getLogger(FPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Load_data_PN(){
        try{
            ps = conn.prepareStatement("SELECT * FROM PHIEUNHAP ");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listPN.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaPhieuNhap"));
                        v1.add(rs.getDate("NgayNhap"));
                        v1.add(rs.getString("TongTienPN"));
                        v1.add(rs.getString("MaNCC"));
                        v1.add(rs.getString("MaNV"));
                  }
                    model.addRow(v1);
                   listPN.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(FPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void Load_data_PN (String MaPN){
        try{
            ps = conn.prepareStatement("SELECT * FROM PHIEUNHAP WHERE MaPhieuNhap = ?");
            ps.setString(1, MaPN);
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listPN.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaPhieuNhap"));
                        v1.add(rs.getDate("NgayNhap"));
                        v1.add(rs.getString("TongTienPN"));
                        v1.add(rs.getString("MaNCC"));
                        v1.add(rs.getString("MaNV"));
                  }
                    model.addRow(v1);
                   listPN.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(FPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void LamMoi(){
        jMaPN.setText("");
        jNgayNgap.setDate(null);
        jMaNCC.setText("");
        jMaNV.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnPN = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlabelPN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNgayNgap = new com.toedter.calendar.JDateChooser();
        jMaPN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMaNCC = new javax.swing.JTextField();
        jMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonTim = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonCN = new javax.swing.JButton();
        jButtonRS = new javax.swing.JButton();
        jButtonXem = new javax.swing.JButton();
        jButtonTinh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPN = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButtonChonMaNCC = new javax.swing.JButton();
        jButtonChonMaNV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 175, 139));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHIẾU NHẬP");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jlabelPN.setText("Mã phiếu nhập");

        jLabel2.setText("Ngày Nhập");

        jLabel3.setText("Mã NCC");

        jMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaNVActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã nhân viên");

        jButtonTim.setBackground(new java.awt.Color(230, 175, 139));
        jButtonTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        jButtonTim.setText("Tìm");
        jButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimActionPerformed(evt);
            }
        });

        jButtonThem.setBackground(new java.awt.Color(230, 175, 139));
        jButtonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-icon.png"))); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonXoa.setBackground(new java.awt.Color(230, 175, 139));
        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonCN.setBackground(new java.awt.Color(230, 175, 139));
        jButtonCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonCN.setText("Cập nhật");
        jButtonCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCNActionPerformed(evt);
            }
        });

        jButtonRS.setBackground(new java.awt.Color(230, 175, 139));
        jButtonRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButtonRS.setText("Reset");
        jButtonRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRSActionPerformed(evt);
            }
        });

        jButtonXem.setBackground(new java.awt.Color(230, 175, 139));
        jButtonXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eye.png"))); // NOI18N
        jButtonXem.setText("Xem chi tiết");
        jButtonXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXemActionPerformed(evt);
            }
        });

        jButtonTinh.setBackground(new java.awt.Color(255, 102, 51));
        jButtonTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invoice.png"))); // NOI18N
        jButtonTinh.setText("Tính tổng tiền");
        jButtonTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTinhActionPerformed(evt);
            }
        });

        listPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Ngày nhập", "Tổng tiền", "Mã nhà cung cấp", "Mã nhân viên"
            }
        ));
        listPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPN);

        jPanel2.setBackground(new java.awt.Color(230, 175, 139));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("THÔNG TIN PHIẾU NHẬP SÁCH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(230, 175, 139));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DANH SÁCH PHIẾU NHẬP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButtonChonMaNCC.setText("...");
        jButtonChonMaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonMaNCCActionPerformed(evt);
            }
        });

        jButtonChonMaNV.setText("...");
        jButtonChonMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnPNLayout = new javax.swing.GroupLayout(jpnPN);
        jpnPN.setLayout(jpnPNLayout);
        jpnPNLayout.setHorizontalGroup(
            jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnPNLayout.createSequentialGroup()
                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPNLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnPNLayout.createSequentialGroup()
                                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnPNLayout.createSequentialGroup()
                                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnPNLayout.createSequentialGroup()
                                        .addComponent(jlabelPN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnPNLayout.createSequentialGroup()
                                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnPNLayout.createSequentialGroup()
                                                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPNLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)))
                                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jNgayNgap, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jpnPNLayout.createSequentialGroup()
                                                .addComponent(jMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonChonMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpnPNLayout.createSequentialGroup()
                                                .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonChonMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                                .addGap(30, 30, 30)
                                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonXem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpnPNLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jpnPNLayout.setVerticalGroup(
            jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPNLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPNLayout.createSequentialGroup()
                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelPN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnPNLayout.createSequentialGroup()
                                .addComponent(jButtonXem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnPNLayout.createSequentialGroup()
                                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnPNLayout.createSequentialGroup()
                                        .addComponent(jNgayNgap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonChonMaNCC))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonChonMaNV))))
                        .addGap(38, 38, 38)
                        .addGroup(jpnPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jpnPNLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (jMaPN.getText().equals("")){
            sb.append("Mã phiếu nhập không được để trống!!!");
           jMaPN.setBackground(Color.red);
        } else {
             jMaPN.setBackground(Color.white);
        }
        if (sb.length() > 0){
           JOptionPane.showMessageDialog(this, sb);
           return;
        }
        try{
            PN pn = PNmodify.find(jMaPN.getText());
            if (pn != null){
          
            jMaPN.setText(pn.getMaPhieuNhap());
            jNgayNgap.setDate(pn.getNgayNhap());
            jMaNCC.setText(pn.getMaNCC());
            jMaNV.setText(pn.getMaNV());
            Load_data_PN(pn.getMaPhieuNhap());
            }
            else JOptionPane.showMessageDialog(this, "Phiếu Nhập tìm kiếm không tồn tại!");
        } catch (Exception e){
         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
      }
    }//GEN-LAST:event_jButtonTimActionPerformed

    private void jButtonXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaPN.getText().equals("")){
            sb.append("!!Mã Phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        jpnPN.removeAll();
        jpnPN.setLayout(new BorderLayout());
        jpnPN.add(new FCTPN(jMaPN.getText()).getJPN());
        jpnPN.validate();
        jpnPN.repaint();
    }//GEN-LAST:event_jButtonXemActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaPN.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa phiếu nhập không?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                PNmodify.DeletePN(jMaPN.getText());
                JOptionPane.showMessageDialog(this,"Đã xóa phiếu nhập thành công");
            }
            else{
                JOptionPane.showMessageDialog(this,"phiếu nhập chưa được xóa");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRSActionPerformed
        // TODO add your handling code here:
        LamMoi();
        Load_data_PN();
    }//GEN-LAST:event_jButtonRSActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaPN.getText().equals("")){
            sb.append("!!Mã phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            PN pn = new PN();
            pn.setMaPhieuNhap(jMaPN.getText());
            if(jNgayNgap.getDate() != null){
                java.util.Date ngn = jNgayNgap.getDate();
                java.sql.Date sqlbd = new java.sql.Date(ngn.getTime());
                pn.setNgayNhap(sqlbd);
            }
            pn.setMaNCC(jMaNCC.getText());
            pn.setMaNV(jMaNV.getText());
            PNmodify.InsertPN(pn);
            JOptionPane.showMessageDialog(this, "Đã thêm thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCNActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaPN.getText().equals("")){
            sb.append("!!Mã phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            PN pn = new PN();
            pn.setMaPhieuNhap(jMaPN.getText());
            if(jNgayNgap.getDate() != null){
                java.util.Date ngn = jNgayNgap.getDate();
                java.sql.Date sqlbd = new java.sql.Date(ngn.getTime());
                pn.setNgayNhap(sqlbd);
            }
            pn.setMaNCC(jMaNCC.getText());
            pn.setMaNV(jMaNV.getText());
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn cập nhật phiếu nhập không?", "cập nhật", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                PNmodify.UpdatePN(pn);
                JOptionPane.showMessageDialog(this,"Đã Cập nhật thành công.");
            }
            else{
                JOptionPane.showMessageDialog(this,"Phiếu nhập chưa được cập nhật");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCNActionPerformed

    private void listPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPNMouseClicked
        // TODO add your handling code here:
        try{
        LamMoi();
        int selectedIndex = listPN.getSelectedRow();
        listPN.setColumnSelectionInterval(0,4);
        jMaPN.setText(listPN.getValueAt(selectedIndex, 0).toString());
        jNgayNgap.setDate((java.util.Date) listPN.getValueAt(selectedIndex, 1));
        jMaNCC.setText(listPN.getValueAt(selectedIndex, 3).toString());
        jMaNV.setText(listPN.getValueAt(selectedIndex, 4).toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi : " + e.getMessage());
        }
    }//GEN-LAST:event_listPNMouseClicked

    private void jButtonTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTinhActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaPN.getText().equals("")){
            sb.append("!!Mã phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
           PNmodify.Tinh_TongPN(jMaPN.getText());
           JOptionPane.showMessageDialog(this, "Đã tính thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTinhActionPerformed

    private void jMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaNVActionPerformed

    private void jButtonChonMaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonMaNCCActionPerformed
        // TODO add your handling code here:
        ChonNCCFrame fncc = new ChonNCCFrame();
        fncc.setVisible(true);
        fncc.TruyenDL(this);
    }//GEN-LAST:event_jButtonChonMaNCCActionPerformed

    private void jButtonChonMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonMaNVActionPerformed
        // TODO add your handling code here:
        setMaNV();
    }//GEN-LAST:event_jButtonChonMaNVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCN;
    private javax.swing.JButton jButtonChonMaNCC;
    private javax.swing.JButton jButtonChonMaNV;
    private javax.swing.JButton jButtonRS;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTim;
    private javax.swing.JButton jButtonTinh;
    private javax.swing.JButton jButtonXem;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jMaNCC;
    private javax.swing.JTextField jMaNV;
    private javax.swing.JTextField jMaPN;
    private com.toedter.calendar.JDateChooser jNgayNgap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabelPN;
    private javax.swing.JPanel jpnPN;
    private javax.swing.JTable listPN;
    // End of variables declaration//GEN-END:variables
}
