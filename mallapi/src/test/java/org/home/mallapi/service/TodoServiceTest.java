package org.home.mallapi.service;

import java.time.LocalDate;

import org.home.mallapi.dto.PageRequestDTO;
import org.home.mallapi.dto.TodoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TodoServiceTest {
	
	@Autowired
	private TodoService todoService;

	@Test
	public void testGet() {

		Long tno = 50L;
	
		log.info("get = {}", todoService.get(tno));
		
	}

	@Test
	@Transactional
	public void testRegister() {
		TodoDTO todoDTO = TodoDTO.builder()
			.title("Title...")
			.content("Content.....")
			.dueDate(LocalDate.of(2024, 10, 8))
		.build();

		Long result = todoService.register(todoDTO);
		
		log.info("result = {}", result);
		
	}

	@Test
	public void testGetList() {

		// 값을 지정하지 않으면 page = 1, size = 10
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(10).build();

		System.out.println(todoService.getList(pageRequestDTO));
	}
	
}
