package com.tt.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.tt.common.ServerResponse;

public interface IFileService {
	ServerResponse<Map<String, String>> uploadFile(String owner,MultipartFile multipartFile);
}
