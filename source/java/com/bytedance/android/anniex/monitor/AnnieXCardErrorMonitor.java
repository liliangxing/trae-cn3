package com.bytedance.android.anniex.monitor;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXCardErrorMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/monitor/AnnieXCardErrorMonitor;", "", "()V", "GLOBAL_PROPS_ERROR_EVENT", "", "reportGlobalPropsError", "", "errorMsg", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXCardErrorMonitor {
    private static final String GLOBAL_PROPS_ERROR_EVENT = "bdx_anniex_card_props_error";
    public static final AnnieXCardErrorMonitor INSTANCE = new AnnieXCardErrorMonitor();

    private AnnieXCardErrorMonitor() {
    }

    public final void reportGlobalPropsError(String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        CustomInfo.Builder sample = new CustomInfo.Builder(GLOBAL_PROPS_ERROR_EVENT).setBid("bullet_custom_bid").setSample(0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", "anniex_card");
        jSONObject.put(StrategyConstants.ERROR_MSG, errorMsg);
        HybridMultiMonitor.getInstance().customReport(sample.setCategory(jSONObject).build());
    }
}
