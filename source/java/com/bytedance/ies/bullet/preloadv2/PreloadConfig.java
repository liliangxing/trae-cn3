package com.bytedance.ies.bullet.preloadv2;

import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.prefetchv2.ConfigLoaderKt;
import com.bytedance.ies.bullet.preloadv2.cache.DynamicComponentPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.ExternalJsPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.FontPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.ImagePreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.LottiePreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadResourceType;
import com.bytedance.ies.bullet.preloadv2.cache.TemplatePreloadItem;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadHelper;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.pia.core.tracing.OnlineTracing;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PreloadConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/PreloadConfig;", "", "()V", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "decodeTemplate", "", "getDecodeTemplate", "()Z", "setDecodeTemplate", "(Z)V", "disableTemplate", "getDisableTemplate", "setDisableTemplate", "expireTime", "", "items", "", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "preCodeCache", "getPreCodeCache", "setPreCodeCache", "checkExpire", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadConfig {
    private static final String CONFIG_FILE_NAME = "preload.json";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<Uri, PreloadConfig> configCache = new ConcurrentHashMap<>();
    private boolean decodeTemplate;
    private boolean disableTemplate;
    private final long expireTime;
    private List<PreloadItem> items;
    private boolean preCodeCache;

    public final List<PreloadItem> getItems() {
        return this.items;
    }

    public final void setItems(List<PreloadItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final boolean getDisableTemplate() {
        return this.disableTemplate;
    }

    public final void setDisableTemplate(boolean z) {
        this.disableTemplate = z;
    }

    public final boolean getDecodeTemplate() {
        return this.decodeTemplate;
    }

    public final void setDecodeTemplate(boolean z) {
        this.decodeTemplate = z;
    }

    public final boolean getPreCodeCache() {
        return this.preCodeCache;
    }

    public final void setPreCodeCache(boolean z) {
        this.preCodeCache = z;
    }

    public PreloadConfig() {
        this.expireTime = System.currentTimeMillis() + PreloadConfigKt.EXPIRE_TIME;
        this.items = new ArrayList();
    }

    public PreloadConfig(JSONObject jSONObject) {
        LottiePreloadItem preloadItem;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        this.expireTime = System.currentTimeMillis() + PreloadConfigKt.EXPIRE_TIME;
        this.items = new ArrayList();
        this.disableTemplate = jSONObject.optBoolean("disableTemplate", false);
        this.decodeTemplate = jSONObject.optBoolean("decodeTemplate", false);
        this.preCodeCache = jSONObject.optBoolean("preCodeCache", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("preloadItems");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("type");
            if (Intrinsics.areEqual(optString, PreloadResourceType.Template.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new TemplatePreloadItem(optJSONObject);
            } else if (Intrinsics.areEqual(optString, PreloadResourceType.Image.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new ImagePreloadItem(optJSONObject);
            } else if (Intrinsics.areEqual(optString, PreloadResourceType.Redirect.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new PreloadItem(optJSONObject);
            } else if (Intrinsics.areEqual(optString, PreloadResourceType.Font.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new FontPreloadItem(optJSONObject);
            } else if (Intrinsics.areEqual(optString, PreloadResourceType.ExternalJs.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new ExternalJsPreloadItem(optJSONObject);
            } else if (Intrinsics.areEqual(optString, PreloadResourceType.DynamicComponent.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new DynamicComponentPreloadItem(optJSONObject);
            } else if (Intrinsics.areEqual(optString, PreloadResourceType.Lottie.getTag())) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new LottiePreloadItem(optJSONObject);
            } else {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "itemJson");
                preloadItem = new PreloadItem(optJSONObject);
            }
            if (preloadItem.checkValid()) {
                this.items.add(preloadItem);
            } else {
                PreloadLogger.INSTANCE.m43i("invalid preload config checked");
            }
        }
    }

    public final boolean checkExpire() {
        return System.currentTimeMillis() > this.expireTime;
    }

    /* compiled from: PreloadConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/PreloadConfig$Companion;", "", "()V", "CONFIG_FILE_NAME", "", "configCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/preloadv2/PreloadConfig;", "getConfig", "schema", "targetBid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00f2 A[Catch: all -> 0x0160, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0008, B:7:0x002f, B:10:0x0037, B:12:0x003b, B:16:0x0044, B:18:0x0050, B:20:0x0056, B:23:0x006b, B:25:0x00b7, B:28:0x00d7, B:30:0x00e6, B:35:0x00f2, B:38:0x0124, B:40:0x0134, B:41:0x0140, B:43:0x014d, B:49:0x0025, B:6:0x0019), top: B:3:0x0008, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0124 A[Catch: all -> 0x0160, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0008, B:7:0x002f, B:10:0x0037, B:12:0x003b, B:16:0x0044, B:18:0x0050, B:20:0x0056, B:23:0x006b, B:25:0x00b7, B:28:0x00d7, B:30:0x00e6, B:35:0x00f2, B:38:0x0124, B:40:0x0134, B:41:0x0140, B:43:0x014d, B:49:0x0025, B:6:0x0019), top: B:3:0x0008, inners: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized PreloadConfig getConfig(String schema, String targetBid) {
            Object obj;
            boolean z;
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(targetBid, "targetBid");
            PreloadConfig preloadConfig = new PreloadConfig();
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Uri.parse(schema));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Uri uri = (Uri) obj;
            if (uri != null) {
                PreloadConfig preloadConfig2 = (PreloadConfig) PreloadConfig.configCache.get(uri);
                if (preloadConfig2 != null) {
                    if (!preloadConfig2.checkExpire()) {
                        return preloadConfig2;
                    }
                    PreloadLogger.INSTANCE.m43i("配置文件过期，重新加载");
                }
                TaskConfig generateTaskConfig = PreloadHelper.INSTANCE.generateTaskConfig(null, uri, targetBid);
                generateTaskConfig.setLoadTimeOut(OnlineTracing.DATA_TIMEOUT);
                generateTaskConfig.setCdnUrl(ConfigLoaderKt.suffixReplace(generateTaskConfig.getCdnUrl(), PreloadConfig.CONFIG_FILE_NAME));
                PreloadLogger.INSTANCE.m43i("preload config: " + generateTaskConfig.getCdnUrl());
                generateTaskConfig.setBundle(ConfigLoaderKt.bundleReplace(generateTaskConfig.getBundle(), PreloadConfig.CONFIG_FILE_NAME));
                ResourceInfo loadSync = ResourceLoader.with$default(ResourceLoader.INSTANCE, targetBid, null, 2, null).loadSync("", generateTaskConfig);
                if (loadSync == null) {
                    PreloadLogger.INSTANCE.m42e("Preload配置加载失败: " + uri);
                    preloadConfig.getItems().add(new TemplatePreloadItem(schema));
                    return preloadConfig;
                }
                String fileString = ExtKt.getFileString(loadSync.provideInputStream());
                String str = fileString;
                if (str != null && str.length() != 0) {
                    z = false;
                    if (!z) {
                        PreloadLogger.INSTANCE.m42e("Preload配置加载失败，配置为空: " + loadSync.getGeckoFailMessage() + '-' + loadSync.getCdnFailedMessage());
                        preloadConfig.getItems().add(new TemplatePreloadItem(schema));
                        return preloadConfig;
                    }
                    PreloadConfig preloadConfig3 = new PreloadConfig(new JSONObject(fileString));
                    if (!preloadConfig3.getDisableTemplate()) {
                        preloadConfig3.getItems().add(0, new TemplatePreloadItem(schema));
                    }
                    if (!preloadConfig3.getItems().isEmpty()) {
                        PreloadConfig.configCache.put(uri, preloadConfig3);
                        PreloadLogger.INSTANCE.m43i("配置获取成功");
                    }
                    return preloadConfig3;
                }
                z = true;
                if (!z) {
                }
            } else {
                PreloadLogger.INSTANCE.m42e("Preload resource schema in wrong format");
                return preloadConfig;
            }
        }
    }
}
