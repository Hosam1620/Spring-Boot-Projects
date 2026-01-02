package com.global.book.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
//generic type here for type of created by and modified by
public  class AuditingAwareImp implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Hossam");
    }
}
