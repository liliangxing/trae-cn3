package com.bytedance.applog.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.batch.PackCalculator;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.engine.Session;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.LogReportMonitor;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.StageEventBasic;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.strategy.IReportDropStrategy;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.applog.util.Utils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DbStore {
    private static final int DB_VERSION = 57;
    public static final int LIMIT_EVENT_COUNT = 200;
    private static final int LIMIT_EVENT_SIZE = 50000;
    private static final long LIMIT_INTERVAL_SEND_FAIL_3_DAYS = 259200000;
    private static final int LIMIT_LAUNCH = 5;
    private static final int LIMIT_PACK_SIZE = 995000;
    public static final int LIMIT_SELECT_PACK = 8;
    public static final int LIMIT_SELECT_PACK_MAX = 16;
    private static final int MSG_SAVE_DATA = 0;
    private static final String SQL_DEL_LAUNCH = "DELETE FROM launch WHERE _id=?";
    private static final String SQL_SELECT_FORWARD_EVENT = "SELECT * FROM forward_eventv3 ORDER BY _id ASC LIMIT 1000";
    private static final String WHERE_ID_CLAUSE = "_id = ?";
    public static volatile boolean cacheMemOpt;
    private final HashMap<String, BaseData> ZYGOTES = new HashMap<>();
    private volatile boolean mEnableMemoryCache;
    private volatile boolean mEnableTransaction;
    private final Engine mEngine;
    private final Set<String> mIdSendSet;
    private final DbOpenHelper mOpenHelper;
    private Handler mWorkHandler;
    ArrayList<BaseData> memoryCache;
    private int piledUpEventCount;
    private int piledUpLaunchCount;
    private int piledUpPackCount;
    private int piledUpTerminateCount;
    private final BaseData[] sEvents;

    public DbStore(Engine engine, String str) {
        BaseData[] allEventObj = BaseData.getAllEventObj();
        this.sEvents = allEventObj;
        this.mWorkHandler = null;
        this.mEnableMemoryCache = false;
        this.mEnableTransaction = false;
        this.mIdSendSet = new HashSet();
        this.piledUpEventCount = 0;
        this.piledUpLaunchCount = 0;
        this.piledUpTerminateCount = 0;
        this.piledUpPackCount = 0;
        this.memoryCache = new ArrayList<>();
        this.mOpenHelper = new DbOpenHelper(engine.getContext(), str, null, 57);
        this.mEngine = engine;
        registerZygote(new Page());
        registerZygote(new Launch());
        registerZygote(new Terminate());
        registerZygote(new Pack());
        registerZygote(new ForwardEvent());
        for (BaseData baseData : allEventObj) {
            registerZygote(baseData);
        }
        readPiledUpEventCount();
    }

    public int getPiledUpEventCount() {
        return this.piledUpEventCount;
    }

    public int getPiledUpLaunchCount() {
        return this.piledUpLaunchCount;
    }

    public int getPiledUpTerminateCount() {
        return this.piledUpTerminateCount;
    }

    public int getPiledUpPackCount() {
        return this.piledUpPackCount;
    }

    public int getPiledUpDbSizeInKb() {
        return this.mOpenHelper.getDbInitSizeInKb();
    }

    private void resetEventsByIndex(int i) {
        if (cacheMemOpt) {
            if (i == 0) {
                this.sEvents[i] = new Event();
            } else if (i == 1) {
                this.sEvents[i] = new EventV3(null, null, false, null);
            } else {
                if (i != 2) {
                    return;
                }
                this.sEvents[i] = new EventMisc(null, "", new JSONObject());
            }
        }
    }

    private void resetZygoteByKey(String str) {
        if (cacheMemOpt && this.ZYGOTES.containsKey(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1376501097:
                    if (str.equals("eventv3")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1109843021:
                    if (str.equals("launch")) {
                        c = 1;
                        break;
                    }
                    break;
                case -551622883:
                    if (str.equals("forward_eventv3")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3432985:
                    if (str.equals("pack")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3433103:
                    if (str.equals("page")) {
                        c = 4;
                        break;
                    }
                    break;
                case 96891546:
                    if (str.equals("event")) {
                        c = 5;
                        break;
                    }
                    break;
                case 984152945:
                    if (str.equals("event_misc")) {
                        c = 6;
                        break;
                    }
                    break;
                case 2035990113:
                    if (str.equals("terminate")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.ZYGOTES.put(str, new EventV3(null, null, false, null));
                    return;
                case 1:
                    this.ZYGOTES.put(str, new Launch());
                    return;
                case 2:
                    this.ZYGOTES.put(str, new ForwardEvent());
                    return;
                case 3:
                    this.ZYGOTES.put(str, new Pack());
                    return;
                case 4:
                    this.ZYGOTES.put(str, new Page());
                    return;
                case 5:
                    this.ZYGOTES.put(str, new Event());
                    return;
                case 6:
                    this.ZYGOTES.put(str, new EventMisc(null, "", new JSONObject()));
                    return;
                case 7:
                    this.ZYGOTES.put(str, new Terminate());
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAppLogLogger getLogger() {
        return this.mEngine.getAppLog().getLogger();
    }

    private String selLaunch(int i) {
        return "SELECT * FROM launch ORDER BY _id DESC LIMIT " + i;
    }

    private String selPage(String str, boolean z) {
        return "SELECT * FROM page WHERE session_id" + (z ? "='" : "!='") + str + "' ORDER BY " + (z ? "session_id," : "") + "duration DESC LIMIT 1000";
    }

    private String delPage(String str, boolean z) {
        return "DELETE FROM page WHERE session_id" + (z ? "='" : "!='") + str + "'";
    }

    private String selEvent(BaseData baseData, String str, boolean z, int i, EventPriorityItem eventPriorityItem) {
        StringBuilder sb = new StringBuilder("SELECT * FROM " + baseData.getTableName() + " WHERE session_id");
        if (z) {
            sb.append("='");
        } else {
            sb.append("!='");
        }
        sb.append(str);
        if (eventPriorityItem != null) {
            int priority = eventPriorityItem.getPriority();
            if (-1 == priority) {
                sb.append("' AND (priority=" + priority + " OR priority>" + eventPriorityItem.getMaxPriority() + ")");
            } else {
                sb.append("' AND priority=" + priority);
            }
        } else {
            sb.append("'");
        }
        sb.append(" ORDER BY _id LIMIT " + i);
        return sb.toString();
    }

    private String selPriorityEvent(BaseData baseData, int i, int i2) {
        return "SELECT * FROM " + baseData.getTableName() + " WHERE priority=" + i2 + " ORDER BY _id LIMIT " + i;
    }

    private String delEvent(String str, String str2, boolean z, long j, EventPriorityItem eventPriorityItem) {
        StringBuilder sb = new StringBuilder("DELETE FROM " + str + " WHERE session_id");
        if (z) {
            sb.append("='");
        } else {
            sb.append("!='");
        }
        sb.append(str2 + "' AND _id<=" + j);
        if (eventPriorityItem != null) {
            int priority = eventPriorityItem.getPriority();
            if (-1 == priority) {
                sb.append(" AND (priority=" + priority + " OR priority>" + eventPriorityItem.getMaxPriority() + ")");
            } else {
                sb.append(" AND priority=" + priority);
            }
        }
        return sb.toString();
    }

    private String delPriorityEvent(String str, long j, int i) {
        return "DELETE FROM " + str + " WHERE _id<=" + j + " AND priority=" + i;
    }

    private String selPack(int i, EventPriorityItem eventPriorityItem) {
        StringBuilder sb = new StringBuilder("SELECT * FROM pack");
        if (eventPriorityItem != null) {
            int priority = eventPriorityItem.getPriority();
            if (-1 == priority) {
                sb.append(" WHERE priority=" + priority + " OR priority>" + eventPriorityItem.getMaxPriority());
            } else {
                sb.append(" WHERE priority=" + priority);
            }
        }
        sb.append(" ORDER BY _id DESC LIMIT " + i);
        return sb.toString();
    }

    private String failPack(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    private void registerZygote(BaseData baseData) {
        this.ZYGOTES.put(baseData.getTableName(), baseData);
    }

    private boolean needLaunch(String str) {
        boolean z;
        if (this.mIdSendSet.contains(str)) {
            z = false;
        } else {
            this.mIdSendSet.add(str);
            z = true;
        }
        getLogger().debug(5, "session id:{} needLaunch:{}", str, Boolean.valueOf(z));
        return z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:3|4|5|6|7|8|9|(4:11|12|(2:137|138)(1:14)|15)|(9:16|(5:18|19|(6:(1:22)(1:68)|23|24|25|26|27)(5:69|70|71|72|73)|(3:32|33|35)(2:29|30)|31)(1:80)|38|39|40|(2:47|48)|42|43|44)|81|82|83|(4:117|118|(6:121|122|123|124|125|119)|129)|85|86|87|88|(3:103|104|(9:106|107|108|109|91|(2:94|95)|93|43|44))|90|91|(0)|93|43|44) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01f1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01f2, code lost:
    
        r16 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01f8, code lost:
    
        r14 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01f5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01f6, code lost:
    
        r16 = r21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void pack(JSONObject jSONObject, EventPriorityItem eventPriorityItem, int i, boolean z) {
        int i2;
        int i3;
        Cursor cursor;
        String str;
        JSONArray[] jSONArrayArr;
        long[] jArr;
        HashMap<String, JSONObject> hashMap;
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase;
        Cursor rawQuery;
        String id;
        boolean hadUi;
        ArrayList arrayList;
        boolean moveToFirst;
        JSONObject jSONObject2;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        String str2;
        HashMap<String, JSONObject> hashMap2;
        long[] jArr2;
        JSONArray[] jSONArrayArr2;
        ArrayList arrayList2;
        Page page;
        Pack pack;
        saveBeforeSendOrQuery();
        Launch launch = (Launch) this.ZYGOTES.get("launch");
        Terminate terminate = (Terminate) this.ZYGOTES.get("terminate");
        Page page2 = (Page) this.ZYGOTES.get("page");
        Pack pack2 = (Pack) this.ZYGOTES.get("pack");
        SQLiteDatabase sQLiteDatabase4 = null;
        int i4 = 0;
        try {
            jSONArrayArr = new JSONArray[3];
            jArr = new long[3];
            hashMap = new HashMap<>();
            getLogger().debug(5, "DbStore pack before collect impression.", new Object[0]);
            writableDatabase = this.mOpenHelper.getWritableDatabase();
            try {
                collectImpression(writableDatabase, hashMap);
                getLogger().debug(5, "DbStore pack after collect impression.", new Object[0]);
                writableDatabase.beginTransaction();
                rawQuery = writableDatabase.rawQuery(selLaunch(5), null);
                try {
                    Session session = this.mEngine.getSession();
                    id = session.getId();
                    hadUi = session.hadUi();
                    arrayList = new ArrayList();
                    if (z) {
                        try {
                            moveToFirst = rawQuery.moveToFirst();
                        } catch (Throwable th) {
                            th = th;
                            cursor = rawQuery;
                            sQLiteDatabase4 = writableDatabase;
                            i2 = 5;
                            i3 = 0;
                        }
                    } else {
                        moveToFirst = rawQuery.moveToLast();
                    }
                    jSONObject2 = jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    sQLiteDatabase = writableDatabase;
                    i2 = 5;
                    i3 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = writableDatabase;
                i2 = 5;
                i3 = 0;
                cursor = null;
            }
        } catch (Throwable th4) {
            th = th4;
            i2 = 5;
            i3 = 0;
            cursor = null;
        }
        while (true) {
            boolean z2 = 1;
            if (!moveToFirst) {
                break;
            }
            try {
                launch.readDb(rawQuery);
                pack2.sid = launch.sid;
                JSONObject checkVersion = checkVersion(launch, jSONObject);
                if (TextUtils.equals(launch.sid, id)) {
                    if (hadUi) {
                        z2 = i4;
                    }
                    launch.mBg = z2;
                    ArrayList arrayList3 = arrayList;
                    str2 = id;
                    cursor = rawQuery;
                    sQLiteDatabase3 = writableDatabase;
                    hashMap2 = hashMap;
                    jArr2 = jArr;
                    jSONArrayArr2 = jSONArrayArr;
                    try {
                        packCurrentData(checkVersion, launch, pack2, writableDatabase, jSONArrayArr, jArr, hashMap2, eventPriorityItem, i);
                        arrayList2 = arrayList3;
                        pack = pack2;
                        page = page2;
                        i3 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase4 = sQLiteDatabase3;
                        i2 = 5;
                        i3 = 0;
                    }
                } else {
                    ArrayList arrayList4 = arrayList;
                    str2 = id;
                    cursor = rawQuery;
                    sQLiteDatabase3 = writableDatabase;
                    hashMap2 = hashMap;
                    jArr2 = jArr;
                    jSONArrayArr2 = jSONArrayArr;
                    try {
                        arrayList4.add(Long.valueOf(launch.dbId));
                        Page page3 = page2;
                        arrayList2 = arrayList4;
                        page = page2;
                        i3 = 0;
                        pack = pack2;
                        packHistoryData(checkVersion, launch, pack2, page3, terminate, sQLiteDatabase3, jSONArrayArr2, jArr2, hashMap2, eventPriorityItem, i);
                    } catch (Throwable th6) {
                        th = th6;
                        i3 = 0;
                        sQLiteDatabase4 = sQLiteDatabase3;
                        i2 = 5;
                        this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                        this.mEngine.getAppLog().getMonitorHelper().sendError("pack failed", th);
                        getLogger().error(i2, "pack failed", th, new Object[i3]);
                        if (cursor != null) {
                        }
                        Utils.endDbTransactionSafely(sQLiteDatabase4);
                        resetZygoteByKey("launch");
                        resetZygoteByKey("terminate");
                        resetZygoteByKey("page");
                        str = "pack";
                        resetZygoteByKey(str);
                    }
                }
                if (z) {
                    try {
                        moveToFirst = cursor.moveToNext();
                    } catch (Throwable th7) {
                        th = th7;
                        sQLiteDatabase4 = sQLiteDatabase3;
                        i2 = 5;
                        this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                        this.mEngine.getAppLog().getMonitorHelper().sendError("pack failed", th);
                        getLogger().error(i2, "pack failed", th, new Object[i3]);
                        if (cursor != null) {
                        }
                        Utils.endDbTransactionSafely(sQLiteDatabase4);
                        resetZygoteByKey("launch");
                        resetZygoteByKey("terminate");
                        resetZygoteByKey("page");
                        str = "pack";
                        resetZygoteByKey(str);
                    }
                } else {
                    moveToFirst = cursor.moveToPrevious();
                }
                i4 = i3;
                arrayList = arrayList2;
                jSONObject2 = checkVersion;
                id = str2;
                rawQuery = cursor;
                writableDatabase = sQLiteDatabase3;
                hashMap = hashMap2;
                jArr = jArr2;
                jSONArrayArr = jSONArrayArr2;
                page2 = page;
                pack2 = pack;
            } catch (Throwable th8) {
                th = th8;
                cursor = rawQuery;
                sQLiteDatabase3 = writableDatabase;
                i3 = i4;
            }
            i2 = 5;
            try {
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("pack failed", th);
                getLogger().error(i2, "pack failed", th, new Object[i3]);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th9) {
                        getLogger().error(i2, "close cursor failed", th9, new Object[i3]);
                    }
                }
                Utils.endDbTransactionSafely(sQLiteDatabase4);
                resetZygoteByKey("launch");
                resetZygoteByKey("terminate");
                resetZygoteByKey("page");
                str = "pack";
                resetZygoteByKey(str);
            } finally {
            }
        }
        ArrayList arrayList5 = arrayList;
        String str3 = id;
        cursor = rawQuery;
        SQLiteDatabase sQLiteDatabase5 = writableDatabase;
        long[] jArr3 = jArr;
        JSONArray[] jSONArrayArr3 = jSONArrayArr;
        Pack pack3 = pack2;
        Page page4 = page2;
        i3 = i4;
        if (!arrayList5.isEmpty()) {
            try {
                Iterator it = arrayList5.iterator();
                while (it.hasNext()) {
                    String[] strArr = new String[1];
                    strArr[i3] = String.valueOf((Long) it.next());
                    sQLiteDatabase2 = sQLiteDatabase5;
                    try {
                        sQLiteDatabase2.execSQL(SQL_DEL_LAUNCH, strArr);
                        sQLiteDatabase5 = sQLiteDatabase2;
                    } catch (Throwable th10) {
                        th = th10;
                        sQLiteDatabase4 = sQLiteDatabase2;
                        i2 = 5;
                        this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                        this.mEngine.getAppLog().getMonitorHelper().sendError("pack failed", th);
                        getLogger().error(i2, "pack failed", th, new Object[i3]);
                        if (cursor != null) {
                        }
                        Utils.endDbTransactionSafely(sQLiteDatabase4);
                        resetZygoteByKey("launch");
                        resetZygoteByKey("terminate");
                        resetZygoteByKey("page");
                        str = "pack";
                        resetZygoteByKey(str);
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                sQLiteDatabase2 = sQLiteDatabase5;
            }
        }
        SQLiteDatabase sQLiteDatabase6 = sQLiteDatabase5;
        if (cursor.getCount() < 5) {
            try {
            } catch (Throwable th12) {
                th = th12;
                i2 = 5;
                sQLiteDatabase = sQLiteDatabase6;
                sQLiteDatabase4 = sQLiteDatabase;
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("pack failed", th);
                getLogger().error(i2, "pack failed", th, new Object[i3]);
                if (cursor != null) {
                }
                Utils.endDbTransactionSafely(sQLiteDatabase4);
                resetZygoteByKey("launch");
                resetZygoteByKey("terminate");
                resetZygoteByKey("page");
                str = "pack";
                resetZygoteByKey(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                i2 = 5;
                sQLiteDatabase = sQLiteDatabase6;
                try {
                    packLostData(jSONObject2, (Launch) launch.m432clone(), terminate, page4, pack3, sQLiteDatabase6, str3, jSONArrayArr3, jArr3, eventPriorityItem, i);
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th13) {
                            getLogger().error(i2, "close cursor failed", th13, new Object[i3]);
                        }
                    }
                    Utils.endDbTransactionSafely(sQLiteDatabase);
                    resetZygoteByKey("launch");
                    resetZygoteByKey("terminate");
                    resetZygoteByKey("page");
                    str = "pack";
                } catch (Throwable th14) {
                    th = th14;
                    sQLiteDatabase4 = sQLiteDatabase;
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("pack failed", th);
                    getLogger().error(i2, "pack failed", th, new Object[i3]);
                    if (cursor != null) {
                    }
                    Utils.endDbTransactionSafely(sQLiteDatabase4);
                    resetZygoteByKey("launch");
                    resetZygoteByKey("terminate");
                    resetZygoteByKey("page");
                    str = "pack";
                    resetZygoteByKey(str);
                }
                resetZygoteByKey(str);
            }
        }
        i2 = 5;
        sQLiteDatabase = sQLiteDatabase6;
        sQLiteDatabase.setTransactionSuccessful();
        if (cursor != null) {
        }
        Utils.endDbTransactionSafely(sQLiteDatabase);
        resetZygoteByKey("launch");
        resetZygoteByKey("terminate");
        resetZygoteByKey("page");
        str = "pack";
        resetZygoteByKey(str);
    }

    public synchronized void packByPriority(JSONObject jSONObject, EventPriorityItem eventPriorityItem, int i) {
        saveBeforeSendOrQuery();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            sQLiteDatabase = this.mOpenHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            int i2 = 200;
            for (int i3 = 200; i2 >= i3; i3 = 200) {
                queryEventByPriority(sQLiteDatabase, jSONArrayArr, jArr, eventPriorityItem.getPriority());
                int length = jSONArrayArr[1].length();
                if (length == 0) {
                    break;
                }
                Pack pack = new Pack();
                pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, null, null, null, jSONArrayArr, jArr, null, eventPriorityItem, i);
                saveAndDeleteDataFromPriorityPack(pack, sQLiteDatabase, eventPriorityItem.getPriority());
                i2 = length;
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    public synchronized List<ForwardEvent> queryForwardEvents() {
        ArrayList arrayList;
        saveBeforeSendOrQuery();
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.mOpenHelper.getWritableDatabase().rawQuery(SQL_SELECT_FORWARD_EVENT, null);
            while (cursor.moveToNext()) {
                ForwardEvent forwardEvent = new ForwardEvent();
                forwardEvent.readDb(cursor);
                arrayList.add(forwardEvent);
            }
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    private JSONObject checkVersion(Launch launch, JSONObject jSONObject) {
        if (TextUtils.equals(launch.verName, this.mEngine.getDm().getVersionName()) && launch.verCode == this.mEngine.getDm().getVersionCode()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            Utils.copy(jSONObject2, jSONObject);
            jSONObject2.put("app_version", launch.verName);
            jSONObject2.put("version_code", launch.verCode);
            return jSONObject2;
        } catch (JSONException e) {
            getLogger().error(5, "check version failed", e, new Object[0]);
            return jSONObject;
        }
    }

    private void packCurrentData(JSONObject jSONObject, Launch launch, Pack pack, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, HashMap<String, JSONObject> hashMap, EventPriorityItem eventPriorityItem, int i) {
        EventPriorityItem eventPriorityItem2;
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        Pack pack2;
        Launch launch2;
        JSONObject jSONObject2;
        boolean z;
        EventPriorityItem eventPriorityItem3;
        SQLiteDatabase sQLiteDatabase3;
        Pack pack3;
        PackCalculator packCalculator;
        boolean z2;
        getLogger().debug(5, "packCurrentData sid:{}", launch.sid);
        PackCalculator packCalculator2 = new PackCalculator();
        packCalculator2.beginPack(jSONObject);
        PackCalculator packCalculator3 = packCalculator2;
        int queryEvents = queryEvents(0, sQLiteDatabase, launch.sid, true, jSONArrayArr, jArr, eventPriorityItem, packCalculator3);
        boolean needLaunch = needLaunch(launch.sid);
        JSONArray impression = getImpression(launch.sid, hashMap);
        if (needLaunch || hasEvent(jArr) || impression != null) {
            eventPriorityItem2 = eventPriorityItem;
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            pack2 = pack;
            launch2 = launch;
            jSONObject2 = jSONObject;
            pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, needLaunch ? launch : null, null, null, jSONArrayArr, jArr, impression, eventPriorityItem, i);
            z = true;
            saveAndDeleteDataFromPack(pack2, true, sQLiteDatabase2, eventPriorityItem2);
        } else {
            eventPriorityItem2 = eventPriorityItem;
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            pack2 = pack;
            launch2 = launch;
            jSONObject2 = jSONObject;
            z = true;
        }
        int i2 = queryEvents;
        while (i2 < this.sEvents.length) {
            PackCalculator packCalculator4 = packCalculator3;
            packCalculator4.beginPack(jSONObject2);
            Pack pack4 = pack2;
            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
            EventPriorityItem eventPriorityItem4 = eventPriorityItem2;
            i2 = queryEvents(i2, sQLiteDatabase, launch2.sid, true, jSONArrayArr, jArr, eventPriorityItem, packCalculator4);
            if (hasEvent(jArr2)) {
                eventPriorityItem3 = eventPriorityItem4;
                sQLiteDatabase3 = sQLiteDatabase4;
                pack3 = pack4;
                packCalculator = packCalculator4;
                z2 = z;
                pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, null, null, null, jSONArrayArr, jArr, null, eventPriorityItem, i);
                saveAndDeleteDataFromPack(pack3, z2, sQLiteDatabase3, eventPriorityItem3);
            } else {
                eventPriorityItem3 = eventPriorityItem4;
                sQLiteDatabase3 = sQLiteDatabase4;
                pack3 = pack4;
                packCalculator = packCalculator4;
                z2 = z;
            }
            jArr2 = jArr;
            packCalculator3 = packCalculator;
            z = z2;
            eventPriorityItem2 = eventPriorityItem3;
            pack2 = pack3;
            jSONObject2 = jSONObject;
            launch2 = launch;
            sQLiteDatabase2 = sQLiteDatabase3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void packHistoryData(JSONObject jSONObject, Launch launch, Pack pack, Page page, Terminate terminate, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, HashMap<String, JSONObject> hashMap, EventPriorityItem eventPriorityItem, int i) {
        JSONObject jSONObject2;
        EventPriorityItem eventPriorityItem2;
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        Pack pack2;
        Launch launch2;
        boolean z;
        EventPriorityItem eventPriorityItem3;
        SQLiteDatabase sQLiteDatabase3;
        Pack pack3;
        boolean z2;
        PackCalculator packCalculator;
        boolean z3;
        boolean z4 = false;
        getLogger().debug(5, "packHistoryData sid:{}", launch.sid);
        PackCalculator packCalculator2 = new PackCalculator();
        packCalculator2.beginPack(jSONObject);
        PackCalculator packCalculator3 = packCalculator2;
        int queryEvents = queryEvents(0, sQLiteDatabase, launch.sid, true, jSONArrayArr, jArr, eventPriorityItem, packCalculator3);
        JSONArray queryPage = queryPage(launch, true, terminate, page, sQLiteDatabase, eventPriorityItem, hasEvent(jArr));
        launch.mBg = !(queryPage.length() > 0);
        JSONArray impression = getImpression(launch.sid, hashMap);
        if (launch.mBg) {
            if (needLaunch(launch.sid)) {
                eventPriorityItem2 = eventPriorityItem;
                jArr2 = jArr;
                sQLiteDatabase2 = sQLiteDatabase;
                pack2 = pack;
                launch2 = launch;
                jSONObject2 = jSONObject;
                z3 = true;
                pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, launch, null, null, jSONArrayArr, jArr, impression, eventPriorityItem, i);
            } else {
                jSONObject2 = jSONObject;
                eventPriorityItem2 = eventPriorityItem;
                jArr2 = jArr;
                sQLiteDatabase2 = sQLiteDatabase;
                pack2 = pack;
                launch2 = launch;
                z3 = true;
                if (hasEvent(jArr2) || (impression != null && impression.length() > 0)) {
                    pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, null, null, null, jSONArrayArr, jArr, impression, eventPriorityItem, i);
                } else {
                    z = true;
                    if (z4) {
                        saveAndDeleteDataFromPack(pack2, z, sQLiteDatabase2, eventPriorityItem2);
                    }
                    while (queryEvents < this.sEvents.length) {
                        PackCalculator packCalculator4 = packCalculator3;
                        packCalculator4.beginPack(jSONObject2);
                        boolean z5 = z;
                        Pack pack4 = pack2;
                        SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
                        EventPriorityItem eventPriorityItem4 = eventPriorityItem2;
                        queryEvents = queryEvents(queryEvents, sQLiteDatabase, launch2.sid, true, jSONArrayArr, jArr, eventPriorityItem, packCalculator4);
                        if (hasEvent(jArr2)) {
                            eventPriorityItem3 = eventPriorityItem4;
                            sQLiteDatabase3 = sQLiteDatabase4;
                            pack3 = pack4;
                            z2 = z5;
                            packCalculator = packCalculator4;
                            pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, null, null, null, jSONArrayArr, jArr, null, eventPriorityItem, i);
                            saveAndDeleteDataFromPack(pack3, z2, sQLiteDatabase3, eventPriorityItem3);
                        } else {
                            eventPriorityItem3 = eventPriorityItem4;
                            sQLiteDatabase3 = sQLiteDatabase4;
                            pack3 = pack4;
                            z2 = z5;
                            packCalculator = packCalculator4;
                        }
                        launch2 = launch;
                        jArr2 = jArr;
                        packCalculator3 = packCalculator;
                        eventPriorityItem2 = eventPriorityItem3;
                        pack2 = pack3;
                        sQLiteDatabase2 = sQLiteDatabase3;
                        z = z2;
                        jSONObject2 = jSONObject;
                    }
                }
            }
            z = z3;
        } else {
            jSONObject2 = jSONObject;
            eventPriorityItem2 = eventPriorityItem;
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            pack2 = pack;
            launch2 = launch;
            z = true;
            pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, null, terminate, queryPage, jSONArrayArr, jArr, impression, eventPriorityItem, i);
        }
        z4 = z;
        if (z4) {
        }
        while (queryEvents < this.sEvents.length) {
        }
    }

    private void packLostData(JSONObject jSONObject, Launch launch, Terminate terminate, Page page, Pack pack, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr, long[] jArr, EventPriorityItem eventPriorityItem, int i) {
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        Pack pack2;
        JSONObject jSONObject2;
        EventPriorityItem eventPriorityItem2;
        boolean z;
        SQLiteDatabase sQLiteDatabase3;
        Pack pack3;
        PackCalculator packCalculator;
        boolean z2;
        EventPriorityItem eventPriorityItem3;
        getLogger().debug(5, "packLostData exclude sid:{}", str);
        launch.sid = str;
        pack.sid = str;
        PackCalculator packCalculator2 = new PackCalculator();
        packCalculator2.beginPack(jSONObject);
        PackCalculator packCalculator3 = packCalculator2;
        int queryEvents = queryEvents(0, sQLiteDatabase, str, false, jSONArrayArr, jArr, eventPriorityItem, packCalculator3);
        JSONArray queryPage = queryPage(launch, false, terminate, page, sQLiteDatabase, eventPriorityItem, hasEvent(jArr));
        launch.mBg = !(queryPage.length() > 0);
        if (hasEvent(jArr) || !launch.mBg) {
            String appId = this.mEngine.getAppLog().getAppId();
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            pack2 = pack;
            jSONObject2 = jSONObject;
            pack.setData(appId, jSONObject, null, !launch.mBg ? terminate : null, launch.mBg ? null : queryPage, jSONArrayArr, jArr, null, eventPriorityItem, i);
            eventPriorityItem2 = eventPriorityItem;
            z = false;
            saveAndDeleteDataFromPack(pack2, false, sQLiteDatabase2, eventPriorityItem2);
        } else {
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            pack2 = pack;
            jSONObject2 = jSONObject;
            z = false;
            eventPriorityItem2 = eventPriorityItem;
        }
        int i2 = queryEvents;
        while (i2 < this.sEvents.length) {
            PackCalculator packCalculator4 = packCalculator3;
            packCalculator4.beginPack(jSONObject2);
            Pack pack4 = pack2;
            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
            i2 = queryEvents(i2, sQLiteDatabase, str, false, jSONArrayArr, jArr, eventPriorityItem, packCalculator4);
            if (hasEvent(jArr2)) {
                sQLiteDatabase3 = sQLiteDatabase4;
                pack3 = pack4;
                packCalculator = packCalculator4;
                z2 = z;
                eventPriorityItem3 = eventPriorityItem2;
                pack.setData(this.mEngine.getAppLog().getAppId(), jSONObject, null, null, null, jSONArrayArr, jArr, null, eventPriorityItem, i);
                saveAndDeleteDataFromPack(pack3, z2, sQLiteDatabase3, eventPriorityItem3);
            } else {
                sQLiteDatabase3 = sQLiteDatabase4;
                pack3 = pack4;
                packCalculator = packCalculator4;
                z2 = z;
                eventPriorityItem3 = eventPriorityItem2;
            }
            jArr2 = jArr;
            z = z2;
            eventPriorityItem2 = eventPriorityItem3;
            packCalculator3 = packCalculator;
            jSONObject2 = jSONObject;
            sQLiteDatabase2 = sQLiteDatabase3;
            pack2 = pack3;
        }
    }

    private boolean hasEvent(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    private void collectImpression(SQLiteDatabase sQLiteDatabase, HashMap<String, JSONObject> hashMap) {
        Launch launch = (Launch) this.ZYGOTES.get("launch");
        if (launch == null) {
            return;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery(selLaunch(3), null);
            for (boolean moveToLast = cursor.moveToLast(); moveToLast; moveToLast = cursor.moveToPrevious()) {
                launch.readDb(cursor);
                JSONObject jSONObject = new JSONObject();
                try {
                    this.mEngine.getAppLog().getSessionObserverHolder().onSessionBatchEvent(launch.dbId, launch.sid, jSONObject);
                } catch (Throwable th) {
                    getLogger().debug(5, "onSessionBatchEvent failed", th);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("collectImpression onSessionBatchEvent failed", th);
                }
                hashMap.put(launch.sid, jSONObject);
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th2) {
                    getLogger().debug(5, "close cursor failed", th2);
                }
            }
        } catch (Throwable th3) {
            try {
                getLogger().debug(5, "collect impression failed", th3);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.COLLECT_IMPRESSION_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("collectImpression failed", th3);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th4) {
                        getLogger().debug(5, "close cursor failed", th4);
                    }
                }
            } catch (Throwable th5) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th6) {
                        getLogger().debug(5, "close cursor failed", th6);
                    }
                }
                resetZygoteByKey("launch");
                throw th5;
            }
        }
        resetZygoteByKey("launch");
    }

    private JSONArray getImpression(String str, HashMap<String, JSONObject> hashMap) {
        JSONArray optJSONArray;
        JSONObject remove = hashMap.remove(str);
        JSONArray jSONArray = null;
        if (remove != null && ((optJSONArray = remove.optJSONArray(Api.KEY_IMPRESSION)) == null || optJSONArray.length() != 0)) {
            jSONArray = optJSONArray;
        }
        if (EventsSenderUtils.isEnable(this.mEngine.getAppLog().getAppId()) && jSONArray != null) {
            EventsSenderUtils.putEvent(this.mEngine.getAppLog().getAppId(), Api.KEY_IMPRESSION, jSONArray);
        }
        return jSONArray;
    }

    private List<Pack> splitPackToList(Pack pack) {
        ArrayList arrayList = new ArrayList();
        if (this.mEngine.getAppLog().isDataIsolateEnabled() && this.mEngine.getAppLog().getDataIsolateKey() != null) {
            Collection<Pack> splitByIsolateKey = pack.splitByIsolateKey(this.mEngine.getAppLog().getDataIsolateKey());
            if (splitByIsolateKey != null) {
                getLogger().debug(5, "Pack split to {} packs for data isolate: {}", Integer.valueOf(splitByIsolateKey.size()), this.mEngine.getAppLog().getDataIsolateKey());
                arrayList.addAll(splitByIsolateKey);
            } else {
                arrayList.add(pack);
            }
        } else {
            arrayList.add(pack);
        }
        if (!this.mEngine.getConfig().isPackSizeLimitEnabled()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((Pack) it.next()).splitBySizeLimited(this.mEngine.getConfig().getMaxPackSize()));
        }
        return arrayList2;
    }

    public long fastInsertPack(Pack pack) {
        long insert = this.mOpenHelper.getWritableDatabase().insert("pack", null, pack.toValues(null));
        if (insert < 0) {
            this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_PACK_FAILED_COUNT);
        }
        return insert;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveAndDeleteDataFromPack(Pack pack, boolean z, SQLiteDatabase sQLiteDatabase, EventPriorityItem eventPriorityItem) {
        SQLiteDatabase sQLiteDatabase2;
        boolean z2;
        if (sQLiteDatabase == null) {
            try {
                sQLiteDatabase2 = this.mOpenHelper.getWritableDatabase();
                z2 = true;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase2 = sQLiteDatabase;
                z2 = false;
                try {
                    getLogger().debug(5, "delete pack data failed", th);
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("saveAndDeleteDataFromPack failed", th);
                    if (!z2) {
                        return;
                    }
                } finally {
                    if (z2) {
                        Utils.endDbTransactionSafely(sQLiteDatabase2);
                    }
                }
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            z2 = false;
        }
        if (z2) {
            try {
                sQLiteDatabase2.beginTransaction();
            } catch (Throwable th2) {
                th = th2;
                getLogger().debug(5, "delete pack data failed", th);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("saveAndDeleteDataFromPack failed", th);
                if (!z2) {
                }
            }
        }
        Iterator<Pack> it = splitPackToList(pack).iterator();
        while (it.hasNext()) {
            insertPack(sQLiteDatabase2, it.next(), z);
        }
        if (pack.mMaxEventId > 0) {
            sQLiteDatabase2.execSQL(delEvent("event", pack.sid, z, pack.mMaxEventId, eventPriorityItem));
        }
        if (pack.mMaxEventV3Id > 0) {
            sQLiteDatabase2.execSQL(delEvent("eventv3", pack.sid, z, pack.mMaxEventV3Id, eventPriorityItem));
        }
        if (pack.mMaxMiscId > 0) {
            sQLiteDatabase2.execSQL(delEvent("event_misc", pack.sid, z, pack.mMaxMiscId, eventPriorityItem));
        }
        if (z2) {
            sQLiteDatabase2.setTransactionSuccessful();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveAndDeleteDataFromPriorityPack(Pack pack, SQLiteDatabase sQLiteDatabase, int i) {
        boolean z;
        if (sQLiteDatabase == null) {
            try {
                sQLiteDatabase = this.mOpenHelper.getWritableDatabase();
                z = true;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    getLogger().debug(5, "delete pack data failed", th);
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("saveAndDeleteDataFromPriorityPack " + i + " failed", th);
                    if (!z) {
                    }
                } finally {
                    if (z) {
                        Utils.endDbTransactionSafely(sQLiteDatabase);
                    }
                }
            }
        } else {
            z = false;
        }
        if (z) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th2) {
                th = th2;
                getLogger().debug(5, "delete pack data failed", th);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("saveAndDeleteDataFromPriorityPack " + i + " failed", th);
                if (!z) {
                    return;
                }
            }
        }
        Iterator<Pack> it = splitPackToList(pack).iterator();
        while (it.hasNext()) {
            insertPack(sQLiteDatabase, it.next(), false);
        }
        if (pack.mMaxEventV3Id > 0) {
            sQLiteDatabase.execSQL(delPriorityEvent("eventv3", pack.mMaxEventV3Id, i));
        }
        if (z) {
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    private void insertPack(SQLiteDatabase sQLiteDatabase, Pack pack, boolean z) {
        if (pack.isEmpty()) {
            getLogger().warn(5, "no need insert to db for empty pack: {}, matchSid: {}", pack, Boolean.valueOf(z));
            return;
        }
        if (this.mEngine.getAppLog().getMonitorHelper().isStageEnabled()) {
            Iterator<StageEventBasic> it = pack.getEventStainedEvents().iterator();
            while (it.hasNext()) {
                MonitorUtils.stageEvent(this.mEngine.getAppLog().getMonitorHelper(), EventStage.PACK_INSERT_START, it.next());
            }
        }
        long insert = sQLiteDatabase.insert("pack", null, pack.toValues(null));
        if (insert < 0) {
            if (pack.mLaunch != null) {
                this.mIdSendSet.remove(pack.mLaunch.sid);
            }
            pack.recordPackDetailLost();
            getLogger().error(5, "insert to db failed, pack: {}, result: {}", pack, Long.valueOf(insert));
            this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_PACK_FAILED_COUNT);
            this.mEngine.getAppLog().getMonitorHelper().sendError("pack insert failed for db id < 0", null);
            throw new SQLiteException("insert pack to db failed for result id < 0.");
        }
        if (this.mEngine.getAppLog().getMonitorHelper().isStageEnabled()) {
            Iterator<StageEventBasic> it2 = pack.getEventStainedEvents().iterator();
            while (it2.hasNext()) {
                MonitorUtils.stageEvent(this.mEngine.getAppLog().getMonitorHelper(), EventStage.PACK_INSERT_END, it2.next());
            }
        }
        pack.dbId = insert;
        getLogger().info(5, "pack: {} insert to db success!", pack, Long.valueOf(insert));
        if (pack.mTerm == null || pack.mPages == null || pack.mPages.length() <= 0) {
            return;
        }
        sQLiteDatabase.execSQL(delPage(pack.sid, z));
    }

    private boolean hasLaunch(SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select count(1) from launch where session_id" + (z ? "='" : "!='") + str + "'", null);
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getInt(0) > 0;
            }
        } catch (Throwable unused) {
            Utils.closeSafely(cursor);
        }
        return false;
    }

    private int queryEvents(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, JSONArray[] jSONArrayArr, long[] jArr, EventPriorityItem eventPriorityItem, PackCalculator packCalculator) {
        int i2;
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = packCalculator.isEnabled() ? PackOptConfig.packMaxEventCount : 200;
        int i5 = i3;
        int i6 = i4;
        while (i6 > 0 && i5 < this.sEvents.length) {
            i2 = i5;
            queryEvent(sQLiteDatabase, str, i6, i5, z, jSONArrayArr, jArr, eventPriorityItem, i4, packCalculator);
            if (packCalculator.isEnabled() && packCalculator.isAbort()) {
                break;
            }
            i6 -= jSONArrayArr[i2].length();
            i5 = i6 > 0 ? i2 + 1 : i2;
        }
        i2 = i5;
        for (int i7 = i2 + 1; i7 < jSONArrayArr.length; i7++) {
            jSONArrayArr[i7] = null;
            jArr[i7] = 0;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r25.setAbort(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d6, code lost:
    
        r21[r19] = r10;
        r22[r19] = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00da, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
    
        if (r11 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void queryEvent(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, EventPriorityItem eventPriorityItem, int i3, PackCalculator packCalculator) {
        boolean appendLogData;
        BaseData baseData = this.sEvents[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = sQLiteDatabase.rawQuery(selEvent(baseData, str, z, i, eventPriorityItem), null);
            int i4 = 0;
            while (true) {
                if (!cursor.moveToNext() || i4 > i3) {
                    break;
                }
                baseData.readDb(cursor);
                JSONObject packJson = baseData.toPackJson();
                if (packCalculator.isEnabled()) {
                    if (baseData instanceof EventV3) {
                        appendLogData = packCalculator.appendEventV3(packJson);
                    } else if (baseData instanceof Event) {
                        appendLogData = packCalculator.appendEventV1(packJson);
                    } else {
                        appendLogData = packCalculator.appendLogData(packJson);
                    }
                    if (!appendLogData) {
                        break;
                    }
                }
                jSONArray.put(packJson);
                if (baseData.dbId > j) {
                    j = baseData.dbId;
                }
                i4++;
            }
        } catch (Throwable th) {
            try {
                if (baseData instanceof EventV3) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_EVENT_V3_FAILED_COUNT);
                } else if (baseData instanceof Event) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_EVENT_V1_FAILED_COUNT);
                } else if (baseData instanceof EventMisc) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_EVENT_MISC_FAILED_COUNT);
                }
                this.mEngine.getAppLog().getMonitorHelper().sendError("queryEvent failed", th);
                if (th instanceof SQLiteBlobTooBigException) {
                    tryIncreaseCursorWindowSize();
                }
                getLogger().error(5, "query event failed", th, new Object[0]);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                resetEventsByIndex(i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a2, code lost:
    
        r12[1] = r2;
        r13[1] = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (r4 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void queryEventByPriority(SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        BaseData baseData = this.sEvents[1];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            cursor = sQLiteDatabase.rawQuery(selPriorityEvent(baseData, 200, i), null);
            for (int i2 = 0; cursor.moveToNext() && i2 <= 200; i2++) {
                baseData.readDb(cursor);
                jSONArray.put(baseData.toPackJson());
                if (baseData.dbId > j) {
                    j = baseData.dbId;
                }
            }
        } catch (Throwable th) {
            try {
                if (baseData instanceof EventV3) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_EVENT_V3_FAILED_COUNT);
                } else if (baseData instanceof Event) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_EVENT_V1_FAILED_COUNT);
                } else if (baseData instanceof EventMisc) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_EVENT_MISC_FAILED_COUNT);
                }
                this.mEngine.getAppLog().getMonitorHelper().sendError("queryEventByPriority failed", th);
                if (th instanceof SQLiteBlobTooBigException) {
                    tryIncreaseCursorWindowSize();
                }
                getLogger().error(5, "query event failed", th, new Object[0]);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                resetEventsByIndex(1);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x010c, code lost:
    
        if (r14 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d4, code lost:
    
        r0 = r18;
        r5 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0113, code lost:
    
        if (r6.length() <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0119, code lost:
    
        if (r16 <= 1000) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011b, code lost:
    
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011f, code lost:
    
        r24.initEventId();
        r24.setAppId(r21.mEngine.getAppLog().getAppId());
        r24.duration = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0131, code lost:
    
        if (r23 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0133, code lost:
    
        r24.sid = r22.sid;
        r24.setTs(r22.f80ts);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014c, code lost:
    
        r21.mEngine.getSession().fillUserInfoAndAbSdkVersion(r24, r22.user_id);
        r24.uuid = r22.uuid;
        r24.stopTs = r24.f80ts + r11;
        r24.eid = r21.mEngine.getSession().nextEventId();
        r24.lastSession = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0175, code lost:
    
        if (android.text.TextUtils.isEmpty(r22.lastSession) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0177, code lost:
    
        r24.lastSession = r22.lastSession;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0186, code lost:
    
        r24.sentryStained = com.bytedance.applog.monitor.MonitorUtils.getStainedValue(r21.mEngine.getAppLog().getMonitorHelper(), r24);
        r24.flatParams = r13;
        r21.mEngine.getAppLog().getMonitorHelper().increaseStats(com.bytedance.applog.monitor.p006v3.StatsCountKeys.COLLECT_TERMINATE_COUNT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a9, code lost:
    
        if (r24.sentryStained <= 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ab, code lost:
    
        com.bytedance.applog.monitor.MonitorUtils.stageEvent(r21.mEngine.getAppLog().getMonitorHelper(), com.bytedance.applog.monitor.p006v3.EventStage.COLLECTED, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ba, code lost:
    
        r21.mEngine.getAppLog().getSessionObserverHolder().onSessionTerminate(-1, r24.sid, r24.toPackJson());
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d1, code lost:
    
        getLogger().error(5, "notify session terminate failed", r0, new java.lang.Object[0]);
        r21.mEngine.getAppLog().getMonitorHelper().sendError("notify onSessionTerminate failed", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0180, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0182, code lost:
    
        r24.lastSession = r0;
        r24.uuid = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013d, code lost:
    
        r24.sid = java.util.UUID.randomUUID().toString();
        r24.setTs(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x011e, code lost:
    
        r11 = 1000;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray queryPage(Launch launch, boolean z, Terminate terminate, Page page, SQLiteDatabase sQLiteDatabase, EventPriorityItem eventPriorityItem, boolean z2) {
        String str;
        Cursor cursor;
        long j;
        String str2;
        String str3;
        int priority;
        JSONArray jSONArray = new JSONArray();
        if (eventPriorityItem != null && ((priority = eventPriorityItem.getPriority()) == 0 || (-1 != priority && !z2))) {
            return jSONArray;
        }
        try {
            cursor = sQLiteDatabase.rawQuery(selPage(launch.sid, z), null);
            try {
                HashMap hashMap = new HashMap(8);
                str = null;
                j = 0;
                str2 = null;
                str3 = null;
                while (cursor.moveToNext()) {
                    try {
                        page.readDb(cursor);
                        getLogger().debug(5, "queryPage: {}", page);
                        Integer num = (Integer) hashMap.get(page.name);
                        if (!page.isResumeEvent()) {
                            hashMap.put(page.name, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
                            j = page.duration >= 1000 ? j + page.duration : j + 1000;
                            jSONArray.put(page.toPackJson());
                            if (!TextUtils.isEmpty(page.lastSession)) {
                                String str4 = page.lastSession;
                                try {
                                    str2 = str4;
                                    str3 = page.uuid;
                                } catch (Throwable th) {
                                    th = th;
                                    str2 = str4;
                                    try {
                                        getLogger().error(5, "query page failed", th, new Object[0]);
                                        this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_PAGE_FAILED_COUNT);
                                        this.mEngine.getAppLog().getMonitorHelper().sendError("query page failed", th);
                                    } finally {
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                    }
                                }
                            }
                            str = page.flatParams;
                        } else if (num != null) {
                            Integer valueOf = Integer.valueOf(num.intValue() - 1);
                            if (valueOf.intValue() > 0) {
                                hashMap.put(page.name, valueOf);
                            } else {
                                hashMap.remove(page.name);
                            }
                        } else {
                            page.duration = 1000L;
                            j += page.duration;
                            jSONArray.put(page.toPackJson());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                str = null;
                j = 0;
                str2 = null;
                str3 = null;
                getLogger().error(5, "query page failed", th, new Object[0]);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.QUERY_PAGE_FAILED_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("query page failed", th);
            }
        } catch (Throwable th4) {
            th = th4;
            str = null;
            cursor = null;
        }
        LogUtils.sendObject("event_receive", terminate);
        return jSONArray;
    }

    public ArrayList<Pack> queryPack(int i, EventPriorityItem eventPriorityItem) {
        Pack pack = (Pack) this.ZYGOTES.get("pack");
        Cursor cursor = null;
        try {
            cursor = this.mOpenHelper.getWritableDatabase().rawQuery(selPack(i, eventPriorityItem), null);
            ArrayList<Pack> arrayList = new ArrayList<>();
            while (cursor.moveToNext()) {
                pack = (Pack) pack.m432clone();
                pack.readDb(cursor);
                arrayList.add(pack);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                boolean z = th instanceof SQLiteBlobTooBigException;
                getLogger().error(5, "query pack failed", th, new Object[0]);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("query pack failed", th);
                if (cursor != null) {
                    cursor.close();
                }
                resetZygoteByKey("pack");
                if (z) {
                    tryIncreaseCursorWindowSize();
                }
                return new ArrayList<>();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                resetZygoteByKey("pack");
            }
        }
    }

    private void tryIncreaseCursorWindowSize() {
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(null);
            if (i <= 0 || i > 8388608) {
                return;
            }
            declaredField.setInt(null, i * 2);
        } catch (Throwable th) {
            getLogger().error(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
        }
    }

    public void setResult(List<Pack> list, List<Pack> list2) {
        getLogger().debug(5, "setResult: del -> {}, fail -> {}", list, list2);
        Iterator<Pack> it = list2.iterator();
        ArrayList arrayList = new ArrayList();
        IReportDropStrategy reportDropStrategy = this.mEngine.getAppLog().getReportDropStrategy();
        while (it.hasNext()) {
            Pack next = it.next();
            long timeoutInMills = reportDropStrategy.getTimeoutInMills();
            if (timeoutInMills > 0 && Math.abs(System.currentTimeMillis() - next.f80ts) >= timeoutInMills) {
                list.add(next);
                arrayList.add(next);
                it.remove();
            } else {
                int maxRetryTimes = reportDropStrategy.getMaxRetryTimes();
                if (maxRetryTimes >= 0 && next.fail >= maxRetryTimes) {
                    list.add(next);
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            for (Pack pack : list) {
                int delete = writableDatabase.delete("pack", WHERE_ID_CLAUSE, new String[]{String.valueOf(pack.dbId)});
                if (delete <= 0) {
                    getLogger().error(5, "delete from db failed, pack: {}, rows: {}", pack, Integer.valueOf(delete));
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    this.mEngine.getAppLog().getLogReportMonitor().onDbError(LogReportMonitor.DB_DELETE_LOG_FAILED, "fail delete pack:" + pack.dbId);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("delete pack failed for zero", null);
                }
            }
            for (Pack pack2 : list2) {
                long j = pack2.dbId;
                int i = pack2.fail + 1;
                pack2.fail = i;
                writableDatabase.execSQL(failPack(j, i));
            }
        } catch (Throwable th) {
            getLogger().error(5, "set result failed", th, new Object[0]);
            this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            this.mEngine.getAppLog().getLogReportMonitor().onDbError(LogReportMonitor.DB_DELETE_LOG_ERROR, th);
            this.mEngine.getAppLog().getMonitorHelper().sendError("handle pack send result failed", th);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Pack) it2.next()).recordPackDetailLost();
        }
    }

    public void save(ArrayList<BaseData> arrayList) {
        save(arrayList, true);
    }

    public synchronized void save(ArrayList<BaseData> arrayList, boolean z) {
        if (!this.mEnableMemoryCache) {
            saveReal(arrayList);
            return;
        }
        int size = arrayList == null ? 0 : arrayList.size();
        int size2 = this.memoryCache.size() + size;
        if (size2 == 0) {
            return;
        }
        if (!z && size2 < this.mEngine.getAppLog().getInsertCacheMaxCount()) {
            this.memoryCache.addAll(arrayList);
            if (getWorkHandler() == null) {
                save(null, true);
            } else if (!getWorkHandler().hasMessages(0)) {
                getWorkHandler().sendEmptyMessageDelayed(0, this.mEngine.getAppLog().getInsertByCacheMaxIntervalMills());
            }
        }
        ArrayList<BaseData> arrayList2 = new ArrayList<>(this.memoryCache);
        this.memoryCache.clear();
        if (size > 0) {
            arrayList2.addAll(arrayList);
        }
        if (getWorkHandler() != null) {
            getWorkHandler().removeCallbacksAndMessages(null);
        }
        saveReal(arrayList2);
    }

    private Handler getWorkHandler() {
        if (this.mWorkHandler == null && Looper.myLooper() != null) {
            this.mWorkHandler = new DbHandler(Looper.myLooper());
        }
        return this.mWorkHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class DbHandler extends Handler {
        public DbHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            DbStore.this.save(null, true);
        }
    }

    private void saveBeforeSendOrQuery() {
        if (this.mEnableMemoryCache) {
            save(null);
        }
    }

    public synchronized void setEnableMemoryCache(boolean z) {
        if (this.mEnableMemoryCache && !z) {
            save(null);
        }
        this.mEnableMemoryCache = z;
    }

    public void setEnableTransaction(boolean z) {
        this.mEnableTransaction = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[Catch: all -> 0x00ed, LOOP:1: B:26:0x00a9->B:28:0x00af, LOOP_END, TryCatch #3 {all -> 0x00ed, blocks: (B:25:0x00a5, B:26:0x00a9, B:28:0x00af, B:30:0x00c7, B:31:0x00cb, B:33:0x00d1), top: B:24:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1 A[Catch: all -> 0x00ed, LOOP:2: B:31:0x00cb->B:33:0x00d1, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x00ed, blocks: (B:25:0x00a5, B:26:0x00a9, B:28:0x00af, B:30:0x00c7, B:31:0x00cb, B:33:0x00d1), top: B:24:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveReal(ArrayList<BaseData> arrayList) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        boolean z;
        Iterator<Launch> it;
        Iterator<Terminate> it2;
        if (arrayList == null) {
            return;
        }
        ArrayList<Launch> arrayList2 = new ArrayList<>(4);
        ArrayList<BaseData> arrayList3 = new ArrayList<>(4);
        ArrayList<Terminate> arrayList4 = new ArrayList<>(4);
        boolean z2 = this.mEnableTransaction;
        try {
            SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            if (z2) {
                try {
                    writableDatabase.beginTransaction();
                } catch (Throwable th2) {
                    sQLiteDatabase = writableDatabase;
                    th = th2;
                    z = false;
                    if (z2) {
                        try {
                            Utils.endDbTransactionSafely(sQLiteDatabase);
                            fallbackInsert(arrayList, arrayList2, arrayList3, arrayList4, sQLiteDatabase);
                        } finally {
                            if (z2) {
                                Utils.endDbTransactionSafely(sQLiteDatabase);
                            }
                        }
                    }
                    getLogger().error(5, "save db failed", th, new Object[0]);
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    this.mEngine.getAppLog().getMonitorHelper().sendError("save base data list failed", th);
                    notifyEventObserver(arrayList3);
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                    }
                    it2 = arrayList4.iterator();
                    while (it2.hasNext()) {
                    }
                }
            }
            insertDbAndMonitor(arrayList, arrayList2, arrayList3, arrayList4, writableDatabase);
            if (z2) {
                writableDatabase.setTransactionSuccessful();
                z = true;
            } else {
                z = false;
            }
            try {
                if (!LogUtils.isDisabled()) {
                    Iterator<BaseData> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        LogUtils.sendObject("event_save_db", it3.next());
                    }
                }
                if (z2) {
                    Utils.endDbTransactionSafely(writableDatabase);
                }
            } catch (Throwable th3) {
                sQLiteDatabase = writableDatabase;
                th = th3;
                if (z2 && !z) {
                    Utils.endDbTransactionSafely(sQLiteDatabase);
                    fallbackInsert(arrayList, arrayList2, arrayList3, arrayList4, sQLiteDatabase);
                }
                getLogger().error(5, "save db failed", th, new Object[0]);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("save base data list failed", th);
                notifyEventObserver(arrayList3);
                it = arrayList2.iterator();
                while (it.hasNext()) {
                }
                it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                }
            }
        } catch (Throwable th4) {
            sQLiteDatabase = null;
            th = th4;
        }
        notifyEventObserver(arrayList3);
        try {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                Launch next = it.next();
                this.mEngine.getAppLog().getSessionObserverHolder().onSessionStart(next.dbId, next.sid);
            }
            it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                Terminate next2 = it2.next();
                this.mEngine.getAppLog().getSessionObserverHolder().onSessionTerminate(next2.dbId, next2.sid, next2.toPackJson());
            }
        } catch (Throwable th5) {
            getLogger().error(5, "onSessionStart failed", th5, new Object[0]);
            this.mEngine.getAppLog().getMonitorHelper().sendError("notify onSessionStart or onSessionTerminate failed", th5);
        }
    }

    private void fallbackInsert(ArrayList<BaseData> arrayList, ArrayList<Launch> arrayList2, ArrayList<BaseData> arrayList3, ArrayList<Terminate> arrayList4, SQLiteDatabase sQLiteDatabase) {
        arrayList2.clear();
        arrayList3.clear();
        arrayList4.clear();
        try {
            insertDbAndMonitor(arrayList, arrayList2, arrayList3, arrayList4, sQLiteDatabase);
        } catch (Throwable th) {
            getLogger().error(5, "save db failed", th, new Object[0]);
            this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            this.mEngine.getAppLog().getMonitorHelper().sendError("save base data list failed", th);
        }
    }

    private void insertDbAndMonitor(ArrayList<BaseData> arrayList, ArrayList<Launch> arrayList2, ArrayList<BaseData> arrayList3, ArrayList<Terminate> arrayList4, SQLiteDatabase sQLiteDatabase) {
        Iterator<BaseData> it = arrayList.iterator();
        ContentValues contentValues = null;
        while (it.hasNext()) {
            BaseData next = it.next();
            if (TextUtils.isEmpty(next.appId)) {
                next.setAppId(this.mEngine.getAppLog().getAppId());
            }
            if (next.sentryStained > 0) {
                MonitorUtils.stageEvent(this.mEngine.getAppLog().getMonitorHelper(), EventStage.DB_INSERT_START, next);
            }
            String tableName = next.getTableName();
            contentValues = next.toValues(contentValues);
            next.dbId = sQLiteDatabase.insert(tableName, null, contentValues);
            boolean z = next.dbId >= 0;
            if (next.sentryStained > 0) {
                MonitorUtils.stageEvent(this.mEngine.getAppLog().getMonitorHelper(), z ? EventStage.DB_SAVE_END : EventStage.DB_SAVE_FAILED, next);
            }
            if (!z) {
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            }
            if (next instanceof Event) {
                arrayList3.add(next);
                if (!z) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_EVENT_V1_FAILED_COUNT);
                }
            } else if (next instanceof EventV3) {
                arrayList3.add(next);
                if (!z) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_EVENT_V3_FAILED_COUNT);
                }
            } else if (next instanceof EventMisc) {
                arrayList3.add(next);
                if (!z) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_EVENT_MISC_FAILED_COUNT);
                }
            } else if (next instanceof Launch) {
                arrayList2.add((Launch) next);
                if (!z) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_SESSION_FAILED_COUNT);
                }
            } else if (next instanceof Terminate) {
                arrayList4.add((Terminate) next);
                if (!z) {
                    this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_SESSION_FAILED_COUNT);
                }
            } else if ((next instanceof Page) && !z) {
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.INSERT_PAGE_FAILED_COUNT);
            }
        }
    }

    public void notifyEventObserver(List<BaseData> list) {
        if (this.mEngine.getAppLog().getEventObserverHolder().noStage(0)) {
            return;
        }
        for (BaseData baseData : list) {
            try {
                if ("event".equals(baseData.getTableName())) {
                    Event event = (Event) baseData;
                    this.mEngine.getAppLog().getEventObserverHolder().onEvent(0, event.category, event.tag, event.label, event.value, event.extValue, event.param);
                } else if ("eventv3".equals(baseData.getTableName())) {
                    EventV3 eventV3 = (EventV3) baseData;
                    this.mEngine.getAppLog().getEventObserverHolder().onEventV3(0, eventV3.getEvent(), eventV3.getContent());
                } else if ("event_misc".equals(baseData.getTableName())) {
                    EventMisc eventMisc = (EventMisc) baseData;
                    this.mEngine.getAppLog().getEventObserverHolder().onMiscEvent(0, eventMisc.getLogType(), eventMisc.getContent());
                }
            } catch (Throwable th) {
                getLogger().error(5, "notify event observer before store failed", th, new Object[0]);
                this.mEngine.getAppLog().getMonitorHelper().sendError("notify event observer failed", th);
            }
        }
    }

    public void clearAllTables() {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (this.mEnableMemoryCache) {
            synchronized (this) {
                this.memoryCache.clear();
            }
        }
        try {
            sQLiteDatabase = this.mOpenHelper.getWritableDatabase();
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<BaseData> it = this.ZYGOTES.values().iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete(it.next().getTableName(), null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th3) {
            th = th3;
            try {
                getLogger().error(5, "clear tables failed", th, new Object[0]);
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                this.mEngine.getAppLog().getMonitorHelper().sendError("clearAllTables failed", th);
            } finally {
                Utils.endDbTransactionSafely(sQLiteDatabase);
            }
        }
    }

    public void deleteForwardEvents(List<ForwardEvent> list) {
        long j = 0;
        for (ForwardEvent forwardEvent : list) {
            if (forwardEvent.dbId > j) {
                j = forwardEvent.dbId;
            }
        }
        try {
            this.mOpenHelper.getWritableDatabase().delete("forward_eventv3", "_id <= ?", new String[]{String.valueOf(j)});
        } catch (Throwable th) {
            getLogger().error(5, "delete forward events failed", th, new Object[0]);
            this.mEngine.getAppLog().getMonitorHelper().sendError("deleteForwardEvents failed", th);
        }
    }

    public void readPiledUpEventCount() {
        Cursor cursor;
        Throwable th;
        this.piledUpEventCount = 0;
        this.piledUpLaunchCount = 0;
        this.piledUpTerminateCount = 0;
        this.piledUpPackCount = 0;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase readableDatabase = this.mOpenHelper.getReadableDatabase();
            Iterator it = Arrays.asList("event", "eventv3", "event_misc").iterator();
            cursor = null;
            while (it.hasNext()) {
                try {
                    try {
                        cursor = readableDatabase.rawQuery("select count(1) from " + ((String) it.next()), null);
                        if (cursor != null && cursor.moveToFirst()) {
                            this.piledUpEventCount += cursor.getInt(0);
                        }
                    } catch (Throwable unused) {
                        Utils.closeSafely(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        getLogger().error(5, "count all events failed", th, new Object[0]);
                        this.mEngine.getAppLog().getMonitorHelper().sendError("readPiledUpEventCount failed", th);
                        return;
                    } finally {
                        Utils.closeSafely(cursor);
                    }
                }
            }
            cursor2 = readableDatabase.rawQuery("select _launch_count, _terminate_count, _event_v1_count, _event_v3_count, _event_misc_count, _impression_count from pack", null);
            if (cursor2 != null) {
                this.piledUpPackCount = cursor2.getCount();
                while (cursor2.moveToNext()) {
                    this.piledUpLaunchCount += cursor2.getInt(0);
                    this.piledUpTerminateCount += cursor2.getInt(1);
                    int i = this.piledUpEventCount + cursor2.getInt(2);
                    this.piledUpEventCount = i;
                    int i2 = i + cursor2.getInt(3);
                    this.piledUpEventCount = i2;
                    this.piledUpEventCount = i2 + cursor2.getInt(4);
                }
            }
            Utils.closeSafely(cursor2);
        } catch (Throwable th3) {
            cursor = cursor2;
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class DbOpenHelper extends SQLiteOpenHelper {
        private long dbInitSize;

        DbOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
            this.dbInitSize = 0L;
            File databasePath = context.getDatabasePath(str);
            this.dbInitSize = databasePath != null ? databasePath.length() : 0L;
        }

        public int getDbInitSizeInKb() {
            long j = this.dbInitSize;
            if (j > 0) {
                return Math.toIntExact(j / 1024);
            }
            return 0;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator it = DbStore.this.ZYGOTES.values().iterator();
                while (it.hasNext()) {
                    String createTable = ((BaseData) it.next()).createTable();
                    if (createTable != null) {
                        sQLiteDatabase.execSQL(createTable);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            IAppLogLogger logger = DbStore.this.getLogger();
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            logger.debug(5, "onUpgrade: v{} -> v{}", objArr);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator it = DbStore.this.ZYGOTES.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ((BaseData) it.next()).getTableName());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    onCreate(sQLiteDatabase);
                } finally {
                }
            }
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
