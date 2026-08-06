package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerVariablesRef.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/ContainerVariablesRef;", "", "monitorId", "", "(Ljava/lang/String;)V", "variables", "", "getVariables", "()Ljava/util/Map;", "variablesBase", "getVariablesBase", "getVariable", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ContainerVariablesRef {
    private final Map<String, Object> variables;
    private final Map<String, Object> variablesBase;

    public ContainerVariablesRef(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        this.variablesBase = ContainerDataCache.INSTANCE.ensureContainerBase(monitorId);
        this.variables = ContainerDataCache.INSTANCE.ensureContainerInfo(monitorId);
    }

    public final Map<String, Object> getVariablesBase() {
        return this.variablesBase;
    }

    public final Map<String, Object> getVariables() {
        return this.variables;
    }

    public final String getVariable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.variables.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
