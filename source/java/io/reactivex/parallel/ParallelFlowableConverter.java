package io.reactivex.parallel;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface ParallelFlowableConverter<T, R> {
    R apply(ParallelFlowable<T> parallelFlowable);
}
