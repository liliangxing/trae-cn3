package ms.bd.p001c;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* renamed from: ms.bd.c.v1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0219v1 {

    /* renamed from: a */
    public final int f429a;

    /* renamed from: b */
    public final int f430b;

    /* renamed from: c */
    public final int f431c;

    /* renamed from: d */
    public final int f432d;

    /* renamed from: e */
    public final boolean f433e;

    /* renamed from: f */
    public final boolean f434f;

    static {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0219v1() {
        Object m166a;
        Object m166a2;
        this.f429a = 0;
        this.f430b = 0;
        this.f431c = 0;
        this.f432d = 0;
        this.f433e = false;
        this.f434f = false;
        String str = (String) AbstractC0190p2.m166a(16777224, 0, 0L, null, null);
        if (TextUtils.isEmpty(str)) {
            this.f433e = true;
            m166a2 = AbstractC0190p2.m166a(16777217, 0, 0L, "f8fdd7", new byte[]{71, 59, 7, 3, 94, 96, 102, 22, 57, 50, 126, Base64.padSymbol, 85, 22, 90, 41, 105, 28, 51, 116, 120, 40, 85, 4, 83, 37, 37, 26, 56, 58, 113, 51, 18, 80, 76, 33, 118, 89, 57, 59, 99, 122, 6, 21, 79, 110});
        } else {
            String[] split = str.split((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7acdf4", new byte[]{26, Byte.MAX_VALUE}));
            if (split.length != 3) {
                this.f433e = true;
                m166a2 = AbstractC0190p2.m166a(16777217, 0, 0L, "dd709b", new byte[]{86, 105, 74, 66, 15, 114, 39, 82, 103, 115, 53, 111, 74, 4, 18, 125, 98, 5, 113, 114, 122, 104, 67, 4, 0, 122, 117, 72, 103, 116, 59});
            } else {
                int parseInt = Integer.parseInt(split[0]);
                this.f429a = parseInt;
                int parseInt2 = Integer.parseInt(split[1]);
                this.f430b = parseInt2;
                int parseInt3 = Integer.parseInt(split[2]);
                this.f431c = parseInt3;
                if (parseInt < 0 || parseInt2 < 0 || parseInt < parseInt2 || parseInt3 == 0) {
                    this.f433e = true;
                    m166a = AbstractC0190p2.m166a(16777217, 0, 0L, "b78485", new byte[]{80, 58, 69, 70, 14, 37, 33, 1, 104, 119, 51, 38, 78, 84, 71, 43, 111, 86, 125, 108, 118, 117, 92, 82, 8, 44, 102, 86, 126, 101, 106, 123});
                } else {
                    if (parseInt2 != 0 || parseInt != 0) {
                        this.f434f = true;
                        if (this.f434f) {
                            this.f432d = this.f429a - this.f430b;
                            return;
                        }
                        return;
                    }
                    m166a = AbstractC0190p2.m166a(16777217, 0, 0L, "620ed8", new byte[]{4, Utf8.REPLACEMENT_BYTE, 77, 23, 82, 40, 117, 4, 96, 38, 103, 35, 70, 5, 27, 43, 60, 0, 96, 55, 43, 53, 71, 95});
                }
                if (this.f434f) {
                }
            }
        }
        if (this.f434f) {
        }
    }

    public final String toString() {
        return String.format(Locale.US, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "5570fb", new byte[]{33, 37, 86, 30, 28, 102, 42, 17, 104, 97, 38, 59, 65, 64, 3, 48, 37, 8, 35, 100, 104, 114, 64, 8, 28, 113}), Boolean.valueOf(this.f433e), Boolean.valueOf(this.f434f), Integer.valueOf(this.f429a), Integer.valueOf(this.f430b), Integer.valueOf(this.f431c));
    }
}
