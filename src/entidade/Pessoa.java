package entidade;

import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private String email;
    private String cpf;
    private Integer idade;
    private ArrayList<Pessoa> list = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String cpf, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade;
    }
}
