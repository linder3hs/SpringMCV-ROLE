package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;
import com.tecsup.gestion.model.Role;

public interface EmployeeService {
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;

	List<Employee> findAll() 
			throws DAOException, EmptyResultException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException;
	
	void updateWithrole(String login, String password, String lastname, String firstname, int salary, int dptId, Role role)
			throws DAOException;
	
	

	void delete(String login) throws DAOException;
	
	void deleteWhithrole(String login) throws DAOException;

	void create(String login, String password, String lastname, String firstname, int salary, int deptId) throws DAOException;
	Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException;
 
	boolean isEmployeeExist(Employee emp) throws DAOException, EmptyResultException;
	
	void createWithRole(String login, String password, String lastname, String firstname, int salary, int deptId,
			String roleId) throws DAOException;

	
	
}
