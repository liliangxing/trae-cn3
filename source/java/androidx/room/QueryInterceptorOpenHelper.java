package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.p004db.SupportSQLiteDatabase;
import androidx.sqlite.p004db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final SupportSQLiteOpenHelper mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, RoomDatabase.QueryCallback queryCallback, Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getWritableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getReadableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.p004db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }
}
