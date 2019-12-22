package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToUpperTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new ToUpper(t);
		assertEquals("MAMA",t.transform_text("maMa"));
	}

}
