package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// @author Aelyo Pinto, Carlos Henrique e Jimmy Peterson

/*contém os métodos insert, update e delete.
 Esta classe poderá ser usada por qualquer classe que acesse ao banco. A vantagem dela é que não precisamos
 criar estes três métodos em cada classe que os utilizarmos, precisa apenas passar os parâmetros necessários
 para as ações com o banco de dados.
 O atributo connection, do tipo Connection, recebe através do construtor da classe uma conexão com o banco
 sempre que a classe dao for instanciada. Essa conexão recebida vem como retorno da classe ConnectionDataBase.
 */
public abstract class GenericDao {

    private Connection connection;

    protected GenericDao() {
        this.connection = ConnectionDataBase.getConnection();
    }

    protected Connection getConnection() {
        return connection;
    }

    protected void save(String insertSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt
                = getConnection().prepareStatement(insertSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
    }

    protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
        PreparedStatement pstmt
                = getConnection().prepareStatement(updateSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
    }

    protected void delete(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt
                = getConnection().prepareStatement(deleteSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
    }
}
