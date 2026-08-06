package com.ss.android.pushmanager.setting;

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
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushMultiProcessSharedProvider extends ContentProvider {
    public static final String ALL_TYPE = "all";
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    private static final String KEY = "key";
    private static final String KEY_APP_FOREGROUND = "current_app_foreground";
    private static final String KEY_APP_STATE = "current_app_state";
    private static final String KEY_COLUMN = "key_column";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    public static final String SP_CONFIG_NAME = "push_multi_process_config";
    public static final String STRING_TYPE = "string";
    private static final String TAG = "PushMultiProcessSP";
    private static final String TYPE = "type";
    private static final String TYPE_COLUMN = "type_column";
    private static final String VALUE_COLUMN = "value_column";
    private static boolean mAllowStartOthersProcess;
    public static Uri sBaseUri;
    public static boolean sCurIsProviderProcess;
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
        sCurIsProviderProcess = true;
        super.attachInfo(context, providerInfo);
    }

    private static void init(Context context) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority)) {
            sShareAuthority = getProviderAuthority(context, PushMultiProcessSharedProvider.class.getName());
        }
        if (TextUtils.isEmpty(sShareAuthority)) {
            throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
        }
        if (Logger.debug()) {
            Logger.d("MultiProcessSharedProvider", sShareAuthority);
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        sMatcher = uriMatcher;
        uriMatcher.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
    }

    public static String getProviderAuthority(Context context, String str) {
        Logger.d("MultiProcessSharedProvider", "getProviderAuthority:" + str);
        if (context == null || StringUtils.isEmpty(str)) {
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
        return context.getPackageName() + ".push.SHARE_PROVIDER_AUTHORITY";
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        sCurIsProviderProcess = true;
        Context context = getContext();
        if (context != null) {
            AppProvider.initApp((Application) context.getApplicationContext());
        }
        if (sMatcher != null) {
            return true;
        }
        try {
            if (Logger.debug()) {
                Logger.d("MultiProcessSharedProvider", "init form onCreate");
            }
            init(context);
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
        Logger.d("MultiProcessSharedProvider", "getType:" + uri.toString());
        sCurIsProviderProcess = true;
        delayOnCreate();
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Logger.d("MultiProcessSharedProvider", "delete:" + uri.toString() + " " + str);
        sCurIsProviderProcess = true;
        delayOnCreate();
        if (isInitWithFailure() || sMatcher.match(uri) == 65536) {
            return 0;
        }
        throw new IllegalArgumentException("Unsupported uri " + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x003e A[SYNTHETIC] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Uri insert(Uri uri, ContentValues contentValues) {
        ArrayList arrayList;
        SharedPreferences.Editor editor;
        boolean z;
        Runnable createNotifyRunnable;
        Logger.d("MultiProcessSharedProvider", "delete:" + uri.toString());
        sCurIsProviderProcess = true;
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
                    if (Logger.debug()) {
                        Logger.d("PushService", "MultiProcessShareProvider insert key = " + key + " value = " + value.toString());
                    }
                    if (value == null) {
                        this.mContentValues.remove(key);
                    } else {
                        Object obj = this.mContentValues.get(key);
                        if (obj != null && obj.equals(value)) {
                            z = false;
                            if (z) {
                                if (Logger.debug()) {
                                    Logger.d("PushService", new StringBuilder().append("MultiProcessShareProvider reallly insert key = ").append(key).append(" value = ").append(value).toString() != null ? value.toString() : "null");
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
                        this.mContentValues.put(key, value);
                    }
                    z = true;
                    if (z) {
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
        return new Runnable() { // from class: com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider.1
            @Override // java.lang.Runnable
            public void run() {
                PushMultiProcessSharedProvider pushMultiProcessSharedProvider = PushMultiProcessSharedProvider.this;
                pushMultiProcessSharedProvider.notifyContentChanged(PushMultiProcessSharedProvider.getContentUri(pushMultiProcessSharedProvider.getContext(), str, str2));
            }
        };
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj;
        MatrixCursor matrixCursor;
        Logger.d("MultiProcessSharedProvider", "query:" + uri.toString());
        int i = 1;
        sCurIsProviderProcess = true;
        delayOnCreate();
        MatrixCursor matrixCursor2 = null;
        MatrixCursor matrixCursor3 = null;
        if (isInitWithFailure()) {
            return null;
        }
        if (sMatcher.match(uri) == 65536) {
            try {
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
                    } catch (Exception unused) {
                        matrixCursor2 = matrixCursor;
                        return matrixCursor2;
                    }
                } else {
                    String str4 = uri.getPathSegments().get(0);
                    boolean equal = StringUtils.equal(str4, KEY_APP_STATE);
                    boolean equal2 = StringUtils.equal(str4, KEY_APP_FOREGROUND);
                    if (!this.mContentValues.containsKey(str4) && !equal && !equal2) {
                        return null;
                    }
                    MatrixCursor matrixCursor4 = new MatrixCursor(new String[]{str4});
                    try {
                        if (equal) {
                            obj = Boolean.valueOf(ActivityLifecycleObserver.getIns().isApplicationActive());
                        } else if (equal2) {
                            obj = Boolean.valueOf(!ActivityLifecycleObserver.getIns().isBackGround());
                        } else {
                            obj = this.mContentValues.get(str4);
                        }
                        MatrixCursor.RowBuilder newRow2 = matrixCursor4.newRow();
                        if (obj instanceof Boolean) {
                            if (!((Boolean) obj).booleanValue()) {
                                i = 0;
                            }
                            obj = Integer.valueOf(i);
                        }
                        if (Logger.debug()) {
                            Logger.d("PushService", "MultiProcessShareProvider reallly get key = " + str4 + " value = " + obj.toString());
                        }
                        newRow2.add(obj);
                        matrixCursor = matrixCursor4;
                        matrixCursor2 = newRow2;
                    } catch (Exception unused2) {
                        matrixCursor2 = matrixCursor4;
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
        sCurIsProviderProcess = true;
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
        synchronized (PushMultiProcessSharedProvider.class) {
            if (sInstance == null) {
                sInstance = new MultiProcessShared(context);
            }
            multiProcessShared = sInstance;
        }
        return multiProcessShared;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Editor {
        Context mContext;
        private SharedPreferences mSharedPreferences;
        private ContentValues mValues;

        private Editor(Context context) {
            this.mValues = new ContentValues();
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSharedPreferences = applicationContext.getApplicationContext().getSharedPreferences(PushMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
        }

        public synchronized void apply() {
            if (PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                try {
                    this.mContext.getContentResolver().insert(PushMultiProcessSharedProvider.getContentUri(this.mContext, "key", "type"), this.mValues);
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

        public void remove(String str) {
            this.mValues.putNull(str);
        }
    }

    public static void setAllowStartOthersProcess(boolean z) {
        mAllowStartOthersProcess = z;
    }

    public static boolean allowStartOthersProcess(Context context) {
        boolean isSmpProcess = ToolUtils.isSmpProcess(context);
        Logger.d(TAG, "mAllowStartOthersProcess  is " + mAllowStartOthersProcess + " isSmpProcess is " + isSmpProcess);
        if (!isSmpProcess) {
            return true;
        }
        Boolean isMainProcessStart = ToolUtils.isMainProcessStart(context);
        Logger.d(TAG, "isMainProcessStartEd is " + isMainProcessStart);
        if (isMainProcessStart == null || !isMainProcessStart.booleanValue()) {
            return mAllowStartOthersProcess;
        }
        return true;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MultiProcessShared {
        private Context mContext;
        private SharedPreferences mSharedPreferences;

        private MultiProcessShared(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSharedPreferences = applicationContext.getApplicationContext().getSharedPreferences(PushMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
            if (Logger.debug()) {
                Logger.d("PushService", "MultiProcessShared create");
            }
        }

        public Editor edit() {
            return new Editor(this.mContext);
        }

        public String getString(String str, String str2) {
            try {
                if (!PushMultiProcessSharedProvider.sCurIsProviderProcess && PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return PushMultiProcessSharedProvider.getStringValue(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, str, "string"), null, null, null, null), str2);
                }
                return this.mSharedPreferences.getString(str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }

        public long getLong(String str, long j) {
            try {
                if (!PushMultiProcessSharedProvider.sCurIsProviderProcess && PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return PushMultiProcessSharedProvider.getLongValue(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, str, "long"), null, null, null, null), j);
                }
                return this.mSharedPreferences.getLong(str, j);
            } catch (Throwable unused) {
                return j;
            }
        }

        public float getFloat(String str, float f) {
            try {
                if (!PushMultiProcessSharedProvider.sCurIsProviderProcess && PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return PushMultiProcessSharedProvider.getFloatValue(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, str, "float"), null, null, null, null), f);
                }
                return this.mSharedPreferences.getFloat(str, f);
            } catch (Throwable unused) {
                return f;
            }
        }

        public boolean getBoolean(String str, boolean z) {
            try {
                if (!PushMultiProcessSharedProvider.sCurIsProviderProcess && PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return PushMultiProcessSharedProvider.getBooleanValue(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, str, "boolean"), null, null, null, null), z);
                }
                return this.mSharedPreferences.getBoolean(str, z);
            } catch (Throwable unused) {
                return z;
            }
        }

        public int getInt(String str, int i) {
            try {
                if (!PushMultiProcessSharedProvider.sCurIsProviderProcess && PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                    return PushMultiProcessSharedProvider.getIntValue(this.mContext.getContentResolver().query(PushMultiProcessSharedProvider.getContentUri(this.mContext, str, "integer"), null, null, null, null), i);
                }
                return this.mSharedPreferences.getInt(str, i);
            } catch (Throwable unused) {
                return i;
            }
        }

        public boolean isApplicationActive() {
            if (PushMultiProcessSharedProvider.sCurIsProviderProcess || !PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                return isApplicationActiveInMainProcess();
            }
            return getBoolean(PushMultiProcessSharedProvider.KEY_APP_STATE, false);
        }

        private boolean isApplicationActiveInMainProcess() {
            return ActivityLifecycleObserver.getIns().isApplicationActive();
        }

        public boolean isApplicationForeground() {
            if (PushMultiProcessSharedProvider.sCurIsProviderProcess || !PushMultiProcessSharedProvider.allowStartOthersProcess(this.mContext)) {
                return isApplicationForegroundInMainProcess();
            }
            return getBoolean(PushMultiProcessSharedProvider.KEY_APP_FOREGROUND, false);
        }

        private boolean isApplicationForegroundInMainProcess() {
            return !ActivityLifecycleObserver.getIns().isBackGround();
        }
    }

    public static final synchronized Uri getContentUri(Context context, String str, String str2) {
        Uri build;
        synchronized (PushMultiProcessSharedProvider.class) {
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
