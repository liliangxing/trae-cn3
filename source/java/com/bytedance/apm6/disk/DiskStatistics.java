package com.bytedance.apm6.disk;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.util.TopK;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.dumper.Scraps;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DiskStatistics {
    private static final String EXTERNAL_PREFIX = "external";
    private static final long FACTOR_1024 = 1024;
    private static final String INTERNAL_PREFIX = "internal";
    private static final long MAX_STORAGE_CHECK_VALUE_BYTES = 17179869184L;
    private static final long MIN_OUTDATE_FILE_SIZE_BYTES = 102400;
    private static final String OUTSIDE_STORAGE = "/Android/data/";
    private static final String PERF_DISK_FILE_NAME = "name";
    private static final String PERF_DISK_FILE_NUM = "num";
    private static final String PERF_DISK_FILE_SIZE = "size";
    private static final long SHORT_UNIT = 1000;
    private static DiskStatistics instance = new DiskStatistics();
    private List<String> compliancePaths;
    private DiskConfig config;
    private List<String> customCollectPaths;
    private List<String> ignoredPaths;
    private boolean inited;
    private String insideCachePath;
    private String insideDataPath;
    private IStorageCheckListener listener;
    private String outsideCachePath;
    private String outsideDataPath;
    private volatile boolean initException = false;
    private long insideDataSize = 0;
    private long outsideDataSize = 0;
    private long insideCacheSize = 0;
    private long outsideCacheSize = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOutOfMaxCheckSize(long j) {
        return j < 0 || j > MAX_STORAGE_CHECK_VALUE_BYTES;
    }

    boolean isOutdatedFileSizeValid(long j) {
        return j >= 104857600 && j <= MAX_STORAGE_CHECK_VALUE_BYTES;
    }

    private DiskStatistics() {
    }

    public static DiskStatistics getInstance() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskReportEvent collect(DiskConfig diskConfig) {
        if (diskConfig == null || this.initException) {
            return null;
        }
        this.config = diskConfig;
        initPaths();
        this.ignoredPaths = toAbsolutePath(diskConfig.getIgnoredRelativePaths());
        this.customCollectPaths = toAbsolutePath(diskConfig.getCustomRelativePaths());
        this.compliancePaths = toAbsolutePath(diskConfig.getComplianceRelativePaths());
        return calculate();
    }

    public void setListener(IStorageCheckListener iStorageCheckListener) {
        this.listener = iStorageCheckListener;
    }

    private DiskReportEvent calculate() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        calculateFirstLevelDiskInfo(new File(this.insideDataPath), arrayList);
        calculateFirstLevelDiskInfo(new File(this.outsideDataPath), arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (DiskInfoNode diskInfoNode : arrayList) {
            Iterator<DiskInfoNode> it = diskInfoNode.nextDisk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (it.next().isFolder) {
                    z = false;
                    break;
                }
            }
            if (z) {
                arrayList2.remove(diskInfoNode);
            }
        }
        arrayList.removeAll(arrayList2);
        if (ApmContext.isDebugMode()) {
            Iterator<DiskInfoNode> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Logger.m119d(Constants.TAG, "diskInfoNodes:" + it2.next().toJson());
            }
        }
        TopK<FileNode> topK = new TopK<>(this.config.getReportMaxTopCount());
        TopK<FileNode> topK2 = new TopK<>(this.config.getReportExceptionDirMaxCount());
        TopK<FileNode> topK3 = new TopK<>(this.config.getReportMaxOutdatedCount());
        List<String> arrayList3 = new ArrayList<>();
        arrayList3.add(this.insideDataPath);
        arrayList3.add(this.insideCachePath);
        calculateDiskTotalSize(calculateDiskTopK(this.insideDataPath, topK, topK2, topK3, arrayList3));
        arrayList3.clear();
        arrayList3.add(this.outsideCachePath);
        arrayList3.add(this.outsideDataPath);
        calculateDiskTotalSize(calculateDiskTopK(this.outsideDataPath, topK, topK2, topK3, arrayList3));
        if (ApmContext.isDebugMode()) {
            Iterator<FileNode> it3 = topK.sortedList().iterator();
            while (it3.hasNext()) {
                Logger.m119d(Constants.TAG, "fileListTopK:" + it3.next().toJSON());
            }
            Iterator<FileNode> it4 = topK2.sortedList().iterator();
            while (it4.hasNext()) {
                Logger.m119d(Constants.TAG, "dirListTopK:" + it4.next().toJSON());
            }
            Iterator<FileNode> it5 = topK3.sortedList().iterator();
            while (it5.hasNext()) {
                Logger.m119d(Constants.TAG, "outdatedListTopK:" + it5.next().toJSON());
            }
            Logger.m119d(Constants.TAG, "insideDataSize:" + this.insideDataSize + " outsideDataSize:" + this.outsideDataSize + " insideCacheSize:" + this.insideCacheSize + " outsideCacheSize:" + this.outsideCacheSize);
        }
        calculateCustomDiskInfo(arrayList);
        return createReportEvent(topK, topK2, topK3, arrayList);
    }

    private void calculateDiskTotalSize(List<Node> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (Node node : list) {
            if (TextUtils.equals(node.path, this.insideDataPath)) {
                this.insideDataSize = node.size;
            } else if (TextUtils.equals(node.path, this.outsideDataPath)) {
                this.outsideDataSize = node.size;
            } else if (TextUtils.equals(node.path, this.insideCachePath)) {
                this.insideCacheSize = node.size;
            } else if (TextUtils.equals(node.path, this.outsideCachePath)) {
                this.outsideCacheSize = node.size;
            }
        }
    }

    private DiskReportEvent createReportEvent(TopK<FileNode> topK, TopK<FileNode> topK2, TopK<FileNode> topK3, List<DiskInfoNode> list) {
        try {
            long j = this.insideDataSize + this.outsideDataSize;
            long j2 = this.insideCacheSize + this.outsideCacheSize;
            long totalSpace = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();
            long freeSpace = Environment.getDataDirectory().getFreeSpace();
            long min = Math.min(j, MAX_STORAGE_CHECK_VALUE_BYTES);
            long min2 = Math.min(j2, MAX_STORAGE_CHECK_VALUE_BYTES);
            if (min < 0) {
                return null;
            }
            if (this.listener != null) {
                this.listener.onDetectException(this.config.getDiskThresholdBytes(), min, convertFileNodeList(topK), convertFileNodeList(topK2), convertFileNodeList(topK3));
            }
            Pair<Long, Long> phoneStorage = getPhoneStorage();
            long appUsage = getAppUsage();
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "appUsage:" + appUsage);
            }
            return new DiskReportEvent(j, min2, totalSpace, freeSpace, appUsage, ((Long) phoneStorage.first).longValue(), ((Long) phoneStorage.second).longValue(), getRate(appUsage, new BigDecimal(totalSpace)), createJSONArray(topK), createJSONArray(topK2), createJSONArray(topK3), createDiskInfo(list, min));
        } catch (Throwable th) {
            Log.e(Constants.TAG, "error", th);
            return null;
        }
    }

    private Pair<Long, Long> getPhoneStorage() {
        try {
            long j = 0;
            if (Build.VERSION.SDK_INT >= 26) {
                StorageStatsManager storageStatsManager = (StorageStatsManager) ApmContext.getContext().getSystemService("storagestats");
                StorageManager storageManager = (StorageManager) ApmContext.getContext().getSystemService(Scraps.STORAGE);
                Iterator<StorageVolume> it = storageManager.getStorageVolumes().iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    String uuid = it.next().getUuid();
                    UUID fromString = uuid == null ? StorageManager.UUID_DEFAULT : UUID.fromString(uuid);
                    j += storageStatsManager.getTotalBytes(fromString);
                    j2 += storageManager.getAllocatableBytes(fromString);
                }
                return new Pair<>(Long.valueOf(((j / 1000) / 1000) * 1024 * 1024), Long.valueOf(((j2 / 1000) / 1000) * 1024 * 1024));
            }
            List<StorageVolume> storageVolumes = ((StorageManager) ApmContext.getContext().getSystemService(Scraps.STORAGE)).getStorageVolumes();
            if (ListUtils.isEmpty(storageVolumes)) {
                return null;
            }
            long j3 = 0;
            for (StorageVolume storageVolume : storageVolumes) {
                File file = (File) reflectHideMethod(storageVolume.getClass(), "getPathFile", new Class[0]).invoke(storageVolume, new Object[0]);
                j += file.getTotalSpace();
                j3 += file.getFreeSpace();
            }
            return new Pair<>(Long.valueOf(((j / 1000) / 1000) * 1024 * 1024), Long.valueOf(((j3 / 1000) / 1000) * 1024 * 1024));
        } catch (Throwable unused) {
            return new Pair<>(Long.valueOf(FileUtils.getTotalStorageSize(Environment.getDataDirectory().getPath()) + FileUtils.getTotalStorageSize(Environment.getRootDirectory().getPath())), Long.valueOf(FileUtils.getAvailableStorage(Environment.getDataDirectory().getPath())));
        }
    }

    private static Method reflectHideMethod(Class cls, String str, Class<?>... clsArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    private long getAppUsage() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Application context = ApmContext.getContext();
                String packageName = context.getPackageName();
                StorageStats queryStatsForUid = ((StorageStatsManager) context.getSystemService("storagestats")).queryStatsForUid(((StorageManager) context.getSystemService(Scraps.STORAGE)).getUuidForPath(new File(context.getDataDir().getParent(), packageName)), context.getPackageManager().getApplicationInfo(packageName, 128).uid);
                if (ApmContext.isDebugMode()) {
                    Log.e(Constants.TAG, "storageStats.getAppBytes():" + queryStatsForUid.getAppBytes());
                }
                return queryStatsForUid.getAppBytes();
            } catch (Throwable unused) {
            }
        }
        try {
            long folderSize = getFolderSize(new File(ApmContext.getContext().getPackageManager().getApplicationInfo(ApmContext.getContext().getPackageName(), 0).sourceDir).getParentFile());
            if (ApmContext.isDebugMode()) {
                Log.e(Constants.TAG, "storageStats.getAppBytes():" + (getMediaDirLength() + folderSize + this.insideDataSize + this.outsideDataSize));
            }
            return folderSize + getMediaDirLength() + this.insideDataSize + this.outsideDataSize;
        } catch (Exception unused2) {
            return 0L;
        }
    }

    private long getMediaDirLength() {
        long j = 0;
        for (File file : ApmContext.getContext().getApplicationContext().getExternalMediaDirs()) {
            j += getFolderSize(file);
        }
        return j;
    }

    private JSONArray createDiskInfo(List<DiskInfoNode> list, long j) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(j);
        JSONArray jSONArray = new JSONArray();
        for (DiskInfoNode diskInfoNode : list) {
            if (isIgnoredNode(diskInfoNode)) {
                diskInfoNode.sizeRate = 0.0f;
            } else {
                diskInfoNode.sizeRate = getRate(diskInfoNode.size, bigDecimal);
            }
            List<DiskInfoNode> list2 = diskInfoNode.nextDisk;
            if (list2 != null && list2.size() > 0) {
                for (DiskInfoNode diskInfoNode2 : list2) {
                    if (isIgnoredNode(diskInfoNode2)) {
                        diskInfoNode2.sizeRate = 0.0f;
                    } else {
                        diskInfoNode2.sizeRate = getRate(diskInfoNode2.size, bigDecimal);
                    }
                }
            }
            jSONArray.put(diskInfoNode.toJson());
        }
        return jSONArray;
    }

    private float getRate(long j, BigDecimal bigDecimal) {
        return (float) new BigDecimal(j).divide(bigDecimal, 4, 4).doubleValue();
    }

    private boolean isIgnoredNode(DiskInfoNode diskInfoNode) {
        Iterator<String> it = this.ignoredPaths.iterator();
        while (it.hasNext()) {
            if (diskInfoNode.path.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private List<String> toAbsolutePath(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        for (String str : list) {
            if (str.contains(INTERNAL_PREFIX)) {
                arrayList.add(str.replace(INTERNAL_PREFIX, this.insideDataPath));
            } else if (str.contains(EXTERNAL_PREFIX)) {
                arrayList.add(str.replace(EXTERNAL_PREFIX, this.outsideDataPath));
            }
        }
        return arrayList;
    }

    private static List<String> convertFileNodeList(TopK<? extends FileNode> topK) {
        if (topK == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<? extends FileNode> it = topK.sortedList().iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().path);
        }
        return linkedList;
    }

    JSONArray createJSONArray(TopK<FileNode> topK) {
        JSONArray jSONArray = new JSONArray();
        Iterator<FileNode> it = topK.sortedList().iterator();
        while (it.hasNext()) {
            JSONObject json = it.next().toJSON();
            if (json != null) {
                jSONArray.put(json);
            }
        }
        return jSONArray;
    }

    private List<Node> calculateDiskTopK(String str, TopK<FileNode> topK, TopK<FileNode> topK2, TopK<FileNode> topK3, List<String> list) {
        List<String> list2;
        ArrayList arrayList;
        LinkedList linkedList;
        int i;
        int i2;
        int i3;
        File file;
        ArrayList arrayList2;
        String str2;
        List<String> list3 = list;
        ArrayList arrayList3 = new ArrayList();
        File file2 = new File(str);
        Node node = new Node();
        node.path = str;
        node.parent = new Node();
        File[] listFiles = file2.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        if (list3.contains(file2.getAbsolutePath())) {
            arrayList3.add(node);
            list3.remove(file2.getAbsolutePath());
        }
        node.childCount = listFiles.length;
        LinkedList linkedList2 = new LinkedList();
        linkedList2.offer(node);
        while (!linkedList2.isEmpty()) {
            int size = linkedList2.size();
            int i4 = 0;
            while (i4 < size) {
                Node node2 = (Node) linkedList2.poll();
                if (node2 == null) {
                    list2 = list3;
                    arrayList = arrayList3;
                    linkedList = linkedList2;
                    i = size;
                    i2 = i4;
                } else {
                    String str3 = node2.path;
                    File file3 = new File(str3);
                    if (!file3.exists() || isIgnored(file3)) {
                        list2 = list3;
                        arrayList = arrayList3;
                        linkedList = linkedList2;
                        i = size;
                        i2 = i4;
                        Node.access$310(node2.parent);
                    } else if (file3.isFile()) {
                        LinkedList linkedList3 = linkedList2;
                        long length = file3.length();
                        if (isOutOfMaxCheckSize(length)) {
                            file = file3;
                            arrayList2 = arrayList3;
                            str2 = str3;
                        } else {
                            arrayList2 = arrayList3;
                            file = file3;
                            str2 = str3;
                            topK.add(new FileNode(str3, length, 1));
                        }
                        if (node2.parent == null) {
                            linkedList = linkedList3;
                            list2 = list;
                            i2 = i4;
                        } else {
                            node2.parent.appendChildInfo(length, topK3, topK2);
                            if (!node2.parent.isOutdated) {
                                long outOfDateInterval = getOutOfDateInterval(file.lastModified());
                                if (outOfDateInterval > 0 && isOutdatedFileSizeValid(length)) {
                                    String str4 = str2;
                                    i2 = i4;
                                    topK3.add(new OutdatedNode(str4, size, 0, outOfDateInterval));
                                    linkedList = linkedList3;
                                    list2 = list;
                                }
                            }
                            i2 = i4;
                            linkedList = linkedList3;
                            list2 = list;
                        }
                        i = size;
                        arrayList = arrayList2;
                    } else {
                        ArrayList arrayList4 = arrayList3;
                        LinkedList linkedList4 = linkedList2;
                        i2 = i4;
                        list2 = list;
                        if (list2.contains(file3.getAbsolutePath())) {
                            arrayList = arrayList4;
                            arrayList.add(node2);
                            list2.remove(file3.getAbsolutePath());
                        } else {
                            arrayList = arrayList4;
                        }
                        File[] listFiles2 = file3.listFiles();
                        if (listFiles2 == null || listFiles2.length == 0) {
                            linkedList = linkedList4;
                            i = size;
                            node2.parent.appendChildInfo(0L, topK3, topK2);
                        } else {
                            node2.childCount = listFiles2.length;
                            int length2 = listFiles2.length;
                            int i5 = 0;
                            while (i5 < length2) {
                                File file4 = listFiles2[i5];
                                Node node3 = new Node();
                                node3.parent = node2;
                                node3.path = file4.getAbsolutePath();
                                if (!file4.isDirectory() || node2.isOutdated) {
                                    i3 = size;
                                } else {
                                    i3 = size;
                                    long outOfDateInterval2 = getOutOfDateInterval(file4.lastModified());
                                    if (outOfDateInterval2 > 0) {
                                        node3.isOutdated = true;
                                        node3.outdateInterval = outOfDateInterval2;
                                    }
                                }
                                LinkedList linkedList5 = linkedList4;
                                linkedList5.offer(node3);
                                i5++;
                                linkedList4 = linkedList5;
                                size = i3;
                            }
                            linkedList = linkedList4;
                            i = size;
                        }
                    }
                }
                i4 = i2 + 1;
                arrayList3 = arrayList;
                linkedList2 = linkedList;
                size = i;
                list3 = list2;
            }
        }
        return arrayList3;
    }

    private void calculateCustomDiskInfo(List<DiskInfoNode> list) {
        if (ListUtils.isEmpty(this.customCollectPaths)) {
            return;
        }
        Iterator<String> it = this.customCollectPaths.iterator();
        while (it.hasNext()) {
            calculateCustomDiskInfo(new File(it.next()), list);
        }
    }

    private void initPaths() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        Application context = ApmContext.getContext();
        try {
            context.getPackageName();
            this.insideDataPath = context.getFilesDir().getParent();
            this.insideCachePath = context.getCacheDir().getAbsolutePath();
            this.outsideDataPath = getExternalDir(context);
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                this.outsideCachePath = externalCacheDir.getAbsolutePath();
            }
        } catch (Exception unused) {
            this.initException = true;
        }
    }

    private String getExternalDir(Context context) {
        try {
            return context.getExternalFilesDir(null).getParentFile().getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    private void calculateFirstLevelDiskInfo(File file, List<DiskInfoNode> list) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            calculateDiskInfo(file2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCompliancePath(String str) {
        String findFirstCompliancePath = findFirstCompliancePath(str);
        if (findFirstCompliancePath == null || str == null) {
            return null;
        }
        return findFirstCompliancePath + str.substring(findFirstCompliancePath.length()).replaceAll("[^/]", "*");
    }

    private long calculateDiskInfo(File file, List<DiskInfoNode> list) {
        long j = 0;
        if (file != null && file.exists() && !isIgnored(file)) {
            if (file.isFile()) {
                long length = file.length();
                if (length < this.config.getFileThresholdBytes()) {
                    return length;
                }
                DiskInfoNode diskInfoNode = new DiskInfoNode();
                diskInfoNode.isFolder = false;
                diskInfoNode.path = file.getAbsolutePath();
                diskInfoNode.size = length;
                list.add(diskInfoNode);
                return length;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                DiskInfoNode diskInfoNode2 = new DiskInfoNode();
                diskInfoNode2.isFolder = file.isDirectory();
                diskInfoNode2.path = file.getAbsolutePath();
                ArrayList arrayList = new ArrayList();
                diskInfoNode2.nextDisk = arrayList;
                list.add(diskInfoNode2);
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists() && !isIgnored(file2)) {
                        j += calculateDiskInfo(file2, arrayList);
                    }
                }
                diskInfoNode2.size = j;
            }
        }
        return j;
    }

    private void calculateCustomDiskInfo(File file, List<DiskInfoNode> list) {
        if (file == null || !file.exists() || isIgnored(file)) {
            return;
        }
        if (file.isFile()) {
            long length = file.length();
            DiskInfoNode diskInfoNode = new DiskInfoNode();
            diskInfoNode.isFolder = false;
            diskInfoNode.path = file.getAbsolutePath();
            diskInfoNode.size = length;
            diskInfoNode.reportType = "custom";
            list.add(diskInfoNode);
            return;
        }
        DiskInfoNode diskInfoNode2 = new DiskInfoNode();
        diskInfoNode2.isFolder = true;
        diskInfoNode2.reportType = "custom";
        diskInfoNode2.path = file.getAbsolutePath();
        diskInfoNode2.size = getFolderSize(file);
        list.add(diskInfoNode2);
    }

    private boolean isIgnored(File file) {
        if (ListUtils.isEmpty(this.ignoredPaths)) {
            return false;
        }
        return this.ignoredPaths.contains(file.getAbsolutePath());
    }

    private String findFirstCompliancePath(String str) {
        if (ListUtils.isEmpty(this.compliancePaths) || str == null) {
            return null;
        }
        for (String str2 : this.compliancePaths) {
            if (str.startsWith(str2)) {
                return str2;
            }
        }
        return null;
    }

    private long getOutOfDateInterval(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < this.config.getOutdatedIntervalMs() || currentTimeMillis >= 62899200000L) {
            return 0L;
        }
        return currentTimeMillis;
    }

    private long getFolderSize(File file) {
        File[] listFiles;
        long length;
        long j = 0;
        try {
            listFiles = file.listFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    length = getFolderSize(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
            return j;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class DiskInfoNode {
        public static final String TYPE_CUSTOM = "custom";
        public static final String TYPE_NORMAL = "normal";
        public boolean isFolder;
        public List<DiskInfoNode> nextDisk;
        public String path;
        public String reportType;
        public long size;
        public float sizeRate;

        private DiskInfoNode() {
            this.reportType = "normal";
            this.nextDisk = new ArrayList();
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("path", parsePath());
                jSONObject.put("size", this.size);
                jSONObject.put("size_rate", this.sizeRate);
                jSONObject.put("is_folder", this.isFolder);
                jSONObject.put("report_type", this.reportType);
                if (!this.nextDisk.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<DiskInfoNode> it = this.nextDisk.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJson());
                    }
                    jSONObject.put("next_disk", jSONArray);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        private String parsePath() {
            String str = this.path;
            String compliancePath = DiskStatistics.this.getCompliancePath(str);
            if (compliancePath != null) {
                str = compliancePath;
            }
            if (str.contains(DiskStatistics.this.insideDataPath)) {
                return str.replace(DiskStatistics.this.insideDataPath, DiskStatistics.INTERNAL_PREFIX);
            }
            return str.contains(DiskStatistics.this.outsideDataPath) ? str.replace(DiskStatistics.this.outsideDataPath, DiskStatistics.EXTERNAL_PREFIX) : str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class FileNode implements Comparable {
        private int num;
        private String path;
        public long size;

        public FileNode() {
        }

        public FileNode(String str, long j, int i) {
            this.path = str;
            this.size = j;
            this.num = i;
        }

        public JSONObject toJSON() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", parsePath());
                jSONObject.put("size", this.size);
                int i = this.num;
                if (i > 0) {
                    jSONObject.put("num", i);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            long j = this.size;
            long j2 = ((FileNode) obj).size;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? 1 : -1;
        }

        private String parsePath() {
            String str = this.path;
            String compliancePath = DiskStatistics.this.getCompliancePath(str);
            if (compliancePath != null) {
                str = compliancePath;
            }
            if (str.contains(DiskStatistics.this.insideDataPath)) {
                return str.replace(DiskStatistics.this.insideDataPath, DiskStatistics.INTERNAL_PREFIX);
            }
            return str.contains(DiskStatistics.this.outsideDataPath) ? str.replace(DiskStatistics.this.outsideDataPath, DiskStatistics.EXTERNAL_PREFIX) : str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class OutdatedNode extends FileNode {
        private int num;
        private long outdatedInterval;
        private final String path;
        public long size;

        public OutdatedNode(String str, long j, int i, long j2) {
            super();
            this.path = str;
            this.size = j;
            this.num = i;
            this.outdatedInterval = j2;
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode
        public JSONObject toJSON() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", parsePath());
                jSONObject.put("size", this.size);
                int i = this.num;
                if (i > 0) {
                    jSONObject.put("num", i);
                }
                jSONObject.put(PerfConsts.PERF_DISK_FILE_OUTDATE_INTERVAL, this.outdatedInterval);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.bytedance.apm6.disk.DiskStatistics.FileNode, java.lang.Comparable
        public int compareTo(Object obj) {
            long j = this.outdatedInterval;
            long j2 = ((OutdatedNode) obj).outdatedInterval;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? 1 : -1;
        }

        private String parsePath() {
            String str = this.path;
            String compliancePath = DiskStatistics.this.getCompliancePath(str);
            if (compliancePath != null) {
                str = compliancePath;
            }
            if (str.contains(DiskStatistics.this.insideDataPath)) {
                return str.replace(DiskStatistics.this.insideDataPath, DiskStatistics.INTERNAL_PREFIX);
            }
            return str.contains(DiskStatistics.this.outsideDataPath) ? str.replace(DiskStatistics.this.outsideDataPath, DiskStatistics.EXTERNAL_PREFIX) : str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class Node {
        private int childAccuCount;
        private int childCount;
        private boolean isChildExceedThreshold;
        private boolean isOutdated;
        private long outdateInterval;
        public Node parent;
        private String path;
        public long size;

        private Node() {
        }

        static /* synthetic */ int access$310(Node node) {
            int i = node.childCount;
            node.childCount = i - 1;
            return i;
        }

        public boolean isFull() {
            return this.childAccuCount == this.childCount;
        }

        public void appendChildInfo(long j, TopK<FileNode> topK, TopK<FileNode> topK2) {
            this.size += j;
            this.childAccuCount++;
            if (this.parent == null || !isFull()) {
                return;
            }
            if (this.isChildExceedThreshold) {
                this.parent.isChildExceedThreshold = true;
            }
            if (this.size >= DiskStatistics.this.config.getFolderThresholdBytes() && !this.isChildExceedThreshold) {
                if (!DiskStatistics.this.isOutOfMaxCheckSize(this.size)) {
                    topK2.add(new FileNode(this.path, this.size, this.childCount));
                }
                this.parent.isChildExceedThreshold = true;
            }
            this.parent.appendChildInfo(this.size, topK, topK2);
            if (this.isOutdated && DiskStatistics.this.isOutdatedFileSizeValid(this.size)) {
                DiskStatistics diskStatistics = DiskStatistics.this;
                String str = this.path;
                long j2 = this.size;
                int i = this.childCount;
                topK.add(new OutdatedNode(str, j2, i, i));
            }
        }
    }
}
