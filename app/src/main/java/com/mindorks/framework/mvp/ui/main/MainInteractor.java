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

package com.mindorks.framework.mvp.ui.main;

import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.data.db.repository.QuestionRepository;
import com.mindorks.framework.mvp.data.network.ApiHelper;
import com.mindorks.framework.mvp.data.network.model.LogoutResponse;
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by janisharali on 20/07/17.
 */

public class MainInteractor extends BaseInteractor
        implements MainMvpInteractor {

    private QuestionRepository mQuestionRepository;

    @Inject
    public MainInteractor(PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper,
                          QuestionRepository questionRepository) {

        super(preferencesHelper, apiHelper);
        mQuestionRepository = questionRepository;
    }

    @Override
    public Observable<LogoutResponse> doLogoutApiCall() {
        return getApiHelper().doLogoutApiCall();
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return mQuestionRepository.getAllQuestions();
    }

    @Override
    public String getCurrentUserName() {
        return getPreferencesHelper().getCurrentUserName();
    }

    @Override
    public String getCurrentUserEmail() {
        return getPreferencesHelper().getCurrentUserEmail();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return getPreferencesHelper().getCurrentUserProfilePicUrl();
    }

}
