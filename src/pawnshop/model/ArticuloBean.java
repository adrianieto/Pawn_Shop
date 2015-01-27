package pawnshop.model;


public class ArticuloBean {
	
	private String nombre;
	private String marca;
	private String modelo;
	private String precio;
	private String image;
	private String departamentos;

	public ArticuloBean(){}
	
	public ArticuloBean(String nombre, String marca, String modelo,
			String precio, String image,String departamentos) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.image = image;
		this.departamentos = departamentos;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(String departamentos) {
		this.departamentos = departamentos;
	}
	
	
}
