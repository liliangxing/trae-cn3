package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.PropsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: LynxBehaviorWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u0016H&J\u0006\u0010\u0017\u001a\u00020\u0005J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxBehaviorWrapper;", "", "name", "", PropsConstants.FLATTEN, "", "(Ljava/lang/String;Z)V", "getFlatten", "()Z", "getName", "()Ljava/lang/String;", "createClassWarmer", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/BehaviorClassWarmerWrapper;", "createFlattenUI", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxFlattenUIWrapper;", "context", "Landroid/content/Context;", "createShadowNode", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxShadowNodeWrapper;", "createUI", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxUIWrapper;", "Landroid/view/View;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxContextWrapper;", "supportUIFlatten", "toString", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public abstract class LynxBehaviorWrapper {
    private final boolean flatten;
    private final String name;

    public LynxBehaviorWrapper(String str) {
        this(str, false, 2, null);
    }

    public BehaviorClassWarmerWrapper createClassWarmer() {
        return null;
    }

    public LynxFlattenUIWrapper createFlattenUI(Context context) {
        return null;
    }

    public LynxShadowNodeWrapper createShadowNode() {
        return null;
    }

    public abstract LynxUIWrapper<? extends View> createUI(LynxContextWrapper context);

    public LynxBehaviorWrapper(String name, boolean z) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
        this.flatten = z;
    }

    public /* synthetic */ LynxBehaviorWrapper(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final boolean getFlatten() {
        return this.flatten;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean supportUIFlatten() {
        return this.flatten;
    }

    public String toString() {
        return "[" + getClass().getName() + " - " + this.name + AbstractJsonLexerKt.END_LIST;
    }
}
