package eu.sample.java.spring.redis;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author eisakuu
 * 
 */
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/ApplicationContext.xml");

		SampleService sampleService = (SampleService)applicationContext.getBean("sampleService");
		sampleService.save("aa", "tes");
		System.out.println(sampleService.get("aa"));
	}
}
