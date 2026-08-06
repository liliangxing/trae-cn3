package com.bytedance.ies.bullet.lynx.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxModuleWrappers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrappers;", "", "modules", "", "", "Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrapper;", "(Ljava/util/Map;)V", "getModules", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxModuleWrappers {
    private final Map<String, LynxModuleWrapper> modules;

    public LynxModuleWrappers(Map<String, LynxModuleWrapper> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        this.modules = modules;
    }

    public final Map<String, LynxModuleWrapper> getModules() {
        return this.modules;
    }
}
