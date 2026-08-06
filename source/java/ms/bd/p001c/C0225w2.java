package ms.bd.p001c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import kotlin.io.encoding.Base64;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.w2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0225w2 extends BroadcastReceiver {

    /* renamed from: a */
    public static final String f447a;

    /* renamed from: b */
    public static final String f448b;

    /* renamed from: c */
    public static C0225w2 f449c;

    /* renamed from: d */
    public static boolean f450d;

    static {
        f447a = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "35c40d", new byte[]{33, 56, 29, 14, 13, 106, 36, 17, 54, 101, 44, 52, 21, 14, 2, 118, 36, 21, 33, 97, 33, 121, 30, 79, 27, 122, 54, 29, 49, 101, 54, 62, 31, 78, 65, Byte.MAX_VALUE, 57, 2, 55, 42, 45, 57});
        f448b = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "c0d883", new byte[]{113, Base64.padSymbol, 26, 2, 5, Base64.padSymbol, 116, 20, 49, 105, 124, 49, 18, 2, 10, 33, 116, Tnaf.POW_2_WIDTH, 38, 109, 113, 124, 25, 67, 19, 45, 102, 24, 54, 105, 102, 59, 24, 66, 73, 40, 105, 7, 48, 38, 125, 52, 17});
        f450d = false;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode != -1125048048) {
            if (hashCode == -516751266 && action.equals(f448b)) {
                c = 1;
            }
            c = 65535;
        } else {
            if (action.equals(f447a)) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                return;
            }
            if (AbstractC0204s1.f392a == null || !AbstractC0204s1.f393b) {
                return;
            }
            C0189p1 c0189p1 = AbstractC0204s1.f392a;
            if (c0189p1.f306d && c0189p1.f303a.f363a) {
                Message message = new Message();
                message.what = 4;
                c0189p1.f307e.sendMessage(message);
                new Thread(new RunnableC0184o1(c0189p1)).start();
            }
            AbstractC0204s1.f393b = false;
            return;
        }
        Context applicationContext = context.getApplicationContext();
        synchronized (AbstractC0204s1.class) {
            AbstractC0204s1.m189a(applicationContext, intent);
            if (!AbstractC0204s1.f393b) {
                C0189p1 c0189p12 = AbstractC0204s1.f392a;
                if (c0189p12.f306d && c0189p12.f303a.f363a) {
                    c0189p12.f308f = new Handler(Looper.getMainLooper());
                    HandlerThread handlerThread = new HandlerThread((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4ff7b4", new byte[]{41, 109, 3, 70, 98, 55, 50, 84}));
                    c0189p12.f309g = handlerThread;
                    handlerThread.start();
                    c0189p12.f307e = new HandlerC0179n1(c0189p12, c0189p12.f309g.getLooper());
                    Message message2 = new Message();
                    message2.what = 1;
                    c0189p12.f307e.sendMessage(message2);
                    Message message3 = new Message();
                    message3.what = 3;
                    c0189p12.f307e.sendMessageDelayed(message3, c0189p12.f304b.f431c);
                }
                AbstractC0204s1.f393b = true;
            }
        }
    }
}
