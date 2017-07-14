package de.pathologie_hh_west.support;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by eike on 10.07.2017.
 */
@Component
public class DBSetup {
	@Value("${mysql.datasource.url}")
	private String url;
	@Value("${mysql.datasource.username}")
	private String username;
	@Value("${mysql.datasource.password}")
	private String password;
	
	@Bean
	@Primary
//	@ConfigurationProperties(value = "mysql.datasource")
	public DataSource mysqlDataSource(DataSourceProperties properties) {
		try {
			DataSource dataSource = DataSourceBuilder
					.create()
					.driverClassName(Driver.class.getName())
					.url(url)
					.username(username)
					.password(password)
					.build();
			
			dataSource.getConnection();
			return dataSource;
		} catch (CommunicationsException e) {
			return DataSourceBuilder
					.create()
					.url("jdbc:h2:mem:AZ;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
					.driverClassName("org.h2.Driver")
					.username("sa")
					.build();
		} catch (SQLException e) {
			return DataSourceBuilder
					.create()
					.url("jdbc:h2:mem:AZ;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
					.driverClassName("org.h2.Driver")
					.username("sa")
					.build();
		}
	}
}