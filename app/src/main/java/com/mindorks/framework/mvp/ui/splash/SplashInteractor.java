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

package com.mindorks.framework.mvp.ui.splash;

import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.data.db.repository.OptionRepository;
import com.mindorks.framework.mvp.data.db.repository.QuestionRepository;
import com.mindorks.framework.mvp.data.disk.DiskHelper;
import com.mindorks.framework.mvp.data.network.ApiHelper;
import com.mindorks.framework.mvp.data.prefs.PreferencesHelper;
import com.mindorks.framework.mvp.ui.base.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by janisharali on 20/07/17.
 */

public class SplashInteractor extends BaseInteractor
        implements SplashMvpInteractor {

    private QuestionRepository mQuestionRepository;
    private OptionRepository mOptionRepository;

    @Inject
    public SplashInteractor(PreferencesHelper preferencesHelper,
                            ApiHelper apiHelper,
                            DiskHelper diskHelper,
                            QuestionRepository questionRepository,
                            OptionRepository optionRepository) {

        super(preferencesHelper, apiHelper, diskHelper);
        mQuestionRepository = questionRepository;
        mOptionRepository = optionRepository;
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {

        return mQuestionRepository.isQuestionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(@NonNull Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            return getDiscHelper()
                                    .getQuizQuestions()
                                    .concatMap(new Function<List<Question>,
                                            ObservableSource<? extends Boolean>>() {
                                        @Override
                                        public ObservableSource<? extends Boolean> apply(
                                                @NonNull List<Question> questions) throws
                                                Exception {
                                            return mQuestionRepository
                                                    .saveQuestionList(questions);
                                        }
                                    });

                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {

        return mOptionRepository
                .isOptionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            return getDiscHelper()
                                    .getQuizOptions()
                                    .concatMap(new Function<List<Option>,
                                            ObservableSource<? extends Boolean>>() {
                                        @Override
                                        public ObservableSource<? extends Boolean> apply(
                                                @NonNull List<Option> options) throws
                                                Exception {
                                            return mOptionRepository
                                                    .saveOptionList(options);
                                        }
                                    });

                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return getPreferencesHelper().getCurrentUserLoggedInMode();
    }
}
