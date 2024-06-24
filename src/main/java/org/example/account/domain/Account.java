package org.example.account.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.account.exception.AccountException;
import org.example.account.type.AccountStatus;
import org.example.account.type.ErrorCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
// spring jpa에서 시간에 대해 자동으로 값 넣어줌
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    // Account 테이블에 pk를 id로 지정해주겠다

    @ManyToOne
    private AccountUser accountUser; // 그냥 user로 하면 db테이블 시스템 유저테이블과 충돌발생할수있음

    private String accountNumber;

    @Enumerated(EnumType.STRING) // Enum값에 실제 문자열 이름 그대로 db에 저장
    private AccountStatus accountStatus;

    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    @CreatedDate //Entity 생성되어 저장될때 시간 자동저장
    private LocalDateTime createdAt;
    @LastModifiedDate // 조회한 Entity 값 변경할때 시간 자동저장
    private LocalDateTime updatedAt;

    public void useBalance(Long amount){
        if(amount > balance){
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }

    public void cancelBalance(Long amount){
        if(amount < 0){
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance += amount;
    }
}
