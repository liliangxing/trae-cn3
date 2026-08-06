package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.network.p010public.BizInterceptorManager;
import com.bytedance.kmp.network.p010public.ICommonHeaderProvider;
import com.bytedance.kmp.network.p010public.ICommonQueryProvider;
import com.bytedance.kmp.network.requet.Request;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: IKmpNetworkCommonParamsProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0007\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"cacheQueries", "", "", "cacheVersion", "", "commonParamsCacheMutex", "Lkotlinx/coroutines/sync/Mutex;", "initDone", "", "getInitDone", "()Z", "setInitDone", "(Z)V", "initKmpCinteropCommonParamsProvider", "", "network_service_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IKmpNetworkCommonParamsProviderKt {
    private static int cacheVersion = -1;
    private static boolean initDone;
    private static Map<String, String> cacheQueries = MapsKt.emptyMap();
    private static final Mutex commonParamsCacheMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public static final boolean getInitDone() {
        return initDone;
    }

    public static final void setInitDone(boolean z) {
        initDone = z;
    }

    public static final void initKmpCinteropCommonParamsProvider() {
        System.out.println((Object) "lzlog, init network interceptor");
        if (initDone) {
            return;
        }
        initDone = true;
        BizInterceptorManager.INSTANCE.addQueryProviderForCinteropRequest(new ICommonQueryProvider() { // from class: com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$1
            @Override // com.bytedance.kmp.network.p010public.ICommonQueryProvider
            public Map<String, String> getCommonParams(Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                return MapsKt.emptyMap();
            }

            @Override // com.bytedance.kmp.network.p010public.ICommonQueryProvider
            public Map<String, String> getCommonParams(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return (Map) BuildersKt.runBlocking$default((CoroutineContext) null, new C0198xcff59047(url, null), 1, (Object) null);
            }
        });
        BizInterceptorManager.INSTANCE.addHeaderProvider(new ICommonHeaderProvider() { // from class: com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2
            @Override // com.bytedance.kmp.network.p010public.ICommonHeaderProvider
            public Map<String, String> getCommonHeaders(Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                return (Map) BuildersKt.runBlocking$default((CoroutineContext) null, new C0200x95241bbe(request, null), 1, (Object) null);
            }

            @Override // com.bytedance.kmp.network.p010public.ICommonHeaderProvider
            public Map<String, String> getCommonHeaders(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return (Map) BuildersKt.runBlocking$default((CoroutineContext) null, new C0201x95241bbf(url, null), 1, (Object) null);
            }
        });
    }
}
