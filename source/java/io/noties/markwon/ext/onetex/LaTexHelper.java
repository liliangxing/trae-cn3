package io.noties.markwon.ext.onetex;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.edu.onetex.OneTeXInitializer;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: LaTexHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/ext/onetex/LaTexHelper;", "Lio/noties/markwon/ext/onetex/LatexCallback;", "()V", "callback", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor$annotations", "getExecutor$markwon_ext_onetex_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor$delegate", "Lkotlin/Lazy;", "onBuild", "", "timeConsume", "", "onParse", "latex", "", "onRender", "setLatexCallback", "tryInit", "context", "Landroid/content/Context;", "config", "Lio/noties/markwon/ext/onetex/LaTexHelper$LatexInitConfig;", "LatexInitConfig", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LaTexHelper implements LatexCallback {
    private static volatile LatexCallback callback;
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LaTexHelper.class), "executor", "getExecutor$markwon_ext_onetex_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
    public static final LaTexHelper INSTANCE = new LaTexHelper();

    /* renamed from: executor$delegate, reason: from kotlin metadata */
    private static final Lazy executor = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: io.noties.markwon.ext.onetex.LaTexHelper$executor$2
        public final ThreadPoolExecutor invoke() {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: io.noties.markwon.ext.onetex.LaTexHelper$executor$2.1
                /* JADX WARN: Type inference failed for: r0v0, types: [io.noties.markwon.ext.onetex.LaTexHelper$executor$2$1$1] */
                @Override // java.util.concurrent.ThreadFactory
                public final AnonymousClass1 newThread(final Runnable runnable) {
                    return new Thread("latex-parse") { // from class: io.noties.markwon.ext.onetex.LaTexHelper.executor.2.1.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            Runnable runnable2 = runnable;
                            if (runnable2 != null) {
                                runnable2.run();
                            }
                        }
                    };
                }
            });
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }
    });

    public static /* synthetic */ void executor$annotations() {
    }

    public final ThreadPoolExecutor getExecutor$markwon_ext_onetex_release() {
        Lazy lazy = executor;
        KProperty kProperty = $$delegatedProperties[0];
        return (ThreadPoolExecutor) lazy.getValue();
    }

    private LaTexHelper() {
    }

    /* compiled from: LaTexHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/onetex/LaTexHelper$LatexInitConfig;", "", "supportNewCommand", "", "(Z)V", "getSupportNewCommand", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final /* data */ class LatexInitConfig {
        private final boolean supportNewCommand;

        public static /* synthetic */ LatexInitConfig copy$default(LatexInitConfig latexInitConfig, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = latexInitConfig.supportNewCommand;
            }
            return latexInitConfig.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSupportNewCommand() {
            return this.supportNewCommand;
        }

        public final LatexInitConfig copy(boolean supportNewCommand) {
            return new LatexInitConfig(supportNewCommand);
        }

        public boolean equals(Object other) {
            if (this != other) {
                if (other instanceof LatexInitConfig) {
                    if (this.supportNewCommand == ((LatexInitConfig) other).supportNewCommand) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.supportNewCommand;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "LatexInitConfig(supportNewCommand=" + this.supportNewCommand + ")";
        }

        public LatexInitConfig(boolean z) {
            this.supportNewCommand = z;
        }

        public final boolean getSupportNewCommand() {
            return this.supportNewCommand;
        }
    }

    public final void tryInit(Context context, LatexInitConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        Application application = (Application) (applicationContext instanceof Application ? applicationContext : null);
        if (application == null || LaTeXEngine.INSTANCE.isInitialized()) {
            return;
        }
        synchronized (this) {
            if (LaTeXEngine.INSTANCE.isInitialized()) {
                return;
            }
            try {
                OneTeXInitializer.init(application);
                LaTeXEngine.INSTANCE.setConfig(new OneTexConfiguration((Map) null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cosx", "cos"), TuplesKt.to("sinx", "sin"), TuplesKt.to("arcsinx", "arcsin"), TuplesKt.to("arccosx", "arccos")}), config.getSupportNewCommand(), config.getSupportNewCommand(), false, false, false, 113, (DefaultConstructorMarker) null));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setLatexCallback(LatexCallback callback2) {
        callback = callback2;
    }

    @Override // io.noties.markwon.ext.onetex.LatexCallback
    public void onParse(String latex) {
        LatexCallback latexCallback = callback;
        if (latexCallback != null) {
            latexCallback.onParse(latex);
        }
    }

    @Override // io.noties.markwon.ext.onetex.LatexCallback
    public void onRender(String latex) {
        LatexCallback latexCallback = callback;
        if (latexCallback != null) {
            latexCallback.onRender(latex);
        }
    }

    @Override // io.noties.markwon.ext.onetex.LatexCallback
    public void onBuild(long timeConsume) {
        LatexCallback latexCallback = callback;
        if (latexCallback != null) {
            latexCallback.onBuild(timeConsume);
        }
    }
}
