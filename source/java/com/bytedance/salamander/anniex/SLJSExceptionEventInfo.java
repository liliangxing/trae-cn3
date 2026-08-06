package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: AnniexMonitorEventTypingsInfoJsException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R:\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/salamander/anniex/SLJSExceptionEventInfo;", "Lcom/bytedance/salamander/anniex/IEventInfo;", "()V", "context", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getContext", "()Ljava/util/Map;", "setContext", "(Ljava/util/Map;)V", "error_ts", "", "getError_ts", "()J", "setError_ts", "(J)V", "js_info", "Lcom/bytedance/salamander/anniex/JsInfo;", "getJs_info", "()Lcom/bytedance/salamander/anniex/JsInfo;", "setJs_info", "(Lcom/bytedance/salamander/anniex/JsInfo;)V", "native_info", "Lcom/bytedance/salamander/anniex/NativeInfo;", "getNative_info", "()Lcom/bytedance/salamander/anniex/NativeInfo;", "setNative_info", "(Lcom/bytedance/salamander/anniex/NativeInfo;)V", "root_cause", "getRoot_cause", "()Ljava/lang/String;", "setRoot_cause", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLJSExceptionEventInfo implements IEventInfo {
    private Map<String, String> context;
    private long error_ts = -1;
    private JsInfo js_info;
    private NativeInfo native_info;
    private String root_cause;

    public NativeInfo getNative_info() {
        return this.native_info;
    }

    public void setNative_info(NativeInfo nativeInfo) {
        this.native_info = nativeInfo;
    }

    public JsInfo getJs_info() {
        return this.js_info;
    }

    public void setJs_info(JsInfo jsInfo) {
        this.js_info = jsInfo;
    }

    public long getError_ts() {
        return this.error_ts;
    }

    public void setError_ts(long j) {
        this.error_ts = j;
    }

    public String getRoot_cause() {
        return this.root_cause;
    }

    public void setRoot_cause(String str) {
        this.root_cause = str;
    }

    public Map<String, String> getContext() {
        return this.context;
    }

    public void setContext(Map<String, String> map) {
        this.context = map;
    }
}
