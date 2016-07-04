package org.dzf.domain.game;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "gameEntityManagerFactory", transactionManagerRef = "gameTransactionManager")
public class GameConfig {
	@Autowired
	@Qualifier("gameDataSource")
	private DataSource gameDataSource;

	@Bean
	PlatformTransactionManager gameTransactionManager() {
		return new JpaTransactionManager(gameEntityManagerFactory().getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean gameEntityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(gameDataSource);
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("org.dzf.domain.game");

		return factoryBean;
	}

}
