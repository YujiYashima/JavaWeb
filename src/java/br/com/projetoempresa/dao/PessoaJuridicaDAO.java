package br.com.projetoempresa.dao;

import br.com.projetoempresa.model.PessoaJuridica;
import br.com.projetoempresa.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PessoaJuridicaDAO implements GenericDAO {

    private Connection conn;

    //Prepara a conexao
    public PessoaJuridicaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    //Cadastrar
    public Boolean cadastrar(Object object) {

        //Cria a classe que vai obter os dados digitados pelo usuario
        PessoaJuridica pessoaJuridica = (PessoaJuridica) object;
        PreparedStatement stmt = null;

        //Cria o comando SQL para o resgistro desses dados
        String sql = "Insert into pessoajuridica(cnpjpessoajuridica, iepessoajuridica, tipopessoajuridica, idpessoa) "
                + "values (?, ?, ?, ?);";

        try {

            //Registra dado por dado, substituindo as variaveis do comando SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoaJuridica.getCnpjPessoaJuridica());
            stmt.setString(2, pessoaJuridica.getIePessoaJuridica());
            stmt.setString(3, pessoaJuridica.getTipoPessoaJuridica());
            //Obtem o codigo da PessoaDAO, apos cadastrar nela o objeto pessoaJuridica 
            stmt.setInt(4, new PessoaDAO().cadastrar(pessoaJuridica));
            stmt.execute();

            return true;

        } catch (Exception err) {

            //Retorna o possivel erro
            System.out.println("Problemas ao cadastrar usuário! Erro: " + err.getMessage());
            err.printStackTrace();

            return false;

        } finally {

            //Fecha a conexao
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

}
