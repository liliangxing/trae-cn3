package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.sdk.open.aweme.utils.IOUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e {
    private static final String d = "SettingsDao";
    private static final String e = "open";
    private static final long f = 200;
    protected Context a;
    private File b;
    private b c;

    public e(Context context) {
        this.a = context;
        File a = a(context);
        this.b = a;
        this.c = b.a(a);
    }

    private File a(Context context) {
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

    private boolean a(String str) {
        if (!this.c.a(200L)) {
            LogUtils.w(d, "loadSettingsModel lock failed");
            return false;
        }
        try {
            return IOUtils.writeStringToFile(this.b.getAbsolutePath(), str, Constant.CHARSET_UTF_8);
        } catch (Exception unused) {
            return false;
        } finally {
            this.c.b();
        }
    }

    private String d() {
        if (!this.c.a(200L)) {
            LogUtils.w(d, "read lock failed:");
            return null;
        }
        try {
            return IOUtils.fromInputStream(new FileInputStream(this.b));
        } catch (Exception e2) {
            LogUtils.w(d, SettingV2Monitor.REPORT_TYPE_READ, e2);
            return null;
        } finally {
            this.c.b();
        }
    }

    public boolean a() {
        return a("");
    }

    public boolean a(f fVar) {
        return a(fVar.g().toString());
    }

    protected f b() {
        return new f(0L, "", new JSONObject(), new JSONObject(), 0L);
    }

    public f c() {
        f a;
        String d2 = d();
        return (TextUtils.isEmpty(d2) || (a = f.a(d2)) == null) ? b() : a;
    }
}
