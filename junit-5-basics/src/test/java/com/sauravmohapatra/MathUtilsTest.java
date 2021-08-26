package com.sauravmohapatra;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Testing Class for MathUtils")
class MathUtilsTest {
	
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all test methods");
	}
	
	@AfterAll
	static void afterAllInit() {
		System.out.println("This needs to run after all test methods");
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up...");
	}
	
	
	@Test
	@DisplayName("TDD, should be disabled for build to happen")
	@Disabled
	@Tag("NoMath")
	void testDisabled() {
		fail("TDD, should be disabled for build to happen");
	}
	
	@Nested
	@DisplayName("Testing Class for Add Method")
	@Tag("BasicMath")
	class AddTest {
		
		@Test
		@DisplayName("Basic Testing Add Method")
		void testAdd() {
			boolean isServerUp = true;
			assumeTrue(isServerUp);
			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected, actual,"This method adds two numbers");
		}
		
		@Test
		@DisplayName("Testing Addition of Positive Numbers")
		void testAddPositiveNumbers() {
			boolean isServerUp = true;
			assumeTrue(isServerUp);
			int expected = 5;
			int actual = mathUtils.add(2, 3);
			assertEquals(expected, actual,"This method adds two numbers");
		}
		
		@Test
		@DisplayName("Testing Addition of Negative Numbers")
		void testAddNegativeNumbers() {
			boolean isServerUp = true;
			assumeTrue(isServerUp);
			int expected = -3;
			int actual = mathUtils.add(-2, -1);
			assertEquals(expected, actual,() -> "This method adds two numbers where actual is " + actual + " and expected is " + expected);
		}
		
	}
	
	@Test
	@DisplayName("Testing Multiply Method")
	@Tag("BasicMath")
	void testMultiply() {
		//System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2),"This method multiplies two numbers"),
				() -> assertEquals(0, mathUtils.multiply(2, 0),"This method multiplies two numbers"),
				() -> assertEquals(-4, mathUtils.multiply(-2, 2),"This method multiplies two numbers")
				);
	}
	
	@RepeatedTest(3)
	@DisplayName("Testing Compute Area of Circle Method")
	@Tag("AdvancedMath")
	void testComputeCircleArea() {
		double expected = Math.PI*10*10;
		double actual = mathUtils.computeCircleArea(10);
		assertEquals(expected,actual,"This method computes area of circle");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Testing Divide Method")
	@Tag("BasicMath")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by Zero Exception should be Thrown");
	}

}
