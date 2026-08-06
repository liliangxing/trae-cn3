package com.bytedance.salamander.anniex;

import com.bytedance.keva.Keva;
import com.bytedance.rts.foundation.Int32;
import com.bytedance.rts.foundation.RTSIntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorFoundationImplStorageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J \u0010\f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\rj\u0002`\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\n\u0010\u0015\u001a\u00060\rj\u0002`\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/salamander/anniex/StorageImpl;", "Lcom/bytedance/salamander/anniex/IStorage;", "()V", "keva", "Lcom/bytedance/keva/Keva;", "clear", "", "getBoolean", "", "key", "", "defaultValue", "getBytes", "", "Lcom/bytedance/salamander/anniex/AnnieXByteArray;", "getInt", "", "getLong", "", "getString", "putBoolean", "value", "putBytes", "putInt", "putLong", "putString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class StorageImpl implements IStorage {
    private Keva keva = Keva.getRepo("salamander_anniex", 1);

    @Override // com.bytedance.salamander.anniex.IStorage
    public void putInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Keva keva = this.keva;
        if (keva != null) {
            keva.storeInt(key, Int32.INSTANCE.toInt(value));
        }
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public int getInt(String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Keva keva = this.keva;
        return RTSIntKt.toInt32(IntCompanionObject.INSTANCE, keva != null ? keva.getInt(key, Int32.INSTANCE.toInt(defaultValue)) : Int32.INSTANCE.toInt(defaultValue));
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public void putLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Keva keva = this.keva;
        if (keva != null) {
            keva.storeLong(key, value);
        }
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public long getLong(String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Keva keva = this.keva;
        return keva != null ? keva.getLong(key, defaultValue) : defaultValue;
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Keva keva = this.keva;
        if (keva != null) {
            keva.storeString(key, value);
        }
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public String getString(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Keva keva = this.keva;
        String string = keva != null ? keva.getString(key, defaultValue) : null;
        return string == null ? defaultValue : string;
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public void putBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Keva keva = this.keva;
        if (keva != null) {
            keva.storeBoolean(key, value);
        }
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Keva keva = this.keva;
        return keva != null ? keva.getBoolean(key, defaultValue) : defaultValue;
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public void putBytes(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Keva keva = this.keva;
        if (keva != null) {
            keva.storeBytes(key, value);
        }
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public byte[] getBytes(String key, byte[] defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Keva keva = this.keva;
        byte[] bytes = keva != null ? keva.getBytes(key, defaultValue) : null;
        return bytes == null ? defaultValue : bytes;
    }

    @Override // com.bytedance.salamander.anniex.IStorage
    public void clear() {
        Keva keva = this.keva;
        if (keva != null) {
            keva.clear();
        }
    }
}
