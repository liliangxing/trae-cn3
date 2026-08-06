package com.bytedance.android.anniex.lite;

import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider;
import kotlin.Metadata;

/* compiled from: AnnieXDefaultLitePageDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXDefaultLitePageDelegateProvider;", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegateProvider;", "()V", "provideDelegate", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXDefaultLitePageDelegateProvider implements IAnnieXLitePageDelegateProvider {
    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider
    public IAnnieXLitePageDelegate provideDelegate() {
        return new AnnieXDefaultLitePageDelegate();
    }
}
