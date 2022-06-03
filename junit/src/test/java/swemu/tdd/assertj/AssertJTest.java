package swemu.tdd.assertj;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import swemu.tdd.junit.Account;
import swemu.tdd.junit.AccountMother;
import swemu.tdd.junit.InsufficientBalanceException;
import swemu.tdd.junit.Money;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

class AssertJTest {
    // NOTE: Assertions are chained here for the sake of
    // brevity. Chaining assertions is not encouraged
    // as it violates the single assertion principle

    @Test
    void string() {
        assertThat("John Doe")
                .startsWith("John")
                .endsWith("Doe")
                .isEqualToIgnoringCase("john DOE")
                .contains("Do")
                .doesNotContain("foobar");
    }

    @Test
    void number() {
        assertThat(123.45001)
                .isCloseTo(123.45, Offset.offset(0.001))
                .isGreaterThan(100)
                .isLessThan(150)
                .isPositive();
    }

    @Test
    void instant() {
        assertThat(Instant.parse("2022-05-01T12:13:14Z"))
                .isBefore(Instant.parse("2022-06-01T00:00:00Z"))
                .isAfter(Instant.parse("2022-04-01T00:00:00Z"))
                .isBetween(Instant.parse("2022-04-01T00:00:00Z"), Instant.parse("2022-06-01T00:00:00Z"));
    }

    @Test
    void collection() {
        var animals = List.of("cat", "dog", "cow", "ant", "llama");

        assertThat(animals).hasSize(5)
                .contains("llama", "cat")
                .containsSequence("cow", "ant")
                .doesNotContain("oak", "mushroom")
                .containsAnyOf("wombat", "dog")
                .containsExactlyInAnyOrder("llama", "cat", "cow", "dog", "ant");
    }

    @Test
    void extracting() {
        var accounts = List.of(
                AccountMother.withHolderNameAndBalance("John Doe", 1000.0),
                AccountMother.withHolderNameAndBalance("Jane Doe", 1500.0)
        );

        assertThat(accounts).extracting(
                account -> account.getHolder().getName(),
                Account::getBalance
        ).containsExactly(
                tuple("John Doe", 1000.0),
                tuple("Jane Doe", 1500.0)
        );
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> {
            throw new InsufficientBalanceException(
                    Money.of("EUR", 100.0),
                    Money.of("EUR", 90.0)
            );
        })
                .hasMessage("Required: EUR 100.0, balance: EUR 90.0")
                .isInstanceOfSatisfying(InsufficientBalanceException.class, e ->
                        assertThat(e.getRequired()).isEqualTo(Money.of("EUR", 100.0)));
    }
}
