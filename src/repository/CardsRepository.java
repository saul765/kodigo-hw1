package repository;

import domain.CreditCard;
import enums.CardType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CardsRepository {

    private final Map<String, List<CreditCard>> cardsRepository = new HashMap<>(
            Map.of(
                    "mario", List.of(
                            new CreditCard("XXXX XXXX XXXX 1234", 700.00, CardType.TYPE1)
                    ),
                    "pepe", List.of(
                            new CreditCard("XXXX XXXX XXXX 5332", 1550.00, CardType.TYPE2),
                            new CreditCard("XXXX XXXX XXXX 9863", 5000.00, CardType.TYPE3)
                    ),
                    "juan", List.of(
                            new CreditCard("XXXX XXXX XXXX 1522", 3000.00, CardType.TYPE3),
                            new CreditCard("XXXX XXXX XXXX 1414", 6000.00, CardType.OTHER)
                    )
            ));

    public List<CreditCard> getCardsByClientName(String clientName) {
        return Optional.ofNullable(cardsRepository.get(clientName)).orElse(List.of());
    }
}
