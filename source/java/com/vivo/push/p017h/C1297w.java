package com.vivo.push.p017h;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.vivo.push.C1306m;
import com.vivo.push.PushClient;
import com.vivo.push.p017h.C1295u;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1379f;
import com.vivo.push.util.C1393t;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnNotificationArrivedReceiveTask.java */
/* renamed from: com.vivo.push.h.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1297w implements C1295u.a {

    /* renamed from: a */
    final /* synthetic */ RunnableC1296v f494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1297w(RunnableC1296v runnableC1296v) {
        this.f494a = runnableC1296v;
    }

    @Override // com.vivo.push.p017h.C1295u.a
    /* renamed from: a */
    public final void mo735a() {
        long m796k = C1306m.m762a().m796k();
        if (m796k < 1400 && m796k != 1340) {
            C1393t.m1041b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(m796k)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", PushClient.DEFAULT_REQUEST_ID);
        hashMap.put("message_id", String.valueOf(this.f494a.f491b.m632h()));
        String mo854a = C1313a.m810a().m815e().mo854a();
        if (!TextUtils.isEmpty(mo854a)) {
            hashMap.put("app_id", mo854a);
        }
        hashMap.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, PushClient.DEFAULT_REQUEST_ID);
        hashMap.put("dtp", PushClient.DEFAULT_REQUEST_ID);
        C1379f.m995a(6L, (HashMap<String, String>) hashMap);
    }

    @Override // com.vivo.push.p017h.C1295u.a
    /* renamed from: b */
    public final void mo736b() {
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.f494a.f491b.m632h()));
        String mo854a = C1313a.m810a().m815e().mo854a();
        if (!TextUtils.isEmpty(mo854a)) {
            hashMap.put("remoteAppId", mo854a);
        }
        C1379f.m995a(2122L, (HashMap<String, String>) hashMap);
    }
}
