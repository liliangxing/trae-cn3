package com.bytedance.trae.im.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatabaseSchema.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0000¢\u0006\u0002\b\"J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/trae/im/database/DatabaseSchema;", "", "<init>", "()V", "DB_NAME", "", "CONVERSATION_COMPATIBILITY_COLUMNS", "", "createAll", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "dropAll", "CREATE_CONVERSATION_TABLE", "getCREATE_CONVERSATION_TABLE", "()Ljava/lang/String;", "CREATE_STATEMENTS", "", "DROP_STATEMENTS", "MIGRATION_1_TO_2", "getMIGRATION_1_TO_2", "()Ljava/util/List;", "MIGRATION_2_TO_3", "getMIGRATION_2_TO_3", "MIGRATION_3_TO_4", "getMIGRATION_3_TO_4", "upgradeStatementsBeforeConversationCompatibility", "oldVersion", "", "upgradeStatementsBeforeConversationCompatibility$im_mainlandRelease", "migrateConversationCompatibilityColumns", "missingConversationCompatibilityColumns", "existingColumns", "", "missingConversationCompatibilityColumns$im_mainlandRelease", "queryConversationColumns", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DatabaseSchema {
    public static final String DB_NAME = "im.db";
    public static final DatabaseSchema INSTANCE = new DatabaseSchema();
    private static final Map<String, String> CONVERSATION_COMPATIBILITY_COLUMNS = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("cli_conversation_status", "INTEGER"), TuplesKt.to("owner_project_id", "TEXT"), TuplesKt.to("latest_project_id", "TEXT"), TuplesKt.to("owner_project_absolute_path", "TEXT"), TuplesKt.to("owner_project_name", "TEXT"), TuplesKt.to("owner_project_workspace_status", "TEXT"), TuplesKt.to("is_pinned", "INTEGER NOT NULL DEFAULT 0"), TuplesKt.to("pinned_at", "TEXT")});
    private static final String CREATE_CONVERSATION_TABLE = "    CREATE TABLE IF NOT EXISTS conversation (\n    id TEXT NOT NULL PRIMARY KEY,\n    cli_conversation_id TEXT,\n    user_id TEXT,\n    cli_id TEXT,\n    title TEXT,\n    workspace TEXT,\n    git_uri TEXT,\n    mode TEXT,\n    status TEXT,\n    cli_type TEXT,\n    latest_task_id TEXT,\n    latest_task_status TEXT,\n    latest_task_update_time TEXT,\n    created_at TEXT,\n    updated_at TEXT,\n    icon_type TEXT,\n    cli_conversation_status INTEGER,\n    owner_project_id TEXT,\n    latest_project_id TEXT,\n    owner_project_absolute_path TEXT,\n    owner_project_name TEXT,\n    owner_project_workspace_status TEXT,\n    is_pinned INTEGER NOT NULL DEFAULT 0,\n    pinned_at TEXT,\n    cached_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))\n)";
    private static final List<String> CREATE_STATEMENTS = CollectionsKt.listOf(new String[]{"    CREATE TABLE IF NOT EXISTS chat_message (\n    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n    task_id TEXT NOT NULL,\n    message_id TEXT NOT NULL,\n    message_type TEXT NOT NULL,\n    message_index INTEGER NOT NULL,\n    content TEXT NOT NULL,\n    status INTEGER NOT NULL DEFAULT 0,\n    created_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now')),\n    updated_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now')),\n    deleted_at INTEGER NOT NULL DEFAULT 0,\n    revertible INTEGER NOT NULL DEFAULT 0\n)", "    CREATE TABLE IF NOT EXISTS conversation (\n    id TEXT NOT NULL PRIMARY KEY,\n    cli_conversation_id TEXT,\n    user_id TEXT,\n    cli_id TEXT,\n    title TEXT,\n    workspace TEXT,\n    git_uri TEXT,\n    mode TEXT,\n    status TEXT,\n    cli_type TEXT,\n    latest_task_id TEXT,\n    latest_task_status TEXT,\n    latest_task_update_time TEXT,\n    created_at TEXT,\n    updated_at TEXT,\n    icon_type TEXT,\n    cli_conversation_status INTEGER,\n    owner_project_id TEXT,\n    latest_project_id TEXT,\n    owner_project_absolute_path TEXT,\n    owner_project_name TEXT,\n    owner_project_workspace_status TEXT,\n    is_pinned INTEGER NOT NULL DEFAULT 0,\n    pinned_at TEXT,\n    cached_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))\n)", "    CREATE TABLE IF NOT EXISTS conversation_detail (\n    conversation_id TEXT NOT NULL,\n    message_id      TEXT NOT NULL,\n    message_index   INTEGER DEFAULT 0,\n    role            TEXT NOT NULL,\n    content_type    TEXT NOT NULL,\n    content         TEXT ,\n    status          TEXT,\n    created_at      INTEGER NOT NULL DEFAULT 0,\n    updated_at      INTEGER NOT NULL DEFAULT (strftime('%s','now') * 1000),\n    PRIMARY KEY (conversation_id, message_id)\n)"});
    private static final List<String> DROP_STATEMENTS = CollectionsKt.listOf(new String[]{"DROP TABLE IF EXISTS chat_message", "DROP TABLE IF EXISTS conversation", "DROP TABLE IF EXISTS conversation_detail"});
    private static final List<String> MIGRATION_1_TO_2 = CollectionsKt.listOf("    CREATE TABLE IF NOT EXISTS conversation (\n    id TEXT NOT NULL PRIMARY KEY,\n    cli_conversation_id TEXT,\n    user_id TEXT,\n    cli_id TEXT,\n    title TEXT,\n    workspace TEXT,\n    git_uri TEXT,\n    mode TEXT,\n    status TEXT,\n    cli_type TEXT,\n    latest_task_id TEXT,\n    latest_task_status TEXT,\n    latest_task_update_time TEXT,\n    created_at TEXT,\n    updated_at TEXT,\n    cached_at INTEGER NOT NULL DEFAULT (strftime('%s', 'now'))\n)");
    private static final List<String> MIGRATION_2_TO_3 = CollectionsKt.listOf("ALTER TABLE conversation ADD COLUMN icon_type TEXT");
    private static final List<String> MIGRATION_3_TO_4 = CollectionsKt.listOf("    CREATE TABLE IF NOT EXISTS conversation_detail (\n    conversation_id TEXT NOT NULL,\n    message_id      TEXT NOT NULL,\n    message_index   INTEGER DEFAULT 0,\n    role            TEXT NOT NULL,\n    content_type    TEXT NOT NULL,\n    content         TEXT ,\n    status          TEXT,\n    created_at      INTEGER NOT NULL DEFAULT 0,\n    updated_at      INTEGER NOT NULL DEFAULT (strftime('%s','now') * 1000),\n    PRIMARY KEY (conversation_id, message_id)\n)");

    private DatabaseSchema() {
    }

    public final void createAll(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        Iterator<String> it = CREATE_STATEMENTS.iterator();
        while (it.hasNext()) {
            db.execSQL(it.next());
        }
    }

    public final void dropAll(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        Iterator<String> it = DROP_STATEMENTS.iterator();
        while (it.hasNext()) {
            db.execSQL(it.next());
        }
    }

    public final String getCREATE_CONVERSATION_TABLE() {
        return CREATE_CONVERSATION_TABLE;
    }

    public final List<String> getMIGRATION_1_TO_2() {
        return MIGRATION_1_TO_2;
    }

    public final List<String> getMIGRATION_2_TO_3() {
        return MIGRATION_2_TO_3;
    }

    public final List<String> getMIGRATION_3_TO_4() {
        return MIGRATION_3_TO_4;
    }

    /* renamed from: upgradeStatementsBeforeConversationCompatibility$im_mainlandRelease */
    public final List<String> m882x779d7cde(int oldVersion) {
        ArrayList arrayList = new ArrayList();
        if (oldVersion < 2) {
            CollectionsKt.addAll(arrayList, MIGRATION_1_TO_2);
        }
        if (oldVersion < 3) {
            CollectionsKt.addAll(arrayList, MIGRATION_2_TO_3);
        }
        if (oldVersion < 4) {
            CollectionsKt.addAll(arrayList, MIGRATION_3_TO_4);
        }
        return arrayList;
    }

    public final void migrateConversationCompatibilityColumns(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        for (String str : missingConversationCompatibilityColumns$im_mainlandRelease(queryConversationColumns(db))) {
            db.execSQL("ALTER TABLE conversation ADD COLUMN " + str + ' ' + ((String) MapsKt.getValue(CONVERSATION_COMPATIBILITY_COLUMNS, str)));
        }
    }

    public final List<String> missingConversationCompatibilityColumns$im_mainlandRelease(Set<String> existingColumns) {
        Intrinsics.checkNotNullParameter(existingColumns, "existingColumns");
        Set<String> keySet = CONVERSATION_COMPATIBILITY_COLUMNS.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (!existingColumns.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final Set<String> queryConversationColumns(SQLiteDatabase db) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Cursor rawQuery = db.rawQuery("PRAGMA table_info(conversation)", null);
        Intrinsics.checkNotNullExpressionValue(rawQuery, "rawQuery(...)");
        Cursor cursor = rawQuery;
        try {
            Cursor cursor2 = cursor;
            int columnIndex = cursor2.getColumnIndex("name");
            while (columnIndex >= 0 && cursor2.moveToNext()) {
                String string = cursor2.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                linkedHashSet.add(string);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return linkedHashSet;
        } finally {
        }
    }
}
