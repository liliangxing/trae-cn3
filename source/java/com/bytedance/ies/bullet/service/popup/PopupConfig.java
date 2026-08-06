package com.bytedance.ies.bullet.service.popup;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.base.IBulletPopupFragment;
import com.bytedance.ies.bullet.service.base.IPopupConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/PopupConfig;", "Lcom/bytedance/ies/bullet/service/base/IPopupConfig;", "fragmentCls", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/IBulletPopupFragment;", "(Ljava/lang/Class;)V", "getFragmentCls", "()Ljava/lang/Class;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "getFragmentClazz", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PopupConfig implements IPopupConfig {
    private final Class<? extends IBulletPopupFragment> fragmentCls;

    /* JADX WARN: Multi-variable type inference failed */
    public PopupConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopupConfig copy$default(PopupConfig popupConfig, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = popupConfig.fragmentCls;
        }
        return popupConfig.copy(cls);
    }

    public final Class<? extends IBulletPopupFragment> component1() {
        return this.fragmentCls;
    }

    public final PopupConfig copy(Class<? extends IBulletPopupFragment> fragmentCls) {
        return new PopupConfig(fragmentCls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PopupConfig) && Intrinsics.areEqual(this.fragmentCls, ((PopupConfig) other).fragmentCls);
    }

    public int hashCode() {
        Class<? extends IBulletPopupFragment> cls = this.fragmentCls;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public String toString() {
        return "PopupConfig(fragmentCls=" + this.fragmentCls + ')';
    }

    public PopupConfig(Class<? extends IBulletPopupFragment> cls) {
        this.fragmentCls = cls;
    }

    public /* synthetic */ PopupConfig(Class cls, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cls);
    }

    public final Class<? extends IBulletPopupFragment> getFragmentCls() {
        return this.fragmentCls;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPopupConfig
    public Class<? extends IBulletPopupFragment> getFragmentClazz() {
        return this.fragmentCls;
    }
}
