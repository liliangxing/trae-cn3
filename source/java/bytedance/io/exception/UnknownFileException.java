package bytedance.io.exception;

/* loaded from: classes2.dex */
public class UnknownFileException extends Exception {
    public UnknownFileException() {
    }

    public UnknownFileException(String str) {
        super(str);
    }

    private UnknownFileException(String str, String str2) {
        super(str + (str2 == null ? "" : " (" + str2 + ")"));
    }
}
