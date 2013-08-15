import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DebugProxy implements java.lang.reflect.InvocationHandler {

	private Object obj;

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Object obj) {
		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new DebugProxy(obj));
	}

	private DebugProxy(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result;
		boolean flag = getFlag(m);
		try {
			if (flag) {
				System.out.println("before method " + m.getName());
			}
			result = m.invoke(obj, args);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
		} finally {
			if (flag) {
				System.out.println("after method " + m.getName());
			}
		}
		return result;
	}

	private boolean getFlag(Method m) throws Exception {
		//Annotation annotation = m.getAnnotation(Tran.class);
		Annotation annotation = obj.getClass().getMethod(m.getName(), m.getParameterTypes()).getAnnotation(Tran.class);

		if (annotation == null) {
			return false;
		} else {
			return true;
		}
	}
}