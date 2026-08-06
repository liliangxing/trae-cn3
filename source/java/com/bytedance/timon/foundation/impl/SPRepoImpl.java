package com.bytedance.timon.foundation.impl;

import android.content.SharedPreferences;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SPStoreImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J-\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0017¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0016J#\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0017¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/timon/foundation/impl/SPRepoImpl;", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "clear", "", "contains", "", "key", "", "getAll", "", "getBoolean", "defValue", "getBytes", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "getStringSet", "", "putBoolean", "value", "putBytes", "putFloat", "putInt", "putLong", "putString", "putStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "putStringSet", "remove", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class SPRepoImpl implements IStoreRepo {
    private final SharedPreferences sp;

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public byte[] getBytes(String key, byte[] defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(defValue, "defValue");
        return defValue;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    @Deprecated(message = "return defValue")
    public String[] getStringArray(String key, String[] defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return defValue;
    }

    public SPRepoImpl(SharedPreferences sharedPreferences) {
        this.sp = sharedPreferences;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.putString(key, value);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putInt(String key, int value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.putInt(key, value);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putLong(String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.putLong(key, value);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putFloat(String key, float value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.putFloat(key, value);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putBoolean(String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.putBoolean(key, value);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putStringSet(String key, Set<String> value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.putStringSet(key, value);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    @Deprecated(message = "empty impl")
    public void putStringArray(String key, String[] value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        throw new UnsupportedOperationException("unsupport save stringArray");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void putBytes(String key, byte[] value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        throw new UnsupportedOperationException("unsupport save bytes");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public String getString(String key, String defValue) {
        String string;
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        return (sharedPreferences == null || (string = sharedPreferences.getString(key, defValue)) == null) ? defValue : string;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public int getInt(String key, int defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences != null ? sharedPreferences.getInt(key, defValue) : defValue;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public long getLong(String key, long defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences != null ? sharedPreferences.getLong(key, defValue) : defValue;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public float getFloat(String key, float defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences != null ? sharedPreferences.getFloat(key, defValue) : defValue;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public boolean getBoolean(String key, boolean defValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        return sharedPreferences != null ? sharedPreferences.getBoolean(key, defValue) : defValue;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public Set<String> getStringSet(String key, Set<String> defValue) {
        Set<String> stringSet;
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        return (sharedPreferences == null || (stringSet = sharedPreferences.getStringSet(key, defValue)) == null) ? defValue : stringSet;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void clear() {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.clear();
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
            editor.remove(key);
            editor.apply();
        }
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public boolean contains(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(key);
        }
        return false;
    }
}
