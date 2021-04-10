package main.java.controller;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineModelEntity implements Serializable{
	private int id;
	private String linha;
	private String categoria;
	private String modelo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String toString() {
		return linha + " " + modelo;
	}
	
}
