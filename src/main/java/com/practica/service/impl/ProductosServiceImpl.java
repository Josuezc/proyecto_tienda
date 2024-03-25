
package com.practica.service.impl;



import com.practica.dao.ProductosDao;
import com.practica.domain.Productos;
import com.practica.service.productosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
    public class ProductosServiceImpl implements productosService {
    
    @Autowired
    private ProductosDao productosDao;
 @Autowired
    public ProductosServiceImpl(ProductosDao ProductosDao) {
        this.productosDao = productosDao;
    }
  @Override
@Transactional
public List<Productos> getProductos() {
    
        return productosDao.findAll();
    
}
   @Override
    @Transactional()
    public Productos getProducto(Productos productos) {
        return productosDao.findById(productos.getId_producto()).orElse(null);
    }
 
    
    @Override
    @Transactional
    public void save(Productos productos) {
        productosDao.save(productos);
    }

    @Override
    @Transactional
    public void delete(Productos productos) {
        productosDao.delete(productos);
    }
    
    

 
    
}
