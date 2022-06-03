package swemu.tdd.junit.mockito;

public class AccountMother {
    public static Account withAccountNumber(String accountNumber) {
        return new Account(accountNumber);
    }
}
