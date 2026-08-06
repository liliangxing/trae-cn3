package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: PTYRequestConfig.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYRequestConfig;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "download", "", "filters", "Lorg/json/JSONObject;", "(ZLorg/json/JSONObject;)V", "getDownload", "()Z", "filterStr", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYRequestConfig implements ReflectionCall {
    private final boolean download;
    private final String filterStr;

    /* JADX WARN: Multi-variable type inference failed */
    public PTYRequestConfig() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public PTYRequestConfig(boolean z, JSONObject jSONObject) {
        this.download = z;
        this.filterStr = jSONObject != null ? jSONObject.toString() : null;
    }

    public /* synthetic */ PTYRequestConfig(boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : jSONObject);
    }

    public final boolean getDownload() {
        return this.download;
    }
}
