package com.jake.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jake.app.ipma_client.IpmaCityForecast;
import com.jake.app.ipma_client.IpmaService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    // todo: should generalize for a city passed as argument
    // private static final int CITY_ID_AVEIRO = 1010500;

    private static final Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void main(String[] args) {
        int CITY_ID_AVEIRO;

        if (args.length != 1) {
            System.out.println("ERRO: Número de argumentos inválido.");
            logger.error("Número de argumentos inválido.");
            System.exit(1);
        }

        CITY_ID_AVEIRO = Integer.parseInt(args[0]);

        // get a retrofit instance, loaded with the GSon lib to convert JSON into
        // objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        logger.info("Retrofit criado.");

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        logger.info("IPMA Service criado.");
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();
            logger.info("Resposta recebida.");

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf("max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));
                logger.info(
                        "max temp for " + firstDay.getForecastDate() + " is " + Double.parseDouble(firstDay.getTMax()));
            } else {
                System.out.println("No results for this request!");
                logger.error("No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
