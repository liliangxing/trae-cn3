package com.bytedance.timonbase;

import com.bytedance.timonbase.utils.EnumUtils;
import kotlin.Metadata;

/* compiled from: ITMBasicModeLifecycleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/timonbase/ITMBasicModeLifecycleService;", "", "init", "", "isFuse", "", "name", "", "priority", "Lcom/bytedance/timonbase/utils/EnumUtils$Priority;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface ITMBasicModeLifecycleService {
    void init(boolean isFuse);

    String name();

    EnumUtils.Priority priority();

    /* compiled from: ITMBasicModeLifecycleService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static EnumUtils.Priority priority(ITMBasicModeLifecycleService iTMBasicModeLifecycleService) {
            return EnumUtils.Priority.MIDDLE;
        }
    }
}
