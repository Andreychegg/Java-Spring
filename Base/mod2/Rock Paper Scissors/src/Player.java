import java.util.Random;

class Player {
    private VARIANTS choice;
    private String name;

    Player() {
        Random random = new Random();
        int rand = random.nextInt(VARIANTS.values().length);
        this.choice = VARIANTS.values()[rand];
        this.name = "Bot";
    }

    Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public String whoWins(Player player1, Player player2) {
        if (player1.choice == player2.choice) {
            return "Ничья";
        }

        if ((player1.choice == VARIANTS.ROCK && player2.choice == VARIANTS.SCISSORS) ||
                (player1.choice == VARIANTS.PAPER && player2.choice == VARIANTS.ROCK) ||
                (player1.choice == VARIANTS.SCISSORS && player2.choice == VARIANTS.PAPER)) {
            return "Победил игрок с именем: " + player1.name;
        } else return "Победил игрок с именем: " + player2.name;
    }
}
