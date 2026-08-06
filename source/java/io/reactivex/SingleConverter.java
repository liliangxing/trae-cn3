package io.reactivex;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface SingleConverter<T, R> {
    R apply(Single<T> single);
}
