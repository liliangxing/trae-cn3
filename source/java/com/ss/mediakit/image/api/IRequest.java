package com.ss.mediakit.image.api;

/* loaded from: classes7.dex */
public interface IRequest {
    default void cancel() {
    }

    default boolean isCanceled() {
        return false;
    }

    default void start(Callback callback) {
    }
}
