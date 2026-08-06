package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "", "<init>", "(Ljava/lang/String;I)V", "Remote", "Local", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArtifactSource[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ArtifactSource Remote = new ArtifactSource("Remote", 0);
    public static final ArtifactSource Local = new ArtifactSource("Local", 1);

    private static final /* synthetic */ ArtifactSource[] $values() {
        return new ArtifactSource[]{Remote, Local};
    }

    public static EnumEntries<ArtifactSource> getEntries() {
        return $ENTRIES;
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) ArtifactSource.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ArtifactSource> serializer() {
            return get$cachedSerializer();
        }
    }

    private ArtifactSource(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource", values());
    }

    static {
        ArtifactSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = ArtifactSource._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }

    public static ArtifactSource valueOf(String str) {
        return (ArtifactSource) Enum.valueOf(ArtifactSource.class, str);
    }

    public static ArtifactSource[] values() {
        return (ArtifactSource[]) $VALUES.clone();
    }
}
