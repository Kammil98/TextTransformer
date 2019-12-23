package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ToUpperTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new ToUpper(t);
		assertEquals("MAMA",t.transform_text("maMa"));
	}
	
	@Test
	public void mockTest() {
		TransformInterface mockObject = mock(ToLower.class);
		when(mockObject.transform_text("MaMA")).thenReturn("MAMA");
		assertEquals("ToUpper base test", "MAMA",mockObject.transform_text("MaMA"));
	}
	
	@Test
	public void mockCallTest() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("MaMA")).thenReturn("MaMA");
		TransformInterface t = new ToLower(mockObject);
		t.transform_text("MaMA");
		verify(mockObject).transform_text("MaMA");
	}

}
