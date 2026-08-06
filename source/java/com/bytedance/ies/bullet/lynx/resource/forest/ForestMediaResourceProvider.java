package com.bytedance.ies.bullet.lynx.resource.forest;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.preloadv2.redirect.RedirectManager;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestMediaResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestMediaResourceProvider;", "Lcom/lynx/tasm/resourceprovider/media/LynxMediaResourceFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "downloadEngine", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getDownloadEngine", "()Ljava/lang/String;", "getSessionId", "isLocalResource", "Lcom/lynx/tasm/resourceprovider/media/OptionalBool;", "url", "redirectWithPipeline", "shouldRedirectUrl", "request", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestMediaResourceProvider extends LynxMediaResourceFetcher implements ForestInfoHelper {
    private final String TAG;
    private final String downloadEngine;
    private final String sessionId;

    public ForestMediaResourceProvider(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "downloadEngine");
        this.downloadEngine = str;
        this.sessionId = str2;
        this.TAG = "ForestMediaResourceProvider";
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    public final String getDownloadEngine() {
        return this.downloadEngine;
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    public String shouldRedirectUrl(LynxResourceRequest request) {
        String redirectWithPipeline;
        Uri parse = Uri.parse(request != null ? request.getUrl() : null);
        String url = request != null ? request.getUrl() : null;
        boolean z = true;
        if (!(!TextUtils.isEmpty(url))) {
            url = null;
        }
        if (url != null && (redirectWithPipeline = redirectWithPipeline(url)) != null) {
            if (!(!equals(url))) {
                redirectWithPipeline = null;
            }
            if (redirectWithPipeline != null) {
                return redirectWithPipeline;
            }
        }
        String url2 = request != null ? request.getUrl() : null;
        if (url2 != null && url2.length() != 0) {
            z = false;
        }
        if (!z) {
            List listOf = CollectionsKt.listOf(new String[]{"http", "https", "file", "content", "res", "data"});
            String scheme = parse.getScheme();
            if (scheme == null) {
                scheme = "";
            }
            if (listOf.contains(scheme)) {
                String url3 = request != null ? request.getUrl() : null;
                return url3 == null ? "" : url3;
            }
            if (Intrinsics.areEqual(parse.getScheme(), SchemaConstants.QUERY_KEY_BUNDLE) || Intrinsics.areEqual(parse.getScheme(), ResourceUriHelperKt.AUTHORITY_RELATIVE)) {
                parse.getPath();
            } else if (request != null) {
                request.getUrl();
            }
        }
        return "";
    }

    public OptionalBool isLocalResource(String url) {
        String str = url;
        if ((str == null || str.length() == 0) || !StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return OptionalBool.FALSE;
        }
        if (GeckoXAdapter.Companion.isCDNMultiVersionResource(url) || GeckoXAdapter.Companion.canParsed(url)) {
            return OptionalBool.TRUE;
        }
        return OptionalBool.FALSE;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String redirectWithPipeline(String url) {
        String str;
        String str2;
        Response loadSync;
        long currentTimeMillis = System.currentTimeMillis();
        PreloadLogger.INSTANCE.m43i("redirectWithPipeline URL:" + url + ",defaultCache:" + RedirectManager.INSTANCE.getDefaultCache());
        String str3 = url;
        boolean z = true;
        if ((str3 == null || str3.length() == 0) || StringsKt.startsWith$default(url, "file://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "data:", false, 2, (Object) null)) {
            return url;
        }
        String redirectPath = RedirectManager.INSTANCE.getRedirectPath(url);
        if (redirectPath != null) {
            RedirectManager.INSTANCE.reportRedirect("default_bid", url, redirectPath, true, System.currentTimeMillis() - currentTimeMillis);
            return redirectPath;
        }
        if (!StringsKt.startsWith$default(url, "base64:", false, 2, (Object) null)) {
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            Scene scene = Scene.LYNX_IMAGE;
            String str4 = this.sessionId;
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setBid("default_bid");
            Unit unit = Unit.INSTANCE;
            loadSync = forestLoader.loadSync((r17 & 1) != 0 ? forestLoader.getDefault() : null, url, (r17 & 4) != 0 ? null : null, scene, str4, (r17 & 32) != 0 ? null : taskConfig, (r17 & 64) != 0 ? null : new Function1<RequestParams, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestMediaResourceProvider$redirectWithPipeline$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RequestParams) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(RequestParams requestParams) {
                    Intrinsics.checkNotNullParameter(requestParams, "requestParams");
                    requestParams.setDisableCdn(true);
                    requestParams.setCheckGeckoFileAvailable(false);
                }
            });
            if (loadSync != null) {
                String filePath = loadSync.getFilePath();
                if (filePath != null) {
                    if (!(!StringsKt.isBlank(filePath))) {
                        filePath = null;
                    }
                    if (filePath != null) {
                        str = "file://" + filePath;
                        str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            z = false;
                        }
                        if ((!z || Intrinsics.areEqual(str, url)) && GeckoXAdapter.Companion.isCDNMultiVersionResource(url)) {
                            str = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
                        }
                        if (RedirectManager.INSTANCE.getDefaultCache()) {
                            PreloadLogger.INSTANCE.m43i("redirectWithPipeline putRedirectPath URL:" + url + ",redirectUrl:" + str);
                            RedirectManager.INSTANCE.putRedirectPath(url, str);
                        }
                        RedirectManager.INSTANCE.reportRedirect("default_bid", url, str, false, System.currentTimeMillis() - currentTimeMillis);
                        return str;
                    }
                }
                str = null;
                str2 = str;
                if (str2 != null) {
                    z = false;
                }
                if (!z) {
                }
                str = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
                if (RedirectManager.INSTANCE.getDefaultCache()) {
                }
                RedirectManager.INSTANCE.reportRedirect("default_bid", url, str, false, System.currentTimeMillis() - currentTimeMillis);
                return str;
            }
        }
        str = url;
        str2 = str;
        if (str2 != null) {
        }
        if (!z) {
        }
        str = GeckoXAdapter.Companion.addCommonParamsForCDNMultiVersionURL(url);
        if (RedirectManager.INSTANCE.getDefaultCache()) {
        }
        RedirectManager.INSTANCE.reportRedirect("default_bid", url, str, false, System.currentTimeMillis() - currentTimeMillis);
        return str;
    }
}
