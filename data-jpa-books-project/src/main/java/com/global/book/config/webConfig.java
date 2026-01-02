package com.global.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "")
public class webConfig {
    @Bean
    //should careful about we interface and then meke creating from the implementation
    public AuditorAware<String> auditorAware() {
        return new AuditingAwareImp();
    }
}
