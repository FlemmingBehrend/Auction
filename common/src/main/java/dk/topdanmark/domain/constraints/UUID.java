package dk.topdanmark.domain.constraints;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Documented
@Target({
    ElementType.ANNOTATION_TYPE,
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.CONSTRUCTOR,
    ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}", message = "Not valid UUID format")
@NotNull(message = "UUID can not be null")
public @interface UUID {
}
