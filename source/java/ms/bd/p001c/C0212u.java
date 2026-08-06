package ms.bd.p001c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: ms.bd.c.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0212u implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ab1ba8", new byte[]{115, 112, 87, 45, 14, 98, 59, 126}), file.getName());
    }
}
