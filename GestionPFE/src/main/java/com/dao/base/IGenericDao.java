package com.dao.base;

import java.util.List;

/**
 * 
 * @author El Mehdi
 *
 * @param <T>
 * @param <PK>
 */

public interface IGenericDao<T, PK> {

	/**
	 * 
	 * @param obj
	 * @return PK
	 * 
	 *         For saving an object.
	 * 
	 */
	public abstract PK add(T object);

	/**
	 * 
	 * @param primaryKey
	 * @return Object For getting an object using primaryKey
	 * 
	 */
	public abstract T getById(PK primaryKey);

	/**
	 * 
	 * @param primaryKey
	 * @return boolean val It return true when the item deleted and false if the
	 *         item not found in the table
	 * 
	 */
	public abstract void delete(PK primaryKey);

	/**
	 * For updating an existing project
	 * 
	 * @param object
	 */
	public abstract void update(T object);

	/**
	 * Getting All elements
	 * 
	 * @return
	 */
	public abstract List<T> getAll();

}
