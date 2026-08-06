package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChannelMetaManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0013j\b\u0012\u0004\u0012\u00020\u0005`\u0014J\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u001eJ\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u001e\u0010%\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fJ\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u001e\u0010(\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007J\u001e\u0010)\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007J \u0010*\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0002R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/iesgurd/meta/ChannelMetaManager;", "", "()V", "metaMap", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/iesgurd/meta/ChannelMeta;", "repo", "Lcom/bytedance/keva/Keva;", "repoMigrate", "checkLatestVersion", "", "accessKey", "channel", IPiaCacheProvider.CacheConfig.FIELD_META, "extraMsg", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/iesgurd/meta/ChannelMeta;Ljava/lang/String;)Ljava/lang/Long;", "getAllAccessKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllMeta", "getLatestChannelVersion", "channelDir", "Ljava/io/File;", "(Ljava/io/File;)Ljava/lang/Long;", "getMeta", "getMetas", "", "migrateLocalVersion", "", "rootDir", "migrateRes", "readCache", "removeAccessKey", "removeAll", "removeChannel", "removeVersion", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "resetMetaId", "saveMeta", "setMeta", "setMetaToMemory", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ChannelMetaManager {
    public static final ChannelMetaManager INSTANCE;
    private static final Map<String, ConcurrentHashMap<String, ChannelMeta>> metaMap;
    private static Keva repo;
    private static Keva repoMigrate;

    static {
        ChannelMetaManager channelMetaManager = new ChannelMetaManager();
        INSTANCE = channelMetaManager;
        metaMap = new ConcurrentHashMap();
        GeckoLogger.d("ChannelMetaManager init");
        channelMetaManager.readCache();
        GeckoExecutors.INSTANCE.getIoExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.meta.ChannelMetaManager.1
            @Override // java.lang.Runnable
            public final void run() {
                ChannelMetaManager.INSTANCE.migrateRes();
            }
        });
    }

    private ChannelMetaManager() {
    }

    public final Map<String, ConcurrentHashMap<String, ChannelMeta>> getAllMeta() {
        return metaMap;
    }

    public final ArrayList<String> getAllAccessKeys() {
        return new ArrayList<>(metaMap.keySet());
    }

    public final ChannelMeta getMeta(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap = metaMap.get(accessKey);
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(channel);
        }
        return null;
    }

    public final Map<String, ChannelMeta> getMetas(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        return metaMap.get(accessKey);
    }

    public final void setMeta(String accessKey, String channel, ChannelMeta meta) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(meta, IPiaCacheProvider.CacheConfig.FIELD_META);
        setMetaToMemory(accessKey, channel, meta);
        saveMeta(accessKey, channel, meta);
    }

    public final void saveMeta(String accessKey, String channel, ChannelMeta meta) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(meta, IPiaCacheProvider.CacheConfig.FIELD_META);
        Keva keva = repo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        keva.storeString(accessKey + '@' + channel, meta.toString());
    }

    private final void setMetaToMemory(String accessKey, String channel, ChannelMeta meta) {
        Map<String, ConcurrentHashMap<String, ChannelMeta>> map = metaMap;
        if (map.get(accessKey) == null) {
            synchronized (map) {
                if (map.get(accessKey) == null) {
                    map.put(accessKey, new ConcurrentHashMap<>());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap = map.get(accessKey);
        if (concurrentHashMap == null) {
            Intrinsics.throwNpe();
        }
        concurrentHashMap.put(channel, meta);
    }

    public final void removeAll() {
        GeckoLogger.d("ChannelMetaManager removeAll");
        Iterator it = CollectionsKt.toList(metaMap.keySet()).iterator();
        while (it.hasNext()) {
            INSTANCE.removeAccessKey((String) it.next());
        }
    }

    public final void removeAccessKey(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        GeckoLogger.d("ChannelMetaManager removeAccessKey " + accessKey);
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap = metaMap.get(accessKey);
        if (concurrentHashMap != null) {
            Set<String> keySet = concurrentHashMap.keySet();
            Intrinsics.checkExpressionValueIsNotNull(keySet, "metas.keys");
            for (String str : keySet) {
                Keva keva = repo;
                if (keva == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                }
                keva.erase(accessKey + '@' + str);
            }
            metaMap.remove(accessKey);
        }
    }

    public final void removeChannel(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        GeckoLogger.d("ChannelMetaManager removeChannel " + accessKey + '@' + channel);
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap = metaMap.get(accessKey);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(channel);
        }
        Keva keva = repo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        keva.erase(accessKey + '@' + channel);
    }

    public final void removeVersion(String accessKey, String channel, long version) {
        ChannelMeta channelMeta;
        Long id;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Map<String, ConcurrentHashMap<String, ChannelMeta>> map = metaMap;
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap = map.get(accessKey);
        if (concurrentHashMap == null || (channelMeta = concurrentHashMap.get(channel)) == null || (id = channelMeta.getId()) == null || id.longValue() != version) {
            return;
        }
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap2 = map.get(accessKey);
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.remove(channel);
        }
        Keva keva = repo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        keva.erase(accessKey + '@' + channel);
    }

    public final void resetMetaId(String accessKey, String channel) {
        ChannelMeta channelMeta;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, ChannelMeta> concurrentHashMap = metaMap.get(accessKey);
        if (concurrentHashMap == null || (channelMeta = concurrentHashMap.get(channel)) == null) {
            return;
        }
        channelMeta.setId(null);
        ChannelMetaManager channelMetaManager = INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(channelMeta, "it");
        channelMetaManager.saveMeta(accessKey, channel, channelMeta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void migrateRes() {
        GeckoLogger.d("ChannelMetaManager migrateRes");
        Keva repo2 = Keva.getRepo("gecko_channel_meta_migrate", 1);
        Intrinsics.checkExpressionValueIsNotNull(repo2, "Keva.getRepo(\"gecko_chan…tants.MODE_MULTI_PROCESS)");
        repoMigrate = repo2;
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        Map accessKeyDirs = inst.getAccessKeyDirs();
        GlobalManager.INSTANCE.getNeedMigrateLocalVersion().set(true);
        for (Map.Entry entry : accessKeyDirs.entrySet()) {
            ChannelMetaManager channelMetaManager = INSTANCE;
            Object key = entry.getKey();
            Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
            Object value = entry.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
            channelMetaManager.migrateLocalVersion((String) key, (String) value);
        }
    }

    private final void readCache() {
        GeckoLogger.d("ChannelMetaManager readCache");
        Keva repo2 = Keva.getRepo("gecko_channel_meta_new", 1);
        Intrinsics.checkExpressionValueIsNotNull(repo2, "Keva.getRepo(\"gecko_chan…tants.MODE_MULTI_PROCESS)");
        repo = repo2;
        if (repo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        Map<String, ?> all = repo2.getAll();
        Intrinsics.checkExpressionValueIsNotNull(all, "repo.all");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getKey().length() < 34) {
                GeckoLogger.w("ChannelMetaManager key length error: " + entry.getKey());
                UploadStatistic.INSTANCE.uploadEvent(EventSubType.META_PARSE_KEY_ERROR, (String) null, (String) null, entry.getKey());
            } else {
                String key = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
                String str = key;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(0, 32);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String key2 = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(key2, "it.key");
                String str2 = key2;
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring2 = str2.substring(33);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                String str3 = (String) entry.getValue();
                if (str3 == null) {
                    GeckoLogger.w("ChannelMetaManager value error: " + entry.getValue());
                    UploadStatistic.INSTANCE.uploadEvent(EventSubType.META_PARSE_VALUE_ERROR, substring, substring2, String.valueOf(entry.getValue()));
                } else {
                    ChannelMeta fromString = ChannelMeta.INSTANCE.fromString(str3);
                    if (fromString == null) {
                        GeckoLogger.w("ChannelMetaManager buffer error: " + str3);
                        UploadStatistic.INSTANCE.uploadEvent(EventSubType.META_PARSE_ERROR, substring, substring2, str3);
                    } else {
                        INSTANCE.setMetaToMemory(substring, substring2, fromString);
                    }
                }
            }
        }
        GeckoLogger.d("ChannelMetaManager readCache finish");
    }

    public final void migrateLocalVersion(String accessKey, String rootDir) {
        ChannelMetaManager channelMetaManager;
        Long latestChannelVersion;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(rootDir, "rootDir");
        Keva keva = repoMigrate;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repoMigrate");
        }
        if (keva.getBoolean(accessKey, false)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        GeckoLogger.d("ChannelMetaManager migrate: " + accessKey + " start");
        File file = new File(rootDir, accessKey);
        String[] list = file.list(new FilenameFilter() { // from class: com.bytedance.iesgurd.meta.ChannelMetaManager$migrateLocalVersion$channels$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                Intrinsics.checkExpressionValueIsNotNull(str, "name");
                return !StringsKt.endsWith$default(str, "--pending-delete", false, 2, (Object) null);
            }
        });
        if (list != null) {
            for (String str : list) {
                File file2 = new File(file, str);
                if (file2.isDirectory() && (latestChannelVersion = (channelMetaManager = INSTANCE).getLatestChannelVersion(file2)) != null) {
                    Intrinsics.checkExpressionValueIsNotNull(str, "it");
                    ChannelMeta meta = channelMetaManager.getMeta(accessKey, str);
                    if (meta == null) {
                        meta = new ChannelMeta();
                    }
                    meta.setId(latestChannelVersion);
                    meta.setUpdateTime(Long.valueOf(file2.lastModified()));
                    channelMetaManager.setMeta(accessKey, str, meta);
                }
            }
        }
        GeckoLogger.d("ChannelMetaManager migrate: " + accessKey + " finish, duration: " + (System.currentTimeMillis() - currentTimeMillis) + ", size:" + (list != null ? Integer.valueOf(list.length) : null));
        Keva keva2 = repoMigrate;
        if (keva2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repoMigrate");
        }
        keva2.storeBoolean(accessKey, true);
    }

    public final Long checkLatestVersion(String accessKey, String channel, ChannelMeta meta, String extraMsg) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(meta, IPiaCacheProvider.CacheConfig.FIELD_META);
        Intrinsics.checkParameterIsNotNull(extraMsg, "extraMsg");
        if (meta.getId() == null) {
            return null;
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        if (str == null) {
            return meta.getId();
        }
        File file = new File(new File(str, accessKey), channel);
        if (!file.exists()) {
            new EventMessageModel(EventSubType.META_CHANNEL_FILE_NOT_EXIST, accessKey, channel, String.valueOf(meta.getId()), extraMsg, 0L, 32, null).upload();
            removeChannel(accessKey, channel);
            return null;
        }
        if (!new File(file, String.valueOf(meta.getId())).exists()) {
            Long latestChannelVersion = getLatestChannelVersion(file);
            new EventMessageModel(EventSubType.META_VERSION_FILE_NOT_EXIST, accessKey, channel, new StringBuilder().append(meta.getId()).append('-').append(latestChannelVersion).toString(), extraMsg, 0L, 32, null).upload();
            if (latestChannelVersion != null) {
                meta.setId(latestChannelVersion);
                saveMeta(accessKey, channel, meta);
            } else {
                removeChannel(accessKey, channel);
            }
            return latestChannelVersion;
        }
        return meta.getId();
    }

    private final Long getLatestChannelVersion(File channelDir) {
        Long l = null;
        if (channelDir == null) {
            return null;
        }
        File[] listFiles = channelDir.listFiles(new FileFilter() { // from class: com.bytedance.iesgurd.meta.ChannelMetaManager$getLatestChannelVersion$files$1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                Intrinsics.checkExpressionValueIsNotNull(file, "pathname");
                return file.isDirectory();
            }
        });
        if (listFiles != null) {
            if (!(listFiles.length == 0)) {
                long j = 0;
                for (File file : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(file, "file");
                    String name = file.getName();
                    long lastModified = new File(file, "res").lastModified();
                    try {
                        Long valueOf = Long.valueOf(name);
                        if (l == null || lastModified > j) {
                            l = valueOf;
                            j = lastModified;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return l;
    }
}
