package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.lynx.tasm.core.ResManager;
import com.ss.ttm.player.C0968C;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Map;

/* compiled from: ConvertMsgToIntentImpl.java */
/* renamed from: com.vivo.push.util.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1382i extends AbstractC1375b {

    /* renamed from: e */
    private int f694e = 0;

    @Override // com.vivo.push.util.AbstractC1375b
    /* renamed from: a */
    protected final int mo974a() {
        return this.f694e;
    }

    @Override // com.vivo.push.util.AbstractC1375b
    /* renamed from: a */
    protected final Intent mo976a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return m1003b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.util.AbstractC1375b
    /* renamed from: a */
    public final PendingIntent mo975a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0126 A[Catch: Exception -> 0x01a2, TryCatch #1 {Exception -> 0x01a2, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003e, B:20:0x0168, B:23:0x0181, B:25:0x0049, B:26:0x0067, B:28:0x0085, B:59:0x00e6, B:60:0x00fa, B:61:0x0104, B:63:0x010e, B:65:0x011a, B:69:0x0126, B:70:0x014d, B:72:0x015e, B:73:0x0199, B:30:0x008a, B:32:0x009c, B:35:0x00a3, B:36:0x00ab, B:38:0x00b1, B:41:0x00b9, B:44:0x00bf, B:47:0x00cb, B:54:0x00db, B:56:0x00e1), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014d A[Catch: Exception -> 0x01a2, TryCatch #1 {Exception -> 0x01a2, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003e, B:20:0x0168, B:23:0x0181, B:25:0x0049, B:26:0x0067, B:28:0x0085, B:59:0x00e6, B:60:0x00fa, B:61:0x0104, B:63:0x010e, B:65:0x011a, B:69:0x0126, B:70:0x014d, B:72:0x015e, B:73:0x0199, B:30:0x008a, B:32:0x009c, B:35:0x00a3, B:36:0x00ab, B:38:0x00b1, B:41:0x00b9, B:44:0x00bf, B:47:0x00cb, B:54:0x00db, B:56:0x00e1), top: B:2:0x0005, inners: #0 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Intent m1003b(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        String packageName;
        Intent m1001a;
        int m998a;
        try {
            packageName = context.getPackageName();
        } catch (Exception e) {
            C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient parsing error : " + e.getMessage());
            this.f694e = 2159;
        }
        if (insideNotificationItem != null && !TextUtils.isEmpty(packageName)) {
            C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient getSkipType ：：" + insideNotificationItem.getSkipType());
            int skipType = insideNotificationItem.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                m1001a = m1001a(insideNotificationItem.getParams(), packageName, context);
            } else if (skipType == 2) {
                String skipContent = insideNotificationItem.getSkipContent();
                if (!TextUtils.isEmpty(skipContent)) {
                    String lowerCase = skipContent.toLowerCase();
                    if (!lowerCase.startsWith(ResManager.HTTP_SCHEME)) {
                        if (lowerCase.startsWith("https://")) {
                        }
                    }
                    if (!z) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(skipContent));
                        intent.setFlags(C0968C.ENCODING_PCM_MU_LAW);
                        m999a(intent, insideNotificationItem.getParams());
                        C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url urlAddr ::".concat(String.valueOf(skipContent)));
                        m1001a = intent;
                    } else {
                        C1393t.m1047c(context, " 跳转参数不合法，打开网页地址不符合要求 通知未展示 2157");
                        C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient url not legal");
                        this.f694e = 2157;
                        m1001a = null;
                    }
                }
                z = false;
                if (!z) {
                }
            } else if (skipType == 3) {
                String skipContent2 = insideNotificationItem.getSkipContent();
                C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + insideNotificationItem.getSkipContent());
                if (notifyArriveCallbackByUser.getIntent() != null) {
                    C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   not null  ");
                    try {
                        m1001a = notifyArriveCallbackByUser.getIntent();
                        m1001a.setSelector(null);
                        m1001a.setFlags(335544320);
                        Map<String, String> params = insideNotificationItem.getParams();
                        if (params != null && params.entrySet() != null) {
                            for (Map.Entry<String, String> entry : params.entrySet()) {
                                if (entry != null && entry.getKey() != null && !m1001a.hasExtra(entry.getKey())) {
                                    m1001a.putExtra(entry.getKey(), entry.getValue());
                                }
                            }
                        }
                        m998a = m998a(m1001a, packageName);
                    } catch (Exception e2) {
                        C1393t.m1035a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(skipContent2)), e2);
                        this.f694e = 2158;
                    }
                    if (m998a > 0) {
                        this.f694e = m998a;
                        m1001a = null;
                    }
                } else {
                    C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "notifyArriveCallbackByUser.getIntent()   is null 根据skipcontent生成跳转参数 ");
                    m1001a = m1000a(skipContent2, packageName, insideNotificationItem, context);
                }
            } else if (skipType == 4) {
                String skipContent3 = insideNotificationItem.getSkipContent();
                C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ：：" + insideNotificationItem.getSkipContent());
                m1001a = m1000a(skipContent3, packageName, insideNotificationItem, context);
            } else {
                C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : intent null");
                this.f694e = 2159;
                m1001a = null;
            }
            if (m1001a != null) {
                m1001a.putExtra("vivo_push_messageId", m978b());
                m1001a.putExtra("command_type", "reflect_receiver");
                m973a(m1001a, context);
                long j = this.f679b;
                this.f694e = 0;
                return m1001a;
            }
            C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient skip type error : " + insideNotificationItem.getSkipType());
            return null;
        }
        C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient notify == null");
        this.f694e = 2159;
        return null;
    }

    /* renamed from: a */
    private Intent m1000a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setSelector(null);
            parseUri.setPackage(str2);
            parseUri.setFlags(335544320);
            m999a(parseUri, insideNotificationItem.getParams());
            int m998a = m998a(parseUri, str2);
            if (m998a <= 0) {
                return parseUri;
            }
            this.f694e = m998a;
            C1393t.m1047c(context, " 落地页未找到，通知不展示：  " + this.f694e);
            return null;
        } catch (Exception e) {
            C1393t.m1035a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e);
            this.f694e = 2158;
            return null;
        }
    }

    /* renamed from: a */
    private Intent m1001a(Map<String, String> map, String str, Context context) {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
            if (intent != null) {
                intent.setFlags(335544320);
                m999a(intent, map);
            } else {
                this.f694e = 2162;
                C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e) {
            C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e.getMessage());
        }
        return intent;
    }

    /* renamed from: a */
    private static Intent m999a(Intent intent, Map<String, String> map) {
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
    private int m998a(Intent intent, String str) {
        int m997a = m997a(intent);
        C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(m997a)));
        if (m997a != 0) {
            return m997a;
        }
        int m1002b = m1002b(intent, str);
        C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(m1002b)));
        if (m1002b != 0) {
            return m1002b;
        }
        return 0;
    }

    /* renamed from: a */
    private int m997a(Intent intent) {
        if (intent.resolveActivityInfo(this.f680c.getPackageManager(), 65536) != null) {
            return 0;
        }
        C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        C1393t.m1047c(this.f680c, " 跳转参数对应的Activity找不到 通知不展示   2162");
        return 2162;
    }

    /* renamed from: b */
    private int m1002b(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder("checkSkipContentPackageFit intent = : ");
            Object obj = intent;
            if (intent == null) {
                obj = "";
            }
            C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", sb.append(obj).append(" mPkgName = ").append(str).toString());
            return 2158;
        }
        try {
            String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
            if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                return 0;
            }
            C1393t.m1048d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
            C1393t.m1038a(this.f680c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
            return 2813;
        } catch (Exception e) {
            C1393t.m1034a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e.getMessage());
            return 2158;
        }
    }
}
