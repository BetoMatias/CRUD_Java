/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Beto
 */
public class PessoaDAO {

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("CRUD_JavaPU");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }   
    /**
     *
     * @param pessoa
     * @return
     * @throws Exception
     */
    public Pessoa salvar(Pessoa pessoa) throws Exception{
        EntityManager entityManager = getEntityManager();
                         
        try {
            entityManager.getTransaction().begin();
            System.out.println("Salvando a pessoa.");
          if (pessoa.getId()==null) {    
                
                entityManager.persist(pessoa);
            } else {
                pessoa = entityManager.merge(pessoa);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return pessoa;
    }

    public void excluir(long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Pessoa pessoa = consultarPorId(id);
            System.out.println("Excluindo a pessoa: " + pessoa.getNome());

            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    public Pessoa consultarPorId(long id) {
        EntityManager entityManager = getEntityManager();
        Pessoa pessoa = null;
        try{
            pessoa = entityManager.find(Pessoa.class, id);
        }finally{
            entityManager.close();
        }
        return pessoa;
        }
    
}

