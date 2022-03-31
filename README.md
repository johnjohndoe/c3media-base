[![Build Status](https://travis-ci.com/johnjohndoe/c3media-base.svg?branch=master)](https://travis-ci.com/johnjohndoe/c3media-base) [![Apache License](http://img.shields.io/badge/license-Apache%20License%202.0-lightgrey.svg)](http://choosealicense.com/licenses/apache-2.0/) [![JitPack](https://jitpack.io/v/johnjohndoe/c3media-base.svg)][jitpack-c3media-base]

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
        mavenLocal()
    }
}
```

and to your application module `build.gradle`:


```groovy
dependencies {
    // use this for the basic c3media version
    implementation "info.metadude.kotlin.library.c3media:c3media-base:$version"
    // or use this line for the rx-java-2 version of c3media
    implementation "info.metadude.kotlin.library.c3media:c3media-rx-java-2:$version"
}
```

Alternatively, you can use [JitPack][jitpack-c3media-base] to fetch and
build the sources directly from this repository.


## Tests

Run the following command to execute all tests:

```groovy
$ ./gradlew clean test
```

## Which applications are using this library?

* cccTV - [Sources][ccctv-github], [Google Play][ccctv-play]

## Author

* [Tobias Preuss][tobias-preuss]

## Contributors

* [Stefan Medack][stefan-medack]

## License

    Copyright 2017-2022 Tobias Preuss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[ccctv-github]: https://github.com/stefanmedack/cccTV
[ccctv-play]: https://play.google.com/store/apps/details?id=de.stefanmedack.ccctv
[stefan-medack]: https://github.com/stefanmedack
[tobias-preuss]: https://github.com/johnjohndoe
[jitpack-c3media-base]: https://jitpack.io/#johnjohndoe/c3media-base
