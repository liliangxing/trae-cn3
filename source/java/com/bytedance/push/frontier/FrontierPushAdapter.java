package com.bytedance.push.frontier;

import android.content.Context;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.ss.android.message.AppProvider;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FrontierPushAdapter implements IPushAdapter {
    private static int FRONTIER_PUSH = -1;

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        return true;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean requestRemoveVoipNotification(Context context, int i) {
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void setAlias(Context context, String str, int i) {
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void trackPush(Context context, int i, Object obj) {
    }

    public static int getFrontierPush() {
        if (FRONTIER_PUSH == -1) {
            FRONTIER_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(FrontierPushAdapter.class.getName());
        }
        return FRONTIER_PUSH;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean isPushAvailable(Context context, int i) {
        return i == getFrontierPush() && FrontierPush.getIns(context).isPushAvailable();
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void registerPush(Context context, int i) {
        if (FrontierPush.getIns(context).registerPush()) {
            PushSupporter.monitor().monitorRegisterSenderSuccess(i);
        } else {
            PushSupporter.monitor().monitorRegisterSenderFailed(i, 104, "-1", "register frontier push failed");
        }
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void unregisterPush(Context context, int i) {
        FrontierPush.getIns(context).unRegisterPush();
    }
}
