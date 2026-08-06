package androidx.webkit;

import java.lang.Throwable;

/* loaded from: classes2.dex */
public interface WebViewOutcomeReceiver<T, E extends Throwable> {
    default void onError(E e) {
    }

    void onResult(T t);
}
