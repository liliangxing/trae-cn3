package com.bytedance.ies.bullet.service.webkit;

import android.webkit.JavascriptInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalPropsHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/InjectData;", "", "globalProps", "", "initialProps", "injectInitData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGlobalProps", "getInitialProps", "getInjectInitData", "setGlobalProps", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class InjectData {
    private volatile String globalProps;
    private final String initialProps;
    private final String injectInitData;

    public InjectData() {
        this(null, null, null, 7, null);
    }

    public InjectData(String str, String str2, String str3) {
        this.globalProps = str;
        this.initialProps = str2;
        this.injectInitData = str3;
    }

    public /* synthetic */ InjectData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JavascriptInterface
    public final String getGlobalProps() {
        String str = this.globalProps;
        return str == null ? "{}" : str;
    }

    @JavascriptInterface
    public final String getInitialProps() {
        String str = this.initialProps;
        return str == null ? "{}" : str;
    }

    @JavascriptInterface
    public final String getInjectInitData() {
        String str = this.injectInitData;
        return str == null ? "{}" : str;
    }

    public final void setGlobalProps(String globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        this.globalProps = globalProps;
    }
}
