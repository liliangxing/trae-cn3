package com.bytedance.trae.im.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationDetailDao.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fJ\u001c\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0011J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u0004\u0018\u00010\u000f*\u00020 2\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/im/database/ConversationDetailDao;", "", "dbHelper", "Lcom/bytedance/trae/im/database/DatabaseOpenHelper;", "<init>", "(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V", "insertOrReplace", "", "entity", "Lcom/bytedance/trae/im/database/ConversationDetailEntity;", "insertOrReplaceAll", "entities", "", "queryLatest", "conversationId", "", "limit", "", "deleteByConversationId", "deleteByMessageId", "messageId", "deleteByMessageIds", "messageIds", "replaceAllForConversation", "deleteAll", "getTotalCount", "trimOldConversations", "maxRows", "toContentValues", "Landroid/content/ContentValues;", "cursorToEntity", "cursor", "Landroid/database/Cursor;", "getStringOrNull", "columnName", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationDetailDao {
    private final DatabaseOpenHelper dbHelper;

    public ConversationDetailDao(DatabaseOpenHelper databaseOpenHelper) {
        Intrinsics.checkNotNullParameter(databaseOpenHelper, "dbHelper");
        this.dbHelper = databaseOpenHelper;
    }

    public final void insertOrReplace(ConversationDetailEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.dbHelper.getWritableDatabase().insertWithOnConflict("conversation_detail", null, toContentValues(entity), 5);
    }

    public final void insertOrReplaceAll(List<ConversationDetailEntity> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<ConversationDetailEntity> it = entities.iterator();
            while (it.hasNext()) {
                writableDatabase.insertWithOnConflict("conversation_detail", null, toContentValues(it.next()), 5);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public static /* synthetic */ List queryLatest$default(ConversationDetailDao conversationDetailDao, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return conversationDetailDao.queryLatest(str, i);
    }

    public final List<ConversationDetailEntity> queryLatest(String conversationId, int limit) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        ArrayList arrayList = new ArrayList();
        Cursor query = this.dbHelper.getReadableDatabase().query("conversation_detail", null, "conversation_id = ?", new String[]{conversationId}, null, null, "created_at DESC", String.valueOf(limit));
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            while (cursor2.moveToNext()) {
                arrayList.add(cursorToEntity(cursor2));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return arrayList;
        } finally {
        }
    }

    public final void deleteByConversationId(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        this.dbHelper.getWritableDatabase().delete("conversation_detail", "conversation_id = ?", new String[]{conversationId});
    }

    public final void deleteByMessageId(String conversationId, String messageId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        this.dbHelper.getWritableDatabase().delete("conversation_detail", "conversation_id = ? AND message_id = ?", new String[]{conversationId, messageId});
    }

    public final void deleteByMessageIds(String conversationId, List<String> messageIds) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        if (messageIds.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<String> it = messageIds.iterator();
            while (it.hasNext()) {
                writableDatabase.delete("conversation_detail", "conversation_id = ? AND message_id = ?", new String[]{conversationId, it.next()});
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void replaceAllForConversation(String conversationId, List<ConversationDetailEntity> entities) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(entities, "entities");
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.delete("conversation_detail", "conversation_id = ?", new String[]{conversationId});
            Iterator<ConversationDetailEntity> it = entities.iterator();
            while (it.hasNext()) {
                writableDatabase.insertWithOnConflict("conversation_detail", null, toContentValues(it.next()), 5);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void deleteAll() {
        this.dbHelper.getWritableDatabase().delete("conversation_detail", null, null);
    }

    public final int getTotalCount() {
        Cursor rawQuery = this.dbHelper.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM conversation_detail", null);
        Intrinsics.checkNotNullExpressionValue(rawQuery, "rawQuery(...)");
        Cursor cursor = rawQuery;
        try {
            Cursor cursor2 = cursor;
            int i = cursor2.moveToFirst() ? cursor2.getInt(0) : 0;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return i;
        } finally {
        }
    }

    public static /* synthetic */ int trimOldConversations$default(ConversationDetailDao conversationDetailDao, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2000;
        }
        return conversationDetailDao.trimOldConversations(i);
    }

    public final int trimOldConversations(int maxRows) {
        int totalCount = getTotalCount();
        if (totalCount <= maxRows) {
            return 0;
        }
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT conversation_id, COUNT(*) AS cnt\nFROM conversation_detail\nGROUP BY conversation_id\nORDER BY MAX(updated_at) ASC", null);
        Intrinsics.checkNotNullExpressionValue(rawQuery, "rawQuery(...)");
        Cursor cursor = rawQuery;
        try {
            Cursor cursor2 = cursor;
            while (true) {
                totalCount -= maxRows;
                if (!cursor2.moveToNext() || totalCount <= 0) {
                    break;
                }
                String string = cursor2.getString(0);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(string);
                maxRows = cursor2.getInt(1);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            if (arrayList.isEmpty()) {
                return 0;
            }
            writableDatabase.beginTransaction();
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete("conversation_detail", "conversation_id = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return arrayList.size();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } finally {
        }
    }

    private final ContentValues toContentValues(ConversationDetailEntity entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("conversation_id", entity.getConversationId());
        contentValues.put("message_id", entity.getMessageId());
        contentValues.put("message_index", Integer.valueOf(entity.getMessageIndex()));
        contentValues.put("role", entity.getRole());
        contentValues.put("content_type", entity.getContentType());
        contentValues.put(ReportConstant.COMMON_CONTENT, entity.getContent());
        contentValues.put(PageDataManager.EXTRA_STATUS, entity.getStatus());
        contentValues.put("created_at", Long.valueOf(entity.getCreatedAt()));
        contentValues.put("updated_at", Long.valueOf(entity.getUpdatedAt()));
        return contentValues;
    }

    private final ConversationDetailEntity cursorToEntity(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndexOrThrow("conversation_id"));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("message_id"));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("message_index"));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("role"));
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow("content_type"));
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = cursor.getString(cursor.getColumnIndexOrThrow(ReportConstant.COMMON_CONTENT));
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        return new ConversationDetailEntity(string, string2, i, string3, string4, string5, getStringOrNull(cursor, PageDataManager.EXTRA_STATUS), cursor.getLong(cursor.getColumnIndexOrThrow("created_at")), cursor.getLong(cursor.getColumnIndexOrThrow("updated_at")));
    }

    private final String getStringOrNull(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0 || cursor.isNull(columnIndex)) {
            return null;
        }
        return cursor.getString(columnIndex);
    }
}
