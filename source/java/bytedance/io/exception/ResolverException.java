package bytedance.io.exception;

/* loaded from: classes2.dex */
public class ResolverException extends Exception {
    public ResolverException() {
    }

    public ResolverException(String str) {
        super(str);
    }

    private ResolverException(String str, String str2) {
        super(str + (str2 == null ? "" : " (" + str2 + ")"));
    }
}
