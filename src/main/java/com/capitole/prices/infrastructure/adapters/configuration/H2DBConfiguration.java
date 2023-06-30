package com.capitole.prices.infrastructure.adapters.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.capitole.prices.infrastructure.adapters.repositories.SpringDataJpaPriceRepository;

@EnableJpaRepositories(basePackageClasses = SpringDataJpaPriceRepository.class)
@Configuration
public class H2DBConfiguration {
}
