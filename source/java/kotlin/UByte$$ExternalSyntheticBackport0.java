package kotlin;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes8.dex */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(int i, int i2) {
        return (int) ((i & BodyPartID.bodyIdMax) % (i2 & BodyPartID.bodyIdMax));
    }

    public static /* synthetic */ int m(long j, int i) {
        return (int) Math.floorMod(j, i);
    }

    public static /* synthetic */ int m(String str, int i) {
        if (str.length() > 1 && str.charAt(0) == '+') {
            str = str.substring(1);
        }
        long parseLong = Long.parseLong(str, i);
        if ((BodyPartID.bodyIdMax & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ long m10323m(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ long m10326m(String str, int i) {
        return m$1(str, 0, str.length(), i);
    }

    public static /* synthetic */ Object m(Object obj, Object obj2) {
        return obj != null ? obj : Objects.requireNonNull(obj2, "defaultObj");
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ String m10327m(int i, int i2) {
        return Long.toString(i & BodyPartID.bodyIdMax, i2);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ String m10328m(long j, int i) {
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        if (i < 2 || i > 36) {
            i = 10;
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long m10323m = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : m10323m(j, i);
            long j2 = i;
            cArr[63] = Character.forDigit((int) (j - (m10323m * j2)), i);
            i2 = 63;
            while (m10323m > 0) {
                i2--;
                cArr[i2] = Character.forDigit((int) (m10323m % j2), i);
                m10323m /= j2;
            }
        }
        return new String(cArr, i2, 64 - i2);
    }

    public static /* synthetic */ String m(CharSequence charSequence, Iterable iterable) {
        if (charSequence == null) {
            throw new NullPointerException("delimiter");
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append(charSequence);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ List m(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(Objects.requireNonNull(obj));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ Map.Entry m10330m(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(obj), Objects.requireNonNull(obj2));
    }

    public static /* synthetic */ Map m(Map.Entry[] entryArr) {
        HashMap hashMap = new HashMap(entryArr.length);
        for (Map.Entry entry : entryArr) {
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap.put(requireNonNull, Objects.requireNonNull(entry.getValue())) != null) {
                throw new IllegalArgumentException("duplicate key: " + requireNonNull);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ boolean m10331m(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!Character.isWhitespace(codePointAt)) {
                return false;
            }
            i += Character.charCount(codePointAt);
        }
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ int m$1(int i, int i2) {
        return (int) ((i & BodyPartID.bodyIdMax) / (i2 & BodyPartID.bodyIdMax));
    }

    public static /* synthetic */ long m$1(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if ((j3 ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE)) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static /* synthetic */ long m$1(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i4 == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i3 < 2 || i3 > 36) {
            throw new NumberFormatException("illegal radix: ".concat(String.valueOf(i3)));
        }
        long j = i3;
        long m10323m = m10323m(-1L, j);
        int i5 = (charSequence.charAt(i) != '+' || i4 <= 1) ? i : i + 1;
        long j2 = 0;
        long j3 = 0;
        while (i5 < i2) {
            int digit = Character.digit(charSequence.charAt(i5), i3);
            if (digit == -1) {
                throw new NumberFormatException(charSequence.toString());
            }
            if (j3 < j2 || j3 > m10323m || (j3 == m10323m && digit > ((int) m$1(-1L, j)))) {
                throw new NumberFormatException("Too large for unsigned long: ".concat(charSequence.toString()));
            }
            j3 = (j3 * j) + digit;
            i5++;
            j2 = 0;
        }
        return j3;
    }

    public static /* synthetic */ long m$1(String str, int i) {
        return m$1(str, 0, str.length(), i);
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ String m10332m$1(long j, int i) {
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        if (i < 2 || i > 36) {
            i = 10;
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long m10323m = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : m10323m(j, i);
            long j2 = i;
            cArr[63] = Character.forDigit((int) (j - (m10323m * j2)), i);
            i2 = 63;
            while (m10323m > 0) {
                i2--;
                cArr[i2] = Character.forDigit((int) (m10323m % j2), i);
                m10323m /= j2;
            }
        }
        return new String(cArr, i2, 64 - i2);
    }

    public static /* synthetic */ String m$2(long j, int i) {
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        if (i < 2 || i > 36) {
            i = 10;
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long m10323m = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : m10323m(j, i);
            long j2 = i;
            cArr[63] = Character.forDigit((int) (j - (m10323m * j2)), i);
            i2 = 63;
            while (m10323m > 0) {
                i2--;
                cArr[i2] = Character.forDigit((int) (m10323m % j2), i);
                m10323m /= j2;
            }
        }
        return new String(cArr, i2, 64 - i2);
    }
}
