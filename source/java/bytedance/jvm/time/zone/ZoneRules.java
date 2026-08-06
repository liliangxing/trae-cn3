package bytedance.jvm.time.zone;

import androidx.core.location.LocationRequestCompat;
import bytedance.jvm.time.Clock;
import bytedance.jvm.time.Duration;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final transient ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap();
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final TimeZone timeZone;
    private final ZoneOffset[] wallOffsets;
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final ZoneOffsetTransitionRule[] EMPTY_LASTRULES = new ZoneOffsetTransitionRule[0];
    private static final LocalDateTime[] EMPTY_LDT_ARRAY = new LocalDateTime[0];
    private static final ZoneOffsetTransition[] NO_TRANSITIONS = new ZoneOffsetTransition[0];

    /* renamed from: of */
    public static ZoneRules m142of(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        Objects.requireNonNull(zoneOffset, "baseStandardOffset");
        Objects.requireNonNull(zoneOffset2, "baseWallOffset");
        Objects.requireNonNull(list, "standardOffsetTransitionList");
        Objects.requireNonNull(list2, "transitionList");
        Objects.requireNonNull(list3, "lastRules");
        return new ZoneRules(zoneOffset, zoneOffset2, list, list2, list3);
    }

    /* renamed from: of */
    public static ZoneRules m141of(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return new ZoneRules(zoneOffset);
    }

    ZoneRules(ZoneOffset zoneOffset, ZoneOffset zoneOffset2, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        this.standardTransitions = new long[list.size()];
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[list.size() + 1];
        this.standardOffsets = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        int i = 0;
        while (i < list.size()) {
            this.standardTransitions[i] = list.get(i).toEpochSecond();
            int i2 = i + 1;
            this.standardOffsets[i2] = list.get(i).getOffsetAfter();
            i = i2;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(zoneOffset2);
        for (ZoneOffsetTransition zoneOffsetTransition : list2) {
            if (zoneOffsetTransition.isGap()) {
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
            } else {
                arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                arrayList.add(zoneOffsetTransition.getDateTimeBefore());
            }
            arrayList2.add(zoneOffsetTransition.getOffsetAfter());
        }
        this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        this.wallOffsets = (ZoneOffset[]) arrayList2.toArray(new ZoneOffset[arrayList2.size()]);
        this.savingsInstantTransitions = new long[list2.size()];
        for (int i3 = 0; i3 < list2.size(); i3++) {
            this.savingsInstantTransitions[i3] = list2.get(i3).toEpochSecond();
        }
        if (list3.size() > 16) {
            throw new IllegalArgumentException("Too many transition rules");
        }
        this.lastRules = (ZoneOffsetTransitionRule[]) list3.toArray(new ZoneOffsetTransitionRule[list3.size()]);
        this.timeZone = null;
    }

    private ZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.standardTransitions = jArr;
        this.standardOffsets = zoneOffsetArr;
        this.savingsInstantTransitions = jArr2;
        this.wallOffsets = zoneOffsetArr2;
        this.lastRules = zoneOffsetTransitionRuleArr;
        if (jArr2.length == 0) {
            this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < jArr2.length) {
                int i2 = i + 1;
                ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[i], zoneOffsetArr2[i], zoneOffsetArr2[i2]);
                if (zoneOffsetTransition.isGap()) {
                    arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                    arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                } else {
                    arrayList.add(zoneOffsetTransition.getDateTimeAfter());
                    arrayList.add(zoneOffsetTransition.getDateTimeBefore());
                }
                i = i2;
            }
            this.savingsLocalTransitions = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.timeZone = null;
    }

    private ZoneRules(ZoneOffset zoneOffset) {
        this.standardOffsets = r0;
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRules(TimeZone timeZone) {
        this.standardOffsets = r0;
        ZoneOffset[] zoneOffsetArr = {offsetFromMillis(timeZone.getRawOffset())};
        long[] jArr = EMPTY_LONG_ARRAY;
        this.standardTransitions = jArr;
        this.savingsInstantTransitions = jArr;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = zoneOffsetArr;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = timeZone;
    }

    private static ZoneOffset offsetFromMillis(int i) {
        return ZoneOffset.ofTotalSeconds(i / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(this.timeZone != null ? (byte) 100 : (byte) 1, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.standardTransitions.length);
        for (long j : this.standardTransitions) {
            Ser.writeEpochSec(j, dataOutput);
        }
        for (ZoneOffset zoneOffset : this.standardOffsets) {
            Ser.writeOffset(zoneOffset, dataOutput);
        }
        dataOutput.writeInt(this.savingsInstantTransitions.length);
        for (long j2 : this.savingsInstantTransitions) {
            Ser.writeEpochSec(j2, dataOutput);
        }
        for (ZoneOffset zoneOffset2 : this.wallOffsets) {
            Ser.writeOffset(zoneOffset2, dataOutput);
        }
        dataOutput.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule zoneOffsetTransitionRule : this.lastRules) {
            zoneOffsetTransitionRule.writeExternal(dataOutput);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternalTimeZone(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.timeZone.getID());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRules readExternal(DataInput dataInput) throws IOException, ClassNotFoundException {
        long[] jArr;
        long[] jArr2;
        int readInt = dataInput.readInt();
        if (readInt == 0) {
            jArr = EMPTY_LONG_ARRAY;
        } else {
            jArr = new long[readInt];
        }
        long[] jArr3 = jArr;
        for (int i = 0; i < readInt; i++) {
            jArr3[i] = Ser.readEpochSec(dataInput);
        }
        int i2 = readInt + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            zoneOffsetArr[i3] = Ser.readOffset(dataInput);
        }
        int readInt2 = dataInput.readInt();
        if (readInt2 == 0) {
            jArr2 = EMPTY_LONG_ARRAY;
        } else {
            jArr2 = new long[readInt2];
        }
        long[] jArr4 = jArr2;
        for (int i4 = 0; i4 < readInt2; i4++) {
            jArr4[i4] = Ser.readEpochSec(dataInput);
        }
        int i5 = readInt2 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            zoneOffsetArr2[i6] = Ser.readOffset(dataInput);
        }
        int readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = readByte == 0 ? EMPTY_LASTRULES : new ZoneOffsetTransitionRule[readByte];
        for (int i7 = 0; i7 < readByte; i7++) {
            zoneOffsetTransitionRuleArr[i7] = ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        return new ZoneRules(jArr3, zoneOffsetArr, jArr4, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRules readExternalTimeZone(DataInput dataInput) throws IOException {
        return new ZoneRules(TimeZone.getTimeZone(dataInput.readUTF()));
    }

    public boolean isFixedOffset() {
        TimeZone timeZone = this.timeZone;
        return timeZone != null ? !timeZone.useDaylightTime() && this.timeZone.getDSTSavings() == 0 && previousTransition(Instant.now()) == null : this.savingsInstantTransitions.length == 0;
    }

    public ZoneOffset getOffset(Instant instant) {
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            return offsetFromMillis(timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        long epochSecond = instant.getEpochSecond();
        if (this.lastRules.length > 0) {
            if (epochSecond > this.savingsInstantTransitions[r7.length - 1]) {
                ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear(epochSecond, this.wallOffsets[r7.length - 1]));
                ZoneOffsetTransition zoneOffsetTransition = null;
                for (int i = 0; i < findTransitionArray.length; i++) {
                    zoneOffsetTransition = findTransitionArray[i];
                    if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                        return zoneOffsetTransition.getOffsetBefore();
                    }
                }
                return zoneOffsetTransition.getOffsetAfter();
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.wallOffsets[binarySearch + 1];
    }

    public ZoneOffset getOffset(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).getOffsetBefore();
        }
        return (ZoneOffset) offsetInfo;
    }

    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) offsetInfo).getValidOffsets();
        }
        return Collections.singletonList((ZoneOffset) offsetInfo);
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object offsetInfo = getOffsetInfo(localDateTime);
        if (offsetInfo instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) offsetInfo;
        }
        return null;
    }

    private Object getOffsetInfo(LocalDateTime localDateTime) {
        Object obj = null;
        int i = 0;
        if (this.timeZone != null) {
            ZoneOffsetTransition[] findTransitionArray = findTransitionArray(localDateTime.getYear());
            if (findTransitionArray.length == 0) {
                return offsetFromMillis(this.timeZone.getOffset(localDateTime.toEpochSecond(this.standardOffsets[0]) * 1000));
            }
            int length = findTransitionArray.length;
            while (i < length) {
                ZoneOffsetTransition zoneOffsetTransition = findTransitionArray[i];
                Object findOffsetInfo = findOffsetInfo(localDateTime, zoneOffsetTransition);
                if ((findOffsetInfo instanceof ZoneOffsetTransition) || findOffsetInfo.equals(zoneOffsetTransition.getOffsetBefore())) {
                    return findOffsetInfo;
                }
                i++;
                obj = findOffsetInfo;
            }
            return obj;
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        if (this.lastRules.length > 0) {
            if (localDateTime.isAfter(this.savingsLocalTransitions[r0.length - 1])) {
                ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(localDateTime.getYear());
                int length2 = findTransitionArray2.length;
                while (i < length2) {
                    ZoneOffsetTransition zoneOffsetTransition2 = findTransitionArray2[i];
                    Object findOffsetInfo2 = findOffsetInfo(localDateTime, zoneOffsetTransition2);
                    if ((findOffsetInfo2 instanceof ZoneOffsetTransition) || findOffsetInfo2.equals(zoneOffsetTransition2.getOffsetBefore())) {
                        return findOffsetInfo2;
                    }
                    i++;
                    obj = findOffsetInfo2;
                }
                return obj;
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsLocalTransitions, localDateTime);
        if (binarySearch == -1) {
            return this.wallOffsets[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            Object[] objArr = this.savingsLocalTransitions;
            if (binarySearch < objArr.length - 1) {
                int i2 = binarySearch + 1;
                if (objArr[binarySearch].equals(objArr[i2])) {
                    binarySearch = i2;
                }
            }
        }
        if ((binarySearch & 1) == 0) {
            LocalDateTime[] localDateTimeArr = this.savingsLocalTransitions;
            LocalDateTime localDateTime2 = localDateTimeArr[binarySearch];
            LocalDateTime localDateTime3 = localDateTimeArr[binarySearch + 1];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            int i3 = binarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr[i3];
            ZoneOffset zoneOffset2 = zoneOffsetArr[i3 + 1];
            if (zoneOffset2.getTotalSeconds() > zoneOffset.getTotalSeconds()) {
                return new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2);
            }
            return new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
        }
        return this.wallOffsets[(binarySearch / 2) + 1];
    }

    private Object findOffsetInfo(LocalDateTime localDateTime, ZoneOffsetTransition zoneOffsetTransition) {
        LocalDateTime dateTimeBefore = zoneOffsetTransition.getDateTimeBefore();
        if (zoneOffsetTransition.isGap()) {
            if (localDateTime.isBefore(dateTimeBefore)) {
                return zoneOffsetTransition.getOffsetBefore();
            }
            return localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition : zoneOffsetTransition.getOffsetAfter();
        }
        if (localDateTime.isBefore(dateTimeBefore)) {
            return localDateTime.isBefore(zoneOffsetTransition.getDateTimeAfter()) ? zoneOffsetTransition.getOffsetBefore() : zoneOffsetTransition;
        }
        return zoneOffsetTransition.getOffsetAfter();
    }

    private ZoneOffsetTransition[] findTransitionArray(int i) {
        long j;
        long j2;
        Integer valueOf = Integer.valueOf(i);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = this.lastRulesCache.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        if (this.timeZone == null) {
            ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.lastRules;
            ZoneOffsetTransition[] zoneOffsetTransitionArr2 = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
            for (int i2 = 0; i2 < zoneOffsetTransitionRuleArr.length; i2++) {
                zoneOffsetTransitionArr2[i2] = zoneOffsetTransitionRuleArr[i2].createTransition(i);
            }
            if (i < LAST_CACHED_YEAR) {
                this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr2);
            }
            return zoneOffsetTransitionArr2;
        }
        if (i < 1800) {
            return NO_TRANSITIONS;
        }
        long epochSecond = LocalDateTime.m89of(i - 1, 12, 31, 0, 0).toEpochSecond(this.standardOffsets[0]);
        long j3 = 1000;
        int offset = this.timeZone.getOffset(epochSecond * 1000);
        long j4 = 31968000 + epochSecond;
        ZoneOffsetTransition[] zoneOffsetTransitionArr3 = NO_TRANSITIONS;
        while (epochSecond < j4) {
            long j5 = 7776000 + epochSecond;
            long j6 = epochSecond;
            if (offset != this.timeZone.getOffset(j5 * j3)) {
                epochSecond = j6;
                while (j5 - epochSecond > 1) {
                    long j7 = j4;
                    long floorDiv = Math.floorDiv(j5 + epochSecond, 2L);
                    long j8 = j5;
                    if (this.timeZone.getOffset(floorDiv * 1000) == offset) {
                        epochSecond = floorDiv;
                        j5 = j8;
                    } else {
                        j5 = floorDiv;
                    }
                    j3 = 1000;
                    j4 = j7;
                }
                j = j4;
                long j9 = j5;
                j2 = j3;
                if (this.timeZone.getOffset(epochSecond * j2) == offset) {
                    epochSecond = j9;
                }
                ZoneOffset offsetFromMillis = offsetFromMillis(offset);
                int offset2 = this.timeZone.getOffset(epochSecond * j2);
                ZoneOffset offsetFromMillis2 = offsetFromMillis(offset2);
                if (findYear(epochSecond, offsetFromMillis2) == i) {
                    ZoneOffsetTransition[] zoneOffsetTransitionArr4 = (ZoneOffsetTransition[]) Arrays.copyOf(zoneOffsetTransitionArr3, zoneOffsetTransitionArr3.length + 1);
                    zoneOffsetTransitionArr4[zoneOffsetTransitionArr4.length - 1] = new ZoneOffsetTransition(epochSecond, offsetFromMillis, offsetFromMillis2);
                    offset = offset2;
                    zoneOffsetTransitionArr3 = zoneOffsetTransitionArr4;
                } else {
                    offset = offset2;
                }
            } else {
                j = j4;
                j2 = j3;
                epochSecond = j5;
            }
            j3 = j2;
            j4 = j;
        }
        if (1916 <= i && i < LAST_CACHED_YEAR) {
            this.lastRulesCache.putIfAbsent(valueOf, zoneOffsetTransitionArr3);
        }
        return zoneOffsetTransitionArr3;
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            return offsetFromMillis(timeZone.getRawOffset());
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        int binarySearch = Arrays.binarySearch(this.standardTransitions, instant.getEpochSecond());
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.standardOffsets[binarySearch + 1];
    }

    public Duration getDaylightSavings(Instant instant) {
        if (this.timeZone != null) {
            return Duration.ofMillis(r0.getOffset(instant.toEpochMilli()) - this.timeZone.getRawOffset());
        }
        if (this.savingsInstantTransitions.length == 0) {
            return Duration.ZERO;
        }
        return Duration.ofSeconds(getOffset(instant).getTotalSeconds() - getStandardOffset(instant).getTotalSeconds());
    }

    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return getValidOffsets(localDateTime).contains(zoneOffset);
    }

    public ZoneOffsetTransition nextTransition(Instant instant) {
        if (this.timeZone != null) {
            long epochSecond = instant.getEpochSecond();
            int findYear = findYear(epochSecond, getOffset(instant));
            for (ZoneOffsetTransition zoneOffsetTransition : findTransitionArray(findYear)) {
                if (epochSecond < zoneOffsetTransition.toEpochSecond()) {
                    return zoneOffsetTransition;
                }
            }
            if (findYear < 999999999) {
                for (ZoneOffsetTransition zoneOffsetTransition2 : findTransitionArray(findYear + 1)) {
                    if (epochSecond < zoneOffsetTransition2.toEpochSecond()) {
                        return zoneOffsetTransition2;
                    }
                }
            }
            int offset = this.timeZone.getOffset((1 + epochSecond) * 1000);
            long millis = (Clock.systemUTC().millis() / 1000) + 31968000;
            for (long j = 31104000 + epochSecond; j <= millis; j += 7776000) {
                int offset2 = this.timeZone.getOffset(j * 1000);
                if (offset != offset2) {
                    int findYear2 = findYear(j, offsetFromMillis(offset2));
                    for (ZoneOffsetTransition zoneOffsetTransition3 : findTransitionArray(findYear2 - 1)) {
                        if (epochSecond < zoneOffsetTransition3.toEpochSecond()) {
                            return zoneOffsetTransition3;
                        }
                    }
                    return findTransitionArray(findYear2)[0];
                }
            }
            return null;
        }
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond2 = instant.getEpochSecond();
        long[] jArr = this.savingsInstantTransitions;
        if (epochSecond2 >= jArr[jArr.length - 1]) {
            if (this.lastRules.length == 0) {
                return null;
            }
            int findYear3 = findYear(epochSecond2, this.wallOffsets[r14.length - 1]);
            for (ZoneOffsetTransition zoneOffsetTransition4 : findTransitionArray(findYear3)) {
                if (epochSecond2 < zoneOffsetTransition4.toEpochSecond()) {
                    return zoneOffsetTransition4;
                }
            }
            if (findYear3 < 999999999) {
                return findTransitionArray(findYear3 + 1)[0];
            }
            return null;
        }
        int binarySearch = Arrays.binarySearch(jArr, epochSecond2);
        int i = binarySearch < 0 ? (-binarySearch) - 1 : binarySearch + 1;
        long j2 = this.savingsInstantTransitions[i];
        ZoneOffset[] zoneOffsetArr = this.wallOffsets;
        return new ZoneOffsetTransition(j2, zoneOffsetArr[i], zoneOffsetArr[i + 1]);
    }

    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.timeZone != null) {
            long epochSecond = instant.getEpochSecond();
            if (instant.getNano() > 0 && epochSecond < LocationRequestCompat.PASSIVE_INTERVAL) {
                epochSecond++;
            }
            int findYear = findYear(epochSecond, getOffset(instant));
            ZoneOffsetTransition[] findTransitionArray = findTransitionArray(findYear);
            for (int length = findTransitionArray.length - 1; length >= 0; length--) {
                if (epochSecond > findTransitionArray[length].toEpochSecond()) {
                    return findTransitionArray[length];
                }
            }
            if (findYear > 1800) {
                ZoneOffsetTransition[] findTransitionArray2 = findTransitionArray(findYear - 1);
                for (int length2 = findTransitionArray2.length - 1; length2 >= 0; length2--) {
                    if (epochSecond > findTransitionArray2[length2].toEpochSecond()) {
                        return findTransitionArray2[length2];
                    }
                }
                int offset = this.timeZone.getOffset((epochSecond - 1) * 1000);
                long epochDay = LocalDate.m87of(1800, 1, 1).toEpochDay() * 86400;
                for (long min = Math.min(epochSecond - 31104000, (Clock.systemUTC().millis() / 1000) + 31968000); epochDay <= min; min -= 7776000) {
                    int offset2 = this.timeZone.getOffset(min * 1000);
                    if (offset != offset2) {
                        int findYear2 = findYear(min, offsetFromMillis(offset2));
                        ZoneOffsetTransition[] findTransitionArray3 = findTransitionArray(findYear2 + 1);
                        for (int length3 = findTransitionArray3.length - 1; length3 >= 0; length3--) {
                            if (epochSecond > findTransitionArray3[length3].toEpochSecond()) {
                                return findTransitionArray3[length3];
                            }
                        }
                        ZoneOffsetTransition[] findTransitionArray4 = findTransitionArray(findYear2);
                        return findTransitionArray4[findTransitionArray4.length - 1];
                    }
                }
            }
            return null;
        }
        if (this.savingsInstantTransitions.length == 0) {
            return null;
        }
        long epochSecond2 = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSecond2 < LocationRequestCompat.PASSIVE_INTERVAL) {
            epochSecond2++;
        }
        long[] jArr = this.savingsInstantTransitions;
        long j = jArr[jArr.length - 1];
        if (this.lastRules.length > 0 && epochSecond2 > j) {
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
            int findYear3 = findYear(epochSecond2, zoneOffset);
            ZoneOffsetTransition[] findTransitionArray5 = findTransitionArray(findYear3);
            for (int length4 = findTransitionArray5.length - 1; length4 >= 0; length4--) {
                if (epochSecond2 > findTransitionArray5[length4].toEpochSecond()) {
                    return findTransitionArray5[length4];
                }
            }
            int i = findYear3 - 1;
            if (i > findYear(j, zoneOffset)) {
                ZoneOffsetTransition[] findTransitionArray6 = findTransitionArray(i);
                return findTransitionArray6[findTransitionArray6.length - 1];
            }
        }
        int binarySearch = Arrays.binarySearch(this.savingsInstantTransitions, epochSecond2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        if (binarySearch <= 0) {
            return null;
        }
        int i2 = binarySearch - 1;
        long j2 = this.savingsInstantTransitions[i2];
        ZoneOffset[] zoneOffsetArr2 = this.wallOffsets;
        return new ZoneOffsetTransition(j2, zoneOffsetArr2[i2], zoneOffsetArr2[binarySearch]);
    }

    private int findYear(long j, ZoneOffset zoneOffset) {
        return LocalDate.ofEpochDay(UByte$.ExternalSyntheticBackport0.m(j + zoneOffset.getTotalSeconds(), 86400)).getYear();
    }

    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.savingsInstantTransitions.length) {
            long j = this.savingsInstantTransitions[i];
            ZoneOffset[] zoneOffsetArr = this.wallOffsets;
            ZoneOffset zoneOffset = zoneOffsetArr[i];
            i++;
            arrayList.add(new ZoneOffsetTransition(j, zoneOffset, zoneOffsetArr[i]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return UByte$.ExternalSyntheticBackport0.m(this.lastRules);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneRules)) {
            return false;
        }
        ZoneRules zoneRules = (ZoneRules) obj;
        return Objects.equals(this.timeZone, zoneRules.timeZone) && Arrays.equals(this.standardTransitions, zoneRules.standardTransitions) && Arrays.equals(this.standardOffsets, zoneRules.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, zoneRules.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, zoneRules.wallOffsets) && Arrays.equals(this.lastRules, zoneRules.lastRules);
    }

    public int hashCode() {
        return ((((Objects.hashCode(this.timeZone) ^ Arrays.hashCode(this.standardTransitions)) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public String toString() {
        if (this.timeZone != null) {
            return "ZoneRules[timeZone=" + this.timeZone.getID() + "]";
        }
        return new StringBuilder("ZoneRules[currentStandardOffset=").append(this.standardOffsets[r2.length - 1]).append("]").toString();
    }
}
