package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.strategy.provider.client.PrefetchCallerParams;
import com.bytedance.ies.argus.strategy.provider.client.PrefetchType;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.CustomLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.pia.core.metrics.ErrorType;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* compiled from: ConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/InternalConfigLoader;", "Lcom/bytedance/ies/bullet/prefetchv2/ConfigLoader;", "()V", "CONFIG_FILE_NAME", "", "getFileString", "ins", "Ljava/io/InputStream;", "loadConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "pageUri", "Landroid/net/Uri;", "targetBid", "identifierUrl", "loadConfigFromRL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InternalConfigLoader implements ConfigLoader {
    public static final String CONFIG_FILE_NAME = "prefetch.json";
    public static final InternalConfigLoader INSTANCE = new InternalConfigLoader();

    private InternalConfigLoader() {
    }

    @Override // com.bytedance.ies.bullet.prefetchv2.ConfigLoader
    public PrefetchConfig loadConfig(final Uri pageUri, final String targetBid, final String identifierUrl) {
        final PrefetchConfig bySchemaUri;
        Intrinsics.checkNotNullParameter(pageUri, "pageUri");
        Intrinsics.checkNotNullParameter(targetBid, "targetBid");
        if (BulletEnv.INSTANCE.getInstance().getDebuggable() && Intrinsics.areEqual(SchemaUtilsKt.getQueryParameterSafely(pageUri, "__dev"), "1")) {
            return loadConfigFromRL(pageUri, targetBid);
        }
        if (identifierUrl == null || (bySchemaUri = ConfigCache.INSTANCE.getConfigByIdentifier(identifierUrl)) == null) {
            bySchemaUri = ConfigCache.INSTANCE.getBySchemaUri(pageUri);
        }
        PrefetchLogger.INSTANCE.m36d("configCache: " + bySchemaUri);
        if (bySchemaUri != null) {
            bySchemaUri.setConfigFrom("memory");
            PrefetchLoggerKt.debugPrint(new Function0<String>() { // from class: com.bytedance.ies.bullet.prefetchv2.InternalConfigLoader$loadConfig$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "命中预取配置缓存: " + PrefetchConfig.this.toJson() + ", identifier: " + identifierUrl;
                }
            });
            PrefetchV2.INSTANCE.executeInWorker$anniex_release(new Runnable() { // from class: com.bytedance.ies.bullet.prefetchv2.InternalConfigLoader$loadConfig$1$2
                @Override // java.lang.Runnable
                public final void run() {
                    PrefetchLogger.INSTANCE.m36d("异步更新配置");
                    InternalConfigLoader.INSTANCE.loadConfigFromRL(pageUri, targetBid);
                }
            });
            return bySchemaUri;
        }
        return loadConfigFromRL(pageUri, targetBid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        if ((r3 == null || r3.length() == 0) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PrefetchConfig loadConfigFromRL(final Uri pageUri, final String targetBid) {
        String safeGetQueryParameter;
        String safeGetQueryParameter2;
        final String cdn = ExtKt.getCDN(pageUri, targetBid);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ExtKt.safeGetQueryParameter(pageUri, PrefetchSchemaParam.PREFETCH_CHANNEL);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = ExtKt.safeGetQueryParameter(pageUri, PrefetchSchemaParam.PREFETCH_BUNDLE);
        CharSequence charSequence = (CharSequence) objectRef.element;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = (CharSequence) objectRef2.element;
        }
        RLChannelBundleModel parseChannelBundle = ResourceLoader.with$default(ResourceLoader.INSTANCE, targetBid, null, 2, null).parseChannelBundle(cdn);
        if (parseChannelBundle == null || (safeGetQueryParameter = parseChannelBundle.provideChannel()) == null) {
            safeGetQueryParameter = ExtKt.safeGetQueryParameter(pageUri, "channel");
        }
        objectRef.element = safeGetQueryParameter;
        if (parseChannelBundle == null || (safeGetQueryParameter2 = parseChannelBundle.providerBundlePath()) == null) {
            safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(pageUri, SchemaConstants.QUERY_KEY_BUNDLE);
        }
        objectRef2.element = safeGetQueryParameter2;
        final String safeGetQueryParameter3 = ExtKt.safeGetQueryParameter(pageUri, PrefetchSchemaParam.PREFETCH_ACCESS_KEY);
        PrefetchLoggerKt.debugPrint(new Function0<String>() { // from class: com.bytedance.ies.bullet.prefetchv2.InternalConfigLoader$loadConfigFromRL$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                StringBuilder sb = new StringBuilder("开始加载预取配置，cdnUrl: ");
                String str = cdn;
                StringBuilder append = sb.append(str != null ? ConfigLoaderKt.suffixReplace(str, InternalConfigLoader.CONFIG_FILE_NAME) : null).append(", channel: ").append((String) objectRef.element).append(", bundle: ");
                String str2 = (String) objectRef2.element;
                return append.append(str2 != null ? ConfigLoaderKt.bundleReplace(str2, InternalConfigLoader.CONFIG_FILE_NAME) : null).append(", ak: ").append(safeGetQueryParameter3).toString();
            }
        });
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setBid(targetBid);
        taskConfig.setResTag(ErrorType.PREFETCH);
        taskConfig.setLoadTimeOut(3500L);
        taskConfig.setDynamic(0);
        if (Intrinsics.areEqual(ExtKt.safeGetQueryParameter(pageUri, PrefetchSchemaParam.PREFETCH_RES_FROM), PrefetchSchemaParam.PREFETCH_RES_FROM_DISABLE_CDN)) {
            CustomLoaderConfig customLoaderConfig = new CustomLoaderConfig(false);
            customLoaderConfig.setRemovedLoader(CollectionsKt.mutableListOf(new Class[]{CDNLoader.class}));
            taskConfig.setLoaderConfig(customLoaderConfig);
        }
        if (cdn != null) {
            try {
                taskConfig.setCdnUrl(ConfigLoaderKt.suffixReplace(cdn, CONFIG_FILE_NAME));
            } catch (Throwable th) {
                PrefetchLogger.INSTANCE.m37e("Prefetch resourceloader 配置创建失败: " + th.getMessage());
            }
        }
        String str = (String) objectRef.element;
        if (str != null) {
            taskConfig.setChannel(str);
        }
        String str2 = (String) objectRef2.element;
        if (str2 != null) {
            taskConfig.setBundle(ConfigLoaderKt.bundleReplace(str2, CONFIG_FILE_NAME));
        }
        if (safeGetQueryParameter3 != null) {
            taskConfig.setAccessKey(safeGetQueryParameter3);
        }
        ResourceInfo loadSync = ResourceLoader.with$default(ResourceLoader.INSTANCE, targetBid, null, 2, null).loadSync("", taskConfig);
        if (loadSync == null) {
            PrefetchLogger.INSTANCE.m37e("Prefetch配置加载失败, url可能不合法: " + pageUri);
            return null;
        }
        if (!ArgusGlobalDelegate.Companion.getInstance().verifyAboutToPrefetch(new PrefetchCallerParams(loadSync.getCdnSafeUrl(), loadSync.getChannel(), loadSync.getBundle(), PrefetchType.PrefetchV2)).isPass()) {
            PrefetchLogger.INSTANCE.m37e("disable prefetch for security reason by Argus. prefetch.json url: " + loadSync.getCdnSafeUrl());
            return null;
        }
        String fileString = getFileString(loadSync.provideInputStream());
        String str3 = fileString;
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        if (z) {
            PrefetchLogger.INSTANCE.m37e("Prefetch配置加载失败: " + loadSync.getGeckoFailMessage() + '-' + loadSync.getCdnFailedMessage());
            return null;
        }
        final PrefetchConfig config = PrefetchConfigKt.toConfig(fileString);
        if (config == null || !config.checkValid()) {
            return null;
        }
        config.setConfigFrom(loadSync.getStatisticFrom());
        PrefetchV2.INSTANCE.executeInWorker$anniex_release(new Runnable() { // from class: com.bytedance.ies.bullet.prefetchv2.InternalConfigLoader$loadConfigFromRL$2
            @Override // java.lang.Runnable
            public final void run() {
                long nanoTime = System.nanoTime();
                ConfigCache.INSTANCE.put(pageUri, config, targetBid);
                final long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
                final PrefetchConfig prefetchConfig = config;
                PrefetchLoggerKt.debugPrint(new Function0<String>() { // from class: com.bytedance.ies.bullet.prefetchv2.InternalConfigLoader$loadConfigFromRL$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "配置获取成功:\n" + PrefetchConfig.this.toJson() + "，from: " + PrefetchConfig.this.getConfigFrom() + ", 配置缓存耗时 " + millis + " ms";
                    }
                });
            }
        });
        return config;
    }

    private final String getFileString(InputStream ins) {
        if (ins == null) {
            return "";
        }
        try {
            return new String(ByteStreamsKt.readBytes(ins), Charsets.UTF_8);
        } catch (Throwable unused) {
            return "";
        }
    }
}
