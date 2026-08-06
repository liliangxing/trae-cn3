package com.bytedance.geckox.task;

import android.content.Context;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.bytedance.geckox.Constants;
import com.bytedance.geckox.GeckoBuildInManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.geckox.utils.SPManager;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.GkFSReporter;
import com.bytedance.gkfs.storage.GkFSChunkTidyInfo;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.CacheManager;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.core.RegisterManager;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import com.bytedance.iesgurd.strategy.StorageManager;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: InitDelayTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/geckox/task/InitDelayTask;", "", "()V", "runDailyTask", "", "runDailyTaskIfNeeded", "context", "Landroid/content/Context;", "start", "uploadOnlineStats", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class InitDelayTask {
    public static final InitDelayTask INSTANCE = new InitDelayTask();

    private InitDelayTask() {
    }

    public final void start() {
        uploadOnlineStats();
        GeckoExecutors.INSTANCE.getDelayHandler().postDelayed(new Runnable() { // from class: com.bytedance.geckox.task.InitDelayTask$start$1
            @Override // java.lang.Runnable
            public final void run() {
                GeckoGlobalManager inst = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
                Intrinsics.checkExpressionValueIsNotNull(globalConfig, "GeckoGlobalManager.inst().globalConfig");
                Context context = globalConfig.getContext();
                if (context != null) {
                    StringBuilder sb = new StringBuilder();
                    File filesDir = context.getFilesDir();
                    Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
                    File file = new File(sb.append(filesDir.getAbsolutePath()).append("/keva/repo/gecko_channel_meta").toString());
                    if (file.exists() && file.isDirectory()) {
                        FileUtils.delete(file);
                    }
                    GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
                    Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
                    ArrayList arrayList = new ArrayList(inst2.getAccessKeyDirs().keySet());
                    if (!arrayList.isEmpty()) {
                        GeckoBuildInManager geckoBuildInManager = GeckoBuildInManager.INSTANCE;
                        GeckoGlobalManager inst3 = GeckoGlobalManager.inst();
                        Intrinsics.checkExpressionValueIsNotNull(inst3, "GeckoGlobalManager.inst()");
                        GeckoGlobalConfig globalConfig2 = inst3.getGlobalConfig();
                        Intrinsics.checkExpressionValueIsNotNull(globalConfig2, "GeckoGlobalManager.inst().globalConfig");
                        String appVersion = globalConfig2.getAppVersion();
                        Intrinsics.checkExpressionValueIsNotNull(appVersion, "GeckoGlobalManager.inst().globalConfig.appVersion");
                        geckoBuildInManager.disableOfflineChannels(context, appVersion, arrayList);
                    }
                    CacheManager.INSTANCE.deletePendingFiles();
                    InitDelayTask.INSTANCE.runDailyTaskIfNeeded(context);
                }
            }
        }, 120000L);
    }

    private final void uploadOnlineStats() {
        new HandlerTimerTask("upload_online_stats", 3).schedule(new HandlerTask<Object>() { // from class: com.bytedance.geckox.task.InitDelayTask$uploadOnlineStats$task$1
            @Override // com.bytedance.geckox.task.HandlerTask
            public int taskType() {
                return 10;
            }

            @Override // com.bytedance.geckox.task.HandlerTask
            public void execute() {
                JSONObject jSONObject = new JSONObject();
                GeckoGlobalManager inst = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                GlobalConfigSettings globalSettings = inst.getGlobalSettings();
                if (globalSettings != null) {
                    jSONObject.put("settings_version", globalSettings.getVersion());
                }
                StorageManager.INSTANCE.putStorageStatus(jSONObject);
                List noLocalAks = GeckoStore.INSTANCE.getNoLocalAks();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ChannelMetaManager.INSTANCE.getAllMeta().entrySet()) {
                    String str = (String) entry.getKey();
                    if (noLocalAks == null || !noLocalAks.contains(str)) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap.put(str, linkedHashMap2);
                        for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                            Long id = ((ChannelMeta) entry2.getValue()).getId();
                            if (id != null) {
                                linkedHashMap2.put(entry2.getKey(), Long.valueOf(id.longValue()));
                            }
                        }
                    }
                }
                jSONObject.put("available_meta_ids", new Gson().toJson(linkedHashMap));
                UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_online_stats", jSONObject);
            }
        }, 0L, 300000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runDailyTaskIfNeeded(Context context) {
        String string = SPManager.inst().getString(context, "gecko_daily_task", "2021-09-15");
        String format = new SimpleDateFormat(DateUtils.PATTERN_YEAR).format(new Date());
        if (Intrinsics.areEqual(format, string)) {
            return;
        }
        SPManager.inst().putString(context, "gecko_daily_task", format);
        GeckoLogger.m296d("do daily task, date: " + format);
        GeckoExecutors.INSTANCE.getIoExecutor().execute(new Runnable() { // from class: com.bytedance.geckox.task.InitDelayTask$runDailyTaskIfNeeded$1
            @Override // java.lang.Runnable
            public final void run() {
                InitDelayTask.INSTANCE.runDailyTask();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void runDailyTask() {
        boolean z;
        Iterator<Map.Entry<String, String>> it;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator<Map.Entry<String, String>> it2;
        int i;
        File[] fileArr;
        File file;
        long j;
        int i2;
        int i3;
        final Ref.LongRef longRef = new Ref.LongRef();
        long j2 = 0;
        longRef.element = 0L;
        ArrayList<JSONObject> arrayList3 = new ArrayList();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        Map<String, String> accessKeyDirs = inst.getAccessKeyDirs();
        Intrinsics.checkExpressionValueIsNotNull(accessKeyDirs, "GeckoGlobalManager.inst().accessKeyDirs");
        Iterator<Map.Entry<String, String>> it3 = accessKeyDirs.entrySet().iterator();
        int i4 = 0;
        while (it3.hasNext()) {
            Map.Entry<String, String> next = it3.next();
            String key = next.getKey();
            File[] listFiles = new File(next.getValue(), key).listFiles(new FileFilter() { // from class: com.bytedance.geckox.task.InitDelayTask$runDailyTask$channelFiles$1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    Intrinsics.checkExpressionValueIsNotNull(file2, "pathname");
                    return file2.isDirectory();
                }
            });
            if (listFiles != null) {
                if (!(listFiles.length == 0)) {
                    z = false;
                    if (z) {
                        int length = listFiles.length;
                        long j3 = j2;
                        int i5 = 0;
                        while (i5 < length) {
                            File file2 = listFiles[i5];
                            CleanManager cleanManager = CleanManager.INSTANCE;
                            Intrinsics.checkExpressionValueIsNotNull(file2, "it");
                            String absolutePath = file2.getAbsolutePath();
                            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "it.absolutePath");
                            cleanManager.cleanOldVersion(absolutePath, (Long) null);
                            File[] listFiles2 = file2.listFiles(new FileFilter() { // from class: com.bytedance.geckox.task.InitDelayTask$runDailyTask$1$versions$1
                                @Override // java.io.FileFilter
                                public final boolean accept(File file3) {
                                    Intrinsics.checkExpressionValueIsNotNull(file3, "pathname");
                                    return file3.isDirectory();
                                }
                            });
                            if (listFiles2 != null) {
                                int length2 = listFiles2.length;
                                int i6 = 0;
                                while (i6 < length2) {
                                    int i7 = length2;
                                    File file3 = new File(listFiles2[i6], "res.zip");
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    i6++;
                                    length2 = i7;
                                }
                            }
                            int length3 = listFiles2 != null ? listFiles2.length : 0;
                            if (length3 > 1) {
                                Intrinsics.checkExpressionValueIsNotNull(listFiles2, "versions");
                                int length4 = listFiles2.length;
                                String str = "";
                                int i8 = 0;
                                while (i8 < length4) {
                                    Iterator<Map.Entry<String, String>> it4 = it3;
                                    File file4 = listFiles2[i8];
                                    File[] fileArr2 = listFiles2;
                                    StringBuilder append = new StringBuilder().append(str);
                                    Intrinsics.checkExpressionValueIsNotNull(file4, "file");
                                    str = append.append(file4.getName()).append(',').toString();
                                    i8++;
                                    listFiles2 = fileArr2;
                                    it3 = it4;
                                }
                                it2 = it3;
                                arrayList2 = arrayList3;
                                file = file2;
                                i = i4;
                                fileArr = listFiles;
                                j = j3;
                                i2 = i5;
                                i3 = length;
                                new EventMessageModel(EventSubType.MULTI_VERSION, key, file2.getName(), str, String.valueOf(length3), 0L, 32, (DefaultConstructorMarker) null).upload();
                            } else {
                                arrayList2 = arrayList3;
                                it2 = it3;
                                i = i4;
                                fileArr = listFiles;
                                file = file2;
                                j = j3;
                                i2 = i5;
                                i3 = length;
                            }
                            j3 = j + FileUtils.INSTANCE.getTotalSizeOfFiles$geckox_noasanRelease(file);
                            i5 = i2 + 1;
                            i4 = i;
                            it3 = it2;
                            arrayList3 = arrayList2;
                            listFiles = fileArr;
                            length = i3;
                        }
                        ArrayList arrayList4 = arrayList3;
                        it = it3;
                        int i9 = i4;
                        File[] fileArr3 = listFiles;
                        long j4 = j3;
                        longRef.element += j4;
                        int length5 = fileArr3.length + i9;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("access_key", key);
                        jSONObject.put("access_key_resource_usage", j4);
                        jSONObject.put("channel_count", fileArr3.length);
                        RegisterManager registerManager = RegisterManager.INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(key, "accessKey");
                        jSONObject.put(Constants.CUSTOM_KEY_BUSINESS_VERSION, registerManager.getBusinessVersionWithCommon(key));
                        Pair<Integer, String> blockChannelData = MetaDataManager.INSTANCE.getBlockChannelData(key);
                        jSONObject.put("blocklist_count", ((Number) blockChannelData.getFirst()).intValue());
                        jSONObject.put("block_channels", blockChannelData.getSecond());
                        arrayList = arrayList4;
                        arrayList.add(jSONObject);
                        i4 = length5;
                    } else {
                        arrayList = arrayList3;
                        it = it3;
                    }
                    arrayList3 = arrayList;
                    it3 = it;
                    j2 = 0;
                }
            }
            z = true;
            if (z) {
            }
            arrayList3 = arrayList;
            it3 = it;
            j2 = 0;
        }
        int i10 = i4;
        for (JSONObject jSONObject2 : arrayList3) {
            jSONObject2.put("gecko_total_resource_usage", longRef.element);
            jSONObject2.put("total_channel_count", i10);
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_access_key_resource_info", jSONObject2);
        }
        GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.geckox.task.InitDelayTask$runDailyTask$3
            @Override // java.lang.Runnable
            public final void run() {
                if (GkFSUtils.INSTANCE.allowTidyUp()) {
                    try {
                        GkFSChunkTidyInfo tidyUp = GeckoFileSystem.INSTANCE.tidyUp();
                        if (tidyUp != null) {
                            GkFSReporter.INSTANCE.reportGeneralResourceInfo(null, tidyUp, longRef.element);
                        }
                    } catch (Throwable th) {
                        GkFSReporter.INSTANCE.reportGeneralResourceInfo(th, null, 0L);
                    }
                }
            }
        });
    }
}
