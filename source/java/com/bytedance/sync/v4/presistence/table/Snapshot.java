package com.bytedance.sync.v4.presistence.table;

import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v4.protocal.Bucket;
import com.bytedance.sync.v4.protocal.ConsumeType;

/* loaded from: classes5.dex */
public class Snapshot {
    public Bucket bucket;
    public long business;
    public ConsumeType consumeType;
    public long cursor;
    public byte[] data;
    public DataType dataType;
    public String did;
    public long notified;
    public int patchCnt;
    public long publishTs;
    public long receiveTs;
    public String syncId;
    public String uid;
}
