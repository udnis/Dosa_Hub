package com.food.dosa;

import com.food.dosa.Ingredient;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	
	JdbcTemplate jdbc;
	
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		this.jdbc=jdbcTemplate;
	}
	@Override
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub
		
		return jdbc.query(
				"select id, name, type from Ingredient", this::mapRowtoIngredient);
	}

	@Override
	public Ingredient findOne(String id) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject(
				"select id, name, type from Ingredient where id = ?", this::mapRowtoIngredient,id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}
	public Ingredient mapRowtoIngredient(ResultSet rs, int rowNum) throws SQLException {
	
		return(new Ingredient(
				rs.getString("id"),
				Ingredient.Type.valueOf(rs.getString("type")),
						rs.getString("name")));
	}
	

}
