package com.bytedance.android.anniex.ability.service;

import android.app.Activity;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import kotlin.Metadata;

/* compiled from: IAnnieXCustomActivityService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXCustomActivityService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "getXShortcutStartActivityClazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "schema", "", "outerOnActivityResult", "Lcom/bytedance/android/anniex/ability/service/IAnnieXActivityResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXCustomActivityService extends IAnnieXService {
    Class<? extends Activity> getXShortcutStartActivityClazz(String schema);

    IAnnieXActivityResult outerOnActivityResult();
}
