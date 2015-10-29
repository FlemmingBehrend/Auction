package dk.topdanmark.registration.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// DDD Value Object
public class DateOfBirth {

    private Date date;

    private final String dateRegex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";

    public DateOfBirth(@Pattern(regexp = dateRegex) String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
        } // regex needs to be wrong for this to happen
        new DateOfBirth(date);
    }

    public DateOfBirth(@NotNull @Past Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

}
