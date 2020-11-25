package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.persistance.entities.User;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	UserService userService;

	public String generateReport(OutputStream out) throws FileNotFoundException, JRException {
//		String path = "C:/Users/abimael.hernandez/Desktop/";
//		SimpleDateFormat format = new SimpleDateFormat("ddMMYYYYHHmm");
		
		List<User> users = userService.findAll();
		File file = ResourceUtils.getFile("classpath:demo.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
		
		JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
		
//		JasperExportManager.exportReportToPdfFile(print, path+"demo_" + format.format(new Date()) + ".pdf");
		JasperExportManager.exportReportToPdfStream(print, out);

		return "Report generate";
	}
}
