package com.bytedance.webx.extension.webview.ttnet;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.core.webview.client.WebViewContainerClient;
import com.bytedance.webx.event.EventManager;
import com.bytedance.webx.extension.webview.ttnet.TtnetExtension;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.MediaType;

/* compiled from: TtnetExtension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/webx/extension/webview/ttnet/TtnetExtension;", "Lcom/bytedance/webx/AbsExtension;", "Lcom/bytedance/webx/core/webview/WebViewContainer;", "Lcom/bytedance/webx/IExtension$IContainerExtension;", "()V", "mWebViewContainerClientExtension", "Lcom/bytedance/webx/extension/webview/ttnet/TtnetExtension$WebViewContainerClientExtension;", "onCreateExtendable", "", "createHelper", "Lcom/bytedance/webx/AbsExtension$CreateHelper;", "Companion", "WebViewContainerClientExtension", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TtnetExtension extends AbsExtension<WebViewContainer> implements IExtension.IContainerExtension {
    public static final String TAG = "TtnetInterceptExtension";
    private final WebViewContainerClientExtension mWebViewContainerClientExtension = new WebViewContainerClientExtension();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.webx.AbsExtension
    public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
        initMatchable("ttnet");
        Intrinsics.checkNotNull(createHelper);
        createHelper.bindExtension(getExtendable().getExtendableWebViewClient(), this.mWebViewContainerClientExtension);
    }

    /* compiled from: TtnetExtension.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/webx/extension/webview/ttnet/TtnetExtension$WebViewContainerClientExtension;", "Lcom/bytedance/webx/AbsExtension;", "Lcom/bytedance/webx/core/webview/client/WebViewContainerClient;", "(Lcom/bytedance/webx/extension/webview/ttnet/TtnetExtension;)V", "mWebViewContainerClientListenerStub", "com/bytedance/webx/extension/webview/ttnet/TtnetExtension$WebViewContainerClientExtension$mWebViewContainerClientListenerStub$1", "Lcom/bytedance/webx/extension/webview/ttnet/TtnetExtension$WebViewContainerClientExtension$mWebViewContainerClientListenerStub$1;", "isApprove", "", "onCreateExtendable", "", "createHelper", "Lcom/bytedance/webx/AbsExtension$CreateHelper;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public final class WebViewContainerClientExtension extends AbsExtension<WebViewContainerClient> {
        private C0057x2d760dd5 mWebViewContainerClientListenerStub = new WebViewContainerClient.ListenerStub() { // from class: com.bytedance.webx.extension.webview.ttnet.TtnetExtension$WebViewContainerClientExtension$mWebViewContainerClientListenerStub$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.webx.event.AbsListenerStub
            public AbsExtension<?> getExtension() {
                return TtnetExtension.WebViewContainerClientExtension.this;
            }

            @Override // com.bytedance.webx.core.webview.client.WebViewContainerClient.ListenerStub, com.bytedance.webx.core.webview.client.IWebViewContainerClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Uri url;
                String createBaseUrl;
                WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(view, request);
                if (shouldInterceptRequest != null) {
                    return shouldInterceptRequest;
                }
                if (request == null || !request.isForMainFrame() || (url = request.getUrl()) == null || (createBaseUrl = createBaseUrl(url)) == null) {
                    return null;
                }
                List<Header> parseRequestHeaders = parseRequestHeaders(request.getRequestHeaders());
                String uri = url.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "requestUri.toString()");
                return ttnetRequest(createBaseUrl, uri, parseRequestHeaders);
            }

            private final String createBaseUrl(Uri requestUri) {
                if (requestUri.getHost() == null || requestUri.getScheme() == null) {
                    return null;
                }
                return requestUri.getScheme() + "://" + requestUri.getHost() + "/";
            }

            public final WebResourceResponse ttnetRequest(String baseUrl, String fullUrl, List<Header> headers) {
                Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
                Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
                Call<TypedInput> streamRequest = ((TtnetRetrofitApi) RetrofitUtils.createSsService(baseUrl, TtnetRetrofitApi.class)).streamRequest(fullUrl, headers);
                if (WebXEnv.isEnableTrace()) {
                    WLog.m45i(TtnetExtension.TAG, "[ttnetRequest] start url = " + fullUrl);
                } else {
                    WLog.m45i(TtnetExtension.TAG, "[ttnetRequest] start");
                }
                try {
                    SsResponse<TypedInput> execute = streamRequest.execute();
                    if (execute == null) {
                        return null;
                    }
                    TypedInput typedInput = (TypedInput) execute.body();
                    InputStream in = typedInput != null ? typedInput.in() : null;
                    if (in == null) {
                        streamRequest.cancel();
                    }
                    WLog.m45i(TtnetExtension.TAG, "[ttnetRequest] after execute");
                    return convertToWebResourceResponse(execute, in);
                } catch (Exception e) {
                    WLog.m47w(TtnetExtension.TAG, "ttnetRequest " + e);
                    streamRequest.cancel();
                    return null;
                }
            }

            private final WebResourceResponse convertToWebResourceResponse(SsResponse<TypedInput> ssResponse, InputStream inputStream) {
                String str;
                Charset charset;
                Map<String, String> parseResponseHeaders = parseResponseHeaders(ssResponse.headers());
                MediaType mediaType = getMediaType(parseResponseHeaders);
                String str2 = mediaType == null ? "text/html" : mediaType.type() + '/' + mediaType.subtype();
                if (mediaType == null || (charset = mediaType.charset()) == null || (str = charset.toString()) == null) {
                    str = "utf-8";
                }
                return new WebResourceResponse(str2, str, ssResponse.raw().getStatus(), TextUtils.isEmpty(ssResponse.raw().getReason()) ? "OK" : ssResponse.raw().getReason(), parseResponseHeaders, inputStream);
            }

            private final Map<String, String> parseResponseHeaders(List<Header> headers) {
                if (headers == null) {
                    return null;
                }
                List<Header> list = headers;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                for (Header header : list) {
                    Pair pair = new Pair(header.getName(), header.getValue());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                return linkedHashMap;
            }

            private final MediaType getMediaType(Map<String, String> headers) {
                String str;
                if (headers == null || (str = headers.get("Content-Type")) == null) {
                    str = headers != null ? headers.get("content-type") : null;
                    if (str == null) {
                        str = "text/html; charset=UTF-8";
                    }
                }
                return MediaType.parse(str);
            }

            private final List<Header> parseRequestHeaders(Map<String, String> headers) {
                if (headers == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(headers.size());
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            }
        };

        /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.webx.extension.webview.ttnet.TtnetExtension$WebViewContainerClientExtension$mWebViewContainerClientListenerStub$1] */
        public WebViewContainerClientExtension() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.webx.AbsExtension
        public void onCreateExtendable(AbsExtension.CreateHelper createHelper) {
            register(WebViewContainerClient.EVENT_shouldInterceptRequest, this.mWebViewContainerClientListenerStub, EventManager.REGION_LOGIC_HIGH_BREAK);
        }

        @Override // com.bytedance.webx.AbsExtension
        public boolean isApprove() {
            return TtnetExtension.this.isApprove();
        }
    }
}
