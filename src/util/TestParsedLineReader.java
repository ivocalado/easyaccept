/*
 * Created on 07/06/2004
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
package util;

import junit.framework.TestCase;

/**
 * Provide the Parsed Line Reader tests.
 * @author Jacques
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class TestParsedLineReader extends TestCase {
	
	/**
	 * Execute the testCommand1 
	 * @throws Exception
	 */
	public void testCommand1() throws Exception {
		ParsedLineReader plr = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'));
		plr.addFile("src/util/test/command1.txt");
		ParsedLine parsedLine = plr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertNull(param.getName());
		assertEquals("a", param.getValue());

		parsedLine = plr.getParsedLine();
		assertNull(parsedLine);
		plr.close();
	}
	
	/**
	 * The method getLineNumber must returns the line number in the script file 
	 * of the last command executed.
	 * The script bellow has two test lines. Thus, the last test script line number
	 * must be 2.
	 * @author Gustavo Farias
	 * @throws Exception
	 */
	public void testGetLineNumber() throws Exception {
		ParsedLineReader plr = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'));
		plr.addFile("src/util/test/command.txt");
		ParsedLine parsedLine = plr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertNull(param.getName());
		assertEquals("a", param.getValue());

		parsedLine = plr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertNull(param.getName());
		assertEquals("b", param.getValue());
		
		assertEquals(2, plr.getLineNumber());
		
		}
	
	/**
	 * Execute the testCommand2
	 * @throws Exception
	 */
	public void testCommand2() throws Exception {
		ParsedLineReader cpr = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'));
		cpr.addFile("src/util/test/command2.txt");
		ParsedLine parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertNull(param.getName());
		assertEquals("one", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertNull(param.getName());
		assertEquals("two", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertNull(param.getName());
		assertEquals("three", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("four", param.getName());
		assertNull(param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("five", param.getName());
		assertNull(param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("six", param.getName());
		assertEquals("seven", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("a", param.getName());
		assertEquals("b", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNull(parsedLine);
		cpr.close();
	}
	/**
	 * Execute the testCommand3 
	 * @throws Exception
	 */
	public void testCommand3() throws Exception {
		ParsedLineReader cpr = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'));
		cpr.addFile("src/util/test/command3.txt");

		ParsedLine parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("a", param.getName());
		assertEquals("", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("b", param.getName());
		assertEquals("hello", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("c", param.getName());
		assertEquals("hello world", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("d", param.getName());
		assertEquals("hello world ", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("e", param.getName());
		assertEquals(" hello world ", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("f", param.getName());
		assertEquals("a    b", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNull(parsedLine);
		cpr.close();
	}
	/**
	 * Execute the escape character test 
	 * @throws Exception
	 */
	public void testEscapeCharacter() throws Exception {
		ParsedLineReader cpr = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'));
		cpr.addFile("src/util/test/testEscapeCharacter.txt");

		ParsedLine parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("param", param.getName());
		assertEquals("value1 22 333 4444", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("param2", param.getName());
		assertEquals("\"", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("param", param.getName());
		assertEquals("phase  with   six spaces", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("param", param.getName());
		assertEquals("doublequotes \" inside", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("param", param.getName());
		assertEquals(" doublequotes ", param.getValue());
		
		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("param", param.getName());
		assertEquals("doublequotes \" inside", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNull(parsedLine);
		cpr.close();
	}
	/**
	 * Execute the variable substitution1 
	 * @throws Exception
	 */
	public void testVariableSubstitution1() throws Exception {
		ParsedLineReader cpr = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'));
		cpr.addFile("src/util/test/variableSubstitution.txt");

		ParsedLine parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("a", param.getName());
		assertEquals("command1", param.getValue());

		cpr.setVariable("a", "command1Return");
		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(3, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("command2", param.getValue());
		assertNull(param.getName());
		param = parsedLine.getParameter(1);
		assertNotNull(param);
		assertEquals("p1", param.getName());
		assertEquals("a", param.getValue());
		param = parsedLine.getParameter(2);
		assertNotNull(param);
		assertEquals("p2", param.getName());
		assertEquals("command1Return", param.getValue());

		try {
			parsedLine = cpr.getParsedLine();
			fail("Expected exception");
		} catch (ParsingException ex) {
		}

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(3, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("command4", param.getValue());
		assertNull(param.getName());
		param = parsedLine.getParameter(1);
		assertNotNull(param);
		assertEquals("p1", param.getName());
		assertEquals("a", param.getValue());
		param = parsedLine.getParameter(2);
		assertNotNull(param);
		assertEquals("p2", param.getName());
		assertEquals("${a}", param.getValue());

		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(3, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("command5", param.getValue());
		assertNull(param.getName());
		param = parsedLine.getParameter(1);
		assertNotNull(param);
		assertEquals("p1", param.getName());
		assertEquals("a", param.getValue());
		param = parsedLine.getParameter(2);
		assertNotNull(param);
		assertEquals("p2", param.getName());
		assertEquals("", param.getValue());

		cpr.setVariable("a", null);
		parsedLine = cpr.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(3, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("command5", param.getValue());
		assertNull(param.getName());
		param = parsedLine.getParameter(1);
		assertNotNull(param);
		assertEquals("p1", param.getName());
		assertEquals("a", param.getValue());
		param = parsedLine.getParameter(2);
		assertNotNull(param);
		assertEquals("p2", param.getName());
		assertEquals("", param.getValue());
	}
	/**
	 * Execute the variable substitution2
	 * @throws Exception
	 */
	public void testVariableSubstitution2() throws Exception {
		Variables variables = makeVariables(); 
		ParsedLineReader cpr1 = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'), variables);
		cpr1.addFile("src/util/test/variableSubstitution1.txt");

		ParsedLine parsedLine = cpr1.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(1, parsedLine.numberOfParameters());
		Parameter param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("a", param.getName());
		assertEquals("command1", param.getValue());
		cpr1.setVariable("a", "command1Return");

		ParsedLineReader cpr2 = new ParsedLineReader(new LogicalLineReader(
				new MultiFileReader(), '#', '\\'), variables);
		cpr2.addFile("src/util/test/variableSubstitution2.txt");
		parsedLine = cpr2.getParsedLine();
		assertNotNull(parsedLine);
		assertEquals(3, parsedLine.numberOfParameters());
		param = parsedLine.getParameter(0);
		assertNotNull(param);
		assertEquals("command2", param.getValue());
		assertNull(param.getName());
		param = parsedLine.getParameter(1);
		assertNotNull(param);
		assertEquals("p1", param.getName());
		assertEquals("a", param.getValue());
		param = parsedLine.getParameter(2);
		assertNotNull(param);
		assertEquals("p2", param.getName());
		assertEquals("command1Return", param.getValue());
	}
	/**
	 * The making variables method return a new VariablesImpl
	 * @return
	 * 			The VariablesImpl Map.
	 */
	private Variables makeVariables() {
		return new VariablesImpl();
	}

}