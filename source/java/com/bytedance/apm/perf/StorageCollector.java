package com.bytedance.apm.perf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.internal.SpManager;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ParseUtils;
import com.bytedance.apm.util.TopK;
import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class StorageCollector extends AbstractPerfCollector {
    private static final String EXTERNAL_PREFIX = "external";
    private static final String INTERNAL_PREFIX = "internal";
    private static long MAX_STORAGE_CHECK_VALUE_BYTES = 17179869184L;
    private static final String TAG = "MonitorStorage";
    private static final long UNIT = 1073741824;
    private static String mInsideDataPath;
    private static String mOutsideDataPath;
    private boolean isExceptionDiskSwitch;
    private TopK<FileNode> mDirListTopK;
    private List<DiskInfoNode> mDiskInfoNodes;
    private TopK<FileNode> mFileListTopK;
    private boolean mHasUploadUsedStorage;
    private boolean mInitException;
    private String mInsideCachePath;
    private long mInsideCacheSize;
    private long mInsideDataSize;
    private TopK<OutdatedNode> mOutdatedListTopK;
    private String mOutsideCachePath;
    private long mOutsideCacheSize;
    private long mOutsideDataSize;
    private IStorageCheckListener mStorageCheckListener;
    private long mDiskAppUsedThresholdBytes = 524288000;
    private long mFolderSizeThresholdBytes = 524288000;
    private int mReportFileMaxCount = 20;
    private long mOutdatedIntervalMs = 2592000000L;
    private List<String> mDiskCustomedRelativePaths = new ArrayList();
    private List<String> mIgnoredRelativePaths = new ArrayList();
    private List<String> mIgnoredPaths = new ArrayList();
    private List<String> mDiskCustomedPaths = new ArrayList();

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return true;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return 120000L;
    }

    public StorageCollector() {
        this.mCollectorSettingKey = "disk";
    }

    public void setStorageCheckListener(IStorageCheckListener iStorageCheckListener) {
        this.mStorageCheckListener = iStorageCheckListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("dump_switch", true);
        this.isExceptionDiskSwitch = optBoolean;
        if (optBoolean) {
            long currentTimeMillis = System.currentTimeMillis() - SpManager.getInstance().getLong(PerfConsts.DISK_SP_KEY_CHECK_TIME);
            if (currentTimeMillis < 86400000 && currentTimeMillis > 0) {
                this.mHasUploadUsedStorage = true;
            }
            if (jSONObject.optInt("dump_threshold") > 0) {
                this.mDiskAppUsedThresholdBytes = jSONObject.optInt("dump_threshold") * 1024 * 1024;
            }
            if (jSONObject.optInt("abnormal_folder_size") > 0) {
                this.mFolderSizeThresholdBytes = jSONObject.optInt("abnormal_folder_size") * 1024 * 1024;
            }
            if (jSONObject.optInt("dump_top_count") > 0) {
                this.mReportFileMaxCount = jSONObject.optInt("dump_top_count");
            }
            if (jSONObject.optInt("outdated_days") > 0) {
                this.mOutdatedIntervalMs = jSONObject.optInt("outdated_days") * 86400000;
            }
            this.mDiskCustomedRelativePaths = ParseUtils.parseMapList(jSONObject, "disk_customed_paths");
            this.mIgnoredRelativePaths = ParseUtils.parseList(jSONObject, "ignored_relative_paths");
        }
        this.mHasUploadUsedStorage = true;
    }

    private void initPaths() {
        if (mInsideDataPath != null) {
            return;
        }
        Context context = ApmContext.getContext();
        try {
            context.getPackageName();
            mInsideDataPath = context.getFilesDir().getParent();
            this.mInsideCachePath = context.getCacheDir().getAbsolutePath();
            mOutsideDataPath = context.getExternalFilesDir(null).getParentFile().getAbsolutePath();
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                this.mOutsideCachePath = externalCacheDir.getAbsolutePath();
            }
            List<String> list = this.mIgnoredRelativePaths;
            if (list != null) {
                for (String str : list) {
                    if (str.contains(INTERNAL_PREFIX)) {
                        this.mIgnoredPaths.add(str.replace(INTERNAL_PREFIX, mInsideDataPath));
                    } else if (str.contains(EXTERNAL_PREFIX)) {
                        this.mIgnoredPaths.add(str.replace(EXTERNAL_PREFIX, mOutsideDataPath));
                    }
                }
            }
            List<String> list2 = this.mDiskCustomedRelativePaths;
            if (list2 != null) {
                for (String str2 : list2) {
                    if (str2.contains(INTERNAL_PREFIX)) {
                        this.mDiskCustomedPaths.add(str2.replace(INTERNAL_PREFIX, mInsideDataPath));
                    } else if (str2.contains(EXTERNAL_PREFIX)) {
                        this.mDiskCustomedPaths.add(str2.replace(EXTERNAL_PREFIX, mOutsideDataPath));
                    }
                }
            }
        } catch (Exception unused) {
            this.mInitException = true;
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        boolean isBackground = isBackground();
        if (this.mHasUploadUsedStorage || !isBackground) {
            return;
        }
        initPaths();
        if (this.mInitException) {
            this.mHasUploadUsedStorage = true;
            return;
        }
        if (this.isExceptionDiskSwitch) {
            handleUsedStorageNew();
        } else {
            handleUsedStorageOld();
        }
        this.mHasUploadUsedStorage = true;
        stop();
        destroy();
    }

    private void handleUsedStorageOld() {
        try {
            sendData(CommonMonitorUtil.getUsedStorageSize(ApmContext.getContext()), CommonMonitorUtil.getUsedCacheSize(ApmContext.getContext()), CommonMonitorUtil.getDiskTotalSize(), Environment.getDataDirectory().getFreeSpace());
        } catch (Exception unused) {
        }
    }

    private void handleUsedStorageNew() {
        try {
            checkExceptionDisk();
            sendData(this.mInsideDataSize + this.mOutsideDataSize, this.mInsideCacheSize + this.mOutsideCacheSize, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());
            SpManager.getInstance().saveAsync(PerfConsts.DISK_SP_KEY_CHECK_TIME, System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    private void sendData(long j, long j2, long j3, long j4) {
        try {
            if (ApmContext.isDebugMode()) {
                Logger.m88i(DebugLogger.TAG_PERF, "disk: data: " + j + " , cache: " + j2 + " , total: " + j3 + " , free: " + j4);
            }
            long j5 = MAX_STORAGE_CHECK_VALUE_BYTES;
            long j6 = j > j5 ? j5 : j;
            if (j2 <= j5) {
                j5 = j2;
            }
            JSONObject jSONObject = new JSONObject();
            if (j > 0) {
                jSONObject.put("data", j6);
            }
            if (j2 > 0) {
                jSONObject.put("cache", j5);
            }
            if (j3 > 0) {
                jSONObject.put(PerfConsts.PERF_DISK_TOTAL, byte2G(j3));
            }
            if (j4 > 0) {
                jSONObject.put(PerfConsts.PERF_DISK_ROM_FREE, byte2G(j4));
            }
            JSONObject jSONObject2 = new JSONObject();
            if (this.isExceptionDiskSwitch && j6 > this.mDiskAppUsedThresholdBytes) {
                if (this.mFileListTopK != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FileNode> it = this.mFileListTopK.sortedList().iterator();
                    while (it.hasNext()) {
                        JSONObject json = it.next().toJSON();
                        if (json != null) {
                            jSONArray.put(json);
                        }
                    }
                    jSONObject2.put(PerfConsts.PERF_DISK_TOP_USAGE, jSONArray);
                }
                if (this.mDirListTopK != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<FileNode> it2 = this.mDirListTopK.sortedList().iterator();
                    while (it2.hasNext()) {
                        JSONObject json2 = it2.next().toJSON();
                        if (json2 != null) {
                            jSONArray2.put(json2);
                        }
                    }
                    jSONObject2.put(PerfConsts.PERF_DISK_EXCEPTION_FOLDERS, jSONArray2);
                }
                if (this.mOutdatedListTopK != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    Iterator<OutdatedNode> it3 = this.mOutdatedListTopK.sortedList().iterator();
                    while (it3.hasNext()) {
                        JSONObject json3 = it3.next().toJSON();
                        if (json3 != null) {
                            jSONArray3.put(json3);
                        }
                    }
                    jSONObject2.put(PerfConsts.PERF_DISK_OUTDATED_FILES, jSONArray3);
                }
                List<DiskInfoNode> list = this.mDiskInfoNodes;
                if (list != null && !list.isEmpty()) {
                    BigDecimal bigDecimal = new BigDecimal(j6);
                    JSONArray jSONArray4 = new JSONArray();
                    for (DiskInfoNode diskInfoNode : this.mDiskInfoNodes) {
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
                        jSONArray4.put(diskInfoNode.toJson());
                    }
                    jSONObject2.put(PerfConsts.PERF_DISK_DISK_INFO, jSONArray4);
                }
                if (this.mStorageCheckListener != null) {
                    final List<String> convertFileNodeList = convertFileNodeList(this.mFileListTopK);
                    final List<String> convertFileNodeList2 = convertFileNodeList(this.mDirListTopK);
                    final List<String> convertFileNodeList3 = convertFileNodeList(this.mOutdatedListTopK);
                    final long j7 = j6;
                    AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.apm.perf.StorageCollector.1
                        @Override // java.lang.Runnable
                        public void run() {
                            StorageCollector.this.mStorageCheckListener.onDetectException(StorageCollector.this.mDiskAppUsedThresholdBytes, j7, convertFileNodeList, convertFileNodeList2, convertFileNodeList3);
                        }
                    });
                }
                this.mFileListTopK = null;
                this.mDirListTopK = null;
                this.mOutdatedListTopK = null;
                this.mDiskInfoNodes = null;
            }
            sendPerfLog(new PerfData("disk", SlardarSettingsConsts.PERF_DISK_SAMPLE_METRIC, false, jSONObject, null, jSONObject2));
        } catch (Exception unused) {
        }
    }

    private float getRate(long j, BigDecimal bigDecimal) {
        return (float) new BigDecimal(j).divide(bigDecimal, 4, 4).doubleValue();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v2 */
    public void checkExceptionDisk() {
        List<DiskInfoNode> list;
        int i;
        String[] strArr;
        int i2 = 2;
        int i3 = 0;
        ?? r11 = 1;
        String[] strArr2 = {mInsideDataPath, mOutsideDataPath};
        this.mDiskInfoNodes = new ArrayList();
        int i4 = 0;
        while (i4 < i2) {
            String str = strArr2[i4];
            calculateDiskInfo(new File(str), r11, r11, this.mDiskInfoNodes);
            File file = new File(str);
            Node node = new Node();
            node.path = str;
            node.parent = new Node();
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                node.childCount = listFiles.length;
                LinkedList linkedList = new LinkedList();
                linkedList.offer(node);
                while (!linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i5 = i3;
                    while (i5 < size) {
                        Node node2 = (Node) linkedList.poll();
                        if (node2 == null) {
                            i = i5;
                            strArr = strArr2;
                        } else {
                            String str2 = node2.path;
                            File file2 = new File(str2);
                            if (!file2.exists() || this.mIgnoredPaths.contains(str2)) {
                                i = i5;
                                strArr = strArr2;
                                Node.access$510(node2.parent);
                            } else {
                                strArr = strArr2;
                                if (file2.isFile()) {
                                    long length = file2.length();
                                    if (length > 0) {
                                        appendExceptionFileQueue(str2, length);
                                    }
                                    if (node2.parent != null) {
                                        node2.parent.appendChildInfo(length);
                                        if (!node2.parent.isOutdated) {
                                            long isOutOfDate = isOutOfDate(file2.lastModified());
                                            if (isOutOfDate > 0) {
                                                i = i5;
                                                appendOutdatedFileQueue(str2, length, 0, isOutOfDate);
                                            }
                                        }
                                    }
                                    i = i5;
                                } else {
                                    i = i5;
                                    File[] listFiles2 = file2.listFiles();
                                    if (listFiles2 == null || listFiles2.length == 0) {
                                        node2.parent.appendChildInfo(0L);
                                    } else {
                                        node2.childCount = listFiles2.length;
                                        for (File file3 : listFiles2) {
                                            Node node3 = new Node();
                                            node3.parent = node2;
                                            node3.path = file3.getAbsolutePath();
                                            if (file3.isDirectory() && !node2.isOutdated) {
                                                long isOutOfDate2 = isOutOfDate(file3.lastModified());
                                                if (isOutOfDate2 > 0) {
                                                    node3.isOutdated = true;
                                                    node3.outdateInterval = isOutOfDate2;
                                                }
                                            }
                                            linkedList.offer(node3);
                                        }
                                    }
                                }
                            }
                        }
                        i5 = i + 1;
                        strArr2 = strArr;
                        i3 = 0;
                    }
                }
            }
            i4++;
            strArr2 = strArr2;
            i2 = 2;
            i3 = 0;
            r11 = 1;
        }
        List<String> list2 = this.mDiskCustomedPaths;
        if (list2 != null && list2.size() > 0) {
            Iterator<String> it = this.mDiskCustomedPaths.iterator();
            while (it.hasNext()) {
                calculateDiskInfo(new File(it.next()), 1, false, this.mDiskInfoNodes);
            }
        }
        for (DiskInfoNode diskInfoNode : this.mDiskInfoNodes) {
            if ("normal".equals(diskInfoNode.reportType) && (list = diskInfoNode.nextDisk) != null && !list.isEmpty()) {
                Iterator<DiskInfoNode> it2 = list.iterator();
                while (it2.hasNext()) {
                    diskInfoNode.size += it2.next().size;
                }
            }
        }
    }

    private void calculateDiskInfo(File file, int i, boolean z, List<DiskInfoNode> list) {
        if (i > 2 || file == null || !file.exists() || this.mIgnoredPaths.contains(file.getAbsolutePath())) {
            return;
        }
        if (!file.isDirectory()) {
            DiskInfoNode diskInfoNode = new DiskInfoNode();
            diskInfoNode.isFolder = false;
            diskInfoNode.path = file.getAbsolutePath();
            diskInfoNode.size = file.length();
            if (!z) {
                diskInfoNode.reportType = "custom";
            }
            list.add(diskInfoNode);
            return;
        }
        if (z) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists() && !this.mIgnoredPaths.contains(file2.getAbsolutePath())) {
                    DiskInfoNode diskInfoNode2 = new DiskInfoNode();
                    diskInfoNode2.isFolder = file2.isDirectory();
                    diskInfoNode2.path = file2.getAbsolutePath();
                    if (file2.isDirectory()) {
                        ArrayList arrayList = new ArrayList();
                        diskInfoNode2.nextDisk = arrayList;
                        if (i == 2) {
                            diskInfoNode2.size = getFolderSize(file2);
                        }
                        calculateDiskInfo(file2, i + 1, z, arrayList);
                        list.add(diskInfoNode2);
                    } else {
                        diskInfoNode2.size = file2.length();
                        list.add(diskInfoNode2);
                    }
                }
            }
            return;
        }
        DiskInfoNode diskInfoNode3 = new DiskInfoNode();
        diskInfoNode3.isFolder = true;
        diskInfoNode3.reportType = "custom";
        diskInfoNode3.path = file.getAbsolutePath();
        diskInfoNode3.size = getFolderSize(file);
        list.add(diskInfoNode3);
    }

    private long byte2G(long j) {
        return j / 1073741824;
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

    private long isOutOfDate(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < this.mOutdatedIntervalMs || currentTimeMillis >= 62899200000L) {
            return 0L;
        }
        return currentTimeMillis;
    }

    private void appendExceptionFileQueue(String str, long j) {
        if (ApmContext.isDebugMode()) {
            Logger.m86d(TAG, "appendExceptionFileQueue: path: " + str + ", size: " + j);
        }
        if (j > MAX_STORAGE_CHECK_VALUE_BYTES) {
            return;
        }
        if (this.mFileListTopK == null) {
            this.mFileListTopK = new TopK<>(this.mReportFileMaxCount);
        }
        this.mFileListTopK.add(new FileNode(str, j, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendExceptionFolderQueue(String str, long j, int i, int i2) {
        if (ApmContext.isDebugMode()) {
            Log.d(TAG, "appendExceptionFolderQueue: path: " + str + ":  size: " + j + " , accumulateNum: " + i + " , num: " + i2);
        }
        if (j > MAX_STORAGE_CHECK_VALUE_BYTES) {
            return;
        }
        if (this.mDirListTopK == null) {
            this.mDirListTopK = new TopK<>(this.mReportFileMaxCount);
        }
        this.mDirListTopK.add(new FileNode(str, j, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendOutdatedFileQueue(String str, long j, int i, long j2) {
        if (ApmContext.isDebugMode()) {
            Logger.m86d(TAG, "appendutdatedFileQueue: path: " + str + ", size: " + j);
        }
        if (j < WsConstants.DEFAULT_IO_LIMIT || j > MAX_STORAGE_CHECK_VALUE_BYTES) {
            return;
        }
        if (this.mOutdatedListTopK == null) {
            this.mOutdatedListTopK = new TopK<>(this.mReportFileMaxCount);
        }
        this.mOutdatedListTopK.add(new OutdatedNode(str, j, i, j2));
    }

    private boolean isIgnoredNode(DiskInfoNode diskInfoNode) {
        Iterator<String> it = this.mIgnoredPaths.iterator();
        while (it.hasNext()) {
            if (diskInfoNode.path.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class FileNode implements Comparable {
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
                    jSONObject.put(PerfConsts.PERF_DISK_FILE_NUM, i);
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
            if (str.contains(StorageCollector.mInsideDataPath)) {
                return str.replace(StorageCollector.mInsideDataPath, StorageCollector.INTERNAL_PREFIX);
            }
            return str.contains(StorageCollector.mOutsideDataPath) ? str.replace(StorageCollector.mOutsideDataPath, StorageCollector.EXTERNAL_PREFIX) : str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class OutdatedNode extends FileNode {
        private int num;
        private long outdatedInterval;
        private String path;
        public long size;

        public OutdatedNode(String str, long j, int i, long j2) {
            this.path = str;
            this.size = j;
            this.num = i;
            this.outdatedInterval = j2;
        }

        @Override // com.bytedance.apm.perf.StorageCollector.FileNode
        public JSONObject toJSON() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", parsePath());
                jSONObject.put("size", this.size);
                int i = this.num;
                if (i > 0) {
                    jSONObject.put(PerfConsts.PERF_DISK_FILE_NUM, i);
                }
                jSONObject.put(PerfConsts.PERF_DISK_FILE_OUTDATE_INTERVAL, this.outdatedInterval);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.bytedance.apm.perf.StorageCollector.FileNode, java.lang.Comparable
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
            if (str.contains(StorageCollector.mInsideDataPath)) {
                return str.replace(StorageCollector.mInsideDataPath, StorageCollector.INTERNAL_PREFIX);
            }
            return str.contains(StorageCollector.mOutsideDataPath) ? str.replace(StorageCollector.mOutsideDataPath, StorageCollector.EXTERNAL_PREFIX) : str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class DiskInfoNode {
        public static final String TYPE_CUSTOMED = "custom";
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
            if (str.contains(StorageCollector.mInsideDataPath)) {
                return str.replace(StorageCollector.mInsideDataPath, StorageCollector.INTERNAL_PREFIX);
            }
            return str.contains(StorageCollector.mOutsideDataPath) ? str.replace(StorageCollector.mOutsideDataPath, StorageCollector.EXTERNAL_PREFIX) : str;
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

        static /* synthetic */ int access$510(Node node) {
            int i = node.childCount;
            node.childCount = i - 1;
            return i;
        }

        private boolean isFull() {
            return this.childAccuCount == this.childCount;
        }

        public void appendChildInfo(long j) {
            this.size += j;
            this.childAccuCount++;
            if (this.parent == null || !isFull()) {
                return;
            }
            if (this.isChildExceedThreshold) {
                this.parent.isChildExceedThreshold = true;
            }
            if (this.size >= StorageCollector.this.mFolderSizeThresholdBytes && !this.isChildExceedThreshold) {
                StorageCollector.this.appendExceptionFolderQueue(this.path, this.size, this.childAccuCount, this.childCount);
                this.parent.isChildExceedThreshold = true;
            }
            this.parent.appendChildInfo(this.size);
            if (this.isOutdated) {
                StorageCollector.this.appendOutdatedFileQueue(this.path, this.size, this.childCount, this.outdateInterval);
            }
            calcTotalSize();
        }

        private void calcTotalSize() {
            if (!TextUtils.equals(this.path, StorageCollector.mInsideDataPath)) {
                if (!TextUtils.equals(this.path, StorageCollector.mOutsideDataPath)) {
                    if (!TextUtils.equals(this.path, StorageCollector.this.mInsideCachePath)) {
                        if (TextUtils.equals(this.path, StorageCollector.this.mOutsideCachePath)) {
                            StorageCollector.this.mOutsideCacheSize = this.size;
                            return;
                        }
                        return;
                    }
                    StorageCollector.this.mInsideCacheSize = this.size;
                    return;
                }
                StorageCollector.this.mOutsideDataSize = this.size;
                return;
            }
            StorageCollector.this.mInsideDataSize = this.size;
        }
    }
}
