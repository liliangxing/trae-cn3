package com.bytedance.applog.sampling.util;

import androidx.collection.SieveCacheKt;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.upc.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes3.dex */
public class CityHashUtils {
    public static final int c1 = -862048943;
    public static final int c2 = 461845907;
    public static final long k0 = -4348849565147123417L;
    public static final long k1 = -5435081209227447693L;
    public static final long k2 = -7286425919675154353L;
    public static final long kMul = -7070675565921424023L;
    private static final boolean IS_BIG_EDIAN = !"little".equals(System.getProperty("sun.cpu.endian"));
    private static CityHashUtils citiHash = new CityHashUtils();
    private static long quarter = SieveCacheKt.NodeVisitedBit;

    private int fmix(int i) {
        int i2 = (i ^ (i >>> 16)) * (-2048144789);
        int i3 = (i2 ^ (i2 >>> 13)) * (-1028477387);
        return i3 ^ (i3 >>> 16);
    }

    private long hashLen16(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private long rotate(long j, int i) {
        if (i == 0) {
            return j;
        }
        return (j << (64 - i)) | (j >>> i);
    }

    static int rotate32(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        return (i << (32 - i2)) | (i >>> i2);
    }

    private long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    public static BigInteger hash64UnSign(String str) {
        if (str == null) {
            str = "NULL";
        }
        return getInstance().hash64Unsign(str);
    }

    public int hash32(String str) {
        byte[] convertString2UTF8 = convertString2UTF8(str);
        int length = convertString2UTF8.length;
        if (length <= 24) {
            return length <= 12 ? length <= 4 ? hash32Len0to4(convertString2UTF8) : hash32Len5to12(convertString2UTF8) : hash32Len13to24(convertString2UTF8);
        }
        int i = 17;
        int rotate32 = rotate32(fetch32(convertString2UTF8, length - 4) * (-862048943), 17);
        int i2 = c2;
        int i3 = rotate32 * c2;
        int rotate322 = rotate32(fetch32(convertString2UTF8, length - 8) * (-862048943), 17) * c2;
        int rotate323 = rotate32(fetch32(convertString2UTF8, length - 16) * (-862048943), 17) * c2;
        int rotate324 = rotate32(fetch32(convertString2UTF8, length - 12) * (-862048943), 17) * c2;
        int rotate325 = rotate32(fetch32(convertString2UTF8, length - 20) * (-862048943), 17) * c2;
        int rotate326 = (rotate32(((rotate32(i3 ^ length, 19) * 5) - 430675100) ^ rotate323, 19) * 5) - 430675100;
        int rotate327 = (rotate32(((rotate32(rotate322 ^ r4, 19) * 5) - 430675100) ^ rotate324, 19) * 5) - 430675100;
        int rotate328 = (rotate32((length * (-862048943)) + rotate325, 19) * 5) - 430675100;
        int i4 = (length - 1) / 20;
        int i5 = 0;
        while (true) {
            int rotate329 = rotate32(fetch32(convertString2UTF8, i5) * (-862048943), i) * i2;
            int fetch32 = fetch32(convertString2UTF8, i5 + 4);
            int rotate3210 = rotate32(fetch32(convertString2UTF8, i5 + 8) * (-862048943), i) * i2;
            int rotate3211 = rotate32(fetch32(convertString2UTF8, i5 + 12) * (-862048943), i) * i2;
            int fetch322 = fetch32(convertString2UTF8, i5 + 16);
            int rotate3212 = (rotate32(rotate326 ^ rotate329, 18) * 5) - 430675100;
            int rotate3213 = rotate32(rotate328 + fetch32, 19) * (-862048943);
            int rotate3214 = (rotate32(rotate327 + rotate3210, 18) * 5) - 430675100;
            int rotate3215 = (rotate32(rotate3212 ^ (rotate3211 + fetch32), 19) * 5) - 430675100;
            int reverseBytes = Integer.reverseBytes(rotate3214 ^ fetch322) * 5;
            rotate327 = Integer.reverseBytes(rotate3215 + (fetch322 * 5));
            rotate326 = rotate3213 + rotate329;
            i5 += 20;
            i4--;
            if (i4 == 0) {
                return rotate32((rotate32((rotate32((rotate32(rotate326 + (rotate32(rotate32(rotate327, 11) * (-862048943), 17) * (-862048943)), 19) * 5) - 430675100, 17) * (-862048943)) + (rotate32(rotate32(reverseBytes, 11) * (-862048943), 17) * (-862048943)), 19) * 5) - 430675100, 17) * (-862048943);
            }
            rotate328 = reverseBytes;
            i = 17;
            i2 = c2;
        }
    }

    public BigInteger hash64Unsign(String str) {
        long hash64 = hash64(str);
        if (hash64 >= 0) {
            return BigInteger.valueOf(hash64);
        }
        return BigInteger.valueOf(hash64 & Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE)).add(BigInteger.valueOf(1L));
    }

