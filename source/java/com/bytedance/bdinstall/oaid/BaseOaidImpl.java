package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class BaseOaidImpl<SERVICE> implements OaidApi {
    private final String packageName;
    private final Singleton<Boolean> support = new Singleton<Boolean>() { // from class: com.bytedance.bdinstall.oaid.BaseOaidImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf(Oaid.isPackageExisted((Context) objArr[0], BaseOaidImpl.this.packageName));
        }
    };

    protected abstract Intent buildIntent(Context context);

    protected abstract ServiceBlockBinder.ServiceBindedListener<SERVICE, String> buildServiceImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseOaidImpl(String str) {
        this.packageName = str;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.support.get(context).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
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
