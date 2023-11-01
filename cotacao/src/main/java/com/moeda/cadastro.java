package com.moeda;

import java.sql.*;
import java.util.Scanner;

public class cadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario,
                senha)) {

            String nome;
            String email;
            int telefone;

            System.out.print("Insira seu nome: ");
            nome = scanner.nextLine();

            System.out.print("Insira seu e-mail: ");
            email = scanner.nextLine();

            System.out.print("Insira seu numero de telefone: ");
            telefone = scanner.nextInt();

            String sql = "INSERT INTO cadastro_usuario (nome, email, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setInt(3, telefone);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cadastro adicionado com sucesso!");
            } else {
                System.out.println("Erro ao inserir cadastro.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
        }

    }
}
