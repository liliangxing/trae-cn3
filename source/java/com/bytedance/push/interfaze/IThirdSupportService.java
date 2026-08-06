package com.bytedance.push.interfaze;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.util.Pair;
import com.bytedance.push.Keep;
import com.bytedance.push.third.ISendTokenCallBack;
import com.ss.android.push.Triple;
import com.ss.android.pushmanager.MessageConstants;
import java.io.IOException;
import java.util.zip.DataFormatException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IThirdSupportService extends Keep {
    public static final String KEY_PUSH_TOKEN_SENT = "push_token_sent";
    public static final String LOG_TYPE = "ss_push";
    public static final String SEND_PUSH_TOKEN_URL = MessageConstants.getSendPushTokenUrl();

    boolean allowPullUp(String str);

    boolean canKeepPackageAlive(Context context, String str);

    String getAdmPayloadName();

    String getFcmPayloadName();

    JSONObject getMessage(byte[] bArr, boolean z) throws DataFormatException, IOException;

    String getMessageV2(int i, byte[] bArr, boolean z) throws DataFormatException, IOException;

    Pair<String, String> getPushConfig(int i);

    String getToken(Context context, int i);

    Triple<String, String, String> getUmConfig();

    void hackJobHandler(Service service);

    boolean isMainProcess(Context context);

    void onClickNotPassThroughNotification(Context context, String str, int i, String str2);

    void registerSenderFailed(int i, String str, String str2);

    void registerSenderSuccessAndUploadToken(Context context, int i, String str);

    void sendMonitor(Context context, String str, JSONObject jSONObject);

    void sendToken(Context context, ISendTokenCallBack iSendTokenCallBack);

    boolean shouldShowUpgradeDialog(Activity activity);
}
