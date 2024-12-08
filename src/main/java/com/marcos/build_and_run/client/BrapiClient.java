package com.marcos.build_and_run.client;

import com.marcos.build_and_run.client.dto.BrapiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "BrapiClient",
        url = "https://brapi.dev"
)

public interface BrapiClient {

    @GetMapping("/api/quote/{ticker}")
    BrapiResponseDto getQuote(@RequestParam("token") String token,
                              @PathVariable("ticker") String ticker);


}
