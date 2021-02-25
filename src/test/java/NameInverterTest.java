import org.assertj.swing.assertions.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NameInverterTest {
    @Test
    void shouldThrowExceptionWhenNullProvided() {
        NameInverter nameInverter = new NameInverter();
        Throwable thrown = catchThrowable(() -> nameInverter.invert(null));
        Assertions.assertThat(thrown).isInstanceOf(NullPointerException.class);
    }
}
