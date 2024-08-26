package mode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    
    Connection conexao;
    
    public void conectar() throws SQLException{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/leilao", "root", "sql234");
        System.out.println("Sucesso ao conectar");   
        } catch(ClassNotFoundException e) {
            System.out.println("Falha ao conectar a classe de conexão\nerro: " + e.getMessage());
        } catch(SQLException ex){
            System.out.println("Falha ao conectar no banco\nerro: " + ex.getMessage());
            
        }
    }
    
    public void desconectar(){
        try{
            if(conexao != null && conexao.isClosed()){
                conexao.close();
                System.out.println("Desconectado com sucesso");
            } 
        } catch(SQLException e){
            System.out.println("Erro ao desconectar\nerro: " + e.getMessage());
        }
    }

     public Connection getCon() {
        return conexao;
    }
}
