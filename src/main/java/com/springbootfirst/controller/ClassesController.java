package com.springbootfirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.dao.ClassDao;
import com.springbootfirst.entity.Classes;
import com.springbootfirst.exception.StatusConstant;
import com.springbootfirst.returnData.Info;


@RestController
@RequestMapping(value = "/classes")
public class ClassesController {

	@Autowired
	private ClassDao classDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Info<Iterable<Classes>> getAllClassesList() {
		return new Info<Iterable<Classes>>(StatusConstant.OK, null, classDao.findAll());
	}

	@RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
	public Info<Page<Classes>> getClassesList(@PathVariable Integer page, @PathVariable Integer size) {
		return new Info<Page<Classes>>(StatusConstant.OK, null, classDao.findAll(new PageRequest(page - 1, size)));
	}

	@RequestMapping(value = "/{page}/{size}/{direction}/{props}", method = RequestMethod.GET)
	public Info<Page<Classes>> getClassesListSort(@PathVariable Integer page, @PathVariable Integer size,
			@PathVariable String direction, @PathVariable String props) {
		return new Info<Page<Classes>>(StatusConstant.OK, null,
				classDao.findAll(new PageRequest(page - 1, size, Direction.fromString(direction), props.split(","))));
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Info<Classes> postClasses(Classes classes) {
		return new Info<Classes>(StatusConstant.OK, null, classDao.save(classes));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Info<Classes> getClasses(@PathVariable Long classesId) {
		return new Info<Classes>(StatusConstant.OK, null, classDao.findOne(classesId));
	}

	@RequestMapping(value = "/{classesId}", method = RequestMethod.PUT)
	public Info<Classes> putClasses(@PathVariable Long classesId, @ModelAttribute Classes classes) {
		return new Info<Classes>(StatusConstant.OK, null, classDao.save(classes));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Info<String> deleteClasses(@PathVariable Long id) {
		classDao.delete(id);
		return new Info<String>(StatusConstant.OK, null);
	}
}
