package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
class ProdConfigTests {

  @Value("${created}")
  String created;

  @Value("${properties.application:false}")
  Boolean defaultLoaded;

  @Value("${properties.application.prod:false}")
  Boolean prodLoaded;

  @Value("${properties.application.prod.variant:false}")
  Boolean variantProdLoaded;

  @Test
  void contextLoads() {
    assertThat(defaultLoaded).isEqualTo(true);
    assertThat(prodLoaded).isEqualTo(true);
    assertThat(variantProdLoaded).isEqualTo(false);

    assertThat(created).isEqualTo("application-prod.properties");

    // loads first application properties, then application-prod.properties
  }

}
