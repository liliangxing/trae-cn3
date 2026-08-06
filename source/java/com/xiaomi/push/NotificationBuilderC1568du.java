package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.Map;

/* renamed from: com.xiaomi.push.du */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotificationBuilderC1568du extends Notification.Builder {

    /* renamed from: a */
    private Context f1480a;

    /* renamed from: a */
    public NotificationBuilderC1568du mo2297a(Map<String, String> map) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2288a() {
    }

    public NotificationBuilderC1568du(Context context) {
        super(context);
        this.f1480a = context;
    }

    /* renamed from: a */
    protected Context m2294a() {
        return this.f1480a;
    }

    /* renamed from: a */
    public int m2292a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    /* renamed from: a */
    public final int m2293a(String str) {
        return m2292a(m2294a().getResources(), str, "id", m2294a().getPackageName());
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo2288a();
        return super.build();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotificationBuilderC1568du addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotificationBuilderC1568du setCustomContentView(RemoteViews remoteViews) {
        super.setCustomContentView(remoteViews);
        return this;
    }

    /* renamed from: a */
    public NotificationBuilderC1568du mo2286a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                C1488av.m1568a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                AbstractC1417b.m1103d("fail to set color. " + e);
            }
        }
        return this;
    }
}
