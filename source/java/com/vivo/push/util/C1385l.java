package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* compiled from: DefaultNotifyLayoutAdapter.java */
/* renamed from: com.vivo.push.util.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1385l implements BaseNotifyLayoutAdapter {

    /* renamed from: a */
    private Resources f701a;

    /* renamed from: b */
    private String f702b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f702b = context.getPackageName();
        this.f701a = context.getResources();
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f701a.getIdentifier("push_notify", "layout", this.f702b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        if (C1386m.f706d) {
            resources = this.f701a;
            str = "notify_icon_rom30";
        } else if (C1386m.f705c) {
            resources = this.f701a;
            str = "notify_icon_rom20";
        } else {
            resources = this.f701a;
            str = "notify_icon";
        }
        return resources.getIdentifier(str, "id", this.f702b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((Integer) C1373ah.m955a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.f701a.getColor(i);
        }
        if (C1386m.f706d) {
            return -1;
        }
        if (!C1386m.f705c) {
            return -16777216;
        }
        if (C1386m.f706d) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }
}
