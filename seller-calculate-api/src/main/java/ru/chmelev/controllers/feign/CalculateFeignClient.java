package ru.chmelev.controllers.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.chmelev.config.FeignRequestInterceptor;
import ru.chmelev.dto.calculate.request.ProductionInformationRequestDto;
import ru.chmelev.dto.calculate.response.CalculatedDataResponseDto;

@FeignClient(name = "calculate-controller",url = "http://localhost:8090",configuration = FeignRequestInterceptor.class)
public interface CalculateFeignClient {

    @PostMapping ("/calculate-final-overall")
    CalculatedDataResponseDto calculateFinalOverall (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);

    @PostMapping ("/calculate-profit-overall")
    CalculatedDataResponseDto calculateProfitOverall (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);

    @PostMapping ("/calculate-profit-for-one")
    CalculatedDataResponseDto calculateProfitForOne (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);

    @PostMapping ("/calculate-final-for-one")
    CalculatedDataResponseDto calculateFinalForOne (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);
}
