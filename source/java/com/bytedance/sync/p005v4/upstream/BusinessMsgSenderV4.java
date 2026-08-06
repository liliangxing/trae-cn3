package com.bytedance.sync.p005v4.upstream;

import android.content.Context;
import com.bytedance.sync.BusinessManager;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.DelayTaskExecutor;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.ISendInterceptor;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.settings.SyncSettings;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BusinessMsgSenderV4.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0006\u0010\u001d\u001a\u00020\u0013J\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0006\u0010#\u001a\u00020\u0013J\"\u0010$\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/sync/v4/upstream/BusinessMsgSenderV4;", "", "context", "Landroid/content/Context;", "configuration", "Lcom/bytedance/sync/Configuration;", "businessMgr", "Lcom/bytedance/sync/BusinessManager;", "(Landroid/content/Context;Lcom/bytedance/sync/Configuration;Lcom/bytedance/sync/BusinessManager;)V", "TAG", "", "isSendingMsg", "", "()Z", "mFirstTimeSend", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mSyncDataReadyTask", "Lcom/bytedance/sync/DelayTaskExecutor;", "beforeSendMsg", "", "bindCursor", "bucket", "Lcom/bytedance/sync/v4/protocal/Bucket;", "deviceInfo", "Lcom/bytedance/sync/user/AccountEventSynchronizer$DeviceInfo;", "syncCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "deleteUnExceptedMsg", "doSendMsg", "onSyncReady", "sendWithSyncId", "syncId", "uploadItemV3", "", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "syncToServer", "uploadWithBucket", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BusinessMsgSenderV4 {
    private final String TAG;
    private final BusinessManager businessMgr;
    private final Configuration configuration;
    private final Context context;
    private final AtomicBoolean mFirstTimeSend;
    private final DelayTaskExecutor mSyncDataReadyTask;

    public BusinessMsgSenderV4(Context context, Configuration configuration, BusinessManager businessManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(businessManager, "businessMgr");
        this.context = context;
        this.configuration = configuration;
        this.businessMgr = businessManager;
        this.TAG = "[BusinessMsgSenderV4] ";
        this.mFirstTimeSend = new AtomicBoolean(true);
        this.mSyncDataReadyTask = new DelayTaskExecutor();
    }

    public final void onSyncReady() {
        this.mSyncDataReadyTask.onReady();
    }

    public final void syncToServer() {
        if (this.mSyncDataReadyTask.hasDelayTask()) {
            LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "there is upstream task in queue,throw current one"));
        } else {
            this.mSyncDataReadyTask.runAfterReady(new Runnable() { // from class: com.bytedance.sync.v4.upstream.BusinessMsgSenderV4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BusinessMsgSenderV4.m1031syncToServer$lambda0(BusinessMsgSenderV4.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: syncToServer$lambda-0, reason: not valid java name */
    public static final void m1031syncToServer$lambda0(BusinessMsgSenderV4 businessMsgSenderV4) {
        Intrinsics.checkNotNullParameter(businessMsgSenderV4, "this$0");
        LogUtils.m187i(Intrinsics.stringPlus(businessMsgSenderV4.TAG, "sync upstream msg to server"));
        if (businessMsgSenderV4.mFirstTimeSend.compareAndSet(true, false)) {
            businessMsgSenderV4.beforeSendMsg();
        }
        businessMsgSenderV4.doSendMsg();
    }

    private final void beforeSendMsg() {
        deleteUnExceptedMsg();
    }

    private final void deleteUnExceptedMsg() {
        try {
            ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).deleteUpStreamMsgIfBusinessNotExist();
        } catch (Exception e) {
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when deleteMsgWhichBusinessNotExist");
            e.printStackTrace();
        }
    }

    private final void doSendMsg() {
        if (isSendingMsg()) {
            LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "there is msg in dequeue, ignore this request"));
            return;
        }
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        try {
            Intrinsics.checkNotNullExpressionValue(deviceInfo, "deviceInfo");
            List<SyncCursor> queryLocalSyncCursorInfoWithDeviceInfo = iDBServiceV4.queryLocalSyncCursorInfoWithDeviceInfo(deviceInfo);
            ArrayList arrayList = new ArrayList();
            for (Object obj : queryLocalSyncCursorInfoWithDeviceInfo) {
                if (((SyncCursor) obj).topicType == TopicType.SpecTopic) {
                    arrayList.add(obj);
                }
            }
            ArrayList<SyncCursor> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (SyncCursor syncCursor : arrayList2) {
                arrayList3.add(TuplesKt.to(syncCursor.bucket, syncCursor));
            }
            Map map = MapsKt.toMap(arrayList3);
            uploadWithBucket(Bucket.Device, deviceInfo, (SyncCursor) map.get(Bucket.Device));
            uploadWithBucket(Bucket.User, deviceInfo, (SyncCursor) map.get(Bucket.User));
        } catch (Throwable th) {
            SyncMonitor.monitorException$default(th, null, 2, null);
        }
    }

    private final void uploadWithBucket(Bucket bucket, AccountEventSynchronizer.DeviceInfo deviceInfo, SyncCursor syncCursor) {
        if (syncCursor == null) {
            return;
        }
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        if (!bindCursor(bucket, deviceInfo, syncCursor)) {
            LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "save distributed payload to db failed"));
            return;
        }
        try {
            String str = syncCursor.syncId;
            Intrinsics.checkNotNullExpressionValue(str, "syncCursor.syncId");
            List<UploadItemV4> queryDistributeMsgs = iDBServiceV4.queryDistributeMsgs(str, 100);
            List<UploadItemV4> list = queryDistributeMsgs;
            if (list == null || list.isEmpty()) {
                LogUtils.m187i(this.TAG + "local db is empty, not upload " + bucket);
                return;
            }
            String str2 = syncCursor.syncId;
            Intrinsics.checkNotNullExpressionValue(str2, "syncCursor.syncId");
            sendWithSyncId(str2, queryDistributeMsgs);
        } catch (Exception e) {
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when queryDistributeMsgs");
            e.printStackTrace();
        }
    }

    private final void sendWithSyncId(String syncId, List<UploadItemV4> uploadItemV3) {
        ArrayList arrayList = new ArrayList();
        ISettings settings = SyncSettings.inst(this.context).getSettings();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(!uploadItemV3.isEmpty())) {
                break;
            }
            if (uploadItemV3.get(0).data.length + i <= settings.reportSizeLimit()) {
                UploadItemV4 remove = uploadItemV3.remove(0);
                arrayList.add(remove);
                i += remove.data.length;
            } else if (arrayList.isEmpty()) {
                arrayList.add(uploadItemV3.remove(0));
                z = true;
            }
        }
        if (!arrayList.isEmpty()) {
            ((ISyncMsgSenderV4) UgBusFramework.getService(ISyncMsgSenderV4.class)).sendPayload(syncId, arrayList, z);
        } else {
            LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "dataList is empty when send payload,maybe the first size too large or original data is empty"));
        }
    }

    private final boolean bindCursor(Bucket bucket, AccountEventSynchronizer.DeviceInfo deviceInfo, SyncCursor syncCursor) {
        List<UploadItemV4> queryUploadMsgByDeviceInfo;
        IDBServiceV4 iDBServiceV4 = (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
        try {
            if (bucket == Bucket.Device) {
                String str = deviceInfo.did;
                Intrinsics.checkNotNullExpressionValue(str, "deviceInfo.did");
                queryUploadMsgByDeviceInfo = iDBServiceV4.queryUploadMsgByDeviceInfo(bucket, str, 100);
            } else {
                String str2 = deviceInfo.uid;
                String str3 = deviceInfo.did;
                Intrinsics.checkNotNullExpressionValue(str3, "deviceInfo.did");
                Intrinsics.checkNotNullExpressionValue(str2, "uid");
                queryUploadMsgByDeviceInfo = iDBServiceV4.queryUploadMsgByDeviceInfo(bucket, str3, str2, 100);
            }
            List<UploadItemV4> list = queryUploadMsgByDeviceInfo;
            if (list == null || list.isEmpty()) {
                return true;
            }
            ArrayList<UploadItemV4> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z = false;
            for (UploadItemV4 uploadItemV4 : queryUploadMsgByDeviceInfo) {
                Object[] connectOnSendDataListener = this.businessMgr.getBusinessById(uploadItemV4.business).connectOnSendDataListener();
                if (connectOnSendDataListener != null) {
                    for (Object obj : connectOnSendDataListener) {
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.sync.interfaze.ISendInterceptor");
                        }
                        byte[] bArr = uploadItemV4.data;
                        Intrinsics.checkNotNullExpressionValue(bArr, "updateItem.data");
                        z = ((ISendInterceptor) obj).onSend(bArr) || z;
                    }
                }
                if (z) {
                    arrayList2.add(uploadItemV4);
                } else {
                    arrayList.add(uploadItemV4);
                }
            }
            for (UploadItemV4 uploadItemV42 : arrayList) {
                uploadItemV42.syncId = syncCursor.syncId;
                syncCursor.reportCursor++;
                uploadItemV42.cursor = syncCursor.reportCursor;
                uploadItemV42.bucket = syncCursor.bucket;
            }
            boolean updateUploadCursorAndDelete = iDBServiceV4.updateUploadCursorAndDelete(queryUploadMsgByDeviceInfo, syncCursor, arrayList2);
            if (updateUploadCursorAndDelete) {
                LogUtils.m187i(Intrinsics.stringPlus(this.TAG, "save distributed payload to db success"));
            }
            return updateUploadCursorAndDelete;
        } catch (Exception e) {
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when queryUploadMsgByDeviceInfo");
            e.printStackTrace();
            return false;
        }
    }

    private final boolean isSendingMsg() {
        return ((ISyncMsgSenderV4) UgBusFramework.getService(ISyncMsgSenderV4.class)).isPendingPayloadToSend();
    }
}
