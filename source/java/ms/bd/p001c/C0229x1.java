package ms.bd.p001c;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import net.openid.appauth.BuildConfig;
import org.json.JSONObject;

/* renamed from: ms.bd.c.x1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0229x1 {

    /* renamed from: e */
    public static final String f454e = (String) AbstractC0190p2.m166a(16777217, 0, 0, "7ce50b", new byte[]{50});

    /* renamed from: f */
    public static final String f455f = (String) AbstractC0190p2.m166a(16777217, 0, 0, "1ea8ad", new byte[]{50});

    /* renamed from: g */
    public static final String f456g = (String) AbstractC0190p2.m166a(16777217, 0, 0, "927675", new byte[]{59});

    /* renamed from: h */
    public static final String f457h = (String) AbstractC0190p2.m166a(16777217, 0, 0, "e19cea", new byte[]{114});

    /* renamed from: i */
    public static final String f458i = (String) AbstractC0190p2.m166a(16777217, 0, 0, "fdf624", new byte[]{116});

    /* renamed from: a */
    public final int f459a;

    /* renamed from: b */
    public final String f460b;

    /* renamed from: c */
    public final String f461c;

    /* renamed from: d */
    public final Throwable f462d;

    public C0229x1(int i, String str, String str2, Throwable th) {
        this.f459a = i;
        this.f460b = str;
        this.f461c = str2;
        this.f462d = th;
    }

    /* renamed from: a */
    public final String[] m207a() {
        String str;
        String str2;
        String str3;
        String valueOf = String.valueOf(this.f459a);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f454e, System.currentTimeMillis());
            jSONObject.put(f455f, this.f459a);
            if (this.f462d != null) {
                str2 = f456g;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f462d.getMessage());
                StackTraceElement[] stackTrace = this.f462d.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    int i3 = i2 + 1;
                    if (i2 >= 3) {
                        break;
                    }
                    sb.append("\n");
                    sb.append(stackTraceElement.toString());
                    i++;
                    i2 = i3;
                }
                str3 = sb.toString();
            } else {
                jSONObject.put(f457h, this.f460b);
                str2 = f458i;
                str3 = this.f461c;
            }
            jSONObject.put(str2, str3);
            str = Base64.encodeToString(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 2);
        } catch (Throwable unused) {
            str = BuildConfig.FLAVOR;
        }
        return new String[]{valueOf, str};
    }
}
