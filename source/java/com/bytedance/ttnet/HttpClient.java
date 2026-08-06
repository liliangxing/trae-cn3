package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.config.ExperimentalSwitches;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.io.IOException;
import java.net.MalformedURLException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HttpClient {
    static final CronetImpl CRONET_IMPL;
    static final OK3Impl OK3_IMPL;
    private static final String TAG = "HttpClient";
    static volatile boolean sCronetBootSucceed;
    static String sCronetExceptionMessage;
    private static volatile IHttpClientConfig sHttpClientConfig;
    static boolean sIsCronetException;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IHttpClientConfig {
        boolean isChromiumOpen();
    }

    public static void setHttpClientConfig(IHttpClientConfig iHttpClientConfig) {
        sHttpClientConfig = iHttpClientConfig;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class OK3Impl {
        private OK3Impl() {
        }

        public IHttpClient getHttpClient() {
            Context context = TTNetInit.getTTNetDepend().getContext();
            SsOkHttp3Client inst = SsOkHttp3Client.inst(context);
            if (ProcessUtils.isMainProcessByProcessFlag(context)) {
                inst.setOk3TncBridge(TNCManager.getInstance());
            }
            return inst;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class CronetImpl extends OK3Impl {
        private CronetImpl() {
            super();
        }

        @Override // com.bytedance.ttnet.HttpClient.OK3Impl
        public IHttpClient getHttpClient() {
            return SsCronetHttpClientWrap.inst(SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext()));
        }
    }

    static {
        OK3_IMPL = new OK3Impl();
        CRONET_IMPL = new CronetImpl();
    }

    public static void setCronetBootSucceed(boolean z) {
        sCronetBootSucceed = z;
    }

    public static String getCronetExceptionMessage() {
        return sCronetExceptionMessage;
    }

    public static boolean isCronetClientEnable() {
        if (sHttpClientConfig != null && SsOkHttp3Client.getFallbackReason() == 9) {
            if (Logger.debug()) {
                Logger.d(TAG, "reset null config fallback");
            }
            SsOkHttp3Client.setFallbackReason(-1);
        }
        if (sHttpClientConfig == null && !ExperimentalSwitches.isDisableFallbackReasonNullAppconfig()) {
            if (Logger.debug()) {
                Logger.d(TAG, "check null config and fallback");
            }
            TNCManager.getInstance().handleCronetInitFailed();
            SsOkHttp3Client.setFallbackReason(9);
            return false;
        }
        if (sHttpClientConfig != null && !sHttpClientConfig.isChromiumOpen()) {
            return false;
        }
        if (!sIsCronetException || sCronetBootSucceed) {
            return true;
        }
        SsOkHttp3Client.setFallbackReason(7);
        SsOkHttp3Client.setFallbackMessage(sCronetExceptionMessage);
        return false;
    }

    public static IHttpClient getHttpClient(String str, boolean z) {
        if (isCronetClientEnable() && !z) {
            return CRONET_IMPL.getHttpClient();
        }
        return OK3_IMPL.getHttpClient();
    }

    public static IHttpClient getHttpClient(String str) {
        if (isCronetClientEnable()) {
            return CRONET_IMPL.getHttpClient();
        }
        return OK3_IMPL.getHttpClient();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SsCronetHttpClientWrap implements IHttpClient {
        private static final int CRONET_EXCEPTION_LIMIT_TIMES = 3;
        private static volatile SsCronetHttpClientWrap sInstance;
        private volatile int mCronetExceptionTimes;
        private SsCronetHttpClient ssCronetHttpClient;

        public static SsCronetHttpClientWrap inst(SsCronetHttpClient ssCronetHttpClient) {
            if (sInstance == null) {
                synchronized (SsCronetHttpClientWrap.class) {
                    if (sInstance == null) {
                        sInstance = new SsCronetHttpClientWrap(ssCronetHttpClient);
                    }
                }
            }
            return sInstance;
        }

        private SsCronetHttpClientWrap(SsCronetHttpClient ssCronetHttpClient) {
            this.ssCronetHttpClient = ssCronetHttpClient;
        }

        private void shouldFallbackWhenCronetException(Throwable th) {
            if (th instanceof MalformedURLException) {
                return;
            }
            if (th.getMessage() == null || !th.getMessage().contains("MalformedURLException")) {
                if (Logger.debug()) {
                    Logger.d(HttpClient.TAG, "init mode is " + TTNetInitMetrics.inst().isPreOrForceInitCronet());
                    Logger.d(HttpClient.TAG, "exception times is " + this.mCronetExceptionTimes);
                }
                if (TTNetInitMetrics.inst().isPreOrForceInitCronet()) {
                    int i = this.mCronetExceptionTimes + 1;
                    this.mCronetExceptionTimes = i;
                    if (i > 3) {
                        if (!ExperimentalSwitches.isDisableFallbackReasonCronetException()) {
                            if (Logger.debug()) {
                                Logger.d(HttpClient.TAG, "set sIsCronetException true");
                            }
                            HttpClient.sIsCronetException = true;
                        }
                        HttpClient.sCronetExceptionMessage = TtnetUtil.outputThrowableStackTrace(th);
                        if (HttpClient.sCronetExceptionMessage.length() > 256) {
                            HttpClient.sCronetExceptionMessage = HttpClient.sCronetExceptionMessage.substring(0, 256);
                        }
                    }
                }
            }
        }

        public SsCall newSsCall(Request request) throws IOException {
            try {
                return this.ssCronetHttpClient.newSsCall(request);
            } catch (Throwable th) {
                shouldFallbackWhenCronetException(th);
                TTNetInit.notifyColdStartFinish();
                if (request.getMetrics() != null) {
                    String outputThrowableStackTrace = TtnetUtil.outputThrowableStackTrace(th);
                    if (outputThrowableStackTrace.length() > 1024) {
                        outputThrowableStackTrace = outputThrowableStackTrace.substring(0, 1024);
                    }
                    request.getMetrics().requestFallbackMessage = outputThrowableStackTrace;
                    request.getMetrics().requestFallbackReason = 10;
                    if (Logger.debug()) {
                        Logger.d(HttpClient.TAG, "new CronetSscall failed " + this.mCronetExceptionTimes + " for " + request.getPath());
                        Logger.d(HttpClient.TAG, "new CronetSscall failed message " + outputThrowableStackTrace);
                    }
                }
                return HttpClient.OK3_IMPL.getHttpClient().newSsCall(request);
            }
        }
    }
}
