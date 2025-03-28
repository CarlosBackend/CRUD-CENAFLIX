package AcessoDB;
import java.sql.*;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/cenaflix";
    private static final String user = "root";
    private static final String password = "Cc!1carlos";
    Connection conn;
    
    public Connection getConexao(){
        try{
             conn = DriverManager.getConnection(url,user,password);
            return conn;
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao banco " + e.getMessage());
            return null;
        }
    }
    public void desconectar(){
        try{
            if(getConexao() != null && getConexao().isClosed()){
                getConexao().close();
            }
        }catch(SQLException ex){
            System.out.println("Erro de SQL " + ex.getMessage());
        }
    }
 }
