package org.jsp.userproduct.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.hibernate.query.Query;
import org.jsp.userproduct.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDao {


	 @Autowired(required = true)
		private EntityManager manager;
	    public static Users mdao;
	    public Users saveUsers(Users m) {
	    	EntityTransaction t=manager.getTransaction();
	    	t.begin();
	    	manager.persist(m);
	    	t.commit();
	    	return m;
	    }
	    
	    public Users updateUsers(Users m) {
	    	 mdao=manager.find(Users.class, m.getId());
	    	if(mdao!=null) {
	    		mdao.setName(m.getName());
	    		mdao.setEmail(m.getEmail());
	    		mdao.setPhone(m.getPhone());
	    		mdao.setPassword(m.getPassword());
	    		EntityTransaction t= manager.getTransaction();
	    		t.begin();
	    		
	    		t.commit();
	    		return mdao;
	    	}
	    	return null;
	    }
		public Users FindUsers(int id) {
		 return manager.find(Users.class, id);
		}
		public Users VerifyUsers(long phone,String password) {
			Query q=(Query) manager.createQuery("select m from Users m where m.phone=?1 and m.password=?2");
			q.setParameter(1, phone);
			q.setParameter(2, password);
			try {
				return (Users) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
			
		}
		public Users VerifyUsers(String email,String password) {
			Query q=(Query) manager.createQuery("select m from Users m where m.email=?1 and m.password=?2");
			q.setParameter(1, email);
			q.setParameter(2, password);
			try {
				return (Users) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			
			
		}

		
}


}
