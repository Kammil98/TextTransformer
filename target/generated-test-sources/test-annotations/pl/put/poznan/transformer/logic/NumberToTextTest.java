package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class NumberToTextTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new NumberToText(t);
		assertEquals("dwadzieścia jeden motyli",t.transform_text("21 motyli"));
	}
	
	@Test
	public void mockTest() {
		TransformInterface mockObject = mock(NumberToText.class);
		when(mockObject.transform_text("21 motyli")).thenReturn("dwadzieścia jeden motyli");
		assertEquals("NumberToText base test", "dwadzieścia jeden motyli",mockObject.transform_text("21 motyli"));
	}
	
	@Test
	public void mockCallTest() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("21 motyli")).thenReturn("21 motyli");
		TransformInterface t = new NumberToText(mockObject);
		t.transform_text("21 motyli");
		verify(mockObject).transform_text("21 motyli");
	}

}