    private long hash64(String str) {
        byte[] convertString2UTF8 = convertString2UTF8(str);
        int length = convertString2UTF8.length;
        if (length <= 32) {
            if (length <= 16) {
                return hashLen0to16(convertString2UTF8);
            }
            return hashLen17to32(convertString2UTF8);
        }
        if (length <= 64) {
            return hashLen33to64(convertString2UTF8);
        }
        long fetch64 = fetch64(convertString2UTF8, length - 40);
        long fetch642 = fetch64(convertString2UTF8, length - 16) + fetch64(convertString2UTF8, length - 56);
        long j = length;
        long hashLen16 = hashLen16(fetch64(convertString2UTF8, length - 48) + j, fetch64(convertString2UTF8, length - 24));
        Number128 weakHashLen32WithSeeds = weakHashLen32WithSeeds(convertString2UTF8, length - 64, j, hashLen16);
        Number128 weakHashLen32WithSeeds2 = weakHashLen32WithSeeds(convertString2UTF8, length - 32, fetch642 + k1, fetch64);
        long fetch643 = (fetch64 * k1) + fetch64(convertString2UTF8, 0);
        int i = (length - 1) & (-64);
        Number128 number128 = weakHashLen32WithSeeds2;
        int i2 = 0;
        int i3 = i;
        long j2 = fetch643;
        while (true) {
            long rotate = rotate(j2 + fetch642 + weakHashLen32WithSeeds.getLowValue() + fetch64(convertString2UTF8, i2 + 8), 37) * k1;
            long rotate2 = rotate(fetch642 + weakHashLen32WithSeeds.getHiValue() + fetch64(convertString2UTF8, i2 + 48), 42) * k1;
            long hiValue = rotate ^ number128.getHiValue();
            long lowValue = rotate2 + weakHashLen32WithSeeds.getLowValue() + fetch64(convertString2UTF8, i2 + 40);
            long rotate3 = rotate(number128.getLowValue() + hashLen16, 33) * k1;
            weakHashLen32WithSeeds = weakHashLen32WithSeeds(convertString2UTF8, i2, weakHashLen32WithSeeds.getHiValue() * k1, hiValue + number128.getLowValue());
            number128 = weakHashLen32WithSeeds(convertString2UTF8, i2 + 32, rotate3 + number128.getHiValue(), lowValue + fetch64(convertString2UTF8, i2 + 16));
            i2 += 64;
            i3 -= 64;
            if (i3 == 0) {
                return hashLen16(hashLen16(weakHashLen32WithSeeds.getLowValue(), number128.getLowValue()) + (shiftMix(lowValue) * k1) + hiValue, hashLen16(weakHashLen32WithSeeds.getHiValue(), number128.getHiValue()) + rotate3);
            }
            j2 = rotate3;
            hashLen16 = hiValue;
            fetch642 = lowValue;
        }
    }

    public long hash64WithSeeds(String str, long j, long j2) {
        return hashLen16(hash64(str) - j, j2);
    }

    public long hash64WithSeed(String str, long j) {
        return hash64WithSeeds(str, k2, j);
    }

