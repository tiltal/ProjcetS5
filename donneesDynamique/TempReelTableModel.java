package donneesDynamique;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;




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
				return captorList.get(rowIndex).getLastValue();
			case 5:
				switch(TypeCaptor.AIRCOMPRIME){//TODO getType()
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
