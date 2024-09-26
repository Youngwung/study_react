package org.home.mallapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class TodoDTO {
	private Long tno;

	private String title;

	private String content;

	private boolean complete;

	private LocalDate dueDate;
}
