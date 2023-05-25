package com.ll.codicaster.boundedContext.article.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;

	//manytoone Member
	private String author;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private Integer like;
	private String imageUrl;

	//지역엔티티와연결 추가해야함


	//ManyToMany 태그리스트와 연결
	@ElementCollection
	private List<String> tags;

}
