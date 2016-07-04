package org.dzf.domain.school;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "schoolEntityManagerFactory", transactionManagerRef = "schoolTransactionManager")
public class SchoolConfig {
	@Autowired
	@Qualifier("schoolDataSource")
	private DataSource schoolDataSource;

	@Bean
	@Primary
	PlatformTransactionManager schoolTransactionManager() {
		return new JpaTransactionManager(schoolEntityManagerFactory().getObject());
	}

	@Bean
	@Primary
	LocalContainerEntityManagerFactoryBean schoolEntityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(schoolDataSource);
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("org.dzf.domain.school");

		return factoryBean;
	}

}
