package ms.bd.p001c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0187p {
    /* renamed from: a */
    public static boolean m164a(String str) {
        if (m165a(str, true)) {
            return true;
        }
        return m165a(str, false);
    }

    /* renamed from: a */
    public static boolean m165a(String str, boolean z) {
        int i = Build.VERSION.SDK_INT;
        Date date = new Date();
        KeyGenParameterSpec.Builder keyValidityStart = new KeyGenParameterSpec.Builder(str, 12).setAlgorithmParameterSpec(new ECGenParameterSpec((String) AbstractC0190p2.m166a(16777217, 0, 0L, "cef7c2", new byte[]{97, 98, 22, 83, 14, 112, 54, 86, 102}))).setDigests((String) AbstractC0190p2.m166a(16777217, 0, 0L, "cc42f5", new byte[]{65, 73, 102, 11, 11, 119, 54}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "13d653", new byte[]{19, 25, 54, 15, 89, 124, 102}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "152e3c", new byte[]{19, 31, 96, 92, 89, 37, 96})).setKeyValidityStart(date);
        keyValidityStart.setAttestationChallenge(date.toString().getBytes());
        Context context = C0122d2.f158b.f159a;
        PackageManager packageManager = context == null ? null : context.getPackageManager();
        if (z && i >= 31 && packageManager != null && packageManager.hasSystemFeature((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b1face", new byte[]{114, Base64.padSymbol, 17, 7, 83, 123, 101, 94, 36, 62, 117, 39, 2, 20, 78, 119, 47, 20, 50, 39, 122, 48, Tnaf.POW_2_WIDTH, 42, 85, 118, 94, 17, 35, 37, 118, 32, 1, 20, 72, 123, 110, 30}))) {
            keyValidityStart.setDevicePropertiesAttestationIncluded(true);
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance((String) AbstractC0190p2.m166a(16777217, 0, 0L, "51affe", new byte[]{1, Tnaf.POW_2_WIDTH}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "837edd", new byte[]{8, Utf8.REPLACEMENT_BYTE, 64, 3, 84, 122, Utf8.REPLACEMENT_BYTE, 57, 99, 44, 26, 37, 75, 3, 94}));
            keyPairGenerator.initialize(keyValidityStart.build());
            keyPairGenerator.generateKeyPair();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
