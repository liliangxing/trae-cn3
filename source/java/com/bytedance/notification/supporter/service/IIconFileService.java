package com.bytedance.notification.supporter.service;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public interface IIconFileService {
    Bitmap getTargetPkgIcon(String str);

    void saveTargetPkgIcon(String str, Bitmap bitmap);
}
