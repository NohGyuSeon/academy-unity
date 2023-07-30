package com.daonplace.springbootweb.dto.api;

import lombok.Getter;
import java.util.List;

@Getter
public class AirPollutionApiResponse {
    private Response response;

    @Getter
    public static class Response {
        private ResponseBody body;
        private ResponseHeader header;
    }

    @Getter
    public static class ResponseBody {
        private int totalCount;
        private List<AirPollutionInfo> items;
    }

    @Getter
    public static class ResponseHeader {
        private String resultMsg;
        private String resultCode;
    }
}
