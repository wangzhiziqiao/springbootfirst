package com.springbootfirst.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springbootfirst.entity.Classes;

public interface ClassDao extends PagingAndSortingRepository<Classes, Long> {
	
}
