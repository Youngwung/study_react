package org.home.mallapi.controller;

import java.util.Map;

import org.home.mallapi.dto.PageRequestDTO;
import org.home.mallapi.dto.PageResponseDTO;
import org.home.mallapi.dto.TodoDTO;
import org.home.mallapi.service.TodoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

	private final TodoService todoService;

	@GetMapping("/{tno}")
	public TodoDTO get(@PathVariable("tno") Long tno) {
		TodoDTO todoDTO = todoService.get(tno);
		System.out.println(todoDTO);
		return todoDTO;
	}

	@GetMapping("/list")
	public PageResponseDTO<TodoDTO> list(PageRequestDTO pageResponseDTO) {
		log.info("list............................. {}", pageResponseDTO);

		return todoService.getList(pageResponseDTO);
	}

	@PostMapping("/")
	public Map<String, Long> register(@RequestBody TodoDTO dto) {
		log.info("dto = {}", dto);

		Long tno = todoService.register(dto);

		// JSON 형태로 값을 전달하기 위해 Map 으로 리턴함.
		return Map.of("TNO", tno);
	}

	@PutMapping("/{tno}")
	public Map<String, String> modify(@PathVariable("tno") Long tno, @RequestBody TodoDTO dto) {

		// pathvariable의 tno와 dto의 tno가 같아야 하므로 set으로 동기화시키는게 조금 더 안전한 코드가 될듯?
		dto.setTno(tno);

		todoService.modify(dto);

		return Map.of("RESULT", "SUCCESS");
	}

	@DeleteMapping("/{tno}")
	public Map<String, String> remove(@PathVariable("tno") Long tno) {
		todoService.remove(tno);

		return Map.of("RESULT", "SUCCESS");
	}
	
	
}
