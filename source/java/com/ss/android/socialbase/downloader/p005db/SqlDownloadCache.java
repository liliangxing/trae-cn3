package com.ss.android.socialbase.downloader.p005db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache {
    private static final int DEFAULT_MAIN_THREAD_DB_OP_MAX_TIME_MS = 4000;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_DEFAULT = 300;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_MIN = 100;
    private static final String TAG = "SqlDownloadCache";
    private static volatile SQLiteDatabase database;
    private volatile boolean cacheSynced;
    ISqlCacheLoadCompleteCallbackAidl callback;
    private TableStatements downloadTableStatements;
    private boolean isCheckCacheEnable;
    private volatile boolean mDownloadDBOptimize;
    private TableStatements segmentTableStatements;
    private int singleLoadCountLimit;
    private long singleLoadSleepTimeMs;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_MAX = getLRUCapacityMax();
    public static volatile HashMap<String, Integer> lruHotCacheKeysMap = null;
    private static final int mainThreadDbOPMaxTime = getMainThreadDbOPMaxTime();
    private static final boolean mEnableRemoveDownloadSPInfo = isRemoveDownloadSPInfo();
    private static boolean mExternalDownload = DownloadFileUtils.isExternalDownloadEnabled();
    private static Set<Integer> mExternalDownloadIdSets = new CopyOnWriteArraySet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Fallback<T> {
        T getDefaultValue();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double d) {
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfosByFilters(String str, String str2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo onDownloadTaskStart(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int i) {
    }

    public SqlDownloadCache() {
        this(false);
    }

    public SqlDownloadCache(boolean z) {
        this.isCheckCacheEnable = false;
        this.mDownloadDBOptimize = false;
        this.callback = null;
        if (z) {
            this.cacheSynced = false;
            init(false);
        }
    }

    private static int getLRUCapacityMax() {
        int optInt = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_LRU_CAPACITY_MAX, 300);
        if (optInt >= 100) {
            return optInt;
        }
        return 300;
    }

    private static int getMainThreadDbOPMaxTime() {
        int optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.MAIN_THREAD_DB_OP_MAX_TIME_MS);
        if (optInt >= 0 && DownloadComponentManager.isEnableLruCache()) {
            return 4000;
        }
        return optInt;
    }

    private static boolean isRemoveDownloadSPInfo() {
        return DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_REMOVE_DOWNLOAD_SP_INFO) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getHotCacheKeys() {
        if (lruHotCacheKeysMap != null) {
            return;
        }
        lruHotCacheKeysMap = DownloadHelper.jsonObjectToHashMap(DownloadSetting.getGlobalSettings().optJSONObject(DownloadSettingKeys.KEY_HOT_CACHE_KEYS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isHoldDownloadInfo(String str) {
        if (lruHotCacheKeysMap != null && !lruHotCacheKeysMap.isEmpty() && str != null) {
            Iterator<Map.Entry<String, Integer>> it = lruHotCacheKeysMap.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key != null && str.indexOf(key) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureDataBaseInit() {
        if (database == null) {
            synchronized (SqlDownloadCache.class) {
                if (database == null) {
                    try {
                        if (DownloadComponentManager.getAppContext() == null) {
                            Logger.globalError(TAG, "ensureDataBaseInit", "Context is null");
                            return;
                        }
                        if (DownloadUtils.isMultiProcessDBMode()) {
                            dbInitDataBase();
                        } else {
                            database = DownloadDBHelper.getInstance().getWritableDatabase();
                        }
                        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);
                        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        Logger.globalError(TAG, "ensureDataBaseInit", "Error:" + th);
                    }
                }
            }
        }
    }

    private boolean dbInitDataBase() {
        String str;
        String curProcessName = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (TextUtils.isEmpty(curProcessName)) {
            Logger.globalError(TAG, "dbInitDataBase", "ProcessName is null");
            return false;
        }
        if (curProcessName.contains(Constants.COLON_SEPARATOR)) {
            String[] split = curProcessName.split(Constants.COLON_SEPARATOR);
            if (split == null || split.length != 2) {
                Logger.globalError(TAG, "dbInitDataBase", "Error process name:" + curProcessName);
                return false;
            }
            String str2 = split[1];
            if (TextUtils.isEmpty(str2)) {
                Logger.globalError(TAG, "dbInitDataBase", "TargetProcess empty");
                return false;
            }
            str = DBDefinition.DATABASE_SUBPROCESS_PREFIX_NAME + str2 + DBDefinition.DATABASE_SUBPROCESS_SUFFIX_NAME;
        } else {
            str = DBDefinition.DATABASE_NAME;
        }
        database = DownloadDBHelper.getInstance(str).getWritableDatabase();
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "dbInitDataBase", "DB name:" + str);
        }
        return true;
    }

    private List<String> getMimeTypes() {
        IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
        if (downloadLaunchHandler != null) {
            return downloadLaunchHandler.getResumeMimeTypes();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public void init(boolean z) {
        if (z) {
            init(new SparseArray<>(), new HashSet(), new ArrayList(), getMimeTypes(), null);
        } else {
            init(new SparseArray<>(), null, null, null, null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> sparseArray, final Set<Integer> set, final List<DownloadInfo> list, final List<String> list2, final SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.1
                /* JADX WARN: Code restructure failed: missing block: B:128:0x0612, code lost:
                
                    if (r0 == null) goto L290;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:129:0x0614, code lost:
                
                    r0.callback(r2);
                    r37.this$0.cacheSynced = r2;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:130:0x061c, code lost:
                
                    r37.this$0.onInitFinish(r2, r4, r5, r2);
                    r14.start();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:131:0x062a, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:277:0x037a, code lost:
                
                    if (r12.isFileDataValid() == false) goto L177;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:305:0x057e, code lost:
                
                    if (r0 != null) goto L289;
                 */
                /* JADX WARN: Removed duplicated region for block: B:120:0x05d1  */
                /* JADX WARN: Removed duplicated region for block: B:123:0x05f4  */
                /* JADX WARN: Removed duplicated region for block: B:126:0x05fd  */
                /* JADX WARN: Removed duplicated region for block: B:202:0x0445  */
                /* JADX WARN: Removed duplicated region for block: B:245:0x043d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:297:0x053b  */
                /* JADX WARN: Removed duplicated region for block: B:300:0x055e  */
                /* JADX WARN: Removed duplicated region for block: B:303:0x0567  */
                /* JADX WARN: Removed duplicated region for block: B:77:0x0248 A[Catch: all -> 0x0215, TRY_ENTER, TryCatch #6 {all -> 0x0215, blocks: (B:310:0x01fe, B:312:0x0202, B:314:0x020d, B:71:0x0220, B:73:0x0226, B:77:0x0248, B:79:0x025c, B:81:0x0262, B:87:0x0276), top: B:309:0x01fe }] */
                /* JADX WARN: Removed duplicated region for block: B:79:0x025c A[Catch: all -> 0x0215, TryCatch #6 {all -> 0x0215, blocks: (B:310:0x01fe, B:312:0x0202, B:314:0x020d, B:71:0x0220, B:73:0x0226, B:77:0x0248, B:79:0x025c, B:81:0x0262, B:87:0x0276), top: B:309:0x01fe }] */
                /* JADX WARN: Removed duplicated region for block: B:86:0x0274  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    ArrayList arrayList;
                    char c;
                    Cursor cursor;
                    boolean z;
                    SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback2;
                    IDownloadDBListener downloadDBListener;
                    int count;
                    int i;
                    IDownloadIdGeneratorService iDownloadIdGeneratorService;
                    boolean z2;
                    boolean z3;
                    int i2;
                    IDownloadDBListener downloadDBListener2;
                    DownloadInfo parseDownloadInfo;
                    String str;
                    boolean z4;
                    Set<String> set2;
                    Set<String> set3;
                    Set<String> set4;
                    DownloadInfo downloadInfo;
                    IDownloadIdGeneratorService iDownloadIdGeneratorService2;
                    boolean z5;
                    int id;
                    int generate;
                    if (Logger.alog()) {
                        Logger.globalDebug(SqlDownloadCache.TAG, "init", "Run");
                    }
                    DownloadDBInitInfo downloadDBInitInfo = new DownloadDBInitInfo();
                    downloadDBInitInfo.initDuration = System.currentTimeMillis();
                    SqlDownloadCache.this.ensureDataBaseInit();
                    String str2 = "Run callback:";
                    if (SqlDownloadCache.database == null && DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SQLITE_UPGRADE_FAIL_CALLBACK) > 0) {
                        Logger.globalError(SqlDownloadCache.TAG, "init", "Database is null");
                        downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                        if (Logger.alog()) {
                            Logger.globalDebug(SqlDownloadCache.TAG, "init", "Init time=" + downloadDBInitInfo.initDuration);
                        }
                        downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                        IDownloadDBListener downloadDBListener3 = DownloadComponentManager.getDownloadDBListener();
                        if (downloadDBListener3 != null) {
                            downloadDBListener3.onInitFinish(downloadDBInitInfo);
                        }
                        if (Logger.alog()) {
                            Logger.globalDebug(SqlDownloadCache.TAG, "init", "Run callback:" + sqlCacheLoadCompleteCallback);
                        }
                        SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback3 = sqlCacheLoadCompleteCallback;
                        if (sqlCacheLoadCompleteCallback3 != null) {
                            sqlCacheLoadCompleteCallback3.callback(true);
                            SqlDownloadCache.this.cacheSynced = true;
                        }
                        SqlDownloadCache.this.onInitFinish(sparseArray, set, list, true);
                        return;
                    }
                    Cleaner cleaner = Cleaner.getInstance();
                    cleaner.init();
                    SqlDownloadCache.this.singleLoadCountLimit = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQL_DOWNLOAD_CACHE_INIT_SINGLE_LOAD_COUNT_LIMIT);
                    SqlDownloadCache.this.singleLoadSleepTimeMs = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.SQL_DOWNLOAD_CACHE_INIT_SINGLE_LOAD_SLEEP_TIME_MS);
                    SqlDownloadCache.this.isCheckCacheEnable = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_CHECK_CACHE_ENABLE, 0) > 0;
                    SqlDownloadCache.this.mDownloadDBOptimize = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DOWNLOAD_DB_INIT_OPTIMIZE) > 0;
                    if (!SqlDownloadCache.this.mDownloadDBOptimize) {
                        if (SqlDownloadCache.this.singleLoadCountLimit > 0 && SqlDownloadCache.this.singleLoadSleepTimeMs > 0) {
                            SqlDownloadCache.this.newBatchInit(downloadDBInitInfo, sparseArray, set, list, list2, sqlCacheLoadCompleteCallback, cleaner);
                            return;
                        }
                        SparseArray sparseArray2 = new SparseArray();
                        ArrayList arrayList2 = new ArrayList();
                        boolean z6 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQL_DOWNLOAD_CACHE_TIME_OPT) > 0;
                        boolean z7 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_DOWNLOAD_SUCCESS_AND_NOT_EXISTS) > 0;
                        boolean z8 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_EXTERNAL_PUBLIC_DIR_TASK_FOR_Q) > 0;
                        boolean z9 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.REMOVE_USELESS_MONITOR_REPORT, 0) > 0;
                        boolean z10 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEAN_INSTALLED_APK) > 0;
                        long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.INCOMPLETE_FILE_EXPIRED_TIME);
                        boolean z11 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.ASYNC_DB_CLEAN) > 0;
                        Set<String> skipDbInitSceneSet = DownloadHelper.getSkipDbInitSceneSet();
                        Set<String> skipDbInitExpectMimeTypeSet = DownloadHelper.getSkipDbInitExpectMimeTypeSet();
                        Set<String> dbInitSceneSet = DownloadHelper.getDbInitSceneSet();
                        boolean z12 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.OPTIMIZE_DOWNLOAD_DB_LOAD) > 0;
                        try {
                            ArrayList arrayList3 = arrayList2;
                            try {
                                Cursor rawQuery = SqlDownloadCache.database.rawQuery("SELECT * FROM downloader", null);
                                try {
                                    if (list != null) {
                                        try {
                                            if (set != null) {
                                                SqlDownloadCache.getHotCacheKeys();
                                                if (rawQuery.getCount() > SqlDownloadCache.DOWNLOAD_CACHE_LRU_CAPACITY_MAX) {
                                                    count = rawQuery.getCount() - SqlDownloadCache.DOWNLOAD_CACHE_LRU_CAPACITY_MAX;
                                                    if (z6 || rawQuery.getCount() <= 0) {
                                                        i = count;
                                                        iDownloadIdGeneratorService = null;
                                                        z2 = true;
                                                    } else {
                                                        iDownloadIdGeneratorService = (IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class);
                                                        i = count;
                                                        z2 = iDownloadIdGeneratorService.isDefaultIdGenerator();
                                                    }
                                                    downloadDBInitInfo.diskCacheCount = rawQuery.getCount();
                                                    if (Logger.alog()) {
                                                        Logger.globalDebug(SqlDownloadCache.TAG, "init", "DownloadInfo Count:" + downloadDBInitInfo.diskCacheCount);
                                                    }
                                                    if (z12) {
                                                        if (SqlDownloadHelper.loadDownloadInfoIndex(rawQuery)) {
                                                            DownloadInfo.setOptimizeMonitorLoad(true);
                                                        } else {
                                                            i2 = i;
                                                            z3 = false;
                                                            while (rawQuery.moveToNext()) {
                                                                if (z3) {
                                                                    parseDownloadInfo = SqlDownloadHelper.parsePartialDownloadInfo(rawQuery);
                                                                } else {
                                                                    parseDownloadInfo = DownloadHelper.parseDownloadInfo(rawQuery);
                                                                }
                                                                DownloadInfo downloadInfo2 = parseDownloadInfo;
                                                                long curBytes = downloadInfo2.getCurBytes();
                                                                if (curBytes > 0) {
                                                                    str = str2;
                                                                    try {
                                                                        downloadDBInitInfo.diskCacheSize += curBytes;
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        cursor = rawQuery;
                                                                        arrayList = arrayList3;
                                                                        str2 = str;
                                                                        c = 0;
                                                                        try {
                                                                            th.printStackTrace();
                                                                            Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                                                            Cursor[] cursorArr = new Cursor[1];
                                                                            cursorArr[c] = cursor;
                                                                            DownloadUtils.safeClose(cursorArr);
                                                                            SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                                                            SqlDownloadCache.this.deleteChunkTable();
                                                                            SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                                                            downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                                            if (Logger.alog()) {
                                                                                Logger.globalDebug(SqlDownloadCache.TAG, "init", "init time=" + downloadDBInitInfo.initDuration);
                                                                            }
                                                                            downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                            if (downloadDBListener != null) {
                                                                                downloadDBListener.onInitFinish(downloadDBInitInfo);
                                                                            }
                                                                            if (Logger.alog()) {
                                                                                Logger.globalDebug(SqlDownloadCache.TAG, "init", str2 + sqlCacheLoadCompleteCallback);
                                                                            }
                                                                            sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                                            z = true;
                                                                        } catch (Throwable th2) {
                                                                            Cursor[] cursorArr2 = new Cursor[1];
                                                                            cursorArr2[c] = cursor;
                                                                            DownloadUtils.safeClose(cursorArr2);
                                                                            SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                                                            SqlDownloadCache.this.deleteChunkTable();
                                                                            SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                                                            downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                                            if (Logger.alog()) {
                                                                                Logger.globalDebug(SqlDownloadCache.TAG, "init", "init time=" + downloadDBInitInfo.initDuration);
                                                                            }
                                                                            downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                            IDownloadDBListener downloadDBListener4 = DownloadComponentManager.getDownloadDBListener();
                                                                            if (downloadDBListener4 != null) {
                                                                                downloadDBListener4.onInitFinish(downloadDBInitInfo);
                                                                            }
                                                                            if (Logger.alog()) {
                                                                                Logger.globalDebug(SqlDownloadCache.TAG, "init", str2 + sqlCacheLoadCompleteCallback);
                                                                            }
                                                                            SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback4 = sqlCacheLoadCompleteCallback;
                                                                            if (sqlCacheLoadCompleteCallback4 != null) {
                                                                                sqlCacheLoadCompleteCallback4.callback(true);
                                                                                SqlDownloadCache.this.cacheSynced = true;
                                                                            }
                                                                            SqlDownloadCache.this.onInitFinish(sparseArray, set, list, true);
                                                                            cleaner.start();
                                                                            throw th2;
                                                                        }
                                                                    }
                                                                } else {
                                                                    str = str2;
                                                                }
                                                                try {
                                                                    if (SqlDownloadCache.mExternalDownload && DownloadFileUtils.isMediaUri(downloadInfo2.getSavePath())) {
                                                                        SqlDownloadCache.mExternalDownloadIdSets.add(Integer.valueOf(downloadInfo2.getId()));
                                                                    }
                                                                    if (SqlDownloadCache.this.checkAndRemoveDownloadInfo(downloadInfo2, z8, optLong, z11)) {
                                                                        if (i2 > 0) {
                                                                            i2--;
                                                                        }
                                                                        if (z11) {
                                                                            try {
                                                                                cleaner.forceUpdateCleanDownloadId(downloadInfo2, false);
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                cursor = rawQuery;
                                                                                c = 0;
                                                                                arrayList = arrayList3;
                                                                                str2 = str;
                                                                                th.printStackTrace();
                                                                                Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                                                                Cursor[] cursorArr3 = new Cursor[1];
                                                                                cursorArr3[c] = cursor;
                                                                                DownloadUtils.safeClose(cursorArr3);
                                                                                SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                                                                SqlDownloadCache.this.deleteChunkTable();
                                                                                SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                                                                downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                                                if (Logger.alog()) {
                                                                                }
                                                                                downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                                                DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                if (downloadDBListener != null) {
                                                                                }
                                                                                if (Logger.alog()) {
                                                                                }
                                                                                sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                                                z = true;
                                                                            }
                                                                        } else {
                                                                            SqlDownloadCache.this.removeDownloadTaskData(downloadInfo2.getId());
                                                                        }
                                                                    } else {
                                                                        if (z11 && downloadInfo2.getCacheLifeTimeMax() == 0) {
                                                                            cleaner.updateCleanDownloadId(downloadInfo2);
                                                                        }
                                                                        try {
                                                                            if (!DownloadHelper.hitSkipDbInitScene(skipDbInitSceneSet, skipDbInitExpectMimeTypeSet, dbInitSceneSet, downloadInfo2.getMimeType(), downloadInfo2.getMonitorScene())) {
                                                                                if (z3) {
                                                                                    SqlDownloadHelper.parseAllRemainingDownloadInfo(rawQuery, downloadInfo2);
                                                                                }
                                                                                if (!z9) {
                                                                                    downloadInfo2.setStatusAtDbInit(downloadInfo2.getRealStatus());
                                                                                }
                                                                                if (downloadInfo2.isCanResumeFromBreakPointStatus()) {
                                                                                    downloadInfo2.setDBInitStatus(downloadInfo2.getStatus());
                                                                                    downloadInfo2.setStatus(-5);
                                                                                    if (z6 && !z9) {
                                                                                        sparseArray2.put(downloadInfo2.getId(), downloadInfo2);
                                                                                    }
                                                                                }
                                                                                if (!TextUtils.isEmpty(downloadInfo2.getSavePath()) && !TextUtils.isEmpty(downloadInfo2.getName())) {
                                                                                    if (downloadInfo2.getStatus() != 1 || downloadInfo2.getCurBytes() > 0) {
                                                                                        if (downloadInfo2.getStatus() != -3 && downloadInfo2.getStatus() != 11) {
                                                                                            if (z3) {
                                                                                                if (!downloadInfo2.isFileDataValidOptimize()) {
                                                                                                    downloadInfo2.reset();
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        z5 = false;
                                                                                    } else {
                                                                                        z5 = true;
                                                                                    }
                                                                                    z4 = z3;
                                                                                    if (downloadInfo2.getStatus() == 11) {
                                                                                        downloadInfo2.setStatus(-5);
                                                                                    }
                                                                                    if (z10) {
                                                                                        try {
                                                                                            set3 = skipDbInitExpectMimeTypeSet;
                                                                                            set4 = skipDbInitSceneSet;
                                                                                            boolean z13 = z5;
                                                                                            ArrayList arrayList4 = arrayList3;
                                                                                            set2 = dbInitSceneSet;
                                                                                            iDownloadIdGeneratorService2 = iDownloadIdGeneratorService;
                                                                                            c = 0;
                                                                                            try {
                                                                                                boolean handleSuccess = SqlDownloadCache.this.handleSuccess(downloadInfo2, z7, z13, cleaner, z11);
                                                                                                downloadInfo = downloadInfo2;
                                                                                                arrayList = arrayList4;
                                                                                                z5 = handleSuccess;
                                                                                            } catch (Throwable th4) {
                                                                                                th = th4;
                                                                                                cursor = rawQuery;
                                                                                                arrayList = arrayList4;
                                                                                                str2 = str;
                                                                                                th.printStackTrace();
                                                                                                Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                                                                                Cursor[] cursorArr32 = new Cursor[1];
                                                                                                cursorArr32[c] = cursor;
                                                                                                DownloadUtils.safeClose(cursorArr32);
                                                                                                SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                                                                                SqlDownloadCache.this.deleteChunkTable();
                                                                                                SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                                                                                downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                                                                if (Logger.alog()) {
                                                                                                }
                                                                                                downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                                                                DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                                downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                                if (downloadDBListener != null) {
                                                                                                }
                                                                                                if (Logger.alog()) {
                                                                                                }
                                                                                                sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                                                                z = true;
                                                                                            }
                                                                                        } catch (Throwable th5) {
                                                                                            th = th5;
                                                                                            c = 0;
                                                                                            cursor = rawQuery;
                                                                                            arrayList = arrayList3;
                                                                                            str2 = str;
                                                                                            th.printStackTrace();
                                                                                            Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                                                                            Cursor[] cursorArr322 = new Cursor[1];
                                                                                            cursorArr322[c] = cursor;
                                                                                            DownloadUtils.safeClose(cursorArr322);
                                                                                            SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                                                                            SqlDownloadCache.this.deleteChunkTable();
                                                                                            SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                                                                            downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                                                            if (Logger.alog()) {
                                                                                            }
                                                                                            downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                            if (downloadDBListener != null) {
                                                                                            }
                                                                                            if (Logger.alog()) {
                                                                                            }
                                                                                            sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                                                            z = true;
                                                                                        }
                                                                                    } else {
                                                                                        set2 = dbInitSceneSet;
                                                                                        set3 = skipDbInitExpectMimeTypeSet;
                                                                                        set4 = skipDbInitSceneSet;
                                                                                        iDownloadIdGeneratorService2 = iDownloadIdGeneratorService;
                                                                                        arrayList = arrayList3;
                                                                                        c = 0;
                                                                                        if (DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo2.getStatus(), downloadInfo2.getSavePath(), downloadInfo2.getName())) {
                                                                                            if (Logger.debug()) {
                                                                                                downloadInfo = downloadInfo2;
                                                                                                Logger.taskDebug(SqlDownloadCache.TAG, downloadInfo, "run", "Download success and file not exist,downloadid=" + downloadInfo2.getId() + "path=" + downloadInfo2.getSavePath() + "/" + downloadInfo2.getName());
                                                                                            } else {
                                                                                                downloadInfo = downloadInfo2;
                                                                                            }
                                                                                            if (z7) {
                                                                                                z5 = true;
                                                                                            } else {
                                                                                                downloadInfo.erase();
                                                                                            }
                                                                                        } else {
                                                                                            downloadInfo = downloadInfo2;
                                                                                        }
                                                                                    }
                                                                                    if (!z5) {
                                                                                        try {
                                                                                            arrayList.add(downloadInfo);
                                                                                        } catch (Throwable th6) {
                                                                                            th = th6;
                                                                                            cursor = rawQuery;
                                                                                            str2 = str;
                                                                                            th.printStackTrace();
                                                                                            Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                                                                            Cursor[] cursorArr3222 = new Cursor[1];
                                                                                            cursorArr3222[c] = cursor;
                                                                                            DownloadUtils.safeClose(cursorArr3222);
                                                                                            SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                                                                            SqlDownloadCache.this.deleteChunkTable();
                                                                                            SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                                                                            downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                                                            if (Logger.alog()) {
                                                                                            }
                                                                                            downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                            if (downloadDBListener != null) {
                                                                                            }
                                                                                            if (Logger.alog()) {
                                                                                            }
                                                                                            sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                                                            z = true;
                                                                                        }
                                                                                    } else {
                                                                                        if (!z6) {
                                                                                            int id2 = downloadInfo.getId();
                                                                                            int generate2 = ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(downloadInfo);
                                                                                            if (generate2 != id2) {
                                                                                                downloadInfo.setId(generate2);
                                                                                                sparseArray2.put(id2, downloadInfo);
                                                                                            }
                                                                                        } else if (!z2 && (generate = iDownloadIdGeneratorService2.generate(downloadInfo)) != (id = downloadInfo.getId())) {
                                                                                            downloadInfo.setId(generate);
                                                                                            sparseArray2.put(id, downloadInfo);
                                                                                        }
                                                                                        if (!z11 && downloadInfo.getCacheLifeTimeMax() == 0) {
                                                                                            cleaner.updateCleanDownloadId(downloadInfo);
                                                                                        }
                                                                                        if (list != null && set != null) {
                                                                                            if (!z9) {
                                                                                                SqlDownloadCache.this.checkAndReportToMonitor(downloadInfo);
                                                                                            }
                                                                                            List list3 = list2;
                                                                                            if (list3 != null && !list3.isEmpty() && list2.contains(downloadInfo.getMimeType())) {
                                                                                                int realStatus = downloadInfo.getRealStatus();
                                                                                                if (DownloadSetting.obtain(downloadInfo).optInt("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi()) {
                                                                                                    list.add(downloadInfo);
                                                                                                }
                                                                                            }
                                                                                            if (i2 > 0) {
                                                                                                int i3 = i2 - 1;
                                                                                                if (i2 <= 0 || SqlDownloadCache.isHoldDownloadInfo(downloadInfo.getUrl())) {
                                                                                                    i2 = i3;
                                                                                                } else {
                                                                                                    set.add(Integer.valueOf(downloadInfo.getId()));
                                                                                                    iDownloadIdGeneratorService = iDownloadIdGeneratorService2;
                                                                                                    arrayList3 = arrayList;
                                                                                                    i2 = i3;
                                                                                                    skipDbInitExpectMimeTypeSet = set3;
                                                                                                    skipDbInitSceneSet = set4;
                                                                                                    z3 = z4;
                                                                                                    dbInitSceneSet = set2;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        sparseArray.put(downloadInfo.getId(), downloadInfo);
                                                                                    }
                                                                                    iDownloadIdGeneratorService = iDownloadIdGeneratorService2;
                                                                                    arrayList3 = arrayList;
                                                                                    skipDbInitExpectMimeTypeSet = set3;
                                                                                    skipDbInitSceneSet = set4;
                                                                                    z3 = z4;
                                                                                    dbInitSceneSet = set2;
                                                                                }
                                                                                z4 = z3;
                                                                                set2 = dbInitSceneSet;
                                                                                set3 = skipDbInitExpectMimeTypeSet;
                                                                                set4 = skipDbInitSceneSet;
                                                                                downloadInfo = downloadInfo2;
                                                                                iDownloadIdGeneratorService2 = iDownloadIdGeneratorService;
                                                                                arrayList = arrayList3;
                                                                                c = 0;
                                                                                z5 = true;
                                                                                if (!z5) {
                                                                                }
                                                                                iDownloadIdGeneratorService = iDownloadIdGeneratorService2;
                                                                                arrayList3 = arrayList;
                                                                                skipDbInitExpectMimeTypeSet = set3;
                                                                                skipDbInitSceneSet = set4;
                                                                                z3 = z4;
                                                                                dbInitSceneSet = set2;
                                                                            } else if (i2 > 0) {
                                                                                i2--;
                                                                            }
                                                                        } catch (Throwable th7) {
                                                                            th = th7;
                                                                            c = 0;
                                                                            arrayList = arrayList3;
                                                                        }
                                                                    }
                                                                    str2 = str;
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    arrayList = arrayList3;
                                                                    c = 0;
                                                                }
                                                            }
                                                            String str3 = str2;
                                                            ArrayList arrayList5 = arrayList3;
                                                            DownloadUtils.safeClose(rawQuery);
                                                            SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList5);
                                                            SqlDownloadCache.this.deleteChunkTable();
                                                            SqlDownloadCache.this.loadCacheFromDB(arrayList5, sparseArray2);
                                                            downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                            if (Logger.alog()) {
                                                                Logger.globalDebug(SqlDownloadCache.TAG, "init", "init time=" + downloadDBInitInfo.initDuration);
                                                            }
                                                            downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                            downloadDBListener2 = DownloadComponentManager.getDownloadDBListener();
                                                            if (downloadDBListener2 != null) {
                                                                downloadDBListener2.onInitFinish(downloadDBInitInfo);
                                                            }
                                                            if (Logger.alog()) {
                                                                Logger.globalDebug(SqlDownloadCache.TAG, "init", str3 + sqlCacheLoadCompleteCallback);
                                                            }
                                                            sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                            z = true;
                                                        }
                                                    }
                                                    z3 = z12;
                                                    i2 = i;
                                                    while (rawQuery.moveToNext()) {
                                                    }
                                                    String str32 = str2;
                                                    ArrayList arrayList52 = arrayList3;
                                                    DownloadUtils.safeClose(rawQuery);
                                                    SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList52);
                                                    SqlDownloadCache.this.deleteChunkTable();
                                                    SqlDownloadCache.this.loadCacheFromDB(arrayList52, sparseArray2);
                                                    downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                                    if (Logger.alog()) {
                                                    }
                                                    downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                    downloadDBListener2 = DownloadComponentManager.getDownloadDBListener();
                                                    if (downloadDBListener2 != null) {
                                                    }
                                                    if (Logger.alog()) {
                                                    }
                                                    sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                                    z = true;
                                                }
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            cursor = rawQuery;
                                            arrayList = arrayList3;
                                            c = 0;
                                            th.printStackTrace();
                                            Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                            Cursor[] cursorArr32222 = new Cursor[1];
                                            cursorArr32222[c] = cursor;
                                            DownloadUtils.safeClose(cursorArr32222);
                                            SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                            SqlDownloadCache.this.deleteChunkTable();
                                            SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                            downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                            if (Logger.alog()) {
                                            }
                                            downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                            if (downloadDBListener != null) {
                                            }
                                            if (Logger.alog()) {
                                            }
                                            sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                            z = true;
                                        }
                                    }
                                    count = 0;
                                    if (z6) {
                                    }
                                    i = count;
                                    iDownloadIdGeneratorService = null;
                                    z2 = true;
                                    downloadDBInitInfo.diskCacheCount = rawQuery.getCount();
                                    if (Logger.alog()) {
                                    }
                                    if (z12) {
                                    }
                                    z3 = z12;
                                    i2 = i;
                                    while (rawQuery.moveToNext()) {
                                    }
                                    String str322 = str2;
                                    ArrayList arrayList522 = arrayList3;
                                    DownloadUtils.safeClose(rawQuery);
                                    SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList522);
                                    SqlDownloadCache.this.deleteChunkTable();
                                    SqlDownloadCache.this.loadCacheFromDB(arrayList522, sparseArray2);
                                    downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                    if (Logger.alog()) {
                                    }
                                    downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                    downloadDBListener2 = DownloadComponentManager.getDownloadDBListener();
                                    if (downloadDBListener2 != null) {
                                    }
                                    if (Logger.alog()) {
                                    }
                                    sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                    z = true;
                                } catch (Throwable th10) {
                                    th = th10;
                                    arrayList = arrayList3;
                                    c = 0;
                                    cursor = rawQuery;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                arrayList = arrayList3;
                                c = 0;
                                cursor = null;
                                th.printStackTrace();
                                Logger.globalError(SqlDownloadCache.TAG, "init", "Error:" + th);
                                Cursor[] cursorArr322222 = new Cursor[1];
                                cursorArr322222[c] = cursor;
                                DownloadUtils.safeClose(cursorArr322222);
                                SqlDownloadCache.this.clearAntiHijackDirIfNeeded(arrayList);
                                SqlDownloadCache.this.deleteChunkTable();
                                SqlDownloadCache.this.loadCacheFromDB(arrayList, sparseArray2);
                                downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                                if (Logger.alog()) {
                                }
                                downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                                DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                if (downloadDBListener != null) {
                                }
                                if (Logger.alog()) {
                                }
                                sqlCacheLoadCompleteCallback2 = sqlCacheLoadCompleteCallback;
                                z = true;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            arrayList = arrayList2;
                        }
                    } else {
                        new DownloadDBInitRunner(SqlDownloadCache.database, downloadDBInitInfo, sparseArray, set, list, list2, sqlCacheLoadCompleteCallback, SqlDownloadCache.this.callback, SqlDownloadCache.this.singleLoadCountLimit, SqlDownloadCache.this.singleLoadSleepTimeMs).start();
                        SqlDownloadCache.this.cacheSynced = true;
                    }
                }
            };
            ExecutorService dBThreadExecutorService = DownloadComponentManager.getDBThreadExecutorService();
            if (dBThreadExecutorService != null) {
                dBThreadExecutorService.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "init", "Error2:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(36:1|(1:3)(1:328)|4|(1:6)(1:327)|7|(1:9)(1:326)|10|(1:12)(1:325)|13|(1:15)(1:324)|16|(1:18)(1:323)|19|(1:21)(1:322)|22|23|(3:26|27|(16:29|(1:316)(2:33|34)|35|36|(1:38)|(1:311)(3:42|43|(3:45|46|47)(10:307|49|(14:(1:54)(2:293|294)|55|56|(3:58|59|60)(1:288)|62|63|(1:67)|68|69|70|(5:267|(1:269)|(2:274|275)(1:271)|272|273)(4:72|(1:76)|77|(4:262|(1:264)|265|266)(18:79|(3:81|82|83)(1:261)|(1:85)|86|87|88|(2:90|(1:93))|94|(3:197|198|(1:200)(18:201|202|(4:242|243|244|(11:246|218|(2:220|221)|(3:223|224|225)(3:230|(3:232|(1:234)|(2:236|97)(1:237))|238)|(3:99|100|101)(7:146|(1:(2:149|(1:151))(1:188))(4:189|190|191|(1:193))|(1:155)|(3:(1:159)|(2:165|(1:172)(1:171))|(2:174|(3:184|185|186)(2:178|(6:180|181|182|109|110|111)(3:183|110|111))))|187|185|186)|102|(4:104|105|106|107)(1:138)|108|109|110|111))|204|205|206|(11:(2:211|(2:213|214))(1:215)|218|(0)|(0)(0)|(0)(0)|102|(0)(0)|108|109|110|111)|217|218|(0)|(0)(0)|(0)(0)|102|(0)(0)|108|109|110|111))|96|97|(0)(0)|102|(0)(0)|108|109|110|111))|112|50|51)|295|296|(1:298)|299|(1:301)|125|126))|48|49|(2:50|51)|295|296|(0)|299|(0)|125|126))|318|(1:31)|316|35|36|(0)|(0)|311|48|49|(2:50|51)|295|296|(0)|299|(0)|125|126|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x02a1, code lost:
    
        if (r3.isFileDataValid() == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x04f5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02cd A[Catch: all -> 0x02ff, TryCatch #20 {all -> 0x02ff, blocks: (B:225:0x02c8, B:230:0x02cd, B:232:0x02e8, B:234:0x02ee, B:237:0x02f9), top: B:224:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb A[Catch: all -> 0x00e7, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x00e7, blocks: (B:27:0x00be, B:29:0x00c9, B:31:0x00d2, B:33:0x00d8, B:38:0x00fb), top: B:26:0x00be }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0321  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void newBatchInit(DownloadDBInitInfo downloadDBInitInfo, SparseArray<DownloadInfo> sparseArray, Set<Integer> set, List<DownloadInfo> list, List<String> list2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback, Cleaner cleaner) {
        ArrayList arrayList;
        SparseArray<DownloadInfo> sparseArray2;
        String str;
        int i;
        String str2;
        DownloadDBInitInfo downloadDBInitInfo2;
        Cursor cursor;
        IDownloadDBListener downloadDBListener;
        Set<String> set2;
        Set<String> set3;
        int i2;
        boolean z;
        int i3;
        IDownloadIdGeneratorService iDownloadIdGeneratorService;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        IDownloadDBListener downloadDBListener2;
        DownloadInfo parseDownloadInfo;
        String str3;
        boolean z5;
        Cursor cursor2;
        IDownloadIdGeneratorService iDownloadIdGeneratorService2;
        boolean z6;
        Cursor cursor3;
        boolean z7;
        Cursor cursor4;
        boolean z8;
        boolean z9;
        boolean z10;
        Set<String> set4;
        Set<String> set5;
        boolean z11;
        IDownloadIdGeneratorService iDownloadIdGeneratorService3;
        int i6;
        boolean z12;
        int count;
        int i7;
        DownloadDBInitInfo downloadDBInitInfo3 = downloadDBInitInfo;
        String str4 = "Run End";
        String str5 = TAG;
        SparseArray<DownloadInfo> sparseArray3 = new SparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        boolean z13 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQL_DOWNLOAD_CACHE_TIME_OPT) > 0;
        boolean z14 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_DOWNLOAD_SUCCESS_AND_NOT_EXISTS) > 0;
        boolean z15 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_EXTERNAL_PUBLIC_DIR_TASK_FOR_Q) > 0;
        boolean z16 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.REMOVE_USELESS_MONITOR_REPORT, 0) > 0;
        boolean z17 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEAN_INSTALLED_APK) > 0;
        long optLong = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.INCOMPLETE_FILE_EXPIRED_TIME);
        boolean z18 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.ASYNC_DB_CLEAN) > 0;
        Set<String> skipDbInitSceneSet = DownloadHelper.getSkipDbInitSceneSet();
        Set<String> skipDbInitExpectMimeTypeSet = DownloadHelper.getSkipDbInitExpectMimeTypeSet();
        Set<String> dbInitSceneSet = DownloadHelper.getDbInitSceneSet();
        Set<String> set6 = skipDbInitExpectMimeTypeSet;
        boolean z19 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.OPTIMIZE_DOWNLOAD_DB_LOAD) > 0;
        try {
            set2 = skipDbInitSceneSet;
            set3 = dbInitSceneSet;
            cursor = database.rawQuery("SELECT * FROM downloader", null);
        } catch (Throwable th) {
            th = th;
            arrayList = arrayList2;
            sparseArray2 = sparseArray3;
            str = "Run End";
            i = 1;
            str2 = TAG;
            downloadDBInitInfo2 = downloadDBInitInfo3;
            cursor = null;
        }
        if (list != null && set != null) {
            try {
                getHotCacheKeys();
                count = cursor.getCount();
                i7 = DOWNLOAD_CACHE_LRU_CAPACITY_MAX;
            } catch (Throwable th2) {
                th = th2;
                arrayList = arrayList2;
                sparseArray2 = sparseArray3;
                str = "Run End";
                z = true;
                DownloadDBInitInfo downloadDBInitInfo4 = downloadDBInitInfo3;
                str2 = str5;
                downloadDBInitInfo2 = downloadDBInitInfo4;
                i = z;
                try {
                    th.printStackTrace();
                    Logger.globalError(str2, "newBatchInit", "Error:" + th);
                    Cursor[] cursorArr = new Cursor[i];
                    cursorArr[0] = cursor;
                    DownloadUtils.safeClose(cursorArr);
                    deleteChunkTable();
                    if (Logger.alog()) {
                    }
                    DownloadDBInitInfo downloadDBInitInfo5 = downloadDBInitInfo2;
                    callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                    this.cacheSynced = i;
                    downloadDBInitInfo5.initDuration = System.currentTimeMillis() - downloadDBInitInfo5.initDuration;
                    downloadDBInitInfo5.memoryCacheCount = sparseArray.size();
                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                    downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                    if (downloadDBListener != null) {
                    }
                    cleaner.start();
                } catch (Throwable th3) {
                    Cursor[] cursorArr2 = new Cursor[i];
                    cursorArr2[0] = cursor;
                    DownloadUtils.safeClose(cursorArr2);
                    deleteChunkTable();
                    if (Logger.alog()) {
                        Logger.globalDebug(str2, "newBatchInit", str);
                    }
                    DownloadDBInitInfo downloadDBInitInfo6 = downloadDBInitInfo2;
                    callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                    this.cacheSynced = i;
                    downloadDBInitInfo6.initDuration = System.currentTimeMillis() - downloadDBInitInfo6.initDuration;
                    downloadDBInitInfo6.memoryCacheCount = sparseArray.size();
                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                    IDownloadDBListener downloadDBListener3 = DownloadComponentManager.getDownloadDBListener();
                    if (downloadDBListener3 != null) {
                        downloadDBListener3.onInitFinish(downloadDBInitInfo6);
                    }
                    cleaner.start();
                    throw th3;
                }
            }
            if (count > i7) {
                i2 = cursor.getCount() - i7;
                if (z13 || cursor.getCount() <= 0) {
                    i3 = i2;
                    iDownloadIdGeneratorService = null;
                    z2 = true;
                } else {
                    iDownloadIdGeneratorService = (IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class);
                    z2 = iDownloadIdGeneratorService.isDefaultIdGenerator();
                    i3 = i2;
                }
                downloadDBInitInfo3.diskCacheCount = cursor.getCount();
                if (Logger.alog()) {
                    Logger.globalDebug(TAG, "newBatchInit", "DownloadInfo Count:" + downloadDBInitInfo3.diskCacheCount);
                }
                if (z19 || !z19) {
                    z3 = true;
                } else {
                    try {
                    } catch (Throwable th4) {
                        th = th4;
                        z3 = true;
                        arrayList = arrayList2;
                        sparseArray2 = sparseArray3;
                        str = str4;
                        z = z3;
                        DownloadDBInitInfo downloadDBInitInfo42 = downloadDBInitInfo3;
                        str2 = str5;
                        downloadDBInitInfo2 = downloadDBInitInfo42;
                        i = z;
                        th.printStackTrace();
                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                        Cursor[] cursorArr3 = new Cursor[i];
                        cursorArr3[0] = cursor;
                        DownloadUtils.safeClose(cursorArr3);
                        deleteChunkTable();
                        if (Logger.alog()) {
                        }
                        DownloadDBInitInfo downloadDBInitInfo52 = downloadDBInitInfo2;
                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                        this.cacheSynced = i;
                        downloadDBInitInfo52.initDuration = System.currentTimeMillis() - downloadDBInitInfo52.initDuration;
                        downloadDBInitInfo52.memoryCacheCount = sparseArray.size();
                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                        if (downloadDBListener != null) {
                        }
                        cleaner.start();
                    }
                    if (SqlDownloadHelper.loadDownloadInfoIndex(cursor)) {
                        z3 = true;
                        try {
                            DownloadInfo.setOptimizeMonitorLoad(true);
                        } catch (Throwable th5) {
                            th = th5;
                            arrayList = arrayList2;
                            sparseArray2 = sparseArray3;
                            str = str4;
                            z = z3;
                            DownloadDBInitInfo downloadDBInitInfo422 = downloadDBInitInfo3;
                            str2 = str5;
                            downloadDBInitInfo2 = downloadDBInitInfo422;
                            i = z;
                            th.printStackTrace();
                            Logger.globalError(str2, "newBatchInit", "Error:" + th);
                            Cursor[] cursorArr32 = new Cursor[i];
                            cursorArr32[0] = cursor;
                            DownloadUtils.safeClose(cursorArr32);
                            deleteChunkTable();
                            if (Logger.alog()) {
                            }
                            DownloadDBInitInfo downloadDBInitInfo522 = downloadDBInitInfo2;
                            callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                            this.cacheSynced = i;
                            downloadDBInitInfo522.initDuration = System.currentTimeMillis() - downloadDBInitInfo522.initDuration;
                            downloadDBInitInfo522.memoryCacheCount = sparseArray.size();
                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                            if (downloadDBListener != null) {
                            }
                            cleaner.start();
                        }
                    } else {
                        z3 = true;
                        i5 = i3;
                        z4 = false;
                        i4 = 0;
                        while (cursor.moveToNext()) {
                            try {
                                if (z4) {
                                    parseDownloadInfo = SqlDownloadHelper.parsePartialDownloadInfo(cursor);
                                } else {
                                    try {
                                        parseDownloadInfo = DownloadHelper.parseDownloadInfo(cursor);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        arrayList = arrayList2;
                                        sparseArray2 = sparseArray3;
                                        str2 = str5;
                                        str3 = str4;
                                        z5 = z3;
                                        downloadDBInitInfo2 = downloadDBInitInfo;
                                        str = str3;
                                        i = z5;
                                        th.printStackTrace();
                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                        Cursor[] cursorArr322 = new Cursor[i];
                                        cursorArr322[0] = cursor;
                                        DownloadUtils.safeClose(cursorArr322);
                                        deleteChunkTable();
                                        if (Logger.alog()) {
                                        }
                                        DownloadDBInitInfo downloadDBInitInfo5222 = downloadDBInitInfo2;
                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                        this.cacheSynced = i;
                                        downloadDBInitInfo5222.initDuration = System.currentTimeMillis() - downloadDBInitInfo5222.initDuration;
                                        downloadDBInitInfo5222.memoryCacheCount = sparseArray.size();
                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                        if (downloadDBListener != null) {
                                        }
                                        cleaner.start();
                                    }
                                }
                                DownloadInfo downloadInfo = parseDownloadInfo;
                                long curBytes = downloadInfo.getCurBytes();
                                if (curBytes > 0) {
                                    cursor2 = cursor;
                                    iDownloadIdGeneratorService2 = iDownloadIdGeneratorService;
                                    try {
                                        downloadDBInitInfo3.diskCacheSize += curBytes;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        arrayList = arrayList2;
                                        sparseArray2 = sparseArray3;
                                        str = str4;
                                        z = z3;
                                        cursor = cursor2;
                                        DownloadDBInitInfo downloadDBInitInfo4222 = downloadDBInitInfo3;
                                        str2 = str5;
                                        downloadDBInitInfo2 = downloadDBInitInfo4222;
                                        i = z;
                                        th.printStackTrace();
                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                        Cursor[] cursorArr3222 = new Cursor[i];
                                        cursorArr3222[0] = cursor;
                                        DownloadUtils.safeClose(cursorArr3222);
                                        deleteChunkTable();
                                        if (Logger.alog()) {
                                        }
                                        DownloadDBInitInfo downloadDBInitInfo52222 = downloadDBInitInfo2;
                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                        this.cacheSynced = i;
                                        downloadDBInitInfo52222.initDuration = System.currentTimeMillis() - downloadDBInitInfo52222.initDuration;
                                        downloadDBInitInfo52222.memoryCacheCount = sparseArray.size();
                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                        if (downloadDBListener != null) {
                                        }
                                        cleaner.start();
                                    }
                                } else {
                                    cursor2 = cursor;
                                    iDownloadIdGeneratorService2 = iDownloadIdGeneratorService;
                                }
                                try {
                                    if (mExternalDownload && DownloadFileUtils.isMediaUri(downloadInfo.getSavePath())) {
                                        mExternalDownloadIdSets.add(Integer.valueOf(downloadInfo.getId()));
                                    }
                                    Set<String> set7 = set6;
                                    Set<String> set8 = set2;
                                    str3 = str4;
                                    Set<String> set9 = set3;
                                    Cursor cursor5 = cursor2;
                                    IDownloadIdGeneratorService iDownloadIdGeneratorService4 = iDownloadIdGeneratorService2;
                                    ArrayList arrayList3 = arrayList2;
                                    try {
                                        if (checkAndRemoveDownloadInfo(downloadInfo, z15, optLong, z18)) {
                                            if (i5 > 0) {
                                                i5--;
                                            }
                                            if (z18) {
                                                try {
                                                    cleaner.forceUpdateCleanDownloadId(downloadInfo, false);
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    sparseArray2 = sparseArray3;
                                                    str2 = str5;
                                                    str = str3;
                                                    cursor = cursor5;
                                                    arrayList = arrayList3;
                                                    z7 = true;
                                                    downloadDBInitInfo2 = downloadDBInitInfo;
                                                    i = z7;
                                                    th.printStackTrace();
                                                    Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                    Cursor[] cursorArr32222 = new Cursor[i];
                                                    cursorArr32222[0] = cursor;
                                                    DownloadUtils.safeClose(cursorArr32222);
                                                    deleteChunkTable();
                                                    if (Logger.alog()) {
                                                    }
                                                    DownloadDBInitInfo downloadDBInitInfo522222 = downloadDBInitInfo2;
                                                    callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                    this.cacheSynced = i;
                                                    downloadDBInitInfo522222.initDuration = System.currentTimeMillis() - downloadDBInitInfo522222.initDuration;
                                                    downloadDBInitInfo522222.memoryCacheCount = sparseArray.size();
                                                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                    downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                    if (downloadDBListener != null) {
                                                    }
                                                    cleaner.start();
                                                }
                                            } else {
                                                removeDownloadTaskData(downloadInfo.getId());
                                            }
                                            downloadDBInitInfo3 = downloadDBInitInfo;
                                            str4 = str3;
                                            set2 = set8;
                                            set6 = set7;
                                            set3 = set9;
                                            cursor = cursor5;
                                            iDownloadIdGeneratorService = iDownloadIdGeneratorService4;
                                            arrayList2 = arrayList3;
                                            z3 = true;
                                        } else {
                                            if (z18 && downloadInfo.getCacheLifeTimeMax() == 0) {
                                                cleaner.updateCleanDownloadId(downloadInfo);
                                            }
                                            if (DownloadHelper.hitSkipDbInitScene(set8, set7, set9, downloadInfo.getMimeType(), downloadInfo.getMonitorScene())) {
                                                if (i5 > 0) {
                                                    i5--;
                                                }
                                                downloadDBInitInfo3 = downloadDBInitInfo;
                                                set3 = set9;
                                                set2 = set8;
                                                str4 = str3;
                                                cursor = cursor5;
                                                arrayList2 = arrayList3;
                                                z3 = true;
                                                set6 = set7;
                                                iDownloadIdGeneratorService = iDownloadIdGeneratorService4;
                                            } else {
                                                if (z4) {
                                                    cursor4 = cursor5;
                                                    try {
                                                        SqlDownloadHelper.parseAllRemainingDownloadInfo(cursor4, downloadInfo);
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        cursor = cursor4;
                                                        sparseArray2 = sparseArray3;
                                                        str2 = str5;
                                                        str = str3;
                                                        arrayList = arrayList3;
                                                        z7 = true;
                                                        downloadDBInitInfo2 = downloadDBInitInfo;
                                                        i = z7;
                                                        th.printStackTrace();
                                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                        Cursor[] cursorArr322222 = new Cursor[i];
                                                        cursorArr322222[0] = cursor;
                                                        DownloadUtils.safeClose(cursorArr322222);
                                                        deleteChunkTable();
                                                        if (Logger.alog()) {
                                                        }
                                                        DownloadDBInitInfo downloadDBInitInfo5222222 = downloadDBInitInfo2;
                                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                        this.cacheSynced = i;
                                                        downloadDBInitInfo5222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo5222222.initDuration;
                                                        downloadDBInitInfo5222222.memoryCacheCount = sparseArray.size();
                                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                        if (downloadDBListener != null) {
                                                        }
                                                        cleaner.start();
                                                    }
                                                } else {
                                                    cursor4 = cursor5;
                                                }
                                                if (!z16) {
                                                    downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                                                }
                                                try {
                                                    if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                                        downloadInfo.setDBInitStatus(downloadInfo.getStatus());
                                                        downloadInfo.setStatus(-5);
                                                        if (z13 && !z16) {
                                                            sparseArray3.put(downloadInfo.getId(), downloadInfo);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(downloadInfo.getSavePath())) {
                                                        try {
                                                            if (!TextUtils.isEmpty(downloadInfo.getName())) {
                                                                try {
                                                                    if (downloadInfo.getStatus() == 1) {
                                                                        try {
                                                                            if (downloadInfo.getCurBytes() <= 0) {
                                                                                z10 = true;
                                                                                if (downloadInfo.getStatus() == 11) {
                                                                                    downloadInfo.setStatus(-5);
                                                                                }
                                                                                if (z17) {
                                                                                    z8 = true;
                                                                                    z6 = true;
                                                                                    cursor3 = cursor4;
                                                                                    set3 = set9;
                                                                                    set4 = set7;
                                                                                    set5 = set8;
                                                                                    try {
                                                                                        z11 = handleSuccess(downloadInfo, z14, z10, cleaner, z18);
                                                                                    } catch (Throwable th10) {
                                                                                        th = th10;
                                                                                        sparseArray2 = sparseArray3;
                                                                                        str2 = str5;
                                                                                        cursor = cursor3;
                                                                                        z9 = z8;
                                                                                        str = str3;
                                                                                        arrayList = arrayList3;
                                                                                        z7 = z9;
                                                                                        downloadDBInitInfo2 = downloadDBInitInfo;
                                                                                        i = z7;
                                                                                        th.printStackTrace();
                                                                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                                        Cursor[] cursorArr3222222 = new Cursor[i];
                                                                                        cursorArr3222222[0] = cursor;
                                                                                        DownloadUtils.safeClose(cursorArr3222222);
                                                                                        deleteChunkTable();
                                                                                        if (Logger.alog()) {
                                                                                        }
                                                                                        DownloadDBInitInfo downloadDBInitInfo52222222 = downloadDBInitInfo2;
                                                                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                        this.cacheSynced = i;
                                                                                        downloadDBInitInfo52222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo52222222.initDuration;
                                                                                        downloadDBInitInfo52222222.memoryCacheCount = sparseArray.size();
                                                                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                        if (downloadDBListener != null) {
                                                                                        }
                                                                                        cleaner.start();
                                                                                    }
                                                                                } else {
                                                                                    cursor3 = cursor4;
                                                                                    set3 = set9;
                                                                                    set4 = set7;
                                                                                    set5 = set8;
                                                                                    z6 = true;
                                                                                    z12 = true;
                                                                                    if (DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                                                                        if (Logger.debug()) {
                                                                                            Logger.taskDebug(str5, downloadInfo, "run", "Download success and file not exist");
                                                                                        }
                                                                                        if (z14) {
                                                                                            z11 = z12;
                                                                                            z6 = z12;
                                                                                        } else {
                                                                                            downloadInfo.erase();
                                                                                        }
                                                                                    }
                                                                                    z11 = z10;
                                                                                }
                                                                                if (!z11) {
                                                                                    try {
                                                                                        arrayList3.add(downloadInfo);
                                                                                        arrayList = arrayList3;
                                                                                        sparseArray2 = sparseArray3;
                                                                                        iDownloadIdGeneratorService3 = iDownloadIdGeneratorService4;
                                                                                        sparseArray3 = sparseArray;
                                                                                    } catch (Throwable th11) {
                                                                                        th = th11;
                                                                                        arrayList = arrayList3;
                                                                                        sparseArray2 = sparseArray3;
                                                                                        str2 = str5;
                                                                                        cursor = cursor3;
                                                                                        str = str3;
                                                                                        z7 = z6;
                                                                                        downloadDBInitInfo2 = downloadDBInitInfo;
                                                                                        i = z7;
                                                                                        th.printStackTrace();
                                                                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                                        Cursor[] cursorArr32222222 = new Cursor[i];
                                                                                        cursorArr32222222[0] = cursor;
                                                                                        DownloadUtils.safeClose(cursorArr32222222);
                                                                                        deleteChunkTable();
                                                                                        if (Logger.alog()) {
                                                                                        }
                                                                                        DownloadDBInitInfo downloadDBInitInfo522222222 = downloadDBInitInfo2;
                                                                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                        this.cacheSynced = i;
                                                                                        downloadDBInitInfo522222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo522222222.initDuration;
                                                                                        downloadDBInitInfo522222222.memoryCacheCount = sparseArray.size();
                                                                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                        if (downloadDBListener != null) {
                                                                                        }
                                                                                        cleaner.start();
                                                                                    }
                                                                                } else {
                                                                                    arrayList2 = arrayList3;
                                                                                    if (!z13) {
                                                                                        iDownloadIdGeneratorService = iDownloadIdGeneratorService4;
                                                                                        try {
                                                                                            int id = downloadInfo.getId();
                                                                                            int generate = ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(downloadInfo);
                                                                                            if (generate != id) {
                                                                                                downloadInfo.setId(generate);
                                                                                                sparseArray3.put(id, downloadInfo);
                                                                                            }
                                                                                        } catch (Throwable th12) {
                                                                                            th = th12;
                                                                                            arrayList = arrayList2;
                                                                                            sparseArray2 = sparseArray3;
                                                                                            str2 = str5;
                                                                                            downloadDBInitInfo2 = downloadDBInitInfo;
                                                                                            cursor = cursor3;
                                                                                            z5 = z6;
                                                                                            str = str3;
                                                                                            i = z5;
                                                                                            th.printStackTrace();
                                                                                            Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                                            Cursor[] cursorArr322222222 = new Cursor[i];
                                                                                            cursorArr322222222[0] = cursor;
                                                                                            DownloadUtils.safeClose(cursorArr322222222);
                                                                                            deleteChunkTable();
                                                                                            if (Logger.alog()) {
                                                                                            }
                                                                                            DownloadDBInitInfo downloadDBInitInfo5222222222 = downloadDBInitInfo2;
                                                                                            callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                            this.cacheSynced = i;
                                                                                            downloadDBInitInfo5222222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo5222222222.initDuration;
                                                                                            downloadDBInitInfo5222222222.memoryCacheCount = sparseArray.size();
                                                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                            if (downloadDBListener != null) {
                                                                                            }
                                                                                            cleaner.start();
                                                                                        }
                                                                                    } else if (z2) {
                                                                                        iDownloadIdGeneratorService = iDownloadIdGeneratorService4;
                                                                                    } else {
                                                                                        int id2 = downloadInfo.getId();
                                                                                        iDownloadIdGeneratorService = iDownloadIdGeneratorService4;
                                                                                        int generate2 = iDownloadIdGeneratorService.generate(downloadInfo);
                                                                                        if (generate2 != id2) {
                                                                                            downloadInfo.setId(generate2);
                                                                                            sparseArray3.put(id2, downloadInfo);
                                                                                        }
                                                                                    }
                                                                                    if (!z18 && downloadInfo.getCacheLifeTimeMax() == 0) {
                                                                                        cleaner.updateCleanDownloadId(downloadInfo);
                                                                                    }
                                                                                    try {
                                                                                        if (list != null && set != null) {
                                                                                            if (!z16) {
                                                                                                checkAndReportToMonitor(downloadInfo);
                                                                                            }
                                                                                            if (list2 != null && !list2.isEmpty() && list2.contains(downloadInfo.getMimeType())) {
                                                                                                int realStatus = downloadInfo.getRealStatus();
                                                                                                if (DownloadSetting.obtain(downloadInfo).optInt("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi()) {
                                                                                                    list.add(downloadInfo);
                                                                                                }
                                                                                            }
                                                                                            if (i5 > 0) {
                                                                                                int i8 = i5 - 1;
                                                                                                if (i5 > 0 && !isHoldDownloadInfo(downloadInfo.getUrl())) {
                                                                                                    set.add(Integer.valueOf(downloadInfo.getId()));
                                                                                                    int i9 = i4 + 1;
                                                                                                    if (i9 >= this.singleLoadCountLimit) {
                                                                                                        IDownloadIdGeneratorService iDownloadIdGeneratorService5 = iDownloadIdGeneratorService;
                                                                                                        SparseArray<DownloadInfo> sparseArray4 = sparseArray3;
                                                                                                        String str6 = str5;
                                                                                                        callbackDownloadInfo(false, arrayList2, sparseArray3, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                                        str5 = str6;
                                                                                                        cursor = cursor3;
                                                                                                        i5 = i8;
                                                                                                        iDownloadIdGeneratorService = iDownloadIdGeneratorService5;
                                                                                                        arrayList2 = arrayList2;
                                                                                                        set2 = set5;
                                                                                                        sparseArray3 = sparseArray4;
                                                                                                        i4 = 0;
                                                                                                        downloadDBInitInfo3 = downloadDBInitInfo;
                                                                                                        z3 = z6;
                                                                                                        str4 = str3;
                                                                                                        set6 = set4;
                                                                                                    } else {
                                                                                                        downloadDBInitInfo3 = downloadDBInitInfo;
                                                                                                        i4 = i9;
                                                                                                        cursor = cursor3;
                                                                                                        i5 = i8;
                                                                                                        set2 = set5;
                                                                                                        z3 = z6;
                                                                                                        str4 = str3;
                                                                                                        set6 = set4;
                                                                                                    }
                                                                                                } else {
                                                                                                    iDownloadIdGeneratorService3 = iDownloadIdGeneratorService;
                                                                                                    arrayList = arrayList2;
                                                                                                    sparseArray2 = sparseArray3;
                                                                                                    i5 = i8;
                                                                                                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        sparseArray.put(downloadInfo.getId(), downloadInfo);
                                                                                    } catch (Throwable th13) {
                                                                                        th = th13;
                                                                                        str2 = str5;
                                                                                        downloadDBInitInfo2 = downloadDBInitInfo;
                                                                                        cursor = cursor3;
                                                                                        z5 = z6;
                                                                                        str = str3;
                                                                                        i = z5;
                                                                                        th.printStackTrace();
                                                                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                                        Cursor[] cursorArr3222222222 = new Cursor[i];
                                                                                        cursorArr3222222222[0] = cursor;
                                                                                        DownloadUtils.safeClose(cursorArr3222222222);
                                                                                        deleteChunkTable();
                                                                                        if (Logger.alog()) {
                                                                                        }
                                                                                        DownloadDBInitInfo downloadDBInitInfo52222222222 = downloadDBInitInfo2;
                                                                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                        this.cacheSynced = i;
                                                                                        downloadDBInitInfo52222222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo52222222222.initDuration;
                                                                                        downloadDBInitInfo52222222222.memoryCacheCount = sparseArray.size();
                                                                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                        if (downloadDBListener != null) {
                                                                                        }
                                                                                        cleaner.start();
                                                                                    }
                                                                                    iDownloadIdGeneratorService3 = iDownloadIdGeneratorService;
                                                                                    arrayList = arrayList2;
                                                                                    sparseArray2 = sparseArray3;
                                                                                }
                                                                                i6 = i4 + 1;
                                                                                if (i6 < this.singleLoadCountLimit) {
                                                                                    str2 = str5;
                                                                                    try {
                                                                                        callbackDownloadInfo(false, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                        i4 = 0;
                                                                                    } catch (Throwable th14) {
                                                                                        th = th14;
                                                                                        downloadDBInitInfo2 = downloadDBInitInfo;
                                                                                        cursor = cursor3;
                                                                                        z5 = z6;
                                                                                        str = str3;
                                                                                        i = z5;
                                                                                        th.printStackTrace();
                                                                                        Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                                        Cursor[] cursorArr32222222222 = new Cursor[i];
                                                                                        cursorArr32222222222[0] = cursor;
                                                                                        DownloadUtils.safeClose(cursorArr32222222222);
                                                                                        deleteChunkTable();
                                                                                        if (Logger.alog()) {
                                                                                        }
                                                                                        DownloadDBInitInfo downloadDBInitInfo522222222222 = downloadDBInitInfo2;
                                                                                        callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                                        this.cacheSynced = i;
                                                                                        downloadDBInitInfo522222222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo522222222222.initDuration;
                                                                                        downloadDBInitInfo522222222222.memoryCacheCount = sparseArray.size();
                                                                                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                                        downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                                        if (downloadDBListener != null) {
                                                                                        }
                                                                                        cleaner.start();
                                                                                    }
                                                                                } else {
                                                                                    str2 = str5;
                                                                                    i4 = i6;
                                                                                }
                                                                                str5 = str2;
                                                                                cursor = cursor3;
                                                                                iDownloadIdGeneratorService = iDownloadIdGeneratorService3;
                                                                                arrayList2 = arrayList;
                                                                                set2 = set5;
                                                                                sparseArray3 = sparseArray2;
                                                                                downloadDBInitInfo3 = downloadDBInitInfo;
                                                                                z3 = z6;
                                                                                str4 = str3;
                                                                                set6 = set4;
                                                                            }
                                                                        } catch (Throwable th15) {
                                                                            th = th15;
                                                                            z9 = true;
                                                                            cursor = cursor4;
                                                                            sparseArray2 = sparseArray3;
                                                                            str2 = str5;
                                                                            str = str3;
                                                                            arrayList = arrayList3;
                                                                            z7 = z9;
                                                                            downloadDBInitInfo2 = downloadDBInitInfo;
                                                                            i = z7;
                                                                            th.printStackTrace();
                                                                            Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                            Cursor[] cursorArr322222222222 = new Cursor[i];
                                                                            cursorArr322222222222[0] = cursor;
                                                                            DownloadUtils.safeClose(cursorArr322222222222);
                                                                            deleteChunkTable();
                                                                            if (Logger.alog()) {
                                                                            }
                                                                            DownloadDBInitInfo downloadDBInitInfo5222222222222 = downloadDBInitInfo2;
                                                                            callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                            this.cacheSynced = i;
                                                                            downloadDBInitInfo5222222222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo5222222222222.initDuration;
                                                                            downloadDBInitInfo5222222222222.memoryCacheCount = sparseArray.size();
                                                                            DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                            downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                            if (downloadDBListener != null) {
                                                                            }
                                                                            cleaner.start();
                                                                        }
                                                                    }
                                                                    if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11) {
                                                                        if (z4) {
                                                                            if (!downloadInfo.isFileDataValidOptimize()) {
                                                                                downloadInfo.reset();
                                                                            }
                                                                        }
                                                                        if (downloadInfo.getStatus() == 11) {
                                                                        }
                                                                        if (z17) {
                                                                        }
                                                                        if (!z11) {
                                                                        }
                                                                        i6 = i4 + 1;
                                                                        if (i6 < this.singleLoadCountLimit) {
                                                                        }
                                                                        str5 = str2;
                                                                        cursor = cursor3;
                                                                        iDownloadIdGeneratorService = iDownloadIdGeneratorService3;
                                                                        arrayList2 = arrayList;
                                                                        set2 = set5;
                                                                        sparseArray3 = sparseArray2;
                                                                        downloadDBInitInfo3 = downloadDBInitInfo;
                                                                        z3 = z6;
                                                                        str4 = str3;
                                                                        set6 = set4;
                                                                    }
                                                                    z10 = false;
                                                                    if (downloadInfo.getStatus() == 11) {
                                                                    }
                                                                    if (z17) {
                                                                    }
                                                                    if (!z11) {
                                                                    }
                                                                    i6 = i4 + 1;
                                                                    if (i6 < this.singleLoadCountLimit) {
                                                                    }
                                                                    str5 = str2;
                                                                    cursor = cursor3;
                                                                    iDownloadIdGeneratorService = iDownloadIdGeneratorService3;
                                                                    arrayList2 = arrayList;
                                                                    set2 = set5;
                                                                    sparseArray3 = sparseArray2;
                                                                    downloadDBInitInfo3 = downloadDBInitInfo;
                                                                    z3 = z6;
                                                                    str4 = str3;
                                                                    set6 = set4;
                                                                } catch (Throwable th16) {
                                                                    th = th16;
                                                                    z8 = true;
                                                                    cursor3 = cursor4;
                                                                    sparseArray2 = sparseArray3;
                                                                    str2 = str5;
                                                                    cursor = cursor3;
                                                                    z9 = z8;
                                                                    str = str3;
                                                                    arrayList = arrayList3;
                                                                    z7 = z9;
                                                                    downloadDBInitInfo2 = downloadDBInitInfo;
                                                                    i = z7;
                                                                    th.printStackTrace();
                                                                    Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                                    Cursor[] cursorArr3222222222222 = new Cursor[i];
                                                                    cursorArr3222222222222[0] = cursor;
                                                                    DownloadUtils.safeClose(cursorArr3222222222222);
                                                                    deleteChunkTable();
                                                                    if (Logger.alog()) {
                                                                        Logger.globalDebug(str2, "newBatchInit", str);
                                                                    }
                                                                    DownloadDBInitInfo downloadDBInitInfo52222222222222 = downloadDBInitInfo2;
                                                                    callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                                    this.cacheSynced = i;
                                                                    downloadDBInitInfo52222222222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo52222222222222.initDuration;
                                                                    downloadDBInitInfo52222222222222.memoryCacheCount = sparseArray.size();
                                                                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                                    downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                                    if (downloadDBListener != null) {
                                                                        downloadDBListener.onInitFinish(downloadDBInitInfo52222222222222);
                                                                    }
                                                                    cleaner.start();
                                                                }
                                                            }
                                                        } catch (Throwable th17) {
                                                            th = th17;
                                                            cursor3 = cursor4;
                                                            z8 = true;
                                                        }
                                                    }
                                                    cursor3 = cursor4;
                                                    set3 = set9;
                                                    set4 = set7;
                                                    set5 = set8;
                                                    z12 = true;
                                                    z11 = z12;
                                                    z6 = z12;
                                                    if (!z11) {
                                                    }
                                                    i6 = i4 + 1;
                                                    if (i6 < this.singleLoadCountLimit) {
                                                    }
                                                    str5 = str2;
                                                    cursor = cursor3;
                                                    iDownloadIdGeneratorService = iDownloadIdGeneratorService3;
                                                    arrayList2 = arrayList;
                                                    set2 = set5;
                                                    sparseArray3 = sparseArray2;
                                                    downloadDBInitInfo3 = downloadDBInitInfo;
                                                    z3 = z6;
                                                    str4 = str3;
                                                    set6 = set4;
                                                } catch (Throwable th18) {
                                                    th = th18;
                                                    cursor3 = cursor4;
                                                    sparseArray2 = sparseArray3;
                                                    str2 = str5;
                                                    arrayList = arrayList3;
                                                    z6 = true;
                                                    downloadDBInitInfo2 = downloadDBInitInfo;
                                                    cursor = cursor3;
                                                    z5 = z6;
                                                    str = str3;
                                                    i = z5;
                                                    th.printStackTrace();
                                                    Logger.globalError(str2, "newBatchInit", "Error:" + th);
                                                    Cursor[] cursorArr32222222222222 = new Cursor[i];
                                                    cursorArr32222222222222[0] = cursor;
                                                    DownloadUtils.safeClose(cursorArr32222222222222);
                                                    deleteChunkTable();
                                                    if (Logger.alog()) {
                                                    }
                                                    DownloadDBInitInfo downloadDBInitInfo522222222222222 = downloadDBInitInfo2;
                                                    callbackDownloadInfo(true, arrayList, sparseArray2, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                                                    this.cacheSynced = i;
                                                    downloadDBInitInfo522222222222222.initDuration = System.currentTimeMillis() - downloadDBInitInfo522222222222222.initDuration;
                                                    downloadDBInitInfo522222222222222.memoryCacheCount = sparseArray.size();
                                                    DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                                                    downloadDBListener = DownloadComponentManager.getDownloadDBListener();
                                                    if (downloadDBListener != null) {
                                                    }
                                                    cleaner.start();
                                                }
                                            }
                                        }
                                    } catch (Throwable th19) {
                                        th = th19;
                                        sparseArray2 = sparseArray3;
                                        str2 = str5;
                                        cursor3 = cursor5;
                                    }
                                } catch (Throwable th20) {
                                    th = th20;
                                    arrayList = arrayList2;
                                    sparseArray2 = sparseArray3;
                                    str2 = str5;
                                    str3 = str4;
                                    z6 = z3;
                                    cursor3 = cursor2;
                                }
                            } catch (Throwable th21) {
                                th = th21;
                                arrayList = arrayList2;
                                sparseArray2 = sparseArray3;
                                str = str4;
                                z = z3;
                            }
                        }
                        ArrayList arrayList4 = arrayList2;
                        SparseArray<DownloadInfo> sparseArray5 = sparseArray3;
                        String str7 = str5;
                        String str8 = str4;
                        int i10 = z3;
                        Cursor[] cursorArr4 = new Cursor[i10];
                        cursorArr4[0] = cursor;
                        DownloadUtils.safeClose(cursorArr4);
                        deleteChunkTable();
                        if (Logger.alog()) {
                            Logger.globalDebug(str7, "newBatchInit", str8);
                        }
                        callbackDownloadInfo(true, arrayList4, sparseArray5, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                        this.cacheSynced = i10;
                        downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                        downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                        downloadDBListener2 = DownloadComponentManager.getDownloadDBListener();
                        if (downloadDBListener2 != null) {
                            downloadDBListener2.onInitFinish(downloadDBInitInfo);
                        }
                        cleaner.start();
                    }
                }
                i5 = i3;
                i4 = 0;
                z4 = z19;
                while (cursor.moveToNext()) {
                }
                ArrayList arrayList42 = arrayList2;
                SparseArray<DownloadInfo> sparseArray52 = sparseArray3;
                String str72 = str5;
                String str82 = str4;
                int i102 = z3;
                Cursor[] cursorArr42 = new Cursor[i102];
                cursorArr42[0] = cursor;
                DownloadUtils.safeClose(cursorArr42);
                deleteChunkTable();
                if (Logger.alog()) {
                }
                callbackDownloadInfo(true, arrayList42, sparseArray52, sparseArray, set, list, sqlCacheLoadCompleteCallback);
                this.cacheSynced = i102;
                downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
                downloadDBInitInfo.memoryCacheCount = sparseArray.size();
                DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
                downloadDBListener2 = DownloadComponentManager.getDownloadDBListener();
                if (downloadDBListener2 != null) {
                }
                cleaner.start();
            }
        }
        i2 = 0;
        if (z13) {
        }
        i3 = i2;
        iDownloadIdGeneratorService = null;
        z2 = true;
        downloadDBInitInfo3.diskCacheCount = cursor.getCount();
        if (Logger.alog()) {
        }
        if (z19) {
        }
        z3 = true;
        i5 = i3;
        i4 = 0;
        z4 = z19;
        while (cursor.moveToNext()) {
        }
        ArrayList arrayList422 = arrayList2;
        SparseArray<DownloadInfo> sparseArray522 = sparseArray3;
        String str722 = str5;
        String str822 = str4;
        int i1022 = z3;
        Cursor[] cursorArr422 = new Cursor[i1022];
        cursorArr422[0] = cursor;
        DownloadUtils.safeClose(cursorArr422);
        deleteChunkTable();
        if (Logger.alog()) {
        }
        callbackDownloadInfo(true, arrayList422, sparseArray522, sparseArray, set, list, sqlCacheLoadCompleteCallback);
        this.cacheSynced = i1022;
        downloadDBInitInfo.initDuration = System.currentTimeMillis() - downloadDBInitInfo.initDuration;
        downloadDBInitInfo.memoryCacheCount = sparseArray.size();
        DownloadMonitorHelper.monitorDownloadDB(downloadDBInitInfo);
        downloadDBListener2 = DownloadComponentManager.getDownloadDBListener();
        if (downloadDBListener2 != null) {
        }
        cleaner.start();
    }

    private void callbackDownloadInfo(boolean z, List<DownloadInfo> list, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, Set<Integer> set, List<DownloadInfo> list2, SqlCacheLoadCompleteCallback sqlCacheLoadCompleteCallback) {
        if (Logger.alog()) {
            Logger.globalDebug(TAG, "callbackDownloadInfo", "Run");
        }
        clearAntiHijackDirIfNeeded(list);
        loadCacheFromDB(list, sparseArray);
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "callbackDownloadInfo", "Run Callback:" + sqlCacheLoadCompleteCallback);
        }
        if (sqlCacheLoadCompleteCallback != null) {
            sqlCacheLoadCompleteCallback.callback(z);
        }
        onInitFinish(sparseArray2, set, list2, z);
        sparseArray.clear();
        list.clear();
        sparseArray2.clear();
        if (z) {
            return;
        }
        try {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "newInit", "Sleep:" + this.singleLoadSleepTimeMs);
            }
            Thread.sleep(this.singleLoadSleepTimeMs);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "newInit", "Sleep:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAndRemoveDownloadInfo(DownloadInfo downloadInfo, boolean z, long j, boolean z2) {
        if (this.isCheckCacheEnable && downloadInfo.getCacheLifeTimeMax() > 0 && downloadInfo.getDownloadStartTimeStamp() > 0 && downloadInfo.getDownloadStartTimeStamp() + (downloadInfo.getCacheLifeTimeMax() * 1000) < System.currentTimeMillis()) {
            if (z2) {
                return true;
            }
            DownloadUtils.deleteAllDownloadFiles(downloadInfo, true);
            return true;
        }
        if (z && DownloadFileUtils.isAtLeastAndroidQ() && !DownloadFileUtils.isMediaUri(downloadInfo.getSavePath()) && DownloadFileUtils.isFilePathInExternalPublicDir(downloadInfo.getSavePath())) {
            return true;
        }
        if (j <= 0 || downloadInfo.getStatus() == -3 || downloadInfo.getLastDownloadTime() + (j * 1000) >= System.currentTimeMillis()) {
            return false;
        }
        if (z2) {
            return true;
        }
        DownloadUtils.deleteAllDownloadFiles(downloadInfo, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleSuccess(DownloadInfo downloadInfo, boolean z, boolean z2, Cleaner cleaner, boolean z3) {
        if (downloadInfo.getStatus() != -3) {
            return z2;
        }
        boolean isFileExist = DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
        boolean z4 = downloadInfo.getInstalledTimeStamp() > 0 && (DownloadDirUtils.isSavePathSecurity(downloadInfo.getSavePath()) || (mExternalDownload && DownloadFileUtils.isMediaUri(downloadInfo.getSavePath())));
        if (!isFileExist) {
            if (z) {
                return true;
            }
            if (!z4) {
                downloadInfo.erase();
            }
            return z2;
        }
        if (z4) {
            if (z3) {
                cleaner.forceUpdateCleanDownloadId(downloadInfo, true);
                return z2;
            }
            DownloadUtils.deleteAllDownloadFiles(downloadInfo);
        }
        return z2;
    }

    public void resetNewBatchInit() {
        this.singleLoadCountLimit = Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndReportToMonitor(DownloadInfo downloadInfo) {
        int statusAtDbInit;
        if (downloadInfo != null && (statusAtDbInit = downloadInfo.getStatusAtDbInit()) >= 1 && statusAtDbInit <= 11) {
            DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), null, downloadInfo, null, -5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAntiHijackDirIfNeeded(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (downloadInfo.isSavePathRedirected()) {
                        DownloadUtils.clearAntiHijackDir(downloadInfo);
                    }
                    handleDBRelatedData(downloadInfo.getId(), downloadInfo.getSavePath());
                }
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "clearAntiHijackDirIfNeeded", "Error:" + th);
        }
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCacheFromDB(List<DownloadInfo> list, SparseArray<DownloadInfo> sparseArray) {
        int size = sparseArray.size();
        if (size < 0 || database == null) {
            return;
        }
        synchronized (database) {
            try {
                safeBeginTransaction();
                if (!list.isEmpty()) {
                    String[] strArr = new String[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        strArr[i] = String.valueOf(list.get(i).getId());
                    }
                    database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)", strArr);
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new String[]{String.valueOf(keyAt)});
                    database.insert(DBDefinition.DOWNLOAD_TABLE_NAME, null, DownloadHelper.toContentValues(downloadInfo));
                }
                database.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteChunkTable() {
        if (database == null) {
            return;
        }
        try {
            database.execSQL(DBDefinition.DROP_CHUNK_TABLE);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "deleteChunkTable", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public boolean cacheExist(int i) {
        try {
            return getDownloadInfo(i) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, i, "cacheExist", "Error:" + th);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo getDownloadInfo(final int i) {
        return (DownloadInfo) runImpl(new Callable<DownloadInfo>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public DownloadInfo call() throws Exception {
                return SqlDownloadCache.this.getDownloadInfoImpl(i);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadInfo getDownloadInfoImpl(int i) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        DownloadInfo parseDownloadInfo = DownloadHelper.parseDownloadInfo(cursor);
                        DownloadUtils.safeClose(cursor);
                        return parseDownloadInfo;
                    }
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        Logger.taskError(TAG, i, "getDownloadInfoImpl", "Error:" + th);
                        DownloadUtils.safeClose(cursor);
                        return null;
                    } catch (Throwable th2) {
                        DownloadUtils.safeClose(cursor);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfoList(final String str) {
        return (List) runImpl(new Callable<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.3
            @Override // java.util.concurrent.Callable
            public List<DownloadInfo> call() throws Exception {
                return SqlDownloadCache.this.getDownloadInfoListImpl(str);
            }
        }, new Fallback<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.4
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public List<DownloadInfo> getDefaultValue() {
                return new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadInfo> getDownloadInfoListImpl(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, "url"), new String[]{str});
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadHelper.parseDownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    Logger.globalError(TAG, "getDownloadInfoListImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    public void clearDBSuccessedDownloadInfo(final String str, final String str2) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.5
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.ensureDataBaseInit();
                if (SqlDownloadCache.database == null) {
                    return;
                }
                SqlDownloadCache.this.clearDBSuccessedDownloadInfoImpl(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDBSuccessedDownloadInfoImpl(String str, String str2) {
        try {
            safeBeginTransaction();
            database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, String.format("%s LIKE ? AND %s LIKE ? AND %s = ?", DBDefinition.SAVE_PATH, "name", "status"), new String[]{str, str2, String.valueOf(-3)});
            database.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(final String str) {
        return (List) runImpl(new Callable<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.6
            @Override // java.util.concurrent.Callable
            public List<DownloadInfo> call() throws Exception {
                return SqlDownloadCache.this.getSuccessedDownloadInfosWithMimeTypeImpl(str);
            }
        }, new Fallback<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.7
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public List<DownloadInfo> getDefaultValue() {
                return new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeTypeImpl(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MIME_TYPE, "status"), new String[]{str, String.valueOf(-3)});
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadHelper.parseDownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    Logger.globalError(TAG, "getSuccessedDownloadInfosWithMimeTypeImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(final String str) {
        return (List) runImpl(new Callable<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.8
            @Override // java.util.concurrent.Callable
            public List<DownloadInfo> call() throws Exception {
                return SqlDownloadCache.this.getUnCompletedDownloadInfosWithMimeTypeImpl(str);
            }
        }, new Fallback<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.9
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public List<DownloadInfo> getDefaultValue() {
                return new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeTypeImpl(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s IN (?,?,?,?,?)", DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MIME_TYPE, "status"), new String[]{str, String.valueOf(-1), String.valueOf(-2), String.valueOf(-7), String.valueOf(-4), String.valueOf(-5)});
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadHelper.parseDownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    Logger.globalError(TAG, "getUnCompletedDownloadInfosWithMimeTypeImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfosByFileExtension(final String str) {
        return (List) runImpl(new Callable<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.10
            @Override // java.util.concurrent.Callable
            public List<DownloadInfo> call() throws Exception {
                return SqlDownloadCache.this.getDownloadInfosByFileExtensionImpl(str);
            }
        }, new Fallback<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.11
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public List<DownloadInfo> getDefaultValue() {
                return new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadInfo> getDownloadInfosByFileExtensionImpl(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", DBDefinition.DOWNLOAD_TABLE_NAME, "name"), new String[]{"%" + str});
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadHelper.parseDownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    Logger.globalError(TAG, "getDownloadInfosByFileExtensionImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getAllDownloadInfo() {
        return (List) runImpl(new Callable<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.12
            @Override // java.util.concurrent.Callable
            public List<DownloadInfo> call() throws Exception {
                return SqlDownloadCache.this.getAllDownloadInfoImpl();
            }
        }, new Fallback<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.13
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public List<DownloadInfo> getDefaultValue() {
                return new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadInfo> getAllDownloadInfoImpl() {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s", DBDefinition.DOWNLOAD_TABLE_NAME), null);
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadHelper.parseDownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    Logger.globalError(TAG, "getAllDownloadInfoImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteInner(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, i, "deleteInner", "Error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteInner(int i, String str) {
        try {
            safeBeginTransaction();
            database.delete(str, "_id = ?", new String[]{String.valueOf(i)});
            database.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
            if (mExternalDownload && DownloadFileUtils.isMediaUri(downloadInfo.getSavePath())) {
                mExternalDownloadIdSets.add(Integer.valueOf(downloadInfo.getId()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, downloadInfo.getId(), "insertDownloadInfoInner", "Error:" + th);
        }
    }

    private void updateDownloadInfoInner(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, downloadInfo.getId(), "updateDownloadInfoInner", "Error:" + th);
        }
    }

    private void addDownloadInfo(final DownloadInfo downloadInfo) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.14
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.ensureDataBaseInit();
                if (SqlDownloadCache.database == null || SqlDownloadCache.this.downloadTableStatements == null) {
                    return;
                }
                try {
                    SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                    sqlDownloadCache.insertDownloadInfoInner(downloadInfo, sqlDownloadCache.downloadTableStatements.getInsertStatement());
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.taskError(SqlDownloadCache.TAG, downloadInfo.getId(), "addDownloadInfo", "Error:" + th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public boolean updateDownloadInfo(final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.15
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.ensureDataBaseInit();
                if (SqlDownloadCache.database == null) {
                    return;
                }
                SqlDownloadCache.this.updateDownloadInfoForCurrentThread(downloadInfo);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateDownloadInfoForCurrentThread(DownloadInfo downloadInfo) {
        synchronized (this) {
            if (downloadInfo == null) {
                return;
            }
            try {
                if (!cacheExist(downloadInfo.getId())) {
                    addDownloadInfo(downloadInfo);
                } else {
                    TableStatements tableStatements = this.downloadTableStatements;
                    if (tableStatements == null) {
                    } else {
                        updateDownloadInfoInner(downloadInfo, tableStatements.getUpdateStatement());
                    }
                }
            } finally {
            }
        }
    }

    private void safeEndTransaction() {
        try {
            if (database == null || !database.inTransaction()) {
                return;
            }
            database.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "safeEndTransaction", "Error:" + th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(final int i) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.16
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.ensureDataBaseInit();
                if (SqlDownloadCache.database == null || SqlDownloadCache.this.downloadTableStatements == null) {
                    return;
                }
                try {
                    if (SqlDownloadCache.this.mDownloadDBOptimize) {
                        SqlDownloadCache.this.deleteInner(i, DBDefinition.DOWNLOAD_TABLE_NAME);
                    } else {
                        SqlDownloadCache sqlDownloadCache = SqlDownloadCache.this;
                        sqlDownloadCache.deleteInner(i, sqlDownloadCache.downloadTableStatements.getDeleteStatement());
                    }
                    SqlDownloadCache.this.handleDBRelatedData(i, null);
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.taskError(SqlDownloadCache.TAG, i, "removeDownloadInfo", "Error:" + th);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDBRelatedData(int i, String str) {
        DownloadInfo downloadInfo;
        if (mEnableRemoveDownloadSPInfo) {
            DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().remove(Integer.toString(i)).apply();
        }
        if (mExternalDownload && mExternalDownloadIdSets.contains(Integer.valueOf(i))) {
            mExternalDownloadIdSets.remove(Integer.valueOf(i));
            try {
                if (TextUtils.isEmpty(str) && (downloadInfo = getDownloadInfo(i)) != null) {
                    str = downloadInfo.getSavePath();
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                DownloadFileUtils.deleteUri(Uri.parse(str));
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.taskError(TAG, i, "handleRelatedData", "Error:" + th);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(final int i) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.17
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.removeDownloadInfo(i);
                SqlDownloadCache.this.removeSegments(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public void clearData() {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.18
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.ensureDataBaseInit();
                if (SqlDownloadCache.database == null) {
                    return;
                }
                SqlDownloadCache.this.clearDataInSubThread();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearDataInSubThread() {
        synchronized (this) {
            try {
                safeBeginTransaction();
                database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, null, null);
                database.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(j));
        contentValues.put(DBDefinition.ETAG, str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskProgress(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        if (j > 0) {
            contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskRetry(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, (Integer) 0);
        contentValues.put(DBDefinition.FIRST_SUCCESS, (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int i) {
        Map<Long, Segment> segmentMap = getSegmentMap(i);
        if (segmentMap == null || segmentMap.isEmpty()) {
            return null;
        }
        return new ArrayList<>(segmentMap.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        Cursor cursor;
        ensureDataBaseInit();
        if (database != null) {
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", DBDefinition.SEGMENT_TABLE_NAME, "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex(DBDefinition.SEGMENT_INFO);
                        String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                        HashMap hashMap = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            Segment segment = new Segment(jSONArray.getJSONObject(i2));
                            hashMap.put(Long.valueOf(segment.getStartOffset()), segment);
                        }
                        DownloadUtils.safeClose(cursor);
                        return hashMap;
                    }
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        Logger.taskError(TAG, i, "getSegmentMap", "Error:" + th);
                        DownloadUtils.safeClose(cursor);
                        return null;
                    } catch (Throwable th2) {
                        DownloadUtils.safeClose(cursor);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        ensureDataBaseInit();
        if (database == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Long, Segment> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    jSONArray.put(entry.getValue().toJson());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, i, "updateSegments", "Error:" + th);
        }
        SQLiteStatement insertOrReplaceStatement = this.segmentTableStatements.getInsertOrReplaceStatement();
        if (insertOrReplaceStatement == null) {
            Logger.taskError(TAG, i, "updateSegments", "UpdateSegments statement is null");
            return false;
        }
        synchronized (insertOrReplaceStatement) {
            insertOrReplaceStatement.clearBindings();
            insertOrReplaceStatement.bindLong(1, i);
            insertOrReplaceStatement.bindString(2, jSONArray.toString());
            insertOrReplaceStatement.execute();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        ensureDataBaseInit();
        if (database == null) {
            return;
        }
        try {
            if (this.mDownloadDBOptimize) {
                deleteInner(i, DBDefinition.SEGMENT_TABLE_NAME);
            } else {
                deleteInner(i, this.segmentTableStatements.getDeleteStatement());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.taskError(TAG, i, "removeSegments", "Error:" + th);
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        DownloadComponentManager.submitDBTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.19
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCache.this.ensureDataBaseInit();
                if (SqlDownloadCache.database == null) {
                    return;
                }
                SqlDownloadCache.this.updateInner(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInner(int i, ContentValues contentValues) {
        int i2 = 10;
        while (database.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.taskError(TAG, i, "updateInner", "Error:" + th);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                Logger.taskError(TAG, i, "updateInner", "Error2:" + th2);
                return;
            }
        }
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(final String str) {
        return (List) runImpl(new Callable<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.20
            @Override // java.util.concurrent.Callable
            public List<DownloadInfo> call() throws Exception {
                return SqlDownloadCache.this.getDownloadInfosBySavePathImpl(str);
            }
        }, new Fallback<List<DownloadInfo>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.21
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public List<DownloadInfo> getDefaultValue() {
                return new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadInfo> getDownloadInfosBySavePathImpl(String str) {
        ensureDataBaseInit();
        ArrayList arrayList = new ArrayList();
        if (database != null) {
            Cursor cursor = null;
            try {
                cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.SAVE_PATH), new String[]{str});
                while (cursor.moveToNext()) {
                    arrayList.add(DownloadHelper.parseDownloadInfo(cursor));
                }
                DownloadUtils.safeClose(cursor);
            } catch (Throwable th) {
                try {
                    Logger.globalError(TAG, "getDownloadInfosBySaveInfoImpl", "Error:" + th);
                    DownloadUtils.safeClose(cursor);
                } catch (Throwable th2) {
                    DownloadUtils.safeClose(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(final String str) {
        return (Map) runImpl(new Callable<Map<String, Pair<Integer, Long>>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.22
            @Override // java.util.concurrent.Callable
            public Map<String, Pair<Integer, Long>> call() throws Exception {
                return SqlDownloadCache.this.getInstalledTimeStampBySavePathImpl(str);
            }
        }, new Fallback<Map<String, Pair<Integer, Long>>>() { // from class: com.ss.android.socialbase.downloader.db.SqlDownloadCache.23
            @Override // com.ss.android.socialbase.downloader.db.SqlDownloadCache.Fallback
            public Map<String, Pair<Integer, Long>> getDefaultValue() {
                return new HashMap();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePathImpl(String str) {
        ensureDataBaseInit();
        HashMap hashMap = new HashMap();
        if (database != null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = database.rawQuery(String.format("SELECT %s, %s, %s, %s FROM %s WHERE %s LIKE ?", "_id", DBDefinition.SAVE_PATH, "name", DBDefinition.INSTALLED_TIMESTAMP, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.SAVE_PATH), new String[]{str});
                try {
                    int columnIndex = rawQuery.getColumnIndex("_id");
                    if (columnIndex == -1) {
                        DownloadUtils.safeClose(rawQuery);
                        return null;
                    }
                    int columnIndex2 = rawQuery.getColumnIndex(DBDefinition.SAVE_PATH);
                    if (columnIndex2 == -1) {
                        DownloadUtils.safeClose(rawQuery);
                        return null;
                    }
                    int columnIndex3 = rawQuery.getColumnIndex("name");
                    if (columnIndex3 == -1) {
                        DownloadUtils.safeClose(rawQuery);
                        return null;
                    }
                    int columnIndex4 = rawQuery.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);
                    if (columnIndex4 == -1) {
                        DownloadUtils.safeClose(rawQuery);
                        return null;
                    }
                    while (rawQuery.moveToNext()) {
                        String absolutePath = new DownloadFile(rawQuery.getString(columnIndex2), rawQuery.getString(columnIndex3)).getAbsolutePath();
                        if (!TextUtils.isEmpty(absolutePath)) {
                            hashMap.put(absolutePath, new Pair(Integer.valueOf(rawQuery.getInt(columnIndex)), Long.valueOf(rawQuery.getLong(columnIndex4))));
                        }
                    }
                    DownloadUtils.safeClose(rawQuery);
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    try {
                        Logger.globalError(TAG, "getDownloadInfosBySaveInfoImpl", "Error:" + th);
                        DownloadUtils.safeClose(cursor);
                        return hashMap;
                    } catch (Throwable th2) {
                        DownloadUtils.safeClose(cursor);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return hashMap;
    }

    @Override // com.ss.android.socialbase.downloader.p005db.ISqlDownloadCacheAidl
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl) {
        this.callback = iSqlCacheLoadCompleteCallbackAidl;
    }

    public void onInitFinish(SparseArray<DownloadInfo> sparseArray, Set<Integer> set, List<DownloadInfo> list, boolean z) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onInitFinish", "Run onInitFinish:" + this.callback);
        }
        try {
            HashMap sparseArrayToHashMap = DownloadHelper.sparseArrayToHashMap(sparseArray);
            Map<Integer, DownloadInfo> listConvertToMap = DownloadHelper.listConvertToMap(list);
            List<Integer> convertToList = DownloadHelper.setConvertToList(set);
            ISqlCacheLoadCompleteCallbackAidl iSqlCacheLoadCompleteCallbackAidl = this.callback;
            if (iSqlCacheLoadCompleteCallbackAidl != null) {
                iSqlCacheLoadCompleteCallbackAidl.callback(sparseArrayToHashMap, convertToList, listConvertToMap, z);
            }
        } catch (Throwable th) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "onInitFinish", "Error:" + th);
            }
        }
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public static boolean checkCacheLifeTimeAndRemove(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.getCacheLifeTimeMax() <= 0 || downloadInfo.getDownloadStartTimeStamp() <= 0 || downloadInfo.getDownloadStartTimeStamp() + (downloadInfo.getCacheLifeTimeMax() * 1000) >= System.currentTimeMillis()) {
            return false;
        }
        DownloadUtils.deleteAllDownloadFiles(downloadInfo, true);
        return true;
    }

    private <T> T runImpl(Callable<T> callable, Fallback<T> fallback) {
        int i = mainThreadDbOPMaxTime;
        if (i <= 0 || !DownloadUtils.isMainThread()) {
            try {
                return callable.call();
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.globalError(TAG, "runImpl", "Call Error: " + th);
            }
        } else {
            try {
                return DownloadComponentManager.getDBThreadExecutorService().submit(callable).get(i, TimeUnit.MILLISECONDS);
            } catch (Throwable th2) {
                th2.printStackTrace();
                Logger.globalError(TAG, "runImpl", "Get Error: " + th2);
            }
        }
        if (fallback != null) {
            return fallback.getDefaultValue();
        }
        return null;
    }
}
