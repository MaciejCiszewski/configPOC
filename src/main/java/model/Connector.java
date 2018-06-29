package model;

import javax.validation.constraints.NotNull;


public class Connector {

    private String path;

    @NotNull
    private String resource;


    public String getPath() {
        return path;
    }


    public String getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return "Connector{" +
                "path='" + path + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }
}
