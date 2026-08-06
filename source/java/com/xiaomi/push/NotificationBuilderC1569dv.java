package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1796x;

/* renamed from: com.xiaomi.push.dv */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotificationBuilderC1569dv extends AbstractNotificationBuilderC1570dw {

    /* renamed from: a */
    private int f1481a;

    /* renamed from: a */
    private PendingIntent f1482a;

    /* renamed from: b */
    private int f1483b;

    /* renamed from: b */
    private Bitmap f1484b;

    /* renamed from: c */
    private int f1485c;

    /* renamed from: c */
    private CharSequence f1486c;

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: a */
    protected String mo2287a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: b */
    protected String mo2291b() {
        return "notification_colorful_copy";
    }

    public NotificationBuilderC1569dv(Context context, int i, String str) {
        super(context, i, str);
        this.f1481a = 16777216;
        this.f1483b = 16777216;
        this.f1485c = 16777216;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: a */
    protected boolean mo2289a() {
        if (!C1694j.m3426a()) {
            return false;
        }
        Resources resources = mo2287a().getResources();
        String packageName = mo2287a().getPackageName();
        return (m2292a(resources, "icon", "id", packageName) == 0 || m2292a(resources, "title", "id", packageName) == 0 || m2292a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    /* renamed from: a */
    public NotificationBuilderC1569dv m2300a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (mo2291b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f1486c = charSequence;
            this.f1482a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.NotificationBuilderC1568du
    /* renamed from: a */
    public NotificationBuilderC1569dv mo2286a(String str) {
        if (mo2291b() && !TextUtils.isEmpty(str)) {
            try {
                this.f1483b = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC1417b.m1089a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    /* renamed from: b */
    public NotificationBuilderC1569dv m2301b(String str) {
        if (mo2291b() && !TextUtils.isEmpty(str)) {
            try {
                this.f1481a = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC1417b.m1089a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw
    /* renamed from: a */
    public NotificationBuilderC1569dv setLargeIcon(Bitmap bitmap) {
        if (mo2291b() && bitmap != null) {
            if (bitmap.getWidth() == 984 && bitmap.getHeight() >= 177 && bitmap.getHeight() <= 207) {
                this.f1484b = bitmap;
            } else {
                AbstractC1417b.m1089a("colorful notification bg image resolution error, must [984*177, 984*207]");
            }
        }
        return this;
    }

    /* renamed from: c */
    public NotificationBuilderC1569dv m2302c(String str) {
        if (mo2291b() && !TextUtils.isEmpty(str)) {
            try {
                this.f1485c = Color.parseColor(str);
            } catch (Exception unused) {
                AbstractC1417b.m1089a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.AbstractNotificationBuilderC1570dw, com.xiaomi.push.NotificationBuilderC1568du
    /* renamed from: a */
    public void mo2288a() {
        if (mo2291b()) {
            super.mo2288a();
            Resources resources = mo2287a().getResources();
            String packageName = mo2287a().getPackageName();
            int a = m2292a(resources, "icon", "id", packageName);
            if (this.f1488a == null) {
                m2317a(a);
            } else {
                mo2287a().setImageViewBitmap(a, this.f1488a);
            }
            int a2 = m2292a(resources, "title", "id", packageName);
            int a3 = m2292a(resources, "content", "id", packageName);
            mo2287a().setTextViewText(a2, this.f1490a);
            mo2287a().setTextViewText(a3, this.f1496b);
            if (!TextUtils.isEmpty(this.f1486c)) {
                int a4 = m2292a(resources, "buttonContainer", "id", packageName);
                int a5 = m2292a(resources, "button", "id", packageName);
                int a6 = m2292a(resources, "buttonBg", "id", packageName);
                mo2287a().setViewVisibility(a4, 0);
                mo2287a().setTextViewText(a5, this.f1486c);
                mo2287a().setOnClickPendingIntent(a4, this.f1482a);
                if (this.f1483b != 16777216) {
                    int a7 = m2311a(70.0f);
                    int a8 = m2311a(29.0f);
                    mo2287a().setImageViewBitmap(a6, C1796x.m4051a(m2298a(this.f1483b, a7, a8, a8 / 2.0f)));
                    mo2287a().setTextColor(a5, m2317a(this.f1483b) ? -1 : -16777216);
                }
            }
            int a9 = m2292a(resources, "bg", "id", packageName);
            int a10 = m2292a(resources, "container", "id", packageName);
            if (this.f1481a != 16777216) {
                if (C1694j.m3419a(mo2287a()) >= 10) {
                    mo2287a().setImageViewBitmap(a9, C1796x.m4051a(m2298a(this.f1481a, MediaPlayer.MEDIA_PLAYER_OPTION_LOG_LEVEL, 192, 30.0f)));
                } else {
                    mo2287a().setImageViewBitmap(a9, C1796x.m4051a(m2298a(this.f1481a, MediaPlayer.MEDIA_PLAYER_OPTION_LOG_LEVEL, 192, 0.0f)));
                }
                m2299a(mo2287a(), a10, a2, a3, m2317a(this.f1481a));
            } else if (this.f1484b != null) {
                if (C1694j.m3419a(mo2287a()) >= 10) {
                    mo2287a().setImageViewBitmap(a9, m2312a(this.f1484b, 30.0f));
                } else {
                    mo2287a().setImageViewBitmap(a9, this.f1484b);
                }
                if (this.f1493a != null && this.f1485c == 16777216) {
                    m2302c(this.f1493a.get("notification_image_text_color"));
                }
                int i = this.f1485c;
                m2299a(mo2287a(), a10, a2, a3, i == 16777216 || !m2317a(i));
            } else {
                mo2287a().setViewVisibility(a, 8);
                mo2287a().setViewVisibility(a9, 8);
                try {
                    C1488av.m1568a((Object) this, "setStyle", C1702q.m3463a(mo2287a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    AbstractC1417b.m1089a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(mo2287a());
            return;
        }
        mo2291b();
    }

    /* renamed from: a */
    private void m2299a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a = m2311a(6.0f);
        remoteViews.setViewPadding(i, a, 0, a, 0);
        if (z) {
            remoteViews.setTextColor(i2, -1);
            remoteViews.setTextColor(i3, -1);
        } else {
            remoteViews.setTextColor(i2, -16777216);
            remoteViews.setTextColor(i3, -16777216);
        }
    }

    /* renamed from: a */
    private Drawable m2298a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }
}
