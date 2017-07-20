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

package com.mindorks.framework.mvp.ui.base;

import com.mindorks.framework.mvp.data.network.ApiHelper;
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.utils.AppConstants;

import javax.inject.Inject;

/**
 * Created by janisharali on 20/07/17.
 */

public class BaseInteractor implements MvpInteractor {

    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public BaseInteractor(PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

    @Override
    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }

    @Override
    public void setAccessToken(String accessToken) {
        getPreferencesHelper().setAccessToken(accessToken);

        getApiHelper().getApiHeader()
                .getProtectedApiHeader()
                .setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(
            String accessToken,
            Long userId,
            AppConstants.LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath) {

        getPreferencesHelper().setAccessToken(accessToken);
        getPreferencesHelper().setCurrentUserId(userId);
        getPreferencesHelper().setCurrentUserLoggedInMode(loggedInMode);
        getPreferencesHelper().setCurrentUserName(userName);
        getPreferencesHelper().setCurrentUserEmail(email);
        getPreferencesHelper().setCurrentUserProfilePicUrl(profilePicPath);

        updateApiHeader(userId, accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        getApiHelper().getApiHeader()
                .getProtectedApiHeader().setUserId(userId);
        getApiHelper().getApiHeader()
                .getProtectedApiHeader().setAccessToken(accessToken);
    }

}
