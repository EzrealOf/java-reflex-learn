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
		System.out.println("==============本类属性===============");
		// 取得本类全部属性
		Field[] field = demo.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + " ");
		}

		System.out.println("==================获取类方法=====================");
		Method method[] = demo.getMethods();
		for (int i = 0; i < method.length; i++) {
			// 获取返回对象类型
			Class<?> returnType = method[i].getReturnType();
			// 获取class对象类型
			Class<?> para[] = method[i].getParameterTypes();
			// 获取修饰符
			int temp = method[i].getModifiers();
			// 修饰符
			System.out.print(Modifier.toString(temp) + " ");
			// 返回类型
			System.out.print(returnType.getName() + "  ");
			// 函数名称
			System.out.print(method[i].getName() + " ");
			System.out.print("(");
			for (int j = 0; j < para.length; ++j) {
				// 参数
				System.out.print(para[j].getName() + " " + "arg" + j);
				if (j < para.length - 1) {
					System.out.print(",");
				}
			}
			// 异常输出
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
				.println("====================反射调用类方法==========================");
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
				.println("================反射调用set和get方法==========================");
		try {
			// 实例化一个object
			Object obj = demo.newInstance();
			// 通过调用obj获取他的class，获取他的方法和参数
			Method objMethod = obj.getClass().getMethod("setId", int.class);
			// invoke 执行当前方法，第一个参数是对象，第二个是参数的值
			objMethod.invoke(obj, 1);
			// 获取get方法
			objMethod = obj.getClass().getMethod("getId");
			// 执行，参数是执行的对象
			System.out.println(objMethod.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out
				.println("======================通过反射操作属性================================");
		Object objcc = null;
		Field objfield;
		try {
			// 实例化objcc
			objcc = demo.newInstance();
			// 获取字段
			objfield = demo.getDeclaredField("id");
			// 设置可访问，如果该属性是private的，没有这句会报该属性不能被访问
			objfield.setAccessible(true);
			// 设置objcc该字段的值
			objfield.set(objcc, 3);
			// 获得该对象在该字段的值
			System.out.println(objfield.get(objcc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out
				.println("====================通过反射取得并修改数组的信息================================");
		int temp[] = { 1, 2, 3, 4, 5 };
		//返回主键类型的Class
		Class<?>str = temp.getClass().getComponentType();
		System.out.println("数组类型： " + str.getName());
		System.out.println("数组长度  " + Array.getLength(temp));
		System.out.println("数组的第一个元素: " + Array.get(temp, 0));
		Array.set(temp, 0, 100);
		System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
		

	}

}
