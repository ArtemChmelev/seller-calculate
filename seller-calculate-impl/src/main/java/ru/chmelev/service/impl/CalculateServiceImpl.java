package ru.chmelev.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.chmelev.dto.calculate.request.ProductionInformationRequestDto;
import ru.chmelev.dto.calculate.response.CalculatedDataResponseDto;
import ru.chmelev.service.CalculateService;

@AllArgsConstructor
@Service
@Data
public class CalculateServiceImpl implements CalculateService {

    private final ModelMapper modelMapper;

    @Override
    public CalculatedDataResponseDto calculateFinalForOne(ProductionInformationRequestDto requestDto) {
        double cost = requestDto.getCost();
        double tax = requestDto.getTax() / 100;
        double commission = requestDto.getCommissionMarketplace() / 100;
        double profit = requestDto.getProfitPercentage() / 100;
        double finalPrice = ((cost) + (cost * profit)) / ((1 - tax) - (1 - tax) * commission);
        requestDto.setFinalPrice(finalPrice);

        return modelMapper.map(requestDto, CalculatedDataResponseDto.class);

    }

    @Override
    public CalculatedDataResponseDto calculateFinalOverall(ProductionInformationRequestDto requestDto) {
        double overallCost = requestDto.getOverallCost();
        double tax = requestDto.getTax() / 100;
        double commission = requestDto.getCommissionMarketplace() / 100;
        double profit = requestDto.getProfitPercentage() / 100;
        int count = requestDto.getCount();
        double finalPrice = ((overallCost / count) + ((overallCost/count) * profit)) / ((1 - tax) - (1 - tax) * commission);
        requestDto.setFinalPrice(finalPrice);

        return modelMapper.map(requestDto, CalculatedDataResponseDto.class);
    }

    @Override
    public CalculatedDataResponseDto calculateProfitForOne(ProductionInformationRequestDto requestDto) {
        double cost = requestDto.getCost();
        double tax = requestDto.getTax() / 100;
        double commission = requestDto.getCommissionMarketplace() / 100;
        double finalPrice = requestDto.getFinalPrice();
        double profit = (((1 - tax) * finalPrice - (1 - tax) * commission * finalPrice) - cost) / cost * 100;
        requestDto.setProfitPercentage(profit);
        return modelMapper.map(requestDto, CalculatedDataResponseDto.class);
    }

    @Override
    public CalculatedDataResponseDto calculateProfitOverall(ProductionInformationRequestDto requestDto) {
        double costPrice = requestDto.getOverallCost();
        double tax = requestDto.getTax() / 100;
        double commission = requestDto.getCommissionMarketplace() / 100;
        int count = requestDto.getCount();
        double finalPrice = requestDto.getFinalPrice();
        double profit = (((1 - tax) * finalPrice - (1 - tax) * commission * finalPrice) - costPrice / count) / (costPrice/count) * 100;
        requestDto.setProfitPercentage(profit);
        return modelMapper.map(requestDto, CalculatedDataResponseDto.class);

    }
}
