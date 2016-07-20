/*
 * Unit Test to QuitProcessor class
 * @author  
 */
package easyaccept.script;

import junit.framework.TestCase;
import util.ParsedLine;
import util.ParsedLineReader;
import util.TestUtils;
import easyaccept.QuitSignalException;
import easyaccept.script.test.TestFacade;

/**
 * Provide the Quit test.
 * @author roberta
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestQuitProcessor extends TestCase {

	/**
	 * The set up method
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	/**
	 * The tear down method
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Execute the Quit test.
	 * @throws Exception
	 */
	public void testExecute() throws Exception {
		
		QuitProcessor eqp;
		eqp = new QuitProcessor();
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/scriptQuit01.txt",
				new TestFacade());
		ParsedLineReader plr = script.getParsedLineReader();
		ParsedLine pl = plr.getParsedLine();
		try{
			eqp.execute(script,pl);
			fail();
		}catch(QuitSignalException exc){
			assertTrue( (exc.getMessage().indexOf("Quit command was found")!= -1));
		}
	}

		
}
