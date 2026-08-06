package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ForestAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bJ4\u0010\u0003\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007JT\u0010\u0003\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestPreloadHelper;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "()V", "preloadPage", "", "uri", "Landroid/net/Uri;", "sessionId", "", "ua", "performDelayPreload", "", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "modelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "bid", "type", "Lcom/bytedance/forest/model/PreloadType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestPreloadHelper implements ForestInfoHelper {
    public static final ForestPreloadHelper INSTANCE = new ForestPreloadHelper();

    private ForestPreloadHelper() {
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

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void preloadPage(SchemaModelUnion modelUnion, Uri uri, String sessionId, String bid, PreloadType type, String ua, boolean performDelayPreload) {
        String str;
        ISchemaData schemaData;
        String value;
        String str2;
        Intrinsics.checkNotNullParameter(type, "type");
        if (useForest(modelUnion)) {
            String preloadScope = preloadScope(modelUnion);
            if (Intrinsics.areEqual(preloadScope, ForestLoader.PRELOAD_SCOPE_DISABLE)) {
                return;
            }
            boolean delayPreload = delayPreload(modelUnion);
            HybridLogger.i$default(HybridLogger.INSTANCE, "Forest", "perform preload", MapsKt.mapOf(new Pair[]{TuplesKt.to("url", uri), TuplesKt.to("delay_preload", Boolean.valueOf(delayPreload))}), null, 8, null);
            if (!delayPreload || performDelayPreload) {
                if (delayPreload || !performDelayPreload) {
                    if (uri == null || (value = uri.toString()) == null) {
                        if (modelUnion != null && (schemaData = modelUnion.getSchemaData()) != null) {
                            value = new StringParam(schemaData, "url", null).getValue();
                        } else {
                            str = null;
                            str2 = str;
                            if ((str2 != null || str2.length() == 0) && modelUnion != null) {
                                ForestLoader forestLoader = ForestLoader.INSTANCE;
                                boolean areEqual = Intrinsics.areEqual(preloadScope, "all");
                                boolean areEqual2 = Intrinsics.areEqual(INSTANCE.forestDownloadEngine(modelUnion), ForestLoader.DOWNLOAD_ENGINE_TTNET);
                                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                                taskConfig.setBid(bid != null ? "" : bid);
                                taskConfig.setInjectedUserAgent(ua);
                                Unit unit = Unit.INSTANCE;
                                forestLoader.preload((r24 & 1) != 0 ? forestLoader.getDefault() : null, str, areEqual, sessionId, type, areEqual2, "schema", (r24 & 128) != 0 ? null : taskConfig, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
                            }
                            return;
                        }
                    }
                    str = value;
                    str2 = str;
                    if (str2 != null || str2.length() == 0) {
                        return;
                    }
                    ForestLoader forestLoader2 = ForestLoader.INSTANCE;
                    boolean areEqual3 = Intrinsics.areEqual(preloadScope, "all");
                    boolean areEqual22 = Intrinsics.areEqual(INSTANCE.forestDownloadEngine(modelUnion), ForestLoader.DOWNLOAD_ENGINE_TTNET);
                    TaskConfig taskConfig2 = new TaskConfig(null, 1, null);
                    taskConfig2.setBid(bid != null ? "" : bid);
                    taskConfig2.setInjectedUserAgent(ua);
                    Unit unit2 = Unit.INSTANCE;
                    forestLoader2.preload((r24 & 1) != 0 ? forestLoader2.getDefault() : null, str, areEqual3, sessionId, type, areEqual22, "schema", (r24 & 128) != 0 ? null : taskConfig2, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
                }
            }
        }
    }

    public static /* synthetic */ void preloadPage$default(ForestPreloadHelper forestPreloadHelper, BulletContext bulletContext, Uri uri, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            uri = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        forestPreloadHelper.preloadPage(bulletContext, uri, str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void preloadPage(BulletContext context, Uri uri, String ua, boolean performDelayPreload) {
        String str;
        ISchemaData schemaData;
        String value;
        String str2;
        String bid;
        if (useForest(context)) {
            String preloadScope = preloadScope(context);
            if (Intrinsics.areEqual(preloadScope, ForestLoader.PRELOAD_SCOPE_DISABLE)) {
                return;
            }
            boolean delayPreload = delayPreload(context);
            if (!delayPreload || performDelayPreload) {
                if (delayPreload || !performDelayPreload) {
                    if (uri == null || (value = uri.toString()) == null) {
                        if (context != null && (schemaData = context.getSchemaData()) != null) {
                            value = new StringParam(schemaData, "url", null).getValue();
                        } else {
                            str = null;
                            str2 = str;
                            if ((str2 != null || str2.length() == 0) && context != null) {
                                ForestLoader forestLoader = ForestLoader.INSTANCE;
                                boolean areEqual = Intrinsics.areEqual(preloadScope, "all");
                                String sessionId = context.getSessionId();
                                BulletLoadUriIdentifier uriIdentifier = context.getUriIdentifier();
                                PreloadType preloadType = (uriIdentifier == null ? uriIdentifier.getKitType() : null) != KitType.LYNX ? PreloadType.LYNX : PreloadType.WEB;
                                boolean areEqual2 = Intrinsics.areEqual(INSTANCE.forestDownloadEngine(context), ForestLoader.DOWNLOAD_ENGINE_TTNET);
                                TaskConfig taskConfig = new TaskConfig(null, 1, null);
                                bid = context.getBid();
                                if (bid == null) {
                                    bid = "";
                                }
                                taskConfig.setBid(bid);
                                taskConfig.setInjectedUserAgent(ua);
                                Unit unit = Unit.INSTANCE;
                                forestLoader.preload((r24 & 1) != 0 ? forestLoader.getDefault() : null, str, areEqual, sessionId, preloadType, areEqual2, "schema", (r24 & 128) != 0 ? null : taskConfig, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
                            }
                            return;
                        }
                    }
                    str = value;
                    str2 = str;
                    if (str2 != null || str2.length() == 0) {
                        return;
                    }
                    ForestLoader forestLoader2 = ForestLoader.INSTANCE;
                    boolean areEqual3 = Intrinsics.areEqual(preloadScope, "all");
                    String sessionId2 = context.getSessionId();
                    BulletLoadUriIdentifier uriIdentifier2 = context.getUriIdentifier();
                    PreloadType preloadType2 = (uriIdentifier2 == null ? uriIdentifier2.getKitType() : null) != KitType.LYNX ? PreloadType.LYNX : PreloadType.WEB;
                    boolean areEqual22 = Intrinsics.areEqual(INSTANCE.forestDownloadEngine(context), ForestLoader.DOWNLOAD_ENGINE_TTNET);
                    TaskConfig taskConfig2 = new TaskConfig(null, 1, null);
                    bid = context.getBid();
                    if (bid == null) {
                    }
                    taskConfig2.setBid(bid);
                    taskConfig2.setInjectedUserAgent(ua);
                    Unit unit2 = Unit.INSTANCE;
                    forestLoader2.preload((r24 & 1) != 0 ? forestLoader2.getDefault() : null, str, areEqual3, sessionId2, preloadType2, areEqual22, "schema", (r24 & 128) != 0 ? null : taskConfig2, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
                }
            }
        }
    }

    public static /* synthetic */ void preloadPage$default(ForestPreloadHelper forestPreloadHelper, Uri uri, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        forestPreloadHelper.preloadPage(uri, str, str2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void preloadPage(Uri uri, String sessionId, String ua, boolean performDelayPreload) {
        LinkedHashMap linkedHashMap;
        List<String> list;
        JSONObject parseSubConfigs;
        Iterator<Map.Entry<String, List<String>>> it;
        boolean z;
        BulletSettings provideBulletSettings;
        Boolean enableFmpResourcePreload;
        BulletSettings provideBulletSettings2;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        String preloadScope = preloadScope(uri);
        if (Intrinsics.areEqual(preloadScope, ForestLoader.PRELOAD_SCOPE_DISABLE)) {
            return;
        }
        boolean delayPreload = delayPreload(uri);
        LogUtils.e$default(LogUtils.INSTANCE, ResourceInfo.RESOURCE_FROM_PRELOAD, "origin preload timing " + System.currentTimeMillis(), (Throwable) null, 4, (Object) null);
        if (!delayPreload || performDelayPreload) {
            if (delayPreload || !performDelayPreload) {
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                String queryParameter = uri.getQueryParameter(SchemaConstants.FOREST_DOWNLOAD_ENGINE);
                if (queryParameter == null) {
                    queryParameter = ForestLoader.DOWNLOAD_ENGINE_TTNET;
                }
                ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                if (iSettingService == null || (provideBulletSettings2 = iSettingService.provideBulletSettings()) == null || (linkedHashMap = provideBulletSettings2.getForestFmpResourceList()) == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                ISettingService iSettingService2 = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                if ((iSettingService2 == null || (provideBulletSettings = iSettingService2.provideBulletSettings()) == null || (enableFmpResourcePreload = provideBulletSettings.getEnableFmpResourcePreload()) == null) ? false : enableFmpResourcePreload.booleanValue()) {
                    String queryParameter2 = uri.getQueryParameter("annie_x_url");
                    if (queryParameter2 == null) {
                        queryParameter2 = ExtKt.getCDN$default(uri, null, 1, null);
                    }
                    Iterator<Map.Entry<String, List<String>>> it2 = linkedHashMap.entrySet().iterator();
                    list = null;
                    while (it2.hasNext()) {
                        Map.Entry<String, List<String>> next = it2.next();
                        if (queryParameter2 != null) {
                            it = it2;
                            if (StringsKt.contains$default(queryParameter2, next.getKey(), false, 2, (Object) null)) {
                                z = true;
                                if (!z) {
                                    list = next.getValue();
                                }
                                it2 = it;
                            }
                        } else {
                            it = it2;
                        }
                        z = false;
                        if (!z) {
                        }
                        it2 = it;
                    }
                } else {
                    list = null;
                }
                if (Intrinsics.areEqual(preloadScope, "main") && list != null) {
                    ForestLoader forestLoader = ForestLoader.INSTANCE;
                    parseSubConfigs = ForestAdapterKt.parseSubConfigs(list, uri);
                    PreloadType preloadType = Intrinsics.areEqual(uri.getHost(), "webcast_lynxview") ? PreloadType.LYNX : PreloadType.WEB;
                    TaskConfig taskConfig = new TaskConfig(null, 1, null);
                    taskConfig.setBid(BidConstants.WEBCAST);
                    taskConfig.setInjectedUserAgent(ua);
                    Unit unit = Unit.INSTANCE;
                    forestLoader.preload((r20 & 1) != 0 ? forestLoader.getDefault() : null, (r20 & 2) != 0 ? null : uri2, (r20 & 4) != 0 ? null : parseSubConfigs, "schema", (r20 & 16) != 0 ? null : sessionId, preloadType, (r20 & 64) != 0 ? null : taskConfig, (r20 & 128) != 0 ? false : true);
                    return;
                }
                ForestLoader forestLoader2 = ForestLoader.INSTANCE;
                boolean areEqual = Intrinsics.areEqual(preloadScope, "all");
                PreloadType preloadType2 = Intrinsics.areEqual(uri.getHost(), "webcast_lynxview") ? PreloadType.LYNX : PreloadType.WEB;
                boolean areEqual2 = Intrinsics.areEqual(queryParameter, ForestLoader.DOWNLOAD_ENGINE_TTNET);
                TaskConfig taskConfig2 = new TaskConfig(null, 1, null);
                taskConfig2.setBid(BidConstants.WEBCAST);
                taskConfig2.setInjectedUserAgent(ua);
                Unit unit2 = Unit.INSTANCE;
                forestLoader2.preload((r24 & 1) != 0 ? forestLoader2.getDefault() : null, uri2, areEqual, sessionId, preloadType2, areEqual2, "schema", (r24 & 128) != 0 ? null : taskConfig2, (r24 & 256) != 0 ? false : true, (r24 & 512) != 0 ? null : null);
            }
        }
    }
}
