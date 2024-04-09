package com.practica;

import java.util.Locale;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    /* Los siguientes métodos son para incorporar el tema de internacionalización en el proyecto */

 /* localeResolver se utiliza para crear una sesión de cambio de idioma*/
    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    /* localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    //Bean para poder acceder a los Messages.properties en código...
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/carrito/**", "/categorias/**", "/reportes/**",
                        "/login/**", "/js/**", "/webjars/**","/categorias/listado","/Cotizar/Cotizar"
                , "/Cotizar/servicio", "/Cotizar/completado", "/Cotizar/enviar"
                , "/Cotizar/guardar","/Cotizar/completado","/listado/{idCategoria}","/categorias/listado/{idCategoria}","/carrusel/{idProducto}"
                ,"/menu","/carrusel","index","/menu/carrusel/1")
                .permitAll()
                .requestMatchers(
                        "/adminProducto/nuevo", "/adminProducto/guardar","/adminProducto/listado",
                        "/adminProducto/modifica/**", "/adminProducto/eliminar/**",
                        
                        "/adminCategoria/nuevo", "/adminCategoria/guardar",
                        "/adminCategoria/modifica/**", "/adminCategoria/eliminar/**",
                        
                        "/adminUsuario/nuevo", "/adminUsuario/guardar","/adminUsuario/listado",
                        "/adminUsuario/modifica/**", "/adminUsuario/eliminar/**","/adminUsuario/guardarIf/",
                        
                        
                        "/reportes/**",  "/adminProducto/listado"
                        ,  "/adminUsuario/listado",  "/adminCategoria/listado","/facturar/carrito",
                        "/categorias/listado",
                        "/Cotizar/completado","/categorias/listado","Cotizar/servicio"
                , "/Cotizar/servicio", "/Cotizar/completado", "/Cotizar/enviar"
                , "/Cotizar/guardar"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/producto/listado",
                        "/categorias/listado",
                        "/usuario/listado"
                ).hasAnyRole("ADMIN", "VENDEDOR")
                .requestMatchers("/facturar/carrito","/categorias/listado","/Cotizar/completado")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

  
 @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("juan")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
                .username("rebeca")
                .password("{noop}456")
                .roles("USER", "VENDEDOR")
                .build();
        UserDetails user = User.builder()
                .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, sales, admin);
    }
   
}
