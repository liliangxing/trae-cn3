package io.reactivex;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
