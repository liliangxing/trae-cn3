package bytedance.jvm.time.zone;

import bytedance.jvm.time.DateTimeException;

/* loaded from: classes2.dex */
public class ZoneRulesException extends DateTimeException {
    private static final long serialVersionUID = -1632418723876261839L;

    public ZoneRulesException(String str) {
        super(str);
    }

    public ZoneRulesException(String str, Throwable th) {
        super(str, th);
    }
}
