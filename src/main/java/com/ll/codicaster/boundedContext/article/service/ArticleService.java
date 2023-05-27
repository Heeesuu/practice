package com.ll.codicaster.boundedContext.article.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ll.codicaster.boundedContext.article.entity.Article;
import com.ll.codicaster.boundedContext.article.form.ArticleCreateForm;
import com.ll.codicaster.boundedContext.article.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

	private final ArticleRepository articleRepository;

	public void saveArticle(ArticleCreateForm form) {
		Article article = Article.builder()
			.title(form.getTitle())
			.content(form.getContent())
			.createDate(LocalDateTime.now())
			.modifyDate(LocalDateTime.now())
			.build();

		articleRepository.save(article);
	}

	public List<Article> articleList() {

		return articleRepository.findAll();
	}

	public Article articleDetail(Long id) {
		return articleRepository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("No Article found with id: " + id));
	}

}
