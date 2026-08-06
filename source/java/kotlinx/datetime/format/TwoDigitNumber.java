package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeComponents.kt */
@Metadata(m4d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002¢\u0006\u0002\u0010\u000bJ.\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0086\u0002¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5d2 = {"Lkotlinx/datetime/format/TwoDigitNumber;", BuildConfig.FLAVOR, "reference", "Lkotlin/reflect/KMutableProperty0;", BuildConfig.FLAVOR, "<init>", "(Lkotlin/reflect/KMutableProperty0;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Integer;", "setValue", BuildConfig.FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Integer;)V", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class TwoDigitNumber {
    private final KMutableProperty0<Integer> reference;

    public TwoDigitNumber(KMutableProperty0<Integer> reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        this.reference = reference;
    }

    public final Integer getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.reference.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (new kotlin.ranges.IntRange(0, 99).contains(r5.intValue()) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setValue(Object thisRef, KProperty<?> property, Integer value) {
        Intrinsics.checkNotNullParameter(property, "property");
        boolean z = value == null;
        if (!z) {
            throw new IllegalArgumentException((property.getName() + " must be a two-digit number, got '" + value + '\'').toString());
        }
        this.reference.set(value);
    }
}
