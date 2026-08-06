package com.bytedance.ies.bullet.lynx.model;

import com.lynx.jsbridge.LynxModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxModuleWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006R$\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrapper;", "", "clz", "Ljava/lang/Class;", "Lcom/lynx/jsbridge/LynxModule;", "moduleParams", "(Ljava/lang/Class;Ljava/lang/Object;)V", "getClz", "()Ljava/lang/Class;", "setClz", "(Ljava/lang/Class;)V", "getModuleParams", "()Ljava/lang/Object;", "setModuleParams", "(Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxModuleWrapper {
    private Class<? extends LynxModule> clz;
    private Object moduleParams;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxModuleWrapper() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public LynxModuleWrapper(Class<? extends LynxModule> cls, Object obj) {
        this.clz = cls;
        this.moduleParams = obj;
    }

    public /* synthetic */ LynxModuleWrapper(Class cls, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cls, (i & 2) != 0 ? null : obj);
    }

    public final Class<? extends LynxModule> getClz() {
        return this.clz;
    }

    public final void setClz(Class<? extends LynxModule> cls) {
        this.clz = cls;
    }

    public final Object getModuleParams() {
        return this.moduleParams;
    }

    public final void setModuleParams(Object obj) {
        this.moduleParams = obj;
    }
}
