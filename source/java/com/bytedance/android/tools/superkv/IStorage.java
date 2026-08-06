package com.bytedance.android.tools.superkv;

import com.bytedance.android.tools.superkv.proto.KVProto;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface IStorage {

    /* loaded from: classes3.dex */
    public interface DataInvalidCallback {
        void onAllInvalid();

        void onItemInvalid(String str);
    }

    void ensureUpToDate();

    KVProto get(String str);

    int put(String str, double d);

    int put(String str, float f);

    int put(String str, int i);

    int put(String str, long j);

    int put(String str, String str2);

    int put(String str, List<String> list);

    int put(String str, boolean z);

    int put(String str, byte[] bArr);

    void release();

    void remove(String str);
}
