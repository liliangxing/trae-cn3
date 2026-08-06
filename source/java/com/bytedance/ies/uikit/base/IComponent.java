package com.bytedance.ies.uikit.base;

import android.content.Intent;

/* loaded from: classes4.dex */
public interface IComponent {
    boolean isActive();

    boolean isViewValid();

    void startActivityForResult(Intent intent, int i);
}
