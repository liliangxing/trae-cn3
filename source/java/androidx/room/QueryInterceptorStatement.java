package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.p004db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache = new ArrayList();
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, RoomDatabase.QueryCallback queryCallback, String str, Executor executor) {
        this.mDelegate = supportSQLiteStatement;
        this.mQueryCallback = queryCallback;
        this.mSqlStatement = str;
        this.mQueryCallbackExecutor = executor;
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteStatement
    public void execute() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.m3016lambda$execute$0$androidxroomQueryInterceptorStatement();
            }
        });
        this.mDelegate.execute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$execute$0$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    public /* synthetic */ void m3016lambda$execute$0$androidxroomQueryInterceptorStatement() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.m73x7bfa4cf9();
            }
        });
        return this.mDelegate.executeUpdateDelete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$executeUpdateDelete$1$androidx-room-QueryInterceptorStatement */
    public /* synthetic */ void m73x7bfa4cf9() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteStatement
    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.m3017lambda$executeInsert$2$androidxroomQueryInterceptorStatement();
            }
        });
        return this.mDelegate.executeInsert();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$executeInsert$2$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    public /* synthetic */ void m3017lambda$executeInsert$2$androidxroomQueryInterceptorStatement() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$simpleQueryForLong$3$androidx-room-QueryInterceptorStatement */
    public /* synthetic */ void m74xa983133b() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.m74xa983133b();
            }
        });
        return this.mDelegate.simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$simpleQueryForString$4$androidx-room-QueryInterceptorStatement */
    public /* synthetic */ void m75x12aaf991() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.this.m75x12aaf991();
            }
        });
        return this.mDelegate.simpleQueryForString();
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteProgram
    public void bindNull(int i) {
        saveArgsToCache(i, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(i);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        saveArgsToCache(i, Long.valueOf(j));
        this.mDelegate.bindLong(i, j);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        saveArgsToCache(i, Double.valueOf(d));
        this.mDelegate.bindDouble(i, d);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        saveArgsToCache(i, str);
        this.mDelegate.bindString(i, str);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        saveArgsToCache(i, bArr);
        this.mDelegate.bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    private void saveArgsToCache(int i, Object obj) {
        int i2 = i - 1;
        if (i2 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i2; size++) {
                this.mBindArgsCache.add(null);
            }
        }
        this.mBindArgsCache.set(i2, obj);
    }
}
