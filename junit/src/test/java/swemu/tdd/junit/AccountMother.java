package swemu.tdd.junit;

import java.time.Instant;

public class AccountMother {
    public static Account withHolderNameAndBalance(String holderName, Double balance) {
        return Account.builder()
                .holder(new AccountHolder(holderName, "256, Test Boulevard", "78912", "TDD City"))
                .createdOn(Instant.parse("2016-05-12T14:23:57Z"))
                .creditLimit(Money.of("EUR", 500.00))
                .balance(Money.of("EUR", balance))
                .build();
    }
}
