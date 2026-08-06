package com.bytedance.trae.keva;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KevaRepos.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/keva/KevaRepos;", "", "<init>", "()V", "defaultRepo", "Lcom/bytedance/keva/Keva;", "getDefaultRepo", "()Lcom/bytedance/keva/Keva;", "defaultRepo$delegate", "Lkotlin/Lazy;", "REPO_DEFAULT", "", "AUTO_INIT_ANY_WHERE_DOOR", "HAS_DORA_DEVICE", "REPO_MESSAGE_IMPRESSION", "keva_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class KevaRepos {
    public static final String AUTO_INIT_ANY_WHERE_DOOR = "auto_init_any_where_door";
    public static final String HAS_DORA_DEVICE = "has_dora_device";
    public static final String REPO_DEFAULT = "default";
    public static final String REPO_MESSAGE_IMPRESSION = "message_impression";
    public static final KevaRepos INSTANCE = new KevaRepos();

    /* renamed from: defaultRepo$delegate, reason: from kotlin metadata */
    private static final Lazy defaultRepo = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.keva.KevaRepos$$ExternalSyntheticLambda0
        public final Object invoke() {
            Keva defaultRepo_delegate$lambda$0;
            defaultRepo_delegate$lambda$0 = KevaRepos.defaultRepo_delegate$lambda$0();
            return defaultRepo_delegate$lambda$0;
        }
    });

    private KevaRepos() {
    }

    public final Keva getDefaultRepo() {
        Object value = defaultRepo.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Keva) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva defaultRepo_delegate$lambda$0() {
        return Keva.getRepo(REPO_DEFAULT, 0);
    }
}
