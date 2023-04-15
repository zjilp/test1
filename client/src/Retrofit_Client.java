import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.tomcat.jni.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/*In Bearbeitung*/
public class Retrofit_Client<Repo> {
    public interface GitHubService {
        @GET("users/{user}/repos")
        <Repo>
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

    GitHubService service = retrofit.create(GitHubService.class);

    Call<List<Repo>> repos = service.listRepos("octocat");

    @GET("users/list")

    @GET("users/list?sort=desc")

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);

    @POST("users/new")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);

    @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    Call<List<Widget>> widgetList() {
        return null;
    }

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("user")
    Call<User> getUser(@Header("Authorization") String authorization)

    @GET("user")
    Call<User> getUser(@HeaderMap Map<String, String> headers)

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    GitHubService service = retrofit.create(GitHubService.class);

}
