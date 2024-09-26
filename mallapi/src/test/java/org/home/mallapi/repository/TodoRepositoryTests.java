package org.home.mallapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.home.mallapi.domain.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TodoRepositoryTests {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Test
	public void test1() {
		Assertions.assertNotNull(todoRepository);

		log.info(todoRepository.getClass().getName());
	}

	@Test
	public void testInsert() {

		for (int i = 0; i < 100; i++) {
			Todo todo = Todo.builder()
					.title("Title" + i)
					.content("Content.." + i)
					.dueDate(LocalDate.of(2024, 10, 8))
					.build();
					Todo result = todoRepository.save(todo);
			
					log.info("result = {}", result);
			
		}
		
		
	}

	@Test
	public void testRead() {
		
		Long tno = 1L;
		Optional<Todo> result = todoRepository.findById(tno);

		Todo todo = result.orElseThrow();

		Assertions.assertNotNull(todo);
		log.info("todo = {}", todo);
	}
	
	@Test
	public void testUpdate() {
		
		Long tno = 1L;
		Optional<Todo> result = todoRepository.findById(tno);

		Todo todo = result.orElseThrow();

		todo.setTitle("Update Title");
		todo.setContent("updated content");
		todo.setComplete(true);

		todoRepository.save(todo);
		
		Assertions.assertNotNull(todo);
		log.info("todo = {}", todo);
	}

	@Test
	public void testPaging() {

		// 페이지 번호는 0부터 시작
		Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

		Page<Todo> result = todoRepository.findAll(pageable);

		// 전체 원소 개수
		log.info("resultTotalElements = {}", result.getTotalElements());
		
		// 전체 페이지 개수
		log.info("resultTotalPage = {}", result.getTotalPages());

		// page 처리가 된 리스트
		log.info("result = {}", result.getContent());
		
	}

	// @Test
	// public void testSearch1() {
	// 	todoRepository.search1();
	// }

}
