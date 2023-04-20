package de.thdeg.systemdesign.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BootController implements BootApi {
    private List<Boot> boote = new ArrayList<Boot>();

    @Override
    public ResponseEntity<Boot> createBoot(Boot body) {
        boote.add(body);
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<Boot> getBoot(Long id) {
        return ResponseEntity.ok(boote.get(Math.toIntExact(id)));
    }

}

