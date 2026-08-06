package io.noties.prism4j.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface PrismBundle {
    String grammarLocatorClassName() default ".GrammarLocatorDef";

    String[] include() default {};

    boolean includeAll() default false;
}
