package bytedance.io.exception;

import java.io.IOException;

/* loaded from: classes2.dex */
public class IllegalPathException extends IOException {
    public IllegalPathException() {
    }

    public IllegalPathException(String str) {
        super(str);
    }

    public IllegalPathException(String str, String str2) {
        super(str + (str2 == null ? "" : " (" + str2 + ")"));
    }
}
