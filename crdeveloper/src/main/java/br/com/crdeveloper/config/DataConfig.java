package br.com.crdeveloper.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan( "br.com.crdeveloper.dao" )
public class DataConfig {

	@Bean
	public DataSource dataDevelopment() throws SQLException{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
		dataSource.setUrl( "jdbc:mysql://localhost:3306/crdeveloper" );
		dataSource.setUsername( "root" );
		dataSource.setUsername( "" );
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate( DataSource dataSource ){
		return new JdbcTemplate( dataSource );
	}
	
	@Bean
	public PlatformTransactionManager transactionManager( DataSource dataSource ){
		return new DataSourceTransactionManager( dataSource );
	}
}
