package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1748af;
import com.xiaomi.push.service.C1749ag;
import com.xiaomi.push.service.C1796x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.dw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractNotificationBuilderC1570dw extends NotificationBuilderC1568du {

    /* renamed from: a */
    private int f1487a;

    /* renamed from: a */
    protected Bitmap f1488a;

    /* renamed from: a */
    private RemoteViews f1489a;

    /* renamed from: a */
    protected CharSequence f1490a;

    /* renamed from: a */
    private String f1491a;

    /* renamed from: a */
    private ArrayList<Notification.Action> f1492a;

    /* renamed from: a */
    protected Map<String, String> f1493a;

    /* renamed from: a */
    private boolean f1494a;

    /* renamed from: b */
    private int f1495b;

    /* renamed from: b */
    protected CharSequence f1496b;

    /* renamed from: b */
    private boolean f1497b;

    /* renamed from: a */
    protected abstract String mo2287a();

    /* renamed from: a */
    protected void m2318a(int i, Notification.Action action) {
    }

    /* renamed from: a */
    protected abstract boolean mo2289a();

    /* renamed from: b */
    protected abstract String mo2291b();

    public AbstractNotificationBuilderC1570dw(Context context, String str) {
        this(context, 0, str);
    }

    public AbstractNotificationBuilderC1570dw(Context context, int i, String str) {
        super(context);
        this.f1492a = new ArrayList<>();
        this.f1495b = 0;
        this.f1491a = str;
        this.f1487a = i;
        m2305c();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC1570dw setContentTitle(CharSequence charSequence) {
        this.f1490a = charSequence;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC1570dw setContentText(CharSequence charSequence) {
        this.f1496b = charSequence;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC1570dw setLargeIcon(Bitmap bitmap) {
        this.f1488a = bitmap;
        return this;
    }

    @Override // com.xiaomi.push.NotificationBuilderC1568du
    /* renamed from: a */
    public NotificationBuilderC1568du mo2297a(Map<String, String> map) {
        this.f1493a = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC1570dw addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractNotificationBuilderC1570dw addAction(Notification.Action action) {
        if (action != null) {
            this.f1492a.add(action);
        }
        int i = this.f1495b;
        this.f1495b = i + 1;
        m2318a(i, action);
        return this;
    }

    /* renamed from: c */
    private boolean m2306c() {
        Map<String, String> map = this.f1493a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.NotificationBuilderC1568du
    /* renamed from: a */
    public void mo2288a() {
        super.mo2288a();
        Bundle bundle = new Bundle();
        if (m2308d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f1497b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", m2293a("large_icon"));
        if (this.f1492a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f1492a.size()];
            this.f1492a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m2306c() || !C1749ag.m3667a(m2303a().getContentResolver())) {
            m2307d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f1490a);
            bundle.putCharSequence("mipush.customContent", this.f1496b);
        }
        addExtras(bundle);
    }

    /* renamed from: c */
    private void m2305c() {
        int a = m2292a(m2303a().getResources(), m2304c(), "layout", m2303a().getPackageName());
        if (a != 0) {
            this.f1489a = new RemoteViews(m2303a().getPackageName(), a);
            this.f1494a = mo2289a();
        } else {
            AbstractC1417b.m1089a("create RemoteViews failed, no such layout resource was found");
        }
    }

    /* renamed from: b */
    protected final void m2321b() {
        super.setContentTitle(this.f1490a);
        super.setContentText(this.f1496b);
        Bitmap bitmap = this.f1488a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* renamed from: d */
    private void m2307d() {
        super.setContentTitle(this.f1490a);
        super.setContentText(this.f1496b);
    }

    /* renamed from: c */
    private String m2304c() {
        boolean m2309e = m2309e();
        this.f1497b = m2309e;
        return m2309e ? mo2291b() : mo2287a();
    }

    /* renamed from: a */
    public final RemoteViews m2313a() {
        return this.f1489a;
    }

    /* renamed from: b */
    protected final boolean m2322b() {
        return this.f1494a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m2317a(int i) {
        Bitmap m2303a = m2303a();
        if (m2303a != null) {
            m2313a().setImageViewBitmap(i, m2303a);
            return;
        }
        int m2688b = C1628g.m2688b(m2303a(), this.f1491a);
        if (m2688b != 0) {
            m2313a().setImageViewResource(i, m2688b);
        }
    }

    /* renamed from: a */
    private Bitmap m2303a() {
        return C1796x.m4051a(C1628g.m2679a(m2303a(), this.f1491a));
    }

    /* renamed from: d */
    private boolean m2308d() {
        return (TextUtils.isEmpty(mo2291b()) || TextUtils.isEmpty(this.f1491a)) ? false : true;
    }

    /* renamed from: e */
    private boolean m2309e() {
        return m2308d() && m2310f();
    }

    /* renamed from: f */
    private boolean m2310f() {
        List<StatusBarNotification> m3648b = C1748af.m3625a(m2303a(), this.f1491a).m3648b();
        if (m3648b != null && !m3648b.isEmpty()) {
            for (StatusBarNotification statusBarNotification : m3648b) {
                if (statusBarNotification.getId() == this.f1487a) {
                    if (statusBarNotification.getNotification() == null) {
                        return false;
                    }
                    return !r0.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public int m2311a(float f) {
        return (int) ((f * m2303a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap m2312a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: a */
    protected final boolean m2319a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }
}
