import domain.CreditCard;
import enums.CardType;
import repository.CardsRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Exercise7 {

    private final static Double TYPE1_INCREMENT = 0.25;
    private final static Double TYPE2_INCREMENT = 0.35;
    private final static Double TYPE3_INCREMENT = 0.40;
    private final static Double OTHER_INCREMENT = 0.50;

    private final CardsRepository cardsRepository = new CardsRepository();

    public static void main(String[] args) {

        Exercise7 ex7 = new Exercise7();

        ConsoleUtils console = new ConsoleUtils();
        do {
            try {
                ex7.hintUsers();
                String name = console.requestStringFromTerminal("Please enter your name to check your information or press X to exit: ");

                if (name.equals("X")) {
                    System.out.println("Goodbye!");
                    System.exit(Constants.ZERO);
                }
                ex7.checkCardInformation(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    private void checkCardInformation(String name) {
        System.out.println("Checking information...");
        List<CreditCard> cards = cardsRepository.getCardsByClientName(name);

        if (cards.isEmpty()) throw new RuntimeException("No cards found for " + name);

        System.out.println("======== Your cards information =========");
        cards.forEach(card -> System.out.println(card.toString()));

        CreditCard topTierCard = cards.stream().max(Comparator.comparing(c -> c.getCardType().getTier())).orElseThrow();

        String carPanLastDigits = topTierCard.getCardPan().split(" ")[3];
        System.out.println("You have an immediate upgrade with your card that ends with " + carPanLastDigits +
                ", your upgrade is from $" + topTierCard.getCreditLimit() + " to $" + calculateNewCreditLimit(topTierCard));

        if (cards.size() > 1) {
            System.out.println("You have more than one card, you can upgrade the other ones too! contact us for more information.");

            cards.stream().filter(c -> !c.equals(topTierCard)).forEach(card -> System.out.println("Card " + card.getCardType() + " can be upgraded from $" + card.getCreditLimit() + " to $" + calculateNewCreditLimit(card)));
        }
        System.out.println("=========================================");
    }


    private Double calculateNewCreditLimit(CreditCard card) {
        return card.getCreditLimit() + (card.getCreditLimit() * getCreditUpgradeRate().get(card.getCardType()));
    }

    private Map<CardType, Double> getCreditUpgradeRate() {
        return Map.of(
                CardType.TYPE1, TYPE1_INCREMENT,
                CardType.TYPE2, TYPE2_INCREMENT,
                CardType.TYPE3, TYPE3_INCREMENT,
                CardType.OTHER, OTHER_INCREMENT
        );

    }

    private void hintUsers() {
        System.out.println("You can use the following names to check the information type:< pepe, mario or juan > ");
    }
}
