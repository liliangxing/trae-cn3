package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.zone.ZoneOffsetTransition;
import bytedance.jvm.time.zone.ZoneRules;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> implements ChronoZonedDateTime<D>, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final transient ChronoLocalDateTimeImpl<D> dateTime;
    private final transient ZoneOffset offset;
    private final transient ZoneId zone;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R extends ChronoLocalDate> ChronoZonedDateTime<R> ofBest(ChronoLocalDateTimeImpl<R> chronoLocalDateTimeImpl, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(chronoLocalDateTimeImpl, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        LocalDateTime from = LocalDateTime.from((TemporalAccessor) chronoLocalDateTimeImpl);
        List<ZoneOffset> validOffsets = rules.getValidOffsets(from);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(from);
            chronoLocalDateTimeImpl = chronoLocalDateTimeImpl.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = validOffsets.get(0);
        }
        Objects.requireNonNull(zoneOffset, "offset");
        return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, zoneOffset, zoneId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChronoZonedDateTimeImpl<?> ofInstant(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        Objects.requireNonNull(offset, "offset");
        return new ChronoZonedDateTimeImpl<>((ChronoLocalDateTimeImpl) chronology.localDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset)), offset, zoneId);
    }

    private ChronoZonedDateTimeImpl<D> create(Instant instant, ZoneId zoneId) {
        return (ChronoZonedDateTimeImpl<D>) ofInstant(getChronology(), instant, zoneId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> ensureValid(Chronology chronology, Temporal temporal) {
        ChronoZonedDateTimeImpl<R> chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (chronology.equals(chronoZonedDateTimeImpl.getChronology())) {
            return chronoZonedDateTimeImpl;
        }
        throw new ClassCastException("Chronology mismatch, required: " + chronology.getId() + ", actual: " + chronoZonedDateTimeImpl.getChronology().getId());
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = (ChronoLocalDateTimeImpl) Objects.requireNonNull(chronoLocalDateTimeImpl, "dateTime");
        this.offset = (ZoneOffset) Objects.requireNonNull(zoneOffset, "offset");
        this.zone = (ZoneId) Objects.requireNonNull(zoneId, "zone");
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    /* renamed from: withEarlierOffsetAtOverlap */
    public ChronoZonedDateTime<D> withEarlierOffsetAtOverlap2() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(LocalDateTime.from((TemporalAccessor) this));
        if (transition != null && transition.isOverlap()) {
            ZoneOffset offsetBefore = transition.getOffsetBefore();
            if (!offsetBefore.equals(this.offset)) {
                return new ChronoZonedDateTimeImpl(this.dateTime, offsetBefore, this.zone);
            }
        }
        return this;
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    /* renamed from: withLaterOffsetAtOverlap */
    public ChronoZonedDateTime<D> withLaterOffsetAtOverlap2() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(LocalDateTime.from((TemporalAccessor) this));
        if (transition != null) {
            ZoneOffset offsetAfter = transition.getOffsetAfter();
            if (!offsetAfter.equals(getOffset())) {
                return new ChronoZonedDateTimeImpl(this.dateTime, offsetAfter, this.zone);
            }
        }
        return this;
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    /* renamed from: toLocalDateTime */
    public ChronoLocalDateTime<D> toLocalDateTime2() {
        return this.dateTime;
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    /* renamed from: withZoneSameLocal */
    public ChronoZonedDateTime<D> withZoneSameLocal2(ZoneId zoneId) {
        return ofBest(this.dateTime, zoneId, this.offset);
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    /* renamed from: withZoneSameInstant */
    public ChronoZonedDateTime<D> withZoneSameInstant2(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : create(this.dateTime.toInstant(this.offset), zoneId);
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime, bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime, bytedance.jvm.time.temporal.Temporal
    public ChronoZonedDateTime<D> with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i = C06341.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
            if (i == 1) {
                return plus(j - toEpochSecond(), (TemporalUnit) ChronoUnit.SECONDS);
            }
            if (i == 2) {
                return create(this.dateTime.toInstant(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j))), this.zone);
            }
            return ofBest(this.dateTime.with(temporalField, j), this.zone, this.offset);
        }
        return ensureValid(getChronology(), temporalField.adjustInto(this, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.ChronoZonedDateTimeImpl$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06341 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime, bytedance.jvm.time.temporal.Temporal
    public ChronoZonedDateTime<D> plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return with((TemporalAdjuster) this.dateTime.plus(j, temporalUnit));
        }
        return ensureValid(getChronology(), temporalUnit.addTo(this, j));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoZonedDateTime<? extends ChronoLocalDate> zonedDateTime = getChronology().zonedDateTime(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            return this.dateTime.until(zonedDateTime.withZoneSameInstant2(this.offset).toLocalDateTime2(), temporalUnit);
        }
        Objects.requireNonNull(temporalUnit, "unit");
        return temporalUnit.between(this, zonedDateTime);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.dateTime);
        objectOutput.writeObject(this.offset);
        objectOutput.writeObject(this.zone);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChronoZonedDateTime<?> readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) objectInput.readObject();
        ZoneOffset zoneOffset = (ZoneOffset) objectInput.readObject();
        return chronoLocalDateTime.atZone2(zoneOffset).withZoneSameLocal2((ZoneId) objectInput.readObject());
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime<?>) obj) == 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    public int hashCode() {
        return (toLocalDateTime2().hashCode() ^ getOffset().hashCode()) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    @Override // bytedance.jvm.time.chrono.ChronoZonedDateTime
    public String toString() {
        String str = toLocalDateTime2().toString() + getOffset().toString();
        return getOffset() != getZone() ? str + '[' + getZone().toString() + ']' : str;
    }
}
