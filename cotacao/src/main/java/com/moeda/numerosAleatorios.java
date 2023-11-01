package com.moeda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class numerosAleatorios {
    public static void main(String[] args) {
        Random rand = new Random();

        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {

            int numero = rand.nextInt(100) + 1;

            String sql = "INSERT INTO numeros_aleatorios (numero) VALUES (?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, numero);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Número Aleatório adicionado com sucesso!");
            } else {
                System.out.println("Erro ao inserir Número Aleatório.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
        }
    }
}
