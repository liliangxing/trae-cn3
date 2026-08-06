package com.bytedance.push.settings.storage;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.push.settings.IDataChangedListener;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MultiProcessSpStorage implements Storage {
    private static boolean mIsSmp;
    private Map<IDataChangedListener, ContentObserver> listenerMap = new ConcurrentHashMap();
    private final Context mContext;
    private final String mStorageKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiProcessSpStorage(Context context, String str, boolean z) {
        SettingsLoggerHelper.getInstance().mo256d("create MultiProcessSpStorage with storageKey:" + str + " isSmp: " + z);
        this.mContext = context;
        this.mStorageKey = str;
        mIsSmp = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiProcessSpStorage(Context context, String str) {
        SettingsLoggerHelper.getInstance().mo256d("create MultiProcessSpStorage with storageKey:" + str + " isSmp will be set to false");
        this.mContext = context;
        this.mStorageKey = str;
        mIsSmp = false;
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public String getString(String str, String str2) {
        try {
            return getStringValue(getSpCursor(getContentUri(this.mContext, this.mStorageKey, str, str2, "string")), str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private Cursor getSpCursor(Uri uri) {
        Cursor cursor = null;
        try {
            ContentProviderClient acquireUnstableContentProviderClient = this.mContext.getContentResolver().acquireUnstableContentProviderClient(uri);
            if (acquireUnstableContentProviderClient != null) {
                try {
                    cursor = acquireUnstableContentProviderClient.query(uri, null, null, null, null);
                    acquireUnstableContentProviderClient.close();
                } catch (Throwable th) {
                    acquireUnstableContentProviderClient.close();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            SettingsLoggerHelper.getInstance().mo258e("[getSpCursor]exception:" + th2.getLocalizedMessage());
        }
        return cursor;
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public int getInt(String str, int i) {
        try {
            return getIntValue(getSpCursor(getContentUri(this.mContext, this.mStorageKey, str, String.valueOf(i), "integer")), i);
        } catch (Throwable unused) {
            return i;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public long getLong(String str) {
        return getLong(str, 0L);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public long getLong(String str, long j) {
        try {
            return getLongValue(getSpCursor(getContentUri(this.mContext, this.mStorageKey, str, String.valueOf(j), "long")), j);
        } catch (Throwable unused) {
            return j;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public float getFloat(String str, float f) {
        try {
            return getFloatValue(getSpCursor(getContentUri(this.mContext, this.mStorageKey, str, String.valueOf(f), "float")), f);
        } catch (Throwable unused) {
            return f;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public boolean getBoolean(String str, boolean z) {
        try {
            return getBooleanValue(getSpCursor(getContentUri(this.mContext, this.mStorageKey, str, String.valueOf(z), "boolean")), z);
        } catch (Throwable unused) {
            return z;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public boolean contains(String str) {
        try {
            Bundle bundle = null;
            Uri contentUri = getContentUri(this.mContext, null);
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    ContentProviderClient acquireUnstableContentProviderClient = this.mContext.getContentResolver().acquireUnstableContentProviderClient(contentUri);
                    if (acquireUnstableContentProviderClient != null) {
                        try {
                            bundle = acquireUnstableContentProviderClient.call(contentUri.getAuthority(), "_contains", null, ContainsProcessor.createArgs(this.mStorageKey, str));
                            acquireUnstableContentProviderClient.close();
                        } catch (Throwable th) {
                            acquireUnstableContentProviderClient.close();
                            throw th;
                        }
                    }
                } else {
                    bundle = this.mContext.getContentResolver().call(contentUri, "_contains", (String) null, ContainsProcessor.createArgs(this.mStorageKey, str));
                }
            } catch (Throwable th2) {
                SettingsLoggerHelper.getInstance().mo258e("[contains]exception:" + th2.getLocalizedMessage());
            }
            return ContainsProcessor.parseResult(bundle);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public SharedPreferences.Editor edit() {
        return new EditorImpl(this.mContext, this.mStorageKey, new UriCreator() { // from class: com.bytedance.push.settings.storage.MultiProcessSpStorage.1
            @Override // com.bytedance.push.settings.storage.UriCreator
            public Uri getContentUri(Context context, Item item) {
                return MultiProcessSpStorage.getContentUri(context, item);
            }
        });
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public void registerValChanged(Context context, String str, String str2, final IDataChangedListener iDataChangedListener) {
        Uri observerUri;
        if (iDataChangedListener == null || (observerUri = MainProcessSettingsProvider.getObserverUri(context, this.mStorageKey, str, str2)) == null) {
            return;
        }
        ContentObserver contentObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.bytedance.push.settings.storage.MultiProcessSpStorage.2
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                iDataChangedListener.onChange();
            }
        };
        try {
            context.getContentResolver().registerContentObserver(observerUri, true, contentObserver);
            this.listenerMap.put(iDataChangedListener, contentObserver);
        } catch (Throwable th) {
            SettingsLoggerHelper.getInstance().mo258e("error when  registerContentObserver:" + th.getLocalizedMessage());
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public void unregisterValChanged(IDataChangedListener iDataChangedListener) {
        ContentObserver remove;
        if (iDataChangedListener == null || (remove = this.listenerMap.remove(iDataChangedListener)) == null) {
            return;
        }
        this.mContext.getContentResolver().unregisterContentObserver(remove);
    }

    private static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        try {
            if (cursor.moveToFirst()) {
                str = cursor.getString(0);
            }
        } catch (Throwable unused) {
        }
        safeClose(cursor);
        return str;
    }

    private static boolean getBooleanValue(Cursor cursor, boolean z) {
        if (cursor == null) {
            return z;
        }
        try {
            if (cursor.moveToFirst()) {
                z = cursor.getInt(0) > 0;
            }
        } finally {
            try {
                return z;
            } finally {
            }
        }
        return z;
    }

    private static int getIntValue(Cursor cursor, int i) {
        if (cursor == null) {
            return i;
        }
        try {
            if (cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
        } catch (Throwable unused) {
        }
        safeClose(cursor);
        return i;
    }

    private static long getLongValue(Cursor cursor, long j) {
        if (cursor == null) {
            return j;
        }
        try {
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
        } catch (Throwable unused) {
        }
        safeClose(cursor);
        return j;
    }

    private static float getFloatValue(Cursor cursor, float f) {
        if (cursor == null) {
            return f;
        }
        try {
            if (cursor.moveToFirst()) {
                f = cursor.getFloat(0);
            }
        } catch (Throwable unused) {
        }
        safeClose(cursor);
        return f;
    }

    private Uri getContentUri(Context context, String str, String str2, String str3, String str4) {
        return getContentUri(context, new Item(str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Uri getContentUri(Context context, Item item) {
        synchronized (MultiProcessSpStorage.class) {
            if (mIsSmp) {
                return SmpProcessSettingsProvider.getContentUri(context, item);
            }
            return MainProcessSettingsProvider.getContentUri(context, item);
        }
    }

    private static void safeClose(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class EditorImpl implements SharedPreferences.Editor {
        private Context mContext;
        private final String mSpName;
        private final UriCreator mUriCreator;
        private ContentValues mValues = new ContentValues();

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return false;
        }

        EditorImpl(Context context, String str, UriCreator uriCreator) {
            this.mContext = context.getApplicationContext();
            this.mUriCreator = uriCreator;
            this.mSpName = str;
        }

        @Override // android.content.SharedPreferences.Editor
        public synchronized void apply() {
            try {
                Uri contentUri = this.mUriCreator.getContentUri(this.mContext, new Item(this.mSpName, "key", "val", "type"));
                if (Build.VERSION.SDK_INT >= 29) {
                    ContentProviderClient acquireUnstableContentProviderClient = this.mContext.getContentResolver().acquireUnstableContentProviderClient(contentUri);
                    if (acquireUnstableContentProviderClient != null) {
                        try {
                            acquireUnstableContentProviderClient.insert(contentUri, this.mValues);
                            acquireUnstableContentProviderClient.close();
                        } catch (Throwable th) {
                            acquireUnstableContentProviderClient.close();
                            throw th;
                        }
                    }
                } else {
                    this.mContext.getContentResolver().insert(contentUri, this.mValues);
                }
            } catch (Throwable th2) {
                SettingsLoggerHelper.getInstance().mo258e("[apply]exception:" + th2.getLocalizedMessage());
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl putString(String str, String str2) {
            this.mValues.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new UnsupportedOperationException("putStringSet not support");
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl putLong(String str, long j) {
            this.mValues.put(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl putBoolean(String str, boolean z) {
            this.mValues.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl putInt(String str, int i) {
            this.mValues.put(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl putFloat(String str, float f) {
            this.mValues.put(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl remove(String str) {
            this.mValues.putNull(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public EditorImpl clear() {
            throw new UnsupportedOperationException("no support clear");
        }
    }
}
