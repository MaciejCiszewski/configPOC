package config;


import model.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {

        //Read basicConfiguration
        Configuration basicConfiguration = ConfigurationReader.readBaseConfig("src/main/resources/conf.yaml", Configuration.class);
        System.out.println(basicConfiguration.toString());


        //Read dev configuration based on basicConfiguration
        Configuration extendedConfiguration = ConfigurationReader.extendConfig("src/main/resources/conf-dev.yaml", basicConfiguration);
        System.out.println(extendedConfiguration);


        //Read dev configuration missing required field based on basicConfiguration
        try {
            ConfigurationReader.extendConfig("src/main/resources/conf-dev-error.yaml", basicConfiguration);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }



}
