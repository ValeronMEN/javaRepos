package btp_lab1_task2;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.Theories;

@RunWith(Theories.class)
public class TheoriesTests {
	@DataPoints
	public static Object[][] data = new Object[][] {
		{ "+4+%+1343", true },
		{ "+49+%+1343", true },
		{ "+49+%+1", true },
		{ "", false },
		{ "+099+%+", false },
		{ "++099+%+995", false }
	};
	
	@Theory
	public void testSwitchFsm(final Object... testData) {
		SwitchFSM fsm = new SwitchFSM();
		boolean result = fsm.scanString(testData[0].toString());
		assertEquals(testData[1], result);
	}
	
	@Theory
	public void testTableFsm(final Object... testData) {
		TableFSM fsm = new TableFSM();
		boolean result = fsm.scanString(testData[0].toString());
		assertEquals(testData[1], result);
	}
	
	@Theory
	public void testStateFsm(final Object... testData) {
		StateFSM fsm = new StateFSM();
		boolean result = fsm.scanString(testData[0].toString());
		assertEquals(testData[1], result);
	}
}
