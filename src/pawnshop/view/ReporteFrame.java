package pawnshop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReporteFrame extends JFrame{
	
	private static final long serialVersionUID = 1617921021502990373L;
	
	private JLabel titulo;
	private JPanel joyeria, electronicos, varios;
//	private JPanel joyeriaVentas, electronicosVentas, variosVentas;
//	private JLabel totalArt;
	
	private Container container;
	
	MainWindow mw;
	
	public ReporteFrame(MainWindow mw){
		super("REPORTE DE VENTAS");
		setSize(600,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		init(); //inicializa componentes
		setVisible(true);
		//setResizable(false);
		this.mw = mw;
	}
	
	private void init(){
		container = getContentPane();
		container.setLayout(new BorderLayout());
		container.setBackground(Color.WHITE);
		
		titulo = new JLabel("    VENTAS POR DEPARTAMENTO");
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		
		joyeria = new JPanel(new FlowLayout());
		joyeria.setBorder(BorderFactory.createTitledBorder("Joyeria"));
		joyeria.setPreferredSize(new Dimension(190,250));
		joyeria.setBackground(Color.WHITE);
		
		electronicos = new JPanel(new FlowLayout());
		electronicos.setBorder(BorderFactory.createTitledBorder("Electronicos"));
		electronicos.setPreferredSize(new Dimension(210,250));
		electronicos.setBackground(Color.WHITE);
		
		varios = new JPanel(new FlowLayout());
		varios.setBorder(BorderFactory.createTitledBorder("Varios"));
		varios.setPreferredSize(new Dimension(190,250));
		varios.setBackground(Color.WHITE);
	
		joyeria.add(new JLabel("No. Articulos: "));
		joyeria.add(new JLabel(MainWindow.num_art_joyeria.toString()));
		joyeria.add(new JLabel("         Subtotal: "));
		joyeria.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.subtotal_joyeria)));
		joyeria.add(new JLabel("              IVA: "));
		joyeria.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.joyeria_iva)));
		joyeria.add(new JLabel("  Total por Depto: "));
		joyeria.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.joyeria_total)));
		
		electronicos.add(new JLabel("No. Articulos:    "));
		electronicos.add(new JLabel(MainWindow.num_art_electronicos.toString()));
		electronicos.add(new JLabel("         Subtotal:     "));
		electronicos.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.subtotal_electronica)));
		electronicos.add(new JLabel("                IVA: "));
		electronicos.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.iva_electronica)));
		electronicos.add(new JLabel("  Total por Depto: "));
		electronicos.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.total_electronica)));
		
		varios.add(new JLabel("No. Articulos: "));
		varios.add(new JLabel(MainWindow.num_art_varios.toString()));
		varios.add(new JLabel("         Subtotal: "));
		varios.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.subtotal_varios)));
		varios.add(new JLabel("              IVA: "));
		varios.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.iva_varios)));
		varios.add(new JLabel("  Total por Depto: "));
		varios.add(new JLabel(new DecimalFormat("#.##").format(MainWindow.total_varios)));
		
		
		
		
		container.add(titulo, BorderLayout.PAGE_START);
		container.add(joyeria, BorderLayout.LINE_START);
		container.add(electronicos, BorderLayout.CENTER);
		container.add(varios, BorderLayout.LINE_END);
	}
	
	
}
