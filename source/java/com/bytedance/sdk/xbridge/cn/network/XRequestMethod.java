package com.bytedance.sdk.xbridge.cn.network;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import bolts.Task;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.monitorV2.entity.FetchError;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxJsbFetchErrorData;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.context.IContextProvider;
import com.bytedance.ies.bullet.prefetchv2.PrefetchConfig;
import com.bytedance.ies.bullet.prefetchv2.PrefetchLogger;
import com.bytedance.ies.bullet.prefetchv2.PrefetchReportInfo;
import com.bytedance.ies.bullet.prefetchv2.PrefetchReporter;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequest;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestKt;
import com.bytedance.ies.bullet.prefetchv2.PrefetchResult;
import com.bytedance.ies.bullet.prefetchv2.PrefetchSessionManager;
import com.bytedance.ies.bullet.prefetchv2.PrefetchTask;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.utils.UrlBuilder;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.network.AbsXRequestMethodIDL;
import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import com.bytedance.sdk.xbridge.cn.platform.lynx.XBridgeLynxModule;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.lynx.tasm.LynxView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XRequestMethod.kt */
@XBridgeMethod(name = "x.request")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0003+,-B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002JT\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0002JB\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0012H\u0002J(\u0010'\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0012H\u0002J\f\u0010*\u001a\u00020\u0004*\u00020\u0012H\u0002¨\u0006."}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod;", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXRequestMethodIDL;", "()V", "canRunInBackground", "", "getExecutorService", "Ljava/util/concurrent/ExecutorService;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "handle", "", "params", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXRequestMethodIDL$XRequestParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXRequestMethodIDL$XRequestResultModel;", "printNetworkConsumeLog", IWeixinService.ResponseConstants.URL, "", "realRequestStart", "", "reportJSBFetchError", "method", "statusCode", "", "requestErrorCode", "requestErrorMsg", AccountMonitorConstants.CommonParameter.ERROR, "errorMessage", "logId", "reportPrefetchResult", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "apiUrl", "success", "prefetchStatus", "errorMsg", ReportConstant.COMMON_INIT_DURATION, "configFrom", "addAnnieXAccessToken", "Ljava/util/LinkedHashMap;", "targetUrl", "isAccessTokenAllowed", "Companion", "IRequestInterceptor", "RequestMethodType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XRequestMethod extends AbsXRequestMethodIDL {
    public static final int CODE_PREFETCH_FAILED = -688;
    private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String TAG = "XRequestMethod";

    /* compiled from: XRequestMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod$IRequestInterceptor;", "", "addParamsToUrl", "", IWeixinService.ResponseConstants.URL, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IRequestInterceptor {
        String addParamsToUrl(String url);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    /* compiled from: XRequestMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod$Companion;", "", "()V", "CODE_PREFETCH_FAILED", "", "DEFAULT_CONTENT_TYPE", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return XRequestMethod.TAG;
        }

        public final void setTAG(String str) {
            XRequestMethod.TAG = str;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXRequestMethodIDL.XRequestParamModel params, final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> callback) {
        JSONObject jSONObject;
        IBulletContainer iBulletContainer;
        IKitViewService kitView;
        IServiceToken context;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final long currentTimeMillis = System.currentTimeMillis();
        Boolean usePrefetch = params.getUsePrefetch();
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Context applicationContext = ownerActivity != null ? ownerActivity.getApplicationContext() : null;
        final ContextProviderFactory contextProviderFactory = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
        boolean equals$default = StringsKt.equals$default((contextProviderFactory == null || (iBulletContainer = (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class)) == null || (kitView = iBulletContainer.getKitView()) == null || (context = kitView.getContext()) == null) ? null : context.getBid(), "miniapp", false, 2, (Object) null);
        if (Intrinsics.areEqual(usePrefetch, true) && (applicationContext != null || equals$default)) {
            if (params.getBody() instanceof Map) {
                Object body = params.getBody();
                Intrinsics.checkNotNull(body, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                jSONObject = new JSONObject((Map) body);
            } else {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = jSONObject;
            String url = params.getUrl();
            String method = params.getMethod();
            Map stringMap = PrefetchRequestKt.toStringMap(params.getHeader());
            Map stringMap2 = PrefetchRequestKt.toStringMap(params.getParams());
            boolean addCommonParams = params.getAddCommonParams();
            Boolean isCustomizedCookie = params.isCustomizedCookie();
            PrefetchRequest prefetchRequest = new PrefetchRequest(url, method, stringMap, stringMap2, jSONObject2, addCommonParams, (Map) null, (Map) null, isCustomizedCookie != null ? isCustomizedCookie.booleanValue() : false, Intrinsics.areEqual(params.getStreamLoadType(), 1), (List) null, 1024, (DefaultConstructorMarker) null);
            final PrefetchResult cacheByRequest = PrefetchV2.INSTANCE.getCacheByRequest(prefetchRequest);
            if (Intrinsics.areEqual(params.getStreamLoadType(), 1)) {
                if ((cacheByRequest != null ? cacheByRequest.getByteArrayOutputStream() : null) != null && cacheByRequest.getStreamRequestFinish()) {
                    if (params.getStreamSessionId() == null) {
                        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "streamSessionId is null", null, 4, null);
                        return;
                    }
                    Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$1
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            StreamRequestTransmitter streamRequestTransmitter = StreamRequestTransmitter.INSTANCE;
                            String streamSessionId = AbsXRequestMethodIDL.XRequestParamModel.this.getStreamSessionId();
                            Intrinsics.checkNotNull(streamSessionId);
                            streamRequestTransmitter.transmitByCache(streamSessionId, bridgeContext, cacheByRequest);
                        }
                    });
                    CompletionBlock.DefaultImpls.onSuccess$default(callback, XRequestMethodKt.toResultModel(cacheByRequest, (Number) 2), null, 2, null);
                    reportPrefetchResult(contextProviderFactory, params.getUrl(), true, 2, "hit cache", System.currentTimeMillis() - currentTimeMillis, cacheByRequest.getConfigFrom());
                    return;
                }
                HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "not use cache pipedInputStream", (Map) null, (LoggerContext) null, 12, (Object) null);
            } else if (cacheByRequest != null) {
                CompletionBlock.DefaultImpls.onSuccess$default(callback, XRequestMethodKt.toResultModel(cacheByRequest, (Number) 2), null, 2, null);
                reportPrefetchResult(contextProviderFactory, params.getUrl(), true, 2, "hit cache", System.currentTimeMillis() - currentTimeMillis, cacheByRequest.getConfigFrom());
                return;
            }
            PrefetchTask runningPrefetchTask = PrefetchV2.INSTANCE.getRunningPrefetchTask(prefetchRequest);
            if (runningPrefetchTask != null) {
                if (Intrinsics.areEqual(params.getStreamLoadType(), 1)) {
                    final Ref.IntRef intRef = new Ref.IntRef();
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    runningPrefetchTask.observe(new PrefetchTask.StreamCallback() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$2
                        /* JADX WARN: Multi-variable type inference failed */
                        public void onFailure(PrefetchRequest request, Throwable throwable) {
                            Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
                            Intrinsics.checkNotNullParameter(throwable, "throwable");
                            HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "task observe failed, error: " + throwable.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                            StreamRequestTransmitter streamRequestTransmitter = StreamRequestTransmitter.INSTANCE;
                            String streamSessionId = AbsXRequestMethodIDL.XRequestParamModel.this.getStreamSessionId();
                            Intrinsics.checkNotNull(streamSessionId);
                            streamRequestTransmitter.transmitError(streamSessionId, bridgeContext, cacheByRequest, throwable);
                            CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock = callback;
                            String th = throwable.toString();
                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                            AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                            xRequestResultModel.setHttpCode(Integer.valueOf(XBridgeAPIRequestUtils.ERROR_CODE_408));
                            xRequestResultModel.setClientCode(xRequestResultModel.getClientCode());
                            xRequestResultModel.setPrefetchStatus((Number) 1);
                            xRequestResultModel.setRawResponse(xRequestResultModel.getRawResponse());
                            Unit unit = Unit.INSTANCE;
                            completionBlock.onFailure(XRequestMethod.CODE_PREFETCH_FAILED, th, (XBaseResultModel) createXModel);
                            this.reportPrefetchResult(contextProviderFactory, AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), false, 1, throwable.toString(), System.currentTimeMillis() - currentTimeMillis, request.getConfigFrom());
                        }

                        public void onObserved(PrefetchRequest request, PrefetchResult result) {
                            Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
                            Intrinsics.checkNotNullParameter(result, "result");
                            Ref.IntRef intRef2 = intRef;
                            StreamRequestTransmitter streamRequestTransmitter = StreamRequestTransmitter.INSTANCE;
                            String streamSessionId = AbsXRequestMethodIDL.XRequestParamModel.this.getStreamSessionId();
                            Intrinsics.checkNotNull(streamSessionId);
                            intRef2.element = streamRequestTransmitter.transmitByProgress(streamSessionId, intRef.element, bridgeContext, result);
                            if (booleanRef.element) {
                                return;
                            }
                            CompletionBlock.DefaultImpls.onSuccess$default(callback, XRequestMethodKt.toResultModel(result, (Number) 1), null, 2, null);
                            booleanRef.element = true;
                        }

                        public void onProgress(PrefetchRequest request, PrefetchResult result) {
                            Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
                            Intrinsics.checkNotNullParameter(result, "result");
                            Ref.IntRef intRef2 = intRef;
                            StreamRequestTransmitter streamRequestTransmitter = StreamRequestTransmitter.INSTANCE;
                            String streamSessionId = AbsXRequestMethodIDL.XRequestParamModel.this.getStreamSessionId();
                            Intrinsics.checkNotNull(streamSessionId);
                            intRef2.element = streamRequestTransmitter.transmitByProgress(streamSessionId, intRef.element, bridgeContext, result);
                            if (booleanRef.element) {
                                return;
                            }
                            CompletionBlock.DefaultImpls.onSuccess$default(callback, XRequestMethodKt.toResultModel(result, (Number) 1), null, 2, null);
                            booleanRef.element = true;
                        }

                        public void onSuccess(PrefetchRequest request, PrefetchResult result) {
                            Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
                            Intrinsics.checkNotNullParameter(result, "result");
                            StreamRequestTransmitter streamRequestTransmitter = StreamRequestTransmitter.INSTANCE;
                            String streamSessionId = AbsXRequestMethodIDL.XRequestParamModel.this.getStreamSessionId();
                            Intrinsics.checkNotNull(streamSessionId);
                            streamRequestTransmitter.transmitByProgress(streamSessionId, intRef.element, bridgeContext, result);
                            if (booleanRef.element) {
                                return;
                            }
                            CompletionBlock.DefaultImpls.onSuccess$default(callback, XRequestMethodKt.toResultModel(result, (Number) 1), null, 2, null);
                            booleanRef.element = true;
                        }
                    });
                    return;
                }
                runningPrefetchTask.observe(new PrefetchTask.Callback() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$3
                    public void onSuccess(PrefetchRequest request, PrefetchResult result) {
                        Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
                        Intrinsics.checkNotNullParameter(result, "result");
                        CompletionBlock.DefaultImpls.onSuccess$default(callback, XRequestMethodKt.toResultModel(result, (Number) 1), null, 2, null);
                        this.reportPrefetchResult(contextProviderFactory, params.getUrl(), true, 1, "hit pending success", System.currentTimeMillis() - currentTimeMillis, result.getConfigFrom());
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public void onFailure(PrefetchRequest request, Throwable throwable) {
                        Intrinsics.checkNotNullParameter(request, OauthTokenTriggerScene.REQUEST);
                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                        CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock = callback;
                        String th = throwable.toString();
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                        AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                        xRequestResultModel.setHttpCode(Integer.valueOf(XBridgeAPIRequestUtils.ERROR_CODE_408));
                        xRequestResultModel.setClientCode(xRequestResultModel.getClientCode());
                        xRequestResultModel.setPrefetchStatus((Number) 1);
                        xRequestResultModel.setRawResponse(xRequestResultModel.getRawResponse());
                        Unit unit = Unit.INSTANCE;
                        completionBlock.onFailure(XRequestMethod.CODE_PREFETCH_FAILED, th, (XBaseResultModel) createXModel);
                        this.reportPrefetchResult(contextProviderFactory, params.getUrl(), false, 1, throwable.toString(), System.currentTimeMillis() - currentTimeMillis, request.getConfigFrom());
                    }
                });
                return;
            }
        }
        if (Intrinsics.areEqual(usePrefetch, true)) {
            PrefetchLogger.INSTANCE.e("未命中prefetch，请检查bridge请求参数跟配置是否匹配: " + params.getUrl());
            Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$4
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    String str;
                    IBulletContainer iBulletContainer2;
                    BulletContext bulletContext;
                    ContextProviderFactory contextProviderFactory2 = contextProviderFactory;
                    String sessionId = (contextProviderFactory2 == null || (iBulletContainer2 = (IBulletContainer) contextProviderFactory2.provideInstance(IBulletContainer.class)) == null || (bulletContext = iBulletContainer2.getBulletContext()) == null) ? null : bulletContext.getSessionId();
                    PrefetchConfig prefetchConfig = sessionId != null ? PrefetchSessionManager.INSTANCE.getOrCreateContext(sessionId).getPrefetchConfig() : null;
                    XRequestMethod xRequestMethod = this;
                    ContextProviderFactory contextProviderFactory3 = contextProviderFactory;
                    String url2 = params.getUrl();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (prefetchConfig == null || (str = prefetchConfig.getConfigFrom()) == null) {
                        str = "unknown";
                    }
                    xRequestMethod.reportPrefetchResult(contextProviderFactory3, url2, false, 0, "prefetch missed", currentTimeMillis2, str);
                }
            });
        }
        final RequestMethodType requestMethodTypeByName = RequestMethodType.INSTANCE.getRequestMethodTypeByName(params.getMethod());
        final PlatformType platformType = bridgeContext.getPlatformType();
        if (requestMethodTypeByName == RequestMethodType.UNSUPPORTED) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "Illegal method " + params.getMethod(), null, 4, null);
            return;
        }
        final Map<String, Object> header = params.getHeader();
        final Object body2 = params.getBody();
        final String bodyType = params.getBodyType();
        final Map<String, Object> params2 = params.getParams();
        Number maxLength = params.getMaxLength();
        final int intValue = maxLength != null ? maxLength.intValue() : -1;
        if (TextUtils.isEmpty(params.getUrl())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "url is empty", null, 4, null);
        } else if (intValue > 10485760) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "maxLength too large: " + intValue + ", exceed max size 10MB, maybe cause oom", null, 4, null);
        } else {
            final long currentTimeMillis2 = System.currentTimeMillis();
            getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5
                /* JADX WARN: Type inference failed for: r6v3, types: [com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamGetResponseCallback$1] */
                @Override // java.lang.Runnable
                public final void run() {
                    String addParametersToUrl;
                    final IHostNetworkDependV2 networkDependInstance;
                    IContextProvider provider;
                    final LinkedHashMap<String, String> filterHeaderEmptyValue = XBridgeAPIRequestUtils.INSTANCE.filterHeaderEmptyValue(header);
                    String str = filterHeaderEmptyValue.containsKey("content-type") ? filterHeaderEmptyValue.get("content-type") : filterHeaderEmptyValue.containsKey("Content-Type") ? filterHeaderEmptyValue.get("Content-Type") : null;
                    XBridgeAPIRequestUtils.INSTANCE.addXSecurityArgusHeader(filterHeaderEmptyValue, bridgeContext);
                    ContextProviderFactory contextProviderFactory2 = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
                    XRequestMethod.IRequestInterceptor iRequestInterceptor = (contextProviderFactory2 == null || (provider = contextProviderFactory2.getProvider(XRequestMethod.IRequestInterceptor.class)) == null) ? null : (XRequestMethod.IRequestInterceptor) provider.provideInstance();
                    if (iRequestInterceptor != null) {
                        XBridgeAPIRequestUtils xBridgeAPIRequestUtils = XBridgeAPIRequestUtils.INSTANCE;
                        String addParamsToUrl = iRequestInterceptor.addParamsToUrl(params.getUrl());
                        if (addParamsToUrl == null) {
                            addParamsToUrl = params.getUrl();
                        }
                        addParametersToUrl = xBridgeAPIRequestUtils.addParametersToUrl(addParamsToUrl, params2, platformType, params.getAddCommonParams());
                    } else {
                        addParametersToUrl = XBridgeAPIRequestUtils.INSTANCE.addParametersToUrl(params.getUrl(), params2, platformType, params.getAddCommonParams());
                    }
                    final String str2 = addParametersToUrl;
                    this.addAnnieXAccessToken(filterHeaderEmptyValue, bridgeContext, str2);
                    final AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel = params;
                    final XRequestMethod xRequestMethod = this;
                    final IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                    final long j = currentTimeMillis2;
                    final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock = callback;
                    IResponseCallback iResponseCallback = new IResponseCallback(xRequestMethod, iBDXBridgeContext, j, completionBlock) { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$responseCallback$1
                        final /* synthetic */ IBDXBridgeContext $bridgeContext;
                        final /* synthetic */ CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> $callback;
                        final /* synthetic */ long $realRequestStart;
                        private final String method;
                        final /* synthetic */ XRequestMethod this$0;
                        private final String url;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.this$0 = xRequestMethod;
                            this.$bridgeContext = iBDXBridgeContext;
                            this.$realRequestStart = j;
                            this.$callback = completionBlock;
                            this.method = AbsXRequestMethodIDL.XRequestParamModel.this.getMethod();
                            this.url = AbsXRequestMethodIDL.XRequestParamModel.this.getUrl();
                        }

                        public final String getMethod() {
                            return this.method;
                        }

                        public final String getUrl() {
                            return this.url;
                        }

                        /* JADX WARN: Can't wrap try/catch for region: R(29:1|2|3|4|(1:82)(1:10)|11|(1:81)(1:17)|18|(3:20|(1:(1:23)(2:75|(1:77)(1:78)))(1:79)|(19:25|(18:27|(1:(1:33))(1:73)|(6:35|(1:37)(1:71)|38|39|40|41)(1:72)|42|43|(1:45)|46|(1:48)(1:66)|49|50|51|(2:54|52)|55|56|(1:58)|59|60|61)|74|(0)(0)|42|43|(0)|46|(0)(0)|49|50|51|(1:52)|55|56|(0)|59|60|61))|80|(0)|74|(0)(0)|42|43|(0)|46|(0)(0)|49|50|51|(1:52)|55|56|(0)|59|60|61|(1:(0))) */
                        /* JADX WARN: Code restructure failed: missing block: B:64:0x01b9, code lost:
                        
                            r0 = move-exception;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:65:0x01ba, code lost:
                        
                            android.util.Log.e(com.bytedance.sdk.xbridge.cn.network.XRequestMethod.INSTANCE.getTAG(), "parse response body failed", r0);
                         */
                        /* JADX WARN: Removed duplicated region for block: B:27:0x00c5 A[Catch: all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:3:0x0025, B:6:0x002f, B:8:0x0037, B:10:0x003d, B:11:0x0053, B:13:0x0059, B:15:0x0061, B:17:0x0067, B:20:0x0080, B:23:0x0088, B:25:0x00ba, B:27:0x00c5, B:31:0x00ce, B:33:0x00da, B:35:0x00f3, B:37:0x00f9, B:73:0x00e5, B:75:0x008d, B:77:0x0099, B:79:0x00aa), top: B:2:0x0025 }] */
                        /* JADX WARN: Removed duplicated region for block: B:35:0x00f3 A[Catch: all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:3:0x0025, B:6:0x002f, B:8:0x0037, B:10:0x003d, B:11:0x0053, B:13:0x0059, B:15:0x0061, B:17:0x0067, B:20:0x0080, B:23:0x0088, B:25:0x00ba, B:27:0x00c5, B:31:0x00ce, B:33:0x00da, B:35:0x00f3, B:37:0x00f9, B:73:0x00e5, B:75:0x008d, B:77:0x0099, B:79:0x00aa), top: B:2:0x0025 }] */
                        /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
                        /* JADX WARN: Removed duplicated region for block: B:48:0x0155  */
                        /* JADX WARN: Removed duplicated region for block: B:54:0x0190 A[Catch: all -> 0x01b9, LOOP:0: B:52:0x018a->B:54:0x0190, LOOP_END, TryCatch #2 {all -> 0x01b9, blocks: (B:51:0x017a, B:52:0x018a, B:54:0x0190, B:59:0x01ae), top: B:50:0x017a }] */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x01ac  */
                        /* JADX WARN: Removed duplicated region for block: B:66:0x015a  */
                        /* JADX WARN: Removed duplicated region for block: B:72:0x010c  */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onSuccess(JSONObject body3, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                            int i;
                            Object obj;
                            Throwable th;
                            Iterator<String> keys;
                            List split$default;
                            List split$default2;
                            int i2;
                            String str3;
                            JSONObject optJSONObject;
                            Integer valueOf;
                            Object obj2;
                            String obj3;
                            Object obj4;
                            String obj5;
                            Intrinsics.checkNotNullParameter(body3, "body");
                            Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                            String str4 = responseHeader.get(XBridgeAPIRequestUtils.X_TT_LOG_ID);
                            AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel2 = AbsXRequestMethodIDL.XRequestParamModel.this;
                            XRequestMethod xRequestMethod2 = this.this$0;
                            IBDXBridgeContext iBDXBridgeContext2 = this.$bridgeContext;
                            try {
                                Result.Companion companion = Result.Companion;
                                Map<String, Object> extraInfo = xRequestParamModel2.getExtraInfo();
                                split$default = (extraInfo == null || (obj4 = extraInfo.get("errorNoField")) == null || (obj5 = obj4.toString()) == null) ? null : StringsKt.split$default(obj5, new String[]{"."}, false, 0, 6, (Object) null);
                                Map<String, Object> extraInfo2 = xRequestParamModel2.getExtraInfo();
                                split$default2 = (extraInfo2 == null || (obj2 = extraInfo2.get("errorMsgField")) == null || (obj3 = obj2.toString()) == null) ? null : StringsKt.split$default(obj3, new String[]{"."}, false, 0, 6, (Object) null);
                            } catch (Throwable th2) {
                                th = th2;
                                i = 0;
                            }
                            if (split$default != null) {
                                int size = split$default.size();
                                if (size == 1) {
                                    valueOf = Integer.valueOf(body3.optInt((String) split$default.get(0)));
                                } else if (size == 2) {
                                    JSONObject optJSONObject2 = body3.optJSONObject((String) split$default.get(0));
                                    valueOf = optJSONObject2 != null ? Integer.valueOf(optJSONObject2.optInt((String) split$default.get(1))) : null;
                                } else {
                                    valueOf = 0;
                                }
                                if (valueOf != null) {
                                    i2 = valueOf.intValue();
                                    if (split$default2 != null) {
                                        int size2 = split$default2.size();
                                        if (size2 == 1) {
                                            str3 = body3.optString((String) split$default2.get(0));
                                        } else if (size2 == 2 && (optJSONObject = body3.optJSONObject((String) split$default2.get(0))) != null) {
                                            str3 = optJSONObject.optString((String) split$default2.get(1));
                                        }
                                        if (i2 != 0) {
                                            int i3 = i2;
                                            i = 0;
                                            try {
                                                xRequestMethod2.reportJSBFetchError(iBDXBridgeContext2, this.method, this.url, statusCode != null ? statusCode.intValue() : -1, 1, "fetch success", i3, str3, str4);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                Result.Companion companion2 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                th = Result.exceptionOrNull-impl(obj);
                                                if (th != null) {
                                                }
                                                this.this$0.printNetworkConsumeLog(AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), this.$bridgeContext, this.$realRequestStart);
                                                CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock2 = this.$callback;
                                                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                                AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                                                xRequestResultModel.setHttpCode(statusCode == null ? statusCode : (Number) (-1));
                                                xRequestResultModel.setPrefetchStatus(Integer.valueOf(i));
                                                xRequestResultModel.setClientCode(Integer.valueOf(clientCode));
                                                xRequestResultModel.setHeader(responseHeader);
                                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                                keys = body3.keys();
                                                Intrinsics.checkNotNullExpressionValue(keys, "body.keys()");
                                                while (keys.hasNext()) {
                                                }
                                                if (str4 == null) {
                                                }
                                                linkedHashMap.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, str4);
                                                xRequestResultModel.setResponse(XBridgeKTXKt.assignX(linkedHashMap));
                                                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel, null, 2, null);
                                            }
                                        } else {
                                            i = 0;
                                        }
                                        obj = Result.constructor-impl(Unit.INSTANCE);
                                        th = Result.exceptionOrNull-impl(obj);
                                        if (th != null) {
                                            Log.e(XRequestMethod.INSTANCE.getTAG(), "parse response body failed", th);
                                        }
                                        this.this$0.printNetworkConsumeLog(AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), this.$bridgeContext, this.$realRequestStart);
                                        CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock22 = this.$callback;
                                        XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                        AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel2 = (AbsXRequestMethodIDL.XRequestResultModel) createXModel2;
                                        xRequestResultModel2.setHttpCode(statusCode == null ? statusCode : (Number) (-1));
                                        xRequestResultModel2.setPrefetchStatus(Integer.valueOf(i));
                                        xRequestResultModel2.setClientCode(Integer.valueOf(clientCode));
                                        xRequestResultModel2.setHeader(responseHeader);
                                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                        keys = body3.keys();
                                        Intrinsics.checkNotNullExpressionValue(keys, "body.keys()");
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            Intrinsics.checkNotNullExpressionValue(next, "key");
                                            Object obj6 = body3.get(next);
                                            Intrinsics.checkNotNullExpressionValue(obj6, "body.get(key)");
                                            linkedHashMap2.put(next, obj6);
                                        }
                                        if (str4 == null) {
                                            str4 = "";
                                        }
                                        linkedHashMap2.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, str4);
                                        xRequestResultModel2.setResponse(XBridgeKTXKt.assignX(linkedHashMap2));
                                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock22, (XBaseResultModel) createXModel2, null, 2, null);
                                    }
                                    str3 = null;
                                    if (i2 != 0) {
                                    }
                                    obj = Result.constructor-impl(Unit.INSTANCE);
                                    th = Result.exceptionOrNull-impl(obj);
                                    if (th != null) {
                                    }
                                    this.this$0.printNetworkConsumeLog(AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), this.$bridgeContext, this.$realRequestStart);
                                    CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock222 = this.$callback;
                                    XBaseModel createXModel22 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                    AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel22 = (AbsXRequestMethodIDL.XRequestResultModel) createXModel22;
                                    xRequestResultModel22.setHttpCode(statusCode == null ? statusCode : (Number) (-1));
                                    xRequestResultModel22.setPrefetchStatus(Integer.valueOf(i));
                                    xRequestResultModel22.setClientCode(Integer.valueOf(clientCode));
                                    xRequestResultModel22.setHeader(responseHeader);
                                    LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                                    keys = body3.keys();
                                    Intrinsics.checkNotNullExpressionValue(keys, "body.keys()");
                                    while (keys.hasNext()) {
                                    }
                                    if (str4 == null) {
                                    }
                                    linkedHashMap22.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, str4);
                                    xRequestResultModel22.setResponse(XBridgeKTXKt.assignX(linkedHashMap22));
                                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock222, (XBaseResultModel) createXModel22, null, 2, null);
                                }
                            }
                            i2 = 0;
                            if (split$default2 != null) {
                            }
                            str3 = null;
                            if (i2 != 0) {
                            }
                            obj = Result.constructor-impl(Unit.INSTANCE);
                            th = Result.exceptionOrNull-impl(obj);
                            if (th != null) {
                            }
                            this.this$0.printNetworkConsumeLog(AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), this.$bridgeContext, this.$realRequestStart);
                            CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock2222 = this.$callback;
                            XBaseModel createXModel222 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                            AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel222 = (AbsXRequestMethodIDL.XRequestResultModel) createXModel222;
                            xRequestResultModel222.setHttpCode(statusCode == null ? statusCode : (Number) (-1));
                            xRequestResultModel222.setPrefetchStatus(Integer.valueOf(i));
                            xRequestResultModel222.setClientCode(Integer.valueOf(clientCode));
                            xRequestResultModel222.setHeader(responseHeader);
                            LinkedHashMap linkedHashMap222 = new LinkedHashMap();
                            keys = body3.keys();
                            Intrinsics.checkNotNullExpressionValue(keys, "body.keys()");
                            while (keys.hasNext()) {
                            }
                            if (str4 == null) {
                            }
                            linkedHashMap222.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, str4);
                            xRequestResultModel222.setResponse(XBridgeKTXKt.assignX(linkedHashMap222));
                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2222, (XBaseResultModel) createXModel222, null, 2, null);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                        public Unit onParsingFailed(JSONObject body3, LinkedHashMap<String, String> responseHeader, String rawResponse, Throwable throwable, Integer statusCode, int clientCode) {
                            Intrinsics.checkNotNullParameter(body3, "body");
                            Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                            Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
                            Intrinsics.checkNotNullParameter(throwable, "throwable");
                            String str3 = responseHeader.get(XBridgeAPIRequestUtils.X_TT_LOG_ID);
                            this.this$0.printNetworkConsumeLog(AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), this.$bridgeContext, this.$realRequestStart);
                            this.this$0.reportJSBFetchError(this.$bridgeContext, this.method, this.url, statusCode != null ? statusCode.intValue() : -1, 0, throwable.toString(), 0, null, str3);
                            CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock2 = this.$callback;
                            String th = throwable.toString();
                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                            AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                            xRequestResultModel.setHttpCode(statusCode != null ? statusCode : (Number) (-1));
                            xRequestResultModel.setClientCode(Integer.valueOf(clientCode));
                            xRequestResultModel.setPrefetchStatus((Number) 0);
                            xRequestResultModel.setHeader(responseHeader);
                            try {
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                Iterator<String> keys = body3.keys();
                                Intrinsics.checkNotNullExpressionValue(keys, "body.keys()");
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    Intrinsics.checkNotNullExpressionValue(next, "key");
                                    Object obj = body3.get(next);
                                    Intrinsics.checkNotNullExpressionValue(obj, "body.get(key)");
                                    linkedHashMap.put(next, obj);
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                                linkedHashMap.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, str3);
                                xRequestResultModel.setResponse(XBridgeKTXKt.assignX(linkedHashMap));
                            } catch (Throwable th2) {
                                Log.e(XRequestMethod.INSTANCE.getTAG(), "parse response body failed", th2);
                            }
                            xRequestResultModel.setRawResponse(rawResponse);
                            Unit unit = Unit.INSTANCE;
                            completionBlock2.onFailure(0, th, (XBaseResultModel) createXModel);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                        public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                            int statusCode;
                            Intrinsics.checkNotNullParameter(throwable, "throwable");
                            this.this$0.printNetworkConsumeLog(AbsXRequestMethodIDL.XRequestParamModel.this.getUrl(), this.$bridgeContext, this.$realRequestStart);
                            if (throwable instanceof NetworkNotAvailabeException) {
                                statusCode = -1001;
                            } else if (throwable instanceof HttpResponseException) {
                                statusCode = ((HttpResponseException) throwable).getStatusCode();
                            } else {
                                statusCode = throwable instanceof CronetIOException ? ((CronetIOException) throwable).getStatusCode() : 0;
                            }
                            int intValue2 = errorCode != null ? errorCode.intValue() : XBridgeAPIRequestUtils.ERROR_CODE_408;
                            String str3 = responseHeader != null ? responseHeader.get(XBridgeAPIRequestUtils.X_TT_LOG_ID) : null;
                            int i = intValue2;
                            this.this$0.reportJSBFetchError(this.$bridgeContext, this.method, this.url, intValue2, statusCode, throwable.toString(), 0, null, str3);
                            CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock2 = this.$callback;
                            String str4 = "Request failed, httpCode: " + i + ", clientCode:" + clientCode + ", message: " + throwable;
                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                            AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                            xRequestResultModel.setPrefetchStatus((Number) 0);
                            xRequestResultModel.setHttpCode(Integer.valueOf(i));
                            xRequestResultModel.setClientCode(Integer.valueOf(clientCode));
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("errCode", Integer.valueOf(errorCode != null ? errorCode.intValue() : XBridgeAPIRequestUtils.ERROR_CODE_408));
                            String message = throwable.getMessage();
                            if (message == null) {
                                message = "";
                            }
                            linkedHashMap.put("message", message);
                            linkedHashMap.put("prompts", "");
                            if (str3 == null) {
                                str3 = "";
                            }
                            linkedHashMap.put(XBridgeAPIRequestUtils.REQUEST_ID_KEY, str3);
                            xRequestResultModel.setResponse(XBridgeKTXKt.assignX(linkedHashMap));
                            Unit unit = Unit.INSTANCE;
                            completionBlock2.onFailure(statusCode, str4, (XBaseResultModel) createXModel);
                        }
                    };
                    final XRequestMethod xRequestMethod2 = this;
                    final AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel2 = params;
                    final IBDXBridgeContext iBDXBridgeContext2 = bridgeContext;
                    final long j2 = currentTimeMillis2;
                    final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock2 = callback;
                    IStreamResponseCallback iStreamResponseCallback = new IStreamResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamResponseCallback$1
                        /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
                        
                            if ((r0.length() > 0) != false) goto L25;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:57:0x0126 A[Catch: IOException -> 0x012f, TryCatch #4 {IOException -> 0x012f, blocks: (B:55:0x0121, B:57:0x0126, B:59:0x012b), top: B:54:0x0121 }] */
                        /* JADX WARN: Removed duplicated region for block: B:59:0x012b A[Catch: IOException -> 0x012f, TRY_LEAVE, TryCatch #4 {IOException -> 0x012f, blocks: (B:55:0x0121, B:57:0x0126, B:59:0x012b), top: B:54:0x0121 }] */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void handleConnection(AbsStreamConnection connection) {
                            ByteArrayOutputStream byteArrayOutputStream;
                            if (connection == null) {
                                Log.d(XRequestMethod.INSTANCE.getTAG(), "connection is null");
                                Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                                final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock3 = completionBlock2;
                                mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamResponseCallback$1$handleConnection$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock4 = completionBlock3;
                                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                        AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                                        xRequestResultModel.setHttpCode((Number) 0);
                                        xRequestResultModel.setClientCode((Number) 0);
                                        Unit unit = Unit.INSTANCE;
                                        completionBlock4.onFailure(0, "connection failed", (XBaseResultModel) createXModel);
                                    }
                                });
                                return;
                            }
                            final String errorMsg = connection.getErrorMsg();
                            BufferedInputStream bufferedInputStream = null;
                            if (!(errorMsg.length() > 0)) {
                                errorMsg = null;
                            }
                            if (errorMsg == null) {
                                Throwable exception = connection.getException();
                                if (exception != null && (errorMsg = exception.getMessage()) != null) {
                                }
                                errorMsg = null;
                            }
                            InputStream inputStreamResponseBody = connection.getInputStreamResponseBody();
                            final int responseCode = connection.getResponseCode();
                            final Integer clientCode = connection.getClientCode();
                            if (inputStreamResponseBody == null) {
                                Log.d(XRequestMethod.INSTANCE.getTAG(), "body is null");
                                XRequestMethod.this.printNetworkConsumeLog(xRequestParamModel2.getUrl(), iBDXBridgeContext2, j2);
                                Handler mainThreadHandler2 = ThreadUtils.getMainThreadHandler();
                                final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock4 = completionBlock2;
                                mainThreadHandler2.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamResponseCallback$1$handleConnection$2
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Object obj;
                                        Object obj2;
                                        CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock5 = completionBlock4;
                                        String str3 = errorMsg;
                                        if (str3 == null) {
                                            str3 = "body is null";
                                        }
                                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                        int i = responseCode;
                                        Integer num = clientCode;
                                        AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            obj = Result.constructor-impl(Integer.valueOf(i));
                                        } catch (Throwable th) {
                                            Result.Companion companion2 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        if (Result.isFailure-impl(obj)) {
                                            obj = 0;
                                        }
                                        xRequestResultModel.setHttpCode((Number) obj);
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj2 = Result.constructor-impl(num != null ? Integer.valueOf(num.intValue()) : null);
                                        } catch (Throwable th2) {
                                            Result.Companion companion4 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                        }
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = 0;
                                        }
                                        xRequestResultModel.setClientCode((Number) obj2);
                                        Unit unit = Unit.INSTANCE;
                                        completionBlock5.onFailure(0, str3, (XBaseResultModel) createXModel);
                                    }
                                });
                                return;
                            }
                            final LinkedHashMap<String, String> responseHeader = connection.getResponseHeader();
                            try {
                                try {
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStreamResponseBody);
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        try {
                                            byte[] bArr = new byte[4096];
                                            while (true) {
                                                int read = bufferedInputStream2.read(bArr);
                                                if (read != -1) {
                                                    byteArrayOutputStream.write(bArr, 0, read);
                                                } else {
                                                    final String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                                                    XRequestMethod.this.printNetworkConsumeLog(xRequestParamModel2.getUrl(), iBDXBridgeContext2, j2);
                                                    Handler mainThreadHandler3 = ThreadUtils.getMainThreadHandler();
                                                    final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock5 = completionBlock2;
                                                    mainThreadHandler3.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamResponseCallback$1$handleConnection$4
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Object obj;
                                                            Object obj2;
                                                            CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock6 = completionBlock5;
                                                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                                            LinkedHashMap<String, String> linkedHashMap = responseHeader;
                                                            String str3 = encodeToString;
                                                            int i = responseCode;
                                                            Integer num = clientCode;
                                                            AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                                                            xRequestResultModel.setPrefetchStatus((Number) r7);
                                                            try {
                                                                Result.Companion companion = Result.Companion;
                                                                obj = Result.constructor-impl(Integer.valueOf(i));
                                                            } catch (Throwable th) {
                                                                Result.Companion companion2 = Result.Companion;
                                                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                            }
                                                            if (Result.isFailure-impl(obj)) {
                                                                obj = r7;
                                                            }
                                                            xRequestResultModel.setHttpCode((Number) obj);
                                                            try {
                                                                Result.Companion companion3 = Result.Companion;
                                                                obj2 = Result.constructor-impl(num != null ? Integer.valueOf(num.intValue()) : null);
                                                            } catch (Throwable th2) {
                                                                Result.Companion companion4 = Result.Companion;
                                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                            }
                                                            xRequestResultModel.setClientCode((Number) (Result.isFailure-impl(obj2) ? 0 : obj2));
                                                            xRequestResultModel.setHeader(linkedHashMap);
                                                            xRequestResultModel.setResponse(str3);
                                                            xRequestResultModel.setResponseType("base64");
                                                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock6, (XBaseResultModel) createXModel, null, 2, null);
                                                        }
                                                    });
                                                    connection.cancel();
                                                    bufferedInputStream2.close();
                                                    byteArrayOutputStream.close();
                                                    return;
                                                }
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            bufferedInputStream = bufferedInputStream2;
                                            try {
                                                XRequestMethod.this.printNetworkConsumeLog(xRequestParamModel2.getUrl(), iBDXBridgeContext2, j2);
                                                Handler mainThreadHandler4 = ThreadUtils.getMainThreadHandler();
                                                final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock6 = completionBlock2;
                                                mainThreadHandler4.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamResponseCallback$1$handleConnection$5
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        Object obj;
                                                        Object obj2;
                                                        CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock7 = completionBlock6;
                                                        String message = e.getMessage();
                                                        if (message == null) {
                                                            message = "get data from stream exception";
                                                        }
                                                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                                        int i = responseCode;
                                                        Integer num = clientCode;
                                                        AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                                                        xRequestResultModel.setPrefetchStatus((Number) 0);
                                                        try {
                                                            Result.Companion companion = Result.Companion;
                                                            obj = Result.constructor-impl(Integer.valueOf(i));
                                                        } catch (Throwable th) {
                                                            Result.Companion companion2 = Result.Companion;
                                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                        }
                                                        if (Result.isFailure-impl(obj)) {
                                                            obj = 0;
                                                        }
                                                        xRequestResultModel.setHttpCode((Number) obj);
                                                        try {
                                                            Result.Companion companion3 = Result.Companion;
                                                            obj2 = Result.constructor-impl(num != null ? Integer.valueOf(num.intValue()) : null);
                                                        } catch (Throwable th2) {
                                                            Result.Companion companion4 = Result.Companion;
                                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                        }
                                                        if (Result.isFailure-impl(obj2)) {
                                                            obj2 = 0;
                                                        }
                                                        xRequestResultModel.setClientCode((Number) obj2);
                                                        Unit unit = Unit.INSTANCE;
                                                        completionBlock7.onFailure(0, message, (XBaseResultModel) createXModel);
                                                    }
                                                });
                                                connection.cancel();
                                                if (bufferedInputStream != null) {
                                                    bufferedInputStream.close();
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                try {
                                                    connection.cancel();
                                                    if (bufferedInputStream != null) {
                                                        bufferedInputStream.close();
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                        byteArrayOutputStream.close();
                                                    }
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            bufferedInputStream = bufferedInputStream2;
                                            connection.cancel();
                                            if (bufferedInputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        byteArrayOutputStream = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteArrayOutputStream = null;
                                    }
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            } catch (Exception e5) {
                                e = e5;
                                byteArrayOutputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = null;
                            }
                        }
                    };
                    final CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock3 = callback;
                    final IBDXBridgeContext iBDXBridgeContext3 = bridgeContext;
                    final AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel3 = params;
                    final ?? r6 = new IStreamResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5$streamGetResponseCallback$1
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:44:0x021c  */
                        /* JADX WARN: Removed duplicated region for block: B:47:0x023a A[Catch: all -> 0x0268, TryCatch #6 {all -> 0x0268, blocks: (B:42:0x0203, B:45:0x021e, B:47:0x023a, B:48:0x0240, B:51:0x0252), top: B:41:0x0203 }] */
                        /* JADX WARN: Removed duplicated region for block: B:50:0x024f  */
                        /* JADX WARN: Removed duplicated region for block: B:56:0x025f A[Catch: IOException -> 0x0263, TRY_LEAVE, TryCatch #13 {IOException -> 0x0263, blocks: (B:54:0x025a, B:56:0x025f), top: B:53:0x025a }] */
                        /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:63:0x023f  */
                        /* JADX WARN: Removed duplicated region for block: B:69:0x0270 A[Catch: IOException -> 0x0274, TRY_LEAVE, TryCatch #5 {IOException -> 0x0274, blocks: (B:67:0x026b, B:69:0x0270), top: B:66:0x026b }] */
                        /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void handleConnection(AbsStreamConnection connection) {
                            String str3;
                            String str4;
                            String str5;
                            Throwable th;
                            String streamSessionId;
                            String message;
                            BufferedInputStream bufferedInputStream;
                            BufferedInputStream bufferedInputStream2;
                            byte[] bArr;
                            IBDXBridgeContext iBDXBridgeContext4;
                            AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel4;
                            int i;
                            String str6;
                            LinkedHashMap linkedHashMap;
                            int intValue2;
                            String str7;
                            int i2;
                            String str8;
                            String str9 = "clientCode";
                            String str10 = "httpCode";
                            String str11 = "complete";
                            String str12 = "";
                            if (connection == null) {
                                HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "connection is null", (Map) null, (LoggerContext) null, 12, (Object) null);
                                CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock4 = completionBlock3;
                                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) createXModel;
                                xRequestResultModel.setHttpCode((Number) 0);
                                xRequestResultModel.setClientCode((Number) 0);
                                Unit unit = Unit.INSTANCE;
                                completionBlock4.onFailure(0, "connection is null", (XBaseResultModel) createXModel);
                                return;
                            }
                            InputStream inputStreamResponseBody = connection.getInputStreamResponseBody();
                            int responseCode = connection.getResponseCode();
                            Integer clientCode = connection.getClientCode();
                            if (inputStreamResponseBody == null) {
                                CompletionBlock<AbsXRequestMethodIDL.XRequestResultModel> completionBlock5 = completionBlock3;
                                XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
                                AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel2 = (AbsXRequestMethodIDL.XRequestResultModel) createXModel2;
                                xRequestResultModel2.setHttpCode(Integer.valueOf(responseCode));
                                xRequestResultModel2.setClientCode(clientCode);
                                Unit unit2 = Unit.INSTANCE;
                                completionBlock5.onFailure(0, "body is null", (XBaseResultModel) createXModel2);
                                return;
                            }
                            BufferedInputStream bufferedInputStream3 = null;
                            try {
                                try {
                                    bufferedInputStream = new BufferedInputStream(inputStreamResponseBody);
                                    try {
                                        bArr = new byte[IConditionCallKt.annieXStreamPrefetchChunkSize()];
                                        iBDXBridgeContext4 = iBDXBridgeContext3;
                                        xRequestParamModel4 = xRequestParamModel3;
                                        i = 0;
                                    } catch (Exception e) {
                                        e = e;
                                        str3 = str11;
                                        str4 = str12;
                                        bufferedInputStream2 = bufferedInputStream;
                                        str5 = str9;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedInputStream2 = bufferedInputStream;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    str3 = "complete";
                                    str4 = "";
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                try {
                                    connection.cancel();
                                    if (bufferedInputStream3 == null) {
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                str4 = str12;
                                if (read == -1) {
                                    break;
                                }
                                bufferedInputStream2 = bufferedInputStream;
                                try {
                                    try {
                                        String encodeToString = Base64.encodeToString(bArr, 0, read, 2);
                                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                        byte[] bArr2 = bArr;
                                        linkedHashMap2.put("streamLoadType", 1);
                                        str6 = str9;
                                        try {
                                            str7 = str10;
                                            try {
                                                i2 = i;
                                                str8 = str11;
                                            } catch (Exception e4) {
                                                e = e4;
                                                str3 = str11;
                                                bufferedInputStream3 = bufferedInputStream2;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            str3 = str11;
                                            bufferedInputStream3 = bufferedInputStream2;
                                            str5 = str6;
                                            HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "performStreamRequest error reason: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                            try {
                                                IBDXBridgeContext iBDXBridgeContext5 = iBDXBridgeContext3;
                                                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                                                AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel5 = xRequestParamModel3;
                                                linkedHashMap3.put("streamLoadType", 1);
                                                streamSessionId = xRequestParamModel5.getStreamSessionId();
                                                if (streamSessionId == null) {
                                                }
                                                linkedHashMap3.put("streamSessionId", streamSessionId);
                                                linkedHashMap3.put("dataType", "arraybuffer");
                                                linkedHashMap3.put("stage", str3);
                                                linkedHashMap3.put(str10, Integer.valueOf(connection.getResponseCode()));
                                                Integer clientCode2 = connection.getClientCode();
                                                linkedHashMap3.put(str5, Integer.valueOf(clientCode2 == null ? clientCode2.intValue() : 0));
                                                message = e.getMessage();
                                                if (message == null) {
                                                }
                                                linkedHashMap3.put("msg", message);
                                                Unit unit3 = Unit.INSTANCE;
                                                iBDXBridgeContext5.sendEvent("x.requestChunkData", linkedHashMap3);
                                                try {
                                                    connection.cancel();
                                                    if (bufferedInputStream3 == null) {
                                                    }
                                                } catch (IOException e6) {
                                                    e6.printStackTrace();
                                                    return;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                th = th;
                                                connection.cancel();
                                                if (bufferedInputStream3 == null) {
                                                }
                                            }
                                        }
                                        try {
                                            int i3 = i2 + read;
                                            linkedHashMap2.put("content-range", "bytes=" + i2 + '-' + i3);
                                            Intrinsics.checkNotNullExpressionValue(encodeToString, "data");
                                            linkedHashMap2.put("data", encodeToString);
                                            linkedHashMap2.put("length", Integer.valueOf(read));
                                            String streamSessionId2 = xRequestParamModel4.getStreamSessionId();
                                            if (streamSessionId2 == null) {
                                                streamSessionId2 = str4;
                                            }
                                            linkedHashMap2.put("streamSessionId", streamSessionId2);
                                            linkedHashMap2.put("stage", "inProgress");
                                            linkedHashMap2.put("dataType", "base64");
                                            Unit unit4 = Unit.INSTANCE;
                                            iBDXBridgeContext4.sendEvent("x.requestChunkData", linkedHashMap2);
                                            bArr = bArr2;
                                            str12 = str4;
                                            bufferedInputStream = bufferedInputStream2;
                                            str11 = str8;
                                            str9 = str6;
                                            i = i3;
                                            str10 = str7;
                                        } catch (Exception e7) {
                                            e = e7;
                                            bufferedInputStream3 = bufferedInputStream2;
                                            str3 = str8;
                                            str5 = str6;
                                            str10 = str7;
                                            HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "performStreamRequest error reason: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                            IBDXBridgeContext iBDXBridgeContext52 = iBDXBridgeContext3;
                                            LinkedHashMap linkedHashMap32 = new LinkedHashMap();
                                            AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel52 = xRequestParamModel3;
                                            linkedHashMap32.put("streamLoadType", 1);
                                            streamSessionId = xRequestParamModel52.getStreamSessionId();
                                            if (streamSessionId == null) {
                                            }
                                            linkedHashMap32.put("streamSessionId", streamSessionId);
                                            linkedHashMap32.put("dataType", "arraybuffer");
                                            linkedHashMap32.put("stage", str3);
                                            linkedHashMap32.put(str10, Integer.valueOf(connection.getResponseCode()));
                                            Integer clientCode22 = connection.getClientCode();
                                            linkedHashMap32.put(str5, Integer.valueOf(clientCode22 == null ? clientCode22.intValue() : 0));
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            linkedHashMap32.put("msg", message);
                                            Unit unit32 = Unit.INSTANCE;
                                            iBDXBridgeContext52.sendEvent("x.requestChunkData", linkedHashMap32);
                                            connection.cancel();
                                            if (bufferedInputStream3 == null) {
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    str3 = str11;
                                    bufferedInputStream3 = bufferedInputStream2;
                                    str5 = str9;
                                    HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "performStreamRequest error reason: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                    IBDXBridgeContext iBDXBridgeContext522 = iBDXBridgeContext3;
                                    LinkedHashMap linkedHashMap322 = new LinkedHashMap();
                                    AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel522 = xRequestParamModel3;
                                    linkedHashMap322.put("streamLoadType", 1);
                                    streamSessionId = xRequestParamModel522.getStreamSessionId();
                                    if (streamSessionId == null) {
                                    }
                                    linkedHashMap322.put("streamSessionId", streamSessionId);
                                    linkedHashMap322.put("dataType", "arraybuffer");
                                    linkedHashMap322.put("stage", str3);
                                    linkedHashMap322.put(str10, Integer.valueOf(connection.getResponseCode()));
                                    Integer clientCode222 = connection.getClientCode();
                                    linkedHashMap322.put(str5, Integer.valueOf(clientCode222 == null ? clientCode222.intValue() : 0));
                                    message = e.getMessage();
                                    if (message == null) {
                                    }
                                    linkedHashMap322.put("msg", message);
                                    Unit unit322 = Unit.INSTANCE;
                                    iBDXBridgeContext522.sendEvent("x.requestChunkData", linkedHashMap322);
                                    connection.cancel();
                                    if (bufferedInputStream3 == null) {
                                    }
                                }
                                th = th5;
                                th = th;
                                bufferedInputStream3 = bufferedInputStream2;
                                connection.cancel();
                                if (bufferedInputStream3 == null) {
                                    throw th;
                                }
                                bufferedInputStream3.close();
                                throw th;
                            }
                            str6 = str9;
                            String str13 = str10;
                            String str14 = str11;
                            bufferedInputStream2 = bufferedInputStream;
                            try {
                                linkedHashMap = new LinkedHashMap();
                                linkedHashMap.put("streamLoadType", 1);
                                String streamSessionId3 = xRequestParamModel4.getStreamSessionId();
                                if (streamSessionId3 == null) {
                                    streamSessionId3 = str4;
                                }
                                linkedHashMap.put("streamSessionId", streamSessionId3);
                                linkedHashMap.put("dataType", "base64");
                                str3 = str14;
                            } catch (Exception e9) {
                                e = e9;
                                str3 = str14;
                            }
                            try {
                                linkedHashMap.put("stage", str3);
                                str10 = str13;
                                try {
                                    linkedHashMap.put(str10, Integer.valueOf(connection.getResponseCode()));
                                    Integer clientCode3 = connection.getClientCode();
                                    if (clientCode3 != null) {
                                        try {
                                            intValue2 = clientCode3.intValue();
                                        } catch (Exception e10) {
                                            e = e10;
                                            bufferedInputStream3 = bufferedInputStream2;
                                            str5 = str6;
                                            HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "performStreamRequest error reason: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                            IBDXBridgeContext iBDXBridgeContext5222 = iBDXBridgeContext3;
                                            LinkedHashMap linkedHashMap3222 = new LinkedHashMap();
                                            AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel5222 = xRequestParamModel3;
                                            linkedHashMap3222.put("streamLoadType", 1);
                                            streamSessionId = xRequestParamModel5222.getStreamSessionId();
                                            if (streamSessionId == null) {
                                            }
                                            linkedHashMap3222.put("streamSessionId", streamSessionId);
                                            linkedHashMap3222.put("dataType", "arraybuffer");
                                            linkedHashMap3222.put("stage", str3);
                                            linkedHashMap3222.put(str10, Integer.valueOf(connection.getResponseCode()));
                                            Integer clientCode2222 = connection.getClientCode();
                                            linkedHashMap3222.put(str5, Integer.valueOf(clientCode2222 == null ? clientCode2222.intValue() : 0));
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            linkedHashMap3222.put("msg", message);
                                            Unit unit3222 = Unit.INSTANCE;
                                            iBDXBridgeContext5222.sendEvent("x.requestChunkData", linkedHashMap3222);
                                            connection.cancel();
                                            if (bufferedInputStream3 == null) {
                                            }
                                        }
                                    } else {
                                        intValue2 = 0;
                                    }
                                    str5 = str6;
                                } catch (Exception e11) {
                                    e = e11;
                                    str5 = str6;
                                }
                                try {
                                    linkedHashMap.put(str5, Integer.valueOf(intValue2));
                                    Unit unit5 = Unit.INSTANCE;
                                    iBDXBridgeContext4.sendEvent("x.requestChunkData", linkedHashMap);
                                    try {
                                        connection.cancel();
                                        bufferedInputStream2.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                } catch (Exception e13) {
                                    e = e13;
                                    bufferedInputStream3 = bufferedInputStream2;
                                    HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "performStreamRequest error reason: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                    IBDXBridgeContext iBDXBridgeContext52222 = iBDXBridgeContext3;
                                    LinkedHashMap linkedHashMap32222 = new LinkedHashMap();
                                    AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel52222 = xRequestParamModel3;
                                    linkedHashMap32222.put("streamLoadType", 1);
                                    streamSessionId = xRequestParamModel52222.getStreamSessionId();
                                    if (streamSessionId == null) {
                                        streamSessionId = str4;
                                    }
                                    linkedHashMap32222.put("streamSessionId", streamSessionId);
                                    linkedHashMap32222.put("dataType", "arraybuffer");
                                    linkedHashMap32222.put("stage", str3);
                                    linkedHashMap32222.put(str10, Integer.valueOf(connection.getResponseCode()));
                                    Integer clientCode22222 = connection.getClientCode();
                                    linkedHashMap32222.put(str5, Integer.valueOf(clientCode22222 == null ? clientCode22222.intValue() : 0));
                                    message = e.getMessage();
                                    if (message == null) {
                                        message = "unknown error";
                                    }
                                    linkedHashMap32222.put("msg", message);
                                    Unit unit32222 = Unit.INSTANCE;
                                    iBDXBridgeContext52222.sendEvent("x.requestChunkData", linkedHashMap32222);
                                    connection.cancel();
                                    if (bufferedInputStream3 == null) {
                                        bufferedInputStream3.close();
                                    }
                                }
                            } catch (Exception e14) {
                                e = e14;
                                str5 = str6;
                                str10 = str13;
                                bufferedInputStream3 = bufferedInputStream2;
                                HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "performStreamRequest error reason: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                IBDXBridgeContext iBDXBridgeContext522222 = iBDXBridgeContext3;
                                LinkedHashMap linkedHashMap322222 = new LinkedHashMap();
                                AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel522222 = xRequestParamModel3;
                                linkedHashMap322222.put("streamLoadType", 1);
                                streamSessionId = xRequestParamModel522222.getStreamSessionId();
                                if (streamSessionId == null) {
                                }
                                linkedHashMap322222.put("streamSessionId", streamSessionId);
                                linkedHashMap322222.put("dataType", "arraybuffer");
                                linkedHashMap322222.put("stage", str3);
                                linkedHashMap322222.put(str10, Integer.valueOf(connection.getResponseCode()));
                                Integer clientCode222222 = connection.getClientCode();
                                linkedHashMap322222.put(str5, Integer.valueOf(clientCode222222 == null ? clientCode222222.intValue() : 0));
                                message = e.getMessage();
                                if (message == null) {
                                }
                                linkedHashMap322222.put("msg", message);
                                Unit unit322222 = Unit.INSTANCE;
                                iBDXBridgeContext522222.sendEvent("x.requestChunkData", linkedHashMap322222);
                                connection.cancel();
                                if (bufferedInputStream3 == null) {
                                }
                            }
                        }
                    };
                    if (RuntimeHelper.INSTANCE.getNetworkDependInstanceV2(bridgeContext) != null) {
                        IHostNetworkDependV2 networkDependInstanceV2 = RuntimeHelper.INSTANCE.getNetworkDependInstanceV2(bridgeContext);
                        Intrinsics.checkNotNull(networkDependInstanceV2);
                        networkDependInstance = networkDependInstanceV2;
                    } else {
                        networkDependInstance = params.getAddCommonParams() ? RuntimeHelper.INSTANCE.getNetworkDependInstance(bridgeContext) : RuntimeHelper.INSTANCE.getPureNetworkDependInstance(bridgeContext);
                    }
                    UGLogger.Context context2 = new UGLogger.Context();
                    context2.pushStage("session_id", bridgeContext.getContainerID());
                    UGLogger.INSTANCE.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "x.request do request by net depend", "BridgeProcessing", MapsKt.mapOf(TuplesKt.to("method", requestMethodTypeByName.getMethod())), context2);
                    String method2 = requestMethodTypeByName.getMethod();
                    switch (method2.hashCode()) {
                        case -1335458389:
                            if (method2.equals("delete")) {
                                XBridgeAPIRequestUtils xBridgeAPIRequestUtils2 = XBridgeAPIRequestUtils.INSTANCE;
                                LinkedHashMap<String, String> linkedHashMap = filterHeaderEmptyValue;
                                IResponseCallback iResponseCallback2 = iResponseCallback;
                                boolean addCommonParams2 = params.getAddCommonParams();
                                Boolean isCustomizedCookie2 = params.isCustomizedCookie();
                                xBridgeAPIRequestUtils2.delete(str2, linkedHashMap, iResponseCallback2, networkDependInstance, addCommonParams2, isCustomizedCookie2 != null ? isCustomizedCookie2.booleanValue() : false, intValue);
                                return;
                            }
                            return;
                        case 102230:
                            if (method2.equals(ApiRequest.METHOD_GET)) {
                                if (Intrinsics.areEqual(params.getStreamLoadType(), 1)) {
                                    final AbsXRequestMethodIDL.XRequestParamModel xRequestParamModel4 = params;
                                    Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$handle$5.1
                                        @Override // java.util.concurrent.Callable
                                        public /* bridge */ /* synthetic */ Object call() {
                                            call();
                                            return Unit.INSTANCE;
                                        }

                                        @Override // java.util.concurrent.Callable
                                        public final void call() {
                                            XBridgeAPIRequestUtils xBridgeAPIRequestUtils3 = XBridgeAPIRequestUtils.INSTANCE;
                                            String str3 = str2;
                                            LinkedHashMap<String, String> linkedHashMap2 = filterHeaderEmptyValue;
                                            XRequestMethod$handle$5$streamGetResponseCallback$1 xRequestMethod$handle$5$streamGetResponseCallback$1 = r6;
                                            IHostNetworkDepend iHostNetworkDepend = networkDependInstance;
                                            boolean addCommonParams3 = xRequestParamModel4.getAddCommonParams();
                                            Boolean isCustomizedCookie3 = xRequestParamModel4.isCustomizedCookie();
                                            XBridgeAPIRequestUtils.doGetForStream$default(xBridgeAPIRequestUtils3, str3, linkedHashMap2, xRequestMethod$handle$5$streamGetResponseCallback$1, iHostNetworkDepend, addCommonParams3, isCustomizedCookie3 != null ? isCustomizedCookie3.booleanValue() : false, 0L, 64, null);
                                        }
                                    });
                                    CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class)), null, 2, null);
                                    return;
                                } else {
                                    XBridgeAPIRequestUtils xBridgeAPIRequestUtils3 = XBridgeAPIRequestUtils.INSTANCE;
                                    LinkedHashMap<String, String> linkedHashMap2 = filterHeaderEmptyValue;
                                    IResponseCallback iResponseCallback3 = iResponseCallback;
                                    boolean addCommonParams3 = params.getAddCommonParams();
                                    Boolean isCustomizedCookie3 = params.isCustomizedCookie();
                                    xBridgeAPIRequestUtils3.get(str2, linkedHashMap2, iResponseCallback3, networkDependInstance, addCommonParams3, isCustomizedCookie3 != null ? isCustomizedCookie3.booleanValue() : false, intValue);
                                    return;
                                }
                            }
                            return;
                        case 111375:
                            if (method2.equals("put")) {
                                Object obj = body2;
                                JSONObject jSONObject3 = (obj == null || !(obj instanceof Map)) ? new JSONObject() : new JSONObject((Map) body2);
                                String str3 = str == null ? UrlBuilder.CONTENT_TYPE : str;
                                XBridgeAPIRequestUtils xBridgeAPIRequestUtils4 = XBridgeAPIRequestUtils.INSTANCE;
                                LinkedHashMap<String, String> linkedHashMap3 = filterHeaderEmptyValue;
                                IResponseCallback iResponseCallback4 = iResponseCallback;
                                boolean addCommonParams4 = params.getAddCommonParams();
                                Boolean isCustomizedCookie4 = params.isCustomizedCookie();
                                xBridgeAPIRequestUtils4.put(str2, linkedHashMap3, str3, jSONObject3, iResponseCallback4, networkDependInstance, addCommonParams4, isCustomizedCookie4 != null ? isCustomizedCookie4.booleanValue() : false, intValue);
                                return;
                            }
                            return;
                        case 3446944:
                            if (method2.equals(ApiRequest.METHOD_POST)) {
                                String str4 = str == null ? UrlBuilder.CONTENT_TYPE : str;
                                LinkedHashMap<String, String> linkedHashMap4 = filterHeaderEmptyValue;
                                linkedHashMap4.put("Content-Type", str4);
                                Object obj2 = body2;
                                if (!(obj2 instanceof String)) {
                                    if (obj2 == null || !(obj2 instanceof List)) {
                                        JSONObject jSONObject4 = obj2 instanceof Map ? new JSONObject((Map) body2) : new JSONObject();
                                        XBridgeAPIRequestUtils xBridgeAPIRequestUtils5 = XBridgeAPIRequestUtils.INSTANCE;
                                        IResponseCallback iResponseCallback5 = iResponseCallback;
                                        boolean addCommonParams5 = params.getAddCommonParams();
                                        Boolean isCustomizedCookie5 = params.isCustomizedCookie();
                                        xBridgeAPIRequestUtils5.post(str2, linkedHashMap4, str4, jSONObject4, iResponseCallback5, networkDependInstance, addCommonParams5, isCustomizedCookie5 != null ? isCustomizedCookie5.booleanValue() : false, intValue);
                                        return;
                                    }
                                    XBridgeAPIRequestUtils xBridgeAPIRequestUtils6 = XBridgeAPIRequestUtils.INSTANCE;
                                    String jSONArray = new JSONArray((Collection) body2).toString();
                                    Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(body).toString()");
                                    byte[] bytes = jSONArray.getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                                    IResponseCallback iResponseCallback6 = iResponseCallback;
                                    boolean addCommonParams6 = params.getAddCommonParams();
                                    Boolean isCustomizedCookie6 = params.isCustomizedCookie();
                                    xBridgeAPIRequestUtils6.post(str2, linkedHashMap4, str4, bytes, iResponseCallback6, networkDependInstance, addCommonParams6, isCustomizedCookie6 != null ? isCustomizedCookie6.booleanValue() : false, intValue);
                                    return;
                                }
                                if (Intrinsics.areEqual(bodyType, "base64")) {
                                    XBridgeAPIRequestUtils xBridgeAPIRequestUtils7 = XBridgeAPIRequestUtils.INSTANCE;
                                    byte[] decode = Base64.decode((String) body2, 0);
                                    Intrinsics.checkNotNullExpressionValue(decode, "decode(body, Base64.DEFAULT)");
                                    IStreamResponseCallback iStreamResponseCallback2 = iStreamResponseCallback;
                                    boolean addCommonParams7 = params.getAddCommonParams();
                                    Boolean isCustomizedCookie7 = params.isCustomizedCookie();
                                    xBridgeAPIRequestUtils7.post(str2, linkedHashMap4, str4, decode, iStreamResponseCallback2, networkDependInstance, addCommonParams7, isCustomizedCookie7 != null ? isCustomizedCookie7.booleanValue() : false);
                                    return;
                                }
                                XBridgeAPIRequestUtils xBridgeAPIRequestUtils8 = XBridgeAPIRequestUtils.INSTANCE;
                                String str5 = (String) body2;
                                Charset charset = Charsets.UTF_8;
                                if (str5 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                byte[] bytes2 = str5.getBytes(charset);
                                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                                IResponseCallback iResponseCallback7 = iResponseCallback;
                                boolean addCommonParams8 = params.getAddCommonParams();
                                Boolean isCustomizedCookie8 = params.isCustomizedCookie();
                                xBridgeAPIRequestUtils8.post(str2, linkedHashMap4, str4, bytes2, iResponseCallback7, networkDependInstance, addCommonParams8, isCustomizedCookie8 != null ? isCustomizedCookie8.booleanValue() : false, intValue);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    /* compiled from: XRequestMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod$RequestMethodType;", "", "method", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethod", "()Ljava/lang/String;", OpenNetMethod.GET, OpenNetMethod.POST, OpenNetMethod.PUT, OpenNetMethod.DELETE, "UNSUPPORTED", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum RequestMethodType {
        GET(ApiRequest.METHOD_GET),
        POST(ApiRequest.METHOD_POST),
        PUT("put"),
        DELETE("delete"),
        UNSUPPORTED("unsupported");


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String method;

        RequestMethodType(String str) {
            this.method = str;
        }

        public final String getMethod() {
            return this.method;
        }

        /* compiled from: XRequestMethod.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod$RequestMethodType$Companion;", "", "()V", "getRequestMethodTypeByName", "Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod$RequestMethodType;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final RequestMethodType getRequestMethodTypeByName(String name) {
                if (name != null) {
                    try {
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                        String upperCase = name.toUpperCase(locale);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                        return RequestMethodType.valueOf(upperCase);
                    } catch (Exception unused) {
                        return RequestMethodType.UNSUPPORTED;
                    }
                }
                return RequestMethodType.UNSUPPORTED;
            }
        }
    }

    private final ExecutorService getExecutorService(IBDXBridgeContext bridgeContext) {
        ExecutorService normalThreadExecutor;
        IHostThreadPoolExecutorDepend threadPoolDepend = RuntimeHelper.INSTANCE.getThreadPoolDepend(bridgeContext);
        if (threadPoolDepend != null && (normalThreadExecutor = threadPoolDepend.getNormalThreadExecutor()) != null) {
            return normalThreadExecutor;
        }
        ExecutorService normalExecutor = TTExecutors.getNormalExecutor();
        Intrinsics.checkNotNullExpressionValue(normalExecutor, "getNormalExecutor()");
        return normalExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportPrefetchResult(ContextProviderFactory providerFactory, String apiUrl, boolean success, int prefetchStatus, String errorMsg, long duration, String configFrom) {
        String str;
        IBulletContainer iBulletContainer;
        BulletContext bulletContext;
        IBulletContainer iBulletContainer2;
        BulletContext bulletContext2;
        PrefetchReporter prefetchReporter = PrefetchReporter.INSTANCE;
        if (providerFactory == null || (iBulletContainer2 = (IBulletContainer) providerFactory.provideInstance(IBulletContainer.class)) == null || (bulletContext2 = iBulletContainer2.getBulletContext()) == null || (str = bulletContext2.getBid()) == null) {
            str = BidConstants.DEFAULT;
        }
        prefetchReporter.reportPrefetchResult(new PrefetchReportInfo(str, (Identifier) ((providerFactory == null || (iBulletContainer = (IBulletContainer) providerFactory.provideInstance(IBulletContainer.class)) == null || (bulletContext = iBulletContainer.getBulletContext()) == null) ? null : bulletContext.getUriIdentifier()), apiUrl, success, prefetchStatus, XBridgeLynxModule.NAME, errorMsg, duration, configFrom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printNetworkConsumeLog(String url, IBDXBridgeContext bridgeContext, long realRequestStart) {
        if (XBridge.INSTANCE.getConfig().getDebuggable()) {
            XBridge.log(getName(), "x.request about " + url + " consume ：" + (System.currentTimeMillis() - realRequestStart), "BridgeProcessing", bridgeContext.getContainerID());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportJSBFetchError(final IBDXBridgeContext bridgeContext, final String method, final String url, final int statusCode, final int requestErrorCode, final String requestErrorMsg, final int errorCode, final String errorMessage, final String logId) {
        getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.network.XRequestMethod$reportJSBFetchError$1

            /* compiled from: XRequestMethod.kt */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PlatformType.values().length];
                    try {
                        iArr[PlatformType.LYNX.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PlatformType.WEB.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PlatformType.WORKER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                WebView webView;
                int i = WhenMappings.$EnumSwitchMapping$0[IBDXBridgeContext.this.getPlatformType().ordinal()];
                if (i == 1) {
                    LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                    View engineView = IBDXBridgeContext.this.getEngineView();
                    webView = engineView instanceof LynxView ? (LynxView) engineView : null;
                    LynxJsbFetchErrorData lynxJsbFetchErrorData = new LynxJsbFetchErrorData();
                    String str = method;
                    String str2 = url;
                    int i2 = statusCode;
                    int i3 = requestErrorCode;
                    String str3 = requestErrorMsg;
                    int i4 = errorCode;
                    String str4 = errorMessage;
                    String str5 = logId;
                    lynxJsbFetchErrorData.setMethod(str);
                    lynxJsbFetchErrorData.setUrl(str2);
                    lynxJsbFetchErrorData.setStatusCode(i2);
                    lynxJsbFetchErrorData.setRequestErrorCode(i3);
                    lynxJsbFetchErrorData.setRequestErrorMsg(str3);
                    lynxJsbFetchErrorData.setErrorCode(i4);
                    lynxJsbFetchErrorData.setErrorMessage(str4);
                    lynxJsbFetchErrorData.setLogId(str5);
                    Unit unit = Unit.INSTANCE;
                    instance.reportJsbFetchError(webView, lynxJsbFetchErrorData);
                    return;
                }
                if (i != 2) {
                    return;
                }
                View engineView2 = IBDXBridgeContext.this.getEngineView();
                webView = engineView2 instanceof WebView ? (WebView) engineView2 : null;
                if (webView != null) {
                    String str6 = method;
                    String str7 = url;
                    int i5 = statusCode;
                    int i6 = requestErrorCode;
                    String str8 = requestErrorMsg;
                    int i7 = errorCode;
                    String str9 = errorMessage;
                    String str10 = logId;
                    IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
                    FetchError fetchError = new FetchError();
                    fetchError.method = str6;
                    fetchError.url = str7;
                    fetchError.statusCode = i5;
                    fetchError.requestErrorCode = i6;
                    fetchError.requestErrorMsg = str8;
                    fetchError.errorCode = i7;
                    fetchError.errorMessage = str9;
                    fetchError.logId = str10;
                    Unit unit2 = Unit.INSTANCE;
                    webViewMonitorHelper.handleFetchError(webView, fetchError);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAnnieXAccessToken(LinkedHashMap<String, String> linkedHashMap, IBDXBridgeContext iBDXBridgeContext, String str) {
        IAnnieXAccountService service;
        String accessTokenForAuthPlatform;
        Integer intOrNull;
        ISchemaData schemaData;
        Map queryItems;
        IBulletContainer iBulletContainer;
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) iBDXBridgeContext.getService(ContextProviderFactory.class);
        String str2 = null;
        BulletContext bulletContext = (contextProviderFactory == null || (iBulletContainer = (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class)) == null) ? null : iBulletContainer.getBulletContext();
        if (bulletContext != null && (schemaData = bulletContext.getSchemaData()) != null && (queryItems = schemaData.getQueryItems()) != null) {
            str2 = (String) queryItems.get("enable_access_token");
        }
        boolean z = false;
        if (str2 != null && (intOrNull = StringsKt.toIntOrNull(str2)) != null && intOrNull.intValue() == 1) {
            z = true;
        }
        if (!z || !isAccessTokenAllowed(str) || (service = AnnieXServiceCenter.INSTANCE.getService(BidConstants.DEFAULT, IAnnieXAccountService.class)) == null || (accessTokenForAuthPlatform = service.accessTokenForAuthPlatform()) == null) {
            return;
        }
        linkedHashMap.put("Authorization", accessTokenForAuthPlatform);
    }

    private final boolean isAccessTokenAllowed(String str) {
        return ArgusGlobalDelegate.Companion.getInstance().verifyInjectLoginState(new InjectLoginStateParams(str, InjectLoginStateParams.SceneType.X_REQUEST)).isPass();
    }
}
