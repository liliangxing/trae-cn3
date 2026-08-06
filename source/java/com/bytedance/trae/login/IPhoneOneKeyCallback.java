package com.bytedance.trae.login;

import kotlin.Metadata;

/* compiled from: IPhoneOneKeyCallback.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/IPhoneOneKeyCallback;", "", "onGetPhoneOneKeyInfoSuccess", "", "phoneOneKeyInfo", "Lcom/bytedance/trae/login/PhoneOneKeyInfo;", "onGetPhoneOneKeyInfoFailure", "errorType", "", "errorCode", "", "errorMessage", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IPhoneOneKeyCallback {
    void onGetPhoneOneKeyInfoFailure(int errorType, String errorCode, String errorMessage);

    void onGetPhoneOneKeyInfoSuccess(PhoneOneKeyInfo phoneOneKeyInfo);
}
