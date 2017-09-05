package com.basededatoscomercio.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Proveedor {


	private int codigoProveedor;
	private String nombre;
	private int telefono;
	private String 	direccion;
	private String	 contacto;
	//private ArrayList<Producto> productos;
	
	public Proveedor (){
		this.codigoProveedor = 0;
		this.nombre = "";
		this.telefono = 0;
		this.direccion = "";
		this.contacto = "";
		//ArrayList<Producto> productos = new ArrayList<Producto>();
	}

	
	public int getCodigoProveedor() {
		return codigoProveedor;
	}


	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getContacto() {
		return contacto;
	}


	public void setContacto(String contacto) {
		this.contacto = contacto;
	}


	public boolean es(int codigo){
		return this.codigoProveedor == codigo;
	}

	@Override
	public String toString() {
		return "Proveedor [codigoProveedor=" + codigoProveedor + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", contacto=" + contacto + "]";
	}

	public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into Proveedor (nombre, telefono, direccion, contacto) "
				+ " values(?,?,?,?) ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, telefono);
			conexion.getSentencia().setString(3, direccion);
			conexion.getSentencia().setString(4, contacto);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

	public void update(Proveedor proveedor){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update laboratorio "
				+ " set nombre = ?, "
				+ " telefono = ?, "
				+ " direccion = ?, "
				+ " contacto = ?, "
				+ "	where codigoProveedor = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, proveedor.getNombre());
			conexion.getSentencia().setInt(2, proveedor.getTelefono());
			conexion.getSentencia().setString(3, proveedor.getDireccion());
			conexion.getSentencia().setString(4, proveedor.getContacto());
			conexion.modificacion();
			conexion.close();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void search(int codigo){
		String sql;
		ResultSet resultados;
		Conexion conexion = new Conexion();
		sql = " Select codigoProveedor, nombre, telefono, direccion, contacto "
				+ "from Proveedor "
				+ "where Proveedor.codigoProveedor = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				setCodigoProveedor(resultados.getInt("codigoProveedor"));
				setNombre(resultados.getString("nombre"));
				setTelefono(resultados.getInt("telefono"));
				setDireccion(resultados.getString("direccion"));
				setContacto(resultados.getString("contacto"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int codigo){
		//Producto producto;
		//ResultSet resultados;
		String sql;
		Conexion conexion = new Conexion();
		//System.out.println(productos);
		sql = "delete from proveedor "
				+ "where codigoProveedor = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList <Proveedor> list(){
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		Proveedor proveedor;
		ResultSet resultados;
		String sql;
		
		Conexion conexion = new Conexion();
		sql = "Select * from proveedor";
		try {
			conexion.consulta(sql);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				proveedor = new Proveedor();
				proveedor.setCodigoProveedor(resultados.getInt("codigoProducto"));
				proveedor.setNombre(resultados.getString("nombre"));
				proveedor.setTelefono(resultados.getInt("telefono"));
				proveedor.setDireccion(resultados.getString("direccion"));
				proveedor.setContacto(resultados.getString("contacto"));
				
				proveedores.add(proveedor);
			}
			
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return proveedores;
		
		
		
	}

}

