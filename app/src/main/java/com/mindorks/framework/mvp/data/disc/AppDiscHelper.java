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

package com.mindorks.framework.mvp.data.disc;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.mindorks.framework.mvp.data.db.model.Option;
import com.mindorks.framework.mvp.data.db.model.Question;
import com.mindorks.framework.mvp.di.ApplicationContext;
import com.mindorks.framework.mvp.utils.AppConstants;
import com.mindorks.framework.mvp.utils.FileUtils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by janisharali on 20/07/17.
 */

public class AppDiscHelper implements DiscHelper {

    private Context mContext;

    @Inject
    public AppDiscHelper(@ApplicationContext Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Observable<List<Question>> getQuizQuestions() {

        return Observable.fromCallable(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                GsonBuilder builder = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation();
                final Gson gson = builder.create();

                Type type = $Gson$Types
                        .newParameterizedTypeWithOwner(null, List.class, Question.class);

                return gson.fromJson(FileUtils.loadJSONFromAsset(mContext,
                        AppConstants.SEED_DATABASE_QUESTIONS), type);
            }
        });
    }

    @Override
    public Observable<List<Option>> getQuizOptions() {

        return Observable.fromCallable(new Callable<List<Option>>() {
            @Override
            public List<Option> call() throws Exception {
                GsonBuilder builder = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation();
                final Gson gson = builder.create();

                Type type = new TypeToken<List<Option>>() {
                }.getType();

                return gson.fromJson(FileUtils.loadJSONFromAsset(mContext,
                        AppConstants.SEED_DATABASE_OPTIONS), type);
            }
        });
    }
}
