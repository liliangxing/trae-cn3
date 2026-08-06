package com.bytedance.sync.p004v3.presistence.dao;

import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.p005v4.protocal.Bucket;
import java.util.List;
import kotlin.Metadata;

/* compiled from: UploadDaoV4.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH'J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\fH'J\u0018\u0010\r\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH'J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH'J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH'J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH'J\u0016\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sync/v3/presistence/dao/UploadDaoV4;", "", "deleteUpStreamMsgIfBusinessNotExist", "", "deleteUploadData", "syncId", "", "cursor", "deleteUploadDataList", "", "deleteList", "", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "insert", "item", "queryDistributeMsgs", "", "", "limit", "queryUploadMsgByDeviceInfo", "bucket", "Lcom/bytedance/sync/v4/protocal/Bucket;", "did", "size", "uid", "update", "undistributedUploads", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface UploadDaoV4 {
    void deleteUpStreamMsgIfBusinessNotExist();

    void deleteUploadData(long syncId, long cursor);

    int deleteUploadDataList(List<? extends UploadItemV4> deleteList);

    long insert(UploadItemV4 item);

    void insert(List<? extends UploadItemV4> item);

    List<UploadItemV4> queryDistributeMsgs(String syncId, int limit);

    List<UploadItemV4> queryUploadMsgByDeviceInfo(Bucket bucket, String did, int size);

    List<UploadItemV4> queryUploadMsgByDeviceInfo(Bucket bucket, String did, String uid, int size);

    int update(List<? extends UploadItemV4> undistributedUploads);
}
