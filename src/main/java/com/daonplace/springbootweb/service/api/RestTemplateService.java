package com.daonplace.springbootweb.service.api;

import com.daonplace.springbootweb.dto.api.AirPollutionApiResponse;
import com.daonplace.springbootweb.dto.api.AirPollutionInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownContentTypeException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class RestTemplateService {

    public AirPollutionInfo getAirPollution() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://apis.data.go.kr")
                .path("/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty")
                .queryParam("stationName", "서석동")
                .queryParam("dataTerm", "daily")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1)
                .queryParam("returnType", "json")
                .queryParam("ver", "1.1")
                .queryParam("serviceKey", "WEBPlCO76moRw6PvbJbIl2jNCGsiX1kFIPWu3Gk6cFTlpzbqUsNBhpYIQMqM85ZoMwXRoIOuw%2B%2F6ID4r8YykMA%3D%3D")
                .build().encode().toUri();

        RestTemplate restTemplate = new RestTemplate();

        try {
            AirPollutionApiResponse result = restTemplate.getForEntity(uri, AirPollutionApiResponse.class).getBody();
            return result.getResponse().getBody().getItems().get(0);
        } catch (UnknownContentTypeException e) {
            return new AirPollutionInfo("측정되지 않음", "측정되지 않음");
        }
    }
}
