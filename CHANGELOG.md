# c3media-base changelog

## NEXT

* Not released yet

### Changes

* Use okhttp v.3.12.13.
* Use threetenbp v.1.5.2.
* Update project setup and dependencies (using Kotlin 1.3.61 now).
* Update `releaseDate` field in `Event` class and the corresponding tests. It can be `null`.
* Update test for `Conference` object. The `eventLastReleasedAt` field can be `null`.
* Update test for nested `Recording` object. The `size`, `length`, `width` and `height` fields can be `null`.


## [v.3.0.0](https://github.com/johnjohndoe/c3media-base/releases/tag/v.3.0.0)

* Published: 2019-11-15

### Changes

* Update `eventId` and `html5` fields in `Recording` class.
* Update project setup and dependencies (using Kotlin 1.3.50).
* Customize user agent to let the API identify requests made by the library.
  * Provide `UserAgentInterceptor` class to be used by client apps.


## [v.2.0.0](https://github.com/johnjohndoe/c3media-base/releases/tag/v.2.0.0)

* Published: 2018-12-03

### Changes

* Update library for breaking API change. Thanks to [Stefan Medack][stefan-medack].
* Add new endpoints for loading conference via `acronym` and events via `guid`. Thanks to [Stefan Medack][stefan-medack].
* Add new `related` field to `Event` model. Thanks to [Stefan Medack][stefan-medack].
* Remove `metadata` field from `Event` model. Thanks to [Stefan Medack][stefan-medack].
* Clean up project (mostly Lint warnings and formatting).
* Update project setup and dependencies (sticking to Kotlin 1.2.71 to ease stepwise migration).


## [v.1.1.0](https://github.com/johnjohndoe/c3media-base/releases/tag/v.1.1.0)

* Published: 2018-02-24

### Changes

* Add new field `eventLastReleasedAt` to `Conference` model. Thanks to [Stefan Medack][stefan-medack].
* Fix `related` property which changed from `JSONArray` to `JSONObject` in the API.
* Remove `createdAt` field in `Event` model because it does not exist in the API. Thanks to [Stefan Medack][stefan-medack].
* Add `search` endpoint for `base` and `rx-java-2` module. Thanks to [Stefan Medack][stefan-medack].
* Remove VersionEye since the great service stopped its business.
* Update dependencies.


## [v.1.0.0](https://github.com/johnjohndoe/c3media-base/releases/tag/v.1.0.0)

* Published: 2017-09-23

### Changes

* This is the initial release. Have fun!
* Thanks to [Stefan Medack][stefan-medack] you can choose between Retrofit or RxJava2 return types.


[stefan-medack]: https://github.com/stefanmedack
