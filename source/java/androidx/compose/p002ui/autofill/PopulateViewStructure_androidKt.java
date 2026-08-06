package androidx.compose.p002ui.autofill;

import android.os.Build;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsInfoKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopulateViewStructure.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0001¨\u0006\u000b"}, d2 = {"populate", "", "Landroid/view/ViewStructure;", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "packageName", "", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PopulateViewStructure_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:120:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void populate(final ViewStructure viewStructure, SemanticsInfo semanticsInfo, AutofillId autofillId, String str, RectManager rectManager) {
        ToggleableState toggleableState;
        ContentDataType contentDataType;
        boolean z;
        ContentType contentType;
        Boolean bool;
        Role role;
        boolean z2;
        Integer num;
        AnnotatedString annotatedString;
        List list;
        Integer num2;
        boolean z3;
        String str2;
        String[] contentHints;
        String[] contentHints2;
        MutableScatterMap props$ui_release;
        long[] jArr;
        long[] jArr2;
        MutableScatterMap props$ui_release2;
        ToggleableState toggleableState2;
        final AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        SemanticsConfiguration semanticsConfiguration = semanticsInfo.getSemanticsConfiguration();
        char c = 7;
        long j = -9187201950435737472L;
        if (semanticsConfiguration == null || (props$ui_release2 = semanticsConfiguration.getProps$ui_release()) == null) {
            toggleableState = null;
            contentDataType = null;
            z = false;
            contentType = null;
            bool = null;
            role = null;
            z2 = false;
            num = null;
            annotatedString = null;
        } else {
            MutableScatterMap mutableScatterMap = props$ui_release2;
            Object[] objArr = mutableScatterMap.keys;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i = 0;
                contentDataType = null;
                z = false;
                toggleableState2 = null;
                contentType = null;
                bool = null;
                role = null;
                z2 = false;
                num = null;
                annotatedString = null;
                Object[] objArr3 = objArr2;
                while (true) {
                    long j2 = jArr3[i];
                    Object[] objArr4 = objArr3;
                    if ((((~j2) << c) & j2 & j) != j) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((j2 & 255) < 128) {
                                int i4 = (i << 3) + i3;
                                Object obj = objArr[i4];
                                Object obj2 = objArr4[i4];
                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                                if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getContentDataType())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentDataType");
                                    contentDataType = (ContentDataType) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getContentDescription())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                    String str3 = (String) CollectionsKt.firstOrNull((List) obj2);
                                    if (str3 != null) {
                                        autofillApi26Helper.setContentDescription(viewStructure, str3);
                                    }
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getContentType())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentType");
                                    contentType = (ContentType) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getEditableText())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString");
                                    annotatedString = (AnnotatedString) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getFocused())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                    autofillApi26Helper.setFocused(viewStructure, ((Boolean) obj2).booleanValue());
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getMaxTextLength())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                                    num = (Integer) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getPassword())) {
                                    z2 = true;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getRole())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.semantics.Role");
                                    role = (Role) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getSelected())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                    bool = (Boolean) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.getToggleableState())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.state.ToggleableState");
                                    toggleableState2 = (ToggleableState) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getOnClick())) {
                                    autofillApi26Helper.setClickable(viewStructure, true);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getOnLongClick())) {
                                    autofillApi26Helper.setLongClickable(viewStructure, true);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getRequestFocus())) {
                                    autofillApi26Helper.setFocusable(viewStructure, true);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getSetText())) {
                                    z = true;
                                }
                            }
                            j2 >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                    objArr3 = objArr4;
                    c = 7;
                    j = -9187201950435737472L;
                }
            } else {
                contentDataType = null;
                z = false;
                toggleableState2 = null;
                contentType = null;
                bool = null;
                role = null;
                z2 = false;
                num = null;
                annotatedString = null;
            }
            toggleableState = toggleableState2;
        }
        SemanticsConfiguration mergedSemanticsConfiguration = SemanticsInfoKt.mergedSemanticsConfiguration(semanticsInfo);
        if (mergedSemanticsConfiguration != null && (props$ui_release = mergedSemanticsConfiguration.getProps$ui_release()) != null) {
            MutableScatterMap mutableScatterMap2 = props$ui_release;
            Object[] objArr5 = mutableScatterMap2.keys;
            Object[] objArr6 = mutableScatterMap2.values;
            long[] jArr4 = mutableScatterMap2.metadata;
            int length2 = jArr4.length - 2;
            if (length2 >= 0) {
                int i5 = 0;
                list = null;
                while (true) {
                    long j3 = jArr4[i5];
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length2)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j3 & 255) < 128) {
                                int i8 = (i5 << 3) + i7;
                                Object obj3 = objArr5[i8];
                                Object obj4 = objArr6[i8];
                                SemanticsPropertyKey semanticsPropertyKey2 = (SemanticsPropertyKey) obj3;
                                jArr2 = jArr4;
                                if (Intrinsics.areEqual(semanticsPropertyKey2, semanticsProperties.getDisabled())) {
                                    autofillApi26Helper.setEnabled(viewStructure, false);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey2, semanticsProperties.getText())) {
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString>");
                                    list = (List) obj4;
                                }
                            } else {
                                jArr2 = jArr4;
                            }
                            j3 >>= 8;
                            i7++;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i6 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i5 == length2) {
                        break;
                    }
                    i5++;
                    jArr4 = jArr;
                }
                Integer valueOf = Integer.valueOf(semanticsInfo.getSemanticsId());
                valueOf.intValue();
                if (semanticsInfo.getParentInfo() != null) {
                    valueOf = null;
                }
                int intValue = valueOf == null ? valueOf.intValue() : -1;
                autofillApi26Helper.setAutofillId(viewStructure, autofillId, intValue);
                autofillApi26Helper.setId(viewStructure, intValue, str, null, null);
                if (contentDataType == null) {
                    num2 = Integer.valueOf(ContentDataType_androidKt.getDataType(contentDataType));
                } else if (z) {
                    num2 = 1;
                } else {
                    num2 = toggleableState != null ? 2 : null;
                }
                if (num2 != null) {
                    autofillApi26Helper.setAutofillType(viewStructure, num2.intValue());
                }
                if (contentType != null && (contentHints2 = ContentType_androidKt.getContentHints(contentType)) != null) {
                    autofillApi26Helper.setAutofillHints(viewStructure, contentHints2);
                }
                rectManager.getRects().withRect(semanticsInfo.getSemanticsId(), new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.PopulateViewStructure_androidKt$populate$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                        invoke(((Number) obj5).intValue(), ((Number) obj6).intValue(), ((Number) obj7).intValue(), ((Number) obj8).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i9, int i10, int i11, int i12) {
                        AutofillApi26Helper.this.setDimens(viewStructure, i9, i10, 0, 0, i11 - i9, i12 - i10);
                    }
                });
                if (bool != null) {
                    autofillApi26Helper.setSelected(viewStructure, bool.booleanValue());
                }
                if (toggleableState == null) {
                    autofillApi26Helper.setCheckable(viewStructure, true);
                    autofillApi26Helper.setChecked(viewStructure, toggleableState == ToggleableState.On);
                } else if (bool != null) {
                    if (!(role == null ? false : Role.equals-impl0(role.unbox-impl(), Role.Companion.getTab-o7Vup1c()))) {
                        autofillApi26Helper.setCheckable(viewStructure, true);
                        autofillApi26Helper.setChecked(viewStructure, bool.booleanValue());
                    }
                }
                z3 = !z2 || (contentType == null && (contentHints = ContentType_androidKt.getContentHints(contentType)) != null && ArraysKt.contains(contentHints, (String) ArraysKt.first(ContentType_androidKt.getContentHints(ContentType.INSTANCE.getPassword()))));
                if (z3) {
                    autofillApi26Helper.setDataIsSensitive(viewStructure, true);
                }
                autofillApi26Helper.setVisibility(viewStructure, !semanticsInfo.isTransparent() ? 4 : 0);
                if (list != null) {
                    int size = list.size();
                    String str4 = "";
                    for (int i9 = 0; i9 < size; i9++) {
                        str4 = str4 + ((AnnotatedString) list.get(i9)).getText() + '\n';
                    }
                    autofillApi26Helper.setText(viewStructure, str4);
                    autofillApi26Helper.setClassName(viewStructure, "android.widget.TextView");
                }
                if (semanticsInfo.getChildrenInfo().isEmpty() && role != null && (str2 = SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw(role.unbox-impl())) != null) {
                    autofillApi26Helper.setClassName(viewStructure, str2);
                }
                if (z) {
                    return;
                }
                autofillApi26Helper.setClassName(viewStructure, "android.widget.EditText");
                if (Build.VERSION.SDK_INT >= 28 && num != null) {
                    AutofillApi28Helper.INSTANCE.setMaxTextLength(viewStructure, num.intValue());
                }
                if (annotatedString != null) {
                    autofillApi26Helper.setAutofillValue(viewStructure, autofillApi26Helper.getAutofillTextValue(annotatedString.getText()));
                }
                if (z3) {
                    autofillApi26Helper.setInputType(viewStructure, 129);
                    return;
                }
                return;
            }
        }
        list = null;
        Integer valueOf2 = Integer.valueOf(semanticsInfo.getSemanticsId());
        valueOf2.intValue();
        if (semanticsInfo.getParentInfo() != null) {
        }
        int intValue2 = valueOf2 == null ? valueOf2.intValue() : -1;
        autofillApi26Helper.setAutofillId(viewStructure, autofillId, intValue2);
        autofillApi26Helper.setId(viewStructure, intValue2, str, null, null);
        if (contentDataType == null) {
        }
        if (num2 != null) {
        }
        if (contentType != null) {
            autofillApi26Helper.setAutofillHints(viewStructure, contentHints2);
        }
        rectManager.getRects().withRect(semanticsInfo.getSemanticsId(), new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.PopulateViewStructure_androidKt$populate$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                invoke(((Number) obj5).intValue(), ((Number) obj6).intValue(), ((Number) obj7).intValue(), ((Number) obj8).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i92, int i10, int i11, int i12) {
                AutofillApi26Helper.this.setDimens(viewStructure, i92, i10, 0, 0, i11 - i92, i12 - i10);
            }
        });
        if (bool != null) {
        }
        if (toggleableState == null) {
        }
        if (z2) {
        }
        if (z3) {
        }
        autofillApi26Helper.setVisibility(viewStructure, !semanticsInfo.isTransparent() ? 4 : 0);
        if (list != null) {
        }
        if (semanticsInfo.getChildrenInfo().isEmpty()) {
            autofillApi26Helper.setClassName(viewStructure, str2);
        }
        if (z) {
        }
    }
}
