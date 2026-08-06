package ms.bd.c;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes8.dex */
public final class i3 {
    public final HashSet a;
    public final f3 b;
    public final e3 c;

    public i3() {
        c4 c4Var = new c4();
        h hVar = new h();
        this.a = new HashSet();
        this.b = c4Var;
        this.c = hVar;
    }

    public final void a(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        Locale locale = Locale.US;
        b(context, str);
    }

    public final void b(Context context, String str) {
        if (this.a.contains(str)) {
            Locale locale = Locale.US;
            return;
        }
        try {
            ((c4) this.b).getClass();
            System.loadLibrary(str);
            this.a.add(str);
            Locale locale2 = Locale.US;
        } catch (UnsatisfiedLinkError e) {
            Log.getStackTraceString(e);
            Locale locale3 = Locale.US;
            ((c4) this.b).getClass();
            File file = new File(context.getDir(LibrarianImpl.Constants.LIB_PREFIX, 0), (str.startsWith(LibrarianImpl.Constants.LIB_PREFIX) && str.endsWith(LibrarianImpl.Constants.SO_SUFFIX)) ? str : System.mapLibraryName(str));
            if (!file.exists()) {
                File dir = context.getDir(LibrarianImpl.Constants.LIB_PREFIX, 0);
                ((c4) this.b).getClass();
                File file2 = new File(context.getDir(LibrarianImpl.Constants.LIB_PREFIX, 0), (str.startsWith(LibrarianImpl.Constants.LIB_PREFIX) && str.endsWith(LibrarianImpl.Constants.SO_SUFFIX)) ? str : System.mapLibraryName(str));
                ((c4) this.b).getClass();
                File[] listFiles = dir.listFiles(new h3((str.startsWith(LibrarianImpl.Constants.LIB_PREFIX) && str.endsWith(LibrarianImpl.Constants.SO_SUFFIX)) ? str : System.mapLibraryName(str)));
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (!file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file3.delete();
                        }
                    }
                }
                e3 e3Var = this.c;
                String[] a = ((c4) this.b).a();
                ((c4) this.b).getClass();
                ((h) e3Var).a(context, a, (str.startsWith(LibrarianImpl.Constants.LIB_PREFIX) && str.endsWith(LibrarianImpl.Constants.SO_SUFFIX)) ? str : System.mapLibraryName(str), file, this);
            }
            f3 f3Var = this.b;
            String absolutePath = file.getAbsolutePath();
            ((c4) f3Var).getClass();
            System.load(absolutePath);
            this.a.add(str);
            Locale locale4 = Locale.US;
        }
    }
}
