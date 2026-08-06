package com.bytedance.tobshadow.bdtracker;

/* renamed from: com.bytedance.tobshadow.bdtracker.x3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0548x3 {

    /* renamed from: h */
    public static final long[][] f1228h = {new long[]{60000, 0, 10}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};

    /* renamed from: a */
    public String f1229a;

    /* renamed from: b */
    public C0407d2 f1230b;

    /* renamed from: c */
    public int f1231c;

    /* renamed from: d */
    public int f1232d;

    /* renamed from: e */
    public int f1233e;

    /* renamed from: f */
    public long f1234f;

    /* renamed from: g */
    public long f1235g;

    public C0548x3(String str, C0407d2 c0407d2) {
        this.f1230b = c0407d2;
        this.f1229a = str;
        this.f1231c = 0;
        if (System.currentTimeMillis() - c0407d2.f505f.getLong(this.f1229a + "downgrade_time", 0L) < 10800000) {
            this.f1231c = this.f1230b.f505f.getInt(this.f1229a + "downgrade_index", 0);
        } else {
            this.f1230b.f505f.remove(this.f1229a + "downgrade_time").remove(this.f1229a + "downgrade_index");
        }
    }

    /* renamed from: a */
    public final boolean m749a() {
        return this.f1230b.f502c.isCongestionControlEnable();
    }

    /* renamed from: b */
    public void m750b() {
        if (m749a()) {
            if (this.f1231c < f1228h.length - 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f1231c++;
                this.f1232d = 1;
                this.f1233e = 0;
                this.f1234f = currentTimeMillis;
                this.f1235g = currentTimeMillis;
                this.f1230b.f505f.putLong(this.f1229a + "downgrade_time", currentTimeMillis).putInt(this.f1229a + "downgrade_index", this.f1231c);
                return;
            }
            this.f1233e = 0;
        }
    }

    /* renamed from: c */
    public void m751c() {
        if (m749a()) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = this.f1233e;
            long j = i;
            long[][] jArr = f1228h;
            int i2 = this.f1231c;
            if (j < jArr[i2][1] && currentTimeMillis - this.f1235g <= 1800000) {
                this.f1233e = i + 1;
                return;
            }
            if (i2 > 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.f1231c--;
                this.f1232d = 1;
                this.f1233e = 1;
                this.f1234f = currentTimeMillis2;
                this.f1235g = currentTimeMillis2;
                this.f1230b.f505f.putLong(this.f1229a + "downgrade_time", currentTimeMillis2).putInt(this.f1229a + "downgrade_index", this.f1231c);
            }
        }
    }
}
