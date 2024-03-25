
package com.practica.service.impl;

import com.practica.dao.CategoriasDao;
import com.practica.domain.Categorias;
import com.practica.service.CategoriasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
    public class CategoriasServiceImpl implements CategoriasService {
    
    @Autowired
    private CategoriasDao categoriasDao;
 
  @Override
@Transactional
public List<Categorias> getCategorias() {
    
        return categoriasDao.findAll();
    
}
    @Override
    @Transactional(readOnly = true)
    public Categorias getCategoria(Categorias categoria) {
        return categoriasDao.findById(categoria.getId_categoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categorias categoria) {
        categoriasDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categorias categoria) {
        categoriasDao.delete(categoria);
    }
}



