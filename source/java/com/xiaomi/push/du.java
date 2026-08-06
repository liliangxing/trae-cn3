package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* loaded from: classes7.dex */
public class du extends Notification.Builder {
    private Context a;

    public du a(Map<String, String> map) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9838a() {
    }

    public du(Context context) {
        super(context);
        this.a = context;
    }

    protected Context a() {
        return this.a;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo9838a();
        return super.build();
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public du addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public du setCustomContentView(RemoteViews remoteViews) {
        super.setCustomContentView(remoteViews);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public du mo9840a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                av.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
            }
        }
        return this;
    }
}
