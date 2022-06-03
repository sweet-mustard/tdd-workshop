package swemu.tdd.junit;

import java.time.Instant;

public class Account {
    private final AccountHolder holder;
    private final Instant createdOn;
    private Money creditLimit;
    private Money balance;

    public Account(AccountHolder holder, Instant createdOn, Money creditLimit, Money balance) {
        this.holder = holder;
        this.createdOn = createdOn;
        this.creditLimit = creditLimit;
        this.balance = balance;
    }

    public AccountHolder getHolder() {
        return holder;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public Money getBalance() {
        return balance;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static final class AccountBuilder {
        private AccountHolder holder;
        private Instant createdOn;
        private Money creditLimit;
        private Money balance;

        private AccountBuilder() {
        }

        public AccountBuilder holder(AccountHolder holder) {
            this.holder = holder;
            return this;
        }

        public AccountBuilder createdOn(Instant createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public AccountBuilder creditLimit(Money creditLimit) {
            this.creditLimit = creditLimit;
            return this;
        }

        public AccountBuilder balance(Money balance) {
            this.balance = balance;
            return this;
        }

        public Account build() {
            return new Account(holder, createdOn, creditLimit, balance);
        }
    }
}
