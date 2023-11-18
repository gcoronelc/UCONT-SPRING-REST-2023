package pe.edu.ucontinental.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.ucontinental.app.bean.Cliente;

@Service
public class EurekaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getCantCuentas() {
		String sql = "select count(*) from cuenta";
		int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
		return rowCount;
	}

	public List<Map<String, Object>> getMovimientos(String cuenta) {
		String sql = "select int_movinumero nromov, dtt_movifecha fecha, ";
		sql += "chr_tipocodigo tipo, dec_moviimporte importe ";
		sql += "from movimiento where chr_cuencodigo = ?";
		List<Map<String, Object>> lista = jdbcTemplate.queryForList(sql, cuenta);
		return lista;
	}
	
	public List<Cliente> getClientes(){
		String sql = "select chr_cliecodigo codigo, vch_cliepaterno paterno, vch_cliematerno materno, ";
		sql += "vch_clienombre nombre, chr_cliedni dni, vch_clieciudad ciudad, vch_cliedireccion direccion, ";
		sql += "vch_clietelefono telefono, vch_clieemail email ";
		sql += "from cliente ";
		List<Cliente> lista = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Cliente.class) );
		return lista;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	public Cliente crearCliente(Cliente bean) {
		// Actualizar contador
		String sql = "update contador set int_contitem = int_contitem + 1 ";
		sql += "where vch_conttabla = 'Cliente' ";
		int filas = jdbcTemplate.update(sql);
		if (filas == 0) {
		throw new RuntimeException("El contador de la tabla CLIENTE no existe.");
		}
		// Leer datos para la generación del codigo
		sql = "select int_contitem, int_contlongitud from contador ";
		sql += "where vch_conttabla = 'Cliente' ";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		int cont = Integer.parseInt(map.get("int_contitem").toString());
		int size = Integer.parseInt(map.get("int_contlongitud").toString());
		// Generar el nuevo código
		String formato = "%0" + size + "d";
		String codigo = String.format(formato, cont);
		// Insertar el nuevo cliente
		sql = "insert into cliente(chr_cliecodigo, vch_cliepaterno, "
		+ "vch_cliematerno, vch_clienombre, chr_cliedni, "
		+ "vch_clieciudad, vch_cliedireccion, vch_clietelefono,"
		+ "vch_clieemail) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { codigo, bean.getPaterno(), bean.getMaterno(),
		bean.getNombre(), bean.getDni(), bean.getCiudad(),
		bean.getDireccion(), bean.getTelefono(),
		bean.getEmail() };
		jdbcTemplate.update(sql, args);
		// Retornar el codigo
		bean.setCodigo(codigo);
		return bean;
	}

}
