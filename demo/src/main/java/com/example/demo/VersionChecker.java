package com.example.demo;

import org.springframework.core.SpringVersion;

import com.example.demo.persistance.enums.Estatus;

public class VersionChecker {
	public static void main(String [] args)
    {
        System.out.println("version: " + SpringVersion.getVersion() + Estatus.ACTIVO);
        
    }

}
