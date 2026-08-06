package androidx.sqlite.p004db;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface SupportSQLiteStatement extends SupportSQLiteProgram {
    void execute();

    long executeInsert();

    int executeUpdateDelete();

    long simpleQueryForLong();

    String simpleQueryForString();
}
