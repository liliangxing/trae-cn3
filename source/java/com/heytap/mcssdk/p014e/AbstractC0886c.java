package com.heytap.mcssdk.p014e;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.utils.C0893b;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.heytap.mcssdk.e.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0886c implements InterfaceC0887d {
    /* renamed from: a */
    public static List<BaseMode> m635a(Context context, Intent intent) {
        int i;
        BaseMode mo632a;
        if (intent == null) {
            return null;
        }
        try {
            i = Integer.parseInt(C0893b.m652d(intent.getStringExtra("type")));
        } catch (Exception e) {
            C0895d.m673e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            i = 4096;
        }
        C0895d.m661b("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (InterfaceC0887d interfaceC0887d : PushService.getInstance().getParsers()) {
            if (interfaceC0887d != null && (mo632a = interfaceC0887d.mo632a(context, i, intent)) != null) {
                arrayList.add(mo632a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected abstract BaseMode mo633a(Intent intent, int i);
}
