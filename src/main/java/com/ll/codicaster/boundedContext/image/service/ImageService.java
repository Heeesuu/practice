package com.ll.codicaster.boundedContext.image.service;

import org.springframework.stereotype.Service;
import com.ll.codicaster.boundedContext.image.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

	private final ImageRepository imageRepository;

}