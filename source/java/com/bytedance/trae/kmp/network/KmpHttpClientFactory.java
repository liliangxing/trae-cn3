package com.bytedance.trae.kmp.network;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.trae.kmp.host.KmpHostEnvironment;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHttpClientFactory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0013\u001a\u00020\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;", "", "rawClientFactory", "Lkotlin/Function0;", "Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;", "headerProvider", "Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;", "eventReporter", "Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;", "hostInfo", "Lcom/bytedance/trae/kmp/host/KmpHostInfo;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V", "client", "Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "getClient", "()Lcom/bytedance/trae/kmp/network/KmpHttpClient;", "client$delegate", "Lkotlin/Lazy;", PrefetchRequestConfig.METHOD_GET, "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpHttpClientFactory {
    public static final int $stable = 8;

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private final Lazy client;
    private final KmpHttpEventReporter eventReporter;
    private final KmpHttpHeaderProvider headerProvider;
    private final KmpHostInfo hostInfo;
    private final Function0<KmpRawHttpClient> rawClientFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public KmpHttpClientFactory(Function0<? extends KmpRawHttpClient> function0, KmpHttpHeaderProvider kmpHttpHeaderProvider, KmpHttpEventReporter kmpHttpEventReporter, KmpHostInfo kmpHostInfo) {
        Intrinsics.checkNotNullParameter(function0, "rawClientFactory");
        Intrinsics.checkNotNullParameter(kmpHttpHeaderProvider, "headerProvider");
        Intrinsics.checkNotNullParameter(kmpHttpEventReporter, "eventReporter");
        Intrinsics.checkNotNullParameter(kmpHostInfo, "hostInfo");
        this.rawClientFactory = function0;
        this.headerProvider = kmpHttpHeaderProvider;
        this.eventReporter = kmpHttpEventReporter;
        this.hostInfo = kmpHostInfo;
        this.client = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.kmp.network.KmpHttpClientFactory$$ExternalSyntheticLambda0
            public final Object invoke() {
                TraeKmpHttpClient client_delegate$lambda$0;
                client_delegate$lambda$0 = KmpHttpClientFactory.client_delegate$lambda$0(KmpHttpClientFactory.this);
                return client_delegate$lambda$0;
            }
        });
    }

    public /* synthetic */ KmpHttpClientFactory(Function0 function0, KmpHttpHeaderProvider kmpHttpHeaderProvider, KmpHttpEventReporter kmpHttpEventReporter, KmpHostEnvironment kmpHostEnvironment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, kmpHttpHeaderProvider, kmpHttpEventReporter, (i & 8) != 0 ? KmpHostEnvironment.INSTANCE : kmpHostEnvironment);
    }

    private final KmpHttpClient getClient() {
        return (KmpHttpClient) this.client.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TraeKmpHttpClient client_delegate$lambda$0(KmpHttpClientFactory kmpHttpClientFactory) {
        return new TraeKmpHttpClient((KmpRawHttpClient) kmpHttpClientFactory.rawClientFactory.invoke(), kmpHttpClientFactory.headerProvider, kmpHttpClientFactory.eventReporter, kmpHttpClientFactory.hostInfo);
    }

    public final KmpHttpClient get() {
        return getClient();
    }
}
