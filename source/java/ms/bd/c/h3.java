package ms.bd.c;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes8.dex */
public final class h3 implements FilenameFilter {
    public final /* synthetic */ String a;

    public h3(String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
