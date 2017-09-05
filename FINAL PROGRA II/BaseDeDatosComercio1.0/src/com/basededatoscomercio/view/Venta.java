package com.basededatoscomercio.view;

import java.util.Date;

import com.basededatoscomercio.view.Cliente;
import com.basededatoscomercio.view.Detalles;
import com.basededatoscomercio.view.Vendedor;

public class Venta {
	
	private int codigoVenta;
	private Date fechaVenta;
	private int codigoVendedor;
	private int codigoCliente;
	private double precioTotal;
	
	public Venta (){
		this.codigoVenta=0;
		this.fechaVenta = null;
		this.codigoVendedor = 0;
		this.codigoCliente = 0;
		this.precioTotal = 0.0;
		//ArrayList<Producto> productos = new ArrayList<producto>();
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double precioTotal(){
		Vendedor vendedor;
		vendedor = new Vendedor();
		Cliente cliente;
		cliente = new Cliente();
		Detalles detalles;
		detalles = new Detalles();
		return precioTotal = (detalles.getStock()*detalles.getPrecioUnidad());	
	}
	public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into venta (codigoVenta, fechaVenta, codigoVendedor, codigoCliente, precioTotal) "
				+ " values(?,?,?,?,?) ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoVenta);
			conexion.getSentencia().setDate(2, ReadTypes.cASqlDate(fechaVenta));
			conexion.getSentencia().setInt(3, codigoVendedor);
			conexion.getSentencia().setInt(4, codigoCliente);
			conexion.getSentencia().setDouble(5, precioTotal);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Venta venta){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update venta "
				+ " fechaVenta = ?, "
				+ " codigoVendedor = ?, "
				+ "	codigoCliente = ? "
				+ "	precioTotal = ? "
				+ "	where codigoVenta = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setDate(1, ReadTypes.cASqlDate(venta.getFechaVenta()));
			conexion.getSentencia().setInt(2, venta.getCodigoVendedor());
			conexion.getSentencia().setInt(3, venta.getCodigoCliente());
			conexion.getSentencia().setDouble(4, venta.getPrecioTotal());
			conexion.modificacion();
			conexion.close();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

