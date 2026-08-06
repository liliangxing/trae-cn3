package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.DatePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.i18n.TextBundle;

/* compiled from: DateTimePeriod.kt */
@Metadata(m4d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B'\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00168PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m5d2 = {"Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriod;", "totalMonths", BuildConfig.FLAVOR, "days", "<init>", "(II)V", "years", "months", "(III)V", "getTotalMonths$kotlinx_datetime_release", "()I", "getDays", "hours", "getHours", "minutes", "getMinutes", "seconds", "getSeconds", "nanoseconds", "getNanoseconds", "totalNanoseconds", BuildConfig.FLAVOR, "getTotalNanoseconds$kotlinx_datetime_release", "()J", "Companion", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@Serializable(with = DatePeriodIso8601Serializer.class)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DatePeriod extends DateTimePeriod {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int days;
    private final int totalMonths;

    @Override // kotlinx.datetime.DateTimePeriod
    public int getHours() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getMinutes() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getNanoseconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getSeconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    /* renamed from: getTotalNanoseconds$kotlinx_datetime_release */
    public long getTotalNanoseconds() {
        return 0L;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    /* renamed from: getTotalMonths$kotlinx_datetime_release, reason: from getter */
    public int getTotalMonths() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getDays() {
        return this.days;
    }

    public DatePeriod(int i, int i2) {
        super(null);
        this.totalMonths = i;
        this.days = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DatePeriod(int i, int i2, int i3) {
        this(r1, i3);
        int i4;
        i4 = DateTimePeriodKt.totalMonths(i, i2);
    }

    public /* synthetic */ DatePeriod(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(m4d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, m5d2 = {"Lkotlinx/datetime/DatePeriod$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "parse", "Lkotlinx/datetime/DatePeriod;", TextBundle.TEXT_ENTRY, BuildConfig.FLAVOR, "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DatePeriod> serializer() {
            return DatePeriodIso8601Serializer.INSTANCE;
        }

        public final DatePeriod parse(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            DateTimePeriod parse = DateTimePeriod.INSTANCE.parse(text);
            if (parse instanceof DatePeriod) {
                return (DatePeriod) parse;
            }
            throw new DateTimeFormatException("Period " + parse + " (parsed from string " + text + ") is not date-based");
        }
    }
}
