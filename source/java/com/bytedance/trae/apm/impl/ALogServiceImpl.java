package com.bytedance.trae.apm.impl;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.LynxError;
import com.ss.alog.middleware.ALogService;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ALogServiceImpl.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J1\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016¨\u0006("}, d2 = {"Lcom/bytedance/trae/apm/impl/ALogServiceImpl;", "Lcom/ss/alog/middleware/ALogService;", "<init>", "()V", "init", "", "customName", "", BaseSwitches.V, "tag", "msg", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "header", "priority", "", "json", "bundle", "Landroid/os/Bundle;", "intent", "Landroid/content/Intent;", LynxError.LYNX_THROWABLE, "thread", "Ljava/lang/Thread;", "statcktrace", "traceElements", "", "Ljava/lang/StackTraceElement;", "(ILjava/lang/String;[Ljava/lang/StackTraceElement;)V", "changeLevel", "level", "forceLogSharding", WebViewContainer.EVENT_destroy, "flush", "release", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ALogServiceImpl extends ALogService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ALogServiceImpl";
    private static boolean sIsDebug;

    @Override // com.ss.alog.middleware.IALogProtocol
    public void bundle(int priority, String tag, Bundle bundle) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void changeLevel(int level) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void d(String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void destroy() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void e(String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void e(String tag, String msg, Throwable tr) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void e(String tag, Throwable tr) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void flush() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void forceLogSharding() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void header(int priority, String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void i(String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void init() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void init(String customName) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void intent(int priority, String tag, Intent intent) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void json(int priority, String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void release() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void statcktrace(int priority, String tag, StackTraceElement[] traceElements) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void thread(int priority, String tag, Thread thread) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void throwable(int priority, String tag, Throwable throwable) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void v(String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void w(String tag, String msg) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void w(String tag, String msg, Throwable tr) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public void w(String tag, Throwable tr) {
    }

    /* compiled from: ALogServiceImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "sIsDebug", "", "initService", "", "isDebug", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized void initService(boolean isDebug) {
            ALogServiceImpl.sIsDebug = isDebug;
            if (ALogService.sInstance == null) {
                new ALogServiceImpl();
            }
        }
    }

    @JvmStatic
    public static final synchronized void initService(boolean z) {
        synchronized (ALogServiceImpl.class) {
            INSTANCE.initService(z);
        }
    }
}
