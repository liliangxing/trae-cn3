package com.bytedance.push.task;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.model.TokenCache;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.user.UidTokenSynchronizer;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.account.IAccountService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SyncUidAndTokenTask implements Runnable {
    public static final String ACTION_PASSPORT_LOGIN = "passport_login";
    public static final String ACTION_PASSPORT_LOGOUT = "passport_logout";
    public static final String ACTION_PASSPORT_REFRESH = "passport_refresh";
    public static final String ACTION_PASSPORT_SWITCH = "passport_switch";
    private final String mAction;
    private final ISupport mSupport;

    public SyncUidAndTokenTask(ISupport iSupport, String str) {
        this.mSupport = iSupport;
        this.mAction = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (SendTokenTask.UPLOAD_TOKEN_LOCK) {
            syncToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
    
        if (r9.equals(com.bytedance.push.task.SyncUidAndTokenTask.ACTION_PASSPORT_SWITCH) == false) goto L23;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x00a7. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void syncToken() {
        NetworkClient.ReqContext reqContext;
        if (TextUtils.isEmpty(this.mAction)) {
            Logger.m268d(UidTokenSynchronizer.TAG, "action is null");
            return;
        }
        Application app = AppProvider.getApp();
        Map<Integer, TokenCache> allToken = TokenStorage.getAllToken(app);
        if (allToken == null || allToken.isEmpty()) {
            Logger.m268d(UidTokenSynchronizer.TAG, "token is empty");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<TokenCache> it = allToken.values().iterator();
        while (true) {
            String str = null;
            char c = 2;
            if (it.hasNext()) {
                TokenCache next = it.next();
                if (next == null || next.type <= 0 || TextUtils.isEmpty(next.token)) {
                    Logger.m268d(UidTokenSynchronizer.TAG, "invalid cache : " + next);
                } else {
                    IPushAdapter adapterInstance = PushChannelHelper.inst(app).getAdapterInstance(next.type);
                    Logger.m268d(UidTokenSynchronizer.TAG, "pushAdapter: " + adapterInstance + " mAction:" + this.mAction);
                    String str2 = this.mAction;
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -1797256964:
                            if (str2.equals(ACTION_PASSPORT_LOGIN)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 119615063:
                            if (str2.equals(ACTION_PASSPORT_LOGOUT)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 327471105:
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            str = PushSupporter.get().getIProfileIdService().onLogIn(adapterInstance);
                            break;
                        case 1:
                            PushSupporter.get().getIProfileIdService().onLogOut(adapterInstance);
                            break;
                        case 2:
                            str = PushSupporter.get().getIProfileIdService().onAccountSwitch(adapterInstance);
                            break;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sender_id", next.type);
                        jSONObject.put("token", next.token);
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject.put("profile_id", str);
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Map<String, String> commonParams = this.mSupport.getCommonParams();
                commonParams.put("update_event", this.mAction);
                String addUrlParam = ToolUtils.addUrlParam(MessageConstants.getSendPushTokenUrl(), commonParams);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("sender_token_list", jSONArray.toString()));
                arrayList.add(new Pair("push_sdk", PushChannelHelper.inst(app).buildApplogHeader().toString()));
                for (int i = 0; i < 2; i++) {
                    try {
                        Logger.m268d(UidTokenSynchronizer.TAG, "request url = " + addUrlParam);
                        reqContext = new NetworkClient.ReqContext();
                        reqContext.addCommonParams = false;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if ("success".equals(new JSONObject(NetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext)).optString("message"))) {
                        IAccountService service = UgBusFramework.getService(IAccountService.class);
                        Logger.m274i(UidTokenSynchronizer.TAG, "success sync uid-token to server,set last_sec_uid,accountService=" + service);
                        if (service != null) {
                            String secUid = service.getSecUid();
                            Logger.m274i(UidTokenSynchronizer.TAG, "success sync uid-token to server,set last_sec_uid,secUid=" + secUid);
                            PushSetting.getInstance().getLocalSettings().setLastSecUid(secUid);
                            return;
                        }
                        return;
                    }
                    continue;
                }
                return;
            }
        }
    }
}
