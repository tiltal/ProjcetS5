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
		return captorList.size();
	}

	@Override
	public int getRowCount() {
		return collumnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				//TODO return the id
			case 1:
				//TODO return batiment name
			case 2:
				//TODO return Etage name
			case 3:
				//TODO return Piece name
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