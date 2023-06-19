/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Models.TaiKhoan;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author ThangIKCU
 */
public class Run {
    public static frmMain QlCafe;
    public static frmLogIn frmlg;
    public static TaiKhoan tk;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lg();
    }
    public static void lg(){
        frmlg = new frmLogIn();
        frmlg.setVisible(true);       
    }  
    public static void QLCF(){
        QlCafe = new frmMain();
        QlCafe.setVisible(true);       
    }
    
    
    // Hàm dùng chung cho cả dự án
   
    public static void autoResizeColumns(JTable table) {
        // Lặp qua tất cả các cột trong JTable
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);

            // Đặt độ rộng của cột thành độ rộng tối thiểu cần thiết để hiển thị nội dung
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                // Nếu độ rộng vượt quá maxWidth, giới hạn độ rộng lại
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            // Đặt độ rộng của cột thành độ rộng đã tính toán
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
}
