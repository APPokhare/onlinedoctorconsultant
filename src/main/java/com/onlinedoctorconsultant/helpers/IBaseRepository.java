package com.onlinedoctorconsultant.helpers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.onlinedoctorconsultant.entities.BaseEntity;

/**
 * @author Amruta 5th Dec 2020
 *
 */
@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID>, QueryByExampleExecutor<T> {
	
}
