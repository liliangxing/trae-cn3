package com.bytedance.geckox.policy.meta;

import android.os.Looper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTask;
import com.bytedance.geckox.utils.CloseableUtils;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.ResVersionUtils;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.iesgurd.statistic.model.StatisticCleanData;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetaDataManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J(\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006J0\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0018JD\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00102\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0015\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J&\u0010%\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010+J\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100-2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u001c\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010/\u001a\u000200J\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u001a\u00102\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010)\u001a\u0004\u0018\u00010\u0010J\u0016\u00103\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J\u0016\u00104\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J*\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0004J\b\u00107\u001a\u000200H\u0002J\b\u00108\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/geckox/policy/meta/MetaDataManager;", "", "()V", "DELAY_TIME", "", "INITIATIVE_CLEAN_TYPE", "", "INTERVAL_TIME", "PASSIVE_CLEAN_TYPE", "handlerTimerTask", "Lcom/bytedance/geckox/task/HandlerTimerTask;", "mainLooper", "Landroid/os/Looper;", "kotlin.jvm.PlatformType", "metaDataMap", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/geckox/policy/meta/MetaDataItemNew;", "getMetaDataMap", "()Ljava/util/Map;", "metaFileMap", "Ljava/io/File;", "metaTagMap", "", "checkMetaFileExists", "accessKey", "cleanGeckoResource", "needClean", "expireAge", "cleanType", "writeImmediately", "cleanWithChannelMetaData", "channelMetaData", "", "timeStamp", "createMetaFile", "filterMetaDataUpdate", "updatePackage", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "filterMetaDataUpdate$geckox_noasanRelease", "channel", "groups", "", "getBlockChannelData", "Lkotlin/Pair;", "getStoredMetaData", "initMetaData", "", "initMetaDataWithCleanChannels", "isBlocklistChannel", "removeChannelFromMetaData", "removeFromBlock", "resourceAccessUpdateMetaData", "accessTime", "writeMetaDataImmediately", "writeToMetaData", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MetaDataManager {
    private static final long DELAY_TIME = 2000;
    public static final int INITIATIVE_CLEAN_TYPE = 5;
    private static final long INTERVAL_TIME = 120000;
    public static final int PASSIVE_CLEAN_TYPE = 4;
    public static final MetaDataManager INSTANCE = new MetaDataManager();
    private static final Map<String, ConcurrentHashMap<String, MetaDataItemNew>> metaDataMap = new ConcurrentHashMap();
    private static final Map<String, File> metaFileMap = new ConcurrentHashMap();
    private static final Map<String, Boolean> metaTagMap = new ConcurrentHashMap();
    private static final HandlerTimerTask handlerTimerTask = new HandlerTimerTask("meta-timer-task", 3);
    private static final Looper mainLooper = Looper.getMainLooper();

    public final boolean filterMetaDataUpdate(String accessKey, String channel, List<String> groups) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return false;
    }

    private MetaDataManager() {
    }

    public final Map<String, ConcurrentHashMap<String, MetaDataItemNew>> getMetaDataMap() {
        return metaDataMap;
    }

    public final Pair<Integer, String> getBlockChannelData(String accessKey) {
        String str = accessKey;
        int i = 0;
        String str2 = "";
        if (str == null || str.length() == 0) {
            return new Pair<>(0, "");
        }
        ConcurrentHashMap<String, MetaDataItemNew> storedMetaData = getStoredMetaData(accessKey);
        if (storedMetaData != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (Map.Entry<String, MetaDataItemNew> entry : storedMetaData.entrySet()) {
                String key = entry.getKey();
                if (!entry.getValue().getAllowUpdate()) {
                    i2++;
                    sb.append(",").append(key);
                }
            }
            if (sb.length() > 0) {
                sb.append(",");
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            i = i2;
            str2 = sb2;
        }
        return new Pair<>(Integer.valueOf(i), str2);
    }

    public final boolean isBlocklistChannel(String accessKey, String channel) {
        ConcurrentHashMap<String, MetaDataItemNew> storedMetaData;
        String str = accessKey;
        if (!(str == null || str.length() == 0)) {
            String str2 = channel;
            if (!(str2 == null || str2.length() == 0) && (storedMetaData = getStoredMetaData(accessKey)) != null) {
                MetaDataItemNew metaDataItemNew = storedMetaData.get(channel);
                return (metaDataItemNew == null || metaDataItemNew.getAllowUpdate()) ? false : true;
            }
        }
        return false;
    }

    public final void initMetaData() {
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        final Map<String, String> cleanGroupMap = inst.getCleanGroupMap();
        if (cleanGroupMap != null) {
            handlerTimerTask.schedule(new HandlerTask<Void>() { // from class: com.bytedance.geckox.policy.meta.MetaDataManager$initMetaData$task$1
                @Override // com.bytedance.geckox.task.HandlerTask
                public int taskType() {
                    return 5;
                }

                @Override // com.bytedance.geckox.task.HandlerTask
                public void execute() {
                    for (String str : cleanGroupMap.keySet()) {
                        MetaDataManager metaDataManager = MetaDataManager.INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(str, "accessKey");
                        metaDataManager.getStoredMetaData(str);
                    }
                }
            }, 0L);
        }
        writeToMetaData();
    }

    public final boolean filterMetaDataUpdate$geckox_noasanRelease(PrepareMeta updatePackage) {
        ConcurrentHashMap<String, MetaDataItemNew> storedMetaData;
        Intrinsics.checkParameterIsNotNull(updatePackage, "updatePackage");
        long currentTimeMillis = System.currentTimeMillis();
        String accessKey = updatePackage.getAccessKey();
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        Map<String, String> cleanGroupMap = inst.getCleanGroupMap();
        String str = cleanGroupMap != null ? cleanGroupMap.get(accessKey) : null;
        if (str == null || (storedMetaData = INSTANCE.getStoredMetaData(accessKey)) == null) {
            return false;
        }
        String channel = updatePackage.getChannel();
        List groups = updatePackage.getGroups();
        if (groups != null && groups.contains(str)) {
            if (storedMetaData.get(channel) == null) {
                storedMetaData.put(channel, new MetaDataItemNew(currentTimeMillis, false, 0L, 6, null));
                metaTagMap.put(accessKey, true);
                return false;
            }
            if (updatePackage.getInQueue()) {
                return false;
            }
            MetaDataItemNew metaDataItemNew = storedMetaData.get(channel);
            if (metaDataItemNew == null) {
                Intrinsics.throwNpe();
            }
            return !metaDataItemNew.getAllowUpdate();
        }
        if (storedMetaData.get(channel) == null) {
            return false;
        }
        storedMetaData.remove(channel);
        metaTagMap.put(accessKey, true);
        return false;
    }

    public final Pair<Boolean, Long> resourceAccessUpdateMetaData(String accessKey, String channel, long accessTime) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, MetaDataItemNew> storedMetaData = getStoredMetaData(accessKey);
        long j = 0;
        if (storedMetaData == null || storedMetaData.get(channel) == null) {
            return new Pair<>(false, 0L);
        }
        MetaDataItemNew metaDataItemNew = storedMetaData.get(channel);
        if (metaDataItemNew == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(metaDataItemNew, "channelMetaData[channel]!!");
        MetaDataItemNew metaDataItemNew2 = metaDataItemNew;
        metaDataItemNew2.setLastReadTimeStamp(accessTime);
        metaTagMap.put(accessKey, true);
        boolean z = !metaDataItemNew2.getAllowUpdate();
        if (z && metaDataItemNew2.getLastCleanTimeStamp() > 0) {
            j = accessTime - metaDataItemNew2.getLastCleanTimeStamp();
        }
        return new Pair<>(Boolean.valueOf(z), Long.valueOf(j));
    }

    public final void removeFromBlock(String accessKey, String channel) {
        MetaDataItemNew metaDataItemNew;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, MetaDataItemNew> storedMetaData = getStoredMetaData(accessKey);
        if (storedMetaData == null || (metaDataItemNew = storedMetaData.get(channel)) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(metaDataItemNew, "getStoredMetaData(access…)?.get(channel) ?: return");
        if (metaDataItemNew.getAllowUpdate()) {
            return;
        }
        metaDataItemNew.setAllowUpdate(true);
        metaTagMap.put(accessKey, true);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [boolean] */
    public final ConcurrentHashMap<String, MetaDataItemNew> getStoredMetaData(String accessKey) {
        Set<String> keySet;
        ConcurrentHashMap<String, MetaDataItemNew> concurrentHashMap;
        MetaDataManager metaDataManager;
        ?? checkMetaFileExists;
        ConcurrentHashMap<String, MetaDataItemNew> initMetaDataWithCleanChannels;
        ObjectInputStream objectInputStream;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        Map<String, String> cleanGroupMap = inst.getCleanGroupMap();
        Object obj = null;
        if (cleanGroupMap != null && (keySet = cleanGroupMap.keySet()) != null && keySet.contains(accessKey)) {
            GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
            String str = inst2.getAccessKeyDirs().get(accessKey);
            if (str != null) {
                Map<String, ConcurrentHashMap<String, MetaDataItemNew>> map = metaDataMap;
                if (map.get(accessKey) == null) {
                    if (Intrinsics.areEqual(Looper.myLooper(), mainLooper)) {
                        return null;
                    }
                    synchronized (map) {
                        if (map.get(accessKey) == null) {
                            try {
                                try {
                                    metaDataManager = INSTANCE;
                                    checkMetaFileExists = metaDataManager.checkMetaFileExists(accessKey);
                                } catch (Exception e) {
                                    e = e;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                if (checkMetaFileExists != 0) {
                                    File file = metaFileMap.get(accessKey);
                                    if (file == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                                    Object readObject = objectInputStream.readObject();
                                    if (readObject instanceof ConcurrentHashMap) {
                                        obj = readObject;
                                    }
                                    concurrentHashMap = (ConcurrentHashMap) obj;
                                    if (concurrentHashMap == null) {
                                        concurrentHashMap = metaDataManager.initMetaDataWithCleanChannels(accessKey);
                                    } else {
                                        AppSettingsManager inst3 = AppSettingsManager.inst();
                                        Intrinsics.checkExpressionValueIsNotNull(inst3, "AppSettingsManager.inst()");
                                        Map<String, ArrayList<String>> cleanChannels = inst3.getCleanChannels();
                                        if (cleanChannels != null && cleanChannels.get(accessKey) != null) {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            ArrayList<String> arrayList = cleanChannels.get(accessKey);
                                            if (arrayList == null) {
                                                Intrinsics.throwNpe();
                                            }
                                            Iterator<String> it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                String next = it.next();
                                                if (concurrentHashMap.get(next) == null) {
                                                    MetaDataItemNew metaDataItemNew = new MetaDataItemNew(currentTimeMillis, false, 0L, 6, null);
                                                    Intrinsics.checkExpressionValueIsNotNull(next, "channel");
                                                    concurrentHashMap.put(next, metaDataItemNew);
                                                    metaTagMap.put(accessKey, true);
                                                }
                                            }
                                        }
                                    }
                                    metaDataMap.put(accessKey, concurrentHashMap);
                                } else {
                                    File file2 = new File(str + File.separator + accessKey + File.separator + "metaData.json");
                                    if (file2.exists()) {
                                        UploadStatistic.INSTANCE.uploadEvent(EventSubType.META_DATA_MOVE, accessKey, "", 0L);
                                        objectInputStream = new ObjectInputStream(new FileInputStream(file2));
                                        initMetaDataWithCleanChannels = new ConcurrentHashMap<>();
                                        map.put(accessKey, initMetaDataWithCleanChannels);
                                        Object readObject2 = objectInputStream.readObject();
                                        if (readObject2 instanceof ConcurrentHashMap) {
                                            obj = readObject2;
                                        }
                                        ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) obj;
                                        if (concurrentHashMap2 == null) {
                                            ConcurrentHashMap<String, MetaDataItemNew> initMetaDataWithCleanChannels2 = metaDataManager.initMetaDataWithCleanChannels(accessKey);
                                            CloseableUtils.close(objectInputStream);
                                            return initMetaDataWithCleanChannels2;
                                        }
                                        for (Map.Entry entry : concurrentHashMap2.entrySet()) {
                                            String str2 = (String) entry.getKey();
                                            MetaDataItem metaDataItem = (MetaDataItem) entry.getValue();
                                            initMetaDataWithCleanChannels.put(str2, new MetaDataItemNew(metaDataItem.getLastReadTimeStamp(), metaDataItem.getAllowUpdate(), 0L, 4, null));
                                        }
                                        metaTagMap.put(accessKey, true);
                                        INSTANCE.writeMetaDataImmediately();
                                    } else {
                                        initMetaDataWithCleanChannels = metaDataManager.initMetaDataWithCleanChannels(accessKey);
                                        objectInputStream = null;
                                    }
                                    concurrentHashMap = initMetaDataWithCleanChannels;
                                }
                                CloseableUtils.close(objectInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                obj = checkMetaFileExists;
                                UploadStatistic.INSTANCE.uploadEvent(EventSubType.BLOCK_IO_ERROR, e.getMessage(), "", 0L);
                                ConcurrentHashMap<String, MetaDataItemNew> initMetaDataWithCleanChannels3 = INSTANCE.initMetaDataWithCleanChannels(accessKey);
                                CloseableUtils.close((Closeable) obj);
                                concurrentHashMap = initMetaDataWithCleanChannels3;
                                return concurrentHashMap;
                            } catch (Throwable th2) {
                                th = th2;
                                obj = checkMetaFileExists;
                                CloseableUtils.close((Closeable) obj);
                                throw th;
                            }
                            return concurrentHashMap;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return map.get(accessKey);
            }
        }
        return null;
    }

    private final ConcurrentHashMap<String, MetaDataItemNew> initMetaDataWithCleanChannels(String accessKey) {
        FileUtils.delete(metaFileMap.get(accessKey));
        StringBuilder sb = new StringBuilder();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        FileUtils.delete(new File(sb.append(inst.getAccessKeyDirs().get(accessKey)).append(File.separator).append(accessKey).append(File.separator).append("metaData.json").toString()));
        AppSettingsManager inst2 = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst2, "AppSettingsManager.inst()");
        Map<String, ArrayList<String>> cleanChannels = inst2.getCleanChannels();
        ConcurrentHashMap<String, MetaDataItemNew> concurrentHashMap = new ConcurrentHashMap<>();
        metaDataMap.put(accessKey, concurrentHashMap);
        if (cleanChannels != null && cleanChannels.get(accessKey) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList = cleanChannels.get(accessKey);
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                MetaDataItemNew metaDataItemNew = new MetaDataItemNew(currentTimeMillis, false, 0L, 6, null);
                Intrinsics.checkExpressionValueIsNotNull(next, "channel");
                concurrentHashMap.put(next, metaDataItemNew);
            }
            metaTagMap.put(accessKey, true);
        }
        return concurrentHashMap;
    }

    private final void writeToMetaData() {
        handlerTimerTask.schedule(new HandlerTask<Void>() { // from class: com.bytedance.geckox.policy.meta.MetaDataManager$writeToMetaData$task$1
            @Override // com.bytedance.geckox.task.HandlerTask
            public int taskType() {
                return 5;
            }

            @Override // com.bytedance.geckox.task.HandlerTask
            public void execute() {
                MetaDataManager.INSTANCE.writeMetaDataImmediately();
            }
        }, DELAY_TIME, 120000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeMetaDataImmediately() {
        for (Map.Entry<String, Boolean> entry : metaTagMap.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                Map<String, ConcurrentHashMap<String, MetaDataItemNew>> map = metaDataMap;
                if (map.get(key) != null) {
                    metaTagMap.put(key, false);
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        if (!checkMetaFileExists(key)) {
                            createMetaFile(key);
                        }
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(metaFileMap.get(key)));
                        try {
                            objectOutputStream2.writeObject(map.get(key));
                            StringBuilder sb = new StringBuilder();
                            GeckoGlobalManager inst = GeckoGlobalManager.inst();
                            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                            FileUtils.delete(new File(sb.append(inst.getAccessKeyDirs().get(key)).append(File.separator).append(key).append(File.separator).append("metaData.json").toString()));
                            CloseableUtils.close(objectOutputStream2);
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = objectOutputStream2;
                            try {
                                GeckoLogger.m296d("MetaDataManager: writeToMetaData occurs exception: " + th.getMessage());
                            } finally {
                                CloseableUtils.close(objectOutputStream);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final boolean checkMetaFileExists(String accessKey) {
        Map<String, File> map = metaFileMap;
        if (map.get(accessKey) != null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        File file = new File(sb.append(inst.getAccessKeyDirs().get(accessKey)).append(File.separator).append(accessKey).append(File.separator).append("metaDataNew.json").toString());
        if (!file.exists()) {
            return false;
        }
        map.put(accessKey, file);
        return true;
    }

    private final File createMetaFile(String accessKey) {
        StringBuilder sb = new StringBuilder();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        File file = new File(sb.append(inst.getAccessKeyDirs().get(accessKey)).append(File.separator).append(accessKey).append(File.separator).append("metaDataNew.json").toString());
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        file.createNewFile();
        metaFileMap.put(accessKey, file);
        return file;
    }

    public final long cleanGeckoResource(String accessKey, boolean needClean, int expireAge, int cleanType) {
        return cleanGeckoResource(accessKey, needClean, expireAge, cleanType, false);
    }

    public final long cleanGeckoResource(String accessKey, boolean needClean, int expireAge, int cleanType, boolean writeImmediately) {
        long cleanWithChannelMetaData;
        long currentTimeMillis = System.currentTimeMillis();
        if (accessKey == null) {
            cleanWithChannelMetaData = 0;
            for (Map.Entry<String, ConcurrentHashMap<String, MetaDataItemNew>> entry : metaDataMap.entrySet()) {
                cleanWithChannelMetaData += cleanWithChannelMetaData(entry.getKey(), entry.getValue(), currentTimeMillis, needClean, expireAge, cleanType);
            }
        } else {
            ConcurrentHashMap<String, MetaDataItemNew> concurrentHashMap = metaDataMap.get(accessKey);
            if (concurrentHashMap == null) {
                return 0L;
            }
            cleanWithChannelMetaData = cleanWithChannelMetaData(accessKey, concurrentHashMap, currentTimeMillis, needClean, expireAge, cleanType);
        }
        if (writeImmediately) {
            writeMetaDataImmediately();
        }
        return cleanWithChannelMetaData;
    }

    private final long cleanWithChannelMetaData(String accessKey, Map<String, MetaDataItemNew> channelMetaData, long timeStamp, boolean needClean, int expireAge, int cleanType) {
        String str;
        long j = 60;
        long j2 = expireAge * 24 * j * j * 1000;
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str2 = inst.getAccessKeyDirs().get(accessKey);
        if (str2 == null) {
            return 0L;
        }
        String str3 = str2 + File.separator + accessKey;
        long j3 = 0;
        for (Map.Entry<String, MetaDataItemNew> entry : channelMetaData.entrySet()) {
            String key = entry.getKey();
            MetaDataItemNew value = entry.getValue();
            if (timeStamp - value.getLastReadTimeStamp() >= j2) {
                File file = new File(str3, key);
                if (file.exists()) {
                    long totalSizeOfFiles$geckox_noasanRelease = j3 + FileUtils.INSTANCE.getTotalSizeOfFiles$geckox_noasanRelease(file);
                    if (needClean) {
                        long currentTimeMillis = System.currentTimeMillis();
                        value.setAllowUpdate(false);
                        value.setLastCleanTimeStamp(currentTimeMillis);
                        metaTagMap.put(accessKey, true);
                        ChannelMetaManager.INSTANCE.removeChannel(accessKey, key);
                        Long latestChannelVersion = ResVersionUtils.getLatestChannelVersion(file);
                        CleanManager cleanManager = CleanManager.INSTANCE;
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelDir.absolutePath");
                        int i = cleanManager.cleanAllVersion(absolutePath) ? 202 : TicketGuardProviderKt.CODE_UPDATE_TEE_EVER_FAIL;
                        CleanStrategy cleanStrategy = CleanStrategy.EXPIRE_TIME;
                        long longValue = latestChannelVersion != null ? latestChannelVersion.longValue() : 0L;
                        AppSettingsManager inst2 = AppSettingsManager.inst();
                        Intrinsics.checkExpressionValueIsNotNull(inst2, "AppSettingsManager.inst()");
                        str = str3;
                        new StatisticCleanData(cleanStrategy, cleanType, accessKey, key, longValue, i, expireAge, inst2.getCleanGroupMap().get(accessKey)).upload();
                        CleanManager.INSTANCE.callbackWhenClean(accessKey, key);
                    } else {
                        str = str3;
                    }
                    j3 = totalSizeOfFiles$geckox_noasanRelease;
                    str3 = str;
                }
            }
            str = str3;
            str3 = str;
        }
        return j3;
    }

    public final void removeChannelFromMetaData(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, MetaDataItemNew> concurrentHashMap = metaDataMap.get(accessKey);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(channel);
            metaTagMap.put(accessKey, true);
        }
    }
}
