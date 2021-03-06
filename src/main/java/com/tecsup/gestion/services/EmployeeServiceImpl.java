package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecsup.gestion.dao.EmployeeDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Employee;
import com.tecsup.gestion.model.Role;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	@Override
	public List<Employee> findAll()
			throws DAOException, EmptyResultException {
		
		List<Employee> emps = employeeDAO.findAllEmployees();
	
		return emps;
	}

	@Override
	public void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.update(login, password, lastname, firstname, salary, dptId);
	}

	@Override
	public void delete(String login) throws DAOException {
		 
		employeeDAO.delete(login);
	
	}
	
	@Override
	public void updateWithrole(String login, String password, String lastname, String firstname, int salary, int dptId, Role role)
			throws DAOException {
		
		employeeDAO.update(login, password, lastname, firstname, salary, dptId);

		
	}

	@Override
	public void deleteWhithrole(String login) throws DAOException {
	
		employeeDAO.delete(login);

		
	}



	@Override
	public void create(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.create(login, password, lastname, firstname, salary, dptId);

	}

	@Override
	public Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException {
		Employee emp = employeeDAO.findEmployeeByLogin(login);
		return emp;
	}

	@Override
	public boolean isEmployeeExist(Employee emp) throws DAOException, EmptyResultException {
		List<Employee> emps = employeeDAO.findAllEmployees();
		for (Employee employee : emps) {
			if(employee.getLogin().equals(emp.getLogin())) {
				return true;
			}
		}
			
		return false;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DAOException.class })
	public void createWithRole(String login, String password, String lastname, String firstname, int salary, int dptId,
			String roleId) throws DAOException {

		employeeDAO.create(login, password, lastname, firstname, salary, dptId);
		employeeDAO.addRole(login, roleId);

	}

	
	
	
	

}
