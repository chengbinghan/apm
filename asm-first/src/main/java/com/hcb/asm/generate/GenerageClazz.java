package com.hcb.asm.generate;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author ChengBing Han
 * @date 14:36  2018/5/29
 * @description 生成一个接口
 */
public class GenerageClazz {


    public static void main(String[] args) throws IOException {

        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                "com/hcb/asm/generate1/Comparable1", null, "java/lang/Object",
                new String[]{"com/hcb/asm/generate123"});
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I",
                null, new Integer(1)).visitEnd();
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I",
                null, new Integer(2)).visitEnd();
        cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();

        byte[] b = null;
        b = cw.toByteArray();


        //将上述生成的byts 写入一个XX.class 文件中，再通过一个反编译软件就可以看到生成的类。
        File file = new File("Comparable1.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(b);

        fos.close();

    }
}
