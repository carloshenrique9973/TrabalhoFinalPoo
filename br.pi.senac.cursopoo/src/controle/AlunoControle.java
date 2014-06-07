package controle;

import dao.AlunoDao;
import modelo.Aluno;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

// @author Aelyo Pinto, Carlos Henrique e Jimmy Peterson

/*
A classe AlunoControle será o relacionamento entre o banco de dados e a interface com o usuários,
assim, não iremos misturar na classe da interface métodos referentes ao banco de dados e a regras de negócios.
Tem um método para manipular a data. Esses métodos serão chamados pela interface
e farão a chamada aos métodos das classes dao’s para então retornar para a interface o resultado.
 */

public class AlunoControle {
    
    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }
 
    public void salvar(String nome, String endereco, String dataDeNascimento)
        throws SQLException, ParseException
    {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setDataDeNascimento(formatarData(dataDeNascimento));
 
        new AlunoDao().salvar(aluno);
    }
 
    public void alterar(long id, String nome, String endereco, String dataDeNascimento)
        throws ParseException, SQLException
    {
         
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setDataDeNascimento(formatarData(dataDeNascimento));
 
        new AlunoDao().alterar(aluno);
    }
 
    public List<Aluno> listaAlunos() {
        AlunoDao dao = new AlunoDao();
        try {
            return dao.findAlunos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Problemas ao localizar alunon" +
                e.getLocalizedMessage()
            );
        }
        return null;
    }
 
    public void excluir(long id) throws SQLException {
        new AlunoDao().excluir(id);
    }
 
    public Aluno buscaAlunoPorNome(String nome) throws SQLException {
        AlunoDao dao = new AlunoDao();
        return dao.findByName(nome);
    }
    public Aluno buscaAlunoPorId(String id) throws SQLException {
        AlunoDao dao = new AlunoDao();
        return dao.findById(id);
    }
}
