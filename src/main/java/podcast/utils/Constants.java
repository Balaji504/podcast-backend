package podcast.utils;

public class Constants {

  /* BUCKET NAMES */
  public static final String DB = System.getenv("DB_BUCKET_NAME");
  public static final String PODCASTS = System.getenv("PODCASTS_BUCKET_NAME");

  /* RESOURCE NAMES */
  public static final String USER = "user";
  public static final String SESSION = "session";
  public static final String SERIES = "series";
  public static final String EPISODE = "episode";
  public static final String FOLLOWER = "follower";
  public static final String FOLLOWING = "following";
  public static final String RELEASE = "release";
  public static final String RECOMMENDATION = "recommendation";

  /* FIELDS */
  public static final String TYPE = "type";
  public static final String ID = "id";
  public static final String GOOGLE_ID = "googleId";
  public static final String EMAIL = "email";
  public static final String FIRST_NAME = "firstName";
  public static final String LAST_NAME = "lastName";
  public static final String IMAGE_URL = "imageUrl";
  public static final String NUMBER_FOLLOWERS = "numberFollowers";
  public static final String NUMBER_FOLLOWING = "numberFollowing";
  public static final String USERNAME = "username";
  public static final String SESSION_TOKEN = "sessionToken";
  public static final String EXPIRES_AT = "expiresAt";
  public static final String UPDATE_TOKEN = "updateToken";
  public static final String NEW_USER = "newUser";
  public static final String TITLE = "title";
  public static final String COUNTRY = "country";
  public static final String AUTHOR = "author";
  public static final String IMAGE_URL_SM = "imageUrlSm";
  public static final String IMAGE_URL_LG = "imageUrlLg";
  public static final String FEED_URL = "feedUrl";
  public static final String GENRES = "genres";
  public static final String SERIES_ID = "seriesId";
  public static final String SERIES_TITLE = "seriesTitle";
  public static final String NUMBER_SUBSCRIBERS = "numberSubscribers";
  public static final String SUMMARY = "summary";
  public static final String PUB_DATE = "pubDate";
  public static final String DURATION = "duration";
  public static final String TAGS = "tags";
  public static final String FOLLOWINGS = "followings";
  public static final String FOLLOWERS = "followers";
  public static final String AUDIO_URL = "audioUrl";
  public static final String OWNER_ID = "ownerId";
  public static final String CREATED_AT = "createdAt";
  public static final String DELETED_FOLLOWING = "deletedFollowing";
  public static final String SUBSCRIPTION = "subscription";
  public static final String USER_ID = "userId";
  public static final String EPISODE_ID = "episodeId";
  public static final String FACEBOOK_ID = "facebookId";
  // TODO - more

  public static final String AUTHORIZATION = "Authorization";
  public static final String BEARER = "Bearer ";


  /* Secret encryption key */
  public static final String SECRET_KEY = System.getenv("SECRET_KEY");

  /* Number of bytes in a UUID */
  public static final Integer UUID_BYTES = 36;

  /** Types of various entities **/
  public static enum Type {
    USER,
    SESSION,
    SERIES,
    EPISODE,
    FOLLOWER,
    FOLLOWING,
    RELEASE,
    RECOMMENDATION,
    SUBSCRIPTION;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }
}
