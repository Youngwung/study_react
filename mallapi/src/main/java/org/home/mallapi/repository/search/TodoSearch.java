package org.home.mallapi.repository.search;

import org.home.mallapi.domain.Todo;
import org.home.mallapi.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

	Page<Todo> search1(PageRequestDTO pageRequestDTO);
	
}
