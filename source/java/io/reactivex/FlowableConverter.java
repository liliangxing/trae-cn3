package io.reactivex;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
