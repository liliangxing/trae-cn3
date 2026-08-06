package ms.bd.p001c;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: ms.bd.c.h3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0147h3 implements FilenameFilter {

    /* renamed from: a */
    public final /* synthetic */ String f183a;

    public C0147h3(String str) {
        this.f183a = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f183a);
    }
}
