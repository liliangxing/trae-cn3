package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.internal.format.parser.Copyable;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateFormat.kt */
@Metadata(m4d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0000H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006\""}, m5d2 = {"Lkotlinx/datetime/format/IncompleteLocalDate;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "year", BuildConfig.FLAVOR, "monthNumber", "dayOfMonth", "isoDayOfWeek", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getYear", "()Ljava/lang/Integer;", "setYear", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMonthNumber", "setMonthNumber", "getDayOfMonth", "setDayOfMonth", "getIsoDayOfWeek", "setIsoDayOfWeek", "toLocalDate", "Lkotlinx/datetime/LocalDate;", "populateFrom", BuildConfig.FLAVOR, "date", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class IncompleteLocalDate implements DateFieldContainer, Copyable<IncompleteLocalDate> {
    private Integer dayOfMonth;
    private Integer isoDayOfWeek;
    private Integer monthNumber;
    private Integer year;

    public IncompleteLocalDate() {
        this(null, null, null, null, 15, null);
    }

    public IncompleteLocalDate(Integer num, Integer num2, Integer num3, Integer num4) {
        this.year = num;
        this.monthNumber = num2;
        this.dayOfMonth = num3;
        this.isoDayOfWeek = num4;
    }

    public /* synthetic */ IncompleteLocalDate(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getYear() {
        return this.year;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setYear(Integer num) {
        this.year = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getMonthNumber() {
        return this.monthNumber;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setMonthNumber(Integer num) {
        this.monthNumber = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDayOfMonth() {
        return this.dayOfMonth;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDayOfMonth(Integer num) {
        this.dayOfMonth = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getIsoDayOfWeek() {
        return this.isoDayOfWeek;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setIsoDayOfWeek(Integer num) {
        this.isoDayOfWeek = num;
    }

    public final LocalDate toLocalDate() {
        int intValue;
        LocalDate localDate = new LocalDate(((Number) LocalDateFormatKt.requireParsedField(getYear(), "year")).intValue(), ((Number) LocalDateFormatKt.requireParsedField(getMonthNumber(), "monthNumber")).intValue(), ((Number) LocalDateFormatKt.requireParsedField(getDayOfMonth(), "dayOfMonth")).intValue());
        Integer isoDayOfWeek = getIsoDayOfWeek();
        if (isoDayOfWeek == null || (intValue = isoDayOfWeek.intValue()) == DayOfWeekKt.getIsoDayNumber(localDate.getDayOfWeek())) {
            return localDate;
        }
        throw new DateTimeFormatException("Can not create a LocalDate from the given input: the day of week is " + DayOfWeekKt.DayOfWeek(intValue) + " but the date is " + localDate + ", which is a " + localDate.getDayOfWeek());
    }

    public final void populateFrom(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        setYear(Integer.valueOf(date.getYear()));
        setMonthNumber(Integer.valueOf(date.getMonthNumber()));
        setDayOfMonth(Integer.valueOf(date.getDayOfMonth()));
        setIsoDayOfWeek(Integer.valueOf(DayOfWeekKt.getIsoDayNumber(date.getDayOfWeek())));
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteLocalDate copy() {
        return new IncompleteLocalDate(getYear(), getMonthNumber(), getDayOfMonth(), getIsoDayOfWeek());
    }

    public boolean equals(Object other) {
        if (other instanceof IncompleteLocalDate) {
            IncompleteLocalDate incompleteLocalDate = (IncompleteLocalDate) other;
            if (Intrinsics.areEqual(getYear(), incompleteLocalDate.getYear()) && Intrinsics.areEqual(getMonthNumber(), incompleteLocalDate.getMonthNumber()) && Intrinsics.areEqual(getDayOfMonth(), incompleteLocalDate.getDayOfMonth()) && Intrinsics.areEqual(getIsoDayOfWeek(), incompleteLocalDate.getIsoDayOfWeek())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer year = getYear();
        int hashCode = (year != null ? year.hashCode() : 0) * 31;
        Integer monthNumber = getMonthNumber();
        int hashCode2 = hashCode + ((monthNumber != null ? monthNumber.hashCode() : 0) * 31);
        Integer dayOfMonth = getDayOfMonth();
        int hashCode3 = hashCode2 + ((dayOfMonth != null ? dayOfMonth.hashCode() : 0) * 31);
        Integer isoDayOfWeek = getIsoDayOfWeek();
        return hashCode3 + ((isoDayOfWeek != null ? isoDayOfWeek.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Object year = getYear();
        if (year == null) {
            year = "??";
        }
        StringBuilder append = sb.append(year).append('-');
        Object monthNumber = getMonthNumber();
        if (monthNumber == null) {
            monthNumber = "??";
        }
        StringBuilder append2 = append.append(monthNumber).append('-');
        Object dayOfMonth = getDayOfMonth();
        if (dayOfMonth == null) {
            dayOfMonth = "??";
        }
        StringBuilder append3 = append2.append(dayOfMonth).append(" (day of week is ");
        Integer isoDayOfWeek = getIsoDayOfWeek();
        return append3.append(isoDayOfWeek != null ? isoDayOfWeek : "??").append(')').toString();
    }
}
