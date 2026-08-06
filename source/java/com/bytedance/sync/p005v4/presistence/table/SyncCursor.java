package com.bytedance.sync.p005v4.presistence.table;

import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.TopicType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncCursor {
    public Bucket bucket;
    public String did;
    public long receiveCursor;
    public long reportCursor;
    public String syncId;
    public TopicType topicType;
    public String uid;

    public String toString() {
        return "SyncCursor{did='" + this.did + "', uid='" + this.uid + "', syncId='" + this.syncId + "', topicType=" + this.topicType + ", bucket=" + this.bucket + ", receiveCursor=" + this.receiveCursor + ", reportCursor=" + this.reportCursor + '}';
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
