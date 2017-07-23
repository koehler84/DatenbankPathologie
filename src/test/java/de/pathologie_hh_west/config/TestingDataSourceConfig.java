package de.pathologie_hh_west.config;

import de.pathologie_hh_west.support.SpringConfig;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Profile("test")
@Configuration
@Import(SpringConfig.class)
public class TestingDataSourceConfig {
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setType(H2)
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.addScript("schema.sql")
				.addScripts("user_data.sql", "country_data.sql")
				.build();
	}
}
