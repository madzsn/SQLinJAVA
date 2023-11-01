package com.fichasql;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    // Informações de conexão
    private static final String host = "localhost";
    private static final String database = "cadastro_produto";
    private static final String usuario = "root";
    private static final String senha = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
    
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"
        + host + ":3306/" + database, usuario, senha)) {
            String nome;
            int idade;
            String signo;
            String sexo;
        

            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine();

            System.out.print("Digite sua idade: ");
            idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite seu signo: ");
            signo = scanner.nextLine();

            System.out.print("Digite seu sexo(F/M): ");
            sexo = scanner.nextLine();

    
            
            
        
            String sql = "INSERT INTO alunos (nome, idade, signo, sexo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, signo);
            stmt.setString(4, sexo);

            

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno inserido com sucesso!");
            } else {
                System.out.println("Não foi possível inserir o produto.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " +
            e.getMessage());
        }
    }
}