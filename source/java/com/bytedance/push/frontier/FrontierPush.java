package com.bytedance.push.frontier;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.frontier.interfaze.IFrontierService;
import com.bytedance.push.frontier.wschannel.WsChannelManager;
import com.bytedance.push.utils.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FrontierPush implements OnMessageReceiveListener {
    public static int METHOD_ID = 1777;
    public static int SERVICE_ID = 1777;
    private static volatile FrontierPush mFrontierPushIns;
    private final Context mContext;
    private FrontierStrategy mFrontierStrategy;
    private AtomicReference<IFrontierService> mIFrontierService = new AtomicReference<>();
    private final AtomicBoolean mRegisterFinished = new AtomicBoolean(false);
    private boolean mEnableReceivePush = false;
    private String mSessionId = "";

    public void onReceiveConnectEvent(ConnectEvent connectEvent, JSONObject jSONObject) {
    }

    private FrontierPush(Context context) {
        this.mContext = context;
    }

    public static FrontierPush getIns(Context context) {
        if (mFrontierPushIns == null) {
            synchronized (FrontierPush.class) {
                if (mFrontierPushIns == null) {
                    mFrontierPushIns = new FrontierPush(context);
                }
            }
        }
        return mFrontierPushIns;
    }

    @Deprecated
    public void init(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSessionId = str;
    }

    public void updateSessionId(String str) {
        if (TextUtils.equals(this.mSessionId, str)) {
            return;
        }
        this.mSessionId = str;
        if (this.mIFrontierService.get() == null || !(this.mIFrontierService.get() instanceof WsChannelManager)) {
            return;
        }
        ((WsChannelManager) this.mIFrontierService.get()).onSessionIdUpdated(str);
    }

    public boolean isPushAvailable() {
        this.mFrontierStrategy = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getFrontierMode();
        IFrontierService frontierService = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getFrontierService();
        if (frontierService != null) {
            setFrontierServiceInternal(frontierService);
        }
        return this.mFrontierStrategy != FrontierStrategy.STRATEGY_NOT_USE && ((this.mFrontierStrategy == FrontierStrategy.STRATEGY_USE_HOST && this.mIFrontierService.get() != null) || this.mFrontierStrategy == FrontierStrategy.STRATEGY_USE_SDK);
    }

    @Deprecated
    public void setFrontierService(IFrontierService iFrontierService) {
        setFrontierServiceInternal(iFrontierService);
    }

    private void setFrontierServiceInternal(IFrontierService iFrontierService) {
        UByte$.ExternalSyntheticBackport0.m(this.mIFrontierService, (Object) null, iFrontierService);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean registerPush() {
        String sessionId = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getSessionId();
        if (!TextUtils.isEmpty(sessionId)) {
            this.mSessionId = sessionId;
        }
        if (this.mFrontierStrategy == FrontierStrategy.STRATEGY_USE_SDK) {
            this.mIFrontierService.set(WsChannelManager.getIns(this.mContext, this.mSessionId));
        }
        IFrontierService iFrontierService = this.mIFrontierService.get();
        if (iFrontierService == null) {
            return false;
        }
        this.mEnableReceivePush = true;
        iFrontierService.registerFrontierPush(this);
        return true;
    }

    public void onReceiveMsg(WsChannelMsg wsChannelMsg) {
        if (wsChannelMsg == null || !this.mEnableReceivePush) {
            return;
        }
        if ((this.mFrontierStrategy == FrontierStrategy.STRATEGY_USE_HOST || wsChannelMsg.getChannelId() == 10006) && SERVICE_ID == wsChannelMsg.getService() && METHOD_ID == wsChannelMsg.getMethod()) {
            try {
                String str = new String(wsChannelMsg.getPayload());
                Logger.m273i("received message:".concat(str));
                PushSupporter.pushHandler().handlePassThroughMsg(str, FrontierPushAdapter.getFrontierPush(), (String) null);
            } catch (Throwable unused) {
            }
        }
    }

    public void unRegisterPush() {
        this.mEnableReceivePush = false;
        if (this.mIFrontierService.get() != null) {
            this.mIFrontierService.get().unRegisterFrontierPush();
        }
    }
}
