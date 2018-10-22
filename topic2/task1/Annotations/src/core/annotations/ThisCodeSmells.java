package core.annotations;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Target ({ ANNOTATION_TYPE, CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE })
@Retention (RetentionPolicy.RUNTIME)
public @interface ThisCodeSmells {
    String reviewer ();

}
