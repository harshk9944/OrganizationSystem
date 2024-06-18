package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	public String addCountryData(Country c) {
		// TODO Auto-generated method stub
		
	    Session session=null;
		Transaction tx = null;
		String msg=null;
	    try {
	    session= factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="The data is added successfully in country";
	    }
	    catch(Exception e) {
	    	if(tx!=null) {
	    		tx.rollback();
	    	}
	    	e.printStackTrace();
	    }
	    finally {
	    	if(session!=null) {
	    		session.close();
	    	}
	    	
	    }
	    return msg;
		
	}
	public String updateCountry(int id, Country c) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
		session= factory.openSession();
		tx=session.beginTransaction();
		
		Country country= session.get(Country.class, id);
		
		country.setCname(c.getCname());
		
		session.merge(country);
		tx.commit();
		msg="country is updated";
		
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return msg;
		
	}
	public String deleteCountryData(int id) {
		// TODO Auto-generated method stub
		Session session =null;
		Transaction tx=null;
		String msg=null;
		try {
		session= factory.openSession();
		tx=session.beginTransaction();
		
		Country country= session.get(Country.class, id);
		
		session.remove(country);
		tx.commit();
		 msg="Country is deleted successfully";
		}catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}
	
	public List getAllRec() {
		// TODO Auto-generated method stub
	    Session session=null;
	    Transaction tx=null;
	    String hqlQuery="from Country";
	    List<Country> list=null;
	    
	    try {
	    session = factory.openSession();
	    tx= session.beginTransaction();
	    
	    Query<Country> query= session.createQuery(hqlQuery,Country.class);
	    list=query.list();
	    
 	    tx.commit();
	    }catch (Exception e) {

	    	if(tx!=null) {
	    		tx.rollback();
	    		e.printStackTrace();
	    	}
	    }
	    finally {
	    	if(session!=null) {
	    		session.close();
	    	}
	    }
	    
	    return list;
 	    
	    
	    
		
	}
	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(emp);
			tx.commit();
			msg="Data added successfully in Employee";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee employee= session.get(Employee.class,emp.getId());
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setDepartment(emp.getDepartment());
			employee.setEmailid(emp.getEmailid());
			employee.setPhoneno(emp.getPhoneno());
			employee.setSalary(emp.getSalary());
			employee.setStatus(emp.getStatus());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			
			session.merge(employee);
			tx.commit();
			msg="data is updated";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();		
			}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			Employee employee= session.get(Employee.class, id);
			session.remove(employee);
			tx.commit();
			msg="Data deleted successfully in Employee";
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	public List<Employee> getTotalRecord() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session=null;
				Transaction tx=null;
				List<Employee> list=null;
				String hqlQuery="from Employee";
				
				try {
					
					session= factory.openSession();
					tx=session.beginTransaction();
					
					Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
					list= query.list();
					
					
					tx.commit();
					
				} catch (Exception e) {
					// TODO: handle exception
					if(tx!=null) {
						tx.rollback();
					}
					e.printStackTrace();
				}
				finally {
					if(session!=null) {
						session.close();
					}
				}
		
		return list;
	}
	public Employee getParticular(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session=null;
				Transaction tx=null;
                Employee emp=null;  				
				try {
					
					session= factory.openSession();
					tx=session.beginTransaction();
					
					 emp= session.get(Employee.class, id);
					tx.commit();
					
				} catch (Exception e) {
					// TODO: handle exception
					if(tx!=null) {
						tx.rollback();
					}
					e.printStackTrace();
				}
				finally {
					if(session!=null) {
						session.close();
					}
				}
				
			
		return emp;
	}
	public List<Employee> getParticularbystatus(String status) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
        List<Employee> list=null;
        String hqlQuery="from Employee where status=:mystatus";
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			 query.setParameter("mystatus",status);
			list= query.list();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
	
return list;
	}
	public Employee logInData(Employee emp) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
         Employee employee=null;
        String hqlQuery="from Employee where emailid=:myemailid and phoneno=:myphoneno";
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			 query.setParameter("myemailid",emp.getEmailid() );
			 query.setParameter("myphoneno", emp.getPhoneno());
			 employee=query.uniqueResult();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
	return employee;
	}
	public List<Employee> getparticularBySalary(double salary) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where salary>:mysalary";
		
		try {
			
			session= factory.openSession();
			tx= session.beginTransaction();
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			 query.setParameter("mysalary", salary);
			
			 list=query.list();
			tx.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}
	public List<Employee> getBetweenBySalary(double salary, double salary1) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
	//	String hqlQuery="select from employee where salary>:mysalary1 and salary<:mysalary2";
		String hqlQuery="select from Employee where salary between :mysalary1 and :mysalary2";
		
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("mysalary1", salary);
			query.setParameter("mysalary2", salary1);
			
			list= query.list();
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				tx.rollback();
			}
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

}
