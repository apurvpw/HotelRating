package com.demo.springbootmongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DBSeeder(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot =  new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                    new Review("John", 8, false),
                    new Review("Bruce", 7, true)
                )
        );

        Hotel scandic =  new Hotel(
                "Scandic",
                90,
                new Address("Copenhagen", "Denmark"),
                Arrays.asList(
                        new Review("Hal", 6, true),
                        new Review("Krissy", 9, true)
                )
        );

        Hotel motelOne =  new Hotel(
                "Motel One",
                110,
                new Address("Vienna", "Austria"),
                Arrays.asList(
                        new Review("Chirstina", 9, true),
                        new Review("Ross", 8, true)
                )
        );

        // Drop all Hotels
        this.hotelRepository.deleteAll();

        // add our Hotels to the DB
        List<Hotel> hotels = Arrays.asList(marriot, scandic, motelOne);
        this.hotelRepository.save(hotels);
    }
}
