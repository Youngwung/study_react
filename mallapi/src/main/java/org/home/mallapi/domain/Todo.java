package org.home.mallapi.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString @Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tbl_todo")
public class Todo {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long tno;

	@Column(length = 500, nullable = false)
	private String title;

	private String content;

	private boolean complete;

	private LocalDate dueDate;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
