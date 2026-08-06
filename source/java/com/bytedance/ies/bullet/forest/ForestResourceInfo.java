package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.LoaderName;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestResourceInfo;", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "uri", "Landroid/net/Uri;", "response", "Lcom/bytedance/forest/model/Response;", "(Landroid/net/Uri;Lcom/bytedance/forest/model/Response;)V", "originFrom", "Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "getOriginFrom$anniex_release", "()Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "provideByteArray", "", "provideProcessedData", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestResourceInfo extends ResourceInfo {
    private final ResourceFrom originFrom;
    private final Response response;

    public /* synthetic */ ForestResourceInfo(Uri uri, Response response, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uri, response);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ForestResourceInfo(Uri uri, Response response) {
        super(r1, r2, r3, r4, r5, r6, true, r9, r10, r17, r0 != null ? r0.longValue() : -1L, null, 2048, null);
        ResourceType resourceType;
        ResourceFrom resourceFrom;
        RLChannelBundleModel rLChannelBundleModel;
        ArgusResourceType argusLynxResourceType;
        com.bytedance.forest.model.ResourceFrom resourceFrom2;
        ResourceFrom rLResourceFrom;
        ResourceType rLResourceType;
        Intrinsics.checkNotNullParameter(response, "response");
        Uri parse = uri == null ? Uri.parse(response.getRequest().getUrl()) : uri;
        Intrinsics.checkNotNullExpressionValue(parse, "uri ?: Uri.parse(response.request.url)");
        String filePath = response.getFilePath();
        com.bytedance.forest.model.ResourceFrom from = response.getFrom();
        if (from != null) {
            rLResourceType = ForestAdapterKt.toRLResourceType(from, response);
            resourceType = rLResourceType;
        } else {
            resourceType = null;
        }
        com.bytedance.forest.model.ResourceFrom from2 = response.getFrom();
        if (from2 != null) {
            rLResourceFrom = ForestAdapterKt.toRLResourceFrom(from2, response);
            resourceFrom = rLResourceFrom;
        } else {
            resourceFrom = null;
        }
        boolean isCache = response.isCache();
        long version = response.getVersion();
        InputStream provideInputStream = ((response instanceof ProcessedResponse) && ((ProcessedResponse) response).isProcessSucceed()) ? null : response.provideInputStream();
        rLChannelBundleModel = ForestAdapterKt.toRLChannelBundleModel(response.getRequest().getGeckoModel());
        String successFetcher = response.getSuccessFetcher();
        Long l = (Long) response.getPerformanceInfo().get("res_load_start");
        this.response = response;
        setGeckoFailMessage(response.getErrorInfo().getGeckoError());
        setFromMemory(response.getFrom() == com.bytedance.forest.model.ResourceFrom.MEMORY);
        setBuldinFailedMessage(response.getErrorInfo().getBuiltinError());
        setCdnFailedMessage(response.getErrorInfo().getCdnError());
        setUsePreloadCache(response.isPreloaded() || response.isRequestReused());
        setEnableMemory(response.getRequest().getEnableMemoryCache());
        setAccessKey(response.getRequest().getGeckoModel().getAccessKey());
        setChannel(response.getRequest().getGeckoModel().getChannel());
        setBundle(response.getRequest().getGeckoModel().getBundle());
        setLoaderName(LoaderName.Forest);
        argusLynxResourceType = ForestAdapterKt.toArgusLynxResourceType(response.getRequest().getScene());
        setArgusResourceType(argusLynxResourceType);
        if (response.getRequest().getScene() == Scene.WEB_MAIN_DOCUMENT || response.getRequest().getScene() == Scene.WEB_CHILD_RESOURCE) {
            setWebResourceResponse(response.provideWebResourceResponse());
        }
        if (response.getOriginFrom() == com.bytedance.forest.model.ResourceFrom.CDN || response.getFrom() == com.bytedance.forest.model.ResourceFrom.CDN) {
            String originUrl = response.getRequest().getOriginUrl();
            resourceFrom2 = null;
            originUrl = StringsKt.startsWith$default(originUrl, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(originUrl, "https://", false, 2, (Object) null) ? originUrl : null;
            if (originUrl != null) {
                setCdnSafeUrl(originUrl);
            }
        } else {
            resourceFrom2 = null;
        }
        com.bytedance.forest.model.ResourceFrom from3 = response.getFrom();
        from3 = from3 != com.bytedance.forest.model.ResourceFrom.MEMORY ? from3 : resourceFrom2;
        from3 = from3 == null ? response.getOriginFrom() : from3;
        this.originFrom = from3 != null ? ForestAdapterKt.toRLResourceFrom(from3) : resourceFrom2;
    }

    /* renamed from: getOriginFrom$anniex_release, reason: from getter */
    public final ResourceFrom getOriginFrom() {
        return this.originFrom;
    }

    @Override // com.bytedance.ies.bullet.service.base.ResourceInfo
    public byte[] provideByteArray() {
        ProcessedResponse processedResponse = this.response;
        if ((processedResponse instanceof ProcessedResponse) && processedResponse.isProcessSucceed()) {
            return null;
        }
        return this.response.provideBytes();
    }

    public final Object provideProcessedData() {
        ProcessedResponse processedResponse = this.response;
        ProcessedResponse processedResponse2 = processedResponse instanceof ProcessedResponse ? processedResponse : null;
        if (processedResponse2 == null) {
            return null;
        }
        if (!(processedResponse2.isProcessSucceed() && processedResponse2.provideProcessedData() != null)) {
            processedResponse2 = null;
        }
        if (processedResponse2 != null) {
            return processedResponse2.provideProcessedData();
        }
        return null;
    }
}
