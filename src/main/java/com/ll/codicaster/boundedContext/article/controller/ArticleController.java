package com.ll.codicaster.boundedContext.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ll.codicaster.boundedContext.article.entity.Article;
import com.ll.codicaster.boundedContext.article.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("/write")
	public String articleWrite() {
		return "usr/article/write";
	}

	@PostMapping("/write")
	public String articleWriteSave(Article article) {

		articleService.write(article);

		return "redirect:/article/list";
	}

}
