package pawnshop.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pawnshop.controller.ArticuloDao;
import pawnshop.controller.Varios;
import pawnshop.model.ArticuloBean;

public class VariosFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Container container;
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel modelo;
	JButton sellButton;
	MainWindow mainFrame;
	
	List<ArticuloBean> stock = getTableData();
	ArticuloDao<ArticuloBean> articuloData;
	
	public VariosFrame(MainWindow mainFrame){
		super("Departamento de Eclectronicos");
		setSize(500,315);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		init();
		setVisible(true);
		this.mainFrame = mainFrame;
	}
	
	private void init(){
		//String[] columns = {"Articulo","Marca", "Modelo"};
		container = getContentPane();
		container.setLayout(new FlowLayout());
		container.setBackground(Color.WHITE);
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setPreferredScrollableViewportSize(new Dimension(470, 200));
		table.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(table);
	
		sellButton = new JButton("Vender");
		sellButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				mainFrame.agregarFila(stock.get(row));
				articuloData.deleteArticulo(row);
				dispose();
			}
		});
		
		modelo.addColumn("Articulo");
		modelo.addColumn("Marca");
		modelo.addColumn("Modelo");
		modelo.addColumn("Departamento");
		modelo.addColumn("Precio");
		for(ArticuloBean p : getTableData()){
			modelo.insertRow(modelo.getRowCount(), new Object[] {p.getNombre(), p.getMarca(), p.getModelo(), p.getDepartamentos(), p.getPrecio()});
		}
		
		container.add(scrollPane);
		container.add(sellButton);
	}
	
	private List<ArticuloBean> getTableData(){
		articuloData = Varios.getInstance();
		List<ArticuloBean> articulos =articuloData.obtenerArticulos();
		return articulos;
	}
}
