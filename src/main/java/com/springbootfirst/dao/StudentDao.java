package com.springbootfirst.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springbootfirst.entity.Student;

public interface StudentDao extends PagingAndSortingRepository<Student, Long> {

}
