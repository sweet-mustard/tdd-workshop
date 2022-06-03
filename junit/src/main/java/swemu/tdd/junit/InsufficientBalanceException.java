package swemu.tdd.junit;

public class InsufficientBalanceException extends RuntimeException {
    private final Money required;
    private final Money balance;

    public InsufficientBalanceException(Money required, Money balance) {
        super("Required: %s, balance: %s".formatted(required, balance));
        this.required = required;
        this.balance = balance;
    }

    public Money getRequired() {
        return required;
    }

    public Money getBalance() {
        return balance;
    }
}
