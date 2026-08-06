package ms.bd.p001c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSC;
import java.io.File;
import java.util.HashMap;
import kotlin.io.encoding.Base64;
import net.openid.appauth.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: ms.bd.c.i2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0152i2 {
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    /* renamed from: a */
    public static Object m128a(int i, int i2, long j, String str, Object obj) {
        Object obj2;
        int i3;
        if (i > 268435456 && i < 268435474) {
            switch (i) {
                case 268435457:
                    obj2 = AbstractC0165k3.m138a(C0122d2.f158b.f159a);
                    return obj2;
                case 268435458:
                case 268435459:
                    obj2 = "np";
                    return obj2;
                case 268435460:
                    obj2 = AbstractC0112b4.m74a(BuildConfig.FLAVOR);
                    return obj2;
                case 268435461:
                    int i4 = AbstractC0112b4.f142a;
                    obj2 = BuildConfig.FLAVOR;
                    return obj2;
                case 268435462:
                    String str2 = AbstractC0217v.f417a;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        HashMap m198a = AbstractC0217v.m198a();
                        String str3 = AbstractC0217v.f425i;
                        try {
                            i3 = new File((String) AbstractC0190p2.m166a(16777217, 0, 0L, "1cd30d", new byte[]{111, 114, 14, 84, 64, 119, 55, 84, 60, 96, 37, 114, 88, 84, 22, 96, 38, 71, 56, 44, 35, 113, 2, 8})).listFiles(AbstractC0217v.f426j).length;
                        } catch (Throwable unused) {
                            i3 = -1;
                        }
                        jSONObject.put(str3, i3);
                        jSONObject.put(AbstractC0217v.f420d, AbstractC0217v.m197a(m198a, AbstractC0217v.f417a));
                        jSONObject.put(AbstractC0217v.f421e, AbstractC0217v.m197a(m198a, AbstractC0217v.f418b));
                        jSONObject.put(AbstractC0217v.f423g, AbstractC0217v.m196a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7d0ef7", new byte[]{105, 117, 90, 2, 22, 36, 49, 83, 104, 54, 35, 117, 12, 2, 64, 51, 32, 64, 108, 122, 37, 118, 86, 94, 90, 48, 33, 21, 46, 54, 54, 115, 69, 3, 92, 49, 123, 70, 113, 32, 47, 104, 69, 30, 102, 45, 53, 93, 94, 51, 52, 99, 82})));
                        jSONObject.put(AbstractC0217v.f424h, AbstractC0217v.m196a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "dea820", new byte[]{58, 116, 11, 95, 66, 35, 98, 82, 57, 107, 112, 116, 93, 95, 20, 52, 115, 65, Base64.padSymbol, 39, 118, 119, 7, 3, 14, 55, 114, 20, Byte.MAX_VALUE, 107, 101, 114, 20, 94, 8, 54, 40, 71, 32, 125, 124, 105, 20, 67, 50, 42, 110, 74, 15, 110, 103, 98, 3})));
                        jSONObject.put(AbstractC0217v.f422f, AbstractC0217v.m197a(m198a, AbstractC0217v.f419c));
                    } catch (Throwable unused2) {
                    }
                    String jSONObject2 = jSONObject.toString();
                    obj2 = TextUtils.isEmpty(jSONObject2) ? (String) AbstractC0190p2.m166a(16777217, 0, 0L, "20c1e3", new byte[]{56, 47}) : jSONObject2.trim();
                    return obj2;
                case 268435463:
                    Context context = C0122d2.f158b.f159a;
                    JSONArray jSONArray = new JSONArray();
                    if (context == null) {
                        obj2 = jSONArray.toString();
                    } else {
                        try {
                            if (AbstractC0123d3.m83a()) {
                                obj2 = jSONArray.toString();
                            }
                        } catch (Throwable unused3) {
                        }
                        obj2 = "[]";
                    }
                    return obj2;
                case 268435464:
                    try {
                        AbstractC0123d3.m83a();
                        int i5 = AbstractC0112b4.f142a;
                    } catch (Throwable unused4) {
                        int i6 = AbstractC0112b4.f142a;
                    }
                    obj2 = "null[<!>]null[<!>]0[<!>]";
                    return obj2;
                case 268435465:
                    obj2 = AbstractC0171l3.m143b(C0122d2.f158b.f159a);
                    return obj2;
                case 268435466:
                default:
                    return null;
                case 268435467:
                    C0240z2.m215a(C0122d2.f158b.f159a);
                    return null;
                case 268435468:
                    obj2 = C0240z2.m215a(C0122d2.f158b.f159a).f479a;
                    return obj2;
                case 268435469:
                    Context context2 = C0122d2.f158b.f159a;
                    if (context2 == null) {
                        return null;
                    }
                    obj2 = new StringBuilder(AbstractC0171l3.m142a(context2)).toString();
                    return obj2;
                case 268435470:
                    obj2 = Long.valueOf(MSC.GetABSwitch());
                    return obj2;
                case 268435471:
                    obj2 = Long.valueOf(MSC.GetDelayTime());
                    return obj2;
                case 268435472:
                    obj2 = C0240z2.m215a(C0122d2.f158b.f159a).f480b;
                    return obj2;
                case 268435473:
                    obj2 = C0240z2.m215a(C0122d2.f158b.f159a).f481c;
                    return obj2;
            }
        }
        C0241z3 c0241z3 = AbstractC0185o2.f296a;
        if ((i > 65536 && i < 65545) || ((i > 196608 && i < 196612) || (i > 131072 && i < 131075))) {
            return AbstractC0185o2.m162a(i, i2, j, str, obj);
        }
        C0142g4 c0142g4 = AbstractC0140g2.f177a;
        if ((i <= 16777216 || i >= 16777281) && (i <= 33554432 || i >= 33554435)) {
            return null;
        }
        return AbstractC0140g2.m100a(i, i2, j, str, obj);
    }
}
