package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tJ\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0011R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/DetailEventWrapper;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/CustomEventWrapper;", "tag", "", "type", "", "(ILjava/lang/String;)V", "details", "", "", "(ILjava/lang/String;Ljava/util/Map;)V", "mDetails", "addDetail", "", "key", "value", "eventParams", "", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public class DetailEventWrapper extends CustomEventWrapper {
    private Map<String, Object> mDetails;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailEventWrapper(int i, String type) {
        super(i, type, null, 4, null);
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.mDetails = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailEventWrapper(int i, String type, Map<String, Object> details) {
        super(i, type, null, 4, null);
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(details, "details");
        this.mDetails = details;
    }

    public final void addDetail(String key, Object value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.mDetails.put(key, value);
    }

    public final Map<String, Object> eventParams() {
        return this.mDetails;
    }
}
