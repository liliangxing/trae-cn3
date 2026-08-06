package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Locale;

/* loaded from: classes8.dex */
public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.length() == 0) {
            return TEN_1;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replaceAll("cq", "2q").replaceAll("ci", "si").replaceAll("ce", "se").replaceAll("cy", "sy").replaceAll("tch", "2ch").replaceAll(AirActionConstant.ActionId.ACTION_ID_CALL, "k").replaceAll("q", "k").replaceAll("x", "k").replaceAll(BaseSwitches.V, "f").replaceAll("dg", "2g").replaceAll("tio", "sio").replaceAll("tia", "sia").replaceAll(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "t").replaceAll("ph", "fh").replaceAll("b", AirActionConstant.ActionId.ACTION_ID_PARAMS).replaceAll("sh", "s2").replaceAll("z", "s").replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", "3").replaceAll("j", "y").replaceAll("^y3", "Y3").replaceAll("^y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("y", "3").replaceAll("3gh3", "3kh3").replaceAll("gh", "22").replaceAll("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replaceAll("w3", "W3").replaceAll("wh3", "Wh3").replaceAll("w$", "3").replaceAll("w", "2").replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll(RXScreenCaptureService.KEY_HEIGHT, "2").replaceAll("r3", "R3").replaceAll("r$", "3").replaceAll(DownloadFileUtils.MODE_READ, "2").replaceAll("l3", "L3").replaceAll("l$", "3").replaceAll("l", "2").replaceAll("2", "").replaceAll("3$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("3", "") + TEN_1).substring(0, 10);
    }
}
