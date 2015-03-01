package com.models;

import java.io.Serializable;

/**
 {
data: {
id: 1
nim: "0984343"
nama: "samsul andi"
alamat: "malang"
telepon: "0341322324"
created_at: "2015-02-28 06:22:53"
updated_at: "2015-03-01 04:01:36"
}-
}
 */
public class MahasiswaUser implements Serializable{
	private Integer id;
	private String nim;
	private String nama;
	private String alamat;
	private String telepon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getTelepon() {
		return telepon;
	}
	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}
	
	
}
