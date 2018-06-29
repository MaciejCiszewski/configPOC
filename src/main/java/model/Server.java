package model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Server {

    @NotNull
    private String host;
    private Integer port;
    private String domain;
    @Valid
    private List<Connector> connectors;


    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getDomain() {
        return domain;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    @Override
    public String toString() {
        return "Server{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", domain='" + domain + '\'' +
                ", connectors=" + connectors +
                '}';
    }
}
