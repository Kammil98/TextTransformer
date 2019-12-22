package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteRepetitionTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new DeleteRepetition(t);
		assertEquals("pa",t.transform_text("pa pa pa"));	
	}

}