    public Number128 hash128(String str) {
        byte[] convertString2UTF8 = convertString2UTF8(str);
        return convertString2UTF8.length >= 16 ? hash128WithSeed(convertString2UTF8, 16, new Number128(fetch64(convertString2UTF8, 0), fetch64(convertString2UTF8, 8) + k0)) : hash128WithSeed(convertString2UTF8, 0, new Number128(k0, k1));
    }

    public Number128 hash128WithSeed(String str, Number128 number128) {
        return hash128WithSeed(convertString2UTF8(str), 0, number128);
    }

    private Number128 hash128WithSeed(byte[] bArr, int i, Number128 number128) {
        long lowValue;
        long rotate;
        Number128 weakHashLen32WithSeeds;
        Number128 weakHashLen32WithSeeds2;
        int i2;
        int length = bArr.length - i;
        if (length < 128) {
            return cityMurmur(Arrays.copyOfRange(bArr, i, bArr.length), number128);
        }
        Number128 number1282 = new Number128(0L, 0L);
        Number128 number1283 = new Number128(0L, 0L);
        long lowValue2 = number128.getLowValue();
        long hiValue = number128.getHiValue();
        long j = length * k1;
        int i3 = length;
        number1282.setLowValue((rotate(hiValue ^ k1, 49) * k1) + fetch64(bArr, i));
        number1282.setHiValue((rotate(number1282.getLowValue(), 42) * k1) + fetch64(bArr, i + 8));
        number1283.setLowValue((rotate(hiValue + j, 35) * k1) + lowValue2);
        number1283.setHiValue(rotate(fetch64(bArr, i + 88) + lowValue2, 53) * k1);
        int i4 = i;
        long j2 = hiValue;
        Number128 number1284 = number1283;
        while (true) {
            long rotate2 = rotate(lowValue2 + j2 + number1282.getLowValue() + fetch64(bArr, i4 + 8), 37) * k1;
            long rotate3 = rotate(j2 + number1282.getHiValue() + fetch64(bArr, i4 + 48), 42) * k1;
            long hiValue2 = rotate2 ^ number1284.getHiValue();
            long lowValue3 = rotate3 + number1282.getLowValue() + fetch64(bArr, i4 + 40);
            long rotate4 = rotate(j + number1284.getLowValue(), 33) * k1;
            Number128 weakHashLen32WithSeeds3 = weakHashLen32WithSeeds(bArr, i4, number1282.getHiValue() * k1, hiValue2 + number1284.getLowValue());
            Number128 weakHashLen32WithSeeds4 = weakHashLen32WithSeeds(bArr, i4 + 32, rotate4 + number1284.getHiValue(), lowValue3 + fetch64(bArr, i4 + 16));
            int i5 = i4 + 64;
            long rotate5 = rotate(rotate4 + lowValue3 + weakHashLen32WithSeeds3.getLowValue() + fetch64(bArr, i5 + 8), 37) * k1;
            long rotate6 = rotate(lowValue3 + weakHashLen32WithSeeds3.getHiValue() + fetch64(bArr, i5 + 48), 42) * k1;
            j = rotate5 ^ weakHashLen32WithSeeds4.getHiValue();
            lowValue = rotate6 + weakHashLen32WithSeeds3.getLowValue() + fetch64(bArr, i5 + 40);
            rotate = rotate(hiValue2 + weakHashLen32WithSeeds4.getLowValue(), 33) * k1;
            weakHashLen32WithSeeds = weakHashLen32WithSeeds(bArr, i5, weakHashLen32WithSeeds3.getHiValue() * k1, j + weakHashLen32WithSeeds4.getLowValue());
            weakHashLen32WithSeeds2 = weakHashLen32WithSeeds(bArr, i5 + 32, rotate + weakHashLen32WithSeeds4.getHiValue(), lowValue + fetch64(bArr, i5 + 16));
            i4 = i5 + 64;
            i2 = i3 - 128;
            if (i2 < 128) {
                break;
            }
            number1282 = weakHashLen32WithSeeds;
            lowValue2 = rotate;
            j2 = lowValue;
            number1284 = weakHashLen32WithSeeds2;
            i3 = i2;
        }
        long rotate7 = rotate(weakHashLen32WithSeeds.getLowValue() + j, 49);
        long j3 = k0;
        long j4 = rotate + (rotate7 * k0);
        long rotate8 = (lowValue * k0) + rotate(weakHashLen32WithSeeds2.getHiValue(), 37);
        long rotate9 = (j * k0) + rotate(weakHashLen32WithSeeds2.getLowValue(), 27);
        weakHashLen32WithSeeds2.setLowValue(weakHashLen32WithSeeds2.getLowValue() * 9);
        weakHashLen32WithSeeds.setLowValue(weakHashLen32WithSeeds.getLowValue() * k0);
        int i6 = 0;
        long j5 = j4;
        while (i6 < i2) {
            int i7 = i6 + 32;
            rotate8 = (rotate(j5 + rotate8, 42) * j3) + weakHashLen32WithSeeds.getHiValue();
            int i8 = (i4 + i2) - i7;
            weakHashLen32WithSeeds2.setLowValue(weakHashLen32WithSeeds2.getLowValue() + fetch64(bArr, i8 + 16));
            long lowValue4 = (j5 * k0) + weakHashLen32WithSeeds2.getLowValue();
            rotate9 += weakHashLen32WithSeeds2.getHiValue() + fetch64(bArr, i8);
            weakHashLen32WithSeeds2.setHiValue(weakHashLen32WithSeeds2.getHiValue() + weakHashLen32WithSeeds.getLowValue());
            weakHashLen32WithSeeds = weakHashLen32WithSeeds(bArr, i8, weakHashLen32WithSeeds.getLowValue() + rotate9, weakHashLen32WithSeeds.getHiValue());
            weakHashLen32WithSeeds.setLowValue(weakHashLen32WithSeeds.getLowValue() * k0);
            i6 = i7;
            j5 = lowValue4;
            weakHashLen32WithSeeds2 = weakHashLen32WithSeeds2;
            i2 = i2;
            j3 = -4348849565147123417L;
        }
        Number128 number1285 = weakHashLen32WithSeeds2;
        long hashLen16 = hashLen16(j5, weakHashLen32WithSeeds.getLowValue());
        long hashLen162 = hashLen16(rotate8 + rotate9, number1285.getLowValue());
        return new Number128(hashLen16(weakHashLen32WithSeeds.getHiValue() + hashLen16, number1285.getHiValue()) + hashLen162, hashLen16(hashLen16 + number1285.getHiValue(), hashLen162 + weakHashLen32WithSeeds.getHiValue()));
    }

