package text;  // DO NOT CHANGE THIS OR YOU WILL GET ZERO

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;



/**
 * SOFTENG 254 Assignment 1 submission template
 *
 * Author: (Yujia Wu, ywu660)
 **/

public class TestFlushLeft {// DO NOT CHANGE THE CLASS NAME OR YOU WILL GET ZERO

	List<String> output; 

	@Before
	public void Initialise() {
		output = new ArrayList<String>();
	}
	
	
	@Rule
	public Timeout timeout = Timeout.seconds(1);


	// Your tests here.
	
	/**Test the normal case,test if the adjacent printable character is in the right oder.
	 * does all printable characters appear at output. 
	 * Test when the txt over the line width, it will change to a new line.
	 */
	@Test
	public void TestGeneralCase() {
		String input = "1234567890 1234";
		//List<String> output = new ArrayList<String>();
		output.add("1234567890");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}
	
	
    //1.Test space
	/**Test when space at the start of input text.
	 * The expect output should have no white space at the start of line.
	 */
	@Test
	public void TestOneSpaceAtBegining() {
		String input = " 12345";
		List<String> output = new ArrayList<String>();
		output.add("12345");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}



	/**Test when one space at the end of input text.
	 * The expect output should have no white space at the end of line.
	 */
	@Test
	public void TestOneSpaceAtEnd() {
		String input = "12345 ";
		output.add("12345");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}



	/**Test when normal space at the middle of input text.
	 * The expect output should have one space between the word.
	 */
	@Test 
	public void TestOneSpeceAtMiddle() {
		String input = "I love you";
		output.add("I love you");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}

	/**Test when multiple space at the middle of input text.
	 * The expect output should have only one space between the word.
	 */
	@Test 
	public void TestMoreSpeceAtMiddle() {
		String input = "I    love";
		output.add("I love");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}
	
	
    //2.new Line
	/**Test when new line character at the end of input text.
	 * The expect output should have only have no new line 
	 * character at the end of line.
	 */ 
	@Test (timeout = 1000)
	public void TestOneNewLineAtEnd() {  //need to change
		String input = "12345678\n";
		output.add("12345678");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}


	/**Test when new line character at the middle of input text.
	 * The expect output should split the text into a new line
	 *  even though the input did not exist the line width
	 */
	@Test 
	public void TestOneNewLineAtMiddle() {
		String input = "12345\n67890";
		output.add("12345");
		output.add("67890");
		assertEquals(output,text.Formatter.flushLeftText(input,20));
	}

	/**Test when multiple new line character at the middle of input text.
	 * The expect output should only split the text into a new line once.
	 */
	@Test  
	public void TestMoreNewLineAtMiddle() {
		String input = "123\n\n\n678";
		output.add("123");
		output.add("678");
		assertEquals(output,text.Formatter.flushLeftText(input,20));
	}

	/**Test when one new line character at the start of input text.
	 * The expect output should have no new line character at start.
	 */
	@Test
	public void TestOneNewLineAtBegining() {
		String input = "\n12345";
		output.add("12345");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}

    //3.tab
	/**Test when one tab at end of input text.
	 * The expect output should have no tab at end.
	 */
	@Test 
	public void TestTabAtEnd() {
		String input = "12345\t";
		output.add("12345");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}


	/**Test when one tab at the start of input text.
	 * The expect output should have no tab at start.
	 */
	@Test 
	public void TestTabAtBegin() {
		String input = "\t12345";
		output.add("12345");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}


