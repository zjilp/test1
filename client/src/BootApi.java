
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;


public interface BootApi {
  /**
   * Create or modify a boat
   * 
   * @param body Das Boot was gespeichert werde soll (required)
   * @return Call&lt;Boot&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("boot/")
  Call<Boot> createBoot(
    @Body Boot body
  );

  /**
   * Delete a boat by it&#x27;s id
   * 
   * @param id  (required)
   * @return Call&lt;String&gt;
   */
  @DELETE("boot/{id}")
  Call<String> deleteBoot(
    @Path("id") Long id
  );

  /**
   * Get a boat by id
   * 
   * @param id  (required)
   * @return Call&lt;Boot&gt;
   */
  @GET("boot/{id}")
  Call<Boot> getBoot(
    @Path("id") Long id
  );

  /**
   * List all boats
   * Mit dieser Methode können Sie die Liste von im System integrierten Booten laden.
   * @return Call&lt;List&lt;Boot&gt;&gt;
   */
  @GET("boot/")
  Call<List<Boot>> listBoote();
    

  /**
   * Create or modify a boat
   * 
   * @param body Das Boot was gespeichert werde soll (required)
   * @return Call&lt;Boot&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("boot/")
  Call<Boot> saveBoot(
    @Body Boot body
  );

}
