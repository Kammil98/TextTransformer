package pl.put.poznan.transformer.logic;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import pl.put.poznan.transformer.logic.Capitalize;
import pl.put.poznan.transformer.logic.TextTransformerDecoratorHelper;
import pl.put.poznan.transformer.logic.TransformInterface;

public class CapitalizeTest {
	
	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new Capitalize(t);
		assertEquals("Ola",t.transform_text("ola"));	
	}
	
	@Test
	public void mockTest() {
		TransformInterface mockObject = mock(Capitalize.class);
		when(mockObject.transform_text("ola")).thenReturn("Ola");
		assertEquals("Capitilize base test", "Ola",mockObject.transform_text("ola"));
	}
	
	@Test
	public void mockCallTest() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("ola")).thenReturn("ola");
		TransformInterface t = new Capitalize(mockObject);
		t.transform_text("ola");
		verify(mockObject).transform_text("ola");
	}

}
