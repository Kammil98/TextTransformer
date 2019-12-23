package pl.put.poznan.transformer.logic;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TextTransformerTest {

	@Test
	public void test() {
		TextTransformer t=new TextTransformer();
		t.setTextToChange("ola ola");
		String[] transformacje = {"delete","upper"};
		t.setTransforms(transformacje);
		assertEquals("OLA",t.transform("ola ola"));	
		
	}
	
	
	@Test
	public void mockCallTest1() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("ola")).thenReturn("ola");
		TransformInterface t = new Capitalize(new Inverse(mockObject));
		t.transform_text("ola");
		verify(mockObject).transform_text("ola");
	}
	
	@Test
	public void mockCallTest2() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("ola")).thenReturn("ola");
		TransformInterface t = new ToLower(new ToUpper(mockObject));
		t.transform_text("ola");
		verify(mockObject).transform_text("ola");
	}
	
	@Test
	public void mockCallTest3() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("ola")).thenReturn("ola");
		TransformInterface t = new DeleteRepetition(new NumberToText(mockObject));
		t.transform_text("ola");
		verify(mockObject).transform_text("ola");
	}
}
