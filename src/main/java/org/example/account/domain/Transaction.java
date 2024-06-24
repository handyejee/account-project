package org.example.account.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.account.type.AccountStatus;
import org.example.account.type.TransactionResultType;
import org.example.account.type.TransactionType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    // Account 테이블에 pk를 id로 지정해주겠다

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne // 일대다
    private Account account;
    private Long amount;
    private Long balanceSnapshot;

    private String transactionId;
    private LocalDateTime transactedAt;

    @CreatedDate //Entity 생성되어 저장될때 시간 자동저장
    private LocalDateTime createdAt;
    @LastModifiedDate // 조회한 Entity 값 변경할때 시간 자동저장
    private LocalDateTime updatedAt;
}
