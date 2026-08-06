package io.reactivex.parallel;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> parallelFlowable);
}
