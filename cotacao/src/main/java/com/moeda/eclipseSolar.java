package com.moeda;

import java.sql.*;
import java.util.Scanner;

public class eclipseSolar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {

            String eclipse = "Anular";
            String data = "2023-10-14";

            String sql = "INSERT INTO eclipses_solares (data, tipo) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, data);
            stmt.setString(2, eclipse);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Eclipse adicionado com sucesso!");
            } else {
                System.out.println("Erro ao inserir eclipse.");
            }

          } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " +
            e.getMessage());
        }
    }
}
