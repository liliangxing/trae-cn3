package androidx.sqlite.p004db;

import java.io.Closeable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i, byte[] bArr);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, String str);

    void clearBindings();
}
