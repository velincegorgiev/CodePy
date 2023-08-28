package com.example.diansspring.bootstrap;

import com.example.diansspring.model.Amenity;
import com.example.diansspring.model.User;
import com.example.diansspring.model.enums.Role;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


@Component
public class DataHolder {
    public static List<Amenity> amenities = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    private static String PUBLIC_API = "https://raw.githubusercontent.com/SimonAnastasov/Dians/main/Domasna1/output/output.txt";
    private static String OUTPUT_FILE = "C:\\Users\\Ace\\Desktop\\2. ProjectSpring\\src\\main\\java\\com\\example\\diansspring\\bootstrap\\amenities.txt";

//    @PostConstruct
    public void init() {

        users.add(new User("simon","anastasov", "sa", "sa", Role.ROLE_USER));
        users.add(new User("velin","gjorgiev","vg", "vg", Role.ROLE_USER));
        users.add(new User("ace","gjorgjievski","ag", "ag", Role.ROLE_USER));

        try {
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getData() throws IOException {
        URL url = new URL(PUBLIC_API);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Check if connect is made
        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {

            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            List<String> amenitiesInputData = new ArrayList<>();

            String line = null;


            while ((line = reader.readLine()) != null) {
                amenitiesInputData.add(line);
            }

            List<Amenity> newAmenityList = amenitiesInputData.stream()
                    .skip(1)
                    .map(Amenity::create)
                    .collect(Collectors.toList());

            amenities.addAll(newAmenityList);
            System.out.println();
        }



    }

}
