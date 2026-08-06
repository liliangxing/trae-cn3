package com.edu.onetex;

import android.app.Activity;
import android.app.Application;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.utils.ActivityStack;
import com.edu.onetex.utils.TextContrastUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnetexInitializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/edu/onetex/OneTeXInitializer;", "", "()V", "application", "Landroid/app/Application;", "getApplication$onetex_release", "()Landroid/app/Application;", "setApplication$onetex_release", "(Landroid/app/Application;)V", ReportUtil.Event.EVENT_INIT, "", "registerAppStatusListener", "updateTextContrastMode", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class OneTeXInitializer {
    public static final OneTeXInitializer INSTANCE = new OneTeXInitializer();
    private static Application application;

    private OneTeXInitializer() {
    }

    public final Application getApplication$onetex_release() {
        return application;
    }

    public final void setApplication$onetex_release(Application application2) {
        application = application2;
    }

    @JvmStatic
    public static final void init(Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        application = application2;
        System.loadLibrary("onetex");
        LaTeXEngine.INSTANCE.init();
        OneTeXInitializer oneTeXInitializer = INSTANCE;
        oneTeXInitializer.registerAppStatusListener(application2);
        oneTeXInitializer.updateTextContrastMode(application2);
    }

    private final void registerAppStatusListener(final Application application2) {
        ActivityStack.INSTANCE.init(application2);
        ActivityStack.INSTANCE.registerAppStatusListener(new ActivityStack.OnAppStatusChangedListener() { // from class: com.edu.onetex.OneTeXInitializer$registerAppStatusListener$1
            @Override // com.edu.onetex.utils.ActivityStack.OnAppStatusChangedListener
            public void onBackground() {
            }

            @Override // com.edu.onetex.utils.ActivityStack.OnAppStatusChangedListener
            public void onForeground(Activity activity, boolean isAppLaunch) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                OneTeXInitializer.INSTANCE.updateTextContrastMode(application2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTextContrastMode(Application application2) {
        Graphics2D.INSTANCE.setTextContrastMode(TextContrastUtils.INSTANCE.isTextContrastMode(application2));
    }
}
