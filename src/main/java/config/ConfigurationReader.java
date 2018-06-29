package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.util.Set;

public class ConfigurationReader {
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory()).setDefaultMergeable(true);
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> T readBaseConfig(String configPath, Class<T> clazz) throws Exception {
            return YAML_MAPPER.readValue(new File(configPath), clazz);
    }

    public static <T> T extendConfig(String configPath, T baseConfig) throws Exception {
            T config = YAML_MAPPER.readerForUpdating(baseConfig).readValue(new File(configPath));
            Set<ConstraintViolation<T>> violations = factory.getValidator().validate(config);
            if (!violations.isEmpty()) {
                throw new RuntimeException(violations.toString());
            }
            return config;
    }
}
