package com.bytedance.upc.common.monitor;

import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IUpcMonitorAndEventService;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/upc/common/monitor/UpcMonitor;", "", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "monitor", "", "serviceName", "", "category", "Lorg/json/JSONObject;", "metric", "logExtra", "monitorException", "e", "", "msg", "monitorInitCost", ReportUtil.Event.EVENT_INIT, "Lkotlin/Function0;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UpcMonitor {
    public static final UpcMonitor INSTANCE = new UpcMonitor();

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private static final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.common.monitor.UpcMonitor$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m2604invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    private final Configuration getMConfiguration() {
        return (Configuration) mConfiguration.getValue();
    }

    private UpcMonitor() {
    }

    public static /* synthetic */ void monitor$default(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        if ((i & 4) != 0) {
            jSONObject2 = null;
        }
        if ((i & 8) != 0) {
            jSONObject3 = null;
        }
        monitor(str, jSONObject, jSONObject2, jSONObject3);
    }

    @JvmStatic
    public static final void monitor(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        try {
            IUpcMonitorAndEventService iUpcMonitorAndEventService = INSTANCE.getMConfiguration().mUpcMonitorAndEventService;
            if (iUpcMonitorAndEventService != null) {
                iUpcMonitorAndEventService.monitor(serviceName, category, metric, logExtra);
            }
        } catch (Throwable unused) {
        }
    }

    public final void monitorInitCost(Function0<Unit> init) {
        Intrinsics.checkParameterIsNotNull(init, ReportUtil.Event.EVENT_INIT);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            init.invoke();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("aid", INSTANCE.getMConfiguration().mAid);
            jSONObject.put("cost", System.currentTimeMillis() - currentTimeMillis);
            IUpcMonitorAndEventService iUpcMonitorAndEventService = getMConfiguration().mUpcMonitorAndEventService;
            if (iUpcMonitorAndEventService != null) {
                iUpcMonitorAndEventService.monitor("upc_init_cost", jSONObject, (JSONObject) null, (JSONObject) null);
            }
        } catch (Throwable th) {
            LogUtils.m8e(th);
        }
    }

    public static /* synthetic */ void monitorException$default(UpcMonitor upcMonitor, Throwable th, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        upcMonitor.monitorException(th, str);
    }

    public final void monitorException(Throwable e, String msg) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        try {
            EnsureManager.ensureNotReachHere(e, msg);
        } catch (Throwable th) {
            LogUtils.m8e(th);
        }
    }
}
