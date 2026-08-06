package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* compiled from: AnniexMonitorFoundationInterfaceIStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\nj\u0002`\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H&J\u001c\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0012\u001a\u00060\nj\u0002`\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\rH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/salamander/anniex/IStorage;", "", "clear", "", "getBoolean", "", "k", "", "defaultValue", "getBytes", "", "Lcom/bytedance/salamander/anniex/AnnieXByteArray;", "getInt", "", "getLong", "", "getString", "putBoolean", "value", "putBytes", "putInt", "putLong", "putString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IStorage {
    void clear();

    boolean getBoolean(String k, boolean defaultValue);

    byte[] getBytes(String k, byte[] defaultValue);

    int getInt(String k, int defaultValue);

    long getLong(String k, long defaultValue);

    String getString(String k, String defaultValue);

    void putBoolean(String k, boolean value);

    void putBytes(String k, byte[] value);

    void putInt(String k, int value);

    void putLong(String k, long value);

    void putString(String k, String value);
}
