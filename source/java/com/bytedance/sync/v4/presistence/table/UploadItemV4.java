package com.bytedance.sync.v4.presistence.table;

import com.bytedance.sync.v4.protocal.Bucket;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class UploadItemV4 {
    public Bucket bucket;
    public long business;
    public long cursor;
    public byte[] data;
    public String did;
    public long id;
    public String md5;
    public String msg_id;
    public String syncId;
    public String uid;

    public String toString() {
        return "UploadItem{id=" + this.id + ", syncId='" + this.syncId + "', business=" + this.business + ", did='" + this.did + "', uid='" + this.uid + "', bucket=" + this.bucket + ", cursor=" + this.cursor + ", data=" + Arrays.toString(this.data) + ", md5='" + this.md5 + "', msg_id='" + this.msg_id + "'}";
    }
}
