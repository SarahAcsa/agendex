package br.com.agendex.entidade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lowagie.text.pdf.codec.Base64.InputStream;

public class BuscaCEP {
    
    public static Endereco buscarCep(String cep) {
        Endereco endereco = null;
        String json;
        
        try {
            
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            if(connection.getResponseCode() == 200) {
                
                InputStream is = (InputStream) connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder jsonSb = new StringBuilder();
                br.lines().forEach(l -> jsonSb.append(l.trim()));
                json = jsonSb.toString();
                
                Map<String,String> map = new HashMap<>();

                Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
                while (matcher.find()) {
                    String[] group = matcher.group().split(":");
                    map.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
                }
                
                endereco = new Endereco(
                        map.get("logradouro"),
                        map.get("complemento"),
                        map.get("bairro"),
                        map.get("localidade"),
                        map.get("uf"),
                        map.get("cep")
                        );
                          
            } else {
                throw new Exception("CEP não encontrado!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }
    
}
