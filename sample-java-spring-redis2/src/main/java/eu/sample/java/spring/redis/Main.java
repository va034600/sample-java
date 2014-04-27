package eu.sample.java.spring.redis;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 参考<br>
 * http://tm8r.hateblo.jp/entry/20120329/1333033094
 * 
 * @author eisakuu
 * 
 */
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/ApplicationContext.xml");

		SampleService2 sampleService2 = (SampleService2)applicationContext.getBean("sampleService2");

		Pojo pojo = new Pojo();
		pojo.setKey(1);
		pojo.setValue("a");
		pojo.setDate(new Date());

		sampleService2.save("bb", pojo);

		Pojo pojo2 = sampleService2.get("bb");
		System.out.println(pojo2);
	}
}
