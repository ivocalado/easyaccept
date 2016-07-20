package easyaccept.script;

import junit.framework.TestCase;
import util.TestUtils;
import easyaccept.result.Result;
import easyaccept.script.test.TestFacade;
/**
 * Provide Script tests.
 * @author WinXP
 * @author Gustavo Farias
 */
public class TestScript extends TestCase {
	
	private static String SEPARATOR = System.getProperty("file.separator");
	
	private static String TEST_FILES_PATH = "src"+SEPARATOR+"easyaccept"+SEPARATOR+"script"+SEPARATOR+"test"+SEPARATOR;
	
	/**
	 * Test Script1.
	 * @throws Exception
	 */
	public void testScript1() throws Exception {
		Script script = TestUtils.createJavaAppScript(TEST_FILES_PATH+"script1.txt", new TestFacade()); 
		Result result = (Result) script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script3.
	 * @throws Exception
	 */
	public void testScript2() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script2.txt", new TestFacade());
		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("commandReturningString", result.getCommand());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());
		assertEquals("result commandReturningString", result.getResult());
		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script3.
	 * @throws Exception
	 */
	public void testScript3() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script3.txt", new TestFacade());

		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertTrue(result.getCommand().indexOf("stringdelimiter") != -1);
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());
		assertEquals("OK", result.getResult());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("commandReturningString param1=hello", result.getCommand());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());
		assertEquals("HELLO", result.getResult());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("commandReturningString param1=\" hello \"", result
				.getCommand());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());
		assertEquals(" HELLO ", result.getResult());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script4.
	 * @throws Exception
	 */
	public void testScript4() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script4.txt", new TestFacade());

		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("throwException message=\"An Exception\"", result
				.getCommand());
		assertNull(result.getResult());
		assertTrue(result.hasError());
		assertEquals("An Exception", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("qwerty", result.getCommand());
		assertNull(result.getResult());
		assertTrue(result.hasError());
		assertEquals("Line 2: Unknown command: qwerty", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script5.
	 * @throws Exception
	 */
	public void testScript5() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script5.txt",
				new TestFacade());

		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect HELLO commandReturningString param1=hello", result
				.getCommand());
		assertEquals("OK", result.getResult());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals(
				"expect \"HELLO WORLD\" commandReturningString param1=\"hello world\"",
				result.getCommand());
		assertEquals("OK", result.getResult());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script6.
	 * @throws Exception
	 */
	public void testScript6() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script6.txt",
				new TestFacade());

		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect", result.getCommand());
		assertNull(result.getResult());
		assertTrue(result.hasError());
		assertEquals(
				"Line 2, file src/easyaccept/script/test/script6.txt: Syntax error: expect <string> <command ...>",
				result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect HELLO", result.getCommand());
		assertNull(result.getResult());
		assertTrue(result.hasError());
		assertEquals(
				"Line 3, file src/easyaccept/script/test/script6.txt: Syntax error: expect <string> <command ...>",
				result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script7.
	 * @throws Exception
	 */
	public void testScript7() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script5.txt",
				new TestFacade());
		assertTrue(script.executeAndCheck());
		assertEquals(2, script.getResultManager().getResults().size());
		script.close();
	}
	/**
	 * Test Script8.
	 * @throws Exception
	 */
	public void testScript8() throws Exception {
		Script script = TestUtils.createJavaAppScript(
				"src/easyaccept/script/test/script6.txt", new TestFacade());
		assertFalse(script.executeAndCheck());
		assertEquals(2, script.getResultManager().getResults().values().size());
		assertEquals(
				"Line 2, file src/easyaccept/script/test/script6.txt: Syntax error: expect <string> <command ...>"
						+ System.getProperty("line.separator")
						+ "Command producing error: <expect>"
						+ System.getProperty("line.separator")
						+ "Line 3, file src/easyaccept/script/test/script6.txt: Syntax error: expect <string> <command ...>"
						+ System.getProperty("line.separator")
						+ "Command producing error: <expect HELLO>"
						+ System.getProperty("line.separator"), script.allErrorMessages());
		script.close();
	}
	/**
	 * Test Script9.
	 * @throws Exception
	 */
	public void testScript9() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script7.txt",
				new TestFacade());

		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertTrue(result.getCommand().indexOf("stringdelimiter") != -1);
		assertEquals("OK", result.getResult());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect HELLO commandReturningString param1=hello", result
				.getCommand());
		assertEquals("OK", result.getResult());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals(
				"expect 'HELLO WORLD' commandReturningString param1='hello world'",
				result.getCommand());
		assertEquals("OK", result.getResult());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script10.
	 * @throws Exception
	 */
	public void testScript10() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script8.txt",
				new TestFacade());
		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect OK throwException message=\"exception message\"",
				result.getCommand());
		assertNull(result.getResult());
		assertTrue(result.hasError());
		assertEquals(
				"Line 1, file src/easyaccept/script/test/script8.txt: Unexpected error: exception message",
				result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script11.
	 * @throws Exception
	 */
	public void testScript11() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script9.txt",
				new TestFacade());
		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect HELLOO commandReturningString param1=hello", result
				.getCommand());
		assertNull(result.getResult());
		assertTrue(result.hasError());
		assertEquals(
				"Line 1, file src/easyaccept/script/test/script9.txt: Expected <HELLOO>, but was <HELLO>",
				result.getErrorMessage());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Test Script12.
	 * @throws Exception
	 */
	public void testScript12() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script10.txt",
				new TestFacade());
		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("expect true returnTrue", result.getCommand());
		assertFalse(result.hasError());
		assertEquals("(no exception)", result.getErrorMessage());
		assertEquals("OK", result.getResult());

		result = script.getAndExecuteCommand();
		assertNull(result);
		script.close();
	}
	/**
	 * Execute the match test.
	 * @throws Exception
	 */
	public void testMethodMatch() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script11.txt",
				new TestFacade());
		Result result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("commandManyParameters param1=hello param2=hellow", result
				.getCommand());
		assertFalse(result.hasError());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals("commandManyParametersNum param1=123 param2=456", result
				.getCommand());
		
		assertFalse(result.hasError());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals(
				"expect 123456 commandManyParametersNum param1=123 param2=456",
				result.getCommand());
		assertFalse(result.hasError());

		result = script.getAndExecuteCommand();
		assertNotNull(result);
		assertEquals(
				"expect 5 commandManyParametersPrimitive param1=2 param2=3",
				result.getCommand());
		assertFalse(result.hasError());

		script.close();
	}
	/**
	 * Provide the parameters syntax test.
	 * @throws Exception 
	 */
	public void testParameterPassingSyntax() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script18.txt",
				new TestFacade());
		for(int i = 0; i < 4; i++) {
			Result result = script.getAndExecuteCommand();
			assertNotNull(result);
			assertFalse(""+i, result.hasError());
			assertEquals("OK", result.getResult());
		}
		script.close();
	}
	/**
	 * Execute the expectDiffrente test.
	 * @throws Exception
	 */
	public void testExpectDifferent() throws Exception {
		Script script = TestUtils.createJavaAppScript("src/easyaccept/script/test/script21.txt",
				new TestFacade());
		Result result = script.getAndExecuteCommand();
		
		assertNotNull(result);
	
		assertFalse(result.hasError());
		result = script.getAndExecuteCommand();
		assertTrue(result.hasError());
		assertEquals("Line 2, file src/easyaccept/script/test/script21.txt: Expected different from <hi>, but was <hi>", result.getErrorMessage());
		result = script.getAndExecuteCommand();
		assertNull(result);
		
		
		
		script.close();
	}

}