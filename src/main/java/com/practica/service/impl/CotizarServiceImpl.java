/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service.impl;

import com.practica.service.CotizarService;
import com.practica.domain.Cotizar;
import com.practica.dao.CotizarDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author esteb
 */
@Service

public class CotizarServiceImpl implements CotizarService {

    @Autowired
    private CotizarDao cotizarDao;

    @Autowired
    public CotizarServiceImpl(CotizarDao cotizarDao) {
        this.cotizarDao = cotizarDao;
    }

    @Override
    @Transactional
    public List<Cotizar> getCotizars() {

        return cotizarDao.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Cotizar getCotizar(Cotizar cotizar) {
        return cotizarDao.findById(cotizar.getNombre_cliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cotizar cotizar) {
        cotizarDao.save(cotizar);
    }

    @Override
    @Transactional
    public void delete(Cotizar cotizar) {
        cotizarDao.delete(cotizar);
    }

}
