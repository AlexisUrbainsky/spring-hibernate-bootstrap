package com.alexis.springhibernate.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao <PK extends Serializable,T > {
	
	private final Class<T> persistanceClass;
	
    @SuppressWarnings("unchecked")
	public AbstractDao (){
		this.persistanceClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
    @Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getById(PK id) {
		return (T) getSession().get(persistanceClass,id);
	}
	
    public void persist(T t) {
    	getSession().persist(t);
    }
	
    public void update (T t){
    	getSession().update(t);
    }
    
    public void delete (T t) {
    	getSession().delete(t);
    }
	
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(this.persistanceClass);
    }
    
}
