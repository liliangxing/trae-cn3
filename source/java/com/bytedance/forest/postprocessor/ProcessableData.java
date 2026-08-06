package com.bytedance.forest.postprocessor;

import android.net.Uri;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import java.io.InputStream;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: entity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00106\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b7J\u0013\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0011HÖ\u0001R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0011\u00104\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)¨\u0006>"}, d2 = {"Lcom/bytedance/forest/postprocessor/ProcessableData;", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "(Lcom/bytedance/forest/model/Response;)V", "dataStream", "Ljava/io/InputStream;", "getDataStream", "()Ljava/io/InputStream;", "dataStream$delegate", "Lkotlin/Lazy;", "geckoModel", "Lcom/bytedance/forest/model/GeckoModel;", "getGeckoModel", "()Lcom/bytedance/forest/model/GeckoModel;", "httpHeader", "", "", "getHttpHeader", "()Ljava/util/Map;", "httpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "getHttpResponse", "()Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "isDataStreamBuilt", "", "isDataStreamBuilt$forest_release", "()Z", "setDataStreamBuilt$forest_release", "(Z)V", "isPreload", "originFrom", "Lcom/bytedance/forest/model/ResourceFrom;", "getOriginFrom", "()Lcom/bytedance/forest/model/ResourceFrom;", "originUri", "Landroid/net/Uri;", "getOriginUri", "()Landroid/net/Uri;", "originUrl", "getOriginUrl", "()Ljava/lang/String;", "resFrom", "getResFrom", "getResponse$forest_release", "()Lcom/bytedance/forest/model/Response;", "scene", "Lcom/bytedance/forest/model/Scene;", "getScene", "()Lcom/bytedance/forest/model/Scene;", "uri", "getUri", "url", "getUrl", "component1", "component1$forest_release", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ProcessableData {

    /* renamed from: dataStream$delegate, reason: from kotlin metadata */
    private final Lazy dataStream;
    private final GeckoModel geckoModel;
    private final Map<String, String> httpHeader;
    private final ForestNetAPI.HttpResponse httpResponse;
    private boolean isDataStreamBuilt;
    private final boolean isPreload;
    private final ResourceFrom originFrom;
    private final Uri originUri;
    private final String originUrl;
    private final ResourceFrom resFrom;
    private final Response response;
    private final Scene scene;
    private final Uri uri;
    private final String url;

    public static /* synthetic */ ProcessableData copy$default(ProcessableData processableData, Response response, int i, Object obj) {
        if ((i & 1) != 0) {
            response = processableData.response;
        }
        return processableData.copy(response);
    }

    /* renamed from: component1$forest_release, reason: from getter */
    public final Response getResponse() {
        return this.response;
    }

    public final ProcessableData copy(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        return new ProcessableData(response);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ProcessableData) && Intrinsics.areEqual(this.response, ((ProcessableData) other).response);
        }
        return true;
    }

    public final InputStream getDataStream() {
        return (InputStream) this.dataStream.getValue();
    }

    public int hashCode() {
        Response response = this.response;
        if (response != null) {
            return response.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ProcessableData(response=" + this.response + ")";
    }

    public ProcessableData(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        this.response = response;
        this.scene = response.getRequest().getScene();
        this.url = response.getRequest().getUrl();
        this.uri = response.getRequest().getUri();
        this.originUrl = response.getRequest().getOriginUrl();
        this.originUri = response.getRequest().getOriginUri();
        this.geckoModel = response.getRequest().getGeckoModel();
        this.isPreload = response.getRequest().getIsPreload();
        this.httpResponse = response.getHttpResponse();
        this.httpHeader = response.getHttpHeader();
        this.resFrom = response.getFrom();
        this.originFrom = response.getOriginFrom();
        this.dataStream = LazyKt.lazy(new Function0<InputStream>() { // from class: com.bytedance.forest.postprocessor.ProcessableData$dataStream$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final InputStream m527invoke() {
                ProcessableData.this.setDataStreamBuilt$forest_release(true);
                InputStream provideInputStream = ProcessableData.this.getResponse$forest_release().provideInputStream();
                if (provideInputStream != null) {
                    return provideInputStream;
                }
                throw new IllegalStateException("No InputStream in " + ProcessableData.this.getResponse$forest_release());
            }
        });
    }

    public final Response getResponse$forest_release() {
        return this.response;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final Uri getOriginUri() {
        return this.originUri;
    }

    public final GeckoModel getGeckoModel() {
        return this.geckoModel;
    }

    /* renamed from: isPreload, reason: from getter */
    public final boolean getIsPreload() {
        return this.isPreload;
    }

    public final ForestNetAPI.HttpResponse getHttpResponse() {
        return this.httpResponse;
    }

    public final Map<String, String> getHttpHeader() {
        return this.httpHeader;
    }

    public final ResourceFrom getResFrom() {
        return this.resFrom;
    }

    public final ResourceFrom getOriginFrom() {
        return this.originFrom;
    }

    /* renamed from: isDataStreamBuilt$forest_release, reason: from getter */
    public final boolean getIsDataStreamBuilt() {
        return this.isDataStreamBuilt;
    }

    public final void setDataStreamBuilt$forest_release(boolean z) {
        this.isDataStreamBuilt = z;
    }
}
