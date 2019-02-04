/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package products;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Biruk
 */

public class CustModel extends AbstractTableModel {
        private String[] columnNames = {"Product", "Price"};
        private Object[][] data = null;

        public CustModel(Object[][] data) {
            this.data = data;
        }
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    }
