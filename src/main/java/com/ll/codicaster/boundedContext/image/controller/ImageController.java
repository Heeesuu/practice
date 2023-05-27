package com.ll.codicaster.boundedContext.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ll.codicaster.boundedContext.image.service.ImageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class ImageController {

	private final ImageService imageService;


}
