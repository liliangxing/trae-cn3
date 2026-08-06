package com.bytedance.trae.im.database;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageDao.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/database/ChatMessageDao;", "", "dbHelper", "Lcom/bytedance/trae/im/database/DatabaseOpenHelper;", "<init>", "(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V", "insert", "", "taskId", "", "messageId", "messageType", "messageIndex", "", ReportConstant.COMMON_CONTENT, "queryByTaskId", "", "Lcom/bytedance/trae/im/database/ChatMessageEntity;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatMessageDao {
    private final DatabaseOpenHelper dbHelper;

    public ChatMessageDao(DatabaseOpenHelper databaseOpenHelper) {
        Intrinsics.checkNotNullParameter(databaseOpenHelper, "dbHelper");
        this.dbHelper = databaseOpenHelper;
    }

    public final long insert(String taskId, String messageId, String messageType, int messageIndex, String content) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewTaskTracker.Param.TASK_ID, taskId);
        contentValues.put("message_id", messageId);
        contentValues.put("message_type", messageType);
        contentValues.put("message_index", Integer.valueOf(messageIndex));
        contentValues.put(ReportConstant.COMMON_CONTENT, content);
        return this.dbHelper.getWritableDatabase().insert("chat_message", null, contentValues);
    }

    public final List<ChatMessageEntity> queryByTaskId(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        ArrayList arrayList = new ArrayList();
        Cursor query = this.dbHelper.getReadableDatabase().query("chat_message", null, "task_id = ? AND deleted_at = 0", new String[]{taskId}, null, null, "message_index ASC");
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            while (cursor2.moveToNext()) {
                long j = cursor2.getLong(cursor2.getColumnIndexOrThrow("id"));
                String string = cursor2.getString(cursor2.getColumnIndexOrThrow(NewTaskTracker.Param.TASK_ID));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow("message_id"));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = cursor2.getString(cursor2.getColumnIndexOrThrow("message_type"));
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int i = cursor2.getInt(cursor2.getColumnIndexOrThrow("message_index"));
                String string4 = cursor2.getString(cursor2.getColumnIndexOrThrow(ReportConstant.COMMON_CONTENT));
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                arrayList.add(new ChatMessageEntity(j, string, string2, string3, i, string4, cursor2.getInt(cursor2.getColumnIndexOrThrow(PageDataManager.EXTRA_STATUS)), cursor2.getLong(cursor2.getColumnIndexOrThrow("created_at")), cursor2.getLong(cursor2.getColumnIndexOrThrow("updated_at"))));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return arrayList;
        } finally {
        }
    }
}
