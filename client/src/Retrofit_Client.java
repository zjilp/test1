import de.thdeg.systemdesign.bootfahrt.client.api.BootApi;
import de.thdeg.systemdesign.bootfahrt.client.model.Boot;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

public class Retrofit_Client{
    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BootApi service = retrofit.create(BootApi.class);
        Boot boot1 = new Boot();

        boot1.setId((long) 2);
        boot1.setKlasse("A");
        boot1.setCreated(String.valueOf(OffsetDateTime.now()));
        boot1.setSitze(10);
        boot1.setName("Boot 3");

        Boot boot2 = new Boot();
        boot2.setId((long) 3);
        boot2.setKlasse("B");
        boot2.setCreated(String.valueOf(OffsetDateTime.now()));
        boot2.setSitze(10);
        boot2.setName("Boot 4");

        Call<Boot> callBoot1 = service.createBoot(boot1);
        Call<Boot> callBoot2 = service.createBoot(boot2);

        try {
            callBoot1.execute();
            callBoot2.execute();
            Call<List<Boot>> listCall = service.listBoote();
            Response<List<Boot>> execute = listCall.execute();
            System.out.println(execute.body());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
