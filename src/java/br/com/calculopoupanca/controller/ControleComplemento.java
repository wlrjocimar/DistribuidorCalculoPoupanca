/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.controller;

import br.com.calculopoupanca.model.dao.ComplementoDAO;
import br.com.calculopoupanca.model.dao.ObservacaoDAO;
import br.com.calculopoupanca.model.dao.PlanoDAO;
import br.com.calculopoupanca.model.dao.PoupancaDAO;
import endidades.ComplementoPoupanca;
import endidades.IdPoupanca;
import endidades.Observacao;
import endidades.Plano;
import endidades.Poupanca;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import util.Util;

/**
 *
 * @author f5078775
 */
@ManagedBean
@ViewScoped
public class ControleComplemento implements Serializable {

    /**
     * @return the daoObservacao
     */
   

    


    private ComplementoPoupanca complementoPoupanca;
   
    private List<ComplementoPoupanca> listaComplemento = new ArrayList<>();
     private ComplementoDAO<ComplementoPoupanca, IdPoupanca> daoComplementoPoupanca;

       
       
       
    public ControleComplemento() {
   daoComplementoPoupanca = new ComplementoDAO<>();
    }

    /**
     * @return the complementoPoupanca
     */
    public ComplementoPoupanca getComplementoPoupanca() {
        return complementoPoupanca;
    }

    /**
     * @param complementoPoupanca the complementoPoupanca to set
     */
    public void setComplementoPoupanca(ComplementoPoupanca complementoPoupanca) {
        this.complementoPoupanca = complementoPoupanca;
    }

    /**
     * @return the listaComplemento
     */
    public List<ComplementoPoupanca> getListaComplemento() {
        return listaComplemento;
    }

    /**
     * @param listaComplemento the listaComplemento to set
     */
    public void setListaComplemento(List<ComplementoPoupanca> listaComplemento) {
        this.listaComplemento = listaComplemento;
    }

    /**
     * @return the daoComplementoPoupanca
     */
    public ComplementoDAO<ComplementoPoupanca, IdPoupanca> getDaoComplementoPoupanca() {
        return daoComplementoPoupanca;
    }

    /**
     * @param daoComplementoPoupanca the daoComplementoPoupanca to set
     */
    public void setDaoComplementoPoupanca(ComplementoDAO<ComplementoPoupanca, IdPoupanca> daoComplementoPoupanca) {
        this.daoComplementoPoupanca = daoComplementoPoupanca;
    }
  
  
    
    
   
    
    
    
    
   
}