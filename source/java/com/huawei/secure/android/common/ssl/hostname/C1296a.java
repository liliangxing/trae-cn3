package com.huawei.secure.android.common.ssl.hostname;

import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.huawei.secure.android.common.ssl.hostname.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1296a {

    /* renamed from: a */
    private final String f2171a;

    /* renamed from: b */
    private final int f2172b;

    /* renamed from: c */
    private int f2173c;

    /* renamed from: d */
    private int f2174d;

    /* renamed from: e */
    private int f2175e;

    /* renamed from: f */
    private int f2176f;

    /* renamed from: g */
    private char[] f2177g;

    public C1296a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f2171a = name;
        this.f2172b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009d, code lost:
    
        return new java.lang.String(r1, r2, r8.f2176f - r2);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m2347a() {
        int i;
        int i2;
        char c;
        int i3 = this.f2173c;
        this.f2174d = i3;
        this.f2175e = i3;
        while (true) {
            int i4 = this.f2173c;
            if (i4 >= this.f2172b) {
                char[] cArr = this.f2177g;
                int i5 = this.f2174d;
                return new String(cArr, i5, this.f2175e - i5);
            }
            char[] cArr2 = this.f2177g;
            char c2 = cArr2[i4];
            if (c2 == ' ') {
                int i6 = this.f2175e;
                this.f2176f = i6;
                this.f2173c = i4 + 1;
                this.f2175e = i6 + 1;
                cArr2[i6] = ' ';
                while (true) {
                    i = this.f2173c;
                    i2 = this.f2172b;
                    if (i >= i2) {
                        break;
                    }
                    char[] cArr3 = this.f2177g;
                    if (cArr3[i] != ' ') {
                        break;
                    }
                    int i7 = this.f2175e;
                    this.f2175e = i7 + 1;
                    cArr3[i7] = ' ';
                    this.f2173c = i + 1;
                }
                if (i == i2 || (c = this.f2177g[i]) == ',' || c == '+' || c == ';') {
                    break;
                }
            } else {
                if (c2 == ';') {
                    break;
                }
                if (c2 == '\\') {
                    int i8 = this.f2175e;
                    this.f2175e = i8 + 1;
                    cArr2[i8] = m2348b();
                    this.f2173c++;
                } else {
                    if (c2 == '+' || c2 == ',') {
                        break;
                    }
                    int i9 = this.f2175e;
                    this.f2175e = i9 + 1;
                    cArr2[i9] = c2;
                    this.f2173c = i4 + 1;
                }
            }
        }
        char[] cArr4 = this.f2177g;
        int i10 = this.f2174d;
        return new String(cArr4, i10, this.f2175e - i10);
    }

    /* renamed from: b */
    private char m2348b() {
        int i = this.f2173c + 1;
        this.f2173c = i;
        if (i != this.f2172b) {
            char c = this.f2177g[i];
            if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
                return c;
            }
            switch (c) {
                case '*':
                case '+':
                case ',':
                    return c;
                default:
                    switch (c) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            return c;
                        default:
                            return m2349c();
                    }
            }
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2171a);
    }

    /* renamed from: c */
    private char m2349c() {
        int i;
        int i2;
        int m2346a = m2346a(this.f2173c);
        this.f2173c++;
        if (m2346a < 128) {
            return (char) m2346a;
        }
        if (m2346a < 192 || m2346a > 247) {
            return '?';
        }
        if (m2346a <= 223) {
            i = m2346a & 31;
            i2 = 1;
        } else if (m2346a <= 239) {
            i = m2346a & 15;
            i2 = 2;
        } else {
            i = m2346a & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f2173c + 1;
            this.f2173c = i4;
            if (i4 == this.f2172b || this.f2177g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f2173c = i5;
            int m2346a2 = m2346a(i5);
            this.f2173c++;
            if ((m2346a2 & JfifUtil.MARKER_SOFn) != 128) {
                return '?';
            }
            i = (i << 6) + (m2346a2 & 63);
        }
        return (char) i;
    }

    /* renamed from: d */
    private String m2350d() {
        int i;
        char[] cArr;
        char c;
        int i2 = this.f2173c;
        if (i2 + 4 < this.f2172b) {
            this.f2174d = i2;
            this.f2173c = i2 + 1;
            while (true) {
                i = this.f2173c;
                if (i == this.f2172b || (c = (cArr = this.f2177g)[i]) == '+' || c == ',' || c == ';') {
                    break;
                }
                if (c == ' ') {
                    this.f2175e = i;
                    this.f2173c = i + 1;
                    while (true) {
                        int i3 = this.f2173c;
                        if (i3 >= this.f2172b || this.f2177g[i3] != ' ') {
                            break;
                        }
                        this.f2173c = i3 + 1;
                    }
                } else {
                    if (c >= 'A' && c <= 'F') {
                        cArr[i] = (char) (c + ' ');
                    }
                    this.f2173c = i + 1;
                }
            }
            this.f2175e = i;
            int i4 = this.f2175e;
            int i5 = this.f2174d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) m2346a(i8);
                    i8 += 2;
                }
                return new String(this.f2177g, this.f2174d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f2171a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2171a);
    }

    /* renamed from: e */
    private String m2351e() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        char c2;
        char c3;
        int i5;
        int i6;
        char c4;
        char c5;
        while (true) {
            i = this.f2173c;
            i2 = this.f2172b;
            if (i >= i2 || this.f2177g[i] != ' ') {
                break;
            }
            this.f2173c = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.f2174d = i;
        this.f2173c = i + 1;
        while (true) {
            i3 = this.f2173c;
            i4 = this.f2172b;
            if (i3 >= i4 || (c5 = this.f2177g[i3]) == '=' || c5 == ' ') {
                break;
            }
            this.f2173c = i3 + 1;
        }
        if (i3 < i4) {
            this.f2175e = i3;
            if (this.f2177g[i3] == ' ') {
                while (true) {
                    i5 = this.f2173c;
                    i6 = this.f2172b;
                    if (i5 >= i6 || (c4 = this.f2177g[i5]) == '=' || c4 != ' ') {
                        break;
                    }
                    this.f2173c = i5 + 1;
                }
                if (this.f2177g[i5] != '=' || i5 == i6) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f2171a);
                }
            }
            this.f2173c++;
            while (true) {
                int i7 = this.f2173c;
                if (i7 >= this.f2172b || this.f2177g[i7] != ' ') {
                    break;
                }
                this.f2173c = i7 + 1;
            }
            int i8 = this.f2175e;
            int i9 = this.f2174d;
            if (i8 - i9 > 4) {
                char[] cArr = this.f2177g;
                if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && (((c2 = cArr[i9 + 1]) == 'I' || c2 == 'i') && ((c3 = cArr[i9 + 2]) == 'D' || c3 == 'd')))) {
                    this.f2174d = i9 + 4;
                }
            }
            char[] cArr2 = this.f2177g;
            int i10 = this.f2174d;
            return new String(cArr2, i10, this.f2175e - i10);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2171a);
    }

    /* renamed from: f */
    private String m2352f() {
        int i = this.f2173c + 1;
        this.f2173c = i;
        this.f2174d = i;
        this.f2175e = i;
        while (true) {
            int i2 = this.f2173c;
            if (i2 != this.f2172b) {
                char[] cArr = this.f2177g;
                char c = cArr[i2];
                if (c == '\"') {
                    this.f2173c = i2 + 1;
                    while (true) {
                        int i3 = this.f2173c;
                        if (i3 >= this.f2172b || this.f2177g[i3] != ' ') {
                            break;
                        }
                        this.f2173c = i3 + 1;
                    }
                    char[] cArr2 = this.f2177g;
                    int i4 = this.f2174d;
                    return new String(cArr2, i4, this.f2175e - i4);
                }
                if (c == '\\') {
                    cArr[this.f2175e] = m2348b();
                } else {
                    cArr[this.f2175e] = c;
                }
                this.f2173c++;
                this.f2175e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f2171a);
            }
        }
    }

    /* renamed from: b */
    public List<String> m2354b(String str) {
        String m2352f;
        this.f2173c = 0;
        this.f2174d = 0;
        this.f2175e = 0;
        this.f2176f = 0;
        this.f2177g = this.f2171a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String m2351e = m2351e();
        if (m2351e == null) {
            return emptyList;
        }
        do {
            int i = this.f2173c;
            if (i < this.f2172b) {
                char c = this.f2177g[i];
                if (c == '\"') {
                    m2352f = m2352f();
                } else if (c != '#') {
                    m2352f = (c == '+' || c == ',' || c == ';') ? "" : m2347a();
                } else {
                    m2352f = m2350d();
                }
                if (str.equalsIgnoreCase(m2351e)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(m2352f);
                }
                int i2 = this.f2173c;
                if (i2 < this.f2172b) {
                    char c2 = this.f2177g[i2];
                    if (c2 != ',' && c2 != ';' && c2 != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.f2171a);
                    }
                    this.f2173c = i2 + 1;
                    m2351e = m2351e();
                }
            }
            return emptyList;
        } while (m2351e != null);
        throw new IllegalStateException("Malformed DN: " + this.f2171a);
    }

    /* renamed from: a */
    private int m2346a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f2172b) {
            char[] cArr = this.f2177g;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else {
                if (c < 'A' || c > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f2171a);
                }
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f2171a);
                }
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f2171a);
    }

    /* renamed from: a */
    public String m2353a(String str) {
        String m2352f;
        this.f2173c = 0;
        this.f2174d = 0;
        this.f2175e = 0;
        this.f2176f = 0;
        this.f2177g = this.f2171a.toCharArray();
        String m2351e = m2351e();
        if (m2351e == null) {
            return null;
        }
        do {
            int i = this.f2173c;
            if (i == this.f2172b) {
                return null;
            }
            char c = this.f2177g[i];
            if (c == '\"') {
                m2352f = m2352f();
            } else if (c != '#') {
                m2352f = (c == '+' || c == ',' || c == ';') ? "" : m2347a();
            } else {
                m2352f = m2350d();
            }
            if (str.equalsIgnoreCase(m2351e)) {
                return m2352f;
            }
            int i2 = this.f2173c;
            if (i2 >= this.f2172b) {
                return null;
            }
            char c2 = this.f2177g[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f2171a);
            }
            this.f2173c = i2 + 1;
            m2351e = m2351e();
        } while (m2351e != null);
        throw new IllegalStateException("Malformed DN: " + this.f2171a);
    }
}
