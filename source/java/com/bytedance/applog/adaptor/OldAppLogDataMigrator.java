package com.bytedance.applog.adaptor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.concurrent.AppLogExecutors;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.Pack;
import com.bytedance.applog.util.DateUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OldAppLogDataMigrator {
    private static final String oldAppLogDbName = "ss_app_log.db";
    private static final String queryOldAppLogPagesSql = "select p.name, p.duration, s.value, s.timestamp from page p left join session as s on p.session_id  = s._id where s.value is not null and s.timestamp is not null";
    private static final List<String> logTags = Collections.singletonList("OldAppLogDataMigrator");
    private static volatile int maxQueryLogQueueNum = 10;
    private static final String queryOldAppLogLogIdsSql = "select _id from queue order by _id asc limit " + maxQueryLogQueueNum;
    private static volatile int queryEventMaxNum = 1000;
    private static volatile boolean enableMigrateEvent = false;
    private static volatile boolean enableMigrateStayDuration = false;
    private static volatile boolean enableMigrateLog = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static String getQueryOldAppLogEventSql(boolean z) {
        return "SELECT event._id as _id, category, tag, label, event.value, ext_value, ext_json, user_id, event.timestamp, event.event_index as event_index, user_type, user_is_login, user_is_auth, uid, s.value as session_id " + (z ? ", disable_personalization" : "") + " FROM event left join session s on event.session_id  = s._id order by event._id asc limit ?";
    }

    public static void setMaxEventNumOnceMigrate(int i) {
        queryEventMaxNum = i;
    }

    public static void setEventMigrateEnabled(boolean z) {
        enableMigrateEvent = z;
    }

    public static void setStayDurationMigrateEnabled(boolean z) {
        enableMigrateStayDuration = z;
    }

    public static void setLogMigrateEnabled(boolean z) {
        enableMigrateLog = z;
    }

    public static void migrateStayDuration(final AppLogInstance appLogInstance, final DbStore dbStore) {
        if (enableMigrateStayDuration && appLogInstance.isMigrateOldAppLogDataEnabled()) {
            appLogInstance.getLogger().info(logTags, "Start to migrate stay duration data with pages...", new Object[0]);
            AppLogExecutors.getSingleExecutor().submit(new Runnable() { // from class: com.bytedance.applog.adaptor.OldAppLogDataMigrator.1
                @Override // java.lang.Runnable
                public void run() {
                    Cursor cursor;
                    Cursor cursor2;
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Start to do migrate stay duration data task...", new Object[0]);
                    SQLiteDatabase writableDatabase = new EmptyDbOpenHelper(AppLogInstance.this.getContext(), OldAppLogDataMigrator.oldAppLogDbName).getWritableDatabase();
                    int i = 2;
                    HashMap hashMap = new HashMap(2);
                    Cursor cursor3 = null;
                    try {
                        writableDatabase.beginTransaction();
                        Cursor rawQuery = writableDatabase.rawQuery(OldAppLogDataMigrator.queryOldAppLogPagesSql, null);
                        while (rawQuery.moveToNext()) {
                            try {
                                String string = rawQuery.getString(0);
                                long j = rawQuery.getLong(1);
                                String string2 = rawQuery.getString(i);
                                long j2 = rawQuery.getLong(3);
                                JSONObject jSONObject = (JSONObject) hashMap.get(string2);
                                if (jSONObject == null) {
                                    try {
                                        jSONObject = new JSONObject();
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor3 = rawQuery;
                                        try {
                                            AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old applog sd data", th, new Object[0]);
                                            Utils.endDbTransactionSafely(writableDatabase);
                                            Utils.closeSafely(cursor3);
                                            Utils.closeSafely(writableDatabase);
                                        } catch (Throwable th2) {
                                            Utils.endDbTransactionSafely(writableDatabase);
                                            Utils.closeSafely(cursor3);
                                            Utils.closeSafely(writableDatabase);
                                            throw th2;
                                        }
                                    }
                                }
                                JSONObject jSONObject2 = jSONObject;
                                cursor = rawQuery;
                                try {
                                    jSONObject2.put("duration", jSONObject2.optLong("duration", 0L) + j);
                                    jSONObject2.put(Api.KEY_DATETIME, DateUtils.getDateTimeFormat().format(new Date(j2)));
                                    jSONObject2.put("session_id", string2);
                                    jSONObject2.put(Api.KEY_LOCAL_TIME_MS, j2);
                                    if (!TextUtils.isEmpty(AppLogInstance.this.getAbSdkVersion())) {
                                        jSONObject2.put(Api.KEY_AB_SDK_VERSION, AppLogInstance.this.getAbSdkVersion());
                                    }
                                    if (!TextUtils.isEmpty(AppLogInstance.this.getUserUniqueID())) {
                                        jSONObject2.put("user_unique_id", AppLogInstance.this.getUserUniqueID());
                                    }
                                    jSONObject2.put(Api.KEY_EVENT_INDEX, 0);
                                    JSONArray optJSONArray = jSONObject2.optJSONArray(Api.KEY_ACTIVITES);
                                    if (optJSONArray == null) {
                                        optJSONArray = new JSONArray();
                                    }
                                    JSONArray jSONArray = new JSONArray();
                                    jSONArray.put(0, string);
                                    jSONArray.put(1, j);
                                    optJSONArray.put(jSONArray);
                                    jSONObject2.put(Api.KEY_ACTIVITES, optJSONArray);
                                    hashMap.put(string2, jSONObject2);
                                    rawQuery = cursor;
                                    i = 2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor3 = cursor;
                                    AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old applog sd data", th, new Object[0]);
                                    Utils.endDbTransactionSafely(writableDatabase);
                                    Utils.closeSafely(cursor3);
                                    Utils.closeSafely(writableDatabase);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                cursor = rawQuery;
                            }
                        }
                        cursor2 = rawQuery;
                        AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Total {} terminate found.", Integer.valueOf(hashMap.size()));
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    if (hashMap.isEmpty()) {
                        AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "No terminate found.", new Object[0]);
                        writableDatabase.setTransactionSuccessful();
                        Utils.endDbTransactionSafely(writableDatabase);
                        Utils.closeSafely(cursor2);
                        Utils.closeSafely(writableDatabase);
                        return;
                    }
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        jSONArray2.put((JSONObject) it.next());
                    }
                    Pack fromTerminateArray = Pack.fromTerminateArray(AppLogInstance.this.getAppId(), AppLogInstance.this.getHeader(), jSONArray2, 11);
                    dbStore.saveAndDeleteDataFromPack(fromTerminateArray, true, null, null);
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Pack saved: {}.", Long.valueOf(fromTerminateArray.getDbId()));
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Old {} pages deleted.", Integer.valueOf(writableDatabase.delete("page", null, null)));
                    writableDatabase.setTransactionSuccessful();
                    Utils.endDbTransactionSafely(writableDatabase);
                    Utils.closeSafely(cursor2);
                    Utils.closeSafely(writableDatabase);
                }
            });
        }
    }

    public static void migrateEvents(final AppLogInstance appLogInstance, final DbStore dbStore) {
        if (enableMigrateEvent && appLogInstance.isMigrateOldAppLogDataEnabled()) {
            appLogInstance.getLogger().info(logTags, "Start to migrate events...", new Object[0]);
            AppLogExecutors.getSingleExecutor().submit(new Runnable() { // from class: com.bytedance.applog.adaptor.OldAppLogDataMigrator.2
                /* JADX WARN: Can't wrap try/catch for region: R(3:(6:13|14|15|16|(2:18|19)(74:21|(1:23)(1:238)|24|(1:26)(1:237)|27|(1:29)(1:236)|30|(2:32|(62:34|(1:36)|37|38|39|40|(2:42|43)(1:231)|44|45|46|47|48|49|(1:51)(1:226)|52|(1:54)(1:225)|55|(1:57)(1:224)|58|(1:60)(1:223)|61|62|(1:64)(1:222)|(3:66|67|68)(1:221)|69|70|71|72|(2:74|(26:76|(1:78)|79|(1:81)|82|83|84|85|86|87|(1:146)|91|(1:145)|94|(1:144)|98|(1:143)|101|(1:142)|104|(1:106)|107|108|109|110|136)(1:153))(1:215)|154|155|156|157|158|159|160|161|162|163|(1:165)|166|(2:204|205)|168|(1:170)|171|(1:203)|175|(1:202)|178|(1:201)(1:180)|200|182|(1:198)|185|(1:197)|188|(2:193|194)|190|191|192|110|136))|235|(0)|37|38|39|40|(0)(0)|44|45|46|47|48|49|(0)(0)|52|(0)(0)|55|(0)(0)|58|(0)(0)|61|62|(0)(0)|(0)(0)|69|70|71|72|(0)(0)|154|155|156|157|158|159|160|161|162|163|(0)|166|(0)|168|(0)|171|(1:173)|203|175|(0)|202|178|(0)(0)|200|182|(0)|198|185|(0)|197|188|(0)|190|191|192|110|136)|20)|10|11) */
                /* JADX WARN: Can't wrap try/catch for region: R(52:(5:(2:32|(62:34|(1:36)|37|38|39|40|(2:42|43)(1:231)|44|45|46|47|48|49|(1:51)(1:226)|52|(1:54)(1:225)|55|(1:57)(1:224)|58|(1:60)(1:223)|61|62|(1:64)(1:222)|(3:66|67|68)(1:221)|69|70|71|72|(2:74|(26:76|(1:78)|79|(1:81)|82|83|84|85|86|87|(1:146)|91|(1:145)|94|(1:144)|98|(1:143)|101|(1:142)|104|(1:106)|107|108|109|110|136)(1:153))(1:215)|154|155|156|157|158|159|160|161|162|163|(1:165)|166|(2:204|205)|168|(1:170)|171|(1:203)|175|(1:202)|178|(1:201)(1:180)|200|182|(1:198)|185|(1:197)|188|(2:193|194)|190|191|192|110|136))|191|192|110|136)|48|49|(0)(0)|52|(0)(0)|55|(0)(0)|58|(0)(0)|61|62|(0)(0)|(0)(0)|69|70|71|72|(0)(0)|154|155|156|157|158|159|160|161|162|163|(0)|166|(0)|168|(0)|171|(1:173)|203|175|(0)|202|178|(0)(0)|200|182|(0)|198|185|(0)|197|188|(0)|190) */
                /* JADX WARN: Code restructure failed: missing block: B:181:0x02ef, code lost:
                
                    if (r4 > 0) goto L149;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:210:0x0344, code lost:
                
                    r4 = r11;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:212:0x0342, code lost:
                
                    r7 = r12;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:217:0x034b, code lost:
                
                    r36 = r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:265:0x0469, code lost:
                
                    r0 = th;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:266:0x046a, code lost:
                
                    r3 = r4;
                    r4 = r5;
                    r25 = r8;
                    r38 = r11;
                 */
                /* JADX WARN: Removed duplicated region for block: B:123:0x04a9 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:125:0x04aa  */
                /* JADX WARN: Removed duplicated region for block: B:165:0x02ab A[Catch: all -> 0x0344, TRY_LEAVE, TryCatch #2 {all -> 0x0344, blocks: (B:163:0x029d, B:165:0x02ab, B:170:0x02c5, B:171:0x02c7, B:175:0x02d7, B:178:0x02e3, B:202:0x02e1, B:203:0x02d5), top: B:162:0x029d }] */
                /* JADX WARN: Removed duplicated region for block: B:170:0x02c5 A[Catch: all -> 0x0344, TRY_ENTER, TryCatch #2 {all -> 0x0344, blocks: (B:163:0x029d, B:165:0x02ab, B:170:0x02c5, B:171:0x02c7, B:175:0x02d7, B:178:0x02e3, B:202:0x02e1, B:203:0x02d5), top: B:162:0x029d }] */
                /* JADX WARN: Removed duplicated region for block: B:180:0x02eb  */
                /* JADX WARN: Removed duplicated region for block: B:193:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:201:0x02f2  */
                /* JADX WARN: Removed duplicated region for block: B:204:0x02b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:215:0x0275  */
                /* JADX WARN: Removed duplicated region for block: B:221:0x01a0  */
                /* JADX WARN: Removed duplicated region for block: B:222:0x0193  */
                /* JADX WARN: Removed duplicated region for block: B:223:0x017e  */
                /* JADX WARN: Removed duplicated region for block: B:224:0x0168  */
                /* JADX WARN: Removed duplicated region for block: B:225:0x0158  */
                /* JADX WARN: Removed duplicated region for block: B:226:0x0148  */
                /* JADX WARN: Removed duplicated region for block: B:231:0x0122  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0105 A[Catch: all -> 0x037c, TryCatch #21 {all -> 0x037c, blocks: (B:16:0x009c, B:21:0x00be, B:23:0x00c5, B:24:0x00cb, B:26:0x00d2, B:27:0x00db, B:29:0x00e2, B:30:0x00eb, B:32:0x00f2, B:34:0x00fc, B:36:0x0105), top: B:15:0x009c }] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0119 A[Catch: all -> 0x0372, TRY_LEAVE, TryCatch #13 {all -> 0x0372, blocks: (B:40:0x010f, B:42:0x0119), top: B:39:0x010f }] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x0141 A[Catch: all -> 0x0355, TryCatch #15 {all -> 0x0355, blocks: (B:49:0x0133, B:51:0x0141, B:52:0x014b, B:54:0x0153, B:55:0x0159, B:57:0x0161, B:58:0x016b, B:60:0x0173, B:61:0x0182, B:64:0x018e), top: B:48:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:54:0x0153 A[Catch: all -> 0x0355, TryCatch #15 {all -> 0x0355, blocks: (B:49:0x0133, B:51:0x0141, B:52:0x014b, B:54:0x0153, B:55:0x0159, B:57:0x0161, B:58:0x016b, B:60:0x0173, B:61:0x0182, B:64:0x018e), top: B:48:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0161 A[Catch: all -> 0x0355, TryCatch #15 {all -> 0x0355, blocks: (B:49:0x0133, B:51:0x0141, B:52:0x014b, B:54:0x0153, B:55:0x0159, B:57:0x0161, B:58:0x016b, B:60:0x0173, B:61:0x0182, B:64:0x018e), top: B:48:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:60:0x0173 A[Catch: all -> 0x0355, TryCatch #15 {all -> 0x0355, blocks: (B:49:0x0133, B:51:0x0141, B:52:0x014b, B:54:0x0153, B:55:0x0159, B:57:0x0161, B:58:0x016b, B:60:0x0173, B:61:0x0182, B:64:0x018e), top: B:48:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:64:0x018e A[Catch: all -> 0x0355, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x0355, blocks: (B:49:0x0133, B:51:0x0141, B:52:0x014b, B:54:0x0153, B:55:0x0159, B:57:0x0161, B:58:0x016b, B:60:0x0173, B:61:0x0182, B:64:0x018e), top: B:48:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0197  */
                /* JADX WARN: Removed duplicated region for block: B:74:0x01b4 A[Catch: all -> 0x034b, TryCatch #9 {all -> 0x034b, blocks: (B:72:0x01ac, B:74:0x01b4, B:76:0x01be, B:78:0x01c7, B:79:0x01ce, B:81:0x01d6), top: B:71:0x01ac }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    SQLiteDatabase sQLiteDatabase;
                    ArrayList<BaseData> arrayList;
                    Cursor cursor;
                    Cursor cursor2;
                    long j;
                    Cursor cursor3;
                    SQLiteDatabase sQLiteDatabase2;
                    String str;
                    String str2;
                    String str3;
                    boolean z;
                    long j2;
                    JSONObject jSONObject;
                    String str4;
                    long j3;
                    String str5;
                    long j4;
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    long j5;
                    int i5;
                    String str6;
                    String str7;
                    ArrayList<BaseData> arrayList2;
                    int i6;
                    int i7;
                    Event event;
                    long j6;
                    long j7;
                    String str8 = "_event_v3";
                    String str9 = Api.KEY_AB_SDK_VERSION;
                    String str10 = "nt";
                    int i8 = 0;
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Start to do migrate events task...", new Object[0]);
                    SQLiteDatabase writableDatabase = new EmptyDbOpenHelper(AppLogInstance.this.getContext(), OldAppLogDataMigrator.oldAppLogDbName).getWritableDatabase();
                    ArrayList<BaseData> arrayList3 = new ArrayList<>();
                    try {
                        Cursor rawQuery = writableDatabase.rawQuery("select * from sqlite_master where name = 'event' and sql like '%disable_personalization%' limit 1", null);
                        try {
                            int i9 = 1;
                            boolean z2 = rawQuery.getCount() > 0;
                            AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Start to do migrate events with disable_personalization exists: {}...", Boolean.valueOf(z2));
                            writableDatabase.beginTransaction();
                            Cursor rawQuery2 = writableDatabase.rawQuery(OldAppLogDataMigrator.getQueryOldAppLogEventSql(z2), new String[]{String.valueOf(OldAppLogDataMigrator.queryEventMaxNum)});
                            j = 0;
                            while (rawQuery2.moveToNext()) {
                                try {
                                    long j8 = rawQuery2.getLong(i8);
                                    long max = Math.max(j8, j);
                                    IAppLogLogger logger = AppLogInstance.this.getLogger();
                                    List<String> list = OldAppLogDataMigrator.logTags;
                                    Object[] objArr = new Object[i9];
                                    objArr[0] = Long.valueOf(j8);
                                    logger.info(list, "Start to do migrate event:{}...", objArr);
                                    try {
                                        String string = rawQuery2.getString(i9);
                                        String string2 = rawQuery2.getString(2);
                                        if (TextUtils.isEmpty(string2)) {
                                            str = str8;
                                            str2 = str9;
                                            str3 = str10;
                                            sQLiteDatabase2 = writableDatabase;
                                            arrayList = arrayList3;
                                            cursor3 = rawQuery;
                                            z = z2;
                                            cursor2 = rawQuery2;
                                        } else {
                                            String string3 = !rawQuery2.isNull(3) ? rawQuery2.getString(3) : null;
                                            long j9 = !rawQuery2.isNull(4) ? rawQuery2.getLong(4) : 0L;
                                            long j10 = !rawQuery2.isNull(5) ? rawQuery2.getLong(5) : 0L;
                                            try {
                                                try {
                                                    try {
                                                        try {
                                                            if (!rawQuery2.isNull(6)) {
                                                                String string4 = rawQuery2.getString(6);
                                                                if (!TextUtils.isEmpty(string4)) {
                                                                    jSONObject = new JSONObject(string4);
                                                                    if (jSONObject == null) {
                                                                        jSONObject = new JSONObject();
                                                                    }
                                                                    cursor3 = rawQuery;
                                                                    jSONObject.put("_applog_old", 1);
                                                                    if (rawQuery2.isNull(7)) {
                                                                        sQLiteDatabase2 = writableDatabase;
                                                                        str4 = string3;
                                                                        j3 = rawQuery2.getLong(7);
                                                                    } else {
                                                                        sQLiteDatabase2 = writableDatabase;
                                                                        str4 = string3;
                                                                        j3 = 0;
                                                                    }
                                                                    long j11 = rawQuery2.getLong(8);
                                                                    ArrayList<BaseData> arrayList4 = arrayList3;
                                                                    long j12 = rawQuery2.getLong(9);
                                                                    str5 = str4;
                                                                    if (rawQuery2.isNull(10)) {
                                                                        i = rawQuery2.getInt(10);
                                                                        j4 = j3;
                                                                    } else {
                                                                        j4 = j3;
                                                                        i = 0;
                                                                    }
                                                                    int i10 = rawQuery2.isNull(11) ? rawQuery2.getInt(11) : 0;
                                                                    if (rawQuery2.isNull(12)) {
                                                                        i3 = rawQuery2.getInt(12);
                                                                        i2 = i10;
                                                                    } else {
                                                                        i2 = i10;
                                                                        i3 = 0;
                                                                    }
                                                                    if (rawQuery2.isNull(13)) {
                                                                        i4 = i3;
                                                                        j5 = rawQuery2.getLong(13);
                                                                    } else {
                                                                        i4 = i3;
                                                                        j5 = 0;
                                                                    }
                                                                    i5 = i;
                                                                    String str11 = "";
                                                                    String string5 = rawQuery2.isNull(14) ? rawQuery2.getString(14) : "";
                                                                    if (z2) {
                                                                        z = z2;
                                                                        str6 = "";
                                                                    } else {
                                                                        z = z2;
                                                                        try {
                                                                            str6 = rawQuery2.getString(15);
                                                                        } catch (Throwable unused) {
                                                                            str = str8;
                                                                            str2 = str9;
                                                                            cursor2 = rawQuery2;
                                                                            j2 = j8;
                                                                            arrayList = arrayList4;
                                                                            str3 = str10;
                                                                            try {
                                                                                AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                                                arrayList3 = arrayList;
                                                                                j = max;
                                                                                rawQuery = cursor3;
                                                                                writableDatabase = sQLiteDatabase2;
                                                                                str10 = str3;
                                                                                z2 = z;
                                                                                str8 = str;
                                                                                str9 = str2;
                                                                                rawQuery2 = cursor2;
                                                                                i8 = 0;
                                                                                i9 = 1;
                                                                            } catch (Throwable th) {
                                                                                th = th;
                                                                                cursor = cursor3;
                                                                                sQLiteDatabase = sQLiteDatabase2;
                                                                                try {
                                                                                    AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old events", th, new Object[0]);
                                                                                    Utils.endDbTransactionSafely(sQLiteDatabase);
                                                                                    Utils.closeSafely(cursor2);
                                                                                    Utils.closeSafely(cursor);
                                                                                    Utils.closeSafely(sQLiteDatabase);
                                                                                    if (arrayList.size() < OldAppLogDataMigrator.queryEventMaxNum) {
                                                                                    }
                                                                                } catch (Throwable th2) {
                                                                                    Utils.endDbTransactionSafely(sQLiteDatabase);
                                                                                    Utils.closeSafely(cursor2);
                                                                                    Utils.closeSafely(cursor);
                                                                                    Utils.closeSafely(sQLiteDatabase);
                                                                                    throw th2;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    int value = NetworkUtils.NetworkType.UNKNOWN.getValue();
                                                                    cursor2 = rawQuery2;
                                                                    if (Api.KEY_V3.equalsIgnoreCase(string)) {
                                                                        str = str8;
                                                                        str2 = str9;
                                                                        str7 = string;
                                                                    } else {
                                                                        str7 = string;
                                                                        if (jSONObject.optInt(str8, 0) == 1) {
                                                                            jSONObject.remove(str8);
                                                                            if (jSONObject.has(str10)) {
                                                                                value = jSONObject.optInt(str10);
                                                                                jSONObject.remove(str10);
                                                                            }
                                                                            int i11 = value;
                                                                            if (jSONObject.has(str9)) {
                                                                                str11 = jSONObject.optString(str9);
                                                                                jSONObject.remove(str9);
                                                                            }
                                                                            String str12 = str11;
                                                                            str = str8;
                                                                            try {
                                                                                str2 = str9;
                                                                            } catch (Throwable unused2) {
                                                                                str2 = str9;
                                                                                j2 = j8;
                                                                                arrayList = arrayList4;
                                                                                str3 = str10;
                                                                                AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                                                arrayList3 = arrayList;
                                                                                j = max;
                                                                                rawQuery = cursor3;
                                                                                writableDatabase = sQLiteDatabase2;
                                                                                str10 = str3;
                                                                                z2 = z;
                                                                                str8 = str;
                                                                                str9 = str2;
                                                                                rawQuery2 = cursor2;
                                                                                i8 = 0;
                                                                                i9 = 1;
                                                                            }
                                                                            try {
                                                                                EventV3 eventV3 = new EventV3(AppLogInstance.this.getAppId(), string2);
                                                                                eventV3.f79nt = i11;
                                                                                eventV3.setTs(j11);
                                                                                eventV3.abSdkVersion = str12;
                                                                                eventV3.eid = j12;
                                                                                eventV3.sid = string5;
                                                                                eventV3.disablePersonalization = str6;
                                                                                eventV3.setParams(jSONObject.toString());
                                                                                if (AppLogInstance.this.getEnableEventUserId() || j5 > 0) {
                                                                                    eventV3.uid = j5;
                                                                                }
                                                                                if (AppLogInstance.this.getEnableEventUserId() || i5 > 0) {
                                                                                    eventV3.userType = i5;
                                                                                }
                                                                                if (AppLogInstance.this.getEnableEventUserId() || j4 > 0) {
                                                                                    eventV3.user_id = j4;
                                                                                }
                                                                                if (AppLogInstance.this.getEnableEventUserId() || i4 > 0) {
                                                                                    eventV3.userIsAuth = i4;
                                                                                }
                                                                                if (AppLogInstance.this.getEnableEventUserId() || i2 > 0) {
                                                                                    eventV3.userIsLogin = i2;
                                                                                }
                                                                                if (!TextUtils.isEmpty(AppLogInstance.this.getUserUniqueID())) {
                                                                                    eventV3.uuid = AppLogInstance.this.getUserUniqueID();
                                                                                }
                                                                                arrayList2 = arrayList4;
                                                                                try {
                                                                                    arrayList2.add(eventV3);
                                                                                    str3 = str10;
                                                                                    arrayList = arrayList2;
                                                                                    j2 = j8;
                                                                                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Event:{} move step over.", Long.valueOf(j2));
                                                                                } catch (Throwable unused3) {
                                                                                    str3 = str10;
                                                                                    arrayList = arrayList2;
                                                                                    j2 = j8;
                                                                                    AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                                                    arrayList3 = arrayList;
                                                                                    j = max;
                                                                                    rawQuery = cursor3;
                                                                                    writableDatabase = sQLiteDatabase2;
                                                                                    str10 = str3;
                                                                                    z2 = z;
                                                                                    str8 = str;
                                                                                    str9 = str2;
                                                                                    rawQuery2 = cursor2;
                                                                                    i8 = 0;
                                                                                    i9 = 1;
                                                                                }
                                                                            } catch (Throwable unused4) {
                                                                                j2 = j8;
                                                                                arrayList = arrayList4;
                                                                                str3 = str10;
                                                                                AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                                                arrayList3 = arrayList;
                                                                                j = max;
                                                                                rawQuery = cursor3;
                                                                                writableDatabase = sQLiteDatabase2;
                                                                                str10 = str3;
                                                                                z2 = z;
                                                                                str8 = str;
                                                                                str9 = str2;
                                                                                rawQuery2 = cursor2;
                                                                                i8 = 0;
                                                                                i9 = 1;
                                                                            }
                                                                        } else {
                                                                            str = str8;
                                                                            str2 = str9;
                                                                        }
                                                                    }
                                                                    arrayList2 = arrayList4;
                                                                    long j13 = j4;
                                                                    i6 = i2;
                                                                    i7 = i4;
                                                                    str3 = str10;
                                                                    event = new Event(AppLogInstance.this.getAppId(), str7, string2);
                                                                    event.sid = string5;
                                                                    event.setTs(j11);
                                                                    j2 = j8;
                                                                    event.eid = j2;
                                                                    event.param = jSONObject.toString();
                                                                    if (!TextUtils.isEmpty(str5)) {
                                                                        event.label = str5;
                                                                    }
                                                                    j6 = j9;
                                                                    if (j6 != 0) {
                                                                        try {
                                                                            event.value = j6;
                                                                        } catch (Throwable unused5) {
                                                                            arrayList = arrayList2;
                                                                            AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                                            arrayList3 = arrayList;
                                                                            j = max;
                                                                            rawQuery = cursor3;
                                                                            writableDatabase = sQLiteDatabase2;
                                                                            str10 = str3;
                                                                            z2 = z;
                                                                            str8 = str;
                                                                            str9 = str2;
                                                                            rawQuery2 = cursor2;
                                                                            i8 = 0;
                                                                            i9 = 1;
                                                                        }
                                                                    }
                                                                    j7 = j10;
                                                                    if (j7 != 0) {
                                                                        event.extValue = j7;
                                                                    }
                                                                    if (!AppLogInstance.this.getEnableEventUserId() || j5 > 0) {
                                                                        event.uid = j5;
                                                                    }
                                                                    if (!AppLogInstance.this.getEnableEventUserId() || i5 > 0) {
                                                                        event.userType = i5;
                                                                    }
                                                                    if (AppLogInstance.this.getEnableEventUserId()) {
                                                                    }
                                                                    event.user_id = j13;
                                                                    if (!AppLogInstance.this.getEnableEventUserId() || i7 > 0) {
                                                                        event.userIsAuth = i7;
                                                                    }
                                                                    if (!AppLogInstance.this.getEnableEventUserId() || i6 > 0) {
                                                                        event.userIsLogin = i6;
                                                                    }
                                                                    if (!TextUtils.isEmpty(AppLogInstance.this.getUserUniqueID())) {
                                                                        try {
                                                                            event.uuid = AppLogInstance.this.getUserUniqueID();
                                                                        } catch (Throwable unused6) {
                                                                            arrayList = arrayList2;
                                                                            AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                                            arrayList3 = arrayList;
                                                                            j = max;
                                                                            rawQuery = cursor3;
                                                                            writableDatabase = sQLiteDatabase2;
                                                                            str10 = str3;
                                                                            z2 = z;
                                                                            str8 = str;
                                                                            str9 = str2;
                                                                            rawQuery2 = cursor2;
                                                                            i8 = 0;
                                                                            i9 = 1;
                                                                        }
                                                                    }
                                                                    arrayList = arrayList2;
                                                                    arrayList.add(event);
                                                                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Event:{} move step over.", Long.valueOf(j2));
                                                                }
                                                            }
                                                            arrayList.add(event);
                                                            AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Event:{} move step over.", Long.valueOf(j2));
                                                        } catch (Throwable unused7) {
                                                            AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                            arrayList3 = arrayList;
                                                            j = max;
                                                            rawQuery = cursor3;
                                                            writableDatabase = sQLiteDatabase2;
                                                            str10 = str3;
                                                            z2 = z;
                                                            str8 = str;
                                                            str9 = str2;
                                                            rawQuery2 = cursor2;
                                                            i8 = 0;
                                                            i9 = 1;
                                                        }
                                                        long j122 = rawQuery2.getLong(9);
                                                        str5 = str4;
                                                        if (rawQuery2.isNull(10)) {
                                                        }
                                                        if (rawQuery2.isNull(11)) {
                                                        }
                                                        if (rawQuery2.isNull(12)) {
                                                        }
                                                        if (rawQuery2.isNull(13)) {
                                                        }
                                                        i5 = i;
                                                        String str112 = "";
                                                        if (rawQuery2.isNull(14)) {
                                                        }
                                                        if (z2) {
                                                        }
                                                        int value2 = NetworkUtils.NetworkType.UNKNOWN.getValue();
                                                        cursor2 = rawQuery2;
                                                        if (Api.KEY_V3.equalsIgnoreCase(string)) {
                                                        }
                                                        arrayList2 = arrayList4;
                                                        long j132 = j4;
                                                        i6 = i2;
                                                        i7 = i4;
                                                        str3 = str10;
                                                        event = new Event(AppLogInstance.this.getAppId(), str7, string2);
                                                        event.sid = string5;
                                                        event.setTs(j11);
                                                        j2 = j8;
                                                        event.eid = j2;
                                                        event.param = jSONObject.toString();
                                                        if (!TextUtils.isEmpty(str5)) {
                                                        }
                                                        j6 = j9;
                                                        if (j6 != 0) {
                                                        }
                                                        j7 = j10;
                                                        if (j7 != 0) {
                                                        }
                                                        if (!AppLogInstance.this.getEnableEventUserId()) {
                                                        }
                                                        event.uid = j5;
                                                        if (!AppLogInstance.this.getEnableEventUserId()) {
                                                        }
                                                        event.userType = i5;
                                                        if (AppLogInstance.this.getEnableEventUserId()) {
                                                        }
                                                        event.user_id = j132;
                                                        if (!AppLogInstance.this.getEnableEventUserId()) {
                                                        }
                                                        event.userIsAuth = i7;
                                                        if (!AppLogInstance.this.getEnableEventUserId()) {
                                                        }
                                                        event.userIsLogin = i6;
                                                        if (!TextUtils.isEmpty(AppLogInstance.this.getUserUniqueID())) {
                                                        }
                                                        arrayList = arrayList2;
                                                    } catch (Throwable unused8) {
                                                        str = str8;
                                                        str2 = str9;
                                                        z = z2;
                                                    }
                                                    long j112 = rawQuery2.getLong(8);
                                                    ArrayList<BaseData> arrayList42 = arrayList3;
                                                } catch (Throwable unused9) {
                                                    str = str8;
                                                    str2 = str9;
                                                    str3 = str10;
                                                    arrayList = arrayList3;
                                                    z = z2;
                                                    cursor2 = rawQuery2;
                                                }
                                                jSONObject.put("_applog_old", 1);
                                                if (rawQuery2.isNull(7)) {
                                                }
                                            } catch (Throwable unused10) {
                                                str = str8;
                                                str2 = str9;
                                                str3 = str10;
                                                sQLiteDatabase2 = writableDatabase;
                                                arrayList = arrayList3;
                                                z = z2;
                                                cursor2 = rawQuery2;
                                                j2 = j8;
                                                AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot move event to bdtracker.", Long.valueOf(j2));
                                                arrayList3 = arrayList;
                                                j = max;
                                                rawQuery = cursor3;
                                                writableDatabase = sQLiteDatabase2;
                                                str10 = str3;
                                                z2 = z;
                                                str8 = str;
                                                str9 = str2;
                                                rawQuery2 = cursor2;
                                                i8 = 0;
                                                i9 = 1;
                                            }
                                            jSONObject = null;
                                            if (jSONObject == null) {
                                            }
                                            cursor3 = rawQuery;
                                        }
                                    } catch (Throwable unused11) {
                                        str = str8;
                                        str2 = str9;
                                        str3 = str10;
                                        sQLiteDatabase2 = writableDatabase;
                                        arrayList = arrayList3;
                                        cursor3 = rawQuery;
                                    }
                                    arrayList3 = arrayList;
                                    j = max;
                                    rawQuery = cursor3;
                                    writableDatabase = sQLiteDatabase2;
                                    str10 = str3;
                                    z2 = z;
                                    str8 = str;
                                    str9 = str2;
                                    rawQuery2 = cursor2;
                                    i8 = 0;
                                    i9 = 1;
                                } catch (Throwable th3) {
                                    th = th3;
                                    sQLiteDatabase2 = writableDatabase;
                                    arrayList = arrayList3;
                                    cursor3 = rawQuery;
                                    cursor2 = rawQuery2;
                                    cursor = cursor3;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old events", th, new Object[0]);
                                    Utils.endDbTransactionSafely(sQLiteDatabase);
                                    Utils.closeSafely(cursor2);
                                    Utils.closeSafely(cursor);
                                    Utils.closeSafely(sQLiteDatabase);
                                    if (arrayList.size() < OldAppLogDataMigrator.queryEventMaxNum) {
                                    }
                                }
                            }
                            sQLiteDatabase2 = writableDatabase;
                            arrayList = arrayList3;
                            cursor3 = rawQuery;
                            cursor2 = rawQuery2;
                            try {
                            } catch (Throwable th4) {
                                th = th4;
                                sQLiteDatabase = sQLiteDatabase2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            sQLiteDatabase = writableDatabase;
                            arrayList = arrayList3;
                            cursor = rawQuery;
                            cursor2 = null;
                            AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old events", th, new Object[0]);
                            Utils.endDbTransactionSafely(sQLiteDatabase);
                            Utils.closeSafely(cursor2);
                            Utils.closeSafely(cursor);
                            Utils.closeSafely(sQLiteDatabase);
                            if (arrayList.size() < OldAppLogDataMigrator.queryEventMaxNum) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        sQLiteDatabase = writableDatabase;
                        arrayList = arrayList3;
                        cursor = null;
                    }
                    if (arrayList.size() == 0) {
                        AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Not Found any event to move.", new Object[0]);
                        sQLiteDatabase2.setTransactionSuccessful();
                        Utils.endDbTransactionSafely(sQLiteDatabase2);
                        Utils.closeSafely(cursor2);
                        Utils.closeSafely(cursor3);
                        Utils.closeSafely(sQLiteDatabase2);
                        return;
                    }
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Found {} event to move...", Integer.valueOf(arrayList.size()));
                    dbStore.save(arrayList);
                    sQLiteDatabase = sQLiteDatabase2;
                    try {
                        int delete = sQLiteDatabase.delete("event", "_id <= ?", new String[]{String.valueOf(j)});
                        sQLiteDatabase.setTransactionSuccessful();
                        AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Move events to bdtracker completed with {} rows and {} events success.", Integer.valueOf(delete), Integer.valueOf(arrayList.size()));
                        Utils.endDbTransactionSafely(sQLiteDatabase);
                        Utils.closeSafely(cursor2);
                        Utils.closeSafely(cursor3);
                    } catch (Throwable th7) {
                        th = th7;
                        cursor = cursor3;
                        AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old events", th, new Object[0]);
                        Utils.endDbTransactionSafely(sQLiteDatabase);
                        Utils.closeSafely(cursor2);
                        Utils.closeSafely(cursor);
                        Utils.closeSafely(sQLiteDatabase);
                        if (arrayList.size() < OldAppLogDataMigrator.queryEventMaxNum) {
                        }
                    }
                    Utils.closeSafely(sQLiteDatabase);
                    if (arrayList.size() < OldAppLogDataMigrator.queryEventMaxNum) {
                        return;
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused12) {
                    }
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Retry migrate events...", new Object[0]);
                    OldAppLogDataMigrator.migrateEvents(AppLogInstance.this, dbStore);
                }
            });
        }
    }

    public static void migrateQueueLogs(final AppLogInstance appLogInstance, final DbStore dbStore) {
        if (enableMigrateLog && appLogInstance.isMigrateOldAppLogDataEnabled()) {
            appLogInstance.getLogger().info(logTags, "Start to migrate packed logs data...", new Object[0]);
            AppLogExecutors.getSingleExecutor().submit(new Runnable() { // from class: com.bytedance.applog.adaptor.OldAppLogDataMigrator.3
                /* JADX WARN: Removed duplicated region for block: B:53:0x016a  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x017c  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i;
                    Cursor cursor;
                    Cursor cursor2;
                    int i2;
                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Start to do migrate packed logs data task...", new Object[0]);
                    SQLiteDatabase writableDatabase = new EmptyDbOpenHelper(AppLogInstance.this.getContext(), OldAppLogDataMigrator.oldAppLogDbName).getWritableDatabase();
                    try {
                        Cursor rawQuery = writableDatabase.rawQuery(OldAppLogDataMigrator.queryOldAppLogLogIdsSql, null);
                        try {
                            i = rawQuery.getCount();
                            while (rawQuery.moveToNext()) {
                                try {
                                    long j = rawQuery.getLong(0);
                                    AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "start to move queue:{} from old...", Long.valueOf(j));
                                    try {
                                        i2 = 1;
                                        try {
                                            cursor2 = writableDatabase.query("queue", new String[]{"value", "timestamp"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null);
                                            try {
                                                if (cursor2.moveToFirst()) {
                                                    try {
                                                        String string = cursor2.getString(0);
                                                        if (!TextUtils.isEmpty(string)) {
                                                            AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Pack from queue:{} saved with result: {}", Long.valueOf(j), Long.valueOf(dbStore.fastInsertPack(Pack.fromMigrateValue(AppLogInstance.this.getAppId(), AppLogInstance.this.getHeader(), cursor2.getLong(1), new JSONObject(string)))));
                                                            AppLogInstance.this.getLogger().info(OldAppLogDataMigrator.logTags, "Old queue:{} deleted:{}.", Long.valueOf(j), Integer.valueOf(writableDatabase.delete("queue", "_id = ?", new String[]{String.valueOf(j)})));
                                                            try {
                                                                Thread.sleep(600L);
                                                            } catch (InterruptedException unused) {
                                                            }
                                                        }
                                                    } catch (Throwable th) {
                                                        AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot query queue:{} from old", th, Long.valueOf(j));
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                try {
                                                    IAppLogLogger logger = AppLogInstance.this.getLogger();
                                                    List<String> list = OldAppLogDataMigrator.logTags;
                                                    Object[] objArr = new Object[i2];
                                                    objArr[0] = Long.valueOf(j);
                                                    logger.error(list, "Cannot move pack:{} to bdtracker.", th, objArr);
                                                } finally {
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            cursor2 = null;
                                            IAppLogLogger logger2 = AppLogInstance.this.getLogger();
                                            List<String> list2 = OldAppLogDataMigrator.logTags;
                                            Object[] objArr2 = new Object[i2];
                                            objArr2[0] = Long.valueOf(j);
                                            logger2.error(list2, "Cannot move pack:{} to bdtracker.", th, objArr2);
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        i2 = 1;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    cursor = rawQuery;
                                    try {
                                        AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "Cannot migrate old applog log data", th, new Object[0]);
                                        Utils.closeSafely(writableDatabase);
                                        if (i >= OldAppLogDataMigrator.maxQueryLogQueueNum) {
                                        }
                                    } catch (Throwable th6) {
                                        Utils.closeSafely(cursor2);
                                        Utils.closeSafely(writableDatabase);
                                        throw th6;
                                    }
                                }
                            }
                            Utils.closeSafely(rawQuery);
                        } catch (Throwable th7) {
                            th = th7;
                            i = 0;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        i = 0;
                        cursor = null;
                    }
                    Utils.closeSafely(writableDatabase);
                    if (i >= OldAppLogDataMigrator.maxQueryLogQueueNum) {
                        AppLogInstance.this.getLogger().error(OldAppLogDataMigrator.logTags, "no any log in old applog queue", new Object[0]);
                    } else {
                        try {
                            Thread.sleep(SlardarConfigConsts.FETCH_SETTING_INTERVAL_SECONDS);
                        } catch (InterruptedException unused2) {
                        }
                        OldAppLogDataMigrator.migrateQueueLogs(AppLogInstance.this, dbStore);
                    }
                }
            });
        }
    }
}
