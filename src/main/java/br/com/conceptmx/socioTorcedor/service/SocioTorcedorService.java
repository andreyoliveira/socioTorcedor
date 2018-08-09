package br.com.conceptmx.socioTorcedor.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/socioTorcedor")
public class SocioTorcedorService {

    @RequestMapping(value = "/getClientePorEmail/{email}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getClientePorEmail(@PathVariable String email){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity cliente = restTemplate.getForEntity("http://localhost:8080/serviceCliente/getPorEmail/" + email, RestTemplate.class);

        return cliente;
    }
}
