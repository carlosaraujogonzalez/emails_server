package com.gbtec.emailserver.service.impl;

import com.gbtec.emailserver.service.MarkSpamService;
import com.gbtec.emailserver.service.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MarkSpamImpl implements MarkSpamService {

	@Autowired
    private final UserFeignClient userFeignClient;

	@Override
	public void markSpam(String email) {
		
		log.info("markSpam - Start");
		
		userFeignClient.markSpam(email);
		
		log.info("markSpam - End");
		
	}

}
