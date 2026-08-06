package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxTextUpdateBundleProxy;", "", "hasImages", "", "layout", "Landroid/text/Layout;", "(ZLandroid/text/Layout;)V", "getHasImages", "()Z", "setHasImages", "(Z)V", "getLayout", "()Landroid/text/Layout;", "setLayout", "(Landroid/text/Layout;)V", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class LynxTextUpdateBundleProxy {
    private boolean hasImages;
    private Layout layout;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxTextUpdateBundleProxy() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public LynxTextUpdateBundleProxy(boolean z, Layout layout) {
        this.hasImages = z;
        this.layout = layout;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LynxTextUpdateBundleProxy(boolean z, Layout layout, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, layout);
        z = (i & 1) != 0 ? false : z;
        if ((i & 2) != 0) {
            layout = null;
        }
    }

    public final boolean getHasImages() {
        return this.hasImages;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final void setHasImages(boolean z) {
        this.hasImages = z;
    }

    public final void setLayout(Layout layout) {
        this.layout = layout;
    }
}
