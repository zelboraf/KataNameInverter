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

    @Test
    void shouldReturnEmptyStringWhenWhitespacesProvided() {
        String result = nameInverter.invert("   ");
        assertThat(result).isEqualTo("");
    }

    @Test
    void shouldReturnNameWhenOnlyNameProvided() {
        String result = nameInverter.invert("Jan ");
        assertThat(result).isEqualTo("Jan");
    }

    @Test
    void shouldReturnInvertedLastnameAndFirstname() {
        String result = nameInverter.invert("Jan Kowalski ");
        assertThat(result).isEqualTo("Kowalski, Jan");
    }

    @Test
    void shouldReturnInvertedLastnameAndFirstnameWithoutMaleHonorific() {
        String result = nameInverter.invert(" Mr.  Jan  Kowalski ");
        assertThat(result).isEqualTo("Kowalski, Jan");
    }

    @Test
    void shouldReturnInvertedLastnameAndFirstnameWithoutFemaleHonorific() {
        String result = nameInverter.invert(" Mrs.  Janina  Kowalska ");
        assertThat(result).isEqualTo("Kowalska, Janina");
    }

    @Test
    void shouldReturnInvertedLastnameFirstnameAndTitleWithoutFemaleHonorific() {
        String result = nameInverter.invert(" Mrs.  Janina  Kowalska  MEng");
        assertThat(result).isEqualTo("Kowalska, Janina MEng");
    }

    @Test
    void shouldReturnInvertedLastnameFirstnameAndThreeTitlesWithoutHonorific() {
        String result = nameInverter.invert(" Mr.  Jan  Kowalski    Jr.   MEng    M.D.  ");
        assertThat(result).isEqualTo("Kowalski, Jan Jr. MEng M.D.");
    }
}
