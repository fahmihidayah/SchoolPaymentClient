package com.models;

import java.io.Serializable;

/**
id: 1
data_pesan: "hello world"
mahasiswas_id: 1
created_at: "2015-03-01 04:40:01"
updated_at: "2015-03-01 04:40:01"
 */
public class Pesan implements Serializable{
	private Integer id;
	private String data_pesan;
	private Integer mahasiswas_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getData_pesan() {
		return data_pesan;
	}
	public void setData_pesan(String data_pesan) {
		this.data_pesan = data_pesan;
	}
	public Integer getMahasiswas_id() {
		return mahasiswas_id;
	}
	public void setMahasiswas_id(Integer mahasiswas_id) {
		this.mahasiswas_id = mahasiswas_id;
	}
}
