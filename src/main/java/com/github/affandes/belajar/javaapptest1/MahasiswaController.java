package com.github.affandes.belajar.javaapptest1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MahasiswaController {

    private final List<Mahasiswa> dataMahasiswa;

    public MahasiswaController() {
        dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add(new Mahasiswa(
                "10123",
                "Andi",
                "Ekonomi",
                "Akuntansi",
                2020
        ));
        dataMahasiswa.add(new Mahasiswa(
                "10124",
                "Bunga",
                "Teknik",
                "Komputer",
                2020
        ));
        dataMahasiswa.add(new Mahasiswa(
                "10125",
                "Candra",
                "Teknik",
                "Perkapalan",
                2021
        ));
    }

    @GetMapping("/mhs")
    public Mahasiswa getByNim(@RequestParam(name = "nim") String nim) {
        return dataMahasiswa.stream().filter(o -> o.nim().equals(nim)).findFirst().orElse(null);
    }

}
