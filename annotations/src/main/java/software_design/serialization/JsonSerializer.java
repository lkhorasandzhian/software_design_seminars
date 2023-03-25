package software_design.serialization;

import software_design.annotation.Published;

import org.json.JSONObject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class JsonSerializer<T> {
    private final Set<Field> publishedFields = new HashSet<>();

    public JsonSerializer(Class<T> serializedClass) {
        // TODO: write code.
        for (Field field : ReflectionUtils.getAllFields(serializedClass)) {
            Published fieldAnnotation = field.getAnnotation(Published.class);

            if (fieldAnnotation != null) {
                publishedFields.add(field);
            }
        }
    }

    public JSONObject serialize(T obj) throws NoSuchFieldException, IllegalAccessException {
        JSONObject result = new JSONObject();

        // TODO: write code.
        for (Field field : publishedFields) {
            field.setAccessible(true);
            result.put(field.getName(), field.get(obj).toString());
        }

        return result;
    }
}
