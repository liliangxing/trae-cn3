package com.bytedance.push.task;

import android.util.Pair;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.model.TokenCache;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.ApiConstants;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UploadFilterEventTask implements Runnable {
    private final int mFrom;
    private final PushBody mModel;

    public UploadFilterEventTask(int i, PushBody pushBody) {
        this.mFrom = i;
        this.mModel = pushBody;
    }

    @Override // java.lang.Runnable
    public void run() {
        String secUid;
        Logger.m277v(IPushService.TAG_PUSH_SHOW, "start to upload filter event");
        IAccountService iAccountService = PushSupporter.get().getConfiguration().mAccountService;
        String str = this.mModel.targetSecUid;
        TokenCache bySenderType = TokenStorage.getBySenderType(AppProvider.getApp(), this.mFrom);
        String str2 = "";
        String str3 = bySenderType != null ? bySenderType.token : "";
        Logger.m277v(IPushService.TAG_PUSH_SHOW, "token info = " + bySenderType);
        if (iAccountService != null && (secUid = iAccountService.getSecUid()) != null) {
            str2 = secUid;
        }
        String i = ApiConstants.i("/cloudpush/user_push_replace/");
        ToolUtils.addUrlParam(i, PushSupporter.get().getCommonParams());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("ttpush_sec_target_uid", str));
        arrayList.add(new Pair("local_sec_uid", str2));
        arrayList.add(new Pair("send_sdk", String.valueOf(this.mFrom)));
        arrayList.add(new Pair("token", str3));
        arrayList.add(new Pair("rid64", String.valueOf(this.mModel.rid64)));
        try {
            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
            reqContext.addCommonParams = false;
            Logger.m274i(IPushService.TAG_PUSH_SHOW, "upload filter event. result = " + NetworkClient.getDefault().post(i, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext));
        } catch (Throwable th) {
            Logger.m271e(IPushService.TAG_PUSH_SHOW, "upload filter event. result = " + th);
            th.printStackTrace();
        }
    }
}
