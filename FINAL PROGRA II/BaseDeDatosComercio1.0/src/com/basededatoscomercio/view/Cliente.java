package com.basededatoscomercio.view;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	
	private int codigoCliente;
	private String nombre;
	private String apellidos;
	private int NIT;
	private int telefono;
	private Date fechaNacimiento;
	//private ArrayList<Producto> productos;
	
	public Cliente (){
		this.codigoCliente = 0;
		this.nombre = "";
		this.apellidos = "";
		this.NIT = 0;
		this.telefono = 0;
		this.fechaNacimiento = null;
		//ArrayList<Producto> productos = new ArrayList<Producto>();
	}


	public int getCodigoCliente() {
		return codigoCliente;
	}



	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
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



	public int getNIT() {
		return NIT;
	}



	public void setNIT(int nIT) {
		NIT = nIT;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ",  nombre=" + nombre
				+ ", apellidos=" + apellidos + ", NIT=" + NIT + ", telefono=" + telefono + ",  fechaNacimiento=" + fechaNacimiento + "]";
	}


	public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into cliente (nombre,  apellidos, NIT, telefono,fechaNacimiento) "
				+ " values(?,?,?,?,?,?,?) ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setString(2, apellidos);
			conexion.getSentencia().setInt(3, telefono);
			conexion.getSentencia().setDate(4, ReadTypes.cASqlDate(fechaNacimiento));
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Cliente cliente){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update cliente "
				+ " set nombre = ?, "
				+ " apellidos = ?, "
				+ "	telefono = ? "
				+ "	fechaNacimiento = ? "
				+ "	where codigoCliente = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, cliente.getNombre());
			conexion.getSentencia().setString(2, cliente.getApellidos());
			conexion.getSentencia().setInt(4, cliente.getTelefono());
			conexion.getSentencia().setDate(3, ReadTypes.cASqlDate(cliente.getFechaNacimiento()));
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
		sql = " Select codigoCliente, nombre, apellidos, fechaNacimiento, telefono"
				+ "from cliente "
				+ "where cliente.codigocliente = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				setCodigoCliente(resultados.getInt("codigoCliente"));
				setNombre(resultados.getString("nombre"));
				setApellidos(resultados.getString("apellidos"));
				setFechaNacimiento(resultados.getDate("fechaNacimiento"));
				setTelefono(resultados.getInt("telefono"));
				
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
		sql = "delete from producto "
				+ "where codigoMedicamento = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	} 
	
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






