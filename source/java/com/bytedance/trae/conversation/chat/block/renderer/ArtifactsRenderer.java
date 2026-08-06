package com.bytedance.trae.conversation.chat.block.renderer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.RotateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.StepInterpolator;
import com.bytedance.trae.conversation.chat.IMessageListener;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.settings.ArtifactsRendererSettingsService;
import com.bytedance.trae.conversation.products.ArtifactPreviewActivity;
import com.bytedance.trae.conversation.products.CodeChangedListActivity;
import com.bytedance.trae.conversation.products.DiffViewActivity;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
import com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity;
import com.bytedance.trae.conversation.products.MargeViewActivity;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import com.bytedance.trae.conversation.products.PreviewWebViewActivity;
import com.bytedance.trae.im.model.ArtifactData;
import com.bytedance.trae.im.model.ArtifactDiffInfo;
import com.bytedance.trae.im.model.ChangedFileData;
import com.bytedance.trae.im.model.ChangedSkillsData;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.im.model.FinishCardResult;
import com.bytedance.trae.im.model.FinishCardResultData;
import com.bytedance.trae.im.model.MergeChangedFilesData;
import com.bytedance.trae.im.model.MergeFileDiffInfo;
import com.bytedance.trae.im.model.MergeTotalDiffInfo;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.im.model.PreviewData;
import com.bytedance.trae.im.model.SkillInfo;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactModelsKt;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u0080\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002J:\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002JX\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0002H\u0002J0\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0002JX\u0010$\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0002H\u0002J8\u0010'\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001a2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002J \u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010+\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002J(\u0010,\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002JX\u0010-\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0002H\u0002J8\u00100\u001a\u0004\u0018\u00010\u00132\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00106J(\u00107\u001a\u0004\u0018\u00010\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00109J@\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u0010=\u001a\u00020>H\u0082@¢\u0006\u0002\u0010?J(\u0010@\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010A\u001a\u00020B2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002JG\u0010C\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010JJ1\u0010K\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00132\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010LJ\u0012\u0010M\u001a\u00020E2\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0013H\u0002J(\u0010P\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010A\u001a\u00020Q2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010R\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010S\u001a\u00020T2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010U\u001a\u00020E2\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010V\u001a\u00020W2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020EH\u0002J \u0010Y\u001a\u00020W2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020EH\u0002J\u0010\u0010Z\u001a\u00020T2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010[\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0018\u0010]\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u001a\u0010^\u001a\u00020E2\u0006\u0010\u0012\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010_\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010`\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0002J%\u0010a\u001a\u0004\u0018\u00010I2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010eJ%\u0010f\u001a\u0004\u0018\u00010I2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u00108\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010eJ\u0018\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020i2\u0006\u00108\u001a\u00020\u0013H\u0002J(\u0010j\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002J8\u0010k\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020E2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0002H\u0002J@\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010rJ(\u0010s\u001a\u00020\u00182\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020E2\u0006\u0010t\u001a\u00020qH\u0002J.\u0010u\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00110c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0002J4\u0010w\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020m0c2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00110c2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001c\u0010y\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010{\u001a\u00020\u00132\u0006\u0010|\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H\u0002J\u0012\u0010}\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0014\u0010~\u001a\u0004\u0018\u00010\u00132\b\u0010\u007f\u001a\u0004\u0018\u00010\u0013H\u0002¨\u0006\u0081\u0001"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "createPreviewCard", "preview", "Lcom/bytedance/trae/im/model/PreviewData;", "density", "", "createFileCard", MessagePart.TYPE_FILE, "Lcom/bytedance/trae/im/model/FileDiffInfo;", DBData.FIELD_TYPE, "", "allowPreview", "", "createTextPreviewCard", "loadTextContentAsync", "", "textView", "Landroid/widget/TextView;", "loadingView", "contentContainer", "headerRow", "subtitleView", "dividerLine", "cardContainer", "createMarkdownPreviewCard", "truncateForPreview", ReportConstant.COMMON_CONTENT, "loadMarkdownContentAsync", "markdownTextView", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "collapseToFileCard", "createSkillCard", "skill", "Lcom/bytedance/trae/im/model/SkillInfo;", "createHtmlArtifactCard", "createHtmlPreviewCard", "loadHtmlContentAsync", "webView", "Landroid/webkit/WebView;", "fetchHtmlArchiveUrl", "chatSessionId", "cliType", "path", "conversationId", "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchHtmlDownloadUrlWithRetry", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAndExtractHtml", "Ljava/io/File;", IWeixinService.ResponseConstants.URL, "extras", "Lorg/json/JSONObject;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createChangedCodeSection", "data", "Lcom/bytedance/trae/im/model/ChangedFileData;", "createMtcCodeCard", "totalFiles", "", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "createdTime", "", "(Landroid/content/Context;FILcom/bytedance/trae/im/model/ChangedFileData;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;Lcom/bytedance/trae/im/service/Conversation;Ljava/lang/Long;)Landroid/view/View;", "openHtmlArtifactPreview", "(Landroid/content/Context;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;Ljava/lang/String;Ljava/lang/Long;)V", "getCodeFileIcon", "getBranchDisplayName", "branch", "createMergeSection", "Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "createArtifactLoadingView", "createCardContainer", "Landroid/widget/LinearLayout;", "artifactCardBackgroundColor", "createPreviewIconContainer", "Landroid/widget/FrameLayout;", "iconRes", "createIconContainer", "createTextContainer", "createTitleText", "text", "createSubtitleText", "getFileTypeIcon", "extractFileName", "extractFileExtension", "findMTCLatestTime", "allMessages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/Long;", "findProducts", "containsFilePath", "products", "Lcom/bytedance/trae/im/model/ArtifactData;", "createSingleImagePreviewCard", "loadSingleImageAsync", "draweeView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "container", "maxSizePx", "resolveImageUri", "Landroid/net/Uri;", "(Landroid/content/Context;Lcom/bytedance/trae/im/model/FileDiffInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setImageWithResize", "uri", "createMultiImagePreviewCard", "files", "loadImagesAsync", "imageViews", "normalizeFilePath", "workspacePath", "buildFileUrl", "explorerUrl", "getTitle", "extractPrimaryArtifactPath", "summary", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactsRenderer implements IBlockRenderer<AgentContentBlock.Artifacts> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";

    @Deprecated
    public static final int PREVIEW_MAX_CHARS = 300;
    private static final Companion Companion = new Companion(null);
    private static final Set<String> IMAGE_PREVIEW_EXTENSIONS = SetsKt.setOf(new String[]{"png", "jpg", "jpeg", "gif", "bmp", "webp", "heif", "heic"});
    private static final Set<String> MARKDOWN_EXTENSIONS = SetsKt.setOf(new String[]{"md", "markdown", "mdx"});
    private static final Set<String> CODE_EXTENSIONS = SetsKt.setOf(new String[]{"kt", "java", "py", "js", "ts", "tsx", "jsx", "c", "cpp", "h", "hpp", "cs", "go", "rs", "rb", "php", "swift", "m", "mm", "scala", "groovy", "sh", "bash", "zsh", "bat", "ps1", "pl", "lua", "r", "sql", "css", "scss", "less", "sass", "xml", "json", "yaml", "yml", "toml", "ini", "cfg", "conf", "properties", "gradle", "cmake", "makefile", "dockerfile", "dart", "vue", "svelte", "zig", "nim", "ex", "exs", "erl", "hs", "ml", "mli", "clj", "cljs", "elm"});
    private static final Set<String> TXT_EXTENSIONS = SetsKt.setOf(new String[]{"txt", MessagePart.TYPE_LOG, "csv", "tsv"});
    private static final Set<String> HTML_EXTENSIONS = SetsKt.setOf(new String[]{"html", "htm", "xhtml"});
    private static final Regex COMPUTER_LINK_REGEX = new Regex("computer://([^\\s)\\]]+)");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createMarkdownPreviewCard$lambda$48$lambda$47(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Artifacts artifacts) {
        IBlockRenderer.DefaultImpls.update(this, view, artifacts);
    }

    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "PREVIEW_MAX_CHARS", "", "IMAGE_PREVIEW_EXTENSIONS", "", "MARKDOWN_EXTENSIONS", "CODE_EXTENSIONS", "TXT_EXTENSIONS", "HTML_EXTENSIONS", "COMPUTER_LINK_REGEX", "Lkotlin/text/Regex;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x0376 A[LOOP:2: B:204:0x0370->B:206:0x0376, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03a3 A[LOOP:3: B:215:0x039d->B:217:0x03a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03d1 A[LOOP:4: B:226:0x03cb->B:228:0x03d1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x053e A[LOOP:9: B:277:0x0538->B:279:0x053e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0581 A[LOOP:10: B:285:0x057b->B:287:0x0581, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0601 A[LOOP:13: B:312:0x05fb->B:314:0x0601, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0469  */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View render(final Context context, AgentContentBlock.Artifacts block) {
        List<FileDiffInfo> list;
        ArrayList arrayList;
        ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile;
        ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile2;
        String str;
        ArrayList arrayList2;
        FileDiffInfo fileDiffInfo;
        ChangedSkillsData changedSkills;
        List<SkillInfo> skills;
        Iterator<T> it;
        List<PreviewData> previews;
        Object obj;
        ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile3;
        Object obj2;
        ChangedFileData changedSlides;
        List<FileDiffInfo> fileDiffInfos;
        Iterator<T> it2;
        ChangedFileData changedSheets;
        List<FileDiffInfo> fileDiffInfos2;
        Iterator<T> it3;
        ChangedFileData changedDocs;
        List<FileDiffInfo> fileDiffInfos3;
        Iterator<T> it4;
        MergeChangedFilesData mergeProducts;
        ChangedSkillsData changedSkills2;
        ChangedFileData changedSlides2;
        ChangedFileData changedSheets2;
        ChangedFileData changedImages;
        ChangedFileData changedDocs2;
        ChangedSkillsData changedSkills3;
        List<SkillInfo> skills2;
        ChangedFileData changedSlides3;
        List<FileDiffInfo> fileDiffInfos4;
        ChangedFileData changedSheets3;
        List<FileDiffInfo> fileDiffInfos5;
        ChangedFileData changedImages2;
        List<FileDiffInfo> fileDiffInfos6;
        ChangedFileData changedCodes;
        List<FileDiffInfo> fileDiffInfos7;
        ChangedFileData changedDocs3;
        List<FileDiffInfo> fileDiffInfos8;
        List<PreviewData> previews2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        ArtifactData products = block.getProducts();
        int size = (products == null || (previews2 = products.getPreviews()) == null) ? 0 : previews2.size();
        ArtifactData products2 = block.getProducts();
        int size2 = size + ((products2 == null || (changedDocs3 = products2.getChangedDocs()) == null || (fileDiffInfos8 = changedDocs3.getFileDiffInfos()) == null) ? 0 : fileDiffInfos8.size());
        ArtifactData products3 = block.getProducts();
        int size3 = size2 + ((products3 == null || (changedCodes = products3.getChangedCodes()) == null || (fileDiffInfos7 = changedCodes.getFileDiffInfos()) == null) ? 0 : fileDiffInfos7.size());
        ArtifactData products4 = block.getProducts();
        int size4 = size3 + ((products4 == null || (changedImages2 = products4.getChangedImages()) == null || (fileDiffInfos6 = changedImages2.getFileDiffInfos()) == null) ? 0 : fileDiffInfos6.size());
        ArtifactData products5 = block.getProducts();
        int size5 = size4 + ((products5 == null || (changedSheets3 = products5.getChangedSheets()) == null || (fileDiffInfos5 = changedSheets3.getFileDiffInfos()) == null) ? 0 : fileDiffInfos5.size());
        ArtifactData products6 = block.getProducts();
        int size6 = size5 + ((products6 == null || (changedSlides3 = products6.getChangedSlides()) == null || (fileDiffInfos4 = changedSlides3.getFileDiffInfos()) == null) ? 0 : fileDiffInfos4.size());
        ArtifactData products7 = block.getProducts();
        FLogger.INSTANCE.i("AgentBlock", "[ArtifactsRenderer] render: artifacts=" + (size6 + ((products7 == null || (changedSkills3 = products7.getChangedSkills()) == null || (skills2 = changedSkills3.getSkills()) == null) ? 0 : skills2.size())));
        float f = context.getResources().getDisplayMetrics().density;
        ArtifactData products8 = block.getProducts();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ChangedCodeRenderPlan splitChangedCodes = ArtifactRenderPlan.INSTANCE.splitChangedCodes(products8 != null ? products8.getChangedCodes() : null);
        List<PreviewData> previews3 = products8 != null ? products8.getPreviews() : null;
        boolean z = !(previews3 == null || previews3.isEmpty());
        List<FileDiffInfo> fileDiffInfos9 = (products8 == null || (changedDocs2 = products8.getChangedDocs()) == null) ? null : changedDocs2.getFileDiffInfos();
        boolean z2 = !(fileDiffInfos9 == null || fileDiffInfos9.isEmpty());
        boolean z3 = !splitChangedCodes.getHtmlPreviewFiles().isEmpty();
        ChangedFileData regularChangedCodes = splitChangedCodes.getRegularChangedCodes();
        List<FileDiffInfo> fileDiffInfos10 = regularChangedCodes != null ? regularChangedCodes.getFileDiffInfos() : null;
        boolean z4 = !(fileDiffInfos10 == null || fileDiffInfos10.isEmpty());
        List<FileDiffInfo> fileDiffInfos11 = (products8 == null || (changedImages = products8.getChangedImages()) == null) ? null : changedImages.getFileDiffInfos();
        boolean z5 = !(fileDiffInfos11 == null || fileDiffInfos11.isEmpty());
        List<FileDiffInfo> fileDiffInfos12 = (products8 == null || (changedSheets2 = products8.getChangedSheets()) == null) ? null : changedSheets2.getFileDiffInfos();
        boolean z6 = !(fileDiffInfos12 == null || fileDiffInfos12.isEmpty());
        List<FileDiffInfo> fileDiffInfos13 = (products8 == null || (changedSlides2 = products8.getChangedSlides()) == null) ? null : changedSlides2.getFileDiffInfos();
        boolean z7 = !(fileDiffInfos13 == null || fileDiffInfos13.isEmpty());
        List<SkillInfo> skills3 = (products8 == null || (changedSkills2 = products8.getChangedSkills()) == null) ? null : changedSkills2.getSkills();
        boolean z8 = !(skills3 == null || skills3.isEmpty());
        List<MergeFileDiffInfo> fileDiffInfos14 = (products8 == null || (mergeProducts = products8.getMergeProducts()) == null) ? null : mergeProducts.getFileDiffInfos();
        boolean z9 = !(fileDiffInfos14 == null || fileDiffInfos14.isEmpty());
        boolean z10 = !block.getVideoArtifacts().isEmpty();
        if (!(z || z2 || z4 || z3 || z5 || z6 || z7 || z8 || z10) && !z9) {
            return linearLayout;
        }
        if (z10) {
            IMessageListener iGetMessage = block.getIGetMessage();
            Conversation currentConversation = iGetMessage != null ? iGetMessage.getCurrentConversation() : null;
            if (currentConversation != null) {
                for (VideoArtifactDescriptor videoArtifactDescriptor : block.getVideoArtifacts()) {
                    String id = currentConversation.getId();
                    String str2 = id == null ? "" : id;
                    String messageId = block.getMessageId();
                    String cliConversationId = currentConversation.getCliConversationId();
                    String str3 = cliConversationId == null ? "" : cliConversationId;
                    String environment = currentConversation.getEnvironment();
                    linearLayout.addView(new VideoArtifactCardView(context, videoArtifactDescriptor, ArtifactModelsKt.toOpenRequest(videoArtifactDescriptor, str2, messageId, str3, environment == null ? "" : environment, block.getTurnId()), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj3) {
                            Unit render$lambda$2$lambda$1;
                            render$lambda$2$lambda$1 = ArtifactsRenderer.render$lambda$2$lambda$1(context, (ArtifactOpenRequest) obj3);
                            return render$lambda$2$lambda$1;
                        }
                    }));
                }
            }
        }
        List<FileDiffInfo> emptyList = CollectionsKt.emptyList();
        if (z5) {
            boolean imagePreview = ArtifactsRendererSettingsService.INSTANCE.getArtifactsRendererSettings().getImagePreview();
            ChangedFileData changedImages3 = products8.getChangedImages();
            List<FileDiffInfo> fileDiffInfos15 = changedImages3 != null ? changedImages3.getFileDiffInfos() : null;
            List<FileDiffInfo> list2 = fileDiffInfos15;
            if (!(list2 == null || list2.isEmpty())) {
                if (imagePreview) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj3 : fileDiffInfos15) {
                        String lowerCase = extractFileExtension(((FileDiffInfo) obj3).getFilePath()).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (IMAGE_PREVIEW_EXTENSIONS.contains(lowerCase)) {
                            arrayList3.add(obj3);
                        } else {
                            arrayList4.add(obj3);
                        }
                    }
                    Pair pair = new Pair(arrayList3, arrayList4);
                    List<FileDiffInfo> list3 = (List) pair.component1();
                    List<FileDiffInfo> list4 = (List) pair.component2();
                    if (list3.size() == 1) {
                        FileDiffInfo fileDiffInfo2 = list3.get(0);
                        ArtifactTrack.INSTANCE.trackArtifactShow(fileDiffInfo2.getFilePath(), block.getMessageId());
                        linearLayout.addView(createSingleImagePreviewCard(context, fileDiffInfo2, f, block));
                    } else if (list3.size() > 1) {
                        Iterator<T> it5 = list3.iterator();
                        while (it5.hasNext()) {
                            ArtifactTrack.INSTANCE.trackArtifactShow(((FileDiffInfo) it5.next()).getFilePath(), block.getMessageId());
                        }
                        linearLayout.addView(createMultiImagePreviewCard(context, list3, f, block));
                    }
                    list = list4;
                } else {
                    list = fileDiffInfos15;
                }
                arrayList = new ArrayList();
                if (products8 != null && (changedDocs = products8.getChangedDocs()) != null && (fileDiffInfos3 = changedDocs.getFileDiffInfos()) != null) {
                    it4 = fileDiffInfos3.iterator();
                    while (it4.hasNext()) {
                        arrayList.add(new ArtifactsRenderer$render$TypedFile((FileDiffInfo) it4.next(), MessagePart.TYPE_DOC));
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (products8 != null && (changedSheets = products8.getChangedSheets()) != null && (fileDiffInfos2 = changedSheets.getFileDiffInfos()) != null) {
                    it3 = fileDiffInfos2.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(new ArtifactsRenderer$render$TypedFile((FileDiffInfo) it3.next(), "sheet"));
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                if (products8 != null && (changedSlides = products8.getChangedSlides()) != null && (fileDiffInfos = changedSlides.getFileDiffInfos()) != null) {
                    it2 = fileDiffInfos.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new ArtifactsRenderer$render$TypedFile((FileDiffInfo) it2.next(), "slide"));
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
                boolean filePreview = ArtifactsRendererSettingsService.INSTANCE.getArtifactsRendererSettings().getFilePreview();
                String extractPrimaryArtifactPath = extractPrimaryArtifactPath(block.getSummary());
                if ((!arrayList.isEmpty()) || !filePreview) {
                    artifactsRenderer$render$TypedFile = null;
                } else {
                    if (extractPrimaryArtifactPath != null) {
                        Iterator it6 = arrayList.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it6.next();
                            if (Intrinsics.areEqual(((ArtifactsRenderer$render$TypedFile) obj2).getFile().getFilePath(), extractPrimaryArtifactPath)) {
                                break;
                            }
                        }
                        artifactsRenderer$render$TypedFile3 = (ArtifactsRenderer$render$TypedFile) obj2;
                    } else {
                        artifactsRenderer$render$TypedFile3 = (ArtifactsRenderer$render$TypedFile) CollectionsKt.firstOrNull(arrayList);
                    }
                    artifactsRenderer$render$TypedFile = artifactsRenderer$render$TypedFile3;
                }
                if (artifactsRenderer$render$TypedFile == null) {
                    ArtifactTrack.INSTANCE.trackArtifactShow(artifactsRenderer$render$TypedFile.getFile().getFilePath(), block.getMessageId());
                    artifactsRenderer$render$TypedFile2 = artifactsRenderer$render$TypedFile;
                    str = extractPrimaryArtifactPath;
                    arrayList2 = arrayList;
                    linearLayout.addView(createFileCard(context, artifactsRenderer$render$TypedFile.getFile(), artifactsRenderer$render$TypedFile.getType(), f, block, true));
                } else {
                    artifactsRenderer$render$TypedFile2 = artifactsRenderer$render$TypedFile;
                    str = extractPrimaryArtifactPath;
                    arrayList2 = arrayList;
                }
                boolean htmlPreview = ArtifactsRendererSettingsService.INSTANCE.getArtifactsRendererSettings().getHtmlPreview();
                if (z3 || !htmlPreview || str == null) {
                    fileDiffInfo = null;
                } else {
                    Iterator<T> it7 = splitChangedCodes.getHtmlPreviewFiles().iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next = it7.next();
                        if (Intrinsics.areEqual(((FileDiffInfo) next).getFilePath(), str)) {
                            obj = next;
                            break;
                        }
                    }
                    fileDiffInfo = (FileDiffInfo) obj;
                }
                if (fileDiffInfo != null) {
                    ArtifactTrack.INSTANCE.trackArtifactShow(fileDiffInfo.getFilePath(), block.getMessageId());
                    linearLayout.addView(createHtmlPreviewCard(context, fileDiffInfo, f, block));
                }
                if (!list.isEmpty()) {
                    for (FileDiffInfo fileDiffInfo3 : list) {
                        ArtifactTrack.INSTANCE.trackArtifactShow(fileDiffInfo3.getFilePath(), block.getMessageId());
                        linearLayout.addView(createFileCard$default(this, context, fileDiffInfo3, "image", f, block, false, 32, null));
                        fileDiffInfo = fileDiffInfo;
                    }
                }
                FileDiffInfo fileDiffInfo4 = fileDiffInfo;
                ArrayList<ArtifactsRenderer$render$TypedFile> arrayList5 = new ArrayList();
                for (Object obj4 : arrayList2) {
                    ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile4 = artifactsRenderer$render$TypedFile2;
                    if (!Intrinsics.areEqual((ArtifactsRenderer$render$TypedFile) obj4, artifactsRenderer$render$TypedFile4)) {
                        arrayList5.add(obj4);
                    }
                    artifactsRenderer$render$TypedFile2 = artifactsRenderer$render$TypedFile4;
                }
                for (ArtifactsRenderer$render$TypedFile artifactsRenderer$render$TypedFile5 : arrayList5) {
                    ArtifactTrack.INSTANCE.trackArtifactShow(artifactsRenderer$render$TypedFile5.getFile().getFilePath(), block.getMessageId());
                    linearLayout.addView(createFileCard(context, artifactsRenderer$render$TypedFile5.getFile(), artifactsRenderer$render$TypedFile5.getType(), f, block, false));
                }
                if (z && (previews = products8.getPreviews()) != null) {
                    for (PreviewData previewData : previews) {
                        ArtifactTrack.INSTANCE.trackArtifactWithArtifactType("http_url", block.getMessageId());
                        linearLayout.addView(createPreviewCard(context, previewData, f, block));
                    }
                    Unit unit4 = Unit.INSTANCE;
                }
                if (z3) {
                    List<FileDiffInfo> htmlPreviewFiles = splitChangedCodes.getHtmlPreviewFiles();
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj5 : htmlPreviewFiles) {
                        FileDiffInfo fileDiffInfo5 = fileDiffInfo4;
                        if (!Intrinsics.areEqual((FileDiffInfo) obj5, fileDiffInfo5)) {
                            arrayList6.add(obj5);
                        }
                        fileDiffInfo4 = fileDiffInfo5;
                    }
                    Iterator it8 = arrayList6.iterator();
                    while (it8.hasNext()) {
                        linearLayout.addView(createHtmlArtifactCard(context, (FileDiffInfo) it8.next(), f, block));
                    }
                }
                if (z8 && (changedSkills = products8.getChangedSkills()) != null && (skills = changedSkills.getSkills()) != null) {
                    it = skills.iterator();
                    while (it.hasNext()) {
                        linearLayout.addView(createSkillCard(context, (SkillInfo) it.next(), f));
                    }
                    Unit unit5 = Unit.INSTANCE;
                }
                if (z4) {
                    ArtifactTrack.INSTANCE.trackArtifactWithArtifactType("diff", block.getMessageId());
                    ChangedFileData regularChangedCodes2 = splitChangedCodes.getRegularChangedCodes();
                    Intrinsics.checkNotNull(regularChangedCodes2);
                    linearLayout.addView(createChangedCodeSection(context, regularChangedCodes2, f, block));
                }
                if (z9) {
                    MergeChangedFilesData mergeProducts2 = products8.getMergeProducts();
                    Intrinsics.checkNotNull(mergeProducts2);
                    linearLayout.addView(createMergeSection(context, mergeProducts2, f, block));
                    ArtifactTrack.INSTANCE.trackArtifactWithArtifactType("merge", block.getMessageId());
                }
                return linearLayout;
            }
        }
        list = emptyList;
        arrayList = new ArrayList();
        if (products8 != null) {
            it4 = fileDiffInfos3.iterator();
            while (it4.hasNext()) {
            }
            Unit unit6 = Unit.INSTANCE;
        }
        if (products8 != null) {
            it3 = fileDiffInfos2.iterator();
            while (it3.hasNext()) {
            }
            Unit unit22 = Unit.INSTANCE;
        }
        if (products8 != null) {
            it2 = fileDiffInfos.iterator();
            while (it2.hasNext()) {
            }
            Unit unit32 = Unit.INSTANCE;
        }
        boolean filePreview2 = ArtifactsRendererSettingsService.INSTANCE.getArtifactsRendererSettings().getFilePreview();
        String extractPrimaryArtifactPath2 = extractPrimaryArtifactPath(block.getSummary());
        if (!arrayList.isEmpty()) {
        }
        artifactsRenderer$render$TypedFile = null;
        if (artifactsRenderer$render$TypedFile == null) {
        }
        boolean htmlPreview2 = ArtifactsRendererSettingsService.INSTANCE.getArtifactsRendererSettings().getHtmlPreview();
        if (z3) {
        }
        fileDiffInfo = null;
        if (fileDiffInfo != null) {
        }
        if (!list.isEmpty()) {
        }
        FileDiffInfo fileDiffInfo42 = fileDiffInfo;
        ArrayList<ArtifactsRenderer$render$TypedFile> arrayList52 = new ArrayList();
        while (r1.hasNext()) {
        }
        while (r7.hasNext()) {
        }
        if (z) {
            while (r0.hasNext()) {
            }
            Unit unit42 = Unit.INSTANCE;
        }
        if (z3) {
        }
        if (z8) {
            it = skills.iterator();
            while (it.hasNext()) {
            }
            Unit unit52 = Unit.INSTANCE;
        }
        if (z4) {
        }
        if (z9) {
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit render$lambda$2$lambda$1(Context context, ArtifactOpenRequest artifactOpenRequest) {
        Intrinsics.checkNotNullParameter(artifactOpenRequest, OauthTokenTriggerScene.REQUEST);
        ArtifactTrack.INSTANCE.trackArtifactClick(artifactOpenRequest.getFilePath(), artifactOpenRequest.getMessageId());
        VideoArtifactPreviewActivity.Companion.start(context, artifactOpenRequest);
        return Unit.INSTANCE;
    }

    private final View createPreviewCard(final Context context, PreviewData preview, float density, final AgentContentBlock.Artifacts block) {
        LinearLayout createCardContainer = createCardContainer(context, density);
        createCardContainer.addView(createIconContainer(context, density, C0637R.drawable.ic_artifact_preview));
        LinearLayout createTextContainer = createTextContainer(context);
        String string = context.getString(C0637R.string.trae_chat_artifact_preview_web);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        createTextContainer.addView(createTitleText(context, string));
        String previewUrl = preview.getPreviewUrl();
        if (previewUrl != null) {
            createTextContainer.addView(createSubtitleText(context, previewUrl));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        createCardContainer.addView(createTextContainer, layoutParams);
        final String previewUrl2 = preview.getPreviewUrl();
        if (previewUrl2 != null) {
            createCardContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtifactsRenderer.createPreviewCard$lambda$21$lambda$20$lambda$19(AgentContentBlock.Artifacts.this, context, previewUrl2, view);
                }
            });
        }
        return createCardContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createPreviewCard$lambda$21$lambda$20$lambda$19(AgentContentBlock.Artifacts artifacts, Context context, String str, View view) {
        Conversation currentConversation;
        IMessageListener iGetMessage = artifacts.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return;
        }
        if (Intrinsics.areEqual(currentConversation.getEnvironment(), CliType.LOCAL.getValue()) || Intrinsics.areEqual(currentConversation.getEnvironment(), CliType.IDE.getValue())) {
            CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
            return;
        }
        try {
            try {
                ArtifactTrack.INSTANCE.trackArtifactClickWithArtifactType("http_url", artifacts.getMessageId());
                PreviewWebViewActivity.Companion companion = PreviewWebViewActivity.INSTANCE;
                String string = context.getString(C0637R.string.trae_chat_artifact_preview_web);
                String cliConversationId = currentConversation.getCliConversationId();
                String str2 = cliConversationId == null ? "" : cliConversationId;
                String environment = currentConversation.getEnvironment();
                companion.start(context, str, string, str2, environment == null ? "" : environment);
            } catch (Exception unused) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
        } catch (Exception unused2) {
        }
    }

    static /* synthetic */ View createFileCard$default(ArtifactsRenderer artifactsRenderer, Context context, FileDiffInfo fileDiffInfo, String str, float f, AgentContentBlock.Artifacts artifacts, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        return artifactsRenderer.createFileCard(context, fileDiffInfo, str, f, artifacts, z);
    }

    private final View createFileCard(final Context context, final FileDiffInfo file, String type, float density, final AgentContentBlock.Artifacts block, boolean allowPreview) {
        String lowerCase = extractFileExtension(file.getFilePath()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (allowPreview && MARKDOWN_EXTENSIONS.contains(lowerCase)) {
            return createMarkdownPreviewCard(context, file, type, density, block);
        }
        if (allowPreview && (CODE_EXTENSIONS.contains(lowerCase) || TXT_EXTENSIONS.contains(lowerCase) || HTML_EXTENSIONS.contains(lowerCase))) {
            return createTextPreviewCard(context, file, type, density, block);
        }
        LinearLayout createCardContainer = createCardContainer(context, density);
        createCardContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsRenderer.createFileCard$lambda$24$lambda$22(FileDiffInfo.this, context, block, this, view);
            }
        });
        createCardContainer.addView(createIconContainer(context, density, getFileTypeIcon(type, file.getFilePath())));
        LinearLayout createTextContainer = createTextContainer(context);
        createTextContainer.addView(createTitleText(context, extractFileName(file.getFilePath())));
        String extractFileExtension = extractFileExtension(file.getFilePath());
        if (extractFileExtension.length() > 0) {
            String upperCase = extractFileExtension.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            createTextContainer.addView(createSubtitleText(context, upperCase));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        createCardContainer.addView(createTextContainer, layoutParams);
        return createCardContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createFileCard$lambda$24$lambda$22(FileDiffInfo fileDiffInfo, Context context, AgentContentBlock.Artifacts artifacts, ArtifactsRenderer artifactsRenderer, View view) {
        List<ParsedChatMessage> allMessages;
        Conversation currentConversation;
        String sb;
        String filePath = fileDiffInfo.getFilePath();
        String str = filePath;
        if (str == null || str.length() == 0) {
            CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
            return;
        }
        IMessageListener iGetMessage = artifacts.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null || (currentConversation = artifacts.getIGetMessage().getCurrentConversation()) == null) {
            return;
        }
        Long findProducts = artifactsRenderer.findProducts(allMessages, filePath);
        if (Intrinsics.areEqual(currentConversation.getEnvironment(), CliType.LOCAL.getValue()) || Intrinsics.areEqual(currentConversation.getEnvironment(), CliType.IDE.getValue())) {
            sb = (StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(filePath).toString();
        } else {
            sb = filePath;
        }
        try {
            ArtifactTrack.INSTANCE.trackArtifactClick(filePath, artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        ArtifactPreviewActivity.Companion companion = ArtifactPreviewActivity.INSTANCE;
        String cliConversationId = currentConversation.getCliConversationId();
        if (cliConversationId == null) {
            cliConversationId = "";
        }
        String turnId = artifacts.getTurnId();
        String environment = currentConversation.getEnvironment();
        if (environment == null) {
            environment = "";
        }
        String messageId = artifacts.getMessageId();
        String id = currentConversation.getId();
        companion.start(context, cliConversationId, turnId, environment, sb, messageId, id == null ? "" : id, findProducts != null ? findProducts.longValue() : 0L);
    }

    private final View createTextPreviewCard(final Context context, final FileDiffInfo file, String type, float density, final AgentContentBlock.Artifacts block) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(artifactCardBackgroundColor(context));
        gradientDrawable.setCornerRadius(20 * density);
        int i = (int) (1 * density);
        gradientDrawable.setStroke(i, ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = (int) (12 * density);
        layoutParams.bottomMargin = i2;
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (0 * density);
        linearLayout2.setPadding(i2, i3, i3, i3);
        linearLayout2.addView(createPreviewIconContainer(context, density, getFileTypeIcon(type, file.getFilePath())));
        LinearLayout createTextContainer = createTextContainer(context);
        createTextContainer.addView(createTitleText(context, extractFileName(file.getFilePath())));
        String upperCase = extractFileExtension(file.getFilePath()).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextView createSubtitleText = createSubtitleText(context, upperCase);
        createSubtitleText.setVisibility(8);
        createTextContainer.addView(createSubtitleText);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(createTextContainer, layoutParams2);
        LinearLayout linearLayout3 = linearLayout2;
        linearLayout.addView(linearLayout3);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (151 * density)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.addView(createArtifactLoadingView(context, density));
        View view2 = new View(context);
        view2.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (40 * density), 80));
        view2.setBackgroundResource(C0637R.drawable.trae_bg_artifact_loading_gradient);
        frameLayout2.addView(view2);
        FrameLayout frameLayout3 = frameLayout2;
        frameLayout.addView(frameLayout3);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        textView.setVisibility(8);
        textView.setMaxLines(8);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        textView.setIncludeFontPadding(false);
        int i4 = (int) (16 * density);
        textView.setPadding(i4, 0, i4, i4);
        frameLayout.addView(textView);
        FrameLayout frameLayout4 = frameLayout;
        linearLayout.addView(frameLayout4);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ArtifactsRenderer.createTextPreviewCard$lambda$36(FileDiffInfo.this, context, block, this, view3);
            }
        });
        LinearLayout linearLayout4 = linearLayout;
        loadTextContentAsync(context, textView, frameLayout3, frameLayout4, linearLayout3, createSubtitleText, view, linearLayout4, file, block);
        return linearLayout4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTextPreviewCard$lambda$36(FileDiffInfo fileDiffInfo, Context context, AgentContentBlock.Artifacts artifacts, ArtifactsRenderer artifactsRenderer, View view) {
        List<ParsedChatMessage> allMessages;
        Conversation currentConversation;
        String str;
        String filePath = fileDiffInfo.getFilePath();
        String str2 = filePath;
        if (str2 == null || str2.length() == 0) {
            CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
            return;
        }
        IMessageListener iGetMessage = artifacts.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null || (currentConversation = artifacts.getIGetMessage().getCurrentConversation()) == null) {
            return;
        }
        Long findProducts = artifactsRenderer.findProducts(allMessages, filePath);
        if (currentConversation.isLocal()) {
            str = (StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(filePath).toString();
        } else {
            str = filePath;
        }
        try {
            ArtifactTrack.INSTANCE.trackArtifactClick(filePath, artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        ArtifactPreviewActivity.Companion companion = ArtifactPreviewActivity.INSTANCE;
        String cliConversationId = currentConversation.getCliConversationId();
        if (cliConversationId == null) {
            cliConversationId = "";
        }
        String turnId = artifacts.getTurnId();
        String environment = currentConversation.getEnvironment();
        if (environment == null) {
            environment = "";
        }
        String messageId = artifacts.getMessageId();
        String id = currentConversation.getId();
        companion.start(context, cliConversationId, turnId, environment, str, messageId, id == null ? "" : id, findProducts != null ? findProducts.longValue() : 0L);
    }

    private final void loadTextContentAsync(Context context, final TextView textView, final View loadingView, final View contentContainer, final View headerRow, final TextView subtitleView, final View dividerLine, final View cardContainer, FileDiffInfo file, AgentContentBlock.Artifacts block) {
        Conversation currentConversation;
        final String str;
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return;
        }
        String cliConversationId = currentConversation.getCliConversationId();
        final String str2 = cliConversationId == null ? "" : cliConversationId;
        String environment = currentConversation.getEnvironment();
        final String str3 = environment == null ? "" : environment;
        String id = currentConversation.getId();
        final String str4 = id == null ? "" : id;
        final String messageId = block.getMessageId();
        String filePath = file.getFilePath();
        String str5 = filePath != null ? filePath : "";
        if (currentConversation.isLocal()) {
            str = (StringsKt.startsWith$default(str5, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(str5).toString();
        } else {
            str = str5;
        }
        textView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1
            private Job job;
            private final CoroutineScope scope = CoroutineScopeKt.MainScope();

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C0688x86d82341(str2, str3, str, messageId, str4, this, contentContainer, headerRow, subtitleView, dividerLine, cardContainer, loadingView, textView, null), 3, (Object) null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View createMarkdownPreviewCard(final Context context, final FileDiffInfo file, String type, float density, final AgentContentBlock.Artifacts block) {
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(artifactCardBackgroundColor(context));
        gradientDrawable.setCornerRadius(20 * density);
        int i = (int) (1 * density);
        gradientDrawable.setStroke(i, ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = (int) (12 * density);
        layoutParams.bottomMargin = i2;
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (0 * density);
        linearLayout2.setPadding(i2, i3, i3, i3);
        linearLayout2.addView(createPreviewIconContainer(context, density, getFileTypeIcon(type, file.getFilePath())));
        LinearLayout createTextContainer = createTextContainer(context);
        createTextContainer.addView(createTitleText(context, extractFileName(file.getFilePath())));
        String upperCase = extractFileExtension(file.getFilePath()).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextView createSubtitleText = createSubtitleText(context, upperCase);
        createSubtitleText.setVisibility(8);
        createTextContainer.addView(createSubtitleText);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(createTextContainer, layoutParams2);
        LinearLayout linearLayout3 = linearLayout2;
        linearLayout.addView(linearLayout3);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (151 * density)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.addView(createArtifactLoadingView(context, density));
        View view2 = new View(context);
        view2.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (40 * density), 80));
        view2.setBackgroundResource(C0637R.drawable.trae_bg_artifact_loading_gradient);
        frameLayout2.addView(view2);
        FrameLayout frameLayout3 = frameLayout2;
        frameLayout.addView(frameLayout3);
        SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
        simpleMarkdownTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        simpleMarkdownTextView.setVisibility(8);
        simpleMarkdownTextView.setClickable(false);
        simpleMarkdownTextView.setFocusable(false);
        simpleMarkdownTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda9
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                boolean createMarkdownPreviewCard$lambda$48$lambda$47;
                createMarkdownPreviewCard$lambda$48$lambda$47 = ArtifactsRenderer.createMarkdownPreviewCard$lambda$48$lambda$47(view3, motionEvent);
                return createMarkdownPreviewCard$lambda$48$lambda$47;
            }
        });
        simpleMarkdownTextView.setMaxLines(8);
        simpleMarkdownTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i4 = (int) (16 * density);
        simpleMarkdownTextView.setPadding(i4, 0, i4, i4);
        frameLayout.addView((View) simpleMarkdownTextView);
        View view3 = new View(context);
        view3.setId(C0637R.id.im_artifact_interceptor);
        view3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view3.setClickable(true);
        frameLayout.addView(view3);
        FrameLayout frameLayout4 = frameLayout;
        linearLayout.addView(frameLayout4);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ArtifactsRenderer.createMarkdownPreviewCard$lambda$50(FileDiffInfo.this, context, block, this, view4);
            }
        });
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                linearLayout.performClick();
            }
        });
        LinearLayout linearLayout4 = linearLayout;
        loadMarkdownContentAsync(context, simpleMarkdownTextView, frameLayout3, frameLayout4, linearLayout3, createSubtitleText, view, linearLayout4, file, block);
        return linearLayout4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMarkdownPreviewCard$lambda$50(FileDiffInfo fileDiffInfo, Context context, AgentContentBlock.Artifacts artifacts, ArtifactsRenderer artifactsRenderer, View view) {
        List<ParsedChatMessage> allMessages;
        Conversation currentConversation;
        String str;
        String filePath = fileDiffInfo.getFilePath();
        String str2 = filePath;
        if (str2 == null || str2.length() == 0) {
            CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
            return;
        }
        IMessageListener iGetMessage = artifacts.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null || (currentConversation = artifacts.getIGetMessage().getCurrentConversation()) == null) {
            return;
        }
        Long findProducts = artifactsRenderer.findProducts(allMessages, filePath);
        if (currentConversation.isLocal()) {
            str = (StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(filePath).toString();
        } else {
            str = filePath;
        }
        try {
            ArtifactTrack.INSTANCE.trackArtifactClick(filePath, artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        ArtifactPreviewActivity.Companion companion = ArtifactPreviewActivity.INSTANCE;
        String cliConversationId = currentConversation.getCliConversationId();
        if (cliConversationId == null) {
            cliConversationId = "";
        }
        String turnId = artifacts.getTurnId();
        String environment = currentConversation.getEnvironment();
        if (environment == null) {
            environment = "";
        }
        String messageId = artifacts.getMessageId();
        String id = currentConversation.getId();
        companion.start(context, cliConversationId, turnId, environment, str, messageId, id == null ? "" : id, findProducts != null ? findProducts.longValue() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String truncateForPreview(String content) {
        if (content.length() <= 300) {
            return content;
        }
        String str = content;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(str, "\n\n", 300, false, 4, (Object) null);
        if (lastIndexOf$default > 100) {
            String substring = content.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        int lastIndexOf$default2 = StringsKt.lastIndexOf$default(str, '\n', 300, false, 4, (Object) null);
        if (lastIndexOf$default2 > 100) {
            String substring2 = content.substring(0, lastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            return substring2;
        }
        String substring3 = content.substring(0, 300);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        return substring3;
    }

    private final void loadMarkdownContentAsync(Context context, final SimpleMarkdownTextView markdownTextView, final View loadingView, final View contentContainer, final View headerRow, final TextView subtitleView, final View dividerLine, final View cardContainer, FileDiffInfo file, AgentContentBlock.Artifacts block) {
        Conversation currentConversation;
        final String str;
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return;
        }
        String cliConversationId = currentConversation.getCliConversationId();
        final String str2 = cliConversationId == null ? "" : cliConversationId;
        String environment = currentConversation.getEnvironment();
        final String str3 = environment == null ? "" : environment;
        String id = currentConversation.getId();
        final String str4 = id == null ? "" : id;
        final String messageId = block.getMessageId();
        String filePath = file.getFilePath();
        String str5 = filePath != null ? filePath : "";
        if (currentConversation.isLocal()) {
            str = (StringsKt.startsWith$default(str5, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(str5).toString();
        } else {
            str = str5;
        }
        markdownTextView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1
            private Job job;
            private final CoroutineScope scope = CoroutineScopeKt.MainScope();

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C0686x50fee83f(str2, str3, str, messageId, str4, this, contentContainer, headerRow, subtitleView, dividerLine, cardContainer, loadingView, markdownTextView, null), 3, (Object) null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void collapseToFileCard(View contentContainer, View headerRow, TextView subtitleView, View dividerLine, View cardContainer) {
        contentContainer.setVisibility(8);
        View findViewById = contentContainer.findViewById(C0637R.id.im_artifact_interceptor);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (dividerLine != null) {
            dividerLine.setVisibility(8);
        }
        float f = headerRow.getResources().getDisplayMetrics().density;
        int i = (int) (12 * f);
        headerRow.setPadding(i, i, i, i);
        View findViewById2 = headerRow.findViewById(C0637R.id.img_im_artifact);
        FrameLayout frameLayout = findViewById2 instanceof FrameLayout ? (FrameLayout) findViewById2 : null;
        if (frameLayout != null) {
            int i2 = (int) (50 * f);
            int i3 = (int) (40 * f);
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            View childAt = frameLayout.getChildAt(0);
            if (childAt != null) {
                childAt.setLayoutParams(new FrameLayout.LayoutParams(i3, i3, 17));
            }
        }
        subtitleView.setVisibility(0);
        if (cardContainer != null) {
            Context context = cardContainer.getContext();
            GradientDrawable gradientDrawable = new GradientDrawable();
            Intrinsics.checkNotNull(context);
            gradientDrawable.setColor(artifactCardBackgroundColor(context));
            gradientDrawable.setCornerRadius(20 * f);
            gradientDrawable.setStroke((int) (1 * f), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
            cardContainer.setBackground(gradientDrawable);
            cardContainer.setClipToOutline(true);
            cardContainer.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
    }

    private final View createSkillCard(final Context context, SkillInfo skill, float density) {
        LinearLayout createCardContainer = createCardContainer(context, density);
        createCardContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsRenderer.createSkillCard$lambda$58$lambda$55(context, view);
            }
        });
        createCardContainer.addView(createIconContainer(context, density, C0637R.drawable.ic_artifact_skill));
        LinearLayout createTextContainer = createTextContainer(context);
        String skillName = skill.getSkillName();
        if (skillName == null) {
            skillName = "";
        }
        createTextContainer.addView(createTitleText(context, skillName));
        String filePath = skill.getFilePath();
        if (filePath != null) {
            createTextContainer.addView(createSubtitleText(context, filePath));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        createCardContainer.addView(createTextContainer, layoutParams);
        return createCardContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSkillCard$lambda$58$lambda$55(Context context, View view) {
        CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
    }

    private final View createHtmlArtifactCard(final Context context, final FileDiffInfo file, float density, final AgentContentBlock.Artifacts block) {
        LinearLayout createCardContainer = createCardContainer(context, density);
        createCardContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsRenderer.createHtmlArtifactCard$lambda$62$lambda$59(FileDiffInfo.this, context, this, block, view);
            }
        });
        createCardContainer.addView(createIconContainer(context, density, C0637R.drawable.ic_artifact_code));
        LinearLayout createTextContainer = createTextContainer(context);
        createTextContainer.addView(createTitleText(context, extractFileName(file.getFilePath())));
        String extractFileExtension = extractFileExtension(file.getFilePath());
        if (extractFileExtension.length() == 0) {
            extractFileExtension = "html";
        }
        String lowerCase = extractFileExtension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        createTextContainer.addView(createSubtitleText(context, lowerCase));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        createCardContainer.addView(createTextContainer, layoutParams);
        return createCardContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createHtmlArtifactCard$lambda$62$lambda$59(FileDiffInfo fileDiffInfo, Context context, ArtifactsRenderer artifactsRenderer, AgentContentBlock.Artifacts artifacts, View view) {
        String filePath = fileDiffInfo.getFilePath();
        String str = filePath;
        if (str == null || str.length() == 0) {
            CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
        } else {
            openHtmlArtifactPreview$default(artifactsRenderer, context, artifacts, filePath, null, 8, null);
        }
    }

    private final View createHtmlPreviewCard(final Context context, final FileDiffInfo file, float density, final AgentContentBlock.Artifacts block) {
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(artifactCardBackgroundColor(context));
        gradientDrawable.setCornerRadius(20 * density);
        int i = (int) (1 * density);
        gradientDrawable.setStroke(i, ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = (int) (12 * density);
        layoutParams.bottomMargin = i2;
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        int i3 = (int) (0 * density);
        linearLayout2.setPadding(i2, i3, i3, i3);
        linearLayout2.addView(createPreviewIconContainer(context, density, getCodeFileIcon(file.getFilePath())));
        LinearLayout createTextContainer = createTextContainer(context);
        createTextContainer.addView(createTitleText(context, extractFileName(file.getFilePath())));
        String upperCase = extractFileExtension(file.getFilePath()).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextView createSubtitleText = createSubtitleText(context, upperCase);
        createSubtitleText.setVisibility(8);
        createTextContainer.addView(createSubtitleText);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(createTextContainer, layoutParams2);
        LinearLayout linearLayout3 = linearLayout2;
        linearLayout.addView(linearLayout3);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (151 * density)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.addView(createArtifactLoadingView(context, density));
        View view2 = new View(context);
        view2.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (40 * density), 80));
        view2.setBackgroundResource(C0637R.drawable.trae_bg_artifact_loading_gradient);
        frameLayout2.addView(view2);
        FrameLayout frameLayout3 = frameLayout2;
        frameLayout.addView(frameLayout3);
        WebView webView = new WebView(context);
        webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        webView.setVisibility(8);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDefaultTextEncodingName("UTF-8");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        frameLayout.addView(webView);
        View view3 = new View(context);
        view3.setId(C0637R.id.im_artifact_interceptor);
        view3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view3.setClickable(true);
        frameLayout.addView(view3);
        FrameLayout frameLayout4 = frameLayout;
        linearLayout.addView(frameLayout4);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ArtifactsRenderer.createHtmlPreviewCard$lambda$76(FileDiffInfo.this, context, this, block, view4);
            }
        });
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                linearLayout.performClick();
            }
        });
        LinearLayout linearLayout4 = linearLayout;
        loadHtmlContentAsync(context, webView, frameLayout3, frameLayout4, linearLayout3, createSubtitleText, view, linearLayout4, file, block);
        return linearLayout4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createHtmlPreviewCard$lambda$76(FileDiffInfo fileDiffInfo, Context context, ArtifactsRenderer artifactsRenderer, AgentContentBlock.Artifacts artifacts, View view) {
        String filePath = fileDiffInfo.getFilePath();
        String str = filePath;
        if (str == null || str.length() == 0) {
            CustomToast.showLong(context, context.getString(R.string.trae_skill_preview_unsupported));
        } else {
            openHtmlArtifactPreview$default(artifactsRenderer, context, artifacts, filePath, null, 8, null);
        }
    }

    private final void loadHtmlContentAsync(final Context context, final WebView webView, final View loadingView, final View contentContainer, final View headerRow, final TextView subtitleView, final View dividerLine, final View cardContainer, final FileDiffInfo file, AgentContentBlock.Artifacts block) {
        Conversation currentConversation;
        final String str;
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return;
        }
        String cliConversationId = currentConversation.getCliConversationId();
        final String str2 = cliConversationId == null ? "" : cliConversationId;
        String environment = currentConversation.getEnvironment();
        final String str3 = environment == null ? "" : environment;
        String id = currentConversation.getId();
        final String str4 = id == null ? "" : id;
        final String messageId = block.getMessageId();
        String filePath = file.getFilePath();
        final String str5 = filePath == null ? "" : filePath;
        if (currentConversation.isLocal()) {
            str = (StringsKt.startsWith$default(str5, "/", false, 2, (Object) null) ? new StringBuilder("package") : new StringBuilder("package/")).append(str5).toString();
        } else {
            str = str5;
        }
        webView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1
            private Job job;
            private final CoroutineScope scope = CoroutineScopeKt.MainScope();

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C0682x72e3af03(ArtifactsRenderer.this, str2, str3, str, str4, messageId, context, str5, file, contentContainer, headerRow, subtitleView, dividerLine, cardContainer, loadingView, webView, null), 3, (Object) null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchHtmlArchiveUrl(String str, String str2, String str3, String str4, String str5, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ArtifactsRenderer$fetchHtmlArchiveUrl$2(str2, str, str3, this, str4, str5, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00f4 -> B:11:0x0043). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchHtmlDownloadUrlWithRetry(String str, String str2, String str3, Continuation<? super String> continuation) {
        ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1 artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
        int i;
        int i2;
        ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1 artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12;
        Object obj;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        HttpDataResult.Success success;
        Map<String, String> urlMap;
        if (continuation instanceof ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1) {
            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1 = (ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1) continuation;
            if ((artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj2 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
                    obj = coroutine_suspended;
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                    if (i2 < 21) {
                    }
                } else if (i == 1) {
                    i2 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.I$0;
                    str9 = (String) artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$2;
                    str8 = (String) artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$1;
                    str7 = (String) artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    success = (HttpDataResult) obj2;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.I$0;
                    str9 = (String) artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$2;
                    str8 = (String) artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$1;
                    str7 = (String) artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
                    obj = coroutine_suspended;
                    char c = 2;
                    str6 = str9;
                    str5 = str8;
                    i2++;
                    str4 = str7;
                    if (i2 < 21) {
                        IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
                        Object obj3 = obj;
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(CollectionsKt.listOf(str4), str5, str6, null, 8, null);
                        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12.L$0 = str4;
                        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12.L$1 = str5;
                        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12.L$2 = str6;
                        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12.I$0 = i2;
                        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12.label = 1;
                        Object downloadUrlRawCall = companion.getDownloadUrlRawCall(getDownloadUrlRequest, artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12);
                        if (downloadUrlRawCall == obj3) {
                            return obj3;
                        }
                        str7 = str4;
                        str8 = str5;
                        str9 = str6;
                        obj2 = downloadUrlRawCall;
                        coroutine_suspended = obj3;
                        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12;
                        success = (HttpDataResult) obj2;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            String str10 = (getDownloadUrlData == null || (urlMap = getDownloadUrlData.getUrlMap()) == null) ? null : urlMap.get(str7);
                            if (str10 != null) {
                                return str10;
                            }
                            if (success2.getBizResp().getCode() != 202 || i2 >= 20) {
                                return null;
                            }
                            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$0 = str7;
                            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$1 = str8;
                            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.L$2 = str9;
                            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.I$0 = i2;
                            c = 2;
                            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.label = 2;
                            if (DelayKt.delay(2000L, artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            artifactsRenderer$fetchHtmlDownloadUrlWithRetry$12 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
                            obj = coroutine_suspended;
                            str6 = str9;
                            str5 = str8;
                            i2++;
                            str4 = str7;
                            if (i2 < 21) {
                                return null;
                            }
                        } else {
                            if (success instanceof HttpDataResult.Error) {
                                return null;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
        }
        artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1 = new ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1(this, continuation);
        Object obj22 = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactsRenderer$fetchHtmlDownloadUrlWithRetry$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadAndExtractHtml(Context context, String str, String str2, String str3, String str4, JSONObject jSONObject, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ArtifactsRenderer$downloadAndExtractHtml$2(str4, str, str3, str2, jSONObject, context, null), continuation);
    }

    private final View createChangedCodeSection(final Context context, ChangedFileData data, float density, final AgentContentBlock.Artifacts block) {
        final Conversation currentConversation;
        Long l;
        String str;
        Integer deleteLineCount;
        Integer insertLineCount;
        List<FileDiffInfo> fileDiffInfos = data.getFileDiffInfos();
        if (fileDiffInfos == null) {
            return new LinearLayout(context);
        }
        int size = fileDiffInfos.size();
        ArtifactDiffInfo totalDiffInfo = data.getTotalDiffInfo();
        int intValue = (totalDiffInfo == null || (insertLineCount = totalDiffInfo.getInsertLineCount()) == null) ? 0 : insertLineCount.intValue();
        ArtifactDiffInfo totalDiffInfo2 = data.getTotalDiffInfo();
        int intValue2 = (totalDiffInfo2 == null || (deleteLineCount = totalDiffInfo2.getDeleteLineCount()) == null) ? 0 : deleteLineCount.intValue();
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return new LinearLayout(context);
        }
        if (Intrinsics.areEqual("code", currentConversation.getMode())) {
            LinearLayout createCardContainer = createCardContainer(context, density);
            createCardContainer.addView(createIconContainer(context, density, C0637R.drawable.filetype_diff));
            LinearLayout createTextContainer = createTextContainer(context);
            String string = context.getString(C0637R.string.trae_chat_artifact_files_changed, Integer.valueOf(size));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            createTextContainer.addView(createTitleText(context, string));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            TextView textView = new TextView(context);
            textView.setText("+" + intValue);
            textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_status_success_default));
            textView.setTextSize(2, 13.0f);
            textView.setMaxLines(1);
            linearLayout.addView(textView);
            TextView textView2 = new TextView(context);
            textView2.setText("-" + intValue2);
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_status_error_default));
            textView2.setTextSize(2, 13.0f);
            textView2.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart((int) (4 * density));
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(textView2, layoutParams);
            createTextContainer.addView(linearLayout);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams2.setMarginStart((int) (6 * density));
            Unit unit2 = Unit.INSTANCE;
            createCardContainer.addView(createTextContainer, layoutParams2);
            createCardContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtifactsRenderer.createChangedCodeSection$lambda$84$lambda$83(AgentContentBlock.Artifacts.this, currentConversation, this, context, view);
                }
            });
            return createCardContainer;
        }
        IMessageListener iGetMessage2 = block.getIGetMessage();
        List<ParsedChatMessage> allMessages = iGetMessage2 != null ? iGetMessage2.getAllMessages() : null;
        List<ParsedChatMessage> list = allMessages;
        if (list == null || list.isEmpty()) {
            l = null;
        } else {
            FileDiffInfo fileDiffInfo = (FileDiffInfo) CollectionsKt.firstOrNull(fileDiffInfos);
            if (fileDiffInfo == null || (str = fileDiffInfo.getFilePath()) == null) {
                str = "";
            }
            l = findMTCLatestTime(allMessages, str);
        }
        return createMtcCodeCard(context, density, size, data, block, currentConversation, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createChangedCodeSection$lambda$84$lambda$83(AgentContentBlock.Artifacts artifacts, Conversation conversation, ArtifactsRenderer artifactsRenderer, Context context, View view) {
        try {
            ArtifactTrack.INSTANCE.trackArtifactClickWithArtifactType("diff", artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        DiffViewActivity.Companion companion = DiffViewActivity.INSTANCE;
        String environment = conversation.getEnvironment();
        String str = environment == null ? "" : environment;
        String cliConversationId = conversation.getCliConversationId();
        String str2 = cliConversationId == null ? "" : cliConversationId;
        String turnId = artifacts.getTurnId();
        String title = artifactsRenderer.getTitle(artifacts);
        companion.start(context, title == null ? "" : title, str2, turnId, str, conversation.getId(), artifacts.getMessageId());
    }

    private final View createMtcCodeCard(final Context context, float density, int totalFiles, final ChangedFileData data, final AgentContentBlock.Artifacts block, final Conversation conversation, final Long createdTime) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (12 * density);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(artifactCardBackgroundColor(context));
        gradientDrawable.setCornerRadius(20 * density);
        gradientDrawable.setStroke((int) (1 * density), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        int i2 = (int) (50 * density);
        int i3 = (int) (40 * density);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.ic_file_diff_large);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i3, i3, 17));
        linearLayout.addView(frameLayout);
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_chat_artifact_code_files, Integer.valueOf(totalFiles)));
        textView.setTextColor(Color.parseColor("#171717"));
        textView.setTextSize(2, 17.0f);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart((int) (8 * density));
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(textView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsRenderer.createMtcCodeCard$lambda$92$lambda$91(AgentContentBlock.Artifacts.this, context, data, conversation, createdTime, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMtcCodeCard$lambda$92$lambda$91(AgentContentBlock.Artifacts artifacts, Context context, ChangedFileData changedFileData, Conversation conversation, Long l, View view) {
        try {
            ArtifactTrack.INSTANCE.trackArtifactClickWithArtifactType("diff", artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        CodeChangedListActivity.Companion companion = CodeChangedListActivity.INSTANCE;
        String cliConversationId = conversation.getCliConversationId();
        String str = cliConversationId == null ? "" : cliConversationId;
        String turnId = artifacts.getTurnId();
        String environment = conversation.getEnvironment();
        String str2 = environment == null ? "" : environment;
        String messageId = artifacts.getMessageId();
        String id = conversation.getId();
        companion.start(context, changedFileData, str, turnId, str2, messageId, id == null ? "" : id, l != null ? l.longValue() : 0L);
    }

    static /* synthetic */ void openHtmlArtifactPreview$default(ArtifactsRenderer artifactsRenderer, Context context, AgentContentBlock.Artifacts artifacts, String str, Long l, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        artifactsRenderer.openHtmlArtifactPreview(context, artifacts, str, l);
    }

    private final void openHtmlArtifactPreview(Context context, AgentContentBlock.Artifacts block, String filePath, Long createdTime) {
        List<ParsedChatMessage> allMessages;
        Conversation currentConversation;
        String sb;
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null) {
            return;
        }
        IMessageListener iGetMessage2 = block.getIGetMessage();
        if (iGetMessage2 == null || (currentConversation = iGetMessage2.getCurrentConversation()) == null) {
            return;
        }
        Long findMTCLatestTime = createdTime == null ? findMTCLatestTime(allMessages, filePath) : createdTime;
        if (Intrinsics.areEqual(currentConversation.getEnvironment(), CliType.LOCAL.getValue()) || Intrinsics.areEqual(currentConversation.getEnvironment(), CliType.IDE.getValue())) {
            sb = (StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder("package") : new StringBuilder("package/")).append(filePath).toString();
        } else {
            sb = filePath;
        }
        HtmlArtifactPreviewActivity.Companion companion = HtmlArtifactPreviewActivity.INSTANCE;
        String cliConversationId = currentConversation.getCliConversationId();
        if (cliConversationId == null) {
            cliConversationId = "";
        }
        String turnId = block.getTurnId();
        String environment = currentConversation.getEnvironment();
        if (environment == null) {
            environment = "";
        }
        String messageId = block.getMessageId();
        String id = currentConversation.getId();
        if (id == null) {
            id = "";
        }
        long longValue = findMTCLatestTime != null ? findMTCLatestTime.longValue() : 0L;
        String cliId = currentConversation.getCliId();
        companion.start(context, cliConversationId, turnId, environment, sb, messageId, id, longValue, cliId == null ? "" : cliId, filePath);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x016b, code lost:
    
        if (r2.equals("md") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0177, code lost:
    
        if (r2.equals("kt") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x019b, code lost:
    
        if (r2.equals("cc") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01a7, code lost:
    
        if (r2.equals("h") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r2.equals("markdown") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_markdown;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        if (r2.equals("yaml") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_yaml;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r2.equals("scss") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_css;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if (r2.equals("sass") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009a, code lost:
    
        if (r2.equals("bash") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_bash;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        if (r2.equals("yml") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e0, code lost:
    
        if (r2.equals("kts") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_java;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f8, code lost:
    
        if (r2.equals("hpp") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_type_header;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0110, code lost:
    
        if (r2.equals("cxx") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.explorer_lang_cpp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0128, code lost:
    
        if (r2.equals("cpp") == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0142, code lost:
    
        if (r2.equals("sh") == false) goto L131;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0028. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getCodeFileIcon(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return C0637R.drawable.ic_artifact_code;
        }
        String lowerCase = extractFileExtension(filePath).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case 99:
                if (lowerCase.equals("c")) {
                    return C0637R.drawable.explorer_lang_c;
                }
                return C0637R.drawable.ic_artifact_code;
            case 104:
                break;
            case 3168:
                break;
            case 3304:
                if (lowerCase.equals("go")) {
                    return C0637R.drawable.explorer_lang_go;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3401:
                if (lowerCase.equals("js")) {
                    return C0637R.drawable.explorer_lang_js;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3433:
                break;
            case 3479:
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    return C0637R.drawable.explorer_lang_python;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3649:
                if (lowerCase.equals("rs")) {
                    return C0637R.drawable.explorer_lang_rs;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3669:
                break;
            case 3711:
                if (lowerCase.equals("ts")) {
                    return C0637R.drawable.explorer_lang_ts;
                }
                return C0637R.drawable.ic_artifact_code;
            case 98723:
                break;
            case 98819:
                if (lowerCase.equals("css")) {
                    return C0637R.drawable.explorer_lang_css;
                }
                return C0637R.drawable.ic_artifact_code;
            case 98979:
                break;
            case 99811:
                if (lowerCase.equals("dts")) {
                    return C0637R.drawable.explorer_lang_dts;
                }
                return C0637R.drawable.ic_artifact_code;
            case 103528:
                break;
            case 105551:
                if (lowerCase.equals("jsx")) {
                    return C0637R.drawable.explorer_lang_react;
                }
                return C0637R.drawable.ic_artifact_code;
            case 106538:
                break;
            case 115161:
                if (lowerCase.equals("tsx")) {
                    return C0637R.drawable.explorer_lang_react;
                }
                return C0637R.drawable.ic_artifact_code;
            case 117126:
                if (lowerCase.equals("vue")) {
                    return C0637R.drawable.explorer_lang_vue;
                }
                return C0637R.drawable.ic_artifact_code;
            case 118807:
                if (lowerCase.equals("xml")) {
                    return C0637R.drawable.explorer_lang_xml;
                }
                return C0637R.drawable.ic_artifact_code;
            case 119768:
                break;
            case 3016404:
                break;
            case 3213227:
                if (lowerCase.equals("html")) {
                    return C0637R.drawable.explorer_lang_html;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3254818:
                if (lowerCase.equals("java")) {
                    return C0637R.drawable.explorer_lang_java;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3271912:
                if (lowerCase.equals("json")) {
                    return C0637R.drawable.explorer_lang_json;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3318169:
                if (lowerCase.equals("less")) {
                    return C0637R.drawable.explorer_lang_css;
                }
                return C0637R.drawable.ic_artifact_code;
            case 3522862:
                break;
            case 3524784:
                break;
            case 3701415:
                break;
            case 246938863:
                break;
            default:
                return C0637R.drawable.ic_artifact_code;
        }
    }

    private final String getBranchDisplayName(String branch) {
        return StringsKt.removePrefix(branch, "origin/");
    }

    private final View createMergeSection(final Context context, final MergeChangedFilesData data, float density, final AgentContentBlock.Artifacts block) {
        String string;
        Integer deleteLineCount;
        Integer insertLineCount;
        Integer conflictCount;
        Integer changedFilesCount;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        String sourceBranch = data.getSourceBranch();
        if (sourceBranch == null) {
            sourceBranch = "";
        }
        String branchDisplayName = getBranchDisplayName(sourceBranch);
        String targetBranch = data.getTargetBranch();
        String branchDisplayName2 = getBranchDisplayName(targetBranch != null ? targetBranch : "");
        MergeTotalDiffInfo totalDiffInfo = data.getTotalDiffInfo();
        List<MergeFileDiffInfo> fileDiffInfos = data.getFileDiffInfos();
        if (fileDiffInfos == null) {
            return linearLayout;
        }
        int size = (totalDiffInfo == null || (changedFilesCount = totalDiffInfo.getChangedFilesCount()) == null) ? fileDiffInfos.size() : changedFilesCount.intValue();
        int intValue = (totalDiffInfo == null || (conflictCount = totalDiffInfo.getConflictCount()) == null) ? 0 : conflictCount.intValue();
        int intValue2 = (totalDiffInfo == null || (insertLineCount = totalDiffInfo.getInsertLineCount()) == null) ? 0 : insertLineCount.intValue();
        int intValue3 = (totalDiffInfo == null || (deleteLineCount = totalDiffInfo.getDeleteLineCount()) == null) ? 0 : deleteLineCount.intValue();
        LinearLayout createCardContainer = createCardContainer(context, density);
        createCardContainer.addView(createIconContainer(context, density, C0637R.drawable.filetype_diff));
        LinearLayout createTextContainer = createTextContainer(context);
        String string2 = context.getString(C0637R.string.trae_chat_artifact_merge_title, branchDisplayName, branchDisplayName2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        createTextContainer.addView(createTitleText(context, string2));
        if (intValue > 0) {
            string = context.getString(C0637R.string.trae_chat_artifact_merge_subtitle_conflict, Integer.valueOf(size), Integer.valueOf(intValue));
        } else {
            string = context.getString(C0637R.string.trae_chat_artifact_merge_subtitle, Integer.valueOf(size));
        }
        Intrinsics.checkNotNull(string);
        createTextContainer.addView(createSubtitleText(context, string));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (6 * density));
        Unit unit = Unit.INSTANCE;
        createCardContainer.addView(createTextContainer, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(context);
        textView.setText("+" + intValue2);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_status_success_default));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText(" -" + intValue3);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_status_error_default));
        textView2.setTextSize(2, 13.0f);
        textView2.setMaxLines(1);
        linearLayout2.addView(textView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart((int) (8 * density));
        Unit unit2 = Unit.INSTANCE;
        createCardContainer.addView(linearLayout2, layoutParams2);
        createCardContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsRenderer.createMergeSection$lambda$100(AgentContentBlock.Artifacts.this, context, this, data, view);
            }
        });
        linearLayout.addView(createCardContainer);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMergeSection$lambda$100(AgentContentBlock.Artifacts artifacts, Context context, ArtifactsRenderer artifactsRenderer, MergeChangedFilesData mergeChangedFilesData, View view) {
        try {
            ArtifactTrack.INSTANCE.trackArtifactClickWithArtifactType("merge_view", artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        MargeViewActivity.Companion companion = MargeViewActivity.INSTANCE;
        String title = artifactsRenderer.getTitle(artifacts);
        if (title == null) {
            title = "";
        }
        companion.start(context, title, artifacts.getChatSessionId(), mergeChangedFilesData);
    }

    private final View createArtifactLoadingView(Context context, float density) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        int i = (int) (20 * density);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.trae_ic_artifact_loading_spinner);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 1;
        imageView.setLayoutParams(layoutParams);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new StepInterpolator(8));
        imageView.startAnimation(rotateAnimation);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_artifact_loading));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_disabled));
        textView.setTextSize(2, 15.0f);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) (8 * density);
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final LinearLayout createCardContainer(Context context, float density) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (12 * density);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(artifactCardBackgroundColor(context));
        gradientDrawable.setCornerRadius(20 * density);
        gradientDrawable.setStroke((int) (1 * density), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    private final int artifactCardBackgroundColor(Context context) {
        return ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1);
    }

    private final FrameLayout createPreviewIconContainer(Context context, float density, int iconRes) {
        int i = (int) (36 * density);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(iconRes);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout.setId(C0637R.id.img_im_artifact);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i, i, 17));
        return frameLayout;
    }

    private final FrameLayout createIconContainer(Context context, float density, int iconRes) {
        int i = (int) (50 * density);
        int i2 = (int) (40 * density);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(iconRes);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i2, i2, 17));
        return frameLayout;
    }

    private final LinearLayout createTextContainer(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    private final TextView createTitleText(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 17.0f);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        return textView;
    }

    private final TextView createSubtitleText(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 15.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        return textView;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0180, code lost:
    
        if (r5.equals(com.bytedance.trae.im.model.MessagePart.TYPE_LOG) == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0188, code lost:
    
        if (r5.equals("jpg") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0196, code lost:
    
        if (r5.equals("htm") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01a4, code lost:
    
        if (r5.equals("gif") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01ac, code lost:
    
        if (r5.equals(com.bytedance.trae.im.model.MessagePart.TYPE_DOC) == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b8, code lost:
    
        if (r5.equals("csv") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01c4, code lost:
    
        if (r5.equals("bmp") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01d0, code lost:
    
        if (r5.equals("avi") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01dc, code lost:
    
        if (r5.equals("aac") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e8, code lost:
    
        if (r5.equals("md") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01f4, code lost:
    
        if (r5.equals("gz") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01fd, code lost:
    
        if (r5.equals("7z") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r5.equals("markdown") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_markdown;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        if (r5.equals("xhtml") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_html;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
    
        if (r5.equals("webp") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_png;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
    
        if (r5.equals("webm") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_video;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        if (r5.equals("jpeg") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_jpg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c2, code lost:
    
        if (r5.equals("html") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cc, code lost:
    
        if (r5.equals("flac") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_mp3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d6, code lost:
    
        if (r5.equals("docx") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e1, code lost:
    
        if (r5.equals("zip") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_zip;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ec, code lost:
    
        if (r5.equals("wav") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f7, code lost:
    
        if (r5.equals("txt") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_txt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0102, code lost:
    
        if (r5.equals("tsv") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x010d, code lost:
    
        if (r5.equals("tar") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0118, code lost:
    
        if (r5.equals("svg") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0122, code lost:
    
        if (r5.equals("rar") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x012c, code lost:
    
        if (r5.equals("png") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0144, code lost:
    
        if (r5.equals("ogg") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x014e, code lost:
    
        if (r5.equals("mov") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0158, code lost:
    
        if (r5.equals("mp4") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0162, code lost:
    
        if (r5.equals("mp3") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x016c, code lost:
    
        if (r5.equals("mkv") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0176, code lost:
    
        if (r5.equals("mdx") == false) goto L152;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0076. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getFileTypeIcon(String type, String filePath) {
        String lowerCase = extractFileExtension(filePath).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (type.hashCode()) {
            case 99640:
                if (type.equals(MessagePart.TYPE_DOC)) {
                    switch (lowerCase.hashCode()) {
                        case 1827:
                            break;
                        case 3315:
                            break;
                        case 3479:
                            break;
                        case 96323:
                            break;
                        case 96980:
                            break;
                        case 97669:
                            break;
                        case 98822:
                            break;
                        case 99640:
                            break;
                        case 102340:
                            break;
                        case 103649:
                            break;
                        case 105441:
                            break;
                        case 107332:
                            break;
                        case 107969:
                            break;
                        case 108184:
                            break;
                        case 108272:
                            break;
                        case 108273:
                            break;
                        case 108308:
                            break;
                        case 109967:
                            break;
                        case 110834:
                            if (lowerCase.equals("pdf")) {
                                return C0637R.drawable.ic_artifact_pdf;
                            }
                            return C0637R.drawable.ic_artifact_doc;
                        case 111145:
                            break;
                        case 112675:
                            break;
                        case 114276:
                            break;
                        case 114597:
                            break;
                        case 115159:
                            break;
                        case 115312:
                            break;
                        case 117484:
                            break;
                        case 120609:
                            break;
                        case 3088960:
                            break;
                        case 3145576:
                            break;
                        case 3213227:
                            break;
                        case 3268712:
                            break;
                        case 3271912:
                            if (lowerCase.equals("json")) {
                                return C0637R.drawable.ic_artifact_json;
                            }
                            return C0637R.drawable.ic_artifact_doc;
                        case 3645337:
                            break;
                        case 3645340:
                            break;
                        case 114035747:
                            break;
                        case 246938863:
                            break;
                        default:
                            return C0637R.drawable.ic_artifact_doc;
                    }
                }
                return C0637R.drawable.ic_artifact_custom;
            case 3059181:
                if (type.equals("code")) {
                    return C0637R.drawable.ic_artifact_code;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 100313435:
                if (type.equals("image")) {
                    return (Intrinsics.areEqual(lowerCase, "jpg") || Intrinsics.areEqual(lowerCase, "jpeg")) ? C0637R.drawable.ic_artifact_jpg : C0637R.drawable.ic_artifact_png;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 109403487:
                if (type.equals("sheet")) {
                    return C0637R.drawable.ic_artifact_excel;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 109526449:
                if (type.equals("slide")) {
                    return C0637R.drawable.ic_artifact_ppt;
                }
                return C0637R.drawable.ic_artifact_custom;
            default:
                return C0637R.drawable.ic_artifact_custom;
        }
    }

    private final String extractFileName(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        return StringsKt.substringAfterLast$default(filePath, StringsKt.contains$default(str, '\\', false, 2, (Object) null) ? '\\' : '/', (String) null, 2, (Object) null);
    }

    private final String extractFileExtension(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        String extractFileName = extractFileName(filePath);
        int lastIndexOf$default = StringsKt.lastIndexOf$default(extractFileName, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default <= 0) {
            return "";
        }
        String substring = extractFileName.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058 A[Catch: all -> 0x00e0, TryCatch #0 {all -> 0x00e0, blocks: (B:3:0x0001, B:4:0x000b, B:6:0x0011, B:9:0x001d, B:12:0x0023, B:13:0x0030, B:15:0x0036, B:18:0x0042, B:23:0x0046, B:24:0x0052, B:26:0x0058, B:29:0x0065, B:32:0x006b, B:35:0x0072, B:38:0x0081, B:40:0x0087, B:44:0x0093, B:46:0x0099, B:47:0x009f, B:49:0x00b0, B:54:0x00d7, B:60:0x00ba, B:61:0x00be, B:63:0x00c4, B:71:0x008d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Long findMTCLatestTime(List<ParsedChatMessage> allMessages, String filePath) {
        List<ParsedPlanItemMessage> messages;
        ParsedToolCallResult result;
        ArtifactData products;
        try {
            for (ParsedChatMessage parsedChatMessage : CollectionsKt.reversed(allMessages)) {
                ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
                if (taskContent != null && (messages = taskContent.getMessages()) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = messages.iterator();
                    while (it.hasNext()) {
                        ParsedPlanItem planItem = ((ParsedPlanItemMessage) it.next()).getPlanItem();
                        if (planItem != null) {
                            arrayList.add(planItem);
                        }
                    }
                    Iterator it2 = CollectionsKt.reversed(arrayList).iterator();
                    while (it2.hasNext()) {
                        ParsedToolCallInfo toolCallInfo = ((ParsedPlanItem) it2.next()).getToolCallInfo();
                        if (toolCallInfo != null && (result = toolCallInfo.getResult()) != null) {
                            JsonElement data = result.getData();
                            if (data != null) {
                                try {
                                    FinishCardResult finishCardResult = (FinishCardResult) new Gson().fromJson(data, FinishCardResult.class);
                                    FinishCardResultData data2 = finishCardResult.getData();
                                    if (data2 == null || (products = data2.getProducts()) == null) {
                                        products = finishCardResult.getProducts();
                                    }
                                    if (products == null) {
                                        continue;
                                    } else {
                                        ChangedFileData changedCodes = products.getChangedCodes();
                                        List flatten = CollectionsKt.flatten(CollectionsKt.listOfNotNull(changedCodes != null ? changedCodes.getFileDiffInfos() : null));
                                        boolean z = false;
                                        if (!(flatten instanceof Collection) || !flatten.isEmpty()) {
                                            Iterator it3 = flatten.iterator();
                                            while (true) {
                                                if (!it3.hasNext()) {
                                                    break;
                                                }
                                                if (Intrinsics.areEqual(((FileDiffInfo) it3.next()).getFilePath(), filePath)) {
                                                    z = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (z) {
                                            return Long.valueOf(parsedChatMessage.getCreatedAt());
                                        }
                                    }
                                } catch (Exception unused) {
                                    continue;
                                }
                            }
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x0010, B:8:0x001c, B:11:0x0022, B:12:0x002f, B:14:0x0035, B:17:0x0041, B:22:0x0045, B:23:0x0051, B:25:0x0057, B:28:0x0064, B:31:0x006a, B:34:0x0071, B:37:0x0080, B:39:0x0086, B:43:0x0092, B:46:0x0098, B:53:0x008c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Long findProducts(List<ParsedChatMessage> allMessages, String filePath) {
        List<ParsedPlanItemMessage> messages;
        ParsedToolCallResult result;
        ArtifactData products;
        try {
            for (ParsedChatMessage parsedChatMessage : CollectionsKt.reversed(allMessages)) {
                ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
                if (taskContent != null && (messages = taskContent.getMessages()) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = messages.iterator();
                    while (it.hasNext()) {
                        ParsedPlanItem planItem = ((ParsedPlanItemMessage) it.next()).getPlanItem();
                        if (planItem != null) {
                            arrayList.add(planItem);
                        }
                    }
                    Iterator it2 = CollectionsKt.reversed(arrayList).iterator();
                    while (it2.hasNext()) {
                        ParsedToolCallInfo toolCallInfo = ((ParsedPlanItem) it2.next()).getToolCallInfo();
                        if (toolCallInfo != null && (result = toolCallInfo.getResult()) != null) {
                            JsonElement data = result.getData();
                            if (data != null) {
                                try {
                                    FinishCardResult finishCardResult = (FinishCardResult) new Gson().fromJson(data, FinishCardResult.class);
                                    FinishCardResultData data2 = finishCardResult.getData();
                                    if (data2 == null || (products = data2.getProducts()) == null) {
                                        products = finishCardResult.getProducts();
                                    }
                                    if (products != null && containsFilePath(products, filePath)) {
                                        return Long.valueOf(parsedChatMessage.getCreatedAt());
                                    }
                                } catch (Exception unused) {
                                    continue;
                                }
                            }
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private final boolean containsFilePath(ArtifactData products, String filePath) {
        List[] listArr = new List[4];
        ChangedFileData changedDocs = products.getChangedDocs();
        listArr[0] = changedDocs != null ? changedDocs.getFileDiffInfos() : null;
        ChangedFileData changedImages = products.getChangedImages();
        listArr[1] = changedImages != null ? changedImages.getFileDiffInfos() : null;
        ChangedFileData changedSheets = products.getChangedSheets();
        listArr[2] = changedSheets != null ? changedSheets.getFileDiffInfos() : null;
        ChangedFileData changedSlides = products.getChangedSlides();
        listArr[3] = changedSlides != null ? changedSlides.getFileDiffInfos() : null;
        List flatten = CollectionsKt.flatten(CollectionsKt.listOfNotNull(listArr));
        if ((flatten instanceof Collection) && flatten.isEmpty()) {
            return false;
        }
        Iterator it = flatten.iterator();
        while (it.hasNext()) {
            String filePath2 = ((FileDiffInfo) it.next()).getFilePath();
            if (filePath2 != null && StringsKt.contains$default(filePath2, filePath, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final View createSingleImagePreviewCard(final Context context, final FileDiffInfo file, float density, final AgentContentBlock.Artifacts block) {
        int i = (int) (230 * density);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.bottomMargin = (int) (12 * density);
        frameLayout.setLayoutParams(layoutParams);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
        simpleDraweeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(20 * density)).setPlaceholderImage(C0591R.drawable.trae_bg_image_loading, ScalingUtils.ScaleType.CENTER_CROP).setFailureImage(C0591R.drawable.trae_ic_image_break, ScalingUtils.ScaleType.CENTER).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        frameLayout.addView((View) simpleDraweeView);
        simpleDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactsRenderer.createSingleImagePreviewCard$lambda$124(AgentContentBlock.Artifacts.this, file, this, context, view);
            }
        });
        loadSingleImageAsync(context, simpleDraweeView, frameLayout, i, file, block);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSingleImagePreviewCard$lambda$124(AgentContentBlock.Artifacts artifacts, FileDiffInfo fileDiffInfo, ArtifactsRenderer artifactsRenderer, Context context, View view) {
        List<ParsedChatMessage> allMessages;
        Conversation currentConversation;
        String filePath;
        String str;
        IMessageListener iGetMessage = artifacts.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null || (currentConversation = artifacts.getIGetMessage().getCurrentConversation()) == null || (filePath = fileDiffInfo.getFilePath()) == null) {
            return;
        }
        Long findProducts = artifactsRenderer.findProducts(allMessages, filePath);
        if (currentConversation.isLocal()) {
            str = (StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(filePath).toString();
        } else {
            str = filePath;
        }
        try {
            ArtifactTrack.INSTANCE.trackArtifactClick(filePath, artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        MultiImagePreviewActivity.Companion companion = MultiImagePreviewActivity.INSTANCE;
        String cliConversationId = currentConversation.getCliConversationId();
        String str2 = cliConversationId == null ? "" : cliConversationId;
        String turnId = artifacts.getTurnId();
        String environment = currentConversation.getEnvironment();
        String str3 = environment == null ? "" : environment;
        ArrayList<String> arrayListOf = CollectionsKt.arrayListOf(new String[]{str});
        String messageId = artifacts.getMessageId();
        String id = currentConversation.getId();
        companion.start(context, str2, turnId, str3, arrayListOf, 0, messageId, id == null ? "" : id, findProducts != null ? findProducts.longValue() : 0L);
    }

    private final void loadSingleImageAsync(final Context context, final SimpleDraweeView draweeView, final FrameLayout container, final int maxSizePx, final FileDiffInfo file, AgentContentBlock.Artifacts block) {
        Conversation currentConversation;
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return;
        }
        String cliConversationId = currentConversation.getCliConversationId();
        final String str = cliConversationId == null ? "" : cliConversationId;
        String environment = currentConversation.getEnvironment();
        final String str2 = environment == null ? "" : environment;
        String id = currentConversation.getId();
        final String str3 = id == null ? "" : id;
        final String messageId = block.getMessageId();
        draweeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadSingleImageAsync$1
            private Job job;
            private final CoroutineScope scope = CoroutineScopeKt.MainScope();

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C0687x8c709ea8(ArtifactsRenderer.this, context, file, str2, str, str3, messageId, draweeView, container, maxSizePx, null), 3, (Object) null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x02ac -> B:27:0x02b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveImageUri(Context context, FileDiffInfo fileDiffInfo, String str, String str2, String str3, String str4, Continuation<? super Uri> continuation) {
        ArtifactsRenderer$resolveImageUri$1 artifactsRenderer$resolveImageUri$1;
        int i;
        JSONObject jSONObject;
        String str5;
        String str6;
        Ref.ObjectRef objectRef;
        int i2;
        int i3;
        Object obj;
        ArtifactsRenderer$resolveImageUri$1 artifactsRenderer$resolveImageUri$12;
        JSONObject jSONObject2;
        String str7;
        Context context2;
        FileDiffInfo fileDiffInfo2;
        Object withContext;
        ArtifactsRenderer artifactsRenderer;
        HttpDataResult.Success success;
        Context context3;
        String str8;
        Ref.ObjectRef objectRef2;
        Object obj2;
        JSONObject jSONObject3;
        CharSequence charSequence;
        JSONObject jSONObject4;
        String str9;
        int i4;
        HttpDataResult.Success success2;
        File file;
        if (continuation instanceof ArtifactsRenderer$resolveImageUri$1) {
            artifactsRenderer$resolveImageUri$1 = (ArtifactsRenderer$resolveImageUri$1) continuation;
            if ((artifactsRenderer$resolveImageUri$1.label & Integer.MIN_VALUE) != 0) {
                artifactsRenderer$resolveImageUri$1.label -= Integer.MIN_VALUE;
                Object obj3 = artifactsRenderer$resolveImageUri$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactsRenderer$resolveImageUri$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("chatSessionId", str2);
                        str5 = str3;
                    } catch (Throwable unused) {
                        str5 = str3;
                    }
                    try {
                        jSONObject.put("conversationId", str5);
                        str6 = str4;
                        try {
                            jSONObject.put("messageId", str6);
                            jSONObject.put("path", fileDiffInfo.getFilePath());
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable unused3) {
                        str6 = str4;
                        if (Intrinsics.areEqual(str, CliType.REMOTE.getValue())) {
                        }
                    }
                    if (Intrinsics.areEqual(str, CliType.REMOTE.getValue())) {
                        String filePath = fileDiffInfo.getFilePath();
                        String str10 = filePath != null ? filePath : "";
                        String sb = (StringsKt.startsWith$default(str10, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(str10).toString();
                        objectRef = new Ref.ObjectRef();
                        i2 = 0;
                        i3 = 4;
                        obj = coroutine_suspended;
                        artifactsRenderer$resolveImageUri$12 = artifactsRenderer$resolveImageUri$1;
                        jSONObject2 = jSONObject;
                        str7 = sb;
                        context2 = context;
                        if (i2 < i3) {
                        }
                    } else {
                        CoroutineContext io = Dispatchers.getIO();
                        ArtifactsRenderer$resolveImageUri$result$1 artifactsRenderer$resolveImageUri$result$1 = new ArtifactsRenderer$resolveImageUri$result$1(str2, null);
                        artifactsRenderer$resolveImageUri$1.L$0 = this;
                        fileDiffInfo2 = fileDiffInfo;
                        artifactsRenderer$resolveImageUri$1.L$1 = fileDiffInfo2;
                        artifactsRenderer$resolveImageUri$1.L$2 = jSONObject;
                        artifactsRenderer$resolveImageUri$1.label = 1;
                        withContext = BuildersKt.withContext(io, artifactsRenderer$resolveImageUri$result$1, artifactsRenderer$resolveImageUri$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        artifactsRenderer = this;
                    }
                } else if (i == 1) {
                    JSONObject jSONObject5 = (JSONObject) artifactsRenderer$resolveImageUri$1.L$2;
                    FileDiffInfo fileDiffInfo3 = (FileDiffInfo) artifactsRenderer$resolveImageUri$1.L$1;
                    ArtifactsRenderer artifactsRenderer2 = (ArtifactsRenderer) artifactsRenderer$resolveImageUri$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    jSONObject = jSONObject5;
                    fileDiffInfo2 = fileDiffInfo3;
                    artifactsRenderer = artifactsRenderer2;
                    withContext = obj3;
                } else {
                    if (i == 2) {
                        i4 = artifactsRenderer$resolveImageUri$1.I$0;
                        objectRef2 = (Ref.ObjectRef) artifactsRenderer$resolveImageUri$1.L$5;
                        str9 = (String) artifactsRenderer$resolveImageUri$1.L$4;
                        JSONObject jSONObject6 = (JSONObject) artifactsRenderer$resolveImageUri$1.L$3;
                        str6 = (String) artifactsRenderer$resolveImageUri$1.L$2;
                        String str11 = (String) artifactsRenderer$resolveImageUri$1.L$1;
                        context3 = (Context) artifactsRenderer$resolveImageUri$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        jSONObject4 = jSONObject6;
                        str5 = str11;
                        success2 = (HttpDataResult) obj3;
                        if (success2 instanceof HttpDataResult.Success) {
                        }
                        obj2 = coroutine_suspended;
                        jSONObject3 = jSONObject4;
                        artifactsRenderer$resolveImageUri$12 = artifactsRenderer$resolveImageUri$1;
                        charSequence = (CharSequence) objectRef2.element;
                        if (!(charSequence != null || charSequence.length() == 0)) {
                        }
                        return null;
                    }
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        jSONObject3 = (JSONObject) artifactsRenderer$resolveImageUri$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        file = (File) obj3;
                        if (file == null && file.exists() && file.length() > 0) {
                            ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "success", "", jSONObject3);
                            return Uri.fromFile(file);
                        }
                        ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "failed", "", jSONObject3);
                        return null;
                    }
                    i4 = artifactsRenderer$resolveImageUri$1.I$0;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) artifactsRenderer$resolveImageUri$1.L$5;
                    String str12 = (String) artifactsRenderer$resolveImageUri$1.L$4;
                    JSONObject jSONObject7 = (JSONObject) artifactsRenderer$resolveImageUri$1.L$3;
                    String str13 = (String) artifactsRenderer$resolveImageUri$1.L$2;
                    str5 = (String) artifactsRenderer$resolveImageUri$1.L$1;
                    Context context4 = (Context) artifactsRenderer$resolveImageUri$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    String str14 = str12;
                    objectRef = objectRef3;
                    obj = coroutine_suspended;
                    artifactsRenderer$resolveImageUri$12 = artifactsRenderer$resolveImageUri$1;
                    jSONObject2 = jSONObject7;
                    i2 = i4 + 1;
                    context2 = context4;
                    str7 = str14;
                    str6 = str13;
                    i3 = 4;
                    if (i2 < i3) {
                        CoroutineContext io2 = Dispatchers.getIO();
                        ArtifactsRenderer$resolveImageUri$result$2 artifactsRenderer$resolveImageUri$result$2 = new ArtifactsRenderer$resolveImageUri$result$2(str7, str5, str6, null);
                        artifactsRenderer$resolveImageUri$12.L$0 = context2;
                        artifactsRenderer$resolveImageUri$12.L$1 = str5;
                        artifactsRenderer$resolveImageUri$12.L$2 = str6;
                        artifactsRenderer$resolveImageUri$12.L$3 = jSONObject2;
                        artifactsRenderer$resolveImageUri$12.L$4 = str7;
                        artifactsRenderer$resolveImageUri$12.L$5 = objectRef;
                        artifactsRenderer$resolveImageUri$12.I$0 = i2;
                        artifactsRenderer$resolveImageUri$12.label = 2;
                        Object withContext2 = BuildersKt.withContext(io2, artifactsRenderer$resolveImageUri$result$2, artifactsRenderer$resolveImageUri$12);
                        if (withContext2 == obj) {
                            return obj;
                        }
                        context3 = context2;
                        i4 = i2;
                        jSONObject4 = jSONObject2;
                        artifactsRenderer$resolveImageUri$1 = artifactsRenderer$resolveImageUri$12;
                        coroutine_suspended = obj;
                        objectRef2 = objectRef;
                        str9 = str7;
                        obj3 = withContext2;
                        success2 = (HttpDataResult) obj3;
                        if (success2 instanceof HttpDataResult.Success) {
                            str8 = str9;
                            try {
                                if (success2 instanceof HttpDataResult.Error) {
                                    ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "failed", ((HttpDataResult.Error) success2).getCode() + '_' + ((HttpDataResult.Error) success2).getMsg(), jSONObject4);
                                } else {
                                    ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "failed", "other", jSONObject4);
                                }
                            } catch (Throwable unused4) {
                            }
                        } else {
                            HttpDataResult.Success success3 = success2;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success3.getBizResp().getData();
                            Map<String, String> urlMap = getDownloadUrlData != null ? getDownloadUrlData.getUrlMap() : null;
                            objectRef2.element = urlMap != null ? urlMap.get(str9) : null;
                            CharSequence charSequence2 = (CharSequence) objectRef2.element;
                            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                                str8 = str9;
                            } else if (success3.getBizResp().getCode() == 202) {
                                artifactsRenderer$resolveImageUri$1.L$0 = context3;
                                artifactsRenderer$resolveImageUri$1.L$1 = str5;
                                artifactsRenderer$resolveImageUri$1.L$2 = str6;
                                artifactsRenderer$resolveImageUri$1.L$3 = jSONObject4;
                                artifactsRenderer$resolveImageUri$1.L$4 = str9;
                                artifactsRenderer$resolveImageUri$1.L$5 = objectRef2;
                                artifactsRenderer$resolveImageUri$1.I$0 = i4;
                                artifactsRenderer$resolveImageUri$1.label = 3;
                                str14 = str9;
                                if (DelayKt.delay(50L, artifactsRenderer$resolveImageUri$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                objectRef = objectRef2;
                                obj = coroutine_suspended;
                                artifactsRenderer$resolveImageUri$12 = artifactsRenderer$resolveImageUri$1;
                                jSONObject2 = jSONObject4;
                                Context context5 = context3;
                                str13 = str6;
                                context4 = context5;
                                i2 = i4 + 1;
                                context2 = context4;
                                str7 = str14;
                                str6 = str13;
                                i3 = 4;
                                if (i2 < i3) {
                                    context3 = context2;
                                    str8 = str7;
                                    jSONObject3 = jSONObject2;
                                    obj2 = obj;
                                    objectRef2 = objectRef;
                                    charSequence = (CharSequence) objectRef2.element;
                                    if (!(charSequence != null || charSequence.length() == 0)) {
                                        ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "success", "", jSONObject3);
                                        if (StringsKt.startsWith$default((String) objectRef2.element, "content://", false, 2, (Object) null) || StringsKt.startsWith$default((String) objectRef2.element, "file://", false, 2, (Object) null)) {
                                            return Uri.parse((String) objectRef2.element);
                                        }
                                        FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
                                        CoroutineContext io3 = Dispatchers.getIO();
                                        ArtifactsRenderer$resolveImageUri$cacheFile$1 artifactsRenderer$resolveImageUri$cacheFile$1 = new ArtifactsRenderer$resolveImageUri$cacheFile$1(fileDownloadHelper, context3, objectRef2, str5, str8, null);
                                        artifactsRenderer$resolveImageUri$12.L$0 = jSONObject3;
                                        artifactsRenderer$resolveImageUri$12.L$1 = null;
                                        artifactsRenderer$resolveImageUri$12.L$2 = null;
                                        artifactsRenderer$resolveImageUri$12.L$3 = null;
                                        artifactsRenderer$resolveImageUri$12.L$4 = null;
                                        artifactsRenderer$resolveImageUri$12.L$5 = null;
                                        artifactsRenderer$resolveImageUri$12.label = 4;
                                        Object withContext3 = BuildersKt.withContext(io3, artifactsRenderer$resolveImageUri$cacheFile$1, artifactsRenderer$resolveImageUri$12);
                                        if (withContext3 == obj2) {
                                            return obj2;
                                        }
                                        obj3 = withContext3;
                                        file = (File) obj3;
                                        if (file == null) {
                                        }
                                        ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "failed", "", jSONObject3);
                                    }
                                    return null;
                                }
                            } else {
                                str8 = str9;
                                ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "failed", "url_is_null", jSONObject4);
                            }
                        }
                        obj2 = coroutine_suspended;
                        jSONObject3 = jSONObject4;
                        artifactsRenderer$resolveImageUri$12 = artifactsRenderer$resolveImageUri$1;
                        charSequence = (CharSequence) objectRef2.element;
                        if (!(charSequence != null || charSequence.length() == 0)) {
                        }
                        return null;
                    }
                }
                success = (HttpDataResult) withContext;
                if (success instanceof HttpDataResult.Success) {
                    try {
                        if (success instanceof HttpDataResult.Error) {
                            ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "failed", ((HttpDataResult.Error) success).getCode() + '_' + ((HttpDataResult.Error) success).getMsg(), jSONObject);
                        } else {
                            ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "failed", "other", jSONObject);
                        }
                    } catch (Throwable unused5) {
                    }
                } else {
                    HttpDataResult.Success success4 = success;
                    ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success4.getBizResp().getData();
                    String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                    ChatSessionResponse chatSessionResponse2 = (ChatSessionResponse) success4.getBizResp().getData();
                    String workspacePath = chatSessionResponse2 != null ? chatSessionResponse2.getWorkspacePath() : null;
                    String str15 = explorerUrl;
                    if (str15 != null && str15.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "success", "", jSONObject);
                        String filePath2 = fileDiffInfo2.getFilePath();
                        return Uri.parse(artifactsRenderer.buildFileUrl(explorerUrl, artifactsRenderer.normalizeFilePath(filePath2 != null ? filePath2 : "", workspacePath)));
                    }
                    ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "failed", "url_is_null", jSONObject);
                }
                return null;
            }
        }
        artifactsRenderer$resolveImageUri$1 = new ArtifactsRenderer$resolveImageUri$1(this, continuation);
        Object obj32 = artifactsRenderer$resolveImageUri$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactsRenderer$resolveImageUri$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) withContext;
        if (success instanceof HttpDataResult.Success) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setImageWithResize(SimpleDraweeView draweeView, final FrameLayout container, final int maxSizePx, Uri uri) {
        draweeView.setController(Fresco.newDraweeControllerBuilder().setUri(uri).setControllerListener(new BaseControllerListener<ImageInfo>() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$setImageWithResize$controllerListener$1
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                int i;
                int i2;
                if (imageInfo == null) {
                    return;
                }
                int width = imageInfo.getWidth();
                int height = imageInfo.getHeight();
                if (width <= 0 || height <= 0) {
                    return;
                }
                if (width >= height) {
                    i = maxSizePx;
                    i2 = (int) ((i * height) / width);
                } else {
                    int i3 = maxSizePx;
                    i = (int) ((i3 * width) / height);
                    i2 = i3;
                }
                ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = i;
                layoutParams2.height = i2;
                container.setLayoutParams(layoutParams2);
            }
        }).setOldController(draweeView.getController()).build());
    }

    private final View createMultiImagePreviewCard(final Context context, final List<FileDiffInfo> files, float density, final AgentContentBlock.Artifacts block) {
        FrameLayout.LayoutParams layoutParams;
        boolean z = files.size() == 2;
        int i = (int) ((z ? 140 : 84) * density);
        float f = 20 * density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        if (z) {
            linearLayout.setGravity(16);
        }
        int i2 = 12;
        if (z) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = (int) (12 * density);
            layoutParams = layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        linearLayout.setLayoutParams(layoutParams);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : files) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final FileDiffInfo fileDiffInfo = (FileDiffInfo) obj;
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i, i);
            if (i3 < files.size() - 1) {
                layoutParams3.setMarginEnd((int) (8 * density));
            }
            simpleDraweeView.setLayoutParams(layoutParams3);
            GenericDraweeHierarchyBuilder failureImage = new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(f)).setPlaceholderImage(C0591R.drawable.trae_bg_image_loading, ScalingUtils.ScaleType.CENTER_CROP).setFailureImage(C0591R.drawable.trae_ic_image_break, ScalingUtils.ScaleType.CENTER);
            if (z) {
                failureImage.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            }
            simpleDraweeView.setHierarchy(failureImage.build());
            arrayList.add(simpleDraweeView);
            linearLayout.addView((View) simpleDraweeView);
            final int i5 = i3;
            simpleDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtifactsRenderer.createMultiImagePreviewCard$lambda$133$lambda$132(AgentContentBlock.Artifacts.this, fileDiffInfo, this, files, context, i5, view);
                }
            });
            arrayList = arrayList;
            i2 = 12;
            i3 = i4;
            i = i;
        }
        int i6 = i2;
        loadImagesAsync(context, arrayList, files, block);
        if (z) {
            return linearLayout;
        }
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setOverScrollMode(2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = (int) (i6 * density);
        horizontalScrollView.setLayoutParams(layoutParams4);
        horizontalScrollView.addView(linearLayout);
        return horizontalScrollView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMultiImagePreviewCard$lambda$133$lambda$132(AgentContentBlock.Artifacts artifacts, FileDiffInfo fileDiffInfo, ArtifactsRenderer artifactsRenderer, List list, Context context, int i, View view) {
        List<ParsedChatMessage> allMessages;
        Conversation currentConversation;
        String filePath;
        IMessageListener iGetMessage = artifacts.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null || (currentConversation = artifacts.getIGetMessage().getCurrentConversation()) == null || (filePath = fileDiffInfo.getFilePath()) == null) {
            return;
        }
        Long findProducts = artifactsRenderer.findProducts(allMessages, filePath);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String filePath2 = ((FileDiffInfo) it.next()).getFilePath();
            String str = null;
            if (filePath2 != null) {
                if (currentConversation.isLocal()) {
                    filePath2 = (StringsKt.startsWith$default(filePath2, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(filePath2).toString();
                }
                str = filePath2;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList);
        try {
            ArtifactTrack.INSTANCE.trackArtifactClick(filePath, artifacts.getMessageId());
        } catch (Throwable unused) {
        }
        MultiImagePreviewActivity.Companion companion = MultiImagePreviewActivity.INSTANCE;
        String cliConversationId = currentConversation.getCliConversationId();
        String str2 = cliConversationId == null ? "" : cliConversationId;
        String turnId = artifacts.getTurnId();
        String environment = currentConversation.getEnvironment();
        String str3 = environment == null ? "" : environment;
        String messageId = artifacts.getMessageId();
        String id = currentConversation.getId();
        companion.start(context, str2, turnId, str3, arrayList2, i, messageId, id == null ? "" : id, findProducts != null ? findProducts.longValue() : 0L);
    }

    private final void loadImagesAsync(final Context context, final List<? extends SimpleDraweeView> imageViews, final List<FileDiffInfo> files, AgentContentBlock.Artifacts block) {
        Conversation currentConversation;
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (currentConversation = iGetMessage.getCurrentConversation()) == null) {
            return;
        }
        String cliConversationId = currentConversation.getCliConversationId();
        final String str = cliConversationId == null ? "" : cliConversationId;
        String environment = currentConversation.getEnvironment();
        final String str2 = environment == null ? "" : environment;
        String id = currentConversation.getId();
        final String str3 = id == null ? "" : id;
        final String messageId = block.getMessageId();
        if (imageViews.isEmpty()) {
            return;
        }
        imageViews.get(0).addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadImagesAsync$1
            private Job job;
            private final CoroutineScope scope = CoroutineScopeKt.MainScope();

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.job = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1(str2, files, imageViews, str, str3, messageId, this, context, null), 3, (Object) null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Job job = this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        });
    }

    static /* synthetic */ String normalizeFilePath$default(ArtifactsRenderer artifactsRenderer, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return artifactsRenderer.normalizeFilePath(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeFilePath(String filePath, String workspacePath) {
        String str = workspacePath;
        if (!(str == null || str.length() == 0)) {
            String str2 = StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null) ? workspacePath : workspacePath + '/';
            if (StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null)) {
                workspacePath = StringsKt.dropLast(workspacePath, 1);
            }
            for (String str3 : CollectionsKt.listOf(new String[]{str2, workspacePath})) {
                if (StringsKt.startsWith$default(filePath, str3, false, 2, (Object) null)) {
                    String substring = filePath.substring(str3.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return StringsKt.removePrefix(substring, "/");
                }
            }
        }
        if (!StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null)) {
            return filePath;
        }
        String substring2 = filePath.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildFileUrl(String explorerUrl, String path) {
        String encode = URLEncoder.encode(path, "UTF-8");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        return StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + "/file/" + encode + "?download=true&authorization=" + URLEncoder.encode("Cloud-IDE-JWT " + xTToken, "UTF-8");
    }

    private final String getTitle(AgentContentBlock.Artifacts block) {
        List<ParsedChatMessage> allMessages;
        Object obj;
        String replyToMessageId;
        List<MessagePart> query;
        Object obj2;
        JsonObject data;
        JsonElement jsonElement;
        String messageId = block.getMessageId();
        IMessageListener iGetMessage = block.getIGetMessage();
        if (iGetMessage == null || (allMessages = iGetMessage.getAllMessages()) == null) {
            return null;
        }
        List<ParsedChatMessage> list = allMessages;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ParsedChatMessage) obj).getMessageId(), messageId)) {
                break;
            }
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
        if (parsedChatMessage == null || (replyToMessageId = parsedChatMessage.getReplyToMessageId()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            ParsedChatMessage parsedChatMessage2 = (ParsedChatMessage) obj3;
            if (Intrinsics.areEqual(parsedChatMessage2.getMessageId(), replyToMessageId) && parsedChatMessage2.isUserMessage()) {
                arrayList.add(obj3);
            }
        }
        ParsedChatMessage parsedChatMessage3 = (ParsedChatMessage) CollectionsKt.firstOrNull(arrayList);
        if (parsedChatMessage3 == null || (query = parsedChatMessage3.getQuery()) == null) {
            return null;
        }
        Iterator<T> it2 = query.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(((MessagePart) obj2).getType(), "text")) {
                break;
            }
        }
        MessagePart messagePart = (MessagePart) obj2;
        if (messagePart == null || (data = messagePart.getData()) == null || (jsonElement = data.get(ReportConstant.COMMON_CONTENT)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }

    private final String extractPrimaryArtifactPath(String summary) {
        MatchResult find$default;
        String str = summary;
        if ((str == null || str.length() == 0) || (find$default = Regex.find$default(COMPUTER_LINK_REGEX, str, 0, 2, (Object) null)) == null) {
            return null;
        }
        return (String) find$default.getGroupValues().get(1);
    }
}
