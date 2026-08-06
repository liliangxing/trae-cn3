package com.bytedance.sync.p005v4.topic;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sync.exc.SyncApiException;
import com.bytedance.sync.exc.SyncIOException;
import com.bytedance.sync.interfaze.Callback;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.ISyncNetService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.SubscribeResponse;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.ss.android.ug.bus.UgBusFramework;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTopicMgr.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bJ \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sync/v4/topic/CustomTopicMgr;", "", "()V", "subscribeTopic", "", "topic", "Lcom/bytedance/sync/model/Topic;", "callback", "Lcom/bytedance/sync/interfaze/Callback;", "Ljava/lang/Void;", "unsubscribeTopic", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CustomTopicMgr {
    public final void subscribeTopic(final Topic topic, final Callback<Void> callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        String did = topic.getDid();
        if (did == null || did.length() == 0) {
            topic.setDid(deviceInfo.did);
        }
        String uid = topic.getUid();
        if (uid == null || uid.length() == 0) {
            topic.setUid(deviceInfo.uid);
        }
        LogUtils.m185d(Intrinsics.stringPlus("do subscribeTopic. topic = ", topic));
        TTExecutors.getIOThreadPool().submit(new Runnable() { // from class: com.bytedance.sync.v4.topic.CustomTopicMgr$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CustomTopicMgr.m1024subscribeTopic$lambda2(Topic.this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribeTopic$lambda-2, reason: not valid java name */
    public static final void m1024subscribeTopic$lambda2(Topic topic, final Callback callback) {
        Intrinsics.checkNotNullParameter(topic, "$topic");
        try {
            final SubscribeResponse subscribeTopic = ((ISyncNetService) UgBusFramework.getService(ISyncNetService.class)).subscribeTopic(topic);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sync.v4.topic.CustomTopicMgr$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CustomTopicMgr.m1026subscribeTopic$lambda2$lambda1(SubscribeResponse.this, callback);
                }
            });
        } catch (Exception e) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sync.v4.topic.CustomTopicMgr$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CustomTopicMgr.m1025subscribeTopic$lambda2$lambda0(e, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribeTopic$lambda-2$lambda-0, reason: not valid java name */
    public static final void m1025subscribeTopic$lambda2$lambda0(Exception exc, Callback callback) {
        Intrinsics.checkNotNullParameter(exc, "$e");
        if (exc instanceof CommonHttpException) {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncIOException(((CommonHttpException) exc).getResponseCode(), exc.getMessage(), exc));
        } else {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncIOException(1, exc.getMessage(), exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribeTopic$lambda-2$lambda-1, reason: not valid java name */
    public static final void m1026subscribeTopic$lambda2$lambda1(SubscribeResponse subscribeResponse, Callback callback) {
        if (subscribeResponse == null) {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncApiException(1, "unknown error"));
        } else if (subscribeResponse.getStatusCode() != 0) {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncApiException(subscribeResponse.getStatusCode(), subscribeResponse.getMsg()));
        } else {
            if (callback == null) {
                return;
            }
            callback.onSuccess(null);
        }
    }

    public final void unsubscribeTopic(final Topic topic, final Callback<Void> callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        LogUtils.m185d(Intrinsics.stringPlus("do unsubscribeTopic. topic = ", topic));
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        String did = topic.getDid();
        if (did == null || did.length() == 0) {
            topic.setDid(deviceInfo.did);
        }
        String uid = topic.getUid();
        if (uid == null || uid.length() == 0) {
            topic.setUid(deviceInfo.uid);
        }
        TTExecutors.getIOThreadPool().submit(new Runnable() { // from class: com.bytedance.sync.v4.topic.CustomTopicMgr$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                CustomTopicMgr.m1027unsubscribeTopic$lambda5(Topic.this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unsubscribeTopic$lambda-5, reason: not valid java name */
    public static final void m1027unsubscribeTopic$lambda5(Topic topic, final Callback callback) {
        Intrinsics.checkNotNullParameter(topic, "$topic");
        try {
            final SubscribeResponse unsubscribeTopic = ((ISyncNetService) UgBusFramework.getService(ISyncNetService.class)).unsubscribeTopic(topic);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sync.v4.topic.CustomTopicMgr$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CustomTopicMgr.m1029unsubscribeTopic$lambda5$lambda4(SubscribeResponse.this, callback);
                }
            });
        } catch (Exception e) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sync.v4.topic.CustomTopicMgr$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CustomTopicMgr.m1028unsubscribeTopic$lambda5$lambda3(e, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unsubscribeTopic$lambda-5$lambda-3, reason: not valid java name */
    public static final void m1028unsubscribeTopic$lambda5$lambda3(Exception exc, Callback callback) {
        Intrinsics.checkNotNullParameter(exc, "$e");
        if (exc instanceof CommonHttpException) {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncIOException(((CommonHttpException) exc).getResponseCode(), exc.getMessage(), exc));
        } else {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncIOException(1, exc.getMessage(), exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unsubscribeTopic$lambda-5$lambda-4, reason: not valid java name */
    public static final void m1029unsubscribeTopic$lambda5$lambda4(SubscribeResponse subscribeResponse, Callback callback) {
        if (subscribeResponse == null) {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncApiException(1, "unknown error"));
        } else if (subscribeResponse.getStatusCode() != 0) {
            if (callback == null) {
                return;
            }
            callback.onFailed(new SyncApiException(subscribeResponse.getStatusCode(), subscribeResponse.getMsg()));
        } else {
            if (callback == null) {
                return;
            }
            callback.onSuccess(null);
        }
    }
}
