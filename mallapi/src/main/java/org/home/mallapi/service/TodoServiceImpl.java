package org.home.mallapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.home.mallapi.domain.Todo;
import org.home.mallapi.dto.PageRequestDTO;
import org.home.mallapi.dto.PageResponseDTO;
import org.home.mallapi.dto.TodoDTO;
import org.home.mallapi.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
	
	private final TodoRepository todoRepository;
	
	@Override
	public TodoDTO get(Long tno) {
		
		Optional<Todo> result = todoRepository.findById(tno);

		Todo todo = result.orElseThrow();
		
		return fromEntity(todo);
		
	}

	@Override
	public Long register(TodoDTO dto) {
		Todo todo = toEntity(dto);
		Todo result = todoRepository.save(todo);
		result.getTno();
		return result.getTno();
	}

	@Override
	public void modify(TodoDTO dto) {

		Optional<Todo> result = todoRepository.findById(dto.getTno());
		Todo todo = result.orElseThrow();
		todo.setTitle(dto.getTitle());
		todo.setContent(dto.getContent());
		todo.setComplete(dto.isComplete());
		todo.setDueDate(dto.getDueDate());
		
		todoRepository.save(todo);
		
	}

	@Override
	public void remove(Long tno) {
		todoRepository.deleteById(tno);
	}

	@Override
	public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

		// JPA
		Page<Todo> result = todoRepository.search1(pageRequestDTO);

		// ! Todo List => TodoDTO List
		List<TodoDTO> dtoList = result.get().map(todo -> fromEntity(todo)).collect(Collectors.toList());

		PageResponseDTO<TodoDTO> pageResponseDTO = new PageResponseDTO<>(dtoList, pageRequestDTO, result.getTotalElements());

		
		return pageResponseDTO;
	}

	
}
