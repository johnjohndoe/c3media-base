[![Build Status](https://travis-ci.org/johnjohndoe/c3media-base.svg?branch=master)](https://travis-ci.org/johnjohndoe/c3media-base) [![Apache License](http://img.shields.io/badge/license-Apache%20License%202.0-lightgrey.svg)](http://choosealicense.com/licenses/apache-2.0/) [![VersionEye](https://www.versioneye.com/user/projects/5878a9ad07beb70016a45aaf/badge.svg)](https://www.versioneye.com/user/projects/5878a9ad07beb70016a45aaf) [![JitPack](https://jitpack.io/v/johnjohndoe/c3media-base.svg)][jitpack-c3media-base]

# c3media-base library

A Kotlin library containing a parser and models for the media API of the CCC available here:

* https://api.media.ccc.de


### Gradle build

To deploy the library to your local Maven repository run the following task:

```bash
$ ./gradlew publishToMavenLocal
```

Then, to use the library in your project add the following to
your top level `build.gradle`:

```
allprojects {
    repositories {
        jcenter()
        mavenLocal()
    }
}
```

and to your application module `build.gradle`:


```groovy
dependencies {
    // use this for the basic c3media version
    compile "info.metadude.kotlin.library.c3media:c3media-base:$version"
    // or use this line for the rx-java-2 version of c3media
    compile "info.metadude.kotlin.library.c3media:c3media-rx-java-2:$version"
}
```

Alternatively, you can use [JitPack][jitpack-c3media-base] to fetch and
build the sources directly from this repository.


## Tests

Run the following command to execute all tests:

```groovy
$ ./gradlew clean test
```


## Author

* [Tobias Preuss][tobias-preuss]

## Contributors

* [Stefan Medack][stefan-medack]

## License

    Copyright 2017 Tobias Preuss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[stefan-medack]: https://github.com/stefanmedack
[tobias-preuss]: https://github.com/johnjohndoe
[jitpack-c3media-base]: https://jitpack.io/#johnjohndoe/c3media-base
