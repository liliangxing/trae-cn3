package com.bytedance.trae.kmp.artifacts.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.R;
import com.bytedance.trae.design.compose.TraeComposeTokensKt;
import com.bytedance.trae.kmp.artifacts.C0794R;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest;
import com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: VideoArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "previewViewModel", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "isSaving", "", "getDecorViewBackgroundColor", "", "isLightStatusBar", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "closePreview", "saveVideo", "VideoArtifactPreviewViewModelFactory", "Companion", "artifacts_mainlandRelease", "state", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewActivity extends TraeCommonAppCompatActivity {
    private static final String EXTRA_OPEN_REQUEST = "video_artifact_open_request";
    private boolean isSaving;
    private VideoArtifactPreviewViewModel previewViewModel;
    private TraeTitleBar titleBar;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            Unit json$lambda$10;
            json$lambda$10 = VideoArtifactPreviewActivity.json$lambda$10((JsonBuilder) obj);
            return json$lambda$10;
        }
    }, 1, (Object) null);

    /* renamed from: com_bytedance_trae_kmp_artifacts_video_VideoArtifactPreviewActivity__onStop$___twin___ */
    public void m369xe923e93() {
        super.onStop();
    }

    public boolean isLightStatusBar() {
        return false;
    }

    protected void onStop() {
        m368xc0492348(this);
    }

    public int getDecorViewBackgroundColor() {
        return getColor(R.color.trae_special_black);
    }

    protected void onCreate(Bundle savedInstanceState) {
        Object obj;
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(EXTRA_OPEN_REQUEST);
        if (stringExtra != null) {
            try {
                Result.Companion companion = Result.Companion;
                VideoArtifactPreviewActivity videoArtifactPreviewActivity = this;
                Json json2 = json;
                json2.getSerializersModule();
                obj = Result.constructor-impl((ArtifactOpenRequest) json2.decodeFromString(ArtifactOpenRequest.INSTANCE.serializer(), stringExtra));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            ArtifactOpenRequest artifactOpenRequest = (ArtifactOpenRequest) obj;
            if (artifactOpenRequest != null) {
                this.previewViewModel = (VideoArtifactPreviewViewModel) new ViewModelProvider((ViewModelStoreOwner) this, new VideoArtifactPreviewViewModelFactory(this, artifactOpenRequest)).get(VideoArtifactPreviewViewModel.class);
                setContentView(C0794R.layout.activity_video_artifact_preview);
                TraeTitleBar findViewById = findViewById(C0794R.id.video_artifact_preview_title_bar);
                TraeTitleBar traeTitleBar = findViewById;
                traeTitleBar.showMediaPreviewHeader(artifactOpenRequest.getTitle());
                traeTitleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoArtifactPreviewActivity.this.closePreview();
                    }
                });
                traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoArtifactPreviewActivity.this.saveVideo();
                    }
                });
                Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
                this.titleBar = traeTitleBar;
                ComposeView findViewById2 = findViewById(C0794R.id.video_artifact_preview_content);
                findViewById2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
                findViewById2.setContent(ComposableLambdaKt.composableLambdaInstance(-339933407, true, new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$onCreate$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-339933407, i, -1, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity.onCreate.<anonymous>.<anonymous> (VideoArtifactPreviewActivity.kt:57)");
                            }
                            final VideoArtifactPreviewActivity videoArtifactPreviewActivity2 = VideoArtifactPreviewActivity.this;
                            TraeComposeTokensKt.TraeDesignTheme(false, ComposableLambdaKt.rememberComposableLambda(-132786844, true, new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$onCreate$2$1.1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke((Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i2) {
                                    VideoArtifactPreviewViewModel videoArtifactPreviewViewModel;
                                    VideoArtifactPreviewViewModel videoArtifactPreviewViewModel2;
                                    VideoArtifactPreviewViewModel videoArtifactPreviewViewModel3;
                                    VideoArtifactPreviewViewModel videoArtifactPreviewViewModel4;
                                    VideoArtifactPreviewViewModel videoArtifactPreviewViewModel5;
                                    VideoArtifactPreviewViewModel videoArtifactPreviewViewModel6;
                                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-132786844, i2, -1, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (VideoArtifactPreviewActivity.kt:58)");
                                        }
                                        videoArtifactPreviewViewModel = VideoArtifactPreviewActivity.this.previewViewModel;
                                        VideoArtifactPreviewViewModel videoArtifactPreviewViewModel7 = null;
                                        if (videoArtifactPreviewViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
                                            videoArtifactPreviewViewModel = null;
                                        }
                                        VideoArtifactPreviewState invoke$lambda$0 = invoke$lambda$0(FlowExtKt.collectAsStateWithLifecycle(videoArtifactPreviewViewModel.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer2, 0, 7));
                                        videoArtifactPreviewViewModel2 = VideoArtifactPreviewActivity.this.previewViewModel;
                                        if (videoArtifactPreviewViewModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
                                            videoArtifactPreviewViewModel2 = null;
                                        }
                                        composer2.startReplaceGroup(-1564640322);
                                        boolean changedInstance = composer2.changedInstance(videoArtifactPreviewViewModel2);
                                        Object rememberedValue = composer2.rememberedValue();
                                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = (KFunction) new VideoArtifactPreviewActivity$onCreate$2$1$1$1$1(videoArtifactPreviewViewModel2);
                                            composer2.updateRememberedValue(rememberedValue);
                                        }
                                        composer2.endReplaceGroup();
                                        Function1 function1 = (KFunction) rememberedValue;
                                        videoArtifactPreviewViewModel3 = VideoArtifactPreviewActivity.this.previewViewModel;
                                        if (videoArtifactPreviewViewModel3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
                                            videoArtifactPreviewViewModel3 = null;
                                        }
                                        composer2.startReplaceGroup(-1564637986);
                                        boolean changedInstance2 = composer2.changedInstance(videoArtifactPreviewViewModel3);
                                        Object rememberedValue2 = composer2.rememberedValue();
                                        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                            rememberedValue2 = (KFunction) new VideoArtifactPreviewActivity$onCreate$2$1$1$2$1(videoArtifactPreviewViewModel3);
                                            composer2.updateRememberedValue(rememberedValue2);
                                        }
                                        composer2.endReplaceGroup();
                                        Function1 function12 = (KFunction) rememberedValue2;
                                        videoArtifactPreviewViewModel4 = VideoArtifactPreviewActivity.this.previewViewModel;
                                        if (videoArtifactPreviewViewModel4 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
                                            videoArtifactPreviewViewModel4 = null;
                                        }
                                        composer2.startReplaceGroup(-1564635483);
                                        boolean changedInstance3 = composer2.changedInstance(videoArtifactPreviewViewModel4);
                                        Object rememberedValue3 = composer2.rememberedValue();
                                        if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                            rememberedValue3 = (KFunction) new VideoArtifactPreviewActivity$onCreate$2$1$1$3$1(videoArtifactPreviewViewModel4);
                                            composer2.updateRememberedValue(rememberedValue3);
                                        }
                                        composer2.endReplaceGroup();
                                        Function0 function0 = (KFunction) rememberedValue3;
                                        videoArtifactPreviewViewModel5 = VideoArtifactPreviewActivity.this.previewViewModel;
                                        if (videoArtifactPreviewViewModel5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
                                            videoArtifactPreviewViewModel5 = null;
                                        }
                                        composer2.startReplaceGroup(-1564632664);
                                        boolean changedInstance4 = composer2.changedInstance(videoArtifactPreviewViewModel5);
                                        Object rememberedValue4 = composer2.rememberedValue();
                                        if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                            rememberedValue4 = (KFunction) new VideoArtifactPreviewActivity$onCreate$2$1$1$4$1(videoArtifactPreviewViewModel5);
                                            composer2.updateRememberedValue(rememberedValue4);
                                        }
                                        composer2.endReplaceGroup();
                                        Function0 function02 = (KFunction) rememberedValue4;
                                        videoArtifactPreviewViewModel6 = VideoArtifactPreviewActivity.this.previewViewModel;
                                        if (videoArtifactPreviewViewModel6 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
                                        } else {
                                            videoArtifactPreviewViewModel7 = videoArtifactPreviewViewModel6;
                                        }
                                        composer2.startReplaceGroup(-1564630214);
                                        boolean changedInstance5 = composer2.changedInstance(videoArtifactPreviewViewModel7);
                                        Object rememberedValue5 = composer2.rememberedValue();
                                        if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                            rememberedValue5 = (KFunction) new VideoArtifactPreviewActivity$onCreate$2$1$1$5$1(videoArtifactPreviewViewModel7);
                                            composer2.updateRememberedValue(rememberedValue5);
                                        }
                                        composer2.endReplaceGroup();
                                        Function1 function13 = (KFunction) rememberedValue5;
                                        VideoArtifactPreviewActivity videoArtifactPreviewActivity3 = VideoArtifactPreviewActivity.this;
                                        composer2.startReplaceGroup(-1564628242);
                                        boolean changedInstance6 = composer2.changedInstance(videoArtifactPreviewActivity3);
                                        Object rememberedValue6 = composer2.rememberedValue();
                                        if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                            rememberedValue6 = (KFunction) new VideoArtifactPreviewActivity$onCreate$2$1$1$6$1(videoArtifactPreviewActivity3);
                                            composer2.updateRememberedValue(rememberedValue6);
                                        }
                                        composer2.endReplaceGroup();
                                        VideoArtifactPreviewKt.VideoArtifactPreviewScreen(invoke$lambda$0, function1, function12, function0, function02, function13, (KFunction) rememberedValue6, null, composer2, 0, 128);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }

                                private static final VideoArtifactPreviewState invoke$lambda$0(State<? extends VideoArtifactPreviewState> state) {
                                    return (VideoArtifactPreviewState) state.getValue();
                                }
                            }, composer, 54), composer, 48, 1);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }));
                OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
                Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
                OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, (LifecycleOwner) this, false, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj2) {
                        Unit onCreate$lambda$7;
                        onCreate$lambda$7 = VideoArtifactPreviewActivity.onCreate$lambda$7(VideoArtifactPreviewActivity.this, (OnBackPressedCallback) obj2);
                        return onCreate$lambda$7;
                    }
                }, 2, (Object) null);
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$7(VideoArtifactPreviewActivity videoArtifactPreviewActivity, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        videoArtifactPreviewActivity.closePreview();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closePreview() {
        VideoArtifactPreviewViewModel videoArtifactPreviewViewModel = this.previewViewModel;
        if (videoArtifactPreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
            videoArtifactPreviewViewModel = null;
        }
        videoArtifactPreviewViewModel.close();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveVideo() {
        if (this.isSaving) {
            return;
        }
        this.isSaving = true;
        TraeTitleBar traeTitleBar = this.titleBar;
        VideoArtifactPreviewViewModel videoArtifactPreviewViewModel = null;
        if (traeTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar = null;
        }
        traeTitleBar.setRightActionEnabled(0, false);
        VideoArtifactPreviewViewModel videoArtifactPreviewViewModel2 = this.previewViewModel;
        if (videoArtifactPreviewViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewViewModel");
        } else {
            videoArtifactPreviewViewModel = videoArtifactPreviewViewModel2;
        }
        videoArtifactPreviewViewModel.saveToMediaLibrary(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit saveVideo$lambda$9;
                saveVideo$lambda$9 = VideoArtifactPreviewActivity.saveVideo$lambda$9(VideoArtifactPreviewActivity.this, (KmpMediaLibrarySaveResult) obj);
                return saveVideo$lambda$9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit saveVideo$lambda$9(final VideoArtifactPreviewActivity videoArtifactPreviewActivity, final KmpMediaLibrarySaveResult kmpMediaLibrarySaveResult) {
        Intrinsics.checkNotNullParameter(kmpMediaLibrarySaveResult, "result");
        videoArtifactPreviewActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VideoArtifactPreviewActivity.saveVideo$lambda$9$lambda$8(VideoArtifactPreviewActivity.this, kmpMediaLibrarySaveResult);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void saveVideo$lambda$9$lambda$8(VideoArtifactPreviewActivity videoArtifactPreviewActivity, KmpMediaLibrarySaveResult kmpMediaLibrarySaveResult) {
        String string;
        videoArtifactPreviewActivity.isSaving = false;
        TraeTitleBar traeTitleBar = videoArtifactPreviewActivity.titleBar;
        if (traeTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar = null;
        }
        traeTitleBar.setRightActionEnabled(0, true);
        if (kmpMediaLibrarySaveResult.isSuccess()) {
            string = videoArtifactPreviewActivity.getString(C0882R.string.trae_doc_preview_download_success);
        } else {
            string = videoArtifactPreviewActivity.getString(C0882R.string.trae_doc_preview_download_failed);
        }
        Intrinsics.checkNotNull(string);
        CustomToast.showShort((Context) videoArtifactPreviewActivity, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "request", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "<init>", "(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class VideoArtifactPreviewViewModelFactory implements ViewModelProvider.Factory {
        private final ArtifactOpenRequest request;
        final /* synthetic */ VideoArtifactPreviewActivity this$0;

        public VideoArtifactPreviewViewModelFactory(VideoArtifactPreviewActivity videoArtifactPreviewActivity, ArtifactOpenRequest artifactOpenRequest) {
            Intrinsics.checkNotNullParameter(artifactOpenRequest, "request");
            this.this$0 = videoArtifactPreviewActivity;
            this.request = artifactOpenRequest;
        }

        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new VideoArtifactPreviewViewModel(this.request, new C0795xe59bdd2(this, null));
        }
    }

    /* compiled from: VideoArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;", "", "<init>", "()V", "EXTRA_OPEN_REQUEST", "", "json", "Lkotlinx/serialization/json/Json;", TraeAuthManager.STAGE_START, "", "context", "Landroid/content/Context;", "request", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, ArtifactOpenRequest request) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(request, "request");
            Intent intent = new Intent(context, (Class<?>) VideoArtifactPreviewActivity.class);
            StringFormat stringFormat = VideoArtifactPreviewActivity.json;
            stringFormat.getSerializersModule();
            context.startActivity(intent.putExtra(VideoArtifactPreviewActivity.EXTRA_OPEN_REQUEST, stringFormat.encodeToString(ArtifactOpenRequest.INSTANCE.serializer(), request)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$10(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_kmp_artifacts_video_VideoArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m368xc0492348(VideoArtifactPreviewActivity videoArtifactPreviewActivity) {
        videoArtifactPreviewActivity.m369xe923e93();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) videoArtifactPreviewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
