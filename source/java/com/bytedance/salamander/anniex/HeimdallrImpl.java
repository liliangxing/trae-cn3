package com.bytedance.salamander.anniex;

import com.bytedance.apm.ApmAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnniexMonitorFoundationImplHeimdallrImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/HeimdallrImpl;", "Lcom/bytedance/salamander/anniex/IHeimdallr;", "()V", "monitorCommonLog", "", "logType", "", "result", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class HeimdallrImpl implements IHeimdallr {
    @Override // com.bytedance.salamander.anniex.IHeimdallr
    public void monitorCommonLog(String logType, Map<String, Object> result) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(result, "result");
        ApmAgent.monitorCommonLog(logType, new JSONObject(result));
    }
}
