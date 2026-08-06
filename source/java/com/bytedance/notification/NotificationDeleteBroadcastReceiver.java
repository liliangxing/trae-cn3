package com.bytedance.notification;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.helper.NotificationGroupHelper;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NotificationDeleteBroadcastReceiver extends BroadcastReceiver {
    public static final String DELETE_ACTION = ".pushsdk.notification.delete.action";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_GROUP = "group";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_MSG_TYPE = "msg_type";
    public static final String SMP_DELETE_ACTION = ".pushsdk.notification.delete.action.smp";
    public static final String VALUE_MSG_TYPE_NOTIFICATION = "notification";
    public static final String VALUE_MSG_TYPE_SUMMARY = "summary_notification";
    private static boolean sHasRegister;
    private final String TAG = "NotificationDeleteBroadcastReceiver";

    public boolean isDeleteAction(String str, Context context) {
        return TextUtils.equals(str, context.getPackageName() + DELETE_ACTION);
    }

    public static String getDeleteAction() {
        return ToolUtils.isSmpProcess(AppProvider.getApp()) ? SMP_DELETE_ACTION : DELETE_ACTION;
    }

    public static BroadcastReceiver getDeleteBroadCastReceiver() {
        if (ToolUtils.isSmpProcess(AppProvider.getApp())) {
            return new SmpNotificationDeleteBroadcastReceiver();
        }
        return new NotificationDeleteBroadcastReceiver();
    }

    public static Class getDeleteBroadCastReceiverClass() {
        if (ToolUtils.isSmpProcess(AppProvider.getApp())) {
            return SmpNotificationDeleteBroadcastReceiver.class;
        }
        return NotificationDeleteBroadcastReceiver.class;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (!isDeleteAction(intent.getAction(), context) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString(KEY_MSG_TYPE, "notification");
        if (TextUtils.equals(string, "notification")) {
            String stringExtra = intent.getStringExtra("group");
            if (!TextUtils.isEmpty(stringExtra)) {
                NotificationGroupHelper.getInstance().onNotificationDelete(stringExtra);
            }
            long longExtra = intent.getLongExtra("msg_id", -1L);
            JSONObject jSONObject = null;
            try {
                String stringExtra2 = intent.getStringExtra("extra");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    jSONObject = new JSONObject(stringExtra2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Logger.d("NotificationDeleteBroadcastReceiver", "on notification delete , msgId is " + longExtra);
            PushServiceManager.get().getPushExternalService().onNotificationDelete(longExtra, jSONObject);
            return;
        }
        if (TextUtils.equals(string, VALUE_MSG_TYPE_SUMMARY)) {
            String stringExtra3 = intent.getStringExtra("group");
            Logger.d("NotificationDeleteBroadcastReceiver", "on summary notification delete , group is " + stringExtra3);
            NotificationGroupHelper.getInstance().onSummaryDelete(stringExtra3);
        }
    }

    public static synchronized void register() {
        synchronized (NotificationDeleteBroadcastReceiver.class) {
            if (sHasRegister) {
                return;
            }
            Application app = AppProvider.getApp();
            IntentFilter intentFilter = new IntentFilter(app.getPackageName() + getDeleteAction());
            BroadcastReceiver deleteBroadCastReceiver = getDeleteBroadCastReceiver();
            Logger.d("NotificationDeleteBroadcastReceiver", "register " + getDeleteAction() + " -->" + deleteBroadCastReceiver);
            PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(app, deleteBroadCastReceiver, intentFilter);
            sHasRegister = true;
        }
    }
}
