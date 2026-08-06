package com.bytedance.sdk.account.save.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.entity.ExtHelper;
import com.bytedance.sdk.account.save.entity.LoginInfo;
import com.bytedance.sdk.account.save.entity.LoginType;
import com.ss.android.account.TTAccountInit;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DBService {
    public static final int COLUMN_TYPE_ALL = 0;
    public static final int COLUMN_TYPE_INFO = 3;
    public static final int COLUMN_TYPE_LATEST_ACCOUNTS = 5;
    public static final int COLUMN_TYPE_TIME = 1;
    public static final int COLUMN_TYPE_TYPE = 2;
    public static final int COLUMN_TYPE_UID = 4;
    public static final int DATA_TYPE_LATEST = 1;
    public static final int DATA_TYPE_MASK = 4;
    public static final int DATA_TYPE_OLDEST = 2;
    public static final int DATA_TYPE_SAME = 3;
    public static final int DELETE_TYPE_BY_INFO = 5;
    public static final int DELETE_TYPE_BY_TIME = 3;
    public static final int DELETE_TYPE_BY_TYPE = 4;
    public static final int DELETE_TYPE_LATEST = 1;
    public static final int DELETE_TYPE_OLDEST = 2;

    /* renamed from: db */
    private SQLiteDatabase f15db;
    private DBHelper dbHelper;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class InstanceHelper {
        static final DBService INSTANCE = new DBService();

        private InstanceHelper() {
        }
    }

    private DBService() {
        this.dbHelper = new DBHelper(TTAccountInit.getConfig().getApplicationContext());
        this.f15db = null;
    }

    public static DBService getInstance() {
        return InstanceHelper.INSTANCE;
    }

    public boolean checkOpenDB() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f15db;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return true;
            }
            DBHelper dBHelper = this.dbHelper;
            if (dBHelper == null) {
                return false;
            }
            this.f15db = dBHelper.getWritableDatabase();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeBD() {
        try {
            try {
                SQLiteDatabase sQLiteDatabase = this.f15db;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    this.f15db.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.f15db = null;
        }
    }

    public void beginTransaction() {
        try {
            if (checkOpenDB()) {
                this.f15db.beginTransaction();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endTransaction() {
        try {
            if (checkOpenDB() && this.f15db.inTransaction()) {
                this.f15db.endTransaction();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTransactionSuccessful() {
        try {
            if (checkOpenDB() && this.f15db.inTransaction()) {
                this.f15db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runTransaction(Task task) {
        try {
            try {
                beginTransaction();
                task.onRunning();
                setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            endTransaction();
            task.onCompleted();
        }
    }

    public boolean insert(LoginInfo loginInfo) {
        if (!checkOpenDB() || !LoginType.isInLoginType(loginInfo.getType()) || loginInfo.getInfo() == null || loginInfo.getInfo().length() == 0 || loginInfo.getUid() <= 0 || TextUtils.isEmpty(loginInfo.getScreenName())) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBData.FIELD_TIME, Long.valueOf(loginInfo.getTime()));
        contentValues.put(DBData.FIELD_TYPE, Integer.valueOf(loginInfo.getType()));
        contentValues.put("info", loginInfo.getInfo());
        contentValues.put("uid", Long.valueOf(loginInfo.getUid()));
        contentValues.put("avatar_url", loginInfo.getAvatarUrl());
        contentValues.put(DBData.FIELD_SCREEN_NAME, loginInfo.getScreenName());
        contentValues.put(DBData.FIELD_PLATFORM_AVATAR_URL, loginInfo.getPlatformAvatarUrl());
        contentValues.put(DBData.FIELD_PLATFORM_SCREEN_NAME, loginInfo.getPlatformScreenName());
        contentValues.put(DBData.FIELD_SEC_UID, loginInfo.getSecUid());
        contentValues.put(DBData.FIELD_EXT, ExtHelper.encode(loginInfo.getExt()));
        return this.f15db.insert(DBData.TABLE_NAME, null, contentValues) != -1;
    }

    public boolean replace(LoginInfo loginInfo) {
        if (!checkOpenDB() || !LoginType.isInLoginType(loginInfo.getType()) || loginInfo.getInfo() == null || loginInfo.getInfo().length() == 0 || loginInfo.getUid() <= 0 || TextUtils.isEmpty(loginInfo.getScreenName())) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBData.FIELD_TIME, Long.valueOf(loginInfo.getTime()));
        contentValues.put(DBData.FIELD_TYPE, Integer.valueOf(loginInfo.getType()));
        contentValues.put("info", loginInfo.getInfo());
        contentValues.put("uid", Long.valueOf(loginInfo.getUid()));
        contentValues.put("avatar_url", loginInfo.getAvatarUrl());
        contentValues.put(DBData.FIELD_SCREEN_NAME, loginInfo.getScreenName());
        contentValues.put(DBData.FIELD_PLATFORM_AVATAR_URL, loginInfo.getPlatformAvatarUrl());
        contentValues.put(DBData.FIELD_PLATFORM_SCREEN_NAME, loginInfo.getPlatformScreenName());
        contentValues.put(DBData.FIELD_SEC_UID, loginInfo.getSecUid());
        contentValues.put(DBData.FIELD_EXT, ExtHelper.encode(loginInfo.getExt()));
        return this.f15db.replace(DBData.TABLE_NAME, null, contentValues) != -1;
    }

    public boolean delete(int i, Object obj) {
        if (!checkOpenDB()) {
            return false;
        }
        if (i == 1) {
            return deleteLatest();
        }
        if (i == 2) {
            return deleteOldest();
        }
        if (i == 3) {
            if (obj == null) {
                return false;
            }
            return deleteByTime(((Long) obj).longValue());
        }
        if (i == 4) {
            if (obj == null) {
                return false;
            }
            return deleteByType(((Integer) obj).intValue());
        }
        if (i == 5 && obj != null) {
            return deleteByInfo((String) obj);
        }
        return false;
    }

    public boolean deleteByTime(long j) {
        return checkOpenDB() && this.f15db.delete(DBData.TABLE_NAME, "time = ?", new String[]{String.valueOf(j)}) != 0;
    }

    public boolean deleteByType(int i) {
        return checkOpenDB() && this.f15db.delete(DBData.TABLE_NAME, "type = ?", new String[]{String.valueOf(i)}) != 0;
    }

    public boolean deleteByInfo(String str) {
        return (!checkOpenDB() || str == null || this.f15db.delete(DBData.TABLE_NAME, "info = ?", new String[]{str}) == 0) ? false : true;
    }

    public boolean deleteOldest() {
        return checkOpenDB() && this.f15db.delete(DBData.TABLE_NAME, "time in (select min(time) from login_info)", null) != 0;
    }

    public boolean deleteLatest() {
        return checkOpenDB() && this.f15db.delete(DBData.TABLE_NAME, "time in (select max(time) from login_info)", null) != 0;
    }

    public boolean update(LoginInfo loginInfo) {
        if (!checkOpenDB() || !LoginType.isInLoginType(loginInfo.getType()) || loginInfo.getInfo() == null || loginInfo.getInfo().length() == 0 || loginInfo.getUid() <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        if (loginInfo.getTime() > 0) {
            contentValues.put(DBData.FIELD_TIME, Long.valueOf(loginInfo.getTime()));
        }
        if (LoginType.isInLoginType(loginInfo.getType())) {
            contentValues.put(DBData.FIELD_TYPE, Integer.valueOf(loginInfo.getType()));
        }
        if (!TextUtils.isEmpty(loginInfo.getInfo())) {
            contentValues.put("info", loginInfo.getInfo());
        }
        if (loginInfo.getUid() > 0) {
            contentValues.put("uid", Long.valueOf(loginInfo.getUid()));
        }
        if (!TextUtils.isEmpty(loginInfo.getAvatarUrl())) {
            contentValues.put("avatar_url", loginInfo.getAvatarUrl());
        }
        if (!TextUtils.isEmpty(loginInfo.getScreenName())) {
            contentValues.put(DBData.FIELD_SCREEN_NAME, loginInfo.getScreenName());
        }
        if (!TextUtils.isEmpty(loginInfo.getPlatformAvatarUrl())) {
            contentValues.put(DBData.FIELD_PLATFORM_AVATAR_URL, loginInfo.getPlatformAvatarUrl());
        }
        if (!TextUtils.isEmpty(loginInfo.getPlatformScreenName())) {
            contentValues.put(DBData.FIELD_PLATFORM_SCREEN_NAME, loginInfo.getPlatformScreenName());
        }
        if (!TextUtils.isEmpty(loginInfo.getSecUid())) {
            contentValues.put(DBData.FIELD_SEC_UID, loginInfo.getSecUid());
        }
        String encode = ExtHelper.encode(loginInfo.getExt());
        if (!TextUtils.isEmpty(encode)) {
            contentValues.put(DBData.FIELD_EXT, encode);
        }
        return this.f15db.update(DBData.TABLE_NAME, contentValues, "type = ? and info = ? and uid = ?", new String[]{String.valueOf(loginInfo.getType()), loginInfo.getInfo(), String.valueOf(loginInfo.getUid())}) != 0;
    }

    public boolean updateSecUid(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !checkOpenDB()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBData.FIELD_SEC_UID, str2);
        return this.f15db.update(DBData.TABLE_NAME, contentValues, "uid = ?", new String[]{str}) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x020b, code lost:
    
        if (r4 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x020d, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0217, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0214, code lost:
    
        if (r4 == null) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LoginInfo queryData(int i, Long l, Integer num, String str, Long l2) {
        LoginInfo loginInfo;
        Cursor query;
        Cursor cursor;
        Cursor cursor2 = null;
        if (!checkOpenDB()) {
            return null;
        }
        String[] strArr = {DBData.FIELD_TIME, DBData.FIELD_TYPE, "info", "uid", "avatar_url", DBData.FIELD_SCREEN_NAME, DBData.FIELD_PLATFORM_AVATAR_URL, DBData.FIELD_PLATFORM_SCREEN_NAME, DBData.FIELD_SEC_UID, DBData.FIELD_EXT};
        StringBuilder sb = new StringBuilder();
        try {
            try {
                if (i == 1) {
                    sb.append(DBData.FIELD_TIME).append(" in (select max(").append(DBData.FIELD_TIME).append(") from ").append(DBData.TABLE_NAME).append(")");
                    query = this.f15db.query(DBData.TABLE_NAME, strArr, sb.toString(), null, null, null, null);
                } else if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            ArrayList arrayList = new ArrayList();
                            if (l != null) {
                                appendField(sb, DBData.FIELD_TIME);
                                arrayList.add(String.valueOf(l));
                            }
                            if (num != null) {
                                appendField(sb, DBData.FIELD_TYPE);
                                arrayList.add(String.valueOf(num));
                            }
                            if (l2 != null && l2.longValue() > 0) {
                                appendField(sb, "uid");
                                arrayList.add(String.valueOf(l2));
                            }
                            if (str != null && str.length() != 0) {
                                String[] split = str.split("\\*");
                                StringBuilder sb2 = new StringBuilder();
                                if (split.length != 0) {
                                    for (String str2 : split) {
                                        sb2.append("%");
                                        sb2.append(str2);
                                    }
                                    sb2.append("%");
                                    if (sb.length() > 0) {
                                        sb.append(" and ");
                                    }
                                    sb.append("info").append(" like ? ");
                                    arrayList.add(sb2.toString());
                                }
                            }
                            query = this.f15db.query(DBData.TABLE_NAME, strArr, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, "time desc", "0,1");
                        }
                        cursor = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        if (l != null) {
                            appendField(sb, DBData.FIELD_TIME);
                            arrayList2.add(String.valueOf(l));
                        }
                        if (num != null) {
                            appendField(sb, DBData.FIELD_TYPE);
                            arrayList2.add(String.valueOf(num));
                        }
                        if (str != null && str.length() != 0) {
                            appendField(sb, "info");
                            arrayList2.add(str);
                        }
                        if (l2 != null && l2.longValue() > 0) {
                            appendField(sb, "uid");
                            arrayList2.add(String.valueOf(l2));
                        }
                        if (sb.length() != 0) {
                            query = this.f15db.query(DBData.TABLE_NAME, strArr, sb.toString(), (String[]) arrayList2.toArray(new String[0]), null, null, "time desc", "0,1");
                        }
                        cursor = null;
                    }
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    loginInfo = new LoginInfo(cursor.getLong(0), cursor.getInt(1), cursor.getString(2), cursor.getLong(3), cursor.getString(8), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), ExtHelper.decode(cursor.getString(9)));
                                    try {
                                        cursor.close();
                                    } catch (Exception e) {
                                        e = e;
                                        cursor2 = cursor;
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            loginInfo = null;
                        }
                    }
                    loginInfo = null;
                    cursor2 = cursor;
                } else {
                    sb.append(DBData.FIELD_TIME).append(" in (select min(").append(DBData.FIELD_TIME).append(") from ").append(DBData.TABLE_NAME).append(")");
                    query = this.f15db.query(DBData.TABLE_NAME, strArr, sb.toString(), null, null, null, null);
                }
                cursor = query;
                if (cursor != null) {
                }
                loginInfo = null;
                cursor2 = cursor;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            loginInfo = null;
        }
    }

    private void appendField(StringBuilder sb, String str) {
        if (sb == null) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(" and ");
        }
        sb.append(str).append(" = ?");
    }

    public LoginInfo queryLatest() {
        return queryData(1, null, null, null, null);
    }

    public LoginInfo queryOldest() {
        return queryData(2, null, null, null, null);
    }

    public LoginInfo querySame(int i, String str) {
        return queryData(3, null, Integer.valueOf(i), str, null);
    }

    public LoginInfo querySame(int i, String str, long j) {
        return queryData(3, null, Integer.valueOf(i), str, Long.valueOf(j));
    }

    public LoginInfo queryMask(int i, String str) {
        return queryData(4, null, Integer.valueOf(i), str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cc, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ce, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00de, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<LoginInfo> queryDatas(int i, Object obj) {
        Cursor rawQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        if (!checkOpenDB()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] strArr = {String.valueOf(obj)};
        try {
            try {
                if (i == 0) {
                    rawQuery = this.f15db.rawQuery("select * from login_info", null);
                } else if (i == 1) {
                    if (obj != null) {
                        rawQuery = this.f15db.rawQuery("select * from login_info where time=?", strArr);
                    }
                    cursor = null;
                    if (cursor == null) {
                    }
                } else if (i == 2) {
                    if (obj != null) {
                        rawQuery = this.f15db.rawQuery("select * from login_info where type=?", strArr);
                    }
                    cursor = null;
                    if (cursor == null) {
                    }
                } else if (i == 3) {
                    if (obj != null) {
                        rawQuery = this.f15db.rawQuery("select * from login_info where info=?", strArr);
                    }
                    cursor = null;
                    if (cursor == null) {
                    }
                } else if (i != 4) {
                    if (i == 5) {
                        rawQuery = this.f15db.rawQuery("select * from login_info where time in (select max(time) from login_info group by uid)order by time desc", null);
                    }
                    cursor = null;
                    if (cursor == null) {
                        try {
                            int count = cursor.getCount();
                            if (count > 0) {
                                for (int i2 = 0; i2 < count; i2++) {
                                    cursor.moveToPosition(i2);
                                    arrayList.add(new LoginInfo(cursor.getLong(0), cursor.getInt(1), cursor.getString(2), cursor.getLong(3), cursor.getString(8), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), ExtHelper.decode(cursor.getString(9))));
                                }
                            }
                            cursor.close();
                        } catch (Exception e) {
                            e = e;
                            cursor2 = cursor;
                            AccountMonitorUtil.commonExceptionEvent(e);
                            e.printStackTrace();
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } else {
                        cursor2 = cursor;
                    }
                } else {
                    if (obj != null) {
                        rawQuery = this.f15db.rawQuery("select * from login_info where uid=?", strArr);
                    }
                    cursor = null;
                    if (cursor == null) {
                    }
                }
                cursor = rawQuery;
                if (cursor == null) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public List<LoginInfo> queryByType(int i) {
        return queryDatas(2, Integer.valueOf(i));
    }

    public List<LoginInfo> queryByTime(long j) {
        return queryDatas(1, Long.valueOf(j));
    }

    public List<LoginInfo> queryByInfo(String str) {
        return queryDatas(3, str);
    }

    public List<LoginInfo> queryByUid(long j) {
        return queryDatas(4, Long.valueOf(j));
    }

    public List<LoginInfo> queryLatestAccounts() {
        return queryDatas(5, null);
    }

    public List<LoginInfo> queryAll() {
        return queryDatas(0, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int queryCount() {
        Exception e;
        Cursor cursor;
        if (!checkOpenDB()) {
            return -1;
        }
        Cursor cursor2 = null;
        try {
            cursor = this.f15db.rawQuery("select count(*) from login_info", null);
            if (cursor != null) {
                try {
                    try {
                        cursor.moveToFirst();
                        r1 = cursor.getCount() > 0 ? cursor.getInt(0) : 0;
                        cursor.close();
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return r1;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else {
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        return r1;
    }
}
