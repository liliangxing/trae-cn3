package com.bytedance.sync.p005v4.upstream;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.sync.BusinessManager;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncSDK;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IPayloadSendServiceV4;
import com.bytedance.sync.p005v4.presistence.table.UploadItemV4;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayloadSendServiceV4.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u001e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001eH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/sync/v4/upstream/PayloadSendServiceV4;", "Lcom/bytedance/sync/v4/intf/IPayloadSendServiceV4;", "Landroid/os/Handler$Callback;", "context", "Landroid/content/Context;", "configuration", "Lcom/bytedance/sync/Configuration;", "mAccountEventSynchronizer", "Lcom/bytedance/sync/interfaze/IDeviceInfoGetter;", "mBusinessMgr", "Lcom/bytedance/sync/BusinessManager;", "(Landroid/content/Context;Lcom/bytedance/sync/Configuration;Lcom/bytedance/sync/interfaze/IDeviceInfoGetter;Lcom/bytedance/sync/BusinessManager;)V", "TAG", "", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "mPayloadSender", "Lcom/bytedance/sync/v4/upstream/BusinessMsgSenderV4;", "handleMessage", "", "msg", "Landroid/os/Message;", "insertToUpSteamDb", "", "item", "Lcom/bytedance/sync/v4/presistence/table/UploadItemV4;", "", "startSendToServer", "trySendMsg", "businessId", "", "data", "", "dataList", "Lcom/bytedance/sync/interfaze/ISyncClient$ReportItem;", "trySendUploadMsg", "Companion", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PayloadSendServiceV4 implements IPayloadSendServiceV4, Handler.Callback {
    private static final int MSG_INSERT_UPSTREAM_MSG = 101;
    private static final int MSG_INSERT_UPSTREAM_MSG_BATCH = 103;
    private static final int MSG_UPLOAD = 102;
    private final String TAG;
    private final Configuration configuration;
    private final Context context;
    private final IDeviceInfoGetter mAccountEventSynchronizer;
    private final BusinessManager mBusinessMgr;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;
    private final BusinessMsgSenderV4 mPayloadSender;

    public PayloadSendServiceV4(Context context, Configuration configuration, IDeviceInfoGetter iDeviceInfoGetter, BusinessManager businessManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(iDeviceInfoGetter, "mAccountEventSynchronizer");
        Intrinsics.checkNotNullParameter(businessManager, "mBusinessMgr");
        this.context = context;
        this.configuration = configuration;
        this.mAccountEventSynchronizer = iDeviceInfoGetter;
        this.mBusinessMgr = businessManager;
        this.TAG = "[PayloadSendServiceV4] ";
        this.mPayloadSender = new BusinessMsgSenderV4(context, configuration, businessManager);
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sync.v4.upstream.PayloadSendServiceV4$mHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m1035invoke() {
                return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), PayloadSendServiceV4.this);
            }
        });
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    @Override // com.bytedance.sync.interfaze.IPayloadSendService
    public void trySendMsg(final long businessId, final byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SyncSDK.runAfterStart(new Runnable() { // from class: com.bytedance.sync.v4.upstream.PayloadSendServiceV4$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PayloadSendServiceV4.m1033trySendMsg$lambda0(PayloadSendServiceV4.this, data, businessId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trySendMsg$lambda-0, reason: not valid java name */
    public static final void m1033trySendMsg$lambda0(PayloadSendServiceV4 payloadSendServiceV4, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(payloadSendServiceV4, "this$0");
        Intrinsics.checkNotNullParameter(bArr, "$data");
        AccountEventSynchronizer.DeviceInfo deviceInfo = payloadSendServiceV4.mAccountEventSynchronizer.getDeviceInfo();
        if (deviceInfo == null || TextUtils.isEmpty(deviceInfo.did)) {
            LogUtils.m186e(Intrinsics.stringPlus(payloadSendServiceV4.TAG, "did is null when save upstream msg to db"));
            return;
        }
        if (payloadSendServiceV4.getMHandler().hasMessages(102)) {
            payloadSendServiceV4.getMHandler().removeMessages(102);
        }
        UploadItemV4 uploadItemV4 = new UploadItemV4();
        uploadItemV4.did = deviceInfo.did;
        uploadItemV4.uid = deviceInfo.uid;
        uploadItemV4.data = bArr;
        uploadItemV4.business = j;
        uploadItemV4.md5 = StringEncryptUtils.encrypt(bArr.toString(), "MD5");
        payloadSendServiceV4.getMHandler().obtainMessage(101, uploadItemV4).sendToTarget();
    }

    @Override // com.bytedance.sync.interfaze.IPayloadSendService
    public void trySendMsg(final long businessId, final List<? extends ISyncClient.ReportItem> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        SyncSDK.runAfterStart(new Runnable() { // from class: com.bytedance.sync.v4.upstream.PayloadSendServiceV4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PayloadSendServiceV4.m1034trySendMsg$lambda2(PayloadSendServiceV4.this, dataList, businessId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trySendMsg$lambda-2, reason: not valid java name */
    public static final void m1034trySendMsg$lambda2(PayloadSendServiceV4 payloadSendServiceV4, List list, long j) {
        Intrinsics.checkNotNullParameter(payloadSendServiceV4, "this$0");
        Intrinsics.checkNotNullParameter(list, "$dataList");
        AccountEventSynchronizer.DeviceInfo deviceInfo = payloadSendServiceV4.mAccountEventSynchronizer.getDeviceInfo();
        if (deviceInfo == null || TextUtils.isEmpty(deviceInfo.did)) {
            LogUtils.m186e(Intrinsics.stringPlus(payloadSendServiceV4.TAG, "did is null when save upstream msg to db"));
            return;
        }
        if (payloadSendServiceV4.getMHandler().hasMessages(102)) {
            payloadSendServiceV4.getMHandler().removeMessages(102);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ISyncClient.ReportItem reportItem = (ISyncClient.ReportItem) it.next();
            if (reportItem.data != null && reportItem.msgId != null) {
                UploadItemV4 uploadItemV4 = new UploadItemV4();
                uploadItemV4.did = deviceInfo.did;
                uploadItemV4.uid = deviceInfo.uid;
                uploadItemV4.data = reportItem.data;
                uploadItemV4.msg_id = reportItem.msgId;
                uploadItemV4.business = j;
                uploadItemV4.md5 = StringEncryptUtils.encrypt(reportItem.data.toString(), "MD5");
                arrayList.add(uploadItemV4);
            }
        }
        payloadSendServiceV4.getMHandler().obtainMessage(103, arrayList).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 101) {
            Object obj = msg.obj;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.sync.v4.presistence.table.UploadItemV4");
            }
            insertToUpSteamDb((UploadItemV4) obj);
            if (!getMHandler().hasMessages(102)) {
                getMHandler().obtainMessage(102).sendToTarget();
            }
        }
        if (msg.what == 103) {
            Object obj2 = msg.obj;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.sync.v4.presistence.table.UploadItemV4>");
            }
            insertToUpSteamDb((List<? extends UploadItemV4>) obj2);
            if (!getMHandler().hasMessages(102)) {
                getMHandler().obtainMessage(102).sendToTarget();
            }
        }
        if (msg.what != 102) {
            return false;
        }
        this.mPayloadSender.syncToServer();
        return false;
    }

    private final void insertToUpSteamDb(UploadItemV4 item) {
        LogUtils.m188v(this.TAG + "do insert upstream msg -> " + item);
        try {
            ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).insertUpStreamItem(item);
        } catch (Exception e) {
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when insertUploadPayload");
            e.printStackTrace();
        }
    }

    private final void insertToUpSteamDb(List<? extends UploadItemV4> item) {
        LogUtils.m188v(this.TAG + "do insert upstream msg -> " + item);
        try {
            ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).insertUpStreamItemList(item);
        } catch (Exception e) {
            SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when insertUploadPayload");
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IPayloadSendServiceV4
    public void startSendToServer() {
        this.mPayloadSender.onSyncReady();
    }

    @Override // com.bytedance.sync.p005v4.intf.IPayloadSendServiceV4
    public void trySendUploadMsg() {
        if (getMHandler().hasMessages(102)) {
            return;
        }
        getMHandler().obtainMessage(102).sendToTarget();
    }
}
