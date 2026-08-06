package com.bytedance.salamander.anniex;

import java.util.UUID;
import kotlin.Metadata;

/* compiled from: AnniexMonitorFoundationImplUUIDUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXUUIDUtils;", "Lcom/bytedance/salamander/anniex/IUUIDUtils;", "()V", "generateUUID", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class AnnieXUUIDUtils implements IUUIDUtils {
    @Override // com.bytedance.salamander.anniex.IUUIDUtils
    public String generateUUID() {
        UUID randomUUID = UUID.randomUUID();
        String uuid = randomUUID != null ? randomUUID.toString() : null;
        return uuid == null ? "" : uuid;
    }
}
