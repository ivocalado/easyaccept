package easyaccept;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Make all EasyAccept tests by using a suite test.
 * @author Jacques
 *
 */
public class AllTestsEasyAccept {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		//$JUnit-BEGIN$
		suite.addTest(util.AllTestsUtil.suite());
		suite.addTest(easyaccept.script.AllTestsScript.suite());
		suite.addTestSuite(TestEasyAcceptTask.class);
		suite.addTestSuite(EasyAcceptFacadeTest.class);
		//$JUnit-END$
		return suite;
	}
	
}
