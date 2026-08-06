package com.bytedance.applog.adaptor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes3.dex */
class EmptyDbOpenHelper extends SQLiteOpenHelper {
    private volatile int oldVersion;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmptyDbOpenHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, Integer.MAX_VALUE);
        this.oldVersion = Integer.MAX_VALUE;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.oldVersion = i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.oldVersion = i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        sQLiteDatabase.setVersion(this.oldVersion);
    }
}
