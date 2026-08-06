package com.bytedance.push.spread.out;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushNotificationMessage;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.push.interfaze.IMessageSpreadOutService;
import com.bytedance.push.model.SpreadOutMessage;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MessageSpreadOutServiceImpl implements IMessageSpreadOutService, Handler.Callback {
    private boolean mAllowSpreadOutMessage;
    private Context mContext;
    private Handler mHandler;
    private LocalSettings mLocalSettings;
    private final String TAG = "MessageSpreadOutServiceImpl";
    private final int MSG_WHAT_CHECK_CLIENT_STATUS = 2081615;
    private final SpreadOutMessage mSpreadOutMessage = new SpreadOutMessage();
    private final AtomicBoolean mIsLooperRunning = new AtomicBoolean(false);

    private synchronized void init() {
        if (this.mContext == null) {
            this.mContext = AppProvider.getApp();
            this.mHandler = PushThreadHandlerManager.inst().getHandler(this);
            this.mLocalSettings = (LocalSettings) SettingsManager.obtain(this.mContext, LocalSettings.class);
            this.mAllowSpreadOutMessage = ((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).allowSpreadOutMessage();
        }
    }

    @Override // com.bytedance.push.interfaze.IMessageSpreadOutService
    public void handleMessageNotBeenShown() {
        init();
        List<PushNotificationMessage> allMessageNotShown = MultiProcessPushMessageDatabaseHelper.getInstance(this.mContext).getAllMessageNotShown();
        Logger.m268d("MessageSpreadOutServiceImpl", "[onPushStart] allMessageNotShown size is " + allMessageNotShown.size());
        for (PushNotificationMessage pushNotificationMessage : allMessageNotShown) {
            if (!spreadOut(pushNotificationMessage)) {
                PushSupporter.get().getPushHandler().handleMessageShow(pushNotificationMessage);
            }
        }
    }

    private long getMessageShowTimeInterval(PushNotificationMessage pushNotificationMessage) {
        long messageShowTimeIntervalFromLastMsgShow = getMessageShowTimeIntervalFromLastMsgShow(pushNotificationMessage);
        long messageShowTimeIntervalFromLastForeground = getMessageShowTimeIntervalFromLastForeground(pushNotificationMessage);
        Logger.m268d("MessageSpreadOutServiceImpl", "[getMessageShowTimeInterval] messageShowTimeIntervalFromLastMsgShow:" + messageShowTimeIntervalFromLastMsgShow + " messageShowTimeIntervalFromLastForeground:" + messageShowTimeIntervalFromLastForeground);
        return Math.max(messageShowTimeIntervalFromLastMsgShow, messageShowTimeIntervalFromLastForeground);
    }

    private long getMessageShowTimeIntervalFromLastMsgShow(PushNotificationMessage pushNotificationMessage) {
        if (pushNotificationMessage.getPushBody().minDisplayIntervalFromLastMsg < 0) {
            return 0L;
        }
        long lastMessageShowTimeStamp = (this.mLocalSettings.getLastMessageShowTimeStamp() + (pushNotificationMessage.getPushBody().minDisplayIntervalFromLastMsg * 1000)) - System.currentTimeMillis();
        if (lastMessageShowTimeStamp <= 0) {
            return 0L;
        }
        return lastMessageShowTimeStamp;
    }

    private long getMessageShowTimeIntervalFromLastForeground(PushNotificationMessage pushNotificationMessage) {
        if (pushNotificationMessage.getPushBody().minDisplayIntervalFromForeground < 0) {
            return 0L;
        }
        long lastForeGroundTimeStamp = (AppStatusObserverForChildProcess.getIns().getLastForeGroundTimeStamp() + (pushNotificationMessage.getPushBody().minDisplayIntervalFromForeground * 1000)) - System.currentTimeMillis();
        if (lastForeGroundTimeStamp <= 0) {
            return 0L;
        }
        return lastForeGroundTimeStamp;
    }

    private synchronized void startInMessageLopper() {
        PushNotificationMessage earliestMessage = this.mSpreadOutMessage.getEarliestMessage();
        if (earliestMessage != null) {
            if (this.mIsLooperRunning.compareAndSet(false, true)) {
                long messageShowTimeInterval = getMessageShowTimeInterval(earliestMessage);
                Logger.m268d("MessageSpreadOutServiceImpl", "[startInMessageLopper] show message after " + messageShowTimeInterval + " mill");
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2081615, earliestMessage), messageShowTimeInterval);
            } else {
                Logger.m268d("MessageSpreadOutServiceImpl", "[startInMessageLopper] earliestMessage is not null but mHandler has MSG_WHAT_CHECK_CLIENT_STATUS");
            }
        } else {
            Logger.m268d("MessageSpreadOutServiceImpl", "[startInMessageLopper] earliestMessage is null");
        }
    }

    @Override // com.bytedance.push.interfaze.IMessageSpreadOutService
    public boolean spreadOut(PushNotificationMessage pushNotificationMessage) {
        Logger.m268d("MessageSpreadOutServiceImpl", "[spreadOut] minDisplayInterval：" + pushNotificationMessage.getPushBody().minDisplayIntervalFromLastMsg);
        if (pushNotificationMessage.getPushBody().minDisplayIntervalFromLastMsg <= 0 && pushNotificationMessage.getPushBody().minDisplayIntervalFromForeground <= 0) {
            return false;
        }
        init();
        if (!this.mAllowSpreadOutMessage) {
            Logger.m268d("MessageSpreadOutServiceImpl", "[spreadOut] not spread out message because settings of mAllowSpreadOutMessage is false");
            return false;
        }
        this.mSpreadOutMessage.addMessage(pushNotificationMessage);
        startInMessageLopper();
        return true;
    }

    @Override // com.bytedance.push.interfaze.IMessageSpreadOutService
    public boolean allowSpreadOutMessage() {
        init();
        return this.mAllowSpreadOutMessage;
    }

    private void showMessageNow(PushNotificationMessage pushNotificationMessage) {
        boolean z;
        if (pushNotificationMessage != null && getMessageShowTimeIntervalFromLastForeground(pushNotificationMessage) <= 0) {
            PushBody pushBody = pushNotificationMessage.getPushBody();
            if (pushBody.messageExpiredTime < System.currentTimeMillis()) {
                Logger.m268d("MessageSpreadOutServiceImpl", "[showMessageNow] message expired , not show !");
                z = true;
            } else {
                this.mLocalSettings.setLastMessageShowTimeStamp(System.currentTimeMillis());
                z = false;
            }
            this.mSpreadOutMessage.removeMessage(pushNotificationMessage);
            PushSupporter.get().getPushHandler().showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, true, z, null, pushNotificationMessage.arriveTime);
        }
        startInMessageLopper();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 2081615) {
            return false;
        }
        this.mIsLooperRunning.compareAndSet(true, false);
        PushNotificationMessage pushNotificationMessage = (PushNotificationMessage) message.obj;
        if (pushNotificationMessage != null) {
            Logger.m268d("MessageSpreadOutServiceImpl", "[handleMessage of MSG_WHAT_CHECK_CLIENT_STATUS] show message " + pushNotificationMessage.getLocalMessageId());
            showMessageNow(pushNotificationMessage);
        } else {
            Logger.m271e("MessageSpreadOutServiceImpl", "[handleMessage of MSG_WHAT_CHECK_CLIENT_STATUS] message is null");
        }
        return true;
    }
}
