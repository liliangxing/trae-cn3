package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.ss.ttm.player.MediaPlayer;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes8.dex */
public abstract class s1 {
    public static volatile p1 a;
    public static boolean b;

    public static void a(Context context, Intent intent) {
        String obj;
        if (a == null) {
            synchronized (p1.class) {
                if (a == null) {
                    Bundle INVOKEVIRTUAL_ms_bd_c_s1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra = INVOKEVIRTUAL_ms_bd_c_s1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(intent, (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d59b8b", new byte[]{121, 62, 92, 19, 56, 97, 98, 7}));
                    if (INVOKEVIRTUAL_ms_bd_c_s1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra != null) {
                        CharSequence charSequence = INVOKEVIRTUAL_ms_bd_c_s1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra.getCharSequence((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "37b310", new byte[]{35, 37, 1, 110, 42}));
                        if (!TextUtils.isEmpty(charSequence)) {
                            obj = charSequence.toString();
                            a = new p1(context, obj);
                        }
                    }
                    obj = null;
                    a = new p1(context, obj);
                }
            }
        }
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle INVOKEVIRTUAL_ms_bd_c_s1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }
}
