package ru.chmelev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.chmelev.dto.calculate.request.ProductionInformationRequestDto;

public interface CalculateController {
    @PostMapping ("/calculate-final-overall")
    ResponseEntity<?> calculateFinalOverall (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);

    @PostMapping ("/calculate-profit-overall")
    ResponseEntity<?> calculateProfitOverall (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);

    @PostMapping ("/calculate-profit-for-one")
    ResponseEntity<?> calculateProfitForOne (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);

    @PostMapping ("/calculate-final-for-one")
    ResponseEntity<?> calculateFinalForOne (@RequestBody @Validated ProductionInformationRequestDto productionInformationRequestDto);
}
