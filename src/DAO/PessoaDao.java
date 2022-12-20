package DAO;

import entidade.Pessoa;

import java.sql.*;
import java.util.ArrayList;

public class PessoaDao {
    private static String url = "jdbc:mysql://localhost:3306/bancoteste";
    private static String user = "developer";
    private static String password = "123456";

    public static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(url, user, password);
        return c;
    }

    public static Connection closeConnetion() throws SQLException {
        Connection c = getConnection();
        c.close();
        return c;
    }

    public static void inserirPessoa(Pessoa pessoa) throws SQLException {
        getConnection();
        PreparedStatement ps = getConnection().prepareStatement("insert into pessoas (nome, cpf, email, idade) values (?, ?, ?, ?)");
        ps.setString(1, pessoa.getNome());
        ps.setString(2, pessoa.getCpf());
        ps.setString(3, pessoa.getEmail());
        ps.setInt(4, pessoa.getIdade());
        ps.executeUpdate();
        ps.close();
        closeConnetion();
    }

    public static void excluirPessoa(String cpf) throws SQLException {
        getConnection();
        PreparedStatement ps = getConnection().prepareStatement("delete from pessoas where (cpf = ?) ");
        ps.setString(1, cpf);
        ps.executeUpdate();
        ps.close();
        closeConnetion();

    }

    public static ArrayList<Pessoa> obterTodos() throws SQLException {
        getConnection();
        ArrayList<Pessoa> list = new ArrayList<>();
        PreparedStatement ps = getConnection().prepareStatement("select * from pessoas");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Pessoa pessoa = new Pessoa(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getInt("idade"));
            list.add(pessoa);
        }
        return list;
    }

    public static ArrayList<Pessoa> updatePessoa(Pessoa p, String cpf) throws SQLException {
        getConnection();
        PreparedStatement ps = getConnection().prepareStatement("update pessoas set nome = ?, email = ?, idade = ? where (cpf = ?)");
        ps.setString(1, p.getNome());
        ps.setString(2, p.getEmail());
        ps.setInt(3, p.getIdade());
        ps.setString(4, cpf);
        ps.executeUpdate();
        ps.close();
        closeConnetion();

        return obterTodos();
    }

    public static Pessoa obterPessoa(String cpf) throws SQLException {
        Pessoa pessoa = null;
        getConnection();
        PreparedStatement ps = getConnection().prepareStatement("select * from pessoas where (cpf = ?) ");
        ps.setString(1, cpf);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            pessoa = new Pessoa(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getInt("idade"));
        }

        rs.close();
        ps.close();
        closeConnetion();

        return pessoa;
    }
}
