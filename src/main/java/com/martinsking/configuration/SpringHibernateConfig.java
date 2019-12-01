package com.martinsking.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import java.util.Properties;

//import org.springframework.context.annotation.ComponentScan;
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate.properties" })
//@ComponentScan(basePackages = {"com.martinsking"})
public class SpringHibernateConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("${jdbc.driverClassName}");
        driverManagerDataSource.setUrl("${jdbc.url}");
        return driverManagerDataSource;
    }

    @Bean
    public AnnotationSessionFactoryBean sessionFactory() {
        AnnotationSessionFactoryBean annotationSessionFactoryBean = new AnnotationSessionFactoryBean();
        annotationSessionFactoryBean.setDataSource(dataSource());
        annotationSessionFactoryBean.setAnnotatedClasses(new Class[]{com.martinsking.dto.RecordDto.class});
        Properties hibernateProps = new Properties();
        hibernateProps.put("hibernate.dialext", "${hibernate.dialect}");
        hibernateProps.put("hibernate.show_sql", "${hibernate.show_sql}");
        annotationSessionFactoryBean.setHibernateProperties(hibernateProps);

        return annotationSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory((SessionFactory) sessionFactory());
        return hibernateTransactionManager;
    }
}
