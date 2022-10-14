package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl;


import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.IUserService;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud.UserRepository;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.ApiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ApiUser> getAll() {
        return (List<ApiUser>) userRepository.findAll();
    }

    @Override
    public ApiUser save(ApiUser apiUser) {
        return userRepository.save(apiUser);
    }
}
