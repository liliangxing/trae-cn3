package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.argus.api.ArgusSecureManager;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForestWebInfoHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0017JJ\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0017¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestWebInfoHelper;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "canInterceptByForest", "Lkotlin/Pair;", "", "Lcom/bytedance/forest/model/Scene;", "request", "Landroid/webkit/WebResourceRequest;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "url", "", "isMainResource", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ForestWebInfoHelper extends ForestInfoHelper {
    Pair<Boolean, Scene> canInterceptByForest(WebResourceRequest request, IServiceToken token, BulletContext context, SchemaModelUnion schemaModelUnion);

    Pair<Boolean, Scene> canInterceptByForest(String url, boolean isMainResource, IServiceToken token, BulletContext context, SchemaModelUnion schemaModelUnion);

    /* compiled from: ForestWebInfoHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static boolean delayPreload(ForestWebInfoHelper forestWebInfoHelper, Uri uri) {
            return ForestInfoHelper.DefaultImpls.delayPreload(forestWebInfoHelper, uri);
        }

        public static boolean delayPreload(ForestWebInfoHelper forestWebInfoHelper, BulletContext bulletContext) {
            return ForestInfoHelper.DefaultImpls.delayPreload(forestWebInfoHelper, bulletContext);
        }

        public static boolean delayPreload(ForestWebInfoHelper forestWebInfoHelper, SchemaModelUnion schemaModelUnion) {
            return ForestInfoHelper.DefaultImpls.delayPreload(forestWebInfoHelper, schemaModelUnion);
        }

        public static String forestDownloadEngine(ForestWebInfoHelper forestWebInfoHelper, Uri uri) {
            return ForestInfoHelper.DefaultImpls.forestDownloadEngine(forestWebInfoHelper, uri);
        }

        public static String forestDownloadEngine(ForestWebInfoHelper forestWebInfoHelper, BulletContext bulletContext) {
            return ForestInfoHelper.DefaultImpls.forestDownloadEngine(forestWebInfoHelper, bulletContext);
        }

        public static String forestDownloadEngine(ForestWebInfoHelper forestWebInfoHelper, IServiceToken iServiceToken) {
            return ForestInfoHelper.DefaultImpls.forestDownloadEngine(forestWebInfoHelper, iServiceToken);
        }

        public static String forestDownloadEngine(ForestWebInfoHelper forestWebInfoHelper, SchemaModelUnion schemaModelUnion) {
            return ForestInfoHelper.DefaultImpls.forestDownloadEngine(forestWebInfoHelper, schemaModelUnion);
        }

        public static String getResTag(ForestWebInfoHelper forestWebInfoHelper, LynxResourceRequest.LynxResourceType lynxResourceType) {
            return ForestInfoHelper.DefaultImpls.getResTag(forestWebInfoHelper, lynxResourceType);
        }

        public static Scene getSceneType(ForestWebInfoHelper forestWebInfoHelper, LynxResourceRequest.LynxResourceType lynxResourceType) {
            return ForestInfoHelper.DefaultImpls.getSceneType(forestWebInfoHelper, lynxResourceType);
        }

        public static ProcessedResponse<TemplateBundle> getTemplateBundleResponse(ForestWebInfoHelper forestWebInfoHelper, Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return ForestInfoHelper.DefaultImpls.getTemplateBundleResponse(forestWebInfoHelper, response);
        }

        public static boolean hasGeckoModelInfo(ForestWebInfoHelper forestWebInfoHelper, BulletContext bulletContext) {
            return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(forestWebInfoHelper, bulletContext);
        }

        public static boolean hasGeckoModelInfo(ForestWebInfoHelper forestWebInfoHelper, IServiceToken iServiceToken) {
            return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(forestWebInfoHelper, iServiceToken);
        }

        public static boolean hasGeckoModelInfo(ForestWebInfoHelper forestWebInfoHelper, SchemaModelUnion schemaModelUnion) {
            return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(forestWebInfoHelper, schemaModelUnion);
        }

        public static String preloadScope(ForestWebInfoHelper forestWebInfoHelper, Uri uri) {
            return ForestInfoHelper.DefaultImpls.preloadScope(forestWebInfoHelper, uri);
        }

        public static String preloadScope(ForestWebInfoHelper forestWebInfoHelper, BulletContext bulletContext) {
            return ForestInfoHelper.DefaultImpls.preloadScope(forestWebInfoHelper, bulletContext);
        }

        public static String preloadScope(ForestWebInfoHelper forestWebInfoHelper, SchemaModelUnion schemaModelUnion) {
            return ForestInfoHelper.DefaultImpls.preloadScope(forestWebInfoHelper, schemaModelUnion);
        }

        public static String sessionID(ForestWebInfoHelper forestWebInfoHelper, BulletContext bulletContext) {
            return ForestInfoHelper.DefaultImpls.sessionID(forestWebInfoHelper, bulletContext);
        }

        public static String sessionID(ForestWebInfoHelper forestWebInfoHelper, IServiceToken iServiceToken) {
            return ForestInfoHelper.DefaultImpls.sessionID(forestWebInfoHelper, iServiceToken);
        }

        public static boolean useForest(ForestWebInfoHelper forestWebInfoHelper, Uri uri) {
            return ForestInfoHelper.DefaultImpls.useForest(forestWebInfoHelper, uri);
        }

        public static boolean useForest(ForestWebInfoHelper forestWebInfoHelper, BulletContext bulletContext) {
            return ForestInfoHelper.DefaultImpls.useForest(forestWebInfoHelper, bulletContext);
        }

        public static boolean useForest(ForestWebInfoHelper forestWebInfoHelper, IServiceToken iServiceToken) {
            return ForestInfoHelper.DefaultImpls.useForest(forestWebInfoHelper, iServiceToken);
        }

        public static boolean useForest(ForestWebInfoHelper forestWebInfoHelper, SchemaModelUnion schemaModelUnion) {
            return ForestInfoHelper.DefaultImpls.useForest(forestWebInfoHelper, schemaModelUnion);
        }

        public static /* synthetic */ Pair canInterceptByForest$default(ForestWebInfoHelper forestWebInfoHelper, WebResourceRequest webResourceRequest, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canInterceptByForest");
            }
            if ((i & 2) != 0) {
                iServiceToken = null;
            }
            if ((i & 4) != 0) {
                bulletContext = null;
            }
            if ((i & 8) != 0) {
                schemaModelUnion = null;
            }
            return forestWebInfoHelper.canInterceptByForest(webResourceRequest, iServiceToken, bulletContext, schemaModelUnion);
        }

        public static Pair<Boolean, Scene> canInterceptByForest(ForestWebInfoHelper forestWebInfoHelper, WebResourceRequest webResourceRequest, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
            Pair<Boolean, Scene> canInterceptByForest;
            if (webResourceRequest != null) {
                String method = webResourceRequest.getMethod();
                Intrinsics.checkNotNullExpressionValue(method, "it.method");
                Locale locale = Locale.ENGLISH;
                Intrinsics.checkNotNullExpressionValue(locale, "ENGLISH");
                if (method == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = method.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, PrefetchRequestConfig.METHOD_GET)) {
                    String uri = webResourceRequest.getUrl().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "it.url.toString()");
                    canInterceptByForest = forestWebInfoHelper.canInterceptByForest(uri, webResourceRequest.isForMainFrame(), iServiceToken, bulletContext, schemaModelUnion);
                } else {
                    canInterceptByForest = TuplesKt.to(false, webResourceRequest.isForMainFrame() ? Scene.WEB_MAIN_DOCUMENT : Scene.WEB_CHILD_RESOURCE);
                }
                if (canInterceptByForest != null) {
                    return canInterceptByForest;
                }
            }
            return TuplesKt.to(false, Scene.WEB_CHILD_RESOURCE);
        }

        public static /* synthetic */ Pair canInterceptByForest$default(ForestWebInfoHelper forestWebInfoHelper, String str, boolean z, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canInterceptByForest");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return forestWebInfoHelper.canInterceptByForest(str, z, (i & 4) != 0 ? null : iServiceToken, (i & 8) != 0 ? null : bulletContext, (i & 16) != 0 ? null : schemaModelUnion);
        }

        public static Pair<Boolean, Scene> canInterceptByForest(ForestWebInfoHelper forestWebInfoHelper, String str, boolean z, IServiceToken iServiceToken, BulletContext bulletContext, SchemaModelUnion schemaModelUnion) {
            Scene scene;
            Set set;
            Object obj;
            Intrinsics.checkNotNullParameter(str, "url");
            boolean z2 = false;
            if (StringsKt.isBlank(str) || !StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
                return TuplesKt.to(false, Scene.WEB_CHILD_RESOURCE);
            }
            Uri parse = Uri.parse(str);
            if (ArgusSecureManager.INSTANCE.isSecLinkUrl(str)) {
                return TuplesKt.to(false, Scene.WEB_CHILD_RESOURCE);
            }
            if (z) {
                return TuplesKt.to(true, Scene.WEB_MAIN_DOCUMENT);
            }
            String path = parse.getPath();
            if (path != null) {
                if (StringsKt.endsWith$default(path, ".html", false, 2, (Object) null) || StringsKt.endsWith$default(path, ".hml", false, 2, (Object) null)) {
                    scene = Scene.WEB_MAIN_DOCUMENT;
                } else {
                    scene = Scene.WEB_CHILD_RESOURCE;
                }
                if (scene != null) {
                    if (scene != Scene.WEB_MAIN_DOCUMENT) {
                        set = ForestWebInfoHelperKt.AVAILABLE_SUFFIX_DEFAULT;
                        Iterator it = set.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (StringsKt.endsWith$default(path, (String) obj, false, 2, (Object) null)) {
                                break;
                            }
                        }
                        if (obj != null) {
                            return TuplesKt.to(true, Scene.WEB_CHILD_RESOURCE);
                        }
                        if (!GeckoXAdapter.Companion.isCDNMultiVersionResource(str) && !GeckoXAdapter.Companion.canParsed(str)) {
                            Forest forest = ForestLoader.INSTANCE.getDefault();
                            if (!(forest != null && Forest.isPreloaded$default(forest, str, (RequestParams) null, 2, (Object) null))) {
                                if (!(bulletContext != null && forestWebInfoHelper.hasGeckoModelInfo(bulletContext))) {
                                    if (!(iServiceToken != null && forestWebInfoHelper.hasGeckoModelInfo(iServiceToken))) {
                                        if (schemaModelUnion != null && forestWebInfoHelper.hasGeckoModelInfo(schemaModelUnion)) {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            return TuplesKt.to(false, Scene.WEB_CHILD_RESOURCE);
                                        }
                                    }
                                }
                            }
                        }
                        return TuplesKt.to(true, Scene.WEB_CHILD_RESOURCE);
                    }
                    return TuplesKt.to(true, scene);
                }
            }
            return TuplesKt.to(false, Scene.WEB_CHILD_RESOURCE);
        }
    }
}
