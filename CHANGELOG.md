# c3media-base changelog

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
