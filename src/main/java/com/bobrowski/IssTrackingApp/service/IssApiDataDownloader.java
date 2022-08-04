package com.bobrowski.IssTrackingApp.service;

import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.biz.model.PeopleInSpaceReport;
import com.google.gson.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TimeZone;

@Component
public class IssApiDataDownloader implements IssApiDataDownloaderInterface {

    private final HttpClient client;
    private final Gson gson;
    private final PositionReportsService positionReportsService;
    private final PeopleInSpaceService astronautsService;
    private final String API_URL = "http://api.open-notify.org/";

    private final HttpRequest requestPositionReport = HttpRequest.newBuilder()
            .uri(new URI(API_URL + "iss-now.json"))
            .GET()
            .build();
    private final HttpRequest requestListOfPeopleReport = HttpRequest.newBuilder()
            .uri(new URI(API_URL + "astros.json"))
            .GET()
            .build();

    public IssApiDataDownloader(PositionReportsService positionReportsRepository, PeopleInSpaceService astronautsRepository) throws URISyntaxException {
        this.positionReportsService = positionReportsRepository;
        this.astronautsService = astronautsRepository;
        this.client = HttpClient.newHttpClient();
        gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDateTime.ofInstant(Instant.ofEpochSecond(json.getAsJsonPrimitive().getAsLong()),
                        TimeZone.getDefault().toZoneId());
            }
        }).create();
    }

    //TODO Removing astronauts returning from space.
    @Override
    public void run() {
        IssPositionReport reportISS = getIssPositionReport();
        PeopleInSpaceReport reportPeopleInSpace = getPeopleInSpaceReport();

        if (Objects.nonNull(reportISS)) {
            positionReportsService.save(reportISS);
        }

        if (Objects.nonNull(reportPeopleInSpace)) {
            reportPeopleInSpace.getAstronauts().forEach(astronaut -> {
                if (astronautsService.findByName(astronaut.getName()).isEmpty()) {
                    astronautsService.save(astronaut);
                }
            });
        }
    }

    private IssPositionReport getIssPositionReport() {
        HttpResponse<String> response;
        try {
            response = client.send(requestPositionReport, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, IssPositionReport.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PeopleInSpaceReport getPeopleInSpaceReport() {
        HttpResponse<String> response;
        try {
            response = client.send(requestListOfPeopleReport, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, PeopleInSpaceReport.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
