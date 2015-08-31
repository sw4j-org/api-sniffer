/*
 * Copyright (C) 2015 Uwe Plonus
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sw4j.apisniffer.visitor;

import javax.annotation.concurrent.NotThreadSafe;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;
import org.sw4j.apisniffer.builder.ApiBuilder;
import org.sw4j.apisniffer.builder.TypeBuilder;

/**
 *
 * @author Uwe Plonus
 */
@NotThreadSafe
public final class ApiClassVisitor extends ClassVisitor {

    private final ApiBuilder apiBuilder;

    private TypeBuilder typeBuilder;

    public ApiClassVisitor(ApiBuilder apiBuilder) {
        super(Opcodes.ASM5);
        this.apiBuilder = apiBuilder;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName,
            String[] interfaces) {
        if ((access & Opcodes.ACC_ANNOTATION) == Opcodes.ACC_ANNOTATION) {
            typeBuilder = apiBuilder.createAnnotationTypeBuilder();
        } else if ((access & Opcodes.ACC_INTERFACE) == Opcodes.ACC_INTERFACE) {
            typeBuilder = apiBuilder.createInterfaceTypeBuilder();
        } else if ((access & Opcodes.ACC_ENUM) == Opcodes.ACC_ENUM) {
            typeBuilder = apiBuilder.createEnumTypeBuilder();
        } else {
            typeBuilder = apiBuilder.createClassTypeBuilder();
        }
        typeBuilder.setInternalName(name);
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature,
            String[] exceptions) {
        return super.visitMethod(access, name, desc, signature, exceptions);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature,
            Object value) {
        return super.visitField(access, name, desc, signature, value);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public void visitAttribute(Attribute attr) {
        super.visitAttribute(attr);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc,
            boolean visible) {
        return super.visitTypeAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public void visitOuterClass(String owner, String name, String desc) {
        super.visitOuterClass(owner, name, desc);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }

}
