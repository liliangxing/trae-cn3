package ms.bd.p001c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* renamed from: ms.bd.c.s1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0204s1 {

    /* renamed from: a */
    public static volatile C0189p1 f392a;

    /* renamed from: b */
    public static boolean f393b;

    /* renamed from: a */
    public static void m189a(Context context, Intent intent) {
        String obj;
        if (f392a == null) {
            synchronized (C0189p1.class) {
                if (f392a == null) {
                    Bundle m188xad3e35e6 = m188xad3e35e6(intent, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d59b8b", new byte[]{121, 62, 92, 19, 56, 97, 98, 7}));
                    if (m188xad3e35e6 != null) {
                        CharSequence charSequence = m188xad3e35e6.getCharSequence((String) AbstractC0190p2.m166a(16777217, 0, 0L, "37b310", new byte[]{35, 37, 1, 110, 42}));
                        if (!TextUtils.isEmpty(charSequence)) {
                            obj = charSequence.toString();
                            f392a = new C0189p1(context, obj);
                        }
                    }
                    obj = null;
                    f392a = new C0189p1(context, obj);
                }
            }
        }
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    /* renamed from: INVOKEVIRTUAL_ms_bd_c_s1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra */
    public static Bundle m188xad3e35e6(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }
}
