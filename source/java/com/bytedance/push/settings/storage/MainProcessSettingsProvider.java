package com.bytedance.push.settings.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;
import com.bytedance.push.settings.utils.SettingsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MainProcessSettingsProvider extends ContentProvider {
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String DEFAULT_VAL = "val";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    static final String KEY = "key";
    public static final String LONG_TYPE = "long";
    private static final int MATCH_DATA = 65536;
    public static final String STRING_TYPE = "string";
    static final String TYPE = "type";
    public static Uri sBaseUri;
    private static volatile boolean sInProviderProcess;
    private static UriMatcher sMatcher;
    public static String sShareAuthority;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
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
        sInProviderProcess = true;
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

    public static boolean isInProviderProcess(Context context) {
        return sInProviderProcess || SettingsUtils.isMainProcess(context);
    }

    private static void init(Context context) throws IllegalStateException {
        if (TextUtils.isEmpty(sShareAuthority)) {
            sShareAuthority = getProviderAuthority(context, MainProcessSettingsProvider.class.getName());
        }
        if (TextUtils.isEmpty(sShareAuthority)) {
            throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        sMatcher = uriMatcher;
        uriMatcher.addURI(sShareAuthority, "*/*/*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
    }

    private static boolean isInitWithFailure() {
        return TextUtils.isEmpty(sShareAuthority) || sMatcher == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable createNotifyRunnable(final Context context, final String str, final String str2, final String str3) {
        return new Runnable() { // from class: com.bytedance.push.settings.storage.MainProcessSettingsProvider.1
            @Override // java.lang.Runnable
            public void run() {
                Uri contentUri = MainProcessSettingsProvider.getContentUri(context, new Item(str, str2, "val", str3));
                if (contentUri == null) {
                    return;
                }
                try {
                    context.getContentResolver().notifyChange(contentUri, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static synchronized Uri getObserverUri(Context context, String str, String str2, String str3) {
        synchronized (MainProcessSettingsProvider.class) {
            if (sBaseUri == null) {
                try {
                    init(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return new Item(str, str2, "val", str3).toUri(sBaseUri);
            }
            return sBaseUri;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized Uri getContentUri(Context context, Item item) {
        synchronized (MainProcessSettingsProvider.class) {
            if (sBaseUri == null) {
                try {
                    init(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (item == null) {
                return sBaseUri;
            }
            return item.toUri(sBaseUri);
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Item create;
        Object string;
        if (isInitWithFailure() || sMatcher.match(uri) != 65536 || (create = Item.create(uri)) == null || TextUtils.isEmpty(create.storageKey) || TextUtils.isEmpty(create.key) || TextUtils.isEmpty(create.type)) {
            return null;
        }
        Storage create2 = SettingsManager.getStorageFactory().create(getContext(), true, create.storageKey, "main");
        SettingsLoggerHelper.getInstance().mo256d("query on MainProcessSettingsProvider for " + create.storageKey + " storage class name is " + create2.getClass().getName() + " item.key:" + create.key);
        String str3 = create.type;
        str3.hashCode();
        char c = 65535;
        switch (str3.hashCode()) {
            case -891985903:
                if (str3.equals("string")) {
                    c = 0;
                    break;
                }
                break;
            case 3327612:
                if (str3.equals("long")) {
                    c = 1;
                    break;
                }
                break;
            case 64711720:
                if (str3.equals("boolean")) {
                    c = 2;
                    break;
                }
                break;
            case 97526364:
                if (str3.equals("float")) {
                    c = 3;
                    break;
                }
                break;
            case 1958052158:
                if (str3.equals("integer")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                string = create2.getString(create.key, create.value);
                break;
            case 1:
                string = Long.valueOf(create2.getLong(create.key, Long.parseLong(create.value)));
                break;
            case 2:
                string = Integer.valueOf(create2.getBoolean(create.key, Boolean.parseBoolean(create.value)) ? 1 : 0);
                break;
            case 3:
                string = Float.valueOf(create2.getFloat(create.key, Float.parseFloat(create.value)));
                break;
            case 4:
                string = Integer.valueOf(create2.getInt(create.key, Integer.parseInt(create.value)));
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{create.key});
        matrixCursor.newRow().add(string);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SharedPreferences.Editor edit;
        ArrayList arrayList;
        String str;
        if (isInitWithFailure()) {
            return null;
        }
        if (sMatcher.match(uri) == 65536) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                return null;
            }
            String str2 = pathSegments.get(0);
            try {
                Storage create = SettingsManager.getStorageFactory().create(getContext(), true, str2, "main");
                SettingsLoggerHelper.getInstance().mo256d("insert on MainProcessSettingsProvider for " + str2 + " storage class name is " + create.getClass().getName());
                edit = create.edit();
                arrayList = new ArrayList();
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
                    if (value == null) {
                        edit.remove(key);
                        str = null;
                    } else if (value instanceof String) {
                        if (!TextUtils.equals(create.getString(key), (String) value)) {
                            edit.putString(key, (String) value);
                            str = "string";
                        }
                    } else if (value instanceof Boolean) {
                        if (create.getBoolean(key) != ((Boolean) value).booleanValue()) {
                            edit.putBoolean(key, ((Boolean) value).booleanValue());
                            str = "boolean";
                        }
                    } else if (value instanceof Long) {
                        if (create.getLong(key) != ((Long) value).longValue()) {
                            edit.putLong(key, ((Long) value).longValue());
                            str = "long";
                        }
                    } else if (value instanceof Integer) {
                        if (create.getInt(key) != ((Integer) value).intValue()) {
                            edit.putInt(key, ((Integer) value).intValue());
                            str = "integer";
                        }
                    } else {
                        if (!(value instanceof Float)) {
                            throw new IllegalArgumentException("Unsupported type " + uri);
                        }
                        if (create.getFloat(key) != ((Float) value).floatValue()) {
                            edit.putFloat(key, ((Float) value).floatValue());
                            str = "float";
                        }
                    }
                    if (str != null) {
                        arrayList.add(createNotifyRunnable(getContext(), str2, key, str));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (edit == null) {
                return null;
            }
            edit.apply();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            return null;
        }
        throw new IllegalArgumentException("Unsupported uri " + uri);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Processor processor = ProcessorPool.get(str);
        if (processor == null) {
            return null;
        }
        return processor.process(getContext(), str2, bundle, "main");
    }

    private static String getProviderAuthority(Context context, String str) {
        SettingsLoggerHelper.getInstance().mo257d(IPushService.TAG, "getProviderAuthority: " + str);
        if (context == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                for (ProviderInfo providerInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers) {
                    if (str.equals(providerInfo.name)) {
                        return providerInfo.authority;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return context.getPackageName() + ".push.settings";
    }
}
