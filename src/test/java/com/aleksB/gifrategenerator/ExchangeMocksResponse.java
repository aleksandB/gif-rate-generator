package com.aleksB.gifrategenerator;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class ExchangeMocksResponse {
    public static void setupMockExchangeResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/api/latest.json?app_id=c80f68cd0cf04bb38f7ec86f779aeec9"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        ExchangeMocksResponse.class.getClassLoader().getResourceAsStream("payload/exchange.json"),
                                        defaultCharset()))));
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/api/historical/2020-05-01.json?app_id=c80f68cd0cf04bb38f7ec86f779aeec9"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        ExchangeMocksResponse.class.getClassLoader().getResourceAsStream("payload/exchange_date.json"),
                                        defaultCharset()))));
    }



}
