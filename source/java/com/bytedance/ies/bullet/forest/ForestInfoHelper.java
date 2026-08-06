package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestInfoHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "", "delayPreload", "", "uri", "Landroid/net/Uri;", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "fetchFromQueries", "", "key", "forestDownloadEngine", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "getResTag", "theFrom", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest$LynxResourceType;", "getSceneType", "Lcom/bytedance/forest/model/Scene;", "getTemplateBundleResponse", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "Lcom/lynx/tasm/TemplateBundle;", "response", "Lcom/bytedance/forest/model/Response;", "hasGeckoModelInfo", "preloadScope", "provideContainerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "sessionID", "useForest", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ForestInfoHelper {

    /* compiled from: ForestInfoHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LynxResourceRequest.LynxResourceType.values().length];
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeExternalJSSource.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeFont.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeImage.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeDynamicComponent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeLottie.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeSVG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeVideo.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LynxResourceRequest.LynxResourceType.LynxResourceTypeI18NText.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    boolean delayPreload(Uri uri);

    boolean delayPreload(BulletContext context);

    boolean delayPreload(SchemaModelUnion schemaModelUnion);

    String forestDownloadEngine(Uri uri);

    String forestDownloadEngine(BulletContext context);

    String forestDownloadEngine(IServiceToken token);

    String forestDownloadEngine(SchemaModelUnion schemaModelUnion);

    String getResTag(LynxResourceRequest.LynxResourceType theFrom);

    Scene getSceneType(LynxResourceRequest.LynxResourceType theFrom);

    ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response);

    boolean hasGeckoModelInfo(BulletContext context);

    boolean hasGeckoModelInfo(IServiceToken token);

    boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion);

    String preloadScope(Uri uri);

    String preloadScope(BulletContext context);

    String preloadScope(SchemaModelUnion schemaModelUnion);

    String sessionID(BulletContext context);

    String sessionID(IServiceToken token);

    boolean useForest(Uri uri);

    boolean useForest(BulletContext context);

    boolean useForest(IServiceToken token);

    boolean useForest(SchemaModelUnion schemaModelUnion);

    /* compiled from: ForestInfoHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static boolean useForest(ForestInfoHelper forestInfoHelper, IServiceToken iServiceToken) {
            return forestInfoHelper.useForest(iServiceToken != null ? (BulletContext) iServiceToken.getDependency(BulletContext.class) : null);
        }

        public static boolean useForest(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion) {
            String fetchFromQueries;
            String str;
            StringParam loaderName;
            BDXContainerModel provideContainerModel = provideContainerModel(forestInfoHelper, schemaModelUnion);
            if (provideContainerModel == null || (loaderName = provideContainerModel.getLoaderName()) == null || (fetchFromQueries = loaderName.getValue()) == null) {
                fetchFromQueries = fetchFromQueries(forestInfoHelper, schemaModelUnion, SchemaConstants.LOADER_NAME);
            }
            if (fetchFromQueries != null) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                str = fetchFromQueries.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            return Intrinsics.areEqual(str, "forest");
        }

        public static boolean useForest(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            String fetchFromQueries;
            String str;
            StringParam loaderName;
            BDXContainerModel provideContainerModel = provideContainerModel(forestInfoHelper, bulletContext);
            if (provideContainerModel == null || (loaderName = provideContainerModel.getLoaderName()) == null || (fetchFromQueries = loaderName.getValue()) == null) {
                fetchFromQueries = fetchFromQueries(forestInfoHelper, bulletContext, SchemaConstants.LOADER_NAME);
            }
            if (fetchFromQueries != null) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                str = fetchFromQueries.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            return Intrinsics.areEqual(str, "forest");
        }

        public static boolean useForest(ForestInfoHelper forestInfoHelper, Uri uri) {
            Object obj;
            String str;
            String queryParameter;
            try {
                Result.Companion companion = Result.Companion;
                if (uri == null || (queryParameter = uri.getQueryParameter(SchemaConstants.LOADER_NAME)) == null) {
                    str = null;
                } else {
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    str = queryParameter.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
                }
                obj = Result.constructor-impl(str);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return Intrinsics.areEqual(Result.isFailure-impl(obj) ? null : obj, "forest");
        }

        public static String forestDownloadEngine(ForestInfoHelper forestInfoHelper, IServiceToken iServiceToken) {
            return forestInfoHelper.forestDownloadEngine(iServiceToken != null ? (BulletContext) iServiceToken.getDependency(BulletContext.class) : null);
        }

        public static String forestDownloadEngine(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            StringParam forestDownloadEngine;
            String value;
            BDXContainerModel provideContainerModel = provideContainerModel(forestInfoHelper, bulletContext);
            if (provideContainerModel != null && (forestDownloadEngine = provideContainerModel.getForestDownloadEngine()) != null && (value = forestDownloadEngine.getValue()) != null) {
                return value;
            }
            String fetchFromQueries = fetchFromQueries(forestInfoHelper, bulletContext, SchemaConstants.FOREST_DOWNLOAD_ENGINE);
            return fetchFromQueries == null ? ForestLoader.DOWNLOAD_ENGINE_TTNET : fetchFromQueries;
        }

        public static String forestDownloadEngine(ForestInfoHelper forestInfoHelper, Uri uri) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(uri != null ? uri.getQueryParameter(SchemaConstants.FOREST_DOWNLOAD_ENGINE) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            String str = (String) (Result.isFailure-impl(obj) ? null : obj);
            return str == null ? ForestLoader.DOWNLOAD_ENGINE_TTNET : str;
        }

        public static String forestDownloadEngine(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion) {
            String fetchFromQueries = fetchFromQueries(forestInfoHelper, schemaModelUnion, SchemaConstants.FOREST_DOWNLOAD_ENGINE);
            return fetchFromQueries == null ? ForestLoader.DOWNLOAD_ENGINE_TTNET : fetchFromQueries;
        }

        public static String sessionID(ForestInfoHelper forestInfoHelper, IServiceToken iServiceToken) {
            return forestInfoHelper.sessionID(iServiceToken != null ? (BulletContext) iServiceToken.getDependency(BulletContext.class) : null);
        }

        public static String sessionID(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            if (bulletContext != null) {
                return bulletContext.getSessionId();
            }
            return null;
        }

        public static String preloadScope(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            StringParam forestPreloadScope;
            String value;
            BDXContainerModel provideContainerModel = provideContainerModel(forestInfoHelper, bulletContext);
            if (provideContainerModel != null && (forestPreloadScope = provideContainerModel.getForestPreloadScope()) != null && (value = forestPreloadScope.getValue()) != null) {
                return value;
            }
            String fetchFromQueries = fetchFromQueries(forestInfoHelper, bulletContext, "enable_preload");
            return fetchFromQueries == null ? ForestLoader.PRELOAD_SCOPE_DISABLE : fetchFromQueries;
        }

        public static String preloadScope(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion) {
            String fetchFromQueries = fetchFromQueries(forestInfoHelper, schemaModelUnion, "enable_preload");
            return fetchFromQueries == null ? ForestLoader.PRELOAD_SCOPE_DISABLE : fetchFromQueries;
        }

        public static String preloadScope(ForestInfoHelper forestInfoHelper, Uri uri) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(uri != null ? uri.getQueryParameter("enable_preload") : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            String str = (String) (Result.isFailure-impl(obj) ? null : obj);
            return str == null ? ForestLoader.PRELOAD_SCOPE_DISABLE : str;
        }

        public static boolean delayPreload(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            BooleanParam forestDelayPreload;
            Boolean value;
            BDXContainerModel provideContainerModel = provideContainerModel(forestInfoHelper, bulletContext);
            if (provideContainerModel != null && (forestDelayPreload = provideContainerModel.getForestDelayPreload()) != null && (value = forestDelayPreload.getValue()) != null) {
                return value.booleanValue();
            }
            String fetchFromQueries = fetchFromQueries(forestInfoHelper, bulletContext, "delay_preload");
            if (fetchFromQueries == null) {
                fetchFromQueries = ViewVisibleBridge.INVISIBLE;
            }
            return Intrinsics.areEqual(fetchFromQueries, "1");
        }

        public static boolean delayPreload(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion) {
            String fetchFromQueries = fetchFromQueries(forestInfoHelper, schemaModelUnion, "delay_preload");
            if (fetchFromQueries == null) {
                fetchFromQueries = ViewVisibleBridge.INVISIBLE;
            }
            return Intrinsics.areEqual(fetchFromQueries, "1");
        }

        public static boolean delayPreload(ForestInfoHelper forestInfoHelper, Uri uri) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(uri != null ? uri.getQueryParameter("delay_preload") : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            String str = (String) (Result.isFailure-impl(obj) ? null : obj);
            if (str == null) {
                str = ViewVisibleBridge.INVISIBLE;
            }
            return Intrinsics.areEqual(str, "1");
        }

        public static boolean hasGeckoModelInfo(ForestInfoHelper forestInfoHelper, IServiceToken iServiceToken) {
            return forestInfoHelper.hasGeckoModelInfo(iServiceToken != null ? (BulletContext) iServiceToken.getDependency(BulletContext.class) : null);
        }

        public static boolean hasGeckoModelInfo(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            return (LoaderUtil.INSTANCE.isNotNullOrEmpty(fetchFromQueries(forestInfoHelper, bulletContext, "channel")) && LoaderUtil.INSTANCE.isNotNullOrEmpty(fetchFromQueries(forestInfoHelper, bulletContext, SchemaConstants.QUERY_KEY_BUNDLE))) || LoaderUtil.INSTANCE.isNotNullOrEmpty(fetchFromQueries(forestInfoHelper, bulletContext, SchemaConstants.QUERY_KEY_PREFIX));
        }

        public static boolean hasGeckoModelInfo(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion) {
            return (LoaderUtil.INSTANCE.isNotNullOrEmpty(fetchFromQueries(forestInfoHelper, schemaModelUnion, "channel")) && LoaderUtil.INSTANCE.isNotNullOrEmpty(fetchFromQueries(forestInfoHelper, schemaModelUnion, SchemaConstants.QUERY_KEY_BUNDLE))) || LoaderUtil.INSTANCE.isNotNullOrEmpty(fetchFromQueries(forestInfoHelper, schemaModelUnion, SchemaConstants.QUERY_KEY_PREFIX));
        }

        private static BDXContainerModel provideContainerModel(ForestInfoHelper forestInfoHelper, BulletContext bulletContext) {
            SchemaModelUnion schemaModelUnion;
            ISchemaModel containerModel = (bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getContainerModel();
            if (containerModel instanceof BDXContainerModel) {
                return (BDXContainerModel) containerModel;
            }
            return null;
        }

        private static BDXContainerModel provideContainerModel(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion) {
            ISchemaModel containerModel = schemaModelUnion != null ? schemaModelUnion.getContainerModel() : null;
            if (containerModel instanceof BDXContainerModel) {
                return (BDXContainerModel) containerModel;
            }
            return null;
        }

        private static String fetchFromQueries(ForestInfoHelper forestInfoHelper, BulletContext bulletContext, String str) {
            SchemaModelUnion schemaModelUnion;
            ISchemaData schemaData;
            Map<String, String> queryItems;
            if (bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (queryItems = schemaData.getQueryItems()) == null) {
                return null;
            }
            return queryItems.get(str);
        }

        private static String fetchFromQueries(ForestInfoHelper forestInfoHelper, SchemaModelUnion schemaModelUnion, String str) {
            ISchemaData schemaData;
            Map<String, String> queryItems;
            if (schemaModelUnion == null || (schemaData = schemaModelUnion.getSchemaData()) == null || (queryItems = schemaData.getQueryItems()) == null) {
                return null;
            }
            return queryItems.get(str);
        }

        public static ProcessedResponse<TemplateBundle> getTemplateBundleResponse(ForestInfoHelper forestInfoHelper, Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            ProcessedResponse<TemplateBundle> processedResponse = response instanceof ProcessedResponse ? (ProcessedResponse) response : null;
            if (processedResponse == null) {
                return null;
            }
            if (processedResponse.isProcessSucceed() && processedResponse.provideProcessedData() != null) {
                return processedResponse;
            }
            return null;
        }

        public static Scene getSceneType(ForestInfoHelper forestInfoHelper, LynxResourceRequest.LynxResourceType lynxResourceType) {
            switch (lynxResourceType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lynxResourceType.ordinal()]) {
                case 1:
                    return Scene.LYNX_EXTERNAL_JS;
                case 2:
                    return Scene.LYNX_FONT;
                case 3:
                    return Scene.LYNX_IMAGE;
                case 4:
                    return Scene.LYNX_COMPONENT;
                case 5:
                    return Scene.LYNX_TEMPLATE;
                case 6:
                    return Scene.LYNX_LOTTIE;
                case 7:
                    return Scene.LYNX_SVG;
                case 8:
                    return Scene.LYNX_VIDEO;
                case 9:
                    return Scene.LYNX_I18N;
                default:
                    return Scene.LYNX_CHILD_RESOURCE;
            }
        }

        public static String getResTag(ForestInfoHelper forestInfoHelper, LynxResourceRequest.LynxResourceType lynxResourceType) {
            int i = lynxResourceType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lynxResourceType.ordinal()];
            return i != 1 ? i != 4 ? i != 5 ? "sub_resource" : "template" : "component" : "external_js";
        }
    }
}
