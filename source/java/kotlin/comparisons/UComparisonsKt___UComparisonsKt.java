package kotlin.comparisons;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UComparisons.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a(\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010\b\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b(\u0010\u000b\u001a\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010\u000e\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a(\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b+\u0010\u0013\u001a(\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b,\u0010\u0015\u001a(\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\u0017\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010\u001b\u001a#\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\u001e\u001a#\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UInt;", IEncryptorType.DEFAULT_ENCRYPTOR, "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", AirActionConstant.ActionId.ACTION_ID_CALL, "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", PreloadConfig.KEY_OTHER, "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes8.dex */
public class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m11452maxOfJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare >= 0 ? i : i2;
    }

    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m11460maxOfeb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        return compare >= 0 ? j : j2;
    }

    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m11453maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) >= 0 ? b : b2;
    }

    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m11451maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & 65535, 65535 & s2) >= 0 ? s : s2;
    }

    /* renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m11457maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m11452maxOfJ1ME1BU(i, UComparisonsKt.m11452maxOfJ1ME1BU(i2, i3));
    }

    /* renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m11461maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m11460maxOfeb3DHEI(j, UComparisonsKt.m11460maxOfeb3DHEI(j2, j3));
    }

    /* renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m11459maxOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m11453maxOfKr8caGY(b, UComparisonsKt.m11453maxOfKr8caGY(b2, b3));
    }

    /* renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m11456maxOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m11451maxOf5PvTz6A(s, UComparisonsKt.m11451maxOf5PvTz6A(s2, s3));
    }

    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m11454maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10420getSizeimpl = UIntArray.m10420getSizeimpl(other);
        for (int i2 = 0; i2 < m10420getSizeimpl; i2++) {
            i = UComparisonsKt.m11452maxOfJ1ME1BU(i, UIntArray.m10419getpVg5ArA(other, i2));
        }
        return i;
    }

    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m11455maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10499getSizeimpl = ULongArray.m10499getSizeimpl(other);
        for (int i = 0; i < m10499getSizeimpl; i++) {
            j = UComparisonsKt.m11460maxOfeb3DHEI(j, ULongArray.m10498getsVKNKU(other, i));
        }
        return j;
    }

    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m11458maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10341getSizeimpl = UByteArray.m10341getSizeimpl(other);
        for (int i = 0; i < m10341getSizeimpl; i++) {
            b = UComparisonsKt.m11453maxOfKr8caGY(b, UByteArray.m10340getw2LRezQ(other, i));
        }
        return b;
    }

    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m11462maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10604getSizeimpl = UShortArray.m10604getSizeimpl(other);
        for (int i = 0; i < m10604getSizeimpl; i++) {
            s = UComparisonsKt.m11451maxOf5PvTz6A(s, UShortArray.m10603getMh2AYeg(other, i));
        }
        return s;
    }

    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m11464minOfJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare <= 0 ? i : i2;
    }

    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m11472minOfeb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        return compare <= 0 ? j : j2;
    }

    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m11465minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) <= 0 ? b : b2;
    }

    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m11463minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & 65535, 65535 & s2) <= 0 ? s : s2;
    }

    /* renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m11469minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m11464minOfJ1ME1BU(i, UComparisonsKt.m11464minOfJ1ME1BU(i2, i3));
    }

    /* renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m11473minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m11472minOfeb3DHEI(j, UComparisonsKt.m11472minOfeb3DHEI(j2, j3));
    }

    /* renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m11471minOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m11465minOfKr8caGY(b, UComparisonsKt.m11465minOfKr8caGY(b2, b3));
    }

    /* renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m11468minOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m11463minOf5PvTz6A(s, UComparisonsKt.m11463minOf5PvTz6A(s2, s3));
    }

    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m11466minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10420getSizeimpl = UIntArray.m10420getSizeimpl(other);
        for (int i2 = 0; i2 < m10420getSizeimpl; i2++) {
            i = UComparisonsKt.m11464minOfJ1ME1BU(i, UIntArray.m10419getpVg5ArA(other, i2));
        }
        return i;
    }

    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m11467minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10499getSizeimpl = ULongArray.m10499getSizeimpl(other);
        for (int i = 0; i < m10499getSizeimpl; i++) {
            j = UComparisonsKt.m11472minOfeb3DHEI(j, ULongArray.m10498getsVKNKU(other, i));
        }
        return j;
    }

    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m11470minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10341getSizeimpl = UByteArray.m10341getSizeimpl(other);
        for (int i = 0; i < m10341getSizeimpl; i++) {
            b = UComparisonsKt.m11465minOfKr8caGY(b, UByteArray.m10340getw2LRezQ(other, i));
        }
        return b;
    }

    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m11474minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m10604getSizeimpl = UShortArray.m10604getSizeimpl(other);
        for (int i = 0; i < m10604getSizeimpl; i++) {
            s = UComparisonsKt.m11463minOf5PvTz6A(s, UShortArray.m10603getMh2AYeg(other, i));
        }
        return s;
    }
}
