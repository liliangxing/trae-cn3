package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* compiled from: DefaultNotifyLayoutAdapter.java */
/* loaded from: classes7.dex */
public final class l implements BaseNotifyLayoutAdapter {
    private Resources a;
    private String b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.a.getIdentifier("push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        if (m.d) {
            resources = this.a;
            str = "notify_icon_rom30";
        } else if (m.c) {
            resources = this.a;
            str = "notify_icon_rom20";
        } else {
            resources = this.a;
            str = "notify_icon";
        }
        return resources.getIdentifier(str, "id", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) ah.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.a.getColor(i);
        }
        if (m.d) {
            return -1;
        }
        if (!m.c) {
            return -16777216;
        }
        if (m.d) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }
}
