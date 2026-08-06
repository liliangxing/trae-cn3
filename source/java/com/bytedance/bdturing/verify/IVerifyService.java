package com.bytedance.bdturing.verify;

import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.verify.request.AbstractRequest;

/* loaded from: classes3.dex */
public interface IVerifyService {
    boolean execute(AbstractRequest abstractRequest, BdTuringCallback bdTuringCallback);

    boolean isProcess(int i);
}
