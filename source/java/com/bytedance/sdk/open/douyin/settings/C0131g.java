package com.bytedance.sdk.open.douyin.settings;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.open.douyin.C0114b;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.open.douyin.settings.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0131g {

    /* renamed from: s */
    private static final String f145s = "https://is.snssdk.com/service/settings/v3/";

    /* renamed from: t */
    private static final String f146t = "douyin_open_sdk";

    /* renamed from: a */
    private String f147a;

    /* renamed from: b */
    private String f148b;

    /* renamed from: c */
    private String f149c;

    /* renamed from: d */
    private String f150d;

    /* renamed from: e */
    private String f151e;

    /* renamed from: f */
    private String f152f;

    /* renamed from: g */
    private String f153g;

    /* renamed from: h */
    private String f154h;

    /* renamed from: i */
    private String f155i;

    /* renamed from: j */
    private String f156j;

    /* renamed from: k */
    private long f157k;

    /* renamed from: l */
    private String f158l;

    /* renamed from: m */
    private int f159m;

    /* renamed from: n */
    private String f160n;

    /* renamed from: o */
    private String f161o;

    /* renamed from: p */
    private String f162p;

    /* renamed from: q */
    private String f163q;

    /* renamed from: r */
    private Map<String, String> f164r;

    /* renamed from: com.bytedance.sdk.open.douyin.settings.g$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b {

        /* renamed from: c */
        private String f167c;

        /* renamed from: d */
        private String f168d;

        /* renamed from: e */
        private String f169e;

        /* renamed from: f */
        private String f170f;

        /* renamed from: i */
        private String f173i;

        /* renamed from: j */
        private String f174j;

        /* renamed from: k */
        private int f175k;

        /* renamed from: l */
        private String f176l;

        /* renamed from: m */
        private String f177m;

        /* renamed from: n */
        private String f178n;

        /* renamed from: o */
        private String f179o;

        /* renamed from: p */
        private String f180p;

        /* renamed from: q */
        private long f181q;

        /* renamed from: r */
        private Map<String, String> f182r;

        /* renamed from: a */
        private String f165a = C0131g.f145s;

        /* renamed from: b */
        private String f166b = C0131g.f146t;

        /* renamed from: g */
        private String f171g = Build.MODEL;

        /* renamed from: h */
        private String f172h = Build.BRAND;

        /* renamed from: a */
        public b m100a(int i) {
            this.f175k = i;
            return this;
        }

        /* renamed from: a */
        public b m101a(long j) {
            this.f181q = j;
            return this;
        }

        /* renamed from: a */
        public b m102a(String str) {
            this.f167c = str;
            return this;
        }

        /* renamed from: a */
        public b m103a(Map<String, String> map) {
            this.f182r = map;
            return this;
        }

        /* renamed from: a */
        public C0131g m104a() {
            C0131g c0131g = new C0131g();
            c0131g.f147a = this.f165a;
            c0131g.f148b = this.f166b;
            c0131g.f149c = this.f167c;
            c0131g.f150d = this.f168d;
            c0131g.f151e = this.f169e;
            c0131g.f152f = this.f170f;
            c0131g.f153g = this.f171g;
            c0131g.f154h = this.f172h;
            c0131g.f155i = this.f173i;
            c0131g.f156j = this.f180p;
            c0131g.f157k = this.f181q;
            c0131g.f158l = this.f174j;
            c0131g.f159m = this.f175k;
            c0131g.f160n = this.f176l;
            c0131g.f164r = this.f182r;
            c0131g.f161o = this.f177m;
            c0131g.f162p = this.f178n;
            c0131g.f163q = this.f179o;
            return c0131g;
        }

        /* renamed from: b */
        public b m105b(String str) {
            this.f168d = str;
            return this;
        }

        /* renamed from: b */
        public String m106b() {
            return this.f167c;
        }

        /* renamed from: c */
        public b m107c(String str) {
            this.f166b = str;
            return this;
        }

        /* renamed from: c */
        public String m108c() {
            return this.f168d;
        }

        /* renamed from: d */
        public b m109d(String str) {
            this.f176l = str;
            return this;
        }

        /* renamed from: d */
        public String m110d() {
            return this.f166b;
        }

        /* renamed from: e */
        public b m111e(String str) {
            this.f180p = str;
            return this;
        }

        /* renamed from: e */
        public String m112e() {
            return this.f180p;
        }

        /* renamed from: f */
        public b m113f(String str) {
            this.f172h = str;
            return this;
        }

        /* renamed from: f */
        public String m114f() {
            return this.f172h;
        }

        /* renamed from: g */
        public b m115g(String str) {
            this.f173i = str;
            return this;
        }

        /* renamed from: g */
        public String m116g() {
            return this.f173i;
        }

        /* renamed from: h */
        public b m117h(String str) {
            this.f170f = str;
            return this;
        }

        /* renamed from: h */
        public String m118h() {
            return this.f170f;
        }

        /* renamed from: i */
        public b m119i(String str) {
            this.f171g = str;
            return this;
        }

        /* renamed from: i */
        public String m120i() {
            return this.f171g;
        }

        /* renamed from: j */
        public b m121j(String str) {
            this.f179o = str;
            return this;
        }

        /* renamed from: j */
        public Map<String, String> m122j() {
            return this.f182r;
        }

        /* renamed from: k */
        public long m123k() {
            return this.f181q;
        }

        /* renamed from: k */
        public b m124k(String str) {
            this.f174j = str;
            return this;
        }

        /* renamed from: l */
        public b m125l(String str) {
            this.f165a = str;
            return this;
        }

        /* renamed from: l */
        public String m126l() {
            return this.f165a;
        }

        /* renamed from: m */
        public b m127m(String str) {
            this.f177m = str;
            return this;
        }

        /* renamed from: m */
        public String m128m() {
            return this.f169e;
        }

        /* renamed from: n */
        public b m129n(String str) {
            this.f169e = str;
            return this;
        }

        /* renamed from: o */
        public b m130o(String str) {
            this.f178n = str;
            return this;
        }
    }

    private C0131g() {
    }

    /* renamed from: a */
    private void m84a(StringBuilder sb, String str, String str2, Map<String, String> map, boolean z) {
        if (!TextUtils.isEmpty(str2) || (map != null && map.containsKey(str))) {
            if (map != null && map.containsKey(str)) {
                str2 = map.get(str);
                map.remove(str);
            }
            sb.append(z ? "?" : "&").append(str).append("=").append(str2);
        }
    }

    /* renamed from: a */
    public String m99a() {
        StringBuilder sb = new StringBuilder(this.f147a);
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f164r;
        if (map != null) {
            hashMap.putAll(map);
        }
        m84a(sb, Constant.KEY_CALL_NAME, this.f148b, hashMap, true);
        m84a(sb, Constant.KEY_APP_ID, this.f149c, hashMap, false);
        m84a(sb, "app_name", this.f150d, hashMap, false);
        m84a(sb, "version_code", this.f151e, hashMap, false);
        m84a(sb, "device_platform", this.f152f, hashMap, false);
        m84a(sb, Constant.KEY_DEVICE_TYPE, this.f153g, hashMap, false);
        m84a(sb, Constant.KEY_DEVICE_BRAND, this.f154h, hashMap, false);
        m84a(sb, "device_id", this.f155i, hashMap, false);
        m84a(sb, "ctx_infos", this.f156j, hashMap, false);
        m84a(sb, C0130f.f138k, "" + this.f157k, hashMap, false);
        m84a(sb, Constant.KEY_OS_VERSION, this.f158l, hashMap, false);
        m84a(sb, Constant.KEY_OS_API, "" + this.f159m, hashMap, false);
        m84a(sb, Constant.KEY_CHANNEL, this.f160n, hashMap, false);
        m84a(sb, Constant.KEY_UPDATE_VERSION_CODE, this.f161o, hashMap, false);
        m84a(sb, "version_name", this.f162p, hashMap, false);
        m84a(sb, "iid", this.f163q, hashMap, false);
        m84a(sb, "open_platform_sdk_china_name", C0114b.f52e, hashMap, false);
        m84a(sb, "open_platform_sdk_china_version_code", "5.21.1-rc.0", hashMap, false);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            m84a(sb, entry.getKey(), entry.getValue(), null, false);
        }
        return sb.toString();
    }

    public String toString() {
        return m99a();
    }
}
