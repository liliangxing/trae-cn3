package com.bytedance.timon.ruler.adapter.impl;

import com.bytedance.ruler.base.models.AbsValidator;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IRulerHardCodeValidatorService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H&J\u001c\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/impl/IRulerHardCodeValidatorService;", "", "getFuseSource", "", "getGuardSource", "setFuseSource", "", "fuseSource", "setGuardSource", "guardSource", "setHarCodeValidator", "map", "", "Lcom/bytedance/ruler/base/models/AbsValidator;", "ruler-adapter-api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface IRulerHardCodeValidatorService {
    String getFuseSource();

    String getGuardSource();

    void setFuseSource(String fuseSource);

    void setGuardSource(String guardSource);

    void setHarCodeValidator(Map<String, ? extends AbsValidator> map);
}
