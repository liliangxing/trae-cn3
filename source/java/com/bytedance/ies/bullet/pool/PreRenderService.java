package com.bytedance.ies.bullet.pool;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.IPreRenderConfig;
import com.bytedance.ies.bullet.service.base.IPreRenderServiceWithBundle;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.router.RouterServiceKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreRenderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0012j\b\u0012\u0004\u0012\u00020\u0003`\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u000fJ*\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u0004\u0018\u00010\rJ'\u0010\u001f\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0#H\u0002¢\u0006\u0002\u0010$J \u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J(\u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)H\u0016Jt\u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)2J\u0010,\u001aF\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012%\u0012#\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000f\u0018\u00010-H\u0016J(\u0010%\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u00104\u001a\u0002052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ies/bullet/pool/PreRenderService;", "Lcom/bytedance/ies/bullet/service/base/IPreRenderServiceWithBundle;", "bid", "", "config", "Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;)V", "getBid", "()Ljava/lang/String;", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "poolKitMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/pool/PoolKit;", "clear", "", "clearCaches", "cacheKeys", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "createKit", "fetch", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "schema", "Landroid/net/Uri;", "openPreRender", "", "openReUse", "originView", "Landroid/view/View;", "getKit", "getService", "T", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "preRender", "context", "Landroid/content/Context;", "callback", "Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cacheKey", "Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "reUse", "Lcom/bytedance/ies/bullet/service/base/PoolResult;", "reUsedView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PreRenderService implements IPreRenderServiceWithBundle {
    private final String bid;
    private final IPreRenderConfig config;
    private final ConcurrentHashMap<String, PoolKit> poolKitMap;

    public PreRenderService(String str, IPreRenderConfig iPreRenderConfig) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(iPreRenderConfig, "config");
        this.bid = str;
        this.config = iPreRenderConfig;
        this.poolKitMap = new ConcurrentHashMap<>();
        createKit();
    }

    public /* synthetic */ PreRenderService(String str, IPreRenderConfig iPreRenderConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default_bid" : str, iPreRenderConfig);
    }

    public final String getBid() {
        return this.bid;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public IPreRenderConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public void preRender(Uri schema, Context context, IPreRenderCallback callback) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        preRender(schema, context, -1L, callback);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public void preRender(Uri schema, Context context, long duration, IPreRenderCallback callback) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "start to preRender on schema: " + schema + ", duration: " + duration, null, "XPreRender", 2, null);
        preRender(schema, context, duration, callback, new KeyPreRenderOperation(context, schema, this.bid));
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderServiceWithBundle
    public void preRender(Uri schema, Bundle bundle, Context context, IPreRenderCallback callback) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "start to preRender on schema: " + schema + " with bundle, sessionId=" + bundle.getString("__x_session_id"), null, "XPreRender", 2, null);
        KeyPreRenderOperation keyPreRenderOperation = new KeyPreRenderOperation(context, schema, this.bid);
        keyPreRenderOperation.setBundle(bundle);
        Unit unit = Unit.INSTANCE;
        preRender(schema, context, -1L, callback, keyPreRenderOperation);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public void preRender(Uri schema, Context context, long duration, IPreRenderCallback callback, Function2<? super String, ? super Function2<? super CacheItemStatus, ? super CacheItem, Unit>, Unit> operation) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "start to preRender on schema with operation: " + schema + ", duration: " + duration, null, "XPreRender", 2, null);
        createKit();
        PoolKit kit = getKit();
        String queryParameterSafely = RouterServiceKt.getQueryParameterSafely(schema, "view_cache_key");
        if (kit == null || operation == null || queryParameterSafely == null) {
            return;
        }
        kit.preRender(queryParameterSafely, schema, duration, callback, operation);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public PoolResult reUse(Uri schema, View reUsedView) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(reUsedView, "reUsedView");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "start to reUse on schema: " + schema, null, "XPreRender", 2, null);
        PoolKit kit = getKit();
        if (!(reUsedView instanceof BulletContainerView)) {
            reUsedView = null;
        }
        BulletContainerView bulletContainerView = reUsedView != null ? (BulletContainerView) reUsedView : null;
        if (kit != null && bulletContainerView != null) {
            return kit.reUse(schema, bulletContainerView);
        }
        return PoolResult.FAIL_INVALID;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public CacheItem fetch(Uri schema, boolean openPreRender, boolean openReUse, View originView) {
        String str;
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(originView, "originView");
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "start to fetch on schema: " + schema + ", openPreRender: " + openPreRender + ", openReUse: " + openReUse, null, "XPreRender", 2, null);
        PoolKit kit = getKit();
        CacheItem fetch = kit != null ? kit.fetch(schema, openPreRender, openReUse) : null;
        String queryParameterSafely = RouterServiceKt.getQueryParameterSafely(schema, "url");
        if (queryParameterSafely != null) {
            Uri parse = Uri.parse(queryParameterSafely);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(it)");
            str = RouterServiceKt.getQueryParameterSafely(parse, "view_cache_key");
        } else {
            str = null;
        }
        if (fetch == null) {
            return null;
        }
        View view = fetch.getView();
        if (str != null) {
            openPreRender = str.length() > 0;
        }
        if (!PoolUtilKt.replaceView(view, originView, openPreRender, openReUse)) {
            return null;
        }
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "fetch pool cache item success: " + fetch.getView(), null, "XPreRender", 2, null);
        return fetch;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderService
    public void clearCaches(HashSet<String> cacheKeys) {
        Intrinsics.checkNotNullParameter(cacheKeys, "cacheKeys");
        for (String str : cacheKeys) {
            PoolKit kit = getKit();
            if (kit != null) {
                kit.clearCache(str);
            }
        }
    }

    public final void createKit() {
        if (getKit() == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "create pool kit on bid: " + this.bid, null, "XPreRender", 2, null);
            this.poolKitMap.put(this.bid, new PoolKit(getConfig(), this.bid));
        }
    }

    public final PoolKit getKit() {
        return this.poolKitMap.get(this.bid);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreRenderServiceWithBundle
    public void clear() {
        PoolKit poolKit = this.poolKitMap.get(this.bid);
        if (poolKit != null) {
            PoolKit.clearAll$default(poolKit, null, 1, null);
        }
    }

    private final <T extends IBulletService> T getService(Class<T> clazz) {
        return (T) ServiceCenter.INSTANCE.instance().get(this.bid, clazz);
    }
}
