package com.malak.yaim.services;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.malak.yaim.di.scopes.PerApp;
import com.malak.yaim.model.FlickrFeed;
import io.reactivex.Observable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.malak.yaim.services.FlickrService.FlickrAPI.FLICKR_ENDPOINT;

@PerApp
public class FlickrService {
  private FlickrAPI mFlickrAPI;

  @Inject public FlickrService() {
    buildFlickrService();
  }

  public FlickrAPI getFlickrAPI() {
    return mFlickrAPI;
  }

  private void buildFlickrService() {
    final OkHttpClient client = new OkHttpClient.Builder()
        .addNetworkInterceptor(new StethoInterceptor())
        .build();

    final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(FLICKR_ENDPOINT)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

    mFlickrAPI = retrofit.create(FlickrAPI.class);
  }

  public interface FlickrAPI {
    String FLICKR_ENDPOINT
        = "https://api.flickr.com/services/feeds/";

    String RESPONSE_FORMAT = "json";
    String NO_CALLBACK_METHOD = "?";
    String TAGS_MODE = "any";

    /**
     * @return FlickrFeed object which contains a list of image URLs from Flickr public feed.
     * */
    @GET("photos_public.gne?format=" + RESPONSE_FORMAT + "&nojsoncallback=" + NO_CALLBACK_METHOD)
    Observable<FlickrFeed> getPublicFeed();

    /**
     * @param formattedTags - A comma delimited list of tags to filter the feed by.
     * @return FlickrFeed which contains a list of images URLs
     * from Flickr public feed but filtered by given tags
     * */
    @GET("photos_public.gne?format=" + RESPONSE_FORMAT + "&nojsoncallback=" + NO_CALLBACK_METHOD + "&tagmode=" + TAGS_MODE)
    Observable<FlickrFeed> getPublicFeedByTags(@Nullable @Query("tags") String formattedTags);
  }
}