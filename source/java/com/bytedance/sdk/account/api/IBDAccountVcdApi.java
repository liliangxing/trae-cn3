package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.api.callback.vcd.GetVcdAccountCallback;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdAuthAccountCallback;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdLoginTicketCallback;
import com.bytedance.sdk.account.api.callback.vcd.SwitchVcdAccountCallback;
import com.bytedance.sdk.account.api.callback.vcd.VcdAuthorizeCallback;
import com.bytedance.sdk.account.api.callback.vcd.VcdLoginByTicketCallback;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccountVcdApi {
    void getVcdAuthAccount(GetVcdAuthAccountCallback getVcdAuthAccountCallback);

    void getVcdLoginTicket(GetVcdLoginTicketCallback getVcdLoginTicketCallback);

    void getVcdUserInfoByTicket(String str, Map map, GetVcdAccountCallback getVcdAccountCallback);

    void switchVcdAccount(long j, Map map, SwitchVcdAccountCallback switchVcdAccountCallback);

    void vcdAuthorize(Long l, Boolean bool, String str, VcdAuthorizeCallback vcdAuthorizeCallback);

    void vcdLoginByTicket(String str, Map map, VcdLoginByTicketCallback vcdLoginByTicketCallback);
}
