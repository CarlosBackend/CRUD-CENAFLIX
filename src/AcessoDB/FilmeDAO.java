package AcessoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class FilmeDAO {
    private Conexao conexao;
    private Connection conn;
    public FilmeDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir(Filmes filmes){
        String sql = "INSERT INTO filmes (nome,datalancamento,categoria) VALUES (?,?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery();
            stmt.setString(1, filmes.getNome());
            stmt.setDate(2, filmes.getDatalancamento());
            stmt.setString(3, filmes.getCategoria());
            stmt.execute();
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar " + e.getMessage());
        }
    }
    public void editar(Filmes filmes){
        String sql = "UPDATE filmes SET nome =?,datalancamento=?,categoria=? WHERE id =?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, filmes.getNome());
            stmt.setDate(2, filmes.getDatalancamento());
            stmt.setString(3, filmes.getCategoria());
            stmt.setInt(4, filmes.getId());
            
            int linhasAfetadas =  stmt.executeUpdate();
            if(linhasAfetadas >0){
                System.out.println("Filme atualizado com sucesso!");
            }else{
                System.out.println("Nenhum filme foi atualizado. Verifique o ID.");
            }
            stmt.close();
        }catch(SQLException e){
           e.printStackTrace();
            System.out.println("Erro ao editar Filme " + e.getMessage());
        }
    }
    public List<Filmes> consultar(){
        String sql = "SELECT * FROM filmes";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Filmes> lista = new ArrayList<>();
            while(rs.next()){
                Filmes f = new Filmes();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDatalancamento(rs.getDate("datalancamento"));
                f.setCategoria(rs.getString("categoria"));
                lista.add(f);
            }
            return lista;
        }catch(Exception ex){
            return null;
        }
    }
    public boolean  excluir(int id){
        try{
            Conexao conexao = new Conexao();
            conexao.getConexao();
            String sql = "DELETE FROM filmes WHERE id = ?";
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Filme deletado com sucesso");
            conexao.desconectar();
            return true;
        }catch(SQLException s){
            System.out.println("Erro ao deletar registro no banco de dados!" + s.getMessage());
            return false;
        }
    }
    public Filmes buscarFilme (String nome){
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            Filmes filme = new Filmes();
            rs.next();
            filme.setNome(rs.getString("nome"));
            filme.setId(rs.getInt("id"));
            filme.setDatalancamento(rs.getDate("datalancamento"));
            filme.setCategoria(rs.getString("categoria"));
            return filme;
        }catch(Exception e){
            System.out.println("erro :" +e.getMessage());
            return null;
        }
    }
}
