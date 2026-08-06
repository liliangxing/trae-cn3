package com.bytedance.platform.settingsx.api.internal;

import com.bytedance.platform.settingsx.api.internal.Pools;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProtoUtils {
    private static final Pools.SynchronizedPool<ByteArrayOutputStream> pool = new Pools.SynchronizedPool<>(4);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ReadCallback<T> {
        void onCallback(T t);
    }

    public static ByteArrayOutputStream acquire() {
        ByteArrayOutputStream acquire = pool.acquire();
        return acquire == null ? new ByteArrayOutputStream() : acquire;
    }

    public static void release(ByteArrayOutputStream byteArrayOutputStream) {
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.reset();
            pool.release(byteArrayOutputStream);
        }
    }

    public static void writeIntListToProto(CodedOutputStream codedOutputStream, List<Integer> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    codedOutputStream.writeInt32NoTag(list.size());
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        codedOutputStream.writeInt32NoTag(it.next().intValue());
                    }
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        codedOutputStream.writeInt32NoTag(0);
    }

    public static List<Integer> readProtoToIntList(CodedInputStream codedInputStream) {
        return readProtoToIntList(codedInputStream, null);
    }

    public static List<Integer> readProtoToIntList(CodedInputStream codedInputStream, ReadCallback<Integer> readCallback) {
        try {
            int readInt32 = codedInputStream.readInt32();
            if (readInt32 <= 0 || readInt32 >= 65535) {
                return null;
            }
            ArrayList arrayList = new ArrayList(readInt32);
            for (int i = 0; i < readInt32; i++) {
                int readInt322 = codedInputStream.readInt32();
                if (readCallback != null) {
                    readCallback.onCallback(Integer.valueOf(readInt322));
                }
                arrayList.add(Integer.valueOf(readInt322));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
