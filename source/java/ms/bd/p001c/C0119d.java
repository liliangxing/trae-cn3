package ms.bd.p001c;

import java.nio.ByteBuffer;

/* renamed from: ms.bd.c.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0119d {

    /* renamed from: a */
    public final Object f151a;

    /* renamed from: b */
    public final Object f152b;

    public C0119d(ByteBuffer byteBuffer, Long l) {
        this.f151a = byteBuffer;
        this.f152b = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0119d.class != obj.getClass()) {
            return false;
        }
        C0119d c0119d = (C0119d) obj;
        Object obj2 = this.f151a;
        if (obj2 == null) {
            if (c0119d.f151a != null) {
                return false;
            }
        } else if (!obj2.equals(c0119d.f151a)) {
            return false;
        }
        Object obj3 = this.f152b;
        Object obj4 = c0119d.f152b;
        return obj3 == null ? obj4 == null : obj3.equals(obj4);
    }

    public final int hashCode() {
        Object obj = this.f151a;
        int hashCode = ((obj == null ? 0 : obj.hashCode()) + 31) * 31;
        Object obj2 = this.f152b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
