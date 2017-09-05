package com.basededatoscomercio.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Vendedor {
	private int codigoVendedor;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private int telefono;
	private String email;
	private String contraseña;
	//private ArrayList<Producto> productos;
	
	public Vendedor (){
		this.codigoVendedor = 0;
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = null;
		this.telefono = 0;
		this.email = "";
		this.contraseña = "";
		//ArrayList<Producto> productos = new ArrayList<Producto>();
	}

	
	public int getCodigoVendedor() {
		return codigoVendedor;
	}


	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public boolean es(int codigo){
		return this.codigoVendedor == codigo;
	}


	@Override
	public String toString() {
		return "Vendedor [codigoVendedor=" + codigoVendedor + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", email=" + email
				+ ", contraseña=" + contraseña + "]";
	}


	

	public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into vendedor (nombre, apellidos, fechaNacimiento, telefono, email,  contraseña) "
				+ " values(?,?,?,?,?,?,?) ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setString(2, apellidos);
			conexion.getSentencia().setDate(3, ReadTypes.cASqlDate(fechaNacimiento));
			conexion.getSentencia().setInt(4, telefono);
			conexion.getSentencia().setString(5, email);
			conexion.getSentencia().setString(6, contraseña);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Vendedor vendedor){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update vendedor "
				+ " set nombre = ?, "
				+ " apellidos = ?, "
				+ " fechaNacimiento = ?, "
				+ "	telefono = ? "
				+ "	email = ? "
				+ "	contraseña = ? "
				+ "	where codigoVendedor = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, vendedor.getNombre());
			conexion.getSentencia().setString(2, vendedor.getApellidos());
			conexion.getSentencia().setDate(3, ReadTypes.cASqlDate(vendedor.getFechaNacimiento()));
			conexion.getSentencia().setInt(4, vendedor.getTelefono());
			conexion.getSentencia().setString(5, vendedor.getEmail());
			conexion.getSentencia().setString(6, vendedor.getContraseña());
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
		sql = " Select codigoVendedor, nombre, apellidos, fechaNacimiento, telefono, email,"
				+ ""
				+ " contraseña "
				+ "from vendedor "
				+ "where vendedor.codigovendedor = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				setCodigoVendedor(resultados.getInt("codigoVendedor"));
				setNombre(resultados.getString("nombre"));
				setApellidos(resultados.getString("apellidos"));
				setFechaNacimiento(resultados.getDate("fechaNacimiento"));
				setTelefono(resultados.getInt("telefono"));
				setEmail(resultados.getString("email"));
				setContraseña(resultados.getString("contraseÃ±a"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	/* public void delete(int codigo){
		//Producto producto;
		//ResultSet resultados;
		String sql;
		Conexion conexion = new Conexion();
		//System.out.println(productos);
		sql = "delete from medicamento "
				+ "where codigoMedicamento = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	} */
	
	public ArrayList <Vendedor> list(){
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		Vendedor vendedor;
		ResultSet resultados;
		String sql;
		
		Conexion conexion = new Conexion();
		sql = "Select * from vendedor ";
		try {
			conexion.consulta(sql);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				vendedor = new Vendedor();
				vendedor.setCodigoVendedor(resultados.getInt("codigoVendedor"));
				vendedor.setNombre(resultados.getString("nombre"));
				vendedor.setApellidos(resultados.getString("apellidos"));
				vendedor.setFechaNacimiento(resultados.getDate("fechaNacimiento"));
				vendedor.setTelefono(resultados.getInt("telefono"));
				vendedor.setEmail(resultados.getString("email"));
				vendedor.setContraseña(resultados.getString("contraseÃ±a"));
				
				vendedores.add(vendedor);
			}
			
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return vendedores;
		
		
		
	}

}
