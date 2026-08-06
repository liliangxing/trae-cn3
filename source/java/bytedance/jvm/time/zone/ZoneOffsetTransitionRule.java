package bytedance.jvm.time.zone;

import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.Month;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.temporal.TemporalAdjusters;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 6889046316657758795L;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;
    private final boolean timeEndOfDay;

    /* renamed from: of */
    public static ZoneOffsetTransitionRule m140of(Month month, int i, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        Objects.requireNonNull(month, "month");
        Objects.requireNonNull(localTime, "time");
        Objects.requireNonNull(timeDefinition, "timeDefnition");
        Objects.requireNonNull(zoneOffset, "standardOffset");
        Objects.requireNonNull(zoneOffset2, "offsetBefore");
        Objects.requireNonNull(zoneOffset3, "offsetAfter");
        if (i < -28 || i > 31 || i == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z && !localTime.equals(LocalTime.MIDNIGHT)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (localTime.getNano() != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new ZoneOffsetTransitionRule(month, i, dayOfWeek, localTime, z, timeDefinition, zoneOffset, zoneOffset2, zoneOffset3);
    }

    ZoneOffsetTransitionRule(Month month, int i, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month;
        this.dom = (byte) i;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.timeEndOfDay = z;
        this.timeDefinition = timeDefinition;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        int secondOfDay = this.timeEndOfDay ? 86400 : this.time.toSecondOfDay();
        int totalSeconds = this.standardOffset.getTotalSeconds();
        int totalSeconds2 = this.offsetBefore.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.offsetAfter.getTotalSeconds() - totalSeconds;
        int hour = secondOfDay % 3600 == 0 ? this.timeEndOfDay ? 24 : this.time.getHour() : 31;
        int i = totalSeconds % 900 == 0 ? (totalSeconds / 900) + 128 : 255;
        int i2 = (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) ? totalSeconds2 / 1800 : 3;
        int i3 = (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) ? totalSeconds3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.dow;
        dataOutput.writeInt((this.month.getValue() << 28) + ((this.dom + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (hour << 14) + (this.timeDefinition.ordinal() << 12) + (i << 4) + (i2 << 2) + i3);
        if (hour == 31) {
            dataOutput.writeInt(secondOfDay);
        }
        if (i == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (i2 == 3) {
            dataOutput.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (i3 == 3) {
            dataOutput.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffsetTransitionRule readExternal(DataInput dataInput) throws IOException {
        int readInt = dataInput.readInt();
        Month m99of = Month.m99of(readInt >>> 28);
        int i = ((264241152 & readInt) >>> 22) - 32;
        int i2 = (3670016 & readInt) >>> 19;
        DayOfWeek m85of = i2 == 0 ? null : DayOfWeek.m85of(i2);
        int i3 = (507904 & readInt) >>> 14;
        TimeDefinition timeDefinition = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i4 = (readInt & 4080) >>> 4;
        int i5 = (readInt & 12) >>> 2;
        int i6 = readInt & 3;
        LocalTime ofSecondOfDay = i3 == 31 ? LocalTime.ofSecondOfDay(dataInput.readInt()) : LocalTime.m96of(i3 % 24, 0);
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(i4 == 255 ? dataInput.readInt() : (i4 - 128) * 900);
        return m140of(m99of, i, m85of, ofSecondOfDay, i3 == 24, timeDefinition, ofTotalSeconds, ZoneOffset.ofTotalSeconds(i5 == 3 ? dataInput.readInt() : ofTotalSeconds.getTotalSeconds() + (i5 * 1800)), ZoneOffset.ofTotalSeconds(i6 == 3 ? dataInput.readInt() : ofTotalSeconds.getTotalSeconds() + (i6 * 1800)));
    }

    public Month getMonth() {
        return this.month;
    }

    public int getDayOfMonthIndicator() {
        return this.dom;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dow;
    }

    public LocalTime getLocalTime() {
        return this.time;
    }

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffsetTransition createTransition(int i) {
        LocalDate m88of;
        byte b = this.dom;
        if (b < 0) {
            Month month = this.month;
            m88of = LocalDate.m88of(i, month, month.length(IsoChronology.INSTANCE.isLeapYear(i)) + 1 + this.dom);
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                m88of = m88of.with(TemporalAdjusters.previousOrSame(dayOfWeek));
            }
        } else {
            m88of = LocalDate.m88of(i, this.month, b);
            DayOfWeek dayOfWeek2 = this.dow;
            if (dayOfWeek2 != null) {
                m88of = m88of.with(TemporalAdjusters.nextOrSame(dayOfWeek2));
            }
        }
        if (this.timeEndOfDay) {
            m88of = m88of.plusDays(1L);
        }
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.m95of(m88of, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        return this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.time.equals(zoneOffsetTransitionRule.time) && this.timeEndOfDay == zoneOffsetTransitionRule.timeEndOfDay && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter);
    }

    public int hashCode() {
        int secondOfDay = ((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11) + ((this.dom + 32) << 5);
        DayOfWeek dayOfWeek = this.dow;
        return ((((secondOfDay + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.offsetBefore.compareTo(this.offsetAfter) > 0 ? "Gap " : "Overlap ").append(this.offsetBefore).append(" to ").append(this.offsetAfter).append(", ");
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek != null) {
            byte b = this.dom;
            if (b == -1) {
                sb.append(dayOfWeek.name()).append(" on or before last day of ").append(this.month.name());
            } else if (b < 0) {
                sb.append(dayOfWeek.name()).append(" on or before last day minus ").append((-this.dom) - 1).append(" of ").append(this.month.name());
            } else {
                sb.append(dayOfWeek.name()).append(" on or after ").append(this.month.name()).append(' ').append((int) this.dom);
            }
        } else {
            sb.append(this.month.name()).append(' ').append((int) this.dom);
        }
        sb.append(" at ").append(this.timeEndOfDay ? "24:00" : this.time.toString()).append(" ").append(this.timeDefinition).append(", standard offset ").append(this.standardOffset).append(']');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.zone.ZoneOffsetTransitionRule$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06631 {

        /* renamed from: $SwitchMap$bytedance$jvm$time$zone$ZoneOffsetTransitionRule$TimeDefinition */
        static final /* synthetic */ int[] f100xf89b3b17;

        static {
            int[] iArr = new int[TimeDefinition.values().length];
            f100xf89b3b17 = iArr;
            try {
                iArr[TimeDefinition.UTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f100xf89b3b17[TimeDefinition.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime createDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            int i = C06631.f100xf89b3b17[ordinal()];
            if (i != 1) {
                return i != 2 ? localDateTime : localDateTime.plusSeconds(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds());
            }
            return localDateTime.plusSeconds(zoneOffset2.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }
}
