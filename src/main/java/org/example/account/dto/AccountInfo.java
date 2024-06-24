package org.example.account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo { // client와 application이 주고 받는 응답
    // 다른 dto랑 비슷하지만 정해진 용도로만 사용할 수 있도록 만들어줌
    private String accountNumber;
    private Long balance;


}
