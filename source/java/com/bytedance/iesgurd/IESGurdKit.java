package com.bytedance.iesgurd;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.geckox.GeckoBuildInManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.request.RequestHelper;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.iesgurd.clean.AccessKeyCacheManager;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.loader.ResLoader;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.sync.SyncManager;
import com.bytedance.notification.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IESGurdKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000eJ\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eJ\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eJ&\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\"\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130%J\"\u0010'\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130%J\"\u0010(\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130%J\u0016\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u0016\u00104\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u00105\u001a\u000206J\u0015\u00107\u001a\u00020\u00132\u0006\u0010\"\u001a\u000208H\u0000¢\u0006\u0002\b9R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006:"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdKit;", "", "()V", "BYTE_SYNC_ID_BOE", "", "BYTE_SYNC_ID_ONLINE", "debuggable", "", "getDebuggable", "()Z", "debuggable$delegate", "Lkotlin/Lazy;", "observers", "", "", "Lcom/bytedance/iesgurd/IESGurdObserver;", "getObservers$geckox_noasanRelease", "()Ljava/util/Map;", "addObserver", "", Constants.NOTIFICATION_TAG, "observer", "checkResExistOnlyOffline", "accessKey", "channel", "cleanAllCache", "cleanCache", "decompressChannelBuildIn", "Lcom/bytedance/geckox/GeckoBuildInManager$GeckoBuildInPath;", "context", "Landroid/content/Context;", "getBundlePathBuildIn", SchemaConstants.QUERY_KEY_BUNDLE, "getResData", "params", "Lcom/bytedance/iesgurd/IESGurdResParams;", "callback", "Lkotlin/Function1;", "Lcom/bytedance/iesgurd/IESGurdResData;", "getResPath", "getResPathIgnoreAccess", "getResVersionOnlyOffline", "", "handleByteSyncMessage", "data", "", "handleScanResult", "uri", "Landroid/net/Uri;", "isGkxApi", "url", "removeObserver", "setCacheConfig", "config", "Lcom/bytedance/iesgurd/AccessKeyCacheConfig;", "updateResource", "Lcom/bytedance/geckox/GeckoUpdateParams;", "updateResource$geckox_noasanRelease", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IESGurdKit {
    public static final int BYTE_SYNC_ID_BOE = 57;
    public static final int BYTE_SYNC_ID_ONLINE = 8;
    public static final IESGurdKit INSTANCE = new IESGurdKit();
    private static final Map<String, IESGurdObserver> observers = new ConcurrentHashMap();

    /* renamed from: debuggable$delegate, reason: from kotlin metadata */
    private static final Lazy debuggable = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.iesgurd.IESGurdKit$debuggable$2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(m641invoke());
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final boolean m641invoke() {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Class.forName("com.bytedance.geckox.debugtool.ui.GeckoDebugMenuActivity"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return Result.isSuccess-impl(obj);
        }
    });

    private final boolean getDebuggable() {
        return ((Boolean) debuggable.getValue()).booleanValue();
    }

    private IESGurdKit() {
    }

    public final Map<String, IESGurdObserver> getObservers$geckox_noasanRelease() {
        return observers;
    }

    public final void updateResource$geckox_noasanRelease(GeckoUpdateParams params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        RequestHelper.INSTANCE.updateResource(params);
    }

    public final long getResVersionOnlyOffline(String accessKey, String channel) {
        ChannelMeta meta;
        Long checkLatestVersion;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (accessKey.length() == 0) {
            return 0L;
        }
        if ((channel.length() == 0) || (meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel)) == null || meta.getForbidden() || (checkLatestVersion = ChannelMetaManager.INSTANCE.checkLatestVersion(accessKey, channel, meta, "")) == null) {
            return 0L;
        }
        return checkLatestVersion.longValue();
    }

    public final boolean checkResExistOnlyOffline(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return getResVersionOnlyOffline(accessKey, channel) > 0;
    }

    public final void getResData(IESGurdResParams params, Function1<? super IESGurdResData, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        new ResLoader(params, callback).getData();
    }

    public final void getResPath(IESGurdResParams params, Function1<? super IESGurdResData, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        new ResLoader(params, callback).getPath();
    }

    public final void getResPathIgnoreAccess(IESGurdResParams params, Function1<? super IESGurdResData, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        new ResLoader(params, callback).getPathIgnoreAccess();
    }

    public final void addObserver(String tag, IESGurdObserver observer) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        Map<String, IESGurdObserver> map = observers;
        if (map.get(tag) != null) {
            GeckoLogger.w("observer with " + tag + " already exist");
        } else {
            GeckoLogger.d("add observer: " + tag);
            map.put(tag, observer);
        }
    }

    public final void removeObserver(String tag) {
        Intrinsics.checkParameterIsNotNull(tag, Constants.NOTIFICATION_TAG);
        GeckoLogger.d("remove observer: " + tag);
        observers.remove(tag);
    }

    public final void setCacheConfig(String accessKey, AccessKeyCacheConfig config) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(config, "config");
        AccessKeyCacheManager.INSTANCE.setConfig(accessKey, config);
    }

    public final void cleanCache(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        CleanManager.INSTANCE.cleanCache(accessKey, channel);
    }

    public final void cleanCache(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        CleanManager.INSTANCE.cleanCache(accessKey);
    }

    public final void cleanAllCache() {
        CleanManager.INSTANCE.cleanAllCache();
    }

    public final GeckoBuildInManager.GeckoBuildInPath decompressChannelBuildIn(Context context, String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return GeckoBuildInManager.INSTANCE.decompressChannel(context, accessKey, channel);
    }

    public final GeckoBuildInManager.GeckoBuildInPath getBundlePathBuildIn(Context context, String accessKey, String channel, String bundle) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        return GeckoBuildInManager.INSTANCE.getBuildInPath(context, accessKey, channel, bundle);
    }

    public final void handleByteSyncMessage(byte[] data) {
        SyncManager.INSTANCE.handleMessage(data);
    }

    public final boolean handleScanResult(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        if (!getDebuggable()) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            IESGurdKit iESGurdKit = this;
            Result.constructor-impl(Class.forName("com.bytedance.geckox.debugtool.GeckoDebugTool", false, Application.class.getClassLoader()).getDeclaredMethod("handleScanResult", Uri.class).invoke(null, uri));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return true;
    }

    public final boolean isGkxApi(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        String str = url;
        return StringsKt.contains$default(str, "/gkx/api/settings/v3", false, 2, (Object) null) || StringsKt.contains$default(str, "/gkx/api/resource/v7/custom", false, 2, (Object) null) || StringsKt.contains$default(str, "/gkx/api/resource/v7/coldstart", false, 2, (Object) null) || StringsKt.contains$default(str, "/gkx/api/resource/v7/polling", false, 2, (Object) null);
    }
}
