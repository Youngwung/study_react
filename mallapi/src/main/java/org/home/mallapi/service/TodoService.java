package org.home.mallapi.service;

import org.home.mallapi.domain.Todo;
import org.home.mallapi.dto.PageRequestDTO;
import org.home.mallapi.dto.PageResponseDTO;
import org.home.mallapi.dto.TodoDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface TodoService {

	TodoDTO get(Long tno);

	// 등록 기능 메서드
	Long register(TodoDTO dto);
  // 리턴 값은 등록된 dto의 자동 생성 번호

	// 수정 기능 메서드
	void modify(TodoDTO dto);
	// 리턴 값이 void인 이유는 이 메서드가 실패하면 심각한 문제이므로 리턴 값으로 디버깅 하지 말고 아예 예외를 던지는 방법을 추천하기 때문.

	// 삭제 기능 메서드
	void remove(Long tno);

	PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);


	default TodoDTO fromEntity(Todo todo) {
		
		TodoDTO todoDTO = TodoDTO.builder()
			.tno(todo.getTno())
			.title(todo.getTitle())
			.content(todo.getContent())
			.complete(todo.isComplete())
			.dueDate(todo.getDueDate())
			.build();

		return todoDTO;
		
	}

	default Todo toEntity(TodoDTO dto) {
		
		Todo todo = Todo.builder()
			.tno(dto.getTno())
			.title(dto.getTitle())
			.content(dto.getContent())
			.complete(dto.isComplete())
			.dueDate(dto.getDueDate())
			.build();

		return todo;
		
	}

	
	
}