    private int hash32Len0to4(byte[] bArr) {
        int length = bArr.length;
        int i = 9;
        int i2 = 0;
        for (byte b : bArr) {
            i2 = (i2 * (-862048943)) + b;
            i ^= i2;
        }
        return fmix(mur(i2, mur(length, i)));
    }

    private int hash32Len5to12(byte[] bArr) {
        int length = bArr.length;
        int i = length * 5;
        return fmix(mur(fetch32(bArr, (length >>> 1) & 4) + 9, mur(fetch32(bArr, length - 4) + i, mur(fetch32(bArr, 0) + length, i))));
    }

    private int hash32Len13to24(byte[] bArr) {
        int length = bArr.length;
        int i = length >>> 1;
        int fetch32 = fetch32(bArr, i - 4);
        int fetch322 = fetch32(bArr, 4);
        int fetch323 = fetch32(bArr, length - 8);
        return fmix(mur(fetch32(bArr, length - 4), mur(fetch32(bArr, 0), mur(fetch32(bArr, i), mur(fetch323, mur(fetch322, mur(fetch32, length)))))));
    }

    private long hashLen0to16(byte[] bArr) {
        int length = bArr.length;
        if (length >= 8) {
            long j = (length * 2) + k2;
            long fetch64 = fetch64(bArr, 0) + k2;
            long fetch642 = fetch64(bArr, length - 8);
            return hashLen16((rotate(fetch642, 37) * j) + fetch64, (rotate(fetch64, 25) + fetch642) * j, j);
        }
        if (length >= 4) {
            return hashLen16(((fetch32(bArr, 0) & BodyPartID.bodyIdMax) << 3) + length, BodyPartID.bodyIdMax & fetch32(bArr, length - 4), (length * 2) + k2);
        }
        if (length <= 0) {
            return k2;
        }
        int i = bArr[0] & UByte.MAX_VALUE;
        int i2 = bArr[length >>> 1] & UByte.MAX_VALUE;
        return shiftMix(((length + ((bArr[length - 1] & UByte.MAX_VALUE) << 2)) * k0) ^ ((i + (i2 << 8)) * k2)) * k2;
    }

