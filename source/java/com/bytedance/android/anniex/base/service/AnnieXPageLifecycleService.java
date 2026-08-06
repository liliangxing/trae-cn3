package com.bytedance.android.anniex.base.service;

import android.os.Bundle;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import kotlin.Metadata;

/* compiled from: AnnieXPageLifecycleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u0010\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J$\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXPageLifecycleService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "()V", "isInterceptor", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "onBackPress", "", "onDismiss", "onPageCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPageDestroy", "onPageResume", "onSlide", "slideOffset", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AnnieXPageLifecycleService extends BaseBulletService {
    public abstract boolean isInterceptor(ContextProviderFactory contextProviderFactory, IContainer container);

    public abstract void onBackPress(ContextProviderFactory contextProviderFactory, IContainer container);

    public void onDismiss(ContextProviderFactory contextProviderFactory, IContainer container) {
    }

    public abstract void onPageCreate(ContextProviderFactory contextProviderFactory, IContainer container, Bundle savedInstanceState);

    public abstract void onPageDestroy(ContextProviderFactory contextProviderFactory, IContainer container);

    public abstract void onPageResume(ContextProviderFactory contextProviderFactory, IContainer container);

    public void onSlide(ContextProviderFactory contextProviderFactory, IContainer container, float slideOffset) {
    }
}
