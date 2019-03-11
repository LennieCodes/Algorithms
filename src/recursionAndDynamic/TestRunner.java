package recursionAndDynamic;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestRunner {
	@Test 
	public void countWaysTest() {
		int steps = 3; 
		int result = RecursionAndDynamic.countWays(steps);
		if (RecursionAndDynamic.countWays(steps) != 4) {
			fail("Expected 4 but countWays returned:" +  result);
		} 
	}
}
