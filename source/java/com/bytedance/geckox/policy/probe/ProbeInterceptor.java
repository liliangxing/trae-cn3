package com.bytedance.geckox.policy.probe;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProbeInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/policy/probe/ProbeInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProbeInterceptor implements Interceptor {
    public SsResponse<?> intercept(Interceptor.Chain chain) throws Exception {
        String str;
        String name;
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request request = chain.request();
        SsResponse<?> proceed = chain.proceed(request);
        List headers = proceed.headers();
        if (headers == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header?>");
        }
        Iterator it = headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Header header = (Header) it.next();
            if (header == null || (name = header.getName()) == null) {
                str = null;
            } else {
                Locale locale = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
                if (name == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                str = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase(locale)");
            }
            if (Intrinsics.areEqual(str, ProbeManager.PROBE_RESPONSE_HEADER_NAME)) {
                ProbeManager probeManager = ProbeManager.INSTANCE;
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkExpressionValueIsNotNull(request, "request");
                String sb2 = sb.append(request.getHost()).append(request.getPath()).toString();
                String value = header.getValue();
                Intrinsics.checkExpressionValueIsNotNull(value, "h.value");
                probeManager.parseProbe(sb2, value);
                break;
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(proceed, ApmTrafficStats.TTNET_RESPONSE);
        return proceed;
    }
}
