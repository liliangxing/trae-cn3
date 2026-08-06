package cn.com.chinatelecom.account.api.p009d;

import android.net.Network;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.Map;

/* renamed from: cn.com.chinatelecom.account.api.d.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0692g {

    /* renamed from: a */
    public Network f222a;

    /* renamed from: b */
    public int f223b;

    /* renamed from: c */
    public String f224c;

    /* renamed from: d */
    public String f225d;

    /* renamed from: e */
    public boolean f226e;

    /* renamed from: f */
    public boolean f227f;

    /* renamed from: g */
    public String f228g;

    /* renamed from: h */
    public String f229h;

    /* renamed from: i */
    public Map<String, String> f230i;

    /* renamed from: j */
    private int f231j;

    /* renamed from: k */
    private int f232k;

    /* renamed from: cn.com.chinatelecom.account.api.d.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        private int f233a;

        /* renamed from: b */
        private int f234b;

        /* renamed from: c */
        private Network f235c;

        /* renamed from: d */
        private int f236d;

        /* renamed from: e */
        private String f237e;

        /* renamed from: f */
        private String f238f;

        /* renamed from: g */
        private boolean f239g;

        /* renamed from: h */
        private boolean f240h;

        /* renamed from: i */
        private String f241i;

        /* renamed from: j */
        private String f242j;

        /* renamed from: k */
        private Map<String, String> f243k;

        /* renamed from: a */
        public a m269a(int i) {
            this.f233a = i;
            return this;
        }

        /* renamed from: a */
        public a m270a(Network network) {
            this.f235c = network;
            return this;
        }

        /* renamed from: a */
        public a m271a(String str) {
            this.f237e = str;
            return this;
        }

        /* renamed from: a */
        public a m272a(Map<String, String> map) {
            this.f243k = map;
            return this;
        }

        /* renamed from: a */
        public a m273a(boolean z) {
            this.f239g = z;
            return this;
        }

        /* renamed from: a */
        public a m274a(boolean z, String str, String str2) {
            this.f240h = z;
            this.f241i = str;
            this.f242j = str2;
            return this;
        }

        /* renamed from: a */
        public C0692g m275a() {
            return new C0692g(this);
        }

        /* renamed from: b */
        public a m276b(int i) {
            this.f234b = i;
            return this;
        }

        /* renamed from: b */
        public a m277b(String str) {
            this.f238f = str;
            return this;
        }
    }

    public C0692g(a aVar) {
        this.f231j = aVar.f233a;
        this.f232k = aVar.f234b;
        this.f222a = aVar.f235c;
        this.f223b = aVar.f236d;
        this.f224c = aVar.f237e;
        this.f225d = aVar.f238f;
        this.f226e = aVar.f239g;
        this.f227f = aVar.f240h;
        this.f228g = aVar.f241i;
        this.f229h = aVar.f242j;
        this.f230i = aVar.f243k;
    }

    /* renamed from: a */
    public int m256a() {
        int i = this.f231j;
        return i > 0 ? i : PathInterpolatorCompat.MAX_NUM_POINTS;
    }

    /* renamed from: b */
    public int m257b() {
        int i = this.f232k;
        return i > 0 ? i : PathInterpolatorCompat.MAX_NUM_POINTS;
    }
}
