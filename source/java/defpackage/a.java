package defpackage;

/* loaded from: classes3.dex */
public enum a {
    SUCCESS(0, "success"),
    ERROR_NO_PERMISSION(8002009, "No permission to call this function."),
    ERROR_EXCEEDED_MAXIMUM(8002010, "Turning on the notification switch request exceeds the maximum number of times."),
    ERROR_REQUIRES_TOO_MANY(8002011, "Turning on the notification switch requires too many requests."),
    ERROR_VERSION_NOT_SUPPORT(8002012, "The current version does not support this function, please upgrade Honor Push.");

    public int a;
    public String b;

    a(int i, String str) {
        this.a = i;
        this.b = str;
    }
}
