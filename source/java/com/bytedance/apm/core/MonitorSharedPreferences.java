package com.bytedance.apm.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.util.ListUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class MonitorSharedPreferences implements SharedPreferences {
    private static int sTargetPID = -1;
    private Application mApp;
    private Uri mDefaultUri;
    private String mUriString;

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    private MonitorSharedPreferences(Application application, String str) {
        this.mApp = application;
        String str2 = "content://" + application.getPackageName() + ".apm/sp/" + str;
        this.mUriString = str2;
        this.mDefaultUri = Uri.parse(str2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> pairs = getPairs(null, null);
        if (pairs == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<SpPair> it = pairs.iterator();
        while (it.hasNext()) {
            SpPair next = it.next();
            hashMap.put(next.mKey, next.mValue);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        ArrayList<SpPair> pairs = getPairs(str, str2);
        if (pairs == null) {
            return null;
        }
        return (String) pairs.get(0).mValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        ArrayList<SpPair> pairs = getPairs(str, set);
        if (pairs == null || pairs.get(0).mValue == null) {
            return null;
        }
        String[] strArr = (String[]) pairs.get(0).mValue;
        HashSet hashSet = new HashSet(strArr.length);
        hashSet.addAll(Arrays.asList(strArr));
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        ArrayList<SpPair> pairs = getPairs(str, String.valueOf(i));
        if (pairs == null) {
            return i;
        }
        Object obj = pairs.get(0).mValue;
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return obj instanceof String ? Integer.decode((String) obj).intValue() : i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        ArrayList<SpPair> pairs = getPairs(str, String.valueOf(j));
        if (pairs == null) {
            return j;
        }
        Object obj = pairs.get(0).mValue;
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return obj instanceof String ? Long.decode((String) obj).longValue() : j;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        ArrayList<SpPair> pairs = getPairs(str, String.valueOf(f));
        if (pairs == null) {
            return f;
        }
        Object obj = pairs.get(0).mValue;
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return obj instanceof String ? Float.valueOf((String) obj).floatValue() : f;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        ArrayList<SpPair> pairs = getPairs(str, String.valueOf(z));
        if (pairs == null) {
            return z;
        }
        Object obj = pairs.get(0).mValue;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return obj instanceof String ? Boolean.valueOf((String) obj).booleanValue() : z;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        Bundle bundle = null;
        try {
            bundle = this.mApp.getContentResolver().call(this.mDefaultUri, str != null ? this.mUriString + "/" + str : this.mUriString, "contains", (Bundle) null);
        } catch (Exception unused) {
        }
        return bundle != null && bundle.getBoolean("contains");
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new EditorImpl();
    }

    /* loaded from: classes3.dex */
    private class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mPuts;

        private EditorImpl() {
            this.mClear = false;
            this.mPuts = new HashMap<>();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.mPuts.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.mPuts.put(str, ListUtils.toArray(set));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.mPuts.put(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.mPuts.put(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.mPuts.put(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.mPuts.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.mPuts.put(str, null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mPuts.clear();
            this.mClear = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.mClear || !this.mPuts.isEmpty()) {
                Bundle bundle = new Bundle();
                if (this.mClear) {
                    bundle.putBoolean("clear", true);
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.mPuts.size());
                for (Map.Entry<String, Object> entry : this.mPuts.entrySet()) {
                    arrayList.add(new SpPair(entry.getKey(), entry.getValue()));
                }
                bundle.putParcelableArrayList("edit", arrayList);
                try {
                    MonitorSharedPreferences.this.mApp.getContentResolver().call(MonitorSharedPreferences.this.mDefaultUri, MonitorSharedPreferences.this.mUriString, "edit", bundle);
                } catch (Exception unused) {
                }
            }
        }
    }

    private ArrayList<SpPair> getPairs(String str, Object obj) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        if (obj != null) {
            bundle2.putParcelable(CloudControlInf.SP, new SpPair(str, obj));
        }
        try {
            ContentResolver contentResolver = this.mApp.getContentResolver();
            Uri uri = this.mDefaultUri;
            String str2 = str != null ? this.mUriString + "/" + str : this.mUriString;
            if (obj == null) {
                bundle2 = null;
            }
            bundle = contentResolver.call(uri, str2, "query", bundle2);
        } catch (Exception unused) {
            bundle = null;
        }
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        return bundle.getParcelableArrayList(CloudControlInf.SP);
    }

    private static int getProviderPID(Context context) {
        try {
            Bundle call = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".apm"), "getPid", (String) null, (Bundle) null);
            if (call != null) {
                return call.getInt("Pid", -1);
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        if (isProviderProcess(context)) {
            return context.getSharedPreferences(str, 0);
        }
        return getProviderSharedPreferences(context, str);
    }

    static SharedPreferences getProviderSharedPreferences(Context context, String str) {
        Application application;
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            application = (Application) context.getApplicationContext();
        }
        return new MonitorSharedPreferences(application, str);
    }

    public static boolean isProviderProcess(Context context) {
        if (sTargetPID == -1) {
            sTargetPID = getProviderPID(context);
        }
        return sTargetPID == Process.myPid();
    }
}
