package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/CustomEventWrapper;", "", TicketGuardProviderKt.PATH_SIGN, "", "type", "", "params", "", "(ILjava/lang/String;Ljava/util/Map;)V", "getParams", "()Ljava/util/Map;", "getSign", "()I", "getType", "()Ljava/lang/String;", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public class CustomEventWrapper {
    private final Map<String, Object> params;
    private final int sign;
    private final String type;

    public CustomEventWrapper(int i, String str) {
        this(i, str, null, 4, null);
    }

    public CustomEventWrapper(int i, String type, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.sign = i;
        this.type = type;
        this.params = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CustomEventWrapper(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, map);
        if ((i2 & 4) != 0) {
            map = null;
        }
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final int getSign() {
        return this.sign;
    }

    public final String getType() {
        return this.type;
    }
}
