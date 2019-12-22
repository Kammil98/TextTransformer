package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberToTextTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new NumberToText(t);
		assertEquals("dwadzieścia jeden motyli",t.transform_text("21 motyli"));
	}

}
