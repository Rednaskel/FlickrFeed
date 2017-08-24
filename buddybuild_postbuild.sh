#!/bin/bash

ls


pathToApk="${BUDDYBUILD_WORKSPACE}/app/build/outputs/apk/app-debug.apk"
echo $pathToApk

cd CalabashFlickrFeed
ruby --version
bundler --version
#gem install json -v '1.8.6'

sudo bundle install

calabash-android resign $pathToApk

calabash-android run $pathToApk --format pretty --format html --out report.html