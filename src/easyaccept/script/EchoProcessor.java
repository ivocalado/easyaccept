/*
 * Created on 03/07/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package easyaccept.script;

import util.ParsedLine;

/**
 * Provide the Echo command.
 * @author Jacques
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EchoProcessor implements Command {

	/**
	 * Execute the echo command.
	 */
	public Object execute(Script script, ParsedLine parsedLine) throws Exception {
		StringBuffer sb = new StringBuffer();
		String separator = "";
		for(int i = 1; i < parsedLine.numberOfParameters(); i++) {
			sb.append(separator);
			sb.append(parsedLine.getParameter(i).getValue());
			separator = " ";
		}
		return sb.toString();
	}

}
