package com.ss.android.token;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.account.utils.ActivityStack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AuthTokenMultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    public static final String STRING_TYPE = "string";
    public static final String TAG = "AuthTokenMultiProcessShared";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    public static Uri sBaseUri = null;
    private static MultiProcessShared sInstance = null;
    private static UriMatcher sMatcher = null;
    public static String sShareAuthority = null;
    private static String sSpName = "token_shared_preference";
    private Map<String, Object> mContentValues = new ConcurrentHashMap();
    private volatile boolean mHasCreate = false;
    private final Object mLock = new Object();
    private SharedPreferences mSharedPreferences;

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyContentChanged(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = getContext().getApplicationContext().getSharedPreferences(sSpName, 4);
        this.mSharedPreferences = sharedPreferences2;
        return sharedPreferences2;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(sSpName, 4);
    }

    private static boolean isInitWithFailure() {
        return TextUtils.isEmpty(sShareAuthority) || sMatcher == null;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo != null) {
            sShareAuthority = providerInfo.authority;
        }
        super.attachInfo(context, providerInfo);
    }

    private static void init(Context context) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority)) {
            sShareAuthority = getProviderAuthority(context, AuthTokenMultiProcessSharedProvider.class.getName());
        }
        if (TextUtils.isEmpty(sShareAuthority)) {
            throw new IllegalStateException("Must Set AuthTokenMultiProcessSharedProvider Authority");
        }
        TTTokenManager.log("AuthTokenMultiProcessSharedProvider", sShareAuthority);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sMatcher = uriMatcher;
        uriMatcher.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
    }

    public static String getProviderAuthority(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            for (ProviderInfo providerInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers) {
                if (str.equals(providerInfo.name)) {
                    return providerInfo.authority;
                }
            }
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
        }
        return context.getPackageName() + ".auth_token.SHARE_PROVIDER_AUTHORITY";
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (TTTokenManager.isLocalTest() && !TokenUtils.isMainProcess(getContext())) {
            throw new IllegalAccessError("should be create in main process");
        }
        if (getContext() != null && (getContext().getApplicationContext() instanceof Application)) {
            ActivityStack.init((Application) getContext().getApplicationContext());
        }
        if (sMatcher != null) {
            return true;
        }
        try {
            TTTokenManager.log("AuthTokenMultiProcessSharedProvider", "init form onCreate");
            init(getContext());
            return true;
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
            e.printStackTrace();
            return false;
        }
    }

    private void delayOnCreate() {
        if (this.mHasCreate) {
            return;
        }
        synchronized (this.mLock) {
            if (!this.mHasCreate) {
                loadValues();
                this.mHasCreate = true;
            }
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        delayOnCreate();
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        delayOnCreate();
        if (isInitWithFailure()) {
            return 0;
        }
        if (sMatcher.match(uri) == 65536) {
            try {
                this.mContentValues.clear();
                getMultiProcessSharedPreferences().edit().clear().commit();
                notifyContentChanged(getContentUri(getContext(), "key", "type"));
            } catch (Exception e) {
                TTTokenMonitor.monitorError(e);
            }
            return 0;
        }
        throw new IllegalArgumentException("Unsupported uri " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        ArrayList arrayList;
        SharedPreferences.Editor editor;
        Runnable createNotifyRunnable;
        delayOnCreate();
        if (isInitWithFailure()) {
            return null;
        }
        if (sMatcher.match(uri) == 65536) {
            try {
                arrayList = new ArrayList();
                editor = null;
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
                    TTTokenManager.log(TAG, "MultiProcessShareProvider reallly insert key = " + key + " value = " + TokenFactory.getMixVal(value));
                    if (key != null) {
                        boolean z = true;
                        if (value == null) {
                            this.mContentValues.remove(key);
                        } else {
                            Object obj = this.mContentValues.get(key);
                            if (obj != null && obj.equals(value)) {
                                z = false;
                            }
                            this.mContentValues.put(key, value);
                        }
                        if (z) {
                            TTTokenManager.log(TAG, "MultiProcessShareProvider reallly insert key = " + key + " value = " + TokenFactory.getMixVal(value));
                            if (editor == null) {
                                editor = getMultiProcessSharedPreferences().edit();
                            }
                            if (value == null) {
                                editor.remove(key);
                                createNotifyRunnable = null;
                            } else if (value instanceof String) {
                                editor.putString(key, (String) value);
                                createNotifyRunnable = createNotifyRunnable(key, "string");
                            } else if (value instanceof Boolean) {
                                editor.putBoolean(key, ((Boolean) value).booleanValue());
                                createNotifyRunnable = createNotifyRunnable(key, "boolean");
                            } else if (value instanceof Long) {
                                editor.putLong(key, ((Long) value).longValue());
                                createNotifyRunnable = createNotifyRunnable(key, "long");
                            } else if (value instanceof Integer) {
                                editor.putInt(key, ((Integer) value).intValue());
                                createNotifyRunnable = createNotifyRunnable(key, "integer");
                            } else if (value instanceof Float) {
                                editor.putFloat(key, ((Float) value).floatValue());
                                createNotifyRunnable = createNotifyRunnable(key, "float");
                            } else {
                                throw new IllegalArgumentException("Unsupported type " + uri);
                            }
                            if (createNotifyRunnable != null) {
                                arrayList.add(createNotifyRunnable);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception e) {
                TTTokenMonitor.monitorError(e);
            }
            if (editor == null) {
                return null;
            }
            editor.apply();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            return null;
        }
        throw new IllegalArgumentException("Unsupported uri " + uri);
    }

    private Runnable createNotifyRunnable(final String str, final String str2) {
        return new Runnable() { // from class: com.ss.android.token.AuthTokenMultiProcessSharedProvider.1
            @Override // java.lang.Runnable
            public void run() {
                AuthTokenMultiProcessSharedProvider authTokenMultiProcessSharedProvider = AuthTokenMultiProcessSharedProvider.this;
                authTokenMultiProcessSharedProvider.notifyContentChanged(AuthTokenMultiProcessSharedProvider.getContentUri(authTokenMultiProcessSharedProvider.getContext(), str, str2));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor;
        delayOnCreate();
        MatrixCursor matrixCursor2 = null;
        MatrixCursor matrixCursor3 = null;
        if (isInitWithFailure()) {
            return null;
        }
        if (sMatcher.match(uri) == 65536) {
            try {
                int i = 1;
                if ("all".equals(uri.getPathSegments().get(1))) {
                    Map<String, ?> all = getMultiProcessSharedPreferences().getAll();
                    matrixCursor = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});
                    try {
                        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                        while (true) {
                            matrixCursor2 = matrixCursor3;
                            if (it.hasNext()) {
                                Map.Entry<String, ?> next = it.next();
                                String key = next.getKey();
                                Object value = next.getValue();
                                MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
                                String str3 = "string";
                                if (!(value instanceof String)) {
                                    if (value instanceof Boolean) {
                                        str3 = "boolean";
                                        value = Integer.valueOf(((Boolean) value).booleanValue() ? 1 : 0);
                                    } else if (value instanceof Integer) {
                                        str3 = "integer";
                                    } else if (value instanceof Long) {
                                        str3 = "long";
                                    } else if (value instanceof Float) {
                                        str3 = "float";
                                    }
                                }
                                newRow.add(key);
                                newRow.add(value);
                                newRow.add(str3);
                                matrixCursor3 = key;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        matrixCursor2 = matrixCursor;
                        TTTokenMonitor.monitorError(e);
                        return matrixCursor2;
                    }
                } else {
                    String str4 = uri.getPathSegments().get(0);
                    if (!this.mContentValues.containsKey(str4)) {
                        return null;
                    }
                    MatrixCursor matrixCursor4 = new MatrixCursor(new String[]{str4});
                    try {
                        ?? r8 = this.mContentValues.get(str4);
                        MatrixCursor.RowBuilder newRow2 = matrixCursor4.newRow();
                        boolean z = r8 instanceof Boolean;
                        MatrixCursor matrixCursor5 = r8;
                        if (z) {
                            if (!((Boolean) r8).booleanValue()) {
                                i = 0;
                            }
                            matrixCursor5 = Integer.valueOf(i);
                        }
                        TTTokenManager.log(TAG, "MultiProcessShareProvider  get key = " + str4 + " value = " + TokenFactory.getMixVal(matrixCursor5) + " " + Log.getStackTraceString(new Exception()));
                        newRow2.add(matrixCursor5);
                        matrixCursor = matrixCursor4;
                        matrixCursor2 = matrixCursor5;
                    } catch (Exception e2) {
                        e = e2;
                        matrixCursor2 = matrixCursor4;
                        TTTokenMonitor.monitorError(e);
                        return matrixCursor2;
                    }
                }
                return matrixCursor;
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            throw new IllegalArgumentException("Unsupported uri " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    private void loadValues() {
        SharedPreferences multiProcessSharedPreferences = getMultiProcessSharedPreferences();
        if (multiProcessSharedPreferences == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : multiProcessSharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && key != null) {
                this.mContentValues.put(key, value);
            } else {
                try {
                    TTTokenManager.log(TAG, "MultiProcessShareProvider loadValues key_ = " + key + " value_ = " + value);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key_", key);
                    jSONObject.put("value_", value);
                    TTTokenMonitor.onTokenEvent("token_sp_error", jSONObject);
                } catch (Exception e) {
                    TTTokenMonitor.monitorError(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        try {
            try {
                if (cursor.moveToFirst()) {
                    str = cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                try {
                    TTTokenMonitor.monitorError(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            TTTokenMonitor.monitorError(e);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e2) {
            TTTokenMonitor.monitorError(e2);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static boolean getBooleanValue(Cursor cursor, boolean z) {
        try {
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
        }
        if (cursor == null) {
            return z;
        }
        try {
            z = z;
            if (cursor.moveToFirst()) {
                z = cursor.getInt(0);
                z = z > 0 ? 1 : 0;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            try {
                TTTokenMonitor.monitorError(th);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        TTTokenMonitor.monitorError(e2);
                    }
                }
                throw th2;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntValue(Cursor cursor, int i) {
        if (cursor == null) {
            return i;
        }
        try {
            try {
                if (cursor.moveToFirst()) {
                    i = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                try {
                    TTTokenMonitor.monitorError(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            TTTokenMonitor.monitorError(e);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e2) {
            TTTokenMonitor.monitorError(e2);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getLongValue(Cursor cursor, long j) {
        if (cursor == null) {
            return j;
        }
        try {
            try {
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                try {
                    TTTokenMonitor.monitorError(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            TTTokenMonitor.monitorError(e);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e2) {
            TTTokenMonitor.monitorError(e2);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getFloatValue(Cursor cursor, float f) {
        if (cursor == null) {
            return f;
        }
        try {
            try {
                if (cursor.moveToFirst()) {
                    f = cursor.getFloat(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                try {
                    TTTokenMonitor.monitorError(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            TTTokenMonitor.monitorError(e);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e2) {
            TTTokenMonitor.monitorError(e2);
        }
        return f;
    }

    public static Editor edit(Context context) {
        return new Editor(context);
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context context, String str, boolean z) {
        MultiProcessShared multiProcessShared;
        synchronized (AuthTokenMultiProcessSharedProvider.class) {
            if (sInstance == null) {
                sInstance = new MultiProcessShared(context, str, z);
            }
            multiProcessShared = sInstance;
        }
        return multiProcessShared;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        private Editor(Context context) {
            this.mValues = new ContentValues();
            this.mContext = context.getApplicationContext();
        }

        public synchronized void apply() {
            try {
                SharedPreferences.Editor edit = AuthTokenMultiProcessSharedProvider.getSharedPreferences(this.mContext).edit();
                for (Map.Entry<String, Object> entry : this.mValues.valueSet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
                    TTTokenManager.log(AuthTokenMultiProcessSharedProvider.TAG, "MultiProcessShareProvider apply key = " + key + " value = " + TokenFactory.getMixVal(value));
                    if (value == null) {
                        edit.remove(key);
                    } else if (value instanceof String) {
                        edit.putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Long) {
                        edit.putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Integer) {
                        edit.putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(key, ((Float) value).floatValue());
                    }
                }
                edit.commit();
                this.mContext.getContentResolver().insert(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), this.mValues);
            } catch (Throwable th) {
                TTTokenManager.log(AuthTokenMultiProcessSharedProvider.TAG, "MultiProcessShareProvider apply error = " + Log.getStackTraceString(th));
                TTTokenMonitor.monitorError(th);
            }
        }

        public synchronized void commit() {
            apply();
        }

        public Editor putString(String str, String str2) {
            this.mValues.put(str, str2);
            return this;
        }

        public Editor putLong(String str, long j) {
            this.mValues.put(str, Long.valueOf(j));
            return this;
        }

        public Editor putBoolean(String str, boolean z) {
            this.mValues.put(str, Boolean.valueOf(z));
            return this;
        }

        public Editor putInt(String str, int i) {
            this.mValues.put(str, Integer.valueOf(i));
            return this;
        }

        public Editor putFloat(String str, float f) {
            this.mValues.put(str, Float.valueOf(f));
            return this;
        }

        public void remove(String str) {
            this.mValues.putNull(str);
        }

        public void clear() {
            try {
                this.mContext.getContentResolver().delete(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), null, null);
            } catch (Throwable th) {
                TTTokenMonitor.monitorError(th);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        private MultiProcessShared(Context context, String str, boolean z) {
            this.mIsMainProcess = z;
            this.mContext = context.getApplicationContext();
            String unused = AuthTokenMultiProcessSharedProvider.sSpName = str;
            this.mSharedPreferences = this.mContext.getApplicationContext().getSharedPreferences(AuthTokenMultiProcessSharedProvider.sSpName, 4);
            TTTokenManager.log(AuthTokenMultiProcessSharedProvider.TAG, "MultiProcessShared create");
        }

        public Editor edit() {
            return new Editor(this.mContext);
        }

        public String getString(String str, String str2) {
            try {
                if (!this.mIsMainProcess) {
                    String stringValue = AuthTokenMultiProcessSharedProvider.getStringValue(this.mContext.getContentResolver().query(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, str, "string"), null, null, null, null), str2);
                    TTTokenManager.log(AuthTokenMultiProcessSharedProvider.TAG, " MultiProcessShared getString get key = " + str + " value = " + TokenFactory.getMixVal(stringValue) + " " + Log.getStackTraceString(new Exception()));
                    return stringValue;
                }
                String string = this.mSharedPreferences.getString(str, str2);
                TTTokenManager.log(AuthTokenMultiProcessSharedProvider.TAG, "mSharedPreferences main getString get key = " + str + " value = " + TokenFactory.getMixVal(string) + " " + Log.getStackTraceString(new Exception()));
                return string;
            } catch (Throwable th) {
                TTTokenMonitor.monitorError(th);
                return str2;
            }
        }

        public long getLong(String str, long j) {
            try {
                if (!this.mIsMainProcess) {
                    return AuthTokenMultiProcessSharedProvider.getLongValue(this.mContext.getContentResolver().query(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, str, "long"), null, null, null, null), j);
                }
                return this.mSharedPreferences.getLong(str, j);
            } catch (Throwable th) {
                TTTokenMonitor.monitorError(th);
                return j;
            }
        }

        public float getFloat(String str, float f) {
            try {
                if (!this.mIsMainProcess) {
                    return AuthTokenMultiProcessSharedProvider.getFloatValue(this.mContext.getContentResolver().query(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, str, "float"), null, null, null, null), f);
                }
                return this.mSharedPreferences.getFloat(str, f);
            } catch (Throwable th) {
                TTTokenMonitor.monitorError(th);
                return f;
            }
        }

        public boolean getBoolean(String str, boolean z) {
            try {
                if (!this.mIsMainProcess) {
                    return AuthTokenMultiProcessSharedProvider.getBooleanValue(this.mContext.getContentResolver().query(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, str, "boolean"), null, null, null, null), z);
                }
                return this.mSharedPreferences.getBoolean(str, z);
            } catch (Throwable th) {
                TTTokenMonitor.monitorError(th);
                return z;
            }
        }

        public int getInt(String str, int i) {
            try {
                if (!this.mIsMainProcess) {
                    return AuthTokenMultiProcessSharedProvider.getIntValue(this.mContext.getContentResolver().query(AuthTokenMultiProcessSharedProvider.getContentUri(this.mContext, str, "integer"), null, null, null, null), i);
                }
                return this.mSharedPreferences.getInt(str, i);
            } catch (Throwable th) {
                TTTokenMonitor.monitorError(th);
                return i;
            }
        }
    }

    public static final synchronized Uri getContentUri(Context context, String str, String str2) {
        Uri build;
        synchronized (AuthTokenMultiProcessSharedProvider.class) {
            if (sBaseUri == null) {
                try {
                    TTTokenManager.log("MultiProcessSharedProvider", "init form getContentUri");
                    init(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    TTTokenMonitor.monitorError(e);
                    return null;
                }
            }
            build = sBaseUri.buildUpon().appendPath(str).appendPath(str2).build();
        }
        return build;
    }
}
