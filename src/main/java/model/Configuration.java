package model;

import javax.validation.Valid;

public class Configuration {

    @Valid
    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "server=" + server +
                '}';
    }
}
