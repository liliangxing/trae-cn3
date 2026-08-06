package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.DateTimeFormatter;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalQuery;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: UtcOffsetJvm.kt */
@Metadata(m4d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002\"#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000b\"#\u0010\u0011\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0018"}, m5d2 = {"UtcOffset", "Lkotlinx/datetime/UtcOffset;", "hours", BuildConfig.FLAVOR, "minutes", "seconds", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlinx/datetime/UtcOffset;", "isoFormat", "Lbytedance/jvm/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "getIsoFormat", "()Lbytedance/jvm/time/format/DateTimeFormatter;", "isoFormat$delegate", "Lkotlin/Lazy;", "isoBasicFormat", "getIsoBasicFormat", "isoBasicFormat$delegate", "fourDigitsFormat", "getFourDigitsFormat", "fourDigitsFormat$delegate", "parseWithFormat", "input", BuildConfig.FLAVOR, "format", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UtcOffsetJvmKt {
    private static final Lazy isoFormat$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.UtcOffsetJvmKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormatter isoFormat_delegate$lambda$0;
            isoFormat_delegate$lambda$0 = UtcOffsetJvmKt.isoFormat_delegate$lambda$0();
            return isoFormat_delegate$lambda$0;
        }
    });
    private static final Lazy isoBasicFormat$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.UtcOffsetJvmKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormatter isoBasicFormat_delegate$lambda$1;
            isoBasicFormat_delegate$lambda$1 = UtcOffsetJvmKt.isoBasicFormat_delegate$lambda$1();
            return isoBasicFormat_delegate$lambda$1;
        }
    });
    private static final Lazy fourDigitsFormat$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.UtcOffsetJvmKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormatter fourDigitsFormat_delegate$lambda$2;
            fourDigitsFormat_delegate$lambda$2 = UtcOffsetJvmKt.fourDigitsFormat_delegate$lambda$2();
            return fourDigitsFormat_delegate$lambda$2;
        }
    });

    public static /* synthetic */ UtcOffset UtcOffset$default(Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        return UtcOffset(num, num2, num3);
    }

    public static final UtcOffset UtcOffset(Integer num, Integer num2, Integer num3) {
        UtcOffset utcOffset;
        try {
            if (num != null) {
                ZoneOffset ofHoursMinutesSeconds = ZoneOffset.ofHoursMinutesSeconds(num.intValue(), num2 != null ? num2.intValue() : 0, num3 != null ? num3.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(ofHoursMinutesSeconds, "ofHoursMinutesSeconds(...)");
                utcOffset = new UtcOffset(ofHoursMinutesSeconds);
            } else if (num2 != null) {
                ZoneOffset ofHoursMinutesSeconds2 = ZoneOffset.ofHoursMinutesSeconds(num2.intValue() / 60, num2.intValue() % 60, num3 != null ? num3.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(ofHoursMinutesSeconds2, "ofHoursMinutesSeconds(...)");
                utcOffset = new UtcOffset(ofHoursMinutesSeconds2);
            } else {
                ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(num3 != null ? num3.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(ofTotalSeconds, "ofTotalSeconds(...)");
                utcOffset = new UtcOffset(ofTotalSeconds);
            }
            return utcOffset;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter getIsoFormat() {
        return (DateTimeFormatter) isoFormat$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter isoFormat_delegate$lambda$0() {
        return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffsetId().toFormatter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter getIsoBasicFormat() {
        return (DateTimeFormatter) isoBasicFormat$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter isoBasicFormat_delegate$lambda$1() {
        return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffset("+HHmmss", "Z").toFormatter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter getFourDigitsFormat() {
        return (DateTimeFormatter) fourDigitsFormat$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter fourDigitsFormat_delegate$lambda$2() {
        return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffset("+HHMM", "+0000").toFormatter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UtcOffset parseWithFormat(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        try {
            return new UtcOffset((ZoneOffset) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: kotlinx.datetime.UtcOffsetJvmKt$$ExternalSyntheticLambda3
                public final Object queryFrom(TemporalAccessor temporalAccessor) {
                    return ZoneOffset.from(temporalAccessor);
                }
            }));
        } catch (DateTimeException e) {
            throw new DateTimeFormatException(e);
        }
    }
}
