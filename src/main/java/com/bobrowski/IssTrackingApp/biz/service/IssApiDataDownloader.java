package com.bobrowski.IssTrackingApp.biz.service;

import com.bobrowski.IssTrackingApp.biz.model.ReportISS;
import com.bobrowski.IssTrackingApp.repositories.ReportsRepository;
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
public class IssApiDataDownloader implements IssApiDataDownloaderInterface{

    private final HttpClient client;
    private final Gson gson;
    private final ReportsRepository reportsRepository;

    private final HttpRequest requestPositionReport = HttpRequest.newBuilder()
            .uri(new URI("http://api.open-notify.org/iss-now.json"))
            .GET()
            .build();

    public IssApiDataDownloader(ReportsRepository reportsRepository) throws URISyntaxException {
        this.reportsRepository = reportsRepository;
        this.client = HttpClient.newHttpClient();
        gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDateTime.ofInstant(Instant.ofEpochSecond(json.getAsJsonPrimitive().getAsLong()),
                        TimeZone.getDefault().toZoneId());
            }
        }).create();
    }

    @Override
    public void run() {
        ReportISS reportISS = getIssPositionReport();
        if(Objects.nonNull(reportISS)) {
            reportsRepository.save(reportISS);
        }
    }

    private ReportISS getIssPositionReport(){
        HttpResponse<String> response;
        try {
            response = client.send(requestPositionReport, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, ReportISS.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