    private long hashLen17to32(byte[] bArr) {
        int length = bArr.length;
        long j = (length * 2) + k2;
        long fetch64 = fetch64(bArr, 0) * k1;
        long fetch642 = fetch64(bArr, 8);
        long fetch643 = fetch64(bArr, length - 8) * j;
        return hashLen16(rotate(fetch64 + fetch642, 43) + rotate(fetch643, 30) + (fetch64(bArr, length - 16) * k2), fetch64 + rotate(fetch642 + k2, 18) + fetch643, j);
    }

    private long hashLen33to64(byte[] bArr) {
        int length = bArr.length;
        long j = (length * 2) + k2;
        long fetch64 = fetch64(bArr, 0) * k2;
        long fetch642 = fetch64(bArr, 8);
        long fetch643 = fetch64(bArr, length - 24);
        long fetch644 = fetch64(bArr, length - 32);
        long fetch645 = fetch64(bArr, 16) * k2;
        long fetch646 = fetch64(bArr, 24) * 9;
        long fetch647 = fetch64(bArr, length - 8);
        long fetch648 = fetch64(bArr, length - 16) * j;
        long j2 = fetch64 + fetch647;
        long rotate = rotate(j2, 43) + ((rotate(fetch642, 30) + fetch643) * 9);
        long j3 = (j2 ^ fetch644) + fetch646 + 1;
        long reverseBytes = Long.reverseBytes((rotate + j3) * j) + fetch648;
        long j4 = fetch645 + fetch646;
        long rotate2 = rotate(j4, 42) + fetch643;
        long j5 = j4 + fetch643;
        return (shiftMix(((j5 + Long.reverseBytes(((rotate2 + j5) * j) + ((Long.reverseBytes((j3 + reverseBytes) * j) + fetch647) * j)) + fetch642) * j) + fetch644 + fetch648) * j) + rotate2;
    }

    private long loadUnaligned64(byte[] bArr, int i) {
        OrderIter orderIter = new OrderIter(8, IS_BIG_EDIAN);
        long j = 0;
        while (orderIter.hasNext()) {
            j |= (bArr[r1 + i] & 255) << (orderIter.next() * 8);
        }
        return j;
    }

    private int loadUnaligned32(byte[] bArr, int i) {
        OrderIter orderIter = new OrderIter(4, IS_BIG_EDIAN);
        int i2 = 0;
        while (orderIter.hasNext()) {
            int next = orderIter.next();
            i2 |= (bArr[next + i] & 255) << (next * 8);
        }
        return i2;
    }

    private long fetch64(byte[] bArr, int i) {
        return loadUnaligned64(bArr, i);
    }

    private int fetch32(byte[] bArr, int i) {
        return loadUnaligned32(bArr, i);
    }

    private long hashLen16(long j, long j2) {
        return hash128to64(new Number128(j, j2));
    }

    private long hash128to64(Number128 number128) {
        long lowValue = (number128.getLowValue() ^ number128.getHiValue()) * kMul;
        long hiValue = ((lowValue ^ (lowValue >>> 47)) ^ number128.getHiValue()) * kMul;
        return (hiValue ^ (hiValue >>> 47)) * kMul;
    }

