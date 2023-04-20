package de.thdeg.systemdesign.server;

import java.time.OffsetDateTime;

public class BootClient {

    public static void main(String []args){
        Boot boot1 = new Boot();
        boot1.setId((long) 0);
        boot1.setKlasse("A");
        boot1.setCreated(OffsetDateTime.now());
        boot1.setSitze(10);
        boot1.setName("Boot 1");
        BootController bc = new BootController();
        bc.createBoot(boot1);

        Boot boot2 = new Boot();
        boot2.setId((long) 1);
        boot2.setKlasse("B");
        boot2.setCreated(OffsetDateTime.now());
        boot2.setSitze(10);
        boot2.setName("Boot 2");
        bc.createBoot(boot2);

        System.out.println(bc.getBoot((long)0));
        System.out.println(bc.getBoot((long)1));

    }
}
