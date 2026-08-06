package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import com.bytedance.memory.api.MemoryApi;
import com.lynx.tasm.LynxEnv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKitBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxKitBase;", "", "()V", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "coreJsVersion", "", MemoryApi.DEBUG, "", "getDebug", "()Z", "setDebug", "(Z)V", "devtoolOuterControl", "getDevtoolOuterControl", "setDevtoolOuterControl", "fontScale", "", "getFontScale", "()Ljava/lang/Float;", "setFontScale", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "lynxVersion", "getLynxVersion", "()Ljava/lang/String;", "viewZoom", "getViewZoom", "setViewZoom", "isContextInitialized", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKitBase {
    public static final LynxKitBase INSTANCE = new LynxKitBase();
    public static Application context = null;
    public static final String coreJsVersion = "1.0.0";
    private static boolean debug;
    private static boolean devtoolOuterControl;
    private static Float fontScale;
    private static final String lynxVersion;
    private static Float viewZoom;

    private LynxKitBase() {
    }

    public final Application getContext() {
        Application application = context;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext(Application application) {
        Intrinsics.checkNotNullParameter(application, "<set-?>");
        context = application;
    }

    public final boolean getDebug() {
        return debug;
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final boolean getDevtoolOuterControl() {
        return devtoolOuterControl;
    }

    public final void setDevtoolOuterControl(boolean z) {
        devtoolOuterControl = z;
    }

    static {
        String lynxVersion2 = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullExpressionValue(lynxVersion2, "inst().lynxVersion");
        lynxVersion = lynxVersion2;
    }

    public final String getLynxVersion() {
        return lynxVersion;
    }

    public final Float getFontScale() {
        return fontScale;
    }

    public final void setFontScale(Float f) {
        fontScale = f;
    }

    public final Float getViewZoom() {
        return viewZoom;
    }

    public final void setViewZoom(Float f) {
        viewZoom = f;
    }

    public final boolean isContextInitialized() {
        return context != null;
    }
}
