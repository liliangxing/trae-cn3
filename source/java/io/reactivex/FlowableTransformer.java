package io.reactivex;

import org.reactivestreams.Publisher;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface FlowableTransformer<Upstream, Downstream> {
    Publisher<Downstream> apply(Flowable<Upstream> flowable);
}
