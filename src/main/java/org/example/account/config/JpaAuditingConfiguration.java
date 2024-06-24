package org.example.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // spring에서 jpa auditing 사용할 수 있게 해줌
public class JpaAuditingConfiguration {
}
