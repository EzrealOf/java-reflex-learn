package com.ezreal.test;
import java.lang.reflect.*;

public class Reflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Class<?> demo = null;
		try {
			demo = Class.forName("com.ezreal.user.Account");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(demo.getName());
		System.out.println("==============��������===============");
		// ȡ�ñ���ȫ������
		Field[] field = demo.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// Ȩ�����η�
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// ��������
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + " ");
		}

		System.out.println("==================��ȡ�෽��=====================");
		Method method[] = demo.getMethods();
		for (int i = 0; i < method.length; i++) {
			// ��ȡ���ض�������
			Class<?> returnType = method[i].getReturnType();
			// ��ȡclass��������
			Class<?> para[] = method[i].getParameterTypes();
			// ��ȡ���η�
			int temp = method[i].getModifiers();
			// ���η�
			System.out.print(Modifier.toString(temp) + " ");
			// ��������
			System.out.print(returnType.getName() + "  ");
			// ��������
			System.out.print(method[i].getName() + " ");
			System.out.print("(");
			for (int j = 0; j < para.length; ++j) {
				// ����
				System.out.print(para[j].getName() + " " + "arg" + j);
				if (j < para.length - 1) {
					System.out.print(",");
				}
			}
			// �쳣���
			Class<?> exce[] = method[i].getExceptionTypes();
			if (exce.length > 0) {
				System.out.print(") throws ");
				for (int k = 0; k < exce.length; ++k) {
					System.out.print(exce[k].getName() + " ");
					if (k < exce.length - 1) {
						System.out.print(",");
					}
				}
			} else {
				System.out.print(")");
			}
			System.out.println();

		}

		System.out
				.println("====================��������෽��==========================");
		try {

			Method setMethod = demo.getMethod("setId", int.class);
			setMethod.invoke(demo.newInstance(), 10);
			setMethod = demo.getMethod("sayHello", String.class);
			setMethod.invoke(demo.newInstance(), "world!");
			// System.out.println(demo.toString());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out
				.println("================�������set��get����==========================");
		try {
			// ʵ����һ��object
			Object obj = demo.newInstance();
			// ͨ������obj��ȡ����class����ȡ���ķ����Ͳ���
			Method objMethod = obj.getClass().getMethod("setId", int.class);
			// invoke ִ�е�ǰ��������һ�������Ƕ��󣬵ڶ����ǲ�����ֵ
			objMethod.invoke(obj, 1);
			// ��ȡget����
			objMethod = obj.getClass().getMethod("getId");
			// ִ�У�������ִ�еĶ���
			System.out.println(objMethod.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out
				.println("======================ͨ�������������================================");
		Object objcc = null;
		Field objfield;
		try {
			// ʵ����objcc
			objcc = demo.newInstance();
			// ��ȡ�ֶ�
			objfield = demo.getDeclaredField("id");
			// ���ÿɷ��ʣ������������private�ģ�û�����ᱨ�����Բ��ܱ�����
			objfield.setAccessible(true);
			// ����objcc���ֶε�ֵ
			objfield.set(objcc, 3);
			// ��øö����ڸ��ֶε�ֵ
			System.out.println(objfield.get(objcc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out
				.println("====================ͨ������ȡ�ò��޸��������Ϣ================================");
		int temp[] = { 1, 2, 3, 4, 5 };
		//�����������͵�Class
		Class<?>str = temp.getClass().getComponentType();
		System.out.println("�������ͣ� " + str.getName());
		System.out.println("���鳤��  " + Array.getLength(temp));
		System.out.println("����ĵ�һ��Ԫ��: " + Array.get(temp, 0));
		Array.set(temp, 0, 100);
		System.out.println("�޸�֮�������һ��Ԫ��Ϊ�� " + Array.get(temp, 0));
		

	}

}
