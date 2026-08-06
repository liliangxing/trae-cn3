package com.bytedance.apm.battery.dao;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.core.SpPair;
import com.bytedance.apm.util.ListUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class MonitorContentProvider extends ContentProvider {
    public static String AUTHORITY;
    private final Map<String, SQLiteOpenHelper> mDBHelpers = new HashMap();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    private synchronized Pair<SQLiteDatabase, String> parseUri(Uri uri) {
        try {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && pathSegments.size() >= 2) {
                String str = pathSegments.get(0);
                String str2 = pathSegments.get(1);
                if (str == null) {
                    return null;
                }
                SQLiteOpenHelper sQLiteOpenHelper = this.mDBHelpers.get(str);
                if (sQLiteOpenHelper == null) {
                    if (!str.contains(DBHelper.DB_NAME)) {
                        return null;
                    }
                    sQLiteOpenHelper = new DBHelper(getContext(), str);
                    this.mDBHelpers.put(str, sQLiteOpenHelper);
                }
                return new Pair<>(sQLiteOpenHelper.getWritableDatabase(), str2);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private synchronized Pair<SharedPreferences, String> parseMethod(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() < 2 || !CloudControlInf.SP.equals(pathSegments.get(0))) {
            return null;
        }
        return new Pair<>(getContext().getSharedPreferences(pathSegments.get(1), 0), pathSegments.size() > 2 ? pathSegments.get(2) : null);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        AUTHORITY = getContext().getPackageName() + ".apm";
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> parseUri = parseUri(uri);
        if (parseUri == null || (sQLiteDatabase = (SQLiteDatabase) parseUri.first) == null) {
            return null;
        }
        if (TextUtils.equals(str2, "rawQuery")) {
            return sQLiteDatabase.rawQuery(str, strArr2);
        }
        if (TextUtils.equals(str2, "execSQL")) {
            String[] split = str.split(";");
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    sQLiteDatabase.execSQL(str3);
                }
            }
            return null;
        }
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables((String) parseUri.second);
        return sQLiteQueryBuilder.query(sQLiteDatabase, strArr, str, strArr2, null, null, str2);
    }

    private Bundle querySP(SharedPreferences sharedPreferences, String str, Object obj) {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (str == null) {
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                arrayList.add(new SpPair(entry.getKey(), entry.getValue()));
            }
            bundle.putParcelableArrayList(CloudControlInf.SP, arrayList);
        } else {
            Object obj2 = sharedPreferences.getAll().get(str);
            if (obj2 != null) {
                obj = obj2;
            }
            if (obj instanceof Set) {
                obj = ListUtils.toArray((Set) obj);
            }
            arrayList.add(new SpPair(str, obj));
            bundle.putParcelableArrayList(CloudControlInf.SP, arrayList);
        }
        return bundle;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        SpPair spPair;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        if ("getPid".equals(str)) {
            return getPID();
        }
        Uri.parse(str);
        Pair<SharedPreferences, String> parseMethod = parseMethod(Uri.parse(str));
        Object obj = null;
        if (parseMethod == null) {
            return null;
        }
        if ("query".equals(str2)) {
            if (bundle != null && (spPair = (SpPair) bundle.getParcelable(CloudControlInf.SP)) != null) {
                obj = spPair.mValue;
            }
            return querySP((SharedPreferences) parseMethod.first, (String) parseMethod.second, obj);
        }
        if ("contains".equals(str2)) {
            return containsSP((SharedPreferences) parseMethod.first, (String) parseMethod.second);
        }
        if ("edit".equals(str2) && bundle != null) {
            editSP((SharedPreferences) parseMethod.first, bundle);
        }
        return null;
    }

    private Bundle containsSP(SharedPreferences sharedPreferences, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("contains", sharedPreferences.contains(str));
        return bundle;
    }

    private Bundle getPID() {
        Bundle bundle = new Bundle();
        bundle.putInt("Pid", Process.myPid());
        return bundle;
    }

    private void editSP(SharedPreferences sharedPreferences, Bundle bundle) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bundle.getBoolean("clear")) {
            edit.clear();
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("edit");
        if (parcelableArrayList == null) {
            return;
        }
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            SpPair spPair = (SpPair) it.next();
            if (spPair.mValue == null) {
                edit.remove(spPair.mKey);
            } else {
                edit(edit, spPair.mKey, spPair.mValue);
            }
        }
        edit.apply();
    }

    private static void edit(SharedPreferences.Editor editor, String str, Object obj) {
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String[]) {
            editor.putStringSet(str, new HashSet(Arrays.asList((String[]) obj)));
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> parseUri = parseUri(uri);
        if (parseUri == null || (sQLiteDatabase = (SQLiteDatabase) parseUri.first) == null) {
            return null;
        }
        try {
            long insert = sQLiteDatabase.insert((String) parseUri.second, null, contentValues);
            if (insert >= 0) {
                return ContentUris.withAppendedId(uri, insert);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> parseUri = parseUri(uri);
        if (parseUri == null || (sQLiteDatabase = (SQLiteDatabase) parseUri.first) == null) {
            return -1;
        }
        try {
            return sQLiteDatabase.delete((String) parseUri.second, str, strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Pair<SQLiteDatabase, String> parseUri = parseUri(uri);
        if (parseUri == null || (sQLiteDatabase = (SQLiteDatabase) parseUri.first) == null) {
            return -1;
        }
        try {
            return sQLiteDatabase.update((String) parseUri.second, contentValues, str, strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void execSQLForResolver(Context context, Uri uri, String str) {
        try {
            context.getContentResolver().query(uri, null, str, null, "execSQL");
        } catch (Exception unused) {
        }
    }

    public static Cursor rawQueryForResolver(Context context, Uri uri, String str, String[] strArr) {
        try {
            return context.getContentResolver().query(uri, null, str, strArr, "rawQuery");
        } catch (Exception unused) {
            return null;
        }
    }
}
