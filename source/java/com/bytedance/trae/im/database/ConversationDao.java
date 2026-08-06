package com.bytedance.trae.im.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.Conversation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationDao.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u0014\u0010\u0012\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u000e*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/database/ConversationDao;", "", "dbHelper", "Lcom/bytedance/trae/im/database/DatabaseOpenHelper;", "<init>", "(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V", "insertOrUpdateAll", "", "conversations", "", "Lcom/bytedance/trae/im/service/Conversation;", "queryAll", "queryById", "id", "", "deleteById", "updateTitle", "newTitle", "replaceAll", "clearAll", "cursorToConversation", "cursor", "Landroid/database/Cursor;", "getStringOrNull", "columnName", "getIntOrNull", "", "(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/Integer;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationDao {
    private final DatabaseOpenHelper dbHelper;

    public ConversationDao(DatabaseOpenHelper databaseOpenHelper) {
        Intrinsics.checkNotNullParameter(databaseOpenHelper, "dbHelper");
        this.dbHelper = databaseOpenHelper;
    }

    public final void insertOrUpdateAll(List<Conversation> conversations) {
        Intrinsics.checkNotNullParameter(conversations, "conversations");
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (Conversation conversation : conversations) {
                String id = conversation.getId();
                if (id != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", id);
                    contentValues.put("cli_conversation_id", conversation.getCliConversationId());
                    contentValues.put("user_id", conversation.getUserId());
                    contentValues.put("cli_id", conversation.getCliId());
                    contentValues.put("title", conversation.getTitle());
                    contentValues.put(MessagePart.TYPE_WORKSPACE, conversation.getDisplayWorkspace());
                    contentValues.put("git_uri", conversation.getDisplayGitUri());
                    contentValues.put("mode", conversation.getMode());
                    contentValues.put(PageDataManager.EXTRA_STATUS, conversation.getStatus());
                    contentValues.put("cli_type", conversation.getDisplayEnvironment());
                    contentValues.put("latest_task_id", conversation.getLatestTaskId());
                    contentValues.put("latest_task_status", conversation.getLatestTaskStatus());
                    contentValues.put("latest_task_update_time", conversation.getLatestTaskUpdateTime());
                    contentValues.put("created_at", conversation.getCreatedAt());
                    contentValues.put("updated_at", conversation.getUpdatedAt());
                    contentValues.put("icon_type", conversation.getIconType());
                    contentValues.put("cli_conversation_status", conversation.getCliConversationStatus());
                    contentValues.put("owner_project_id", conversation.getOwnerProjectId());
                    contentValues.put("latest_project_id", conversation.getLatestProjectId());
                    contentValues.put("owner_project_absolute_path", conversation.getOwnerProjectAbsolutePath());
                    contentValues.put("owner_project_workspace_status", conversation.getOwnerProjectWorkSpaceStatus());
                    int i = 1;
                    if (!Intrinsics.areEqual(conversation.isPinned(), true)) {
                        i = 0;
                    }
                    contentValues.put("is_pinned", Integer.valueOf(i));
                    contentValues.put("pinned_at", conversation.getPinnedAt());
                    writableDatabase.insertWithOnConflict("conversation", null, contentValues, 5);
                }
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final List<Conversation> queryAll() {
        ArrayList arrayList = new ArrayList();
        Cursor query = this.dbHelper.getReadableDatabase().query("conversation", null, null, null, null, null, "is_pinned DESC, pinned_at DESC, updated_at DESC");
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            while (cursor2.moveToNext()) {
                arrayList.add(cursorToConversation(cursor2));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return arrayList;
        } finally {
        }
    }

    public final Conversation queryById(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Cursor query = this.dbHelper.getReadableDatabase().query("conversation", null, "id = ?", new String[]{id}, null, null, null, "1");
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst()) {
                Conversation cursorToConversation = cursorToConversation(cursor2);
                CloseableKt.closeFinally(cursor, (Throwable) null);
                return cursorToConversation;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    public final void deleteById(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.dbHelper.getWritableDatabase().delete("conversation", "id = ?", new String[]{id});
    }

    public final void updateTitle(String id, String newTitle) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(newTitle, "newTitle");
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", newTitle);
        this.dbHelper.getWritableDatabase().update("conversation", contentValues, "id = ?", new String[]{id});
    }

    public final void replaceAll(List<Conversation> conversations) {
        Intrinsics.checkNotNullParameter(conversations, "conversations");
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.delete("conversation", null, null);
            for (Conversation conversation : conversations) {
                String id = conversation.getId();
                if (id != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", id);
                    contentValues.put("cli_conversation_id", conversation.getCliConversationId());
                    contentValues.put("user_id", conversation.getUserId());
                    contentValues.put("cli_id", conversation.getCliId());
                    contentValues.put("title", conversation.getTitle());
                    contentValues.put(MessagePart.TYPE_WORKSPACE, conversation.getDisplayWorkspace());
                    contentValues.put("git_uri", conversation.getDisplayGitUri());
                    contentValues.put("mode", conversation.getMode());
                    contentValues.put(PageDataManager.EXTRA_STATUS, conversation.getStatus());
                    contentValues.put("cli_type", conversation.getDisplayEnvironment());
                    contentValues.put("latest_task_id", conversation.getLatestTaskId());
                    contentValues.put("latest_task_status", conversation.getLatestTaskStatus());
                    contentValues.put("latest_task_update_time", conversation.getLatestTaskUpdateTime());
                    contentValues.put("created_at", conversation.getCreatedAt());
                    contentValues.put("updated_at", conversation.getUpdatedAt());
                    contentValues.put("icon_type", conversation.getIconType());
                    contentValues.put("cli_conversation_status", conversation.getCliConversationStatus());
                    contentValues.put("owner_project_id", conversation.getOwnerProjectId());
                    contentValues.put("latest_project_id", conversation.getLatestProjectId());
                    contentValues.put("owner_project_absolute_path", conversation.getOwnerProjectAbsolutePath());
                    contentValues.put("owner_project_workspace_status", conversation.getOwnerProjectWorkSpaceStatus());
                    int i = 1;
                    if (!Intrinsics.areEqual(conversation.isPinned(), true)) {
                        i = 0;
                    }
                    contentValues.put("is_pinned", Integer.valueOf(i));
                    contentValues.put("pinned_at", conversation.getPinnedAt());
                    writableDatabase.insertWithOnConflict("conversation", null, contentValues, 5);
                }
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void clearAll() {
        this.dbHelper.getWritableDatabase().delete("conversation", null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0095, code lost:
    
        if (r2.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Conversation cursorToConversation(Cursor cursor) {
        String stringOrNull = getStringOrNull(cursor, "cli_conversation_id");
        String stringOrNull2 = getStringOrNull(cursor, "id");
        String stringOrNull3 = getStringOrNull(cursor, "user_id");
        String stringOrNull4 = getStringOrNull(cursor, "cli_id");
        String stringOrNull5 = getStringOrNull(cursor, "title");
        String stringOrNull6 = getStringOrNull(cursor, MessagePart.TYPE_WORKSPACE);
        String stringOrNull7 = getStringOrNull(cursor, "git_uri");
        String stringOrNull8 = getStringOrNull(cursor, "mode");
        String stringOrNull9 = getStringOrNull(cursor, PageDataManager.EXTRA_STATUS);
        String stringOrNull10 = getStringOrNull(cursor, "cli_type");
        String stringOrNull11 = getStringOrNull(cursor, "latest_task_id");
        String stringOrNull12 = getStringOrNull(cursor, "latest_task_status");
        String stringOrNull13 = getStringOrNull(cursor, "latest_task_update_time");
        String stringOrNull14 = getStringOrNull(cursor, "created_at");
        String stringOrNull15 = getStringOrNull(cursor, "updated_at");
        String stringOrNull16 = getStringOrNull(cursor, "icon_type");
        Integer intOrNull = getIntOrNull(cursor, "cli_conversation_status");
        String stringOrNull17 = getStringOrNull(cursor, "owner_project_id");
        String stringOrNull18 = getStringOrNull(cursor, "latest_project_id");
        String stringOrNull19 = getStringOrNull(cursor, "owner_project_absolute_path");
        String stringOrNull20 = getStringOrNull(cursor, "owner_project_workspace_status");
        Integer intOrNull2 = getIntOrNull(cursor, "is_pinned");
        boolean z = intOrNull2 != null;
        return new Conversation(stringOrNull2, null, null, stringOrNull, stringOrNull3, stringOrNull4, stringOrNull5, stringOrNull6, stringOrNull7, stringOrNull8, stringOrNull9, stringOrNull10, stringOrNull11, stringOrNull12, stringOrNull13, stringOrNull14, stringOrNull15, null, stringOrNull16, intOrNull, stringOrNull17, stringOrNull18, stringOrNull19, stringOrNull20, Boolean.valueOf(z), getStringOrNull(cursor, "pinned_at"), 131078, null);
    }

    private final String getStringOrNull(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    private final Integer getIntOrNull(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(columnIndex));
    }
}
