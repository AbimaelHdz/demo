package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	JdbcTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE USER IF EXISTS");
		template.execute("CREATE TABLE USER (id int primary key auto_increment, name VARCHAR(10), email varchar(70), registrerDate datetime, estatus varchar(50), history varchar(100))");
		
		template.execute("insert into user values (null,'Juan', 'juan@email.com', current_date, 'ACTIVO', '0 año, 0 meses, 0 dias')");
		template.execute("insert into user values (null,'Carlos', 'carlos@email.com', '2020-09-04', 'INACTIVO', '0 año, 2 meses, 15 dias')");
		template.execute("insert into user values (null,'María', 'maria@email.com', '2019-05-20', 'SUSPENDIDO', '1 año, 5 meses, 30 dias')");
		template.execute("insert into user values (null,'Juan', 'juan@email.com', current_date, 'ACTIVO', '0 año, 0 meses, 0 dias')");
		template.execute("insert into user values (null,'Carlos', 'carlos@email.com', '2020-09-04', 'INACTIVO', '0 año, 2 meses, 15 dias')");
		template.execute("insert into user values (null,'María', 'maria@email.com', '2019-05-20', 'SUSPENDIDO', '1 año, 5 meses, 30 dias')");
		template.execute("insert into user values (null,'Juan', 'juan@email.com', current_date, 'ACTIVO', '0 año, 0 meses, 0 dias')");
		template.execute("insert into user values (null,'Carlos', 'carlos@email.com', '2020-09-04', 'INACTIVO', '0 año, 2 meses, 15 dias')");
		template.execute("insert into user values (null,'María', 'maria@email.com', '2019-05-20', 'SUSPENDIDO', '1 año, 5 meses, 30 dias')");
		template.execute("insert into user values (null,'Juan', 'juan@email.com', current_date, 'ACTIVO', '0 año, 0 meses, 0 dias')");
		template.execute("insert into user values (null,'Carlos', 'carlos@email.com', '2020-09-04', 'INACTIVO', '0 año, 2 meses, 15 dias')");
		template.execute("insert into user values (null,'María', 'maria@email.com', '2019-05-20', 'SUSPENDIDO', '1 año, 5 meses, 30 dias')");
	}

}
