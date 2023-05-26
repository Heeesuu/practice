package com.ll.codicaster.boundedContext.article.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleCreateForm {
	private String title;
	private String content;
}
