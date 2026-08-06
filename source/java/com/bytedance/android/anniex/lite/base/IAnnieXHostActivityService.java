package com.bytedance.android.anniex.lite.base;

import android.content.Context;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import kotlin.Metadata;

/* compiled from: IAnnieXHostActivityService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/IAnnieXHostActivityService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "isTopResumeActivity", "", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXHostActivityService extends IAnnieXService {
    boolean isTopResumeActivity(Context context);
}
