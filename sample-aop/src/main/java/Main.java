/**
 * http://docs.oracle.com/javase/jp/6/technotes/guides/reflection/proxy.html<br>
 * 
 * @author eisakuu
 * 
 */
public class Main {
	public static void main(String[] args) {
		SampleService sampleService = DebugProxy.newInstance(new SampleServiceImpl());
		sampleService.execute1();
		sampleService.execute2();
	}
}
