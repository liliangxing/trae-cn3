package com.bytedance.sync.v4.presistence.table;

import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v4.protocal.Bucket;
import com.bytedance.sync.v4.protocal.ConsumeType;
import com.bytedance.sync.v4.protocal.PacketCtrl;
import com.bytedance.sync.v4.protocal.PacketStatus;
import com.bytedance.sync.v4.protocal.TopicType;
import java.util.Arrays;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class SyncHistoryLogV4 {
    public Bucket bucket;
    public long business;
    public ConsumeType consumeType;
    public byte[] data;
    public DataType dataType;
    public String did;
    public long expireTs;
    public Map<String, String> extra;
    public String md5;
    public PacketCtrl packetCtrl;
    public PacketStatus packetStatus;
    public long publishTs;
    public long receiveTs;
    public String reqId;
    public long syncCursor;
    public String syncId;
    public TopicType topicType;
    public String uid;

    public String toString() {
        return "SyncHistoryLog{syncId='" + this.syncId + "', did='" + this.did + "', uid='" + this.uid + "', syncCursor=" + this.syncCursor + ", data=" + Arrays.toString(this.data) + ", md5='" + this.md5 + "', business=" + this.business + ", consumeType=" + this.consumeType + ", dataType=" + this.dataType + ", publishTs=" + this.publishTs + ", receiveTs=" + this.receiveTs + ", bucket=" + this.bucket + ", reqId='" + this.reqId + "', topicType=" + this.topicType + ", packetStatus=" + this.packetStatus + ", expireTs=" + this.expireTs + ", packetCtrl" + this.packetCtrl + ", extra=" + this.extra + AbstractJsonLexerKt.END_OBJ;
    }
}
