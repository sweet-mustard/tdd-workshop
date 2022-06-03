package swemu.tdd.junit.mockito;

public class JpaAccountRepository {
    private final EntityManager entityManager;

    public JpaAccountRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Account account) {
        entityManager.persist(toAccountData(account));
    }

    private AccountData toAccountData(Account account) {
        return new AccountData(account.accountNumber());
    }
}
