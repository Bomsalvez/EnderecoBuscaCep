package estagio.ti.totem.vamosdnovo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController@RequestMapping("/endereco")
public class EnderecoController {

    @GetMapping("{cep}")
    public ResponseEntity<String> selectCep(@PathVariable String cep){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://viacep.com.br/ws/" + cep + "/json";
        return  restTemplate.getForEntity(url, String.class);
    }

    @GetMapping
    public ResponseEntity<String> selectCep(){
        return ResponseEntity.ok("Teste");
    }

}
