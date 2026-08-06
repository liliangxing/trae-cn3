package com.bytedance.android.monitorV2.lynx.impl;

import android.view.View;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import com.bytedance.android.monitorV2.util.Reflector;
import com.bytedance.android.monitorV2.util.Utilities;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LynxProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\n\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxProxy;", "", "()V", "getOriginLeft", "Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "getGetOriginLeft", "()Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "getOriginLeft$delegate", "Lkotlin/Lazy;", "isHasActualFMP", "Lcom/lynx/tasm/LynxPerfMetric;", "isHasActualFMP$delegate", "onTimingSetupMethod", "Lcom/lynx/tasm/LynxViewClient;", "getOnTimingSetupMethod", "onTimingSetupMethod$delegate", "setExtraTimingMethod", "Lcom/lynx/tasm/LynxView;", "getSetExtraTimingMethod", "setExtraTimingMethod$delegate", "updateExtraTiming", "", "view", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxProxy {
    public static final LynxProxy INSTANCE = new LynxProxy();

    /* renamed from: setExtraTimingMethod$delegate, reason: from kotlin metadata */
    private static final Lazy setExtraTimingMethod = LazyKt.lazy(new Function0<Reflector.RefMethod<LynxView>>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxProxy$setExtraTimingMethod$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Reflector.RefMethod<LynxView> m365invoke() {
            return Reflector.INSTANCE.clazz(LynxView.class).method("setExtraTiming", new Class[]{Map.class});
        }
    });

    /* renamed from: isHasActualFMP$delegate, reason: from kotlin metadata */
    private static final Lazy isHasActualFMP = LazyKt.lazy(new Function0<Reflector.RefMethod<LynxPerfMetric>>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxProxy$isHasActualFMP$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Reflector.RefMethod<LynxPerfMetric> m363invoke() {
            return Reflector.RefClass.method$default(Reflector.INSTANCE.clazz(LynxPerfMetric.class), "isHasActualFMP", null, 2, null);
        }
    });

    /* renamed from: onTimingSetupMethod$delegate, reason: from kotlin metadata */
    private static final Lazy onTimingSetupMethod = LazyKt.lazy(new Function0<Reflector.RefMethod<LynxViewClient>>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxProxy$onTimingSetupMethod$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Reflector.RefMethod<LynxViewClient> m364invoke() {
            return Reflector.INSTANCE.clazz(LynxViewClient.class).method("onTimingSetup", new Class[]{Map.class});
        }
    });

    /* renamed from: getOriginLeft$delegate, reason: from kotlin metadata */
    private static final Lazy getOriginLeft = LazyKt.lazy(new Function0<Reflector.RefMethod<LynxBaseUI>>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxProxy$getOriginLeft$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Reflector.RefMethod<LynxBaseUI> m362invoke() {
            return Reflector.RefClass.method$default(Reflector.INSTANCE.clazz(LynxBaseUI.class), "getOriginLeft", null, 2, null);
        }
    });

    private LynxProxy() {
    }

    public final Reflector.RefMethod<LynxView> getSetExtraTimingMethod() {
        return (Reflector.RefMethod) setExtraTimingMethod.getValue();
    }

    public final Reflector.RefMethod<LynxPerfMetric> isHasActualFMP() {
        return (Reflector.RefMethod) isHasActualFMP.getValue();
    }

    public final Reflector.RefMethod<LynxViewClient> getOnTimingSetupMethod() {
        return (Reflector.RefMethod) onTimingSetupMethod.getValue();
    }

    public final Reflector.RefMethod<LynxBaseUI> getGetOriginLeft() {
        return (Reflector.RefMethod) getOriginLeft.getValue();
    }

    public final void updateExtraTiming(LynxView view) {
        if (view == null || getSetExtraTimingMethod().not()) {
            return;
        }
        Map<String, Object> singleMap = ContainerDataCache.INSTANCE.getContainerInfoByView((View) view).toSingleMap();
        MonitorLog.m29i("setExtraTiming_containerInfoData", singleMap.toString());
        getSetExtraTimingMethod().with(view).invoke(Utilities.INSTANCE.pick(singleMap, "open_time", "container_init_start", "container_init_end", "prepare_template_start", "prepare_template_end"));
    }
}
