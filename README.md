# Android MVP Architecture: Enhanced with Interactors and Repositories: Sample App

This repository is an extension of the [android-mvp-architecture](https://github.com/MindorksOpenSource/android-mvp-architecture). It breaks the DataManager into Interactors and DbHelper into Repositories. These changes makes it fit for very large projects, for smaller projects the above mentioned repository is better.

This repository contains a detailed sample app that implements MVP architecture enhanced with Interactors and DbRepositories for complete decoupling, using Dagger2, GreenDao, RxJava, FastAndroidNetworking, PlaceHolderView and AndroidDebugDatabase

# Architecture Blueprint
![Blueprint](https://janishar.github.io/images/mvp-app-pics/mvp-interactor-arch.png)
<br>

# Project Structure
![Structure](https://janishar.github.io/images/mvp-app-pics/mvp-interactor-project-structure.png)
<br>

<p align="center">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-login.png" width="250">
  <img src="https://janishar.github.io/images/mvp-app-pics/main-view.png" width="250">
  <img src="https://janishar.github.io/gifs/mvp-app.gif" width="250">
</p>
<br>
<p align="center">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-drawer.png" width="200">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-rating.png" width="200">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-feed.png" width="200">
  <img src="https://janishar.github.io/images/mvp-app-pics/mvp-empty-state.png" width="200">
</p>
<br>
<br>

# Read the below listed articles. They describe the MVP concepts and the Project structure.
1. [Android MVP Architecture Extension with Interactors and Repositories](https://blog.mindorks.com/android-mvp-architecture-extension-with-interactors-and-repositories-bd4b51972339)
2. [MVP: Part 1](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-1-74efaf1cda40#.lkml1yggq)
3. [MVP: Part 2](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-2-b2ac6f3f9637#.dge0wl8rl)
4. [MVP: Part 3](https://blog.mindorks.com/essential-guide-for-designing-your-android-app-architecture-mvp-part-3-dialog-viewpager-and-7bdfab86aabb)

#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters and Interactors.
4. **service**: Services for the application.
5. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

# Read the below listed articles. They describe the MVP concepts and the Project structure.
1. [MVP: Part 1](https://janisharali.com/blog/essential-guide-for-designing-your-android-app-architecture-mvp-part-1-74efaf1cda40#.lkml1yggq)
2. [MVP: Part 2](https://janisharali.com/blog/essential-guide-for-designing-your-android-app-architecture-mvp-part-2-b2ac6f3f9637#.dge0wl8rl)
3. [MVP: Part 3](https://janisharali.com/blog/essential-guide-for-designing-your-android-app-architecture-mvp-part-3-dialog-viewpager-and-7bdfab86aabb)
4. [Extension with Interactors and Repositories](https://janisharali.com/blog/android-mvp-architecture-extension-with-interactors-and-repositories-bd4b51972339)

#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters.
4. **service**: Services for the application.
5. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
2. Dagger2: https://github.com/janishar/android-dagger2-example
4. PlaceHolderView: https://github.com/janishar/PlaceHolderView
6. Calligraphy: https://github.com/chrisjenx/Calligraphy
7. GreenDao: http://greenrobot.org/greendao/
8. ButterKnife: http://jakewharton.github.io/butterknife/

### Concept reference resources:
1. [Introduction to Dagger 2: Part 1](https://janisharali.com/blog/introduction-to-dagger-2-using-dependency-injection-in-android-part-1-223289c2a01b#.ki6nt86l6)
2. [Introduction to Dagger 2: Part 2](https://janisharali.com/blog/introduction-to-dagger-2-using-dependency-injection-in-android-part-2-b55857911bcd#.mkpzyk8sa)
3. [Android Dagger2: Critical things to know before you implement](https://janisharali.com/blog/android-dagger2-critical-things-to-know-before-you-implement-275663aecc3e#.bskiz1879)
4. [Android Tinder Swipe View Example](https://janisharali.com/blog/android-tinder-swipe-view-example-3eca9b0d4794#.u7i7jbbvy)
5. [RxJava Anatomy: What is RxJava, how RxJava is designed, and how RxJava works.](https://janisharali.com/blog/rxjava-anatomy-what-is-rxjava-how-rxjava-is-designed-and-how-rxjava-works-d357b3aca586)
6. [Powerful Android ORM: greenDAO 3 Tutorial](https://blog.mindorks.com/powerful-android-orm-greendao-3-tutorial)


### How do I use this project?
This is a boilerplate project aimed to help bootstrap new Android MVP Applications. Feel free to fork this application or use [AndroidStarters](http://androidstarters.com/) to create new app using this boilerplate.

### License
```
   Copyright (C) 2022 JANISHAR ALI ANWAR

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

### Contributing to Android MVP Architecture
Just make pull request. You are in!
