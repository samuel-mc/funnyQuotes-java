import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int optionMenu = -1;
        String[] buttons = {"1. Breaking Bad", "2. Lucifer", "3. Stranger Things",  "4. Salir"};

        do {
            String option = (String) JOptionPane.showInputDialog(null, "Selecciona una serie \n \n", "Quotes Chidas", JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);

            for (int i = 0; i < buttons.length; i++) {
                if (option.equals(buttons[i])) {
                    optionMenu = i;
                }
            }
            switch (optionMenu) {
                case 0:
                    QuoteService.getQuote("breaking-bad");
                    break;
                case 1:
                    QuoteService.getQuote("lucifer");
                    break;
                case 2:
                    QuoteService.getQuote("strangerthings");
                    break;
                default:
                    break;
            }
        } while(optionMenu != 3);
    }
}
