package org.jmresler.fbi.nibrs.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.jmresler.fbi.nibrs",
        entityManagerFactoryRef = "nibrsdbEntityManagerFactory",
        transactionManagerRef = "nibrsdbTransactionManager"
)
public class NibrsJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean nibrsdbEntityManagerFactory(
            @Qualifier("nibrsdbDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("org.jmresler.fbi.nibrs")
                .build();
    }

    @Bean
    public PlatformTransactionManager nibrsdbTransactionManager(
            @Qualifier("metadbEntityManagerFactory") LocalContainerEntityManagerFactoryBean bcasmtdbEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(bcasmtdbEntityManagerFactory.getObject()));
    }
}
