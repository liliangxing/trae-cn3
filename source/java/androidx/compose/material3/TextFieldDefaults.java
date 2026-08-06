package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010+J¦\u0002\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010?J7\u0010@\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010+JP\u0010A\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u009c\u0002\u0010F\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010GJî\u0001\u0010F\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010HJ¦\u0002\u0010I\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010?Jø\u0001\u0010I\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010JJ\r\u0010*\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010KJÂ\u0003\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010P\u001a\u00020M2\b\b\u0002\u0010Q\u001a\u00020M2\b\b\u0002\u0010R\u001a\u00020M2\b\b\u0002\u0010S\u001a\u00020M2\b\b\u0002\u0010T\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\b\b\u0002\u0010Y\u001a\u00020M2\b\b\u0002\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020M2\b\b\u0002\u0010\\\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\b\b\u0002\u0010i\u001a\u00020M2\b\b\u0002\u0010j\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010l\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0004\by\u0010zJ:\u0010{\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J;\u0010\u0082\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0081\u0001J\u0084\u0003\u0010\u0084\u0001\u001a\u00020\u001f2\t\b\u0002\u0010\u0085\u0001\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\t\b\u0002\u0010\u0086\u0001\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\t\b\u0002\u0010\u0087\u0001\u001a\u00020M2\t\b\u0002\u0010\u0088\u0001\u001a\u00020M2\t\b\u0002\u0010\u0089\u0001\u001a\u00020M2\t\b\u0002\u0010\u008a\u0001\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\t\b\u0002\u0010\u008b\u0001\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J´\u0003\u0010\u0084\u0001\u001a\u00020\u001f2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010P\u001a\u00020M2\t\b\u0002\u0010\u0086\u0001\u001a\u00020M2\b\b\u0002\u0010T\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\t\b\u0002\u0010\u0087\u0001\u001a\u00020M2\t\b\u0002\u0010\u0088\u0001\u001a\u00020M2\t\b\u0002\u0010\u0089\u0001\u001a\u00020M2\t\b\u0002\u0010\u008a\u0001\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\b\b\u0002\u0010i\u001a\u00020M2\b\b\u0002\u0010j\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010l\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J=\u0010\u0090\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u0081\u0001J=\u0010\u0092\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u0004H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0081\u0001J\u0080\u0003\u0010\u0094\u0001\u001a\u00020\u001f2\t\b\u0002\u0010\u0085\u0001\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\t\b\u0002\u0010\u0086\u0001\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020M2\b\b\u0002\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020M2\b\b\u0002\u0010\\\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\t\b\u0002\u0010\u008b\u0001\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u008d\u0001J°\u0003\u0010\u0094\u0001\u001a\u00020\u001f2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010P\u001a\u00020M2\t\b\u0002\u0010\u0086\u0001\u001a\u00020M2\b\b\u0002\u0010T\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020M2\b\b\u0002\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020M2\b\b\u0002\u0010\\\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\b\b\u0002\u0010i\u001a\u00020M2\b\b\u0002\u0010j\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010l\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u008f\u0001J=\u0010\u0097\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u0081\u0001J=\u0010\u0099\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u0081\u0001JQ\u0010\u009b\u0001\u001a\u00030\u009c\u0001*\u00030\u009c\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "defaultTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "FilledContainerBox", "OutlinedBorderContainerBox", "focusedBorderThickness", "unfocusedBorderThickness", "OutlinedBorderContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldColors", "textColor", "containerColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "placeholderColor", "outlinedTextFieldColors-eS1Emto", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-M37tBTI", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldColors", "textFieldColors-eS1Emto", "textFieldColors-M37tBTI", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.constructor-impl(56);
    private static final float MinWidth = Dp.constructor-impl(280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* renamed from: getFocusedBorderThickness-D9Ej5fM$annotations */
    public static /* synthetic */ void m3161getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations */
    public static /* synthetic */ void m3162getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1941327459);
        ComposerKt.sourceInformation(composer, "C58@2591L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:58)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM */
    public final float m3174getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM */
    public final float m3175getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM */
    public final float m3177getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM */
    public final float m3173getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00df, code lost:
    
        if ((r27 & 16) != 0) goto L176;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ContainerBox(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(918564008);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContainerBox)P(1,3,2)101@4199L5,105@4283L51,103@4222L203:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(interactionSource) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(textFieldColors) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i4 = Fields.Clip;
                    i3 |= i4;
                }
            } else {
                shape2 = shape;
            }
            i4 = Fields.Shape;
            i3 |= i4;
        } else {
            shape2 = shape;
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= startRestartGroup.changed(this) ? Fields.RenderEffect : 65536;
        }
        if ((74899 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if ((i2 & 16) != 0) {
                    shape2 = INSTANCE.getShape(startRestartGroup, 6);
                    i3 &= -57345;
                }
                Shape shape3 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(918564008, i3, -1, "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:102)");
                }
                shape2 = shape3;
                BoxKt.Box(m3163indicatorLinegv0btCI$default(this, BackgroundKt.m396backgroundbw27NRU(Modifier.INSTANCE, textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168)).getValue().m4849unboximpl(), shape3), z, z2, interactionSource, textFieldColors, 0.0f, 0.0f, 48, null), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Shape shape4 = shape2;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$ContainerBox$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    TextFieldDefaults.this.ContainerBox(z, z2, interactionSource, textFieldColors, shape4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* renamed from: indicatorLine-gv0btCI$default */
    public static /* synthetic */ Modifier m3163indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        return textFieldDefaults.m3178indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, (i & 16) != 0 ? FocusedIndicatorThickness : f, (i & 32) != 0 ? UnfocusedIndicatorThickness : f2);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m3159contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m3170contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4 */
    public final PaddingValues m3170contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m1060PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m3160contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3171contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4 */
    public final PaddingValues m3171contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1060PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default */
    public static /* synthetic */ PaddingValues m3165supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = Dp.constructor-impl(0);
        }
        return textFieldDefaults.m3182supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, f4);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release */
    public final PaddingValues m3182supportingTextPaddinga9UjIt4$material3_release(float start, float top, float end, float bottom) {
        return PaddingKt.m1060PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(831731228);
        ComposerKt.sourceInformation(composer, "C(colors)197@8134L11,197@8146L22:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:197)");
        }
        TextFieldColors defaultTextFieldColors = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: colors-0hiis_0 */
    public final TextFieldColors m3169colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        composer.startReplaceableGroup(1513344955);
        ComposerKt.sourceInformation(composer, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)298@14956L11,298@14968L22:TextFieldDefaults.kt#uh7d8r");
        long m4875getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
        long m4875getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j2;
        long m4875getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j3;
        long m4875getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j4;
        long m4875getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j5;
        long m4875getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j6;
        long m4875getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j7;
        long m4875getUnspecified0d7_KjU8 = (i6 & Fields.SpotShadowColor) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j8;
        long m4875getUnspecified0d7_KjU9 = (i6 & Fields.RotationX) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j9;
        long m4875getUnspecified0d7_KjU10 = (i6 & Fields.RotationY) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i6 & Fields.RotationZ) != 0 ? null : textSelectionColors;
        long m4875getUnspecified0d7_KjU11 = (i6 & Fields.CameraDistance) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j11;
        long m4875getUnspecified0d7_KjU12 = (i6 & Fields.TransformOrigin) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j12;
        long m4875getUnspecified0d7_KjU13 = (i6 & Fields.Shape) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j13;
        long m4875getUnspecified0d7_KjU14 = (i6 & Fields.Clip) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j14;
        long m4875getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j15;
        long m4875getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j16;
        long m4875getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j17;
        long m4875getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j18;
        long m4875getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j19;
        long m4875getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j20;
        long m4875getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j21;
        long m4875getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j22;
        long m4875getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j23;
        long m4875getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j24;
        long m4875getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j25;
        long m4875getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j26;
        long m4875getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j27;
        long m4875getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j28;
        long m4875getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j29;
        long m4875getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j30;
        long m4875getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j31;
        long m4875getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j32;
        long m4875getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j33;
        long m4875getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j34;
        long m4875getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j35;
        long m4875getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j36;
        long m4875getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j37;
        long m4875getUnspecified0d7_KjU38 = (i7 & Fields.SpotShadowColor) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j38;
        long m4875getUnspecified0d7_KjU39 = (i7 & Fields.RotationX) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j39;
        long m4875getUnspecified0d7_KjU40 = (i7 & Fields.RotationY) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j40;
        long m4875getUnspecified0d7_KjU41 = (i7 & Fields.RotationZ) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j41;
        long m4875getUnspecified0d7_KjU42 = (i7 & Fields.CameraDistance) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1513344955, i, i2, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:298)");
        }
        TextFieldColors m3115copyejIjP34 = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 >> 6) & 112).m3115copyejIjP34(m4875getUnspecified0d7_KjU, m4875getUnspecified0d7_KjU2, m4875getUnspecified0d7_KjU3, m4875getUnspecified0d7_KjU4, m4875getUnspecified0d7_KjU5, m4875getUnspecified0d7_KjU6, m4875getUnspecified0d7_KjU7, m4875getUnspecified0d7_KjU8, m4875getUnspecified0d7_KjU9, m4875getUnspecified0d7_KjU10, textSelectionColors2, m4875getUnspecified0d7_KjU11, m4875getUnspecified0d7_KjU12, m4875getUnspecified0d7_KjU13, m4875getUnspecified0d7_KjU14, m4875getUnspecified0d7_KjU15, m4875getUnspecified0d7_KjU16, m4875getUnspecified0d7_KjU17, m4875getUnspecified0d7_KjU18, m4875getUnspecified0d7_KjU19, m4875getUnspecified0d7_KjU20, m4875getUnspecified0d7_KjU21, m4875getUnspecified0d7_KjU22, m4875getUnspecified0d7_KjU23, m4875getUnspecified0d7_KjU24, m4875getUnspecified0d7_KjU25, m4875getUnspecified0d7_KjU26, m4875getUnspecified0d7_KjU27, m4875getUnspecified0d7_KjU28, m4875getUnspecified0d7_KjU29, m4875getUnspecified0d7_KjU30, m4875getUnspecified0d7_KjU31, m4875getUnspecified0d7_KjU32, m4875getUnspecified0d7_KjU33, m4875getUnspecified0d7_KjU34, m4875getUnspecified0d7_KjU35, m4875getUnspecified0d7_KjU36, m4875getUnspecified0d7_KjU37, m4875getUnspecified0d7_KjU38, m4875getUnspecified0d7_KjU39, m4875getUnspecified0d7_KjU40, m4875getUnspecified0d7_KjU41, m4875getUnspecified0d7_KjU42);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m3115copyejIjP34;
    }

    public final TextFieldColors getDefaultTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        composer.startReplaceableGroup(1341970309);
        ComposerKt.sourceInformation(composer, "C*359@18678L7:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341970309, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:346)");
        }
        TextFieldColors defaultTextFieldColorsCached = colorScheme.getDefaultTextFieldColorsCached();
        if (defaultTextFieldColorsCached == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputColor());
            long m4838copywmQWz5c$default = Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorInputColor());
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken6 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken7 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken8 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken9 = ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            defaultTextFieldColorsCached = new TextFieldColors(fromToken, fromToken2, m4838copywmQWz5c$default, fromToken3, fromToken4, fromToken5, fromToken6, fromToken7, fromToken8, fromToken9, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLabelColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getSupportingColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            colorScheme.setDefaultTextFieldColorsCached$material3_release(defaultTextFieldColorsCached);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColorsCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Shape shape2;
        TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Shape shape3;
        PaddingValues paddingValues3;
        int i17;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final boolean z5;
        TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(289640444);
        ComposerKt.sourceInformation(startRestartGroup, "C(DecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)487@27934L5,488@27975L8,499@28330L707:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i3 & 8;
                int i18 = Fields.CameraDistance;
                if (i5 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    i6 = i3 & 16;
                    int i19 = Fields.Shape;
                    if (i6 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                        if ((i3 & 32) != 0) {
                            i4 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i4 |= startRestartGroup.changed(interactionSource) ? Fields.RenderEffect : 65536;
                        }
                        i7 = i3 & 64;
                        if (i7 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                        }
                        i8 = i3 & Fields.SpotShadowColor;
                        if (i8 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        }
                        i9 = i3 & Fields.RotationX;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i10 = i3 & Fields.RotationY;
                        if (i10 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        }
                        i11 = i3 & Fields.RotationZ;
                        if (i11 != 0) {
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i12 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i12 = i2;
                        }
                        i13 = i3 & Fields.CameraDistance;
                        if (i13 != 0) {
                            i12 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i12 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        }
                        int i20 = i12;
                        i14 = i3 & Fields.TransformOrigin;
                        if (i14 != 0) {
                            i20 |= 384;
                        } else if ((i2 & 384) == 0) {
                            i20 |= startRestartGroup.changedInstance(function27) ? Fields.RotationX : Fields.SpotShadowColor;
                            i15 = i3 & Fields.Shape;
                            if (i15 == 0) {
                                i20 |= 3072;
                            } else if ((i2 & 3072) == 0) {
                                if (!startRestartGroup.changedInstance(function28)) {
                                    i18 = 1024;
                                }
                                i20 |= i18;
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(shape)) {
                                        i19 = 16384;
                                    }
                                    i20 |= i19;
                                }
                                if ((i2 & 196608) == 0) {
                                    i20 |= ((i3 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(textFieldColors)) ? Fields.RenderEffect : 65536;
                                }
                                if ((i2 & 1572864) == 0) {
                                    i20 |= ((i3 & 65536) == 0 && startRestartGroup.changed(paddingValues)) ? 1048576 : Fields.BlendMode;
                                }
                                i16 = i3 & Fields.RenderEffect;
                                if (i16 != 0) {
                                    i20 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i20 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                                }
                                if ((i3 & Fields.ColorFilter) != 0) {
                                    i20 |= 100663296;
                                } else if ((i2 & 100663296) == 0) {
                                    i20 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
                                }
                                if ((i4 & 306783379) == 306783378 || (38347923 & i20) != 38347922 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        z4 = i7 != 0 ? false : z3;
                                        function210 = i8 != 0 ? null : function22;
                                        function211 = i9 != 0 ? null : function23;
                                        function212 = i10 != 0 ? null : function24;
                                        function213 = i11 != 0 ? null : function25;
                                        function214 = i13 != 0 ? null : function26;
                                        function215 = i14 != 0 ? null : function27;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i15 == 0 ? function28 : null;
                                        if ((i3 & Fields.Clip) != 0) {
                                            shape2 = INSTANCE.getShape(startRestartGroup, 6);
                                            i20 &= -57345;
                                        } else {
                                            shape2 = shape;
                                        }
                                        if ((i3 & Fields.CompositingStrategy) != 0) {
                                            textFieldColors2 = colors(startRestartGroup, (i20 >> 24) & 14);
                                            i20 &= -458753;
                                        } else {
                                            textFieldColors2 = textFieldColors;
                                        }
                                        if ((i3 & 65536) != 0) {
                                            if (function210 == null) {
                                                paddingValues2 = m3160contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            } else {
                                                paddingValues2 = m3159contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            }
                                            i20 &= -3670017;
                                        } else {
                                            paddingValues2 = paddingValues;
                                        }
                                        if (i16 != 0) {
                                            final boolean z6 = z4;
                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                            final Shape shape5 = shape2;
                                            function213 = function213;
                                            function214 = function214;
                                            function216 = ComposableLambdaKt.composableLambda(startRestartGroup, -435523791, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$DecorationBox$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i21) {
                                                    ComposerKt.sourceInformation(composer2, "C496@28239L64:TextFieldDefaults.kt#uh7d8r");
                                                    if ((i21 & 3) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-435523791, i21, -1, "androidx.compose.material3.TextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:496)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.ContainerBox(z, z6, interactionSource, textFieldColors4, shape5, composer2, 196608, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            shape3 = shape2;
                                            function212 = function212;
                                        } else {
                                            function216 = function29;
                                            shape3 = shape2;
                                        }
                                        paddingValues3 = paddingValues2;
                                        i17 = i20;
                                        function217 = function225;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & Fields.Clip) != 0) {
                                            i20 &= -57345;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i20 &= -458753;
                                        }
                                        if ((i3 & 65536) != 0) {
                                            i20 &= -3670017;
                                        }
                                        z4 = z3;
                                        function210 = function22;
                                        function211 = function23;
                                        function212 = function24;
                                        function213 = function25;
                                        function214 = function26;
                                        function215 = function27;
                                        shape3 = shape;
                                        textFieldColors2 = textFieldColors;
                                        paddingValues3 = paddingValues;
                                        function216 = function29;
                                        i17 = i20;
                                        function217 = function28;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(289640444, i4, i17, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:498)");
                                    }
                                    int i21 = i4 << 3;
                                    int i22 = i4 >> 3;
                                    int i23 = i4 >> 9;
                                    int i24 = i17 << 21;
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i21 & 896) | (i21 & 112) | 6 | (i22 & 7168) | (i23 & 57344) | (i23 & 458752) | (i23 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i23 & 7168) | (57344 & i22) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    shape4 = shape3;
                                    function218 = function213;
                                    function219 = function214;
                                    function220 = function217;
                                    function221 = function215;
                                    z5 = z4;
                                    textFieldColors3 = textFieldColors2;
                                    function222 = function216;
                                    function223 = function212;
                                    function224 = function210;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    z5 = z3;
                                    function224 = function22;
                                    function211 = function23;
                                    function223 = function24;
                                    function218 = function25;
                                    function219 = function26;
                                    function221 = function27;
                                    function220 = function28;
                                    shape4 = shape;
                                    textFieldColors3 = textFieldColors;
                                    paddingValues3 = paddingValues;
                                    function222 = function29;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Function2<? super Composer, ? super Integer, Unit> function226 = function220;
                                    final Shape shape6 = shape4;
                                    final TextFieldColors textFieldColors5 = textFieldColors3;
                                    final PaddingValues paddingValues4 = paddingValues3;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$DecorationBox$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i25) {
                                            TextFieldDefaults.this.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z5, function224, function211, function223, function218, function219, function221, function226, shape6, textFieldColors5, paddingValues4, function222, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i2 & 24576) == 0) {
                            }
                            if ((i2 & 196608) == 0) {
                            }
                            if ((i2 & 1572864) == 0) {
                            }
                            i16 = i3 & Fields.RenderEffect;
                            if (i16 != 0) {
                            }
                            if ((i3 & Fields.ColorFilter) != 0) {
                            }
                            if ((i4 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 == 0) {
                            }
                            if ((i3 & Fields.Clip) != 0) {
                            }
                            if ((i3 & Fields.CompositingStrategy) != 0) {
                            }
                            if ((i3 & 65536) != 0) {
                            }
                            if (i16 != 0) {
                            }
                            paddingValues3 = paddingValues2;
                            i17 = i20;
                            function217 = function225;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i212 = i4 << 3;
                            int i222 = i4 >> 3;
                            int i232 = i4 >> 9;
                            int i242 = i17 << 21;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i212 & 896) | (i212 & 112) | 6 | (i222 & 7168) | (i232 & 57344) | (i232 & 458752) | (i232 & 3670016) | (i242 & 29360128) | (i242 & 234881024) | (i242 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i232 & 7168) | (57344 & i222) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            shape4 = shape3;
                            function218 = function213;
                            function219 = function214;
                            function220 = function217;
                            function221 = function215;
                            z5 = z4;
                            textFieldColors3 = textFieldColors2;
                            function222 = function216;
                            function223 = function212;
                            function224 = function210;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i15 = i3 & Fields.Shape;
                        if (i15 == 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & 196608) == 0) {
                        }
                        if ((i2 & 1572864) == 0) {
                        }
                        i16 = i3 & Fields.RenderEffect;
                        if (i16 != 0) {
                        }
                        if ((i3 & Fields.ColorFilter) != 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 == 0) {
                        }
                        if ((i3 & Fields.Clip) != 0) {
                        }
                        if ((i3 & Fields.CompositingStrategy) != 0) {
                        }
                        if ((i3 & 65536) != 0) {
                        }
                        if (i16 != 0) {
                        }
                        paddingValues3 = paddingValues2;
                        i17 = i20;
                        function217 = function225;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i2122 = i4 << 3;
                        int i2222 = i4 >> 3;
                        int i2322 = i4 >> 9;
                        int i2422 = i17 << 21;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i2122 & 896) | (i2122 & 112) | 6 | (i2222 & 7168) | (i2322 & 57344) | (i2322 & 458752) | (i2322 & 3670016) | (i2422 & 29360128) | (i2422 & 234881024) | (i2422 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i2322 & 7168) | (57344 & i2222) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape4 = shape3;
                        function218 = function213;
                        function219 = function214;
                        function220 = function217;
                        function221 = function215;
                        z5 = z4;
                        textFieldColors3 = textFieldColors2;
                        function222 = function216;
                        function223 = function212;
                        function224 = function210;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i3 & 32) != 0) {
                    }
                    i7 = i3 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i3 & Fields.SpotShadowColor;
                    if (i8 != 0) {
                    }
                    i9 = i3 & Fields.RotationX;
                    if (i9 != 0) {
                    }
                    i10 = i3 & Fields.RotationY;
                    if (i10 != 0) {
                    }
                    i11 = i3 & Fields.RotationZ;
                    if (i11 != 0) {
                    }
                    i13 = i3 & Fields.CameraDistance;
                    if (i13 != 0) {
                    }
                    int i202 = i12;
                    i14 = i3 & Fields.TransformOrigin;
                    if (i14 != 0) {
                    }
                    i15 = i3 & Fields.Shape;
                    if (i15 == 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & 196608) == 0) {
                    }
                    if ((i2 & 1572864) == 0) {
                    }
                    i16 = i3 & Fields.RenderEffect;
                    if (i16 != 0) {
                    }
                    if ((i3 & Fields.ColorFilter) != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 == 0) {
                    }
                    if ((i3 & Fields.Clip) != 0) {
                    }
                    if ((i3 & Fields.CompositingStrategy) != 0) {
                    }
                    if ((i3 & 65536) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    paddingValues3 = paddingValues2;
                    i17 = i202;
                    function217 = function225;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i21222 = i4 << 3;
                    int i22222 = i4 >> 3;
                    int i23222 = i4 >> 9;
                    int i24222 = i17 << 21;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i21222 & 896) | (i21222 & 112) | 6 | (i22222 & 7168) | (i23222 & 57344) | (i23222 & 458752) | (i23222 & 3670016) | (i24222 & 29360128) | (i24222 & 234881024) | (i24222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i23222 & 7168) | (57344 & i22222) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape3;
                    function218 = function213;
                    function219 = function214;
                    function220 = function217;
                    function221 = function215;
                    z5 = z4;
                    textFieldColors3 = textFieldColors2;
                    function222 = function216;
                    function223 = function212;
                    function224 = function210;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i6 = i3 & 16;
                int i192 = Fields.Shape;
                if (i6 == 0) {
                }
                if ((i3 & 32) != 0) {
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                }
                i8 = i3 & Fields.SpotShadowColor;
                if (i8 != 0) {
                }
                i9 = i3 & Fields.RotationX;
                if (i9 != 0) {
                }
                i10 = i3 & Fields.RotationY;
                if (i10 != 0) {
                }
                i11 = i3 & Fields.RotationZ;
                if (i11 != 0) {
                }
                i13 = i3 & Fields.CameraDistance;
                if (i13 != 0) {
                }
                int i2022 = i12;
                i14 = i3 & Fields.TransformOrigin;
                if (i14 != 0) {
                }
                i15 = i3 & Fields.Shape;
                if (i15 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & 196608) == 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                i16 = i3 & Fields.RenderEffect;
                if (i16 != 0) {
                }
                if ((i3 & Fields.ColorFilter) != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 == 0) {
                }
                if ((i3 & Fields.Clip) != 0) {
                }
                if ((i3 & Fields.CompositingStrategy) != 0) {
                }
                if ((i3 & 65536) != 0) {
                }
                if (i16 != 0) {
                }
                paddingValues3 = paddingValues2;
                i17 = i2022;
                function217 = function225;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i212222 = i4 << 3;
                int i222222 = i4 >> 3;
                int i232222 = i4 >> 9;
                int i242222 = i17 << 21;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i212222 & 896) | (i212222 & 112) | 6 | (i222222 & 7168) | (i232222 & 57344) | (i232222 & 458752) | (i232222 & 3670016) | (i242222 & 29360128) | (i242222 & 234881024) | (i242222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i232222 & 7168) | (57344 & i222222) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape4 = shape3;
                function218 = function213;
                function219 = function214;
                function220 = function217;
                function221 = function215;
                z5 = z4;
                textFieldColors3 = textFieldColors2;
                function222 = function216;
                function223 = function212;
                function224 = function210;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i5 = i3 & 8;
            int i182 = Fields.CameraDistance;
            if (i5 != 0) {
            }
            i6 = i3 & 16;
            int i1922 = Fields.Shape;
            if (i6 == 0) {
            }
            if ((i3 & 32) != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            i8 = i3 & Fields.SpotShadowColor;
            if (i8 != 0) {
            }
            i9 = i3 & Fields.RotationX;
            if (i9 != 0) {
            }
            i10 = i3 & Fields.RotationY;
            if (i10 != 0) {
            }
            i11 = i3 & Fields.RotationZ;
            if (i11 != 0) {
            }
            i13 = i3 & Fields.CameraDistance;
            if (i13 != 0) {
            }
            int i20222 = i12;
            i14 = i3 & Fields.TransformOrigin;
            if (i14 != 0) {
            }
            i15 = i3 & Fields.Shape;
            if (i15 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & 196608) == 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i16 = i3 & Fields.RenderEffect;
            if (i16 != 0) {
            }
            if ((i3 & Fields.ColorFilter) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 == 0) {
            }
            if ((i3 & Fields.Clip) != 0) {
            }
            if ((i3 & Fields.CompositingStrategy) != 0) {
            }
            if ((i3 & 65536) != 0) {
            }
            if (i16 != 0) {
            }
            paddingValues3 = paddingValues2;
            i17 = i20222;
            function217 = function225;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i2122222 = i4 << 3;
            int i2222222 = i4 >> 3;
            int i2322222 = i4 >> 9;
            int i2422222 = i17 << 21;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i2122222 & 896) | (i2122222 & 112) | 6 | (i2222222 & 7168) | (i2322222 & 57344) | (i2322222 & 458752) | (i2322222 & 3670016) | (i2422222 & 29360128) | (i2422222 & 234881024) | (i2422222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i2322222 & 7168) | (57344 & i2222222) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape3;
            function218 = function213;
            function219 = function214;
            function220 = function217;
            function221 = function215;
            z5 = z4;
            textFieldColors3 = textFieldColors2;
            function222 = function216;
            function223 = function212;
            function224 = function210;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        int i1822 = Fields.CameraDistance;
        if (i5 != 0) {
        }
        i6 = i3 & 16;
        int i19222 = Fields.Shape;
        if (i6 == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        i8 = i3 & Fields.SpotShadowColor;
        if (i8 != 0) {
        }
        i9 = i3 & Fields.RotationX;
        if (i9 != 0) {
        }
        i10 = i3 & Fields.RotationY;
        if (i10 != 0) {
        }
        i11 = i3 & Fields.RotationZ;
        if (i11 != 0) {
        }
        i13 = i3 & Fields.CameraDistance;
        if (i13 != 0) {
        }
        int i202222 = i12;
        i14 = i3 & Fields.TransformOrigin;
        if (i14 != 0) {
        }
        i15 = i3 & Fields.Shape;
        if (i15 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & 196608) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i16 = i3 & Fields.RenderEffect;
        if (i16 != 0) {
        }
        if ((i3 & Fields.ColorFilter) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 == 0) {
        }
        if ((i3 & Fields.Clip) != 0) {
        }
        if ((i3 & Fields.CompositingStrategy) != 0) {
        }
        if ((i3 & 65536) != 0) {
        }
        if (i16 != 0) {
        }
        paddingValues3 = paddingValues2;
        i17 = i202222;
        function217 = function225;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i21222222 = i4 << 3;
        int i22222222 = i4 >> 3;
        int i23222222 = i4 >> 9;
        int i24222222 = i17 << 21;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function2, visualTransformation, function210, function211, function212, function213, function214, function215, function217, z2, z, z4, interactionSource, paddingValues3, textFieldColors2, function216, startRestartGroup, (i21222222 & 896) | (i21222222 & 112) | 6 | (i22222222 & 7168) | (i23222222 & 57344) | (i23222222 & 458752) | (i23222222 & 3670016) | (i24222222 & 29360128) | (i24222222 & 234881024) | (i24222222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i23222222 & 7168) | (57344 & i22222222) | ((i17 >> 3) & 458752) | (3670016 & (i17 << 3)) | (i17 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape3;
        function218 = function213;
        function219 = function214;
        function220 = function217;
        function221 = function215;
        z5 = z4;
        textFieldColors3 = textFieldColors2;
        function222 = function216;
        function223 = function212;
        function224 = function210;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        composer.startReplaceableGroup(-584749279);
        ComposerKt.sourceInformation(composer, "C527@29387L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:527)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        composer.startReplaceableGroup(611926497);
        ComposerKt.sourceInformation(composer, "C534@29625L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:534)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM */
    public final float m3176getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM */
    public final float m3172getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e4, code lost:
    
        if ((r26 & 16) != 0) goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0051  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.ContainerBox`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n    )", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void FilledContainerBox(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        ScopeUpdateScope endRestartGroup;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1358797526);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledContainerBox)P(1,3,2)570@31126L5,571@31141L168:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(interactionSource) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(textFieldColors) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i4 = Fields.Clip;
                                i3 |= i4;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i4 = Fields.Shape;
                        i3 |= i4;
                    } else {
                        shape2 = shape;
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i3 |= startRestartGroup.changed(this) ? Fields.RenderEffect : 65536;
                    }
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if ((i2 & 16) != 0) {
                                shape2 = INSTANCE.getShape(startRestartGroup, 6);
                                i3 &= -57345;
                            }
                            Shape shape3 = shape2;
                            int i5 = i3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1358797526, i5, -1, "androidx.compose.material3.TextFieldDefaults.FilledContainerBox (TextFieldDefaults.kt:571)");
                            }
                            ContainerBox(z, z2, interactionSource, textFieldColors, shape3, startRestartGroup, (i5 & 14) | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape2 = shape3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Shape shape4 = shape2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i6) {
                                TextFieldDefaults.this.FilledContainerBox(z, z2, interactionSource, textFieldColors, shape4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i & 24576) != 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if ((74899 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                Shape shape32 = shape2;
                int i52 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ContainerBox(z, z2, interactionSource, textFieldColors, shape32, startRestartGroup, (i52 & 14) | (i52 & 112) | (i52 & 896) | (i52 & 7168) | (57344 & i52) | (i52 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape2 = shape32;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 8) != 0) {
            }
            if ((i & 24576) != 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if ((74899 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            Shape shape322 = shape2;
            int i522 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ContainerBox(z, z2, interactionSource, textFieldColors, shape322, startRestartGroup, (i522 & 14) | (i522 & 112) | (i522 & 896) | (i522 & 7168) | (57344 & i522) | (i522 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape2 = shape322;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        Shape shape3222 = shape2;
        int i5222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ContainerBox(z, z2, interactionSource, textFieldColors, shape3222, startRestartGroup, (i5222 & 14) | (i5222 & 112) | (i5222 & 896) | (i5222 & 7168) | (57344 & i5222) | (i5222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape2 = shape3222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0051  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.ContainerBox`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n        focusedBorderThickness = focusedBorderThickness,\n        unfocusedBorderThickness = unfocusedBorderThickness,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: OutlinedBorderContainerBox-nbWgWpA */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3168OutlinedBorderContainerBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        int i4;
        float f3;
        int i5;
        float f4;
        float m2773getFocusedBorderThicknessD9Ej5fM;
        int i6;
        float m2776getUnfocusedBorderThicknessD9Ej5fM;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1998946250);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedBorderContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)600@32285L5,603@32503L286:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(interactionSource) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(textFieldColors) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i7 = Fields.Clip;
                                i3 |= i7;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i7 = Fields.Shape;
                        i3 |= i7;
                    } else {
                        shape2 = shape;
                    }
                    i4 = i2 & 32;
                    if (i4 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        f3 = f;
                        i3 |= startRestartGroup.changed(f3) ? Fields.RenderEffect : 65536;
                        i5 = i2 & 64;
                        if (i5 != 0) {
                            i3 |= 1572864;
                        } else if ((1572864 & i) == 0) {
                            f4 = f2;
                            i3 |= startRestartGroup.changed(f4) ? 1048576 : Fields.BlendMode;
                            if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if ((i2 & 16) != 0) {
                                        shape2 = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                                        i3 &= -57345;
                                    }
                                    m2773getFocusedBorderThicknessD9Ej5fM = i4 == 0 ? OutlinedTextFieldDefaults.INSTANCE.m2773getFocusedBorderThicknessD9Ej5fM() : f3;
                                    if (i5 != 0) {
                                        i6 = i3;
                                        m2776getUnfocusedBorderThicknessD9Ej5fM = OutlinedTextFieldDefaults.INSTANCE.m2776getUnfocusedBorderThicknessD9Ej5fM();
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1998946250, i6, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox (TextFieldDefaults.kt:603)");
                                        }
                                        OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    m2773getFocusedBorderThicknessD9Ej5fM = f3;
                                }
                                i6 = i3;
                                m2776getUnfocusedBorderThicknessD9Ej5fM = f4;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                m2773getFocusedBorderThicknessD9Ej5fM = f3;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Shape shape3 = shape2;
                                final float f5 = m2773getFocusedBorderThicknessD9Ej5fM;
                                final float f6 = f4;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedBorderContainerBox$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i8) {
                                        TextFieldDefaults.this.m3168OutlinedBorderContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape3, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        f4 = f2;
                        if ((599187 & i3) == 599186) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        i6 = i3;
                        m2776getUnfocusedBorderThicknessD9Ej5fM = f4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    f3 = f;
                    i5 = i2 & 64;
                    if (i5 != 0) {
                    }
                    f4 = f2;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    i6 = i3;
                    m2776getUnfocusedBorderThicknessD9Ej5fM = f4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i & 24576) != 0) {
                }
                i4 = i2 & 32;
                if (i4 == 0) {
                }
                f3 = f;
                i5 = i2 & 64;
                if (i5 != 0) {
                }
                f4 = f2;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                i6 = i3;
                m2776getUnfocusedBorderThicknessD9Ej5fM = f4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 8) != 0) {
            }
            if ((i & 24576) != 0) {
            }
            i4 = i2 & 32;
            if (i4 == 0) {
            }
            f3 = f;
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            f4 = f2;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            i6 = i3;
            m2776getUnfocusedBorderThicknessD9Ej5fM = f4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        f4 = f2;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        i6 = i3;
        m2776getUnfocusedBorderThicknessD9Ej5fM = f4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, m2773getFocusedBorderThicknessD9Ej5fM, m2776getUnfocusedBorderThicknessD9Ej5fM, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f4 = m2776getUnfocusedBorderThicknessD9Ej5fM;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m3166textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m3185textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithLabelPadding-a9UjIt4 */
    public final PaddingValues m3185textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m3170contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m3167textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3186textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4 */
    public final PaddingValues m3186textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m3171contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m3164outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3181outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldPadding-a9UjIt4 */
    public final PaddingValues m3181outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m2772contentPaddinga9UjIt4(start, top, end, bottom);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.colors` with additional parameters to controlcontainer color based on state.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedIndicatorColor = focusedIndicatorColor,\n        unfocusedIndicatorColor = unfocusedIndicatorColor,\n        disabledIndicatorColor = disabledIndicatorColor,\n        errorIndicatorColor = errorIndicatorColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {}))
    /* renamed from: textFieldColors-M37tBTI */
    public final TextFieldColors m3183textFieldColorsM37tBTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        TextSelectionColors textSelectionColors2;
        int i8;
        long j41;
        int i9;
        long j42;
        int i10;
        long j43;
        int i11;
        long j44;
        int i12;
        long j45;
        int i13;
        long j46;
        int i14;
        long j47;
        int i15;
        long j48;
        composer.startReplaceableGroup(568209592);
        ComposerKt.sourceInformation(composer, "C(textFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)733@38609L5,734@38685L5,735@38768L5,737@38915L5,738@38991L5,739@39072L5,740@39141L5,741@39225L5,742@39304L7,743@39400L5,744@39491L5,745@39589L5,747@39761L5,748@39853L5,749@39942L5,750@40038L5,752@40204L5,753@40298L5,754@40389L5,755@40487L5,757@40656L5,758@40736L5,759@40813L5,760@40897L5,762@41045L5,763@41137L5,764@41231L5,765@41321L5,767@41481L5,768@41575L5,769@41666L5,770@41764L5,772@41931L5,773@42013L5,774@42097L5,775@42180L5,777@42330L5,778@42412L5,779@42496L5,780@42579L5,782@42729L5,783@42761L2308:TextFieldDefaults.kt#uh7d8r");
        long value = (i6 & 1) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusInputColor(), composer, 6) : j;
        long value2 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j2;
        long m4838copywmQWz5c$default = (i6 & 4) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorInputColor(), composer, 6) : j4;
        long value4 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer, 6) : j5;
        long value5 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer, 6) : j6;
        long value6 = (i6 & 64) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j7;
        long value7 = (i6 & Fields.SpotShadowColor) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j8;
        if ((i6 & Fields.RotationX) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i6 & Fields.RotationY) != 0) {
            i8 = 6;
            j41 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), composer, 6);
        } else {
            i8 = 6;
            j41 = j9;
        }
        long value8 = (i6 & Fields.RotationZ) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), composer, i8) : j10;
        long m4838copywmQWz5c$default2 = (i6 & Fields.CameraDistance) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), composer, i8), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if ((i6 & Fields.TransformOrigin) != 0) {
            i9 = 6;
            j42 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), composer, 6);
        } else {
            i9 = 6;
            j42 = j12;
        }
        long value9 = (i6 & Fields.Shape) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, i9) : j13;
        long value10 = (i6 & Fields.Clip) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, i9) : j14;
        long m4838copywmQWz5c$default3 = (32768 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, i9), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((65536 & i6) != 0) {
            i10 = 6;
            j43 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6);
        } else {
            i10 = 6;
            j43 = j16;
        }
        long value11 = (131072 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, i10) : j17;
        long value12 = (262144 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, i10) : j18;
        long m4838copywmQWz5c$default4 = (524288 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, i10), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((1048576 & i6) != 0) {
            i11 = 6;
            j44 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6);
        } else {
            i11 = 6;
            j44 = j20;
        }
        long value13 = (2097152 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, i11) : j21;
        long value14 = (4194304 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLabelColor(), composer, i11) : j22;
        long m4838copywmQWz5c$default5 = (8388608 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, i11), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if ((16777216 & i6) != 0) {
            i12 = 6;
            j45 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6);
        } else {
            i12 = 6;
            j45 = j24;
        }
        long value15 = (33554432 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, i12) : j25;
        long value16 = (67108864 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, i12) : j26;
        long m4838copywmQWz5c$default6 = (134217728 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, i12), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j27;
        if ((268435456 & i6) != 0) {
            i13 = 6;
            j46 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6);
        } else {
            i13 = 6;
            j46 = j28;
        }
        long value17 = (536870912 & i6) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, i13) : j29;
        long value18 = (i6 & 1073741824) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getSupportingColor(), composer, i13) : j30;
        long m4838copywmQWz5c$default7 = (i7 & 1) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, i13), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j31;
        if ((i7 & 2) != 0) {
            i14 = 6;
            j47 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6);
        } else {
            i14 = 6;
            j47 = j32;
        }
        long value19 = (i7 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, i14) : j33;
        long value20 = (i7 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, i14) : j34;
        long m4838copywmQWz5c$default8 = (i7 & 16) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, i14), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j35;
        if ((i7 & 32) != 0) {
            i15 = 6;
            j48 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6);
        } else {
            i15 = 6;
            j48 = j36;
        }
        long value21 = (i7 & 64) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, i15) : j37;
        long value22 = (i7 & Fields.SpotShadowColor) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, i15) : j38;
        long m4838copywmQWz5c$default9 = (i7 & Fields.RotationX) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, i15), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j39;
        long value23 = (i7 & Fields.RotationY) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j40;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(568209592, i, i2, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:783)");
        }
        int i16 = i << 6;
        int i17 = i >> 24;
        int i18 = i2 << 6;
        int i19 = (i17 & 112) | (i17 & 14) | (i18 & 896) | (i18 & 7168) | (i18 & 57344) | (i18 & 458752) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024) | (i18 & 1879048192);
        int i20 = i2 >> 24;
        int i21 = i3 << 6;
        int i22 = (i20 & 112) | (i20 & 14) | (i21 & 896) | (i21 & 7168) | (i21 & 57344) | (i21 & 458752) | (i21 & 3670016) | (i21 & 29360128) | (i21 & 234881024) | (i21 & 1879048192);
        int i23 = i3 >> 24;
        int i24 = i4 << 6;
        int i25 = (i23 & 112) | (i23 & 14) | (i24 & 896) | (i24 & 7168) | (i24 & 57344) | (i24 & 458752) | (i24 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192);
        int i26 = i4 >> 24;
        int i27 = i5 << 6;
        TextFieldColors m3169colors0hiis_0 = m3169colors0hiis_0(value, value2, m4838copywmQWz5c$default, value3, value4, value4, value4, value5, value6, value7, textSelectionColors2, j41, value8, m4838copywmQWz5c$default2, j42, value9, value10, m4838copywmQWz5c$default3, j43, value11, value12, m4838copywmQWz5c$default4, j44, value13, value14, m4838copywmQWz5c$default5, j45, value15, value16, m4838copywmQWz5c$default6, j46, value17, value18, m4838copywmQWz5c$default7, j47, value19, value20, m4838copywmQWz5c$default8, j48, value21, value22, m4838copywmQWz5c$default9, value23, composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168) | (i & 57344) | ((i << 3) & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), i19, i22, i25, (i26 & 112) | (i26 & 14) | (i27 & 896) | (i27 & 7168), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m3169colors0hiis_0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.colors` with additional parameters tocontrol container color based on state.", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedBorderColor = focusedBorderColor,\n        unfocusedBorderColor = unfocusedBorderColor,\n        disabledBorderColor = disabledBorderColor,\n        errorBorderColor = errorBorderColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldColors-M37tBTI */
    public final TextFieldColors m3179outlinedTextFieldColorsM37tBTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        TextSelectionColors textSelectionColors2;
        int i8;
        long j41;
        int i9;
        long j42;
        int i10;
        long j43;
        int i11;
        long j44;
        int i12;
        long j45;
        int i13;
        long j46;
        int i14;
        long j47;
        int i15;
        long j48;
        composer.startReplaceableGroup(618732090);
        ComposerKt.sourceInformation(composer, "C(outlinedTextFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,13:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)883@48650L5,884@48728L5,885@48813L5,887@48964L5,890@49142L5,891@49228L5,892@49307L7,893@49394L5,894@49476L5,895@49565L5,897@49722L5,898@49816L5,899@49907L5,900@50005L5,902@50175L5,903@50271L5,904@50364L5,906@50477L5,907@50637L5,908@50719L5,909@50798L5,910@50884L5,912@51036L5,913@51130L5,914@51226L5,915@51318L5,917@51482L5,918@51578L5,919@51671L5,921@51784L5,922@51942L5,923@52026L5,924@52112L5,925@52197L5,927@52351L5,928@52435L5,929@52521L5,930@52606L5,932@52760L5,933@52818L2284:TextFieldDefaults.kt#uh7d8r");
        long value = (i6 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusInputColor(), composer, 6) : j;
        long value2 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j2;
        long m4838copywmQWz5c$default = (i6 & 4) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorInputColor(), composer, 6) : j4;
        long m4874getTransparent0d7_KjU = (i6 & 16) != 0 ? Color.INSTANCE.m4874getTransparent0d7_KjU() : j5;
        long m4874getTransparent0d7_KjU2 = (i6 & 32) != 0 ? Color.INSTANCE.m4874getTransparent0d7_KjU() : j6;
        long value4 = (i6 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j7;
        long value5 = (i6 & Fields.SpotShadowColor) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j8;
        if ((i6 & Fields.RotationX) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i6 & Fields.RotationY) != 0) {
            i8 = 6;
            j41 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), composer, 6);
        } else {
            i8 = 6;
            j41 = j9;
        }
        long value6 = (i6 & Fields.RotationZ) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), composer, i8) : j10;
        long m4838copywmQWz5c$default2 = (i6 & Fields.CameraDistance) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), composer, i8), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if ((i6 & Fields.TransformOrigin) != 0) {
            i9 = 6;
            j42 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), composer, 6);
        } else {
            i9 = 6;
            j42 = j12;
        }
        long value7 = (i6 & Fields.Shape) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, i9) : j13;
        long value8 = (i6 & Fields.Clip) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, i9) : j14;
        long m4838copywmQWz5c$default3 = (32768 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, i9), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((65536 & i6) != 0) {
            i10 = 6;
            j43 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6);
        } else {
            i10 = 6;
            j43 = j16;
        }
        long value9 = (131072 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, i10) : j17;
        long value10 = (262144 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, i10) : j18;
        long m4838copywmQWz5c$default4 = (524288 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, i10), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((1048576 & i6) != 0) {
            i11 = 6;
            j44 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6);
        } else {
            i11 = 6;
            j44 = j20;
        }
        long value11 = (2097152 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, i11) : j21;
        long value12 = (4194304 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), composer, i11) : j22;
        long m4838copywmQWz5c$default5 = (8388608 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, i11), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if ((16777216 & i6) != 0) {
            i12 = 6;
            j45 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6);
        } else {
            i12 = 6;
            j45 = j24;
        }
        long value13 = (33554432 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, i12) : j25;
        long value14 = (67108864 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, i12) : j26;
        long m4838copywmQWz5c$default6 = (134217728 & i6) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, i12), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j27;
        if ((268435456 & i6) != 0) {
            i13 = 6;
            j46 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6);
        } else {
            i13 = 6;
            j46 = j28;
        }
        long value15 = (536870912 & i6) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, i13) : j29;
        long value16 = (i6 & 1073741824) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), composer, i13) : j30;
        long m4838copywmQWz5c$default7 = (i7 & 1) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, i13), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j31;
        if ((i7 & 2) != 0) {
            i14 = 6;
            j47 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6);
        } else {
            i14 = 6;
            j47 = j32;
        }
        long value17 = (i7 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, i14) : j33;
        long value18 = (i7 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, i14) : j34;
        long m4838copywmQWz5c$default8 = (i7 & 16) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, i14), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j35;
        if ((i7 & 32) != 0) {
            i15 = 6;
            j48 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6);
        } else {
            i15 = 6;
            j48 = j36;
        }
        long value19 = (i7 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, i15) : j37;
        long value20 = (i7 & Fields.SpotShadowColor) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, i15) : j38;
        long m4838copywmQWz5c$default9 = (i7 & Fields.RotationX) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, i15), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j39;
        long value21 = (i7 & Fields.RotationY) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j40;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618732090, i, i2, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:933)");
        }
        int i16 = i << 6;
        int i17 = i >> 24;
        int i18 = i2 << 6;
        int i19 = (i17 & 112) | (i17 & 14) | (i18 & 896) | (i18 & 7168) | (i18 & 57344) | (i18 & 458752) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024) | (i18 & 1879048192);
        int i20 = i2 >> 24;
        int i21 = i3 << 6;
        int i22 = (i20 & 112) | (i20 & 14) | (i21 & 896) | (i21 & 7168) | (i21 & 57344) | (i21 & 458752) | (i21 & 3670016) | (i21 & 29360128) | (i21 & 234881024) | (i21 & 1879048192);
        int i23 = i3 >> 24;
        int i24 = i4 << 6;
        int i25 = (i23 & 112) | (i23 & 14) | (i24 & 896) | (i24 & 7168) | (i24 & 57344) | (i24 & 458752) | (i24 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192);
        int i26 = i4 >> 24;
        TextFieldColors m2771colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m2771colors0hiis_0(value, value2, m4838copywmQWz5c$default, value3, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU2, value4, value5, textSelectionColors2, j41, value6, m4838copywmQWz5c$default2, j42, value7, value8, m4838copywmQWz5c$default3, j43, value9, value10, m4838copywmQWz5c$default4, j44, value11, value12, m4838copywmQWz5c$default5, j45, value13, value14, m4838copywmQWz5c$default6, j46, value15, value16, m4838copywmQWz5c$default7, j47, value17, value18, m4838copywmQWz5c$default8, j48, value19, value20, m4838copywmQWz5c$default9, value21, composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168) | (i & 57344) | ((i << 3) & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), i19, i22, i25, (i26 & 112) | (i26 & 14) | 3072 | ((i5 << 6) & 896), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2771colors0hiis_0;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x027d  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.DecorationBox`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        shape = shape,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Shape shape2;
        TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Shape shape3;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Function2<? super Composer, ? super Integer, Unit> function217;
        TextFieldColors textFieldColors3;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function218;
        Function2<? super Composer, ? super Integer, Unit> function219;
        PaddingValues paddingValues3;
        Composer composer2;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        final Function2<? super Composer, ? super Integer, Unit> function225;
        final Function2<? super Composer, ? super Integer, Unit> function226;
        final Shape shape4;
        final TextFieldColors textFieldColors4;
        final PaddingValues paddingValues4;
        final Function2<? super Composer, ? super Integer, Unit> function227;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1042273141);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldDecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)1020@56995L5,1021@57036L8,1031@57383L612:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i16 = i3 & 8;
        int i17 = Fields.CameraDistance;
        if (i16 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
            i5 = i3 & 16;
            int i18 = Fields.Shape;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changed(interactionSource) ? Fields.RenderEffect : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                }
                i7 = i3 & Fields.SpotShadowColor;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                i8 = i3 & Fields.RotationX;
                if (i8 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                }
                i9 = i3 & Fields.RotationY;
                if (i9 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                }
                i10 = i3 & Fields.RotationZ;
                if (i10 != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    i11 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                } else {
                    i11 = i2;
                }
                i12 = i3 & Fields.CameraDistance;
                if (i12 != 0) {
                    i11 |= 48;
                } else if ((i2 & 48) == 0) {
                    i11 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                }
                int i19 = i11;
                i13 = i3 & Fields.TransformOrigin;
                if (i13 != 0) {
                    i19 |= 384;
                } else if ((i2 & 384) == 0) {
                    i19 |= startRestartGroup.changedInstance(function27) ? Fields.RotationX : Fields.SpotShadowColor;
                    i14 = i3 & Fields.Shape;
                    if (i14 == 0) {
                        i19 |= 3072;
                    } else if ((i2 & 3072) == 0) {
                        if (!startRestartGroup.changedInstance(function28)) {
                            i17 = 1024;
                        }
                        i19 |= i17;
                        if ((i2 & 24576) == 0) {
                            if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(shape)) {
                                i18 = 16384;
                            }
                            i19 |= i18;
                        }
                        if ((i2 & 196608) == 0) {
                            i19 |= ((i3 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(textFieldColors)) ? Fields.RenderEffect : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            i19 |= ((i3 & 65536) == 0 && startRestartGroup.changed(paddingValues)) ? 1048576 : Fields.BlendMode;
                        }
                        i15 = i3 & Fields.RenderEffect;
                        if (i15 != 0) {
                            i19 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i19 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                        if ((i3 & Fields.ColorFilter) != 0) {
                            i19 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i19 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
                        }
                        if ((i4 & 306783379) == 306783378 || (38347923 & i19) != 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                boolean z6 = i6 != 0 ? false : z3;
                                Function2<? super Composer, ? super Integer, Unit> function228 = i7 != 0 ? null : function22;
                                Function2<? super Composer, ? super Integer, Unit> function229 = i8 != 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function230 = i9 != 0 ? null : function24;
                                Function2<? super Composer, ? super Integer, Unit> function231 = i10 != 0 ? null : function25;
                                Function2<? super Composer, ? super Integer, Unit> function232 = i12 != 0 ? null : function26;
                                Function2<? super Composer, ? super Integer, Unit> function233 = i13 != 0 ? null : function27;
                                Function2<? super Composer, ? super Integer, Unit> function234 = i14 == 0 ? function28 : null;
                                if ((i3 & Fields.Clip) != 0) {
                                    function210 = function230;
                                    shape2 = INSTANCE.getShape(startRestartGroup, 6);
                                    i19 &= -57345;
                                } else {
                                    function210 = function230;
                                    shape2 = shape;
                                }
                                if ((32768 & i3) != 0) {
                                    textFieldColors2 = colors(startRestartGroup, (i19 >> 24) & 14);
                                    i19 &= -458753;
                                } else {
                                    textFieldColors2 = textFieldColors;
                                }
                                if ((i3 & 65536) != 0) {
                                    if (function228 == null) {
                                        paddingValues2 = m3160contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    } else {
                                        paddingValues2 = m3159contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    }
                                    i19 &= -3670017;
                                } else {
                                    paddingValues2 = paddingValues;
                                }
                                if (i15 != 0) {
                                    function211 = function231;
                                    final boolean z7 = z6;
                                    final TextFieldColors textFieldColors5 = textFieldColors2;
                                    final Shape shape5 = shape2;
                                    shape3 = shape2;
                                    function212 = function232;
                                    function214 = function210;
                                    function213 = ComposableLambdaKt.composableLambda(startRestartGroup, 2023266550, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i20) {
                                            ComposerKt.sourceInformation(composer3, "C1029@57300L64:TextFieldDefaults.kt#uh7d8r");
                                            if ((i20 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2023266550, i20, -1, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:1029)");
                                            }
                                            TextFieldDefaults.INSTANCE.ContainerBox(z, z7, interactionSource, textFieldColors5, shape5, composer3, 196608, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    function211 = function231;
                                    shape3 = shape2;
                                    function212 = function232;
                                    function213 = function29;
                                    function214 = function210;
                                }
                                function215 = function228;
                                function216 = function229;
                                function217 = function233;
                                textFieldColors3 = textFieldColors2;
                                z4 = z6;
                                function218 = function234;
                                function219 = function211;
                                paddingValues3 = paddingValues2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & Fields.Clip) != 0) {
                                    i19 &= -57345;
                                }
                                if ((32768 & i3) != 0) {
                                    i19 &= -458753;
                                }
                                if ((i3 & 65536) != 0) {
                                    i19 &= -3670017;
                                }
                                z4 = z3;
                                function215 = function22;
                                function216 = function23;
                                function214 = function24;
                                function219 = function25;
                                function212 = function26;
                                function217 = function27;
                                function218 = function28;
                                shape3 = shape;
                                textFieldColors3 = textFieldColors;
                                paddingValues3 = paddingValues;
                                function213 = function29;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1042273141, i4, i19, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:1031)");
                            }
                            composer2 = startRestartGroup;
                            DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function214, function219, function212, function217, function218, shape3, textFieldColors3, paddingValues3, function213, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i19 & 14) | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (234881024 & i19), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z4;
                            function220 = function215;
                            function221 = function216;
                            function222 = function214;
                            function223 = function219;
                            function224 = function212;
                            function225 = function217;
                            function226 = function218;
                            shape4 = shape3;
                            textFieldColors4 = textFieldColors3;
                            paddingValues4 = paddingValues3;
                            function227 = function213;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z5 = z3;
                            function220 = function22;
                            function221 = function23;
                            function223 = function25;
                            function224 = function26;
                            function225 = function27;
                            function226 = function28;
                            shape4 = shape;
                            textFieldColors4 = textFieldColors;
                            paddingValues4 = paddingValues;
                            function227 = function29;
                            composer2 = startRestartGroup;
                            function222 = function24;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i20) {
                                    TextFieldDefaults.this.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z5, function220, function221, function222, function223, function224, function225, function226, shape4, textFieldColors4, paddingValues4, function227, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & 196608) == 0) {
                    }
                    if ((i2 & 1572864) == 0) {
                    }
                    i15 = i3 & Fields.RenderEffect;
                    if (i15 != 0) {
                    }
                    if ((i3 & Fields.ColorFilter) != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if ((i3 & Fields.Clip) != 0) {
                    }
                    if ((32768 & i3) != 0) {
                    }
                    if ((i3 & 65536) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    function215 = function228;
                    function216 = function229;
                    function217 = function233;
                    textFieldColors3 = textFieldColors2;
                    z4 = z6;
                    function218 = function234;
                    function219 = function211;
                    paddingValues3 = paddingValues2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function214, function219, function212, function217, function218, shape3, textFieldColors3, paddingValues3, function213, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i19 & 14) | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (234881024 & i19), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z5 = z4;
                    function220 = function215;
                    function221 = function216;
                    function222 = function214;
                    function223 = function219;
                    function224 = function212;
                    function225 = function217;
                    function226 = function218;
                    shape4 = shape3;
                    textFieldColors4 = textFieldColors3;
                    paddingValues4 = paddingValues3;
                    function227 = function213;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i14 = i3 & Fields.Shape;
                if (i14 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & 196608) == 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                i15 = i3 & Fields.RenderEffect;
                if (i15 != 0) {
                }
                if ((i3 & Fields.ColorFilter) != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 == 0) {
                }
                if ((i3 & Fields.Clip) != 0) {
                }
                if ((32768 & i3) != 0) {
                }
                if ((i3 & 65536) != 0) {
                }
                if (i15 != 0) {
                }
                function215 = function228;
                function216 = function229;
                function217 = function233;
                textFieldColors3 = textFieldColors2;
                z4 = z6;
                function218 = function234;
                function219 = function211;
                paddingValues3 = paddingValues2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function214, function219, function212, function217, function218, shape3, textFieldColors3, paddingValues3, function213, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i19 & 14) | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (234881024 & i19), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z4;
                function220 = function215;
                function221 = function216;
                function222 = function214;
                function223 = function219;
                function224 = function212;
                function225 = function217;
                function226 = function218;
                shape4 = shape3;
                textFieldColors4 = textFieldColors3;
                paddingValues4 = paddingValues3;
                function227 = function213;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i3 & 32) != 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & Fields.SpotShadowColor;
            if (i7 != 0) {
            }
            i8 = i3 & Fields.RotationX;
            if (i8 != 0) {
            }
            i9 = i3 & Fields.RotationY;
            if (i9 != 0) {
            }
            i10 = i3 & Fields.RotationZ;
            if (i10 != 0) {
            }
            i12 = i3 & Fields.CameraDistance;
            if (i12 != 0) {
            }
            int i192 = i11;
            i13 = i3 & Fields.TransformOrigin;
            if (i13 != 0) {
            }
            i14 = i3 & Fields.Shape;
            if (i14 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & 196608) == 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i15 = i3 & Fields.RenderEffect;
            if (i15 != 0) {
            }
            if ((i3 & Fields.ColorFilter) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 == 0) {
            }
            if ((i3 & Fields.Clip) != 0) {
            }
            if ((32768 & i3) != 0) {
            }
            if ((i3 & 65536) != 0) {
            }
            if (i15 != 0) {
            }
            function215 = function228;
            function216 = function229;
            function217 = function233;
            textFieldColors3 = textFieldColors2;
            z4 = z6;
            function218 = function234;
            function219 = function211;
            paddingValues3 = paddingValues2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function214, function219, function212, function217, function218, shape3, textFieldColors3, paddingValues3, function213, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i192 & 14) | (i192 & 112) | (i192 & 896) | (i192 & 7168) | (57344 & i192) | (458752 & i192) | (3670016 & i192) | (29360128 & i192) | (234881024 & i192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z4;
            function220 = function215;
            function221 = function216;
            function222 = function214;
            function223 = function219;
            function224 = function212;
            function225 = function217;
            function226 = function218;
            shape4 = shape3;
            textFieldColors4 = textFieldColors3;
            paddingValues4 = paddingValues3;
            function227 = function213;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 16;
        int i182 = Fields.Shape;
        if (i5 == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & Fields.SpotShadowColor;
        if (i7 != 0) {
        }
        i8 = i3 & Fields.RotationX;
        if (i8 != 0) {
        }
        i9 = i3 & Fields.RotationY;
        if (i9 != 0) {
        }
        i10 = i3 & Fields.RotationZ;
        if (i10 != 0) {
        }
        i12 = i3 & Fields.CameraDistance;
        if (i12 != 0) {
        }
        int i1922 = i11;
        i13 = i3 & Fields.TransformOrigin;
        if (i13 != 0) {
        }
        i14 = i3 & Fields.Shape;
        if (i14 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & 196608) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i15 = i3 & Fields.RenderEffect;
        if (i15 != 0) {
        }
        if ((i3 & Fields.ColorFilter) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 == 0) {
        }
        if ((i3 & Fields.Clip) != 0) {
        }
        if ((32768 & i3) != 0) {
        }
        if ((i3 & 65536) != 0) {
        }
        if (i15 != 0) {
        }
        function215 = function228;
        function216 = function229;
        function217 = function233;
        textFieldColors3 = textFieldColors2;
        z4 = z6;
        function218 = function234;
        function219 = function211;
        paddingValues3 = paddingValues2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function214, function219, function212, function217, function218, shape3, textFieldColors3, paddingValues3, function213, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i1922 & 14) | (i1922 & 112) | (i1922 & 896) | (i1922 & 7168) | (57344 & i1922) | (458752 & i1922) | (3670016 & i1922) | (29360128 & i1922) | (234881024 & i1922), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z4;
        function220 = function215;
        function221 = function216;
        function222 = function214;
        function223 = function219;
        function224 = function212;
        function225 = function217;
        function226 = function218;
        shape4 = shape3;
        textFieldColors4 = textFieldColors3;
        paddingValues4 = paddingValues3;
        function227 = function213;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0273  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.DecorationBox`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OutlinedTextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Function2<? super Composer, ? super Integer, Unit> function210;
        final TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Function2<? super Composer, ? super Integer, Unit> function217;
        PaddingValues paddingValues3;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function218;
        TextFieldColors textFieldColors4;
        Composer composer2;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        final Function2<? super Composer, ? super Integer, Unit> function225;
        final TextFieldColors textFieldColors5;
        final PaddingValues paddingValues4;
        final Function2<? super Composer, ? super Integer, Unit> function226;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-789275592);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldDecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1093@59957L8,1098@60237L589:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i16 = i3 & 8;
        int i17 = Fields.CameraDistance;
        if (i16 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
            i5 = i3 & 16;
            int i18 = Fields.Shape;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changed(interactionSource) ? Fields.RenderEffect : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                }
                i7 = i3 & Fields.SpotShadowColor;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                i8 = i3 & Fields.RotationX;
                if (i8 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                }
                i9 = i3 & Fields.RotationY;
                if (i9 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                }
                i10 = i3 & Fields.RotationZ;
                if (i10 != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    i11 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                } else {
                    i11 = i2;
                }
                i12 = i3 & Fields.CameraDistance;
                if (i12 != 0) {
                    i11 |= 48;
                } else if ((i2 & 48) == 0) {
                    i11 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                }
                int i19 = i11;
                i13 = i3 & Fields.TransformOrigin;
                if (i13 != 0) {
                    i19 |= 384;
                } else if ((i2 & 384) == 0) {
                    i19 |= startRestartGroup.changedInstance(function27) ? Fields.RotationX : Fields.SpotShadowColor;
                    i14 = i3 & Fields.Shape;
                    if (i14 == 0) {
                        i19 |= 3072;
                    } else if ((i2 & 3072) == 0) {
                        if (!startRestartGroup.changedInstance(function28)) {
                            i17 = 1024;
                        }
                        i19 |= i17;
                        if ((i2 & 24576) == 0) {
                            if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(textFieldColors)) {
                                i18 = 16384;
                            }
                            i19 |= i18;
                        }
                        if ((i2 & 196608) == 0) {
                            i19 |= ((i3 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(paddingValues)) ? Fields.RenderEffect : 65536;
                        }
                        i15 = i3 & 65536;
                        if (i15 != 0) {
                            i19 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i19 |= startRestartGroup.changedInstance(function29) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i4 & 306783379) == 306783378 || (599187 & i19) != 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                final boolean z6 = i6 != 0 ? false : z3;
                                Function2<? super Composer, ? super Integer, Unit> function227 = i7 != 0 ? null : function22;
                                Function2<? super Composer, ? super Integer, Unit> function228 = i8 != 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function229 = i9 != 0 ? null : function24;
                                Function2<? super Composer, ? super Integer, Unit> function230 = i10 != 0 ? null : function25;
                                Function2<? super Composer, ? super Integer, Unit> function231 = i12 != 0 ? null : function26;
                                Function2<? super Composer, ? super Integer, Unit> function232 = i13 != 0 ? null : function27;
                                Function2<? super Composer, ? super Integer, Unit> function233 = i14 == 0 ? function28 : null;
                                if ((i3 & Fields.Clip) != 0) {
                                    function210 = function229;
                                    textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    i19 &= -57345;
                                } else {
                                    function210 = function229;
                                    textFieldColors2 = textFieldColors;
                                }
                                if ((i3 & Fields.CompositingStrategy) != 0) {
                                    paddingValues2 = OutlinedTextFieldDefaults.m2769contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -458753;
                                } else {
                                    paddingValues2 = paddingValues;
                                }
                                if (i15 != 0) {
                                    textFieldColors3 = textFieldColors2;
                                    function211 = function210;
                                    function212 = function230;
                                    function213 = function231;
                                    function214 = ComposableLambdaKt.composableLambda(startRestartGroup, -1153197597, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i20) {
                                            ComposerKt.sourceInformation(composer3, "C1096@60135L57:TextFieldDefaults.kt#uh7d8r");
                                            if ((i20 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1153197597, i20, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:1096)");
                                            }
                                            OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z6, interactionSource, textFieldColors2, null, 0.0f, 0.0f, composer3, 12582912, 112);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    textFieldColors3 = textFieldColors2;
                                    function211 = function210;
                                    function212 = function230;
                                    function213 = function231;
                                    function214 = function29;
                                }
                                function215 = function227;
                                function216 = function228;
                                function217 = function232;
                                paddingValues3 = paddingValues2;
                                z4 = z6;
                                function218 = function233;
                                textFieldColors4 = textFieldColors3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & Fields.Clip) != 0) {
                                    i19 &= -57345;
                                }
                                if ((i3 & Fields.CompositingStrategy) != 0) {
                                    i19 &= -458753;
                                }
                                z4 = z3;
                                function215 = function22;
                                function216 = function23;
                                function211 = function24;
                                function212 = function25;
                                function213 = function26;
                                function217 = function27;
                                function218 = function28;
                                textFieldColors4 = textFieldColors;
                                paddingValues3 = paddingValues;
                                function214 = function29;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-789275592, i4, i19, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:1098)");
                            }
                            int i20 = i4;
                            composer2 = startRestartGroup;
                            OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function211, function212, function213, function217, function218, textFieldColors4, paddingValues3, function214, composer2, (i20 & 14) | (i20 & 112) | (i20 & 896) | (i20 & 7168) | (57344 & i20) | (458752 & i20) | (3670016 & i20) | (29360128 & i20) | (234881024 & i20) | (i20 & 1879048192), (i19 & 14) | 12582912 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z4;
                            function219 = function215;
                            function220 = function216;
                            function221 = function211;
                            function222 = function212;
                            function223 = function213;
                            function224 = function217;
                            function225 = function218;
                            textFieldColors5 = textFieldColors4;
                            paddingValues4 = paddingValues3;
                            function226 = function214;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z5 = z3;
                            function219 = function22;
                            function221 = function24;
                            function222 = function25;
                            function223 = function26;
                            function224 = function27;
                            function225 = function28;
                            textFieldColors5 = textFieldColors;
                            paddingValues4 = paddingValues;
                            function226 = function29;
                            composer2 = startRestartGroup;
                            function220 = function23;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    TextFieldDefaults.this.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z5, function219, function220, function221, function222, function223, function224, function225, textFieldColors5, paddingValues4, function226, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & 196608) == 0) {
                    }
                    i15 = i3 & 65536;
                    if (i15 != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if ((i3 & Fields.Clip) != 0) {
                    }
                    if ((i3 & Fields.CompositingStrategy) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    function215 = function227;
                    function216 = function228;
                    function217 = function232;
                    paddingValues3 = paddingValues2;
                    z4 = z6;
                    function218 = function233;
                    textFieldColors4 = textFieldColors3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i202 = i4;
                    composer2 = startRestartGroup;
                    OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function211, function212, function213, function217, function218, textFieldColors4, paddingValues3, function214, composer2, (i202 & 14) | (i202 & 112) | (i202 & 896) | (i202 & 7168) | (57344 & i202) | (458752 & i202) | (3670016 & i202) | (29360128 & i202) | (234881024 & i202) | (i202 & 1879048192), (i19 & 14) | 12582912 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z5 = z4;
                    function219 = function215;
                    function220 = function216;
                    function221 = function211;
                    function222 = function212;
                    function223 = function213;
                    function224 = function217;
                    function225 = function218;
                    textFieldColors5 = textFieldColors4;
                    paddingValues4 = paddingValues3;
                    function226 = function214;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i14 = i3 & Fields.Shape;
                if (i14 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & 196608) == 0) {
                }
                i15 = i3 & 65536;
                if (i15 != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 == 0) {
                }
                if ((i3 & Fields.Clip) != 0) {
                }
                if ((i3 & Fields.CompositingStrategy) != 0) {
                }
                if (i15 != 0) {
                }
                function215 = function227;
                function216 = function228;
                function217 = function232;
                paddingValues3 = paddingValues2;
                z4 = z6;
                function218 = function233;
                textFieldColors4 = textFieldColors3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2022 = i4;
                composer2 = startRestartGroup;
                OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function211, function212, function213, function217, function218, textFieldColors4, paddingValues3, function214, composer2, (i2022 & 14) | (i2022 & 112) | (i2022 & 896) | (i2022 & 7168) | (57344 & i2022) | (458752 & i2022) | (3670016 & i2022) | (29360128 & i2022) | (234881024 & i2022) | (i2022 & 1879048192), (i19 & 14) | 12582912 | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z4;
                function219 = function215;
                function220 = function216;
                function221 = function211;
                function222 = function212;
                function223 = function213;
                function224 = function217;
                function225 = function218;
                textFieldColors5 = textFieldColors4;
                paddingValues4 = paddingValues3;
                function226 = function214;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i3 & 32) != 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & Fields.SpotShadowColor;
            if (i7 != 0) {
            }
            i8 = i3 & Fields.RotationX;
            if (i8 != 0) {
            }
            i9 = i3 & Fields.RotationY;
            if (i9 != 0) {
            }
            i10 = i3 & Fields.RotationZ;
            if (i10 != 0) {
            }
            i12 = i3 & Fields.CameraDistance;
            if (i12 != 0) {
            }
            int i192 = i11;
            i13 = i3 & Fields.TransformOrigin;
            if (i13 != 0) {
            }
            i14 = i3 & Fields.Shape;
            if (i14 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & 196608) == 0) {
            }
            i15 = i3 & 65536;
            if (i15 != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 == 0) {
            }
            if ((i3 & Fields.Clip) != 0) {
            }
            if ((i3 & Fields.CompositingStrategy) != 0) {
            }
            if (i15 != 0) {
            }
            function215 = function227;
            function216 = function228;
            function217 = function232;
            paddingValues3 = paddingValues2;
            z4 = z6;
            function218 = function233;
            textFieldColors4 = textFieldColors3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i20222 = i4;
            composer2 = startRestartGroup;
            OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function211, function212, function213, function217, function218, textFieldColors4, paddingValues3, function214, composer2, (i20222 & 14) | (i20222 & 112) | (i20222 & 896) | (i20222 & 7168) | (57344 & i20222) | (458752 & i20222) | (3670016 & i20222) | (29360128 & i20222) | (234881024 & i20222) | (i20222 & 1879048192), (i192 & 14) | 12582912 | (i192 & 112) | (i192 & 896) | (i192 & 7168) | (57344 & i192) | (458752 & i192) | (3670016 & i192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z4;
            function219 = function215;
            function220 = function216;
            function221 = function211;
            function222 = function212;
            function223 = function213;
            function224 = function217;
            function225 = function218;
            textFieldColors5 = textFieldColors4;
            paddingValues4 = paddingValues3;
            function226 = function214;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 16;
        int i182 = Fields.Shape;
        if (i5 == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & Fields.SpotShadowColor;
        if (i7 != 0) {
        }
        i8 = i3 & Fields.RotationX;
        if (i8 != 0) {
        }
        i9 = i3 & Fields.RotationY;
        if (i9 != 0) {
        }
        i10 = i3 & Fields.RotationZ;
        if (i10 != 0) {
        }
        i12 = i3 & Fields.CameraDistance;
        if (i12 != 0) {
        }
        int i1922 = i11;
        i13 = i3 & Fields.TransformOrigin;
        if (i13 != 0) {
        }
        i14 = i3 & Fields.Shape;
        if (i14 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & 196608) == 0) {
        }
        i15 = i3 & 65536;
        if (i15 != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 == 0) {
        }
        if ((i3 & Fields.Clip) != 0) {
        }
        if ((i3 & Fields.CompositingStrategy) != 0) {
        }
        if (i15 != 0) {
        }
        function215 = function227;
        function216 = function228;
        function217 = function232;
        paddingValues3 = paddingValues2;
        z4 = z6;
        function218 = function233;
        textFieldColors4 = textFieldColors3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i202222 = i4;
        composer2 = startRestartGroup;
        OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function216, function211, function212, function213, function217, function218, textFieldColors4, paddingValues3, function214, composer2, (i202222 & 14) | (i202222 & 112) | (i202222 & 896) | (i202222 & 7168) | (57344 & i202222) | (458752 & i202222) | (3670016 & i202222) | (29360128 & i202222) | (234881024 & i202222) | (i202222 & 1879048192), (i1922 & 14) | 12582912 | (i1922 & 112) | (i1922 & 896) | (i1922 & 7168) | (57344 & i1922) | (458752 & i1922) | (3670016 & i1922), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z4;
        function219 = function215;
        function220 = function216;
        function221 = function211;
        function222 = function212;
        function223 = function213;
        function224 = function217;
        function225 = function218;
        textFieldColors5 = textFieldColors4;
        paddingValues4 = paddingValues3;
        function226 = function214;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-eS1Emto */
    public final /* synthetic */ TextFieldColors m3184textFieldColorseS1Emto(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        composer.startReplaceableGroup(-595874869);
        ComposerKt.sourceInformation(composer, "C(textFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1122@61047L5,1123@61130L5,1125@61276L5,1126@61345L5,1127@61429L5,1128@61508L7,1129@61604L5,1130@61695L5,1131@61793L5,1133@61965L5,1134@62057L5,1135@62146L5,1136@62242L5,1138@62408L5,1139@62502L5,1140@62593L5,1141@62691L5,1143@62860L5,1144@62940L5,1145@63017L5,1146@63101L5,1148@63249L5,1149@63334L5,1150@63424L5,1152@63588L5,1153@63679L5,1154@63777L5,1156@63944L5,1157@64026L5,1158@64110L5,1159@64193L5,1161@64343L5,1162@64425L5,1163@64509L5,1164@64592L5,1166@64742L5,1167@64774L2261:TextFieldDefaults.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j;
        long m4838copywmQWz5c$default = (i5 & 2) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long value2 = (i5 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer, 6) : j3;
        long value3 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        long value4 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j5;
        if ((i5 & 32) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value5 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), composer, 6) : j6;
        long value6 = (i5 & Fields.SpotShadowColor) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), composer, 6) : j7;
        long m4838copywmQWz5c$default2 = (i5 & Fields.RotationX) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long value7 = (i5 & Fields.RotationY) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), composer, 6) : j9;
        long value8 = (i5 & Fields.RotationZ) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, 6) : j10;
        long value9 = (i5 & Fields.CameraDistance) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j11;
        long m4838copywmQWz5c$default3 = (i5 & Fields.TransformOrigin) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long value10 = (i5 & Fields.Shape) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6) : j13;
        long value11 = (i5 & Fields.Clip) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, 6) : j14;
        long value12 = (32768 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j15;
        long m4838copywmQWz5c$default4 = (65536 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value13 = (131072 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6) : j17;
        long value14 = (262144 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, 6) : j18;
        long value15 = (524288 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLabelColor(), composer, 6) : j19;
        long m4838copywmQWz5c$default5 = (1048576 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long value16 = (2097152 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6) : j21;
        long value17 = (4194304 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j22;
        long m4838copywmQWz5c$default6 = (8388608 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j23;
        long value18 = (16777216 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, 6) : j24;
        long value19 = (33554432 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getSupportingColor(), composer, 6) : j25;
        long m4838copywmQWz5c$default7 = (67108864 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j26;
        long value20 = (134217728 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6) : j27;
        long value21 = (268435456 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j28;
        long value22 = (536870912 & i5) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j29;
        long m4838copywmQWz5c$default8 = (i5 & 1073741824) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j30;
        long value23 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j31;
        long value24 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j32;
        long value25 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j33;
        long m4838copywmQWz5c$default9 = (i6 & 8) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j34;
        long value26 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j35;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-595874869, i, i2, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:1167)");
        }
        int i7 = i << 3;
        int i8 = (i & 14) | (i7 & 112) | (i7 & 896);
        int i9 = i << 9;
        int i10 = i8 | (i9 & 7168) | ((i << 6) & 57344) | (i9 & 458752) | ((i << 12) & 3670016);
        int i11 = i << 15;
        int i12 = i10 | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192);
        int i13 = i >> 15;
        int i14 = i2 << 15;
        int i15 = (i13 & 57344) | (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (i14 & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192);
        int i16 = i2 >> 15;
        int i17 = i3 << 15;
        int i18 = (i16 & 57344) | (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128);
        int i19 = i3 << 18;
        int i20 = i18 | (i19 & 234881024) | (i19 & 1879048192);
        int i21 = i3 >> 9;
        int i22 = ((i3 >> 6) & 14) | (i21 & 112) | (i21 & 896) | (i21 & 7168) | (i21 & 57344) | (i21 & 458752) | (i21 & 3670016);
        int i23 = i4 << 21;
        int i24 = i22 | (i23 & 29360128) | (i23 & 234881024) | (i23 & 1879048192);
        int i25 = i4 >> 9;
        TextFieldColors m3169colors0hiis_0 = m3169colors0hiis_0(value, value, m4838copywmQWz5c$default, value, value2, value2, value2, value2, value3, value4, textSelectionColors2, value5, value6, m4838copywmQWz5c$default2, value7, value8, value9, m4838copywmQWz5c$default3, value10, value11, value12, m4838copywmQWz5c$default4, value13, value14, value15, m4838copywmQWz5c$default5, value16, value17, value17, m4838copywmQWz5c$default6, value17, value18, value19, m4838copywmQWz5c$default7, value20, value21, value22, m4838copywmQWz5c$default8, value23, value24, value25, m4838copywmQWz5c$default9, value26, composer, i12, i15, i20, i24, (i25 & 14) | (i25 & 112) | (i25 & 896) | (i25 & 7168), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m3169colors0hiis_0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-eS1Emto */
    public final /* synthetic */ TextFieldColors m3180outlinedTextFieldColorseS1Emto(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        composer.startReplaceableGroup(1767818445);
        ComposerKt.sourceInformation(composer, "C(outlinedTextFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1217@67266L5,1218@67351L5,1221@67545L5,1222@67631L5,1223@67710L7,1224@67797L5,1225@67879L5,1226@67968L5,1228@68125L5,1229@68219L5,1230@68310L5,1231@68408L5,1233@68578L5,1234@68674L5,1235@68767L5,1237@68880L5,1238@69040L5,1239@69122L5,1240@69201L5,1241@69287L5,1243@69439L5,1244@69526L5,1245@69618L5,1247@69786L5,1248@69879L5,1250@69992L5,1251@70150L5,1252@70234L5,1253@70320L5,1254@70405L5,1256@70559L5,1257@70643L5,1258@70729L5,1259@70814L5,1261@70968L5,1262@71026L2237:TextFieldDefaults.kt#uh7d8r");
        long value = (i5 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j;
        long m4838copywmQWz5c$default = (i5 & 2) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4874getTransparent0d7_KjU = (i5 & 4) != 0 ? Color.INSTANCE.m4874getTransparent0d7_KjU() : j3;
        long value2 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        long value3 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j5;
        if ((i5 & 32) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), composer, 6) : j6;
        long value5 = (i5 & Fields.SpotShadowColor) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), composer, 6) : j7;
        long m4838copywmQWz5c$default2 = (i5 & Fields.RotationX) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long value6 = (i5 & Fields.RotationY) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), composer, 6) : j9;
        long value7 = (i5 & Fields.RotationZ) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, 6) : j10;
        long value8 = (i5 & Fields.CameraDistance) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j11;
        long m4838copywmQWz5c$default3 = (i5 & Fields.TransformOrigin) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long value9 = (i5 & Fields.Shape) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6) : j13;
        long value10 = (i5 & Fields.Clip) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, 6) : j14;
        long value11 = (32768 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j15;
        long m4838copywmQWz5c$default4 = (65536 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value12 = (131072 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6) : j17;
        long value13 = (262144 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, 6) : j18;
        long value14 = (524288 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), composer, 6) : j19;
        long m4838copywmQWz5c$default5 = (1048576 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long value15 = (2097152 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6) : j21;
        long value16 = (4194304 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j22;
        long m4838copywmQWz5c$default6 = (8388608 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j23;
        long value17 = (16777216 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, 6) : j24;
        long value18 = (33554432 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), composer, 6) : j25;
        long m4838copywmQWz5c$default7 = (67108864 & i5) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j26;
        long value19 = (134217728 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6) : j27;
        long value20 = (268435456 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j28;
        long value21 = (536870912 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j29;
        long m4838copywmQWz5c$default8 = (i5 & 1073741824) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j30;
        long value22 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j31;
        long value23 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j32;
        long value24 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j33;
        long m4838copywmQWz5c$default9 = (i6 & 8) != 0 ? Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j34;
        long value25 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j35;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767818445, i, i2, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:1262)");
        }
        int i7 = i << 3;
        int i8 = (i & 14) | (i7 & 112) | (i7 & 896);
        int i9 = i << 9;
        int i10 = i8 | (i9 & 7168) | ((i << 6) & 57344) | (i9 & 458752) | ((i << 12) & 3670016);
        int i11 = i << 15;
        int i12 = i10 | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192);
        int i13 = i >> 15;
        int i14 = i2 << 15;
        int i15 = (i13 & 57344) | (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (i14 & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192);
        int i16 = i2 >> 15;
        int i17 = i3 << 15;
        int i18 = (i16 & 57344) | (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128);
        int i19 = i3 << 18;
        int i20 = i18 | (i19 & 234881024) | (i19 & 1879048192);
        int i21 = i3 >> 9;
        int i22 = ((i3 >> 6) & 14) | (i21 & 112) | (i21 & 896) | (i21 & 7168) | (i21 & 57344) | (i21 & 458752) | (i21 & 3670016);
        int i23 = i4 << 21;
        int i24 = i22 | (i23 & 29360128) | (i23 & 234881024) | (i23 & 1879048192);
        int i25 = i4 >> 9;
        TextFieldColors m2771colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m2771colors0hiis_0(value, value, m4838copywmQWz5c$default, value, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU, value2, value3, textSelectionColors2, value4, value5, m4838copywmQWz5c$default2, value6, value7, value8, m4838copywmQWz5c$default3, value9, value10, value11, m4838copywmQWz5c$default4, value12, value13, value14, m4838copywmQWz5c$default5, value15, value16, value16, m4838copywmQWz5c$default6, value16, value17, value18, m4838copywmQWz5c$default7, value19, value20, value21, m4838copywmQWz5c$default8, value22, value23, value24, m4838copywmQWz5c$default9, value25, composer, i12, i15, i20, i24, (i25 & 14) | 3072 | (i25 & 112) | (i25 & 896), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2771colors0hiis_0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a7, code lost:
    
        if (r9.changed(r49) == false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c1, code lost:
    
        if (r9.changed(r50) == false) goto L409;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0352  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void TextFieldDecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function27, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Function2 function28;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Shape shape2;
        TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        Function2 function29;
        Function2 function210;
        Shape shape3;
        Function2 function211;
        Function2 function212;
        TextFieldColors textFieldColors3;
        boolean z4;
        PaddingValues paddingValues3;
        Function2 function213;
        Function2 function214;
        Function2 function215;
        Composer composer2;
        final boolean z5;
        final Function2 function216;
        final Function2 function217;
        final Function2 function218;
        final Function2 function219;
        final Function2 function220;
        final Shape shape4;
        final TextFieldColors textFieldColors4;
        final PaddingValues paddingValues4;
        final Function2 function221;
        ScopeUpdateScope endRestartGroup;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1224712461);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldDecorationBox)P(14,4,3,11,15,5,6,7,9,8,13,12,10!1,2)1324@74014L5,1325@74055L8,1336@74410L684:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
            i5 = i3 & 8;
            int i17 = Fields.CameraDistance;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i6 = i3 & 16;
                int i18 = Fields.Clip;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changed(interactionSource) ? Fields.RenderEffect : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                    }
                    i8 = i3 & Fields.SpotShadowColor;
                    if (i8 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                    }
                    i9 = i3 & Fields.RotationX;
                    if (i9 == 0) {
                        i4 |= 100663296;
                        function28 = function23;
                    } else {
                        function28 = function23;
                        if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changedInstance(function28) ? 67108864 : 33554432;
                        }
                    }
                    i10 = i3 & Fields.RotationY;
                    if (i10 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                    }
                    i11 = i3 & Fields.RotationZ;
                    if (i11 == 0) {
                        i12 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i12 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                    } else {
                        i12 = i2;
                    }
                    i13 = i3 & Fields.CameraDistance;
                    if (i13 == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & Fields.TransformOrigin) == 0 && startRestartGroup.changed(shape)) {
                            i16 = Fields.RotationX;
                            i12 |= i16;
                        }
                        i16 = Fields.SpotShadowColor;
                        i12 |= i16;
                    }
                    if ((i2 & 3072) == 0) {
                        if ((i3 & Fields.Shape) != 0) {
                        }
                        i17 = 1024;
                        i12 |= i17;
                    }
                    if ((i2 & 24576) == 0) {
                        if ((i3 & Fields.Clip) != 0) {
                        }
                        i18 = 8192;
                        i12 |= i18;
                    }
                    i14 = i3 & Fields.CompositingStrategy;
                    if (i14 == 0) {
                        i12 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i12 |= startRestartGroup.changedInstance(function27) ? Fields.RenderEffect : 65536;
                    }
                    if ((i3 & 65536) == 0) {
                        i12 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i12 |= startRestartGroup.changed(this) ? 1048576 : Fields.BlendMode;
                    }
                    i15 = i12;
                    if ((i4 & 306783379) == 306783378 || (599187 & i15) != 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            boolean z6 = i7 == 0 ? false : z3;
                            Function2 function222 = i8 == 0 ? null : function22;
                            if (i9 != 0) {
                                function28 = null;
                            }
                            Function2 function223 = i10 == 0 ? null : function24;
                            Function2 function224 = i11 == 0 ? null : function25;
                            Function2 function225 = i13 == 0 ? function26 : null;
                            if ((i3 & Fields.TransformOrigin) == 0) {
                                shape2 = INSTANCE.getShape(startRestartGroup, 6);
                                i15 &= -897;
                            } else {
                                shape2 = shape;
                            }
                            if ((i3 & Fields.Shape) == 0) {
                                textFieldColors2 = colors(startRestartGroup, (i15 >> 18) & 14);
                                i15 &= -7169;
                            } else {
                                textFieldColors2 = textFieldColors;
                            }
                            if ((i3 & Fields.Clip) == 0) {
                                if (function222 == null) {
                                    paddingValues2 = m3160contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValues2 = m3159contentPaddingWithLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i15 &= -57345;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            if (i14 == 0) {
                                function29 = function223;
                                final boolean z7 = z6;
                                final TextFieldColors textFieldColors5 = textFieldColors2;
                                final Shape shape5 = shape2;
                                function210 = function224;
                                shape3 = shape2;
                                function211 = ComposableLambdaKt.composableLambda(startRestartGroup, -1171460386, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i19) {
                                        ComposerKt.sourceInformation(composer3, "C1333@74319L64:TextFieldDefaults.kt#uh7d8r");
                                        if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1171460386, i19, -1, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:1333)");
                                        }
                                        TextFieldDefaults.INSTANCE.ContainerBox(z, z7, interactionSource, textFieldColors5, shape5, composer3, 196608, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            } else {
                                function29 = function223;
                                function210 = function224;
                                shape3 = shape2;
                                function211 = function27;
                            }
                            function212 = function222;
                            textFieldColors3 = textFieldColors2;
                            z4 = z6;
                            paddingValues3 = paddingValues2;
                            function213 = function28;
                            function214 = function29;
                            function215 = function225;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & Fields.TransformOrigin) != 0) {
                                i15 &= -897;
                            }
                            if ((i3 & Fields.Shape) != 0) {
                                i15 &= -7169;
                            }
                            if ((i3 & Fields.Clip) != 0) {
                                i15 &= -57345;
                            }
                            z4 = z3;
                            function212 = function22;
                            function214 = function24;
                            function210 = function25;
                            function215 = function26;
                            shape3 = shape;
                            textFieldColors3 = textFieldColors;
                            paddingValues3 = paddingValues;
                            function211 = function27;
                            function213 = function28;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1224712461, i4, i15, "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:1335)");
                        }
                        int i19 = i15 << 6;
                        composer2 = startRestartGroup;
                        DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function212, function213, function214, function210, null, null, function215, shape3, textFieldColors3, paddingValues3, function211, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i15 & 14) | 432 | (i19 & 7168) | (57344 & i19) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (i19 & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z4;
                        function216 = function212;
                        function217 = function213;
                        function218 = function214;
                        function219 = function210;
                        function220 = function215;
                        shape4 = shape3;
                        textFieldColors4 = textFieldColors3;
                        paddingValues4 = paddingValues3;
                        function221 = function211;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z5 = z3;
                        function218 = function24;
                        function220 = function26;
                        shape4 = shape;
                        textFieldColors4 = textFieldColors;
                        paddingValues4 = paddingValues;
                        function221 = function27;
                        composer2 = startRestartGroup;
                        function217 = function28;
                        function216 = function22;
                        function219 = function25;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                TextFieldDefaults.this.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z5, function216, function217, function218, function219, function220, shape4, textFieldColors4, paddingValues4, function221, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 32) == 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                i8 = i3 & Fields.SpotShadowColor;
                if (i8 == 0) {
                }
                i9 = i3 & Fields.RotationX;
                if (i9 == 0) {
                }
                i10 = i3 & Fields.RotationY;
                if (i10 == 0) {
                }
                i11 = i3 & Fields.RotationZ;
                if (i11 == 0) {
                }
                i13 = i3 & Fields.CameraDistance;
                if (i13 == 0) {
                }
                if ((i2 & 384) == 0) {
                }
                if ((i2 & 3072) == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                i14 = i3 & Fields.CompositingStrategy;
                if (i14 == 0) {
                }
                if ((i3 & 65536) == 0) {
                }
                i15 = i12;
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 == 0) {
                }
                if ((i3 & Fields.TransformOrigin) == 0) {
                }
                if ((i3 & Fields.Shape) == 0) {
                }
                if ((i3 & Fields.Clip) == 0) {
                }
                if (i14 == 0) {
                }
                function212 = function222;
                textFieldColors3 = textFieldColors2;
                z4 = z6;
                paddingValues3 = paddingValues2;
                function213 = function28;
                function214 = function29;
                function215 = function225;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i192 = i15 << 6;
                composer2 = startRestartGroup;
                DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function212, function213, function214, function210, null, null, function215, shape3, textFieldColors3, paddingValues3, function211, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i15 & 14) | 432 | (i192 & 7168) | (57344 & i192) | (458752 & i192) | (3670016 & i192) | (29360128 & i192) | (i192 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z4;
                function216 = function212;
                function217 = function213;
                function218 = function214;
                function219 = function210;
                function220 = function215;
                shape4 = shape3;
                textFieldColors4 = textFieldColors3;
                paddingValues4 = paddingValues3;
                function221 = function211;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 16;
            int i182 = Fields.Clip;
            if (i6 != 0) {
            }
            if ((i3 & 32) == 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            i8 = i3 & Fields.SpotShadowColor;
            if (i8 == 0) {
            }
            i9 = i3 & Fields.RotationX;
            if (i9 == 0) {
            }
            i10 = i3 & Fields.RotationY;
            if (i10 == 0) {
            }
            i11 = i3 & Fields.RotationZ;
            if (i11 == 0) {
            }
            i13 = i3 & Fields.CameraDistance;
            if (i13 == 0) {
            }
            if ((i2 & 384) == 0) {
            }
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i14 = i3 & Fields.CompositingStrategy;
            if (i14 == 0) {
            }
            if ((i3 & 65536) == 0) {
            }
            i15 = i12;
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 == 0) {
            }
            if ((i3 & Fields.TransformOrigin) == 0) {
            }
            if ((i3 & Fields.Shape) == 0) {
            }
            if ((i3 & Fields.Clip) == 0) {
            }
            if (i14 == 0) {
            }
            function212 = function222;
            textFieldColors3 = textFieldColors2;
            z4 = z6;
            paddingValues3 = paddingValues2;
            function213 = function28;
            function214 = function29;
            function215 = function225;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1922 = i15 << 6;
            composer2 = startRestartGroup;
            DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function212, function213, function214, function210, null, null, function215, shape3, textFieldColors3, paddingValues3, function211, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i15 & 14) | 432 | (i1922 & 7168) | (57344 & i1922) | (458752 & i1922) | (3670016 & i1922) | (29360128 & i1922) | (i1922 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z4;
            function216 = function212;
            function217 = function213;
            function218 = function214;
            function219 = function210;
            function220 = function215;
            shape4 = shape3;
            textFieldColors4 = textFieldColors3;
            paddingValues4 = paddingValues3;
            function221 = function211;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 8;
        int i172 = Fields.CameraDistance;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        int i1822 = Fields.Clip;
        if (i6 != 0) {
        }
        if ((i3 & 32) == 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        i8 = i3 & Fields.SpotShadowColor;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.RotationX;
        if (i9 == 0) {
        }
        i10 = i3 & Fields.RotationY;
        if (i10 == 0) {
        }
        i11 = i3 & Fields.RotationZ;
        if (i11 == 0) {
        }
        i13 = i3 & Fields.CameraDistance;
        if (i13 == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i14 = i3 & Fields.CompositingStrategy;
        if (i14 == 0) {
        }
        if ((i3 & 65536) == 0) {
        }
        i15 = i12;
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        if ((i3 & Fields.TransformOrigin) == 0) {
        }
        if ((i3 & Fields.Shape) == 0) {
        }
        if ((i3 & Fields.Clip) == 0) {
        }
        if (i14 == 0) {
        }
        function212 = function222;
        textFieldColors3 = textFieldColors2;
        z4 = z6;
        paddingValues3 = paddingValues2;
        function213 = function28;
        function214 = function29;
        function215 = function225;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i19222 = i15 << 6;
        composer2 = startRestartGroup;
        DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function212, function213, function214, function210, null, null, function215, shape3, textFieldColors3, paddingValues3, function211, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i15 & 14) | 432 | (i19222 & 7168) | (57344 & i19222) | (458752 & i19222) | (3670016 & i19222) | (29360128 & i19222) | (i19222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z4;
        function216 = function212;
        function217 = function213;
        function218 = function214;
        function219 = function210;
        function220 = function215;
        shape4 = shape3;
        textFieldColors4 = textFieldColors3;
        paddingValues4 = paddingValues3;
        function221 = function211;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x019f, code lost:
    
        if (r8.changed(r47) == false) goto L367;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0242  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function27, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        final TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        Function2 function28;
        Function2 function29;
        Function2 function210;
        TextFieldColors textFieldColors3;
        Function2 function211;
        boolean z4;
        PaddingValues paddingValues3;
        Function2 function212;
        Function2 function213;
        Composer composer2;
        final boolean z5;
        final Function2 function214;
        final Function2 function215;
        final Function2 function216;
        final Function2 function217;
        final Function2 function218;
        final TextFieldColors textFieldColors4;
        final PaddingValues paddingValues4;
        final Function2 function219;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(508645792);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldDecorationBox)P(13,4,3,10,14,5,6,7,9,8,12,11!1,2)1374@75878L8,1380@76166L656:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            i5 = i3 & 4;
            int i16 = Fields.SpotShadowColor;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.RotationX : 128;
            }
            i6 = i3 & 8;
            int i17 = Fields.CameraDistance;
            if (i6 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i7 = i3 & 16;
                int i18 = Fields.Clip;
                if (i7 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changed(interactionSource) ? Fields.RenderEffect : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                    }
                    i9 = i3 & Fields.SpotShadowColor;
                    if (i9 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                    }
                    i10 = i3 & Fields.RotationX;
                    if (i10 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    }
                    i11 = i3 & Fields.RotationY;
                    if (i11 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                    }
                    i12 = i3 & Fields.RotationZ;
                    if (i12 == 0) {
                        i13 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i13 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                    } else {
                        i13 = i2;
                    }
                    i14 = i3 & Fields.CameraDistance;
                    if (i14 == 0) {
                        i13 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i13 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & Fields.TransformOrigin) == 0 && startRestartGroup.changed(textFieldColors)) {
                            i16 = Fields.RotationX;
                        }
                        i13 |= i16;
                    }
                    if ((i2 & 3072) == 0) {
                        if ((i3 & Fields.Shape) != 0) {
                        }
                        i17 = 1024;
                        i13 |= i17;
                    }
                    int i19 = i13;
                    i15 = i3 & Fields.Clip;
                    if (i15 == 0) {
                        i19 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        if (!startRestartGroup.changedInstance(function27)) {
                            i18 = 8192;
                        }
                        i19 |= i18;
                        if ((i4 & 306783379) == 306783378 || (i19 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                final boolean z6 = i8 != 0 ? false : z3;
                                Function2 function220 = i9 != 0 ? null : function22;
                                Function2 function221 = i10 != 0 ? null : function23;
                                Function2 function222 = i11 != 0 ? null : function24;
                                Function2 function223 = i12 != 0 ? null : function25;
                                Function2 function224 = i14 == 0 ? function26 : null;
                                if ((i3 & Fields.TransformOrigin) != 0) {
                                    textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    i19 &= -897;
                                } else {
                                    textFieldColors2 = textFieldColors;
                                }
                                if ((i3 & Fields.Shape) != 0) {
                                    paddingValues2 = OutlinedTextFieldDefaults.m2769contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -7169;
                                } else {
                                    paddingValues2 = paddingValues;
                                }
                                if (i15 != 0) {
                                    function28 = function222;
                                    function29 = function223;
                                    function210 = ComposableLambdaKt.composableLambda(startRestartGroup, 144282315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$3
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i20) {
                                            ComposerKt.sourceInformation(composer3, "C1377@76056L57:TextFieldDefaults.kt#uh7d8r");
                                            if ((i20 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(144282315, i20, -1, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:1377)");
                                            }
                                            OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z6, interactionSource, textFieldColors2, null, 0.0f, 0.0f, composer3, 12582912, 112);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    function28 = function222;
                                    function29 = function223;
                                    function210 = function27;
                                }
                                textFieldColors3 = textFieldColors2;
                                function211 = function220;
                                z4 = z6;
                                paddingValues3 = paddingValues2;
                                function212 = function221;
                                function213 = function224;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & Fields.TransformOrigin) != 0) {
                                    i19 &= -897;
                                }
                                if ((i3 & Fields.Shape) != 0) {
                                    i19 &= -7169;
                                }
                                z4 = z3;
                                function211 = function22;
                                function212 = function23;
                                function28 = function24;
                                function29 = function25;
                                function213 = function26;
                                textFieldColors3 = textFieldColors;
                                paddingValues3 = paddingValues;
                                function210 = function27;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(508645792, i4, i19, "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:1379)");
                            }
                            int i20 = i19 << 6;
                            composer2 = startRestartGroup;
                            OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function211, function212, function28, function29, null, null, function213, textFieldColors3, paddingValues3, function210, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i19 & 14) | 12583344 | (i20 & 7168) | (57344 & i20) | (458752 & i20) | (i20 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z4;
                            function214 = function211;
                            function215 = function212;
                            function216 = function28;
                            function217 = function29;
                            function218 = function213;
                            textFieldColors4 = textFieldColors3;
                            paddingValues4 = paddingValues3;
                            function219 = function210;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function214 = function22;
                            function215 = function23;
                            function216 = function24;
                            function217 = function25;
                            function218 = function26;
                            textFieldColors4 = textFieldColors;
                            paddingValues4 = paddingValues;
                            function219 = function27;
                            composer2 = startRestartGroup;
                            z5 = z3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i21) {
                                    TextFieldDefaults.this.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z5, function214, function215, function216, function217, function218, textFieldColors4, paddingValues4, function219, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if ((i3 & Fields.TransformOrigin) != 0) {
                    }
                    if ((i3 & Fields.Shape) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    textFieldColors3 = textFieldColors2;
                    function211 = function220;
                    z4 = z6;
                    paddingValues3 = paddingValues2;
                    function212 = function221;
                    function213 = function224;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i202 = i19 << 6;
                    composer2 = startRestartGroup;
                    OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function211, function212, function28, function29, null, null, function213, textFieldColors3, paddingValues3, function210, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i19 & 14) | 12583344 | (i202 & 7168) | (57344 & i202) | (458752 & i202) | (i202 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z5 = z4;
                    function214 = function211;
                    function215 = function212;
                    function216 = function28;
                    function217 = function29;
                    function218 = function213;
                    textFieldColors4 = textFieldColors3;
                    paddingValues4 = paddingValues3;
                    function219 = function210;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i3 & 32) == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & Fields.SpotShadowColor;
                if (i9 == 0) {
                }
                i10 = i3 & Fields.RotationX;
                if (i10 == 0) {
                }
                i11 = i3 & Fields.RotationY;
                if (i11 == 0) {
                }
                i12 = i3 & Fields.RotationZ;
                if (i12 == 0) {
                }
                i14 = i3 & Fields.CameraDistance;
                if (i14 == 0) {
                }
                if ((i2 & 384) == 0) {
                }
                if ((i2 & 3072) == 0) {
                }
                int i192 = i13;
                i15 = i3 & Fields.Clip;
                if (i15 == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 == 0) {
                }
                if ((i3 & Fields.TransformOrigin) != 0) {
                }
                if ((i3 & Fields.Shape) != 0) {
                }
                if (i15 != 0) {
                }
                textFieldColors3 = textFieldColors2;
                function211 = function220;
                z4 = z6;
                paddingValues3 = paddingValues2;
                function212 = function221;
                function213 = function224;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2022 = i192 << 6;
                composer2 = startRestartGroup;
                OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function211, function212, function28, function29, null, null, function213, textFieldColors3, paddingValues3, function210, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i192 & 14) | 12583344 | (i2022 & 7168) | (57344 & i2022) | (458752 & i2022) | (i2022 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z4;
                function214 = function211;
                function215 = function212;
                function216 = function28;
                function217 = function29;
                function218 = function213;
                textFieldColors4 = textFieldColors3;
                paddingValues4 = paddingValues3;
                function219 = function210;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i3 & 16;
            int i182 = Fields.Clip;
            if (i7 != 0) {
            }
            if ((i3 & 32) == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & Fields.SpotShadowColor;
            if (i9 == 0) {
            }
            i10 = i3 & Fields.RotationX;
            if (i10 == 0) {
            }
            i11 = i3 & Fields.RotationY;
            if (i11 == 0) {
            }
            i12 = i3 & Fields.RotationZ;
            if (i12 == 0) {
            }
            i14 = i3 & Fields.CameraDistance;
            if (i14 == 0) {
            }
            if ((i2 & 384) == 0) {
            }
            if ((i2 & 3072) == 0) {
            }
            int i1922 = i13;
            i15 = i3 & Fields.Clip;
            if (i15 == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 == 0) {
            }
            if ((i3 & Fields.TransformOrigin) != 0) {
            }
            if ((i3 & Fields.Shape) != 0) {
            }
            if (i15 != 0) {
            }
            textFieldColors3 = textFieldColors2;
            function211 = function220;
            z4 = z6;
            paddingValues3 = paddingValues2;
            function212 = function221;
            function213 = function224;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i20222 = i1922 << 6;
            composer2 = startRestartGroup;
            OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function211, function212, function28, function29, null, null, function213, textFieldColors3, paddingValues3, function210, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i1922 & 14) | 12583344 | (i20222 & 7168) | (57344 & i20222) | (458752 & i20222) | (i20222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z4;
            function214 = function211;
            function215 = function212;
            function216 = function28;
            function217 = function29;
            function218 = function213;
            textFieldColors4 = textFieldColors3;
            paddingValues4 = paddingValues3;
            function219 = function210;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 4;
        int i162 = Fields.SpotShadowColor;
        if (i5 == 0) {
        }
        i6 = i3 & 8;
        int i172 = Fields.CameraDistance;
        if (i6 == 0) {
        }
        i7 = i3 & 16;
        int i1822 = Fields.Clip;
        if (i7 != 0) {
        }
        if ((i3 & 32) == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.SpotShadowColor;
        if (i9 == 0) {
        }
        i10 = i3 & Fields.RotationX;
        if (i10 == 0) {
        }
        i11 = i3 & Fields.RotationY;
        if (i11 == 0) {
        }
        i12 = i3 & Fields.RotationZ;
        if (i12 == 0) {
        }
        i14 = i3 & Fields.CameraDistance;
        if (i14 == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        int i19222 = i13;
        i15 = i3 & Fields.Clip;
        if (i15 == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 == 0) {
        }
        if ((i3 & Fields.TransformOrigin) != 0) {
        }
        if ((i3 & Fields.Shape) != 0) {
        }
        if (i15 != 0) {
        }
        textFieldColors3 = textFieldColors2;
        function211 = function220;
        z4 = z6;
        paddingValues3 = paddingValues2;
        function212 = function221;
        function213 = function224;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i202222 = i19222 << 6;
        composer2 = startRestartGroup;
        OutlinedTextFieldDefaults.INSTANCE.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function211, function212, function28, function29, null, null, function213, textFieldColors3, paddingValues3, function210, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i19222 & 14) | 12583344 | (i202222 & 7168) | (57344 & i202222) | (458752 & i202222) | (i202222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z4;
        function214 = function211;
        function215 = function212;
        function216 = function28;
        function217 = function29;
        function218 = function213;
        textFieldColors4 = textFieldColors3;
        paddingValues4 = paddingValues3;
        function219 = function210;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: indicatorLine-gv0btCI */
    public final Modifier m3178indicatorLinegv0btCI(Modifier modifier, final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, final float f, final float f2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("indicatorLine");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("isError", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", interactionSource);
                inspectorInfo.getProperties().set("colors", textFieldColors);
                inspectorInfo.getProperties().set("focusedIndicatorLineThickness", Dp.box-impl(f));
                inspectorInfo.getProperties().set("unfocusedIndicatorLineThickness", Dp.box-impl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                State m3188animateBorderStrokeAsStateNuRrP5Q;
                composer.startReplaceableGroup(-891038934);
                ComposerKt.sourceInformation(composer, "C141@6072L217:TextFieldDefaults.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891038934, i, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:141)");
                }
                m3188animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m3188animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f, f2, composer, 0);
                Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) m3188animateBorderStrokeAsStateNuRrP5Q.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return drawIndicatorLine;
            }
        });
    }

    static {
        float f = Dp.constructor-impl(1);
        UnfocusedIndicatorThickness = f;
        float f2 = Dp.constructor-impl(2);
        FocusedIndicatorThickness = f2;
        UnfocusedBorderThickness = f;
        FocusedBorderThickness = f2;
    }
}
