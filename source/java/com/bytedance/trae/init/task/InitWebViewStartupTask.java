package com.bytedance.trae.init.task;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewOutcomeReceiver;
import androidx.webkit.WebViewStartUpConfig;
import androidx.webkit.WebViewStartUpResult;
import androidx.webkit.WebViewStartupException;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.init.LaunchBoostExecutor;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitWebViewStartupTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/init/task/InitWebViewStartupTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "startUpWebView", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitWebViewStartupTask implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    @Deprecated
    public static final long STARTUP_DELAY_MS = 3000;

    @Deprecated
    public static final String TAG = "WebViewStartup";
    private final String scene = ServiceType.BASIC_TEC;

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public boolean checkFirstStartAsyncTaskInit(String str) {
        return IInitReportTask.DefaultImpls.checkFirstStartAsyncTaskInit(this, str);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getFirstStyle() {
        return IInitReportTask.DefaultImpls.getFirstStyle(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask, java.lang.Runnable
    public void run() {
        IInitReportTask.DefaultImpls.run(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getScene() {
        return this.scene;
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public void runInternal() {
        FLogger.INSTANCE.i(TAG, "startUpWebView scheduled, delayMs=3000");
        MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bytedance.trae.init.task.InitWebViewStartupTask$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InitWebViewStartupTask.this.startUpWebView();
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startUpWebView() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        FLogger.INSTANCE.i(TAG, "startUpWebView start");
        WebViewCompat.startUpWebView(AppHost.INSTANCE.getApplication(), new WebViewStartUpConfig.Builder(LaunchBoostExecutor.INSTANCE.executors$app_mainlandRelease()).build(), new WebViewOutcomeReceiver<WebViewStartUpResult, WebViewStartupException>() { // from class: com.bytedance.trae.init.task.InitWebViewStartupTask$startUpWebView$1
            public void onResult(WebViewStartUpResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                FLogger.INSTANCE.i(InitWebViewStartupTask.TAG, "startUpWebView success, costMs=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }

            public void onError(WebViewStartupException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                FLogger.INSTANCE.e(InitWebViewStartupTask.TAG, "startUpWebView failed, costMs=" + (SystemClock.elapsedRealtime() - elapsedRealtime), (Throwable) error);
            }
        });
    }

    /* compiled from: InitWebViewStartupTask.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;", "", "<init>", "()V", "TAG", "", "STARTUP_DELAY_MS", "", "MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Handler getMAIN_HANDLER() {
            return InitWebViewStartupTask.MAIN_HANDLER;
        }
    }
}
