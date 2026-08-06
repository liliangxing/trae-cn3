package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.p014e.AbstractC0886c;
import com.heytap.mcssdk.p015f.InterfaceC0890c;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;

/* renamed from: com.heytap.mcssdk.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0875c {
    /* renamed from: a */
    public static void m582a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        String str;
        if (context == null) {
            str = "context is null , please check param of parseIntent()";
        } else if (intent == null) {
            str = "intent is null , please check param of parseIntent()";
        } else if (iDataMessageCallBackService == null) {
            str = "callback is null , please check param of parseIntent()";
        } else {
            if (Utils.isSupportPushByClient(context)) {
                List<BaseMode> m635a = AbstractC0886c.m635a(context, intent);
                if (m635a == null) {
                    return;
                }
                for (BaseMode baseMode : m635a) {
                    if (baseMode != null) {
                        for (InterfaceC0890c interfaceC0890c : PushService.getInstance().getProcessors()) {
                            if (interfaceC0890c != null) {
                                interfaceC0890c.mo638a(context, baseMode, iDataMessageCallBackService);
                            }
                        }
                    }
                }
                return;
            }
            str = "push is null ,please check system has push";
        }
        C0895d.m673e(str);
    }
}
