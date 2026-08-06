package androidx.webkit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public abstract class WebResourceErrorCompat {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface NetErrorCode {
    }

    public abstract int getDebugCode();

    public abstract CharSequence getDescription();

    public abstract int getErrorCode();
}
