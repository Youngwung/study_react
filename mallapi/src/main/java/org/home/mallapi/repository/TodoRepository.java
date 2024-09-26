package org.home.mallapi.repository;

import org.home.mallapi.domain.Todo;
import org.home.mallapi.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch{
	
}
