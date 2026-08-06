package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYFeatureStoreInstance.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "TAG", "", "featureStore", "Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "getFeatureStore", "()Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "listeners", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance$FeatureStoreReadyListener;", "notifyAllListener", "", "notifyAllListener$pitayacore_release", "registerReadyListener", "listener", "FeatureStoreReadyListener", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PTYFeatureStoreInstance implements ReflectionCall {
    private static final String TAG = "PTYFeatureStoreInstance";
    public static final PTYFeatureStoreInstance INSTANCE = new PTYFeatureStoreInstance();
    private static final IFeatureStore featureStore = new AndroidFeatureStore();
    private static final Set<FeatureStoreReadyListener> listeners = new LinkedHashSet();

    /* compiled from: PTYFeatureStoreInstance.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance$FeatureStoreReadyListener;", "", "onReady", "", "featureStore", "Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface FeatureStoreReadyListener {
        void onReady(IFeatureStore featureStore);
    }

    private PTYFeatureStoreInstance() {
    }

    public final IFeatureStore getFeatureStore() {
        return featureStore;
    }

    public final void registerReadyListener(FeatureStoreReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            IFeatureStore iFeatureStore = featureStore;
            Intrinsics.checkNotNull(iFeatureStore, "null cannot be cast to non-null type com.bytedance.pitaya.api.feature.store.AndroidFeatureStore");
            IFeatureStore innerFeatureStore = ((AndroidFeatureStore) iFeatureStore).getInnerFeatureStore();
            if (innerFeatureStore != null) {
                listener.onReady(innerFeatureStore);
                Unit unit = Unit.INSTANCE;
            } else {
                Boolean.valueOf(listeners.add(listener));
            }
        }
    }

    public final void notifyAllListener$pitayacore_release(IFeatureStore featureStore2) {
        Intrinsics.checkNotNullParameter(featureStore2, "featureStore");
        synchronized (this) {
            Iterator<T> it = listeners.iterator();
            while (it.hasNext()) {
                ((FeatureStoreReadyListener) it.next()).onReady(featureStore2);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
