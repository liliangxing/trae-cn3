package com.bytedance.push.client.intelligence;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.client.ai.IClientAICallback;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushNotificationMessage;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.push.interfaze.IClientIntelligenceService;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.client.intelligence.ClientIntelligenceSettingsModel;
import com.bytedance.push.settings.client.intelligence.LocalPushClientIntelligenceSettingsModel;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClientIntelligenceServiceImpl extends AbsSystemStatusMonitor implements IClientIntelligenceService, Handler.Callback, IClientAICallback {
    private final int MSG_WHAT_CHECK_CLIENT_STATUS;
    private final int MSG_WHAT_SHOW_CACHED_MESSAGE;
    private final int MSG_WHAT_SHOW_NOTIFICATION_AFTER_TIMEOUT;
    private final String TAG;
    private IClientIntelligenceEventService mClientIntelligenceEventService;
    private ClientIntelligenceSettingsModel mClientIntelligenceSettingsModel;
    private Context mContext;
    private boolean mCurIsHighCtr;
    private boolean mCurIsLowCtr;
    private Handler mHandler;
    private KeyguardManager mKeyguardManager;
    private long mLastJudgeHighCtrTimeStamp;
    private long mLastJudgeLowCtrTimeStamp;
    private int mMonitorNotificationBarSupportLevel;
    private int mMonitorUserPresentSupportLevel;
    private PowerManager mPowerManager;
    private final Map<Long, PushNotificationMessage> mPushNotificationMessageMapNeedToShow;

    public ClientIntelligenceServiceImpl(Context context) {
        super(context);
        this.TAG = "CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl";
        this.mPushNotificationMessageMapNeedToShow = new LinkedHashMap();
        this.MSG_WHAT_CHECK_CLIENT_STATUS = 2091558;
        this.MSG_WHAT_SHOW_NOTIFICATION_AFTER_TIMEOUT = 2091559;
        this.MSG_WHAT_SHOW_CACHED_MESSAGE = 2091560;
        this.mContext = context;
        this.mHandler = PushThreadHandlerManager.inst().getHandler(this);
        this.mClientIntelligenceEventService = new ClientIntelligenceEventServiceImpl();
        if (getClientIntelligenceSettings().clientIntelligencePushShowMode == 2) {
            PushServiceManager.get().getIClientAiExternalService().registerClientAICallback(this);
            return;
        }
        if (getClientIntelligenceSettings().clientIntelligencePushShowMode == 1) {
            LocalSettings localSettings = (LocalSettings) SettingsManager.obtain(this.mContext, LocalSettings.class);
            this.mMonitorNotificationBarSupportLevel = localSettings.monitorNotificationBarSupportLevel();
            this.mMonitorUserPresentSupportLevel = localSettings.monitorUserPresentSupportLevel();
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[ClientIntelligenceServiceImpl] mMonitorNotificationBarSupportLevel is " + this.mMonitorNotificationBarSupportLevel + " mMonitorUserPresentSupportLevel is " + this.mMonitorUserPresentSupportLevel);
            startMonitorNotificationBarPull();
            startMonitorScreenOn();
            if (getClientIntelligenceSettings().improvePushArrivalRate) {
                startMonitorSystemBroadCastForUnDoze();
            }
            if (getClientIntelligenceSettings().needShowAfterScreenOn()) {
                this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
                this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
            }
        }
    }

    @Override // com.bytedance.push.interfaze.IClientIntelligenceService
    public void onPushStart() {
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onPushStart] handle message that not shown");
        if (!getClientIntelligenceSettings().enableClientIntelligencePushShow) {
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onPushStart] enableClientIntelligencePushShow is false,need't handle cache message that not show");
            return;
        }
        List<PushNotificationMessage> allMessageNotShown = MultiProcessPushMessageDatabaseHelper.getInstance(this.mContext).getAllMessageNotShown();
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onPushStart] allMessageNotShown size is " + allMessageNotShown.size());
        if (allMessageNotShown.size() > 0) {
            long currentTimeMillis = ToolUtils.currentTimeMillis();
            final ArrayList arrayList = new ArrayList();
            for (PushNotificationMessage pushNotificationMessage : allMessageNotShown) {
                PushBody pushBody = pushNotificationMessage.getPushBody();
                if (getClientIntelligenceSettings().needShowAfterNotificationBarPull(pushBody.clientIntelligencePushShowSubMode) || getClientIntelligenceSettings().needShowAfterScreenOn(pushBody.clientIntelligencePushShowSubMode)) {
                    if (getClientIntelligenceSettings().needShowAfterNotificationBarPull(pushBody.clientIntelligencePushShowSubMode)) {
                        pushBody.mBdPushStr = "";
                    }
                    synchronized (this.mPushNotificationMessageMapNeedToShow) {
                        this.mPushNotificationMessageMapNeedToShow.put(Long.valueOf(pushNotificationMessage.getLocalMessageId()), pushNotificationMessage);
                    }
                    arrayList.add(Long.valueOf(pushNotificationMessage.getLocalMessageId()));
                } else if (currentTimeMillis - pushNotificationMessage.arriveTime > getClientIntelligenceSettings().maxShowDelayTimeInMill) {
                    synchronized (this.mPushNotificationMessageMapNeedToShow) {
                        this.mPushNotificationMessageMapNeedToShow.put(Long.valueOf(pushNotificationMessage.getLocalMessageId()), pushNotificationMessage);
                    }
                    arrayList.add(Long.valueOf(pushNotificationMessage.getLocalMessageId()));
                } else {
                    showPushWithClientIntelligenceStrategy(pushNotificationMessage, true);
                }
            }
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ClientIntelligenceServiceImpl.this.showMessageWithInterval(arrayList);
                }
            }, getClientIntelligenceSettings().minIntervalFromLaunchInMill);
        }
    }

    @Override // com.bytedance.push.interfaze.IClientIntelligenceService
    public boolean enableClientIntelligencePushShow() {
        if (!getClientIntelligenceSettings().enableClientIntelligencePushShow) {
            return false;
        }
        if (!ToolUtils.isMainProcess(this.mContext) || getClientIntelligenceSettings().clientIntelligencePushShowMode != 2 || PushServiceManager.get().getIClientAiExternalService().isClientAiReady()) {
            return true;
        }
        this.mClientIntelligenceEventService.onClientAiParalysisEvent();
        return false;
    }

    @Override // com.bytedance.push.interfaze.IClientIntelligenceService
    public boolean curIsLowCtr() {
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "start judge curIsLowCtr or not");
        if (ToolUtils.currentTimeMillis() - this.mLastJudgeLowCtrTimeStamp < getClientIntelligenceSettings().checkClientFeatureIntervalInMill) {
            return this.mCurIsLowCtr;
        }
        this.mLastJudgeLowCtrTimeStamp = ToolUtils.currentTimeMillis();
        this.mCurIsLowCtr = false;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        FeatureCollectionHelper.getInstance(this.mContext).getFeatureForPushShow(new IPushShowClientFeatureCallback() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.2
            @Override // com.bytedance.push.client.intelligence.IPushShowClientFeatureCallback
            public void onNullFeatureCallback() {
                Logger.m271e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "cur is not low Ctr because onNullFeatureCallback");
                ClientIntelligenceServiceImpl.this.mCurIsLowCtr = false;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.push.client.intelligence.IPushShowClientFeatureCallback
            public void onFeatureCallback(boolean z, boolean z2, float f, boolean z3, float f2, float f3, float f4) {
                boolean z4 = true;
                boolean z5 = z2 && f >= 0.0f && f < 5.0f;
                boolean z6 = z3 && (f2 >= 5.0f || f3 < 0.0f || (Math.abs(f4) > 9.0f && Math.abs(f2) < 1.0f && Math.abs(f3) < 1.0f));
                ClientIntelligenceServiceImpl clientIntelligenceServiceImpl = ClientIntelligenceServiceImpl.this;
                if (!z && !z5 && !z6) {
                    z4 = false;
                }
                clientIntelligenceServiceImpl.mCurIsLowCtr = z4;
                if (!z2 || !z3) {
                    Logger.m271e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "client feature collect failed , distanceCollectSuccess:" + z2 + " accelerometerCollectSuccess:" + z3);
                }
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onFeatureCallback] curIsLowCtr is " + ClientIntelligenceServiceImpl.this.mCurIsLowCtr + " because isMusicActive: " + z + " isLowCtrDistance:" + z5 + " distanceCollectSuccess:" + z2 + " distance:" + f + " isLowCtrAc:" + z6 + " accelerometerCollectSuccess:" + z3 + " xAc:" + f2 + " yAc:" + f3 + " zAc:" + f4);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().featureCollectTimeOutInMill + 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.mCurIsLowCtr;
    }

    @Override // com.bytedance.push.interfaze.IClientIntelligenceService
    public ClientIntelligenceShowResult showPushWithClientIntelligenceStrategy(final PushNotificationMessage pushNotificationMessage, final boolean z) {
        ClientIntelligenceShowResult clientIntelligenceShowResult = new ClientIntelligenceShowResult();
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] localMessageId is " + pushNotificationMessage.getLocalMessageId());
        if (!enableClientIntelligencePushShow()) {
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] enableClientIntelligencePushShow is false, show notification directly");
            showNotification(pushNotificationMessage.from, pushNotificationMessage.getPushBody(), pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_NOT_ENABLE_CLIENT_INTELLIGENCE;
            return clientIntelligenceShowResult;
        }
        if (getClientIntelligenceSettings().clientIntelligencePushShowMode == 1) {
            if (getClientIntelligenceSettings().clientIntelligencePushShowSubMode == 0) {
                ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread]show notification with default personal strategy");
                        ClientIntelligenceServiceImpl.this.showPushWithOldClientIntelligencePersonalStrategy(pushNotificationMessage);
                    }
                });
                clientIntelligenceShowResult.showByClientIntelligence = true;
                clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_SUCCESS;
                return clientIntelligenceShowResult;
            }
            if (getClientIntelligenceSettings().needShowAfterNotificationBarPull() || getClientIntelligenceSettings().needShowAfterScreenOn()) {
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread]show notification with  personal strategy v2");
                return showPushWithOldClientIntelligencePersonalStrategyV2(pushNotificationMessage);
            }
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] CLIENT_INTELLIGENCE_SUB_MODE is invalid, show notification directly");
            showNotification(pushNotificationMessage.from, pushNotificationMessage.getPushBody(), pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_NO_LEGAL_SUB_MODE;
            return clientIntelligenceShowResult;
        }
        if (getClientIntelligenceSettings().clientIntelligencePushShowMode == 2) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread]show notification with model");
                    ClientIntelligenceServiceImpl.this.showPushWithClientIntelligenceModelStrategy(pushNotificationMessage, z);
                }
            });
            clientIntelligenceShowResult.showByClientIntelligence = true;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_SUCCESS;
            return clientIntelligenceShowResult;
        }
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] show notification for  backup");
        showNotification(pushNotificationMessage.from, pushNotificationMessage.getPushBody(), pushNotificationMessage.handleBySdk, false);
        clientIntelligenceShowResult.showByClientIntelligence = false;
        clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_BACK_UP;
        return clientIntelligenceShowResult;
    }

    @Override // com.bytedance.push.interfaze.IClientIntelligenceService
    public ClientIntelligenceSettingsModel getClientIntelligenceSettings() {
        if (this.mClientIntelligenceSettingsModel == null) {
            this.mClientIntelligenceSettingsModel = ((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).getClientIntelligenceSettings();
        }
        return this.mClientIntelligenceSettingsModel;
    }

    private ClientIntelligenceShowResult showPushWithOldClientIntelligencePersonalStrategyV2(PushNotificationMessage pushNotificationMessage) {
        PushBody pushBody = pushNotificationMessage.getPushBody();
        ClientIntelligenceShowResult clientIntelligenceShowResult = new ClientIntelligenceShowResult();
        if (!pushBody.useClientIntelligenceShow) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]pushBody.useClientIntelligenceShow is false, show notification directly");
            showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_USE_INTELLIGENCE_IS_FALSE_ON_PUSH_BODY;
            return clientIntelligenceShowResult;
        }
        if (pushBody.clientIntelligencePushShowMode != 1) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]pushBody.clientIntelligencePushShowMode is not CLIENT_INTELLIGENCE_MODE_PERSONAL, show notification directly");
            showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_SHOW_MODE_IS_INVALID;
            return clientIntelligenceShowResult;
        }
        boolean needShowAfterNotificationBarPull = getClientIntelligenceSettings().needShowAfterNotificationBarPull(pushBody.clientIntelligencePushShowSubMode);
        boolean needShowAfterScreenOn = getClientIntelligenceSettings().needShowAfterScreenOn(pushBody.clientIntelligencePushShowSubMode);
        ArrayList arrayList = new ArrayList();
        if (!needShowAfterNotificationBarPull) {
            arrayList.add("pushBody.needShowAfterNotificationBar is false");
        }
        if (!needShowAfterScreenOn) {
            arrayList.add("pushBody.needShowAfterScreenOn is false");
        }
        if (needShowAfterNotificationBarPull && !getClientIntelligenceSettings().needShowAfterNotificationBarPull()) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]update needShowAfterNotificationBarPull to false because  needShowAfterNotificationBarPull of settings is false");
            pushBody.mBdPushStr = "";
            arrayList.add("settings.needShowAfterNotificationBar is false");
            needShowAfterNotificationBarPull = false;
        }
        if (needShowAfterNotificationBarPull && this.mMonitorNotificationBarSupportLevel < 1) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]update needShowAfterNotificationBarPull to false because mMonitorNotificationBarSupportLevel < SUPPORT_LEVEL_SUPPORT");
            pushBody.mBdPushStr = "";
            arrayList.add("device not support monitor notification bar");
            needShowAfterNotificationBarPull = false;
        }
        if (needShowAfterScreenOn && !getClientIntelligenceSettings().needShowAfterScreenOn()) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]update needShowAfterScreenOn to false because needShowAfterScreenOn of settings is false");
            arrayList.add("settings.needShowAfterScreenOn is false");
            needShowAfterScreenOn = false;
        }
        if (needShowAfterScreenOn && this.mMonitorUserPresentSupportLevel < 1) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]update needShowAfterNotificationBarPull to false because mMonitorUserPresentSupportLevel < SUPPORT_LEVEL_SUPPORT");
            arrayList.add("device not support monitor user present");
            needShowAfterScreenOn = false;
        }
        if (!needShowAfterNotificationBarPull && !needShowAfterScreenOn) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]needShowAfterNotificationBarPull and needShowAfterScreenOn is invalid, show notification directly");
            showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_SHOW_SUB_MODE_IS_INVALID + ":" + arrayList;
            return clientIntelligenceShowResult;
        }
        if (needShowAfterNotificationBarPull) {
            needShowAfterNotificationBarPull = AppStatusObserverForChildProcess.sIsInBackGround();
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]app is in background:  " + needShowAfterNotificationBarPull);
            if (!needShowAfterNotificationBarPull) {
                pushBody.mBdPushStr = "";
                arrayList.add(ClientIntelligenceShowResult.REASON_APP_IN_FOREGROUND);
            }
        }
        if (needShowAfterScreenOn) {
            boolean isScreenOn = this.mPowerManager.isScreenOn();
            boolean inKeyguardRestrictedInputMode = this.mKeyguardManager.inKeyguardRestrictedInputMode();
            needShowAfterScreenOn = !inKeyguardRestrictedInputMode ? !isScreenOn : inKeyguardRestrictedInputMode;
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]device is in keyguard restricted:  " + needShowAfterScreenOn);
            if (!needShowAfterScreenOn) {
                arrayList.add(ClientIntelligenceShowResult.REASON_DEVICE_IS_SCREEN_ON);
            }
        }
        if (!needShowAfterNotificationBarPull && !needShowAfterScreenOn) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]message be filtered,show directly");
            showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = arrayList.toString();
            return clientIntelligenceShowResult;
        }
        if (this.mPushNotificationMessageMapNeedToShow.size() >= getClientIntelligenceSettings().maxNumberOfAllowCache) {
            Logger.m278w("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2]cached message number reached to max");
            if (needShowAfterNotificationBarPull) {
                pushBody.mBdPushStr = "";
            }
            showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, false);
            clientIntelligenceShowResult.showByClientIntelligence = false;
            clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_REACHED_MAX_CACHE_NUMBER;
            return clientIntelligenceShowResult;
        }
        if (needShowAfterNotificationBarPull) {
            long localMessageId = pushNotificationMessage.getLocalMessageId();
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2] cache the msg of " + localMessageId + " to mPushNotificationMessageMapNeedToShowAfterNotificationBarPull");
            synchronized (this.mPushNotificationMessageMapNeedToShow) {
                this.mPushNotificationMessageMapNeedToShow.put(Long.valueOf(localMessageId), pushNotificationMessage);
            }
            startMonitorNotificationBarPull();
        }
        if (needShowAfterScreenOn) {
            long localMessageId2 = pushNotificationMessage.getLocalMessageId();
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithOldClientIntelligencePersonalStrategyV2] cache the msg of " + localMessageId2 + " to mPushNotificationMessageMapNeedToShowAfterScreenOn");
            synchronized (this.mPushNotificationMessageMapNeedToShow) {
                this.mPushNotificationMessageMapNeedToShow.put(Long.valueOf(localMessageId2), pushNotificationMessage);
            }
            startMonitorScreenOn();
        }
        clientIntelligenceShowResult.showByClientIntelligence = true;
        clientIntelligenceShowResult.reason = ClientIntelligenceShowResult.REASON_SUCCESS;
        return clientIntelligenceShowResult;
    }

    @Override // com.bytedance.push.client.intelligence.AbsSystemStatusMonitor
    void onUserPresent() {
        if (this.mMonitorUserPresentSupportLevel < 1) {
            this.mMonitorUserPresentSupportLevel = 1;
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onUserPresent] update  monitorUserPresentSupportLevel to support");
            ((LocalSettings) SettingsManager.obtain(this.mContext, LocalSettings.class)).setMonitorUserPresentSupportLevel(1);
        }
        synchronized (this.mPushNotificationMessageMapNeedToShow) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Long, PushNotificationMessage> entry : this.mPushNotificationMessageMapNeedToShow.entrySet()) {
                if (getClientIntelligenceSettings().needShowAfterScreenOn(entry.getValue().getPushBody().clientIntelligencePushShowSubMode)) {
                    arrayList.add(entry.getKey());
                }
            }
            if (arrayList.size() > 0) {
                showMessageWithInterval(arrayList);
            }
        }
    }

    @Override // com.bytedance.push.client.intelligence.AbsSystemStatusMonitor
    void onNotificationBarPull() {
        if (this.mMonitorNotificationBarSupportLevel < 1) {
            this.mMonitorNotificationBarSupportLevel = 1;
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onUserPresent] update  monitorNotificationBarSupportLevel to support");
            ((LocalSettings) SettingsManager.obtain(this.mContext, LocalSettings.class)).setMonitorNotificationBarSupportLevel(1);
        }
        synchronized (this.mPushNotificationMessageMapNeedToShow) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Long, PushNotificationMessage> entry : this.mPushNotificationMessageMapNeedToShow.entrySet()) {
                if (getClientIntelligenceSettings().needShowAfterNotificationBarPull(entry.getValue().getPushBody().clientIntelligencePushShowSubMode)) {
                    arrayList.add(entry.getKey());
                }
            }
            if (arrayList.size() > 0) {
                showMessageWithInterval(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPushWithOldClientIntelligencePersonalStrategy(PushNotificationMessage pushNotificationMessage) {
        if (!curIsLowCtr()) {
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] cur is not  low ctr, show notification directly");
            showNotification(pushNotificationMessage.from, pushNotificationMessage.getPushBody(), pushNotificationMessage.handleBySdk);
            return;
        }
        long localMessageId = pushNotificationMessage.getLocalMessageId();
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] cur is low ctr, put " + localMessageId + " to mPushNotificationMessageMapNeedToShow");
        synchronized (this.mPushNotificationMessageMapNeedToShow) {
            this.mPushNotificationMessageMapNeedToShow.put(Long.valueOf(localMessageId), pushNotificationMessage);
            if (this.mPushNotificationMessageMapNeedToShow.size() == 1) {
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] send  MSG_WHAT_CHECK_CLIENT_STATUS delay " + getClientIntelligenceSettings().checkClientFeatureIntervalInMill);
                this.mHandler.sendEmptyMessageDelayed(2091558, getClientIntelligenceSettings().checkClientFeatureIntervalInMill);
            }
        }
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceStrategyOnChildThread] send MSG_WHAT_SHOW_NOTIFICATION_AFTER_TIMEOUT for  " + localMessageId + " delay " + getClientIntelligenceSettings().maxShowDelayTimeInMill);
        Message obtainMessage = this.mHandler.obtainMessage(2091559, Long.valueOf(localMessageId));
        long currentTimeMillis = getClientIntelligenceSettings().maxShowDelayTimeInMill - (ToolUtils.currentTimeMillis() - pushNotificationMessage.arriveTime);
        if (currentTimeMillis < 0) {
            currentTimeMillis = 0;
        }
        this.mHandler.sendMessageDelayed(obtainMessage, currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPushWithClientIntelligenceModelStrategy(PushNotificationMessage pushNotificationMessage, boolean z) {
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceModelStrategy] isRetry:" + z);
        PushServiceManager.get().getIClientAiExternalService().runTask(pushNotificationMessage.buildPitayaTaskParams());
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showPushWithClientIntelligenceModelStrategy] finish isRetry:" + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotification(int i, PushBody pushBody, boolean z, boolean z2) {
        showNotification(i, pushBody, z, z2, null);
    }

    private void showNotification(int i, PushBody pushBody, boolean z, boolean z2, String str) {
        boolean z3;
        if (pushBody.messageExpiredTime < System.currentTimeMillis()) {
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showNotification] message expired , not show !");
            z3 = true;
        } else {
            z3 = false;
        }
        PushSupporter.get().getPushHandler().showNotification(i, pushBody, z, z2, z3, str, -1L);
    }

    private void showNotification(int i, PushBody pushBody, boolean z, String str) {
        showNotification(i, pushBody, z, true, str);
    }

    private void showNotification(int i, PushBody pushBody, boolean z) {
        showNotification(i, pushBody, z, true);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2091558:
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[handleMessage of MSG_WHAT_CHECK_CLIENT_STATUS] start check cur client status ");
                ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ClientIntelligenceServiceImpl.this.checkClientStatusForMessageShow();
                    }
                });
                return true;
            case 2091559:
                long longValue = ((Long) message.obj).longValue();
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[handleMessage of MSG_WHAT_SHOW_NOTIFICATION_AFTER_TIMEOUT] show message " + longValue + " because timeout");
                showCachedMessage(longValue);
                return true;
            case 2091560:
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[handleMessage of MSG_WHAT_SHOW_CACHED_MESSAGE] show message ");
                showCachedMessage(((Long) message.obj).longValue());
                return false;
            default:
                return false;
        }
    }

    private void showCachedMessage(long j) {
        PushNotificationMessage pushNotificationMessage;
        String str;
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showCachedMessage] localMessageId is  " + j);
        synchronized (this.mPushNotificationMessageMapNeedToShow) {
            pushNotificationMessage = this.mPushNotificationMessageMapNeedToShow.get(Long.valueOf(j));
            this.mPushNotificationMessageMapNeedToShow.remove(Long.valueOf(j));
        }
        if (pushNotificationMessage != null) {
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showCachedMessage] finally show message: " + j);
            if (getClientIntelligenceSettings().needShowAfterScreenOn(pushNotificationMessage.getPushBody().clientIntelligencePushShowSubMode)) {
                str = ISignalReportConstants.KEY_SCREEN_STATUS_SCREEN_ON;
            } else {
                str = getClientIntelligenceSettings().needShowAfterNotificationBarPull(pushNotificationMessage.getPushBody().clientIntelligencePushShowSubMode) ? "notification_bar" : null;
            }
            showNotification(pushNotificationMessage.from, pushNotificationMessage.getPushBody(), pushNotificationMessage.handleBySdk, str);
            return;
        }
        Logger.m271e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[showCachedMessage] message with localMessageId " + j + " is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkClientStatusForMessageShow() {
        if (curIsLowCtr()) {
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[checkClientStatusForMessageShow] cur is low ctr");
            if (this.mPushNotificationMessageMapNeedToShow.size() > 0) {
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[checkClientStatusForMessageShow] message need to show size is not 0, send next MSG_WHAT_CHECK_CLIENT_STATUS delay " + getClientIntelligenceSettings().checkClientFeatureIntervalInMill);
                this.mHandler.removeMessages(2091558);
                this.mHandler.sendEmptyMessageDelayed(2091558, getClientIntelligenceSettings().checkClientFeatureIntervalInMill);
                return;
            } else {
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[checkClientStatusForMessageShow]  message need to show size is 0, cancel all MSG_WHAT_CHECK_CLIENT_STATUS");
                this.mHandler.removeMessages(2091558);
                return;
            }
        }
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[checkClientStatusForMessageShow] cur is not low ctr, show the cached message");
        synchronized (this.mPushNotificationMessageMapNeedToShow) {
            showMessageWithInterval(this.mPushNotificationMessageMapNeedToShow.keySet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessageWithInterval(Collection<Long> collection) {
        long j = 0;
        int i = 1;
        for (Long l : collection) {
            if (i > getClientIntelligenceSettings().maxNumberOfMessageShowAtTheSameTime) {
                j += getClientIntelligenceSettings().minMessageShowIntervalInMill;
            }
            Message obtainMessage = this.mHandler.obtainMessage(2091560, l);
            Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[checkClientStatusForMessageShow] show " + l + " after " + j + " mill");
            this.mHandler.sendMessageDelayed(obtainMessage, j);
            i++;
        }
    }

    public void onPushShow(final long j) {
        ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.6
            @Override // java.lang.Runnable
            public void run() {
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onPushShow] ruleId64 is " + j);
                PushNotificationMessage pushNotificationMessage = MultiProcessPushMessageDatabaseHelper.getInstance(ClientIntelligenceServiceImpl.this.mContext).getPushNotificationMessage(j);
                if (pushNotificationMessage != null) {
                    synchronized (ClientIntelligenceServiceImpl.this.mPushNotificationMessageMapNeedToShow) {
                        ClientIntelligenceServiceImpl.this.mPushNotificationMessageMapNeedToShow.remove(Long.valueOf(pushNotificationMessage.getLocalMessageId()));
                    }
                    ClientIntelligenceServiceImpl.this.showNotification(pushNotificationMessage.from, pushNotificationMessage.getPushBody(), pushNotificationMessage.handleBySdk, true);
                }
            }
        });
    }

    public LocalPushClientIntelligenceSettingsModel getLocalPushClientIntelligenceSettings() {
        return getClientIntelligenceSettings().localPushClientIntelligenceSettingsModel;
    }

    public boolean curIsHighCtr() {
        Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "start judge curIsHighCtr or not");
        if (System.currentTimeMillis() - this.mLastJudgeHighCtrTimeStamp < getLocalPushClientIntelligenceSettings().checkClientFeatureIntervalInMill) {
            return this.mCurIsHighCtr;
        }
        this.mLastJudgeHighCtrTimeStamp = System.currentTimeMillis();
        this.mCurIsHighCtr = false;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        FeatureCollectionHelper.getInstance(this.mContext).getFeatureForLocalPush(new ILocalPushClientFeatureCallback() { // from class: com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl.7
            @Override // com.bytedance.push.client.intelligence.ILocalPushClientFeatureCallback
            public void onNullFeatureCallback() {
                Logger.m271e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "cur is not low Ctr because onNullFeatureCallback");
                ClientIntelligenceServiceImpl.this.mCurIsHighCtr = false;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.push.client.intelligence.ILocalPushClientFeatureCallback
            public void onFeatureCallback(boolean z, boolean z2, boolean z3) {
                ClientIntelligenceServiceImpl.this.mCurIsHighCtr = (z || z2) && !z3;
                Logger.m268d("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "[onFeatureCallback] mCurIsHighCtr is " + ClientIntelligenceServiceImpl.this.mCurIsHighCtr + " because isUsingEarPhone: " + z + " isScreenOn:" + z2 + " isMusicActive:" + z3);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().featureCollectTimeOutInMill + 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.mCurIsHighCtr;
    }
}
