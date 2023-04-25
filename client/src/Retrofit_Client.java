import de.thdeg.systemdesign.bootfahrt.client.api.BootApi;
import de.thdeg.systemdesign.bootfahrt.client.model.Boot;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.OffsetDateTime;

public class Retrofit_Client{
    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/boot/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BootApi service = retrofit.create(BootApi.class);
        Boot boot1 = new Boot();

        boot1.setId((long) 0);
        boot1.setKlasse("A");
        boot1.setCreated(OffsetDateTime.now());
        boot1.setSitze(10);
        boot1.setName("Boot 1");

        Boot boot2 = new Boot();
        boot2.setId((long) 1);
        boot2.setKlasse("B");
        boot2.setCreated(OffsetDateTime.now());
        boot2.setSitze(10);
        boot2.setName("Boot 2");

        service.createBoot(boot1);
        service.createBoot(boot2);
        System.out.println(service.listBoote());

    }
}
