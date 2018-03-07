package btp_lab1_task2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {
	private SwitchFSM switchFsm;
	private TableFSM tableFsm;
	private StateFSM stateFsm;

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
        Result result = runner.run(Main.class);
        System.out.println("Run tests count: " + result.getRunCount());
        System.out.println("Failed tests count: " + result.getFailureCount());
        boolean success = result.wasSuccessful();
        System.out.println("Success: " + success);
        if (!success){
        	System.out.println("Failures: " + result.getFailures());
        }
        return;
	}
	
	@Before
	public void init() {
		switchFsm = new SwitchFSM();
		stateFsm = new StateFSM();
		tableFsm = new TableFSM();
	}
	
	@After
	public void tearDown() { 
		switchFsm = null; 
		stateFsm = null;
		tableFsm = null;
	}
	
	@Test
    public void switchFsm_switchMethodCorrectRegEx_true() {
        assertTrue(switchFsm.scanString("+49+%+1"));
    }
	
	@Test
	public void tableFsm_tableMethodCorrectRegEx_true() {
        assertTrue(tableFsm.scanString("+0923432+%+995"));
    }
	
	@Test
	public void stateFsm_stateMethodCorrectRegEx_true() {
        assertTrue(stateFsm.scanString("+10132+%+345"));
    }
	
	@Test
    public void switchFsm_switchMethodNullString_false() {
        assertTrue(!switchFsm.scanString(""));
    }
	
	@Test
	public void tableFsm_tableMethodNullString_false() {
        assertTrue(!tableFsm.scanString(""));
    }
	
	@Test
	public void stateFsm_stateMethodNullString_false() {
        assertTrue(!stateFsm.scanString(""));
    }
	
	@Test
    public void fsm_switchMethodRegExWithoutElement_false() {
        assertTrue(!switchFsm.scanString("+099+%+"));
    }
	
	@Test
	public void tableFsm_tableMethodRegExWithoutElement_false() {
        assertTrue(!tableFsm.scanString("+099++995"));
    }
	
	@Test
	public void stateFsm_stateMethodRegExWithoutElement_false() {
        assertTrue(!stateFsm.scanString("+099%+995"));
    }
	
	@Test
    public void switchFsm_switchMethodRegExInExcess_false() {
        assertTrue(!switchFsm.scanString("++099+%+995"));
    }
	
	@Test
	public void tableFsm_tableMethodRegExInExcess_false() {
        assertTrue(!tableFsm.scanString("+099+%%+995"));
    }
	
	@Test
	public void stateFsm_stateMethodRegExInExcess_false() {
        assertTrue(!stateFsm.scanString("+099+%+995tt"));
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void stateFsm_stateMethodNullState_false() {
        assertTrue(!stateFsm.scanString(null));
    }
}

