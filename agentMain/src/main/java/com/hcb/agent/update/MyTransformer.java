package com.hcb.agent.update;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;

import java.security.ProtectionDomain;

/**
 * @author ChengBing Han
 * @date 13:48  2018/6/7
 * @description
 */
public class MyTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        byte[] bytes = null;
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = null;
        try {
            cc = cp.get("com.hcb.agent.update.HcbSimplePrincipal");
            CtConstructor ctc = cc.getConstructors()[0];
            ctc.setBody("{name=\"modify name11111111111\";this.name = name;}");
            System.out.println("modify name1111111111111=================>");

            final Class<? extends CtConstructor> aClass = ctc.getClass();
            bytes = cc.toBytecode();
            cc.defrost();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
