package ms.bd.c;

import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class d {
    public final Object a;
    public final Object b;

    public d(ByteBuffer byteBuffer, Long l) {
        this.a = byteBuffer;
        this.b = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        Object obj2 = this.a;
        if (obj2 == null) {
            if (dVar.a != null) {
                return false;
            }
        } else if (!obj2.equals(dVar.a)) {
            return false;
        }
        Object obj3 = this.b;
        Object obj4 = dVar.b;
        return obj3 == null ? obj4 == null : obj3.equals(obj4);
    }

    public final int hashCode() {
        Object obj = this.a;
        int hashCode = ((obj == null ? 0 : obj.hashCode()) + 31) * 31;
        Object obj2 = this.b;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }
}
