package com.malak.yaim.services;

import com.malak.yaim.model.FlickrFeed;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class FlickrService {

  public interface FlickrAPI {
    public static final String FLICKR_REST_ENDPOINT
        = "https://api.flickr.com/services/feeds/";

    public static final String RESPONSE_FORMAT = "json";
    public static final String NO_CALLBACK_METHOD = "?";
    public static final String TAGS_MODE = "any";

    @GET("photos_public.gne?format=" + RESPONSE_FORMAT + "&nojsoncallback=" + NO_CALLBACK_METHOD)
    Observable<FlickrFeed> getPublicFeed();

    /**
     * @param formattedTags - A comma delimited list of tags to filter the feed by.
     * */
    @GET("photos_public.gne?format=" + RESPONSE_FORMAT + "&nojsoncallback=" + NO_CALLBACK_METHOD +
         "&tagmode=" + TAGS_MODE + "&tags={tags}")
    Observable<FlickrFeed> getPublicFeedByTags(@Path("tags") String formattedTags);
  }
}
