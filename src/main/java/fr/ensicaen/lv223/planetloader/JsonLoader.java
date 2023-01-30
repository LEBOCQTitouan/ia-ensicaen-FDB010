package fr.ensicaen.lv223.planetloader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonLoader implements PlanetLoader {
    private final String dataSource;

    public JsonLoader(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public PlanetData[] load() {
        PlanetData[] loadedData = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            loadedData = mapper.readValue(getClass().getResource(this.dataSource), PlanetData[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedData;
    }
}
