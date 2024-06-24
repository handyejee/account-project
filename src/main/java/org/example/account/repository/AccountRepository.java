package org.example.account.repository;

import org.example.account.domain.Account;
import org.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


// Account 테이블에 접속하기 위한 repository
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // spring 에서 jpa를 손쉽게 사용하도록 도와주는 목적
    // 타입 : repository가 활용하게 될 타입, primitive 타입

    Optional<Account> findFirstByOrderByIdDesc();

    //Account 안에 AccountUser을 연관관계로 가지고 있기 때문에 가능
    Integer countByAccountUser(AccountUser accountUser);

    Optional<Account> findByAccountNumber(String AccountNumber);

    //account에 연관관계로 포함된 AccountUser가 있기 때문에 이 메소드가 인터페이스 안에서 자동으로생성
    List<Account> findByAccountUser(AccountUser accountUser);
}
