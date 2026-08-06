package cn.com.chinatelecom.account.api.p010e;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.com.chinatelecom.account.api.ClientUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.api.e.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0698e {

    /* renamed from: l */
    private String f273l;

    /* renamed from: o */
    private int f276o;

    /* renamed from: q */
    private long f278q;

    /* renamed from: t */
    private int f281t;

    /* renamed from: w */
    private long f284w;

    /* renamed from: r */
    private long f279r = -1;

    /* renamed from: u */
    private StringBuffer f282u = new StringBuffer();

    /* renamed from: c */
    private String f264c = "";

    /* renamed from: e */
    private String f266e = "";

    /* renamed from: n */
    private String f275n = "";

    /* renamed from: m */
    private String f274m = "";

    /* renamed from: p */
    private String f277p = "";

    /* renamed from: a */
    private String f262a = "1.2";

    /* renamed from: v */
    private long f283v = SystemClock.uptimeMillis();

    /* renamed from: b */
    private String f263b = m315a(System.currentTimeMillis());

    /* renamed from: d */
    private String f265d = CtAuth.mAppId;

    /* renamed from: f */
    private String f267f = "";

    /* renamed from: g */
    private String f268g = Build.BRAND;

    /* renamed from: h */
    private String f269h = Build.MODEL;

    /* renamed from: i */
    private String f270i = "Android";

    /* renamed from: j */
    private String f271j = Build.VERSION.RELEASE;

    /* renamed from: k */
    private String f272k = ClientUtils.getSdkVersion();

    /* renamed from: s */
    private String f280s = "0";

    public C0698e(String str) {
        this.f273l = str;
    }

    /* renamed from: a */
    public static String m315a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public C0698e m316a(int i) {
        this.f276o = i;
        return this;
    }

    /* renamed from: a */
    public C0698e m317a(String str) {
        this.f266e = str;
        return this;
    }

    /* renamed from: a */
    public String m318a() {
        return this.f273l;
    }

    /* renamed from: b */
    public C0698e m319b(int i) {
        this.f281t = i;
        return this;
    }

    /* renamed from: b */
    public C0698e m320b(long j) {
        if (j > 0) {
            this.f278q = j;
        }
        return this;
    }

    /* renamed from: b */
    public C0698e m321b(String str) {
        this.f267f = str;
        return this;
    }

    /* renamed from: b */
    public void m322b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f284w = uptimeMillis;
        if (this.f279r == -1) {
            this.f279r = uptimeMillis - this.f283v;
        }
    }

    /* renamed from: c */
    public C0698e m323c(String str) {
        this.f274m = str;
        return this;
    }

    /* renamed from: d */
    public C0698e m324d(String str) {
        this.f275n = str;
        return this;
    }

    /* renamed from: e */
    public C0698e m325e(String str) {
        this.f277p = str;
        return this;
    }

    /* renamed from: f */
    public C0698e m326f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f280s = str;
        }
        return this;
    }

    /* renamed from: g */
    public C0698e m327g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f282u.append(str).append(";");
        }
        return this;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f262a);
            jSONObject.put("t", this.f263b);
            jSONObject.put("tag", this.f264c);
            jSONObject.put("ai", this.f265d);
            jSONObject.put("di", this.f266e);
            jSONObject.put("ns", this.f267f);
            jSONObject.put("br", this.f268g);
            jSONObject.put("ml", this.f269h);
            jSONObject.put("os", this.f270i);
            jSONObject.put("ov", this.f271j);
            jSONObject.put("sv", this.f272k);
            jSONObject.put("ri", this.f273l);
            jSONObject.put("api", this.f274m);
            jSONObject.put(AirActionConstant.ActionId.ACTION_ID_PARAMS, this.f275n);
            jSONObject.put("rt", this.f276o);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.f277p);
            jSONObject.put("st", this.f278q);
            jSONObject.put("tt", this.f279r);
            jSONObject.put("ot", this.f280s);
            jSONObject.put("rec", this.f281t);
            jSONObject.put("ep", this.f282u.toString());
            return jSONObject.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
