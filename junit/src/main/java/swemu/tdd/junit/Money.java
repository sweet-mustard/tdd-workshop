package swemu.tdd.junit;

import java.util.Objects;

public class Money {
    private final String currency;
    private final Double amount;

    private Money(String currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money of(String currency, Double amount) {
        return new Money(currency, amount);
    }

    @Override
    public String toString() {
        return currency + ' ' + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(currency, money.currency) && Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
