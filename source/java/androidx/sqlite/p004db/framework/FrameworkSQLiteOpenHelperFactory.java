package androidx.sqlite.p004db.framework;

import androidx.sqlite.p004db.SupportSQLiteOpenHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory);
    }
}
