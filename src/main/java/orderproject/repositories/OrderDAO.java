package orderproject.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderDAO {         //  postman -> 8080 -> Dao -> 3306 -> mysql database

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private String sqlQuery;

    public OrderDAO() {
        sqlQuery = read("myScript.sql");
    }

    public List<String> getProductName(String name) {

            Map<String,String> params = new HashMap<>();
            params.put("name", name);

            List<String> productsList = jdbcTemplate.query(sqlQuery, params, (resultSet, rowNum) -> resultSet.getString(1));

            return productsList;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
