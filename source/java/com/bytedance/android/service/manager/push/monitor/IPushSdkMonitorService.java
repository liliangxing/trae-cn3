package com.bytedance.android.service.manager.push.monitor;

import android.content.Context;
import com.bytedance.push.monitor.ICommonPushSdkMonitorService;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IPushSdkMonitorService extends ICommonPushSdkMonitorService {
    public static final int ALLIANCE_USE_NEW_LOCAL_PUSH_API = 4096;
    public static final int ALLIANCE_USE_NEW_RED_BADGE_API = 256;
    public static final int BADGE_OPERATE_TYPE_ADD_NUMBER = 3;
    public static final int BADGE_OPERATE_TYPE_GET_NUMBER = 2;
    public static final int BADGE_OPERATE_TYPE_REDUCE_NUMBER = 4;
    public static final int BADGE_OPERATE_TYPE_SET_NUMBER = 1;
    public static final int ONLINE_USE_NEW_LOCAL_PUSH_API = 16;
    public static final int ONLINE_USE_NEW_RED_BADGE_API = 1;
    public static final int PROFILE_ID_OPERATE_TYPE_REMOVE = 2;
    public static final int PROFILE_ID_OPERATE_TYPE_SET = 1;

    boolean curIsDau();

    boolean curIsTransmit();

    void initOnApplication(Context context);

    void onActivityDepthsDeviceStatus(JSONObject jSONObject);

    void onActivityStartResult(boolean z, int i, String str, String str2, String str3, long j, String str4);

    void onActivityStartReturnValue(String str, JSONObject jSONObject, int i);

    void onBadgeOperateFailed(int i, Integer num, String str);

    void onBadgeOperateSuccess(int i, Integer num);

    void onContentRequest(String str, int i, int i2);

    void onContentShow(String str, String str2, int i);

    void onInvalidMrDepths(Context context, List<String> list);

    void onKeepAliveFrom(String str, String str2, int i);

    void onLaunchEvent(boolean z, boolean z2, long j, long j2, int i, int i2, String str);

    void onMessageArrive(long j);

    void onMessageShow(long j, long j2);

    void onProcessStartEvent(boolean z, boolean z2, long j, long j2, int i, int i2, String str, boolean z3);

    void onProfileIdOperateResult(int i, int i2, int i3, long j, String str);

    void onTokenRetry(int i, String str);

    void onTokenRetryResult(int i, boolean z, String str);

    void onTransmitStrategyRequest();
}
