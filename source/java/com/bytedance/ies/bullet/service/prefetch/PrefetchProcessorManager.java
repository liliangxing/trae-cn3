package com.bytedance.ies.bullet.service.prefetch;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.tools.prefetch.IPrefetchProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PrefetchProcessorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/PrefetchProcessorManager;", "", "()V", "PREFETCH_BRIDGE_KEY", "", "PREFETCH_SCHEMA_KEY", "PREFETCH_VAL_UG", "processorMap", "", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "getProcessorByParams", "params", "Lorg/json/JSONObject;", "getProcessorByUrl", "url", "registerProcessor", "", PrefetchProcessorManager.PREFETCH_BRIDGE_KEY, "processor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchProcessorManager {
    private static final String PREFETCH_BRIDGE_KEY = "business";
    private static final String PREFETCH_SCHEMA_KEY = "prefetch_business";
    public static final String PREFETCH_VAL_UG = "lucky_page";
    public static final PrefetchProcessorManager INSTANCE = new PrefetchProcessorManager();
    private static final Map<String, IPrefetchProcessor> processorMap = new LinkedHashMap();

    private PrefetchProcessorManager() {
    }

    public final void registerProcessor(String business, IPrefetchProcessor processor) {
        Intrinsics.checkNotNullParameter(business, PREFETCH_BRIDGE_KEY);
        Intrinsics.checkNotNullParameter(processor, "processor");
        processorMap.put(business, processor);
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Register Processor: " + processor + " For Business: " + business, null, "XPreRender", 2, null);
    }

    public final IPrefetchProcessor getProcessorByUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        IPrefetchProcessor iPrefetchProcessor = StringsKt.contains$default(url, "prefetch_business=lucky_page", false, 2, (Object) null) ? processorMap.get(PREFETCH_VAL_UG) : null;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Get Processor: " + iPrefetchProcessor + " For Url: " + url, null, "XPreRender", 2, null);
        return iPrefetchProcessor;
    }

    public final IPrefetchProcessor getProcessorByParams(JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Result.Companion companion = Result.Companion;
            r1 = params.optString(PREFETCH_BRIDGE_KEY).equals(PREFETCH_VAL_UG) ? processorMap.get(PREFETCH_VAL_UG) : null;
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Get Processor: " + r1 + " For Params: " + params, null, "XPreRender", 2, null);
        return r1;
    }
}
