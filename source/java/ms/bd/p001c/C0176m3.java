package ms.bd.p001c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.m3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0176m3 {

    /* renamed from: c */
    public static C0176m3 f243c;

    /* renamed from: a */
    public final Context f244a;

    /* renamed from: b */
    public ArrayList f245b = new ArrayList();

    public C0176m3(Context context) {
        this.f244a = null;
        this.f244a = context;
    }

    /* renamed from: a */
    public final int m146a() {
        if (m144xeb9e794e(this.f244a, null, new IntentFilter((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6c5f6d", new byte[]{38, 111, 66, 0, 6, 122, 49, 12, 109, 56, 51, 100, 72, 6, 71, 114, 54, 86, 109, 57, 41, 47, 100, 51, Base64.padSymbol, 71, Tnaf.POW_2_WIDTH, 112, 93, 9, 4, 73, 103, 60, 46, 86, 17}))) == null) {
            return -1;
        }
        return Math.round(((r0.getIntExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2db633", new byte[]{47, 99, 7, 71, 0}), -1) / r0.getIntExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "69af85", new byte[]{52, 56, 19, 30, 2}), -1)) * 100.0f) * 10.0f) / 10;
    }

    /* renamed from: b */
    public final int m147b() {
        Intent m144xeb9e794e = m144xeb9e794e(this.f244a, null, new IntentFilter((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a3ca1d", new byte[]{113, Utf8.REPLACEMENT_BYTE, 20, 7, 1, 122, 102, 92, 59, Utf8.REPLACEMENT_BYTE, 100, 52, 30, 1, 64, 114, 97, 6, 59, 62, 126, Byte.MAX_VALUE, 50, 52, 58, 71, 71, 32, 11, 14, 83, 25, 49, 59, 41, 86, 70})));
        if (m144xeb9e794e == null) {
            return -1;
        }
        return m144xeb9e794e.getIntExtra((String) AbstractC0190p2.m166a(16777217, 0, 0L, "82cfd0", new byte[]{57, 60, 5, 21, 92, 34, Utf8.REPLACEMENT_BYTE}), -1);
    }

    /* renamed from: a */
    public static C0176m3 m145a(Context context) {
        if (f243c == null) {
            synchronized (C0176m3.class) {
                if (f243c == null) {
                    f243c = new C0176m3(context);
                }
            }
        }
        return f243c;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_ms_bd_c_m3_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m144xeb9e794e(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
