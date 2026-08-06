package com.bytedance.trae.network.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.ttnet.R;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.IntranetProber;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* compiled from: IntranetTimeoutInterceptor.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "<init>", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "isUserActionRequest", "", "url", "", "isTimeoutException", "e", "Ljava/io/IOException;", "isBytecloudLogin", "checkIntranetAndNotify", "", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IntranetTimeoutInterceptor implements Interceptor {
    private static final String TAG = "IntranetTimeout";
    private static final long TOAST_DEBOUNCE_MS = 30000;
    private static volatile long lastToastTimestamp;
    private static final List<String> USER_ACTION_PATHS = CollectionsKt.listOf("/conversations/tasks/create");
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService probeExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.trae.network.interceptor.IntranetTimeoutInterceptor$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread probeExecutor$lambda$4;
            probeExecutor$lambda$4 = IntranetTimeoutInterceptor.probeExecutor$lambda$4(runnable);
            return probeExecutor$lambda$4;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread probeExecutor$lambda$4(Runnable runnable) {
        Thread thread = new Thread(runnable, "intranet-probe");
        thread.setDaemon(true);
        return thread;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        try {
            return chain.proceed(request);
        } catch (IOException e) {
            if (isTimeoutException(e) && isUserActionRequest(request.getUrl()) && isBytecloudLogin()) {
                checkIntranetAndNotify();
            }
            throw e;
        }
    }

    private final boolean isUserActionRequest(String url) {
        String str = url;
        if (str == null || str.length() == 0) {
            return false;
        }
        List<String> list = USER_ACTION_PATHS;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default(str, (String) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isTimeoutException(IOException e) {
        if (e instanceof SocketTimeoutException) {
            return true;
        }
        String message = e.getMessage();
        if (message == null) {
            return false;
        }
        String str = message;
        return StringsKt.contains$default(str, "ERR_CONNECTION_TIMED_OUT", false, 2, (Object) null) || StringsKt.contains$default(str, "ERR_TTNET_APP_TIMED_OUT", false, 2, (Object) null) || StringsKt.contains$default(str, "ERR_TTNET_REQUEST_TIMED_OUT", false, 2, (Object) null) || StringsKt.contains$default(str, "timed out", false, 2, (Object) null);
    }

    private final boolean isBytecloudLogin() {
        try {
            return HostResolver.INSTANCE.isBytecloudLogin();
        } catch (Exception unused) {
            return false;
        }
    }

    private final void checkIntranetAndNotify() {
        probeExecutor.execute(new Runnable() { // from class: com.bytedance.trae.network.interceptor.IntranetTimeoutInterceptor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                IntranetTimeoutInterceptor.checkIntranetAndNotify$lambda$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIntranetAndNotify$lambda$2() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastToastTimestamp >= 30000 && !IntranetProber.isRegionalReachable$default(IntranetProber.INSTANCE, 0, 1, null)) {
            lastToastTimestamp = currentTimeMillis;
            FLogger.INSTANCE.mo428i(TAG, "Intranet unreachable, showing toast");
            mainHandler.post(new Runnable() { // from class: com.bytedance.trae.network.interceptor.IntranetTimeoutInterceptor$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    IntranetTimeoutInterceptor.checkIntranetAndNotify$lambda$2$lambda$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIntranetAndNotify$lambda$2$lambda$1() {
        Toast.makeText(AppHost.Companion.getApplication(), R.string.trae_intranet_disconnected, 1).show();
    }
}
