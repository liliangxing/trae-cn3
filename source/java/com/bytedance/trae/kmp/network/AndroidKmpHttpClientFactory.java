package com.bytedance.trae.kmp.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AndroidKmpHttpClientFactory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;", "", "<init>", "()V", "factory", "Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpHttpClientFactory {
    public static final AndroidKmpHttpClientFactory INSTANCE = new AndroidKmpHttpClientFactory();
    private static final KmpHttpClientFactory factory = new KmpHttpClientFactory(new Function0() { // from class: com.bytedance.trae.kmp.network.AndroidKmpHttpClientFactory$$ExternalSyntheticLambda0
        public final Object invoke() {
            KmpRawHttpClient factory$lambda$0;
            factory$lambda$0 = AndroidKmpHttpClientFactory.factory$lambda$0();
            return factory$lambda$0;
        }
    }, new NativeKmpHttpHeaderProvider(null, null, null, 7, null), new NativeKmpHttpEventReporter(null, 1, null), null, 8, null);
    public static final int $stable = 8;

    private AndroidKmpHttpClientFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KmpRawHttpClient factory$lambda$0() {
        KmpNetworkInitializer.INSTANCE.ensureRegistered();
        return new AndroidKmpRawHttpClient(null, null, 3, null);
    }

    public final KmpHttpClient get() {
        return factory.get();
    }
}
