package weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.ipma_client.CityForecast;
import weather.ipma_client.IpmaCityForecast;
import weather.ipma_client.IpmaDistrictsIslands;
import weather.ipma_client.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    // todo: should generalize for a city passed as argument
    // private static final int CITY_ID_AVEIRO = 1010500;

    private static final Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void main(String[] args) {

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

        Call<IpmaDistrictsIslands> callSyncDistrits = service.getDistritsIslands();

        List<Integer> distritsIds = new ArrayList<>();
        HashMap<Integer, String> distrits = new HashMap<>();
        int randomDistrit = 0;

        try {
            Response<IpmaDistrictsIslands> apiResponse = callSyncDistrits.execute();
            IpmaDistrictsIslands forecast = apiResponse.body();
            logger.info("Resposta recebida.");

            distritsIds = new ArrayList<>();
            distrits = new HashMap<>();

            if (forecast != null) {
                for (IpmaDistrictsIslands distrit : forecast.getData()) {
                    distritsIds.add(distrit.getGlobalIdLocal());
                    distrits.put(distrit.getGlobalIdLocal(), distrit.getLocal());
                }

                randomDistrit = distritsIds.get((int) (Math.random() * distritsIds.size()));
            } else {
                System.out.println("No results for this request!");
                logger.error("No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (randomDistrit == 0) {
            System.out.println("ERRO: Não foi possível obter um distrito aleatório.");
            logger.error("Não foi possível obter um distrito aleatório.");
            System.exit(1);
        }

        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(randomDistrit);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();
            logger.info("Resposta recebida.");

            if (forecast != null) {
                List<CityForecast> data = forecast.getData();
                CityForecast day = data.get(0);
                logger.info(
                        "max temp for " + day.getForecastDate() + " in " + distrits.get(randomDistrit) + " is " +
                                Double.parseDouble(day.getTMax()));
            } else {
                logger.error("No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
