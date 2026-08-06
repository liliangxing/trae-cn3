package bytedance.jvm.time.zone;

import bytedance.jvm.time.Duration;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -6946044323557704546L;
    private final long epochSecond;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    /* renamed from: of */
    public static ZoneOffsetTransition m139of(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        Objects.requireNonNull(localDateTime, "transition");
        Objects.requireNonNull(zoneOffset, "offsetBefore");
        Objects.requireNonNull(zoneOffset2, "offsetAfter");
        if (zoneOffset.equals(zoneOffset2)) {
            throw new IllegalArgumentException("Offsets must not be equal");
        }
        if (localDateTime.getNano() != 0) {
            throw new IllegalArgumentException("Nano-of-second must be zero");
        }
        return new ZoneOffsetTransition(localDateTime, zoneOffset, zoneOffset2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.epochSecond = localDateTime.toEpochSecond(zoneOffset);
        this.transition = localDateTime;
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneOffsetTransition(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.epochSecond = j;
        this.transition = LocalDateTime.ofEpochSecond(j, 0, zoneOffset);
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        Ser.writeEpochSec(this.epochSecond, dataOutput);
        Ser.writeOffset(this.offsetBefore, dataOutput);
        Ser.writeOffset(this.offsetAfter, dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffsetTransition readExternal(DataInput dataInput) throws IOException {
        long readEpochSec = Ser.readEpochSec(dataInput);
        ZoneOffset readOffset = Ser.readOffset(dataInput);
        ZoneOffset readOffset2 = Ser.readOffset(dataInput);
        if (readOffset.equals(readOffset2)) {
            throw new IllegalArgumentException("Offsets must not be equal");
        }
        return new ZoneOffsetTransition(readEpochSec, readOffset, readOffset2);
    }

    public Instant getInstant() {
        return Instant.ofEpochSecond(this.epochSecond);
    }

    public long toEpochSecond() {
        return this.epochSecond;
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(getDurationSeconds());
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(getDurationSeconds());
    }

    private int getDurationSeconds() {
        return getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds();
    }

    public boolean isGap() {
        return getOffsetAfter().getTotalSeconds() > getOffsetBefore().getTotalSeconds();
    }

    public boolean isOverlap() {
        return getOffsetAfter().getTotalSeconds() < getOffsetBefore().getTotalSeconds();
    }

    public boolean isValidOffset(ZoneOffset zoneOffset) {
        if (isGap()) {
            return false;
        }
        return getOffsetBefore().equals(zoneOffset) || getOffsetAfter().equals(zoneOffset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ZoneOffset> getValidOffsets() {
        if (isGap()) {
            return Collections.emptyList();
        }
        return UByte$.ExternalSyntheticBackport0.m$2(getOffsetBefore(), getOffsetAfter());
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffsetTransition zoneOffsetTransition) {
        return Long.compare(this.epochSecond, zoneOffsetTransition.epochSecond);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransition)) {
            return false;
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        return this.epochSecond == zoneOffsetTransition.epochSecond && this.offsetBefore.equals(zoneOffsetTransition.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransition.offsetAfter);
    }

    public int hashCode() {
        return (this.transition.hashCode() ^ this.offsetBefore.hashCode()) ^ Integer.rotateLeft(this.offsetAfter.hashCode(), 16);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(isGap() ? "Gap" : "Overlap").append(" at ").append(this.transition).append(this.offsetBefore).append(" to ").append(this.offsetAfter).append(']');
        return sb.toString();
    }
}
