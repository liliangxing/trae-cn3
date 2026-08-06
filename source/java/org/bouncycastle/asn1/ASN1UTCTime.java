package org.bouncycastle.asn1;

import com.bytedance.upc.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes8.dex */
public class ASN1UTCTime extends ASN1Primitive {
    private byte[] time;

    public ASN1UTCTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    public ASN1UTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", DateUtil.EN_Locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1UTCTime(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1UTCTime(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.time = bArr;
        if (!isDigit(0) || !isDigit(1)) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    public static ASN1UTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UTCTime)) {
            return (ASN1UTCTime) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1UTCTime) fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof ASN1UTCTime)) ? getInstance(object) : new ASN1UTCTime(ASN1OctetString.getInstance(object).getOctets());
    }

    private boolean isDigit(int i) {
        byte b;
        byte[] bArr = this.time;
        return bArr.length > i && (b = bArr[i]) >= 48 && b <= 57;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1UTCTime) {
            return Arrays.areEqual(this.time, ((ASN1UTCTime) aSN1Primitive).time);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 23, this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return DateUtil.epochAdjust(simpleDateFormat.parse(getAdjustedTime()));
    }

    public String getAdjustedTime() {
        String time = getTime();
        return (time.charAt(0) < '5' ? new StringBuilder(Constants.USER_EXPERIENCE_IMPROVEMENT_PLAN_ENABLE) : new StringBuilder("19")).append(time).toString();
    }

    public Date getDate() throws ParseException {
        return DateUtil.epochAdjust(new SimpleDateFormat("yyMMddHHmmssz").parse(getTime()));
    }

    public String getTime() {
        StringBuilder append;
        String substring;
        StringBuilder append2;
        StringBuilder append3;
        String str;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.indexOf(45) >= 0 || fromByteArray.indexOf(43) >= 0) {
            int indexOf = fromByteArray.indexOf(45);
            if (indexOf < 0) {
                indexOf = fromByteArray.indexOf(43);
            }
            if (indexOf == fromByteArray.length() - 3) {
                fromByteArray = fromByteArray + "00";
            }
            if (indexOf == 10) {
                append = new StringBuilder().append(fromByteArray.substring(0, 10)).append("00GMT").append(fromByteArray.substring(10, 13)).append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                substring = fromByteArray.substring(13, 15);
            } else {
                append = new StringBuilder().append(fromByteArray.substring(0, 12)).append("GMT").append(fromByteArray.substring(12, 15)).append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                substring = fromByteArray.substring(15, 17);
            }
            append2 = append.append(substring);
        } else {
            if (fromByteArray.length() == 11) {
                append3 = new StringBuilder().append(fromByteArray.substring(0, 10));
                str = "00GMT+00:00";
            } else {
                append3 = new StringBuilder().append(fromByteArray.substring(0, 12));
                str = "GMT+00:00";
            }
            append2 = append3.append(str);
        }
        return append2.toString();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return Strings.fromByteArray(this.time);
    }
}
