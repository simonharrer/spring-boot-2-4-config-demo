package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("variant-prod")
class VariantProdConfigTests {

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
    assertThat(prodLoaded).isEqualTo(false);
    assertThat(variantProdLoaded).isEqualTo(true);

    assertThat(created).isEqualTo("application-variant-prod.properties");
  }

}
