package com.bytedance.sdk.account.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.account.api.callback.UpdateTokenCallback;
import com.bytedance.sdk.account.api.response.UpdateTokenResponse;
import com.bytedance.sdk.account.constants.UserInfoThreadConstants;
import com.bytedance.sdk.account.job.UpdateTokenJob;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.ss.android.account.TTAccountInit;
import com.ss.android.token.TTTokenHeader;
import com.ss.android.token.TTTokenManager;
import com.ss.android.token.TTTokenMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SessionDropManager {
    private static volatile SessionDropManager sSessionDropManager;
    private final BDAccountManager mBDAccountManager;
    private volatile boolean mIsSessionDroppingLock;
    private SessionMessage mSessionMessage;

    private SessionDropManager(BDAccountManager bDAccountManager) {
        this.mBDAccountManager = bDAccountManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SessionDropManager getInstance() {
        return sSessionDropManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SessionDropManager getInstance(BDAccountManager bDAccountManager) {
        if (sSessionDropManager == null) {
            synchronized (SessionDropManager.class) {
                if (sSessionDropManager == null) {
                    sSessionDropManager = new SessionDropManager(bDAccountManager);
                }
            }
        }
        return sSessionDropManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void onReceiveLongConnectionMessage(String str) {
        SessionMessage parseMessage = parseMessage(str);
        monitorReceiveMessageEvent(parseMessage);
        if (this.mIsSessionDroppingLock) {
            return;
        }
        if (this.mBDAccountManager.isLogin()) {
            if (parseMessage == null) {
                return;
            }
            if (parseMessage.degrade) {
                return;
            }
            if (!TTAccountInit.getConfig().isSupportMultiLogin() || parseMessage.userId == this.mBDAccountManager.getUserId()) {
                this.mSessionMessage = parseMessage;
                TTTokenManager.stopUpdateToken();
                this.mIsSessionDroppingLock = true;
                startTokenBeat();
            }
        }
    }

    void onTokenBeatFinish(boolean z, String str, List<TTTokenHeader> list) {
        if (z) {
            TTTokenManager.onSessionDrop(str, list, true);
        } else {
            this.mSessionMessage = null;
        }
        TTTokenManager.startUpdateToken();
        this.mIsSessionDroppingLock = false;
    }

    public Pair<Integer, String> getSessionDropMessageAndClear() {
        if (this.mSessionMessage != null) {
            return new Pair<>(Integer.valueOf(this.mSessionMessage.protocolType), this.mSessionMessage.message);
        }
        this.mSessionMessage = null;
        return null;
    }

    private void startTokenBeat() {
        final String tokenBeatUrl = TTTokenManager.getTokenBeatUrl(false, false, "frontier");
        UpdateTokenJob.updateToken(this.mBDAccountManager.mContext, tokenBeatUrl, new UpdateTokenCallback() { // from class: com.bytedance.sdk.account.impl.SessionDropManager.1
            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(UpdateTokenResponse updateTokenResponse) {
                if (SessionDropManager.this.mSessionMessage != null) {
                    SessionDropManager sessionDropManager = SessionDropManager.this;
                    sessionDropManager.monitorMessageError(sessionDropManager.mSessionMessage.protocolType);
                }
                SessionDropManager.this.onTokenBeatFinish(false, tokenBeatUrl, null);
            }

            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onError(UpdateTokenResponse updateTokenResponse, int i) {
                if (updateTokenResponse != null && UserInfoThreadConstants.SESSION_EXPIRED.equalsIgnoreCase(updateTokenResponse.errorName)) {
                    ArrayList arrayList = new ArrayList();
                    if (updateTokenResponse.result != null && updateTokenResponse.result.optJSONObject("data") != null) {
                        String optString = updateTokenResponse.result.optJSONObject("data").optString("log_id");
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(new TTTokenHeader("X-TT-LOGID", optString));
                        }
                    }
                    SessionDropManager.this.onTokenBeatFinish(true, tokenBeatUrl, arrayList);
                    return;
                }
                TTTokenMonitor.monitorToken("tt_token_beat", (List) null, i, updateTokenResponse != null ? updateTokenResponse.mDetailErrorMsg : "");
                SessionDropManager.this.onTokenBeatFinish(false, tokenBeatUrl, null);
            }
        }).start();
    }

    SessionMessage parseMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SessionMessage sessionMessage = new SessionMessage();
            sessionMessage.message = jSONObject.optString("message");
            sessionMessage.protocolType = jSONObject.optInt("protocol_type");
            sessionMessage.logId = jSONObject.optString("log_id");
            sessionMessage.degrade = jSONObject.optBoolean("degrade");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject != null) {
                sessionMessage.deviceName = optJSONObject.optString("device_name");
                sessionMessage.userName = optJSONObject.optString("user_name");
                sessionMessage.userId = optJSONObject.optLong("user_id");
            }
            return sessionMessage;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    void monitorReceiveMessageEvent(SessionMessage sessionMessage) {
        if (sessionMessage != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("logId", sessionMessage.logId);
                jSONObject.put("protocol_type", sessionMessage.protocolType);
                jSONObject.put("is_login", this.mBDAccountManager.isLogin());
                jSONObject.put("user_id", this.mBDAccountManager.getUserId());
                AccountMonitorUtil.onEventV3("passport_receive_frontier_message", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void monitorMessageError(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocol_type", i);
            AccountMonitorUtil.onEventV3("passport_frontier_message_error", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class SessionMessage {
        boolean degrade;
        String deviceName;
        String logId;
        String message;
        int protocolType;
        long userId;
        String userName;

        SessionMessage() {
        }
    }
}
