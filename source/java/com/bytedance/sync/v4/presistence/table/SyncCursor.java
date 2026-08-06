package com.bytedance.sync.v4.presistence.table;

import com.bytedance.sync.v4.protocal.Bucket;
import com.bytedance.sync.v4.protocal.TopicType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class SyncCursor {
    public Bucket bucket;
    public String did;
    public long receiveCursor;
    public long reportCursor;
    public String syncId;
    public TopicType topicType;
    public String uid;

    public String toString() {
        return "SyncCursor{did='" + this.did + "', uid='" + this.uid + "', syncId='" + this.syncId + "', topicType=" + this.topicType + ", bucket=" + this.bucket + ", receiveCursor=" + this.receiveCursor + ", reportCursor=" + this.reportCursor + AbstractJsonLexerKt.END_OBJ;
    }

    public SyncCursor() {
    }

    public SyncCursor(SyncCursor syncCursor) {
        this.did = syncCursor.did;
        this.uid = syncCursor.uid;
        this.syncId = syncCursor.syncId;
        this.topicType = syncCursor.topicType;
        this.bucket = syncCursor.bucket;
        this.receiveCursor = syncCursor.receiveCursor;
        this.reportCursor = syncCursor.reportCursor;
    }
}
