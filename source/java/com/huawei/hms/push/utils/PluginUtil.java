package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.webx.addr.AddressParam;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.C1219i;
import com.huawei.hms.push.C1222l;
import com.huawei.hms.push.C1223m;
import com.huawei.hms.push.C1231r;
import com.huawei.hms.push.C1233t;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PluginUtil {
    private PluginUtil() {
    }

    /* renamed from: a */
    private static void m2052a(Context context, String str, String str2, String str3) {
        HMSLog.m2120i("PluginUtil", "onNotification");
        if (!C1219i.m1961a(context)) {
            HMSLog.m2120i("PluginUtil", context.getPackageName() + " disable display notification.");
            C1222l.m1967a(context, str, null, "103");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        Charset charset = C1223m.f1692a;
        intent.putExtra("selfshow_info", str3.getBytes(charset));
        intent.putExtra("selfshow_token", str2.getBytes(charset));
        intent.setPackage(context.getPackageName());
        C1233t.m2038a(context, intent);
        HMSLog.m2120i("PluginUtil", "invokeSelfShow done");
    }

    public static void onAppOpened(Context context, String str, String str2, Bundle bundle) {
        C1222l.m1967a(context, str, str2, "appHasOpenedId");
        C1222l.m1966a(context, bundle, "hmsStatistics");
    }

    public static boolean onDataMessage(Context context, String str, String str2, boolean z) {
        HMSLog.m2120i("PluginUtil", "onDataMessage");
        if (TextUtils.isEmpty(str2)) {
            HMSLog.m2120i("PluginUtil", "Empty message received");
            return true;
        }
        if (z) {
            m2051a(context, str);
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_id", str);
        bundle.putByteArray(RemoteMessageConst.MSGBODY, str2.getBytes(C1223m.f1692a));
        bundle.putString(RemoteMessageConst.MSGTYPE, "received_message");
        return new C1231r().m2035a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        HMSLog.m2120i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        bundle.putString(RemoteMessageConst.MSGTYPE, "server_deleted_message");
        return new C1231r().m2035a(context, bundle, intent);
    }

    public static void onMessage(Context context, String[] strArr) {
        HMSLog.m2120i("PluginUtil", "onMessage");
        if (context == null || strArr == null || strArr.length < 5) {
            return;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        if (m2054a(context, strArr)) {
            m2052a(context, strArr[0], strArr[3], strArr[4]);
        } else {
            onDataMessage(context, strArr[0], strArr[4], true);
        }
    }

    public static boolean onNewToken(Context context, String str, String str2, ErrorEnum errorEnum) {
        HMSLog.m2120i("PluginUtil", "onNewToken called.");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt("error", errorEnum.getInternalCode());
        bundle.putString(RemoteMessageConst.MSGTYPE, "new_token");
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, str);
        if (TextUtils.equals(str2, context.getPackageName())) {
            bundle.putString("subjectId", null);
        } else {
            bundle.putString("subjectId", str2);
        }
        bundle.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        return new C1231r().m2035a(context, bundle, intent);
    }

    public static void onNotificationArrived(Context context, String str, String str2) {
        C1222l.m1967a(context, str, str2, "100");
    }

    public static void onNotificationClicked(Context context, String str, String str2) {
        C1222l.m1967a(context, str, str2, "1");
        onAppOpened(context, str, str2, null);
    }

    public static boolean onOldDataMessage(Context context, String str, String str2) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
        return onDataMessage(context, str, m2050a(str2), true);
    }

    public static void saveNotifySwitch(Context context, boolean z) {
        new PushPreferences(context, "push_notify_flag").saveBoolean("notify_msg_enable", z);
    }

    /* renamed from: a */
    private static String m2050a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", str);
            jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException unused) {
            HMSLog.m2118e("PluginUtil", "rebuild message failed");
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m2053a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            HMSLog.m2121w("PluginUtil", "get running app processes null!");
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                int i = runningAppProcessInfo.importance;
                return (i == 100 || i == 200) ? false : true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2054a(Context context, String[] strArr) {
        if (TextUtils.equals(strArr[1], AddressParam.TYPE_DISAPPROVE)) {
            return m2053a(context) || TextUtils.equals(strArr[2], "1");
        }
        return false;
    }

    /* renamed from: a */
    private static void m2051a(Context context, String str) {
        C1222l.m1967a(context, str, null, "102");
    }
}
