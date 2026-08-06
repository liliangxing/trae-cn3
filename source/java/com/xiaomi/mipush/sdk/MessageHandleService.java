package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.EnumC1577ec;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<C1429a> f787a = new ConcurrentLinkedQueue<>();

    /* renamed from: a */
    private static ExecutorService f788a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    context.startService(intent);
                } catch (Exception e) {
                    AbstractC1417b.m1089a(e.getMessage());
                }
            }
        });
    }

    public static void addJob(Context context, C1429a c1429a) {
        if (c1429a != null) {
            f787a.add(c1429a);
            m1174b(context);
            startService(context);
        }
    }

    /* renamed from: b */
    private static void m1174b(final Context context) {
        if (f788a.isShutdown()) {
            return;
        }
        f788a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.2
            @Override // java.lang.Runnable
            public void run() {
                MessageHandleService.m1175c(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m1172a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        m1174b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m1175c(Context context) {
        try {
            m1173a(context, f787a.poll());
        } catch (RuntimeException e) {
            AbstractC1417b.m1093a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1173a(Context context, C1429a c1429a) {
        String[] stringArrayExtra;
        if (c1429a == null) {
            return;
        }
        try {
            PushMessageReceiver m1177a = c1429a.m1177a();
            Intent m1176a = c1429a.m1176a();
            int intExtra = m1176a.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1);
            if (intExtra != 1) {
                if (intExtra == 3) {
                    MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) m1176a.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    AbstractC1417b.m1105e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                    m1177a.onCommandResult(context, miPushCommandMessage);
                    if (TextUtils.equals(miPushCommandMessage.getCommand(), EnumC1577ec.COMMAND_REGISTER.f1521a)) {
                        m1177a.onReceiveRegisterResult(context, miPushCommandMessage);
                        PushMessageHandler.m1205a(context, miPushCommandMessage);
                        if (miPushCommandMessage.getResultCode() == 0) {
                            C1447f.m1294b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(m1176a.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = m1176a.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) != null) {
                    AbstractC1417b.m1105e("begin execute onRequirePermissions, lack of necessary permissions");
                    m1177a.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                return;
            }
            PushMessageHandler.InterfaceC1441a m1365a = C1461t.m1352a(context).m1365a(m1176a);
            int intExtra2 = m1176a.getIntExtra("eventMessageType", -1);
            if (m1365a != null) {
                if (m1365a instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) m1365a;
                    if (!miPushMessage.isArrivedMessage()) {
                        m1177a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        C1566ds.m2275a(context.getApplicationContext()).m2278a(context.getPackageName(), m1176a, InstallErrorCode.ERROR_CANCELED, (String) null);
                        AbstractC1417b.m1104d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        m1177a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    } else {
                        if (miPushMessage.isNotified()) {
                            if (intExtra2 == 1000) {
                                C1566ds.m2275a(context.getApplicationContext()).m2278a(context.getPackageName(), m1176a, 1007, (String) null);
                            } else {
                                C1566ds.m2275a(context.getApplicationContext()).m2278a(context.getPackageName(), m1176a, 3007, (String) null);
                            }
                            AbstractC1417b.m1104d("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                            m1177a.onNotificationMessageClicked(context, miPushMessage);
                            return;
                        }
                        AbstractC1417b.m1104d("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                        m1177a.onNotificationMessageArrived(context, miPushMessage);
                        return;
                    }
                }
                if (m1365a instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) m1365a;
                    AbstractC1417b.m1104d("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    m1177a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), EnumC1577ec.COMMAND_REGISTER.f1521a)) {
                        m1177a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.m1205a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            C1447f.m1294b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                AbstractC1417b.m1104d("MessageHandleService", "unknown raw message: " + m1365a);
                return;
            }
            AbstractC1417b.m1104d("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e) {
            AbstractC1417b.m1091a("MessageHandleService", e);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo1161a() {
        ConcurrentLinkedQueue<C1429a> concurrentLinkedQueue = f787a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class C1429a {

        /* renamed from: a */
        private Intent f792a;

        /* renamed from: a */
        private PushMessageReceiver f793a;

        public C1429a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f793a = pushMessageReceiver;
            this.f792a = intent;
        }

        /* renamed from: a */
        public PushMessageReceiver m1177a() {
            return this.f793a;
        }

        /* renamed from: a */
        public Intent m1176a() {
            return this.f792a;
        }
    }
}