	/**Test when one tab at middle of input text.
	 * The expect output should have only one space to split the world.
	 */
	@Test
	public void TestOneTabAtMiddle() {
		String input = "1234\t1234";
		output.add("1234 1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}

	/**Test when multiple tab at middle of input text.
	 * The expect output should have only one space to split the world.
	 */
	@Test 
	public void TestMoreTabAtMiddle() {
		String input = "12\t\t\t1234";
		output.add("12 1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}
     
	//4.Multiple together
	/**Test when space and new line character in the text at same time.
	 * The expect output should have spilt into a new line at the new 
	 * line character with no white space at the end of the line.
	 */
	@Test
	public void TestSpaceAndNewLine() {
		String input = "1  \n1234";
		output.add("1");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}

	/**Test when space and new line character in the text at same time.
	 * The expect output should have spilt into a new line at the new 
	 * line character with no white space at start of the new line.
	 */
	@Test 
	public void TestNewLineAndSpace() {
		String input = "1\n  1234";
		output.add("1");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}

	/**Test when tab and new line character in the text at same time.
	 * The expect output should have spilt into a new line at the new 
	 * line character with no white space at the end of the line.
	 */
	@Test 
	public void TestTabAndNewLine() {
		String input = "1\t\n1234";
		output.add("1");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}

	/**Test when tab and new line character in the text at same time.
	 * The expect output should have spilt into a new line at the new 
	 * line character with no white space at the start of new line.
	 */
	@Test
	public void TestNewLineAndTab() {
		String input = "1\n\t1234";
		output.add("1");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}

	
	//5.Non-sense Line Width
	/**
	 * Test non sense zero line width , should send the exception
	 */
	@Test 
	public void TestZeroSenceLineWidth() {
		String input = "1234";
		output.add("1234");
		try {
			assertEquals(0,text.Formatter.flushLeftText(input,0));
			fail("None sence Line width");
		}catch(IllegalArgumentException e){
			assertEquals("Constraints cannot be satisfied",e.getMessage());
		}		

	}
	
	
    /**
	 * Test non sense negative line width , should send the exception
	 */
	@Test 
	public void TestNegativeLineWidth() {
		String input = "1234";
		try {
			assertEquals(0,text.Formatter.flushLeftText(input,-1));
			fail("Line width cannot be negative.");
		}catch(IllegalArgumentException e) {
			assertEquals("Constraints cannot be satisfied",e.getMessage());
		}
	}
	
	//6. line width = 1
	/**
	 * Test non sense 1 line width, should send the exception due to hyphen
	 * This will not output the 1,2,3,4 due to the rule.
	 */
	@Test 
	public void TestOneLineWidth() {
		String input = "12";
		try {
			assertEquals(0,text.Formatter.flushLeftText(input,1));
			fail("Invalid line wide.");
		}catch(IllegalArgumentException e) {
			assertEquals("Constraints cannot be satisfied",e.getMessage());
		}

	}
	
	/**This test will not be satisfied due to the hyphenated rule
	 * This one should send exception two.
	 */
	@Test 
	public void TestOneWidthWithHyprnAtEnd() {
		String input = "1-";
		try {
			assertEquals(0,text.Formatter.flushLeftText(input,1));
			fail("Invalid line wide for word wit hyphen.");
		}catch(IllegalArgumentException e) {
			assertEquals("Constraints cannot be satisfied",e.getMessage());
		}

	}
	
	/**Test when the word has hyphen and one line width.
	 * This test should return the hyphen and 1.
	 */
	@Test 
	public void TestOneWidthWithHyprnAtBegining() {
		String input = "-1";
		output.add("-");
		output.add("1");
		assertEquals(output,text.Formatter.flushLeftText(input,1));
		

	}

	
    //7.long word
	/**The test test when the text did not exist the line width,it will not 
	 * split into a new line.
	 */
	@Test 
	public void TestWordShorterThanLineWidth() {
		String input = "1234";
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}

	/**Test when the text width is sane as the line width
	 *It should not split the word into a new line
	 */
	@Test 
	public void TestWordSameThanLineWidth() {
		String input = "12345";
		output.add("12345");
		assertEquals(output,text.Formatter.flushLeftText(input,5));

	}
	
    /** Test when the world is longer than the line width and has no hyphenated
     *  The output should split the word and add the hyphenated at the line 
     *  width position.
     */
	@Test
	public void TestWordLongerThanLineWidthWithoutHyphen() {
		String input = "123456789";
		output.add("1234-");
		output.add("56789");
		assertEquals(output,text.Formatter.flushLeftText(input,5));
	}

    /**Test if hyphen will split at the right place when the nearest hyphen is 
     * just outside the line width,the test if it will add a new hyphen
     * at the line width.
     */
	@Test 
	public void TestWordHasHyphenOutsideLineWidth() {
		String input = "1234-1234";
		output.add("123-");
		output.add("4-");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,4));

	} 
	
    /**Test when the hyphen is just at the line width.
     * Test if the word will split at the nearest hyphen and 
     * do not need to add a new hyphen.
     */
	@Test
	public void TestWordHasHyphenAtLineWidth() {

		String input = "123-1234";
		output.add("123-");
		output.add("1234");
		assertEquals(output,text.Formatter.flushLeftText(input,4));

	} 

	/**Test the hyphen inside the line width.
     * Test if the word will split at the nearest hyphen without add a new hyphen.
     */
	@Test
	public void TestHyphenInsideLineWidth() {
		String input = "12-34";
		output.add("12-");
		output.add("34");
		assertEquals(output,text.Formatter.flushLeftText(input,4));

	}
	
	
    
	/**Test word with multiple hyphen
     * Test if the nearest hyphen will split to a new line
     */
	@Test 
	public void TestWordHasMoreHyphen() {
		String input = "123---78";
		output.add("123--");
		output.add("-78");
		assertEquals(output,text.Formatter.flushLeftText(input,5));
	} 
	
	
	/**Test when input only has hyphen and the line width is 1
     * the expected output is one hyphen at each line
     */
	@Test 
	public void TestOnlyHyphen() {
		String input = "---";
		output.add("-");
		output.add("-");
		output.add("-");
		assertEquals(output,text.Formatter.flushLeftText(input,1));
	}
	
	
    //8.Test input null
	/**Test invalid input as null String, should send exception*/
	@Test
	public void TestNullInput() {
		String input = null;
		try {
			assertEquals(0,text.Formatter.flushLeftText(input,10));
			fail("Text cannot be null");
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid text (null)",e.getMessage());
		}


	}
	
    //9.Test input with only white space
	/**Test invalid input is empty space, the expect output should be emprt list
	 * when line width is long*/
	@Test 
	public void TestEmptyInput() {
		String input = "  ";
		List<String> output = new ArrayList<String>();
		output.add("");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}

	/**Test invalid input is new line, the expect output should be empty list
	 * when line width is long*/
	@Test 
	public void TestNewlineAsInput() {
		String input = "\n";
		List<String> output = new ArrayList<String>();
		output.add("");
		assertEquals(output,text.Formatter.flushLeftText(input,10));

	}

	/**Test invalid input is tab, the expect output should be empty list
	 *  when line width is long*/
	@Test (timeout = 1000)
	public void TestTabAsInput() {
		String input = "\t";
		output.add("");
		assertEquals(output,text.Formatter.flushLeftText(input,10));
	}
	
	
	//10.Test white-space input with 0 line width
	/**Test  input is tab, the expect output should be empty list
	 *  when line width is 0*/
	@Test 
	public void TestTabAsInputAndZeroIndex() {
		String input = "\t";
		output.add("");
		assertEquals(output,text.Formatter.flushLeftText(input,0));
	}

	/**Test invalid input is new line, the expect output should be empty list
	 *  when line width is 0*/
	@Test 
	public void TestNewLineAsInputAndZeroIndex() {
		String input = "\n";
		output.add("");
		assertEquals(output,text.Formatter.flushLeftText(input,0));
	}

	/**Test invalid input is white space, the expect output should be empty list
	 *  when line width is 0*/
	@Test 
	public void TestEmptyAsInputAndZeroIndex() {
		String input = "  ";
		output.add("");
		assertEquals(output,text.Formatter.flushLeftText(input,0));
	}
	
	
	//11.Overload input
	@Test
	public void TestTooLargeInput() {
		String input = "";
		for(int i=0;i<100;i++) {
			input = input+"12345 ";
			output.add("12345");
		}
		assertEquals(output,text.Formatter.flushLeftText(input, 5));
	}

}
