package io.thirdplanet.demo_hibernate.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.jolbox.bonecp.BoneCPDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Configuration:
 *  -   annotation identifies the class
 *      as an application context configuration
 *      class
 * 
 * @ComponentScan
 * -    annotation that configures Spring IoC container
 *      to scan the packages containing our controller and service classes
 * @EnableJpaRepositories 
 * -    annotation isuesed to enable Spring Data JPA
 *      and configure the base package of our repositories
 * 
 * @EnableTransaction Management 
 * -    annotation enables the annotation drivein transaction management
 *      of Spring Framework.
 * 
 * @EnableWebMcv 
 * -    annotation imports the default configuration of Spring MVC 
    
 * @PropertySource
 * -    annotation that tells spring to import paramters
 *      from the application.properties which may be acess programmatically
 *      of the Enviroment interface that is injected by the 
 *      Spring IoC container.
 */

 /*
@Configuration
@ComponentScan(basePackages = { "io.thirdplanet.demo_hibernate.controller", "io.thirdplanet.demo_hibernate.service" })
@EnableJpaRepositories("io.thirdplanet.demo_hibernate.repository")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class ApplicationContext extends WebMvcConfigurerAdapter {
    @Resource
    private Environment env;

    
    @Bean
    public DataSource dataSource(){
        BoneCPDataSource ds = new BoneCPDataSource();
        return null ;
    }
    
}//end of class

*/

class ApplicationContext {
    
}