package com.bytedance.news.common.settings.api.annotation;

import com.bytedance.news.common.settings.api.ILocalClientResultDelegate;

/* loaded from: classes4.dex */
public @interface LocalClientResultGetter {
    Class<? extends ILocalClientResultDelegate> value() default ILocalClientResultDelegate.class;
}
