import DAO.PessoaDao;
import entidade.Pessoa;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        System.out.println(PessoaDao.obterPessoa("652345985").toString());

    }

}
