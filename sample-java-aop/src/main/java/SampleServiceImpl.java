public class SampleServiceImpl implements SampleService {
	@Override
	public void execute1() {
		System.out.println("execute1");
	}

	@Tran
	@Override
	public void execute2() {
		System.out.println("execute2");
	}
}
