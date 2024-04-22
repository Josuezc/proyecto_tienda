package com.practica;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    /* Los siguientes métodos son para hacer uso de Internacionalización */
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
        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
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
                ,"/menu","/carrusel","index","/menu/carrusel/1","/menu/ubicacion","/menu/","/", "/index", "/errores/**",
                        "/carrito/**", "/**","/login/","/login/index",
                        "/registro/**", "/js/**", "/webjars/**")
                .permitAll()
                .requestMatchers(
                        
                        
                        "/", "/index", "/errores/**",
                        "/carrito/**", "/categorias/**", "/reportes/**",
                        "/login/**", "/js/**", "/webjars/**","/categorias/listado","/Cotizar/Cotizar"
                , "/Cotizar/servicio", "/Cotizar/completado", "/Cotizar/enviar"
                , "/Cotizar/guardar","/Cotizar/completado","/listado/{idCategoria}","/categorias/listado/{idCategoria}","/carrusel/{idProducto}"
                ,"/menu","/carrusel","index","/menu/carrusel/1","/menu/ubicacion","/menu/","/", "/index", "/errores/**",
                        "/carrito/**", 
                        "/registro/**", "/js/**", "/webjars/**",
                        
                        
                        
                        
                        
                        
                        
                        
                        
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

  
  
   @Autowired
   private UserDetailsService userDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build)
            throws Exception {
        build
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
   
}
