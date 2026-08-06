package com.vivo.push.p017h;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.lynx.tasm.core.ResManager;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.ttm.player.C0968C;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1306m;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.p010b.C1219p;
import com.vivo.push.p010b.C1228y;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.C1394u;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* compiled from: NotifyInnerClientClickTask.java */
/* renamed from: com.vivo.push.h.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1278d extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1278d(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1 A[Catch: Exception -> 0x01b9, TryCatch #0 {Exception -> 0x01b9, blocks: (B:19:0x00b6, B:21:0x00bd, B:23:0x00c7, B:25:0x00d3, B:30:0x00e1, B:31:0x01ac, B:34:0x00f3, B:36:0x0106, B:38:0x0110, B:39:0x0120, B:42:0x0131, B:44:0x0137, B:46:0x0143, B:48:0x0166, B:50:0x016c, B:51:0x0173, B:53:0x0192, B:55:0x0196, B:56:0x0129), top: B:18:0x00b6 }] */
    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo702a(AbstractC1400v abstractC1400v) {
        Intent intent;
        boolean z;
        C1219p c1219p = (C1219p) abstractC1400v;
        if (c1219p == null) {
            C1393t.m1048d("NotifyInnerClientTask", "current onNotifyArrivedCommand is null");
            return;
        }
        InsideNotificationItem m616g = c1219p.m616g();
        if (m616g == null) {
            C1393t.m1048d("NotifyInnerClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage m1051a = C1394u.m1051a(m616g);
        boolean equals = this.f625a.getPackageName().equals(c1219p.m614e());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f625a);
        }
        if (equals) {
            C1228y c1228y = new C1228y(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, "2");
            hashMap.put("messageID", String.valueOf(c1219p.m615f()));
            hashMap.put(PushCommonConstants.KEY_PLATFORM, this.f625a.getPackageName());
            String mo854a = C1313a.m810a().m815e().mo854a();
            if (!TextUtils.isEmpty(mo854a)) {
                hashMap.put("remoteAppId", mo854a);
            }
            c1228y.m636a(hashMap);
            C1306m.m762a().m776a(c1228y);
            C1393t.m1048d("NotifyInnerClientTask", "notification is clicked by skip type[" + m1051a.getSkipType() + "]");
            C1393t.m1048d("NotifyInnerClientTask", "notification is clicked by skip content[" + m1051a.getSkipContent() + "]");
            try {
                if (m1051a.getSkipType() == 2) {
                    String skipContent = m1051a.getSkipContent();
                    if (!TextUtils.isEmpty(skipContent)) {
                        String lowerCase = skipContent.toLowerCase();
                        if (lowerCase.startsWith(ResManager.HTTP_SCHEME) || lowerCase.startsWith("https://")) {
                            z = true;
                            if (z) {
                                return;
                            }
                            intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent));
                            intent.setFlags(C0968C.ENCODING_PCM_MU_LAW);
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else {
                    intent = new Intent(c1219p.m617h());
                    if (!TextUtils.isEmpty(c1219p.m618i()) && !TextUtils.isEmpty(c1219p.m619j())) {
                        intent.setComponent(new ComponentName(c1219p.m618i(), c1219p.m619j()));
                    }
                    String packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
                    if (!TextUtils.isEmpty(packageName) && !this.f625a.getPackageName().equals(packageName)) {
                        C1393t.m1034a("NotifyInnerClientTask", "inner activity component error : local pkgName is " + this.f625a.getPackageName() + "; but remote pkgName is " + packageName);
                        return;
                    }
                    if (c1219p.m620k() != null) {
                        intent.setData(c1219p.m620k());
                    }
                    intent.setSelector(null);
                    intent.setPackage(this.f625a.getPackageName());
                    intent.addFlags(335544320);
                    ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.f625a.getPackageManager(), 65536);
                    if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                        C1393t.m1048d("NotifyInnerClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                    }
                }
                intent.putExtras(c1219p.m621l());
                this.f625a.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C1393t.m1034a("NotifyInnerClientTask", "notify is " + m1051a + " ; isMatch is " + equals);
    }
}
