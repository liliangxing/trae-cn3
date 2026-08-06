package com.bytedance.apm.battery.dao;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.util.ListUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseDao<T> {
    protected static final int SINGLE_BATCH_SIZE = 50;
    private final String mAuthority;
    private final HashMap<String, Integer> mColumnIndex = new HashMap<>();
    private final Context mContext;
    private String mSqlGetTotalCountClause;
    private Uri mUri;

    /* loaded from: classes3.dex */
    public interface CursorGetter<T> {
        T get(CursorWrapper cursorWrapper);
    }

    public abstract String[] getColumns();

    public abstract ContentValues getContentValues(T t);

    public String getDbName() {
        return DBHelper.DB_NAME;
    }

    public abstract String getTableName();

    public boolean isWeedTakenOver() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseDao() {
        Context context = ApmContext.getContext();
        this.mContext = context;
        this.mAuthority = context.getPackageName() + ".apm";
    }

    protected String getDbPath() {
        return ApmContext.getContext().getDatabasePath(getDbName()).getAbsolutePath();
    }

    public Uri getUri() {
        if (this.mUri == null) {
            this.mUri = Uri.parse("content://" + this.mAuthority + "/" + getDbName() + "/" + getTableName());
        }
        return this.mUri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> query(String str, String[] strArr, String str2, CursorGetter<T> cursorGetter) {
        int i;
        int indexOf;
        Cursor cursor = null;
        Object[] objArr = 0;
        try {
            Cursor query = this.mContext.getContentResolver().query(getUri(), getColumns(), str, strArr, str2);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (TextUtils.isEmpty(str2) || (indexOf = str2.indexOf("LIMIT")) <= 0) {
                            i = Integer.MAX_VALUE;
                        } else {
                            int indexOf2 = str2.indexOf("OFF");
                            if (indexOf2 > 0) {
                                i = Integer.valueOf(str2.substring(indexOf + 5, indexOf2).trim()).intValue();
                            } else {
                                i = Integer.valueOf(str2.substring(indexOf + 5).trim()).intValue();
                            }
                        }
                        LinkedList linkedList = new LinkedList();
                        for (int i2 = 0; query.moveToNext() && i2 < i; i2++) {
                            linkedList.add(cursorGetter.get(new CursorWrapper(query, this.mColumnIndex)));
                        }
                        safeCloseCursor(query);
                        return linkedList;
                    }
                } catch (Throwable unused) {
                    cursor = query;
                    safeCloseCursor(cursor);
                    return Collections.emptyList();
                }
            }
            List<T> emptyList = Collections.emptyList();
            safeCloseCursor(query);
            return emptyList;
        } catch (Throwable unused2) {
        }
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return -1;
        }
        try {
            return ApmContext.getContext().getContentResolver().update(getUri(), contentValues, str, strArr);
        } catch (Exception unused) {
            return -1;
        }
    }

    public synchronized <I extends T> long insert(ContentValues contentValues) {
        if (contentValues == null) {
            return -1L;
        }
        try {
            Uri insert = ApmContext.getContext().getContentResolver().insert(getUri(), contentValues);
            if (insert == null) {
                return -1L;
            }
            try {
                return Long.parseLong(insert.getLastPathSegment());
            } catch (Exception unused) {
                return 1L;
            }
        } catch (Exception unused2) {
            return -1L;
        }
    }

    public synchronized void insertBatch(List<ContentValues> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>(8);
            for (int i2 = 0; i2 < 50 && i < size; i2++) {
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(getUri());
                newInsert.withValues(list.get(i));
                arrayList.add(newInsert.build());
                i++;
            }
            try {
                ContentProviderResult[] applyBatch = ApmContext.getContext().getContentResolver().applyBatch(this.mAuthority, arrayList);
                if (ApmContext.isDebugMode()) {
                    for (ContentProviderResult contentProviderResult : applyBatch) {
                        Logger.i(DebugLogger.TAG_STORE, "insertBatch ret: ", contentProviderResult.uri.toString());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int delete(String str, String[] strArr) {
        try {
            return this.mContext.getContentResolver().delete(getUri(), str, strArr);
        } catch (Exception unused) {
            return -1;
        }
    }

    public long getTotalRowCount() {
        return getCount(null, null);
    }

    private String getSqlTotalCountClause() {
        if (this.mSqlGetTotalCountClause == null) {
            this.mSqlGetTotalCountClause = "SELECT count(*) FROM " + getTableName();
        }
        return this.mSqlGetTotalCountClause;
    }

    public long getCount(String str, String[] strArr) {
        long j = -1;
        Cursor cursor = null;
        try {
            cursor = MonitorContentProvider.rawQueryForResolver(ApmContext.getContext(), getUri(), str == null ? getSqlTotalCountClause() : getSqlTotalCountClause() + " where " + str, strArr);
            if (cursor != null && cursor.moveToNext()) {
                j = cursor.getLong(0);
            }
            return j;
        } catch (Exception unused) {
            return -1L;
        } finally {
            safeCloseCursor(cursor);
        }
    }

    public void execSql(String str) {
        MonitorContentProvider.execSQLForResolver(this.mContext, getUri(), str);
    }

    private static void safeCloseCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class CursorWrapper {
        private final HashMap<String, Integer> mColumnIndex;
        Cursor mCursor;

        private CursorWrapper(Cursor cursor, HashMap<String, Integer> hashMap) {
            this.mCursor = cursor;
            this.mColumnIndex = hashMap;
        }

        public long getLong(String str) {
            try {
                return this.mCursor.getLong(getIndex(str));
            } catch (Throwable unused) {
                return -1L;
            }
        }

        public int getInt(String str) {
            try {
                return this.mCursor.getInt(getIndex(str));
            } catch (Throwable unused) {
                return -1;
            }
        }

        public String getString(String str) {
            try {
                return this.mCursor.getString(getIndex(str));
            } catch (Throwable unused) {
                return "";
            }
        }

        public double getDouble(String str) {
            try {
                return this.mCursor.getDouble(getIndex(str));
            } catch (Throwable unused) {
                return -1.0d;
            }
        }

        public float getFloat(String str) {
            try {
                return this.mCursor.getFloat(getIndex(str));
            } catch (Throwable unused) {
                return -1.0f;
            }
        }

        public short getShort(String str) {
            try {
                return this.mCursor.getShort(getIndex(str));
            } catch (Throwable unused) {
                return (short) -1;
            }
        }

        public byte[] getBlob(String str) {
            try {
                return this.mCursor.getBlob(getIndex(str));
            } catch (Throwable unused) {
                return new byte[0];
            }
        }

        private int getIndex(String str) {
            Integer num = this.mColumnIndex.get(str);
            if (num == null) {
                try {
                    num = Integer.valueOf(this.mCursor.getColumnIndex(str));
                } catch (Throwable unused) {
                    num = -1;
                }
                this.mColumnIndex.put(str, num);
            }
            return num.intValue();
        }
    }
}
