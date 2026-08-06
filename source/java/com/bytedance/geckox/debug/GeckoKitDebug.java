package com.bytedance.geckox.debug;

import android.net.Uri;
import com.bytedance.geckox.GeckoBuildInManager;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.policy.request.RequestHelper;
import com.bytedance.geckox.strategy.OccasionManager;
import com.bytedance.geckox.utils.ChannelState;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.geckox.utils.UIHandler;
import com.bytedance.iesgurd.core.CacheManager;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.strategy.LoopManager;
import com.bytedance.iesgurd.update.UpdateQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoKitDebug.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0004J\u0014\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190 J\u0016\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006'"}, d2 = {"Lcom/bytedance/geckox/debug/GeckoKitDebug;", "", "()V", "isUnitTest", "", "()Z", "setUnitTest", "(Z)V", "getCacheRootDir", "Ljava/io/File;", "getChannelMetaAks", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getChannelMetaChannes", "accessKey", "getChannelMetaStr", "channel", "getLoopEnable", "getOccasionManagerStr", "getPrepareMetaAks", "getPrepareMetaChannes", "getPrepareMetaStr", "isChannelUsed", "removeCacheBuildIn", "", "removeMetaByAccessKey", "removeMetaByChannel", "resetLoopEnable", "enable", "runOnUIThread", "runnable", "Lkotlin/Function0;", "updateByScan", "uri", "Landroid/net/Uri;", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "updateResource", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoKitDebug {
    public static final GeckoKitDebug INSTANCE = new GeckoKitDebug();
    private static boolean isUnitTest;

    private GeckoKitDebug() {
    }

    public final boolean isUnitTest() {
        return isUnitTest;
    }

    public final void setUnitTest(boolean z) {
        isUnitTest = z;
    }

    public final String getOccasionManagerStr() {
        String json = GsonUtil.INSTANCE.inst().getGson().toJson(OccasionManager.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(json, "GsonUtil.inst().gson().toJson(OccasionManager)");
        return json;
    }

    public final File getCacheRootDir() {
        return CacheManager.INSTANCE.getFileRoot();
    }

    public final boolean getLoopEnable() {
        return LoopManager.INSTANCE.isEnable();
    }

    public final void resetLoopEnable(boolean enable) {
        LoopManager.INSTANCE.resetDebugLoopEnable(enable);
    }

    public final void removeCacheBuildIn(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        GeckoBuildInManager.INSTANCE.removeCache(accessKey, channel);
    }

    public final ArrayList<String> getChannelMetaAks() {
        return new ArrayList<>(CollectionsKt.sorted(ChannelMetaManager.INSTANCE.getAllAccessKeys()));
    }

    public final ArrayList<String> getChannelMetaChannes(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Map metas = ChannelMetaManager.INSTANCE.getMetas(accessKey);
        if (metas == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(CollectionsKt.sorted(metas.keySet()));
    }

    public final String getChannelMetaStr(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel);
        if (meta == null) {
            return null;
        }
        return GsonUtil.INSTANCE.inst().getGson().toJson(meta);
    }

    public final ArrayList<String> getPrepareMetaAks() {
        return new ArrayList<>(CollectionsKt.sorted(PrepareMetaManager.INSTANCE.getMetaMap().keySet()));
    }

    public final ArrayList<String> getPrepareMetaChannes(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Map metas = PrepareMetaManager.INSTANCE.getMetas(accessKey);
        if (metas == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(CollectionsKt.sorted(metas.keySet()));
    }

    public final String getPrepareMetaStr(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(accessKey, channel);
        if (updateMeta == null) {
            return null;
        }
        return GsonUtil.INSTANCE.inst().getGson().toJson(updateMeta);
    }

    public final String updateByScan(Uri uri, GeckoUpdateParams params) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(params, "params");
        String queryParameter = uri.getQueryParameter("access_key");
        String queryParameter2 = uri.getQueryParameter("channel");
        String queryParameter3 = uri.getQueryParameter("version");
        String queryParameter4 = uri.getQueryParameter("url_list");
        String queryParameter5 = uri.getQueryParameter("md5");
        String queryParameter6 = uri.getQueryParameter("package_type");
        String queryParameter7 = uri.getQueryParameter("size");
        String str = queryParameter;
        if (!(str == null || str.length() == 0)) {
            String str2 = queryParameter2;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = queryParameter3;
                if (!(str3 == null || str3.length() == 0)) {
                    String str4 = queryParameter4;
                    if (!(str4 == null || str4.length() == 0)) {
                        String str5 = queryParameter5;
                        if (!(str5 == null || str5.length() == 0)) {
                            String str6 = queryParameter6;
                            if (!(str6 == null || str6.length() == 0)) {
                                String str7 = queryParameter7;
                                if (!(str7 == null || str7.length() == 0)) {
                                    GeckoGlobalManager inst = GeckoGlobalManager.inst();
                                    Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                                    String str8 = inst.getAccessKeyDirs().get(queryParameter);
                                    String str9 = str8;
                                    if (str9 == null || str9.length() == 0) {
                                        return "扫码更新失败, accessKey没有注册, 请先检查Gecko环境是否匹配: " + uri;
                                    }
                                    Long innerGetLatestChannelVersion = ResLoadUtils.innerGetLatestChannelVersion(new File(str8), queryParameter, queryParameter2);
                                    if (innerGetLatestChannelVersion != null) {
                                        if (innerGetLatestChannelVersion.longValue() == Long.parseLong(queryParameter3)) {
                                            return "扫码更新成功, 本地已经是最新版本";
                                        }
                                    }
                                    PrepareMeta prepareMeta = new PrepareMeta(queryParameter, queryParameter2);
                                    if (Integer.parseInt(queryParameter6) == 1) {
                                        prepareMeta.setSingleFile(true);
                                    }
                                    prepareMeta.setFullPackage(new PrepareMetaPackage(Long.parseLong(queryParameter3), queryParameter5, Long.parseLong(queryParameter7), queryParameter4));
                                    prepareMeta.ignoreBlocks();
                                    prepareMeta.setUseZstd(false);
                                    PrepareMetaManager.INSTANCE.addMeta(queryParameter, queryParameter2, prepareMeta);
                                    UpdateQueue.INSTANCE.add(CollectionsKt.listOf(prepareMeta), params);
                                    return "扫码更新, 开始下载: " + queryParameter4;
                                }
                            }
                        }
                    }
                }
            }
        }
        return "扫码更新失败, 参数不合法: " + uri;
    }

    public final void updateResource(GeckoUpdateParams params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        params.setEnableThrottle$geckox_noasanRelease(false);
        RequestHelper.INSTANCE.updateResource(params);
    }

    public final boolean isChannelUsed(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return ChannelState.INSTANCE.isChannelUsed(accessKey, channel);
    }

    public final void removeMetaByChannel(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ChannelMetaManager.INSTANCE.removeChannel(accessKey, channel);
    }

    public final void removeMetaByAccessKey(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        ChannelMetaManager.INSTANCE.removeAccessKey(accessKey);
    }

    public final void runOnUIThread(Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        UIHandler.INSTANCE.runOnUIThread(runnable);
    }
}
