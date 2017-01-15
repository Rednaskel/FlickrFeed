YAIM - Yet Another Image WUT?

Any questions? maciejmalak@gmail.com

This application is not an end-to-end solution.
I would appreciate any comments about code style.

I wanted to show how I can handle concepts such as:
* MVP architecture, SOLID
* basic of DI and Reactive
* knowledge about modern android tech stack = libraries, tools, patterns

Features:
* can show images from Flickr feed with basic metadata if present
* can refresh
* offline - nothing happens

Libs
* LeakCanary 1.5 - to track and deal with memory leaks efficiently
* Hugo 1.2.1 - (used during development) - fast and effortless logging mechanism
* Retrofit 2.1.0 
* Gson Converter 2.8.0 
* RxJava2 2.0.4
* RxAndroid 2.0.1
* RxAdapter 1.0.0
* Dagger2 2.7 - The only choice left. No reflection, fast.
* Retrolambda 3.3.1 - I didn't want to migrate to 1.8 fully and use Jack&Jill toolchain so I used it
* Glide 3.7.0 - recommended by Google, with very nice cache, simple. 
* ButterKnife 8.4.0 - "A butter knife is like a dagger only infinitely less sharp." and because Jake did great work.

Resources:

glide_memory_cache.png attached.

The screenshot is a prove that Glide is caching images.
From the 3mimute5s to 3m25s I swyped slowly from top to bottom so images were downloaded one by one.
Then I swyped until 3m40s with furious anger up and down and again. 
No network operations, images were cached at the first step.
3m40s is a feed refresh event. Until 3m45s I was swyping fast throught entire list. 
It triggered "a lot of" network operation at one time. 
After 3m45s - again, images are cached, no network operations.
