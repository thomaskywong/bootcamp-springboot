package com.vtxlab.bootcamp.bootcampsbthymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbthymeleaf.model.CoinData;
import com.vtxlab.bootcamp.bootcampsbthymeleaf.service.ApiService;

@Service
public class CoinDataService implements ApiService<CoinData> {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinData> fetchData() {

    String urlString = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin,ethereum,tether&%20token=CG-bwho9ocenw9LA9LoBbJQvGFa";

    CoinData[] coinDataList = restTemplate.getForObject(urlString, CoinData[].class);

    return Arrays.stream(coinDataList).collect(Collectors.toList());

  }
  
  

}
