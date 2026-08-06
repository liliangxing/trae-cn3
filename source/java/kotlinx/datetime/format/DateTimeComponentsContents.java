package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;
import net.openid.appauth.BuildConfig;

/* compiled from: DateTimeComponents.kt */
@Metadata(m4d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00000\u0005B3\b\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001a\u001a\u00020\u0000H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000b\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u000fR\u000b\u0010#\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010$\u001a\u0004\u0018\u00010%X\u0096\u000fR\u000b\u0010&\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010'\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010(\u001a\u0004\u0018\u00010\u001cX\u0096\u000fR\u000b\u0010)\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010*\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010+\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010,\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010-\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010.\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u0010/\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u00100\u001a\u0004\u0018\u00010 X\u0096\u000fR\u000b\u00101\u001a\u0004\u0018\u00010 X\u0096\u000f¨\u00062"}, m5d2 = {"Lkotlinx/datetime/format/DateTimeComponentsContents;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "date", "Lkotlinx/datetime/format/IncompleteLocalDate;", "time", "Lkotlinx/datetime/format/IncompleteLocalTime;", "offset", "Lkotlinx/datetime/format/IncompleteUtcOffset;", "timeZoneId", BuildConfig.FLAVOR, "<init>", "(Lkotlinx/datetime/format/IncompleteLocalDate;Lkotlinx/datetime/format/IncompleteLocalTime;Lkotlinx/datetime/format/IncompleteUtcOffset;Ljava/lang/String;)V", "getDate", "()Lkotlinx/datetime/format/IncompleteLocalDate;", "getTime", "()Lkotlinx/datetime/format/IncompleteLocalTime;", "getOffset", "()Lkotlinx/datetime/format/IncompleteUtcOffset;", "getTimeZoneId", "()Ljava/lang/String;", "setTimeZoneId", "(Ljava/lang/String;)V", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "amPm", "Lkotlinx/datetime/format/AmPmMarker;", "dayOfMonth", "fractionOfSecond", "Lkotlinx/datetime/internal/DecimalFraction;", "hour", "hourOfAmPm", "isNegative", "isoDayOfWeek", "minute", "minutesOfHour", "monthNumber", "nanosecond", "second", "secondsOfMinute", "totalHoursAbs", "year", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DateTimeComponentsContents implements DateFieldContainer, TimeFieldContainer, UtcOffsetFieldContainer, DateTimeFieldContainer, Copyable<DateTimeComponentsContents> {
    private final IncompleteLocalDate date;
    private final IncompleteUtcOffset offset;
    private final IncompleteLocalTime time;
    private String timeZoneId;

    public DateTimeComponentsContents() {
        this(null, null, null, null, 15, null);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public AmPmMarker getAmPm() {
        return this.time.getAmPm();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public DecimalFraction getFractionOfSecond() {
        return this.time.getFractionOfSecond();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getHour() {
        return this.time.getHour();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getHourOfAmPm() {
        return this.time.getHourOfAmPm();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getIsoDayOfWeek() {
        return this.date.getIsoDayOfWeek();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getMinute() {
        return this.time.getMinute();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getMinutesOfHour() {
        return this.offset.getMinutesOfHour();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getMonthNumber() {
        return this.date.getMonthNumber();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getNanosecond() {
        return this.time.getNanosecond();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public Integer getSecond() {
        return this.time.getSecond();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getSecondsOfMinute() {
        return this.offset.getSecondsOfMinute();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getTotalHoursAbs() {
        return this.offset.getTotalHoursAbs();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public Integer getYear() {
        return this.date.getYear();
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    /* renamed from: isNegative */
    public Boolean getIsNegative() {
        return this.offset.getIsNegative();
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setAmPm(AmPmMarker amPmMarker) {
        this.time.setAmPm(amPmMarker);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setDayOfMonth(Integer num) {
        this.date.setDayOfMonth(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setFractionOfSecond(DecimalFraction decimalFraction) {
        this.time.setFractionOfSecond(decimalFraction);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setHour(Integer num) {
        this.time.setHour(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setHourOfAmPm(Integer num) {
        this.time.setHourOfAmPm(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setIsoDayOfWeek(Integer num) {
        this.date.setIsoDayOfWeek(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setMinute(Integer num) {
        this.time.setMinute(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setMinutesOfHour(Integer num) {
        this.offset.setMinutesOfHour(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setMonthNumber(Integer num) {
        this.date.setMonthNumber(num);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setNanosecond(Integer num) {
        this.time.setNanosecond(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setNegative(Boolean bool) {
        this.offset.setNegative(bool);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public void setSecond(Integer num) {
        this.time.setSecond(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setSecondsOfMinute(Integer num) {
        this.offset.setSecondsOfMinute(num);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setTotalHoursAbs(Integer num) {
        this.offset.setTotalHoursAbs(num);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public void setYear(Integer num) {
        this.date.setYear(num);
    }

    public DateTimeComponentsContents(IncompleteLocalDate date, IncompleteLocalTime time, IncompleteUtcOffset offset, String str) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.date = date;
        this.time = time;
        this.offset = offset;
        this.timeZoneId = str;
    }

    public /* synthetic */ DateTimeComponentsContents(IncompleteLocalDate incompleteLocalDate, IncompleteLocalTime incompleteLocalTime, IncompleteUtcOffset incompleteUtcOffset, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IncompleteLocalDate(null, null, null, null, 15, null) : incompleteLocalDate, (i & 2) != 0 ? new IncompleteLocalTime(null, null, null, null, null, null, 63, null) : incompleteLocalTime, (i & 4) != 0 ? new IncompleteUtcOffset(null, null, null, null, 15, null) : incompleteUtcOffset, (i & 8) != 0 ? null : str);
    }

    public final IncompleteLocalDate getDate() {
        return this.date;
    }

    public final IncompleteLocalTime getTime() {
        return this.time;
    }

    public final IncompleteUtcOffset getOffset() {
        return this.offset;
    }

    public final String getTimeZoneId() {
        return this.timeZoneId;
    }

    public final void setTimeZoneId(String str) {
        this.timeZoneId = str;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public DateTimeComponentsContents copy() {
        return new DateTimeComponentsContents(this.date.copy(), this.time.copy(), this.offset.copy(), this.timeZoneId);
    }

    public boolean equals(Object other) {
        if (other instanceof DateTimeComponentsContents) {
            DateTimeComponentsContents dateTimeComponentsContents = (DateTimeComponentsContents) other;
            if (Intrinsics.areEqual(dateTimeComponentsContents.date, this.date) && Intrinsics.areEqual(dateTimeComponentsContents.time, this.time) && Intrinsics.areEqual(dateTimeComponentsContents.offset, this.offset) && Intrinsics.areEqual(dateTimeComponentsContents.timeZoneId, this.timeZoneId)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.date.hashCode() ^ this.time.hashCode()) ^ this.offset.hashCode();
        String str = this.timeZoneId;
        return hashCode ^ (str != null ? str.hashCode() : 0);
    }
}
