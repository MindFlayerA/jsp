/**
 * 
 */
package com.springjdbc.SpringResultSetExtractor;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Amit
 *
 */
public class EmployeyDao {

	//Alreay created bean object in XML for JDBC template.
	private JdbcTemplate jdbc;
	
	//Setting bean for JDBC template 
	public EmployeyDao(JdbcTemplate jdbc) {
		super();
		this.jdbc = jdbc;
	}
	
	/*Addup your employeyes by passing employey type objects*/
	public int addEmployey(Employey em)
	{
		String sql="insert into employey values('"+em.getEm_id()+" ',' "+em.getEm_name()+" ','"+em.getDesig()+"','"+em.getDept()+"' ,'"+em.getAge()+"')";
		return jdbc.update(sql);
		
	}
	
	/*This will extract whole list of employey and will return a employey type arrayList*/
	public List<Employey> viewAll()
	{
		String sql="Select * from employey";
		return jdbc.query(sql, new Extractor());
	}
	
	/*Search your employeyes by their employey id's returns list of employey's */
	public List<Employey> emByID(int id)
	{
		String sql="Select * from employey where id='"+ id +"'";
		
		return jdbc.query(sql, new Extractor());
	}
	
	/*Delete Employey by Employey ID*/
	public int deleteById(int id)
	{
		String sql="delete from employey where id='"+id+"'";
		return jdbc.update(sql);
	}
	
	/*Updates Employey data of employey using id you just need to pass a employey object and return int*/
	public int update(Employey em, int id)
	{
		String sql="update employey set"
				+ " name="+em.getEm_name()+" designation="+em.getDesig()+"department="+em.getDept()+"age="+em.getAge()+"'where id="+id+"";
		return jdbc.update(sql);
	}
	
	
	
	

}
