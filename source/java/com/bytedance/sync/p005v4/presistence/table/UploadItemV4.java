package com.bytedance.sync.p005v4.presistence.table;

import com.bytedance.sync.p005v4.protocal.Bucket;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UploadItemV4 {
    public Bucket bucket;
    public long business;
    public long cursor;
    public byte[] data;
    public String did;

    /* renamed from: id */
    public long f235id;
    public String md5;
    public String msg_id;
    public String syncId;
    public String uid;

    public String toString() {
        return "UploadItem{id=" + this.f235id + ", syncId='" + this.syncId + "', business=" + this.business + ", did='" + this.did + "', uid='" + this.uid + "', bucket=" + this.bucket + ", cursor=" + this.cursor + ", data=" + Arrays.toString(this.data) + ", md5='" + this.md5 + "', msg_id='" + this.msg_id + "'}";
    }
}
