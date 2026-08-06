package com.bytedance.android.anniex.scene.data;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.core.SceneFingerprint;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.android.anniex.scene.utils.CompressionUtils;
import com.bytedance.android.anniex.scene.utils.SceneLoggerUtils;
import com.bytedance.ies.bullet.core.BulletEnv;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SceneDbManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010$\u001a\u00020\bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/anniex/scene/data/SceneDbManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CLEAN_THRESHOLD", "", "DATA_EXPIRE_MS", "", "SCENE_MAX_COUNT", "TRANSITION_MAX_COUNT", "TRANS_THRESHOLD", "dbHelper", "Lcom/bytedance/android/anniex/scene/data/SceneDbHelper;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "transitionBuffer", "", "Lkotlin/Triple;", "", "writeCounter", "autoCleanScenes", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "autoCleanTransitions", "flushTransitions", "", "getRowCount", "table", "reportSqliteStatus", "saveSceneAndGetStats", "Lcom/bytedance/android/anniex/scene/data/SceneQueryInfo;", "scene", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "fromId", "durationMs", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SceneDbManager {
    private final int CLEAN_THRESHOLD;
    private final long DATA_EXPIRE_MS;
    private final int SCENE_MAX_COUNT;
    private final int TRANSITION_MAX_COUNT;
    private final int TRANS_THRESHOLD;
    private final SceneDbHelper dbHelper;
    private final ReentrantLock lock;
    private final List<Triple<String, String, Long>> transitionBuffer;
    private int writeCounter;

    public SceneDbManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.dbHelper = new SceneDbHelper(context);
        this.lock = new ReentrantLock();
        this.SCENE_MAX_COUNT = SwitchCenter.INSTANCE.getSceneTableMaxCount();
        this.TRANSITION_MAX_COUNT = SwitchCenter.INSTANCE.getTransitionTableMaxCount();
        this.DATA_EXPIRE_MS = SwitchCenter.INSTANCE.getSqliteDataExpireMs();
        this.transitionBuffer = new ArrayList();
        this.CLEAN_THRESHOLD = SwitchCenter.INSTANCE.getSqliteCleanThreshold();
        this.TRANS_THRESHOLD = SwitchCenter.INSTANCE.getSqliteTransFlushThreshold();
    }

    public static /* synthetic */ SceneQueryInfo saveSceneAndGetStats$default(SceneDbManager sceneDbManager, SceneFingerprint sceneFingerprint, String str, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return sceneDbManager.saveSceneAndGetStats(sceneFingerprint, str, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SceneQueryInfo saveSceneAndGetStats(final SceneFingerprint scene, String fromId, long durationMs) {
        String message;
        int i;
        Cursor cursor;
        Cursor cursor2;
        int i2;
        double d;
        Intrinsics.checkNotNullParameter(scene, "scene");
        SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$saveSceneAndGetStats$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "场景数据入库 scene 解码后:" + CompressionUtils.INSTANCE.decompressSceneId(SceneFingerprint.this.getSceneId());
            }
        });
        final long currentTimeMillis = System.currentTimeMillis();
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            writableDatabase.beginTransaction();
            int i3 = 0;
            try {
                try {
                    this.dbHelper.saveScene(scene);
                    if (fromId != null) {
                        try {
                            this.transitionBuffer.add(new Triple<>(fromId, scene.getSceneId(), Long.valueOf(durationMs)));
                        } catch (Exception e) {
                            e = e;
                            SceneConnectCenter sceneConnectCenter = SceneConnectCenter.INSTANCE;
                            message = e.getMessage();
                            if (message == null) {
                            }
                            sceneConnectCenter.reportSqliteError(message);
                            writableDatabase.endTransaction();
                            i = i3;
                            Unit unit = Unit.INSTANCE;
                            reentrantLock.unlock();
                            SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$saveSceneAndGetStats$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "保存场景数据耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms";
                                }
                            });
                            return new SceneQueryInfo(i, linkedHashMap);
                        }
                    }
                    i = this.dbHelper.querySceneCount(scene.getSceneId());
                } catch (Exception e2) {
                    e = e2;
                    i3 = 0;
                }
                try {
                    int i4 = 1;
                    Cursor rawQuery = writableDatabase.rawQuery(StringsKt.trimIndent("\n                        SELECT to_scene_id,\n                         count,\n                         (SELECT SUM(count)\n                         FROM transitions\n                         WHERE from_scene_id = ?) as total\n                         FROM transitions\n                         WHERE from_scene_id = ?\n                     "), new String[]{scene.getSceneId(), scene.getSceneId()});
                    try {
                        Cursor cursor3 = rawQuery;
                        while (cursor3.moveToNext()) {
                            String string = cursor3.getString(i3);
                            int i5 = cursor3.getInt(i4);
                            int i6 = cursor3.getInt(2);
                            cursor2 = rawQuery;
                            if (i6 > 0) {
                                i2 = i5;
                                d = i5 / i6;
                            } else {
                                i2 = i5;
                                d = 0.0d;
                            }
                            try {
                                Intrinsics.checkNotNullExpressionValue(string, "toId");
                                linkedHashMap.put(string, TuplesKt.to(Integer.valueOf(i2), Double.valueOf(d)));
                                rawQuery = cursor2;
                                i3 = 0;
                                i4 = 1;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                Throwable th2 = th;
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    CloseableKt.closeFinally(cursor, th2);
                                    throw th3;
                                }
                            }
                        }
                        cursor2 = rawQuery;
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursor2, (Throwable) null);
                        int i7 = this.writeCounter + 1;
                        this.writeCounter = i7;
                        if (i7 % this.TRANS_THRESHOLD == 0) {
                            Intrinsics.checkNotNullExpressionValue(writableDatabase, "db");
                            flushTransitions(writableDatabase);
                        }
                        if (this.writeCounter % this.CLEAN_THRESHOLD == 0) {
                            Intrinsics.checkNotNullExpressionValue(writableDatabase, "db");
                            boolean autoCleanScenes = autoCleanScenes(writableDatabase);
                            boolean autoCleanTransitions = autoCleanTransitions(writableDatabase);
                            if (autoCleanScenes || autoCleanTransitions) {
                                reportSqliteStatus(writableDatabase);
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (Throwable th4) {
                        th = th4;
                        cursor = rawQuery;
                    }
                } catch (Exception e3) {
                    e = e3;
                    i3 = i;
                    SceneConnectCenter sceneConnectCenter2 = SceneConnectCenter.INSTANCE;
                    message = e.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    sceneConnectCenter2.reportSqliteError(message);
                    writableDatabase.endTransaction();
                    i = i3;
                    Unit unit3 = Unit.INSTANCE;
                    reentrantLock.unlock();
                    SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$saveSceneAndGetStats$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "保存场景数据耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms";
                        }
                    });
                    return new SceneQueryInfo(i, linkedHashMap);
                }
                Unit unit32 = Unit.INSTANCE;
                reentrantLock.unlock();
                SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$saveSceneAndGetStats$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "保存场景数据耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms";
                    }
                });
                return new SceneQueryInfo(i, linkedHashMap);
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    private final void flushTransitions(SQLiteDatabase db) {
        long j;
        for (Triple<String, String, Long> triple : this.transitionBuffer) {
            String str = (String) triple.component1();
            String str2 = (String) triple.component2();
            long longValue = ((Number) triple.component3()).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            Cursor rawQuery = db.rawQuery(StringsKt.trimIndent("\n            SELECT count, avg_duration\n            FROM transitions\n            WHERE from_scene_id = ? AND to_scene_id = ?\n            "), new String[]{str, str2});
            try {
                Cursor cursor = rawQuery;
                if (cursor.moveToFirst()) {
                    i = cursor.getInt(0);
                    j = cursor.getLong(1);
                } else {
                    j = 0;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(rawQuery, (Throwable) null);
                if (i > 0) {
                    long j2 = (j * i) + longValue;
                    long j3 = i + 1;
                    SQLiteStatement compileStatement = db.compileStatement(StringsKt.trimIndent("\n                UPDATE transitions SET\n                    count = ?,\n                    last_update = ?,\n                    avg_duration = ?\n                WHERE from_scene_id = ? AND to_scene_id = ?\n                "));
                    compileStatement.bindLong(1, j3);
                    compileStatement.bindLong(2, currentTimeMillis);
                    compileStatement.bindLong(3, j2 / j3);
                    compileStatement.bindString(4, str);
                    compileStatement.bindString(5, str2);
                    compileStatement.executeUpdateDelete();
                    compileStatement.close();
                } else {
                    SQLiteStatement compileStatement2 = db.compileStatement(StringsKt.trimIndent("\n                INSERT INTO transitions\n                (from_scene_id, to_scene_id,\n                 count, last_update,\n                 avg_duration)\n                VALUES (?, ?, 1, ?, ?)\n                "));
                    compileStatement2.bindString(1, str);
                    compileStatement2.bindString(2, str2);
                    compileStatement2.bindLong(3, currentTimeMillis);
                    compileStatement2.bindLong(4, longValue);
                    compileStatement2.executeInsert();
                    compileStatement2.close();
                }
            } finally {
            }
        }
        this.transitionBuffer.clear();
    }

    private final boolean autoCleanScenes(SQLiteDatabase db) {
        db.execSQL("DELETE FROM scenes WHERE timestamp < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.DATA_EXPIRE_MS)});
        Cursor rawQuery = db.rawQuery("SELECT COUNT(*) FROM scenes", null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst() && cursor.getInt(0) > this.SCENE_MAX_COUNT) {
                db.execSQL(StringsKt.trimIndent("\n                    DELETE FROM scenes\n                    WHERE scene_id IN (\n                        SELECT scene_id\n                        FROM scenes\n                        ORDER BY timestamp ASC\n                        LIMIT " + (cursor.getInt(0) - this.SCENE_MAX_COUNT) + "\n                    )\n                "));
                SceneLoggerUtils.INSTANCE.warningLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$autoCleanScenes$1$1
                    public final String invoke() {
                        return "触发场景清理： autoCleanScenes";
                    }
                });
                CloseableKt.closeFinally(rawQuery, (Throwable) null);
                return true;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rawQuery, (Throwable) null);
            return false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(rawQuery, th);
                throw th2;
            }
        }
    }

    private final boolean autoCleanTransitions(SQLiteDatabase db) {
        db.execSQL("DELETE FROM transitions WHERE last_update < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.DATA_EXPIRE_MS)});
        Cursor rawQuery = db.rawQuery("SELECT COUNT(*) FROM transitions", null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst() && cursor.getInt(0) > this.TRANSITION_MAX_COUNT) {
                db.execSQL(StringsKt.trimIndent("\n                    DELETE FROM transitions\n                    WHERE rowid IN (\n                        SELECT rowid FROM transitions\n                        ORDER BY last_update ASC\n                        LIMIT " + (cursor.getInt(0) - this.TRANSITION_MAX_COUNT) + "\n                    )\n                "));
                SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$autoCleanTransitions$1$1
                    public final String invoke() {
                        return "触发跳转清理： autoCleanTransitions";
                    }
                });
                CloseableKt.closeFinally(rawQuery, (Throwable) null);
                return true;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rawQuery, (Throwable) null);
            return false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(rawQuery, th);
                throw th2;
            }
        }
    }

    private final void reportSqliteStatus(SQLiteDatabase db) {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null) {
            final long length = application.getDatabasePath(SceneDbContract.DATABASE_NAME).length();
            final long j = length / 1024;
            final int rowCount = getRowCount(db, SceneDbContract.Scenes.TABLE_NAME);
            final int rowCount2 = getRowCount(db, SceneDbContract.Transitions.TABLE_NAME);
            SceneConnectCenter.INSTANCE.reportSqliteStatus(rowCount, rowCount2, (int) j);
            SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.data.SceneDbManager$reportSqliteStatus$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "数据库实时大小：" + j + "kb, " + length + "byte, sceneTableCount:" + rowCount + ", transTableCount:" + rowCount2;
                }
            });
        }
    }

    private final int getRowCount(SQLiteDatabase db, String table) {
        Cursor rawQuery = db.rawQuery("SELECT COUNT(*) FROM " + table, null);
        try {
            Cursor cursor = rawQuery;
            int i = cursor.moveToFirst() ? cursor.getInt(0) : 0;
            CloseableKt.closeFinally(rawQuery, (Throwable) null);
            return i;
        } finally {
        }
    }
}
