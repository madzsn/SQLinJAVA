package com.moeda;

import java.sql.*;

public class feriadosNacionais {
    public static void main(String[] args) {
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {

            String feriado = "Tiradentes";
            String data = "21 de Abril";
            String descricao = "A data remete ao dia da morte do mineiro Joaquim José da Silva Xavier, que ocorreu em 21 de abril de 1792. Ele foi um dos participantes da Inconfidência Mineira, conspiração da elite mineira contra Portugal.";

            String sql = "INSERT INTO feriados_nacionais  (feriado, data, descricao) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, feriado);
            stmt.setString(2, data);
            stmt.setString(3, descricao);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Feriado adicionado com sucesso!");
            } else {
                System.out.println("Erro ao inserir feriado.");
            } 
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
        }
    }
}
