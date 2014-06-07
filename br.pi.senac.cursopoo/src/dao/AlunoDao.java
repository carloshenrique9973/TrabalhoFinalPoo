package dao;

import modelo.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// @author Aelyo Pinto, Carlos Henrique e Jimmy Peterson

/* classe AlunoDao, onde terão os métodos mais específicos da classe
 Foi usado herança nesta classe, herdando os métodos da classe GenericDao.
 Os métodos salvar(), alterar() e excluir() criam o SQL que será executado no banco uma chamada ao
 método da classe GenericDao, passando para ele o SQL e os demais parâmetros.
 Os métodos salvar(), alterar() e excluir(), serão os métodos acessados pela classe AlunoControle
 para manipulação com o banco.
 Tem mais dois métodos, um que retorna através de um select uma lista com todos os alunos
 e um que realizara um select pela coluna nome da tabela alunos do banco de dados.
 Podem ser criadas mais consultas, mas para este tutorial vamos utilizar apenas estes dois.
 */
public class AlunoDao extends GenericDao {

    public void salvar(Aluno aluno) throws SQLException {
        String insert = "INSERT INTO aluno(nome, dataDeNascimento, endereco ) VALUES(?,?,?)";
        save(insert, aluno.getNome(), aluno.getDataDeNascimento(), aluno.getEndereco());
    }

    public void alterar(Aluno aluno) throws SQLException {
        String update = "UPDATE aluno "
                + "SET nome = ?, dataDeNascimento = ?, endereco = ?  "
                + "WHERE id = ?";
        update(update, aluno.getId(), aluno.getNome(), aluno.getDataDeNascimento(), aluno.getEndereco());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM aluno WHERE id = ?";
        delete(delete, id);
    }

    public List<Aluno> findAlunos() throws SQLException {
        List<Aluno> alunos = new ArrayList<Aluno>();

        String select = "SELECT * FROM aluno";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setId(rs.getLong("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setDataDeNascimento(rs.getDate("dataDeNascimento"));
            aluno.setEndereco(rs.getString("endereco"));
            alunos.add(aluno);
        }

        rs.close();
        stmt.close();

        return alunos;
    }

    public Aluno findByName(String nome) throws SQLException {
        String select = "SELECT * FROM aluno WHERE nome = ?";
        Aluno aluno = null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            aluno = new Aluno();
            aluno.setId(rs.getLong("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setDataDeNascimento(rs.getDate("dataDeNascimento"));
            aluno.setEndereco(rs.getString("endereco"));
        }

        rs.close();
        stmt.close();
        return aluno;
    }
    public Aluno findById(String id) throws SQLException {
        String select = "SELECT * FROM aluno WHERE id = ?";
        Aluno aluno = null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            aluno = new Aluno();
            aluno.setId(rs.getLong("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setDataDeNascimento(rs.getDate("dataDeNascimento"));
            aluno.setEndereco(rs.getString("endereco"));
        }

        rs.close();
        stmt.close();
        return aluno;
    }
}
