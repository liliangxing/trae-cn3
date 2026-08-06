package com.bytedance.platform.settingsx.api.storage;

import com.bytedance.platform.settingsx.api.map.MappedData;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IBlock {
    void clear();

    boolean contains(int i);

    Map<Integer, ?> getAll();

    byte[] getBytes(int i, byte[] bArr);

    int getCount();

    String getName();

    List<MappedData> getObject(int i, List<MappedData> list);

    void putBytes(int i, byte[] bArr);

    void putObject(int i, List<MappedData> list);

    void remove(int i);

    void sync();
}
