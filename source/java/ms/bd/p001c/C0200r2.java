package ms.bd.p001c;

import java.util.Arrays;

/* renamed from: ms.bd.c.r2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0200r2 extends RuntimeException {
    public C0200r2(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + ".");
    }
}
