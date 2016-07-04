package org.dzf;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//https://github.com/spring-projects/spring-data-examples/tree/master/jpa/multiple-datasources
@Configuration
public class DataConfiguration {
	
	@Bean(name="schoolDataSource")  
	@Primary
    @ConfigurationProperties(prefix="datasource.school")
    public DataSource primaryDataSource() {  
        System.out.println("-------------------- schoolDataSource init ---------------------");  
        return DataSourceBuilder.create().build();  
    }
	
	@Bean(name="gameDataSource")
    @ConfigurationProperties(prefix="datasource.game")
    public DataSource gameDataSource() {  
        System.out.println("-------------------- gameDataSource init ---------------------");  
        return DataSourceBuilder.create().build();  
    }
}
