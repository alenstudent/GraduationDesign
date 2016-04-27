import org.junit.Test;

import com.aaron.demo.model.Demo;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年3月18日 下午11:21:07
* 类说明：TODO
*/
public class ClassNameTest {

	@Test
	public void testClassName() {
		System.out.println(Demo.class.getName());
		System.out.println(Demo.class.getSimpleName());
	}
	public void testMD5() {
		System.out.println();
	}
}
