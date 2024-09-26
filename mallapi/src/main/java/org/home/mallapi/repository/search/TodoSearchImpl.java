package org.home.mallapi.repository.search;

import java.util.List;

import org.home.mallapi.domain.QTodo;
import org.home.mallapi.domain.Todo;
import org.home.mallapi.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

	// 생성자와 오버라이드 메서드가 필요함.

	// 생성자는 자동생성해주는 거 쓰지 말고
	// 도메인 클래스를 명시적으로 아규먼트로 전달해주는 게 좋음.
	public TodoSearchImpl() {
		super(Todo.class);
	}

	@Override
	public Page<Todo> search1(PageRequestDTO pageRequestDTO) {

		log.info("search1................................");

		QTodo todo = QTodo.todo;

		JPQLQuery<Todo> query = from(todo);

		// 검색 조건 설정 하면 됨.

		Pageable pageable = PageRequest.of(
				pageRequestDTO.getPage() - 1,
				pageRequestDTO.getSize(),
				Sort.by("tno").descending());

		// QueryDSL에서 페이징처리 하는 방법
		this.getQuerydsl().applyPagination(pageable, query);
		// query에 페이징 처리가 적용됨.

		List<Todo> list = query.fetch(); // 목록 데이터(페이징 처리 된 데이터)

		long total = query.fetchCount(); // 검색된 전체 데이터 양

		return new PageImpl<>(list, pageable, total);
	}

}
