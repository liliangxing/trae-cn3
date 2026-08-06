package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.dt */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotificationBuilderC1567dt extends AbstractNotificationBuilderC1570dw {

    /* renamed from: a */
    private int f1477a;

    /* renamed from: b */
    private Bitmap f1478b;

    /* renamed from: c */
    private Bitmap f1479c;

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw, android.app.Notification.Builder
    /* renamed from: a */
    public AbstractNotificationBuilderC1570dw setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: a */
    protected String mo2287a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: b */
    protected String mo2291b() {
        return null;
    }

    public NotificationBuilderC1567dt(Context context, String str) {
        super(context, str);
        this.f1477a = 16777216;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: a */
    protected boolean mo2289a() {
        if (!C1694j.m3426a()) {
            return false;
        }
        Resources resources = mo2287a().getResources();
        String packageName = mo2287a().getPackageName();
        return (m2292a(mo2287a().getResources(), "bg", "id", mo2287a().getPackageName()) == 0 || m2292a(resources, "icon", "id", packageName) == 0 || m2292a(resources, "title", "id", packageName) == 0 || C1694j.m3419a(mo2287a()) < 9) ? false : true;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: a */
    public NotificationBuilderC1567dt setLargeIcon(Bitmap bitmap) {
        if (mo2291b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && 184 <= bitmap.getHeight() && bitmap.getHeight() <= 1678) {
                this.f1478b = bitmap;
            } else {
                AbstractC1417b.m1089a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            }
        }
        return this;
    }

    /* renamed from: b */
    public NotificationBuilderC1567dt m2290b(Bitmap bitmap) {
        if (mo2291b() && bitmap != null) {
            this.f1479c = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.NotificationBuilderC1568du
    /* renamed from: a */
    public NotificationBuilderC1567dt mo2286a(String str) {
        if (mo2291b() && !TextUtils.isEmpty(str)) {
            try {
                this.f1477a = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC1417b.m1089a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw, com.xiaomi.push.NotificationBuilderC1568du
    /* renamed from: a */
    public void mo2288a() {
        if (mo2291b() && this.f1478b != null) {
            super.mo2288a();
            Resources resources = mo2287a().getResources();
            String packageName = mo2287a().getPackageName();
            int a = m2292a(resources, "bg", "id", packageName);
            if (C1694j.m3419a(mo2287a()) >= 10) {
                mo2287a().setImageViewBitmap(a, m2312a(this.f1478b, 30.0f));
            } else {
                mo2287a().setImageViewBitmap(a, this.f1478b);
            }
            int a2 = m2292a(resources, "icon", "id", packageName);
            if (this.f1479c != null) {
                mo2287a().setImageViewBitmap(a2, this.f1479c);
            } else {
                m2317a(a2);
            }
            int a3 = m2292a(resources, "title", "id", packageName);
            mo2287a().setTextViewText(a3, this.f1490a);
            if (this.f1493a != null && this.f1477a == 16777216) {
                mo2286a(this.f1493a.get("notification_image_text_color"));
            }
            RemoteViews a4 = mo2287a();
            int i = this.f1477a;
            a4.setTextColor(a3, (i == 16777216 || !m2317a(i)) ? -1 : -16777216);
            setCustomContentView(mo2287a());
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            return;
        }
        mo2291b();
    }
}
