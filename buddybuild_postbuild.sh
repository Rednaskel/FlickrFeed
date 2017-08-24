#!/bin/bash

ls
cd CalabashFlickrFeed
bundle install

pathToApk="${BUDDYBUILD_WORKSPACE}/app/build/outputs/apk/app-debug.apk"
echo $pathToApk

calabash-android resign $pathToApk

calabash-android run $pathToApk --format pretty --format html --out report.html