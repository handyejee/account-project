package org.example.account.dto;

import lombok.*;
import org.example.account.domain.Account;

import java.time.LocalDateTime;

// Entity class랑 비슷한데(Account class) 더 단순하고 필요한 것만 넣어둔다

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private Long userId;
    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    // 엔티티를 통해 만들어지는 dto는 생성자를 만들어주는 것보다
    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance()) // balance를 담아줘야 조회할 수 있다
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
