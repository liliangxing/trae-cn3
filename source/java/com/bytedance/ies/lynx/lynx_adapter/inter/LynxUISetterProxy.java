package com.bytedance.ies.lynx.lynx_adapter.inter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxUISetterProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;", "", "setProperty", "", "name", "", "prop", "Base", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface LynxUISetterProxy {

    /* compiled from: LynxUISetterProxy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy$Base;", "Lcom/bytedance/ies/lynx/lynx_adapter/inter/LynxUISetterProxy;", "()V", "setProperty", "", "name", "", "prop", "", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static class Base implements LynxUISetterProxy {
        @Override // com.bytedance.ies.lynx.lynx_adapter.inter.LynxUISetterProxy
        public void setProperty(String name, Object prop) {
            Intrinsics.checkParameterIsNotNull(name, "name");
        }
    }

    void setProperty(String name, Object prop);
}
