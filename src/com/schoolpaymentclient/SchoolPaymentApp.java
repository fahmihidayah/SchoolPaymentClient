package com.schoolpaymentclient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;

import com.framework.file_handler.FileHandler;
import com.models.Constantas;
import com.models.MahasiswaUser;

import android.app.Application;

public class SchoolPaymentApp extends Application implements Constantas{
	
	private static SchoolPaymentApp instance;
	
	public MahasiswaUser mahasiswaUser;
	
	public static SchoolPaymentApp getInstance(){
		return instance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		try {
			mahasiswaUser = (MahasiswaUser) FileHandler.loadDataFromFile(getApplicationContext(), MAHASISWA_USER);
		} catch (StreamCorruptedException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		
	}

}
