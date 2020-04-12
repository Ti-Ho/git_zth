package gui;
import charactor.Hero;
import jdbc.HeroDAO;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HeroTableModel extends AbstractTableModel {
    String[] columnNames = new String[] {"id", "name", "hp", "damage"};
    public List<Hero> heros = new HeroDAO().list();
    @Override
    public int getRowCount() {
        return heros.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hero h = heros.get(rowIndex);
        if (0 == columnIndex)
            return h.id;
        if (1 == columnIndex)
            return h.name;
        if (2 == columnIndex)
            return h.hp;
        if (3 == columnIndex)
            return h.damage;
        return null;
    }
}
