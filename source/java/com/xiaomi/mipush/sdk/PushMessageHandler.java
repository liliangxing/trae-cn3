package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.C1637gi;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.EnumC1577ec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushMessageHandler extends BaseService {

    /* renamed from: a */
    private static List<MiPushClient.ICallbackResult> f812a = new ArrayList();

    /* renamed from: b */
    private static List<MiPushClient.MiPushClientCallback> f814b = new ArrayList();

    /* renamed from: a */
    private static ThreadPoolExecutor f813a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.PushMessageHandler$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface InterfaceC1441a extends Serializable {
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* renamed from: a */
    public static void m1202a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e) {
            AbstractC1417b.m1090a("PushMessageHandler", e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m1203a(Context context, Intent intent) {
        AbstractC1417b.m1099b("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            m1218c(context, intent);
            m1202a(context);
        }
    }

    /* renamed from: c */
    private static void m1218c(final Context context, final Intent intent) {
        if (intent != null && !f813a.isShutdown()) {
            f813a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.PushMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PushMessageHandler.m1215b(context, intent);
                }
            });
        } else {
            AbstractC1417b.m1104d("PushMessageHandler", "-->scheduleJob() fail, case".concat(intent == null ? "0" : PushClient.DEFAULT_REQUEST_ID));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1211a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f814b) {
            if (!f814b.contains(miPushClientCallback)) {
                f814b.add(miPushClientCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1210a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f812a) {
            if (!f812a.contains(iCallbackResult)) {
                f812a.add(iCallbackResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1200a() {
        synchronized (f814b) {
            f814b.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static void m1213b() {
        synchronized (f812a) {
            f812a.clear();
        }
    }

    /* renamed from: b */
    protected static void m1215b(Context context, Intent intent) {
        boolean z;
        ResolveInfo resolveInfo;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            AbstractC1417b.m1090a("PushMessageHandler", "intent unparcel error:" + th);
            z = false;
        }
        try {
            AbstractC1417b.m1092a("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                C1637gi c1637gi = new C1637gi();
                C1670ho.m3312a(c1637gi, intent.getByteArrayExtra("mipush_payload"));
                AbstractC1417b.m1099b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + c1637gi.m2747d());
                MiTinyDataClient.upload(context, c1637gi);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (m1217b()) {
                    AbstractC1417b.m1102c("PushMessageHandler", "receive a message before application calling initialize");
                    if (z) {
                        m1214b(context);
                        return;
                    }
                    return;
                }
                InterfaceC1441a m1365a = C1461t.m1352a(context).m1365a(intent);
                if (m1365a != null) {
                    m1207a(context, m1365a);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                try {
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                    if (queryBroadcastReceivers != null) {
                        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                        while (it.hasNext()) {
                            resolveInfo = it.next();
                            if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(C1702q.m3463a(context, resolveInfo.activityInfo.name))) {
                                break;
                            }
                        }
                    }
                    resolveInfo = null;
                    if (resolveInfo != null) {
                        m1204a(context, intent2, resolveInfo, z);
                    } else {
                        AbstractC1417b.m1102c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                        C1566ds.m2275a(context).m2279a(context.getPackageName(), intent, "11");
                    }
                } catch (Exception e) {
                    AbstractC1417b.m1091a("PushMessageHandler", e);
                    C1566ds.m2275a(context).m2279a(context.getPackageName(), intent, "9");
                }
            }
            if (!z) {
            }
        } catch (Throwable th2) {
            try {
                AbstractC1417b.m1091a("PushMessageHandler", th2);
                C1566ds.m2275a(context).m2279a(context.getPackageName(), intent, "10");
            } finally {
                if (z) {
                    m1214b(context);
                }
            }
        }
    }

    /* renamed from: b */
    private static void m1214b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, C1444c.m1262a(context));
        } catch (Exception e) {
            AbstractC1417b.m1090a("PushMessageHandler", "callback sync error" + e);
        }
    }

    /* renamed from: a */
    private static void m1204a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.C1429a c1429a = new MessageHandleService.C1429a(intent, (PushMessageReceiver) C1702q.m3463a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.m1173a(context.getApplicationContext(), c1429a);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), c1429a);
            }
            MessageHandleService.m1172a(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            AbstractC1417b.m1093a(th);
        }
    }

    /* renamed from: b */
    public static boolean m1217b() {
        return f814b.isEmpty();
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        m1218c(getApplicationContext(), intent);
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo1161a() {
        ThreadPoolExecutor threadPoolExecutor = f813a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f813a.getQueue().size() <= 0) ? false : true;
    }

    /* renamed from: a */
    public static void m1207a(Context context, InterfaceC1441a interfaceC1441a) {
        if (interfaceC1441a instanceof MiPushMessage) {
            m1206a(context, (MiPushMessage) interfaceC1441a);
            return;
        }
        if (interfaceC1441a instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) interfaceC1441a;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (EnumC1577ec.COMMAND_REGISTER.f1521a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                m1201a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (EnumC1577ec.COMMAND_SET_ALIAS.f1521a.equals(command) || EnumC1577ec.COMMAND_UNSET_ALIAS.f1521a.equals(command) || EnumC1577ec.COMMAND_SET_ACCEPT_TIME.f1521a.equals(command)) {
                m1209a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
                return;
            }
            if (EnumC1577ec.COMMAND_SUBSCRIBE_TOPIC.f1521a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                m1208a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (EnumC1577ec.COMMAND_UNSUBSCRIBE_TOPIC.f1521a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                m1216b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m1206a(Context context, MiPushMessage miPushMessage) {
        synchronized (f814b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f814b) {
                if (m1212a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m1201a(long j, String str, String str2) {
        synchronized (f814b) {
            Iterator<MiPushClient.MiPushClientCallback> it = f814b.iterator();
            while (it.hasNext()) {
                it.next().onInitializeResult(j, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1208a(Context context, String str, long j, String str2, String str3) {
        synchronized (f814b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f814b) {
                if (m1212a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b */
    protected static void m1216b(Context context, String str, long j, String str2, String str3) {
        synchronized (f814b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f814b) {
                if (m1212a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1209a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f814b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f814b) {
                if (m1212a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    /* renamed from: a */
    protected static boolean m1212a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1205a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f812a) {
            for (MiPushClient.ICallbackResult iCallbackResult : f812a) {
                if (iCallbackResult instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    iCallbackResult.onResult(tokenResult);
                }
            }
        }
    }
}
