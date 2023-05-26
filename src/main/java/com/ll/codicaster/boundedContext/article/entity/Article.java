package com.ll.codicaster.boundedContext.article.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;

	private String author;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private Integer likeCount;
	private String imageUrl;


	//ManyToMany 태그리스트와 연결
	// @ElementCollection
	// private List<String> tags;

}
