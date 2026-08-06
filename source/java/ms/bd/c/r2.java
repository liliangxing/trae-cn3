package ms.bd.c;

import com.bytedance.librarian.LibrarianImpl;
import java.util.Arrays;

/* loaded from: classes8.dex */
public final class r2 extends RuntimeException {
    public r2(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + LibrarianImpl.Constants.DOT);
    }
}
