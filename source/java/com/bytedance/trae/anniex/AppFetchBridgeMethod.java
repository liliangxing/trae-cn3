package com.bytedance.trae.anniex;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.trae.anniex.AbsAppFetchMethodIDL;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.TrustedDomainUtils;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AppFetchBridgeMethod.kt */
@XBridgeMethod(name = "app.fetch")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/anniex/AppFetchBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL;", "<init>", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/trae/anniex/AbsAppFetchMethodIDL$AppFetchResultModel;", "buildUrl", "", IWeixinService.ResponseConstants.URL, "queryParams", "", "buildPostBody", "", "data", "", "getExecutorService", "Ljava/util/concurrent/ExecutorService;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppFetchBridgeMethod extends AbsAppFetchMethodIDL {
    public static final int $stable = 0;
    private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String TAG = "AppFetchBridgeMethod";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, final AbsAppFetchMethodIDL.AppFetchParamModel params, final CompletionBlock<AbsAppFetchMethodIDL.AppFetchResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(params.getUrl())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "url is empty", null, 4, null);
            return;
        }
        if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(bridgeContext.getBridgeCall().getUrl())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "untrusted page domain", null, 4, null);
            return;
        }
        if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(params.getUrl())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "untrusted request domain", null, 4, null);
            return;
        }
        String method = params.getMethod();
        if (method == null) {
            method = OpenNetMethod.GET;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        final String upperCase = method.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String responseType = params.getResponseType();
        if (responseType == null) {
            responseType = "json";
        }
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
        final String lowerCase = responseType.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Object header = params.getHeader();
        final Map emptyMap = header instanceof Map ? (Map) header : MapsKt.emptyMap();
        Object params2 = params.getParams();
        final Map emptyMap2 = params2 instanceof Map ? (Map) params2 : MapsKt.emptyMap();
        getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.trae.anniex.AppFetchBridgeMethod$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AppFetchBridgeMethod.handle$lambda$8(AppFetchBridgeMethod.this, params, emptyMap2, emptyMap, upperCase, callback, lowerCase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$8(AppFetchBridgeMethod appFetchBridgeMethod, AbsAppFetchMethodIDL.AppFetchParamModel appFetchParamModel, Map map, Map map2, String str, CompletionBlock completionBlock, String str2) {
        boolean z;
        boolean z2;
        boolean z3;
        SsResponse execute;
        String str3;
        JSONObject put;
        try {
            String url = appFetchParamModel.getUrl();
            Intrinsics.checkNotNull(url);
            String buildUrl = appFetchBridgeMethod.buildUrl(url, map);
            Uri parse = Uri.parse(buildUrl);
            String str4 = parse.getScheme() + "://" + parse.getHost() + '/';
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = map2.entrySet().iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((CharSequence) entry.getValue()).length() <= 0) {
                    z = false;
                }
                if (z) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                arrayList.add(new Header((String) entry2.getKey(), (String) entry2.getValue()));
            }
            List<Header> mutableList = CollectionsKt.toMutableList(arrayList);
            List<Header> list = mutableList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.equals(((Header) it2.next()).getName(), "X-Tt-Token", true)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            String str5 = "";
            if (!z2) {
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                if (xTToken == null) {
                    xTToken = "";
                }
                if (xTToken.length() > 0) {
                    mutableList.add(new Header("X-Tt-Token", xTToken));
                }
            }
            List<Header> list2 = mutableList;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    if (StringsKt.equals(((Header) it3.next()).getName(), "x-ide-token", true)) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (!z3) {
                ILoginService iLoginService2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                String xTToken2 = iLoginService2 != null ? iLoginService2.getXTToken() : null;
                if (xTToken2 != null) {
                    str5 = xTToken2;
                }
                if (str5.length() <= 0) {
                    z = false;
                }
                if (z) {
                    mutableList.add(new Header("x-ide-token", str5));
                }
            }
            AppFetchTtnetApi appFetchTtnetApi = (AppFetchTtnetApi) RetrofitUtils.createSsService(str4, AppFetchTtnetApi.class);
            if (Intrinsics.areEqual(str, OpenNetMethod.GET)) {
                execute = appFetchTtnetApi.get(buildUrl, mutableList).execute();
            } else if (Intrinsics.areEqual(str, OpenNetMethod.POST)) {
                String str6 = (String) map2.get("Content-Type");
                if (str6 == null && (str6 = (String) map2.get("content-type")) == null) {
                    str6 = "application/x-www-form-urlencoded";
                }
                execute = appFetchTtnetApi.post(buildUrl, mutableList, new TypedByteArray(str6, appFetchBridgeMethod.buildPostBody(appFetchParamModel.getData()), new String[0])).execute();
            } else {
                CompletionBlock.DefaultImpls.onFailure$default(completionBlock, -3, "Unsupported method: " + str, null, 4, null);
                return;
            }
            if (execute == null) {
                CompletionBlock.DefaultImpls.onFailure$default(completionBlock, 0, "response is null", null, 4, null);
                return;
            }
            int status = execute.raw().getStatus();
            TypedInput typedInput = (TypedInput) execute.body();
            if (typedInput != null) {
                InputStream in = typedInput.in();
                try {
                    InputStream inputStream = in;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                    CloseableKt.closeFinally(in, (Throwable) null);
                    str3 = byteArrayOutputStream2;
                } finally {
                }
            } else {
                str3 = "{}";
            }
            Object obj = str3;
            if (!Intrinsics.areEqual(str2, "string")) {
                try {
                    put = new JSONObject(str3);
                } catch (Exception unused) {
                    put = new JSONObject().put(AccountMonitorConstants.CommonParameter.RAW, str3);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator<String> keys = put.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
                while (keys.hasNext()) {
                    String next = keys.next();
                    linkedHashMap2.put(next, put.get(next));
                }
                obj = XBridgeKTXKt.assignX(linkedHashMap2);
            }
            Intrinsics.checkNotNull(obj);
            XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAppFetchMethodIDL.AppFetchResultModel.class);
            AbsAppFetchMethodIDL.AppFetchResultModel appFetchResultModel = (AbsAppFetchMethodIDL.AppFetchResultModel) createXModel;
            appFetchResultModel.setStatus(Integer.valueOf(status));
            appFetchResultModel.setResponse(obj);
            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "request failed";
            }
            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAppFetchMethodIDL.AppFetchResultModel.class);
            ((AbsAppFetchMethodIDL.AppFetchResultModel) createXModel2).setStatus((Number) (-1));
            Unit unit = Unit.INSTANCE;
            completionBlock.onFailure(0, message, (XBaseResultModel) createXModel2);
        }
    }

    private final String buildUrl(String url, Map<String, String> queryParams) {
        if (queryParams.isEmpty()) {
            return url;
        }
        Uri.Builder buildUpon = Uri.parse(url).buildUpon();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private final byte[] buildPostBody(Object data) {
        if (data instanceof String) {
            byte[] bytes = ((String) data).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        if (!(data instanceof Map)) {
            byte[] bytes2 = "{}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return bytes2;
        }
        String jSONObject = new JSONObject((Map) data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        byte[] bytes3 = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        return bytes3;
    }

    private final ExecutorService getExecutorService(IBDXBridgeContext bridgeContext) {
        ExecutorService normalThreadExecutor;
        IHostThreadPoolExecutorDepend threadPoolDepend = RuntimeHelper.INSTANCE.getThreadPoolDepend(bridgeContext);
        if (threadPoolDepend != null && (normalThreadExecutor = threadPoolDepend.getNormalThreadExecutor()) != null) {
            return normalThreadExecutor;
        }
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(newCachedThreadPool, "newCachedThreadPool(...)");
        return newCachedThreadPool;
    }
}
