package com.edu.onetex.latex.icon;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.LaTeXParam;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LaTeXIconBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIconBuilder;", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(Lcom/edu/onetex/latex/LaTeXParam;)V", "nIconBuilder", "", "awaitBuild", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "build", "internalBuild", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class LaTeXIconBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy latexParseHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: com.edu.onetex.latex.icon.LaTeXIconBuilder$Companion$latexParseHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m2636invoke() {
            HandlerThread handlerThread = new HandlerThread("tutor_latex_parse_thread");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });
    private static final Lazy mainThreadHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: com.edu.onetex.latex.icon.LaTeXIconBuilder$Companion$mainThreadHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m2637invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private final LaTeXParam latexParam;
    private long nIconBuilder;

    public LaTeXIconBuilder(LaTeXParam laTeXParam) {
        Intrinsics.checkNotNullParameter(laTeXParam, "latexParam");
        this.latexParam = laTeXParam;
    }

    /* compiled from: LaTeXIconBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0082 J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082 R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIconBuilder$Companion;", "", "()V", "latexParseHandler", "Landroid/os/Handler;", "getLatexParseHandler", "()Landroid/os/Handler;", "latexParseHandler$delegate", "Lkotlin/Lazy;", "mainThreadHandler", "getMainThreadHandler", "mainThreadHandler$delegate", "nBuild", "", "nBuilder", "nParse", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        public final Handler getLatexParseHandler() {
            Lazy lazy = LaTeXIconBuilder.latexParseHandler$delegate;
            Companion companion = LaTeXIconBuilder.INSTANCE;
            return (Handler) lazy.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Handler getMainThreadHandler() {
            Lazy lazy = LaTeXIconBuilder.mainThreadHandler$delegate;
            Companion companion = LaTeXIconBuilder.INSTANCE;
            return (Handler) lazy.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final native long nBuild(long nBuilder);

        /* JADX INFO: Access modifiers changed from: private */
        public final native long nParse(LaTeXParam latexParam);

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final LaTeXIcon build() {
        return internalBuild();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LaTeXIcon internalBuild() {
        Companion companion = INSTANCE;
        long nParse = companion.nParse(this.latexParam);
        this.nIconBuilder = nParse;
        long nBuild = companion.nBuild(nParse);
        if (nBuild == 0) {
            return null;
        }
        return new LaTeXIcon(nBuild, this.latexParam);
    }

    public final LaTeXIcon awaitBuild() {
        Handler mainThreadHandler;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            LaTeXEngine.INSTANCE.setAsyncParse$onetex_release(false);
            LaTeXEngine.onReceiveLog("LaTeXIconBuilder", "主线程解析", false);
            return internalBuild();
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (LaTeXEngine.INSTANCE.getAsyncParse()) {
            LaTeXEngine.onReceiveLog("LaTeXIconBuilder", "子线程解析", false);
            mainThreadHandler = INSTANCE.getLatexParseHandler();
        } else {
            LaTeXEngine.onReceiveLog("LaTeXIconBuilder", "子线程切换至主线程解析", false);
            mainThreadHandler = INSTANCE.getMainThreadHandler();
        }
        mainThreadHandler.post(new Runnable() { // from class: com.edu.onetex.latex.icon.LaTeXIconBuilder$awaitBuild$1
            @Override // java.lang.Runnable
            public final void run() {
                LaTeXIcon internalBuild;
                try {
                    internalBuild = LaTeXIconBuilder.this.internalBuild();
                    objectRef.element = internalBuild;
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return (LaTeXIcon) objectRef.element;
    }
}
