package ru.chmelev.service;

import ru.chmelev.dto.calculate.request.ProductionInformationRequestDto;
import ru.chmelev.dto.calculate.response.CalculatedDataResponseDto;

public interface CalculateService {
    CalculatedDataResponseDto calculateFinalForOne(ProductionInformationRequestDto productionInformationRequestDto);

    CalculatedDataResponseDto calculateFinalOverall(ProductionInformationRequestDto productionInformationRequestDto);

    CalculatedDataResponseDto calculateProfitForOne(ProductionInformationRequestDto productionInformationRequestDto);

    CalculatedDataResponseDto calculateProfitOverall(ProductionInformationRequestDto productionInformationRequestDto);

}
