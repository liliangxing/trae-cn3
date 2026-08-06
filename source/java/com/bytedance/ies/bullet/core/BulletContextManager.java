package com.bytedance.ies.bullet.core;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.settings.ForestSettingsConfig;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.IServiceContextKt;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.interceptor.BundleInterceptor;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BulletContextManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005J6\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J$\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletContextManager;", "", "()V", "_cachedContext", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/bullet/core/BulletContext;", "addContext", "", "bulletContext", "createBulletContext", "getContext", "sessionId", "getOrCreateContext", "bid", "uri", "Landroid/net/Uri;", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "forceCreateNewSchemaData", "", "config", "Lcom/bytedance/ies/bullet/service/sdk/SchemaConfig;", "injectForestUsageInfo", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "cdnUrl", "type", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "removeContext", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletContextManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<BulletContextManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<BulletContextManager>() { // from class: com.bytedance.ies.bullet.core.BulletContextManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BulletContextManager m498invoke() {
            return new BulletContextManager(null);
        }
    });
    private ConcurrentHashMap<String, BulletContext> _cachedContext;

    public /* synthetic */ BulletContextManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: BulletContextManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletContextManager$Companion;", "", "()V", "instance", "Lcom/bytedance/ies/bullet/core/BulletContextManager;", "getInstance", "()Lcom/bytedance/ies/bullet/core/BulletContextManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BulletContextManager getInstance() {
            return (BulletContextManager) BulletContextManager.instance$delegate.getValue();
        }
    }

    private BulletContextManager() {
        this._cachedContext = new ConcurrentHashMap<>();
    }

    public final void addContext(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        this._cachedContext.put(bulletContext.getSessionId(), bulletContext);
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, bulletContext.getSessionId(), "BulletContextManager addContext: " + this._cachedContext.size(), null, null, 12, null);
    }

    public final BulletContext getContext(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return this._cachedContext.get(sessionId);
    }

    public final void removeContext(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        this._cachedContext.remove(bulletContext.getSessionId());
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, bulletContext.getSessionId(), "BulletContextManager removeContext: " + this._cachedContext.size(), null, null, 12, null);
    }

    public final void removeContext(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this._cachedContext.remove(sessionId);
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, "BulletContextManager removeContextID: " + this._cachedContext.size(), null, null, 12, null);
    }

    public final BulletContext createBulletContext() {
        return new BulletContext();
    }

    public static /* synthetic */ BulletContext getOrCreateContext$default(BulletContextManager bulletContextManager, String str, Uri uri, Bundle bundle, boolean z, SchemaConfig schemaConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            schemaConfig = null;
        }
        return bulletContextManager.getOrCreateContext(str, uri, bundle, z2, schemaConfig);
    }

    public final BulletContext getOrCreateContext(String bid, Uri uri, Bundle bundle, boolean forceCreateNewSchemaData, SchemaConfig config) {
        BulletContext bulletContext;
        boolean z;
        BulletContext bulletContext2;
        ISchemaData schemaDataFromCache;
        Uri uri2 = uri;
        SchemaConfig schemaConfig = config;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        long currentTimeMillis = System.currentTimeMillis();
        String orCreateSessionID = IServiceContextKt.getOrCreateSessionID(uri, bundle);
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, orCreateSessionID, "BulletContextManager getOrCreateContext: " + bid + ", " + uri2 + ", " + bundle + ", " + forceCreateNewSchemaData + ", " + schemaConfig, null, null, 12, null);
        BulletContext context = getContext(orCreateSessionID);
        if (context == null) {
            BulletContext bulletContext3 = new BulletContext(orCreateSessionID);
            addContext(bulletContext3);
            bulletContext3.setUriIdentifier(new BulletLoadUriIdentifier(uri2));
            bulletContext3.getMonitorCallback().onBulletContextCreated(bulletContext3);
            bulletContext = bulletContext3;
            z = true;
        } else {
            bulletContext = context;
            z = forceCreateNewSchemaData;
        }
        if (Intrinsics.areEqual(uri2, Uri.EMPTY)) {
            return bulletContext;
        }
        if (bulletContext.getSchemaData() == null) {
            z = true;
        }
        if (z) {
            if (schemaConfig == null) {
                if (bundle != null) {
                    schemaConfig = new SchemaConfig();
                    schemaConfig.addInterceptor(new BundleInterceptor(bundle));
                } else {
                    schemaConfig = null;
                }
            }
            if (schemaConfig != null) {
                SchemaService.INSTANCE.getInstance().bindConfig(uri2, schemaConfig);
            }
            boolean areEqual = Intrinsics.areEqual(bid, BidConstants.WEBCAST);
            if (forceCreateNewSchemaData) {
                schemaDataFromCache = SchemaService.INSTANCE.getInstance().generateSchemaData(bid, uri2, areEqual);
            } else {
                schemaDataFromCache = SchemaService.INSTANCE.getInstance().getSchemaDataFromCache(uri2, bundle);
                if (schemaDataFromCache == null) {
                    schemaDataFromCache = SchemaService.INSTANCE.getInstance().generateSchemaData(bid, uri2, areEqual);
                }
            }
            bulletContext.setSchemaData(schemaDataFromCache);
            bulletContext.setLoadUri(schemaDataFromCache.getUrl());
            Uri value = new UrlParam(schemaDataFromCache, "url", null).getValue();
            if (value != null) {
                uri2 = value;
            }
            bulletContext.setUriIdentifier(new BulletLoadUriIdentifier(uri2));
            ISchemaMutableData iSchemaMutableData = schemaDataFromCache instanceof ISchemaMutableData ? (ISchemaMutableData) schemaDataFromCache : null;
            String cDN$default = value != null ? ExtKt.getCDN$default(value, null, 1, null) : null;
            BulletLoadUriIdentifier uriIdentifier = bulletContext.getUriIdentifier();
            Intrinsics.checkNotNull(uriIdentifier);
            injectForestUsageInfo(iSchemaMutableData, cDN$default, uriIdentifier.getKitType());
            bulletContext.setSchemaModelUnion(new SchemaModelUnion(schemaDataFromCache));
            BulletContextKt.setupAnniePro(bulletContext);
            BulletContextKt.setupPia(bulletContext, bid);
            bulletContext.getMonitorCallback().onSchemaPrepared();
            bulletContext2 = bulletContext;
            BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, orCreateSessionID, "BulletContextManager : needCreateSchemaData " + z + " forceCreateNewSchemaData " + forceCreateNewSchemaData, null, null, 12, null);
        } else {
            bulletContext2 = bulletContext;
        }
        BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, orCreateSessionID, "BulletContextManager getOrCreateContext cost: " + (System.currentTimeMillis() - currentTimeMillis), null, null, 12, null);
        return bulletContext2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r11 == null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void injectForestUsageInfo(ISchemaMutableData schemaData, String cdnUrl, KitType type) {
        String str;
        IBulletSettingsService iBulletSettingsService;
        ForestSettingsConfig forestSettingsConfig;
        List<String> disallowListLynx;
        List<String> allowListLynx;
        Object obj;
        if (schemaData == null) {
            return;
        }
        Object obj2 = null;
        if (cdnUrl != null) {
            if (!StringsKt.startsWith$default(cdnUrl, "http", false, 2, (Object) null)) {
                cdnUrl = null;
            }
        }
        ISchemaMutableData iSchemaMutableData = schemaData;
        String value = new StringParam(iSchemaMutableData, "channel", "").getValue();
        String value2 = new StringParam(iSchemaMutableData, SchemaConstants.QUERY_KEY_BUNDLE, "").getValue();
        String removePrefix = value2 != null ? StringsKt.removePrefix(value2, "/") : null;
        if (LoaderUtil.INSTANCE.isNotNullOrEmpty(value)) {
            String str2 = removePrefix;
            if (str2 == null || str2.length() == 0) {
                cdnUrl = value + '/' + removePrefix;
                str = cdnUrl;
                if (!(str.length() != 0) || (iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class)) == null || (forestSettingsConfig = (ForestSettingsConfig) iBulletSettingsService.obtainSettings(ForestSettingsConfig.class)) == null) {
                    return;
                }
                disallowListLynx = type != KitType.LYNX ? forestSettingsConfig.getDisallowListLynx() : forestSettingsConfig.getDisallowListWeb();
                if (disallowListLynx != null) {
                    Iterator<T> it = disallowListLynx.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (StringsKt.contains$default(str, (String) obj, false, 2, (Object) null)) {
                                break;
                            }
                        }
                    }
                    if (((String) obj) != null) {
                        schemaData.addParam(SchemaConstants.LOADER_NAME, new StringParam("rl"), true);
                        return;
                    }
                }
                allowListLynx = type != KitType.LYNX ? forestSettingsConfig.getAllowListLynx() : forestSettingsConfig.getAllowListWeb();
                if (allowListLynx == null) {
                    Iterator<T> it2 = allowListLynx.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (StringsKt.contains$default(str, (String) next, false, 2, (Object) null)) {
                            obj2 = next;
                            break;
                        }
                    }
                    if (((String) obj2) != null) {
                        schemaData.addParam(SchemaConstants.LOADER_NAME, new StringParam("forest"), false);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        cdnUrl = "";
        str = cdnUrl;
        if (!(str.length() != 0)) {
            return;
        }
        if (type != KitType.LYNX) {
        }
        if (disallowListLynx != null) {
        }
        if (type != KitType.LYNX) {
        }
        if (allowListLynx == null) {
        }
    }
}
