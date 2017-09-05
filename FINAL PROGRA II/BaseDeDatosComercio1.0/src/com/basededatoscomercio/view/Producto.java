package com.basededatoscomercio.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class Producto {

	private int codigoProducto;
	private String nombre;
	private double precio;
	private int stock;
	private String Categoria;
	private Date fechaVencimiento;
	private int codigoProveedor;
	//private ArrayList<Producto> productos;
	
	public Producto (){
		this.codigoProducto = 0;
		this.nombre = "";
		this.precio = 0.0;
		this.stock = 0;
		this.Categoria = "";
		this.fechaVencimiento = null;
		//ArrayList<Producto> productos = new ArrayList<Producto>();
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public int getCodigoProveedor() {
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
	public boolean es(int codigo){
		return this.codigoProducto == codigo;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", precio=" + precio
				+ ", stock=" + stock + ", fechaVencimiento=" + fechaVencimiento + ", Categoria="
				+ Categoria + "]";
	}

	public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into producto (nombre, precio, stock, Categoria, fechaVencimiento, codigoProveedor) "
				+ " values(?,?,?,?,?,?) ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setDouble(2, precio);
			conexion.getSentencia().setInt(3, stock);
			conexion.getSentencia().setString(4, Categoria);
			conexion.getSentencia().setDate(5, ReadTypes.cASqlDate(fechaVencimiento));
			conexion.getSentencia().setInt(6, codigoProveedor);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void update(Producto producto){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update producto "
				+ " set nombre = ?, "
				+ " precio = ?, "
				+ " stock = ?, "
				+ " Categoria = ?, "
				+ " fechaVencimiento = ?, "
				+ "	codigoProveedor = ? "
				+ "	where codigoProducto = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, producto.getNombre());
			conexion.getSentencia().setDouble(2, producto.getPrecio());
			conexion.getSentencia().setInt(3, producto.getStock());
			conexion.getSentencia().setString(4, producto.getCategoria());
			conexion.getSentencia().setDate(5, ReadTypes.cASqlDate(producto.getFechaVencimiento()));
			conexion.getSentencia().setInt(6, producto.getCodigoProducto());
			conexion.getSentencia().setInt(7, producto.getCodigoProveedor());
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
		sql = " Select codigoProducto, nombre, precio, stock, Categoria "
				+ "fechaVencimiento, codigoProveedor "
				+ "from producto "
				+ "where producto.codigoproducto = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				setCodigoProducto(resultados.getInt("codigoProducto"));
				setNombre(resultados.getString("nombre"));
				setPrecio(resultados.getDouble("precio"));
				setStock(resultados.getInt("stock"));
				setCategoria(resultados.getString("Categoria"));
				setFechaVencimiento(resultados.getDate("fechaVencimiento"));
				setCodigoProveedor(resultados.getInt("codigoProveedor"));
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
		//System.out.println(Productos);
		sql = "delete from producto "
				+ "where codigoProducto = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList <Producto> list(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto producto;
		ResultSet resultados;
		String sql;
		
		Conexion conexion = new Conexion();
		sql = "Select * from producto ";
		try {
			conexion.consulta(sql);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				producto = new Producto();
				producto.setCodigoProducto(resultados.getInt("codigoProducto"));
				producto.setNombre(resultados.getString("nombre"));
				producto.setPrecio(resultados.getDouble("precio"));
				producto.setStock(resultados.getInt("stock"));
				producto.setFechaVencimiento(resultados.getDate("fechaVencimiento"));
				producto.setCodigoProveedor(resultados.getInt("codigoProveedor"));
				
				productos.add(producto);
			}
			
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return productos;
		
		
		
	}

}
	


