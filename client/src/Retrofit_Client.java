import retrofit2.Retrofit;

import java.time.OffsetDateTime;

public class Retrofit_Client{
    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        BootApi service = retrofit.create(BootApi.class);

        Boot boot1 = new Boot();
        boot1.setId((long) 0);
        boot1.setKlasse("A");
        boot1.setCreated(OffsetDateTime.now());
        boot1.setSitze(10);
        boot1.setName("Boot 1");
        Retrofit_Client rc = new Retrofit_Client();

        service.createBoot(boot1);

    }

}
