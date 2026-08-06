package com.bytedance.keva;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class KevaPrivateOnlyNativeImpl extends KevaPrivateNativeImpl {
    @Override // com.bytedance.keva.KevaPrivateNativeImpl
    public long clearCache(int i, boolean z) {
        return 0L;
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void dump() {
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public KevaPrivateOnlyNativeImpl(String str, String str2, int i) {
        super(str, str2, i);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeFloat(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str2 = str;
        try {
            if (nativeStoreFloat(str2, f, this.handle)) {
                super.notifyChangeListeners(this, str2);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str2, Float.valueOf(f), th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str2 = str;
        try {
            if (nativeStoreBoolean(str2, z, this.handle)) {
                super.notifyChangeListeners(this, str2);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str2, Boolean.valueOf(z), th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str2 = str;
        try {
            if (nativeStoreInt(str2, i, this.handle)) {
                super.notifyChangeListeners(this, str2);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str2, Integer.valueOf(i), th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        try {
            if (nativeStoreLong(str, j, this.handle)) {
                super.notifyChangeListeners(this, str);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str, Long.valueOf(j), th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeDouble(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        try {
            if (nativeStoreDouble(str, d, this.handle)) {
                super.notifyChangeListeners(this, str);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str, Double.valueOf(d), th);
        }
    }

    private void storeString(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str3 = str;
        try {
            if (nativeStoreString(str3, str2, this.handle)) {
                super.notifyChangeListeners(this, str3);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str3, str2, th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeString(String str, String str2) {
        storeString(str, str2, false);
    }

    private void storeStringSet(String str, Set<String> set, boolean z) {
        try {
            String[] strArr = null;
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            if (set != null) {
                strArr = new String[set.size()];
                set.toArray(strArr);
            }
            if (nativeStoreStringArray(str, strArr, this.handle)) {
                super.notifyChangeListeners(this, str);
            }
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str, set, th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeStringSet(String str, Set<String> set) {
        storeStringSet(str, set, false);
    }

    private void storeStringArray(String str, String[] strArr, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str2 = str;
        try {
            if (nativeStoreStringArray(str2, strArr, this.handle)) {
                super.notifyChangeListeners(this, str2);
            }
        } catch (Throwable th) {
            if (sMonitor != null) {
                sMonitor.reportThrowable(3, this.mName, str2, strArr, th);
            }
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeStringArray(String str, String[] strArr) {
        storeStringArray(str, strArr, false);
    }

    private void storeBytes(String str, byte[] bArr, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str2 = str;
        try {
            if (nativeStoreBytes(str2, bArr, this.handle)) {
                super.notifyChangeListeners(this, str2);
            }
        } catch (Throwable th) {
            if (sMonitor != null) {
                sMonitor.reportThrowable(3, this.mName, str2, bArr, th);
            }
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeBytes(String str, byte[] bArr) {
        storeBytes(str, bArr, false);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeStringJustDisk(String str, String str2) {
        storeString(str, str2, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String str, String[] strArr) {
        storeStringArray(str, strArr, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String str, Set<String> set) {
        storeStringSet(str, set, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void storeBytesJustDisk(String str, byte[] bArr) {
        storeBytes(str, bArr, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void erase(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String str2 = str;
        try {
            nativeErase(str2, this.handle);
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, str2, null, th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public void clear() {
        try {
            nativeClearRepo(this.handle);
        } catch (Throwable th) {
            sMonitor.reportThrowable(3, this.mName, "clear_function", null, th);
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.Keva
    public int count() {
        return nativeGetCount(this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> map) {
        return super.buildNewMap(map);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return super.getAll();
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public int getInt(String str, int i) {
        try {
            return fetchInt(str, i);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, Integer.valueOf(i), th);
            return i;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public long getLong(String str, long j) {
        try {
            return fetchLong(str, j);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, Long.valueOf(j), th);
            return j;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public double getDouble(String str, double d) {
        try {
            return fetchDouble(str, d);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, Double.valueOf(d), th);
            return d;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public float getFloat(String str, float f) {
        try {
            return fetchFloat(str, f);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, Float.valueOf(f), th);
            return f;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public boolean getBoolean(String str, boolean z) {
        try {
            return fetchBoolean(str, z);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, Boolean.valueOf(z), th);
            return z;
        }
    }

    private byte[] getBytes(String str, byte[] bArr, boolean z) {
        try {
            return fetchBytes(str, bArr, -1, z);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, bArr, th);
            return bArr;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public byte[] getBytes(String str, byte[] bArr) {
        return getBytes(str, bArr, false);
    }

    private Set<String> getStringSet(String str, Set<String> set, boolean z) {
        try {
            String[] fetchStringArray = fetchStringArray(str, null, z);
            if (fetchStringArray == null) {
                return set != null ? new HashSet(set) : set;
            }
            return new HashSet(Arrays.asList(fetchStringArray));
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, set, th);
            return set;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public Set<String> getStringSet(String str, Set<String> set) {
        return getStringSet(str, set, false);
    }

    private String[] getStringArray(String str, String[] strArr, boolean z) {
        try {
            String[] fetchStringArray = fetchStringArray(str, null, z);
            return fetchStringArray == null ? strArr : fetchStringArray;
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, strArr, th);
            return strArr;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public String[] getStringArray(String str, String[] strArr) {
        return getStringArray(str, strArr, false);
    }

    private String getString(String str, String str2, boolean z) {
        try {
            return fetchString(str, str2, z);
        } catch (Throwable th) {
            sMonitor.reportThrowable(2, this.mName, str, str2, th);
            return str2;
        }
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public String getString(String str, String str2) {
        return getString(str, str2, false);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public String getStringJustDisk(String str, String str2) {
        return getString(str, str2, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String str, String[] strArr) {
        return getStringArray(str, strArr, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String str, Set<String> set) {
        return getStringSet(str, set, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String str, byte[] bArr) {
        return getBytes(str, bArr, true);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.Keva
    public boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeContains(str, this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected int fetchInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeGetInt(str, i, this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected long fetchLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeGetLong(str, j, this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected float fetchFloat(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeGetFloat(str, f, this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected boolean fetchBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeGetBoolean(str, z, this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected double fetchDouble(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeGetDouble(str, d, this.handle);
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected String fetchString(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        String nativeGetString = nativeGetString(str, this.handle);
        return nativeGetString == null ? str2 : nativeGetString;
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected byte[] fetchBytes(String str, byte[] bArr, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        byte[] nativeGetBytes = nativeGetBytes(str, this.handle);
        return nativeGetBytes == null ? bArr : nativeGetBytes;
    }

    @Override // com.bytedance.keva.KevaPrivateNativeImpl, com.bytedance.keva.KevaImpl
    protected String[] fetchStringArray(String str, String[] strArr, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        return nativeGetStringArray(str, this.handle);
    }
}
