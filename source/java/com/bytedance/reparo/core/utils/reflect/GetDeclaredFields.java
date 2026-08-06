package com.bytedance.reparo.core.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class GetDeclaredFields extends ClassMethodFinder<Field[]> {
    @Override // com.bytedance.reparo.core.utils.reflect.ClassMethodFinder
    List<? extends ClassMethodFinder<Field[]>.ClassMethodGetter> allMethodsImpl() {
        return Arrays.asList(new GetDeclaredMethods7(), new GetDeclaredMethods4());
    }

    /* loaded from: classes4.dex */
    private class GetDeclaredMethods7 extends ClassMethodFinder<Field[]>.ClassMethodGetter {
        private GetDeclaredMethods7() {
            super();
        }

        @Override // com.bytedance.reparo.core.utils.reflect.ClassMethodFinder.ClassMethodGetter
        Method getDeclaredMethod() throws NoSuchMethodException {
            return Class.class.getDeclaredMethod("getDeclaredFieldsUnchecked", Boolean.TYPE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.reparo.core.utils.reflect.ClassMethodFinder.ClassMethodGetter
        public Field[] invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            return (Field[]) super.invoke(obj, false);
        }
    }

    /* loaded from: classes4.dex */
    private class GetDeclaredMethods4 extends ClassMethodFinder<Field[]>.ClassMethodGetter {
        private GetDeclaredMethods4() {
            super();
        }

        @Override // com.bytedance.reparo.core.utils.reflect.ClassMethodFinder.ClassMethodGetter
        Method getDeclaredMethod() throws NoSuchMethodException {
            return Class.class.getDeclaredMethod("getDeclaredFields", Boolean.TYPE, List.class);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.reparo.core.utils.reflect.ClassMethodFinder.ClassMethodGetter
        public Field[] invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            ArrayList arrayList = new ArrayList();
            super.invoke(obj, false, arrayList);
            return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
        }
    }
}
