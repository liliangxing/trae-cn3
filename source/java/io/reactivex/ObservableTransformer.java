package io.reactivex;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> apply(Observable<Upstream> observable);
}
