package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.utils.IOUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.open.douyin.settings.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0129e {

    /* renamed from: d */
    private static final String f127d = "SettingsDao";

    /* renamed from: e */
    private static final String f128e = "open";

    /* renamed from: f */
    private static final long f129f = 200;

    /* renamed from: a */
    protected Context f130a;

    /* renamed from: b */
    private File f131b;

    /* renamed from: c */
    private C0126b f132c;

    public C0129e(Context context) {
        this.f130a = context;
        File m65a = m65a(context);
        this.f131b = m65a;
        this.f132c = C0126b.m45a(m65a);
    }

    /* renamed from: a */
    private File m65a(Context context) {
        File file = new File(context.getFilesDir(), "open/open.settings");
        if (file.exists()) {
            return file;
        }
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (Exception unused) {
        }
        return file;
    }

    /* renamed from: a */
    private boolean m66a(String str) {
        if (!this.f132c.m47a(200L)) {
            LogUtils.m30w(f127d, "loadSettingsModel lock failed");
            return false;
        }
        try {
            return IOUtils.writeStringToFile(this.f131b.getAbsolutePath(), str, "utf-8");
        } catch (Exception unused) {
            return false;
        } finally {
            this.f132c.m48b();
        }
    }

    /* renamed from: d */
    private String m67d() {
        if (!this.f132c.m47a(200L)) {
            LogUtils.m30w(f127d, "read lock failed:");
            return null;
        }
        try {
            return IOUtils.fromInputStream(new FileInputStream(this.f131b));
        } catch (Exception e) {
            LogUtils.m30w(f127d, "read", e);
            return null;
        } finally {
            this.f132c.m48b();
        }
    }

    /* renamed from: a */
    public boolean m68a() {
        return m66a("");
    }

    /* renamed from: a */
    public boolean m69a(C0130f c0130f) {
        return m66a(c0130f.m79g().toString());
    }

    /* renamed from: b */
    protected C0130f m70b() {
        return new C0130f(0L, "", new JSONObject(), new JSONObject(), 0L);
    }

    /* renamed from: c */
    public C0130f m71c() {
        C0130f m72a;
        String m67d = m67d();
        return (TextUtils.isEmpty(m67d) || (m72a = C0130f.m72a(m67d)) == null) ? m70b() : m72a;
    }
}
