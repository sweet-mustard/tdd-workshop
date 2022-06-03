package swemu.tdd.junit.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestWithMockito {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private JpaAccountRepository accountRepository;

    @Test
    void mockitoTest() {
        accountRepository.save(AccountMother.withAccountNumber("123456789"));

        verify(entityManager).persist(argThat((AccountData accountData) -> "123456789".equals(accountData.accountNumber())));
    }
}
