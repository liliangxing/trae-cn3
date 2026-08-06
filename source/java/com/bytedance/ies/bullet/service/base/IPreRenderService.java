package com.bytedance.ies.bullet.service.base;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.HashSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreRenderService.kt */
@Deprecated(message = "内部解耦用的临时接口，随时下线，请勿使用")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 %2\u00020\u0001:\u0001%J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0016J*\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H&Jv\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192L\b\u0002\u0010\u001c\u001aF\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012%\u0012#\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001dH&J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006&"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "", "config", "Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "clearCaches", "", "cacheKeys", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "fetch", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "schema", "Landroid/net/Uri;", "openPreRender", "", "openReUse", "originView", "Landroid/view/View;", "preRender", "context", "Landroid/content/Context;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", "duration", "", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cacheKey", "Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "reUse", "Lcom/bytedance/ies/bullet/service/base/PoolResult;", "reUsedView", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPreRenderService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String QUERY_VIEW_CACHE_KEY = "view_cache_key";

    void clearCaches(HashSet<String> cacheKeys);

    CacheItem fetch(Uri schema, boolean openPreRender, boolean openReUse, View originView);

    IPreRenderConfig getConfig();

    void preRender(Uri schema, Context context, long duration, IPreRenderCallback callback);

    void preRender(Uri schema, Context context, long duration, IPreRenderCallback callback, Function2<? super String, ? super Function2<? super CacheItemStatus, ? super CacheItem, Unit>, Unit> operation);

    void preRender(Uri schema, Context context, IPreRenderCallback callback);

    PoolResult reUse(Uri schema, View reUsedView);

    /* compiled from: IPreRenderService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPreRenderService$Companion;", "", "()V", "QUERY_VIEW_CACHE_KEY", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String QUERY_VIEW_CACHE_KEY = "view_cache_key";

        private Companion() {
        }
    }

    /* compiled from: IPreRenderService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void clearCaches(IPreRenderService iPreRenderService, HashSet<String> cacheKeys) {
            Intrinsics.checkNotNullParameter(cacheKeys, "cacheKeys");
        }

        public static /* synthetic */ void preRender$default(IPreRenderService iPreRenderService, Uri uri, Context context, long j, IPreRenderCallback iPreRenderCallback, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preRender");
            }
            if ((i & 16) != 0) {
                function2 = null;
            }
            iPreRenderService.preRender(uri, context, j, iPreRenderCallback, function2);
        }
    }
}
