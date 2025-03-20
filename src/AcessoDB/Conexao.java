package AcessoDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

public class Conexao {
    Connection conn;
    PreparedStatement st;
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaflix","root", "Cc!1carlos");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erro ao conectar ao banco " + ex.getMessage());
        }
        return false;
    }
    public int cadastrar(Filmes filme){
        int status = 0;
        try{
           st = conn.prepareStatement("INSERT INTO filmes (nome,datalancamento,categoria) VALUES (?,?,?)");
           st.setString(1,filme.getNome());
           st.setDate(2, filme.getDatalancamento());
           st.setString(3, filme.getCategoria());
           status = st.executeUpdate();
           return status;
        }catch(SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException e){
            
        }
    }
}

