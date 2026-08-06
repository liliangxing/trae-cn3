package com.bytedance.timon.ext.keva;

import com.bytedance.keva.Keva;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KevaStoreImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J-\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0016J#\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0016¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/timon/ext/keva/KevaStoreRepoImpl;", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "keva", "Lcom/bytedance/keva/Keva;", "(Lcom/bytedance/keva/Keva;)V", "clear", "", "contains", "", "key", "", "getAll", "", "getBoolean", "defValue", "getBytes", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "getStringSet", "", "putBoolean", "value", "putBytes", "putFloat", "putInt", "putLong", "putString", "putStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "putStringSet", "remove", "ext-keva_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class KevaStoreRepoImpl implements IStoreRepo {
    private final Keva keva;

    public KevaStoreRepoImpl(Keva keva) {
        Intrinsics.checkParameterIsNotNull(keva, "keva");
        this.keva = keva;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.keva.storeString(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putInt(String key, int value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.keva.storeInt(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putLong(String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.keva.storeLong(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putFloat(String key, float value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.keva.storeFloat(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putBoolean(String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.keva.storeBoolean(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putStringSet(String key, Set<String> value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.keva.storeStringSet(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putStringArray(String key, String[] value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.keva.storeStringArray(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putBytes(String key, byte[] value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.keva.storeBytes(key, value);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public String getString(String key, String defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        String string = this.keva.getString(key, defValue);
        return string != null ? string : defValue;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public int getInt(String key, int defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.getInt(key, defValue);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public long getLong(String key, long defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.getLong(key, defValue);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public float getFloat(String key, float defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.getFloat(key, defValue);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public boolean getBoolean(String key, boolean defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.getBoolean(key, defValue);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public Set<String> getStringSet(String key, Set<String> defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.getStringSet(key, defValue);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public byte[] getBytes(String key, byte[] defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(defValue, "defValue");
        byte[] bytes = this.keva.getBytes(key, defValue);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "keva.getBytes(key, defValue)");
        return bytes;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public Map<String, ?> getAll() {
        return this.keva.getAll();
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public String[] getStringArray(String key, String[] defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.getStringArray(key, defValue);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void clear() {
        this.keva.clear();
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.keva.erase(key);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public boolean contains(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.keva.contains(key);
    }
}
