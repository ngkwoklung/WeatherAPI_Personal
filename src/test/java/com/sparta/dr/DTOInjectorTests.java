package com.sparta.dr;

import com.sparta.dr.DTO.WeatherResponseDTO;
import com.sparta.dr.connectionmanager.ConnectionManager;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.net.http.HttpResponse;
import static org.hamcrest.MatcherAssert.*;

public class DTOInjectorTests {

    @Test
    @DisplayName("Check ")
    void check() {
//        Mockito.when(ConnectionManager.getResponse("a")).thenReturn("{\"coord\":{\"lon\":0,\"lat\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"base\":\"stations\",\"main\":{\"temp\":294.82,\"feels_like\":295.55,\"temp_min\":294.82,\"temp_max\":294.82,\"pressure\":984,\"humidity\":96},\"visibility\":10000,\"wind\":{\"speed\":5.22,\"deg\":189,\"gust\":4.9},\"rain\":{\"1h\":0.25},\"clouds\":{\"all\":91},\"dt\":1662973919,\"sys\":{\"type\":2,\"id\":2008684,\"sunrise\":1662961990,\"sunset\":1663005590},\"timezone\":0,\"id\":6295630,\"name\":\"Globe\",\"cod\":200}");
//        WeatherResponseDTO weatherDTO = DTOInjector.injectDTO(ConnectionManager.getResponse("a"));
//        Assertions.assertNotNull(weatherDTO);

    }
}
