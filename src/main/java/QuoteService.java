import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import javax.swing.*;
import java.io.IOException;

public class QuoteService {
    /**
     * Traemos la quote de la API
     * @return regresa la respuesta brindada por la API
     */
    public static void getQuote ( String show) throws IOException {
        String url = "";
        if (show == "breaking-bad"){
            url = "https://breaking-bad-quotes.herokuapp.com/v1/quotes";
        }
        if (show == "lucifer"){
            url = "https://lucifer-quotes.herokuapp.com/v1/quotes";
        }
        if (show == "strangerthings"){
            url = "https://strangerthings-quotes.herokuapp.com/v1/quotes";
        }
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();
        jsonResponse = jsonResponse.substring(1, jsonResponse.length()); //Elimina los corchetes.
        jsonResponse = jsonResponse.substring(0, jsonResponse.length()-1); //Elimina los corchetes.

        Gson gson = new Gson();
        Quote quote = gson.fromJson(jsonResponse, Quote.class);
        String quoteGotten =  quote.getQuote() + "\n \n \n";
        String author = quote.getAuthor();
        try {
            ImageIcon icon = new ImageIcon("./BBLogo.png");
            String [] buttons = { "Ver otra frase", "Volver"};
            String option = (String) JOptionPane.showInputDialog(null, quoteGotten, author, JOptionPane.INFORMATION_MESSAGE, icon, buttons, buttons[0]);
            int optionSelected = -1;

            for (int i = 0; i < buttons.length; i++){
                if (option.equals(buttons[i])) {
                    optionSelected = i;
                }
            }

            switch (optionSelected) {
                case 0:
                    getQuote(show);
                    break;
                default:
                    break;
            }


        } catch ( Exception e ) {

        }


    }
}
