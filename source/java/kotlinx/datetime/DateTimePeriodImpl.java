package kotlinx.datetime;

import kotlin.Metadata;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimePeriod.kt */
@Metadata(m4d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m5d2 = {"Lkotlinx/datetime/DateTimePeriodImpl;", "Lkotlinx/datetime/DateTimePeriod;", "totalMonths", BuildConfig.FLAVOR, "days", "totalNanoseconds", BuildConfig.FLAVOR, "<init>", "(IIJ)V", "getTotalMonths$kotlinx_datetime_release", "()I", "getDays", "getTotalNanoseconds$kotlinx_datetime_release", "()J", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DateTimePeriodImpl extends DateTimePeriod {
    private final int days;
    private final int totalMonths;
    private final long totalNanoseconds;

    @Override // kotlinx.datetime.DateTimePeriod
    /* renamed from: getTotalMonths$kotlinx_datetime_release, reason: from getter */
    public int getTotalMonths() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getDays() {
        return this.days;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    /* renamed from: getTotalNanoseconds$kotlinx_datetime_release, reason: from getter */
    public long getTotalNanoseconds() {
        return this.totalNanoseconds;
    }

    public DateTimePeriodImpl(int i, int i2, long j) {
        super(null);
        this.totalMonths = i;
        this.days = i2;
        this.totalNanoseconds = j;
    }
}
