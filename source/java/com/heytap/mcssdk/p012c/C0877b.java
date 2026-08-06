package com.heytap.mcssdk.p012c;

import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.heytap.mcssdk.c.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0877b extends BaseMode {

    /* renamed from: a */
    private static final String f505a = "&";

    /* renamed from: b */
    private String f506b;

    /* renamed from: c */
    private String f507c;

    /* renamed from: d */
    private String f508d;

    /* renamed from: e */
    private String f509e;

    /* renamed from: f */
    private int f510f;

    /* renamed from: g */
    private String f511g;

    /* renamed from: h */
    private int f512h = -2;

    /* renamed from: i */
    private String f513i;

    /* renamed from: j */
    private String f514j;

    /* renamed from: a */
    public static <T> String m587a(List<T> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("&");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m588a() {
        return this.f506b;
    }

    /* renamed from: a */
    public void m589a(int i) {
        this.f510f = i;
    }

    /* renamed from: a */
    public void m590a(String str) {
        this.f506b = str;
    }

    /* renamed from: b */
    public String m591b() {
        return this.f507c;
    }

    /* renamed from: b */
    public void m592b(int i) {
        this.f512h = i;
    }

    /* renamed from: b */
    public void m593b(String str) {
        this.f507c = str;
    }

    /* renamed from: c */
    public String m594c() {
        return this.f508d;
    }

    /* renamed from: c */
    public void m595c(String str) {
        this.f508d = str;
    }

    /* renamed from: d */
    public String m596d() {
        return this.f509e;
    }

    /* renamed from: d */
    public void m597d(String str) {
        this.f509e = str;
    }

    /* renamed from: e */
    public int m598e() {
        return this.f510f;
    }

    /* renamed from: e */
    public void m599e(String str) {
        this.f511g = str;
    }

    /* renamed from: f */
    public String m600f() {
        return this.f511g;
    }

    /* renamed from: f */
    public void m601f(String str) {
        this.f514j = str;
    }

    /* renamed from: g */
    public int m602g() {
        return this.f512h;
    }

    /* renamed from: g */
    public void m603g(String str) {
        this.f513i = str;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return MessageConstant.MessageType.MESSAGE_CALL_BACK;
    }

    /* renamed from: h */
    public String m604h() {
        return this.f514j;
    }

    /* renamed from: i */
    public String m605i() {
        return this.f513i;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f508d + "', mSdkVersion='" + this.f509e + "', mCommand=" + this.f510f + "', mContent='" + this.f511g + "', mAppPackage=" + this.f513i + "', mResponseCode=" + this.f512h + ", miniProgramPkg=" + this.f514j + '}';
    }
}
