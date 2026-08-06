package com.bytedance.android.monitorV2.hybridSetting.localcache;

import kotlin.Metadata;

/* compiled from: ILocalCacheAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/localcache/ILocalCacheAdapter;", "", "clear", "", "getBytes", "", "key", "", "getInt", "", "getLong", "", "putBytes", "value", "putInt", "putLong", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface ILocalCacheAdapter {
    void clear();

    byte[] getBytes(String key);

    int getInt(String key);

    long getLong(String key);

    void putBytes(String key, byte[] value);

    void putInt(String key, int value);

    void putLong(String key, long value);
}
