package pawnshop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import pawnshop.model.ArticuloBean;

/**
 * 
 * A simple program to manage sells in a pawn shop, this 
 * program has been writen with academic propurses.
 * 
 * @author Adrian Nieto <adrianieto@outlook.com>
 * 
 *
 */
public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = -4221303625134866133L;
	
	private Container container;
	private JPanel menuPanel, ventasPanel, totalesPanel;
	private JButton joyeria, electronicos, varios, cierre;
	private JLabel title, subtotales, totales, totalesIVA;
	private JLabel totalesLbl, subtotalesLbl, totalesIVALbl;
	private ImageIcon joyasIcon, electronicosIcon, variosIcon, titlebg;
	private JTable ventasTable;
	private JScrollPane scrollPane;
	
	private List<ArticuloBean> lista_ventas = new ArrayList<ArticuloBean>();
	
	MainWindow self = this;
	
	public DefaultTableModel modelo;
	
	Double suma =  0.0;
	Double sumaIVA = 0.0;
	Double sumaTotales = 0.0;

	public static Integer num_art_joyeria=0, num_art_electronicos=0, num_art_varios=0;
	public static Double subtotal_joyeria=0.0, joyeria_iva=0.0, joyeria_total=0.0;
	public static  Double subtotal_electronica=0.0, iva_electronica=0.0, total_electronica=0.0;
	public static Double subtotal_varios=0.0, iva_varios=0.0, total_varios=0.0;
	
	/**
	 * Constructor de la clase
	 * 
	 * 
	 *
	 */
	public MainWindow(){
		super("GOLD & SILVER PAWN SHOP");
		setSize(690,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init(); //inicializa componenres
		setVisible(true);
		setResizable(false);
	}
	
	//metodo de inicializacion de compinentes
	private void init(){

		container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.BLACK);
		titlebg = new ImageIcon("recursos/pawn_logo.jpg");
		title = new JLabel();
		title.setIcon(titlebg);
		
		
		
		modelo = new DefaultTableModel();
		ventasTable = new JTable(modelo);
		ventasTable.setPreferredScrollableViewportSize(new Dimension(488, 200));
		ventasTable.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(ventasTable);
		
		

		subtotales = new JLabel("0.00");
		subtotales.setFont(new Font("Arial", Font.BOLD, 20));
		subtotalesLbl = new JLabel("    Subtotal: $ ");
		subtotalesLbl.setFont(new Font("Arial", Font.BOLD, 20));
		totalesIVA = new JLabel("0.00");
		totalesIVA.setFont(new Font("Arial", Font.BOLD, 20));
		totalesIVALbl = new JLabel("            IVA: $ ");
		totalesIVALbl.setFont(new Font("Arial", Font.BOLD, 20));
		totales = new JLabel("0.00");
		totales.setFont(new Font("Arial", Font.BOLD, 35));
		totales.setForeground(Color.BLUE);
		totalesLbl = new JLabel("Total: $");
		totalesLbl.setFont(new Font("Arial", Font.BOLD, 35));
		totalesLbl.setForeground(Color.BLUE);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.LIGHT_GRAY);
		menuPanel.setBorder(BorderFactory.createTitledBorder("Departamentos"));
		
		ventasPanel = new JPanel(new FlowLayout());
		ventasPanel.setBackground(Color.WHITE);
		
		totalesPanel = new JPanel(new GridBagLayout());
		totalesPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		totalesPanel.setAlignmentX(RIGHT_ALIGNMENT);
		totalesPanel.setPreferredSize(new Dimension(320, 130));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		totalesPanel.add(subtotalesLbl, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		totalesPanel.add(subtotales, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		totalesPanel.add(totalesIVALbl,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.ipady=10;
		totalesPanel.add(totalesIVA,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		totalesPanel.add(totalesLbl,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		totalesPanel.add(totales,c);
		//totalesPanel.add(totalesLbl);
		
		joyeria = new JButton("Joyeria");
		joyeria.setFocusPainted(false);
		joyeria.setVerticalTextPosition(SwingConstants.BOTTOM);
		joyeria.setHorizontalTextPosition(SwingConstants.CENTER);
		joyeria.setBackground(Color.WHITE);
		joyasIcon = new ImageIcon("recursos/joyas.jpg");
		joyeria.setIcon(joyasIcon);
		joyeria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoyasFrame(self);
				
			}
		});
		
		electronicos = new JButton("Electronicos");
		electronicos.setVerticalTextPosition(SwingConstants.BOTTOM);
		electronicos.setHorizontalTextPosition(SwingConstants.CENTER);
		electronicos.setBackground(Color.WHITE);
		electronicosIcon = new ImageIcon("recursos/electronicos.jpg");
		electronicos.setIcon(electronicosIcon);
		electronicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ElectronicosFrame(self);
				
			}
		});
		
		varios = new JButton("Varios");
		varios.setVerticalTextPosition(SwingConstants.BOTTOM);
		varios.setHorizontalTextPosition(SwingConstants.CENTER);
		varios.setBackground(Color.WHITE);
		variosIcon = new ImageIcon("recursos/varios.jpg");
		varios.setIcon(variosIcon);
		varios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VariosFrame(self);
				
			}
		});
		
		
		modelo.addColumn("Articulo");
		modelo.addColumn("Marca");
		modelo.addColumn("Modelo");
		modelo.addColumn("Departamento");
		modelo.addColumn("Precio");

		menuPanel.add(joyeria);
		menuPanel.add(Box.createVerticalStrut(10));
		menuPanel.add(electronicos);
		menuPanel.add(Box.createVerticalStrut(10));
		menuPanel.add(varios);
		
		cierre = new JButton("Cierre de Caja");
		cierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reporte();
				new ReporteFrame(self);
			}
		});
		
		
		ventasPanel.setBorder(BorderFactory.createTitledBorder("Ventas"));
		ventasPanel.add(scrollPane);
		ventasPanel.add(cierre);
		ventasPanel.add(Box.createHorizontalStrut(40));
		ventasPanel.add(totalesPanel);
