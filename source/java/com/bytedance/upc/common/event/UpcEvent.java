package com.bytedance.upc.common.event;

import com.bytedance.upc.Configuration;
import com.bytedance.upc.IUpcMonitorAndEventService;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/upc/common/event/UpcEvent;", "", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "onEvent", "", "eventName", "", RemoteMessageConst.MessageBody.PARAM, "Lorg/json/JSONObject;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UpcEvent {
    public static final UpcEvent INSTANCE = new UpcEvent();

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private static final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.common.event.UpcEvent$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m2603invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    private final Configuration getMConfiguration() {
        return (Configuration) mConfiguration.getValue();
    }

    private UpcEvent() {
    }

    @JvmStatic
    public static final void onEvent(String eventName, JSONObject param) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        try {
            LogUtils.m9i("[onEventV3] eventName = " + eventName + ", param = " + param);
            IUpcMonitorAndEventService iUpcMonitorAndEventService = INSTANCE.getMConfiguration().mUpcMonitorAndEventService;
            if (iUpcMonitorAndEventService != null) {
                iUpcMonitorAndEventService.event("timon_" + eventName, param);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
