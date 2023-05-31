package com.ll.codicaster.boundedContext.article.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ll.codicaster.boundedContext.article.entity.Article;
import com.ll.codicaster.boundedContext.article.form.ArticleCreateForm;
import com.ll.codicaster.boundedContext.article.service.ArticleService;
import com.ll.codicaster.boundedContext.image.entity.Image;
import com.ll.codicaster.boundedContext.image.service.ImageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleService articleService;

	private final ImageService imageService;

	@GetMapping("/write")
	public String articleWrite() {
		return "usr/article/write";
	}


	@PostMapping("/writepro")
	public String articleWriteSave(@ModelAttribute ArticleCreateForm articleCreateForm, @RequestParam("imageFile") MultipartFile imageFile) throws Exception {
		articleService.saveArticle(articleCreateForm, imageFile);

		return "redirect:/article/list";
	}



	@GetMapping("/list")
	public String articles(Model model) {

		List<Article> articles = articleService.articleList();
		model.addAttribute("articles", articles);

		return "usr/article/list";
	}

	@GetMapping("/detail/{id}")
	public String articleDetail(@PathVariable Long id, Model model) {
		Article article = articleService.articleDetail(id);
		model.addAttribute("article", article);
		model.addAttribute("image", article.getImage()); // image 정보를 추가해줍니다.
		return "usr/article/detail";
	}

	@GetMapping("/modify/{id}")
	public String modifyArticle(@PathVariable("id") Long id, Model model) {
		// id를 이용하여 기존 게시물 정보를 가져옵니다.
		// 예를 들어, ArticleService를 이용하여 DB에서 게시물을 찾습니다.

		Article article = articleService.findArticleById(id);

		if (article == null) {
			// 게시물을 찾지 못한 경우 처리를 작성합니다.
			// 예를 들어, 오류 페이지로 리다이렉트 시킬 수 있습니다.
			return "redirect:/error";
		}

		model.addAttribute("article", article);

		// 수정 페이지를 반환합니다.
		return "usr/article/modify";
	}

	@PostMapping("/modify/{id}")
	public String updateArticle(@PathVariable("id") Long id, @ModelAttribute ArticleCreateForm updatedArticle, MultipartFile imageFile) {
		boolean success = articleService.updateArticle(id, updatedArticle, imageFile);

		if (!success) {
			return "redirect:/error";
		}

		return "redirect:/article/detail/" + id;
	}

	@GetMapping("/delete/{id}")
	public String deleteArticle(@PathVariable("id") Long id) {
		// id를 이용하여 게시물을 삭제합니다.
		// 예를 들어, ArticleService를 이용하여 DB에서 게시물을 삭제합니다.

		boolean success = articleService.deleteArticle(id);

		if (!success) {
			// 게시물을 삭제하지 못한 경우 처리를 작성합니다.
			// 예를 들어, 오류 페이지로 리다이렉트 시킬 수 있습니다.
			return "redirect:/error";
		}

		// 게시물 삭제가 성공적으로 이루어진 경우, 게시물 목록으로 리다이렉트합니다.
		return "redirect:/article/list";
	}


}


