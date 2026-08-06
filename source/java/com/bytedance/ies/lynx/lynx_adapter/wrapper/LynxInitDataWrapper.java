package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxInitDataWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0010J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "", "()V", "dataProxy", "", "", "getDataProxy", "()Ljava/util/Map;", "setDataProxy", "(Ljava/util/Map;)V", "initData", "getInitData", "()Ljava/lang/String;", "setInitData", "(Ljava/lang/String;)V", "readOnly", "", "getReadOnly", "()Z", "setReadOnly", "(Z)V", "checkIsLegalData", "put", "", "key", "value", "Companion", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class LynxInitDataWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, Object> dataProxy = new LinkedHashMap();
    private String initData;
    private boolean readOnly;

    public final Map<String, Object> getDataProxy() {
        return this.dataProxy;
    }

    public final void setDataProxy(Map<String, Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.dataProxy = map;
    }

    public final String getInitData() {
        return this.initData;
    }

    public final void setInitData(String str) {
        this.initData = str;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final boolean checkIsLegalData() {
        return !this.dataProxy.isEmpty();
    }

    public final void put(String key, Object value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (value == null) {
            return;
        }
        this.dataProxy.put(key, value);
    }

    /* compiled from: LynxInitDataWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper$Companion;", "", "()V", "fromMap", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "map", "", "", "fromString", "json", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LynxInitDataWrapper fromString(String json) {
            Intrinsics.checkParameterIsNotNull(json, "json");
            LynxInitDataWrapper lynxInitDataWrapper = new LynxInitDataWrapper();
            lynxInitDataWrapper.setInitData(json);
            return lynxInitDataWrapper;
        }

        public final LynxInitDataWrapper fromMap(Map<String, Object> map) {
            Intrinsics.checkParameterIsNotNull(map, "map");
            LynxInitDataWrapper lynxInitDataWrapper = new LynxInitDataWrapper();
            lynxInitDataWrapper.setDataProxy(map);
            return lynxInitDataWrapper;
        }
    }
}
