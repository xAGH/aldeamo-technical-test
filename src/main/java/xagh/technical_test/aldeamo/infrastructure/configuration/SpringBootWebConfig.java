package xagh.technical_test.aldeamo.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringBootWebConfig implements WebMvcConfigurer {
    @SuppressWarnings({ "deprecation", "null" })
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // Configuration to accept paths with and without slash (/) at the end
        configurer.setUseTrailingSlashMatch(true);
    }
}