package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.rts.foundation.Date;
import com.bytedance.rts.foundation.Float64;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsInfoJsbErrorEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R:\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/salamander/anniex/SLJSBErrorEventInfo;", "Lcom/bytedance/salamander/anniex/IEventInfo;", "()V", "bridge_name", "", "getBridge_name", "()Ljava/lang/String;", "setBridge_name", "(Ljava/lang/String;)V", CDNLoader.DIAGNOSE_ERROR_CODE, "", "getError_code", "()I", "setError_code", "(I)V", CDNLoader.DIAGNOSE_ERROR_MESSAGE, "getError_message", "setError_message", "error_ts", "", "getError_ts", "()J", "setError_ts", "(J)V", "extra", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "jsb_params", "getJsb_params", "setJsb_params", "root_cause", "getRoot_cause", "setRoot_cause", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLJSBErrorEventInfo implements IEventInfo {
    private int error_code;
    private Map<String, Object> extra;
    private String jsb_params;
    private String root_cause;
    private String error_message = "";
    private long error_ts = Float64.INSTANCE.toInt64(Date.INSTANCE.now_v2());
    private String bridge_name = "";

    public String getError_message() {
        return this.error_message;
    }

    public void setError_message(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.error_message = str;
    }

    public long getError_ts() {
        return this.error_ts;
    }

    public void setError_ts(long j) {
        this.error_ts = j;
    }

    public String getBridge_name() {
        return this.bridge_name;
    }

    public void setBridge_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bridge_name = str;
    }

    public int getError_code() {
        return this.error_code;
    }

    public void setError_code(int i) {
        this.error_code = i;
    }

    public String getRoot_cause() {
        return this.root_cause;
    }

    public void setRoot_cause(String str) {
        this.root_cause = str;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void setExtra(Map<String, Object> map) {
        this.extra = map;
    }

    public String getJsb_params() {
        return this.jsb_params;
    }

    public void setJsb_params(String str) {
        this.jsb_params = str;
    }
}
