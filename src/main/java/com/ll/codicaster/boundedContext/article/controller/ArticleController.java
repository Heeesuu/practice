package com.ll.codicaster.boundedContext.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@GetMapping("/write")
	public String articleWrite() {
		return "usr/article/write";
	}
}
