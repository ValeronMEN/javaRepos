package btp_lab1_task2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParamTests {
 
     private String regex;
     private boolean expected;
      
    
     public ParamTests (String regex, boolean expected){
         this.regex = regex;
         this.expected = expected;
     }
     
     @Parameters
     public static List<Object[]> data() {
    	 Object[][] data = new Object[][] {
    			 { "+4+%+1343", true },
    			 { "+49+%+1343", true },
    			 { "+49+%+1", true },
    			 { "", false },
    			 { "+099+%+", false },
    			 { "++099+%+995", false }
    	 };
    	 return Arrays.asList(data);
     }
 
     @Test
     public void testSwitchFsm(){
    	 SwitchFSM switchFsm = new SwitchFSM();
         assertEquals(expected, switchFsm.scanString(regex));
     }
     
     @Test
     public void testTableFsm(){
    	 TableFSM tableFsm = new TableFSM();
         assertEquals(expected, tableFsm.scanString(regex));
     }
     
     @Test
     public void testStateFsm(){
    	 StateFSM stateFsm = new StateFSM();
         assertEquals(expected, stateFsm.scanString(regex));
     }
}
