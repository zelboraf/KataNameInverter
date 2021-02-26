import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.swing.assertions.Assertions.assertThat;

public class NameInverterTest {
    NameInverter nameInverter;

    @BeforeEach
    void setUp() {
        nameInverter = new NameInverter();
    }

    @Test
    void shouldThrowExceptionWhenNullProvided() {
        Throwable thrown = catchThrowable(() -> nameInverter.invert(null));
        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldReturnEmptyStringWhenEmptyInputProvided() {
        String result = nameInverter.invert("");
        assertThat(result).isEqualTo("");
    }
}
