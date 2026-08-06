package com.bytedance.iesgurd.clean;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.lock.ResLockManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.ResVersionUtils;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdObserver;
import com.bytedance.iesgurd.IESGurdObserverCleanInfo;
import com.bytedance.iesgurd.core.CacheManager;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.model.CleanTask;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.iesgurd.statistic.model.StatisticCleanData;
import com.bytedance.iesgurd.sync.SyncCleanModel;
import com.bytedance.iesgurd.sync.SyncCleanPolicy;
import com.bytedance.iesgurd.update.UpdateQueue;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CleanManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u00020\u00042 \u0010!\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0\u000f\u0018\u00010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/iesgurd/clean/CleanManager;", "", "()V", "callbackWhenClean", "", "accessKey", "", "channel", "checkChannelNeedDelete", "cleanAllCache", "cleanAllVersion", "", "channelPath", "cleanByPush", "universalStrategies", "", "Lcom/bytedance/iesgurd/sync/SyncCleanModel;", "cleanCache", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", "strategy", "Lcom/bytedance/iesgurd/statistic/model/CleanStrategy;", "type", "", "cleanOldVersion", "newVersion", "(Ljava/lang/String;Ljava/lang/Long;)I", "doCleanOldVersion", "subDirs", "", "Ljava/io/File;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)I", "handleCleanTasks", "cleanTasks", "Lcom/bytedance/iesgurd/model/CleanTask;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CleanManager {
    public static final CleanManager INSTANCE = new CleanManager();

    private CleanManager() {
    }

    public final void callbackWhenClean(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        try {
            GeckoUpdateListener.GeckoParams geckoParams = new GeckoUpdateListener.GeckoParams(accessKey, channel, 0L);
            Iterator it = ListenerManager.INSTANCE.getListeners().iterator();
            while (it.hasNext()) {
                ((GeckoUpdateListener) it.next()).onCleanRes(geckoParams);
            }
        } catch (Throwable th) {
            GeckoLogger.w("GeckoUpdateListener onCleanRes exception: " + th.getMessage() + '-' + th.getStackTrace());
        }
        IESGurdObserverCleanInfo iESGurdObserverCleanInfo = new IESGurdObserverCleanInfo(accessKey, channel);
        Iterator<Map.Entry<String, IESGurdObserver>> it2 = IESGurdKit.INSTANCE.getObservers$geckox_noasanRelease().entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onResClean(iESGurdObserverCleanInfo);
        }
    }

    public final void cleanCache(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (accessKey.length() == 0) {
            return;
        }
        if (channel.length() == 0) {
            return;
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        if (str != null) {
            GeckoLogger.d("IESGurdKit.cleanCache: " + accessKey + '-' + channel);
            ChannelMetaManager.INSTANCE.removeChannel(accessKey, channel);
            FileUtils.delete(new File(str + File.separator + accessKey + File.separator + channel));
            new StatisticCleanData(CleanStrategy.BUSINESS_CALL, 1, accessKey, channel, 0L, 0, 0, null, 240, null).upload();
            callbackWhenClean(accessKey, channel);
        }
    }

    public final void cleanCache(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        if (accessKey.length() == 0) {
            return;
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        if (str != null) {
            GeckoLogger.d("IESGurdKit.cleanCache: " + accessKey);
            ChannelMetaManager.INSTANCE.removeAccessKey(accessKey);
            FileUtils.delete(new File(str + File.separator + accessKey));
            new StatisticCleanData(CleanStrategy.BUSINESS_CALL, 2, accessKey, null, 0L, 0, 0, null, 248, null).upload();
        }
    }

    public final void cleanAllCache() {
        GeckoLogger.d("IESGurdKit.cleanAllCache");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        Map accessKeyDirs = inst.getAccessKeyDirs();
        Intrinsics.checkExpressionValueIsNotNull(accessKeyDirs, "GeckoGlobalManager.inst().accessKeyDirs");
        for (Map.Entry entry : accessKeyDirs.entrySet()) {
            ChannelMetaManager channelMetaManager = ChannelMetaManager.INSTANCE;
            Object key = entry.getKey();
            Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
            channelMetaManager.removeAccessKey((String) key);
            FileUtils.delete(new File((String) entry.getValue()));
        }
        new StatisticCleanData(CleanStrategy.BUSINESS_CALL, 3, null, null, 0L, 0, 0, null, 252, null).upload();
    }

    public final void handleCleanTasks(Map<String, ? extends Map<String, CleanTask>> cleanTasks) {
        if (cleanTasks == null || cleanTasks.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ? extends Map<String, CleanTask>> entry : cleanTasks.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<String, CleanTask> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                CleanTask value = entry2.getValue();
                List<Long> cleanPackages = value.getCleanPackages();
                if (cleanPackages != null) {
                    Iterator<T> it = cleanPackages.iterator();
                    while (it.hasNext()) {
                        INSTANCE.cleanCache(key, key2, ((Number) it.next()).longValue(), CleanStrategy.CHECK_UPDATE, 0);
                    }
                }
                List<Long> closePackages = value.getClosePackages();
                if (closePackages != null) {
                    Iterator<T> it2 = closePackages.iterator();
                    while (it2.hasNext()) {
                        PrepareMetaManager.INSTANCE.removeUpdateMeta(key, key2, Long.valueOf(((Number) it2.next()).longValue()));
                    }
                }
                INSTANCE.checkChannelNeedDelete(key, key2);
                ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(key, key2);
                if (meta != null) {
                    List<Long> forbiddenPackages = value.getForbiddenPackages();
                    if (forbiddenPackages != null) {
                        Iterator<T> it3 = forbiddenPackages.iterator();
                        while (it3.hasNext()) {
                            long longValue = ((Number) it3.next()).longValue();
                            Long id = meta.getId();
                            if (id != null && id.longValue() == longValue && !meta.getForbidden()) {
                                GeckoLogger.d("forbidden channel: " + key + '-' + key2 + '-' + longValue);
                                meta.setForbidden(true);
                                ChannelMetaManager.INSTANCE.saveMeta(key, key2, meta);
                                INSTANCE.callbackWhenClean(key, key2);
                            }
                        }
                    }
                    List<Long> unforbiddenPackages = value.getUnforbiddenPackages();
                    if (unforbiddenPackages != null) {
                        Iterator<T> it4 = unforbiddenPackages.iterator();
                        while (it4.hasNext()) {
                            long longValue2 = ((Number) it4.next()).longValue();
                            Long id2 = meta.getId();
                            if (id2 != null && id2.longValue() == longValue2 && meta.getForbidden()) {
                                GeckoLogger.d("unforbidden channel: " + key + '-' + key2 + '-' + longValue2);
                                meta.setForbidden(false);
                                ChannelMetaManager.INSTANCE.saveMeta(key, key2, meta);
                            }
                        }
                    }
                }
            }
        }
        CacheManager.INSTANCE.deletePendingFiles();
    }

    private final void cleanCache(String accessKey, String channel, long version, CleanStrategy strategy, int type) {
        File file;
        int i;
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        if (str != null) {
            Long valueOf = Long.valueOf(version);
            if (version == 0) {
                ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel);
                valueOf = meta != null ? meta.getId() : null;
                file = new File(str + '/' + accessKey + '/' + channel);
                PrepareMetaManager.INSTANCE.removeUpdateMeta(accessKey, channel, null);
                ChannelMetaManager.INSTANCE.removeChannel(accessKey, channel);
                MetaDataManager.INSTANCE.removeChannelFromMetaData(accessKey, channel);
            } else {
                file = new File(str + '/' + accessKey + '/' + channel + '/' + version);
                PrepareMetaManager.INSTANCE.removeUpdateMeta(accessKey, channel, Long.valueOf(version));
                ChannelMetaManager.INSTANCE.removeVersion(accessKey, channel, version);
            }
            if (file.exists()) {
                if (CacheManager.INSTANCE.renameFileToPending(file)) {
                    if (valueOf != null) {
                        valueOf.longValue();
                        INSTANCE.callbackWhenClean(accessKey, channel);
                    }
                    i = 200;
                } else {
                    i = 201;
                }
                new StatisticCleanData(strategy, type, accessKey, channel, version, i, 0, null, 192, null).upload();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        if ((r6.length == 0) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void checkChannelNeedDelete(String accessKey, String channel) {
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        String str2 = str;
        boolean z = false;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        File file = new File(str + '/' + accessKey + '/' + channel);
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.iesgurd.clean.CleanManager$checkChannelNeedDelete$files$1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                Intrinsics.checkExpressionValueIsNotNull(file2, "f");
                return file2.isDirectory();
            }
        });
        if (listFiles != null) {
        }
        z = true;
        if (z) {
            FileUtils.delete(file);
        }
    }

    public final boolean cleanAllVersion(String channelPath) {
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        if (!ResLockManager.INSTANCE.writeTryLock(channelPath)) {
            return false;
        }
        boolean delete = FileUtils.delete(new File(channelPath));
        ResLockManager.INSTANCE.writeUnlock(channelPath);
        return delete;
    }

    public final int cleanOldVersion(String channelPath, Long newVersion) {
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        File file = new File(channelPath);
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            if (!(listFiles.length == 0)) {
                z = false;
            }
        }
        if (z) {
            file.delete();
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            Intrinsics.checkExpressionValueIsNotNull(file2, "pathname");
            if (file2.isDirectory()) {
                arrayList.add(file2);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty() || !ResLockManager.INSTANCE.writeTryLock(channelPath)) {
            return 0;
        }
        int doCleanOldVersion = doCleanOldVersion(channelPath, arrayList2, newVersion);
        ResLockManager.INSTANCE.writeUnlock(channelPath);
        if (doCleanOldVersion > 0) {
            CacheManager.INSTANCE.deletePendingFiles();
        }
        GeckoLogger.d("channel version delete: " + channelPath + ", newVersion: " + newVersion + ", deleteCount: " + doCleanOldVersion);
        return doCleanOldVersion;
    }

    private final int doCleanOldVersion(String channelPath, List<? extends File> subDirs, Long newVersion) {
        ChannelMeta meta;
        Long id;
        List split$default = StringsKt.split$default(channelPath, new String[]{"/"}, false, 0, 6, (Object) null);
        if (split$default.size() < 2) {
            return 0;
        }
        String str = (String) split$default.get(split$default.size() - 2);
        String str2 = (String) split$default.get(split$default.size() - 1);
        String valueOf = String.valueOf(newVersion);
        if (newVersion == null && (meta = ChannelMetaManager.INSTANCE.getMeta(str, str2)) != null && (id = meta.getId()) != null) {
            valueOf = String.valueOf(id.longValue());
        }
        int i = 0;
        for (File file : subDirs) {
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "verName");
            if (StringsKt.endsWith$default(name, "--updating", false, 2, (Object) null)) {
                if (!UpdateQueue.INSTANCE.checkIsUpdating(str, str2)) {
                    CacheManager.INSTANCE.renameFileToPending(file);
                    i++;
                }
            } else if (!Intrinsics.areEqual(name, valueOf)) {
                CacheManager.INSTANCE.renameFileToPending(file);
                i++;
            }
        }
        return i;
    }

    public final void cleanByPush(Map<String, SyncCleanModel> universalStrategies) {
        List<SyncCleanPolicy> specifiedClean;
        Intrinsics.checkParameterIsNotNull(universalStrategies, "universalStrategies");
        for (Map.Entry<String, SyncCleanModel> entry : universalStrategies.entrySet()) {
            String key = entry.getKey();
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            String str = (String) inst.getAccessKeyDirs().get(key);
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                File file = new File(str, key);
                if (file.isDirectory() && (specifiedClean = entry.getValue().getSpecifiedClean()) != null) {
                    for (SyncCleanPolicy syncCleanPolicy : specifiedClean) {
                        String channel = syncCleanPolicy.getChannel();
                        if (channel != null) {
                            int cleanType = syncCleanPolicy.getCleanType();
                            List<Long> versions = syncCleanPolicy.getVersions();
                            if (cleanType == 1) {
                                if (versions != null) {
                                    Iterator<T> it = versions.iterator();
                                    while (it.hasNext()) {
                                        INSTANCE.cleanCache(key, channel, ((Number) it.next()).longValue(), CleanStrategy.PUSH, cleanType);
                                    }
                                }
                                INSTANCE.checkChannelNeedDelete(key, channel);
                            } else if (cleanType == 2) {
                                List<Long> list = versions;
                                if (!(list == null || list.isEmpty())) {
                                    List<Long> allVersion = ResVersionUtils.getAllVersion(new File(file, channel));
                                    if (allVersion != null) {
                                        for (Long l : allVersion) {
                                            long longValue = versions.get(0).longValue();
                                            Intrinsics.checkExpressionValueIsNotNull(l, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
                                            if (longValue > l.longValue()) {
                                                INSTANCE.cleanCache(key, channel, l.longValue(), CleanStrategy.PUSH, cleanType);
                                            }
                                        }
                                    }
                                    INSTANCE.checkChannelNeedDelete(key, channel);
                                }
                            } else if (cleanType == 3) {
                                INSTANCE.cleanCache(key, channel, 0L, CleanStrategy.PUSH, cleanType);
                            }
                        }
                    }
                }
            }
        }
        CacheManager.INSTANCE.deletePendingFiles();
    }
}
