package kotlinx.datetime.internal.format;

import kotlin.Metadata;

/* compiled from: Predicate.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lkotlinx/datetime/internal/format/Truth;", "Lkotlinx/datetime/internal/format/Predicate;", "", "<init>", "()V", "test", "", "value", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Truth implements Predicate<Object> {
    public static final Truth INSTANCE = new Truth();

    @Override // kotlinx.datetime.internal.format.Predicate
    public boolean test(Object value) {
        return true;
    }

    private Truth() {
    }
}
