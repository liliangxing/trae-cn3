package com.bytedance.android.anniex.scene.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.anniex.scene.core.SceneFingerprint;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SceneDbHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/scene/data/SceneDbHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "querySceneCount", "sceneId", "", "saveScene", "scene", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SceneDbHelper extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db, "db");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDbHelper(Context context) {
        super(context, SceneDbContract.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL(StringsKt.trimIndent("\n            CREATE TABLE scenes (\n                scene_id TEXT PRIMARY KEY,\n                timestamp INTEGER,\n                origin TEXT,\n                attach_scene TEXT,\n                count INTEGER DEFAULT 1,\n                view_count INTEGER DEFAULT 0,\n                client_component TEXT\n            )\n        "));
        db.execSQL(StringsKt.trimIndent("\n            CREATE TABLE transitions (\n                from_scene_id TEXT,\n                to_scene_id TEXT,\n                count INTEGER DEFAULT 1,\n                avg_duration INTEGER,\n                last_update INTEGER,\n                PRIMARY KEY (from_scene_id, to_scene_id)\n            )\n        "));
        db.execSQL(StringsKt.trimIndent("\n            CREATE INDEX idx_from_id ON transitions(from_scene_id)\n        "));
    }

    public final void saveScene(SceneFingerprint scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (querySceneCount(scene.getSceneId()) > 0) {
            SQLiteStatement compileStatement = writableDatabase.compileStatement(StringsKt.trimIndent("\n            UPDATE scenes SET\n                count = count + 1,\n                timestamp = ?,\n                attach_scene = ?,\n                origin = ?,\n                view_count = ?,\n                client_component = ?\n            WHERE scene_id = ?\n            "));
            compileStatement.bindLong(1, scene.getTimestamp());
            String attachScene = scene.getAttachScene();
            if (attachScene == null) {
                attachScene = "";
            }
            compileStatement.bindString(2, attachScene);
            compileStatement.bindString(3, scene.getOrigin().name());
            compileStatement.bindLong(4, scene.getViewCount() != null ? r1.intValue() : 0L);
            String clientComponent = scene.getClientComponent();
            compileStatement.bindString(5, clientComponent != null ? clientComponent : "");
            compileStatement.bindString(6, scene.getSceneId());
            compileStatement.executeUpdateDelete();
            compileStatement.close();
            return;
        }
        SQLiteStatement compileStatement2 = writableDatabase.compileStatement(StringsKt.trimIndent("\n            INSERT INTO scenes\n            (scene_id, attach_scene, \n             timestamp, origin, \n             count, view_count,\n             client_component)\n            VALUES (?, ?, ?, ?, 1, ?, ?)\n            "));
        compileStatement2.bindString(1, scene.getSceneId());
        String attachScene2 = scene.getAttachScene();
        if (attachScene2 == null) {
            attachScene2 = "";
        }
        compileStatement2.bindString(2, attachScene2);
        compileStatement2.bindLong(3, scene.getTimestamp());
        compileStatement2.bindString(4, scene.getOrigin().name());
        compileStatement2.bindLong(5, scene.getViewCount() != null ? r1.intValue() : 0L);
        String clientComponent2 = scene.getClientComponent();
        compileStatement2.bindString(6, clientComponent2 != null ? clientComponent2 : "");
        compileStatement2.executeInsert();
        compileStatement2.close();
    }

    public final int querySceneCount(String sceneId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT count FROM scenes WHERE scene_id = ?", new String[]{sceneId});
        try {
            Cursor cursor = rawQuery;
            int i = cursor.moveToFirst() ? cursor.getInt(0) : 0;
            CloseableKt.closeFinally(rawQuery, (Throwable) null);
            return i;
        } finally {
        }
    }
}
