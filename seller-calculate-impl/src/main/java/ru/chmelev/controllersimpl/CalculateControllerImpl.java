package ru.chmelev.controllersimpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.chmelev.controllers.CalculateController;
import ru.chmelev.dto.calculate.request.ProductionInformationRequestDto;
import ru.chmelev.dto.calculate.response.CalculatedDataResponseDto;
import ru.chmelev.service.CalculateService;

@RestController
@AllArgsConstructor
@Slf4j
public class CalculateControllerImpl implements CalculateController {
    CalculateService calculateService;


    @Override
    public ResponseEntity<?> calculateFinalForOne(ProductionInformationRequestDto informationRequestDto) {
        log.info("Request for calculating the final price for one product");
        CalculatedDataResponseDto responseDto = calculateService.calculateFinalForOne(informationRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<?> calculateFinalOverall(ProductionInformationRequestDto informationRequestDto) {
        log.info("Request for calculating the final price for overall");
        CalculatedDataResponseDto responseDto = calculateService.calculateFinalOverall(informationRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<?> calculateProfitForOne(ProductionInformationRequestDto informationRequestDto) {
        log.info("Request to calculate profit for one product");
        CalculatedDataResponseDto responseDto = calculateService.calculateProfitForOne(informationRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<?> calculateProfitOverall(ProductionInformationRequestDto informationRequestDto) {
        log.info("Request to calculate profit for overall");
        CalculatedDataResponseDto responseDto = calculateService.calculateProfitOverall(informationRequestDto);
        return ResponseEntity.ok(responseDto);
    }


}

