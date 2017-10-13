/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;
import java.awt.Component; 
import javax.swing.JTable; 
import javax.swing.table.TableCellRenderer; 
import javax.swing.table.TableColumnModel; 



public class SizeSetter {
    public void resizeColumnWidth(JTable table) { 
        final TableColumnModel columnModel = table.getColumnModel(); 
        for (int column = 0; column < table.getColumnCount(); column++) { 
            int width = 25; 
            for (int row = 0; row < table.getRowCount(); row++) { 
                TableCellRenderer renderer = table.getCellRenderer(row, column); 
                Component comp = table.prepareRenderer(renderer, row, column); 
                width = Math.max(comp.getPreferredSize().width + 1, width); 
            } 
            width = Math.max(table.getColumnName(column).length() * 9 + 1, width); 
            if (width > 200) { 
                 width = 200; 
            } 
            columnModel.getColumn(column).setPreferredWidth(width); 
        } 
    } 
    
}
