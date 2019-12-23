package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class DeleteRepetitionTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new DeleteRepetition(t);
		assertEquals("pa",t.transform_text("pa pa pa"));	
	}
	
	@Test
	public void mockTest() {
		TransformInterface mockObject = mock(DeleteRepetition.class);
		when(mockObject.transform_text("pa pa pa")).thenReturn("pa");
		assertEquals("DeleteRepetition base test", "pa",mockObject.transform_text("pa pa pa"));
	}
	
	@Test
	public void mockCallTest() {
		TransformInterface mockObject = mock(TextTransformerDecoratorHelper.class);
		when(mockObject.transform_text("pa pa pa")).thenReturn("pa pa pa");
		TransformInterface t = new DeleteRepetition(mockObject);
		t.transform_text("pa pa pa");
		verify(mockObject).transform_text("pa pa pa");
	}

}
