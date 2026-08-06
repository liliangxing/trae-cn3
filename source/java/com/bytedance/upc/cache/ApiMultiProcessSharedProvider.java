package com.bytedance.upc.cache;

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
import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.upc.common.utils.ProcessUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class ApiMultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_APP_FOREGROUND = "current_app_foreground";
    private static final String KEY_APP_STATE = "current_app_state";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 131072;
    public static final String SP_CONFIG_NAME = "upc_sdk_multi_process_sp";
    public static final String STRING_TYPE = "string";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    private static boolean mAllowStartOthersProcess = true;
    public static Uri sBaseUri;
    private static MultiProcessShared sInstance;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;
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
        SharedPreferences sharedPreferences2 = getContext().getApplicationContext().getSharedPreferences(SP_CONFIG_NAME, 4);
        this.mSharedPreferences = sharedPreferences2;
        return sharedPreferences2;
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
            sShareAuthority = getProviderAuthority(context, ApiMultiProcessSharedProvider.class.getName());
        }
        if (TextUtils.isEmpty(sShareAuthority)) {
            throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
        }
        LogUtils.d("MultiProcessSharedProvider " + sShareAuthority);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sMatcher = uriMatcher;
        uriMatcher.addURI(sShareAuthority, "*/*", 131072);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
    }

    public static String getProviderAuthority(Context context, String str) {
        LogUtils.d("MultiProcessSharedProvidergetProviderAuthority:" + str);
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            for (ProviderInfo providerInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers) {
                if (str.equals(providerInfo.name)) {
                    return providerInfo.authority;
                }
            }
        } catch (Exception unused) {
        }
        return context.getPackageName() + ".UPC.SHARE_PROVIDER_AUTHORITY";
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (sMatcher != null) {
            return true;
        }
        try {
            init(getContext());
            return true;
        } catch (Exception e) {
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
        if (isInitWithFailure() || sMatcher.match(uri) == 131072) {
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
        if (sMatcher.match(uri) == 131072) {
            try {
                arrayList = new ArrayList();
                editor = null;
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
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
            } catch (Exception e) {
                e.printStackTrace();
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
        return new Runnable() { // from class: com.bytedance.upc.cache.ApiMultiProcessSharedProvider.1
            @Override // java.lang.Runnable
            public void run() {
                ApiMultiProcessSharedProvider apiMultiProcessSharedProvider = ApiMultiProcessSharedProvider.this;
                apiMultiProcessSharedProvider.notifyContentChanged(ApiMultiProcessSharedProvider.getContentUri(apiMultiProcessSharedProvider.getContext(), str, str2));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Integer] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        MatrixCursor matrixCursor;
        LogUtils.d("MultiProcessSharedProvider query:" + uri.toString());
        delayOnCreate();
        MatrixCursor matrixCursor2 = null;
        r7 = 0;
        ?? r7 = 0;
        if (isInitWithFailure()) {
            return null;
        }
        if (sMatcher.match(uri) == 131072) {
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
                    boolean equals = TextUtils.equals(str4, KEY_APP_STATE);
                    boolean equals2 = TextUtils.equals(str4, KEY_APP_FOREGROUND);
                    if (!this.mContentValues.containsKey(str4) && !equals && !equals2) {
                        return null;
                    }
                    MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{str4});
                    if (!equals && !equals2) {
                        try {
                            r7 = this.mContentValues.get(str4);
                        } catch (Exception unused2) {
                            matrixCursor2 = matrixCursor3;
                            return matrixCursor2;
                        }
                    }
                    MatrixCursor.RowBuilder newRow2 = matrixCursor3.newRow();
                    boolean z = r7 instanceof Boolean;
                    MatrixCursor matrixCursor4 = r7;
                    if (z) {
                        if (!((Boolean) r7).booleanValue()) {
                            i = 0;
                        }
                        matrixCursor4 = Integer.valueOf(i);
                    }
                    newRow2.add(matrixCursor4);
                    matrixCursor = matrixCursor3;
                    matrixCursor2 = matrixCursor4;
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
        SharedPreferences multiProcessSharedPreferences = getMultiProcessSharedPreferences();
        if (multiProcessSharedPreferences == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : multiProcessSharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                this.mContentValues.put(key, value);
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
        synchronized (ApiMultiProcessSharedProvider.class) {
            if (sInstance == null) {
                sInstance = new MultiProcessShared(context);
            }
            multiProcessShared = sInstance;
        }
        return multiProcessShared;
    }

    /* loaded from: classes2.dex */
    public static class Editor {
        Context mContext;
        private SharedPreferences mSharedPreferences;
        private ContentValues mValues;

        private Editor(Context context) {
            this.mValues = new ContentValues();
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSharedPreferences = applicationContext.getApplicationContext().getSharedPreferences(ApiMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
        }

        public synchronized void apply() {
            if (ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                try {
                    this.mContext.getContentResolver().insert(ApiMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), this.mValues);
                } catch (Throwable unused) {
                }
            } else {
                SharedPreferences.Editor edit = this.mSharedPreferences.edit();
                Set<String> keySet = this.mValues.keySet();
                if (keySet != null) {
                    Object[] array = keySet.toArray();
                    if (array == null) {
                        return;
                    }
                    for (Object obj : array) {
                        String str = (String) obj;
                        Object obj2 = this.mValues.get(str);
                        if (obj2 instanceof String) {
                            edit.putString(str, (String) obj2);
                        } else if (obj2 instanceof Long) {
                            edit.putLong(str, ((Long) obj2).longValue());
                        } else if (obj2 instanceof Boolean) {
                            edit.putBoolean(str, ((Boolean) obj2).booleanValue());
                        } else if (obj2 instanceof Integer) {
                            edit.putInt(str, ((Integer) obj2).intValue());
                        } else if (obj2 instanceof Float) {
                            edit.putFloat(str, ((Float) obj2).floatValue());
                        }
                    }
                    edit.apply();
                }
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

        public Editor putStringSet(String str, Set<String> set) {
            this.mValues.put(str, ApiMultiProcessSharedProvider.setToString(set));
            return this;
        }

        public void remove(String str) {
            this.mValues.putNull(str);
        }
    }

    public static void setAllowStartOthersProcess(boolean z) {
        mAllowStartOthersProcess = z;
    }

    public static boolean allowStartOthersProcess(Context context) {
        return mAllowStartOthersProcess;
    }

    /* loaded from: classes2.dex */
    public static class MultiProcessShared {
        private Context mContext;
        private boolean mIsMainProcess;
        private SharedPreferences mSharedPreferences;

        private MultiProcessShared(Context context) {
            this.mIsMainProcess = false;
            this.mIsMainProcess = ProcessUtils.isMainProcess(context);
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSharedPreferences = applicationContext.getApplicationContext().getSharedPreferences(ApiMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
        }

        public Editor edit() {
            return new Editor(this.mContext);
        }

        public String getString(String str, String str2) {
            try {
                if (!this.mIsMainProcess && ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return ApiMultiProcessSharedProvider.getStringValue(this.mContext.getContentResolver().query(ApiMultiProcessSharedProvider.getContentUri(this.mContext, str, "string"), null, null, null, null), str2);
                }
                return this.mSharedPreferences.getString(str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }

        public long getLong(String str, long j) {
            try {
                if (!this.mIsMainProcess && ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return ApiMultiProcessSharedProvider.getLongValue(this.mContext.getContentResolver().query(ApiMultiProcessSharedProvider.getContentUri(this.mContext, str, "long"), null, null, null, null), j);
                }
                return this.mSharedPreferences.getLong(str, j);
            } catch (Throwable unused) {
                return j;
            }
        }

        public float getFloat(String str, float f) {
            try {
                if (!this.mIsMainProcess && ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return ApiMultiProcessSharedProvider.getFloatValue(this.mContext.getContentResolver().query(ApiMultiProcessSharedProvider.getContentUri(this.mContext, str, "float"), null, null, null, null), f);
                }
                return this.mSharedPreferences.getFloat(str, f);
            } catch (Throwable unused) {
                return f;
            }
        }

        public boolean getBoolean(String str, boolean z) {
            try {
                if (!this.mIsMainProcess && ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return ApiMultiProcessSharedProvider.getBooleanValue(this.mContext.getContentResolver().query(ApiMultiProcessSharedProvider.getContentUri(this.mContext, str, "boolean"), null, null, null, null), z);
                }
                return this.mSharedPreferences.getBoolean(str, z);
            } catch (Throwable unused) {
                return z;
            }
        }

        public int getInt(String str, int i) {
            try {
                if (!this.mIsMainProcess && ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return ApiMultiProcessSharedProvider.getIntValue(this.mContext.getContentResolver().query(ApiMultiProcessSharedProvider.getContentUri(this.mContext, str, "integer"), null, null, null, null), i);
                }
                return this.mSharedPreferences.getInt(str, i);
            } catch (Throwable unused) {
                return i;
            }
        }

        public Set<String> getStringSet(String str, Set<String> set) {
            String string;
            try {
                if (!this.mIsMainProcess && ApiMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    string = ApiMultiProcessSharedProvider.getStringValue(this.mContext.getContentResolver().query(ApiMultiProcessSharedProvider.getContentUri(this.mContext, str, "integer"), null, null, null, null), "");
                    return ApiMultiProcessSharedProvider.stringToSet(string);
                }
                string = this.mSharedPreferences.getString(str, "");
                return ApiMultiProcessSharedProvider.stringToSet(string);
            } catch (Throwable unused) {
                return set;
            }
        }
    }

    public static final synchronized Uri getContentUri(Context context, String str, String str2) {
        Uri build;
        synchronized (ApiMultiProcessSharedProvider.class) {
            if (sBaseUri == null) {
                try {
                    LogUtils.d("MultiProcessSharedProvider init form getContentUri");
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

    public static String setToString(Set<String> set) {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.lastIndexOf(","));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Set<String> stringToSet(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new HashSet(Arrays.asList(str.split(",")));
            }
        } catch (Throwable unused) {
        }
        return Collections.emptySet();
    }
}
