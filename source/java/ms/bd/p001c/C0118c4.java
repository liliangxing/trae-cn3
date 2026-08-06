package ms.bd.p001c;

import android.os.Build;

/* renamed from: ms.bd.c.c4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0118c4 implements InterfaceC0135f3 {
    /* renamed from: a */
    public final String[] m77a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
    }
}
