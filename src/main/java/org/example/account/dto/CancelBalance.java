package org.example.account.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.account.type.TransactionResultType;

import java.time.LocalDateTime;

public class CancelBalance {
    /**
     * "transactionId": abdkfjk12dkjfkdjfkj,
     * "accountNumber":"100000000",
     * "amount":1000
     *
     */

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        @NotBlank
        private String transactionId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;
    }

    /**
     * {
     *    "accountNumber":"1234567890",
     *    "transactionResult":"S",
     *    "transactionId":"c2033bb6d82a4250aecf8e27c49b63f6",
     *    "amount":1000,
     *    "transactedAt":"2022-06-01T23:26:14.671859"
     * }
     *
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber; // 계좌번호
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt; // 등록일시

        public static Response from(TransactionDto transactionDto){
            return Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResult(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }
    }
}
