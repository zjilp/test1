package de.thdeg.systemdesign.server;

import de.thdeg.systemdesign.bootfahrt.api.BootApi;
import de.thdeg.systemdesign.bootfahrt.model.Boot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BootController implements BootApi {
    List<Boot> boote = new ArrayList<Boot>();

     BootController(){
         Boot boot0;
         Boot boot1;
         boot1 = new Boot();
         boot1.setId((long) 1);
         boot1.setKlasse("A");
         boot1.setCreated(OffsetDateTime.now());
         boot1.setSitze(10);
         boot1.setName("Boot 1");
         boot0 = new Boot();
         boot0.setId((long) 0);
         boot0.setKlasse("B");
         boot0.setCreated(OffsetDateTime.now());
         boot0.setSitze(5);
         boot0.setName("Boot 0");
         boote.add(boot0);
         boote.add(boot1);
    }
    @Override
    public ResponseEntity<Boot> createBoot(Boot body) {
        boote.add(body);
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<List<Boot>> listBoote() {
        return new ResponseEntity<>(boote, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boot> getBoot(Long id) {
        return ResponseEntity.ok(boote.get(Math.toIntExact(id)));
    }

}

