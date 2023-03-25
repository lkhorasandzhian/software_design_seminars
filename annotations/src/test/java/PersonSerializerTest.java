import software_design.structure.Person;
import software_design.serialization.JsonSerializer;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PersonSerializerTest {

    @Test
    void personIsSerialized() {
        Person p = new Person("Ivan", "Ivanov", LocalDate.of(1997, 11, 2));

        JSONObject json;
        try {
            json = new JsonSerializer<>(Person.class).serialize(p);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            fail(exception.getMessage());
            return;
        }

        assertEquals("Ivan", json.get("firstName"));
        assertEquals("Ivanov", json.get("lastName"));
        assertEquals("1997-11-02", json.get("birthDate"));
    }
}
