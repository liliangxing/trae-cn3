package com.bytedance.sdk.open.douyin.settings;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class g {
    private static final String s = "https://is.snssdk.com/service/settings/v3/";
    private static final String t = "douyin_open_sdk";
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private long k;
    private String l;
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private Map<String, String> r;

    /* loaded from: classes5.dex */
    public static class b {
        private String c;
        private String d;
        private String e;
        private String f;
        private String i;
        private String j;
        private int k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private long q;
        private Map<String, String> r;
        private String a = "https://is.snssdk.com/service/settings/v3/";
        private String b = g.t;
        private String g = Build.MODEL;
        private String h = Build.BRAND;

        public b a(int i) {
            this.k = i;
            return this;
        }

        public b a(long j) {
            this.q = j;
            return this;
        }

        public b a(String str) {
            this.c = str;
            return this;
        }

        public b a(Map<String, String> map) {
            this.r = map;
            return this;
        }

        public g a() {
            g gVar = new g();
            gVar.a = this.a;
            gVar.b = this.b;
            gVar.c = this.c;
            gVar.d = this.d;
            gVar.e = this.e;
            gVar.f = this.f;
            gVar.g = this.g;
            gVar.h = this.h;
            gVar.i = this.i;
            gVar.j = this.p;
            gVar.k = this.q;
            gVar.l = this.j;
            gVar.m = this.k;
            gVar.n = this.l;
            gVar.r = this.r;
            gVar.o = this.m;
            gVar.p = this.n;
            gVar.q = this.o;
            return gVar;
        }

        public b b(String str) {
            this.d = str;
            return this;
        }

        public String b() {
            return this.c;
        }

        public b c(String str) {
            this.b = str;
            return this;
        }

        public String c() {
            return this.d;
        }

        public b d(String str) {
            this.l = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public b e(String str) {
            this.p = str;
            return this;
        }

        public String e() {
            return this.p;
        }

        public b f(String str) {
            this.h = str;
            return this;
        }

        public String f() {
            return this.h;
        }

        public b g(String str) {
            this.i = str;
            return this;
        }

        public String g() {
            return this.i;
        }

        public b h(String str) {
            this.f = str;
            return this;
        }

        public String h() {
            return this.f;
        }

        public b i(String str) {
            this.g = str;
            return this;
        }

        public String i() {
            return this.g;
        }

        public b j(String str) {
            this.o = str;
            return this;
        }

        public Map<String, String> j() {
            return this.r;
        }

        public long k() {
            return this.q;
        }

        public b k(String str) {
            this.j = str;
            return this;
        }

        public b l(String str) {
            this.a = str;
            return this;
        }

        public String l() {
            return this.a;
        }

        public b m(String str) {
            this.m = str;
            return this;
        }

        public String m() {
            return this.e;
        }

        public b n(String str) {
            this.e = str;
            return this;
        }

        public b o(String str) {
            this.n = str;
            return this;
        }
    }

    private g() {
    }

    private void a(StringBuilder sb, String str, String str2, Map<String, String> map, boolean z) {
        if (!TextUtils.isEmpty(str2) || (map != null && map.containsKey(str))) {
            if (map != null && map.containsKey(str)) {
                str2 = map.get(str);
                map.remove(str);
            }
            sb.append(z ? "?" : ContainerUtils.FIELD_DELIMITER).append(str).append(ContainerUtils.KEY_VALUE_DELIMITER).append(str2);
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder(this.a);
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.r;
        if (map != null) {
            hashMap.putAll(map);
        }
        a(sb, Constant.KEY_CALL_NAME, this.b, hashMap, true);
        a(sb, "app_id", this.c, hashMap, false);
        a(sb, Api.KEY_APP_NAME, this.d, hashMap, false);
        a(sb, "version_code", this.e, hashMap, false);
        a(sb, "device_platform", this.f, hashMap, false);
        a(sb, "device_type", this.g, hashMap, false);
        a(sb, "device_brand", this.h, hashMap, false);
        a(sb, "device_id", this.i, hashMap, false);
        a(sb, "ctx_infos", this.j, hashMap, false);
        a(sb, "settings_time", "" + this.k, hashMap, false);
        a(sb, "os_version", this.l, hashMap, false);
        a(sb, "os_api", "" + this.m, hashMap, false);
        a(sb, "channel", this.n, hashMap, false);
        a(sb, "update_version_code", this.o, hashMap, false);
        a(sb, "version_name", this.p, hashMap, false);
        a(sb, "iid", this.q, hashMap, false);
        a(sb, "open_platform_sdk_china_name", com.bytedance.sdk.open.douyin.b.e, hashMap, false);
        a(sb, "open_platform_sdk_china_version_code", "5.21.1-rc.0", hashMap, false);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(sb, entry.getKey(), entry.getValue(), null, false);
        }
        return sb.toString();
    }

    public String toString() {
        return a();
    }
}
