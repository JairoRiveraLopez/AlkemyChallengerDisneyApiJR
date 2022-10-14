package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service;


import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.ApiUser;

import java.util.List;

public interface IUserService {

    List<ApiUser> getAll();
    ApiUser save(ApiUser apiUser);
}
