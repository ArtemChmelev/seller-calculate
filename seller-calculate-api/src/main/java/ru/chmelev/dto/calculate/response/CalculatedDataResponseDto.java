package ru.chmelev.dto.calculate.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatedDataResponseDto {

    private Double profitPercentage;

    private Double finalPrice;

}
