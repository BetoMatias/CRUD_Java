/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_java;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Beto
 */
public class PessoaDAOTeste {

    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Sawachika Eri");
        Calendar data = new GregorianCalendar();
        data.set(Calendar.YEAR, 2002);
        data.set(Calendar.MONTH, 02);
        data.set(Calendar.DAY_OF_MONTH, 28);
        pessoa.setDataNascimento(data.getTime());
        pessoa.setEmail("sawachika.eri@schoolrumble.com");

        PessoaDAO dao = new PessoaDAO();
        System.out.println("Salvanda a pessoa: " + pessoa.getNome());
        pessoa = dao.salvar(pessoa);

        pessoa.setNome("Sawachika Kenji");
        pessoa = dao.salvar(pessoa);
        System.out.println("Alterando a pessoa: " + pessoa.getNome());

        Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());

        System.out.println("Consultando: " + pessoa2.getNome());

        System.out.println("Excluindo a pessoa " + pessoa.getId());
        dao.excluir(pessoa.getId());
    }
}
