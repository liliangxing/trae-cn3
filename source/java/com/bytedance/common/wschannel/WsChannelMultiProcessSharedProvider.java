package com.bytedance.common.wschannel;

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
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class WsChannelMultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    private static final String SP_CONFIG_NAME = "wschannel_multi_process_config";
    public static final String STRING_TYPE = "string";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    public static Uri sBaseUri;
    private static MultiProcessShared sInstance;
    private static boolean sIsRegisterInMainProcess;
    private static volatile boolean sLoadValuesInit;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
    private SharedPreferences mSharedPreferences;
    private Map<String, Object> mContentValues = new ConcurrentHashMap();
    private final Object sLoadValuesInitLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyContentChanged(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    private synchronized SharedPreferences getMultiProcessSharedPreferences() {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = getContext().getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 4);
        this.mSharedPreferences = sharedPreferences2;
        return sharedPreferences2;
    }

    private static void init(Context context) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority)) {
            sShareAuthority = getProviderAuthority(context, WsChannelMultiProcessSharedProvider.class.getName());
        }
        if (TextUtils.isEmpty(sShareAuthority)) {
            throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
        }
        if (Logger.debug()) {
            Logger.v("MultiProcessSharedProvider", sShareAuthority);
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        sMatcher = uriMatcher;
        uriMatcher.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
    }

    public static String getProviderAuthority(Context context, String str) {
        if (context != null && !StringUtils.isEmpty(str)) {
            try {
                for (ProviderInfo providerInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers) {
                    if (str.equals(providerInfo.name)) {
                        return providerInfo.authority;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo != null) {
            sShareAuthority = providerInfo.authority;
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (Utils.isMainProcess(getContext())) {
            sIsRegisterInMainProcess = true;
        }
        WsChannelSdk2.monitorLifeCycle(getContext());
        if (sMatcher == null) {
            try {
                if (Logger.debug()) {
                    Logger.v("MultiProcessSharedProvider", "init form onCreate");
                }
                init(getContext());
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (sMatcher.match(uri) == 65536) {
            try {
                getMultiProcessSharedPreferences().edit().clear().commit();
                this.mContentValues.clear();
                notifyContentChanged(getContentUri(getContext(), "key", "type"));
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        throw new IllegalArgumentException("Unsupported uri " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        ArrayList arrayList;
        SharedPreferences.Editor editor;
        Runnable createNotifyRunnable;
        if (sMatcher.match(uri) == 65536) {
            try {
                loadValues();
                arrayList = new ArrayList();
                editor = null;
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
                    if (Logger.debug()) {
                        Logger.v("PushService", "MultiProcessShareProvider insert key = " + key + " value = " + value.toString());
                    }
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
                        if (Logger.debug()) {
                            Logger.v("PushService", new StringBuilder().append("MultiProcessShareProvider reallly insert key = ").append(key).append(" value = ").append(value).toString() != null ? value.toString() : "null");
                        }
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
                    }
                }
            } catch (Exception unused) {
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
        return new Runnable() { // from class: com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider.1
            @Override // java.lang.Runnable
            public void run() {
                WsChannelMultiProcessSharedProvider wsChannelMultiProcessSharedProvider = WsChannelMultiProcessSharedProvider.this;
                wsChannelMultiProcessSharedProvider.notifyContentChanged(WsChannelMultiProcessSharedProvider.getContentUri(wsChannelMultiProcessSharedProvider.getContext(), str, str2));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor;
        if (sMatcher.match(uri) == 65536) {
            MatrixCursor matrixCursor2 = null;
            try {
                int i = 1;
                if ("all".equals(uri.getPathSegments().get(1))) {
                    Map<String, ?> all = getMultiProcessSharedPreferences().getAll();
                    matrixCursor = new MatrixCursor(new String[]{KEY_COLUMN, VALUE_COLUMN, TYPE_COLUMN});
                    try {
                        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                        while (true) {
                            ?? hasNext = it.hasNext();
                            matrixCursor2 = hasNext;
                            if (hasNext != 0) {
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
                            }
                        }
                    } catch (Exception unused) {
                        matrixCursor2 = matrixCursor;
                        return matrixCursor2;
                    }
                } else {
                    String str4 = uri.getPathSegments().get(0);
                    loadValues();
                    if (!this.mContentValues.containsKey(str4)) {
                        return null;
                    }
                    MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{str4});
                    try {
                        ?? r7 = this.mContentValues.get(str4);
                        MatrixCursor.RowBuilder newRow2 = matrixCursor3.newRow();
                        boolean z = r7 instanceof Boolean;
                        MatrixCursor matrixCursor4 = r7;
                        if (z) {
                            if (!((Boolean) r7).booleanValue()) {
                                i = 0;
                            }
                            matrixCursor4 = Integer.valueOf(i);
                        }
                        if (Logger.debug()) {
                            Logger.v("PushService", "MultiProcessShareProvider reallly get key = " + str4 + " value = " + matrixCursor4.toString());
                        }
                        newRow2.add(matrixCursor4);
                        matrixCursor = matrixCursor3;
                        matrixCursor2 = matrixCursor4;
                    } catch (Exception unused2) {
                        matrixCursor2 = matrixCursor3;
                        return matrixCursor2;
                    }
                }
                return matrixCursor;
            } catch (Exception unused3) {
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
        if (sLoadValuesInit) {
            return;
        }
        synchronized (this.sLoadValuesInitLock) {
            if (!sLoadValuesInit) {
                SharedPreferences multiProcessSharedPreferences = getMultiProcessSharedPreferences();
                if (multiProcessSharedPreferences == null) {
                    sLoadValuesInit = true;
                    return;
                }
                for (Map.Entry<String, ?> entry : multiProcessSharedPreferences.getAll().entrySet()) {
                    this.mContentValues.put(entry.getKey(), entry.getValue());
                }
                sLoadValuesInit = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0010, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0014, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        try {
            if (cursor.moveToFirst()) {
                str = cursor.getString(0);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0015, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0019, code lost:
    
        if (r1 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean getBooleanValue(Cursor cursor, boolean z) {
        if (cursor == null) {
            return z;
        }
        try {
            if (cursor.moveToFirst()) {
                z = cursor.getInt(0) > 0;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0010, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0014, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getIntValue(Cursor cursor, int i) {
        if (cursor == null) {
            return i;
        }
        try {
            if (cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0010, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0014, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getLongValue(Cursor cursor, long j) {
        if (cursor == null) {
            return j;
        }
        try {
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0010, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0014, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float getFloatValue(Cursor cursor, float f) {
        if (cursor == null) {
            return f;
        }
        try {
            if (cursor.moveToFirst()) {
                f = cursor.getFloat(0);
            }
        } catch (Throwable unused) {
        }
    }

    public static Editor edit(Context context) {
        return new Editor(context);
    }

    public static synchronized MultiProcessShared getMultiprocessShared(Context context) {
        MultiProcessShared multiProcessShared;
        synchronized (WsChannelMultiProcessSharedProvider.class) {
            if (sInstance == null) {
                sInstance = new MultiProcessShared(context);
            }
            multiProcessShared = sInstance;
        }
        return multiProcessShared;
    }

    /* loaded from: classes3.dex */
    public static class Editor {
        Context mContext;
        private ContentValues mValues;

        private Editor(Context context) {
            this.mValues = new ContentValues();
            this.mContext = context.getApplicationContext();
        }

        public synchronized void apply() {
            try {
                this.mContext.getContentResolver().insert(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), this.mValues);
            } catch (Throwable unused) {
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
                this.mContext.getContentResolver().delete(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), null, null);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        private MultiProcessShared(Context context) {
            boolean z = false;
            this.mIsMainProcess = false;
            if (Utils.isMainProcess(context) && WsChannelMultiProcessSharedProvider.sIsRegisterInMainProcess) {
                z = true;
            }
            this.mIsMainProcess = z;
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSharedPreferences = applicationContext.getApplicationContext().getSharedPreferences(WsChannelMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
            if (Logger.debug()) {
                Logger.v("PushService", "MultiProcessShared create");
            }
        }

        public Editor edit() {
            return new Editor(this.mContext);
        }

        public String getString(String str, String str2) {
            try {
                if (!this.mIsMainProcess) {
                    return WsChannelMultiProcessSharedProvider.getStringValue(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, str, "string"), null, null, null, null), str2);
                }
                return this.mSharedPreferences.getString(str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }

        public long getLong(String str, long j) {
            try {
                if (!this.mIsMainProcess) {
                    return WsChannelMultiProcessSharedProvider.getLongValue(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, str, "long"), null, null, null, null), j);
                }
                return this.mSharedPreferences.getLong(str, j);
            } catch (Throwable unused) {
                return j;
            }
        }

        public float getFloat(String str, float f) {
            try {
                if (!this.mIsMainProcess) {
                    return WsChannelMultiProcessSharedProvider.getFloatValue(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, str, "float"), null, null, null, null), f);
                }
                return this.mSharedPreferences.getFloat(str, f);
            } catch (Throwable unused) {
                return f;
            }
        }

        public boolean getBoolean(String str, boolean z) {
            try {
                if (!this.mIsMainProcess) {
                    return WsChannelMultiProcessSharedProvider.getBooleanValue(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, str, "boolean"), null, null, null, null), z);
                }
                return this.mSharedPreferences.getBoolean(str, z);
            } catch (Throwable unused) {
                return z;
            }
        }

        public int getInt(String str, int i) {
            try {
                if (!this.mIsMainProcess) {
                    return WsChannelMultiProcessSharedProvider.getIntValue(this.mContext.getContentResolver().query(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, str, "integer"), null, null, null, null), i);
                }
                return this.mSharedPreferences.getInt(str, i);
            } catch (Throwable unused) {
                return i;
            }
        }
    }

    public static final synchronized Uri getContentUri(Context context, String str, String str2) {
        Uri build;
        synchronized (WsChannelMultiProcessSharedProvider.class) {
            if (sBaseUri == null) {
                try {
                    if (Logger.debug()) {
                        Logger.d("MultiProcessSharedProvider", "init form getContentUri");
                    }
                    init(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            build = sBaseUri.buildUpon().appendPath(str).appendPath(str2).build();
        }
        return build;
    }
}
