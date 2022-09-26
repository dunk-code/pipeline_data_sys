package com.pipeline.pipeline_data_sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    Contact DEFAULT_CONTACT = new Contact("dunkcode", "http://www.dunkcode.cn", "zsy3020000629@163.com");
    @Bean
    public Docket modelDocket(Environment environment) {
        ApiInfo apiInfo = new ApiInfo("api", "Model Documentation", "1.0", "http://www.dunkcode.cn",
                DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

        Profiles dev = Profiles.of("dev");
        boolean isDev = environment.acceptsProfiles(dev);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("model")
                .enable(isDev)
                .apiInfo(apiInfo)

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pipeline.pipeline_data_sys.controller"))
                .build();
    }


}
