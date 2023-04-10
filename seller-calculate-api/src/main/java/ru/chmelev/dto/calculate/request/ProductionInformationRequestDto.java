package ru.chmelev.dto.calculate.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionInformationRequestDto {

    private Double commissionMarketplace;

    private Double tax;

    private Integer count;

    private Double cost;

    private Double overallCost;

    private Double profitPercentage;

    private Double finalPrice;
}