    private int mur(int i, int i2) {
        return (rotate32((rotate32(i * (-862048943), 17) * c2) ^ i2, 19) * 5) - 430675100;
    }

    private Number128 weakHashLen32WithSeeds(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j5 + j;
        long j8 = j2 + j7 + j3;
        return new Number128(j8 + j4, rotate(j6 + j7 + j4, 21) + rotate(j8, 44) + j7);
    }

    private Number128 weakHashLen32WithSeeds(byte[] bArr, int i, long j, long j2) {
        return weakHashLen32WithSeeds(fetch64(bArr, i), fetch64(bArr, i + 8), fetch64(bArr, i + 16), fetch64(bArr, i + 24), j, j2);
    }

    private Number128 cityMurmur(byte[] bArr, Number128 number128) {
        long j;
        long j2;
        long j3;
        int length = bArr.length;
        long lowValue = number128.getLowValue();
        long hiValue = number128.getHiValue();
        int i = length - 16;
        if (i <= 0) {
            j = shiftMix(lowValue * k1) * k1;
            j3 = (k1 * hiValue) + hashLen0to16(bArr);
            j2 = shiftMix((length >= 8 ? fetch64(bArr, 0) : j3) + j);
        } else {
            long hashLen16 = hashLen16(fetch64(bArr, length - 8) + k1, lowValue);
            long hashLen162 = hashLen16(length + hiValue, hashLen16 + fetch64(bArr, i));
            j = lowValue + hashLen162;
            long j4 = hashLen162;
            int i2 = 0;
            do {
                j = (j ^ (shiftMix(fetch64(bArr, i2) * k1) * k1)) * k1;
                hiValue ^= j;
                hashLen16 = (hashLen16 ^ (shiftMix(fetch64(bArr, i2 + 8) * k1) * k1)) * k1;
                j4 ^= hashLen16;
                i2 += 16;
                i -= 16;
            } while (i > 0);
            j2 = j4;
            j3 = hashLen16;
        }
        long hashLen163 = hashLen16(j, j3);
        long hashLen164 = hashLen16(j2, hiValue);
        return new Number128(hashLen163 ^ hashLen164, hashLen16(hashLen164, hashLen163));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class OrderIter {
        private int index;
        private final boolean isBigEdian;
        private final int size;

        OrderIter(int i, boolean z) {
            this.size = i;
            this.isBigEdian = z;
        }

        boolean hasNext() {
            return this.index < this.size;
        }

        int next() {
            if (!this.isBigEdian) {
                int i = this.index;
                this.index = i + 1;
                return i;
            }
            int i2 = this.size - 1;
            int i3 = this.index;
            this.index = i3 + 1;
            return i2 - i3;
        }
    }

    private byte[] convertString2UTF8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static CityHashUtils getInstance() {
        return citiHash;
    }

    public static int nonNegativeMod(BigInteger bigInteger, int i) {
        long j = i;
        long longValue = bigInteger.mod(BigInteger.valueOf(j)).longValue();
        if (longValue < 0) {
            longValue += j;
        }
        return (int) longValue;
    }

    public static void main(String[] strArr) {
        System.out.println(getInstance().hash64(IEncryptorType.DEFAULT_ENCRYPTOR));
        System.out.println(getInstance().hash64("abcdefghijkl"));
        System.out.println(getInstance().hash64("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(getInstance().hash64("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println(getInstance().hash64("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println("=======");
        System.out.println(new BigInteger("15778675771769088146").add(new BigInteger("2668068301940463470")).toString());
        System.out.println(new BigInteger("12917804110809363939").add(new BigInteger("5528939962900187677")).toString());
        System.out.println(-1);
        System.out.println(new BigInteger("18446744073709551616").divide(new BigInteger(Constants.RECOMMEND_BASE_ON_FOLLOW_LIST)));
        System.out.println(new BigInteger("12917804110809363939").mod(new BigInteger("16000")));
    }
}
