/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.controller;

import br.com.calculopoupanca.model.dao.ObservacaoDAO;
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
public class ControlePoupanca implements Serializable {

    /**
     * @return the daoObservacao
     */
   

    

    private String estadoTela = "";
    private Poupanca poupanca;
    private ComplementoPoupanca complementoPoupanca;
    private Plano plano;
    private Observacao observacao;
    private IdPoupanca idPoupanca;
    private PoupancaDAO<Poupanca, IdPoupanca> daoPoupanca;
    private ObservacaoDAO<Observacao, IdPoupanca> daoObservacao;
    private List<Observacao> listaObservacao = new ArrayList<>();
    
    private List<Poupanca> listaPoupanca = new ArrayList<>();
  
    
    
    @PostConstruct
    public void init(){
      
        buscar();
        listar();
    }
    
    public void mostrarConteudo(){
        System.out.println(observacao);
    }
   
    public void alterarTamanhoLetra(){
        
      
       complementoPoupanca.setPoupador(complementoPoupanca.getPoupador().toUpperCase());
    }
    
    
    
    public void calcularValorAcordo(){
        this.getComplementoPoupanca().setValorAcordo(getComplementoPoupanca().getValorBase().multiply(new BigDecimal("3")));
    }
    
    public ControlePoupanca() {
        daoPoupanca = new PoupancaDAO<>();
        daoObservacao = new ObservacaoDAO<>();
    }
    
    
    
    public void buscar(){
        setPoupanca(null);
        mudarParaBuscar();
        setListaPoupanca(getDaoPoupanca().getListaObjetos());
        setListaPoupanca(getListaPoupanca());
    }
    

    public void novo() {
        setEstadoTela("");
        setPoupanca(new Poupanca());
    }
    
    public void novoComplemento() {
        setEstadoTela("editarComplemento");
        setComplementoPoupanca(new ComplementoPoupanca());
        getPoupanca().adicionarComplementoPoupanca(getComplementoPoupanca());
    }

    public String listar() {
        return "home?faces-redirect=true";
    }

    public void salvar() {
        boolean persistiu = false;

        if (isEditar()) {
            persistiu = getDaoPoupanca().atualizar(getPoupanca());
        } else {
            persistiu = getDaoPoupanca().salvar(getPoupanca());
        }

        if (persistiu) {
            Util.mensagemInformacao(getDaoPoupanca().getMensagem());
        } else {
            Util.mensagemErro(getDaoPoupanca().getMensagem());
        }
      
        mudarParaBuscar();
        getDaoPoupanca().getEm().clear();
        novo();
        buscar();
       
        listar();
    }

    public void mudarParaEditar() {
        setEstadoTela("editar");
    }

    public void mudarParaEditarComplemento() {
        setEstadoTela("editarComplemento");
    }

    public void mudarParaBuscar() {
        setEstadoTela("buscar");
    }

    public boolean isEditar() {

        return "editar".equals(getEstadoTela());
    }

    public boolean isEditarComplemento() {

        return "editarComplemento".equals(getEstadoTela());
       
    }

    public boolean isBuscar() {

        return "buscar".equals(getEstadoTela());
    }

    public void editar(IdPoupanca idpoupanca) {
        mudarParaEditar();
        setPoupanca(getDaoPoupanca().localizarPorChaveComposta(idpoupanca));
    }
    
    public void editarComplemento(Integer index) {
       
       
     
        mudarParaEditarComplemento();
      
    
        for (ComplementoPoupanca c : getPoupanca().getListaComplementoPoupanca()) {
         if(c.getId().equals(index)){
             setComplementoPoupanca(c);
             break;
         }
            
        }
        
    }

    /**
     * @return the estadoTela
     */
    public String getEstadoTela() {
        return estadoTela;
    }

    /**
     * @param estadoTela the estadoTela to set
     */
    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }

    /**
     * @return the poupanca
     */
    public Poupanca getPoupanca() {
        return poupanca;
    }

    /**
     * @param poupanca the poupanca to set
     */
    public void setPoupanca(Poupanca poupanca) {
        this.poupanca = poupanca;
    }

    /**
     * @return the daoPoupanca
     */
    public PoupancaDAO<Poupanca, IdPoupanca> getDaoPoupanca() {
        return daoPoupanca;
    }

    /**
     * @param daoPoupanca the daoPoupanca to set
     */
    public void setDaoPoupanca(PoupancaDAO<Poupanca, IdPoupanca> daoPoupanca) {
        this.daoPoupanca = daoPoupanca;
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
     * @return the idPoupanca
     */
    public IdPoupanca getIdPoupanca() {
        return idPoupanca;
    }

    /**
     * @param idPoupanca the idPoupanca to set
     */
    public void setIdPoupanca(IdPoupanca idPoupanca) {
        this.idPoupanca = idPoupanca;
    }

    /**
     * @return the listaPoupanca
     */
    public List<Poupanca> getListaPoupanca() {
        return listaPoupanca;
    }

    /**
     * @param listaPoupanca the listaPoupanca to set
     */
    public void setListaPoupanca(List<Poupanca> listaPoupanca) {
        this.listaPoupanca = listaPoupanca;
    }

    /**
     * @return the plano
     */
    public Plano getPlano() {
        return plano;
    }

    /**
     * @param plano the plano to set
     */
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    /**
     * @return the observacao
     */
    public Observacao getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(Observacao observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the daoObservacao
     */
    public ObservacaoDAO<Observacao, IdPoupanca> getDaoObservacao() {
        return daoObservacao;
    }

    /**
     * @param daoObservacao the daoObservacao to set
     */
    public void setDaoObservacao(ObservacaoDAO<Observacao, IdPoupanca> daoObservacao) {
        this.daoObservacao = daoObservacao;
    }

    /**
     * @return the listaObservacao
     */
    public List<Observacao> getListaObservacao() {
        return listaObservacao;
    }

    /**
     * @param listaObservacao the listaObservacao to set
     */
    public void setListaObservacao(List<Observacao> listaObservacao) {
        this.listaObservacao = listaObservacao;
    }

}
