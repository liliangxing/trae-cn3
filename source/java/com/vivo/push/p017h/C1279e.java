package com.vivo.push.p017h;

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
import com.vivo.push.C1357t;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.p010b.C1219p;
import com.vivo.push.p010b.C1228y;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.C1394u;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* renamed from: com.vivo.push.h.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1279e extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1279e(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    public final void mo702a(AbstractC1400v abstractC1400v) {
        Intent parseUri;
        String str;
        C1219p c1219p = (C1219p) abstractC1400v;
        InsideNotificationItem m616g = c1219p.m616g();
        if (m616g == null) {
            C1393t.m1048d("NotifyOpenClientTask", "current notification item is null");
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
            C1393t.m1048d("NotifyOpenClientTask", "notification is clicked by skip type[" + m1051a.getSkipType() + "]");
            int skipType = m1051a.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new RunnableC1280f(this, this.f625a, m1051a.getParams())).start();
                m717a(m1051a);
                return;
            }
            if (skipType == 2) {
                String skipContent = m1051a.getSkipContent();
                if (!skipContent.startsWith(ResManager.HTTP_SCHEME) && !skipContent.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(C0968C.ENCODING_PCM_MU_LAW);
                    m718b(intent, m1051a.getParams());
                    try {
                        this.f625a.startActivity(intent);
                    } catch (Exception unused) {
                        C1393t.m1034a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    C1393t.m1034a("NotifyOpenClientTask", "url not legal");
                }
                m717a(m1051a);
                return;
            }
            if (skipType == 3) {
                m717a(m1051a);
                return;
            }
            if (skipType == 4) {
                String skipContent2 = m1051a.getSkipContent();
                try {
                    parseUri = Intent.parseUri(skipContent2, 1);
                    str = parseUri.getPackage();
                } catch (Exception e) {
                    C1393t.m1035a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e);
                }
                if (!TextUtils.isEmpty(str) && !this.f625a.getPackageName().equals(str)) {
                    C1393t.m1034a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f625a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.f625a.getPackageName().equals(packageName)) {
                    C1393t.m1034a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f625a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                parseUri.setSelector(null);
                parseUri.setPackage(this.f625a.getPackageName());
                parseUri.addFlags(335544320);
                m718b(parseUri, m1051a.getParams());
                ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f625a.getPackageManager(), 65536);
                if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                    C1393t.m1034a("NotifyOpenClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                    return;
                } else {
                    this.f625a.startActivity(parseUri);
                    m717a(m1051a);
                    return;
                }
            }
            C1393t.m1034a("NotifyOpenClientTask", "illegitmacy skip type error : " + m1051a.getSkipType());
            return;
        }
        C1393t.m1034a("NotifyOpenClientTask", "notify is " + m1051a + " ; isMatch is " + equals);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static Intent m718b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    /* renamed from: a */
    private void m717a(UPSNotificationMessage uPSNotificationMessage) {
        C1357t.m917b(new RunnableC1281g(this, uPSNotificationMessage));
    }
}
