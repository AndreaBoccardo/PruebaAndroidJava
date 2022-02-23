package cl.desafiolatm.pruebaandroidjava.cliente;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import cl.desafiolatm.pruebaandroidjava.LectorJson;
import cl.desafiolatm.pruebaandroidjava.modelo.Heroe;
import cl.desafiolatm.pruebaandroidjava.service.HeroeService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(AndroidJUnit4.class)
public class ClienteRetrofitTest {

    private MockWebServer server;
    private String body = LectorJson.lector("deck.json");

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start(8080);
        server.enqueue(new MockResponse().setResponseCode(200).setBody(body));
        server.url("id/1.json");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void test_apiSuccess() {
        HeroeService servicio = ClienteRetrofit.getInstance("http://localhost:8080/api/")
                .create(HeroeService.class);
        try {
            Heroe heroe = servicio.getHeroe1().execute().body();
            Truth.assertThat(heroe.getHeroe().size()).isEqualTo(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}