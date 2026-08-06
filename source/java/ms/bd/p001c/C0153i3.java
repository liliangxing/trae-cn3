package ms.bd.p001c;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: ms.bd.c.i3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0153i3 {

    /* renamed from: a */
    public final HashSet f191a;

    /* renamed from: b */
    public final InterfaceC0135f3 f192b;

    /* renamed from: c */
    public final InterfaceC0129e3 f193c;

    public C0153i3() {
        C0118c4 c0118c4 = new C0118c4();
        C0143h c0143h = new C0143h();
        this.f191a = new HashSet();
        this.f192b = c0118c4;
        this.f193c = c0143h;
    }

    /* renamed from: a */
    public final void m129a(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        Locale locale = Locale.US;
        m130b(context, str);
    }

    /* renamed from: b */
    public final void m130b(Context context, String str) {
        if (this.f191a.contains(str)) {
            Locale locale = Locale.US;
            return;
        }
        try {
            ((C0118c4) this.f192b).getClass();
            System.loadLibrary(str);
            this.f191a.add(str);
            Locale locale2 = Locale.US;
        } catch (UnsatisfiedLinkError e) {
            Log.getStackTraceString(e);
            Locale locale3 = Locale.US;
            ((C0118c4) this.f192b).getClass();
            File file = new File(context.getDir("lib", 0), (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str));
            if (!file.exists()) {
                File dir = context.getDir("lib", 0);
                ((C0118c4) this.f192b).getClass();
                File file2 = new File(context.getDir("lib", 0), (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str));
                ((C0118c4) this.f192b).getClass();
                File[] listFiles = dir.listFiles(new C0147h3((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (!file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file3.delete();
                        }
                    }
                }
                InterfaceC0129e3 interfaceC0129e3 = this.f193c;
                String[] m77a = ((C0118c4) this.f192b).m77a();
                ((C0118c4) this.f192b).getClass();
                ((C0143h) interfaceC0129e3).m127a(context, m77a, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file, this);
            }
            InterfaceC0135f3 interfaceC0135f3 = this.f192b;
            String absolutePath = file.getAbsolutePath();
            ((C0118c4) interfaceC0135f3).getClass();
            System.load(absolutePath);
            this.f191a.add(str);
            Locale locale4 = Locale.US;
        }
    }
}
