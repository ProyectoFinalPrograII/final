package com.basededatoscomercio.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basededatoscomercio.view.Producto;
import com.basededatoscomercio.view.Venta;

public class Detalles {
	//private int codigoDetalles;
	private double precio;
	private int 	codigoVenta;
	private int codigoProducto;
	private int	 stock;
	//private ArrayList<Producto> productos;
	
	public Detalles (){
		//this.codigoDetalles=0;
		this.precio = 0;
		this.codigoVenta = 0;
		this.codigoProducto = 0;
		this.stock = 0;
		//ArrayList<Producto> productos = new ArrayList<Producto>();
	}

	//public int getCodigoDetalles() {
		//return codigoDetalles;
	//}

	//public void setCodigoDetalles(int codigoDetalles) {
		//this.codigoDetalles = codigoDetalles;
	//}

	public double getPrecioUnidad() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public  double precio(int codigo)            
	{
		String sql;
		Conexion conexion = new Conexion();
		sql = "Insert into detalles (precio)"
				+ " values(?)";
		
		Producto producto;
		producto = new Producto();
		producto.search(codigo);
		precio=  producto.getPrecio();
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setDouble(1, precio);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return precio;
	}
	
	public double stock(int stockProductos) {
		String sql;
		Conexion conexion = new Conexion();
		sql = "Insert into detalles (stock)"
				+ " values(?)";
		
		stock=  stockProductos;
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, stock);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return stock;
		
	}
	
	
	/*public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into detalles (precioUnidad, stock) "
				+ " values(?,?,?) ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setInt(2, telefono);
			conexion.getSentencia().setString(3, direccion);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}*/

	/*public void update(Detalles detalles){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update detalles "
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
	} */
	
	public void search(int codigo){
		String sql;
		ResultSet resultados;
		Conexion conexion = new Conexion();
		sql = " Select  codigoVenta, codigoProducto, stock, precio"
				+ "from detalles ";
				//+ "where detalles.codigoLetalles = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				setCodigoVenta(resultados.getInt("codigoVenta"));
				setCodigoProducto(resultados.getInt("codigoProducto"));
				setStock(resultados.getInt("stock"));
				setPrecio(resultados.getDouble("precio"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	/*public void delete(int codigo){
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
	}*/
	
	public ArrayList <Detalles> list(){
		ArrayList<Detalles> detalless = new ArrayList<Detalles>();
		Detalles detalles;
		ResultSet resultados;
		String sql;
		
		Conexion conexion = new Conexion();
		sql = "Select * from detalles";
		try {
			conexion.consulta(sql);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				detalles = new Detalles();
				detalles.setCodigoVenta(resultados.getInt("codigoVenta"));
				detalles.setCodigoProducto(resultados.getInt("codigoProducto"));
				detalles.setStock(resultados.getInt("stock"));
				detalles.setPrecio(resultados.getDouble("precio"));
				
				detalless.add(detalles);
			}
			
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		return detalless;
		
		
		
	}


}
