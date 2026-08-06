package com.bytedance.upc;

import kotlin.Metadata;

/* compiled from: IUpcTeenModeConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/upc/IUpcTeenModeConfiguration;", "", "teenModeChangeListener", "Lcom/bytedance/upc/IUpcTeenModeChangeListener;", "teenModeCurfewTimeConfiguration", "Lcom/bytedance/upc/IUpcTeenModeActivityConfiguration;", "teenModeTimeLockConfiguration", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcTeenModeConfiguration {
    IUpcTeenModeChangeListener teenModeChangeListener();

    IUpcTeenModeActivityConfiguration teenModeCurfewTimeConfiguration();

    IUpcTeenModeActivityConfiguration teenModeTimeLockConfiguration();
}