//		menuPanel.setOpaque(false);
		container.add(title, BorderLayout.PAGE_START);
		container.add(ventasPanel, BorderLayout.CENTER);
		container.add(menuPanel, BorderLayout.LINE_START);
		
		
		
	}
	
//	public List<ArticuloBean> getTableData(){
//		ArticuloDao<ArticuloBean> articuloData = new Electronicos();
//		List<ArticuloBean> articulos =articuloData.obtenerArticulos();
//		return articulos;
//	}

	
	public void agregarFila(ArticuloBean articulo){
		lista_ventas.add(articulo);
		modelo.insertRow(modelo.getRowCount(), new Object[] {articulo.getNombre(), 
															articulo.getMarca(), 
															articulo.getModelo(), 
															articulo.getDepartamentos(), 
															articulo.getPrecio()});
		
		subtotales.setText(sumarSubtotales(articulo));
		totalesIVA.setText(sumarIVA(articulo));
		totales.setText(sumarTotales(articulo));
		
	}
	/**
	 * 
	 * @param ventas
	 * @return
	 */
	private String sumarIVA(ArticuloBean ventas){
		sumaIVA += Double.parseDouble(ventas.getPrecio())-(Double.parseDouble(ventas.getPrecio())/1.16);
		return new DecimalFormat("#.##").format(sumaIVA); 
	}
	
	private String sumarSubtotales(ArticuloBean ventas){	
		suma += (Double.parseDouble(ventas.getPrecio())/1.16);
		return new DecimalFormat("#.##").format(suma); 
	}
	
	private String sumarTotales(ArticuloBean ventas){	
		sumaTotales += Double.parseDouble(ventas.getPrecio());
		return new DecimalFormat("#.##").format(sumaTotales); 
	}

	public List<ArticuloBean> getLista_ventas() {
		return lista_ventas;
	}

	public void setLista_ventas(List<ArticuloBean> lista_ventas) {
		this.lista_ventas = lista_ventas;
	}
	
private void reporte(){
		
		//recorrido de la lista de ventas para contablilizar
		//los articulos vendidos
		for(ArticuloBean a : lista_ventas){
			if(a.getDepartamentos() == "Joyeria"){
				num_art_joyeria += 1;
				subtotal_joyeria = subtotal_joyeria + Double.parseDouble(a.getPrecio())/1.16;
				joyeria_iva  = joyeria_iva +  Double.parseDouble(a.getPrecio())- (Double.parseDouble(a.getPrecio())/1.16); 
				joyeria_total= joyeria_total+Double.parseDouble(a.getPrecio());
			}else if(a.getDepartamentos() == "Electronicos"){
				num_art_electronicos++;
				subtotal_electronica = subtotal_electronica + Double.parseDouble(a.getPrecio())/1.16;
				iva_electronica  = iva_electronica + Double.parseDouble(a.getPrecio()) - (Double.parseDouble(a.getPrecio())/1.16); 
				total_electronica = total_electronica+Double.parseDouble(a.getPrecio());
				//sub
			}else if(a.getDepartamentos() == "Varios"){
				num_art_varios++;
				subtotal_varios = subtotal_varios + Double.parseDouble(a.getPrecio())/1.16;
				iva_varios = iva_varios +Double.parseDouble(a.getPrecio()) - (Double.parseDouble(a.getPrecio())/1.16); 
				total_varios= total_varios+Double.parseDouble(a.getPrecio());
			}
			
		}
		
}
	
}
