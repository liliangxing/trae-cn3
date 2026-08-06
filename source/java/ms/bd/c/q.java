package ms.bd.c;

import com.ss.ttm.player.MediaPlayer;
import java.util.Arrays;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* loaded from: classes8.dex */
public abstract class q {
    public static final String a = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "4e3009", new byte[]{4, 69, 99, 96, 42, 8, Tnaf.POW_2_WIDTH, 108, 75, 74, 14, 75, 109, 106, 32, 30, 6, 118, 81, 84, Tnaf.POW_2_WIDTH, 81, 119, 124, 54, 20, 54, 70, 97, 100, 32, 97, 71, 76, 6, 36, 60, 72, 111, 110, 42, 119, 81, 86, 28, 58, 34, 82, 117, 120, 60, 125, Tnaf.POW_2_WIDTH, 21, 93, 125, 99, 17, 52, 55, 125, 62, 11, 11});
    public static final String b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "11f351", new byte[]{125});

    public static String a(String str) {
        return (str == null || str.length() <= 0) ? str : str.replaceAll((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "1986be", new byte[]{28, 112}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b3e506", new byte[]{62})).replaceAll((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d3fe47", new byte[]{58}), (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d053ad", new byte[]{74})).replaceAll(b, "");
    }

    public static byte[] b(String str) {
        try {
            int length = (str.length() * 3) / 4;
            byte[] bArr = new byte[length];
            int length2 = str.length();
            String str2 = "";
            for (int i = 0; i < 2; i++) {
                if (str.charAt((length2 - 1) - i) == b.charAt(0)) {
                    str2 = str2 + a.charAt(0);
                }
            }
            String str3 = str.substring(0, length2 - str2.length()) + str2;
            int i2 = 0;
            int i3 = 0;
            while (i2 < str3.length()) {
                String str4 = a;
                int indexOf = str4.indexOf(str3.charAt(i2));
                int indexOf2 = str4.indexOf(str3.charAt(i2 + 1));
                int indexOf3 = str4.indexOf(str3.charAt(i2 + 2));
                int indexOf4 = str4.indexOf(str3.charAt(i2 + 3));
                bArr[i3] = (byte) (((indexOf << 2) | (indexOf2 >> 4)) & 255);
                bArr[i3 + 1] = (byte) (((indexOf2 << 4) | (indexOf3 >> 2)) & 255);
                bArr[i3 + 2] = (byte) ((indexOf4 | (indexOf3 << 6)) & 255);
                i2 += 4;
                i3 += 3;
            }
            return Arrays.copyOfRange(bArr, 0, length - str2.length());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            int length = bArr.length % 3;
            if (length > 0) {
                bArr = Arrays.copyOf(bArr, (bArr.length + 3) - length);
                str = "";
                while (length < 3) {
                    str = str + b;
                    length++;
                }
            } else {
                str = "";
            }
            for (int i = 0; i < bArr.length; i += 3) {
                byte b2 = bArr[i];
                byte b3 = bArr[i + 1];
                byte b4 = bArr[i + 2];
                int i2 = (b2 >> 2) & 63;
                int i3 = ((b2 << 4) | (b3 >> 4)) & 63;
                int i4 = ((b3 << 2) | (b4 >> 6)) & 63;
                int i5 = b4 & Utf8.REPLACEMENT_BYTE;
                String str2 = a;
                sb.append(str2.charAt(i2));
                sb.append(str2.charAt(i3));
                sb.append(str2.charAt(i4));
                sb.append(str2.charAt(i5));
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - str.length()) + str;
        } catch (Throwable unused) {
            return "";
        }
    }
}
