package com.fackbook.drawee;

import com.facebook.common.internal.Supplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DefaultDraweeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u001e\u0012\u0018\b\u0001\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005\u0018\u00010\u0004R7\u0010\u0003\u001a\u001e\u0012\u0018\b\u0001\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/fackbook/drawee/DefaultDraweeConfig;", "", "()V", "initializer", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;", "getInitializer", "()Lcom/facebook/common/internal/Supplier;", "initializer$delegate", "Lkotlin/Lazy;", "getDraweeControllerBuilder", "drawee_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultDraweeConfig {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultDraweeConfig.class), "initializer", "getInitializer()Lcom/facebook/common/internal/Supplier;"))};
    public static final DefaultDraweeConfig INSTANCE = new DefaultDraweeConfig();

    /* renamed from: initializer$delegate, reason: from kotlin metadata */
    private static final Lazy initializer = LazyKt.lazy(new Function0<Supplier<? extends AbstractDraweeControllerBuilder<?, ?, ?, ?>>>() { // from class: com.fackbook.drawee.DefaultDraweeConfig$initializer$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Supplier<? extends AbstractDraweeControllerBuilder<?, ?, ?, ?>> m2692invoke() {
            IDraweeConfigOutService iDraweeConfigOutService = (IDraweeConfigOutService) ServiceManager.get().getService(IDraweeConfigOutService.class);
            if (iDraweeConfigOutService != null) {
                return iDraweeConfigOutService.getDraweeControllerBuilder();
            }
            return null;
        }
    });

    private final Supplier<? extends AbstractDraweeControllerBuilder<?, ?, ?, ?>> getInitializer() {
        Lazy lazy = initializer;
        KProperty kProperty = $$delegatedProperties[0];
        return (Supplier) lazy.getValue();
    }

    private DefaultDraweeConfig() {
    }

    public final Supplier<? extends AbstractDraweeControllerBuilder<?, ?, ?, ?>> getDraweeControllerBuilder() {
        return getInitializer();
    }
}
