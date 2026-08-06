package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.base.ServiceBlockBinder;
import com.ss.android.deviceregister.utils.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class BaseOaidImpl<SERVICE> implements OaidApi {
    private final String packageName;
    private Singleton<Boolean> support = new Singleton<Boolean>() { // from class: com.ss.android.deviceregister.base.BaseOaidImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf(OaidWrapper.isPackageExisted((Context) objArr[0], BaseOaidImpl.this.packageName));
        }
    };

    protected abstract Intent buildIntent(Context context);

    protected abstract ServiceBlockBinder.ServiceBindedListener<SERVICE, String> buildServiceImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseOaidImpl(String str) {
        this.packageName = str;
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.support.get(context).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        return wrapOaid((String) new ServiceBlockBinder(context, buildIntent(context), buildServiceImpl()).blockFetchResult());
    }

    private OaidApi.Result wrapOaid(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OaidApi.Result result = new OaidApi.Result();
        result.oaid = str;
        return result;
    }
}
