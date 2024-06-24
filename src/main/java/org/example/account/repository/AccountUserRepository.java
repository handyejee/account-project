package org.example.account.repository;

import org.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository 어노테이션 사용하는 이유
 * Bean 등록: @Repository 어노테이션을 사용하면 해당 클래스가 스프링의 Bean으로 등록되어 Component Scan을 통해 자동으로 인식됩니다. 따라서 @Repository 어노테이션을 사용하지 않으면 직접 Bean으로 등록해줘야 합니다.
 * 예외 변환: 스프링 데이터 JPA는 데이터 엑세스 작업 중 발생하는 예외를 스프링이 제공하는 DataAccessException 계층 구조의 예외로 변환하여 처리합니다. @Repository 어노테이션은 이 예외 변환 기능을 활성화하는 역할도 수행합니다.
 * 의미 전달: @Repository 어노테이션은 해당 클래스가 데이터 접근 계층의 구현체임을 명시적으로 표현합니다. 이를 통해 코드의 가독성과 유지 보수성을 높일 수 있습니다.
 */
@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {
}
