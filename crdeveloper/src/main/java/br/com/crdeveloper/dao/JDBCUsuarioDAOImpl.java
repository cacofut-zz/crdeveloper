package br.com.crdeveloper.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.crdeveloper.model.Usuario;

@Repository
public class JDBCUsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario salvar(Usuario objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Usuario> listarTodos() {
		return jdbcTemplate.query("select * from usuario", new UsuarioRowMapper());
		
	}

	public List<Usuario> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario alterar(Usuario objeto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class UsuarioRowMapper implements RowMapper<Usuario>{

		public Usuario mapRow(ResultSet rs, int indice) throws SQLException {
			
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id_usuario"));
			usuario.setUsuario(rs.getString("usuario_usuario"));
			usuario.setSenha(rs.getString("senha_usuario"));
			usuario.setAtivo(rs.getBoolean("ativo_usuario"));
			
			return usuario;
		}
		
	}

}
