package com.bytedance.pia.core.utils;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0002*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0005*\u00020\u0004¨\u0006\n"}, d2 = {"toResourceRequest", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "Landroid/webkit/WebResourceRequest;", "toResourceResponse", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "Landroid/webkit/WebResourceResponse;", "from", "Lcom/bytedance/pia/core/api/resource/LoadFrom;", "toWebResourceRequest", "toWebResourceResponse", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ResourceConverterKt {
    public static final WebResourceRequest toWebResourceRequest(final IResourceRequest iResourceRequest) {
        Intrinsics.checkNotNullParameter(iResourceRequest, "<this>");
        return new WebResourceRequest() { // from class: com.bytedance.pia.core.utils.ResourceConverterKt$toWebResourceRequest$1
            @Override // android.webkit.WebResourceRequest
            public String getMethod() {
                return "GET";
            }

            @Override // android.webkit.WebResourceRequest
            public boolean hasGesture() {
                return false;
            }

            @Override // android.webkit.WebResourceRequest
            public boolean isForMainFrame() {
                return false;
            }

            @Override // android.webkit.WebResourceRequest
            public boolean isRedirect() {
                return false;
            }

            @Override // android.webkit.WebResourceRequest
            public Uri getUrl() {
                Uri url = IResourceRequest.this.getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "this@toWebResourceRequest.url");
                return url;
            }

            @Override // android.webkit.WebResourceRequest
            public Map<String, String> getRequestHeaders() {
                Map<String, String> requestHeaders = IResourceRequest.this.getRequestHeaders();
                return requestHeaders != null ? requestHeaders : new LinkedHashMap();
            }
        };
    }

    public static final IResourceRequest toResourceRequest(final WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "<this>");
        return new IResourceRequest() { // from class: com.bytedance.pia.core.utils.ResourceConverterKt$toResourceRequest$1
            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public Uri getUrl() {
                return webResourceRequest.getUrl();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public boolean isForMainFrame() {
                return webResourceRequest.isForMainFrame();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public Map<String, String> getRequestHeaders() {
                return webResourceRequest.getRequestHeaders();
            }
        };
    }

    public static final WebResourceResponse toWebResourceResponse(IResourceResponse iResourceResponse) {
        Intrinsics.checkNotNullParameter(iResourceResponse, "<this>");
        return new WebResourceResponse(iResourceResponse.getMimeType(), iResourceResponse.getEncoding(), iResourceResponse.getStatusCode(), iResourceResponse.getReasonPhrase(), iResourceResponse.getHeaders(), iResourceResponse.getData());
    }

    public static /* synthetic */ IResourceResponse toResourceResponse$default(WebResourceResponse webResourceResponse, LoadFrom loadFrom, int i, Object obj) {
        if ((i & 1) != 0) {
            loadFrom = LoadFrom.Auto;
        }
        return toResourceResponse(webResourceResponse, loadFrom);
    }

    public static final IResourceResponse toResourceResponse(final WebResourceResponse webResourceResponse, final LoadFrom from) {
        Intrinsics.checkNotNullParameter(webResourceResponse, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        return new IResourceResponse() { // from class: com.bytedance.pia.core.utils.ResourceConverterKt$toResourceResponse$1
            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public String getMimeType() {
                return webResourceResponse.getMimeType();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public String getEncoding() {
                return webResourceResponse.getEncoding();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public int getStatusCode() {
                return webResourceResponse.getStatusCode();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public String getReasonPhrase() {
                String reasonPhrase = webResourceResponse.getReasonPhrase();
                return reasonPhrase == null ? "" : reasonPhrase;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public Map<String, String> getHeaders() {
                return webResourceResponse.getResponseHeaders();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getLoadFrom, reason: from getter */
            public LoadFrom get$from() {
                return from;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public InputStream getData() {
                return webResourceResponse.getData();
            }
        };
    }
}
