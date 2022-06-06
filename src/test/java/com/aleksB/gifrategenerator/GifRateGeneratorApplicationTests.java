package com.aleksB.gifrategenerator;

import com.aleksB.gifrategenerator.service.client.ExchangeClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
class GifRateGeneratorApplicationTests {

	@Autowired
	private WireMockServer mockExchangeService;

	@Autowired
	private ExchangeClient exchangeClient;

	@Value("${aleksB.app.app_id}")
	private String appId;

	@BeforeEach
	void setUp() throws IOException{
		ExchangeMocksResponse.setupMockExchangeResponse(mockExchangeService);
	}

	//Test for today rate request
	@Test
	public void whenGetExchangeTodayRate_thenExchangeRateShouldBeReturned(){
		assertFalse(exchangeClient.getTodayRates(appId).getRates().isEmpty());
	}

	@Test
	public void whenGetExchangeTodayRate_thenTheCorrectExchangeShouldBeReturned() {
		assertTrue(exchangeClient.getTodayRates(appId).getRates().containsValue(0.797216));
	}

	//Test for yesterday rate request
	@Test
	public void whenGetExchangeYesterdayRate_thenExchangeRateShouldBeReturned(){
		assertFalse(exchangeClient.getYesterdayRates(appId, "2020-05-01").getRates().isEmpty());
	}

	@Test
	public void whenGetYesterdayRate_thenTheCorrectExchangeShouldBeReturned() {
		assertTrue(exchangeClient.getYesterdayRates(appId, "2020-05-01").getRates().containsValue(0.799872));

	}

}
