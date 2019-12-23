package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class InverseTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new Inverse(t);
		assertEquals("ikar łapał rakI",t.transform_text("Ikar łapał raki"));
	}
	
	@Test
	public void mockTest() {
		TransformInterface mockObject = mock(Inverse.class);
		when(mockObject.transform_text("ola")).thenReturn("alo");
		assertEquals("Inverse base test", "alo",mockObject.transform_text("ola"));
	}
	
	@Test
	public void mockCallTest() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("ola")).thenReturn("ola");
		TransformInterface t = new Inverse(mockObject);
		t.transform_text("ola");
		verify(mockObject).transform_text("ola");
	}

}
