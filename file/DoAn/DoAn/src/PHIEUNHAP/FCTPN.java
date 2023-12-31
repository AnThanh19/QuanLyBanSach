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
import ChonSach.SachFrame;
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
public class FCTPN extends javax.swing.JFrame {

    /**
     * Creates new form FCTPN
     */
    String MaPN;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public FCTPN() {
        initComponents();
        KetNoiCSDL();
        Load_data_CTPN();
    }
    public FCTPN(String in_MaPN) {
        initComponents();
        KetNoiCSDL();
        Load_data_CTPN(in_MaPN);
        MaPN = in_MaPN;
        jMaPN.setText(MaPN);
    }
    public JPanel getJPN(){
        return jpnCTPN;
    }
    
    public void NhanDLMaSach(String MaSach){
        jMaSach.setText(MaSach);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnCTPN = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonTroLai = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMaSach = new javax.swing.JTextField();
        jSoLuong = new javax.swing.JSpinner();
        jGiaNhap = new javax.swing.JTextField();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonCN = new javax.swing.JButton();
        jButtonRS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCTPN = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jMaPN = new javax.swing.JLabel();
        jBtChonMaSach = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 175, 139));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ CHI TIẾT PHIẾU NHẬP");

        jButtonTroLai.setBackground(new java.awt.Color(255, 102, 51));
        jButtonTroLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        jButtonTroLai.setText("Trở lại");
        jButtonTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTroLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonTroLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã phiếu nhập");

        jLabel3.setText("Mã sách");

        jLabel4.setText("Số lượng");

        jLabel5.setText("Giá nhập");

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
        jButtonCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
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

        listCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Mã sách", "Số lượng", "Giá nhập", "Thành Tiền"
            }
        ));
        listCTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCTPNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listCTPN);

        jPanel2.setBackground(new java.awt.Color(230, 175, 139));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("THÔNG TIN CHI TIẾT PHIẾU NHẬP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(230, 175, 139));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DANH SÁCH CHI TIẾT PHIẾU NHẬP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtChonMaSach.setText("...");
        jBtChonMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtChonMaSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnCTPNLayout = new javax.swing.GroupLayout(jpnCTPN);
        jpnCTPN.setLayout(jpnCTPNLayout);
        jpnCTPNLayout.setHorizontalGroup(
            jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnCTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCTPNLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnCTPNLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCTPNLayout.createSequentialGroup()
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRS, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnCTPNLayout.createSequentialGroup()
                        .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCTPNLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnCTPNLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtChonMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jpnCTPNLayout.setVerticalGroup(
            jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCTPNLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnCTPNLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtChonMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnCTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(jpnCTPNLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnCTPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCNActionPerformed
        // TODO add your handling code here:
        StringBuilder sb1 = new StringBuilder();
        if(jMaPN.getText().equals("") ){
            sb1.append("!!Mã phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        StringBuilder sb2 = new StringBuilder();
        if(jMaSach.getText().equals("")){
            sb2.append("!!Mã sách không được để trống!!");
            jMaSach.setBackground(Color.red);
        }
        else{
            jMaSach.setBackground(Color.white);
        }
        if(sb1.length() > 0 || sb2.length() > 0){
            JOptionPane.showMessageDialog(this, sb1 + "\n" + sb2);
            return;
        }
        if((int)jSoLuong.getValue() < 0){
            JOptionPane.showMessageDialog(this, "Số lượng không được âm");
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn cập nhật?", "Cập nhật", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){ 
                CTPN ct = new CTPN();
                ct.setMaPhieuNhap(jMaPN.getText());
                ct.setMaSach(jMaSach.getText());
                ct.setSoLuong((int)jSoLuong.getValue());
                ct.setGiaNhap(Float.parseFloat(jGiaNhap.getText()));
                CTPNmodify.UpdateCTPN(ct);
                JOptionPane.showMessageDialog(this, "Đã cập nhật thành công.");
            }
            else JOptionPane.showMessageDialog(this, "Chưa cập nhật.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCNActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb1 = new StringBuilder();
        if(jMaPN.getText().equals("") ){
            sb1.append("!!Mã phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        StringBuilder sb2 = new StringBuilder();
        if(jMaSach.getText().equals("")){
            sb2.append("!!Mã sách không được để trống!!");
            jMaSach.setBackground(Color.red);
        }
        else{
            jMaSach.setBackground(Color.white);
        }
        if(sb1.length() > 0 || sb2.length() > 0){
            JOptionPane.showMessageDialog(this, sb1 + "\n" + sb2);
            return;
        }
        if((int)jSoLuong.getValue() < 0){
            JOptionPane.showMessageDialog(this, "Số lượng không được âm");
            return;
        }
        try{
            CTPN ct = new CTPN();
            ct.setMaPhieuNhap(jMaPN.getText());
            ct.setMaSach(jMaSach.getText());
            ct.setSoLuong((int)jSoLuong.getValue());
            ct.setGiaNhap(Float.parseFloat(jGiaNhap.getText()));
            CTPNmodify.InsertCTPN(ct);
            JOptionPane.showMessageDialog(this, "Đã thêm thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb1 = new StringBuilder();
        if(jMaPN.getText().equals("") ){
            sb1.append("!!Mã phiếu nhập không được để trống!!");
            jMaPN.setBackground(Color.red);
        }
        else{
            jMaPN.setBackground(Color.white);
        }
        StringBuilder sb2 = new StringBuilder();
        if(jMaSach.getText().equals("")){
            sb2.append("!!Mã sách không được để trống!!");
            jMaSach.setBackground(Color.red);
        }
        else{
            jMaSach.setBackground(Color.white);
        }
        if(sb1.length() > 0 || sb2.length() > 0){
            JOptionPane.showMessageDialog(this, sb1 + "\n" + sb2);
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                CTPNmodify.DeleteCTPN(jMaPN.getText(), jMaSach.getText());
                JOptionPane.showMessageDialog(this, "Đã xóa chi tiết phiếu nhập thành công.");
            }
            else JOptionPane.showMessageDialog(this, "Chưa xóa chi tiết phiếu nhập.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRSActionPerformed
        // TODO add your handling code here:
        LamMoi();
        Load_data_CTPN(MaPN);
    }//GEN-LAST:event_jButtonRSActionPerformed

    private void jButtonTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTroLaiActionPerformed
        // TODO add your handling code here:
        jpnCTPN.removeAll();
        jpnCTPN.setLayout(new BorderLayout());
        jpnCTPN.add(new FPhieuNhap().getJPN());
        jpnCTPN.validate();
        jpnCTPN.repaint();
    }//GEN-LAST:event_jButtonTroLaiActionPerformed

    private void listCTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCTPNMouseClicked
        // TODO add your handling code here:
        LamMoi();
        int selectedIndex = listCTPN.getSelectedRow();
        listCTPN.setColumnSelectionInterval(0,3);
        jMaPN.setText(listCTPN.getValueAt(selectedIndex, 0).toString());
        jMaSach.setText(listCTPN.getValueAt(selectedIndex, 1).toString());
        jSoLuong.setValue(Integer.parseInt(listCTPN.getValueAt(selectedIndex, 2).toString()));
        jGiaNhap.setText(listCTPN.getValueAt(selectedIndex, 3).toString());
    }//GEN-LAST:event_listCTPNMouseClicked

    private void jBtChonMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtChonMaSachActionPerformed
        // TODO add your handling code here:
        SachFrame sf = new SachFrame();
        sf.setVisible(true);
        sf.TruyenDL(this, "ctpn");
    }//GEN-LAST:event_jBtChonMaSachActionPerformed

    
    public void KetNoiCSDL(){ 
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FCTPN.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");
        
        } catch (SQLException ex) {
            Logger.getLogger(FCTPN.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Load_data_CTPN(){
        try{
            ps = conn.prepareStatement("SELECT * FROM CTPHIEUNHAP");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listCTPN.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaPhieuNhap"));
                        v1.add(rs.getString("MaSach"));
                        v1.add(rs.getInt("SoLuong"));
                        v1.add(rs.getString("GiaNhap"));
                        v1.add(rs.getFloat("ThanhTien"));
                  }
                    model.addRow(v1);
                   listCTPN.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(FCTPN.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void Load_data_CTPN(String in_MaPN){
        try{
            ps = conn.prepareStatement("SELECT * FROM CTPHIEUNHAP WHERE MaPhieuNhap = ?");
            ps.setString(1, in_MaPN);
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listCTPN.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaPhieuNhap"));
                        v1.add(rs.getString("MaSach"));
                        v1.add(rs.getInt("SoLuong"));
                        v1.add(rs.getString("GiaNhap"));
                        v1.add(rs.getFloat("ThanhTien"));
                  }
                    model.addRow(v1);
                   listCTPN.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(FCTPN.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void LamMoi(){
        jMaSach.setText("");
        jSoLuong.setValue(0);
        jGiaNhap.setText("");
    }
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
            java.util.logging.Logger.getLogger(FCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCTPN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtChonMaSach;
    private javax.swing.JButton jButtonCN;
    private javax.swing.JButton jButtonRS;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTroLai;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JTextField jGiaNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jMaPN;
    private javax.swing.JTextField jMaSach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSoLuong;
    private javax.swing.JPanel jpnCTPN;
    private javax.swing.JTable listCTPN;
    // End of variables declaration//GEN-END:variables
}
