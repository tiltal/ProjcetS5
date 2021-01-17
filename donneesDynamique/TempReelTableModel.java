package donneesDynamique;


import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;




public class TempReelTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Captor> captorList = new ArrayList<>();
	private String[] collumnNames = { "ID", "Batiment", "Etage", "Piece", "Valeur", "Unite" };
	
	public  TempReelTableModel(ArrayList<Captor> captorList) {
		super();
		
		this.captorList = captorList;
		
		
	}
	
	public Captor getCaptorAt(int row) {
		return captorList.get(row);
	}
  
	@Override
	public int getColumnCount() {
		return collumnNames.length;
	}

	@Override
	public int getRowCount() {
		return captorList.size();
	}
	
	public String getColumnName(int columnIndex) {
        return collumnNames[columnIndex];
    }
	
	public void setCaptoList(ArrayList<Captor> captorList) {
		this.captorList = captorList;
        fireTableDataChanged();
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return captorList.get(rowIndex).getId();
			case 1:
				return captorList.get(rowIndex).getBatiment();
			case 2:
				return captorList.get(rowIndex).getEtage();
			case 3:
				return captorList.get(rowIndex).getLieu();
			case 4:
				if (captorList.get(rowIndex).getLastValue() == null) {
					return null;
				}
				else {
				return captorList.get(rowIndex).getLastValue().getValue();
				}
			case 5:
				switch(captorList.get(rowIndex).getType()){
						case AIRCOMPRIME:
							return "psi";
						case EAU:
							return "m³/s";
						case ELECTRICITE:
							return "W";
						case TEMPERATURE:
							return "°c";
						default:
							return null;
				}
			default:
				return null;
		}
	}
	


	

}
