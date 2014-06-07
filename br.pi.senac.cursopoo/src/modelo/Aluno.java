/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Date;

// @author Aelyo Pinto, Carlos Henrique e Jimmy Peterson

public class Aluno {
    
    /* A classe aluno terá os atributos conforme os campos da tabela Alunos.
    Foi gerado os métodos getters e setters.
    Ela foi criada no pacote modelo, esse modelo não é o mesmo Model do padrão MVC
    é um pacote onde se costuma colocar as classes de entidades.
    */
    
    private Long id;
    private String nome;
    private String endereco;
    private Date dataDeNascimento;
    //gere os métodos getters and setters

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the dataDeNascimento
     */
    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     * @param dataDeNascimento the dataDeNascimento to set
     */
    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    

}
