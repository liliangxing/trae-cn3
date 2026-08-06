package com.bytedance.android.anniex.ability.service;

import android.content.Intent;
import kotlin.Metadata;

/* compiled from: IAnnieXCustomActivityService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXActivityResultListener;", "", "onAnnieXActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXActivityResultListener {
    boolean onAnnieXActivityResult(int requestCode, int resultCode, Intent data);
}
