/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.framework.mvp.ui.login;

import com.mindorks.framework.mvp.data.db.repository.UserRepository;
import com.mindorks.framework.mvp.data.network.ApiHelper;
import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.ui.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by janisharali on 20/07/17.
 */

public class LoginInteractor extends BaseInteractor
        implements LoginMvpInteractor {

    private UserRepository mUserRepository;

    @Inject
    public LoginInteractor(PreferencesHelper preferencesHelper,
                           ApiHelper apiHelper,
                           UserRepository userRepository) {

        super(preferencesHelper, apiHelper);
        mUserRepository = userRepository;
    }

    @Override
    public Observable<LoginResponse> doServerLoginApiCall(
            LoginRequest.ServerLoginRequest request) {
        return getApiHelper().doServerLoginApiCall(request);
    }

    @Override
    public Observable<LoginResponse> doGoogleLoginApiCall(
            LoginRequest.GoogleLoginRequest request) {
        return getApiHelper().doGoogleLoginApiCall(request);
    }

    @Override
    public Observable<LoginResponse> doFacebookLoginApiCall(
            LoginRequest.FacebookLoginRequest request) {
        return getApiHelper().doFacebookLoginApiCall(request);
    }
}
