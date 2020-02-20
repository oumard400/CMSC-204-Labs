/**
 * 
 */
package Gradebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Oumar Diallo
 *
 */
class GradeBookTester {
	GradeBook gBook1;
	GradeBook gBook2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		gBook1 = new GradeBook(5);
		gBook1.addScore(95);
		gBook1.addScore(85);
		
		gBook2 = new GradeBook(5);
		gBook2.addScore(100);
		gBook2.addScore(70);
		gBook2.addScore(90);
		
		}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		gBook1 = null;
		gBook2 = null;
	}

	@Test
	public void sum() {
		assertEquals(180,gBook1.sum(),.0001);
		assertEquals(260, gBook2.sum(),.0001);
	}
	
	@Test
	public void minimum() {
		assertEquals(85,gBook1.minimum(),.001);
		assertEquals(70, gBook2.minimum(),.001);
	}
	
	@Test
	public void addScore() {
		assertTrue(gBook1.toString().equals(" 95.0 85.0 "));
		assertTrue(gBook2.toString().equals(" 100.0 70.0 90.0 "));
		
	}
	
	@Test
	public void finalScore() {
		assertEquals(95.0,gBook1.finalScore(),.001);
		assertEquals(190.0, gBook2.finalScore(),.001);
	}

}
